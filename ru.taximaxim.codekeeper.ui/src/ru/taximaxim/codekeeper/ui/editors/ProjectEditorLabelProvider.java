package ru.taximaxim.codekeeper.ui.editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorContentProvider.MyElement;

public class ProjectEditorLabelProvider implements ICommonLabelProvider {

    @Override
    public Image getImage(Object element) {

        LocalResourceManager lrm = new LocalResourceManager(
                JFaceResources.getResources());

        if (element instanceof MyElement){
            return lrm.createImage(ImageDescriptor.createFromURL(Activator
                    .getContext().getBundle().getResource(UIConsts.FILE.ICONAPPSMALL)));
        }

        return null;
    }

    @Override
    public String getText(Object element) {
        if (element instanceof MyElement){
            return UIConsts.FILE.CODEKEEPEREDITOR;
        }
        return null;
    }

    @Override
    public void addListener(ILabelProviderListener listener) {
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
    public void restoreState(IMemento aMemento) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveState(IMemento aMemento) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getDescription(Object anElement) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void init(ICommonContentExtensionSite aConfig) {
        /*        aConfig.getService().addListener(new INavigatorContentServiceListener() {

            @Override
            public void onLoad(INavigatorContentExtension anExtension) {
                // TODO Auto-generated method stub

            }
        });*/
    }

}
