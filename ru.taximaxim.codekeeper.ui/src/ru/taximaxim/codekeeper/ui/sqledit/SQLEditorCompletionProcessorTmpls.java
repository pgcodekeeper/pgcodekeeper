package ru.taximaxim.codekeeper.ui.sqledit;

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

        // SQL Templates
        if (text.isEmpty()) {
            return new SQLEditorTemplateAssistProcessor().getAllTemplates(viewer, offset)
                    .toArray(new ICompletionProposal[0]);
        } else {
            ICompletionProposal[] templates = new SQLEditorTemplateAssistProcessor()
                    .computeCompletionProposals(viewer, offset);
            return templates != null ? templates : new ICompletionProposal[0];
        }
    }
}