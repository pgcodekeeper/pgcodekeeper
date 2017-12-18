package ru.taximaxim.codekeeper.ui.dialogs;

import java.util.Collection;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.differ.CodeFilter;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * A dialog to display and edit filters for <code>DiffTableViewer</code>
 *
 * @since 3.11.5
 * @author galiev_mr
 * @see DiffTableViewer
 */
public class FilterDialog extends Dialog {

    private CheckboxTableViewer objViewer;
    private CheckboxTableViewer chgViewer;
    private final Collection<DbObjType> types;
    private final Collection<DiffSide> sides;
    private final CodeFilter filter;

    private Text text;
    private Button btnRegEx;

    /**
     * Creates a dialog instance. Note that the window will have no visual
     * representation (no widgets) until it is told to open. By default,
     * <code>open</code> blocks for dialogs.
     *
     * @param parentShell
     *            the parent shell, or <code>null</code> to create a top-level
     *            shell
     * @param filter
     *            object, that contains params for code search
     * @param types
     *            list of object types
     * @param sides
     *            list of change types
     *
     * @since 4.1.2
     * @see CodeFilter
     * @see DbObjType
     * @see DiffSide
     */
    public FilterDialog(Shell parentShell, CodeFilter filter,
            Collection<DbObjType> types, Collection<DiffSide> sides) {
        super(parentShell);
        this.filter = filter;
        this.types = types;
        this.sides = sides;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.FilterDialog_title);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(2, true));
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        Composite searchComposite = new Composite(container, SWT.NONE);
        GridLayout layout = new GridLayout(2, false);
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        searchComposite.setLayout(layout);
        searchComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

        Label txtFilter = new Label(searchComposite, SWT.NONE);
        txtFilter.setText(Messages.CodeFilter_search_by_code);
        txtFilter.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

        text = new Text(searchComposite, SWT.BORDER | SWT.SEARCH | SWT.ICON_SEARCH | SWT.ICON_CANCEL);
        text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        text.setText(filter.getPattern());

        btnRegEx = new Button(searchComposite, SWT.CHECK);
        btnRegEx.setText(Messages.diffTableViewer_use_regular_expressions);
        btnRegEx.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        btnRegEx.setSelection(filter.isUseRegex());

        new Label(container, SWT.NONE).setText(Messages.FilterDialog_show_object_types);

        new Label(container, SWT.NONE).setText(Messages.FilterDialog_show_change_types);

        objViewer = CheckboxTableViewer.newCheckList(container, SWT.BORDER);
        objViewer.add(new DbObjType[] {DbObjType.SCHEMA, DbObjType.EXTENSION, DbObjType.TYPE,
                DbObjType.DOMAIN, DbObjType.SEQUENCE, DbObjType.FUNCTION, DbObjType.TABLE,
                DbObjType.VIEW, DbObjType.CONSTRAINT, DbObjType.INDEX, DbObjType.TRIGGER,
                DbObjType.RULE});

        objViewer.setCheckedElements(types.toArray());
        objViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

        chgViewer = CheckboxTableViewer.newCheckList(container, SWT.BORDER);
        chgViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        chgViewer.setContentProvider(ArrayContentProvider.getInstance());
        chgViewer.setLabelProvider(new LabelProvider() {

            @Override
            public String getText(Object element) {
                switch (((DiffSide) element)) {
                case BOTH: return "edit"; //$NON-NLS-1$
                case LEFT: return "project"; //$NON-NLS-1$
                case RIGHT: return "remote"; //$NON-NLS-1$
                default: return null;
                }
            }
        });

        chgViewer.setInput(DiffSide.values());
        chgViewer.setCheckedElements(sides.toArray());

        return searchComposite;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        Button btnReset = createButton(parent, IDialogConstants.NO_ID, Messages.FilterDialog_reset, false);
        createButton(parent, IDialogConstants.CANCEL_ID, Messages.FilterDialog_cancel, false);

        btnReset.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                text.setText(""); //$NON-NLS-1$
                btnRegEx.setSelection(false);
                objViewer.setAllChecked(false);
                chgViewer.setAllChecked(false);
            }
        });
    }

    @Override
    protected Point getInitialSize() {
        Point size = super.getInitialSize();
        return new Point(Math.max(size.x, 450), Math.max(size.y, 300));
    }

    @Override
    protected void okPressed() {
        types.clear();
        sides.clear();

        for (Object obj : objViewer.getCheckedElements()) {
            types.add((DbObjType)obj);
        }

        for (Object chg : chgViewer.getCheckedElements()) {
            sides.add((DiffSide)chg);
        }

        filter.update(text.getText(), btnRegEx.getSelection());

        super.okPressed();
    }
}
