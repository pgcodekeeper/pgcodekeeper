/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.views.navigator;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.navigator.IDescriptionProvider;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class NavigatorRootLabelProvider extends LabelProvider implements IDescriptionProvider {

    @Override
    public Image getImage(Object element) {
        if (element instanceof OpenProjectFromNavigator) {
            return Activator.getRegisteredImage(ProjectIcon.APP_SMALL);
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
