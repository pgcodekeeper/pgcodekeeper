package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * строит дерево сравнения из двух баз
 */
public class TimestampTreeDiffer extends TreeDiffer {

    public TimestampTreeDiffer(DbSource dbSource, DbSource dbTarget, boolean needTwoWay) {
        super(dbSource, dbTarget, needTwoWay);
    }

    @Override
    public void run(IProgressMonitor monitor)
            throws InvocationTargetException, InterruptedException {
        SubMonitor pm = SubMonitor.convert(monitor,
                Messages.diffPresentationPane_getting_changes_for_diff, 100); // 0

        if (dbSource instanceof DbSourceProject && dbTarget instanceof DbSourceJdbc) {
            loadSequentially((DbSourceProject) dbSource, (DbSourceJdbc) dbTarget, pm);
        }

        Log.log(Log.LOG_INFO, "Generating diff tree between src: " + dbSource.getOrigin() //$NON-NLS-1$
        + " tgt: " + dbTarget.getOrigin()); //$NON-NLS-1$

        pm.newChild(15).subTask(Messages.treeDiffer_building_diff_tree); // 95
        diffTree = DiffTree.create(dbSource.getDbObject(), dbTarget.getDbObject(), pm);

        if (needTwoWay) {
            Log.log(Log.LOG_INFO, "Generating diff tree between src: " + dbTarget.getOrigin() //$NON-NLS-1$
            + " tgt: " + dbSource.getOrigin()); //$NON-NLS-1$

            pm.newChild(3).subTask(Messages.TreeDiffer_reverting_tree); // 98
            diffTreeRevert = diffTree.getRevertedCopy();
        }

        PgDiffUtils.checkCancelled(pm);
        monitor.done();
    }

    private void loadSequentially(DbSourceProject dbSource, DbSourceJdbc dbTarget,
            SubMonitor monitor) throws InterruptedException {
        try {
            PgDatabase db = dbSource.get(monitor);
            dbTarget.setProjectDb(db);
            dbTarget.get(monitor);
        } catch (IOException | LicenseException | CoreException ex) {
            Log.log(Log.LOG_ERROR, Messages.TreeDiffer_schema_load_error, ex);
        }
    }
}
