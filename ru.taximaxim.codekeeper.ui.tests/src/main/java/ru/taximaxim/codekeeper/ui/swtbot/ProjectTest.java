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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectTest extends AbstractSwtBotTest {

    @ParameterizedTest
    @EnumSource(DatabaseType.class)
    void createEmptyPgcodekeeperProjectTest(DatabaseType dbType)
            throws AWTException, IOException, URISyntaxException {
        var projectName = dbType.name().toLowerCase() + "_empty_test_project";

        createProject(projectName, dbType);
        assertNotNull(getProjectExplorer().getTreeItem(projectName));
    }

    @ParameterizedTest
    @EnumSource(DatabaseType.class)
    void createPgcodekeeperProjectWithDumpTest(DatabaseType dbType)
            throws AWTException, IOException, URISyntaxException {
        var projectName = dbType.name().toLowerCase() + "_test_project";
        var dumpName = dbType.name().toLowerCase() + "_dump_test.sql";
        createProject(projectName, dbType, dumpName);

        SWTBotTree projectExplorer = getProjectExplorer();
        projectExplorer.expandNode(projectName);
        projectExplorer.getTreeItem(projectName).selectAll();
        assertTrue(3 < projectExplorer.selectionCount());
    }

    @ParameterizedTest
    @EnumSource(DatabaseType.class)
    void convertProjectTest(DatabaseType dbType) {
        var projectName = dbType.name().toLowerCase() + "_convert_test_project";
        BOT.menu("File").menu("New").menu("Project...").click();
        BOT.tree().getTreeItem("General").expand().getNode("Project").select();
        BOT.button("Next >").click();
        BOT.textWithLabel("Project name:").setText(projectName);
        BOT.button("Finish").click();
        waitProjectCreation();

        getProjectExplorer().getTreeItem(projectName).contextMenu().menu("Configure")
                .menu("Convert to pgCodeKeeper project").click();
        BOT.comboBox().setSelection(dbType.getDbTypeName());
        BOT.button("OK").click();
        closeShell(Messages.ConvertProject_convert_dialog_title, "Yes");
        waitProjectCreation();

        var projectTree = getProjectExplorer().getTreeItem(projectName);
        projectTree.expand();
        projectTree.selectAll();

        int countSelected = getProjectExplorer().selectionCount();
        assertEquals(2, countSelected, "DatabaseType: " + dbType.getDbTypeName());
    }

    private SWTBotTree getProjectExplorer() {
        return BOT.viewByTitle(PROJECT_EXPLORER).bot().tree();
    }
}
