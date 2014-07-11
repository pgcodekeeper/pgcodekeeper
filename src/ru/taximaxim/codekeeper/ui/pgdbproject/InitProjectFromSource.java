package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;

import cz.startnet.utils.pgdiff.schema.PgDatabase;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.externalcalls.IRepoWorker;
import ru.taximaxim.codekeeper.ui.externalcalls.JGitExec;
import ru.taximaxim.codekeeper.ui.fileutils.Dir;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class InitProjectFromSource implements IRunnableWithProgress {

    private final String exePgdump;
    private final String pgdumpCustom;

    private final PgDbProject props;

    private final String dumpPath;

    private final IPreferenceStore mainPrefStore;
    
    public InitProjectFromSource(final IPreferenceStore mainPrefStore,
            final PgDbProject props, final String dumpPath) {
        this.mainPrefStore = mainPrefStore;
        this.exePgdump = mainPrefStore.getString(UIConsts.PREF_PGDUMP_EXE_PATH);
        this.pgdumpCustom = mainPrefStore.getString(UIConsts.PREF_PGDUMP_CUSTOM_PARAMS);
        this.props = props;
        this.dumpPath = dumpPath;
    }

    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException {
        try {
            Log.log(Log.LOG_INFO, "Init project at " + props.getProjectWorkingDir()); //$NON-NLS-1$
            
            SubMonitor pm = SubMonitor.convert(monitor, Messages.initProjectFromSource_initializing_project, 100);
            IRepoWorker repo = new JGitExec(props, 
                    mainPrefStore.getString(UIConsts.PREF_GIT_KEY_PRIVATE_FILE));
            initRepoFromSource(pm, repo);
            
            monitor.done();
        } catch (IOException ex) {
            throw new InvocationTargetException(ex, Messages.initProjectFromSource_ioexception_while_creating_project);
        }
    }

    /**
     * clean repository, generate new file structure, preserve and fix repo
     * metadata, repo rm/add, commit new revision
     * 
     * @param pm
     * @param repo
     * @throws IOException
     * @throws InvocationTargetException
     */

    private void initRepoFromSource(SubMonitor pm, IRepoWorker repo)
            throws IOException, InvocationTargetException {
        File dirRepo = props.getProjectWorkingDir();
        SubMonitor taskpm = pm.newChild(25); // 50

        PgDatabase db;
        switch (props.getString(UIConsts.PROJ_PREF_SOURCE)) {
        case UIConsts.PROJ_SOURCE_TYPE_DB:
            db = DbSource.fromDb(exePgdump, pgdumpCustom, props).get(taskpm);
            break;

        case UIConsts.PROJ_SOURCE_TYPE_DUMP:
            db = DbSource.fromFile(dumpPath,
                    props.getString(UIConsts.PROJ_PREF_ENCODING)).get(taskpm);
            break;

        default:
            throw new InvocationTargetException(new IllegalStateException(
                    Messages.initProjectFromSource_init_request_but_no_schema_source));
        }

        pm.newChild(25).subTask(Messages.initProjectFromSource_exporting_db_model); // 75

        for (ApgdiffConsts.WORK_DIR_NAMES subdirName : ApgdiffConsts.WORK_DIR_NAMES.values()) {
            File subdir = new File(dirRepo, subdirName.toString());
            if (subdir.exists()) {
                Dir.deleteRecursive(subdir);
            }
        }
        
        new ModelExporter(dirRepo.getAbsolutePath(), db,
                props.getString(UIConsts.PROJ_PREF_ENCODING)).export();

        pm.newChild(25).subTask(UIConsts.PROJ_REPO_TYPE_GIT_NAME + " committing..."); // 100 //$NON-NLS-1$
        repo.repoRemoveMissingAddNew(dirRepo);
        repo.repoCommit(dirRepo, "new rev"); //$NON-NLS-1$
    }
}
