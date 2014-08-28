 
package ru.taximaxim.codekeeper.ui.recentprojs;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.prefs.UIScopedPreferenceStore;

public class DynamicMenuRecent extends CompoundContributionItem {
    
    @Override
    protected IContributionItem[] getContributionItems() {
        String pref = UIScopedPreferenceStore.get().getString(PREF.RECENT_PROJECTS);
        String[] recent = RecentProjects.getRecent(pref);
        
        if (recent == null) {
            Action a = new Action(Messages.dynamicMenuRecent_recent_list_is_empty) {};
            a.setEnabled(false);
            return new IContributionItem[] { new ActionContributionItem(a) };
        }
        
        IContributionItem items[] = new IContributionItem[recent.length];
        for(int i = 0; i < recent.length; ++i) {
            final String path = recent[i];
            Action a = new Action(shortenPath(path, 40)) {
                
                @Override
                public void run() {
                    PgDbProject proj = new PgDbProject(path);
                    Shell shell = PlatformUI.getWorkbench()
                            .getActiveWorkbenchWindow().getShell();
                    
                    if (proj.getProjectFile().isFile()) {
                    // TODO pending project loader rewrite (open 3.x views)
                    //    LoadProj.load(proj, app.getContext(), partService, model, app, mainPrefs, shell);
                    } else {
                        Log.log(Log.LOG_WARNING, "Couldn't open project at " //$NON-NLS-1$
                                + proj.getProjectFile()
                                + ". Project pref store either doesn't exist or not a file."); //$NON-NLS-1$
                        
                        MessageBox mb = new MessageBox(shell);
                        mb.setText(Messages.load_failed);
                        // TODO wrong message
                        mb.setMessage(Messages.directory_isnt_valid_project);
                        mb.open();
                        
                        RecentProjects.deleteRecent(path, UIScopedPreferenceStore.get());
                    }
                }
            };
            items[i] = new ActionContributionItem(a);
        }
        
        return items;
    }
    
    public static String shortenPath(String path, int maxLength) {
        Path p = Paths.get(path);
        String filename = p.getFileName().toString();
        StringBuilder shortPath = new StringBuilder(path.length());
        
        Path root = p.getRoot();
        if (root != null) {
            shortPath.append(root);
        }
        
        int names = p.getNameCount() - 1; // last one (filename) is processed separately
        for (int i = 0; i < names; ++i) {
            Path el = p.getName(i);
            String sEl = el.toString();
            String sep = el.getFileSystem().getSeparator();
            
            if (i >= 2 && // root (above), filename (below) and first two elements are mandatory
                    shortPath.length() + sEl.length() + sep.length() +
                    filename.length() > maxLength) {
                shortPath.append("...").append(sep); //$NON-NLS-1$
                break;
            }
            
            shortPath.append(sEl).append(sep);
        }
        
        shortPath.append(filename);
        
        return shortPath.toString();
    }
}