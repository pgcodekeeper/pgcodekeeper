package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import java.text.MessageFormat;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.YesNoEditingSupport.YesNoValues;

public class IgnoredObjectPrefListEditor extends PrefListEditor<IgnoredObject, TableViewer> {

    enum BooleanChangeValues {
        REGULAR(1<<0),
        IGNORE_CONTENT(1<<1);

        private final int statusFlagValue;

        BooleanChangeValues(int statusFlagValue) {
            this.statusFlagValue = statusFlagValue;
        }

        public int getStatusFlagValue(){
            return statusFlagValue;
        }
    }

    public IgnoredObjectPrefListEditor(Composite parent, boolean doSorting, boolean noMargins) {
        super(parent, doSorting, false, noMargins);
    }

    @Override
    protected IgnoredObject getNewObject(IgnoredObject oldObject) {
        NewIgnoredObjectDialog d = new NewIgnoredObjectDialog(getShell(), oldObject);
        return d.open() == NewIgnoredObjectDialog.OK ? d.getIgnoredObject() : null;
    }

    @Override
    protected String errorAlreadyExists(IgnoredObject obj) {
        return MessageFormat.format(
                Messages.IgnoredObjectPrefListEditor_already_present, obj.getName());
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
        name.getColumn().setText(Messages.ignoredObjectPrefListEditor_name);
        name.getColumn().setResizable(true);
        name.getColumn().setMoveable(true);
        name.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                IgnoredObject obj = (IgnoredObject) element;
                return obj.getName();
            }
        });

        TableViewerColumn isRegular = new TableViewerColumn(tableViewer, SWT.CHECK);
        isRegular.getColumn().setResizable(true);
        isRegular.getColumn().setText(Messages.ignoredObjectPrefListEditor_regular);
        isRegular.getColumn().setResizable(false);
        isRegular.getColumn().setMoveable(true);
        isRegular.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                IgnoredObject obj = (IgnoredObject) element;
                return obj.isRegular()? YesNoValues.YES.toString() : YesNoValues.NO.toString();
            }
        });
        isRegular.setEditingSupport(new YesNoEditingSupport(tableViewer, BooleanChangeValues.REGULAR));

        TableViewerColumn ignoreContents = new TableViewerColumn(tableViewer, SWT.CHECK);
        ignoreContents.getColumn().setResizable(true);
        ignoreContents.getColumn().setText(Messages.ignoredObjectPrefListEditor_ignore_contents);
        ignoreContents.getColumn().setResizable(false);
        ignoreContents.getColumn().setMoveable(true);
        ignoreContents.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                IgnoredObject obj = (IgnoredObject) element;
                return obj.isIgnoreContent()? YesNoValues.YES.toString() : YesNoValues.NO.toString();
            }
        });
        ignoreContents.setEditingSupport(new YesNoEditingSupport(tableViewer, BooleanChangeValues.IGNORE_CONTENT));

        // name column will take half of the space
        int width = (int)(tableViewer.getTable().getSize().x * 0.5);
        // not less than 200
        name.getColumn().setWidth(Math.max(width, 200));

        PixelConverter pc = new PixelConverter(tableViewer.getControl());
        isRegular.getColumn().setWidth(pc.convertWidthInCharsToPixels(10));
        ignoreContents.getColumn().setWidth(pc.convertWidthInCharsToPixels(11));
    }
}

class NewIgnoredObjectDialog extends InputDialog {

    private final IgnoredObject objInitial;
    private IgnoredObject ignoredObject;
    private Button btnPattern, btnContent;

    public IgnoredObject getIgnoredObject() {
        return ignoredObject;
    }

    public NewIgnoredObjectDialog(Shell shell, IgnoredObject objInitial) {
        super(shell, Messages.IgnoredObjectPrefListEditor_new_ignored, Messages.IgnoredObjectPrefListEditor_object_name,
                objInitial == null ? null : objInitial.getName(),
                        new IInputValidator() {

            @Override
            public String isValid(String newText) {
                return newText.isEmpty() ? Messages.IgnoredObjectPrefListEditor_enter_name : null;
            }
        });
        this.objInitial = objInitial;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        Composite c = new Composite(composite, SWT.NONE);
        c.setLayout(new GridLayout(2,  false));
        c.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        btnPattern = new Button(c, SWT.CHECK);
        btnPattern.setText(Messages.IgnoredObjectPrefListEditor_pattern);

        btnContent = new Button(c, SWT.CHECK);
        btnContent.setText(Messages.IgnoredObjectPrefListEditor_contents);

        if (objInitial != null) {
            btnPattern.setSelection(objInitial.isRegular());
            btnContent.setSelection(objInitial.isIgnoreContent());
        }

        return composite;
    }

    @Override
    protected void okPressed() {
        ignoredObject = new IgnoredObject(getValue(), btnPattern.getSelection(), btnContent.getSelection());
        super.okPressed();
    }
}
