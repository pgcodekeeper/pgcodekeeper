 
package ru.taximaxim.codekeeper.ui;

import java.util.List;

import org.eclipse.e4.ui.di.AboutToHide;
import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;

public class DynamicMenu {
	@AboutToShow
    public void aboutToShow(List<MMenuElement> items) {
	    String [] recent = {"A","B","C"};
        for (String s : recent){
            MDirectMenuItem dynamicItem = MMenuFactory.INSTANCE
                    .createDirectMenuItem();
            dynamicItem.setLabel(s);
            dynamicItem.
                setContributionURI(
                        "bundleclass://ru.taximaxim.codekeeper.ui/ru.taximaxim.codekeeper.ui.handlers.OpenRecent");
            items.add(dynamicItem);
        }        
	}
	
	@AboutToHide
	public void aboutToHide(List<MMenuElement> items) {
		//TODO Your code goes here
	}
		
}