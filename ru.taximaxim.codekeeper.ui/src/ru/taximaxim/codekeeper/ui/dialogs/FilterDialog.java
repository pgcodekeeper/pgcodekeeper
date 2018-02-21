package ru.taximaxim.codekeeper.ui.dialogs;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

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
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;
import ru.taximaxim.codekeeper.ui.differ.filters.AbstractFilter;
import ru.taximaxim.codekeeper.ui.differ.filters.CodeFilter;
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
    private final AbstractFilter codeFilter;
    private final AbstractFilter schemaFilter;
    private final AbstractFilter gitUserFilter;
    private final AbstractFilter dbUserFilter;
    private final AtomicBoolean isLocalChange;

    private Text txtCode;
    private Text txtSchema;
    private Text txtGitUser;
    private Text txtDbUser;
    private Button btnCodeRegEx;
    private Button btnSchemaRegEx;
    private Button btnGitUserRegEx;
    private Button btnDbUserRegEx;
    private Button btnIsLocal;

    /**
     * Creates a dialog instance. Note that the window will have no visual
     * representation (no widgets) until it is told to open. By default,
     * <code>open</code> blocks for dialogs.
     *
     * @param parentShell
     *            the parent shell, or <code>null</code> to create a top-level
     *            shell
     * @param schemaFilter
     *            object, that contains schema in which want to search
     * @param codeFilter
     *            object, that contains params for code search
     * @param gitUserFilter
     *            object, that contains local git user params to search
     * @param dbUserFilter
     *            object, that contains db user params to search
     * @param types
     *            list of object types
     * @param sides
     *            list of change types
     * @param isLocalChange
     *            is search just local changes
     *
     * @since 4.1.2
     * @see CodeFilter
     * @see DbObjType
     * @see DiffSide
     */
    public FilterDialog(Shell parentShell,
            AbstractFilter schemaFilter, AbstractFilter codeFilter,
            AbstractFilter gitUserFilter, AbstractFilter dbUserFilter,
            Collection<DbObjType> types, Collection<DiffSide> sides,
            AtomicBoolean isLocalChange) {
        super(parentShell);
        this.codeFilter = codeFilter;
        this.schemaFilter = schemaFilter;
        this.gitUserFilter = gitUserFilter;
        this.dbUserFilter = dbUserFilter;
        this.types = types;
        this.sides = sides;
        this.isLocalChange = isLocalChange;
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

        Composite leftComposite = new Composite(container, SWT.NONE);
        leftComposite.setLayout(new GridLayout(2, false));
        createTypesPart(leftComposite);

        Composite rightComposite = new Composite(container, SWT.NONE);
        rightComposite.setLayout(new GridLayout(2, false));
        rightComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

        createCodePart(rightComposite);
        createSchemaPart(rightComposite);
        createDbUserPart(rightComposite);
        createGitUserPart(rightComposite);

        btnIsLocal = new Button(rightComposite, SWT.CHECK);
        btnIsLocal.setText("Show only local changes");
        btnIsLocal.setSelection(isLocalChange.get());

        return container;
    }

    private void createCodePart(Composite container) {
        createFilterLabel(container, Messages.CodeFilter_search_by_code);
        txtCode = createFilterField(container, Messages.FilterDialog_sql_filter_placehodlder,
                codeFilter.getPattern());
        btnCodeRegEx = createRegexButton(container, codeFilter.isUseRegex());
    }

    private void createSchemaPart(Composite container) {
        createFilterLabel(container, Messages.FilterDialog_search_by_container);
        txtSchema = createFilterField(container, Messages.FilterDialog_schema_filter_placeholder,
                schemaFilter.getPattern());
        btnSchemaRegEx = createRegexButton(container, schemaFilter.isUseRegex());
    }

    private void createDbUserPart(Composite container) {
        createFilterLabel(container, "Search by database user");
        txtDbUser = createFilterField(container, "Enter db user name",
                dbUserFilter.getPattern());
        btnDbUserRegEx = createRegexButton(container, dbUserFilter.isUseRegex());
    }

    private void createGitUserPart(Composite container) {
        createFilterLabel(container, "Search by git user");
        txtGitUser = createFilterField(container, "Enter git user name",
                gitUserFilter.getPattern());
        btnGitUserRegEx = createRegexButton(container, gitUserFilter.isUseRegex());
    }


    private void createFilterLabel(Composite container, String text) {
        Label lbl = new Label(container, SWT.NONE);
        lbl.setText(text);
        lbl.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
    }

    private Text createFilterField(Composite container, String placeholder, String pattern) {
        Text txt = new Text(container, SWT.BORDER | SWT.SEARCH | SWT.ICON_SEARCH | SWT.ICON_CANCEL);
        txt.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        txt.setMessage(placeholder);
        txt.setText(pattern);
        return txt;
    }

    private Button createRegexButton(Composite container, boolean useRegex) {
        Button btnUseRegex = new Button(container, SWT.CHECK);
        btnUseRegex.setText(Messages.diffTableViewer_use_regular_expressions);
        btnUseRegex.setSelection(useRegex);
        return btnUseRegex;
    }


    private void createTypesPart(Composite container) {
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
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        Button btnReset = createButton(parent, IDialogConstants.NO_ID, Messages.FilterDialog_reset, false);
        createButton(parent, IDialogConstants.CANCEL_ID, Messages.FilterDialog_cancel, false);

        btnReset.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                txtCode.setText(""); //$NON-NLS-1$
                btnCodeRegEx.setSelection(false);
                txtSchema.setText(""); //$NON-NLS-1$
                btnSchemaRegEx.setSelection(false);
                txtGitUser.setText(""); //$NON-NLS-1$
                btnGitUserRegEx.setSelection(false);
                txtDbUser.setText(""); //$NON-NLS-1$
                btnDbUserRegEx.setSelection(false);
                btnIsLocal.setSelection(false);
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

        codeFilter.updateFields(txtCode.getText(), btnCodeRegEx.getSelection());
        schemaFilter.updateFields(txtSchema.getText(), btnSchemaRegEx.getSelection());
        gitUserFilter.updateFields(txtGitUser.getText(), btnGitUserRegEx.getSelection());
        dbUserFilter.updateFields(txtDbUser.getText(), btnDbUserRegEx.getSelection());
        isLocalChange.set(btnIsLocal.getSelection());

        super.okPressed();
    }
}
