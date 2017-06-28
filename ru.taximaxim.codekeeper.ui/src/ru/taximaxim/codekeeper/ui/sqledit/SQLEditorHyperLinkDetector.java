package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class SQLEditorHyperLinkDetector extends AbstractHyperlinkDetector {

    @Override
    public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region,
            boolean canShowMultipleHyperlinks) {
        SQLEditor editor = getAdapter(SQLEditor.class);
        PgDbParser parser = editor.getParser();
        IEditorInput input = editor.getEditorInput();
        IFile file = null;
        if (input instanceof IFileEditorInput) {
            file = ((IFileEditorInput) input).getFile();
        }

        List<PgObjLocation> refs;
        if (file != null) {
            refs = parser.getObjsForPath(file.getLocation().toOSString());
        } else {
            refs = PgDbParser.getAll(parser.getObjReferences());
        }
        List<IHyperlink> hyperlinks = new ArrayList<>();
        int offset = region.getOffset();
        for (PgObjLocation obj : refs) {
            if (offset > obj.getOffset()
                    && offset < (obj.getOffset() + obj.getObjLength())) {
                String message = obj.getObjName();
                PgObjLocation def = parser.getDefinitionForObj(obj);
                if (def != null) {
                    hyperlinks.add(new SQLEditorHyperLink(
                            new Region(def.getOffset(), def.getObjLength()),
                            new Region(obj.getOffset(), obj.getObjLength()), message,
                            def.getFilePath(), def.getLineNumber()));
                }
            }
        }

        if (hyperlinks.isEmpty()) {
            return null;
        }
        return hyperlinks.toArray(new IHyperlink[hyperlinks.size()]);
    }
}