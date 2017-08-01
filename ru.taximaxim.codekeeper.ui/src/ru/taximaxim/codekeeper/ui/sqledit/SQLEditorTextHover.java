package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.List;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;

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
        PgDbParser parser = editor.getParser();
        List<PgObjLocation> refs = parser.getObjsForEditor(editor.getEditorInput());
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