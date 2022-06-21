package ru.taximaxim.codekeeper.ui.prefs;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.security.storage.StorageException;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbStoreEditorDialog;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.dialogs.PgPassDialog;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.xmlstore.DbXmlStore;
import ru.taximaxim.pgpass.PgPass;

public class DbStorePrefPage extends FieldEditorPreferencePage
implements IWorkbenchPreferencePage {

    private DbStorePrefListEditor dbList;
    private BooleanFieldEditor useSecureStorage;
    private List<DbInfo> oldDbList;

    public DbStorePrefPage() {
        super(GRID);
    }

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected void createFieldEditors() {
        dbList = new DbStorePrefListEditor(getFieldEditorParent());
        dbList.setLayoutData(new GridData(GridData.FILL_BOTH));
        List<DbInfo> dbInfoList = DbInfo.readStoreFromXml();

        DbInfo.fillDblist(dbInfoList);
        dbList.setInputList(dbInfoList);
        oldDbList = new ArrayList<>(dbList.getList());

        useSecureStorage = new BooleanFieldEditor(PREF.SAVE_IN_SECURE_STORAGE,
                Messages.GeneralPrefPage_save_in_security_storage, getFieldEditorParent());
        addField(useSecureStorage);
    }

    @Override
    protected void performDefaults() {
        dbList.setInputList(Arrays.asList(
                new DbInfo("default", "", "", "", "", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                        0, false, false, new ArrayList<>(), new HashMap<>(), false, false, "", //$NON-NLS-1$
                        DbInfo.DEFAULT_EXECUTE_PATH, DbInfo.DEFAULT_CUSTOM_PARAMS, false, ""))); //$NON-NLS-1$
    }

    @Override
    public boolean performOk() {
        setErrorMessage(null);
        try {
            if (useSecureStorage.getBooleanValue()) {
                try {
                    DbXmlStore.INSTANCE.savePasswords(dbList.getList(), oldDbList);
                } catch (StorageException e) {
                    MessageBox mb = new MessageBox(getShell(), SWT.ICON_WARNING | SWT.YES | SWT.NO);
                    String text;
                    if (Platform.OS_LINUX.equals(Platform.getOS())) {
                        text = Messages.DbStorePrefPage_secure_storage_error_text_linux;
                    } else {
                        text = Messages.DbStorePrefPage_secure_storage_error_text_other;
                    }
                    mb.setMessage(MessageFormat.format(text, e.getLocalizedMessage()));
                    mb.setText(Messages.DbStorePrefPage_secure_storage_error_title);
                    if (mb.open() != SWT.YES) {
                        setErrorMessage(Messages.DbStorePrefPage_secure_storage_error + e.getLocalizedMessage());
                        return false;
                    }
                    getPreferenceStore().setValue(PREF.SAVE_IN_SECURE_STORAGE, false);
                    useSecureStorage.load();
                }
            }
            DbXmlStore.INSTANCE.writeObjects(dbList.getList());
            super.performOk();
            return true;
        } catch (IOException e) {
            setErrorMessage(e.getLocalizedMessage());
            return false;
        }
    }
}

class DbStorePrefListEditor extends PrefListEditor<DbInfo> {

    private String action;

    public DbStorePrefListEditor(Composite parent) {
        super(parent);
        getViewer().addDoubleClickListener(event -> editObject());
    }

    @Override
    protected DbInfo getNewObject(DbInfo oldObject) {
        DbStoreEditorDialog dialog = new DbStoreEditorDialog(getShell(), oldObject, action, getDbGroup() );
        return dialog.open() == Window.OK ? dialog.getDbInfo() : null;
    }

    @Override
    protected String errorAlreadyExists(DbInfo obj) {
        return MessageFormat.format(Messages.DbStorePrefPage_already_present, obj.getName());
    }

    protected Set<String> getDbGroup() {
        Set<String> dbGroups = new LinkedHashSet<>();
        getList().stream().forEach(dbInfo -> dbGroups.add(dbInfo.getDbGroup()));
        return dbGroups;
    }

    @Override
    public void refresh() {
        DbInfo.fillDblist(getList());
        super.refresh();
    }

    @Override
    public void setInputList(List<DbInfo> list){
        DbInfo.fillDblist(list);
        super.setInputList(list);
    }

    @Override
    protected void addColumns(TableViewer tableViewer) {
        TableViewerColumn dbGroupCol = new TableViewerColumn(tableViewer, SWT.NONE);
        dbGroupCol.getColumn().setText(Messages.DbStorePrefPage_db_group);
        dbGroupCol.getColumn().setResizable(true);
        dbGroupCol.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                return ((DbInfo) element).getDbGroup();
            }
        });
        PixelConverter pc = new PixelConverter(tableViewer.getControl());
        dbGroupCol.getColumn().setWidth(pc.convertWidthInCharsToPixels(15));

        TableViewerColumn dbNameCol = new TableViewerColumn(tableViewer, SWT.NONE);
        dbNameCol.getColumn().setText(Messages.DbStorePrefPage_db);
        dbNameCol.getColumn().setResizable(true);
        dbNameCol.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                return ((DbInfo) element).getName();
            }

            @Override
            public Image getImage(Object element) {
                return Activator.getRegisteredImage(((DbInfo) element).isMsSql() ? FILE.MS_ICON : FILE.PG_ICON);
            }
        });
        dbNameCol.getColumn().setWidth(pc.convertWidthInCharsToPixels(50));
    }

    @Override
    protected void createButtonsForSideBar(Composite parent) {
        createButton(parent, ADD_ID, Messages.add, Activator.getEclipseImage(ISharedImages.IMG_OBJ_ADD));
        createButton(parent, COPY_ID, Messages.copy, Activator.getEclipseImage(ISharedImages.IMG_TOOL_COPY));
        createButton(parent, EDIT_ID, Messages.edit, Activator.getRegisteredImage(FILE.ICONEDIT));
        createButton(parent, DELETE_ID, Messages.delete, Activator.getEclipseImage(ISharedImages.IMG_ETOOL_DELETE));

        Button exportDB = createButton(parent, CLIENT_ID, Messages.DbStorePrefPage_export_db, FILE.ICONEXPORT);
        exportDB.setLayoutData(new GridData(SWT.DEFAULT, SWT.END, false, true));

        exportDB.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(getShell(), SWT.SAVE);
                dialog.setText(Messages.DbStorePrefPage_export_db);
                dialog.setFilterExtensions(new String[] { "*.xml", "*" }); //$NON-NLS-1$ //$NON-NLS-2$
                dialog.setFilterNames(new String[] { Messages.DbStorePrefPage_xml_files, Messages.DiffPresentationPane_any_file_filter });
                dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());

                String stringPath = dialog.open();
                if (stringPath != null) {
                    try {
                        new DbXmlStore(Paths.get(stringPath)).writeObjects(getList());
                    } catch (IOException ex) {
                        ExceptionNotifier.notifyDefault(Messages.DbStorePrefPage_saving_error, ex);
                    }
                }
            }
        });

        Button importDB = createButton(parent, CLIENT_ID, Messages.DbStorePrefPage_import_db_list, FILE.ICONIMPORT);

        importDB.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
                dialog.setText(Messages.DbStorePrefPage_import_db_list);
                dialog.setFilterExtensions(new String[] { "*.xml", "*" }); //$NON-NLS-1$ //$NON-NLS-2$
                dialog.setFilterNames(new String[] {Messages.DbStorePrefPage_xml_files, Messages.DiffPresentationPane_any_file_filter });
                dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());

                String stringPath = dialog.open();
                if (stringPath != null) {
                    try {
                        DbStorePrefListEditor.this.setInputList(new DbXmlStore(Paths.get(stringPath)).readObjects());
                    } catch (IOException ex) {
                        ExceptionNotifier.notifyDefault(Messages.DbStorePrefPage_opening_error, ex);
                    }
                }
            }
        });

        Button btnPgPass = createButton(parent, CLIENT_ID,
                Messages.DbStorePrefPage_pg_pass_import_tooltip, FILE.PGPASS);

        btnPgPass.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent event) {
                FileDialog dialog = new FileDialog(getShell());
                dialog.setText(Messages.DbStorePrefPage_pg_pass_file_select_title);
                dialog.setFilterExtensions(new String[] {"*.pgpass", "*"}); //$NON-NLS-1$ //$NON-NLS-2$
                dialog.setFilterNames(new String[] {
                        Messages.DbStorePrefPage_pg_pass_file_filter,
                        Messages.DiffPresentationPane_any_file_filter});
                Path path = PgPass.getPgPassPath();
                dialog.setFilterPath(path.getParent().toString());
                dialog.setFileName(path.getFileName().toString());
                String s = dialog.open();
                if (s != null) {
                    new PgPassDialog(getShell(), s, DbStorePrefListEditor.this).open();
                }
            }
        });
    }

    @Override
    protected void editObject() {
        action = Messages.DbStorePrefPage_action_edit;
        super.editObject();
    }

    @Override
    protected void copyObject() {
        action = Messages.DbStorePrefPage_action_copy;
        super.copyObject();
    }

    @Override
    public void addNewObject(DbInfo oldObject) {
        action = Messages.DbStorePrefPage_action_add_new;
        super.addNewObject(oldObject);
    }
}
