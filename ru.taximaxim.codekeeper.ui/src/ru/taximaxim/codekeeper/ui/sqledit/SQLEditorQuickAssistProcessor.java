package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.Iterator;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.MarkerAnnotation;

import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

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

        if (model == null) {
            return null;
        }

        return computeProposals(quickAssistContext.getOffset(), model);
    }

    private MisplaceCompletionProposal[] computeProposals(
            int documentOffset, IAnnotationModel model) {
        Iterator<Annotation> iter = model.getAnnotationIterator();
        while (iter.hasNext()) {
            Annotation annotation = iter.next();
            if (annotation instanceof MarkerAnnotation) {
                Position pos = model.getPosition(annotation);
                pos = new Position(pos.getOffset(), pos.getLength() + 1);
                if (pos != null && pos.overlapsWith(documentOffset, 0) && canFix(annotation)) {
                    PgObjLocation obj = editor.getObjectAtOffset(documentOffset, true);
                    if (obj != null) {
                        return getMisplaceProposal(annotation, obj);
                    }
                }
            }
        }
        return null;
    }

    private MisplaceCompletionProposal[] getMisplaceProposal(Annotation annotation, PgObjLocation pgObjLocation) {
        return MisplaceCompletionProposal.getMisplaceProposals(annotation, pgObjLocation);
    }

    @Override
    public String getErrorMessage() {
        return null;
    }

    @Override
    public boolean canFix(Annotation annotation) {
        return MisplaceCompletionProposal.isMisplaceError(annotation);
    }

    @Override
    public boolean canAssist(IQuickAssistInvocationContext invocationContext) {
        return true;
    }
}