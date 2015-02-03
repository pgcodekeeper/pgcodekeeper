package ru.taximaxim.codekeeper.ui.builders;

import java.nio.file.Paths;
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
import org.eclipse.core.runtime.SubMonitor;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class ProjectBuilder extends IncrementalProjectBuilder {

    public ProjectBuilder() {
    }
    
    int count = 0;

    @Override
    protected IProject[] build(int kind, Map<String, String> args,
            IProgressMonitor monitor) throws CoreException {
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
                count = 0;
                delta.accept(new IResourceDeltaVisitor() {
                    
                    @Override
                    public boolean visit(IResourceDelta delta) throws CoreException {
                        if (delta.getResource() instanceof IFile) {
                            count++;
                        }
                        return true;
                    }
                });
                if (count > 10) {
                    parser.getObjFromProject(monitor);
                } else {
                    final SubMonitor sub = SubMonitor.convert(monitor, count);
                    delta.accept(new IResourceDeltaVisitor() {
                        public boolean visit(IResourceDelta delta) {
                            if (delta.getResource() instanceof IFile) {
                                switch (delta.getKind()) {
                                case IResourceDelta.REMOVED:
                                case IResourceDelta.REMOVED_PHANTOM:
                                case IResourceDelta.REPLACED:
                                    parser.removePathFromRefs(Paths.get(delta
                                            .getResource().getLocationURI()));
                                    break;
                                default:

                                    sub.worked(1);
                                    parser.getObjFromProjFile(delta
                                            .getResource().getLocationURI());

                                    break;
                                }
                            }
                            return true;
                        }
                    });
                    parser.notifyListeners();
                }
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
