 
package ru.taximaxim.codekeeper.ui.addons;

import java.io.IOException;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.osgi.service.application.ApplicationHandle;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.externalcalls.PgDumper;
import ru.taximaxim.codekeeper.ui.parts.Console;

public class AddonExternalTools {
    
    private static volatile String pgdumpVersion = "<unknown>";
 
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
            @Preference(value=UIConsts.PREF_PGDUMP_EXE_PATH)
            String pgdumpExec) {
        
        try {
            setPgdumpVersion(new PgDumper(pgdumpExec).getVersion());
        } catch(IOException ex) {
            Console.addMessage("Error while trying to run pg_dump --version!"
                    + " Check paths in program preferences.");
            ex.printStackTrace();
            setPgdumpVersion("<unknown>");
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
            @Preference(value=UIConsts.PREF_PGDUMP_EXE_PATH)
            String pgdumpExec) {
        if(appHandle.getState() == ApplicationHandle.RUNNING) {
            getVersionsOnStartup(null, pgdumpExec);
        }
    }
}