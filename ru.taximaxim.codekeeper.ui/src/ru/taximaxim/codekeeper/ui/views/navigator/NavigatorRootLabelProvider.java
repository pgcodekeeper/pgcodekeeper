package ru.taximaxim.codekeeper.ui.views.navigator;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.navigator.IDescriptionProvider;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class NavigatorRootLabelProvider extends LabelProvider implements IDescriptionProvider {

    @Override
    public Image getImage(Object element) {
        if (element instanceof OpenProjectFromNavigator) {
            return Activator.getRegisteredImage(FILE.ICONAPPSMALL);
        }
        return null;
    }

    @Override
    public String getText(Object element) {
        if (element instanceof OpenProjectFromNavigator) {
            return Messages.NavigatorRootLabelProvider_open_editor;
        }
        return null;
    }

    @Override
    public String getDescription(Object anElement) {
        if (anElement instanceof OpenProjectFromNavigator) {
            return ((OpenProjectFromNavigator) anElement).getProject().getName();
        }
        return null;
    }
}
