package ru.taximaxim.codekeeper.ui.views.navigator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ITreeContentProvider;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
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
        IProject iProject = iFile.getProject();

        List<PgObjLocation> refs = PgDbParser.getParser(iProject).getObjsForPath(iFile.getLocation().toOSString());
        List<SegmentsWithParent> segments = new ArrayList<>(refs.size());
        for (PgObjLocation loc : refs) {
            if (loc.getAction() != StatementActions.NONE) {
                segments.add(new SegmentsWithParent(loc, iFile));
            }
        }
        return segments.toArray();
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
