package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
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

import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PATH;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.views.navigator.OpenProjectFromNavigator;

public class MockDataPage extends WizardPage {

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();
    private static final DateTimeFormatter FILE_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd HH''mm''ss"); //$NON-NLS-1$

    private int count = 1;
    private final List <Map<String, Object>> columns = new ArrayList<>();
    private ScrolledComposite scrolledComposite;
    private Composite composite;
    private IProject proj;
    private String tableName;
    private int rowCount;

    private enum Types {
        BIGINT,
        BIT,
        BOOLEAN,
        CHARACTER,
        DATE,
        DOUBLE,
        INTEGER,
        JSON,
        NUMERIC,
        REAL,
        SMALLINT,
        TEXT,
        OTHER
    }

    private static final String[] COLUMN_NAMES = new String[] {
            "Column name",
            "Column type",
            "Range start",
            "Range end"
    };


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
        StringBuilder sb = new StringBuilder("INSERT INTO ");
        sb.append(tableName);
        sb.append(" (");

        columns.forEach((v) -> {
            sb.append(v.get(COLUMN_NAMES[0]));
            sb.append(", ");
        });

        sb.setLength(sb.length() - 2);
        sb.append(") VALUES \n\t");

        for (int i = 0; i < rowCount; i++) {
            sb.append("(");

            columns.forEach((v) -> {
                sb.append(generateValue((Types)v.get(COLUMN_NAMES[1]),
                        (String)v.get(COLUMN_NAMES[2]), (String)v.get(COLUMN_NAMES[3])));
                sb.append(", ");
            });
            sb.setLength(sb.length() - 2);
            sb.append("), \n\t");
        }
        sb.setLength(sb.length() - 4);
        sb.append(";");
        return sb.toString();
    }

    private Object generateValue(Types type, String rangeStart, String rangeEnd) {
        SecureRandom ran = new SecureRandom();
        switch (type) {
        case BOOLEAN: return rangeStart.equals(rangeEnd) ? rangeStart : Math.random() < 0.5;
        case SMALLINT:
        case INTEGER:
        case BIGINT:
            BigInteger bigEnd = new BigInteger(rangeEnd);
            BigInteger bigInteger = bigEnd.subtract(new BigInteger(rangeStart));
            BigInteger aRandomBigInt = new BigInteger(bigInteger.bitLength(), ran);
            return aRandomBigInt.subtract(bigEnd);
        case DATE:
            Long beginTime = Timestamp.valueOf(rangeStart).getTime();
            Long endTime = Timestamp.valueOf(rangeEnd).getTime();
            long diff = endTime - beginTime + 1;
            return "'" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                    .format(new Date(beginTime + (long) (Math.random() * diff))) + "'";
        case REAL: return (Float.parseFloat(rangeEnd) - Float.parseFloat(rangeStart))
                * ran.nextFloat() + Float.parseFloat(rangeStart);
        case NUMERIC:
        case DOUBLE: return (Double.parseDouble(rangeEnd) - Double.parseDouble(rangeStart))
                * ran.nextDouble() + Double.parseDouble(rangeStart);
        case BIT:
        case CHARACTER: return "'" + (char)(ran.nextInt(26) + 'a') + "'";
        case JSON: return "'{key: value}'";
        case TEXT: return "'Text'";
        default: return null;
        }
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
        container.setLayout(new FillLayout());

        scrolledComposite = new ScrolledComposite(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setExpandVertical(true);

        composite = new Composite(scrolledComposite, SWT.NONE);
        composite.setLayout(new GridLayout(1, false));
        scrolledComposite.setContent(composite);
        scrolledComposite.setSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

        final Composite composite_1 = new Composite(composite, SWT.NONE);
        composite_1.setLayout(new GridLayout(2, false));
        composite_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

        final Label lblTableName = new Label(composite_1, SWT.NONE);
        lblTableName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblTableName.setText("Table name:");

        final Text txtTableName = new Text(composite_1, SWT.NONE);
        txtTableName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
        if (tableName != null) {
            txtTableName.setText(tableName);
        }
        txtTableName.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                tableName = txtTableName.getText();
            }
        });

        final Label lblRowCount = new Label(composite_1, SWT.NONE);
        lblRowCount.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblRowCount.setText("Row count:");

        final Text txtRowCount = new Text(composite_1, SWT.NONE);
        txtRowCount.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        txtRowCount.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                rowCount = Integer.parseInt(txtRowCount.getText());
            }
        });
        txtRowCount.setText("10");

        final Composite composite_2 = new Composite(composite, SWT.NONE);
        composite_2.setLayout(new GridLayout(5, false));
        composite_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

        final Composite composite_3 = new Composite(composite, SWT.NONE);
        composite_3.setLayout(new GridLayout());
        composite_3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

        createHeader(composite_2);

        final Button btnAdd = new Button(composite_3, SWT.NONE);
        btnAdd.setText("Add");
        btnAdd.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(final SelectionEvent e) {
                createColumnRow(composite_2);
            }
        });

        setControl(container);
    }

    private void createHeader(Composite parent) {
        new Label(parent, SWT.NONE).setText(COLUMN_NAMES[0]);
        new Label(parent, SWT.NONE).setText(COLUMN_NAMES[1]);
        new Label(parent, SWT.NONE).setText(COLUMN_NAMES[2]);
        new Label(parent, SWT.NONE).setText(COLUMN_NAMES[3]);
        new Label(parent, SWT.NONE).setText("   X   ");

        if (columns.isEmpty()) {
            createColumnRow(parent);
        } else {
            columns.forEach((v) -> createColumnRow(parent));
        }
    }

    private void createColumnRow(Composite parent) {
        Map <String, Object> params = new HashMap<>(COLUMN_NAMES.length);

        final Text colName = new Text(parent, SWT.BORDER);
        colName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        colName.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                params.put(COLUMN_NAMES[0], colName.getText());
            }
        });
        colName.setText("c" + count++);

        final ComboViewer colType = new ComboViewer(parent, SWT.BORDER | SWT.READ_ONLY);
        colType.getControl().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        final Text txtRangeStart = new Text(parent, SWT.BORDER);
        txtRangeStart.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        txtRangeStart.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                params.put(COLUMN_NAMES[2], txtRangeStart.getText());
            }
        });

        final Text txtRangeEnd = new Text(parent, SWT.BORDER);
        txtRangeEnd.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        txtRangeEnd.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                params.put(COLUMN_NAMES[3], txtRangeEnd.getText());
            }
        });

        columns.add(params);

        colType.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                StructuredSelection sel = (StructuredSelection) colType.getSelection();
                Types element = (Types) sel.getFirstElement();
                setDefaultValues(element, txtRangeStart, txtRangeEnd);
                params.put(COLUMN_NAMES[1], element);
            }
        });
        colType.add(Types.values());
        colType.setSelection(new StructuredSelection(Types.INTEGER));



        final Button delete = new Button(parent, SWT.NONE);
        delete.setText("Delete");
        delete.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(final SelectionEvent e) {
                if (columns.size() == 1 ) {
                    setErrorMessage("You can not delete last column");
                    return;
                }
                colName.dispose();
                colType.getControl().dispose();
                txtRangeStart.dispose();
                txtRangeEnd.dispose();
                delete.dispose();
                columns.remove(params);
                scrolledComposite.layout(true, true);
                scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
            }
        });

        scrolledComposite.layout(true, true);
        scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
    }

    private void setDefaultValues(Types element, Text txtRangeStart,
            Text txtRangeEnd) {
        switch (element) {
        case BOOLEAN:
            txtRangeStart.setText("false");
            txtRangeEnd.setText("true");
            break;
        case SMALLINT:
            txtRangeStart.setText("-32768");
            txtRangeEnd.setText("32767");
            break;
        case INTEGER:
            txtRangeStart.setText("-2147483648");
            txtRangeEnd.setText("2147483647");
            break;
        case BIGINT:
            txtRangeStart.setText("-9223372036854775808");
            txtRangeEnd.setText("9223372036854775807");
            break;
        case DATE:
            txtRangeStart.setText("2000-01-01 00:00:00");
            txtRangeEnd.setText("2030-12-31 23:59:59");
            break;
        case REAL:
            txtRangeStart.setText("0.000001");
            txtRangeEnd.setText("99.999999");
            break;
        case NUMERIC:
            txtRangeStart.setText("0.1");
            txtRangeEnd.setText("99.999999999999999");
            break;
        case DOUBLE:
            txtRangeStart.setText("0.000000000000001");
            txtRangeEnd.setText("99.999999999999999");
            break;
        case BIT:
            txtRangeStart.setText("1");
            txtRangeEnd.setText("255");
            break;
        case CHARACTER:
            txtRangeStart.setText("1");
            txtRangeEnd.setText("255");
            break;
        case JSON:
            txtRangeStart.setText("1");
            txtRangeEnd.setText("255");
            break;
        case TEXT:
            txtRangeStart.setText("10");
            txtRangeEnd.setText("255");
            break;
        default:
            txtRangeStart.setText("");
            txtRangeEnd.setText("");
        }
        scrolledComposite.layout(true, true);
        scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
    }

    private void parseSelection(IStructuredSelection selection) {
        Object source = selection.getFirstElement();
        if (source instanceof IFile) {
            IFile file = (IFile)source;
            if ("TABLE".equals(file.getParent().getName())) {
                tableName = file.getName().replaceAll(".sql", "");
            }
        }
        if (source instanceof IResource) {
            proj = ((IResource) source).getProject();
        } else if (source instanceof OpenProjectFromNavigator) {
            proj = ((OpenProjectFromNavigator)source).getProject();
        }
    }
}