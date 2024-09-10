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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.DECORATOR;
import ru.taximaxim.codekeeper.ui.UIConsts.MARKER;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UiSync;

public class PgDecorator extends LabelProvider implements ILightweightLabelDecorator {

    @Override
    public void decorate(Object element, IDecoration decoration) {
        if (element instanceof IResource res) {
            IProject proj = res.getProject();
            try {
                if (res.exists() && proj != null && proj.isAccessible() && proj.hasNature(NATURE.ID)) {
                    IMarker[] markers = res.findMarkers(MARKER.ERROR, false,
                            IResource.DEPTH_INFINITE);
                    if (markers.length > 0) {
                        decoration.addOverlay(PlatformUI.getWorkbench().getSharedImages()
                                .getImageDescriptor(ISharedImages.IMG_DEC_FIELD_ERROR));
                    }
                }
            } catch (CoreException e) {
                Log.log(e);
            }
        }
    }

    public static void update() {
        UiSync.exec(PlatformUI.getWorkbench().getDisplay(),
                () -> PlatformUI.getWorkbench().getDecoratorManager().update(DECORATOR.DECORATOR));
    }
}
