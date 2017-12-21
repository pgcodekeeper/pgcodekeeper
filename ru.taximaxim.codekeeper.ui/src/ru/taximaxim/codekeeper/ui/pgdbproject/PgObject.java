package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

class PgObject extends WizardPage {

    private static final String SPLITTER = "\\."; //$NON-NLS-1$
    private static final String POSTFIX = ".sql"; //$NON-NLS-1$
    private static final String GROUP_DELIMITER =
            "\n--------------------------------------------------------------------------------\n\n"; //$NON-NLS-1$
    private static final String DEFAULT_SCHEMA = "public"; //$NON-NLS-1$
    private static final String OWNER_TO = "\n\nALTER {0} {1} OWNER TO CURRENT_DB_USER;\n"; //$NON-NLS-1$
    private static final String PATTERN = "CREATE {0} {1};"; //$NON-NLS-1$

    private static final String RULE_PATTERN = "CREATE RULE {1} AS\n\tON UPDATE TO {0} DO NOTHING;\n";//$NON-NLS-1$
    private static final String TRIGGER_PATTERN = "CREATE TRIGGER {1}\n\tBEFORE UPDATE ON {0}" //$NON-NLS-1$
            + "\n\tFOR EACH STATEMENT\n\tEXECUTE PROCEDURE function_name_placeholder();\n"; //$NON-NLS-1$
    private static final String CONSTRAINT_PATTERN = "ALTER TABLE {0}\n\tADD CONSTRAINT {1}" //$NON-NLS-1$
            + " PRIMARY KEY ({2});\n"; //$NON-NLS-1$
    private static final String INDEX_PATTERN = "CREATE INDEX {2} ON {0} USING btree ({1});\n"; //$NON-NLS-1$

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();

    private final IStructuredSelection selection;
    private Text txtName;
    private ComboViewer viewerProject;
    private ComboViewer viewerType;
    private Group group;

    private DbObjType type;
    private String currentProj;
    private boolean parentIsTable;

    protected PgObject(String pageName, IStructuredSelection selection) {
        super(pageName);
        this.selection = selection;
        setTitle(pageName);
    }

    @Override
    public void createControl(Composite parent) {
        Composite area = new Composite(parent, SWT.NONE);
        area.setLayout(new GridLayout(2, false));
        area.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        new Label(area, SWT.NONE).setText(Messages.PgObject_project_name);
        viewerProject = new ComboViewer(area, SWT.READ_ONLY | SWT.DROP_DOWN);

        new Label(area, SWT.NONE).setText(Messages.PgObject_object_type);
        viewerType = new ComboViewer(area, SWT.READ_ONLY | SWT.DROP_DOWN);

        new Label(area, SWT.NONE).setText(Messages.PgObject_object_name);
        txtName = new Text(area, SWT.BORDER);
        txtName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtName.addModifyListener(e -> getWizard().getContainer().updateButtons());
        createAdditionalFields(area);
        fillProjects();
        fillTypes();
        setControl(area);
    }

    private void createAdditionalFields(Composite area) {
        group = new Group(area, SWT.SHADOW_IN);
        group.setText(Messages.PgObject_parent_type);
        group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
        group.setLayout(new GridLayout(2, true));

        Button btnTable = new Button(group, SWT.RADIO);
        btnTable.setText(Messages.PgObject_table);
        btnTable.setSelection(true);
        btnTable.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                parentIsTable = true;
                getWizard().getContainer().updateButtons();
            }
        });

        Button btnView = new Button(group, SWT.RADIO);
        btnView.setText(Messages.PgObject_view);
        btnView.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                parentIsTable = false;
                getWizard().getContainer().updateButtons();
            }
        });
    }

    private void fillProjects() {
        viewerProject.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        viewerProject.setContentProvider(ArrayContentProvider.getInstance());
        viewerProject.setLabelProvider(new LabelProvider() {

            @Override
            public String getText(Object element) {
                if (element instanceof IProject) {
                    return ((IProject)element).getName();
                }
                return super.getText(element);
            }
        });

        viewerProject.addSelectionChangedListener(e -> {
            Object element = e.getStructuredSelection().getFirstElement();
            if (element != null) {
                currentProj = ((IProject) element).getName();
            }
            getWizard().getContainer().updateButtons();
        });

        List<IProject> projectList = new LinkedList<>();
        IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        IProject[] projects = workspaceRoot.getProjects();

        try {
            for (IProject project : projects) {
                if (project.isOpen() && project.hasNature(NATURE.ID)) {
                    projectList.add(project);
                }
            }

            if (projectList.isEmpty()) {
                setErrorMessage(Messages.PgObject_cant_find_porojects);
            } else {
                viewerProject.setInput(projectList);
            }
        } catch (CoreException ex) {
            Log.log(Log.LOG_ERROR, "Project nature identifier error"
                    + ex.getLocalizedMessage(), ex);
        }

        Object element = selection.getFirstElement();
        if (element instanceof IResource) {
            IProject current = ((IResource)element).getProject();
            viewerProject.setSelection(new StructuredSelection(current));
        }
    }

    private void fillTypes() {
        viewerType.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        viewerType.setContentProvider(ArrayContentProvider.getInstance());
        viewerType.addSelectionChangedListener(e -> {
            type = (DbObjType) e.getStructuredSelection().getFirstElement();
            GridData data =  (GridData) group.getLayoutData();
            if (type == DbObjType.TRIGGER || type == DbObjType.RULE) {
                data.exclude = false;
            } else {
                data.exclude = true;
            }
            group.setVisible(!data.exclude);
            group.getParent().layout(false);
            getWizard().getContainer().updateButtons();
        });

        viewerType.setInput(EnumSet.complementOf(EnumSet.of(DbObjType.COLUMN,
                DbObjType.DATABASE, DbObjType.SEQUENCE)));

        String lastType = mainPrefs.getString(PREF.LAST_CREATED_OBJECT_TYPE);
        viewerType.setSelection(new StructuredSelection(
                lastType.isEmpty() ? DbObjType.SCHEMA : DbObjType.valueOf(lastType)));
    }

    private boolean parseName() {
        setErrorMessage(null);
        String name = txtName.getText();

        if (name.isEmpty()) {
            setDescription(Messages.PgObject_empty_name);
            return false;
        }

        if (viewerProject.getStructuredSelection().getFirstElement() == null) {
            setDescription(Messages.PgObject_select_project);
            return false;
        }

        String [] names = name.split(SPLITTER);
        String err = null;

        switch (type) {
        case EXTENSION:
        case SCHEMA:
            err = parseName(Messages.PgObject_desc,
                    Messages.PgObject_invalid_format_schema, 1, names);
            break;
        case CONSTRAINT:
        case INDEX:
            err = parseName(Messages.PgObject_full_desc_with_column,
                    Messages.PgObject_invalid_format_column, 4, names);
            break;
        case RULE:
        case TRIGGER:
            err = parseName(Messages.PgObject_full_desc,
                    Messages.PgObject_invalid_format_object, 3, names);
            break;
        default:
            err = parseName(Messages.PgObject_schema_desc,
                    Messages.PgObject_invalid_format_container, 2, names);
            break;
        }

        setErrorMessage(err);
        return err == null;
    }

    private String parseName(String desc, String error, int count, String... names) {
        if (names.length != count && names.length != count -1) {
            return error;
        }

        boolean isDefault = names.length == count -1;
        Object[] args = new String[count + 2];
        args[0] = type.name();
        args[1] = currentProj;
        if (isDefault) {
            args[2] = DEFAULT_SCHEMA;
        }
        System.arraycopy(names, 0, args, isDefault ? 3 : 2, names.length);
        setDescription(MessageFormat.format(desc, args));

        return null;
    }

    public boolean createFile () {
        String name = txtName.getText();
        String [] names = name.split(SPLITTER);
        try {
            int size = names.length;
            mainPrefs.setValue(PREF.LAST_CREATED_OBJECT_TYPE, type.toString());
            switch (type) {
            case EXTENSION:
                createExtension();
                break;
            case SCHEMA:
                createSchema(name, true);
                break;
            case TRIGGER:
            case RULE:
                createSubElement(size == 2 ? DEFAULT_SCHEMA : names[0],
                        names[size - 2], null, names[size - 1]);
                break;
            case CONSTRAINT:
            case INDEX:
                createSubElement(size == 3 ? DEFAULT_SCHEMA : names[0],
                        names[size - 3], names[size - 2], names[size - 1]);
                break;
            default:
                createObject(size == 1 ? DEFAULT_SCHEMA : names[0],
                        names[size - 1], type, true);
                break;
            }
        } catch (CoreException ex) {
            Log.log(Log.LOG_ERROR, Messages.PgObject_file_creation_error
                    + ex.getLocalizedMessage(), ex);
            setErrorMessage(Messages.PgObject_file_creation_error);
            return false;
        }

        return true;
    }

    private void createSubElement(String schema, String parent, String column,
            String name) throws CoreException {
        DbObjType parentType = DbObjType.TABLE;
        if (!parentIsTable && type == DbObjType.RULE || type == DbObjType.TRIGGER) {
            parentType = DbObjType.VIEW;
        }
        IFile file = createObject(schema, parent, parentType, false);
        StringBuilder sb = new StringBuilder(GROUP_DELIMITER);

        if (type == DbObjType.RULE) {
            sb.append(MessageFormat.format(RULE_PATTERN, parent, name));
        } else if (type == DbObjType.TRIGGER) {
            sb.append(MessageFormat.format(TRIGGER_PATTERN, parent, name));
        } else if (type == DbObjType.CONSTRAINT) {
            sb.append(MessageFormat.format(CONSTRAINT_PATTERN, parent, name, column));
        } else {
            sb.append(MessageFormat.format(INDEX_PATTERN, parent, name, column));
        }

        file.appendContents(new ByteArrayInputStream(sb.toString().getBytes()), true, true, null);
        openFileInEditor(file);
    }

    private IFile createObject(String schema, String name, DbObjType type, boolean open) throws CoreException {
        IFolder folder = getFolder(schema, type);
        IFile file = folder.getFile(name + POSTFIX);
        if (type == DbObjType.FUNCTION) {
            int paren = name.indexOf('(');
            if (paren != -1) {
                file = folder.getFile(name.substring(0, paren) + POSTFIX);
            }
        }
        StringBuilder sb = new StringBuilder("SET search_path = " + schema + ", pg_catalog;\n\nCREATE "+ type + ' ' + name); //$NON-NLS-1$ //$NON-NLS-2$
        InputStream stream;
        switch (type) {
        case TYPE:
            sb.append(';');
            break;
        case DOMAIN:
            sb.append(" AS datatype;"); //$NON-NLS-1$
            break;
        case FUNCTION:
            sb.append(" RETURNS void\n\tLANGUAGE sql\n\tAS $$ --function body \n$$;"); //$NON-NLS-1$
            break;
        case TABLE:
            sb.append(" (\n);"); //$NON-NLS-1$
            break;
        default:
            sb.append(" AS\n\tSELECT 'select_text'::text AS text;"); //$NON-NLS-1$
            break;
        }

        sb.append(MessageFormat.format(OWNER_TO, type, name));

        stream = new ByteArrayInputStream(sb.toString().getBytes());
        if (!file.exists()) {
            file.create(stream, false, null);
        }
        if (open) {
            openFileInEditor(file);
        }
        return file;
    }

    private void createExtension() throws CoreException {
        String name = txtName.getText();
        Object element = viewerProject.getStructuredSelection().getFirstElement();
        IFolder folder = ((IProject) element).getFolder(DbObjType.EXTENSION.name());
        if (!folder.exists()) {
            folder.create(false, true, null);
        }
        IFile extFile = folder.getFile(name + POSTFIX);
        if (!extFile.exists()) {
            String code = MessageFormat.format(PATTERN, DbObjType.EXTENSION, name);
            extFile.create(new ByteArrayInputStream(code.getBytes()), false, null);
        }
        openFileInEditor(extFile);
    }

    private IFolder createSchema(String name, boolean open) throws CoreException {
        Object element = viewerProject.getStructuredSelection().getFirstElement();
        IFolder projectFolder = ((IProject) element).getFolder(DbObjType.SCHEMA.name());
        if (!projectFolder.exists()) {
            projectFolder.create(false, true, null);
        }
        IFolder schemaFolder = projectFolder.getFolder(name);
        if (!schemaFolder.exists()) {
            schemaFolder.create(false, true, null);
        }
        IFile file = projectFolder.getFile(name + POSTFIX);
        if (!file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(MessageFormat.format(PATTERN, DbObjType.SCHEMA, name));
            sb.append(MessageFormat.format(OWNER_TO, DbObjType.SCHEMA, name));
            file.create(new ByteArrayInputStream(sb.toString().getBytes()), false, null);
        }
        if (open) {
            openFileInEditor(file);
        }
        return schemaFolder;
    }

    private IFolder getFolder(String name, DbObjType type) throws CoreException {
        IFolder schemaFolder = createSchema(name, false);
        IFolder typeFolder = schemaFolder.getFolder(type.name());
        if (!typeFolder.exists()) {
            typeFolder.create(false, true, null);
        }
        return typeFolder;
    }

    private void openFileInEditor(IFile file) throws PartInitException {
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .openEditor(new FileEditorInput(file), EDITOR.SQL);
    }

    @Override
    public boolean isPageComplete() {
        return parseName();
    }
}