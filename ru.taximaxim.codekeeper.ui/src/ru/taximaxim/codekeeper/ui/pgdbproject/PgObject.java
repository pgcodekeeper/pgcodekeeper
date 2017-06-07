package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
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
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
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
    private static final String DEFAULT_SCHEMA = "public"; //$NON-NLS-1$
    private static final String OWNER_TO = "\n\nALTER {0} {1} OWNER TO CURRENT_DB_USER;\n"; //$NON-NLS-1$
    private static final String GROUP_DELIMITER =
            "\n--------------------------------------------------------------------------------\n\n"; //$NON-NLS-1$

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();

    private final IStructuredSelection selection;
    private Text txtName;
    private ComboViewer viewerProject, viewerType;
    private Group group;

    private DbObjType currentObj;
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

        txtName.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                getWizard().getContainer().updateButtons();
            }
        });

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

        viewerProject.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                Object element = viewerProject.getStructuredSelection().getFirstElement();
                if (element != null) {
                    currentProj = ((IProject) element).getName();
                }
                getWizard().getContainer().updateButtons();
            }
        });

        List<IProject> projectList = new LinkedList<>();
        IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        IProject[] projects = workspaceRoot.getProjects();

        try {
            for (IProject project : projects) {
                if(project.isOpen() && project.hasNature(NATURE.ID)) {
                    projectList.add(project);
                }
            }
            if (projectList.isEmpty()) {
                setErrorMessage(Messages.PgObject_cant_find_porojects);
            } else {
                viewerProject.setInput(projectList);
            }
        } catch (CoreException ex) {
            Log.log(Log.LOG_ERROR, "Project nature identifier error" + ex.getLocalizedMessage(), ex); //$NON-NLS-1$
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
        viewerType.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                currentObj = (DbObjType) viewerType.getStructuredSelection().getFirstElement();
                showGroup();
                getWizard().getContainer().updateButtons();
            }
        });

        List<DbObjType> types = new ArrayList<>(DbObjType.values().length - 3);

        for (DbObjType type : DbObjType.values()) {
            if (type != DbObjType.DATABASE && type != DbObjType.COLUMN
                    & type != DbObjType.SEQUENCE){
                types.add(type);
            }
        }
        viewerType.setInput(types);

        String lastType = mainPrefs.getString(PREF.LAST_CREATED_OBJECT_TYPE);

        for (DbObjType type : DbObjType.values()) {
            if (type.toString().equals(lastType)){
                viewerType.setSelection(new StructuredSelection(type));
                return;
            }
        }
        viewerType.setSelection(new StructuredSelection(DbObjType.SCHEMA));
    }

    private void showGroup() {
        GridData data =  (GridData) group.getLayoutData();
        if (currentObj == DbObjType.TRIGGER || currentObj == DbObjType.RULE) {
            data.exclude = false;
        } else {
            data.exclude = true;
        }
        group.setVisible(!data.exclude);
        group.getParent().layout(false);
    }

    private boolean parseName() {
        String name = txtName.getText();
        String [] names = name.split(SPLITTER);
        String err = null;
        setErrorMessage(err);
        if (viewerProject.getStructuredSelection().getFirstElement() == null) {
            setDescription(Messages.PgObject_select_project);
            return false;
        } else if (name.length() == 0) {
            setDescription(Messages.PgObject_empty_name);
            return false;
        } else {
            if (currentObj == DbObjType.SCHEMA || currentObj == DbObjType.EXTENSION) {
                if (names.length == 1) {
                    setDescription(MessageFormat.format(Messages.PgObject_desc, currentObj,
                            names[0], currentProj));
                } else {
                    err = Messages.PgObject_invalid_format_schema;
                }
            } else if (currentObj == DbObjType.CONSTRAINT || currentObj == DbObjType.INDEX) {
                if (names.length == 3 || names.length == 4) {
                    String schema = names.length == 3 ? DEFAULT_SCHEMA : names[0];
                    setDescription(MessageFormat.format(Messages.PgObject_full_desc_with_column,
                            currentObj, names[names.length - 1], currentProj, schema,
                            names[names.length - 3], names[names.length - 2]));
                } else {
                    err = Messages.PgObject_invalid_format_column;
                }
            } else if (currentObj == DbObjType.RULE || currentObj == DbObjType.TRIGGER) {
                if (names.length == 2 || names.length == 3) {
                    String schema = names.length == 2 ? DEFAULT_SCHEMA : names[0];
                    setDescription(MessageFormat.format(Messages.PgObject_full_desc, currentObj,
                            names[names.length - 1], currentProj, schema,
                            ((group.isVisible() && parentIsTable) ? Messages.PgObject_in_table : Messages.PgObject_in_view),
                            names[names.length - 2]));
                } else {
                    err = Messages.PgObject_invalid_format_object;
                }
            } else {
                // type, domain, function, table, view
                if (names.length == 1 || names.length == 2) {
                    String schema = names.length == 1 ? DEFAULT_SCHEMA : names[0];
                    setDescription(MessageFormat.format(Messages.PgObject_schema_desc, currentObj,
                            names[names.length - 1], currentProj, schema));
                } else {
                    err = Messages.PgObject_invalid_format_container;
                }
            }
        }
        setErrorMessage(err);
        return err == null;
    }

    public boolean createFile () {
        String name = txtName.getText();
        String [] names = name.split(SPLITTER);
        try {
            mainPrefs.setValue(PREF.LAST_CREATED_OBJECT_TYPE, currentObj.toString());
            if (currentObj == DbObjType.SCHEMA || currentObj == DbObjType.EXTENSION) {
                return getFolder(names[0], currentObj) == null;
            } else if ((currentObj == DbObjType.CONSTRAINT || currentObj == DbObjType.INDEX)) {
                return createSubElement(names.length == 3 ? DEFAULT_SCHEMA : names[0],
                        names[names.length - 3], names[names.length - 2], names[names.length - 1], currentObj);
            } else if ((currentObj == DbObjType.TRIGGER || currentObj == DbObjType.RULE)) {
                return createSubElement(names.length == 2 ? DEFAULT_SCHEMA : names[0],
                        names[names.length - 2], null, names[names.length - 1],  currentObj);
            } else {
                return createObject(names.length == 1 ? DEFAULT_SCHEMA : names[0],
                        names[names.length - 1], currentObj, false) != null;
            }
        } catch (CoreException ex) {
            Log.log(Log.LOG_ERROR, Messages.PgObject_file_creation_error
                    + ex.getLocalizedMessage(), ex);
            setErrorMessage(Messages.PgObject_file_creation_error);
            return false;
        }
    }

    private boolean createSubElement(String schema, String parentName, String columnName,
            String name, DbObjType type) throws CoreException {
        DbObjType parentType = DbObjType.TABLE;
        if (!parentIsTable && type == DbObjType.RULE || type == DbObjType.TRIGGER ) {
            parentType = DbObjType.VIEW;
        }
        IFile file = createObject(schema, parentName, parentType, true);
        StringBuilder sb = new StringBuilder(GROUP_DELIMITER);

        if (type == DbObjType.RULE) {
            sb.append("CREATE RULE ").append(name).append(" AS\n\tON UPDATE TO ") //$NON-NLS-1$ //$NON-NLS-2$
            .append(parentName).append(" DO NOTHING;\n"); //$NON-NLS-1$
        } else if (type == DbObjType.TRIGGER) {
            sb.append("CREATE TRIGGER ").append(name).append("\n\tBEFORE UPDATE ON ").append(parentName) //$NON-NLS-1$ //$NON-NLS-2$
            .append("\n\tFOR EACH STATEMENT\n\tEXECUTE PROCEDURE function_name_placeholder();\n"); //$NON-NLS-1$
        } else if (type == DbObjType.CONSTRAINT) {
            sb.append("ALTER TABLE ").append(parentName).append("\n\tADD CONSTRAINT ").append(name) //$NON-NLS-1$ //$NON-NLS-2$
            .append(" PRIMARY KEY (").append(columnName).append(");\n"); //$NON-NLS-1$ //$NON-NLS-2$
        } else if (type == DbObjType.INDEX) {
            sb.append("CREATE INDEX ").append(name).append(" ON ").append(parentName) //$NON-NLS-1$ //$NON-NLS-2$
            .append(" USING btree (").append(columnName).append(");\n"); //$NON-NLS-1$ //$NON-NLS-2$
        }

        file.appendContents(new ByteArrayInputStream(sb.toString().getBytes()), true, true, null);
        openFileInEditor(file);
        return true;
    }

    private IFile createObject(String schema, String name, DbObjType type, boolean isSubElement) throws CoreException {
        IFolder folder = getFolder(schema, type);
        IFile file = folder.getFile(name + POSTFIX);
        if (type == DbObjType.FUNCTION) {
            int paren = name.indexOf("("); //$NON-NLS-1$
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
            sb.append(" AS text;"); //$NON-NLS-1$
            break;
        case FUNCTION:
            sb.append(" RETURNS integer\n\tLANGUAGE sql\n    AS $$select 1;$$;"); //$NON-NLS-1$
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
        if (!isSubElement) {
            openFileInEditor(file);
        }
        return file;
    }

    private IFolder getFolder (String name, DbObjType type) throws CoreException {
        Object element = viewerProject.getStructuredSelection().getFirstElement();
        IFolder projectFolder;
        if (type == DbObjType.EXTENSION) {
            projectFolder = ((IProject) element).getFolder(type.toString());
        } else {
            projectFolder = ((IProject) element).getFolder(DbObjType.SCHEMA.toString());
        }
        if (!projectFolder.exists()) {
            projectFolder.create(false, true, null);
        }
        if (type == DbObjType.EXTENSION) {
            IFile extFile = projectFolder.getFile(name + POSTFIX);
            if (!extFile.exists()) {
                StringBuilder sb = new StringBuilder();
                sb.append("CREATE EXTENSION ").append(name).append(';'); //$NON-NLS-1$
                sb.append(MessageFormat.format(OWNER_TO, type, name));
                extFile.create(new ByteArrayInputStream((sb.toString()).getBytes()), false, null);
            }
            openFileInEditor(extFile);
            return null;
        }
        IFolder schemaFolder = projectFolder.getFolder(name);
        if (!schemaFolder.exists()) {
            schemaFolder.create(false, true, null);
        }
        IFile file = projectFolder.getFile(name + POSTFIX);
        if (!file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE SCHEMA ").append(name).append(';'); //$NON-NLS-1$
            sb.append(MessageFormat.format(OWNER_TO, DbObjType.SCHEMA.toString(), name));
            file.create(new ByteArrayInputStream((sb.toString()).getBytes()), false, null);
        }
        if (type == DbObjType.SCHEMA) {
            openFileInEditor(file);
            return null;
        } else {
            IFolder typeFolder = schemaFolder.getFolder(type.toString());
            if (!typeFolder.exists()) {
                typeFolder.create(false, true, null);
            }
            return typeFolder;
        }
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