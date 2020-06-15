package ru.taximaxim.codekeeper.ui.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.search.ui.text.AbstractTextSearchResult;

public class ReferenceContentProvider implements ITreeContentProvider {

    private static final Object[] NO_CHILDREN = new Object[0];

    private AbstractTextSearchResult result;
    private final AbstractTreeViewer viewer;
    private Map<Object, Set<Object>> children;

    ReferenceContentProvider(AbstractTreeViewer viewer) {
        this.viewer = viewer;
    }

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
                insert(element, false);
            }
        }
    }

    public void elementsChanged(Object[] updatedElements) {
        for (Object updatedElement : updatedElements) {
            if (result.getMatchCount(updatedElement) > 0) {
                if (viewer.testFindItem(updatedElement) != null) {
                    viewer.refresh(updatedElement);
                } else {
                    // second parameter for compatibility with neon
                    viewer.add(updatedElement, NO_CHILDREN);
                }
            } else {
                viewer.remove(updatedElement);
            }
        }
    }

    private void insert(Object child, boolean refreshViewer) {
        Object parent = getParent(child);
        while (parent != null) {
            if (insertChild(parent, child)) {
                if (refreshViewer) {
                    viewer.add(parent, child);
                }
            } else {
                if (refreshViewer) {
                    viewer.update(parent, null);
                }
                return;
            }
            child = parent;
            parent = getParent(child);
        }
        if (insertChild(result, child) && refreshViewer) {
            viewer.add(result, child);
        }
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

        return null;
    }
}
