package ru.taximaxim.codekeeper.ui.views;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

import ru.taximaxim.codekeeper.ui.differ.DbSource;

public class DepcyStructuredSelection extends StructuredSelection {
    
    private final DbSource dbSource;
    private final DbSource dbTarget;
    
    public DepcyStructuredSelection(DbSource dbSource, DbSource dbTarget,
            IStructuredSelection sel) {
        super(sel.toList());
        
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
    }
    
    public DbSource getSource(){
        return dbSource;
    }
    
    public DbSource getTarget(){
        return dbTarget;
    }
}
