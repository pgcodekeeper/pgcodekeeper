package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class SQLEditorCompletionProcessor implements IContentAssistProcessor {

    private SqlPostgresSyntax sqlSyntax;
    private String text = "";
    public SQLEditorCompletionProcessor(SqlPostgresSyntax sqlSyntax) {
        this.sqlSyntax = sqlSyntax;
    }
    
    @Override
    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
        IDocument document= viewer.getDocument();
        text = "";
        try {
            int length = 1;
            text = document.get(offset - length, length);
            if (text.getBytes()[0] != '\n') {
                while (Character.isLetter(document.get(offset - length, length).getBytes()[0])) {
                    text = document.get(offset - length, length);
                    length++;
                }
            }
            if (length == 1) {
                text = "";
            }
        } catch (BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        List<ICompletionProposal> result= new ArrayList<ICompletionProposal>();
        for (String fgProposal : sqlSyntax.getReservedwords()) {
            if (!text.isEmpty()) {
                if (fgProposal.contains(text)) {
                    IContextInformation info = new ContextInformation(
                            fgProposal, fgProposal);
                    result.add(new CompletionProposal(fgProposal, offset, 0,
                            fgProposal.length(), null, fgProposal, info,
                            fgProposal));
                }
            } else {
                IContextInformation info = new ContextInformation(fgProposal,
                        fgProposal);
                result.add(new CompletionProposal(fgProposal, offset, 0,
                        fgProposal.length(), null, fgProposal, info, fgProposal));
   }
        }
        return result.toArray(new ICompletionProposal[result.size()]);
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
