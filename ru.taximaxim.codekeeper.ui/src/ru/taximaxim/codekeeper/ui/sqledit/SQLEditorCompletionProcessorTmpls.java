package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.ui.Log;

public class SQLEditorCompletionProcessorTmpls extends SQLEditorCompletionProcessorAbstract {

    public SQLEditorCompletionProcessorTmpls(SQLEditor editor) {
        super(editor);
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
        while (nonid > 0 && PgDiffUtils.isValidIdChar(part.charAt(nonid))) {
            --nonid;
        }
        String text = part.substring(nonid + 1, offset);

        List<ICompletionProposal> result = new LinkedList<>();

        // SQL Templates
        if (text.isEmpty()) {
            result.addAll(new SQLEditorTemplateAssistProcessor().getAllTemplates(viewer, offset));
        } else {
            ICompletionProposal[] templates = new SQLEditorTemplateAssistProcessor()
                    .computeCompletionProposals(viewer, offset);
            if (templates != null) {
                result.addAll(Arrays.asList(templates));
            }
        }

        return result.toArray(new ICompletionProposal[result.size()]);
    }
}
