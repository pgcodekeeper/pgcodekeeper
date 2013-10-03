 
package ru.taximaxim.codekeeper.ui.handlers;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.jface.preference.IPreferenceNode;
import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.UIConsts;

//@SuppressWarnings("restriction")
public class Prefs {
	
	private static final String PREF_PAGES_XP = "org.eclipse.ui.preferencePages";
	private static final String ELMT_PAGE = "page";
	private static final String ATTR_ID = "id";
	private static final String ATTR_NAME = "name";
	private static final String ATTR_CLASS = "class";
	private static final String ATTR_CAT = "category";
	
	@Inject
	private IEclipseContext ctx;
	
	@Inject
	private Logger logger;
	
	@Inject
	private IExtensionRegistry extRegistry;
	
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
		IContributionFactory contribFactory = ctx.get(IContributionFactory.class);
		
		for( IConfigurationElement el : extRegistry.getConfigurationElementsFor(
				PREF_PAGES_XP)) {
			if(!el.getName().equals(ELMT_PAGE)) {
				logger.warn("unexpected preferencePages element: {0}",
						el.getName());
				continue;
			}
			else if(isEmpty(el.getAttribute(ATTR_ID))
					|| isEmpty(el.getAttribute(ATTR_NAME))
					|| isEmpty(el.getAttribute(ATTR_CLASS))) {
				logger.warn("preferencePage missing id, name and/or class: {0}", 
						el.getNamespaceIdentifier());
				continue;
			}
			
			IPreferencePage page = null;
			
			String prefPageClassURI = getClassURI(el.getNamespaceIdentifier(),
					el.getAttribute(ATTR_CLASS));
			Object ob = contribFactory.create(prefPageClassURI, ctx);
			if(ob instanceof IPreferencePage) {
				page = (IPreferencePage) ob;
			} else {
				logger.warn("expected instance of IPreferencePage: {0}",
						prefPageClassURI);
				continue;
			}
			
			ContextInjectionFactory.inject(page, ctx);
			
			if(isEmpty(page.getTitle())) {
				page.setTitle(el.getAttribute(ATTR_NAME));
			}

			PreferenceNode node = new PreferenceNode(el.getAttribute(ATTR_ID), page);
			
			IPreferenceNode parent = null;
			if(!isEmpty(el.getAttribute(ATTR_CAT))) {
				parent = findPrefNode(pm, el.getAttribute(ATTR_CAT));
			}
			
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
	
	private String getClassURI(String definingBundleId, String spec) {
		if(spec.startsWith("platform:") || spec.startsWith("bundleclass:")) {
			return spec;
		}
		return "bundleclass://" + definingBundleId + "/" + spec;
	}
	
	private boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}
}