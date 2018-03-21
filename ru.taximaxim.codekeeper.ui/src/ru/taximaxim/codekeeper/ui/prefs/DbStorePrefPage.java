package ru.taximaxim.codekeeper.ui.prefs;

import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbStoreEditorDialog;
import ru.taximaxim.codekeeper.ui.dialogs.PgPassDialog;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.xmlstore.DbXmlStore;

public class DbStorePrefPage extends PreferencePage
implements IWorkbenchPreferencePage {

    private DbStorePrefListEditor dbList;

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);

        Button btnDef = getDefaultsButton();
        btnDef.setText(Messages.dbStorePrefPage_clear_db_store);
        GridData defGd = (GridData) btnDef.getLayoutData();
        defGd.widthHint = Math.max(defGd.widthHint,
                btnDef.computeSize(SWT.DEFAULT, SWT.DEFAULT).x);
        btnDef.getParent().layout();
    }

    @Override
    protected Control createContents(Composite parent) {
        dbList = new DbStorePrefListEditor(parent);
        dbList.setInputList(DbInfo.readStoreFromXml(getPreferenceStore().getString(PREF.DB_STORE)));
        return dbList;
    }

    @Override
    protected void performDefaults() {
        DbXmlStore.INSTANCE.writeDbStoreList(Arrays.asList(
                new DbInfo("default", "", "", "", "", 0, false, new ArrayList<>()))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
    }

    @Override
    public boolean performOk() {
        DbXmlStore.INSTANCE.writeDbStoreList(dbList.getList());
        return true;
    }
}

class DbStorePrefListEditor extends PrefListEditor<DbInfo, ListViewer> {

    public DbStorePrefListEditor(Composite parent) {
        super(parent, false, true, true);
    }

    @Override
    protected DbInfo getNewObject(DbInfo oldObject) {
        DbStoreEditorDialog dialog = new DbStoreEditorDialog(getShell(), oldObject);
        return dialog.open() == DbStoreEditorDialog.OK ? dialog.getDbInfo() : null;
    }

    @Override
    protected String errorAlreadyExists(DbInfo obj) {
        return MessageFormat.format(Messages.DbStorePrefPage_already_present, obj.getName());
    }

    @Override
    protected ListViewer createViewer(Composite parent) {
        ListViewer viewerObjs = new ListViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        GridData gd =  new GridData(SWT.FILL, SWT.FILL, true, true, 1, 6);
        gd.widthHint = PREF_PAGE.WIDTH_HINT_PX;
        viewerObjs.getControl().setLayoutData(gd);

        viewerObjs.setContentProvider(ArrayContentProvider.getInstance());
        viewerObjs.setLabelProvider(new LabelProvider() {

            @Override
            public String getText(Object element) {
                return ((DbInfo) element).getName();
            }
        });
        return viewerObjs;
    }

    @Override
    protected void createAdditionalButtons(PrefListEditor<DbInfo, ListViewer> editor,
            ListViewer viewer, LocalResourceManager lrm) {
        Button btnPgPass = new Button(editor, SWT.NONE);
        btnPgPass.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_END));
        btnPgPass.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.PGPASS))));
        btnPgPass.setToolTipText(Messages.DbStorePrefPage_pg_pass_import_tooltip);
        btnPgPass.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent event) {
                FileDialog dialog = new FileDialog(getShell());
                dialog.setText(Messages.DbStorePrefPage_pg_pass_file_select_title);
                dialog.setFilterExtensions(new String[] {"*.pgpass", "*"}); //$NON-NLS-1$ //$NON-NLS-2$
                dialog.setFilterNames(new String[] {
                        Messages.DbStorePrefPage_pg_pass_file_filter,
                        Messages.DiffPresentationPane_any_file_filter});
                Path path = JdbcConnector.getPgPassLocation();
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