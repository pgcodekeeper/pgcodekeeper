/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui;

import java.util.Locale;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
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
     * @return Shared {@link Image}, registered with this plugin with the <code>projectIcon</code> key.
     * Do not dispose!
     */
    public static Image getRegisteredImage(ProjectIcon projectIcon) {
        return getRegisteredImage(projectIcon.getPath());
    }

    /**
     * @return Shared {@link ImageDescriptor}, registered with this plugin with the <code>projectIcon</code> key.
     */
    public static ImageDescriptor getRegisteredDescriptor(ProjectIcon projectIcon) {
        Activator a = plugin;
        return a == null ? null : a.getImageRegistry().getDescriptor(projectIcon.getPath());
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
        for (ProjectIcon projectIcon : ProjectIcon.values()) {
            String path = projectIcon.getPath();
            reg.put(path, ImageDescriptor.createFromURL(context.getBundle().getResource(path)));
        }

        for (DbObjType dbObjType : DbObjType.values()) {
            reg.put(dbObjType.name(), ImageDescriptor.createFromURL(context.getBundle()
                    .getResource(ProjectIcon.PG_ADMIN_ICON_FOLDER + dbObjType.name().toLowerCase(Locale.ROOT) + ".png"))); //$NON-NLS-1$
        }
    }
}
