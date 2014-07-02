 
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

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.addons.AddonPrefLoader;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
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
            MApplication app,
            @Named(UIConsts.PREF_STORE) final IPreferenceStore mainPrefs) {
        FileDialog dialog = new FileDialog(shell);
        dialog.setText(Messages.LoadProj_open_project);
        dialog.setOverwrite(false);
        dialog.setFilterPath(mainPrefs.getString(UIConsts.PREF_LAST_OPENED_LOCATION));
        dialog.setFilterExtensions(new String[] { "*.project", "*" }); //$NON-NLS-1$ //$NON-NLS-2$
        
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
                mb.setText(Messages.LoadProj_loadl_failed);
                mb.setMessage(Messages.LoadProj_directory_isnt_valid_project
                        + Messages.LoadProj_properties_file_not_found);
                mb.open();
            }
        }
    }
    
    public static boolean load(PgDbProject proj, IEclipseContext ctx, EPartService partService,
            EModelService model, MApplication app, IPreferenceStore mainPrefs, Shell shell) {
        Log.log(Log.LOG_INFO, "Opening project at " + proj.getProjectFile()); //$NON-NLS-1$
        
        proj.load();
        // check for not existing working dir
        if (!proj.getProjectWorkingDir().exists() || !proj.getProjectWorkingDir().isDirectory()){
            String message = Messages.LoadProj_couldnt_open_project + proj.getProjectFile() + 
                    Messages.LoadProj_because_working_directory + proj.getProjectWorkingDir() + 
                    Messages.LoadProj_either_doesnt_exist_or_not_a_directory;
            Console.addMessage(message);
            Log.log(Log.LOG_WARNING, message);
            return false;
        }
        if (!new File(proj.getProjectWorkingDir(), 
                ApgdiffConsts.FILENAME_WORKING_DIR_MARKER).exists()){
            MessageDialog dialog = new MessageDialog(shell,
                    Messages.LoadProj_bad_project, null, 
                    Messages.LoadProj_missing_marker_file_in_working_directory + proj.getProjectWorkingDir() +
                    Messages.LoadProj_create_marker_file_named + ApgdiffConsts.FILENAME_WORKING_DIR_MARKER +
                    Messages.LoadProj_manually_and_try_again, MessageDialog.WARNING, 
                    new String []{Messages.LoadProj_ok}, 0);
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