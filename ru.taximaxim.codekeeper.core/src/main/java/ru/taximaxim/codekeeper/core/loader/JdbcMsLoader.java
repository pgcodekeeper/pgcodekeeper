package ru.taximaxim.codekeeper.core.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.text.MessageFormat;

import org.eclipse.core.runtime.SubMonitor;

import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.MsAssembliesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.MsCheckConstraintsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.MsExtendedObjectsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.MsFKReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.MsFPVTReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.MsIndicesAndPKReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.MsRolesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.MsSequencesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.MsTablesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.MsTypesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.MsUsersReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.SchemasMsReader;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.log.Log;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class JdbcMsLoader extends JdbcLoaderBase {

    public JdbcMsLoader(JdbcConnector connector, PgDiffArguments args) {
        this(connector, args, SubMonitor.convert(null), null);
    }

    public JdbcMsLoader(JdbcConnector connector, PgDiffArguments args,
            SubMonitor monitor, IgnoreSchemaList ignoreSchemaList) {
        super(connector, monitor, args, ignoreSchemaList);
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
            // TODO maybe not needed and/or may cause extra locking (compared to PG)
            // may need to be removed, Source Control seems to work in default READ COMMITTED state
            runner.run(statement, "SET TRANSACTION ISOLATION LEVEL REPEATABLE READ");

            // TODO add role cache if needed to process permissions, or remove this
            //queryRoles();
            // TODO add counting objects later
            //setupMonitorWork();

            new SchemasMsReader(this, d).read();
            new MsFPVTReader(this).read();
            new MsExtendedObjectsReader(this).read();
            new MsTablesReader(this).read();
            new MsSequencesReader(this).read();
            new MsIndicesAndPKReader(this).read();
            new MsFKReader(this).read();
            new MsCheckConstraintsReader(this).read();
            new MsTypesReader(this).read();
            new MsAssembliesReader(this, d).read();
            new MsRolesReader(this, d).read();
            new MsUsersReader(this, d).read();

            finishLoaders();

            connection.commit();

            Log.log(Log.LOG_INFO, "Database object has been successfully queried from JDBC");
        } catch (InterruptedException ex) {
            throw ex;
        } catch (Exception e) {
            // connection is closed at this point
            throw new IOException(MessageFormat.format(Messages.Connection_DatabaseJdbcAccessError,
                    e.getLocalizedMessage(), getCurrentLocation()), e);
        }
        return d;
    }
}
