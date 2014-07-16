package ru.taximaxim.codekeeper.ui.differ;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class Differ implements IRunnableWithProgress {
    
    private final DbSource dbSource, dbTarget;

    private boolean finished;
    private final boolean needTwoWay;
    private String diffDirect, diffReverse;

    private PgDatabase sourceDbFull;
    private PgDatabase targetDbFull;
    
    private List<Entry<PgStatement, PgStatement>> additionalDepcies;

    public void setFullDbs(PgDatabase sourceDbFull, PgDatabase targetDbFull) {
       this.sourceDbFull = sourceDbFull;
       this.targetDbFull = targetDbFull;
    }
    
    public void setAdditionalDepcies(
            List<Entry<PgStatement, PgStatement>> additionalDepcies) {
        this.additionalDepcies = additionalDepcies;
    }
    
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
            throw new IllegalStateException(Messages.runnable_has_not_finished);
        }
    }
    
    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException{
        SubMonitor pm = SubMonitor.convert(monitor, Messages.calculating_diff, 100); // 0
        
        PgDatabase dbSource, dbTarget;
        dbSource = dbTarget = null;
        try {
            dbSource = this.dbSource.get(pm.newChild(25)); // 25
            dbTarget = this.dbTarget.get(pm.newChild(25)); // 50
        } catch(IOException ex) {
            throw new InvocationTargetException(ex);
        }
        
        Log.log(Log.LOG_INFO, "Diff from: " + this.dbSource.getOrigin() //$NON-NLS-1$
                + " to: " + this.dbTarget.getOrigin()); //$NON-NLS-1$
        
        pm.newChild(25).subTask(Messages.differ_direct_diff); // 75
        PgDiffArguments args = new PgDiffArguments();
        ByteArrayOutputStream diffOut = new ByteArrayOutputStream(1024);
        PrintWriter writer = new UnixPrintWriter(diffOut, true);
        
        PgDiff.diffDatabaseSchemasAdditionalDepcies(writer, args,
                dbSource, dbTarget, sourceDbFull, targetDbFull, additionalDepcies);
        writer.flush();
        diffDirect = diffOut.toString().trim();

        if (needTwoWay) {
            Log.log(Log.LOG_INFO, "Diff from: " + this.dbTarget.getOrigin() //$NON-NLS-1$
                    + " to: " + this.dbSource.getOrigin()); //$NON-NLS-1$
            
            pm.newChild(25).subTask(Messages.differ_reverse_diff); // 100
            diffOut.reset();
            PgDiff.diffDatabaseSchemas(writer, args, dbTarget, dbSource, targetDbFull, sourceDbFull);
            writer.flush();
            diffReverse = diffOut.toString().trim();
        }
        pm.done();
        finished = true;
    }
}
