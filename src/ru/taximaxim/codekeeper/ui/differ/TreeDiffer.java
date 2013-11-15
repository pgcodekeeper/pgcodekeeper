package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class TreeDiffer implements IRunnableWithProgress {
    
    final private DbSource dbFrom, dbTo;

    private boolean finished;
    
    private TreeElement diffTree;
    
    public DbSource getDbFrom() {
        checkFinished();
        return dbFrom;
    }
    
    public DbSource getDbTo() {
        checkFinished();
        return dbTo;
    }
    
    public TreeElement getDiffTree() {
        checkFinished();
        return diffTree;
    }
    
    public TreeDiffer(DbSource db1, DbSource db2, boolean reverse) {
        this.dbFrom = reverse? db2 : db1;
        this.dbTo = reverse? db1 : db2;
    }
    
    private void checkFinished() {
        if(!finished) {
            throw new IllegalStateException("Runnable has not yet finished!"
                    + " diff is undefined!");
        }
    }
    
    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException {
        SubMonitor pm = SubMonitor.convert(monitor, "Calculating diff", 100); // 0
        
        PgDatabase dbFrom, dbTo;
        dbFrom = dbTo = null;
        try {
            dbFrom = this.dbFrom.get(pm.newChild(33)); // 33
            dbTo = this.dbTo.get(pm.newChild(33)); // 66
        } catch(IOException ex) {
            throw new InvocationTargetException(ex);
        }
        
        pm.newChild(34).subTask("Building diff tree"); // 100
        diffTree = DiffTree.create(dbFrom, dbTo);
        
        monitor.done();
        finished = true;
    }
}
