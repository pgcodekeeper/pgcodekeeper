 
package ru.taximaxim.codekeeper.ui.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Version;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PART;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
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
        dialog.setText(Messages.loadProj_open_project);
        dialog.setOverwrite(false);
        dialog.setFilterPath(mainPrefs.getString(PREF.LAST_OPENED_LOCATION));
        dialog.setFilterExtensions(new String[] { "*.project", "*" }); //$NON-NLS-1$ //$NON-NLS-2$
        
        String path = dialog.open();
        if(path != null) {
            PgDbProject proj = new PgDbProject(path);
            if(proj.getProjectFile().isFile()) {
                if (load(proj, ctx, partService, model, app, mainPrefs, shell)){
                    AddonPrefLoader.savePreference(mainPrefs, 
                            PREF.LAST_OPENED_LOCATION, new File (path).getParent());
                }
            } else {
                MessageBox mb = new MessageBox(shell);
                mb.setText(Messages.load_failed);
                // TODO wrong message
                mb.setMessage(Messages.directory_isnt_valid_project);
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
            String message = Messages.loadProj_couldnt_open_project + proj.getProjectFile() + 
                    Messages.loadProj_because_working_directory + proj.getProjectWorkingDir() + 
                    Messages.loadProj_either_doesnt_exist_or_not_a_directory;
            Console.addMessage(message);
            Log.log(Log.LOG_WARNING, message);
            return false;
        }
        if (!new File(proj.getProjectWorkingDir(), 
                ApgdiffConsts.FILENAME_WORKING_DIR_MARKER).exists()){
            MessageDialog dialog = new MessageDialog(shell,
                    Messages.loadProj_bad_project, null, 
                    Messages.missing_marker_file_in_working_directory + proj.getProjectWorkingDir() +
                    Messages.create_marker_file_named + ApgdiffConsts.FILENAME_WORKING_DIR_MARKER +
                    Messages.manually_and_try_again, MessageDialog.WARNING, 
                    new String []{Messages.loadProj_ok}, 0);
            dialog.open();
            return false;
        }
        StringBuilder message = new StringBuilder();
        boolean allowContinue = getProjVersion(new File(proj.getProjectWorkingDir(), 
                ApgdiffConsts.FILENAME_WORKING_DIR_MARKER), message);
            
        if (message.length() != 0) {
            MessageDialog dialog = new MessageDialog(shell,
                    Messages.loadProj_bad_project, null, 
                    message.toString(), MessageDialog.WARNING, 
                    new String []{Messages.loadProj_ok}, 0);
            dialog.open();
            if (!allowContinue) {
                return false; 
            }
        }
        ctx.modify(PgDbProject.class, proj);
        
        // магический костыль
        // иначе Application does not have a active window
        // по причине невозврата фокуса/селекшена/чего-то главному окну
        // модальным прогресс диалогом, показывающемся при парсинге дерева файлов
        // при реинжекте PgDbProject в ProjectExplorer парте
        ((MPart) model.find(PART.WELCOME, app)).getContext().activateBranch();
        
        CommitPartDescr.openNew(proj.getProjectFile().toString(),
                partService, model, app);
        DiffPartDescr.openNew(proj.getProjectFile().toString(),
                partService, model, app);
        RecentProjects.addRecent(proj.getProjectFile().toString(), mainPrefs);
        return true;
    }
    
    public static boolean getProjVersion(File file, StringBuilder message) {
        try {
            Properties prop = new Properties();
            FileInputStream fStream = new FileInputStream(file);
            prop.load(fStream);
            fStream.close();
            String version = prop.getProperty(ApgdiffConsts.VERSION_PROP_NAME);
            
            if (version == null) {
                message.append(Messages.loadProj_proj_can_modified_because_it_was_created_in_program_with_version_smaller_than_allowed);
                return true;
            }
            Version projVersion = Version.parseVersion(version);
            Version minVersion = Version.parseVersion(UIConsts.MIN_APPROVAL_VERSION);
            Version curVersion = Version.parseVersion(
                    Activator.getPluginVersions().get(UIConsts.PLUGIN_ID.APGDIFF).get(0));
            if (projVersion.compareTo(curVersion) > 0) {
                message.append(Messages.loadProj_proj_cannt_loaded_because_it_created_in_program_with_version_bigger_than_current);
                return false;
            }
            if (projVersion.compareTo(minVersion) < 0) {
                message.append(Messages.loadProj_proj_can_modified_because_it_was_created_in_program_with_version_smaller_than_allowed);
            }
            return true;
            
        } catch (IOException | IllegalArgumentException e) {
            throw new IllegalStateException(Messages.loadProj_ecseption_during_get_project_version, e);
        }
    }
}