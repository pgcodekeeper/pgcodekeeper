package ru.taximaxim.codekeeper.ui.differ;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;

import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffScript;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class Differ implements IRunnableWithProgress {

    private static final int INITIAL_BUFFER_CAPACITY = 1024;

    private final PgDatabase sourceDbFull;
    private final PgDatabase targetDbFull;
    private final TreeElement root;
    private final boolean needTwoWay;
    private final String timezone;

    private String diffDirect, diffReverse;
    private PgDiffScript script;

    private List<Entry<PgStatement, PgStatement>> additionalDepciesSource;
    private List<Entry<PgStatement, PgStatement>> additionalDepciesTarget;

    public void setAdditionalDepciesSource(
            List<Entry<PgStatement, PgStatement>> additionalDepcies) {
        this.additionalDepciesSource = additionalDepcies;
    }

    public void setAdditionalDepciesTarget(
            List<Entry<PgStatement, PgStatement>> additionalDepcies) {
        this.additionalDepciesTarget = additionalDepcies;
    }

    public void addAdditionalDepciesSource(
            List<Entry<PgStatement, PgStatement>> additionalDepcies) {
        if (this.additionalDepciesSource == null) {
            setAdditionalDepciesSource(additionalDepcies);
        } else {
            this.additionalDepciesSource.addAll(additionalDepcies);
        }
    }

    public List<Entry<PgStatement, PgStatement>> getAdditionalDepciesSource() {
        return additionalDepciesSource;
    }

    public Differ(PgDatabase sourceDbFull, PgDatabase targetDbFull,
            TreeElement root, boolean needTwoWay, String timezone) {
        this.sourceDbFull = sourceDbFull;
        this.targetDbFull = targetDbFull;
        this.root = root;
        this.needTwoWay = needTwoWay;
        this.timezone = timezone;
    }

    public Job getDifferJob() {
        return new Job(Messages.differ_get_differ) {

            @Override
            protected IStatus run(IProgressMonitor monitor) {
                try {
                    Differ.this.run(monitor);
                } catch (InvocationTargetException e) {
                    return new Status(Status.ERROR, PLUGIN_ID.THIS,
                            Messages.error_in_the_project_modifier_thread, e);
                } catch (InterruptedException e) {
                    return Status.CANCEL_STATUS;
                }
                return Status.OK_STATUS;
            }
        };
    }

    public String getDiffDirect() {
        if (diffDirect == null) {
            throw new IllegalStateException(Messages.runnable_has_not_finished);
        }
        return diffDirect;
    }

    public String getDiffReverse() {
        if (diffReverse == null) {
            throw new IllegalStateException(Messages.runnable_has_not_finished);
        }
        return diffReverse;
    }

    public PgDiffScript getScript() {
        if (script == null) {
            throw new IllegalStateException(Messages.runnable_has_not_finished);
        }
        return script;
    }

    public String getTimezone() {
        return timezone;
    }

    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException,
    InterruptedException {
        SubMonitor pm = SubMonitor.convert(monitor, Messages.calculating_diff, 100); // 0

        Log.log(Log.LOG_INFO, "Diff from: " + sourceDbFull.getName() //$NON-NLS-1$
        + " to: " + targetDbFull.getName()); //$NON-NLS-1$

        pm.newChild(25).subTask(Messages.differ_direct_diff); // 75
        ByteArrayOutputStream diffOut = new ByteArrayOutputStream(INITIAL_BUFFER_CAPACITY);
        try {
            PrintWriter writer = new UnixPrintWriter(
                    new OutputStreamWriter(diffOut, StandardCharsets.UTF_8), true);
            script = PgDiff.diffDatabaseSchemasAdditionalDepcies(writer,
                    // forceUnixNewLines has no effect on diff operaiton, just pass true
                    DbSource.getPgDiffArgs(ApgdiffConsts.UTF_8, timezone, true),
                    root,
                    sourceDbFull, targetDbFull,
                    additionalDepciesSource, additionalDepciesTarget);
            writer.flush();
            diffDirect = new String(diffOut.toByteArray(), StandardCharsets.UTF_8).trim();

            if (needTwoWay) {
                Log.log(Log.LOG_INFO, "Diff from: " + targetDbFull.getName() //$NON-NLS-1$
                + " to: " + sourceDbFull.getName()); //$NON-NLS-1$

                pm.newChild(25).subTask(Messages.differ_reverse_diff); // 100
                diffOut.reset();
                PgDiff.diffDatabaseSchemasAdditionalDepcies(writer,
                        DbSource.getPgDiffArgs(ApgdiffConsts.UTF_8, timezone, true),
                        root.getRevertedCopy(),
                        targetDbFull, sourceDbFull,
                        additionalDepciesTarget, additionalDepciesSource);
                writer.flush();
                diffReverse = new String(diffOut.toByteArray(), StandardCharsets.UTF_8).trim();
            }
        } catch (IOException ex) {
            throw new InvocationTargetException(ex, ex.getLocalizedMessage());
        }

        PgDiffUtils.checkCancelled(pm);
        monitor.done();
    }
}
