package ru.taximaxim.codekeeper.ui.views;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;

import ru.taximaxim.codekeeper.ui.differ.DbSource;

public class DepcyStructuredSelection implements IStructuredSelection {
    private DbSource dbSource;
    private DbSource dbTarget;
    private List<Object> selection;
    
    public DepcyStructuredSelection(DbSource dbSource, DbSource dbTarget, Object[] sel) {
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
        this.selection = Arrays.asList(sel);
    }
    
    @Override
    public boolean isEmpty() {
        return selection.isEmpty() || dbSource == null || dbTarget == null;
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

    public DbSource getSource(){
        return dbSource;
    }
    
    public DbSource getTarget(){
        return dbTarget;
    }
}
