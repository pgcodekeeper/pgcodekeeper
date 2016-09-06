package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ProgressMonitorWrapper;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;

import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * строит дерево сравнения из двух баз
 */
public class TreeDiffer implements IRunnableWithProgress {

    private static final int JOB_CHECK_MS = 20;

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
            throws InvocationTargetException, InterruptedException {
        SubMonitor pm = SubMonitor.convert(monitor,
                Messages.diffPresentationPane_getting_changes_for_diff, 100); // 0

        SubMonitor jobMonitor = pm.newChild(80); // 80
        DbSourceJob srcJob = new DbSourceJob(dbSource, jobMonitor);
        DbSourceJob tgtJob = new DbSourceJob(dbTarget, jobMonitor);
        srcJob.schedule();
        tgtJob.schedule();
        IStatus srcResult, tgtResult;
        do {
            Thread.sleep(JOB_CHECK_MS);
            srcResult = srcJob.getResult();
            tgtResult = tgtJob.getResult();
        } while (srcResult == null && tgtResult == null);
        if (srcResult != null) {
            finishJobs(srcJob, tgtJob);
        } else {
            finishJobs(tgtJob, srcJob);
        }

        Log.log(Log.LOG_INFO, "Generating diff tree between src: " + dbSource.getOrigin() //$NON-NLS-1$
        + " tgt: " + dbTarget.getOrigin()); //$NON-NLS-1$

        pm.newChild(20).subTask(Messages.treeDiffer_building_diff_tree); // 100
        diffTree = DiffTree.create(dbSource.getDbObject(), dbTarget.getDbObject());

        PgDumpLoader.checkCancelled(pm);
        monitor.done();
        finished = true;
    }

    private void finishJobs(DbSourceJob exitedJob, DbSourceJob otherJob)
            throws InvocationTargetException, InterruptedException {
        IStatus exitResult = exitedJob.getResult();
        if (!exitResult.isOK()) {
            otherJob.cancel();
        }
        exitedJob.join();
        otherJob.join();

        IStatus otherResult = otherJob.getResult();
        if (!exitResult.isOK() || !otherResult.isOK()) {
            if (exitResult.getSeverity() == IStatus.CANCEL &&
                    otherResult.getSeverity() == IStatus.CANCEL) {
                throw new InterruptedException();
            }
            Throwable t = otherResult.getException();
            Throwable exitEx = exitResult.getException();
            if (exitEx != null) {
                if (t != null) {
                    t.addSuppressed(exitEx);
                } else {
                    t = exitEx;
                }
            }
            if (t == null) {
                t = new IOException(Messages.TreeDiffer_unknown_error);
            }
            throw new InvocationTargetException(t, t.getLocalizedMessage());
        }
    }

    private static class DbSourceJob extends Job {

        private final DbSource s;
        private final SubMonitor m;

        public DbSourceJob(DbSource s, SubMonitor m) {
            super(MessageFormat.format(Messages.TreeDiffer_loading_schema_from, s.getOrigin()));
            this.s = s;
            this.m = m;
        }

        @Override
        protected IStatus run(IProgressMonitor monitor) {
            MultiProgressMonitor mpm = new MultiProgressMonitor(monitor, m);
            try {
                s.get(SubMonitor.convert(mpm, Messages.TreeDiffer_loading_schema, 1));
            } catch (InterruptedException ex) {
                return Status.CANCEL_STATUS;
            } catch (IOException | LicenseException | CoreException ex) {
                return new Status(IStatus.ERROR, PLUGIN_ID.THIS, Messages.TreeDiffer_schema_load_error, ex);
            } finally {
                mpm.done();
            }
            return Status.OK_STATUS;
        }
    }

    private static class MultiProgressMonitor extends ProgressMonitorWrapper {

        private static final int DEFAULT_SCALE = 500;

        private final SubMonitor secondaryMonitor;
        private final int secondaryWorkScale;

        public MultiProgressMonitor(IProgressMonitor wrappedMonitor,
                SubMonitor secondaryMonitor) {
            this(wrappedMonitor, secondaryMonitor, DEFAULT_SCALE);
        }

        public MultiProgressMonitor(IProgressMonitor wrappedMonitor,
                SubMonitor secondaryMonitor, int secondaryWorkScale) {
            super(wrappedMonitor);
            this.secondaryMonitor = secondaryMonitor;
            this.secondaryWorkScale = secondaryWorkScale;
        }

        @Override
        public void worked(int work) {
            super.internalWorked(work);
            reportWork();
        }

        @Override
        public void internalWorked(double work) {
            super.internalWorked(work);
            reportWork();
        }

        private void reportWork() {
            secondaryMonitor.setWorkRemaining(secondaryWorkScale);
            secondaryMonitor.worked(1);
        }

        @Override
        public boolean isCanceled() {
            return super.isCanceled() || secondaryMonitor.isCanceled();
        }

        @Override
        public void setCanceled(boolean b) {
            super.setCanceled(b);
            secondaryMonitor.setCanceled(b);
        }
    }
}
