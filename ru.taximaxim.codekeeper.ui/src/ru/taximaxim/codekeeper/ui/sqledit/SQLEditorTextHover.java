package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
//TODO использовать extension интерфейсы
final class SQLEditorTextHover implements ITextHover {

    private final SQLEditor editor;

    public SQLEditorTextHover(SQLEditor editor) {
        this.editor = editor;
    }

    @Override
    public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
        IFile file = null;
        PgDbParser parser = editor.getParser();
        IEditorInput input = editor.getEditorInput();
        if (input instanceof FileEditorInput) {
            file = ((FileEditorInput) input).getFile();
        }
        if (parser == null) {
            return new Region(offset, 0);
        }
        List<PgObjLocation> refs;
        if (file != null) {
            refs = parser.getObjsForPath(file.getLocation().toOSString());
        } else {
            refs = parser.getAllObjReferences();
        }
        for (PgObjLocation obj : refs) {
            if (offset > obj.getOffset()
                    && offset < (obj.getOffset() + obj.getObjLength())) {
                PgObjLocation loc = parser.getDefinitionForObj(obj);
                if (loc != null) {
                    SQLEditorMyRegion region = new SQLEditorMyRegion(obj.getOffset(), obj.getObjLength());
                    region.setComment(loc.getComment());
                    return region;
                }
            }
        }
        return new Region(offset, 0);
    }

    @Override
    public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
        if (hoverRegion instanceof SQLEditorMyRegion) {
            return ((SQLEditorMyRegion) hoverRegion).getComment();
        }
        return "";  //$NON-NLS-1$
    }
}