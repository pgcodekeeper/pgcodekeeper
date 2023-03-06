package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import java.util.EnumSet;
import java.util.Iterator;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class NewIgnoredObjectDialog extends InputDialog {

    // TODO add possibility to select several types in GUI
    // (in parsing logic it is already done)
    private final IgnoredObject objInitial;
    private IgnoredObject ignoredObject;
    private Button btnPattern;
    private Button btnContent;
    private Button btnQualified;
    private ComboViewer comboType;
    private final boolean isIgnoreSchemaList;

    public IgnoredObject getIgnoredObject() {
        return ignoredObject;
    }

    public NewIgnoredObjectDialog(Shell shell, IgnoredObject objInitial, boolean isIgnoreSchemaList) {
        super(shell, Messages.IgnoredObjectPrefListEditor_new_ignored, Messages.IgnoredObjectPrefListEditor_object_name,
                objInitial == null ? null : objInitial.getName(),
                        text ->  text.isEmpty() ? Messages.IgnoredObjectPrefListEditor_enter_name : null);
        this.objInitial = objInitial;
        this.isIgnoreSchemaList = isIgnoreSchemaList;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        Composite c = new Composite(composite, SWT.NONE);
        c.setLayout(new GridLayout());
        c.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        if (!isIgnoreSchemaList) {
            Label label = new Label(c, SWT.LEFT);
            label.setText(Messages.ignoredObjectPrefListEditor_type);

            comboType = new ComboViewer(c, SWT.READ_ONLY);
            comboType.setContentProvider(ArrayContentProvider.getInstance());
            comboType.setInput(TypesEditingSupport.comboTypes());
            comboType.setContentProvider(ArrayContentProvider.getInstance());
            comboType.setSelection(new StructuredSelection(TypesEditingSupport.COMBO_TYPE_ALL));
        }

        btnPattern = new Button(c, SWT.CHECK);
        btnPattern.setText(Messages.IgnoredObjectPrefListEditor_pattern);

        if (!isIgnoreSchemaList) {
            btnContent = new Button(c, SWT.CHECK);
            btnContent.setText(Messages.IgnoredObjectPrefListEditor_contents);

            btnQualified = new Button(c, SWT.CHECK);
            btnQualified.setText(Messages.IgnoredObjectPrefListEditor_qualified_name);

            if (objInitial != null) {
                btnContent.setSelection(objInitial.isIgnoreContent());
                btnContent.setSelection(objInitial.isQualified());
                btnPattern.setSelection(objInitial.isRegular());

                Iterator<DbObjType> iterator = objInitial.getObjTypes().iterator();
                if (iterator.hasNext()) {
                    comboType.setSelection(new StructuredSelection(iterator.next()));
                }
            }
        }
        return composite;
    }

    @Override
    protected void okPressed() {
        String selectedType = isIgnoreSchemaList ? TypesEditingSupport.COMBO_TYPE_ALL
                : (String) ((StructuredSelection) comboType.getSelection()).getFirstElement();

        ignoredObject = new IgnoredObject(getValue(), btnPattern.getSelection(),
                (!isIgnoreSchemaList && btnContent.getSelection()),
                (!isIgnoreSchemaList && btnQualified.getSelection()),
                TypesEditingSupport.COMBO_TYPE_ALL.equals(selectedType) ?
                        EnumSet.noneOf(DbObjType.class) : EnumSet.of(DbObjType.valueOf(selectedType)));
        super.okPressed();
    }
}

