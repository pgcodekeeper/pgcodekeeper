package ru.taximaxim.codekeeper.ui.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.views.DepcyStructuredSelection;

public class ProjectEditorSelectionProvider implements IPostSelectionProvider {

    private final IProject proj;
    private final SelectionChangedEvent defaultSelectionEvent;
    private ISelection currentSelection;

    private final ListenerList<ISelectionChangedListener> listeners = new ListenerList<>();
    private final ListenerList<ISelectionChangedListener> postListeners = new ListenerList<>();

    public ProjectEditorSelectionProvider(IProject proj) {
        this.proj = proj;
        currentSelection = new StructuredSelection(proj);
        defaultSelectionEvent = new SelectionChangedEvent(this, currentSelection);
    }

    @Override
    public ISelection getSelection() {
        // maybe refactor to call ProjectEditorDiffer.getActivePage.getViewer.getSelection() and modify the result
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

    public void fireSelectionChanged(SelectionChangedEvent event) {
        modifyAndFireEvent(listeners, event);
    }

    public void firePostSelectionChanged(SelectionChangedEvent event) {
        modifyAndFireEvent(postListeners, event);
    }

    private void modifyAndFireEvent(ListenerList<ISelectionChangedListener> listeners, SelectionChangedEvent event) {
        SelectionChangedEvent newEvent = modifyEvent(event);
        currentSelection = newEvent.getSelection();
        for(Object l : listeners.getListeners()) {
            ((ISelectionChangedListener) l).selectionChanged(newEvent);
        }
    }

    /**
     * Ensures that IProject is present as first element of the selection.
     * Special handling for {@link DepcyStructuredSelection}
     */
    private SelectionChangedEvent modifyEvent(SelectionChangedEvent event) {
        ISelection selection = event.getSelection();
        if (selection.isEmpty()) {
            return defaultSelectionEvent;
        }
        if (!(selection instanceof IStructuredSelection)) {
            Log.log(Log.LOG_WARNING, "Cannot handle this selection type: " + selection.toString()); //$NON-NLS-1$
            // no way to deal with empty/other types of selections
            return defaultSelectionEvent;
        }

        IStructuredSelection sel = (IStructuredSelection) selection;
        List<?> elements = sel.toList();

        boolean isDepcySel = sel instanceof DepcyStructuredSelection;
        List<Object> newElements = new ArrayList<>(elements.size() + (isDepcySel ? 2 : 1));
        newElements.add(proj);
        if (isDepcySel) {
            newElements.add(sel);
        }
        newElements.addAll(elements);

        return new SelectionChangedEvent((ISelectionProvider) event.getSource(),
                new StructuredSelection(newElements));
    }
}
