package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcLoader;
import cz.startnet.utils.pgdiff.loader.timestamps.DBTimestampPair;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * строит дерево сравнения из двух баз с учетом времени модификации объектов
 */
public class TimestampTreeDiffer extends TreeDiffer {

    private final String schema;

    public TimestampTreeDiffer(DbSource dbSource, DbSource dbTarget,
            String schema) {
        super(dbSource, dbTarget, false);
        this.schema = schema;
    }

    @Override
    public void run(IProgressMonitor monitor) throws InterruptedException {
        SubMonitor pm = SubMonitor.convert(monitor,
                Messages.diffPresentationPane_getting_changes_for_diff, 100); // 0

        JdbcConnector connector = ((DbSourceJdbc) dbTarget).getJdbcConnector();
        try (Connection connection = connector.getConnection();
                Statement statement = connection.createStatement()) {
            PgDatabase dbSrc = dbSource.get(pm);

            Path path = FileUtilsUi.getPathToTimeObject(dbSource.getOrigin());
            JdbcLoader loader = new JdbcLoader(connector, ((DbSourceJdbc)dbTarget).getArgs(), pm);
            loader.setTimeParams(dbSrc, path, schema);
            PgDatabase dbTgt = loader.getDbFromJdbc();
            dbTarget.set(dbTgt);

            Log.log(Log.LOG_INFO, "Generating diff tree between src: " + dbSource.getOrigin() //$NON-NLS-1$
            + " tgt: " + dbTarget.getOrigin()); //$NON-NLS-1$

            DBTimestampPair pair = loader.getDbPair();
            pair.clearProject();

            pm.newChild(15).subTask(Messages.treeDiffer_building_diff_tree); // 95
            diffTree = DiffTree.create(dbSrc, dbTgt, pm, pair);

            pair.serializeProject(path);

            PgDiffUtils.checkCancelled(pm);
            monitor.done();

        } catch (SQLException | CoreException | IOException | URISyntaxException ex) {
            Log.log(Log.LOG_ERROR, Messages.TreeDiffer_schema_load_error, ex);
        }
    }
}
