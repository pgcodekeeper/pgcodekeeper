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
import org.eclipse.ui.IEditorInput;
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
        PgDbParser projParser = null;
        if (input instanceof DepcyFromPSQLOutput) {
            DepcyFromPSQLOutput dep = (DepcyFromPSQLOutput) input;
            parser = dep.getParser();
            projParser = PgDbParser.getParser(dep.getProject());
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
                String message = obj.getObjName();
                PgObjLocation def = parser.getDefinitionForObj(obj);
                if (def != null) {
                    fillHyperLink(input, hyperlinks, obj, def, message,
                            def.getLineNumber());
                }
                if (projParser != null) {
                    PgObjLocation projDef = projParser.getDefinitionForObj(obj);
                    if (projDef != null) {
                        fillHyperLink(input, hyperlinks, obj, projDef, message,
                                projDef.getLineNumber());
                    }
                }
            }
        }

        if (hyperlinks.isEmpty()) {
            return null;
        }
        return hyperlinks.toArray(new IHyperlink[hyperlinks.size()]);
    }

    private void fillHyperLink(IEditorInput input, List<IHyperlink> hyperlinks,
            PgObjLocation obj, PgObjLocation objDefinition, String text,
            int lineNumber) {
        hyperlinks.add(new SQLEditorHyperLink(new Region(objDefinition
                .getOffset(), objDefinition.getObjLength()), new Region(obj
                .getOffset(), obj.getObjLength()), text, objDefinition
                .getFilePath(), input, lineNumber));
    }
}