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

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ITreeContentProvider;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.libraries.AbstractLibrary;
import ru.taximaxim.codekeeper.ui.libraries.LibraryUtils;
import ru.taximaxim.codekeeper.ui.libraries.RootLibrary;

public class NavigationLibrariesContentProvider implements ITreeContentProvider {

    private static final Object[] NO_CHILDREN = new Object[0];

    @Override
    public Object[] getElements(Object inputElement) {
        return getChildren(inputElement);
    }

    @Override
    public Object[] getChildren(Object parent) {
        if (parent instanceof IProject proj) {
            try {
                return new Object[] { LibraryUtils.getRoot(proj) };
            } catch (IOException e) {
                Log.log(e);
            }
        } else if (parent instanceof AbstractLibrary lib) {
            return lib.getChildren().toArray();
        }

        return NO_CHILDREN;
    }

    @Override
    public Object getParent(Object element) {
        if (element instanceof RootLibrary lib) {
            return ResourcesPlugin.getWorkspace().getRoot().getProject(lib.getProject());
        }
        if (element instanceof AbstractLibrary lib) {
            return lib.getParent();
        }

        return null;
    }

    @Override
    public boolean hasChildren(Object element) {
        if (element instanceof AbstractLibrary lib) {
            return lib.hasChildren();
        }
        return false;
    }
}
