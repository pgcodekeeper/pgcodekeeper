package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
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
}
