package ru.taximaxim.codekeeper.ui.prefs.ignoredobjects;

import java.text.MessageFormat;
import java.util.Set;

import org.eclipse.jface.layout.PixelConverter;
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

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.IIgnoreList;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoredObject;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.CheckEditingSupport.BooleanChangeValues;

public class IgnoredObjectPrefListEditor extends PrefListEditor<IgnoredObject> {

    public static IgnoredObjectPrefListEditor create(Composite parent, IgnoreList ignoreList) {
        fillComposite(parent, ignoreList,
                Messages.IgnoredObjectsPrefPage_these_objects_are_ignored_info,
                Messages.IgnoredObjectsPrefPage_these_objects_are_ignored_info_white);
        return new IgnoredObjectPrefListEditor(parent);
    }

    protected static void fillComposite(Composite composite, IIgnoreList ignoreList,
            String blackDescripton, String whiteDescripton) {
        Label descriptionLabel = new Label(composite, SWT.NONE);
        descriptionLabel.setText(blackDescripton);

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
                descriptionLabel.setText(blackDescripton);
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
                descriptionLabel.setText(whiteDescripton);
                composite.layout();
            }
        });
    }

    protected IgnoredObjectPrefListEditor(Composite parent) {
        super(parent);
    }

    @Override
    protected IgnoredObject getNewObject(IgnoredObject oldObject) {
        NewIgnoredObjectDialog d = new NewIgnoredObjectDialog(getShell(), oldObject, false);
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

        PixelConverter pc = new PixelConverter(tableViewer.getControl());
        name.getColumn().setWidth(150);
        isRegular.getColumn().setWidth(pc.convertWidthInCharsToPixels(10));
        ignoreContents.getColumn().setWidth(pc.convertWidthInCharsToPixels(28));
        isQualified.getColumn().setWidth(pc.convertWidthInCharsToPixels(18));
        objType.getColumn().setWidth(pc.convertWidthInCharsToPixels(10));
    }
}
