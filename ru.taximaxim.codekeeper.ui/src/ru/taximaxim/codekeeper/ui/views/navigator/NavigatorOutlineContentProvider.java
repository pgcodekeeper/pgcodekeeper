package ru.taximaxim.codekeeper.ui.views.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ITreeContentProvider;

import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import ru.taximaxim.codekeeper.ui.sqledit.SegmentsWithParent;

public class NavigatorOutlineContentProvider implements ITreeContentProvider {

    @Override
    public Object[] getElements(Object inputElement) {
        return getChildren(inputElement);
    }

    @Override
    public Object[] getChildren(Object parentElement) {
        if (!(parentElement instanceof IFile)) {
            return null;
        }
        IFile iFile = (IFile) parentElement;

        return PgDbParser.getParser(iFile)
                .getObjsForPath(iFile.getLocation().toOSString())
                .stream()
                .filter(e -> e.getAction() != null)
                .sorted((a, b) -> Integer.compare(a.getOffset(), b.getOffset()))
                .map(e -> new SegmentsWithParent(e, iFile))
                .toArray();
    }

    @Override
    public Object getParent(Object element) {
        return null;
    }

    @Override
    public boolean hasChildren(Object element) {
        return !(element instanceof SegmentsWithParent);
    }
}
