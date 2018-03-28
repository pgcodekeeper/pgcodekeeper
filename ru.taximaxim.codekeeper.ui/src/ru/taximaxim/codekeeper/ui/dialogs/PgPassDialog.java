package ru.taximaxim.codekeeper.ui.dialogs;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;
import ru.taximaxim.pgpass.PgPass;
import ru.taximaxim.pgpass.PgPassEntry;
import ru.taximaxim.pgpass.PgPassException;

public class PgPassDialog extends Dialog {

    private final String path;
    private TableViewer viewer;
    private final PrefListEditor<DbInfo, ListViewer> editor;

    public PgPassDialog(Shell shell, String path, PrefListEditor<DbInfo, ListViewer> editor) {
        super(shell);
        this.path = path;
        this.editor = editor;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.PgPassDialog_title);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        viewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
        viewer.setContentProvider(ArrayContentProvider.getInstance());
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 320;
        viewer.getTable().setLayoutData(gd);
        viewer.getTable().setLinesVisible(true);
        viewer.getTable().setHeaderVisible(true);

        addColumns();
        viewer.setInput(parseLines());

        return parent;
    }

    private void addColumns() {
        TableViewerColumn name = new TableViewerColumn(viewer, SWT.LEFT);
        name.getColumn().setResizable(true);
        name.getColumn().setMoveable(true);
        name.getColumn().setText(Messages.dB_name);
        name.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                PgPassEntry c = (PgPassEntry) element;
                return c.getDbName();
            }
        });

        TableViewerColumn user = new TableViewerColumn(viewer, SWT.LEFT);
        user.getColumn().setResizable(true);
        user.getColumn().setMoveable(true);
        user.getColumn().setText(Messages.dB_user);
        user.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                PgPassEntry c = (PgPassEntry) element;
                return c.getUser();
            }
        });

        TableViewerColumn host = new TableViewerColumn(viewer, SWT.LEFT);
        host.getColumn().setResizable(true);
        host.getColumn().setMoveable(true);
        host.getColumn().setText(Messages.dB_host);
        host.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                PgPassEntry c = (PgPassEntry) element;
                return c.getHost();
            }
        });

        TableViewerColumn port = new TableViewerColumn(viewer, SWT.LEFT);
        port.getColumn().setResizable(true);
        port.getColumn().setMoveable(true);
        port.getColumn().setText(Messages.dbPicker_port);
        port.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                PgPassEntry c = (PgPassEntry) element;
                return c.getPort();
            }
        });

        int width = (int)(viewer.getTable().getSize().x * 0.25);
        name.getColumn().setWidth(Math.max(width, 250));
        user.getColumn().setWidth(Math.max(width, 250));
        host.getColumn().setWidth(Math.max(width, 200));
        port.getColumn().setWidth(Math.max(width, 100));
    }

    private List<PgPassEntry> parseLines() {
        try {
            return PgPass.getAll(Paths.get(path));
        } catch (PgPassException ex) {
            Log.log(Log.LOG_ERROR, "Error reading pgpass file", ex); //$NON-NLS-1$
            return new ArrayList<>();
        }
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        Button btnImport = createButton(parent, IDialogConstants.CLIENT_ID, Messages.PgPassDialog_import, true);

        btnImport.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                PgPassEntry info = (PgPassEntry) viewer.getStructuredSelection().getFirstElement();

                if (info == null) {
                    return;
                }

                int dbport;
                try {
                    dbport = Integer.parseInt(info.getPort());
                } catch (NumberFormatException ex) {
                    dbport = 0;
                }

                editor.addNewObject(new DbInfo(info.getDbName(), info.getDbName(),
                        info.getUser(), "", info.getHost(), dbport, false, new ArrayList<>())); //$NON-NLS-1$
            }
        });

        createButton(parent, IDialogConstants.OK_ID, Messages.PgPassDialog_close, true);
    }
}
