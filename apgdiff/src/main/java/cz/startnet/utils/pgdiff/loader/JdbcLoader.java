package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.jdbc.ExtensionsReader;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcLoaderBase;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.SchemasContainer;
import cz.startnet.utils.pgdiff.loader.jdbc.SchemasReader;
import cz.startnet.utils.pgdiff.loader.jdbc.SequencesReader;
import cz.startnet.utils.pgdiff.loader.jdbc.TimestampsReader;
import cz.startnet.utils.pgdiff.loader.timestamps.DBTimestamp;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;

public class JdbcLoader extends JdbcLoaderBase {

    private boolean useServerHelpers = true;

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
        PgDatabase d = new PgDatabase(false);
        d.setArguments(args);

        Log.log(Log.LOG_INFO, "Reading db using JDBC.");
        setCurrentOperation("connection setup");
        try (Connection connection = connector.getConnection();
                Statement statement = connection.createStatement()) {
            this.connection = connection;
            this.statement = statement;
            connection.setAutoCommit(false);
            statement.execute("SET TRANSACTION ISOLATION LEVEL REPEATABLE READ, READ ONLY");
            statement.execute("SET timezone = " + PgDiffUtils.quoteString(connector.getTimezone()));

            queryCheckVersion();
            queryTypesForCache();
            queryRoles();
            setupMonitorWork();

            if (getExtensionSchema() != null) {
                DBTimestamp dbTime = new TimestampsReader(this).read();
                finishAntlr();
                d.setDbTimestamp(dbTime);
                timestampParams.fillObjects(dbTime);
                useServerHelpers = false; // not supported in this version
            }

            schemas = new SchemasReader(this, d).read();
            try (SchemasContainer schemas = this.schemas) {
                availableHelpersBits = useServerHelpers ? JdbcReaderFactory.getAvailableHelpersBits(this) : 0;
                for (JdbcReaderFactory f : JdbcReaderFactory.FACTORIES) {
                    f.getReader(this).read();
                }
                new ExtensionsReader(this, d).read();

                if(!SupportedVersion.VERSION_10.checkVersion(version)) {
                    SequencesReader.querySequencesData(d, this);
                }
            }
            connection.commit();
            finishAntlr();

            d.sortColumns();

            FullAnalyze.goThroughGraphForAnalyze(d);

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

    public void setUseServerHelpers(boolean useServerHelpers) {
        this.useServerHelpers = useServerHelpers;
    }

    public boolean hasAllHelpers() throws IOException {
        // just makes new connection for now
        // smarter solution would be to make the class AutoCloseable
        try (Connection c = connector.getConnection()) {
            return JdbcReaderFactory.getAvailableHelperBits(c) == JdbcReaderFactory.getAllHelperBits();
        } catch (SQLException ex) {
            throw new IOException(ex.getLocalizedMessage(), ex);
        }
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
     * @return extension schema or null, if not found
     */
    public static String getExtensionSchema(String host, int port, String user, String pass, String dbname, String timezone) {
        JdbcConnector connector = new JdbcConnector(host, port, user, pass, dbname, timezone);
        String schema = null;
        try (Connection connection = connector.getConnection();
                Statement statement = connection.createStatement();
                ResultSet res = statement.executeQuery(JdbcQueries.QUERY_CHECK_TIMESTAMPS)) {
            while (res.next()) {
                schema = res.getString("nspname");
            }
        } catch (SQLException | IOException ex) {
            Log.log(Log.LOG_ERROR, "Error loading DB schema", ex);
        }
        return schema;
    }

}
