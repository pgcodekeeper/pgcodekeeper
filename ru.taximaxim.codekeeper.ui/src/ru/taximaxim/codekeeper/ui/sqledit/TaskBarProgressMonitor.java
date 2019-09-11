package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ProgressMonitorWrapper;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TaskBar;
import org.eclipse.swt.widgets.TaskItem;

import ru.taximaxim.codekeeper.ui.UiSync;

public class  TaskBarProgressMonitor extends ProgressMonitorWrapper {

    private final int batchCount;

    private int progressState;
    private TaskItem item;

    public TaskBarProgressMonitor(IProgressMonitor monitor, int batchCount, Composite shell) {
        super(monitor);
        this.batchCount = batchCount;

        UiSync.exec(shell, () -> {
            if (!shell.isDisposed()) {
                item = getTaskBarItem(shell);
            }
        });
    }

    public TaskBarProgressMonitor(SubMonitor monitor, int batchCount, Display display) {
        super(monitor);
        this.batchCount = batchCount;

        UiSync.exec(display, () -> {
            if (!display.isDisposed()) {
                item = getTaskBarItem(display.getActiveShell());
            }
        });
    }

    private TaskItem getTaskBarItem(Composite composite) {
        TaskBar bar = composite.getDisplay().getSystemTaskBar();
        if (bar == null) {
            return null;
        }
        TaskItem item = bar.getItem(composite.getShell());
        if (item == null) {
            item = bar.getItem(null);
        }
        return item;
    }

    @Override
    public void done() {
        super.done();
        if (item == null) {
            return;
        }

        UiSync.exec(item, () -> {
            if (!item.isDisposed()) {
                item.setProgressState(SWT.DEFAULT);
            }
        });
    }

    @Override
    public void worked(int work) {
        super.worked(work);
        if (item == null) {
            return;
        }

        UiSync.exec(item, () -> {
            if (!item.isDisposed()) {
                item.setProgress(++progressState * 100 / batchCount);
                item.setProgressState(SWT.NORMAL);
            }
        });
    }
}