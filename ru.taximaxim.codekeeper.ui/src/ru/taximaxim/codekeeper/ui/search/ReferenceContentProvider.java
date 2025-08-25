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
package ru.taximaxim.codekeeper.ui.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.pgcodekeeper.core.schema.PgObjLocation;

import ru.taximaxim.codekeeper.ui.libraries.AbstractLibrary;
import ru.taximaxim.codekeeper.ui.libraries.LibraryStorage;
import ru.taximaxim.codekeeper.ui.libraries.LibraryUtils;
import ru.taximaxim.codekeeper.ui.libraries.RootLibrary;

public class ReferenceContentProvider implements ITreeContentProvider {

    private static final Object[] NO_CHILDREN = new Object[0];

    private AbstractTextSearchResult result;
    private Map<Object, Set<Object>> children;

    @Override
    public Object[] getElements(Object inputElement) {
        return getChildren(inputElement);
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        if (newInput instanceof AbstractTextSearchResult res) {
            this.result = res;
            children = new HashMap<>();

            Object[] elements = result.getElements();
            for (Object element : elements) {
                insert(element);
            }
        }
    }

    private void insert(Object child) {
        Object parent = getParent(child);
        while (parent != null) {
            if (!insertChild(parent, child)) {
                return;
            }
            child = parent;
            parent = getParent(child);
        }

        insertChild(result, child);
    }

    /**
     * Adds the child to the parent.
     *
     * @param parent the parent
     * @param child the child
     * @return <code>true</code> if this set did not already contain the specified element

     */
    private boolean insertChild(Object parent, Object child) {
        return children.computeIfAbsent(parent, e -> new HashSet<>()).add(child);
    }

    @Override
    public Object[] getChildren(Object parentElement) {
        Set<Object> childElements = children.get(parentElement);
        if (childElements == null) {
            return NO_CHILDREN;
        }

        return childElements.toArray();
    }

    @Override
    public boolean hasChildren(Object element) {
        return getChildren(element).length > 0;
    }

    @Override
    public Object getParent(Object element) {
        if (element instanceof IProject) {
            return null;
        }

        if (element instanceof IResource resource) {
            return resource.getParent();
        }

        if (element instanceof PgObjLocation loc) {
            String filePath = loc.getFilePath();
            if (filePath.contains(LibraryUtils.META_PATH.toString())) {
                return LibraryStorage.getLibrary(loc.getFilePath());
            }

            return ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(loc.getFilePath()));
        }

        if (element instanceof RootLibrary lib) {
            return ResourcesPlugin.getWorkspace().getRoot().getProject(lib.getProject());
        }

        if (element instanceof AbstractLibrary lib) {
            return lib.getParent();
        }

        return null;
    }
}
