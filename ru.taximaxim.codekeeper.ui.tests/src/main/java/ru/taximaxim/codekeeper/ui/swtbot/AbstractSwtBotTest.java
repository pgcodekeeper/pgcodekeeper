/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.swtbot;

import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.jupiter.api.BeforeEach;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public abstract class AbstractSwtBotTest {

    protected static final SWTWorkbenchBot bot = new SWTWorkbenchBot();

    private static final long DEFAULT_TIME_OUT = 5_000;

    static {
        IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();
        mainPrefs.setDefault(DB_UPDATE_PREF.DELETE_SCRIPT_AFTER_CLOSE, MessageDialogWithToggle.ALWAYS);
    }

    @BeforeEach
    protected void setDefaultShell() {
        bot.shell("data").activate();
    }

    protected void createPgCodekeeperProject(String projectName, DatabaseType dbType) {
        bot.menu("File").menu("New").menu(Messages.NavigatorRootLabelProvider_open_editor).click();
        bot.shell(Messages.newProjWizard_new_pg_db_project).activate();
        bot.textWithLabel(Messages.PgImportWizardImportPage_name).setText(projectName);
        bot.button("Next >").click();
        bot.comboBoxWithLabel(Messages.NewProjWizard_select_project_type).setSelection(dbType.getDbTypeName());
        bot.checkBox(Messages.NewProjWizard_initializing_check).deselect();
        bot.button("Finish").click();
    }

    protected void deleteProject(String projectName, boolean deleteContent) {
        SWTBotTreeItem project = bot.viewByTitle("Project Explorer").bot().tree().getTreeItem(projectName);
        project.contextMenu("Delete").click();
        if (deleteContent) {
            bot.checkBox("Delete project contents on disk (cannot be undone)").click();
        }
        bot.button("OK").click();
        var prExpr = bot.viewByTitle("Project Explorer");
        bot.waitUntil(new DefaultCondition() {

            @Override
            public boolean test() throws Exception {
                try {
                    prExpr.bot().tree().selectionCount();
                    return false;
                } catch (Exception e) {
                    return true;
                }

            }

            @Override
            public String getFailureMessage() {
                return "project didn't delete";
            }
        }, DEFAULT_TIME_OUT);
    }

}
