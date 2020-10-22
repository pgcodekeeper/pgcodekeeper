package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.source.Annotation;

public class SQLAnnotationInfo {
    public final Annotation annotation;
    public final Position position;
    public final ITextViewer viewer;

    public SQLAnnotationInfo(Annotation annotation, Position position, ITextViewer textViewer) {
        this.annotation= annotation;
        this.position= position;
        this.viewer= textViewer;
    }

    /**
     * Create completion proposals which can resolve the given annotation at
     * the given position. Returns an empty array if no such proposals exist.
     *
     * @return the proposals or an empty array
     */
    public ICompletionProposal[] getCompletionProposals() {
        return new ICompletionProposal[0];
    }

}
