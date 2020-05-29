package ru.taximaxim.codekeeper.ui.prefs;

import java.io.IOException;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.security.storage.StorageException;
import org.eclipse.jface.preference.PreferencePage;
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
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbStoreEditorDialog;
import ru.taximaxim.codekeeper.ui.dialogs.PgPassDialog;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.xmlstore.DbXmlStore;
import ru.taximaxim.pgpass.PgPass;

public class DbStorePrefPage extends PreferencePage
implements IWorkbenchPreferencePage {

    private DbStorePrefListEditor dbList;

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected Control createContents(Composite parent) {
        dbList = new DbStorePrefListEditor(parent);
        dbList.setInputList(DbInfo.readStoreFromXml());
        return dbList;
    }

    @Override
    protected void performDefaults() {
        dbList.setInputList(Arrays.asList(
                new DbInfo("default", "", "", "", "", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
                        0, false, false, new ArrayList<>(), new HashMap<>(), false, false, "", //$NON-NLS-1$
                        DbInfo.DEFAULT_EXECUTE_PATH, DbInfo.DEFAULT_CUSTOM_PARAMS, false)));
    }

    @Override
    public boolean performOk() {
        setErrorMessage(null);
        try {
            try {
                DbXmlStore.INSTANCE.savePasswords(dbList.getList());
            } catch (StorageException e) {
                MessageBox mb;
                String text;
                if (Platform.OS_LINUX.equals(Platform.getOS())) {
                    mb = new MessageBox(getShell(), SWT.ICON_WARNING | SWT.YES | SWT.NO);
                    text = Messages.DbStorePrefPage_secure_storage_error_text_linux;
                } else {
                    mb = new MessageBox(getShell(), SWT.ERROR);
                    text = Messages.DbStorePrefPage_secure_storage_error_text_other;
                }
                mb.setMessage(MessageFormat.format(text, e.getLocalizedMessage()));
                mb.setText(Messages.DbStorePrefPage_secure_storage_error_title);
                if (mb.open() != SWT.YES) {
                    setErrorMessage(e.getLocalizedMessage());
                    return false;
                }
            }
            DbXmlStore.INSTANCE.writeObjects(dbList.getList());
            return true;
        } catch (IOException e) {
            setErrorMessage(e.getLocalizedMessage());
            return false;
        }
    }
}

class DbStorePrefListEditor extends PrefListEditor<DbInfo> {

    public DbStorePrefListEditor(Composite parent) {
        super(parent);
        getViewer().addDoubleClickListener(event -> editObject());
    }

    @Override
    protected DbInfo getNewObject(DbInfo oldObject) {
        DbStoreEditorDialog dialog = new DbStoreEditorDialog(getShell(), oldObject);
        return dialog.open() == Window.OK ? dialog.getDbInfo() : null;
    }

    @Override
    protected String errorAlreadyExists(DbInfo obj) {
        return MessageFormat.format(Messages.DbStorePrefPage_already_present, obj.getName());
    }

    @Override
    protected void addColumns(TableViewer tableViewer) {
        TableViewerColumn col = new TableViewerColumn(tableViewer, SWT.NONE);
        col.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                return ((DbInfo) element).getName();
            }

            @Override
            public Image getImage(Object element) {
                return Activator.getRegisteredImage(((DbInfo) element).isMsSql() ? FILE.MS_ICON : FILE.PG_ICON);
            }
        });
    }

    @Override
    protected void createButtonsForSideBar(Composite parent) {
        createButton(parent, ADD_ID, Messages.add, Activator.getEclipseImage(ISharedImages.IMG_OBJ_ADD));
        createButton(parent, COPY_ID, Messages.copy, Activator.getEclipseImage(ISharedImages.IMG_TOOL_COPY));
        createButton(parent, EDIT_ID, Messages.edit, Activator.getRegisteredImage(FILE.ICONEDIT));
        createButton(parent, DELETE_ID, Messages.delete, Activator.getEclipseImage(ISharedImages.IMG_ETOOL_DELETE));

        Button btnPgPass = createButton(parent, CLIENT_ID,
                Messages.DbStorePrefPage_pg_pass_import_tooltip, FILE.PGPASS);
        btnPgPass.setLayoutData(new GridData(SWT.DEFAULT, SWT.END, false, true));

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
}