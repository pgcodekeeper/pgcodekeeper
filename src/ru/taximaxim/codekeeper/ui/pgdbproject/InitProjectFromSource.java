package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class InitProjectFromSource implements IRunnableWithProgress {

    private final String exePgdump;
    private final String pgdumpCustom;

    private final PgDbProject props;

    private final String dumpPath;

    public InitProjectFromSource(final IPreferenceStore mainPrefStore,
            final PgDbProject props, final String dumpPath) {
        this.exePgdump = mainPrefStore.getString(PREF.PGDUMP_EXE_PATH);
        this.pgdumpCustom = mainPrefStore.getString(PREF.PGDUMP_CUSTOM_PARAMS);
        this.props = props;
        this.dumpPath = dumpPath;
    }

    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException {
        try {
            Log.log(Log.LOG_INFO, "Init project at " + props.getPathToProject()); //$NON-NLS-1$
            
            SubMonitor pm = SubMonitor.convert(monitor, Messages.initProjectFromSource_initializing_project, 75);

            initRepoFromSource(pm);
            
            pm.done();
        } catch (IOException ex) {
            throw new InvocationTargetException(ex, Messages.initProjectFromSource_ioexception_while_creating_project);
        }
    }

    /**
     * clean repository, generate new file structure, preserve and fix repo
     * metadata, repo rm/add, commit new revision
     */
    private void initRepoFromSource(SubMonitor pm)
            throws IOException, InvocationTargetException {
        SubMonitor taskpm = pm.newChild(25); // 50

        PgDatabase db;
        switch (props.getPrefs().get(PROJ_PREF.SOURCE, "")) { //$NON-NLS-1$
        case PROJ_PREF.SOURCE_TYPE_DB:
            db = DbSource.fromDb(exePgdump, pgdumpCustom, props).get(taskpm);
            break;

        case PROJ_PREF.SOURCE_TYPE_DUMP:
            db = DbSource.fromFile(dumpPath,
                    props.getPrefs().get(PROJ_PREF.ENCODING, "")).get(taskpm); //$NON-NLS-1$
            break;

        case PROJ_PREF.SOURCE_TYPE_JDBC:
            db = DbSource.fromJdbc(props).get(taskpm);
            break;
            
        default:
            throw new InvocationTargetException(new IllegalStateException(
                    Messages.initProjectFromSource_init_request_but_no_schema_source));
        }

        pm.newChild(25).subTask(Messages.initProjectFromSource_exporting_db_model); // 75
        new ProjectUpdater(db, props).update();
    }
}
