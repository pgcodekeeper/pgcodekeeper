package ru.taximaxim.codekeeper.ui.addons;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MAddon;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.MApplicationFactory;

import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class AddonsProcessor {

    private static String ADDONS[] = {
        PLUGIN_ID.THIS + ".addons.AddonExternalTools",
        PLUGIN_ID.THIS + ".addons.AddonOpenLast",
        PLUGIN_ID.THIS + ".addons.AddonPerspListener",
        PLUGIN_ID.THIS + ".addons.AddonPrefLoader",
        PLUGIN_ID.THIS + ".addons.AddonWindowLabel"
    };
    
    @Execute
    private void execute(MApplication app, IEclipseContext ctx) {
        ctx.declareModifiable(PgDbProject.class);
        
        for (String addonClass : ADDONS) {
            MAddon a = MApplicationFactory.INSTANCE.createAddon();
            a.setContributionURI("bundleclass://" + PLUGIN_ID.THIS + '/' + addonClass);
            app.getAddons().add(a);
        }
    }
}
