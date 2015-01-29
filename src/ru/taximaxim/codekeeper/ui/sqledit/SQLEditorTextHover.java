package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;

final class SQLEditorTextHover implements ITextHover {
    /**
     * 
     */
    private final SQLEditorSourceViewerConfiguration sqlEditorSourceViewerConfiguration;

    /**
     * @param sqlEditorSourceViewerConfiguration
     */
    SQLEditorTextHover(
            SQLEditorSourceViewerConfiguration sqlEditorSourceViewerConfiguration) {
        this.sqlEditorSourceViewerConfiguration = sqlEditorSourceViewerConfiguration;
    }

    @Override
    public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
        IFile file = null;
        IEditorPart page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor();
        IEditorInput input = page.getEditorInput();
        if (input instanceof FileEditorInput) {
            file = ((FileEditorInput) input).getFile();
        }
        if (this.sqlEditorSourceViewerConfiguration.parser == null) {
            return new Region(offset, 0);
        }
        List<PgObjLocation> refs;
        if (file != null) {
            refs = this.sqlEditorSourceViewerConfiguration.parser.getObjsForPath(file.getLocation().toFile().toPath());
        } else {
            refs = this.sqlEditorSourceViewerConfiguration.parser.getObjReferences();
        }
        for (PgObjLocation obj : refs) {
            if (offset > obj.getOffset()
                    && offset < (obj.getOffset() + obj.getObjLength())) {
                PgObjLocation loc = this.sqlEditorSourceViewerConfiguration.parser.getDefinitionForObj(obj);
                if (loc != null) {
                    SQLEditorMyRegion region = new SQLEditorMyRegion(obj.getOffset(), obj.getObjLength());
                    region.setComment(loc.getComment());
                    return region;
                } else {
                    if (input instanceof DepcyFromPSQLOutput) {
                        PgDbParser projParser = PgDbParser
                                .getParser(((DepcyFromPSQLOutput) input)
                                        .getProject());
                        loc = projParser.getDefinitionForObj(obj);
                        if (loc != null) {
                            SQLEditorMyRegion region = new SQLEditorMyRegion(obj.getOffset(), obj.getObjLength());
                            region.setComment(loc.getComment());
                            return region;
                        }
                    }
                }
            }
        }
        return new Region(offset, 0);
    }

    @Override
    public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
        if (hoverRegion != null) {
            if (hoverRegion.getLength() > -1
                    && hoverRegion instanceof SQLEditorMyRegion) {
                SQLEditorMyRegion myRegion = (SQLEditorMyRegion) hoverRegion;
                return myRegion.getComment();
            }
        }
        return ""; 
    }
}