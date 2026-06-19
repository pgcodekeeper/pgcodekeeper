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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import ru.taximaxim.codekeeper.ui.DatabaseType;

public class PrejectTest extends AbstractSwtBotTest {

    @ParameterizedTest
    @EnumSource(DatabaseType.class)
    void createEmptyPgcodekeeperProjectTest(DatabaseType dbType) {

        var projectName = dbType.name().toLowerCase() + "_test_project";

        createPgCodekeeperProject(projectName, dbType);
        SWTBotTreeItem treeElement = bot.viewByTitle("Project Explorer").bot().tree().getTreeItem(projectName);
        assertNotNull(treeElement);

        deleteProject(projectName, true);
        assertThrows(WidgetNotFoundException.class, () -> bot.viewByTitle("Project Explorer").bot().tree());
    }
}
