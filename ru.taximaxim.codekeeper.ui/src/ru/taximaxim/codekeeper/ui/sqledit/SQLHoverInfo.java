package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.source.Annotation;

import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public class SQLHoverInfo {

    public final Annotation annotation;
    public final ITextViewer viewer;
    public final PgObjLocation pgObjLocation;
    public final String comment;

    public SQLHoverInfo(Annotation annotation, ITextViewer textViewer, PgObjLocation pgObjLocation, String comment) {
        this.annotation = annotation;
        this.viewer = textViewer;
        this.pgObjLocation = pgObjLocation;
        this.comment = comment;
    }
}
