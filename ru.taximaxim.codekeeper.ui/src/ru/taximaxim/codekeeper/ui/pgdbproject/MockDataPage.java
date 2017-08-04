package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.part.FileEditorInput;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.CustomSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParserBaseListener;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;
import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.apgdiff.licensing.License;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PATH;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.generators.PgData;
import ru.taximaxim.codekeeper.ui.generators.PgDataGenerator;
import ru.taximaxim.codekeeper.ui.generators.PgDataType;
import ru.taximaxim.codekeeper.ui.generators.PgDataWrapper;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.views.navigator.OpenProjectFromNavigator;

/**
 *  Page of the creating mock data for PostgreSql data
 *
 *  @since 3.11.5
 *  @author galiev_mr
 *  @see PgData
 */
public class MockDataPage extends WizardPage {

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();
    private static final DateTimeFormatter FILE_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd HH''mm''ss"); //$NON-NLS-1$

    private int count = 1;
    private final List <PgDataWrapper> columns = new ArrayList<>();
    private IProject proj;
    private String tableName = "t1"; //$NON-NLS-1$
    private String schemaName = "public"; //$NON-NLS-1$
    private int rowCount = 20;

    private ComboViewer cmbType, cmbGeneration;
    private Button btnIsUnique, btnIsNotNull;
    private Text txtColumnName, txtStart, txtEnd, txtStep, txtLength, txtRowCount;

    private TableViewer viewer;

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
    public boolean createFile() {
        if (!isValid()) {
            return false;
        }

        IEditorInput file = null;
        try {
            boolean mode = false;
            String creationMode = mainPrefs.getString(DB_UPDATE_PREF.CREATE_SCRIPT_IN_PROJECT);
            // if select "YES" with toggle
            if (creationMode.equals(MessageDialogWithToggle.ALWAYS)) {
                mode = true;
                // if not select "NO" with toggle, show choice message dialog
            } else if (!creationMode.equals(MessageDialogWithToggle.NEVER)) {
                MessageDialogWithToggle dialog = MessageDialogWithToggle.openYesNoQuestion(getShell(),
                        Messages.ProjectEditorDiffer_script_creation_title, Messages.ProjectEditorDiffer_script_creation_message,
                        Messages.remember_choice_toggle, false, mainPrefs, DB_UPDATE_PREF.CREATE_SCRIPT_IN_PROJECT);
                if (dialog.getReturnCode() == IDialogConstants.YES_ID) {
                    mode = true;
                }
            }
            file = createScriptFile(mode, generateInsert());
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
            .openEditor(file, EDITOR.ROLLON);
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
        if (tableName == null || tableName.length() == 0) {
            err = Messages.MockDataPage_empty_table_name;
        }

        if (err == null) {
            try {
                rowCount = Integer.valueOf(txtRowCount.getText());
            } catch (NumberFormatException ex) {
                err = Messages.MockDataPage_incorrect_row_count;
            }
        }

        if (err == null) {
            for (PgDataWrapper wrapper : columns) {
                try {
                    wrapper.generateValue();
                } catch (NumberFormatException e) {
                    err = Messages.MockDataPage_column_wrong_format + wrapper.getName();
                } catch (IllegalArgumentException ex) {
                    err = Messages.MockDataPage_date_wrong_format + wrapper.getName();
                }
            }
        }

        if (err == null) {
            for (PgDataWrapper wrapper : columns) {
                if (wrapper.isUnique() && wrapper.getGenerator() == PgDataGenerator.RANDOM
                        && wrapper.getMaxValues() < rowCount) {
                    err = Messages.MockDataPage_maximum_value
                            + wrapper.getName() + ": " + wrapper.getMaxValues(); //$NON-NLS-1$
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
        StringBuilder sb = new StringBuilder("SET search_path = "); //$NON-NLS-1$
        sb.append(schemaName.length() == 0 ? "public" : schemaName); //$NON-NLS-1$
        sb.append(", pg_catalog;\n\nINSERT INTO "); //$NON-NLS-1$
        sb.append(tableName);
        sb.append(" ("); //$NON-NLS-1$

        columns.forEach(v -> {
            sb.append(v.getName());
            sb.append(", "); //$NON-NLS-1$
        });

        sb.setLength(sb.length() - 2);
        sb.append(") VALUES \n\t"); //$NON-NLS-1$

        columns.forEach(w -> w.reset());
        for (int i = 0; i < rowCount; i++) {
            sb.append("("); //$NON-NLS-1$
            columns.forEach(v -> {
                sb.append(v.generateValue());
                sb.append(", "); //$NON-NLS-1$
            });
            sb.setLength(sb.length() - 2);
            sb.append("), \n\t"); //$NON-NLS-1$
        }
        sb.setLength(sb.length() - 4);
        sb.append(';');
        return sb.toString();
    }

    /**
     * Generates file with insert query
     *
     * @param mode The generation mode, if true generates a script in the project directory,
     * otherwise generates a temporary file that will be deleted after the shutdown
     * @param insert String with insert query
     * @return IEditorInput with generated file as a resource
     * @throws IOException - if an I/O error occurs or the temporary-file directory does not exist
     * @throws CoreException - if file creation is failed
     * @since 3.11.5
     * @author galiev_mr
     */
    private IEditorInput createScriptFile(boolean mode, String insert) throws CoreException, IOException {
        String name = FILE_DATE.format(LocalDateTime.now()) + " insert to " + tableName ; //$NON-NLS-1$
        name = FileUtils.INVALID_FILENAME.matcher(name).replaceAll(""); //$NON-NLS-1$
        Log.log(Log.LOG_INFO, "Creating file " + name); //$NON-NLS-1$
        if (mode && proj != null) {
            IProject iProject = proj.getProject();
            IFolder folder = iProject.getFolder(PROJ_PATH.MIGRATION_DIR);
            if (!folder.exists()){
                folder.create(IResource.NONE, true, null);
            }
            IFile file = folder.getFile(name + ".sql"); //$NON-NLS-1$
            InputStream source = new ByteArrayInputStream(insert.getBytes());
            file.create(source, IResource.NONE, null);
            return new FileEditorInput(iProject.getFile(file.getProjectRelativePath()));
        } else {
            Path path = Files.createTempFile(name + '_', ".sql"); //$NON-NLS-1$
            Files.write(path, insert.getBytes());
            IFileStore externalFile = EFS.getLocalFileSystem().fromLocalFile(path.toFile());
            return new FileStoreEditorInput(externalFile);
        }
    }

    @Override
    public void createControl(Composite parent) {
        final Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(5, false));
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        new Label(container, SWT.NONE).setText(Messages.MockDataPage_schema_name);

        final Text txtSchemaName = new Text(container, SWT.BORDER);
        txtSchemaName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1));
        txtSchemaName.setText(schemaName);
        txtSchemaName.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                schemaName = txtSchemaName.getText();
            }
        });

        final Composite columnInfo = createColumnInfo(container);
        columnInfo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 5));

        new Label(container, SWT.NONE).setText(Messages.MockDataPage_table_name);

        final Text txtTableName = new Text(container, SWT.BORDER);
        txtTableName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1));
        txtTableName.setText(tableName);
        txtTableName.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                tableName = txtTableName.getText();
            }
        });

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

        final Button btnDelete = new Button(container, SWT.NONE);
        btnDelete.setText(Messages.MockDataPage_delete_column);
        btnDelete.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                StructuredSelection sel = (StructuredSelection) viewer.getSelection();
                if (!sel.isEmpty() && columns.size() != 1) {
                    PgDataWrapper wrapper = (PgDataWrapper) sel.getFirstElement();
                    int index = columns.indexOf(wrapper);
                    columns.remove(wrapper);
                    if (index == columns.size()) {
                        index--;
                    }
                    viewer.setSelection(new StructuredSelection(columns.get(index)));
                    if (columns.size() == 1) {
                        btnDelete.setEnabled(false);
                    }
                    viewer.refresh();
                }
            }
        });

        final Button btnUp = new Button(container, SWT.NONE);
        btnUp.setText(Messages.MockDataPage_column_up);
        btnUp.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                StructuredSelection sel = (StructuredSelection) viewer.getSelection();
                if (!sel.isEmpty() && columns.size() != 1) {
                    PgDataWrapper wrapper = (PgDataWrapper) sel.getFirstElement();
                    int index = columns.indexOf(wrapper);
                    Collections.swap(columns, index, index - 1);
                    viewer.setSelection(new StructuredSelection(wrapper));
                    viewer.refresh();
                }
            }
        });

        final Button btnDown = new Button(container, SWT.NONE);
        btnDown.setText(Messages.MockDataPage_column_down);
        btnDown.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                StructuredSelection sel = (StructuredSelection) viewer.getSelection();
                if (!sel.isEmpty() && columns.size() != 1) {
                    PgDataWrapper wrapper = (PgDataWrapper) sel.getFirstElement();
                    int index = columns.indexOf(wrapper);
                    Collections.swap(columns, index, index + 1);
                    viewer.setSelection(new StructuredSelection(wrapper));
                    viewer.refresh();
                }
            }
        });

        btnAdd.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                PgDataWrapper wrapper = new PgDataWrapper();
                wrapper.setName("c" + count++); //$NON-NLS-1$
                columns.add(wrapper);
                viewer.refresh();
                viewer.setSelection(new StructuredSelection(wrapper));
                btnDelete.setEnabled(true);
                viewer.refresh();
            }
        });

        viewer.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                StructuredSelection sel = (StructuredSelection) event.getSelection();
                if (!sel.isEmpty()) {
                    PgDataWrapper wrapper = (PgDataWrapper) sel.getFirstElement();
                    showColumnInfo(wrapper);
                    if (columns.size() == 1) {
                        btnUp.setEnabled(false);
                        btnDown.setEnabled(false);
                    } else {
                        int index = columns.indexOf(wrapper);
                        btnUp.setEnabled(index != 0);
                        btnDown.setEnabled(index != columns.size() - 1);
                    }
                }
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

        Composite composite = new Composite(parent, SWT.BORDER);
        composite.setLayout(new GridLayout(2,  false));

        new Label(composite, SWT.NONE).setText(Messages.MockDataPage_column_name);

        txtColumnName = new Text(composite, SWT.BORDER);
        txtColumnName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtColumnName.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                StructuredSelection sel = (StructuredSelection) viewer.getSelection();
                if (!sel.isEmpty()) {
                    PgDataWrapper wrapper = (PgDataWrapper) sel.getFirstElement();
                    wrapper.setName(txtColumnName.getText());
                    viewer.refresh();
                }
            }
        });

        new Label(composite, SWT.NONE).setText(Messages.MockDataPage_column_type);

        cmbType = new ComboViewer(composite);
        cmbType.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbType.add(PgDataType.values());
        cmbType.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                StructuredSelection sel = (StructuredSelection) viewer.getSelection();
                if (!sel.isEmpty()) {
                    PgDataWrapper wrapper = (PgDataWrapper) sel.getFirstElement();
                    wrapper.setType((PgDataType)((StructuredSelection)event.getSelection()).getFirstElement());
                    updateFields(wrapper);
                }
            }
        });

        new Label(composite, SWT.NONE).setText(Messages.MockDataPage_column_generator);

        cmbGeneration = new ComboViewer(composite);
        cmbGeneration.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbGeneration.add(PgDataGenerator.values());
        cmbGeneration.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                StructuredSelection sel = (StructuredSelection) viewer.getSelection();
                if (!sel.isEmpty()) {
                    PgDataWrapper wrapper = (PgDataWrapper) sel.getFirstElement();
                    PgDataGenerator gen = (PgDataGenerator)((StructuredSelection) event.getSelection()).getFirstElement();
                    wrapper.setGenerator(gen);
                    updateFields(wrapper);
                }
            }
        });

        btnIsUnique = new Button(composite, SWT.CHECK);
        btnIsUnique.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        btnIsUnique.setText("UNIQUE"); //$NON-NLS-1$
        btnIsUnique.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                StructuredSelection sel = (StructuredSelection) viewer.getSelection();
                if (!sel.isEmpty()) {
                    PgDataWrapper col = (PgDataWrapper) sel.getFirstElement();
                    col.setUnique(!col.isUnique());
                }
            }
        });

        btnIsNotNull = new Button(composite, SWT.CHECK);
        btnIsNotNull.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        btnIsNotNull.setText("NOT NULL"); //$NON-NLS-1$
        btnIsNotNull.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                StructuredSelection sel = (StructuredSelection) viewer.getSelection();
                if (!sel.isEmpty()) {
                    PgDataWrapper col = (PgDataWrapper) sel.getFirstElement();
                    col.setNotNull(!col.isNotNull());
                }
            }
        });

        new Label(composite, SWT.NONE).setText(Messages.MockDataPage_range_start);

        txtStart = new Text(composite, SWT.BORDER);
        txtStart.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtStart.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                StructuredSelection sel = (StructuredSelection) viewer.getSelection();
                if (!sel.isEmpty()) {
                    PgDataWrapper wrapper = (PgDataWrapper) sel.getFirstElement();
                    wrapper.setStart(txtStart.getText());
                }
            }
        });

        new Label(composite, SWT.NONE).setText(Messages.MockDataPage_range_end);

        txtEnd = new Text(composite, SWT.BORDER);
        txtEnd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtEnd.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                StructuredSelection sel = (StructuredSelection) viewer.getSelection();
                if (!sel.isEmpty()) {
                    PgDataWrapper wrapper = (PgDataWrapper) sel.getFirstElement();
                    wrapper.setEnd(txtEnd.getText());
                }
            }
        });

        new Label(composite, SWT.NONE).setText(Messages.MockDataPage_step);

        txtStep = new Text(composite, SWT.BORDER);
        txtStep.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtStep.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                StructuredSelection sel = (StructuredSelection) viewer.getSelection();
                if (!sel.isEmpty()) {
                    PgDataWrapper wrapper = (PgDataWrapper) sel.getFirstElement();
                    wrapper.setStep(txtStep.getText());
                }
            }
        });

        new Label(composite, SWT.NONE).setText(Messages.MockDataPage_length);

        txtLength = new Text(composite, SWT.BORDER);
        txtLength.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtLength.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                StructuredSelection sel = (StructuredSelection) viewer.getSelection();
                if (!sel.isEmpty()) {
                    PgDataWrapper wrapper = (PgDataWrapper) sel.getFirstElement();
                    wrapper.setLength(txtLength.getText());
                }
            }
        });

        return composite;
    }

    /**
     * Fills the block with information about the column
     *
     * @param wrapper Selected column wrapper
     * @since 3.11.5
     * @author galiev_mr
     */
    private void showColumnInfo(PgDataWrapper wrapper) {
        txtColumnName.setText(wrapper.getName());
        cmbType.setSelection(new StructuredSelection(wrapper.getType()));
        txtStart.setText(wrapper.getStart());
        txtEnd.setText(wrapper.getEnd());
        txtStep.setText(wrapper.getStep());
        txtLength.setText(wrapper.getLength());
        btnIsUnique.setSelection(wrapper.isUnique());
        btnIsNotNull.setSelection(wrapper.isNotNull());
        cmbGeneration.setSelection(new StructuredSelection(wrapper.getGenerator()));
    }

    /**
     * Enable and disable fields when changing the generator and type
     *
     * @param wrapper Selected column wrapper
     * @since 3.11.5
     * @author galiev_mr
     */
    private void updateFields(PgDataWrapper wrapper) {
        PgDataType type = wrapper.getType();
        PgDataGenerator gen = wrapper.getGenerator();
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
        viewer.refresh();
    }

    /**
     * Creates columns for the top level viewer
     *
     * @param viewer Parent viewer
     * @since 3.11.5
     * @author galiev_mr
     */
    private void addColumns(TableViewer viewer) {
        TableViewerColumn name = new TableViewerColumn(viewer, SWT.NONE);
        name.getColumn().setResizable(true);
        name.getColumn().setText(Messages.MockDataPage_column_name);
        name.getColumn().setResizable(true);
        name.getColumn().setMoveable(true);
        name.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                PgDataWrapper wrapper = (PgDataWrapper) element;
                return wrapper.getName();
            }
        });

        TableViewerColumn type = new TableViewerColumn(viewer, SWT.NONE);
        type.getColumn().setResizable(true);
        type.getColumn().setText(Messages.MockDataPage_column_type);
        type.getColumn().setResizable(true);
        type.getColumn().setMoveable(true);
        type.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                PgDataWrapper wrapper = (PgDataWrapper) element;
                return wrapper.getType().getValue();
            }
        });

        TableViewerColumn generator = new TableViewerColumn(viewer, SWT.NONE);
        generator.getColumn().setResizable(true);
        generator.getColumn().setText(Messages.MockDataPage_column_generator);
        generator.getColumn().setResizable(true);
        generator.getColumn().setMoveable(true);
        generator.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                PgDataWrapper wrapper = (PgDataWrapper) element;
                PgDataGenerator gen = wrapper.getGenerator();
                return gen.getValue();
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
        if (source instanceof IResource) {
            proj = ((IResource) source).getProject();
        } else if (source instanceof OpenProjectFromNavigator) {
            proj = ((OpenProjectFromNavigator)source).getProject();
        }
        if (source instanceof IFile && "TABLE".equals(((IFile) source).getParent().getName())) { //$NON-NLS-1$
            IFile file = (IFile)source;
            tableName = file.getName().replaceAll(".sql", ""); //$NON-NLS-1$ //$NON-NLS-2$
            schemaName = file.getParent().getParent().getName();
            try {
                // TODO change to the method from the master branch after merging the branch 13091
                PgDiffArguments args = new PgDiffArguments();
                args.setLicense(new License(Activator.getDefault().getPreferenceStore().getString(PREF.LICENSE_PATH)));
                PgDatabase db = new PgDatabase();
                db.setArguments(args);
                db.addSchema(new PgSchema(schemaName, null));
                SQLParserBaseListener listener = new CustomSQLParserListener(db, tableName, null, null);
                AntlrParser.parseSqlStream(new FileInputStream(file.getRawLocation().makeAbsolute().toFile()),
                        args.getInCharsetName(), tableName, listener, null, 0, null);
                PgTable table = db.getSchema(schemaName).getTable(tableName);
                table.getColumns().forEach(col -> parseColumns(col));
                table.getConstraints().forEach(con -> parseConstraints(con));
            } catch (IOException | LicenseException | InterruptedException ex) {
                Log.log(Log.LOG_ERROR, "Error while parse document: " + tableName); //$NON-NLS-1$
            }
        } else {
            PgDataWrapper wrapper = new PgDataWrapper();
            wrapper.setName("id"); //$NON-NLS-1$
            count++;
            columns.add(wrapper);
        }
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
        String type = column.getType();
        PgDataWrapper wrapper = new PgDataWrapper(type);
        wrapper.setNotNull(!column.getNullValue());
        wrapper.setName(column.getName());
        count++;
        columns.add(wrapper);
    }
}