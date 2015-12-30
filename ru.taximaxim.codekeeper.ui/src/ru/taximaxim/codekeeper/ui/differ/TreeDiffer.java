package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;

import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
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
    private PgDatabase dbSrc, dbTgt;

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
        dbSrc = dbTgt = null;
        Job dbSourceJob = new getDataFromdbSourceJob("",pm);
        Job dbTargetJob = new getDataFromdbTargetJob("",pm);
        dbSourceJob.schedule();
        dbTargetJob.schedule();
        dbSourceJob.join();
        dbTargetJob.join();
        if (!dbSourceJob.getResult().equals(Status.OK_STATUS)
                || !dbTargetJob.getResult().equals(Status.OK_STATUS))
        {
            finished = true;
            return;
        }

        Log.log(Log.LOG_INFO, "Generating diff tree between src: " + this.dbSource.getOrigin() //$NON-NLS-1$
        + " tgt: " + this.dbTarget.getOrigin()); //$NON-NLS-1$

        pm.newChild(12).subTask(Messages.treeDiffer_building_diff_tree); // 100
        diffTree = DiffTree.create(dbSrc, dbTgt);

        PgDumpLoader.checkCancelled(pm);
        pm.done();
        finished = true;
    }

    private class getDataFromdbSourceJob extends Job{
        private SubMonitor subMonitor;
        public getDataFromdbSourceJob(String name, SubMonitor sm) {
            super(name);
            subMonitor = sm;
        }
        @Override
        protected IStatus run(IProgressMonitor monitor) {
            try {
                dbSrc = dbSource.get(subMonitor.newChild(44));
            } catch (IOException | InterruptedException e) {
                Log.log(Log.LOG_ERROR, "Unable to retrive data from " + dbSource.getDbObject().getName() + "\n"
                        + e.getLocalizedMessage());
                return Status.CANCEL_STATUS;
            }
            return Status.OK_STATUS;
        }
    }

    private class getDataFromdbTargetJob extends Job{
        private SubMonitor subMonitor;
        public getDataFromdbTargetJob(String name, SubMonitor sm) {
            super(name);
            subMonitor = sm;
        }
        @Override
        protected IStatus run(IProgressMonitor monitor) {
            try {
                dbTgt = dbTarget.get(subMonitor.newChild(44));
            } catch (IOException | InterruptedException e) {
                Log.log(Log.LOG_ERROR, "Unable to retrive data from " + dbTarget.getDbObject().getName() + "\n"
                        + e.getLocalizedMessage());
                e.printStackTrace();
                return Status.CANCEL_STATUS;
            }
            return Status.OK_STATUS;
        }
    }
}
