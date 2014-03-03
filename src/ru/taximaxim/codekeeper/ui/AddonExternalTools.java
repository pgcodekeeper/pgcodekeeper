 
package ru.taximaxim.codekeeper.ui;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.EventTopic;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.osgi.service.application.ApplicationHandle;

import ru.taximaxim.codekeeper.ui.externalcalls.PgDumper;
import ru.taximaxim.codekeeper.ui.externalcalls.SvnExec;
import ru.taximaxim.codekeeper.ui.parts.Console;

public class AddonExternalTools {
    
    private static volatile String svnVersion = "<unknown>";
    private static volatile String pgdumpVersion = "<unknown>";
    
    public static String getSvnVersion() {
        return svnVersion;
    }
    
    public static void setSvnVersion(String svnVersion) {
        AddonExternalTools.svnVersion = svnVersion;
    }
    
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
     * @param svnExec
     * @param pgdumpExec
     */
    @Inject
    @Optional
    private void getVersionsOnStartup(
            // FIXME workaround, see http://www.eclipse.org/forums/index.php/t/351144/
            // and https://bugs.eclipse.org/bugs/show_bug.cgi?id=378694
            // without @Named it doesn't register @EventTopic annotation,
            // calls the method on Addon creation and doesn't do anything afterwards
            @Named("__DUMMY__")
            @EventTopic(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE)
            MApplication app,
            @Preference(value=UIConsts.PREF_REPO_EXE_PATH)
            String svnExec,
            @Preference(value=UIConsts.PREF_PGDUMP_EXE_PATH)
            String pgdumpExec) {
        try {
            setSvnVersion(new SvnExec(svnExec).repoGetVersion());
        } catch(IOException ex) {
            Console.addMessage("Error while trying to run svn --version!"
                    + " Check paths in program preferences.");
            ex.printStackTrace();
            setSvnVersion("<unknown>");
        }
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
     * @param svnExec
     * @param pgdumpExec
     */
    @Inject
    @Optional
    private void prefsReinject(
            ApplicationHandle appHandle, // IApplicationContext actually
            @Preference(value=UIConsts.PREF_REPO_EXE_PATH)
            String svnExec,
            @Preference(value=UIConsts.PREF_PGDUMP_EXE_PATH)
            String pgdumpExec) {
        if(appHandle.getState() == ApplicationHandle.RUNNING) {
            getVersionsOnStartup(null, svnExec, pgdumpExec);
        }
    }
}