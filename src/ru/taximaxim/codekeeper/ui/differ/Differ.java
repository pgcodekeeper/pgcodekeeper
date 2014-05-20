package ru.taximaxim.codekeeper.ui.differ;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import ru.taximaxim.codekeeper.ui.Log;
import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.UnixPrintWriter;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class Differ implements IRunnableWithProgress {
    
    final private DbSource dbSource, dbTarget;

    private boolean finished;
    
    private String diffDirect, diffReverse;

    private PgStatement sourceDbFull = null;
    private PgStatement targetDbFull = null;
    
    public Differ(DbSource dbSource, DbSource dbTarget) {
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
    }
    
    public String getDiffDirect() {
        checkFinished();
        return diffDirect;
    }
    
    public String getDiffReverse() {
        checkFinished();
        return diffReverse;
    }
    
    private void checkFinished() {
        if(!finished) {
            throw new IllegalStateException("Runnable has not yet finished!"
                    + " diff is undefined!");
        }
    }
    
    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException{
        SubMonitor pm = SubMonitor.convert(monitor, "Calculating diff", 100); // 0
        
        PgDatabase dbSource, dbTarget;
        dbSource = dbTarget = null;
        try {
            dbSource = this.dbSource.get(pm.newChild(25)); // 25
            dbTarget = this.dbTarget.get(pm.newChild(25)); // 50
        } catch(IOException ex) {
            throw new InvocationTargetException(ex);
        }
        
        Log.log(Log.LOG_INFO, "Diff from: " + this.dbSource.getOrigin()
                + " to: " + this.dbTarget.getOrigin());
        
        pm.newChild(25).subTask("Direct diff..."); // 75
        PgDiffArguments args = new PgDiffArguments();
        ByteArrayOutputStream diffOut = new ByteArrayOutputStream(1024);
        PrintWriter writer = new UnixPrintWriter(diffOut, true);
        
        PgDiff.diffDatabaseSchemas(writer, args, dbSource, dbTarget, sourceDbFull, targetDbFull);
        writer.flush();
        diffDirect = diffOut.toString().trim();

        Log.log(Log.LOG_INFO, "Diff from: " + this.dbTarget.getOrigin()
                + " to: " + this.dbSource.getOrigin());
        
        pm.newChild(25).subTask("Reverse diff..."); // 100
        diffOut.reset();
        PgDiff.diffDatabaseSchemas(writer, args, dbTarget, dbSource, targetDbFull, sourceDbFull);
        writer.flush();
        diffReverse = diffOut.toString().trim();
        
        monitor.done();
        finished = true;
    }

    public void setFullDbs(PgDatabase sourceDbFull, PgDatabase targetDbFull) {
       this.sourceDbFull = sourceDbFull;
       this.targetDbFull = targetDbFull;
    }
}
