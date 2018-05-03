package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.ui.Activator;

public class SQLEditorSourceViewerConfiguration extends TextSourceViewerConfiguration {

    private static final class WordDetector implements IWordDetector {
        @Override
        public boolean isWordPart(char c) {
            return PgDiffUtils.isValidIdChar(c);
        }

        @Override
        public boolean isWordStart(char c) {
            return PgDiffUtils.isValidIdChar(c, true, false);
        }
    }

    private final SQLEditor editor;
    private final ISharedTextColors fSharedColors;
    private final SqlPostgresSyntax sqlSyntax = new SqlPostgresSyntax();
    private final IPreferenceStore prefs;

    public SQLEditorSourceViewerConfiguration(ISharedTextColors sharedColors,
            IPreferenceStore store, SQLEditor editor) {
        super(store);
        fSharedColors= sharedColors;
        this.prefs = Activator.getDefault().getPreferenceStore();
        this.editor = editor;
    }

    @Override
    public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType) {
        return editor == null ? null : new SQLEditorTextHover(sourceViewer, editor);
    }

    @Override
    public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
        if (editor == null) {
            return null;
        }
        ContentAssistant assistant= new ContentAssistant();
        assistant.setContentAssistProcessor(new SQLEditorCompletionProcessor(editor), SQLEditorCommonDocumentProvider.SQL_CODE);
        assistant.enableAutoActivation(true);
        assistant.enableAutoInsert(true);
        assistant.setAutoActivationDelay(500);
        assistant.setProposalPopupOrientation(IContentAssistant.PROPOSAL_OVERLAY);
        assistant.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_ABOVE);
        return assistant;
    }

    @Override
    public String getConfiguredDocumentPartitioning(ISourceViewer sourceViewer) {
        return SQLEditorCommonDocumentProvider.SQL_PARTITIONING;
    }

    @Override
    public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
        return new String[] {
                SQLEditorCommonDocumentProvider.SQL_CODE,
                SQLEditorCommonDocumentProvider.SQL_SINGLE_COMMENT
        };
    }

    @Override
    public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
        PresentationReconciler reconciler= new PresentationReconciler();
        reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));

        addDamagerRepairer(reconciler, createCommentScanner(), SQLEditorCommonDocumentProvider.SQL_SINGLE_COMMENT);
        addDamagerRepairer(reconciler, createMultiCommentScanner(), SQLEditorCommonDocumentProvider.SQL_MULTI_COMMENT);
        addDamagerRepairer(reconciler, createCharacterStringLiteralCommentScanner(), SQLEditorCommonDocumentProvider.SQL_CHARACTER_STRING_LITERAL);
        addDamagerRepairer(reconciler, createRecipeScanner(), SQLEditorCommonDocumentProvider.SQL_CODE);

        return reconciler;
    }

    @Override
    protected Map<String, IAdaptable> getHyperlinkDetectorTargets(ISourceViewer sourceViewer) {
        Map<String, IAdaptable> targets = super.getHyperlinkDetectorTargets(sourceViewer);
        if (editor != null) {
            targets.put("ru.taximaxim.codekeeper.ui.SQLEditorTarget", editor); //$NON-NLS-1$
        }
        return targets;
    }

    private void addDamagerRepairer(PresentationReconciler reconciler, RuleBasedScanner commentScanner, String contentType) {
        DefaultDamagerRepairer commentDamagerRepairer= new DefaultDamagerRepairer(commentScanner);
        reconciler.setDamager(commentDamagerRepairer, contentType);
        reconciler.setRepairer(commentDamagerRepairer, contentType);
    }

    private RuleBasedScanner createRecipeScanner() {
        RuleBasedScanner recipeScanner= new RuleBasedScanner();

        IRule[] rules= {
                sqlSyntaxRules()
        };
        recipeScanner.setRules(rules);
        return recipeScanner;
    }

    private WordRule sqlSyntaxRules() {

        // Define a word rule and add SQL keywords to it.
        WordRule wordRule = new WordRule(new WordDetector(), Token.WHITESPACE, true);
        for (String reservedWord : sqlSyntax.getReservedwords()) {
            wordRule.addWord(reservedWord, new Token(
                    getTextAttribute(prefs, SQLEditorStatementTypes.RESERVED_WORDS)));
        }
        // TODO render unreserved keywords in the same way with reserved
        // keywords, should let user decide via preference
        for (String unreservedWord : sqlSyntax.getUnreservedwords()) {
            wordRule.addWord(unreservedWord, new Token(
                    getTextAttribute(prefs, SQLEditorStatementTypes.UN_RESERVED_WORDS)));
        }

        // Add the SQL datatype names to the word rule.
        for (String datatype : sqlSyntax.getTypes()) {
            wordRule.addWord(datatype, new Token(
                    getTextAttribute(prefs, SQLEditorStatementTypes.TYPES)));
        }

        // Add the SQL function names to the word rule.
        for (String function : sqlSyntax.getFunctions()) {
            wordRule.addWord(function, new Token(
                    getTextAttribute(prefs, SQLEditorStatementTypes.FUNCTIONS)));
        }

        // Add the SQL constants to the word rule.
        for (String constant : sqlSyntax.getConstants()) {
            wordRule.addWord(constant, new Token(
                    getTextAttribute(prefs, SQLEditorStatementTypes.CONSTANTS)));
        }

        return wordRule;
    }

    private TextAttribute getTextAttribute(IPreferenceStore prefs, SQLEditorStatementTypes type) {
        SQLEditorSyntaxModel sm = new SQLEditorSyntaxModel(type, prefs).load();
        int style = 0 | (sm.isBold() ? SWT.BOLD : 0)
                | (sm.isItalic() ? SWT.ITALIC: 0)
                | (sm.isUnderline() ? SWT.UNDERLINE_SINGLE: 0)
                | (sm.isUnderline() ? TextAttribute.UNDERLINE: 0)
                | (sm.isStrikethrough() ? TextAttribute.STRIKETHROUGH: 0);
        return new TextAttribute(fSharedColors.getColor(sm.getColor()), null, style);
    }

    private RuleBasedScanner createCommentScanner() {
        RuleBasedScanner commentScanner= new RuleBasedScanner();
        commentScanner.setDefaultReturnToken(new Token(
                getTextAttribute(prefs, SQLEditorStatementTypes.SINGLE_LINE_COMMENTS)));
        return commentScanner;
    }

    private RuleBasedScanner createMultiCommentScanner() {
        RuleBasedScanner commentScanner= new RuleBasedScanner();
        commentScanner.setDefaultReturnToken(new Token(
                getTextAttribute(prefs, SQLEditorStatementTypes.MULTI_LINE_COMMENTS)));
        return commentScanner;
    }

    private RuleBasedScanner createCharacterStringLiteralCommentScanner() {
        RuleBasedScanner commentScanner= new RuleBasedScanner();
        commentScanner.setDefaultReturnToken(new Token(
                getTextAttribute(prefs, SQLEditorStatementTypes.CHARACTER_STRING_LITERAL)));
        return commentScanner;
    }
}

