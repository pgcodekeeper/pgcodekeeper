package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;

public class SQLEditorHyperLink implements IHyperlink {

    private String location;
    private IRegion region;
    private ITextViewer viewer;

    public SQLEditorHyperLink(IRegion region, String text, ITextViewer viewer) {

        this.region= region;
        this.location = text;
        this.viewer = viewer;
    }
    
    @Override
    public IRegion getHyperlinkRegion() {
        return region;
    }

    @Override
    public String getTypeLabel() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getHyperlinkText() {
        return location;
    }

    @Override
    public void open() {
        if(location!=null)
        {
            viewer.setSelectedRange(region.getOffset(), region.getLength());

        }
    }

}
