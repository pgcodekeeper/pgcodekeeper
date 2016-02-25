package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * строит дерево сравнения из двух баз
 */
public class TreeDiffer implements IRunnableWithProgress {

    private final DbSource dbSource, dbTarget;

    private boolean finished;
    private TreeElement diffTree;

    public DbSource getDbSource() throws PgCodekeeperUIException {
        checkFinished();
        return dbSource;
    }

    public DbSource getDbTarget() throws PgCodekeeperUIException {
        checkFinished();
        return dbTarget;
    }

    public TreeElement getDiffTree() throws PgCodekeeperUIException {
        checkFinished();
        return diffTree;
    }

    public TreeDiffer(DbSource dbSource, DbSource dbTarget) {
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
    }

    private void checkFinished() throws PgCodekeeperUIException {
        if(!finished) {
            throw new PgCodekeeperUIException(Messages.runnable_has_not_finished);
        }
    }

    @Override
    public void run(IProgressMonitor monitor)
            throws InvocationTargetException, InterruptedException{
        SubMonitor pm = SubMonitor.convert(monitor,
                Messages.diffPresentationPane_getting_changes_for_diff, 100); // 0

        PgDatabase dbSrc, dbTgt;
        dbSrc = dbTgt = null;
        try {
            dbSrc = this.dbSource.get(pm.newChild(33)); // 33
            dbTgt = this.dbTarget.get(pm.newChild(33)); // 66
        } catch(IOException | LicenseException ex) {
            throw new InvocationTargetException(ex, ex.getLocalizedMessage());
        }

        Log.log(Log.LOG_INFO, "Generating diff tree between src: " + this.dbSource.getOrigin() //$NON-NLS-1$
        + " tgt: " + this.dbTarget.getOrigin()); //$NON-NLS-1$

        pm.newChild(34).subTask(Messages.treeDiffer_building_diff_tree); // 100
        diffTree = DiffTree.create(dbSrc, dbTgt);

        PgDumpLoader.checkCancelled(pm);
        pm.done();
        finished = true;
    }
}