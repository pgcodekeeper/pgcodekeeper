package ru.taximaxim.codekeeper.ui.comparetools;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.contentmergeviewer.IMergeViewerContentProvider;
import org.eclipse.compare.structuremergeviewer.ICompareInput;
import org.eclipse.swt.graphics.Image;

public class DiffContentProvider implements IMergeViewerContentProvider {

    private final CompareConfiguration conf;

    public DiffContentProvider(CompareConfiguration conf) {
        this.conf = conf;
    }

    @Override
    public String getRightLabel(Object input) {
        return conf.isMirrored() ? conf.getLeftLabel(input) : conf.getRightLabel(input);
    }

    @Override
    public Object getRightContent(Object input) {
        if (input instanceof ICompareInput) {
            ICompareInput ci = ((ICompareInput) input);
            return conf.isMirrored() ? ci.getLeft() : ci.getRight();
        }
        return null;
    }

    @Override
    public String getLeftLabel(Object input) {
        return conf.isMirrored() ? conf.getRightLabel(input) : conf.getLeftLabel(input);
    }

    @Override
    public Object getLeftContent(Object input) {
        if (input instanceof ICompareInput) {
            ICompareInput ci = ((ICompareInput) input);
            return conf.isMirrored() ? ci.getRight() : ci.getLeft();
        }
        return null;
    }

    @Override
    public boolean showAncestor(Object input) {
        return false;
    }

    @Override
    public void saveRightContent(Object input, byte[] bytes) {
        //no impl
    }

    @Override
    public void saveLeftContent(Object input, byte[] bytes) {
        //no impl
    }

    @Override
    public boolean isRightEditable(Object input) {
        return false;
    }

    @Override
    public boolean isLeftEditable(Object input) {
        return false;
    }

    @Override
    public Image getRightImage(Object input) {
        return null;
    }

    @Override
    public Image getLeftImage(Object input) {
        return null;
    }

    @Override
    public String getAncestorLabel(Object input) {
        return null;
    }

    @Override
    public Image getAncestorImage(Object input) {
        return null;
    }

    @Override
    public Object getAncestorContent(Object input) {
        return null;
    }
}
