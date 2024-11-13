/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.templates.DocumentTemplateContext;
import org.eclipse.jface.text.templates.Template;
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
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.ObjectLevel;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.WorkDirs;
import ru.taximaxim.codekeeper.core.fileutils.FileUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParserWrapper;
import ru.taximaxim.codekeeper.core.schema.ISearchPath;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.ch.ChFunction;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.UIProjectLoader;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorTemplateAssistProcessor;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorTemplateContextType;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorTemplateManager;
import ru.taximaxim.codekeeper.ui.sqledit.SqlEditorTemplateProposal;

public final class NewObjectPage extends WizardPage {

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();

    private static final DbObjType DEFAULT_TYPE = DbObjType.TABLE;

    private static final String EXPECTED_SCHEMA = "schema"; //$NON-NLS-1$
    private static final String EXPECTED_CONTAINER = "container"; //$NON-NLS-1$
    private static final String EXPECTED_NAME = "name"; //$NON-NLS-1$
    private static final String EXPECTED_OP_NAME = "=+*";

    private static final String PATTERN = "CREATE SCHEMA {0};"; //$NON-NLS-1$
    private static final String CH_PATTERN = "CREATE DATABASE {0}\nENGINE = Atomic;"; //$NON-NLS-1$
    private static final String CREATE_POSTFIX = ".create"; //$NON-NLS-1$

    private final List<DbObjType> allowedTypes = new ArrayList<>();

    private DbObjType type;
    private String schema = EXPECTED_SCHEMA;
    private String container = EXPECTED_CONTAINER;
    private String name = EXPECTED_NAME;
    private String expectedFormat;
    private IProject currentProj;
    private boolean parentIsTable = true;

    private ComboViewer viewerProject;
    private ComboViewer viewerType;
    private Text txtName;
    private Group group;
    private Label lblDbType;
    private DatabaseType dbType;

    public NewObjectPage(String pageName, IStructuredSelection selection) {
        super(pageName, pageName, null);
        parseSelection(selection);
    }

    private void parseSelection(IStructuredSelection selection) {
        Object element = selection.getFirstElement();
        if (element instanceof IResource resource) {
            currentProj = resource.getProject();
            dbType = OpenProjectUtils.getDatabaseType(currentProj);
            fillAllowedTypes();
            if (resource.getType() == IResource.FILE && UIProjectLoader.isInProject(resource)) {
                parseSelectionFile(resource);
            } else if (resource.getType() == IResource.FOLDER) {
                parseSelectionFolder(resource);
            }
        }
        if (type == null) {
            String lastType = mainPrefs.getString(PREF.LAST_CREATED_OBJECT_TYPE);
            type = allowedTypes.stream().filter(e -> e.toString().equals(lastType))
                    .findAny().orElse(DEFAULT_TYPE);
        }
    }

    private void fillAllowedTypes() {
        allowedTypes.clear();
        if (dbType != null) {
            allowedTypes.addAll(ObjectLevel.getTypes(dbType, false,
                    ObjectLevel.SCHEMA, ObjectLevel.CONTAINER, ObjectLevel.SUB_ELEMENT));
            allowedTypes.sort(Comparator.comparing(DbObjType::name));
        }
    }

    private void parseSelectionFolder(IResource resource) {
        type = allowedTypes.stream()
                .filter(e -> resource.getName().equals(WorkDirs.getDirectoryNameForType(dbType, e)))
                .findAny().orElse(null);

        if (dbType == DatabaseType.MS) {
            schema = "dbo";
            return;
        }

        IContainer cont = resource.getParent();
        var dbContName = WorkDirs.getDirectoryNameForType(dbType, DbObjType.SCHEMA);
        if (cont != null) {
            if (type != null && !isSchemaLevel()) {
                schema = cont.getName();
            } else if (dbContName.equals(cont.getName())) {
                schema = resource.getName();
            }
        }
    }

    private void parseSelectionFile(IResource resource) {
        Set<DbObjType> types = ObjectLevel.getTypes(dbType, false, ObjectLevel.SCHEMA, ObjectLevel.CONTAINER);
        types.remove(DbObjType.SCHEMA);

        PgStatement st = null;
        try {
            st = UIProjectLoader.parseStatement((IFile) resource, types);
        } catch (IOException | InterruptedException | CoreException ex) {
            Log.log(Log.LOG_ERROR, "Error while parsing selection", ex); //$NON-NLS-1$
        }
        if (st == null) {
            return;
        }

        type = st.getStatementType();
        if (st instanceof ISearchPath path && !(st instanceof ChFunction)) {
            schema = path.getSchemaName();
        }
        if (type.in(DbObjType.TABLE, DbObjType.VIEW)) {
            container = st.getName();
            parentIsTable = type != DbObjType.VIEW;
        }
    }

    private boolean isClickHouseDb() {
        return dbType == DatabaseType.CH;
    }

    @Override
    public void createControl(Composite parent) {
        Composite area = new Composite(parent, SWT.NONE);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        area.setLayoutData(gd);
        area.setLayout(new GridLayout(3, false));

        //project
        Label lblProj = new Label(area, SWT.NONE);
        lblProj.setText(Messages.PgObject_project_name);
        lblProj.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
        viewerProject = new ComboViewer(area, SWT.READ_ONLY | SWT.DROP_DOWN);
        viewerProject.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
        lblDbType = new Label(area, SWT.NONE);
        lblDbType.setText(dbType != null ? dbType.name() : "");
        lblDbType.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

        //object name
        Label lblObj = new Label(area, SWT.NONE);
        gd = new GridData(SWT.FILL, SWT.DEFAULT, false, false, 1, 1);
        lblObj.setLayoutData(gd);
        lblObj.setText(Messages.PgObject_object_name);
        // in windows the beginning of long text disappears
        int style = SWT.getPlatform().contains("win") ? SWT.MULTI | SWT.BORDER : SWT.BORDER;
        txtName = new Text(area, style);
        txtName.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2, 1));

        txtName.addModifyListener(e -> {
            parseName();
            getWizard().getContainer().updateButtons();
        });
        txtName.setFocus();

        //object type
        new Label(area, SWT.NONE).setText(Messages.PgObject_object_type);
        viewerType = new ComboViewer(area, SWT.READ_ONLY | SWT.DROP_DOWN);
        viewerType.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

        createAdditionalFields(area);
        // must paint first time
        showGroup(true);

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
                if (element instanceof IProject project) {
                    return project.getName();
                }
                return super.getText(element);
            }
        });

        List<IProject> projectList = new ArrayList<>();
        for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
            if (OpenProjectUtils.isPgCodeKeeperProject(project)) {
                projectList.add(project);
            }
        }

        if (projectList.isEmpty()) {
            setErrorMessage(Messages.PgObject_cant_find_projects);
        } else {
            viewerProject.setInput(projectList);
        }

        viewerProject.addSelectionChangedListener(e -> {
            Object object = ((StructuredSelection) e.getSelection()).getFirstElement();
            if (object != null) {
                currentProj = ((IProject) object);
                dbType = OpenProjectUtils.getDatabaseType(currentProj);
                lblDbType.setText(dbType.getDbTypeName());
                lblDbType.getParent().layout();
                fillTypes();
            }
            getWizard().getContainer().updateButtons();
        });

        if (projectList.contains(currentProj)) {
            viewerProject.setSelection(new StructuredSelection(currentProj));
        }
    }

    private void fillTypes() {
        fillAllowedTypes();
        viewerType.setContentProvider(ArrayContentProvider.getInstance());
        viewerType.setInput(allowedTypes);

        viewerType.addSelectionChangedListener(e -> {
            type = (DbObjType) ((StructuredSelection) e.getSelection()).getFirstElement();
            if (type == null) {
                type = DEFAULT_TYPE;
            }
            showGroup(isHaveChoise());
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
        GridData data = (GridData) group.getLayoutData();
        data.exclude = !isShow;
        group.setVisible(!data.exclude);
        group.getParent().layout(false);
    }

    private void setDefaultName() {
        String path;
        switch (ObjectLevel.getLevel(dbType, type)) {
        case SCHEMA:
            path = name;
            expectedFormat = EXPECTED_NAME;
            break;
        case CONTAINER:
            path = schema + '.' + name;
            if (type == DbObjType.OPERATOR) {
                expectedFormat = EXPECTED_SCHEMA + '.' + EXPECTED_OP_NAME;
            } else {
                expectedFormat = EXPECTED_SCHEMA + '.' + EXPECTED_NAME;
            }
            break;
        case SUB_ELEMENT:
            path = schema + '.' + container + '.' + name;
            expectedFormat = EXPECTED_SCHEMA + '.' + EXPECTED_CONTAINER + '.' + EXPECTED_NAME;
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
        }
        if (fullName.isEmpty()) {
            setDescription(Messages.PgObject_empty_name);
            return false;
        }
        if (type != null && type.in(DbObjType.CAST, DbObjType.USER_MAPPING)) {
            name = fullName;
            return true;
        }
        QNameParserWrapper parser;
        if (isClickHouseDb()) {
            parser = QNameParserWrapper.parseCh(fullName);
        } else if (type != null && type == DbObjType.OPERATOR) {
            parser = QNameParserWrapper.parsePgOperator(fullName);
        } else {
            parser = QNameParserWrapper.parsePg(fullName);
        }
        if (parser.hasErrors()) {
            err = Messages.NewObjectWizard_invalid_input_format + expectedFormat;
        } else {
            String third = parser.getThirdName();
            String second = parser.getSecondName();
            if (isSchemaLevel() && second != null) {
                err = Messages.NewObjectWizard_invalid_schema_format;
            } else if (isSubElement() == (third == null) || (second == null && !isSchemaLevel())) {
                err = Messages.NewObjectWizard_invalid_input_format + expectedFormat;
            }

            if (err == null) {
                name = parser.getFirstName();
                if (isSubElement()) {
                    container = second;
                    schema = third;
                } else if (!isSchemaLevel()) {
                    schema = second;
                }
            }
        }

        setErrorMessage(err);
        if (err == null) {
            setDescription(MessageFormat.format(Messages.Object_create_object, dbType.getDbTypeName()));
        }
        return err == null;
    }

    private boolean isSchemaLevel() {
        return ObjectLevel.SCHEMA == ObjectLevel.getLevel(dbType, type);
    }

    private boolean isHaveChoise() {
        return type.in(DbObjType.TRIGGER, DbObjType.RULE, DbObjType.INDEX)
                || (DatabaseType.MS == dbType && DbObjType.STATISTICS == type);
    }

    private boolean isSubElement() {
        return ObjectLevel.SUB_ELEMENT == ObjectLevel.getLevel(dbType, type);
    }

    public boolean createFile() {
        try {
            mainPrefs.setValue(PREF.LAST_CREATED_OBJECT_TYPE, type.name());
            if (isSchemaLevel()) {
                if (DbObjType.SCHEMA == type) {
                    createSchema(name, true, currentProj);
                } else {
                    createObject(null, true);
                }
            } else if (!isSubElement()) {
                createObject(schema, true);
            } else {
                createSubElement(!isHaveChoise() || parentIsTable);
            }
            return true;
        } catch (CoreException ex) {
            Log.log(Log.LOG_ERROR, Messages.PgObject_file_creation_error + ex.getLocalizedMessage(), ex);
            setErrorMessage(Messages.PgObject_file_creation_error);
            return false;
        }
    }

    private IEditorPart openFileInEditor(IFile file) throws PartInitException {
        return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .openEditor(new FileEditorInput(file), EDITOR.SQL);
    }

    private void openFileInEditor(IFile file, String tmplId, String schema,
            String object, String parent) throws CoreException {
        String schemaName = schema != null ? Utils.getQuotedName(schema, dbType) : null;
        String objectName = type.in(DbObjType.OPERATOR, DbObjType.CAST, DbObjType.USER_MAPPING) ? object
                : Utils.getQuotedName(object, dbType);

        Template newObjTmpl = SQLEditorTemplateManager.getInstance().getTemplateStore().findTemplateById(tmplId);
        ITextViewer textViewer = (ITextViewer) openFileInEditor(file).getAdapter(ITextOperationTarget.class);

        if (parent == null) {
            // creation element
            new SQLEditorTemplateAssistProcessor().getAllTemplates(textViewer, 0)
            .stream().filter(tmplProp -> tmplProp.getTempalteOfProposal().equals(newObjTmpl))
            .findAny().ifPresent(tmplProp -> tmplProp.fillTmplAndInsertToViewer(schemaName,
                    objectName, parent, textViewer, 0));
        } else {
            // creation sub-element
            IDocumentProvider provider = new TextFileDocumentProvider();
            try {
                // inserting the group delimiter at the end of the parent element
                // code and getting the offset from it
                provider.connect(file);
                IDocument doc = provider.getDocument(file);
                int offset = doc.getLength();
                doc.replace(offset, 0, ModelExporter.GROUP_DELIMITER);
                offset += ModelExporter.GROUP_DELIMITER.length();

                new SqlEditorTemplateProposal(newObjTmpl,
                        new DocumentTemplateContext(new SQLEditorTemplateContextType(), doc, new Position(offset, 0)),
                        new Region(offset, 0), null, 0)
                .fillTmplAndInsertToViewer(schemaName, objectName, Utils.getQuotedName(parent, dbType), textViewer, 0);
            } catch (BadLocationException e) {
                Log.log(Log.LOG_ERROR, "File with location exception: " + file.getName(), e); //$NON-NLS-1$
            } finally {
                provider.disconnect(file);
            }
        }
    }

    private IFolder createSchema(String name, boolean open, IProject project) throws CoreException {
        IFolder schemaFolder;
        String schemaFolderName = WorkDirs.getDirectoryNameForType(dbType, DbObjType.SCHEMA);
        if (dbType == DatabaseType.MS) {
            IFolder securityFolder = project.getFolder(new Path(WorkDirs.MS_SECURITY));
            if (!securityFolder.exists()) {
                securityFolder.create(false, true, null);
            }
            schemaFolder = securityFolder.getFolder(schemaFolderName);
        } else {
            IFolder rootSchemaFolder = project.getFolder(schemaFolderName);
            if (!rootSchemaFolder.exists()) {
                rootSchemaFolder.create(false, true, null);
            }
            schemaFolder = rootSchemaFolder.getFolder(FileUtils.getValidFilename(name));
        }

        if (!schemaFolder.exists()) {
            schemaFolder.create(false, true, null);
        }

        IFile file = schemaFolder.getFile(ModelExporter.getExportedFilenameSql(name));
        if (!file.exists()) {
            StringBuilder sb = new StringBuilder();
            String schemaText = MessageFormat.format(isClickHouseDb() ? CH_PATTERN : PATTERN,
                    Utils.getQuotedName(name, dbType));
            sb.append(schemaText);
            file.create(new ByteArrayInputStream(sb.toString().getBytes(
                    Charset.forName(file.getCharset()))), false, null);
        }

        if (open) {
            openFileInEditor(file);
        }
        return schemaFolder;
    }

    private IFile createObject(String schema, boolean open) throws CoreException {
        IFolder folder;
        if (schema == null) {
            if (dbType == DatabaseType.MS && type.in(DbObjType.SCHEMA, DbObjType.ROLE, DbObjType.USER)) {
                folder = getMsSecurityFolder();
            } else {
                folder = currentProj.getFolder(WorkDirs.getDirectoryNameForType(dbType, type));
                if (!folder.exists()) {
                    folder.create(false, true, null);
                }
            }
        } else {
            folder = getFolder(schema, type, currentProj);
        }

        IFile file = folder.getFile(getFileName(type, name));
        if (!file.exists()) {
            file.create(new ByteArrayInputStream(new byte[0]), false, null);
            if (open) {
                openFileInEditor(file, getTmplIdProtected(getTemplateType(), CREATE_POSTFIX, type), schema, name, null);
            }
        } else if (open) {
            openFileInEditor(file);
        }

        return file;
    }

    private String getFileName(DbObjType type, String name) {
        if (DatabaseType.MS == dbType && ObjectLevel.SCHEMA != ObjectLevel.getLevel(dbType, type)) {
            return FileUtils.getValidFilename(schema) + '.' + ModelExporter.getExportedFilenameSql(name);
        }

        return ModelExporter.getExportedFilenameSql(name);
    }

    private String getTemplateType() {
        return switch (dbType) {
        case CH -> SQLEditorTemplateContextType.CONTEXT_TYPE_CH;
        case MS -> SQLEditorTemplateContextType.CONTEXT_TYPE_MS;
        case PG -> SQLEditorTemplateContextType.CONTEXT_TYPE_PG;
        default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        };
    }

    private void createSubElement(boolean parentIsTable) throws CoreException {
        DbObjType parentType = parentIsTable ? DbObjType.TABLE : DbObjType.VIEW;
        IFile file = getFolder(schema, parentType, currentProj).getFile(getFileName(parentType, container));

        if (!file.exists()) {
            file.create(new ByteArrayInputStream(new byte[0]), false, null);
            createParentCodeOfSubEl(file, schema, container, parentType);
        }

        String tmplCtxTypeId = getTemplateType();
        String tmplIdPostfix = CREATE_POSTFIX;
        if (type == DbObjType.CONSTRAINT) {
            tmplCtxTypeId = SQLEditorTemplateContextType.CONTEXT_TYPE_COMMON;
            tmplIdPostfix = ".add"; //$NON-NLS-1$
        }

        openFileInEditor(file, getTmplIdProtected(tmplCtxTypeId, tmplIdPostfix, type), schema, name, container);
    }

    private void createParentCodeOfSubEl(IFile file, String schema, String parent, DbObjType parentType)
            throws CoreException {
        String tmplCtxTypeId = getTemplateType();
        openFileInEditor(file, getTmplIdProtected(tmplCtxTypeId, CREATE_POSTFIX, parentType), schema, parent, null);
    }

    /**
     * Returns template id with special postfix ".protected". <br />
     * <br />
     * ".protected" - this is a marker of belonging to the templates of mechanism for creating new objects; <br />
     * such marker is written at the end of the template id and means that this template is not displayed in the
     * properties and cannot be edited by users.
     *
     * @param tmplCtxTypeId
     *            template context type id
     * @param tmplIdPostfix
     *            postfix of template id
     * @param objType
     *            type of creating object
     * @return
     */
    private String getTmplIdProtected(String tmplCtxTypeId, String tmplIdPostfix,
            DbObjType objType) {
        return tmplCtxTypeId + tmplIdPostfix + objType.name().toLowerCase(Locale.ROOT);
    }

    private IFolder getFolder(String name, DbObjType type, IProject project) throws CoreException {
        IFolder schemaFolder = createSchema(name, false, project);
        String folderName = WorkDirs.getDirectoryNameForType(dbType, type);

        IFolder typeFolder;
        if (DatabaseType.MS == dbType) {
            typeFolder = project.getFolder(folderName);
        } else {
            typeFolder = schemaFolder.getFolder(folderName);
        }

        if (!typeFolder.exists()) {
            typeFolder.create(false, true, null);
        }
        return typeFolder;
    }

    private IFolder getMsSecurityFolder() throws CoreException {
        IFolder securityFolder = currentProj.getFolder(new Path(WorkDirs.MS_SECURITY));
        if (!securityFolder.exists()) {
            securityFolder.create(false, true, null);
        }
        IFolder objFolder = securityFolder.getFolder(WorkDirs.getDirectoryNameForType(dbType, type));
        if (!objFolder.exists()) {
            objFolder.create(false, true, null);
        }
        return objFolder;
    }
}