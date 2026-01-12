/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.sqledit;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

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
import org.pgcodekeeper.core.PgDiffUtils;
import org.pgcodekeeper.core.model.difftree.DbObjType;
import org.pgcodekeeper.core.schema.meta.MetaStatement;
import org.pgcodekeeper.core.sql.Keyword;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.copiedclasses.CompletionProposal;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class SQLEditorCompletionProcessor implements IContentAssistProcessor {

    private static final char DELIMITER = '.';

    private static final Set<DbObjType> VALID_TYPES = Set.of(DbObjType.SCHEMA, DbObjType.TABLE, DbObjType.VIEW,
            DbObjType.FUNCTION, DbObjType.PROCEDURE, DbObjType.AGGREGATE, DbObjType.DICTIONARY, DbObjType.TYPE);

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
                .toList();

        tmplMsg = Messages.SQLEditorCompletionProcessor_show_templates.formatted(hotKey);
        keyMsg = Messages.SQLEditorCompletionProcessor_show_keywords.formatted(hotKey);

        assistant.addCompletionListener(new CompletionListener());
    }

    @Override
    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
        String part;
        try {
            part = viewer.getDocument().get(0, offset);
        } catch (BadLocationException ex) {
            Log.log(Log.LOG_ERROR, "Document doesn't contain such offset", ex); //$NON-NLS-1$
            return null;
        }

        List<String> splittedText = getCursorText(part, offset);

        ICompletionProposal[] res;
        if (repetition % 2 == 0) {
            res = getKeys(offset, splittedText);
            assistant.setStatusMessage(tmplMsg);
        } else {
            res = getTmpls(viewer, offset, splittedText.get(0));
            assistant.setStatusMessage(keyMsg);
        }

        repetition++;

        return res;
    }

    private List<String> getCursorText(String part, int offset) {
        List<String> result = new ArrayList<>();
        int cursor = offset - 1;
        int last = offset;
        while (cursor > 0) {
            char currentChar = part.charAt(cursor);
            if (DELIMITER == currentChar) {
                result.add(part.substring(cursor + 1, last).toUpperCase(Locale.ROOT));
                last = cursor;
            } else if (!PgDiffUtils.isValidIdChar(currentChar)) {
                break;
            }
            cursor--;
        }

        result.add(part.substring(0 != cursor ? cursor + 1 : cursor, last).toUpperCase(Locale.ROOT));
        return result;
    }

    private ICompletionProposal[] getTmpls(ITextViewer viewer, int offset, String text) {
        if (text.isEmpty()) {
            return new SQLEditorTemplateAssistProcessor().getAllTemplates(viewer, offset)
                    .toArray(new ICompletionProposal[0]);
        }

        var templates = new SQLEditorTemplateAssistProcessor().computeCompletionProposals(viewer, offset);
        return templates != null ? templates : new ICompletionProposal[0];
    }

    private ICompletionProposal[] getKeys(int offset, List<String> splittedText) {
        List<ICompletionProposal> result = new ArrayList<>();
        int size = splittedText.size();
        String secondName = size > 1 ? splittedText.get(1) : null;
        String lastName = splittedText.get(0);

        if (size < 3) {
            editor.getParser().getAllObjDefinitions()
            .filter(d -> checkDefinition(d, lastName, secondName))
            .sorted(ProposalComparator.INSTANCE)
            .map(obj -> getProposal(offset, lastName, obj))
            .forEach(result::add);
        } else {
            // TODO add logic to autocompletion the columns
        }

        // Keywords
        if (1 == size) {
            if (lastName.isEmpty()) {
                keywords.forEach(k -> result.add(new SqlEditorKeywordProposal(k, offset, 0, k.length())));
            } else {
                List<ICompletionProposal> partResult = new ArrayList<>();
                for (String keyword : keywords) {
                    int location = keyword.indexOf(lastName);
                    if (location != -1) {
                        CompletionProposal proposal = new SqlEditorKeywordProposal(keyword,
                                offset - lastName.length(), lastName.length(), keyword.length());
                        if (location == 0) {
                            result.add(proposal);
                        } else {
                            partResult.add(proposal);
                        }
                    }
                }

                result.addAll(partResult);
            }
        }

        return result.toArray(new ICompletionProposal[result.size()]);
    }

    private SqlEditorKeywordProposal getProposal(int offset, String text, MetaStatement obj) {
        Image img = Activator.getDbObjImage(obj.getStatementType());
        String displayText = obj.getName();
        if (!obj.getComment().isEmpty()) {
            displayText += " - " + obj.getComment(); //$NON-NLS-1$
        }
        IContextInformation info = new ContextInformation(obj.getName(), obj.getComment());

        int replacementOffset;
        int replacementLength;
        if (!text.isEmpty()) {
            replacementOffset = offset - text.length();
            replacementLength = text.length();
        } else {
            replacementOffset = offset;
            replacementLength = 0;
        }

        return new SqlEditorKeywordProposal(obj.getName(), replacementOffset, replacementLength,
                obj.getObjLength(), img, displayText, info, obj.getName());
    }

    private boolean checkDefinition(MetaStatement definition, String text, String parentName) {
        if (definition.getFilePath() == null || !VALID_TYPES.contains(definition.getStatementType())) {
            return false;
        }

        var difName = definition.getName();

        if (!text.isEmpty() && !difName.toUpperCase(Locale.ROOT).contains(text)) {
            return false;
        }

        if (parentName != null && (difName.equalsIgnoreCase(parentName)
                || !definition.getGenericColumn().schema.equalsIgnoreCase(parentName))) {
            return false;
        }

        return true;
    }

    @Override
    public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
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

    private static final class ProposalComparator implements Comparator<MetaStatement> {

        static final ProposalComparator INSTANCE = new ProposalComparator();

        @Override
        public int compare(MetaStatement o1, MetaStatement o2) {
            int result = Integer.compare(getRank(o1), getRank(o2));
            if (result != 0) {
                return result;
            }

            return o1.getFilePath().compareTo(o2.getFilePath());
        }

        private int getRank(MetaStatement el) {
            return switch (el.getStatementType()) {
            case SCHEMA -> 0;
            case TABLE -> 1;
            case VIEW -> 2;
            default -> 3;
            };
        }

        private ProposalComparator() {
        }
    }
}
