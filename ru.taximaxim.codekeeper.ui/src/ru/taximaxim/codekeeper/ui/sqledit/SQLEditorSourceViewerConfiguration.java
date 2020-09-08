package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.bindings.TriggerSequence;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.quickassist.IQuickAssistAssistant;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.quickassist.QuickAssistAssistant;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.ui.internal.texteditor.spelling.NoCompletionsProposal;
import org.eclipse.ui.keys.IBindingService;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.spelling.SpellingAnnotation;
import org.eclipse.ui.texteditor.spelling.SpellingProblem;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.copiedclasses.CompletionProposal;

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
    public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
        return new IAnnotationHover() {

            @Override
            public String getHoverInfo(ISourceViewer sourceViewer, int lineNumber) {
                IDocument document= sourceViewer.getDocument();

                try {
                    IRegion info= document.getLineInformation(lineNumber);
                    return document.get(info.getOffset(), info.getLength());
                } catch (BadLocationException x) {
                }

                return null;
            }
        };

    }

    @Override
    public IAutoEditStrategy[] getAutoEditStrategies(ISourceViewer sourceViewer, String contentType) {
        // TODO remove "SQLAutoIndentStrategy" if its not need,
        // if "SQLAutoIndentStrategy" need then correct it
        return new IAutoEditStrategy[] { new DefaultIndentLineAutoEditStrategy() };
    }

    @Override
    public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType) {
        return editor == null ? null : new SQLEditorTextHover(sourceViewer, editor);
    }

    /**
     * Returns the information control creator. The creator is a factory creating information
     * controls for the given source viewer. This implementation always returns a creator for
     * <code>JavaInformationControl</code> instances.
     *
     * @param sourceViewer the source viewer to be configured by this configuration
     * @return the information control creator or <code>null</code> if no information support should be installed
     * @since 2.0
     */
    @Override
    public IInformationControlCreator getInformationControlCreator(ISourceViewer sourceViewer) {
        return new IInformationControlCreator() {
            @Override
            public IInformationControl createInformationControl(Shell parent) {
                return new SQLHoverInformationControl(parent);
            }
        };
    }

    @Override
    public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
        if (editor == null) {
            return null;
        }

        KeySequence binding = getIterationBinding();

        ContentAssistant assistant = new ContentAssistant();
        assistant.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
        assistant.setContentAssistProcessor(new SQLEditorCompletionProcessor(assistant,
                editor, binding != null ? binding.format() : "no key"), //$NON-NLS-1$
                SQLEditorCommonDocumentProvider.SQL_CODE);
        assistant.enableAutoActivation(true);
        assistant.enableAutoInsert(true);
        assistant.setAutoActivationDelay(500);
        assistant.setProposalPopupOrientation(IContentAssistant.PROPOSAL_OVERLAY);
        assistant.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_ABOVE);
        assistant.setRepeatedInvocationMode(true);
        assistant.setStatusLineVisible(true);
        assistant.setShowEmptyList(true);
        assistant.setInformationControlCreator(this.getInformationControlCreator(sourceViewer));
        assistant.setRepeatedInvocationTrigger(binding);

        return assistant;
    }

    @Override
    public String[] getDefaultPrefixes(ISourceViewer sourceViewer,
            String contentType) {
        String pref = getDefaultPrefix(sourceViewer, contentType);
        if (pref != null) {
            String[] arr = new String[1];
            arr[0] = pref;
            return arr;
        }
        return null;
    }

    public String getDefaultPrefix(ISourceViewer sourceViewer, String contentType) {
        return (IDocument.DEFAULT_CONTENT_TYPE.equals(contentType) ? "//" : null); //$NON-NLS-1$
    }

    @Override
    public String[] getIndentPrefixes(ISourceViewer sourceViewer, String contentType) {
        return new String[] { "\t", "    " }; //$NON-NLS-1$ //$NON-NLS-2$
    }

    private KeySequence getIterationBinding() {
        final IBindingService bindingSvc= PlatformUI.getWorkbench().getService(IBindingService.class);
        TriggerSequence binding= bindingSvc.getBestActiveBindingFor(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
        if (binding instanceof KeySequence) {
            return (KeySequence) binding;
        }
        return null;
    }

    @Override
    public IQuickAssistAssistant getQuickAssistAssistant(ISourceViewer sourceViewer) {
        IQuickAssistAssistant quickAssist = new QuickAssistAssistant();
        quickAssist.setQuickAssistProcessor(new MyQuickAssistProcessor());
        quickAssist.setInformationControlCreator(getInformationControlCreator(sourceViewer));
        return quickAssist;
    }

    private static class MyQuickAssistProcessor implements IQuickAssistProcessor {


        private static final ICompletionProposal[] fgNoSuggestionsProposal=  new ICompletionProposal[] { new NoCompletionsProposal() };


        /*
         * @see IContentAssistProcessor#computeCompletionProposals(ITextViewer, int)
         */
        @Override
        public ICompletionProposal[] computeQuickAssistProposals(IQuickAssistInvocationContext quickAssistContext) {
            //            ISourceViewer viewer= quickAssistContext.getSourceViewer();
            //            int documentOffset= quickAssistContext.getOffset();
            //
            //            int length= viewer != null ? viewer.getSelectedRange().y : -1;
            //            TextInvocationContext context= new TextInvocationContext(viewer, documentOffset, length);
            //
            //
            //            IAnnotationModel model= viewer.getAnnotationModel();
            //            if (model == null) {
            //                return fgNoSuggestionsProposal;
            //            }
            //
            //            List<ICompletionProposal> proposals= computeProposals(context, model);
            //            if (proposals.isEmpty()) {
            //                return fgNoSuggestionsProposal;
            //            }
            //
            //            return proposals.toArray(new ICompletionProposal[proposals.size()]);

            return new CompletionProposal[] {new CompletionProposal("replacementString", 11, 5, 3), new CompletionProposal("replacementString2", 10, 4, 2)};
        }

        private boolean isAtPosition(int offset, Position pos) {
            return (pos != null) && (offset >= pos.getOffset() && offset <= (pos.getOffset() +  pos.getLength()));
        }

        private List<ICompletionProposal> computeProposals(IQuickAssistInvocationContext context, IAnnotationModel model) {
            int offset= context.getOffset();
            ArrayList<SpellingProblem> annotationList= new ArrayList<>();
            Iterator<Annotation> iter= model.getAnnotationIterator();
            while (iter.hasNext()) {
                Annotation annotation= iter.next();
                if (canFix(annotation)) {
                    Position pos= model.getPosition(annotation);
                    if (isAtPosition(offset, pos)) {
                        collectSpellingProblems(annotation, annotationList);
                    }
                }
            }
            SpellingProblem[] spellingProblems= annotationList.toArray(new SpellingProblem[annotationList.size()]);
            return computeProposals(context, spellingProblems);
        }

        private void collectSpellingProblems(Annotation annotation, List<SpellingProblem> problems) {
            if (annotation instanceof SpellingAnnotation) {
                problems.add(((SpellingAnnotation)annotation).getSpellingProblem());
            }
        }

        private List<ICompletionProposal> computeProposals(IQuickAssistInvocationContext context, SpellingProblem[] spellingProblems) {
            List<ICompletionProposal> proposals= new ArrayList<>();
            for (SpellingProblem spellingProblem : spellingProblems) {
                proposals.addAll(Arrays.asList(spellingProblem.getProposals(context)));
            }

            return proposals;
        }

        @Override
        public String getErrorMessage() {
            return "Some message";
        }

        @Override
        public boolean canFix(Annotation annotation) {
            // return annotation instanceof SpellingAnnotation && !annotation.isMarkedDeleted();
            return true;
        }

        @Override
        public boolean canAssist(IQuickAssistInvocationContext invocationContext) {
            return true;
        }
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
        addDamagerRepairer(reconciler, createQuotedIdentifierScanner(), SQLEditorCommonDocumentProvider.SQL_QUOTED_IDENTIFIER);
        addDamagerRepairer(reconciler, createRecipeScanner(), SQLEditorCommonDocumentProvider.SQL_CODE);
        return reconciler;
    }

    @Override
    public int getTabWidth(ISourceViewer sourceViewer) {
        return 4;
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
        RuleBasedScanner commentScanner = new RuleBasedScanner();
        commentScanner.setDefaultReturnToken(new Token(
                getTextAttribute(prefs, SQLEditorStatementTypes.SINGLE_LINE_COMMENTS)));
        return commentScanner;
    }

    private RuleBasedScanner createMultiCommentScanner() {
        RuleBasedScanner commentScanner = new RuleBasedScanner();
        commentScanner.setDefaultReturnToken(new Token(
                getTextAttribute(prefs, SQLEditorStatementTypes.MULTI_LINE_COMMENTS)));
        return commentScanner;
    }

    private RuleBasedScanner createCharacterStringLiteralCommentScanner() {
        RuleBasedScanner commentScanner = new RuleBasedScanner();
        commentScanner.setDefaultReturnToken(new Token(
                getTextAttribute(prefs, SQLEditorStatementTypes.CHARACTER_STRING_LITERAL)));
        return commentScanner;
    }

    private RuleBasedScanner createQuotedIdentifierScanner() {
        RuleBasedScanner commentScanner = new RuleBasedScanner();
        commentScanner.setDefaultReturnToken(new Token(
                getTextAttribute(prefs, SQLEditorStatementTypes.QUOTED_IDENTIFIER)));
        return commentScanner;
    }
}
