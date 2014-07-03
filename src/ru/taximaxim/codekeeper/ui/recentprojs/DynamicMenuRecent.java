 
package ru.taximaxim.codekeeper.ui.recentprojs;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;

import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DynamicMenuRecent {
    @Inject
    @Preference(UIConsts.PREF_RECENT_PROJECTS)
    String prefRecent;
    
    @AboutToShow
    public void aboutToShow(List<MMenuElement> items) {
        String[] recent = RecentProjects.getRecent(prefRecent);
        if (recent == null) {
            MDirectMenuItem dynamicItem = MMenuFactory.INSTANCE.createDirectMenuItem();
            dynamicItem.setLabel(Messages.dynamicMenuRecent_recent_list_is_empty);
            dynamicItem.setEnabled(false);
            items.add(dynamicItem);
        } else {
            for (String s : recent) {
                MDirectMenuItem dynamicItem = MMenuFactory.INSTANCE.createDirectMenuItem();
                dynamicItem.setLabel(s);
                dynamicItem.setContributionURI(UIConsts.HANDLER_RECENT_PROJ);
                items.add(dynamicItem);
            }
        }
    }
}