package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public abstract class SQLEditorCompletionProcessorAbstract implements IContentAssistProcessor {

    protected final SQLEditor editor;

    public SQLEditorCompletionProcessorAbstract(SQLEditor editor) {
        this.editor = editor;
    }

    @Override
    public abstract ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
            int offset);

    @Override
    public IContextInformation[] computeContextInformation(ITextViewer viewer,
            int offset) {
        return null;
    }

    @Override
    public char[] getCompletionProposalAutoActivationCharacters() {
        return new char[] { '.', '(' };
    }

    @Override
    public char[] getContextInformationAutoActivationCharacters() {
        return new char[] { '#' };
    }

    @Override
    public String getErrorMessage() {
        return null;
    }

    @Override
    public IContextInformationValidator getContextInformationValidator() {
        return null;
    }

    public SQLEditor getEditor() {
        return editor;
    }
}
