package ru.taximaxim.codekeeper.ui.prefs;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.dbstore.DbStoreEditorDialog;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DbStorePrefPage extends FieldEditorPreferencePage
implements IWorkbenchPreferencePage {

    private ListViewer listObjs;
    private String preference;
    private boolean needUpdateDataBases = false;
    Map<String, DbInfo> dataBases;

    public DbStorePrefPage() {
        super(GRID);
    }

    @Override
    public void init(IWorkbench workbench) {
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected void createFieldEditors() {
        // this is our "hidden field editor"
        preference = getPreferenceStore().getString(PREF.DB_STORE);
    }

    @Override
    public void createControl(Composite parent) {
        super.createControl(parent);

        Button btnDef = getDefaultsButton();
        btnDef.setText(Messages.dbStorePrefPage_clear_db_store);
        ((GridData) btnDef.getLayoutData()).widthHint =
                btnDef.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
        btnDef.getParent().layout();
    }

    @Override
    protected Control createContents(Composite parent) {
        LocalResourceManager lrm = new LocalResourceManager(
                JFaceResources.getResources());

        GridLayout layout= new GridLayout();
        layout.numColumns= 2;
        layout.marginHeight= 0;
        layout.marginWidth= 0;

        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        composite.setLayout(gridLayout);
        composite.setLayoutData(new GridData(GridData.FILL_BOTH));

        listObjs = new ListViewer(composite);
        listObjs.getList().setLayoutData(new GridData(GridData.FILL_BOTH));

        listObjs.setContentProvider(new ArrayContentProvider());
        listObjs.setLabelProvider(new LabelProvider());

        Composite buttons= new Composite(composite, SWT.NONE);
        buttons.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
        layout= new GridLayout();
        layout.marginHeight= 0;
        layout.marginWidth= 0;
        buttons.setLayout(layout);

        Button fAddButton= new Button(buttons, SWT.PUSH);
        fAddButton.setImage(lrm.createImage(ImageDescriptor.createFromURL(Activator
                .getContext().getBundle().getResource(FILE.ICONADD))));
        fAddButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        fAddButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event e) {
                DbStoreEditorDialog dialog = new DbStoreEditorDialog(getShell(), null);
                if(dialog.open() == Dialog.OK) {
                    dataBases.put(dialog.getDbInfo().getName(), dialog.getDbInfo());
                    listObjs.setInput(dataBases.keySet());
                }
            }
        });

        Button fRemoveButton= new Button(buttons, SWT.PUSH);
        fRemoveButton.setImage(lrm.createImage(ImageDescriptor.createFromURL(Activator
                .getContext().getBundle().getResource(FILE.ICONDEL))));
        fRemoveButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        fRemoveButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event e) {
                dataBases.remove(listObjs.getList().getSelection()[0]);
                listObjs.setInput(dataBases.keySet());
            }
        });

        Button fEditButton= new Button(buttons, SWT.PUSH);
        fEditButton.setImage(lrm.createImage(ImageDescriptor.createFromURL(Activator
                .getContext().getBundle().getResource(FILE.ICONEDIT))));
        fEditButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        fEditButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event e) {
                if (listObjs.getList().getSelectionIndex() == -1){
                    return;
                }
                String editDb = listObjs.getList().getSelection()[0];

                DbStoreEditorDialog dialog =
                        new DbStoreEditorDialog(getShell(), dataBases.get(editDb));
                if(dialog.open() == Dialog.OK) {
                    dataBases.put(dialog.getDbInfo().getName(), dialog.getDbInfo());
                    if (!editDb.equals(dialog.getDbInfo().getName())){
                        dataBases.remove(editDb);
                        listObjs.setInput(dataBases.keySet());
                    }
                }
            }
        });

        Button fUpButton= new Button(buttons, SWT.PUSH);
        fUpButton.setImage(lrm.createImage(ImageDescriptor.createFromURL(Activator
                .getContext().getBundle().getResource(FILE.ICONUP))));
        fUpButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        fUpButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event e) {
                String tmp = listObjs.getList().getSelection()[0];
                int selectIndex = listObjs.getList().getSelectionIndex();
                if (selectIndex <= 0){
                    return;
                }
                listObjs.getList().setItem(selectIndex, listObjs.getList().getItem(selectIndex - 1));
                listObjs.getList().setItem(selectIndex - 1, tmp);
                needUpdateDataBases = true;
            }
        });

        Button fDownButton= new Button(buttons, SWT.PUSH);
        fDownButton.setImage(lrm.createImage(ImageDescriptor.createFromURL(Activator
                .getContext().getBundle().getResource(FILE.ICONDOWN))));
        fDownButton.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        fDownButton.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event e) {
                String tmp = listObjs.getList().getSelection()[0];
                int selectIndex = listObjs.getList().getSelectionIndex();
                if (selectIndex >= listObjs.getList().getItemCount() - 1){
                    return;
                }
                listObjs.getList().setItem(selectIndex, listObjs.getList().getItem(selectIndex + 1));
                listObjs.getList().setItem(selectIndex + 1, tmp);
                needUpdateDataBases = true;
            }
        });
        updateList();
        return super.createContents(parent);
    }

    @Override
    protected void performDefaults() {
        preference = getPreferenceStore().getDefaultString(PREF.DB_STORE);
        dataBases = DbInfo.preferenceToStore(preference);
        listObjs.setInput(dataBases.keySet());
    }

    @Override
    public boolean performOk() {
        if (needUpdateDataBases){
            Map<String, DbInfo> temp = new LinkedHashMap<>();
            for (String dataBase : listObjs.getList().getItems()){
                temp.put(dataBase, dataBases.get(dataBase));
            }
            dataBases.clear();
            dataBases.putAll(temp);
        }
        if(getPreferenceStore() != null) {
            getPreferenceStore().setValue(PREF.DB_STORE, DbInfo.storeToPreference(dataBases));
        }
        return true;
    }

    private void updateList() {
        preference = getPreferenceStore().getString(PREF.DB_STORE);
        dataBases = DbInfo.preferenceToStore(preference);
        listObjs.setInput(dataBases.keySet());
    }
}