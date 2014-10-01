package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

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
            ExceptionNotifier.showErrorDialog(Messages.runnable_has_not_finished, null);
            throw new IllegalStateException(Messages.runnable_has_not_finished);
        }
    }
    
    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException{
        SubMonitor pm = SubMonitor.convert(monitor, Messages.calculating_diff, 100); // 0
        
        PgDatabase dbSource, dbTarget;
        dbSource = dbTarget = null;
        try {
            dbSource = this.dbSource.get(pm.newChild(33)); // 33
            dbTarget = this.dbTarget.get(pm.newChild(33)); // 66
        } catch(IOException ex) {
            ExceptionNotifier.showErrorDialog("", ex);
            throw new InvocationTargetException(ex);
        }
        
        Log.log(Log.LOG_INFO, "Generating diff tree between src: " + this.dbSource.getOrigin() //$NON-NLS-1$
                + " tgt: " + this.dbTarget.getOrigin()); //$NON-NLS-1$
        
        pm.newChild(34).subTask(Messages.treeDiffer_building_diff_tree); // 100
        diffTree = DiffTree.create(dbSource, dbTarget);
        
        pm.done();
        finished = true;
    }
}
