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
 * строит дерево сравнения из двух баз с учетом времени модификации объектов
 */
public class TimestampTreeDiffer extends TreeDiffer {

    public TimestampTreeDiffer(DbSource dbSource, DbSource dbTarget) {
        super(dbSource, dbTarget, false);
    }

    @Override
    public void run(IProgressMonitor monitor)
            throws InvocationTargetException, InterruptedException {
        SubMonitor pm = SubMonitor.convert(monitor,
                Messages.diffPresentationPane_getting_changes_for_diff, 100); // 0
        try {
            PgDatabase dbSrc = dbSource.get(pm);
            PgDatabase dbTgt = dbTarget.get(pm);
            Log.log(Log.LOG_INFO, "Generating diff tree between src: " + dbSource.getOrigin() //$NON-NLS-1$
            + " tgt: " + dbTarget.getOrigin()); //$NON-NLS-1$

            pm.newChild(15).subTask(Messages.treeDiffer_building_diff_tree); // 95
            diffTree = DiffTree.create(dbSrc, dbTgt, pm);

            PgDiffUtils.checkCancelled(pm);
            monitor.done();

        }  catch (IOException | LicenseException | CoreException ex) {
            Log.log(Log.LOG_ERROR, Messages.TreeDiffer_schema_load_error, ex);
        }
    }
}
