package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.io.ByteArrayInputStream;
import java.text.MessageFormat;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;

public interface IPgObjectPage extends IWizardPage {

    static final String POSTFIX = ".sql"; //$NON-NLS-1$
    static final String GROUP_DELIMITER =
            "\n--------------------------------------------------------------------------------\n\n"; //$NON-NLS-1$
    static final String OWNER_TO = "\n\nALTER {0} {1} OWNER TO CURRENT_DB_USER;\n"; //$NON-NLS-1$
    static final String PATTERN = "CREATE {0} {1};"; //$NON-NLS-1$

    static final String RULE_PATTERN = "CREATE RULE {0} AS\n\tON UPDATE TO {1} DO NOTHING;\n";//$NON-NLS-1$
    static final String TRIGGER_PATTERN = "CREATE TRIGGER {0}\n\tBEFORE UPDATE ON {1}" //$NON-NLS-1$
            + "\n\tFOR EACH STATEMENT\n\tEXECUTE PROCEDURE function_name_placeholder();\n"; //$NON-NLS-1$
    static final String CONSTRAINT_PATTERN = "ALTER TABLE {0}\n\tADD CONSTRAINT {1}" //$NON-NLS-1$
            + " PRIMARY KEY ({2});\n"; //$NON-NLS-1$
    static final String INDEX_PATTERN = "CREATE INDEX {0} ON {1} USING btree ({2});\n"; //$NON-NLS-1$

    boolean canFinish();
    boolean createFile();

    static void openFileInEditor(IFile file) throws PartInitException {
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .openEditor(new FileEditorInput(file), EDITOR.SQL);
    }

    static IFolder createSchema(String name, boolean open, IProject project) throws CoreException {
        IFolder projectFolder = project.getFolder(DbObjType.SCHEMA.name());
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

    static void createExtension(String name, IProject project) throws CoreException {
        IFolder folder = project.getFolder(DbObjType.EXTENSION.name());
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

    static IFile createObject(String schema, String name, DbObjType type,
            boolean open, IProject project) throws CoreException {
        String objectName = name;
        IFolder folder = getFolder(schema, type, project);
        IFile file = folder.getFile(name + POSTFIX);
        if (type == DbObjType.FUNCTION) {
            int paren = name.indexOf('(');
            if (paren != -1) {
                file = folder.getFile(name.substring(0, paren) + POSTFIX);
            } else {
                objectName +="()"; //$NON-NLS-1$
            }
        }
        StringBuilder sb = new StringBuilder("SET search_path = " + schema //$NON-NLS-1$
                + ", pg_catalog;\n\nCREATE "+ type + ' ' + objectName); //$NON-NLS-1$
        switch (type) {
        case TYPE:
            sb.append(';');
            break;
        case DOMAIN:
            sb.append(" AS datatype;"); //$NON-NLS-1$
            break;
        case FUNCTION:
            sb.append(" RETURNS void\n\tLANGUAGE sql AS \n$$\n\t --function body \n$$;"); //$NON-NLS-1$
            break;
        case TABLE:
            sb.append(" (\n);"); //$NON-NLS-1$
            break;
        default:
            sb.append(" AS\n\tSELECT 'select_text'::text AS text;"); //$NON-NLS-1$
            break;
        }

        sb.append(MessageFormat.format(OWNER_TO, type, objectName));

        if (!file.exists()) {
            file.create(new ByteArrayInputStream(sb.toString().getBytes()), false, null);
        }
        if (open) {
            openFileInEditor(file);
        }
        return file;
    }

    static void createSubElement(String schema, String parent, String column,
            String name, boolean parentIsTable,  IProject project, DbObjType type) throws CoreException {
        DbObjType parentType = parentIsTable? DbObjType.TABLE : DbObjType.VIEW;
        IFile file = createObject(schema, parent, parentType, false, project);
        StringBuilder sb = new StringBuilder(GROUP_DELIMITER);
        if (type == DbObjType.RULE) {
            sb.append(MessageFormat.format(RULE_PATTERN, name, parent));
        } else if (type == DbObjType.TRIGGER) {
            sb.append(MessageFormat.format(TRIGGER_PATTERN, name, parent));
        } else if (type == DbObjType.CONSTRAINT) {
            sb.append(MessageFormat.format(CONSTRAINT_PATTERN, parent, name, column));
        } else {
            sb.append(MessageFormat.format(INDEX_PATTERN, name, parent, column));
        }
        file.appendContents(new ByteArrayInputStream(sb.toString().getBytes()), true, true, null);
        openFileInEditor(file);
    }

    static IFolder getFolder(String name, DbObjType type, IProject project) throws CoreException {
        IFolder schemaFolder = createSchema(name, false, project);
        IFolder typeFolder = schemaFolder.getFolder(type.name());
        if (!typeFolder.exists()) {
            typeFolder.create(false, true, null);
        }
        return typeFolder;
    }
}