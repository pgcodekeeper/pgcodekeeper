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
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.part.FileEditorInput;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.CustomSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParserBaseListener;
import cz.startnet.utils.pgdiff.schema.PgColumn;
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
import ru.taximaxim.codekeeper.ui.generators.PgDataColumn;
import ru.taximaxim.codekeeper.ui.generators.PgDataType;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.views.navigator.OpenProjectFromNavigator;

public class MockDataPage extends WizardPage {

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();
    private static final DateTimeFormatter FILE_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd HH''mm''ss"); //$NON-NLS-1$

    private int count = 1;
    private final List <PgDataColumn> columns = new ArrayList<>();
    private IProject proj;
    private String tableName = "t1";
    private String schemaName = "public";
    private int rowCount = 20;


    private ComboViewer cmbType, cmbGeneration;
    private Button btnIsUnique;
    private Text txtColumnName, txtStart, txtEnd, txtStep, txtLenght;

    public MockDataPage(String pageName, IStructuredSelection selection) {
        super(pageName);
        setTitle(pageName);
        parseSelection(selection);
        setDescription("Create mock data for table");
    }

    public boolean createFile() {
        setErrorMessage(null);

        if (tableName == null || tableName.length() == 0) {
            setErrorMessage("Table name can not be null");
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
        } catch (CoreException | IOException ex) {
            ExceptionNotifier.notifyDefault(
                    Messages.ProjectEditorDiffer_error_creating_file, ex);
        }
        if (file != null) {
            try {
                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .openEditor(file, EDITOR.ROLLON);
                return true;
            } catch (PartInitException e) {
                ExceptionNotifier.notifyDefault(
                        Messages.ProjectEditorDiffer_error_creating_file, e);
            }
        }

        return false;
    }

    private String generateInsert() {
        StringBuilder sb = new StringBuilder("SET search_path = ");
        sb.append(schemaName.length() == 0 ? "public" : schemaName);
        sb.append(", pg_catalog;\n\nINSERT INTO ");
        sb.append(tableName);
        sb.append(" (");

        columns.forEach(v -> {
            sb.append(v.getName());
            sb.append(", ");
        });

        sb.setLength(sb.length() - 2);
        sb.append(") VALUES \n\t");

        for (int i = 0; i < rowCount; i++) {
            sb.append("(");
            columns.forEach(v -> {
                sb.append(v.generateValue());
                sb.append(", ");
            });
            sb.setLength(sb.length() - 2);
            sb.append("), \n\t");
        }
        sb.setLength(sb.length() - 4);
        sb.append(";");
        return sb.toString();
    }


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
        container.setLayout(new GridLayout(4, false));
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        new Label(container, SWT.NONE).setText("Schema name");

        final Text txtSchemaName = new Text(container, SWT.BORDER);
        txtSchemaName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
        txtSchemaName.setText(schemaName);
        txtSchemaName.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                schemaName = txtSchemaName.getText();
            }
        });

        final Composite columnInfo = createColumnInfo(container);
        columnInfo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 5));

        new Label(container, SWT.NONE).setText("Table name");

        final Text txtTableName = new Text(container, SWT.BORDER);
        txtTableName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
        txtTableName.setText(tableName);
        txtTableName.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                tableName = txtTableName.getText();
            }
        });

        new Label(container, SWT.NONE).setText("Row count");

        final Text txtRowCount = new Text(container, SWT.BORDER);
        txtRowCount.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
        txtRowCount.setText("20");

        //allowed values: number between 1 and 10000
        txtRowCount.addVerifyListener(new VerifyListener() {

            @Override
            public void verifyText(VerifyEvent e) {
                String currentText = ((Text)e.widget).getText();
                String newText = currentText.substring(0, e.start) + e.text + currentText.substring(e.end);
                try {
                    if (!"".equals(newText)) {
                        int curNumber = Integer.valueOf (newText);
                        if (curNumber < 1 || curNumber > 10000) {
                            e.doit = false;
                        } else {
                            rowCount = curNumber;
                        }
                    }
                } catch (NumberFormatException ex) {
                    e.doit = false;
                }
            }
        });

        final TableViewer viewer = new TableViewer(container, SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
        viewer.setContentProvider(ArrayContentProvider.getInstance());
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 2);

        viewer.getTable().setLayoutData(gd);
        viewer.getTable().setLinesVisible(true);
        viewer.getTable().setHeaderVisible(true);

        addColumns(viewer);

        viewer.setInput(columns);

        viewer.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                StructuredSelection sel = (StructuredSelection) event.getSelection();
                if (!sel.isEmpty()) {
                    PgDataColumn col = (PgDataColumn) sel.getFirstElement();
                    showColumnInfo(col);
                }
            }
        });

        Button btnAdd = new Button(container, SWT.NONE);
        btnAdd.setText("Add column");
        btnAdd.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                PgDataColumn col = new PgDataColumn();
                col.setName("c" + count++);
                col.setType(PgDataType.INTEGER);
                columns.add(col);
                viewer.refresh();
            }
        });

        Button btnDelete = new Button(container, SWT.NONE);
        btnDelete.setText("Delete column");
        btnDelete.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                StructuredSelection sel = (StructuredSelection) viewer.getSelection();
                if (!sel.isEmpty()) {
                    PgDataColumn col = (PgDataColumn) sel.getFirstElement();
                    columns.remove(col);
                    viewer.refresh();
                }
            }
        });

        setControl(container);
    }

    private Composite createColumnInfo(Composite parent) {
        String [] GEN  = {"RANDOM", "INCREMENT", "CONSTANT"};

        Composite composite = new Composite(parent, SWT.BORDER);
        composite.setLayout(new GridLayout(2,  false));

        new Label(composite, SWT.NONE).setText("Name");

        txtColumnName = new Text(composite, SWT.BORDER);
        txtColumnName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(composite, SWT.NONE).setText("Type");

        cmbType = new ComboViewer(composite);
        cmbType.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbType.add(PgDataType.values());

        new Label(composite, SWT.NONE).setText("Generator");

        cmbGeneration = new ComboViewer(composite);
        cmbGeneration.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        cmbGeneration.add(GEN);

        btnIsUnique = new Button(composite, SWT.CHECK);
        btnIsUnique.setLayoutData(new GridData(GridData.FILL_HORIZONTAL, GridData.FILL_VERTICAL, false, false, 2, 1));
        btnIsUnique.setText("UNIQUE");

        new Label(composite, SWT.NONE).setText("Range start");

        txtStart = new Text(composite, SWT.BORDER);
        txtStart.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(composite, SWT.NONE).setText("Range end");

        txtEnd = new Text(composite, SWT.BORDER);
        txtEnd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(composite, SWT.NONE).setText("Increment step");

        txtStep = new Text(composite, SWT.BORDER);
        txtStep.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        new Label(composite, SWT.NONE).setText("Text lenght");

        txtLenght = new Text(composite, SWT.BORDER);
        txtLenght.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        return composite;
    }


    private void showColumnInfo(PgDataColumn column) {
        txtColumnName.setText(column.getName());
        cmbType.setSelection(new StructuredSelection(column.getType()));
        txtStart.setText(column.getBegin());
        txtEnd.setText(column.getEnd());
        txtStep.setText(column.getStep());
        txtLenght.setText(column.getLenght());
        btnIsUnique.setSelection(column.isUnique());
        cmbGeneration.setSelection(new StructuredSelection(column.getGenerator().getName()));
    }

    private void addColumns(TableViewer viewer) {
        TableViewerColumn name = new TableViewerColumn(viewer, SWT.NONE);
        name.getColumn().setResizable(true);
        name.getColumn().setText("Name");
        name.getColumn().setResizable(true);
        name.getColumn().setMoveable(true);
        name.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                PgDataColumn col = (PgDataColumn) element;
                return col.getName();
            }
        });

        TableViewerColumn type = new TableViewerColumn(viewer, SWT.NONE);
        type.getColumn().setResizable(true);
        type.getColumn().setText("Type");
        type.getColumn().setResizable(true);
        type.getColumn().setMoveable(true);
        type.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                PgDataColumn col = (PgDataColumn) element;
                return col.getType().getValue();
            }
        });

        TableViewerColumn generator = new TableViewerColumn(viewer, SWT.NONE);
        generator.getColumn().setResizable(true);
        generator.getColumn().setText("Generator");
        generator.getColumn().setResizable(true);
        generator.getColumn().setMoveable(true);
        generator.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                PgDataColumn col = (PgDataColumn) element;
                return col.getGenerator().getName();
            }
        });


        int width = (int)(viewer.getTable().getSize().x * 0.33);
        name.getColumn().setWidth(Math.max(width, 200));
        type.getColumn().setWidth(Math.max(width, 200));
        generator.getColumn().setWidth(Math.max(width, 200));
    }

    private void parseSelection(IStructuredSelection selection) {
        Object source = selection.getFirstElement();
        if (source instanceof IResource) {
            proj = ((IResource) source).getProject();
        } else if (source instanceof OpenProjectFromNavigator) {
            proj = ((OpenProjectFromNavigator)source).getProject();
        }
        if (source instanceof IFile) {
            IFile file = (IFile)source;
            if ("TABLE".equals(file.getParent().getName())) {
                tableName = file.getName().replaceAll(".sql", "");
                schemaName = file.getParent().getParent().getName();
                try {
                    PgDiffArguments args = new PgDiffArguments();
                    args.setLicense(new License(Activator.getDefault().getPreferenceStore().getString(PREF.LICENSE_PATH)));
                    PgDatabase db = new PgDatabase();
                    db.setArguments(args);
                    db.addSchema(new PgSchema(schemaName, null));
                    SQLParserBaseListener listener = new CustomSQLParserListener(db, tableName, null, null);
                    AntlrParser.parseSqlStream(new FileInputStream(file.getRawLocation().makeAbsolute().toFile()),
                            args.getInCharsetName(), tableName, listener, null, 0, null);
                    PgTable table = db.getSchema(schemaName).getTable(tableName);
                    table.getColumns().forEach((col) -> parseColumn(col));
                } catch (IOException | LicenseException | InterruptedException ex) {
                    Log.log(Log.LOG_ERROR, "Error while parse document: " + tableName); //$NON-NLS-1$
                }
            }
        }
    }

    private void parseColumn(PgColumn col) {
        String type = col.getType();
        PgDataColumn column = new PgDataColumn();
        column.setName(col.getName());

        for (PgDataType pgDataType : PgDataType.values()) {
            if (pgDataType.getValue().equalsIgnoreCase(type)) {
                column.setType(pgDataType);
                count++;
                columns.add(column);
                return;
            }
        }

        if (type.startsWith("bit")) {
            column.setType(PgDataType.BIT);
            column.setEnd(getLength(type));
        } else if ((type.startsWith("character"))) {
            column.setType(PgDataType.CHARACTER);
            column.setLenght(getLength(type));
        } else {
            column.setType(PgDataType.OTHER);
        }

        count++;
        columns.add(column);
    }

    private String getLength(String s) {
        return s.substring(s.indexOf("(") + 1 , s.indexOf(")"));
    }
}