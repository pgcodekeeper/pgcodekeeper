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
import ru.taximaxim.codekeeper.ui.views.DBPair;

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

    public void fireSelectionChanged(SelectionChangedEvent event, DBPair dbPair) {
        SelectionChangedEvent newEvent = modifyEvent(event, dbPair);
        currentSelection = newEvent.getSelection();
        for(ISelectionChangedListener l : listeners) {
            l.selectionChanged(newEvent);
        }
        for(ISelectionChangedListener l : postListeners) {
            l.selectionChanged(newEvent);
        }
    }

    /**
     * Ensures that IProject is present as first element
     * and DBPair is present as second element of the selection.
     */
    private SelectionChangedEvent modifyEvent(SelectionChangedEvent event, DBPair dbPair) {
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

        List<Object> newElements = new ArrayList<>(elements.size() + 2);
        newElements.add(proj);
        newElements.add(dbPair);
        newElements.addAll(elements);

        return new SelectionChangedEvent((ISelectionProvider) event.getSource(),
                new StructuredSelection(newElements));
    }
}
