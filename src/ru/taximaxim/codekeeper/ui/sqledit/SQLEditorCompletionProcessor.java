package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.jface.text.templates.DocumentTemplateContext;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateProposal;

public class SQLEditorCompletionProcessor implements IContentAssistProcessor {

    public SQLEditorCompletionProcessor() {
        // TODO Auto-generated constructor stub
    }
    
    private static final String CONTEXT_ID= "preparation"; //$NON-NLS-1$
    private final TemplateContextType fContextType= new TemplateContextType(CONTEXT_ID, "Preparation Templates"); //$NON-NLS-1$
    private final Template fTemplate= new Template("Stir", "Stir gently", CONTEXT_ID, "Stir ${ingredient} gently", false);   //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
    
    @Override
    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
        IDocument document= viewer.getDocument();
        Region region= new Region(offset, 0);
        TemplateContext templateContext= new DocumentTemplateContext(fContextType, document, offset, 0);
        TemplateProposal templateProposal= new TemplateProposal(fTemplate, templateContext, region, null);
    
        ICompletionProposal[] result= { templateProposal };
        return result;
    }

    @Override
    public IContextInformation[] computeContextInformation(ITextViewer viewer,
            int offset) {
        // TODO Auto-generated method stub
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
        return "Error Message";
    }

    @Override
    public IContextInformationValidator getContextInformationValidator() {
        // TODO Auto-generated method stub
        return null;
    }

}
