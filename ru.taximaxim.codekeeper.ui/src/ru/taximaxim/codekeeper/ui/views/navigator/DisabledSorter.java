package ru.taximaxim.codekeeper.ui.views.navigator;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

public class DisabledSorter extends ViewerComparator {

    @Override
    public void sort(Viewer viewer, Object[] elements) {
        // do no sorting
    }

    @Override
    public int compare(Viewer viewer, Object e1, Object e2) {
        // do no sorting
        return 0;
    }
}
