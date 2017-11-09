package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ResourceBundle;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.editors.text.TextEditorActionContributor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.RetargetTextEditorAction;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class SQLEditorActionContributor extends TextEditorActionContributor {

    private final RetargetTextEditorAction fContentAssist;

    public SQLEditorActionContributor() {
        fContentAssist= new RetargetTextEditorAction(
                ResourceBundle.getBundle(Messages.getBundleName()), "contentAssist."); //$NON-NLS-1$
        fContentAssist.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
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
        if (part instanceof ITextEditor) {
            fContentAssist.setAction(getAction((ITextEditor) part, SQLEditor.CONTENT_ASSIST));
        }
    }
}
