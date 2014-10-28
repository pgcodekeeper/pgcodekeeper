package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.TextAttribute;
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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;

public class SQLSourceViewerConfiguration extends TextSourceViewerConfiguration {

    private static final class WordDetector implements IWordDetector {
        public boolean isWordPart(char c) {
            return !Character.isWhitespace(c);
        }

        public boolean isWordStart(char c) {
            return !Character.isWhitespace(c);
        }
    }
    
    private final ISharedTextColors fSharedColors;
    
    public SQLSourceViewerConfiguration(ISharedTextColors sharedColors, IPreferenceStore store) {
        super(store);
        fSharedColors= sharedColors;
    }

    public String getConfiguredDocumentPartitioning(ISourceViewer sourceViewer) {
        return SQLDocumentProvider.SQL_PARTITIONING;
    }
    
    public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
        return new String[] {
                SQLDocumentProvider.SQL_CODE,
                SQLDocumentProvider.SQL_SINGLE_COMMENT
        };
    }
    
    public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
        PresentationReconciler reconciler= new PresentationReconciler();
        reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
        
        addDamagerRepairer(reconciler, createCommentScanner(), SQLDocumentProvider.SQL_SINGLE_COMMENT);
        addDamagerRepairer(reconciler, createMultiCommentScanner(), SQLDocumentProvider.SQL_MULTI_COMMENT);
        addDamagerRepairer(reconciler, createRecipeScanner(), SQLDocumentProvider.SQL_CODE);
        
        return reconciler;
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
        SqlPostgresSyntax sqlSyntax = new SqlPostgresSyntax();
        
        // Define a word rule and add SQL keywords to it.
        WordRule wordRule = new WordRule(new WordDetector(), Token.WHITESPACE);
        for (String reservedWord : sqlSyntax.getReservedwords()) {
            wordRule.addWord(reservedWord.toLowerCase(), new Token(
                    new TextAttribute(null, null, SWT.BOLD)));
            wordRule.addWord(reservedWord.toUpperCase(), new Token(
                    new TextAttribute(null, null, SWT.BOLD)));
        }
        // TODO render unreserved keywords in the same way with reserved
        // keywords, should let user decide via preference
        for (String unreservedWord : sqlSyntax.getUnreservedwords()) {
            wordRule.addWord(unreservedWord.toLowerCase(), new Token(
                    new TextAttribute(null, null, SWT.BOLD)));
            wordRule.addWord(unreservedWord.toUpperCase(), new Token(
                    new TextAttribute(null, null, SWT.BOLD)));
        }

        // Add the SQL datatype names to the word rule.
        for (String datatype : sqlSyntax.getTypes()) {
            wordRule.addWord(datatype.toLowerCase(), new Token(
                    new TextAttribute(null, null, SWT.BOLD)));
            wordRule.addWord(datatype.toUpperCase(), new Token(
                    new TextAttribute(null, null, SWT.BOLD)));
        }

        // Add the SQL function names to the word rule.
        for (String function : sqlSyntax.getFunctions()) {
            wordRule.addWord(function.toLowerCase(), new Token(
                    new TextAttribute(null, null, SWT.BOLD)));
            wordRule.addWord(function.toUpperCase(), new Token(
                    new TextAttribute(null, null, SWT.BOLD)));
        }

        // Add the SQL constants to the word rule.
        for (String constant : sqlSyntax.getConstants()) {
            wordRule.addWord(constant.toLowerCase(), new Token(
                    new TextAttribute(null, null, SWT.BOLD)));
            wordRule.addWord(constant.toUpperCase(), new Token(
                    new TextAttribute(null, null, SWT.BOLD)));
        }

        return wordRule;
    }

    private RuleBasedScanner createCommentScanner() {
        Color green= fSharedColors.getColor(new RGB(0, 150, 0));
        RuleBasedScanner commentScanner= new RuleBasedScanner();
        commentScanner.setDefaultReturnToken(new Token(new TextAttribute(green, null, SWT.ITALIC)));
        return commentScanner;
    }
    
    private RuleBasedScanner createMultiCommentScanner() {
        Color blue= fSharedColors.getColor(new RGB(0, 0, 200));
        RuleBasedScanner commentScanner= new RuleBasedScanner();
        commentScanner.setDefaultReturnToken(new Token(new TextAttribute(blue, null, SWT.ITALIC)));
        return commentScanner;
    }
}
