package ru.taximaxim.codekeeper.ui.editors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

public class ProjectEditorSelectionProvider implements IPostSelectionProvider {

    private final StructuredSelection projectSelection;
    private IStructuredSelection currentSelection;
    
    private final ListenerList listeners = new ListenerList();
    private final ListenerList postListeners = new ListenerList();
    
    public ProjectEditorSelectionProvider(IProject proj) {
        projectSelection = new StructuredSelection(proj);
        currentSelection = projectSelection;
    }
    
    @Override
    public ISelection getSelection() {
        return currentSelection;
    }

    @Override
    public void setSelection(ISelection selection) {
        // this method sets provider's selection, e.g. changes viewer's selection
        // in this implementation the selection cannot be changed by the interface's clients
        // it can only be changed by attached providers that need to propagate their selection
    }

    @Override
    public void addSelectionChangedListener(ISelectionChangedListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeSelectionChangedListener(ISelectionChangedListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void addPostSelectionChangedListener(ISelectionChangedListener listener) {
        postListeners.add(listener);
    }

    @Override
    public void removePostSelectionChangedListener(ISelectionChangedListener listener) {
        postListeners.remove(listener);
    }
    
    public void changeSelection(IStructuredSelection selection) {
        // in these methods modify the incoming selection
        // to include the IProject this provider is attached to
        // and notify respective listeners
    }
    
    public void postChangeSelection(IStructuredSelection selection) {
        
    }
    
    private void modifyIncomingSelection(IStructuredSelection selection) {
        // here either add the IProject element into the IStructuredSelection list
        // or wrap the incoming selection into a new one (probably bad idea)
    }
}
