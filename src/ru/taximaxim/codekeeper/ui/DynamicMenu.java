 
package ru.taximaxim.codekeeper.ui;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.di.AboutToHide;
import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;

public class DynamicMenu {
    @Inject
    @Preference(value=UIConsts.PREF_RECENT_PROJECTS)
    String prefRecent;
    
	@AboutToShow
    public void aboutToShow(List<MMenuElement> items) {
        String[] recent = RecentProjects.getRecent(prefRecent);
        if (recent.length == 1 && recent[0].equals("")){
            MDirectMenuItem dynamicItem = MMenuFactory.INSTANCE
                    .createDirectMenuItem();
            dynamicItem.setLabel("Recent list is empty");
            dynamicItem.setEnabled(false);
            items.add(dynamicItem);
        }else{
            for (String s : recent) {
                MDirectMenuItem dynamicItem = MMenuFactory.INSTANCE
                        .createDirectMenuItem();
                dynamicItem.setLabel(s);
                dynamicItem
                        .setContributionURI("bundleclass://ru.taximaxim.codekeeper.ui/ru.taximaxim.codekeeper.ui.handlers.OpenRecent");
                items.add(dynamicItem);
            }
        }
	}
	
	@Inject
    @Optional
    private void prefsReinject(
            @Preference(value=UIConsts.PREF_RECENT_PROJECTS)
            String prefRecent) {
	    System.out.println("DEBUG reinjection " + prefRecent);
//        if(appHandle.getState() == ApplicationHandle.RUNNING) {
//            getVersionsOnStartup(null, svnExec, pgdumpExec);
//        }
    }
	
	@AboutToHide
	public void aboutToHide(List<MMenuElement> items) {
	    
	}
}