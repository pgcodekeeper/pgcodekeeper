package ru.taximaxim.codekeeper.ui.properties;

import java.text.MessageFormat;
import java.util.EnumSet;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;

public class IgnoredSchemaListEditorProperties extends PrefListEditor<IgnoredObject> {

    public static IgnoredSchemaListEditorProperties create(Composite parent, IgnoreSchemaList ignoreList) {
        fillComposite(parent, ignoreList);
        return new IgnoredSchemaListEditorProperties(parent);
    }

    private static void fillComposite(Composite composite, IgnoreSchemaList ignoreList) {
        Label descriptionLabel = new Label(composite, SWT.NONE);
        descriptionLabel.setText(Messages.IgnoredSchemaPrefListEditor_schema_ignor);

        Composite compositeRadio = new Composite(composite, SWT.NONE);
        GridLayout gridRadioLayout = new GridLayout(2, false);
        gridRadioLayout.marginHeight = 0;
        gridRadioLayout.marginWidth = 0;
        compositeRadio.setLayout(gridRadioLayout);
        compositeRadio.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

        Button btnIsBlack = new Button (compositeRadio, SWT.RADIO);

        btnIsBlack.setText (Messages.IgnoredObjectsPrefPage_convert_to_black_list);
        btnIsBlack.setSelection(ignoreList.isShow());
        btnIsBlack.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                ignoreList.setShow(true);
                descriptionLabel.setText(Messages.IgnoredSchemaPrefListEditor_black_list_schema_ignor);
                composite.layout();
            }
        });

        Button btnIsWhite = new Button(compositeRadio, SWT.RADIO);
        btnIsWhite.setText(Messages.IgnoredObjectsPrefPage_convert_to_white_list);
        btnIsWhite.setSelection(!ignoreList.isShow());
        btnIsWhite.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                ignoreList.setShow(false);
                descriptionLabel.setText(Messages.IgnoredSchemaPrefListEditor_white_list_schema_ignor);
                composite.layout();
            }
        });
    }

    private IgnoredSchemaListEditorProperties(Composite parent) {
        super(parent);
    }

    @Override
    protected IgnoredObject getNewObject(IgnoredObject oldObject) {
        InputDialog d = new InputDialog(getShell(),
                Messages.IgnoredObjectPrefListEditor_new_ignored,
                Messages.IgnoredSchemaPrefListEditor_schema_name,
                null, text ->  text.isEmpty() ? Messages.IgnoredSchemaPrefListEditor_add_schema : null);
        return d.open() == Window.OK ? (new IgnoredObject(d.getValue(), false,
                true, true,
                EnumSet.of(DbObjType.SCHEMA))) : null;
    }

    @Override
    protected String errorAlreadyExists(IgnoredObject obj) {
        return MessageFormat.format(
                Messages.IgnoredObjectPrefListEditor_already_present, obj.getName());
    }

    @Override
    protected void addColumns(TableViewer tableViewer) {
        TableViewerColumn name = new TableViewerColumn(tableViewer, SWT.NONE);
        name.getColumn().setResizable(true);
        name.getColumn().setText(Messages.ignoredObjectPrefListEditor_name);
        name.getColumn().setMoveable(true);
        name.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                IgnoredObject obj = (IgnoredObject) element;
                return obj.getName();
            }
        });

        // name column will take half of the space
        int width = (int)(tableViewer.getTable().getSize().x * 0.5);
        // not less than 200
        name.getColumn().setWidth(Math.max(width, 150));
    }
}
