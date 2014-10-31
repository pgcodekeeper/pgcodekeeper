package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;

import ru.taximaxim.codekeeper.ui.pgdbproject.parser.DBObjectsLocation;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class SQLEditorHyperLinkDetector extends AbstractHyperlinkDetector {

    IProject proj;

    public SQLEditorHyperLinkDetector(IProject proj) {
        this.proj = proj;
    }

    @Override
    public IHyperlink[] detectHyperlinks(ITextViewer textViewer,
            IRegion region, boolean canShowMultipleHyperlinks) {
        IRegion lineInfo;
        String line;
        int offset = region.getOffset();

        PgDbParser parser = PgDbParser.getParserFromStore(proj);
        try {
            IDocument document = textViewer.getDocument();
            lineInfo = document.getLineInformationOfOffset(offset);
            line = document.get(lineInfo.getOffset(), lineInfo.getLength());
        } catch (BadLocationException ex) {
            return null;
        }

        List<IHyperlink> hyperlinks = new ArrayList<>();
        for (String name : parser.getObjNames()) {
            int wordBegin = lineInfo.getOffset() + line.indexOf(name);
            int wordEnd = lineInfo.getOffset() + line.indexOf(name) + name.length();
            if (line.contains(name)
                    && (wordBegin < offset && wordEnd > offset)) {
                for (DBObjectsLocation loc : parser.getObjectsLocations()) {
                    if (loc.getObjName().equals(name)) {
                        hyperlinks.add(new SQLEditorHyperLink(loc.getRegion(), "Reference",
                                loc.getFilePath(), textViewer));
                    }
                }
            }
        }

        if (hyperlinks.isEmpty()) {
            return null;
        }
        return hyperlinks.toArray(new IHyperlink[hyperlinks.size()]);
    }
}