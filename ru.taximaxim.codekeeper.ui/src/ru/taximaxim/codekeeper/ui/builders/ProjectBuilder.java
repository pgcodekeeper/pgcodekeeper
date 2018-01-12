package ru.taximaxim.codekeeper.ui.builders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;

import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgUIDumpLoader;
import ru.taximaxim.codekeeper.ui.views.navigator.PgDecorator;

public class ProjectBuilder extends IncrementalProjectBuilder {

    @Override
    protected IProject[] build(int kind, Map<String, String> args,
            IProgressMonitor monitor) throws CoreException {
        IProject proj = getProject();
        if (!proj.hasNature(NATURE.ID)) {
            return null;
        }

        try {
            int[] buildType = { kind };
            PgDbParser parser = PgDbParser.getParserForBuilder(proj, buildType);
            switch (buildType[0]) {
            case IncrementalProjectBuilder.AUTO_BUILD:
            case IncrementalProjectBuilder.INCREMENTAL_BUILD:
                IResourceDelta delta = getDelta(getProject());
                buildIncrement(delta, parser, monitor);
                break;

            case IncrementalProjectBuilder.FULL_BUILD:
                if (!PgDbParser.deserialize(proj.getName(), parser)) {
                    parser.getFullDBFromPgDbProject(proj, monitor);
                }
                break;
            default:
                throw new IllegalStateException("Unknown build type!"); //$NON-NLS-1$
            }
            parser.serialize(proj.getName());
        } catch (InterruptedException ex) {
            throw new OperationCanceledException();
        } catch (IOException | IllegalStateException ex) {
            throw new CoreException(PgDbParser.getLoadingErroStatus(ex));
        } finally {
            // update decorators if any kind of build was run
            PgDecorator.update();
            SubMonitor.done(monitor);
        }
        return new IProject[] { proj };
    }

    @Override
    protected void clean(IProgressMonitor monitor) throws CoreException {
        PgDbParser.clean(this.getProject().getName());
    }

    private void buildIncrement(IResourceDelta delta, PgDbParser parser, IProgressMonitor monitor)
            throws CoreException, InterruptedException, IOException {
        List<IFile> files = new ArrayList<>();
        delta.accept(d -> {
            if (PgUIDumpLoader.isInProject(d)) {
                IResource res = d.getResource();
                if (res.getType() == IResource.FILE) {
                    switch (d.getKind()) {
                    case IResourceDelta.REMOVED:
                    case IResourceDelta.REMOVED_PHANTOM:
                        parser.removePathFromRefs(res.getLocation().toOSString());
                        break;
                    default:
                        files.add((IFile) res);
                        break;
                    }
                }
            }
            return true;
        });
        parser.getObjFromProjFiles(files, monitor);
    }
}
