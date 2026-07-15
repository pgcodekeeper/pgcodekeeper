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

import static org.eclipse.swtbot.swt.finder.SWTBotAssert.assertContains;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Locale;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotLink;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.jupiter.api.AfterEach;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.UIConsts.DB_UPDATE_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.swtbot.utils.IBotProvider;
import ru.taximaxim.codekeeper.ui.swtbot.utils.ShellBotProvider;

public abstract class AbstractSwtBotTest {

    protected static final String PROJECT_EXPLORER = "Project Explorer";

    protected static final SWTWorkbenchBot BOT = new SWTWorkbenchBot();

    protected static final int SHORT_TIMEOUT = 200;
    protected static final int ACTION_TIMEOUT = 2_000;

    protected static String mainShellName;

    static {
        org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences.TIMEOUT = 15000;
        IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();
        mainPrefs.setDefault(DB_UPDATE_PREF.DELETE_SCRIPT_AFTER_CLOSE, MessageDialogWithToggle.ALWAYS);

        try {
            BOT.shell(Messages.UsageReport_DialogTitle).close();
        } catch (Exception e) {
            // ignore
        }

        try {
            BOT.viewByTitle("Welcome").close();
        } catch (Exception e) {
            // ignore
        }

        mainShellName = BOT.activeShell().getText();
    }

    @AfterEach
    protected void closeAllEditors() {
        for (var editor : BOT.editors()) {
            editor.close();
        }
    }

    protected void createProject(String projectName, DatabaseType dbType)
            throws AWTException, IOException, URISyntaxException {
        createProject(projectName, dbType, null);
    }

    protected void createProject(String projectName, DatabaseType dbType, String initPath)
            throws AWTException, IOException, URISyntaxException {
        BOT.menu("File").menu("New").menu(Messages.NavigatorRootLabelProvider_open_editor).click();
        BOT.shell(Messages.newProjWizard_new_pg_db_project).activate();
        BOT.textWithLabel(Messages.PgImportWizardImportPage_name).setText(projectName);
        BOT.button("Next >").click();
        BOT.comboBoxWithLabel(Messages.NewProjWizard_select_project_type).setSelection(dbType.getDbTypeName());
        if (null == initPath) {
            BOT.checkBox(Messages.NewProjWizard_initializing_check).deselect();
        } else {
            SWTBotShell shell = BOT.activeShell();
            SWTBotLink link = shell.bot().link();
            link.click().contextMenu(Messages.DbStorePicker_load_from_file).click();
            insertPath(initPath);
            waitForLinkEquals(initPath, new ShellBotProvider(shell));
        }
        BOT.button("Finish").click();
        waitProjectCreation();
    }

    protected void waitProjectCreation() {
        BOT.sleep(ACTION_TIMEOUT);
    }

    protected void closeShell(String name, String button) {
        BOT.sleep(SHORT_TIMEOUT);
        if (button != null) {
            BOT.shell(name).bot().button(button).click();
        } else {
            BOT.shell(name).close();
        }
    }

    protected void insertPath(String fileName) throws AWTException, IOException, URISyntaxException {
        insertPath(fileName, false);
    }

    protected void insertPath(String fileName, boolean needTab) throws AWTException, IOException, URISyntaxException {
        StringSelection stringSelection = new StringSelection(getPath(fileName));
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot robot = new Robot();
        robot.setAutoDelay(100);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(SHORT_TIMEOUT);

        if (needTab) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.delay(200);
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    protected String getPath(String fileName) throws IOException, URISyntaxException {
        URL osgiUrl = getClass().getResource(fileName);
        assertNotNull(osgiUrl, "filename: " + fileName);
        URL fileUrl = FileLocator.toFileURL(osgiUrl);
        String path = Path.of(fileUrl.toURI()).toAbsolutePath().toString();
        assertContains(fileName, path);
        return path;
    }

    protected void selectDump(IBotProvider provider, String dumpName)
            throws AWTException, IOException, URISyntaxException {
        selectDump(provider, dumpName, 0);
    }

    protected void selectDump(IBotProvider provider, String dumpName, int linkIndex)
            throws AWTException, IOException, URISyntaxException {
        SWTBotLink link = provider.bot().link(linkIndex);
        link.click().contextMenu(Messages.DbStorePicker_load_from_file).click();
        insertPath(dumpName);
        waitForLinkEquals(dumpName, provider, linkIndex);
        link = provider.bot().link(linkIndex);
        assertEquals("<a>%s</a>".formatted(dumpName), link.getText());
    }

    protected void waitForLinkEquals(String name, IBotProvider provider) {
        waitForLinkEquals(name, provider, 0);
    }

    protected void waitForLinkEquals(String name, IBotProvider provider, int linkIndex) {
        BOT.waitUntil(new DefaultCondition() {
            @Override
            public boolean test() throws Exception {
                return provider.bot().link(linkIndex).getText().contains("<a>%s</a>".formatted(name));
            }

            @Override
            public String getFailureMessage() {
                return "The link by index " + linkIndex + " has not been updated. Current text: "
                        + provider.bot().link(linkIndex).getText()
                        + "; expected: <a>%s</a>".formatted(name);
            }
        }, ACTION_TIMEOUT);
    }

    protected void waitAction() {
        try {
            Thread.sleep(ACTION_TIMEOUT);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    protected void checkMigrationScript(String dumpName) {
        SWTBotEditor activeEditor = getEditor(dumpName);
        String actualMirationScript = activeEditor.toTextEditor().getText();
        activeEditor.close();
        assertNotNull(actualMirationScript);
    }

    protected SWTBotTree getProjectExplorer() {
        return BOT.viewByTitle(PROJECT_EXPLORER).bot().tree();
    }

    protected String createName(DatabaseType dbType, String testName) {
        return dbType.name().toLowerCase(Locale.ROOT) + testName;
    }

    protected int getActualNodesByProjectName(String projectName) {
        return getProjectExplorer().expandNode(projectName).getNodes().size();
    }

    protected SWTBotEditor getEditor(String partName) {
        BOT.sleep(SHORT_TIMEOUT);
        return BOT.editors().stream().filter(e -> e.getTitle().contains(partName)).findAny()
                .orElseThrow(() -> new IllegalStateException("didn't find editor " + partName));
    }
}
