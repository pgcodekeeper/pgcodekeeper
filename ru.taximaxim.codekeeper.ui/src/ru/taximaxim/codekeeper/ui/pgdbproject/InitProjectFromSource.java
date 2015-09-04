package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.DBSources;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class InitProjectFromSource implements IRunnableWithProgress {

    private final String exePgdump;
    private final String pgdumpCustom;
    private final String password;

    private final PgDbProject proj;

    private final String dumpPath;

    public InitProjectFromSource(IPreferenceStore mainPrefs, PgDbProject proj,
            String dumpPath, String password) {
        this.exePgdump = mainPrefs.getString(PREF.PGDUMP_EXE_PATH);
        this.pgdumpCustom = mainPrefs.getString(PREF.PGDUMP_CUSTOM_PARAMS);
        this.proj = proj;
        this.dumpPath = dumpPath;
        this.password = password;
    }

    @Override
    public void run(IProgressMonitor monitor)
            throws InvocationTargetException, InterruptedException {
        try {
            Log.log(Log.LOG_INFO, "Init project at " + proj.getPathToProject()); //$NON-NLS-1$

            SubMonitor pm = SubMonitor.convert(monitor,
                    Messages.initProjectFromSource_initializing_project, 75);

            initRepoFromSource(pm);

            pm.done();
        } catch (IOException | CoreException ex) {
            throw new InvocationTargetException(ex, MessageFormat.format(
                    Messages.initProjectFromSource_ioexception_while_creating_project,
                    ex.getLocalizedMessage()));
        }
    }

    /**
     * clean repository, generate new file structure, preserve and fix repo
     * metadata, repo rm/add, commit new revision
     * @throws CoreException
     * @throws InterruptedException
     */
    private void initRepoFromSource(SubMonitor pm)
            throws IOException, InvocationTargetException, CoreException, InterruptedException {
        SubMonitor taskpm = pm.newChild(25); // 50

        PgDatabase db;
        switch (DBSources.getEnum(proj.getPrefs().get(PROJ_PREF.SOURCE, ""))) { //$NON-NLS-1$
        case SOURCE_TYPE_DB:
            db = DbSource.fromDb(exePgdump, pgdumpCustom, proj, password).get(taskpm);
            break;

        case SOURCE_TYPE_DUMP:
            db = DbSource.fromFile(proj.getPrefs().getBoolean(PROJ_PREF.FORCE_UNIX_NEWLINES, true),
                    dumpPath, proj.getProjectCharset()).get(taskpm);
            break;

        case SOURCE_TYPE_JDBC:
            db = DbSource.fromJdbc(proj, password).get(taskpm);
            break;

        default:
            throw new InvocationTargetException(new IllegalStateException(
                    Messages.initProjectFromSource_init_request_but_no_schema_source));
        }
        pm.newChild(25).subTask(Messages.initProjectFromSource_exporting_db_model); // 75
        new ProjectUpdater(db, null, null, proj).updateFull();
    }
}
