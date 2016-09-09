package ru.taximaxim.codekeeper.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;

public class Activator extends AbstractUIPlugin {

    private static BundleContext context;
    private static Activator plugin;

    public static BundleContext getContext() {
        return context;
    }

    public static Activator getDefault() {
        return plugin;
    }

    /**
     * @return Shared image. Do not dispose!
     */
    public static Image getDbObjImage(DbObjType dbObjType) {
        Activator a = plugin;
        return a == null ? null : a.getImageRegistry().get(dbObjType.name());
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
        plugin = this;
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
        plugin = null;
    }

    @Override
    protected void initializeImageRegistry(ImageRegistry reg) {
        for (DbObjType dbObjType : DbObjType.values()) {
            reg.put(dbObjType.name(), ImageDescriptor.createFromURL(context.getBundle()
                    .getResource(FILE.ICONPGADMIN + dbObjType.name().toLowerCase() + ".png")));
        }
    }
}
