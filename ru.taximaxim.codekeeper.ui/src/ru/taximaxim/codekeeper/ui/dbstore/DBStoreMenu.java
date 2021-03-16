package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.File;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.dialogs.PreferencesUtil;

import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DBStoreMenu{
    private final MenuManager menuMgrGetChangesCustom;
    private final ProjectEditorDiffer editor;
    private final IPreferenceStore prefStore;

    public DBStoreMenu(MenuManager menuMgrGetChangesCustom, ProjectEditorDiffer editor, IPreferenceStore prefStore) {
        this.menuMgrGetChangesCustom = menuMgrGetChangesCustom;
        this.editor = editor;
        this.prefStore = prefStore;
    }

    public void fillMenu() {
        String title = editor.getEditorInput().getName() + " - ";
        List<DbInfo> store = DbInfo.readStoreFromXml();
        Collection<File> files = DbStorePicker.stringToDumpFileHistory(prefStore.getString(PREF.DB_STORE_FILES));
        boolean isMsProj = OpenProjectUtils.checkMsSql(editor.getProject());
        for (DbInfo dbInfo : store) {
            if (isMsProj == dbInfo.isMsSql()) {
                addAction(dbInfo, title);
            }
        }

        menuMgrGetChangesCustom.add(new Action(Messages.DbStorePicker_open_db_store) {

            @Override
            public void run() {
                PreferencesUtil
                .createPreferenceDialogOn(editor.getEditorSite().getShell(), PREF_PAGE.DB_STORE, null, null)
                .open();
            }
        });
        menuMgrGetChangesCustom.add(new Separator());
        menuMgrGetChangesCustom.add(new Action(Messages.DbStorePicker_load_from_file) {

            @Override
            public void run() {
                File dumpFile = DbStorePicker.chooseDbSource(prefStore, editor.getEditorSite().getShell(), false);
                if (dumpFile != null) {
                    editor.setCurrentDb(dumpFile);
                    editor.setEditorName(title + dumpFile.getName());
                }
            }
        });

        for (File f : files) {
            if (f.isFile()) {
                Action fileAction = new Action(f.getName(), IAction.AS_RADIO_BUTTON) {

                    @Override
                    public void run() {
                        editor.setCurrentDb(f);
                        editor.setEditorName(title + f.getName());
                    }
                };
                menuMgrGetChangesCustom.add(fileAction);
                if (f.equals(editor.getCurrentDb())) {
                    fileAction.setChecked(true);
                }
            }
        }
    }

    private void addAction(DbInfo dbInfo, String title){
        Action dbAction = new Action(dbInfo.getName() + "@", IAction.AS_RADIO_BUTTON) {

            @Override
            public void run() {
                editor.setCurrentDb(dbInfo);
                editor.setEditorName(title+dbInfo.getName());
            }
        };
        menuMgrGetChangesCustom.add(dbAction);
        if (dbInfo.equals(editor.getCurrentDb())) {
            dbAction.setChecked(true);
        }
    }
}
