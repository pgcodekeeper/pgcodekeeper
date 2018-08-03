package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.AbstractConstraint;
import cz.startnet.utils.pgdiff.schema.PgTable;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.generators.IntegerPgData;
import ru.taximaxim.codekeeper.ui.generators.PgData;
import ru.taximaxim.codekeeper.ui.generators.PgDataGenerator;
import ru.taximaxim.codekeeper.ui.generators.PgDataType;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgUIDumpLoader;

/**
 *  Page of the creating mock data for PostgreSql data
 *
 *  @since 3.11.5
 *  @author galiev_mr
 *  @see PgData
 */
public class MockDataPage extends WizardPage {

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();

    private final List<PgData<?>> columns = new ArrayList<>();
    private int rowCount = 20;
    private String parsedTableName;
    private String parsedSchemaName;

    private final DataModifier startDataModifier = new DataModifier(PgData::setStartFromString);
    private final DataModifier endDataModifier = new DataModifier(PgData::setEndFromString);
    private final DataModifier stepDataModifier = new DataModifier(PgData::setStepFromString);
    private final DataModifier lengthDataModifier = new DataModifier((c,s) -> c.setLength(Integer.parseUnsignedInt(s)));

    private Text txtTableName;
    private Button btnCast;
    private ComboViewer cmbType;
    private ComboViewer cmbGeneration;
    private Button btnIsUnique;
    private Button btnIsNotNull;
    private Text txtColumnName;
    private Text txtStart;
    private Text txtEnd;
    private Text txtStep;
    private Text txtLength;
    private Text txtAny;
    private Text txtRowCount;
    private Label lblStart;
    private Label lblEnd;
    private Label lblStep;
    private Label lblLength;
    private Label lblAny;

    private TableViewer viewer;
    private boolean inViewerSelection;

    /**
     * Creates a new wizard page with the given title
     *
     * @param pageName Page name
     * @param selection Current user selection
     */
    public MockDataPage(String pageName, IStructuredSelection selection) {
        super(pageName);
        setTitle(pageName);
        parseSelection(selection);
        setDescription(Messages.MockDataPage_description);
    }

    /**
     * Generates file with insert query and open them in project editor
     *
     * @return true if file successfully created and opened, false otherwise
     * @see #generateInsert()
     */
    boolean createFile() {
        if (!isValid()) {
            return false;
        }

        try {
            mainPrefs.setValue(PREF.EXPLICIT_TYPE_CAST, btnCast.getSelection());
            String name = FileUtils.FILE_DATE.format(LocalDateTime.now()) + " data for " + txtTableName.getText() ; //$NON-NLS-1$
            name = FileUtils.sanitizeFilename(name);
            FileUtilsUi.saveOpenTmpSqlEditor(generateInsert(), name);
            return true;
        } catch (CoreException | IOException ex) {
            ExceptionNotifier.notifyDefault(
                    Messages.ProjectEditorDiffer_error_creating_file, ex);
        }

        return false;
    }

    /**
     * Checks fields filling validation
     *
     */
    private boolean isValid() {
        String err = null;
        if (txtTableName.getText().isEmpty()) {
            err = Messages.MockDataPage_empty_table_name;
        }

        if (err == null) {
            try {
                rowCount = Integer.parseUnsignedInt(txtRowCount.getText());
            } catch (NumberFormatException ex) {
                err = Messages.MockDataPage_incorrect_row_count;
            }
        }

        if (err == null && columns.isEmpty()) {
            err = Messages.MockDataPage_empty_columns;
        }

        if (err == null) {
            for (PgData<?> c : columns) {
                try {
                    c.generateValue();
                } catch (Exception e) {
                    err = MessageFormat.format(Messages.MockDataPage_generation_failed,
                            c.getName(), e.getLocalizedMessage());
                }
            }
        }

        if (err == null) {
            for (PgData<?> c : columns) {
                if (c.isUnique() && c.getGenerator() == PgDataGenerator.RANDOM
                        && c.getMaxValues() < rowCount) {
                    err = Messages.MockDataPage_maximum_value
                            + ' ' + c.getName() + ": " + c.getMaxValues(); //$NON-NLS-1$
                }
            }
        }

        setErrorMessage(err);
        return err == null;
    }

    /**
     * Checks all PgData fields for column and disable viewer if found error
     */
    public void checkAllFields() {
        String err = null;
        if (txtStart.isEnabled()) {
            err = startDataModifier.error;
        }
        if (err == null && txtEnd.isEnabled()) {
            err = endDataModifier.error;
        }
        if (err == null && txtStep.isEnabled()) {
            err = stepDataModifier.error;
        }
        if (err == null && txtLength.isEnabled()) {
            err = lengthDataModifier.error;
        }
        setErrorMessage(err);
        viewer.getControl().setEnabled(err == null);
        getContainer().updateButtons();
    }

    /**
     * Generates insert query from columns list
     *
     * @see PgData #generateValue()
     */
    private String generateInsert() {
        boolean isNeedCast = btnCast.getSelection();

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO "); //$NON-NLS-1$
        sb.append(txtTableName.getText());
        sb.append(" ("); //$NON-NLS-1$

        columns.forEach(v -> {
            sb.append(v.getName());
            sb.append(", "); //$NON-NLS-1$
        });

        sb.setLength(sb.length() - 2);
        sb.append(") VALUES\n  "); //$NON-NLS-1$

        columns.forEach(PgData::reset);
        for (int i = 0; i < rowCount; i++) {
            sb.append('(');
            columns.forEach(v -> {
                sb.append(v.generateAsString());
                if (isNeedCast) {
                    sb.append("::" + v.getAlias()); //$NON-NLS-1$
                }
                sb.append(", "); //$NON-NLS-1$
            });
            sb.setLength(sb.length() - 2);
            sb.append("),\n  "); //$NON-NLS-1$
        }
        sb.setLength(sb.length() - 4);
        sb.append(';');
        return sb.toString();
    }

    @Override
    public void createControl(Composite parent) {
        final Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(6, false));
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        new Label(container, SWT.NONE).setText(Messages.MockDataPage_table_name);

        txtTableName = new Text(container, SWT.BORDER);
        txtTableName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 4, 1));
        txtTableName.setText(parsedTableName == null ? "t1" : (parsedSchemaName + '.' + parsedTableName)); //$NON-NLS-1$

        final Composite columnInfo = createColumnInfo(container);
        columnInfo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 4));

        new Label(container, SWT.NONE).setText(Messages.MockDataPage_row_count);

        txtRowCount = new Text(container, SWT.BORDER);
        txtRowCount.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 4, 1));
        txtRowCount.setText("20"); //$NON-NLS-1$

        viewer = new TableViewer(container, SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER | SWT.MULTI);
        viewer.setContentProvider(ArrayContentProvider.getInstance());
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 5, 2);
        viewer.getTable().setLayoutData(gd);
        viewer.getTable().setLinesVisible(true);
        viewer.getTable().setHeaderVisible(true);

        addColumns(viewer);
        viewer.setInput(columns);
        viewer.getTable().setFocus();

        final Button btnAdd = new Button(container, SWT.NONE);
        btnAdd.setText(Messages.MockDataPage_add_column);
        btnAdd.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                PgData<?> c = new IntegerPgData(PgDataType.INTEGER);
                c.setName("c" + (columns.size() + 1)); //$NON-NLS-1$
                columns.add(c);
                viewer.refresh();
                viewer.setSelection(new StructuredSelection(c));
                viewer.getTable().setFocus();
            }
        });

        final Button btnDelete = new Button(container, SWT.NONE);
        btnDelete.setText(Messages.MockDataPage_delete_column);
        btnDelete.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                Object [] sel = ((IStructuredSelection) viewer.getSelection()).toArray();
                if (sel.length > 0 && columns.size() >  sel.length) {
                    int index = 0;
                    for (Object row : sel) {
                        PgData<?> c = (PgData<?>) row;
                        index = columns.indexOf(c);
                        columns.remove(c);
                        if (index == columns.size()) {
                            index--;
                        }
                    }

                    viewer.setSelection(new StructuredSelection(columns.get(index)));
                    viewer.refresh();
                    viewer.getTable().setFocus();
                }
            }
        });

        final Button btnUp = new Button(container, SWT.NONE);
        btnUp.setText(Messages.MockDataPage_column_up);
        btnUp.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection sel = (IStructuredSelection) viewer.getSelection();
                if (!sel.isEmpty() && columns.size() != 1) {
                    PgData<?> c = (PgData<?>) sel.getFirstElement();
                    int index = columns.indexOf(c);
                    Collections.swap(columns, index, index - 1);
                    viewer.setSelection(new StructuredSelection(c));
                    viewer.refresh();
                    viewer.getTable().setFocus();
                }
            }
        });

        final Button btnDown = new Button(container, SWT.NONE);
        btnDown.setText(Messages.MockDataPage_column_down);
        btnDown.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection sel = (IStructuredSelection) viewer.getSelection();
                if (!sel.isEmpty() && columns.size() != 1) {
                    PgData<?> c = (PgData<?>) sel.getFirstElement();
                    int index = columns.indexOf(c);
                    Collections.swap(columns, index, index + 1);
                    viewer.setSelection(new StructuredSelection(c));
                    viewer.refresh();
                    viewer.getTable().setFocus();
                }
            }
        });


        final Button btnDeletetNullable = new Button(container, SWT.NONE);
        btnDeletetNullable.setText(Messages.MockDataPage_delete_optional);
        btnDeletetNullable.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                Iterator<PgData<?>> it = columns.iterator();

                while (it.hasNext()) {
                    PgData<?> el = it.next();
                    if (!el.isNotNull()) {
                        it.remove();
                    }
                }

                viewer.refresh();
                viewer.getTable().setFocus();
            }
        });

        btnCast = new Button(container, SWT.CHECK);
        btnCast.setText(Messages.MockDataPage_explicit_type_cast);
        btnCast.setSelection(mainPrefs.getBoolean(PREF.EXPLICIT_TYPE_CAST));
        btnCast.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                mainPrefs.setValue(PREF.EXPLICIT_TYPE_CAST, btnCast.getSelection());
            }
        });

        viewer.addSelectionChangedListener(e -> {
            inViewerSelection = true;
            IStructuredSelection sel = (IStructuredSelection) e.getSelection();
            boolean isSingle = sel.size() == 1;
            columnInfo.setEnabled(isSingle);
            if (isSingle) {
                PgData<?> c = (PgData<?>) sel.getFirstElement();
                showColumnInfo(c);
                updateFields(c);
                if (columns.size() == 1) {
                    btnUp.setEnabled(false);
                    btnDown.setEnabled(false);
                } else {
                    int index = columns.indexOf(c);
                    btnUp.setEnabled(index != 0);
                    btnDown.setEnabled(index != columns.size() - 1);
                }
            } else {
                btnUp.setEnabled(false);
                btnDown.setEnabled(false);
            }
            btnDelete.setEnabled(!sel.isEmpty() && sel.size() != columns.size());
            inViewerSelection = false;
        });

        if (!columns.isEmpty()) {
            getShell().addShellListener(new ShellAdapter() {

                @Override
                public void shellActivated(ShellEvent e) {
                    getShell().removeShellListener(this);
                    viewer.setSelection(new StructuredSelection(columns.get(0)));
                }
            });
        }
        setControl(container);
    }

    /**
     * Creates right block with information about the column
     *
     * @param parent Parent composite
     * @return Upper composite of the right block
     */
    private Composite createColumnInfo(Composite parent) {
        Group composite = new Group(parent, SWT.NONE);
        composite.setText(Messages.MockDataPage_column);
        composite.setLayout(new GridLayout(2, false));

        new Label(composite, SWT.NONE).setText(Messages.MockDataPage_column_name);

        txtColumnName = new Text(composite, SWT.BORDER);
        txtColumnName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtColumnName.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                IStructuredSelection sel = (IStructuredSelection) viewer.getSelection();
                if (!sel.isEmpty()) {
                    PgData<?> c = (PgData<?>) sel.getFirstElement();
                    c.setName(txtColumnName.getText());
                    viewer.refresh();
                }
            }
        });

        new Label(composite, SWT.NONE).setText(Messages.MockDataPage_column_type);

        cmbType = new ComboViewer(composite);
        cmbType.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbType.setContentProvider(ArrayContentProvider.getInstance());
        cmbType.setInput(PgDataType.values());
        cmbType.addSelectionChangedListener(e -> {
            // not a user selection action
            if (inViewerSelection) {
                return;
            }
            IStructuredSelection sel = (IStructuredSelection) viewer.getSelection();
            if (!sel.isEmpty()) {
                PgData<?> c = (PgData<?>) sel.getFirstElement();
                PgDataType type = (PgDataType) ((IStructuredSelection)e.getSelection()).getFirstElement();
                PgData<?> cType = type.makeData(null);
                cType.copyFrom(c);
                columns.set(columns.indexOf(c), cType);
                updateFields(cType);
                viewer.refresh();
                checkAllFields();
                viewer.setSelection(new StructuredSelection(cType));
            }
        });

        new Label(composite, SWT.NONE).setText(Messages.MockDataPage_column_generator);

        cmbGeneration = new ComboViewer(composite);
        cmbGeneration.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbGeneration.setContentProvider(ArrayContentProvider.getInstance());
        cmbGeneration.setInput(PgDataGenerator.values());
        cmbGeneration.addSelectionChangedListener(e -> {
            // not a user selection action
            if (inViewerSelection) {
                return;
            }
            IStructuredSelection sel = (IStructuredSelection) viewer.getSelection();
            if (!sel.isEmpty()) {
                PgData<?> c = (PgData<?>) sel.getFirstElement();
                PgDataGenerator gen = (PgDataGenerator) ((IStructuredSelection) e.getSelection()).getFirstElement();
                c.setGenerator(gen);
                updateFields(c);
                checkAllFields();
                viewer.refresh();
            }
        });

        btnIsUnique = new Button(composite, SWT.CHECK);
        btnIsUnique.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        btnIsUnique.setText("UNIQUE"); //$NON-NLS-1$
        btnIsUnique.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection sel = (IStructuredSelection) viewer.getSelection();
                if (!sel.isEmpty()) {
                    PgData<?> c = (PgData<?>) sel.getFirstElement();
                    c.setUnique(btnIsUnique.getSelection());
                }
            }
        });

        btnIsNotNull = new Button(composite, SWT.CHECK);
        btnIsNotNull.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        btnIsNotNull.setText("NOT NULL"); //$NON-NLS-1$
        btnIsNotNull.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection sel = (IStructuredSelection) viewer.getSelection();
                if (!sel.isEmpty()) {
                    PgData<?> c = (PgData<?>) sel.getFirstElement();
                    c.setNotNull(btnIsNotNull.getSelection());
                }
            }
        });

        lblStart = new Label(composite, SWT.NONE);
        lblStart.setText(Messages.MockDataPage_range_start);

        txtStart = new Text(composite, SWT.BORDER);
        txtStart.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtStart.addModifyListener(startDataModifier);

        lblEnd = new Label(composite, SWT.NONE);
        lblEnd.setText(Messages.MockDataPage_range_end);

        txtEnd = new Text(composite, SWT.BORDER);
        txtEnd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtEnd.addModifyListener(endDataModifier);

        lblStep = new Label(composite, SWT.NONE);
        lblStep.setText(Messages.MockDataPage_step);

        txtStep = new Text(composite, SWT.BORDER);
        txtStep.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtStep.addModifyListener(stepDataModifier);

        lblLength = new Label(composite, SWT.NONE);
        lblLength.setText(Messages.MockDataPage_length);

        txtLength = new Text(composite, SWT.BORDER);
        txtLength.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtLength.addModifyListener(lengthDataModifier);

        lblAny = new Label(composite, SWT.NONE);
        lblAny.setText(Messages.MockDataPage_any_value);

        txtAny = new Text(composite, SWT.BORDER);
        txtAny.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtAny.addModifyListener(new DataModifier(PgData::setAny));

        return composite;
    }

    /**
     * Fills the block with information about the column
     *
     * @param c Selected column wrapper
     */
    private void showColumnInfo(PgData<?> c) {
        txtColumnName.setText(c.getName());
        cmbType.setSelection(new StructuredSelection(c.getType()));
        txtStart.setText(c.getStartAsString());
        txtEnd.setText(c.getEndAsString());
        txtStep.setText(c.getStepAsString());
        txtLength.setText(Integer.toString(c.getLength()));
        txtAny.setText(c.getAny());
        btnIsUnique.setSelection(c.isUnique());
        btnIsNotNull.setSelection(c.isNotNull());
        cmbGeneration.setInput(c.getType().getGenerators());
        cmbGeneration.setSelection(new StructuredSelection(c.getGenerator()));
    }

    private void hideWidget(Control first, Control second) {
        boolean isShow = first.getEnabled();
        GridData data = (GridData)first.getLayoutData();
        data.exclude = !isShow;
        first.setVisible(isShow);
        data = (GridData)second.getLayoutData();
        data.exclude = !isShow;
        second.setVisible(isShow);
    }

    /**
     * Enable and disable fields, hide disabled fields when changing the generator and type
     *
     * @param c Selected column wrapper
     */
    private void updateFields(PgData<?> c) {
        PgDataType type = c.getType();
        PgDataGenerator gen = c.getGenerator();
        boolean hasLength = type == PgDataType.TEXT
                || type == PgDataType.JSON
                || type == PgDataType.BIT;

        txtStart.setEnabled((type != PgDataType.BOOLEAN && !hasLength
                || gen != PgDataGenerator.RANDOM) && gen != PgDataGenerator.ANY);
        txtEnd.setEnabled(type != PgDataType.BOOLEAN
                && gen == PgDataGenerator.RANDOM && !hasLength
                && gen != PgDataGenerator.ANY);
        txtStep.setEnabled(gen == PgDataGenerator.INCREMENT);
        txtLength.setEnabled(gen == PgDataGenerator.RANDOM && hasLength);
        txtAny.setEnabled(gen == PgDataGenerator.ANY);
        btnIsUnique.setEnabled(gen == PgDataGenerator.RANDOM);
        btnIsNotNull.setEnabled(gen == PgDataGenerator.RANDOM);

        hideWidget(txtStart, lblStart);
        hideWidget(txtEnd, lblEnd);
        hideWidget(txtStep, lblStep);
        hideWidget(txtLength, lblLength);
        hideWidget(txtAny, lblAny);
        hideWidget(btnIsUnique, btnIsNotNull);

        txtColumnName.getParent().layout();
    }

    /**
     * Creates columns for the top level viewer
     *
     * @param viewer Parent viewer
     */
    private void addColumns(TableViewer viewer) {
        TableViewerColumn name = new TableViewerColumn(viewer, SWT.LEFT);
        name.getColumn().setResizable(true);
        name.getColumn().setMoveable(true);
        name.getColumn().setText(Messages.MockDataPage_column_name);
        name.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                PgData<?> c = (PgData<?>) element;
                return c.getName();
            }
        });

        TableViewerColumn type = new TableViewerColumn(viewer, SWT.LEFT);
        type.getColumn().setResizable(true);
        type.getColumn().setMoveable(true);
        type.getColumn().setText(Messages.MockDataPage_column_type);
        type.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                return ((PgData<?>) element).getAlias();
            }
        });

        TableViewerColumn generator = new TableViewerColumn(viewer, SWT.LEFT);
        generator.getColumn().setResizable(true);
        generator.getColumn().setMoveable(true);
        generator.getColumn().setText(Messages.MockDataPage_column_generator);
        generator.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                PgData<?> c = (PgData<?>) element;
                PgDataGenerator gen = c.getGenerator();
                return gen.name();
            }
        });

        int width = (int)(viewer.getTable().getSize().x * 0.33);
        name.getColumn().setWidth(Math.max(width, 200));
        type.getColumn().setWidth(Math.max(width, 200));
        generator.getColumn().setWidth(Math.max(width, 200));
    }

    /**
     * Processes the selection, gets the project,
     * if a table is selected, fills columns data
     * otherwise create 1 column
     *
     * @param selection Current selection
     */
    private void parseSelection(IStructuredSelection selection) {
        Object source = selection.getFirstElement();
        if (source instanceof IFile && PgUIDumpLoader.isInProject((IFile)source)) {
            IFile file = (IFile)source;
            PgTable table = null;
            try {
                table = (PgTable) PgUIDumpLoader.parseStatement(file, Arrays.asList(DbObjType.TABLE));
            } catch (InterruptedException | IOException | CoreException e) {
                Log.log(Log.LOG_ERROR, "Error parsing file: " + file.getName(), e); //$NON-NLS-1$
            }
            if (table != null) {
                parsedTableName = table.getName();
                parsedSchemaName = table.getContainingSchema().getName();
                table.getColumns().forEach(this::parseColumns);
                table.getConstraints().forEach(this::parseConstraints);
                return;
            }
        }
        // in case no file or exception
        PgData<?> c = new IntegerPgData(PgDataType.INTEGER);
        c.setName("id"); //$NON-NLS-1$
        columns.add(c);

    }

    /**
     * Gets table constraint data and adds them to columns data
     *
     * @param constraint Table constraint
     */
    private void parseConstraints(AbstractConstraint constraint) {
        if (constraint.isUnique() || constraint.isPrimaryKey()) {
            columns.stream()
            .filter(wrapper -> constraint.getColumns().contains(wrapper.getName()))
            .forEach(wrapper -> wrapper.setUnique(true));
        }
    }

    /**
     * Gets column data and adds them to list
     *
     * @param column Table column
     */
    private void parseColumns(PgColumn column) {
        String type = column.getType();
        PgData<?> c = PgDataType.dataForType(type == null  ? "other" : type); //$NON-NLS-1$
        c.setNotNull(!column.getNullValue());
        c.setName(column.getName());
        c.setAlias(type);
        columns.add(c);
    }

    @Override
    public boolean isPageComplete() {
        return getErrorMessage() == null;
    }

    private class DataModifier implements ModifyListener {

        private final BiConsumer<PgData<?>, String> setter;
        private String error;

        public DataModifier(BiConsumer<PgData<?>, String> setter) {
            this.setter = setter;
        }

        @Override
        public void modifyText(ModifyEvent e) {
            IStructuredSelection sel = (IStructuredSelection) viewer.getSelection();
            if (!sel.isEmpty()) {
                PgData<?> c = (PgData<?>) sel.getFirstElement();
                try {
                    String text = ((Text) e.widget).getText();
                    setter.accept(c, text);
                    error = null;
                } catch (Exception ex) {
                    error = Messages.MockDataPage_invalid_value + ex.getLocalizedMessage();
                    setErrorMessage(error);
                }
                checkAllFields();
            }
        }
    }
}