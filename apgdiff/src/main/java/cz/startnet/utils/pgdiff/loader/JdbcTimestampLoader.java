package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Statement;
import java.text.MessageFormat;
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
import cz.startnet.utils.pgdiff.loader.timestamps.DBTimestampPair;
import cz.startnet.utils.pgdiff.loader.timestamps.ObjectTimestamp;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;

public class JdbcTimestampLoader extends JdbcLoaderBase {

    private List<ObjectTimestamp> objects;
    private PgDatabase projDB;
    private DBTimestampPair pair;
    private String schema;

    public JdbcTimestampLoader(JdbcConnector connector, PgDiffArguments pgDiffArguments,
            SubMonitor monitor) {
        super(connector, monitor, pgDiffArguments);
    }

    public String getSchema() {
        return schema;
    }

    public List<ObjectTimestamp> getObjects() {
        return objects;
    }

    public PgDatabase getProjDb() {
        return projDB;
    }

    public DBTimestampPair getDbPair() {
        return pair;
    }

    public PgDatabase getDbFromJdbc(PgDatabase projDB, Path path, String schema)
            throws IOException, InterruptedException {
        PgDatabase d = new PgDatabase(false);
        d.setArguments(args);
        this.projDB = projDB;
        this.schema = schema;

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

            DBTimestamp projTime = DBTimestamp.getDBTimestamp(path);
            DBTimestamp dbTime = new TimestampsReader(this).read();
            finishAntlr();
            pair = new DBTimestampPair(projTime, dbTime);
            objects = pair.searchMatch();

            schemas = new SchemasReader(this, d).read();
            try (SchemasContainer schemas = this.schemas) {
                availableHelpersBits = 0;
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
