package ru.taximaxim.codekeeper.ui.properties;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;

import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;

public class StoragePrefListEditor extends PrefListEditor<String> {

    public StoragePrefListEditor(Composite parent) {
        super(parent);
    }

    @Override
    protected void addColumns(TableViewer tableViewer) {
        TableViewerColumn col = new TableViewerColumn(tableViewer, SWT.NONE);
        col.setLabelProvider(new ColumnLabelProvider());
    }

    @Override
    protected String getNewObject(String oldObject) {
        FileDialog fd = new FileDialog(getShell(), SWT.OPEN);
        fd.setText(Messages.StoragePrefListEditor_open_snapshot);
        String[] filterExt = {"*.ser"}; //$NON-NLS-1$
        fd.setFilterExtensions(filterExt);
        return fd.open();
    }

    @Override
    protected String errorAlreadyExists(String obj) {
        return Messages.StoragePrefListEditor_file_already_added;
    }
}
