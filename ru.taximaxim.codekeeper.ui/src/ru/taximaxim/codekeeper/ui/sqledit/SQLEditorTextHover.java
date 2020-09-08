package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.Optional;

import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.DefaultTextHover;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHoverExtension;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.editors.text.EditorsUI;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.meta.MetaStatement;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

final class SQLEditorTextHover extends DefaultTextHover implements ITextHoverExtension, ITextHoverExtension2 {

    private static final String QUICKDIFF = "org.eclipse.ui.workbench.texteditor.quickdiff"; //$NON-NLS-1$

    private final SQLEditor editor;

    public SQLEditorTextHover(ISourceViewer sourceViewer, SQLEditor editor) {
        super(sourceViewer);
        this.editor = editor;
    }

    @Override
    public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
        PgDbParser parser = editor.getParser();
        for (PgObjLocation obj : parser.getObjsForEditor(editor.getEditorInput())) {
            if (offset > obj.getOffset()
                    && offset < (obj.getOffset() + obj.getObjLength())) {
                Optional<MetaStatement> loc = parser.getDefinitionsForObj(obj).findAny();
                if (loc.isPresent()) {
                    SQLEditorMyRegion region = new SQLEditorMyRegion(obj.getOffset(), obj.getObjLength());
                    region.setComment(loc.get().getComment());
                    return region;
                }
            }
        }
        return new Region(offset, 0);
    }

    @Override
    public IInformationControlCreator getHoverControlCreator() {
        return parent -> new DefaultInformationControl(parent, EditorsUI.getTooltipAffordanceString());
    }

    @Override
    protected boolean isIncluded(Annotation annotation) {
        // exclude text change annotations
        return !annotation.getType().startsWith(QUICKDIFF);
    }

    @Override
    public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
        @SuppressWarnings("deprecation")
        String msg = super.getHoverInfo(textViewer, hoverRegion);
        System.err.println(" >>> getHoverInfo : ");
        if (msg != null) {
            System.err.println("    >>> getHoverInfo - msg : " + msg);
            return msg;
        }
        if (hoverRegion instanceof SQLEditorMyRegion) {
            return ((SQLEditorMyRegion) hoverRegion).getComment();
        }
        return "";  //$NON-NLS-1$
    }

    @Override
    public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {

        System.err.println("\n\n --- getHoverInfo2");

        // Start with the string returned by the older getHoverInfo()
        final String selection = getHoverInfo(textViewer, hoverRegion);

        // If text is selected in the editor window, it's returned as the
        // hover string. If no text is selected, then the returned hover is
        // a URL pointing to www.outofwhatbox.com/blog.
        return new SQLHoverInformationControl.IHTMLHoverInfo() {

            @Override
            public boolean isURL() {
                return selection.length() == 0;
            }

            @Override
            public String getHTMLString() {
                if (isURL()){
                    return "http://www.outofwhatbox.com/blog";             //$NON-NLS-1$
                }
                return selection;
            }
        };
    }
}