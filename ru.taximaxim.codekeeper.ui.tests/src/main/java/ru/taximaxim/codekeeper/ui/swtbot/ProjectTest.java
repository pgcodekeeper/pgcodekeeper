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

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import ru.taximaxim.codekeeper.ui.DatabaseType;

public class ProjectTest extends AbstractSwtBotTest {

    @ParameterizedTest
    @EnumSource(DatabaseType.class)
    void createEmptyPgcodekeeperProjectTest(DatabaseType dbType) throws AWTException, IOException, URISyntaxException {
        var projectName = dbType.name().toLowerCase() + "_empty_test_project";

        createProject(projectName, dbType);
        SWTBotTreeItem treeElement = BOT.viewByTitle(PROJECT_EXPLORER).bot().tree().getTreeItem(projectName);
        assertNotNull(treeElement);
    }

    @ParameterizedTest
    @EnumSource(DatabaseType.class)
    void createPgcodekeeperProjectWithDumpTest(DatabaseType dbType)
            throws AWTException, IOException, URISyntaxException {
        var projectName = dbType.name().toLowerCase() + "_test_project";
        var dumpName = dbType.name().toLowerCase() + "_dump_test.sql";
        createProject(projectName, dbType, dumpName);

        SWTBotTree projectExplorer = BOT.viewByTitle(PROJECT_EXPLORER).bot().tree();
        projectExplorer.expandNode(projectName);
        projectExplorer.selectAll();
        assertTrue(3 < projectExplorer.selectionCount());
    }
}
