package ru.taximaxim.codekeeper.ui.menuitems;

import java.io.File;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.COMMAND;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;

public class FileStoreList extends ContributionItem {

    @Override
    public void fill(Menu menu, int index) {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        Object currentDB = editor instanceof ProjectEditorDiffer ? ((ProjectEditorDiffer) editor).getLastDb() : null;

        IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();
        Deque<File> files = DbStorePicker.stringToDumpFileHistory(prefStore.getString(PREF.DB_STORE_FILES), false);

        int i = 0;
        for (File file : files) {
            CommandContributionItemParameter paramToProject = new CommandContributionItemParameter(
                    PlatformUI.getWorkbench(), null, COMMAND.GET_CHANGES,
                    CommandContributionItem.STYLE_PUSH);

            paramToProject.label = file.getName();
            paramToProject.icon = ImageDescriptor.createFromURL(Activator.getContext().getBundle()
                    .getResource(file.equals(currentDB) ? FILE.ICONCHECK : FILE.ICONFILE));
            Map<String, String> param = new HashMap<>(1);
            param.put(COMMAND.PARAM_FILE_PATH, file.getAbsolutePath());
            paramToProject.parameters = param;
            CommandContributionItem item = new CommandContributionItem(paramToProject);
            item.fill(menu, index + (i++));
        }
    }

    @Override
    public boolean isDynamic(){
        return true;
    }
}