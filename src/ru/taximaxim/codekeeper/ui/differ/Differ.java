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
    
    private final DbSource dbSource, dbTarget;

    private boolean finished;
    private final boolean needTwoWay;
    private String diffDirect, diffReverse;

    private PgStatement sourceDbFull;
    private PgStatement targetDbFull;
    
    public Differ(DbSource dbSource, DbSource dbTarget, boolean needTwoWay) {
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
        this.needTwoWay = needTwoWay;
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
            throw new IllegalStateException(Messages.Differ_runnable_has_not_finished
                    + Messages.Differ_diff_is_undefined);
        }
    }
    
    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException{
        SubMonitor pm = SubMonitor.convert(monitor, Messages.Differ_calculating_diff, 100); // 0
        
        PgDatabase dbSource, dbTarget;
        dbSource = dbTarget = null;
        try {
            dbSource = this.dbSource.get(pm.newChild(25)); // 25
            dbTarget = this.dbTarget.get(pm.newChild(25)); // 50
        } catch(IOException ex) {
            throw new InvocationTargetException(ex);
        }
        
        Log.log(Log.LOG_INFO, Messages.Differ_diff_from + this.dbSource.getOrigin()
                + Messages.Differ_to + this.dbTarget.getOrigin());
        
        pm.newChild(25).subTask(Messages.Differ_direct_diff); // 75
        PgDiffArguments args = new PgDiffArguments();
        ByteArrayOutputStream diffOut = new ByteArrayOutputStream(1024);
        PrintWriter writer = new UnixPrintWriter(diffOut, true);
        
        PgDiff.diffDatabaseSchemas(writer, args, dbSource, dbTarget, sourceDbFull, targetDbFull);
        writer.flush();
        diffDirect = diffOut.toString().trim();

        if (needTwoWay) {
            Log.log(Log.LOG_INFO, Messages.Differ_diff_from + this.dbTarget.getOrigin()
                    + Messages.Differ_to + this.dbSource.getOrigin());
            
            pm.newChild(25).subTask(Messages.Differ_reverse_diff); // 100
            diffOut.reset();
            PgDiff.diffDatabaseSchemas(writer, args, dbTarget, dbSource, targetDbFull, sourceDbFull);
            writer.flush();
            diffReverse = diffOut.toString().trim();
        }
        monitor.done();
        finished = true;
    }

    public void setFullDbs(PgDatabase sourceDbFull, PgDatabase targetDbFull) {
       this.sourceDbFull = sourceDbFull;
       this.targetDbFull = targetDbFull;
    }
}
