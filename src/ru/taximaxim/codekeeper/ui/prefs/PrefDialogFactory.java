package ru.taximaxim.codekeeper.ui.prefs;

import org.eclipse.jface.preference.IPreferenceNode;
import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.swt.widgets.Shell;

public class PrefDialogFactory {
    
    public static int show(Shell shell, IPreferenceStore prefStore,
            FakePrefPageExtension[] pages) {
        PreferenceManager pm = get(pages);
        PreferenceDialog dialog = new PreferenceDialog(shell, pm);
        dialog.setPreferenceStore(prefStore);
        dialog.create();
        dialog.getTreeViewer().setComparator(null); // do not sort the pref page tree
        dialog.getTreeViewer().expandAll();
        return dialog.open();
    }

    private static PreferenceManager get(FakePrefPageExtension[] pages) {
        PreferenceManager pm = new PreferenceManager();
        
        for (FakePrefPageExtension pageExt : pages) {
            IPreferencePage page = pageExt.getPage();
            
            if(isEmpty(page.getTitle())) {
                page.setTitle(pageExt.getName());
            }
            
            IPreferenceNode parent = null;
            if(!isEmpty(pageExt.getCat())) {
                parent = findPrefNode(pm, pageExt.getCat());
            }

            PreferenceNode node = new PreferenceNode(pageExt.getId(), page);
            
            if(parent != null) {
                parent.add(node);
            } else {
                pm.addToRoot(node);
            }
        }
        
        return pm;
    }
    
    private static IPreferenceNode findPrefNode(PreferenceManager pm, String id) {
        for(Object ob : pm.getElements(PreferenceManager.POST_ORDER)) {
            if(ob instanceof IPreferenceNode) {
                IPreferenceNode node = (IPreferenceNode) ob;
                
                if(node.getId().equals(id)) {
                    return node;
                }
            }
        }
        
        return null;
    }
    
    private static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
