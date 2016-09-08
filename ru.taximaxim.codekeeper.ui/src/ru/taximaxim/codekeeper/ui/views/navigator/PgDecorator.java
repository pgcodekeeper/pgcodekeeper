package ru.taximaxim.codekeeper.ui.views.navigator;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.DECORATOR;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.MARKER;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;

public class PgDecorator extends LabelProvider implements ILightweightLabelDecorator {

    private static final ImageDescriptor ICON_ERROR = ImageDescriptor.createFromURL(
            Activator.getContext().getBundle().getResource(FILE.DECORATEERROR));

    @Override
    public void decorate(Object element, IDecoration decoration) {
        if (element instanceof IResource) {
            IResource res = (IResource) element;
            IProject proj = res.getProject();
            try {
                if (proj != null && proj.isAccessible() && proj.hasNature(NATURE.ID)) {
                    IMarker[] markers = res.findMarkers(
                            MARKER.ERROR, false, IResource.DEPTH_INFINITE);
                    if (markers.length > 0) {
                        decoration.addOverlay(ICON_ERROR);
                    }
                }
            } catch (CoreException e) {
                Log.log(e);
            }
        }
    }

    public static void update() {
        PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

            @Override
            public void run() {
                PlatformUI.getWorkbench().getDecoratorManager().update(DECORATOR.DECORATOR);
            }
        });
    }
}
