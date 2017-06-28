package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class SQLEditorCompletionProcessor implements IContentAssistProcessor {

    @Override
    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
            int offset) {
        String part;
        try {
            part = viewer.getDocument().get(0, offset);
        } catch (BadLocationException ex) {
            Log.log(Log.LOG_ERROR, "Document doesn't contain such offset", ex); //$NON-NLS-1$
            return null;
        }
        int nonid = offset - 1;
        while (nonid > 0 && Character.isJavaIdentifierPart(part.charAt(nonid))) {
            --nonid;
        }
        String text = part.substring(nonid + 1, offset);

        List<ICompletionProposal> result = new ArrayList<>();
        // SQL TEmplates
        if (text.isEmpty()) {
            result.addAll(new SQLEditorTemplateAssistProcessor()
                    .getAllTemplates(viewer, offset));
        } else {
            ICompletionProposal[] templates = new SQLEditorTemplateAssistProcessor()
                    .computeCompletionProposals(viewer, offset);
            if (templates != null) {
                result.addAll(Arrays.asList(templates));
            }
        }
        IEditorPart page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor();
        List<PgObjLocation> loc = new ArrayList<>();
        if (page instanceof SQLEditor) {
            PgDbParser parser = ((SQLEditor)page).getParser();
            loc.addAll(parser.getAllObjDefinitions());
        }
        for (PgObjLocation obj : loc) {
            Image img = Activator.getDbObjImage(obj.getObjType());
            String displayText = obj.getObjName();
            if (!obj.getComment().isEmpty()) {
                displayText += " - " + obj.getComment(); //$NON-NLS-1$
            }
            if (!text.isEmpty()) {
                if (obj.getObjName().startsWith(text)) {
                    IContextInformation info = new ContextInformation(
                            obj.getObjName(), obj.getComment());
                    result.add(new CompletionProposal(obj.getObjName(), offset
                            - text.length(), text.length(),
                            obj.getObjLength(), img, displayText, info,
                            obj.getObjName()));
                }
            } else {
                IContextInformation info = new ContextInformation(obj.getObjName(),
                        obj.getComment());
                result.add(new CompletionProposal(obj.getObjName(), offset, 0,
                        obj.getObjLength(), img, displayText, info, obj.getObjName()));
            }
        }

        return result.toArray(new ICompletionProposal[result.size()]);
    }

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
}
