package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.text.MessageFormat;

import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcLoaderBase;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.SchemasMsReader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;

public class JdbcMsLoader extends JdbcLoaderBase {

    public JdbcMsLoader(JdbcConnector connector, PgDiffArguments args) {
        this(connector, args, SubMonitor.convert(null));
    }

    public JdbcMsLoader(JdbcConnector connector, PgDiffArguments args,
            SubMonitor monitor) {
        super(connector, monitor, args);
    }

    public PgDatabase readDb() throws IOException, InterruptedException {
        PgDatabase d = new PgDatabase();
        d.setArguments(args);

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
            // TODO the way to manage TZ reads in MS is unclear for now
            //runner.run(statement, "SET timezone = " + PgDiffUtils.quoteString(connector.getTimezone()));

            // TODO add role cache if needed to process permissions, or remove this
            //queryRoles();
            // TODO add counting objects later
            //setupMonitorWork();

            new SchemasMsReader(this, d).read();

            for (JdbcReaderFactory f : JdbcReaderFactory.MS_FACTORIES) {
                f.getReader(this).read();
            }

            connection.commit();
            finishAntlr();

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
