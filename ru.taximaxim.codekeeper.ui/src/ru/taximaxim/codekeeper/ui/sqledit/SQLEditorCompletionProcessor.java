package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Image;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.sql.Keyword;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class SQLEditorCompletionProcessor implements IContentAssistProcessor {

    private final SQLEditor editor;

    public SQLEditorCompletionProcessor(SQLEditor editor) {
        this.editor = editor;
    }

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
        List<String> keywords = Keyword.getKeywords();

        Set<ICompletionProposal> result = new LinkedHashSet<>();
        Set<ICompletionProposal> partResult = new LinkedHashSet<>();

        PgDbParser parser = editor.getParser();
        List<PgObjLocation> loc = parser.getAllObjDefinitions();
        Collections.sort(loc, (o1, o2) -> o1.getFilePath().compareTo(o2.getFilePath()));

        for (PgObjLocation obj : loc) {
            if (obj.getObjType() == DbObjType.SEQUENCE || obj.getObjType() == DbObjType.INDEX) {
                continue;
            }

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

        // SQL Templates + Keywords
        if (text.isEmpty()) {
            for (String keyword : keywords) {
                result.add(new CompletionProposal(keyword.toUpperCase(), offset, 0, keyword.length()));
            }


            result.addAll(new SQLEditorTemplateAssistProcessor()
                    .getAllTemplates(viewer, offset));
        } else {
            for (String keyword : keywords) {
                if (keyword.matches("(?i)" + Pattern.quote(text) + ".*")) {
                    result.add(new CompletionProposal(keyword.toUpperCase() + ' ',
                            offset - text.length(), text.length(), keyword.length() + 1));
                } else if (keyword.matches("(?i).*" + Pattern.quote(text) + ".*")) {
                    partResult.add(new CompletionProposal(keyword.toUpperCase() + ' ',
                            offset - text.length(), text.length(), keyword.length() + 1));
                }
            }

            result.addAll(partResult);

            ICompletionProposal[] templates = new SQLEditorTemplateAssistProcessor()
                    .computeCompletionProposals(viewer, offset);
            if (templates != null) {
                result.addAll(Arrays.asList(templates));
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
