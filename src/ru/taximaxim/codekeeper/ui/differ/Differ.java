package ru.taximaxim.codekeeper.ui.differ;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.UnixPrintWriter;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class Differ implements IRunnableWithProgress {
    
    final private DbSource db1, db2;

    private boolean finished;
    
    private String diff;
    
    public Differ(DbSource db1, DbSource db2, boolean reverse) {
        this.db1 = reverse? db2 : db1;
        this.db2 = reverse? db1 : db2;
    }
    
    public String getDiff() {
        if(!finished) {
            throw new IllegalStateException("Runnable has not yet finished!"
                    + " diff is undefined!");
        }
        return diff;
    }
    
    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException {
        SubMonitor pm = SubMonitor.convert(monitor, "Calculating diff", 100); // 0
        
        PgDatabase db1, db2;
        db1 = db2 = null;
        try {
            db1 = this.db1.get(pm.newChild(33)); // 33
            db2 = this.db2.get(pm.newChild(33)); // 66
        } catch(IOException ex) {
            throw new InvocationTargetException(ex);
        }
        
        pm.newChild(34).subTask("Comparing schemas"); // 100
        PgDiffArguments args = new PgDiffArguments();
        ByteArrayOutputStream diffOut = new ByteArrayOutputStream(1024);
        PrintWriter writer = new UnixPrintWriter(diffOut, true);
        
        PgDiff.diffDatabaseSchemas(writer, args, db1, db2);
        
        writer.flush();
        diff = diffOut.toString().trim();
        
        monitor.done();
        finished = true;
    }
}
