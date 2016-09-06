package ru.taximaxim.codekeeper.ui.views.navigator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import ru.taximaxim.codekeeper.ui.sqledit.SegmentsWithParent;

public class NavigatorOutlineContentProvider implements ITreeContentProvider {

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        // TODO Auto-generated method stub
    }

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

        List<SegmentsWithParent> segments = new ArrayList<>();
        List<PgObjLocation> refs = PgDbParser.getParser(iProject).getObjsForPath(iFile.getLocation().toFile().toPath());
        for (PgObjLocation loc : refs) {
            if (loc.getAction() != StatementActions.NONE) {
                segments.add(new SegmentsWithParent(loc, iFile));
            }
        }
        return segments.toArray();
    }

    @Override
    public Object getParent(Object element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasChildren(Object element) {
        if (element instanceof SegmentsWithParent) {
            return false;
        } else {
            return true;
        }
    }
}
