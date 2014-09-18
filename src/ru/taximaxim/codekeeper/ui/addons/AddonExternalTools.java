 
package ru.taximaxim.codekeeper.ui.addons;

import java.io.IOException;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.osgi.service.application.ApplicationHandle;

import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.externalcalls.PgDumper;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class AddonExternalTools {
    
    private static volatile String pgdumpVersion = "<unknown>"; //$NON-NLS-1$
 
    public static String getPgdumpVersion() {
        return pgdumpVersion;
    }
    
    public static void setPgdumpVersion(String pgdumpVersion) {
        AddonExternalTools.pgdumpVersion = pgdumpVersion;
    }
    
    /**
     * This gets called upon APP_STARTUP_COMPLETE event
     * when the GUI is already created just before GUI message loop starts.
     * 
     * @param app
     * @param pgdumpExec
     */
    @Inject
    @Optional
    private void getVersionsOnStartup(
            @EventTopic(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE)
            MApplication app,
            @Preference(PREF.PGDUMP_EXE_PATH)
            String pgdumpExec) {
        
        try {
            setPgdumpVersion(new PgDumper(pgdumpExec).getVersion());
        } catch(IOException ex) {
            setPgdumpVersion("<unknown>"); //$NON-NLS-1$
            ExceptionNotifier.notify(Messages.addonExternalTools_error_while_trying_to_run_pg_admin
                    + Messages.addonExternalTools_version_check_paths_in_program_preferences, ex);
        }
    }
    
    /**
     * This method is reinjected and recalled every time preferences
     * in its parameters change.
     * 
     * @param appHandle
     * @param pgdumpExec
     */
    @Inject
    @Optional
    private void prefsReinject(
            ApplicationHandle appHandle, // IApplicationContext actually
            @Preference(PREF.PGDUMP_EXE_PATH)
            String pgdumpExec) {
        if(appHandle.getState() == ApplicationHandle.RUNNING) {
            getVersionsOnStartup(null, pgdumpExec);
        }
    }
}