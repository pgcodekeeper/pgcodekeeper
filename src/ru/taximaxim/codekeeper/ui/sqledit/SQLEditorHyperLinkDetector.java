package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import cz.startnet.utils.pgdiff.schema.PGObjLocation;

public class SQLEditorHyperLinkDetector extends AbstractHyperlinkDetector {

    public SQLEditorHyperLinkDetector() {
    }

    @Override
    public IHyperlink[] detectHyperlinks(ITextViewer textViewer,
            IRegion region, boolean canShowMultipleHyperlinks) {
        IRegion lineInfo;
        String line;
        int offset = region.getOffset();
        IProject proj = null;
        IFile file = null;
        try {
            IDocument document = textViewer.getDocument();
            IEditorPart page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
            if (page instanceof SQLEditor) {
                SQLEditor edit = (SQLEditor)page;
                file = ((FileEditorInput)((edit).getEditorInput())).getFile();
                if (file != null) {
                    proj = file.getProject();
                }
            }
            
            lineInfo = document.getLineInformationOfOffset(offset);
            line = document.get(lineInfo.getOffset(), lineInfo.getLength());
        } catch (BadLocationException ex) {
            return null;
        }
        
        if (proj == null) {
            return null;
        }
        
        PgDbParser parser = PgDbParser.getParserFromStore(proj);
        List<IHyperlink> hyperlinks = new ArrayList<>();
        for (String name : parser.getObjNames()) {
            int wordBegin = lineInfo.getOffset() + line.indexOf(name);
            int wordEnd = lineInfo.getOffset() + line.indexOf(name) + name.length();
            if (line.contains(name)
                    && (wordBegin < offset && wordEnd > offset)) {
                for (PGObjLocation loc : parser.getObjectLocations(name)) {
                    hyperlinks.add(new SQLEditorHyperLink(new Region(loc.getOffset(), loc.getObjLength()), new Region(wordBegin, name.length()),
                            "Reference", loc.getFilePath(), textViewer));
                }
            }
        }

        if (hyperlinks.isEmpty()) {
            return null;
        }
        return hyperlinks.toArray(new IHyperlink[hyperlinks.size()]);
    }
}