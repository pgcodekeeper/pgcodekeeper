package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;

public class SQLContentAssistant extends ContentAssistant {

    private Map<String, Set<IContentAssistProcessor>> allProcs;
    private SQLEditor editor;

    private final String mesTemplates = "Press 'Ctrl+Space' to show SQL TEMPLATES"; //$NON-NLS-1$
    private final String mesKeywords = "Press 'Ctrl+Space' to show KEYWORDS"; //$NON-NLS-1$

    private Switcher switcherPosition = Switcher.KEYWORDS;

    private enum Switcher {
        KEYWORDS,
        TEMPLATES
    }

    public SQLContentAssistant() {
        setStatusMessage(mesTemplates);
    }

    @Override
    public void setContentAssistProcessor(IContentAssistProcessor processor, String contentType) {
        Assert.isNotNull(contentType);

        if (allProcs == null) {
            allProcs= new HashMap<>();
        }

        if (processor == null) {
            allProcs.remove(contentType);
        } else {
            editor = ((SQLEditorCompletionProcessorAbstract) processor).getEditor();
            allProcs.put(contentType, Collections.singleton(processor));
        }
    }

    @Override
    public void addContentAssistProcessor(IContentAssistProcessor processor, String contentType) {
        Assert.isNotNull(contentType);

        if (allProcs == null) {
            allProcs= new HashMap<>();
        }

        if (processor == null) {
            allProcs.remove(contentType);
        } else {
            if (!allProcs.containsKey(contentType)) {
                allProcs.put(contentType, new LinkedHashSet<>());
            }
            allProcs.get(contentType).add(processor);

            if (editor == null) {
                editor = ((SQLEditorCompletionProcessorAbstract) processor).getEditor();
            }
        }
    }

    @Override
    protected AutoAssistListener createAutoAssistListener() {
        return new SQLAutoAssistListener();
    }

    private class SQLAutoAssistListener extends AutoAssistListener {
        @Override
        public void verifyKey(VerifyEvent event) {
            if (event.keyCode == SWT.MOD1) {
                if (switcherPosition == Switcher.KEYWORDS) {
                    switchToProc(new SQLEditorCompletionProcessorKeys(editor),
                            Switcher.TEMPLATES, mesTemplates);
                } else {
                    switchToProc(new SQLEditorCompletionProcessorTmpls(editor),
                            Switcher.KEYWORDS, mesKeywords);
                }
            }
            super.verifyKey(event);
        }

        private void switchToProc(IContentAssistProcessor proc, Switcher newSwitcherPosition,
                String messageForNewSwitchPos) {
            SQLContentAssistant.super.setContentAssistProcessor(null,
                    SQLEditorCommonDocumentProvider.SQL_CODE);
            SQLContentAssistant.super.setContentAssistProcessor(proc,
                    SQLEditorCommonDocumentProvider.SQL_CODE);
            switcherPosition = newSwitcherPosition;
            setStatusMessage(messageForNewSwitchPos);
        }
    }
}
