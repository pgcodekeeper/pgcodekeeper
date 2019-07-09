package ru.taximaxim.codekeeper.ui.sqledit;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionListenerExtension;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension2;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Image;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.sql.Keyword;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.copiedclasses.CompletionProposal;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class SQLEditorCompletionProcessor implements IContentAssistProcessor {

    protected final SQLEditor editor;
    private final ContentAssistant assistant;
    private final List<String> keywords;

    private final String tmplMsg;
    private final String keyMsg;

    private int repetition= -1;

    public SQLEditorCompletionProcessor(ContentAssistant assistant, SQLEditor editor,
            String hotKey) {
        this.editor = editor;
        this.assistant = assistant;

        keywords = Keyword.KEYWORDS.keySet().stream()
                .sorted()
                .map(s -> s.toUpperCase(Locale.ROOT))
                .collect(Collectors.toList());

        tmplMsg = MessageFormat.format(Messages.SQLEditorCompletionProcessor_show_templates, hotKey);
        keyMsg = MessageFormat.format(Messages.SQLEditorCompletionProcessor_show_keywords, hotKey);

        assistant.addCompletionListener(new CompletionListener());
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
        String typedText = part.substring(nonid + 1, offset).toUpperCase(Locale.ROOT);

        ICompletionProposal[] res;
        if (repetition % 2 == 0) {
            res = getKeys(offset, typedText);
            assistant.setStatusMessage(tmplMsg);
        } else {
            res = getTmpls(viewer, offset, typedText);
            assistant.setStatusMessage(keyMsg);
        }

        repetition++;

        return res;
    };

    private ICompletionProposal[] getTmpls(ITextViewer viewer, int offset, String text) {
        if (text.isEmpty()) {
            return new SQLEditorTemplateAssistProcessor().getAllTemplates(viewer, offset)
                    .toArray(new ICompletionProposal[0]);
        } else {
            ICompletionProposal[] templates = new SQLEditorTemplateAssistProcessor()
                    .computeCompletionProposals(viewer, offset);
            return templates != null ? templates : new ICompletionProposal[0];
        }
    }

    private ICompletionProposal[] getKeys(int offset, String text) {
        List<ICompletionProposal> result = new ArrayList<>();
        List<ICompletionProposal> partResult = new ArrayList<>();

        PgDbParser parser = editor.getParser();
        Stream<PgObjLocation> loc = parser.getAllObjDefinitions();
        loc
        .filter(o -> text.isEmpty() || o.getObjName().toUpperCase(Locale.ROOT).contains(text))
        .filter(o -> o.type != DbObjType.SEQUENCE && o.type != DbObjType.INDEX)
        .sorted((o1, o2) -> o1.getFilePath().compareTo(o2.getFilePath()))
        .forEach(obj -> {
            Image img = Activator.getDbObjImage(obj.type);
            String displayText = obj.getObjName();
            if (!obj.getComment().isEmpty()) {
                displayText += " - " + obj.getComment(); //$NON-NLS-1$
            }
            IContextInformation info = new ContextInformation(
                    obj.getObjName(), obj.getComment());
            if (!text.isEmpty()) {
                result.add(new SqlEditorKeywordProposal(obj.getObjName(), offset - text.length(),
                        text.length(), obj.getObjLength(), img, displayText, info,
                        obj.getObjName()));
            } else {
                result.add(new SqlEditorKeywordProposal(obj.getObjName(), offset, 0,
                        obj.getObjLength(), img, displayText, info, obj.getObjName()));
            }
        });

        // Keywords
        if (text.isEmpty()) {
            keywords.forEach(k -> result.add(new SqlEditorKeywordProposal(k, offset, 0, k.length())));
        } else {
            for (String keyword : keywords) {
                int location = keyword.indexOf(text);
                if (location != -1) {
                    CompletionProposal proposal = new SqlEditorKeywordProposal(keyword,
                            offset - text.length(), text.length(), keyword.length());
                    if (location  == 0) {
                        result.add(proposal);
                    } else {
                        partResult.add(proposal);
                    }
                }
            }

            result.addAll(partResult);
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

    /**
     * Listener for cyclic work of the content assistant ("Ctrl + Space").
     */
    private final class CompletionListener implements ICompletionListener,
    ICompletionListenerExtension {

        @Override
        public void assistSessionStarted(ContentAssistEvent event) {
            repetition = 0;
        }

        @Override
        public void assistSessionEnded(ContentAssistEvent event) {
            repetition = -1;
        }

        @Override
        public void selectionChanged(ICompletionProposal proposal,
                boolean smartToggle) {
            // no impl
        }

        @Override
        public void assistSessionRestarted(ContentAssistEvent event) {
            repetition = 0;
        }
    }

    private static final class SqlEditorKeywordProposal extends CompletionProposal
    implements ICompletionProposalExtension2 {

        public SqlEditorKeywordProposal(String replacementString, int replacementOffset,
                int replacementLength, int cursorPosition) {
            super(replacementString, replacementOffset, replacementLength, cursorPosition);
        }

        public SqlEditorKeywordProposal(String replacementString, int replacementOffset,
                int replacementLength, int cursorPosition, Image image, String displayString,
                IContextInformation contextInformation, String additionalProposalInfo) {
            super(replacementString, replacementOffset, replacementLength, cursorPosition,
                    image, displayString, contextInformation, additionalProposalInfo);
        }

        // This override is necessary for correct filtering the proposed keywords
        // while typing text (here used 'contains' method instead of 'startsWith').
        // Also this override is necessary to prevent calling
        // 'computeCompletionProposals'-method on each keyboard button pressing.
        @Override
        public boolean validate(IDocument document, int offset, DocumentEvent event) {
            try {
                int replaceOffset = getReplacementOffset();
                if (offset >= replaceOffset) {
                    String typedText = document.get(replaceOffset, offset - replaceOffset);
                    return getReplacementString().toLowerCase().contains(typedText.toLowerCase());
                }
            } catch (BadLocationException e) {
                // concurrent modification - ignore
            }
            return false;
        }

        @Override
        public void apply(ITextViewer viewer, char trigger, int stateMask, int offset) {
            try {
                viewer.getDocument().replace(getReplacementOffset(),
                        offset - getReplacementOffset(), getReplacementString());
            } catch (BadLocationException x) {
                // ignore
            }
        }

        @Override
        public void selected(ITextViewer viewer, boolean smartToggle) {
            // no impl
        }

        @Override
        public void unselected(ITextViewer viewer) {
            // no impl
        }

        /**
         * {@inheritDoc}
         *
         * @deprecated This method is no longer called by the framework and clients should overwrite
         *             {@link #apply(ITextViewer, char, int, int)} instead
         */
        @Deprecated
        @Override
        public final void apply(IDocument document) {
            // not called anymore
        }
    }
}
