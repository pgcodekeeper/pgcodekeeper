package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import java.text.MessageFormat;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.StructuredSelection;
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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;

public class IgnoredObjectPrefListEditor extends PrefListEditor<IgnoredObject> {

    enum BooleanChangeValues {
        REGULAR, IGNORE_CONTENT, QUALIFIED;
    }

    public static IgnoredObjectPrefListEditor create(Composite parent, IgnoreList ignoreList) {
        fillComposite(parent, ignoreList);
        return new IgnoredObjectPrefListEditor(parent);
    }

    private static void fillComposite(Composite composite, IgnoreList ignoreList) {
        Label descriptionLabel = new Label(composite, SWT.NONE);
        descriptionLabel.setText(Messages.IgnoredObjectsPrefPage_these_objects_are_ignored_info);

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
                descriptionLabel.setText(Messages.IgnoredObjectsPrefPage_these_objects_are_ignored_info);
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
                descriptionLabel.setText(Messages.IgnoredObjectsPrefPage_these_objects_are_ignored_info_white);
                composite.layout();
            }
        });
    }

    private IgnoredObjectPrefListEditor(Composite parent) {
        super(parent);
    }

    @Override
    protected IgnoredObject getNewObject(IgnoredObject oldObject) {
        NewIgnoredObjectDialog d = new NewIgnoredObjectDialog(getShell(), oldObject);
        return d.open() == Window.OK ? d.getIgnoredObject() : null;
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
        name.setEditingSupport(new TxtNameEditingSupport(tableViewer, this));

        String ballotBoxWithCheck = "\u2611"; //$NON-NLS-1$
        String ballotBox = "\u2610"; //$NON-NLS-1$

        TableViewerColumn isRegular = new TableViewerColumn(tableViewer, SWT.CENTER);
        isRegular.getColumn().setResizable(true);
        isRegular.getColumn().setText(Messages.ignoredObjectPrefListEditor_regular);
        isRegular.getColumn().setMoveable(true);
        isRegular.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                return ((IgnoredObject)element).isRegular() ? ballotBoxWithCheck : ballotBox;
            }
        });
        isRegular.setEditingSupport(new CheckEditingSupport(tableViewer, BooleanChangeValues.REGULAR));

        TableViewerColumn ignoreContents = new TableViewerColumn(tableViewer, SWT.CENTER);
        ignoreContents.getColumn().setResizable(true);
        ignoreContents.getColumn().setText(Messages.ignoredObjectPrefListEditor_ignore_contents);
        ignoreContents.getColumn().setMoveable(true);
        ignoreContents.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                return ((IgnoredObject)element).isIgnoreContent() ? ballotBoxWithCheck : ballotBox;
            }
        });
        ignoreContents.setEditingSupport(new CheckEditingSupport(tableViewer, BooleanChangeValues.IGNORE_CONTENT));

        TableViewerColumn isQualified = new TableViewerColumn(tableViewer, SWT.CENTER);
        isQualified.getColumn().setResizable(true);
        isQualified.getColumn().setText(Messages.IgnoredObjectPrefListEditor_qualified);
        isQualified.getColumn().setMoveable(true);
        isQualified.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                return ((IgnoredObject) element).isQualified() ? ballotBoxWithCheck : ballotBox;
            }
        });
        isQualified.setEditingSupport(new CheckEditingSupport(tableViewer, BooleanChangeValues.QUALIFIED));

        TableViewerColumn objType = new TableViewerColumn(tableViewer, SWT.NONE);
        objType.getColumn().setResizable(true);
        objType.getColumn().setText(Messages.ignoredObjectPrefListEditor_type);
        objType.getColumn().setMoveable(true);
        objType.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                IgnoredObject obj = (IgnoredObject) element;
                Set<DbObjType> typesList = obj.getObjTypes();
                return typesList.isEmpty() ? TypesEditingSupport.COMBO_TYPE_ALL
                        : typesList.iterator().next().toString();
            }
        });
        objType.setEditingSupport(new TypesEditingSupport(tableViewer));

        // name column will take half of the space
        int width = (int)(tableViewer.getTable().getSize().x * 0.5);
        // not less than 200
        name.getColumn().setWidth(Math.max(width, 150));

        PixelConverter pc = new PixelConverter(tableViewer.getControl());
        isRegular.getColumn().setWidth(pc.convertWidthInCharsToPixels(10));
        ignoreContents.getColumn().setWidth(pc.convertWidthInCharsToPixels(28));
        isQualified.getColumn().setWidth(pc.convertWidthInCharsToPixels(18));
        objType.getColumn().setWidth(pc.convertWidthInCharsToPixels(10));
    }
}

class NewIgnoredObjectDialog extends InputDialog {

    // TODO add possibility to select several types in GUI
    // (in parsing logic it is already done)
    private final IgnoredObject objInitial;
    private IgnoredObject ignoredObject;
    private Button btnPattern;
    private Button btnContent;
    private Button btnQualified;
    private ComboViewer comboType;

    public IgnoredObject getIgnoredObject() {
        return ignoredObject;
    }

    public NewIgnoredObjectDialog(Shell shell, IgnoredObject objInitial) {
        super(shell, Messages.IgnoredObjectPrefListEditor_new_ignored, Messages.IgnoredObjectPrefListEditor_object_name,
                objInitial == null ? null : objInitial.getName(),
                        text ->  text.isEmpty() ? Messages.IgnoredObjectPrefListEditor_enter_name : null);
        this.objInitial = objInitial;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        Composite c = new Composite(composite, SWT.NONE);
        c.setLayout(new GridLayout());
        c.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        Label label = new Label(c, SWT.LEFT);
        label.setText(Messages.ignoredObjectPrefListEditor_type);

        comboType = new ComboViewer(c, SWT.READ_ONLY);
        comboType.setContentProvider(ArrayContentProvider.getInstance());
        comboType.setInput(TypesEditingSupport.comboTypes());
        comboType.setContentProvider(ArrayContentProvider.getInstance());
        comboType.setSelection(new StructuredSelection(TypesEditingSupport.COMBO_TYPE_ALL));

        btnPattern = new Button(c, SWT.CHECK);
        btnPattern.setText(Messages.IgnoredObjectPrefListEditor_pattern);

        btnContent = new Button(c, SWT.CHECK);
        btnContent.setText(Messages.IgnoredObjectPrefListEditor_contents);

        btnQualified = new Button(c, SWT.CHECK);
        btnQualified.setText(Messages.IgnoredObjectPrefListEditor_qualified_name);

        if (objInitial != null) {
            btnPattern.setSelection(objInitial.isRegular());
            btnContent.setSelection(objInitial.isIgnoreContent());
            btnContent.setSelection(objInitial.isQualified());

            Iterator<DbObjType> iterator = objInitial.getObjTypes().iterator();
            if (iterator.hasNext()) {
                comboType.setSelection(new StructuredSelection(iterator.next()));
            }
        }

        return composite;
    }

    @Override
    protected void okPressed() {
        String selectedType = (String) ((StructuredSelection) comboType.getSelection()).getFirstElement();
        ignoredObject = new IgnoredObject(getValue(), btnPattern.getSelection(),
                btnContent.getSelection(), btnQualified.getSelection(),
                TypesEditingSupport.COMBO_TYPE_ALL.equals(selectedType) ?
                        EnumSet.noneOf(DbObjType.class) : EnumSet.of(DbObjType.valueOf(selectedType)));
        super.okPressed();
    }
}
