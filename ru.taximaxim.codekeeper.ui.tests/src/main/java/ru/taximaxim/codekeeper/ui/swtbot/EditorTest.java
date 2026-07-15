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
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.function.IntPredicate;

import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import ru.taximaxim.codekeeper.ui.DatabaseType;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.swtbot.utils.EditorBotProvider;
import ru.taximaxim.codekeeper.ui.swtbot.utils.IBotProvider;

public class EditorTest extends AbstractSwtBotTest {

    private static final Map<DatabaseType, Integer> EXPECTED_NODES_SIZE = Map.of(
            DatabaseType.PG, 7,
            DatabaseType.MS, 10,
            DatabaseType.CH, 5
    );

    private static final IntPredicate IS_EMPTY = count -> 0 == count;
    private static final IntPredicate IS_NOT_EMPTY = count -> 0 != count;

    @Test
    void openEmptySQLEditorTest() {
        assertEquals(0, BOT.editors().size());
        BOT.toolbarButtonWithTooltip("New SQL editor").click();
        assertEquals(1, BOT.editors().size());
        BOT.activeEditor().close();
        assertEquals(0, BOT.editors().size());
    }

    @ParameterizedTest
    @EnumSource(DatabaseType.class)
    void createProjectFillAndDeleteTest(DatabaseType dbType)
            throws AWTException, IOException, URISyntaxException {

        var dumpName = createName(dbType, "_dump_test.sql");
        var emptyDumpName = "test.sql";
        var projectName = createName(dbType, "_editor_test");

        createProject(projectName, dbType);

        EditorBotProvider editor = new EditorBotProvider(BOT.editorByTitle(projectName));
        selectDump(editor, dumpName);

        BOT.toolbarDropDownButtonWithTooltip(Messages.DiffTableViewer_get_changes).click();
        waitUntilLoadDiffTree(editor, IS_NOT_EMPTY);
        assertTreeRowCount(editor, IS_NOT_EMPTY);

        selectAllAndApplyTo(Messages.DiffTableViewer_to_database);
        checkMigrationScript("migration for " + dumpName);

        selectAllAndApplyTo(Messages.DiffTableViewer_to_project);

        BOT.shell(Messages.commitPartDescr_commit_confirmation).activate();
        BOT.button("OK").click();

        waitUntilLoadDiffTree(editor, IS_EMPTY);
        assertTreeRowCount(editor, IS_EMPTY);

        selectDump(editor, emptyDumpName);

        BOT.toolbarDropDownButtonWithTooltip(Messages.DiffTableViewer_get_changes).click();
        waitUntilLoadDiffTree(editor, IS_NOT_EMPTY);
        assertTreeRowCount(editor, IS_NOT_EMPTY);

        selectAllAndApplyTo(Messages.DiffTableViewer_to_database);
        checkMigrationScript("migration for " + emptyDumpName);

        assertEquals(EXPECTED_NODES_SIZE.get(dbType), getActualNodesByProjectName(projectName));
    }

    private void selectAllAndApplyTo(String target) {
        BOT.toolbarButtonWithTooltip(Messages.select_all).click();

        String currentBtnType;
        if (target.equals(Messages.DiffTableViewer_to_project)) {
            currentBtnType = Messages.DiffTableViewer_to_database;
        } else {
            currentBtnType = Messages.DiffTableViewer_to_project;
        }

        try {
            // search for an inverted value
            BOT.toolbarDropDownButtonWithTooltip(Messages.DiffTableViewer_apply_to  + ' ' + currentBtnType).menuItem(target).click();
        } catch (Exception ex) {
            // ignore error
        }
        var buttonToApply = BOT.toolbarDropDownButtonWithTooltip(Messages.DiffTableViewer_apply_to  + ' ' + target);
        assertEquals(Messages.DiffTableViewer_apply_to + ' ' + target, buttonToApply.getToolTipText());
        buttonToApply.click();
    }

    private void waitUntilLoadDiffTree(IBotProvider provider, IntPredicate condition) {
        BOT.waitUntil(new DefaultCondition() {
            @Override
            public boolean test() throws Exception {
                return condition.test(provider.bot().tree().rowCount());
            }

            @Override
            public String getFailureMessage() {
                return "The tree has not been populated with the required number of objects.";
            }
        }, ACTION_TIMEOUT);
    }

    private void assertTreeRowCount(IBotProvider provider, IntPredicate condition) {
        int count = provider.bot().tree().rowCount();
        assertTrue(condition.test(count));
    }
}
