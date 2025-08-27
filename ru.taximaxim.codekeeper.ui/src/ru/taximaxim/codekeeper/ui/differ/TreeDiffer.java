/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.stream.Stream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ProgressMonitorWrapper;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.pgcodekeeper.core.model.difftree.DiffTree;
import org.pgcodekeeper.core.model.difftree.TreeElement;
import org.pgcodekeeper.core.monitor.IMonitor;
import org.pgcodekeeper.core.settings.ISettings;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.utils.UIMonitor;

/**
 * строит дерево сравнения из двух баз
 */
public class TreeDiffer implements IRunnableWithProgress {

    private static final int JOB_CHECK_MS = 20;

    private final DbSource oldDb;
    private final DbSource newDb;
    private final ISettings settings;

    private TreeElement diffTree;

    public TreeDiffer(ISettings settings, DbSource oldDb, DbSource newDb) {
        this.settings = settings;
        this.oldDb = oldDb;
        this.newDb = newDb;
    }

    public Stream<Object> getErrors() {
        return Stream.of(oldDb, newDb)
                .flatMap(s -> s == null ? Stream.empty() : s.getErrors().stream());
    }

    public DbSource getOldDb() {
        return oldDb;
    }

    public DbSource getNewDb() {
        return newDb;
    }

    public TreeElement getDiffTree() {
        if (diffTree == null) {
            throw new IllegalStateException(Messages.runnable_has_not_finished);
        }
        return diffTree;
    }

    @Override
    public void run(IProgressMonitor monitor)
            throws InvocationTargetException, InterruptedException {
        SubMonitor pm = SubMonitor.convert(monitor,
                Messages.diffPresentationPane_getting_changes_for_diff, 100); // 0

        SubMonitor jobMonitor = pm.newChild(80); // 80
        DbSourceJob oldDbJob = new DbSourceJob(oldDb, jobMonitor);
        DbSourceJob newDbJob = new DbSourceJob(newDb, jobMonitor);
        oldDbJob.schedule();
        newDbJob.schedule();
        IStatus srcResult;
        IStatus tgtResult;
        do {
            Thread.sleep(JOB_CHECK_MS);
            srcResult = oldDbJob.getResult();
            tgtResult = newDbJob.getResult();
        } while (srcResult == null && tgtResult == null);
        if (srcResult != null) {
            finishJobs(oldDbJob, newDbJob);
        } else {
            finishJobs(newDbJob, oldDbJob);
        }

        Log.log(Log.LOG_INFO, "Generating diff tree between oldDb: " + oldDb.getOrigin() //$NON-NLS-1$
        + " newDb: " + newDb.getOrigin()); //$NON-NLS-1$

        pm.newChild(15).subTask(Messages.treeDiffer_building_diff_tree); // 95
        var uiMon = new UIMonitor(pm);
        diffTree = DiffTree.create(settings, oldDb.getDbObject(), newDb.getDbObject(), uiMon);
        IMonitor.checkCancelled(uiMon);
        monitor.done();
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
            int exitSeverity = exitResult.getSeverity();
            int otherSeverity = otherResult.getSeverity();
            if ((exitSeverity == IStatus.CANCEL || exitSeverity == IStatus.OK)
                    && (otherSeverity == IStatus.CANCEL || otherSeverity == IStatus.OK)) {
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
            super(Messages.TreeDiffer_loading_schema_from.formatted(s.getOrigin()));
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
            } catch (IOException | CoreException ex) {
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