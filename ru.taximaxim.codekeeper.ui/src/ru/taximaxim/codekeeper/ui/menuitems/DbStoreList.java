package ru.taximaxim.codekeeper.ui.menuitems;

import java.util.HashMap;
import java.util.List;
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
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;

public class DbStoreList extends ContributionItem {

    @Override
    public void fill(Menu menu, int index) {
        IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        Object currentDB = editor instanceof ProjectEditorDiffer ? ((ProjectEditorDiffer) editor).getLastDb() : null;

        IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();
        List<DbInfo> store = DbInfo.preferenceToStore(prefStore.getString(PREF.DB_STORE));
        for (DbInfo db : store) {
            CommandContributionItemParameter paramToProject = new CommandContributionItemParameter(
                    PlatformUI.getWorkbench(), null, COMMAND.GET_CHANGES,
                    CommandContributionItem.STYLE_PUSH);

            Map<String, String> param = new HashMap<>(1);
            param.put(COMMAND.PARAM_DB_COORDS, db.toString());
            paramToProject.parameters = param;
            paramToProject.label = db.getName();
            paramToProject.icon = ImageDescriptor.createFromURL(Activator.getContext().getBundle()
                    .getResource(db.equals(currentDB) ? FILE.ICONCHECK : FILE.ICONDATABASE));
            CommandContributionItem item = new CommandContributionItem(paramToProject);
            item.fill(menu, index);
        }
    }

    @Override
    public boolean isDynamic(){
        return true;
    }
}
