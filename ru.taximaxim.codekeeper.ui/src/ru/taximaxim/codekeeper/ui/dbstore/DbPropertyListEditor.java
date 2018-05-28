package ru.taximaxim.codekeeper.ui.dbstore;

import java.text.MessageFormat;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;

public class DbPropertyListEditor extends PrefListEditor<Entry<String, String>, TableViewer> {

    private static String LINK_HINT = "https://jdbc.postgresql.org/documentation/head/connect.html";

    public static DbPropertyListEditor create(Composite parent) {
        return new DbPropertyListEditor(createComposite(parent));
    }

    private static Composite createComposite(Composite composite) {

        new Label(composite, SWT.NONE).setText(Messages.DbPropertyListEditor_properties_hint);

        Link linkHint = new Link(composite, SWT.NONE);
        linkHint.setText("<a href=\"" + LINK_HINT +  "\">" + LINK_HINT + "</a>");
        linkHint.addSelectionListener(new SelectionAdapter()  {

            @Override
            public void widgetSelected(SelectionEvent e) {
                Program.launch(LINK_HINT);
            }

        });

        return composite;
    }

    private DbPropertyListEditor(Composite parent) {
        super(parent);
    }

    @Override
    protected Entry<String, String> getNewObject(Entry<String, String> oldObject) {
        NewDbPropertyDialog d = new NewDbPropertyDialog(getShell(), oldObject);
        return d.open() == NewDbPropertyDialog.OK ? d.getProperty() : null;
    }

    @Override
    protected String errorAlreadyExists(Entry<String, String> obj) {
        return MessageFormat.format(
                Messages.DbPropertyListEditor_already_present, obj.getKey());
    }

    @Override
    protected TableViewer createViewer(Composite parent) {
        TableViewer viewer = new TableViewer(
                parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
        viewer.setContentProvider(ArrayContentProvider.getInstance());

        addColumns(viewer);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2);
        gd.widthHint = PREF_PAGE.WIDTH_HINT_PX;
        viewer.getTable().setLayoutData(gd);
        viewer.getTable().setLinesVisible(true);
        viewer.getTable().setHeaderVisible(true);
        return viewer;
    }

    private void addColumns(TableViewer tableViewer) {
        TableViewerColumn name = new TableViewerColumn(tableViewer, SWT.NONE);
        name.getColumn().setResizable(true);
        name.getColumn().setText(Messages.DbPropertyListEditor_tbl_col_name);
        name.getColumn().setMoveable(true);
        name.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                Entry<String, String> obj = (Entry<String, String>) element;
                return obj.getKey();
            }
        });

        TableViewerColumn value = new TableViewerColumn(tableViewer, SWT.NONE);
        value.getColumn().setResizable(true);
        value.getColumn().setText(Messages.DbPropertyListEditor_tbl_col_value);
        value.getColumn().setMoveable(true);
        value.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                Entry<String, String> obj = (Entry<String, String>) element;
                return obj.getValue();
            }
        });

        // TODO add value.setEditingSupport(new SomeEditingSupport(tableViewer));

        // name column will take half of the space
        int width = (int)(tableViewer.getTable().getSize().x * 0.5);
        // not less than 200
        name.getColumn().setWidth(Math.max(width, 150));

        PixelConverter pc = new PixelConverter(tableViewer.getControl());
        value.getColumn().setWidth(pc.convertWidthInCharsToPixels(28));
    }
}

class NewDbPropertyDialog extends Dialog {

    private final Entry<String, String> objInitial;
    private Entry<String, String> property;
    private Text txtPropertyName;
    private Text txtPropertyValue;

    public Entry<String, String> getProperty() {
        return property;
    }

    public NewDbPropertyDialog(Shell shell, Entry<String, String> objInitial) {
        super(shell);
        this.objInitial = objInitial;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        Composite c = new Composite(composite, SWT.NONE);
        c.setLayout(new GridLayout(2,  false));
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.widthHint = 600;
        c.setLayoutData(gd);

        new Label(c, SWT.LEFT).setText(Messages.DbPropertyListEditor_field_name);

        txtPropertyName = new Text(c, SWT.NONE);
        txtPropertyName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(c, SWT.LEFT).setText(Messages.DbPropertyListEditor_field_value);

        txtPropertyValue = new Text(c, SWT.NONE);
        txtPropertyValue.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        if (objInitial != null) {
            txtPropertyName.setText(objInitial.getKey());
            txtPropertyValue.setText(objInitial.getValue());
        }

        return composite;
    }

    @Override
    protected void okPressed() {
        property = new SimpleEntry<>(txtPropertyName.getText(), txtPropertyValue.getText());
        super.okPressed();
    }

    @Override
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setText(Messages.DbPropertyListEditor_new_property);
    }

    @Override
    protected boolean isResizable() {
        return true;
    }
}
