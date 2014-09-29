 
package ru.taximaxim.codekeeper.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.recentprojs.RecentProjects;

public class OpenLastProject extends E4HandlerWrapper {
    
    @Execute
    private void execute(
            final MApplication app,
            final IWorkbenchPage page,
            @Named(UIConsts.PREF_STORE) final IPreferenceStore mainPrefs,
            @Preference(PREF.RECENT_PROJECTS) String prefRecentProjects,
            UISynchronize sync,
            final @Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
        String[] recent = RecentProjects.getRecent(prefRecentProjects);
        if (recent == null) {
            return;
        }
        
        String last = recent[0];
        final PgDbProject proj = PgDbProject.getProgFromFile(last);
        sync.syncExec(new Runnable() {

            @Override
            public void run() {
                LoadProj.load(proj, app.getContext(), page, mainPrefs, shell);
            }
        });
    }
    
    @CanExecute
    private boolean canExecute(
            @Preference(PREF.RECENT_PROJECTS) String prefRecentProjects) {
        return RecentProjects.getRecent(prefRecentProjects) != null;
    }
}