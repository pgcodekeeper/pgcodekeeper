 
package ru.taximaxim.codekeeper.ui.handlers;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.preference.IPreferenceNode;
import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.prefs.GeneralPrefPage;
import ru.taximaxim.codekeeper.ui.prefs.SubPrefPage;

public class Prefs {
	
	private static final FakePrefPageExtension[] pages = {
		
		new FakePrefPageExtension("ru.taximaxim.codekeeper.ui.prefs.general",
				"General", GeneralPrefPage.class, null),
				
		new FakePrefPageExtension("ru.taximaxim.codekeeper.ui.prefs.generalsub",
				"Sub", SubPrefPage.class, "ru.taximaxim.codekeeper.ui.prefs.general")
	};
	
	@Inject
	private IEclipseContext ctx;
	
	@Execute
	public void execute(
			@Named(UIConsts.PREF_STORE)
			IPreferenceStore prefStore,
			@Named(IServiceConstants.ACTIVE_SHELL)
			Shell shell) {
		PreferenceManager pm = configurePrefs();
		PreferenceDialog dialog = new PreferenceDialog(shell, pm);
		dialog.setPreferenceStore(prefStore);
		dialog.create();
		dialog.getTreeViewer().setComparator(new ViewerComparator());
		dialog.getTreeViewer().expandAll();
		dialog.open();
	}
	
	private PreferenceManager configurePrefs() {
		PreferenceManager pm = new PreferenceManager();
		
		for (FakePrefPageExtension pageExt : pages) {
			IPreferencePage page = ContextInjectionFactory.make(
					pageExt.getClazz(), ctx);
			
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
	
	private IPreferenceNode findPrefNode(PreferenceManager pm, String id) {
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
	
	private boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}
}
/**
 * Instead of storing preference pages info in extension and reading it manually
 * from there - store it in a more convenient array of custom container objects.
 * 
 * @author Alexander Levsha
 */
class FakePrefPageExtension {
	
	private final String id;
	
	private final String name;
	
	private final Class<? extends IPreferencePage> clazz;
	
	private final String category;
	
	public FakePrefPageExtension(String id, String name,
			Class<? extends IPreferencePage> clazz, String category) {
		this.id = id;
		this.name = name;
		this.clazz = clazz;
		this.category = category;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Class<? extends IPreferencePage> getClazz() {
		return clazz;
	}
	
	public String getCat() {
		return category;
	}
}