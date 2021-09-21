package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.Iterator;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.TextInvocationContext;
import org.eclipse.ui.texteditor.MarkerAnnotation;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class SQLEditorQuickAssistProcessor implements IQuickAssistProcessor {
    private final SQLEditor editor;

    public SQLEditorQuickAssistProcessor(SQLEditor editor) {
        this.editor = editor;
    }

    /*
     * @see IContentAssistProcessor#computeCompletionProposals(ITextViewer, int)
     */
    @Override
    public ICompletionProposal[] computeQuickAssistProposals(
            IQuickAssistInvocationContext quickAssistContext) {

        ISourceViewer viewer = quickAssistContext.getSourceViewer();
        IAnnotationModel model = viewer.getAnnotationModel();

        int documentOffset = quickAssistContext.getOffset();
        int length = viewer != null ? viewer.getSelectedRange().y : -1;
        TextInvocationContext context = new TextInvocationContext(viewer,
                documentOffset, length);

        if (model == null) {
            return null;
        }

        MisplaceCompletionProposal[] proposals = computeProposals(context, model);
        if (proposals == null) {
            return null;
        }
        return proposals;
    }

    private MisplaceCompletionProposal[] computeProposals(
            IQuickAssistInvocationContext context, IAnnotationModel model) {
        int offset = context.getOffset();
        Iterator<Annotation> iter = model.getAnnotationIterator();
        while (iter.hasNext()) {
            Annotation annotation = iter.next();
            if (annotation instanceof MarkerAnnotation) {
                Position pos = model.getPosition(annotation);
                if (pos != null && pos.overlapsWith(offset, 0)) {
                    if (canFix(annotation)) {
                        PgObjLocation obj = getPgObj(offset);
                        if (obj != null) {
                            return getMisplaceProposal(annotation, obj);
                        }
                    }
                }
            }
        }
        //TODO This disables Default Spelling Problems.
        return null;
    }

    private PgObjLocation getPgObj( int offset) {
        PgDbParser parser = editor.getParser();
        for (PgObjLocation obj : parser.getObjsForEditor(editor.getEditorInput())) {
            if (offset > obj.getOffset() && offset < (obj.getOffset() + obj.getObjLength())) {
                return obj;
            }
        }
        return null;
    }


    private MisplaceCompletionProposal[] getMisplaceProposal(Annotation annotation, PgObjLocation pgObjLocation) {
        return MisplaceProposal.getMisplaceProposals(annotation, pgObjLocation);
    }

    @Override
    public String getErrorMessage() {
        return "Some message";
    }

    @Override
    public boolean canFix(Annotation annotation) {
        return MisplaceProposal.isMisplaceError(annotation);
    }

    @Override
    public boolean canAssist(IQuickAssistInvocationContext invocationContext) {
        return true;
    }
}