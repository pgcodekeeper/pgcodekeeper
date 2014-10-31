package ru.taximaxim.codekeeper.ui.editors;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;

import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyGraph;

public class DepcyStructuredSelection implements IStructuredSelection {
    private DepcyGraph dg;
    private List<Object> selection;
    
    public DepcyStructuredSelection(DepcyGraph dg, Object[] sel) {
        this.dg = dg;
        this.selection = Arrays.asList(sel);
    }
    
    @Override
    public boolean isEmpty() {
        return selection.isEmpty() || dg == null;
    }

    @Override
    public Object getFirstElement() {
        return selection.isEmpty() ? null : selection.get(0);
    }

    @Override
    public Iterator<Object> iterator() {
        return selection.iterator();
    }

    @Override
    public int size() {
        return selection.size();
    }

    @Override
    public Object[] toArray() {
        return (Object[]) selection.toArray(new Object[selection.size()]);
    }

    @Override
    public List<Object> toList() {
        return selection;
    }

    public DepcyGraph getDepcyGraph(){
        return dg;
    }
}
