package ru.taximaxim.codekeeper.ui.views.navigator;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;

public class PgDecorator implements ILightweightLabelDecorator, IResourceChangeListener {

    public PgDecorator() {
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
    }

    @Override
    public void decorate(Object element, IDecoration decoration) {
        if (element instanceof IResource) {
            try {
                IMarker[] markers = ((IResource) element).findMarkers(UIConsts.MARKER.ERROR, false,
                        IResource.DEPTH_INFINITE);
                if (markers.length > 0) {
                    decoration.addOverlay(ImageDescriptor.createFromURL(Activator.getContext().getBundle()
                            .getResource(FILE.DECORATEWARNING)));
                }
            } catch (CoreException e) {
                Log.log(Log.LOG_ERROR, e.getLocalizedMessage(), e.getCause());
            }
        }
    }

    @Override
    public void addListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isLabelProperty(Object element, String property) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void removeListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub
    }

    @Override
    public void resourceChanged(IResourceChangeEvent event) {
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                PlatformUI.getWorkbench().getDecoratorManager().update(UIConsts.DECORATOR);
            }
        });
    }
}
