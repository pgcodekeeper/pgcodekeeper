package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class InitProjectFromSource implements IRunnableWithProgress {

    private final DbSource src;
    private final PgDbProject proj;

    public InitProjectFromSource(PgDbProject proj, DbSource src) {
        this.proj = proj;
        this.src = src;
    }

    @Override
    public void run(IProgressMonitor monitor)
            throws InvocationTargetException, InterruptedException {
        try {
            Log.log(Log.LOG_INFO, "Init project at " + proj.getPathToProject()); //$NON-NLS-1$

            SubMonitor pm = SubMonitor.convert(monitor,
                    Messages.initProjectFromSource_initializing_project, 75);

            initRepoFromSource(pm);

            monitor.done();
        } catch (IOException | CoreException | LicenseException ex) {
            throw new InvocationTargetException(ex, MessageFormat.format(
                    Messages.initProjectFromSource_ioexception_while_creating_project,
                    ex.getLocalizedMessage()));
        }
    }

    /**
     * clean repository, generate new file structure, preserve and fix repo
     * metadata, repo rm/add, commit new revision
     */
    private void initRepoFromSource(SubMonitor pm) throws InterruptedException,
    CoreException, IOException, LicenseException {
        SubMonitor taskpm = pm.newChild(25); // 50

        PgDatabase db = src.get(taskpm);
        pm.newChild(25).subTask(Messages.initProjectFromSource_exporting_db_model); // 75
        new ProjectUpdater(db, null, null, proj).updateFull();
    }
}
