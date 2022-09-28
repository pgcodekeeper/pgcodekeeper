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

import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

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
        if (newInput instanceof AbstractTextSearchResult) {
            this.result = (AbstractTextSearchResult) newInput;
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
        if (element instanceof IResource) {
            IResource resource = (IResource) element;
            return resource.getParent();
        }

        if (element instanceof PgObjLocation) {
            PgObjLocation loc = (PgObjLocation) element;
            return ResourcesPlugin.getWorkspace().getRoot()
                    .getFileForLocation(new Path(loc.getFilePath()));
        }

        return null;
    }
}
