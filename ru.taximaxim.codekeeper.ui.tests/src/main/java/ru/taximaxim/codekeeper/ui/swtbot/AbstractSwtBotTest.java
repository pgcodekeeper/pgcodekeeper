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

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotLink;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;

import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public abstract class AbstractSwtBotTest {

    private static final int PROJECT_CREATION_TIMEOUT = 2000;

    protected static final String PROJECT_EXPLORER = "Project Explorer";

    protected static final SWTWorkbenchBot BOT = new SWTWorkbenchBot();

    protected static final long DEFAULT_TIME_OUT = 5_000;

    protected static final boolean IS_LINUX = System.getProperty("os.name").toLowerCase().contains("nux")
            || System.getProperty("os.name").toLowerCase().contains("nix");

    static {
        org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences.TIMEOUT = 15000;

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
            waitForLinkEquals(initPath, shell);
        }
        BOT.button("Finish").click();
        waitProjectCreation();
    }

    protected void waitProjectCreation() {
        BOT.sleep(PROJECT_CREATION_TIMEOUT);
    }

    protected void closeShell(String name, String button) {
        BOT.sleep(100);
        if (button != null) {
            BOT.shell(name).bot().button(button).click();
        } else {
            BOT.shell(name).close();
        }
    }

    protected void insertPath(String fileName) throws AWTException, IOException, URISyntaxException {
        StringSelection stringSelection = new StringSelection(getPath(fileName));
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot robot = new Robot();
        robot.setAutoDelay(100);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(200);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    private String getPath(String fileName) throws IOException, URISyntaxException {
        URL osgiUrl = getClass().getResource(fileName);
        assertNotNull(osgiUrl, "filename: " + fileName);
        URL fileUrl = FileLocator.toFileURL(osgiUrl);
        String path = Path.of(fileUrl.toURI()).toAbsolutePath().toString();
        assertContains(fileName, path);
        return path;
    }

    protected void waitForLinkEquals(String name, SWTBotShell shell) {
        BOT.waitUntil(new DefaultCondition() {
            @Override
            public boolean test() throws Exception {
                return shell.bot().link().getText().contains("<a>%s</a>".formatted(name));
            }

            @Override
            public String getFailureMessage() {
                return "The link has not been updated. Current text: " + shell.bot().link().getText() + "; expected:"
                        + "<a>%s</a>".formatted(name);
            }
        }, DEFAULT_TIME_OUT);
    }

    protected void waitForLinkEquals(String name, SWTBotEditor editor) {
        BOT.waitUntil(new DefaultCondition() {
            @Override
            public boolean test() throws Exception {
                return editor.bot().link().getText().contains("<a>%s</a>".formatted(name));
            }

            @Override
            public String getFailureMessage() {
                return "The link has not been updated. Current text: " + editor.bot().link().getText() + "; expected:"
                        + "<a>%s</a>".formatted(name);
            }
        }, DEFAULT_TIME_OUT);
    }
}
