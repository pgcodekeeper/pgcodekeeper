package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.eclipse.core.resources.IContainer;
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

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgUIDumpLoader;

public final class NewObjectPage extends WizardPage {

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();

    private static final String NAME = "name"; //$NON-NLS-1$
    private static final String SCHEMA = "schema"; //$NON-NLS-1$
    private static final String CONTAINER = "container"; //$NON-NLS-1$

    private static final String GROUP_DELIMITER =
            "\n--------------------------------------------------------------------------------\n\n"; //$NON-NLS-1$
    private static final String PATTERN = "CREATE {0} {1};"; //$NON-NLS-1$

    private static final String RULE_PATTERN = "CREATE RULE {0} AS\n\tON UPDATE TO {1} DO NOTHING;\n";//$NON-NLS-1$
    private static final String TRIGGER_PATTERN = "CREATE TRIGGER {0}\n\tBEFORE UPDATE ON {1}" //$NON-NLS-1$
            + "\n\tFOR EACH STATEMENT\n\tEXECUTE PROCEDURE function_name_placeholder();\n"; //$NON-NLS-1$
    private static final String CONSTRAINT_PATTERN = "ALTER TABLE {0}\n\tADD CONSTRAINT {1}" //$NON-NLS-1$
            + " PRIMARY KEY (COLUMN_NAME);\n"; //$NON-NLS-1$
    private static final String INDEX_PATTERN = "CREATE INDEX {0} ON {1} USING btree (COLUMN_NAME);\n"; //$NON-NLS-1$

    private DbObjType type;
    private String name = NAME;
    private String schema = "public"; //$NON-NLS-1$
    private String container = CONTAINER;
    private String expectedFormat;
    private IProject currentProj;
    private boolean parentIsTable = true;
    private final EnumSet<DbObjType> allowedTypes = EnumSet.complementOf(
            EnumSet.of(DbObjType.COLUMN, DbObjType.DATABASE, DbObjType.SEQUENCE));

    private ComboViewer viewerProject;
    private ComboViewer viewerType;
    private Text txtName;
    private Group group;

    public NewObjectPage(String pageName, IStructuredSelection selection) {
        super(pageName, pageName, null);
        Object element = selection.getFirstElement();
        if (element instanceof IResource) {
            IResource resource = (IResource)element;
            if (resource.getType() == IResource.FILE && PgUIDumpLoader.isInProject(resource)) {
                parseFile(resource);
            } else if (resource.getType() == IResource.FOLDER) {
                parseFolder(resource);
            }
            currentProj = resource.getProject();
        }

        if (type == null) {
            String lastType = mainPrefs.getString(PREF.LAST_CREATED_OBJECT_TYPE);
            type = allowedTypes.stream().filter(e -> e.toString().equals(lastType))
                    .findAny().orElse(DbObjType.TABLE);
        }
    }

    private void parseFolder(IResource resource) {
        type = allowedTypes.stream().filter(e -> e.toString().equals(resource.getName()))
                .findAny().orElse(null);
        IContainer container = resource.getParent();
        if (container != null) {
            if (type != null && type != DbObjType.SCHEMA && type != DbObjType.EXTENSION) {
                schema = container.getName();
            } else if (DbObjType.SCHEMA.name().equals(container.getName())) {
                schema = resource.getName();
            }
        }
    }

    private void parseFile(IResource resource) {
        try {
            PgStatement st = PgUIDumpLoader.parseStatement((IFile)resource,
                    EnumSet.of(DbObjType.EXTENSION, DbObjType.TABLE,
                            DbObjType.VIEW, DbObjType.DOMAIN,
                            DbObjType.TYPE, DbObjType.FUNCTION));
            if (st != null) {
                type = st.getStatementType();
                if (st instanceof PgStatementWithSearchPath) {
                    schema = ((PgStatementWithSearchPath)st).getContainingSchema().getName();
                }

                if (type == DbObjType.TABLE || type == DbObjType.VIEW) {
                    container = st.getName();
                    parentIsTable = type != DbObjType.VIEW;
                }
            }
        } catch (IOException | InterruptedException | CoreException ex) {
            Log.log(Log.LOG_ERROR, "Error while parsing selection", ex); //$NON-NLS-1$
        }
    }

    @Override
    public void createControl(Composite parent) {
        Composite area = new Composite(parent, SWT.NONE);
        area.setLayout(new GridLayout(2, false));
        area.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        new Label(area, SWT.NONE).setText(Messages.PgObject_object_name);
        txtName = new Text(area, SWT.BORDER);
        txtName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtName.addModifyListener(e -> {
            parseName();
            getWizard().getContainer().updateButtons();
        });
        txtName.setFocus();

        new Label(area, SWT.NONE).setText(Messages.PgObject_object_type);
        viewerType = new ComboViewer(area, SWT.READ_ONLY | SWT.DROP_DOWN);

        createAdditionalFields(area);
        // must paint first time
        showGroup(true);

        new Label(area, SWT.NONE).setText(Messages.PgObject_project_name);
        viewerProject = new ComboViewer(area, SWT.READ_ONLY | SWT.DROP_DOWN);

        fillProjects();
        fillTypes();
        setControl(area);
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

        List<IProject> projectList = new ArrayList<>();
        IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        IProject[] projects = workspaceRoot.getProjects();

        for (IProject project : projects) {
            try {
                if (project.isOpen() && project.hasNature(NATURE.ID)) {
                    projectList.add(project);
                }
            } catch (CoreException ex) {
                Log.log(Log.LOG_ERROR, "Project nature identifier error" //$NON-NLS-1$
                        + ex.getLocalizedMessage(), ex);
            }
        }

        if (projectList.isEmpty()) {
            setErrorMessage(Messages.PgObject_cant_find_projects);
        } else {
            viewerProject.setInput(projectList);
        }

        viewerProject.addSelectionChangedListener(e -> {
            Object object = e.getStructuredSelection().getFirstElement();
            if (object != null) {
                currentProj = ((IProject) object);
            }
            getWizard().getContainer().updateButtons();
        });

        if (projectList.contains(currentProj)) {
            viewerProject.setSelection(new StructuredSelection(currentProj));
        }
    }

    private void fillTypes() {
        viewerType.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        viewerType.setContentProvider(ArrayContentProvider.getInstance());
        viewerType.setInput(allowedTypes);

        viewerType.addSelectionChangedListener(e -> {
            type = (DbObjType) e.getStructuredSelection().getFirstElement();
            showGroup(type == DbObjType.TRIGGER || type == DbObjType.RULE);
            setDefaultName();
            getWizard().getContainer().updateButtons();
        });

        viewerType.setSelection(new StructuredSelection(type));
    }

    private void createAdditionalFields(Composite area) {
        group = new Group(area, SWT.NONE);
        group.setText(Messages.PgObject_parent_type);
        group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
        group.setLayout(new GridLayout(2, true));

        Button btnTable = new Button(group, SWT.RADIO);
        btnTable.setText(Messages.PgObject_table);
        btnTable.setSelection(parentIsTable);
        btnTable.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                parentIsTable = true;
                getWizard().getContainer().updateButtons();
            }
        });

        Button btnView = new Button(group, SWT.RADIO);
        btnView.setText(Messages.PgObject_view);
        btnView.setSelection(!parentIsTable);
        btnView.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                parentIsTable = false;
                getWizard().getContainer().updateButtons();
            }
        });
    }

    private void showGroup(boolean isShow) {
        GridData data =  (GridData) group.getLayoutData();
        data.exclude = !isShow;
        group.setVisible(!data.exclude);
        group.getParent().layout(false);
    }

    private void setDefaultName() {
        String path;
        switch (type) {
        case SCHEMA:
        case EXTENSION:
            path = name;
            expectedFormat = NAME;
            break;
        case DOMAIN:
        case FUNCTION:
        case TABLE:
        case VIEW:
        case TYPE:
            path = schema + '.' + name;
            expectedFormat = SCHEMA + '.' + NAME;
            break;
        case TRIGGER:
        case RULE:
        case INDEX:
        case CONSTRAINT:
            path = schema + '.' + container + '.' + name;
            expectedFormat = SCHEMA + '.' + CONTAINER + '.' + NAME;
            break;
        default:
            return;
        }
        txtName.setText(path);
        txtName.setSelection(path.length());
    }

    @Override
    public boolean isPageComplete() {
        return parseName();
    }

    private boolean parseName() {
        String fullName = txtName.getText();
        String err = null;
        setErrorMessage(err);
        if (viewerProject.getStructuredSelection().getFirstElement() == null) {
            setDescription(Messages.PgObject_select_project);
            return false;
        } else if (fullName.isEmpty()) {
            setDescription(Messages.PgObject_empty_name);
            return false;
        } else {
            QNameParser parser = new QNameParser(fullName);
            if (parser.hasErrors()) {
                err = Messages.NewObjectWizard_invalid_input_format + expectedFormat;
            } else {
                String third = parser.getThirdName();
                String second = parser.getSecondName();
                if ((type == DbObjType.SCHEMA || type == DbObjType.EXTENSION) && second != null) {
                    err = Messages.NewObjectWizard_invalid_schema_format;
                } else if (isSubElement() == (third == null)
                        || (second == null && type != DbObjType.SCHEMA && type != DbObjType.EXTENSION)) {
                    err = Messages.NewObjectWizard_invalid_input_format + expectedFormat;
                }

                if (err == null) {
                    name = parser.getFirstName();
                    if (isSubElement()) {
                        container = second;
                        schema = third;
                    } else if (type != DbObjType.EXTENSION && type != DbObjType.SCHEMA) {
                        schema = second;
                    }
                }
            }
        }
        setErrorMessage(err);
        if (err == null) {
            setDescription(Messages.PgObject_create_object);
        }
        return err == null;
    }

    private boolean isHaveChoise() {
        return type == DbObjType.TRIGGER || type == DbObjType.RULE;
    }

    public boolean isSubElement() {
        return isHaveChoise() || type == DbObjType.CONSTRAINT || type == DbObjType.INDEX;
    }

    public boolean createFile() {
        try {
            mainPrefs.setValue(PREF.LAST_CREATED_OBJECT_TYPE, type.name());
            if (type == DbObjType.EXTENSION) {
                createExtension(name, currentProj);
            } else if (type == DbObjType.SCHEMA) {
                createSchema(name, true, currentProj);
            } else if (!isSubElement()) {
                createObject(schema, name, type, true, currentProj);
            } else {
                createSubElement(schema, container, name,
                        !isHaveChoise() || parentIsTable, currentProj, type);
            }
            return true;
        } catch (CoreException ex) {
            Log.log(Log.LOG_ERROR, Messages.PgObject_file_creation_error
                    + ex.getLocalizedMessage(), ex);
            setErrorMessage(Messages.PgObject_file_creation_error);
            return false;
        }
    }

    private void openFileInEditor(IFile file) throws PartInitException {
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .openEditor(new FileEditorInput(file), EDITOR.SQL);
    }

    private IFolder createSchema(String name, boolean open, IProject project) throws CoreException {
        IFolder projectFolder = project.getFolder(DbObjType.SCHEMA.name());
        if (!projectFolder.exists()) {
            projectFolder.create(false, true, null);
        }
        IFolder schemaFolder = projectFolder.getFolder(ModelExporter.getExportedFilename(name));
        if (!schemaFolder.exists()) {
            schemaFolder.create(false, true, null);
        }
        IFile file = projectFolder.getFile(ModelExporter.getExportedFilenameSql(name));
        if (!file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(MessageFormat.format(PATTERN, DbObjType.SCHEMA, PgDiffUtils.getQuotedName(name)));
            file.create(new ByteArrayInputStream(sb.toString().getBytes()), false, null);
        }
        if (open) {
            openFileInEditor(file);
        }
        return schemaFolder;
    }

    private void createExtension(String name, IProject project) throws CoreException {
        IFolder folder = project.getFolder(DbObjType.EXTENSION.name());
        if (!folder.exists()) {
            folder.create(false, true, null);
        }
        IFile extFile = folder.getFile(ModelExporter.getExportedFilenameSql(name));
        if (!extFile.exists()) {
            String code = MessageFormat.format(PATTERN, DbObjType.EXTENSION, PgDiffUtils.getQuotedName(name));
            extFile.create(new ByteArrayInputStream(code.getBytes()), false, null);
        }
        openFileInEditor(extFile);
    }

    private IFile createObject(String schema, String name, DbObjType type,
            boolean open, IProject project) throws CoreException {
        String objectName = PgDiffUtils.getQuotedName(name);
        IFolder folder = getFolder(schema, type, project);
        IFile file = folder.getFile(ModelExporter.getExportedFilenameSql(name));

        if (!file.exists()) {
            StringBuilder sb = new StringBuilder("SET search_path = " //$NON-NLS-1$
                    + PgDiffUtils.getQuotedName(schema)
                    + ", pg_catalog;"); //$NON-NLS-1$
            sb.append("\n\nCREATE "); //$NON-NLS-1$
            if (type == DbObjType.FUNCTION) {
                sb.append("OR REPLACE "); //$NON-NLS-1$
                objectName +="()"; //$NON-NLS-1$
            }
            sb.append(type + " " + objectName); //$NON-NLS-1$

            switch (type) {
            case TYPE:
                sb.append(';');
                break;
            case DOMAIN:
                sb.append(" AS datatype;"); //$NON-NLS-1$
                break;
            case FUNCTION:
                sb.append(" RETURNS void\n\tLANGUAGE sql\n    AS $$\n\t--function body \n$$;\n"); //$NON-NLS-1$
                break;
            case TABLE:
                sb.append(" (\n);"); //$NON-NLS-1$
                break;
            default:
                sb.append(" AS\n\tSELECT 'select_text'::text AS text;"); //$NON-NLS-1$
                break;
            }

            file.create(new ByteArrayInputStream(sb.toString().getBytes()), false, null);
        }
        if (open) {
            openFileInEditor(file);
        }
        return file;
    }

    private void createSubElement(String schema, String parent,
            String name, boolean parentIsTable,  IProject project, DbObjType type) throws CoreException {
        DbObjType parentType = parentIsTable? DbObjType.TABLE : DbObjType.VIEW;
        IFile file = createObject(schema, parent, parentType, false, project);
        StringBuilder sb = new StringBuilder(GROUP_DELIMITER);
        String objectName = PgDiffUtils.getQuotedName(name);
        if (type == DbObjType.RULE) {
            sb.append(MessageFormat.format(RULE_PATTERN, objectName, parent));
        } else if (type == DbObjType.TRIGGER) {
            sb.append(MessageFormat.format(TRIGGER_PATTERN, objectName, parent));
        } else if (type == DbObjType.CONSTRAINT) {
            sb.append(MessageFormat.format(CONSTRAINT_PATTERN, parent, objectName));
        } else {
            sb.append(MessageFormat.format(INDEX_PATTERN, objectName, parent));
        }
        file.appendContents(new ByteArrayInputStream(sb.toString().getBytes()), true, true, null);
        openFileInEditor(file);
    }

    private IFolder getFolder(String name, DbObjType type, IProject project) throws CoreException {
        IFolder schemaFolder = createSchema(name, false, project);
        IFolder typeFolder = schemaFolder.getFolder(type.name());
        if (!typeFolder.exists()) {
            typeFolder.create(false, true, null);
        }
        return typeFolder;
    }
}