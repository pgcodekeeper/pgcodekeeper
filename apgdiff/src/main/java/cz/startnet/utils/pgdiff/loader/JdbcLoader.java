package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.text.MessageFormat;

import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.jdbc.ExtensionsReader;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcLoaderBase;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.SchemasReader;
import cz.startnet.utils.pgdiff.loader.jdbc.SequencesReader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;

public class JdbcLoader extends JdbcLoaderBase {

    public JdbcLoader(JdbcConnector connector, PgDiffArguments pgDiffArguments) {
        this(connector, pgDiffArguments, SubMonitor.convert(null));
    }

    public JdbcLoader(JdbcConnector connector, PgDiffArguments pgDiffArguments,
            SubMonitor monitor) {
        super(connector, monitor, pgDiffArguments);
    }

    public PgDatabase getDbFromJdbc() throws IOException, InterruptedException, LicenseException {
        PgDatabase d = new PgDatabase();
        d.setArguments(args);

        Log.log(Log.LOG_INFO, "Reading db using JDBC.");
        setCurrentOperation("connection setup");
        try (Connection connection = connector.getConnection();
                Statement statement = connection.createStatement()) {
            this.connection = connection;
            this.statement = statement;
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setReadOnly(true);
            statement.execute("SET timezone = " + PgDiffUtils.quoteString(connector.getTimezone()));

            queryTypesForCache();
            queryRoles();
            setupMonitorWork();

            schemas = new SchemasReader(this, d).read();
            availableHelpersBits = JdbcReaderFactory.getAvailableHelpersBits(this);
            for (JdbcReaderFactory f : JdbcReaderFactory.FACTORIES) {
                f.getReader(this).read();
            }
            new ExtensionsReader(this, d).read();

            SequencesReader.querySequencesData(d, this);

            connection.commit();
            Log.log(Log.LOG_INFO, "Database object has been successfully queried from JDBC");
        } catch (Exception e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (Exception ex) {
                e.addSuppressed(ex);
                Log.log(Log.LOG_ERROR, "Cannot rollback JdbcLoader transaction", ex);
            }
            if (e instanceof InterruptedException) {
                throw (InterruptedException) e;
            }
            throw new IOException(MessageFormat.format(
                    Messages.Connection_DatabaseJdbcAccessError,
                    e.getLocalizedMessage(), getCurrentLocation()), e);
        }
        args.getLicense().verifyDb(d);
        return d;
    }
}
