package ru.taximaxim.codekeeper.ui.views.navigator;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

public class NavigatorOutlineSorter extends ViewerSorter {

    @Override
    public void sort(Viewer viewer, Object[] elements) {
        // do no sorting
        // NavigatorOutlineContentProvider provides ordered elements given by PgDbParser
    }

    @Override
    public int compare(Viewer viewer, Object e1, Object e2) {
        // do no sorting
        return 0;
    }
}
