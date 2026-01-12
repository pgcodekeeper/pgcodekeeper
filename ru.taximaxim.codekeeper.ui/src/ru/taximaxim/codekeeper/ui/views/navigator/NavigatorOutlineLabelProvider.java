/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.navigator.IDescriptionProvider;
import org.pgcodekeeper.core.model.difftree.DbObjType;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.sqledit.SegmentsWithParent;

public class NavigatorOutlineLabelProvider extends LabelProvider
implements IDescriptionProvider {

    @Override
    public String getDescription(Object anElement) {
        if (anElement instanceof SegmentsWithParent seg) {
            return seg + " (" + seg.getType() + ')'; //$NON-NLS-1$
        }
        return null;
    }

    @Override
    public String getText(Object element) {
        if (element instanceof IFile) {
            return null;
        }
        return super.getText(element);
    }

    @Override
    public Image getImage(Object element) {
        if (element instanceof SegmentsWithParent seg) {
            DbObjType type = seg.getType();
            return type != null ? Activator.getDbObjImage(type)
                    : Activator.getEclipseImage(ISharedImages.IMG_OBJ_FILE);
        }
        return super.getImage(element);
    }
}
