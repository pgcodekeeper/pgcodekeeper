package ru.taximaxim.codekeeper.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.reports.EclipseEnvironment;

public class Activator extends AbstractUIPlugin {

    private static BundleContext context;
    private static Activator plugin;

    private EclipseEnvironment eclipseEnvironment;

    public static BundleContext getContext() {
        return context;
    }

    public static Activator getDefault() {
        return plugin;
    }

    /**
     * Shortcut for {@link ISharedImages#getImage(String)}.
     *
     * @return Shared Eclipse image. Do not dispose!
     */
    public static Image getEclipseImage(String name) {
        return PlatformUI.getWorkbench().getSharedImages().getImage(name);
    }
    /**
     * @return Shared pgadmin {@link Image}. Do not dispose!
     */
    public static Image getDbObjImage(DbObjType dbObjType) {
        return getRegisteredImage(dbObjType.name());
    }
    /**
     * @return Shared {@link Image}, registered with this plugin with the <code>name</code> key.
     * Do not dispose!
     */
    public static Image getRegisteredImage(String name) {
        Activator a = plugin;
        return a == null ? null : a.getImageRegistry().get(name);
    }
    /**
     * @return Shared {@link ImageDescriptor}, registered with this plugin with the <code>name</code> key.
     */
    public static ImageDescriptor getRegisteredDescriptor(String name) {
        Activator a = plugin;
        return a == null ? null : a.getImageRegistry().getDescriptor(name);
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        super.start(bundleContext);
        Activator.context = bundleContext;
        plugin = this;
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
        plugin = null;
        super.stop(bundleContext);
    }

    public synchronized EclipseEnvironment getEclipseEnvironment() {
        if (eclipseEnvironment == null) {
            eclipseEnvironment =  new EclipseEnvironment();
        }
        return eclipseEnvironment;
    }

    @Override
    protected void initializeImageRegistry(ImageRegistry reg) {
        reg.put(FILE.ICONAPPSMALL, ImageDescriptor.createFromURL(
                context.getBundle().getResource(FILE.ICONAPPSMALL)));

        for (DbObjType dbObjType : DbObjType.values()) {
            reg.put(dbObjType.name(), ImageDescriptor.createFromURL(context.getBundle()
                    .getResource(FILE.ICONPGADMIN + dbObjType.name().toLowerCase() + ".png"))); //$NON-NLS-1$
        }
    }
}
