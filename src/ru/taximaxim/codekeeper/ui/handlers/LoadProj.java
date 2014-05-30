 
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.File;

import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.addons.AddonPrefLoader;
import ru.taximaxim.codekeeper.ui.parts.CommitPartDescr;
import ru.taximaxim.codekeeper.ui.parts.Console;
import ru.taximaxim.codekeeper.ui.parts.DiffPartDescr;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.recentprojs.RecentProjects;

public class LoadProj {
    
    @Execute
    private void execute(
            @Named(IServiceConstants.ACTIVE_SHELL)
            Shell shell,
            IEclipseContext ctx, EPartService partService, EModelService model,
            MApplication app, @Named(UIConsts.PREF_STORE) final IPreferenceStore mainPrefs) {
        FileDialog dialog = new FileDialog(shell);
        dialog.setText("Open project...");
        dialog.setOverwrite(false);
        dialog.setFilterPath(mainPrefs.getString(UIConsts.PREF_LAST_OPENED_LOCATION));
        dialog.setFilterExtensions(new String[] { "*.project", "*" });
        
        String path = dialog.open();
        if(path != null) {
            PgDbProject proj = new PgDbProject(path);
            if(proj.getProjectFile().isFile()) {
                if (load(proj, ctx, partService, model, app, mainPrefs, shell)){
                    AddonPrefLoader.savePreference(mainPrefs, 
                            UIConsts.PREF_LAST_OPENED_LOCATION, new File (path).getParent());
                }
            } else {
                MessageBox mb = new MessageBox(shell);
                mb.setText("Load failed");
                mb.setMessage("Directory is not a valid project!"
                        + " Properties file not found!");
                mb.open();
            }
        }
    }
    
    public static boolean load(PgDbProject proj, IEclipseContext ctx, EPartService partService,
            EModelService model, MApplication app, IPreferenceStore mainPrefs, Shell shell) {
        Log.log(Log.LOG_INFO, "Opening project at " + proj.getProjectFile());
        
        proj.load();
        // check for not existing working dir
        if (!proj.getProjectWorkingDir().exists() || !proj.getProjectWorkingDir().isDirectory()){
            String message = "Could not open project " + proj.getProjectFile() + 
                    " because working directory " + proj.getProjectWorkingDir() + 
                    " either does not exist or not a directory";
            Console.addMessage(message);
            Log.log(Log.LOG_WARNING, message);
            return false;
        }
        if (!new File(proj.getProjectWorkingDir(), 
                UIConsts.FILENAME_WORKING_DIR_MARKER).exists()){
            MessageDialog dialog = new MessageDialog(shell,
                    "Bad project", null, 
                    "Missing marker file in working directory " + proj.getProjectWorkingDir() +
                    "\nCreate marker file named " + UIConsts.FILENAME_WORKING_DIR_MARKER +
                    " manually and try again", MessageDialog.WARNING, 
                    new String []{"Ok"}, 0);
            dialog.open();
            return false;
        }
        ctx.modify(PgDbProject.class, proj);
        
        CommitPartDescr.openNew(proj.getProjectFile().toString(),
                partService, model, app);
        DiffPartDescr.openNew(proj.getProjectFile().toString(),
                partService, model, app);
        RecentProjects.addRecent(proj.getProjectFile().toString(), mainPrefs);
        return true;
    }
}