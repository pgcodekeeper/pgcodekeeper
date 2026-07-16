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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.junit.jupiter.api.Test;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class PreferencePageTest extends AbstractSwtBotTest {

    private static final String PREFERENCES = "Preferences";
    private static final String PG_CODEKEEPER_PAGE = "pgCodeKeeper";
    private static final String DB_STORE_PAGE = "DB Store";
    private static final String APPLY_AND_CLOSE = "Apply and Close";

    private static final int NAME_COLUMN = 1;

    @Test
    void dbStoreTest() {
        var generatedName = "tester@127.0.0.1:5432/testdb";
        var editedName = "edited_connection";

        SWTBotShell prefShell = openDbStorePage();
        prefShell.bot().buttonWithTooltip(Messages.add).click();

        SWTBot dialogBot = BOT.shell(Messages.DbStorePrefPage_action_add_new).activate().bot();
        dialogBot.textWithLabel(Messages.dbPicker_port).setText("5432");
        dialogBot.textWithLabel(Messages.dB_name).setText("testdb");
        dialogBot.textWithLabel(Messages.dB_user).setText("tester");
        assertFalse(dialogBot.textWithLabel(Messages.entry_name).isEnabled());
        assertEquals(generatedName, dialogBot.textWithLabel(Messages.entry_name).getText());
        dialogBot.button("OK").click();

        assertTrue(containsConnection(prefShell.bot().table(), generatedName));
        prefShell.bot().button(APPLY_AND_CLOSE).click();

        prefShell = openDbStorePage();
        SWTBotTable table = prefShell.bot().table();
        assertTrue(containsConnection(table, generatedName));
        table.select(findRow(table, generatedName));
        prefShell.bot().buttonWithTooltip(Messages.edit).click();

        dialogBot = BOT.shell(Messages.DbStorePrefPage_action_edit + ": " + generatedName).activate().bot();
        assertEquals("127.0.0.1", dialogBot.textWithLabel(Messages.dB_host).getText());
        assertEquals("5432", dialogBot.textWithLabel(Messages.dbPicker_port).getText());
        assertEquals("testdb", dialogBot.textWithLabel(Messages.dB_name).getText());
        assertEquals("tester", dialogBot.textWithLabel(Messages.dB_user).getText());

        dialogBot.checkBox(Messages.DbStoreEditorDialog_auto_generation).deselect();
        var txtName = dialogBot.textWithLabel(Messages.entry_name);
        assertTrue(txtName.isEnabled());
        txtName.setText(editedName);
        dialogBot.button("OK").click();

        table = prefShell.bot().table();
        assertFalse(containsConnection(table, generatedName));
        assertTrue(containsConnection(table, editedName));
        prefShell.bot().button(APPLY_AND_CLOSE).click();

        prefShell = openDbStorePage();
        table = prefShell.bot().table();
        assertTrue(containsConnection(table, editedName));
        table.select(findRow(table, editedName));
        prefShell.bot().buttonWithTooltip(Messages.delete).click();
        assertFalse(containsConnection(prefShell.bot().table(), editedName));
        prefShell.bot().button(APPLY_AND_CLOSE).click();

        prefShell = openDbStorePage();
        assertFalse(containsConnection(prefShell.bot().table(), editedName));
        prefShell.bot().button("Cancel").click();
    }

    private SWTBotShell openDbStorePage() {
        activateMainShell();
        BOT.menu("Window").menu(PREFERENCES + "...").click();
        SWTBotShell prefShell = BOT.shell(PREFERENCES).activate();
        prefShell.bot().tree().expandNode(PG_CODEKEEPER_PAGE).getNode(DB_STORE_PAGE).select();
        return prefShell;
    }

    private boolean containsConnection(SWTBotTable table, String name) {
        return findRow(table, name) >= 0;
    }

    private int findRow(SWTBotTable table, String name) {
        for (int i = 0; i < table.rowCount(); i++) {
            if (name.equals(table.cell(i, NAME_COLUMN))) {
                return i;
            }
        }
        return -1;
    }
}
