package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import ru.taximaxim.codekeeper.ui.Log;
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
        PgDbParser parser = null;
        IEditorPart page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor();
        IEditorInput input = page.getEditorInput();
        if (input instanceof FileEditorInput) {
            file = ((FileEditorInput) input).getFile();
            if (file != null) {
                proj = file.getProject();
                if (proj != null) {
                    parser = PgDbParser.getParser(proj);
                }
            }
        }
        if (input instanceof DepcyFromPSQLOutput) {
            DepcyFromPSQLOutput dep = (DepcyFromPSQLOutput) input;
            parser = dep.getParser();
        }

        if (parser == null) {
            return null;
        }
        
        List<IHyperlink> hyperlinks = new ArrayList<>();
        List<PgObjLocation> refs;
        if (file != null) {
            refs = parser.getObjsForPath(file.getLocation().toFile().toPath());
        } else {
            refs = parser.getObjReferences();
        }
        for (PgObjLocation obj : refs) {
            if (offset > obj.getOffset()
                    && offset < (obj.getOffset() + obj.getObjLength())) {
                PgObjLocation objDefinition = parser.getDefinitionForObj(obj);
                if (objDefinition != null) {
                    hyperlinks.add(new SQLEditorHyperLink(new Region(
                            objDefinition.getOffset(), objDefinition
                                    .getObjLength()), new Region(obj
                            .getOffset(), obj.getObjLength()), "Reference",
                            objDefinition.getFilePath(), input));
                }
            }
        }

        if (hyperlinks.isEmpty()) {
            return null;
        }
        return hyperlinks.toArray(new IHyperlink[hyperlinks.size()]);
    }
}