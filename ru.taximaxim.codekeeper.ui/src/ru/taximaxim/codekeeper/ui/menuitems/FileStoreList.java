package ru.taximaxim.codekeeper.ui.menuitems;

import java.io.File;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbStorePicker;

public class FileStoreList extends ContributionItem {

    @Override
    public void fill(Menu menu, int index) {
        IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();
        Deque<File> files = DbStorePicker.stringToDumpFileHistory(prefStore.getString(PREF.DB_STORE_FILES));

        for (File file : files) {
            CommandContributionItemParameter paramToProject = new CommandContributionItemParameter(
                    PlatformUI.getWorkbench(),
                    UIConsts.EDITOR_COMMANDS.GET_CHANGES,
                    UIConsts.EDITOR_COMMANDS.GET_CHANGES,
                    CommandContributionItem.STYLE_PUSH);

            paramToProject.label = file.getName();
            paramToProject.icon = ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(FILE.ICONFILE));
            Map<String, String> param = new HashMap<>(1);
            param.put(UIConsts.EDITOR_COMMANDS.FILE_PATH, file.getAbsolutePath());
            paramToProject.parameters = param;
            CommandContributionItem item = new CommandContributionItem(paramToProject);
            item.fill(menu, index);
        }
    }

    @Override
    public boolean isDynamic(){
        return true;
    }
}