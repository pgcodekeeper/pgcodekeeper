package ru.taximaxim.codekeeper.core.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;

import org.eclipse.core.runtime.SubMonitor;

import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.jdbc.CastsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.CollationsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ConstraintsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ExtensionsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ForeignDataWrappersReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.FtsConfigurationsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.FtsDictionariesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.FtsParsersReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.FtsTemplatesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.FunctionsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.IndicesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.OperatorsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.PoliciesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.RulesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.SchemasReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.SequencesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ServersReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.TablesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.TriggersReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.TypesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.UserMappingReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ViewsReader;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.log.Log;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class JdbcLoader extends JdbcLoaderBase {

    public JdbcLoader(JdbcConnector connector, PgDiffArguments pgDiffArguments) {
        this(connector, pgDiffArguments, SubMonitor.convert(null), null);
    }

    public JdbcLoader(JdbcConnector connector, PgDiffArguments pgDiffArguments,
            SubMonitor monitor, IgnoreSchemaList ignoreSchemaList) {
        super(connector, monitor, pgDiffArguments, ignoreSchemaList);
    }

    @Override
    public PgDatabase load() throws IOException, InterruptedException {
        PgDatabase d = new PgDatabase(args);

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
            queryCheckExtension();
            setupMonitorWork();
            new SchemasReader(this, d).read();

            // NOTE: order of readers has been changed to move the heaviest ANTLR tasks to the beginning
            // to give them a chance to finish while JDBC processes other non-ANTLR stuff
            new FunctionsReader(this).read();
            new ViewsReader(this).read();
            new TablesReader(this).read();
            new RulesReader(this).read();
            new PoliciesReader(this).read();
            new TriggersReader(this).read();
            new IndicesReader(this).read();
            // non-ANTLR tasks
            new ConstraintsReader(this).read();
            new TypesReader(this).read();
            new SequencesReader(this).read();
            new FtsParsersReader(this).read();
            new FtsTemplatesReader(this).read();
            new FtsDictionariesReader(this).read();
            new FtsConfigurationsReader(this).read();
            new OperatorsReader(this).read();

            new ExtensionsReader(this, d).read();
            new CastsReader(this, d).read();
            new ForeignDataWrappersReader(this, d).read();
            new ServersReader(this, d).read();
            try (ResultSet res = runner.runScript(statement, JdbcQueries.QUERY_CHECK_USER_PRIVILEGES)) {
                if (res.next() ? res.getBoolean("result") : false) {
                    new UserMappingReader(this, d).read();
                }
            }
            new CollationsReader(this).read();

            connection.commit();
            finishLoaders();

            d.sortColumns();

            d.setPostgresVersion(SupportedVersion.valueOf(version));
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
}
