/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ResourceBundle;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.editors.text.TextEditorActionContributor;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.RetargetTextEditorAction;

import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.menuitems.ChangeLanguageItem;

public class SQLEditorActionContributor extends TextEditorActionContributor {

    private final RetargetTextEditorAction fContentAssist;
    private final ChangeLanguageItem languageItem;

    public SQLEditorActionContributor() {
        fContentAssist= new RetargetTextEditorAction(
                ResourceBundle.getBundle(Messages.getBundleName()), "contentAssist."); //$NON-NLS-1$
        fContentAssist.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);

        languageItem = new ChangeLanguageItem();
    }

    @Override
    public void contributeToStatusLine(IStatusLineManager statusLineManager) {
        super.contributeToStatusLine(statusLineManager);
        statusLineManager.add(languageItem);
    }

    @Override
    public void contributeToMenu(IMenuManager menu) {
        super.contributeToMenu(menu);

        IMenuManager editMenu= menu.findMenuUsingPath(IWorkbenchActionConstants.M_EDIT);
        if (editMenu != null) {
            editMenu.appendToGroup(IWorkbenchActionConstants.MB_ADDITIONS, fContentAssist);
        }
    }

    @Override
    public void setActiveEditor(IEditorPart part) {
        super.setActiveEditor(part);
        if (part instanceof SQLEditor) {
            SQLEditor editor = (SQLEditor) part;
            fContentAssist.setAction(getAction(editor, SQLEditor.CONTENT_ASSIST));
            languageItem.setActiveEditor(editor);
        }
    }
}
