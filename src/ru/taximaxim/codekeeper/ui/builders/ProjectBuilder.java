package ru.taximaxim.codekeeper.ui.builders;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class ProjectBuilder extends IncrementalProjectBuilder {

    public ProjectBuilder() {
    }

    @Override
    protected IProject[] build(int kind, Map<String, String> args,
            final IProgressMonitor monitor) throws CoreException {
        IProject proj = getProject();
        final PgDbParser parser = PgDbParser.getParser(proj);
        if (!proj.hasNature(NATURE.ID)) {
            return null;
        }
        switch (kind) {
        case IncrementalProjectBuilder.AUTO_BUILD:
        case IncrementalProjectBuilder.INCREMENTAL_BUILD:
            IResourceDelta delta = getDelta(getProject());
            try {
                delta.accept(new IResourceDeltaVisitor() {
                   public boolean visit(IResourceDelta delta) {
                        if (delta.getResource() instanceof IFile) {
                            parser.getObjFromProjFile(delta.getResource()
                                    .getLocationURI(), monitor);
                        }
                        return true;
                    }
                });
             } catch (CoreException e) {
                Log.log(Log.LOG_ERROR, "Cannot get delta from incremental or auto build");
             }
            break;
        case IncrementalProjectBuilder.FULL_BUILD:
            parser.getObjFromProject(monitor);
            break;
        }
        List<IProject> list = new ArrayList<>();
        list.add(proj);
        return list.toArray(new IProject[list.size()]);
    }
}
