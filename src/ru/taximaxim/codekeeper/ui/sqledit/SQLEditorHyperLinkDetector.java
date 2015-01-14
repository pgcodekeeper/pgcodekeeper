package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;

public class SQLEditorHyperLinkDetector extends AbstractHyperlinkDetector {

    public SQLEditorHyperLinkDetector() {
    }

    @Override
    public IHyperlink[] detectHyperlinks(ITextViewer textViewer,
            IRegion region, boolean canShowMultipleHyperlinks) {
        int offset = region.getOffset();
        IProject proj = null;
        IFile file = null;
        IEditorPart page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor();
        if (page instanceof SQLEditor) {
            SQLEditor edit = (SQLEditor) page;
            file = ((FileEditorInput) ((edit).getEditorInput())).getFile();
            if (file != null) {
                proj = file.getProject();
            }
        }

        if (proj == null) {
            return null;
        }

        PgDbParser parser = PgDbParser.getParser(proj);
        List<IHyperlink> hyperlinks = new ArrayList<>();
        for (PgObjLocation obj : parser.getObjsForPath(file.getLocation()
                .toFile().toPath())) {
            if (offset > obj.getOffset()
                    && offset < (obj.getOffset() + obj.getObjLength())) {
                PgObjLocation objDefinition = parser.getDefinitionForObj(obj);
                if (objDefinition != null) {
                    hyperlinks.add(new SQLEditorHyperLink(new Region(
                            objDefinition.getOffset(), objDefinition
                                    .getObjLength()), new Region(obj
                            .getOffset(), obj.getObjLength()), "Reference",
                            objDefinition.getFilePath()));
                }
            }
        }

        if (hyperlinks.isEmpty()) {
            return null;
        }
        return hyperlinks.toArray(new IHyperlink[hyperlinks.size()]);
    }
}