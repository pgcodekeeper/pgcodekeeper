package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.jdbc.ExtensionsReader;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcLoaderBase;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.SchemasContainer;
import cz.startnet.utils.pgdiff.loader.jdbc.SchemasReader;
import cz.startnet.utils.pgdiff.loader.jdbc.SequencesReader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
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

    public void setUseServerHelpers(boolean useServerHelpers) {
        this.useServerHelpers = useServerHelpers;
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
            try (SchemasContainer schemas = this.schemas) {
                availableHelpersBits = useServerHelpers ? JdbcReaderFactory.getAvailableHelpersBits(this) : 0;
                for (JdbcReaderFactory f : JdbcReaderFactory.FACTORIES) {
                    f.getReader(this).read();
                }
                new ExtensionsReader(this, d).read();

                SequencesReader.querySequencesData(d, this);
            }
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

    public boolean hasAllHelpers() throws IOException {
        // just makes new connection for now
        // smarter solution would be to make the class AutoCloseable
        try (Connection c = connector.getConnection()) {
            return JdbcReaderFactory.getAvailableHelperBits(c) == JdbcReaderFactory.getAllHelperBits();
        } catch (SQLException ex) {
            throw new IOException(ex.getLocalizedMessage(), ex);
        }
    }
}
