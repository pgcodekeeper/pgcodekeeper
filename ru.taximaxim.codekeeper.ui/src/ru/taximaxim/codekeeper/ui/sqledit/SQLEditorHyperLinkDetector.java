package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.List;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class SQLEditorHyperLinkDetector extends AbstractHyperlinkDetector {

    @Override
    public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region,
            boolean canShowMultipleHyperlinks) {
        SQLEditor editor = getAdapter(SQLEditor.class);
        PgDbParser parser = editor.getParser();

        int offset = region.getOffset();
        List<PgObjLocation> refs = parser.getObjsForEditor(editor.getEditorInput());
        for (PgObjLocation obj : refs) {
            if (offset > obj.getOffset()
                    && offset < (obj.getOffset() + obj.getObjLength())) {
                IHyperlink[] links =  parser.getDefinitionsForObj(obj)
                        .map(def -> new SQLEditorHyperLink(
                                new Region(def.getOffset(), def.getObjLength()),
                                new Region(obj.getOffset(), obj.getObjLength()),
                                obj.getObjName(), def.getFilePath(), def.getLineNumber()))
                        .toArray(IHyperlink[]::new);
                if (links.length != 0) {
                    return links;
                }
            }
        }
        return null;
    }
}