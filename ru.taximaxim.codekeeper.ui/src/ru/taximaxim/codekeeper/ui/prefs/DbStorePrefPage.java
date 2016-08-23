package ru.taximaxim.codekeeper.ui.prefs;

import java.text.MessageFormat;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbStoreEditorDialog;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

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
        dbList.setInputList(DbInfo.preferenceToStore(getPreferenceStore().getString(PREF.DB_STORE)));
        return dbList;
    }

    @Override
    protected void performDefaults() {
        dbList.setInputList(DbInfo.preferenceToStore(getPreferenceStore().getDefaultString(PREF.DB_STORE)));
    }

    @Override
    public boolean performOk() {
        if(getPreferenceStore() != null) {
            getPreferenceStore().setValue(PREF.DB_STORE, DbInfo.storeToPreference(dbList.getList()));
        }
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
        GridData gd =  new GridData(SWT.FILL, SWT.FILL, true, true, 1, 5);
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
}
