package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class TreeDiffer implements IRunnableWithProgress {
    
    final private DbSource dbSource, dbTarget;

    private boolean finished;
    
    private TreeElement diffTree;
    
    public DbSource getDbSource() {
        checkFinished();
        return dbSource;
    }
    
    public DbSource getDbTarget() {
        checkFinished();
        return dbTarget;
    }
    
    public TreeElement getDiffTree() {
        checkFinished();
        return diffTree;
    }
    
    public TreeDiffer(DbSource dbSource, DbSource dbTarget) {
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
    }
    
    private void checkFinished() {
        if(!finished) {
            throw new IllegalStateException("Runnable has not yet finished!"
                    + " diff is undefined!");
        }
    }
    
    @Override
    public void run(IProgressMonitor monitor) {
        SubMonitor pm = SubMonitor.convert(monitor, "Calculating diff", 100); // 0
        
        PgDatabase dbSource, dbTarget;
        dbSource = dbTarget = null;
        try {
            dbSource = this.dbSource.get(pm.newChild(33)); // 33
            dbTarget = this.dbTarget.get(pm.newChild(33)); // 66
        } catch(IOException ex) {
            throw new IllegalStateException(ex);
        }
        
        pm.newChild(34).subTask("Building diff tree..."); // 100
        diffTree = DiffTree.create(dbSource, dbTarget);
        
        monitor.done();
        finished = true;
    }
}
