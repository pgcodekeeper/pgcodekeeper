package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgTable;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.ui.Log;
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

    private final List<PgData<?>> columns = new ArrayList<>();
    private int rowCount = 20;
    private String parsedTableName;
    private String parsedSchemaName;

    private Text txtSchemaName;
    private Text txtTableName;
    private ComboViewer cmbType, cmbGeneration;
    private Button btnIsUnique, btnIsNotNull;
    private Text txtColumnName, txtStart, txtEnd, txtStep, txtLength, txtRowCount;

    private TableViewer viewer;
    private boolean inViewerSelection;

    /**
     * Creates a new wizard page with the given title
     *
     * @param pageName Page name
     * @param selection Current user selection
     * @since 3.11.5
     * @author galiev_mr
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
     * @since 3.11.5
     * @author galiev_mr
     * @see #generateInsert()
     */
    boolean createFile() {
        if (!isValid()) {
            return false;
        }

        try {
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
     * @since 3.11.5
     * @author galiev_mr
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

        if (err == null) {
            for (PgData<?> c : columns) {
                try {
                    c.generateValue();
                } catch (Exception e) {
                    err = MessageFormat.format("Could not generate value for column {0}. Reason: {1}",
                            c.getName(), e.getLocalizedMessage());
                }
            }
        }

        if (err == null) {
            for (PgData<?> c : columns) {
                if (c.isUnique() && c.getGenerator() == PgDataGenerator.RANDOM
                        && c.getMaxValues() < rowCount) {
                    err = Messages.MockDataPage_maximum_value
                            + c.getName() + ": " + c.getMaxValues(); //$NON-NLS-1$
                }
            }
        }

        setErrorMessage(err);
        return err == null;
    }

    /**
     * Generates insert query from columns list
     *
     * @since 3.11.5
     * @author galiev_mr
     * @see PgData #generateValue()
     */
    private String generateInsert() {
        StringBuilder sb = new StringBuilder();
        String schemaName = txtSchemaName.getText();
        sb.append("INSERT INTO "); //$NON-NLS-1$
        if (!schemaName.isEmpty()) {
            sb.append(schemaName)
            .append('.');
        }
        sb.append(txtTableName.getText());
        sb.append(" ("); //$NON-NLS-1$

        columns.forEach(v -> {
            sb.append(v.getName());
            sb.append(", "); //$NON-NLS-1$
        });

        sb.setLength(sb.length() - 2);
        sb.append(") VALUES \n\t"); //$NON-NLS-1$

        columns.forEach(PgData::reset);
        for (int i = 0; i < rowCount; i++) {
            sb.append('(');
            columns.forEach(v -> {
                sb.append(v.generateAsString());
                sb.append(", "); //$NON-NLS-1$
            });
            sb.setLength(sb.length() - 2);
            sb.append("), \n\t"); //$NON-NLS-1$
        }
        sb.setLength(sb.length() - 4);
        sb.append(';');
        return sb.toString();
    }

    @Override
    public void createControl(Composite parent) {
        final Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(5, false));
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        new Label(container, SWT.NONE).setText(Messages.MockDataPage_schema_name);

        txtSchemaName = new Text(container, SWT.BORDER);
        txtSchemaName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1));

        final Composite columnInfo = createColumnInfo(container);
        columnInfo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 5));

        new Label(container, SWT.NONE).setText(Messages.MockDataPage_table_name);

        txtTableName = new Text(container, SWT.BORDER);
        txtTableName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1));
        txtTableName.setText("t1");

        new Label(container, SWT.NONE).setText(Messages.MockDataPage_row_count);

        txtRowCount = new Text(container, SWT.BORDER);
        txtRowCount.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1));
        txtRowCount.setText("20"); //$NON-NLS-1$

        viewer = new TableViewer(container, SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
        viewer.setContentProvider(ArrayContentProvider.getInstance());
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 4, 2);
        viewer.getTable().setLayoutData(gd);
        viewer.getTable().setLinesVisible(true);
        viewer.getTable().setHeaderVisible(true);

        addColumns(viewer);
        viewer.setInput(columns);

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
            }
        });

        final Button btnDelete = new Button(container, SWT.NONE);
        btnDelete.setText(Messages.MockDataPage_delete_column);
        btnDelete.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection sel = (IStructuredSelection) viewer.getSelection();
                if (!sel.isEmpty() && columns.size() != 1) {
                    PgData<?> c = (PgData<?>) sel.getFirstElement();
                    int index = columns.indexOf(c);
                    columns.remove(c);
                    if (index == columns.size()) {
                        index--;
                    }
                    viewer.setSelection(new StructuredSelection(columns.get(index)));
                    viewer.refresh();
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
                }
            }
        });

        viewer.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                inViewerSelection = true;

                IStructuredSelection sel = (IStructuredSelection) event.getSelection();
                boolean empty = sel.isEmpty();
                if (!empty) {
                    PgData<?> c = (PgData<?>) sel.getFirstElement();
                    showColumnInfo(c);
                    if (columns.size() == 1) {
                        btnUp.setEnabled(false);
                        btnDown.setEnabled(false);
                    } else {
                        int index = columns.indexOf(c);
                        btnUp.setEnabled(index != 0);
                        btnDown.setEnabled(index != columns.size() - 1);
                    }
                }
                btnDelete.setEnabled(!empty);

                inViewerSelection = false;
            }
        });

        viewer.setSelection(new StructuredSelection(columns.get(0)));
        setControl(container);
    }

    /**
     * Creates right block with information about the column
     *
     * @param parent Parent composite
     * @since 3.11.5
     * @return Upper composite of the right block
     * @author galiev_mr
     */
    private Composite createColumnInfo(Composite parent) {
        Group composite = new Group(parent, SWT.NONE);
        composite.setText("Column");
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
        cmbType.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                // not a user selection action
                if (inViewerSelection) {
                    return;
                }
                IStructuredSelection sel = (IStructuredSelection) viewer.getSelection();
                if (!sel.isEmpty()) {
                    PgData<?> c = (PgData<?>) sel.getFirstElement();
                    PgDataType type = (PgDataType) ((IStructuredSelection)event.getSelection()).getFirstElement();
                    PgData<?> cType = type.makeData(null);
                    cType.copyFrom(c);
                    columns.set(columns.indexOf(c), cType);
                    updateFields(cType);
                    viewer.setSelection(new StructuredSelection(cType));
                    viewer.refresh();
                }
            }
        });

        new Label(composite, SWT.NONE).setText(Messages.MockDataPage_column_generator);

        cmbGeneration = new ComboViewer(composite);
        cmbGeneration.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbGeneration.setContentProvider(ArrayContentProvider.getInstance());
        cmbGeneration.setInput(PgDataGenerator.values());
        cmbGeneration.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                // not a user selection action
                if (inViewerSelection) {
                    return;
                }
                IStructuredSelection sel = (IStructuredSelection) viewer.getSelection();
                if (!sel.isEmpty()) {
                    PgData<?> c = (PgData<?>) sel.getFirstElement();
                    PgDataGenerator gen = (PgDataGenerator) ((IStructuredSelection) event.getSelection()).getFirstElement();
                    c.setGenerator(gen);
                    updateFields(c);
                    viewer.refresh();
                }
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

        new Label(composite, SWT.NONE).setText(Messages.MockDataPage_range_start);

        txtStart = new Text(composite, SWT.BORDER);
        txtStart.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtStart.addModifyListener(new DataModifier(PgData::setStartFromString));

        new Label(composite, SWT.NONE).setText(Messages.MockDataPage_range_end);

        txtEnd = new Text(composite, SWT.BORDER);
        txtEnd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtEnd.addModifyListener(new DataModifier(PgData::setEndFromString));

        new Label(composite, SWT.NONE).setText(Messages.MockDataPage_step);

        txtStep = new Text(composite, SWT.BORDER);
        txtStep.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtStep.addModifyListener(new DataModifier(PgData::setStepFromString));

        new Label(composite, SWT.NONE).setText(Messages.MockDataPage_length);

        txtLength = new Text(composite, SWT.BORDER);
        txtLength.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtLength.addModifyListener(e -> {
            IStructuredSelection sel = (IStructuredSelection) viewer.getSelection();
            if (!sel.isEmpty()) {
                PgData<?> c = (PgData<?>) sel.getFirstElement();
                try {
                    c.setLength(Integer.parseUnsignedInt(txtLength.getText()));
                } catch (NumberFormatException ex) {
                    Log.log(Log.LOG_INFO, "Invalid input", ex); //$NON-NLS-1$
                }
            }
        });

        return composite;
    }

    /**
     * Fills the block with information about the column
     *
     * @param c Selected column wrapper
     * @since 3.11.5
     * @author galiev_mr
     */
    private void showColumnInfo(PgData<?> c) {
        txtColumnName.setText(c.getName());
        cmbType.setSelection(new StructuredSelection(c.getType()));
        txtStart.setText(c.getStartAsString());
        txtEnd.setText(c.getEndAsString());
        txtStep.setText(c.getStepAsString());
        txtLength.setText(Integer.toString(c.getLength()));
        btnIsUnique.setSelection(c.isUnique());
        btnIsNotNull.setSelection(c.isNotNull());
        cmbGeneration.setInput(c.getType().getGenerators());
        cmbGeneration.setSelection(new StructuredSelection(c.getGenerator()));
    }

    /**
     * Enable and disable fields when changing the generator and type
     *
     * @param c Selected column wrapper
     * @since 3.11.5
     * @author galiev_mr
     */
    private void updateFields(PgData<?> c) {
        PgDataType type = c.getType();
        PgDataGenerator gen = c.getGenerator();
        boolean hasLength = type == PgDataType.TEXT
                || type == PgDataType.JSON
                || type == PgDataType.CHARACTER
                || type == PgDataType.BIT;

        txtStart.setEnabled(type != PgDataType.BOOLEAN && !hasLength
                || gen != PgDataGenerator.RANDOM );
        txtEnd.setEnabled(type != PgDataType.BOOLEAN
                && gen == PgDataGenerator.RANDOM && !hasLength);
        txtStep.setEnabled(gen == PgDataGenerator.INCREMENT);
        txtLength.setEnabled(gen == PgDataGenerator.RANDOM && hasLength);
        btnIsUnique.setEnabled(gen == PgDataGenerator.RANDOM);
        btnIsNotNull.setEnabled(gen == PgDataGenerator.RANDOM);
    }

    /**
     * Creates columns for the top level viewer
     *
     * @param viewer Parent viewer
     * @since 3.11.5
     * @author galiev_mr
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
                PgData<?> c = (PgData<?>) element;
                PgDataType type = c.getType();
                switch (type) {
                case OTHER:
                    return type.name();
                default:
                    return type.getType();
                }
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
     * @since 3.11.5
     * @author galiev_mr
     */
    private void parseSelection(IStructuredSelection selection) {
        Object source = selection.getFirstElement();
        if (source instanceof IFile && "TABLE".equals(((IFile) source).getParent().getName())) { //$NON-NLS-1$
            IFile file = (IFile)source;
            parsedTableName = file.getName().replaceAll(".sql", ""); //$NON-NLS-1$ //$NON-NLS-2$
            parsedSchemaName = file.getParent().getParent().getName();
            try {
                PgDatabase db = PgUIDumpLoader.buildFiles(Arrays.asList(file), null, null);
                PgTable table = db.getSchema(parsedSchemaName).getTable(parsedTableName);

                table.getColumns().forEach(this::parseColumns);
                table.getConstraints().forEach(this::parseConstraints);
                return;
            } catch (IOException | InterruptedException | CoreException ex) {
                Log.log(Log.LOG_ERROR, "Error while parsing table: " + parsedTableName, ex); //$NON-NLS-1$
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
     * @since 3.11.5
     * @author galiev_mr
     */
    private void parseConstraints(PgConstraint constraint) {
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
     * @since 3.11.5
     * @author galiev_mr
     */
    private void parseColumns(PgColumn column) {
        PgData<?> c = PgDataType.dataForType(column.getType());
        c.setNotNull(!column.getNullValue());
        c.setName(column.getName());
        columns.add(c);
    }

    private class DataModifier implements ModifyListener {

        private final BiConsumer<PgData<?>, String> setter;

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
                } catch (Exception ex) {
                    Log.log(Log.LOG_INFO, "Invalid input", ex); //$NON-NLS-1$
                }
            }
        }
    }
}