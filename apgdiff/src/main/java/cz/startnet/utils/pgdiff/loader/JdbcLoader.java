package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.jdbc.ConstraintsReader;
import cz.startnet.utils.pgdiff.loader.jdbc.ExtensionsReader;
import cz.startnet.utils.pgdiff.loader.jdbc.FtsConfigurationsReader;
import cz.startnet.utils.pgdiff.loader.jdbc.FtsDictionariesReader;
import cz.startnet.utils.pgdiff.loader.jdbc.FtsParsersReader;
import cz.startnet.utils.pgdiff.loader.jdbc.FtsTemplatesReader;
import cz.startnet.utils.pgdiff.loader.jdbc.FunctionsReader;
import cz.startnet.utils.pgdiff.loader.jdbc.IndicesReader;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcLoaderBase;
import cz.startnet.utils.pgdiff.loader.jdbc.RulesReader;
import cz.startnet.utils.pgdiff.loader.jdbc.SchemasContainer;
import cz.startnet.utils.pgdiff.loader.jdbc.SchemasReader;
import cz.startnet.utils.pgdiff.loader.jdbc.SequencesReader;
import cz.startnet.utils.pgdiff.loader.jdbc.TablesReader;
import cz.startnet.utils.pgdiff.loader.jdbc.TimestampsReader;
import cz.startnet.utils.pgdiff.loader.jdbc.TriggersReader;
import cz.startnet.utils.pgdiff.loader.jdbc.TypesReader;
import cz.startnet.utils.pgdiff.loader.jdbc.ViewsReader;
import cz.startnet.utils.pgdiff.loader.timestamps.DBTimestamp;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;

public class JdbcLoader extends JdbcLoaderBase {

    public JdbcLoader(JdbcConnector connector, PgDiffArguments pgDiffArguments) {
        this(connector, pgDiffArguments, SubMonitor.convert(null));
    }

    public JdbcLoader(JdbcConnector connector, PgDiffArguments pgDiffArguments,
            SubMonitor monitor) {
        super(connector, monitor, pgDiffArguments);
    }

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    public void setTimestampParams(PgDatabase projDB, String extensionSchema) {
        timestampParams.setTimeParams(projDB, extensionSchema);
    }

    public PgDatabase getDbFromJdbc() throws IOException, InterruptedException {
        PgDatabase d = new PgDatabase();
        d.setArguments(args);

        Log.log(Log.LOG_INFO, "Reading db using JDBC.");
        setCurrentOperation("connection setup");
        try (Connection connection = connector.getConnection();
                Statement statement = connection.createStatement()) {
            this.connection = connection;
            this.statement = statement;
            connection.setAutoCommit(false);
            runner.run(statement, "SET TRANSACTION ISOLATION LEVEL REPEATABLE READ, READ ONLY");
            runner.run(statement, "SET search_path TO pg_catalog;");
            runner.run(statement, "SET timezone = " + PgDiffUtils.quoteString(connector.getTimezone()));

            queryCheckVersion();
            queryCheckLastSysOid();
            queryTypesForCache();
            queryRoles();
            setupMonitorWork();

            if (getExtensionSchema() != null) {
                DBTimestamp dbTime = new TimestampsReader(this).read();
                finishAntlr();
                d.setDbTimestamp(dbTime);
                timestampParams.fillEqualObjects(dbTime);
            }

            schemas = new SchemasReader(this, d).read();
            try (SchemasContainer schemas = this.schemas) {
                // NOTE: order of readers has been changed to move the heaviest ANTLR tasks to the beginning
                // to give them a chance to finish while JDBC processes other non-ANTLR stuff
                new ViewsReader(this).read();
                new TablesReader(this).read();
                new RulesReader(this).read();
                new TriggersReader(this).read();
                new IndicesReader(this).read();
                new FunctionsReader(this).read();
                // non-ANTLR tasks
                new ConstraintsReader(this).read();
                new TypesReader(this).read();
                new SequencesReader(this).read();
                new FtsParsersReader(this).read();
                new FtsTemplatesReader(this).read();
                new FtsDictionariesReader(this).read();
                new FtsConfigurationsReader(this).read();

                new ExtensionsReader(this, d).read();

                if(!SupportedVersion.VERSION_10.checkVersion(version)) {
                    SequencesReader.querySequencesData(d, this);
                }
            }
            connection.commit();
            finishAntlr();

            d.sortColumns();

            d.setPostgresVersion(SupportedVersion.valueOf(version));

            FullAnalyze.fullAnalyze(d);

            Log.log(Log.LOG_INFO, "Database object has been successfully queried from JDBC");
        } catch (InterruptedException ex) {
            throw ex;
        } catch (Exception e) {
            // connection is closed at this point, trust Postgres to rollback it; we're a read-only xact anyway
            throw new IOException(MessageFormat.format(Messages.Connection_DatabaseJdbcAccessError,
                    e.getLocalizedMessage(), getCurrentLocation()), e);
        }
        return d;
    }

    /**
     * Checks pg_dbo_timestamp extension in database and returns its location
     *
     * @param host - db host
     * @param port - db port
     * @param user - db user
     * @param pass - db pass
     * @param dbname - db name
     * @param timezone - db timezone
     * @param properties - additional connection properties
     * @param readOnly - value for enable or disable 'read-only mode' of connection
     * @return extension schema or null, if not found
     * @throws PgCodekeeperException - if extension has wrong params
     */
    public static String getExtensionSchema(String host, int port, String user,
            String pass, String dbname, Map<String, String> properties,
            boolean readOnly, String timezone) throws PgCodekeeperException {
        JdbcConnector connector = new JdbcConnector(host, port, user, pass, dbname,
                properties, readOnly, timezone);
        try (Connection connection = connector.getConnection();
                Statement statement = connection.createStatement();
                ResultSet res = statement.executeQuery(JdbcQueries.QUERY_CHECK_TIMESTAMPS)) {
            while (res.next()) {
                String version = res.getString("extversion");
                if (!version.equals(ApgdiffConsts.EXTENSION_VERSION)) {
                    throw new PgCodekeeperException("pg_dbo_timestamp: old version of extension is used: " +
                            version + ", current version: " + ApgdiffConsts.EXTENSION_VERSION);
                } else if (res.getBoolean("disabled")) {
                    throw new PgCodekeeperException("pg_dbo_timestamp: event trigger is disabled");
                } else {
                    return res.getString("nspname");
                }
            }
        } catch (SQLException | IOException ex) {
            throw new PgCodekeeperException("Error when checking for pg_dbo_timestamp: "
                    + ex.getLocalizedMessage(), ex);
        }
        return null;
    }
}