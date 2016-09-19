package ru.taximaxim.codekeeper.ui.builders;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
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
            SubMonitor m = SubMonitor.convert(monitor, PgUIDumpLoader.countFiles(proj));
            PgDbParser parser = PgDbParser.getParserForBuilder(proj, m);
            if (parser != null) {
                switch (kind) {
                case IncrementalProjectBuilder.AUTO_BUILD:
                case IncrementalProjectBuilder.INCREMENTAL_BUILD:
                    buildIncrement(getDelta(getProject()), parser, m);
                    break;

                case IncrementalProjectBuilder.FULL_BUILD:
                    parser.getObjFromProject(m);
                    break;
                }
            }
        } catch (InterruptedException ex) {
            throw new OperationCanceledException();
        } catch (IOException | LicenseException ex) {
            throw new CoreException(PgDbParser.getLoadingErroStatus(ex));
        } finally {
            // update decorators if any kind of build was run
            PgDecorator.update();
        }
        return new IProject[] { proj };
    }

    private void buildIncrement(IResourceDelta delta, final PgDbParser parser,
            IProgressMonitor monitor) throws CoreException {
        final AtomicInteger count = new AtomicInteger();
        delta.accept(new IResourceDeltaVisitor() {

            @Override
            public boolean visit(IResourceDelta delta) throws CoreException {
                if (delta.getResource().getType() == IResource.FILE) {
                    count.incrementAndGet();
                }
                return true;
            }
        });
        final SubMonitor sub = SubMonitor.convert(monitor, count.get());

        ApgdiffConsts.WORK_DIR_NAMES[] dirs = ApgdiffConsts.WORK_DIR_NAMES.values();
        final IPath[] projDirs = new IPath[dirs.length];
        for (int i = 0; i < dirs.length; ++i) {
            projDirs[i] = getProject().getFullPath().append(dirs[i].name());
        }
        delta.accept(new IResourceDeltaVisitor() {

            @Override
            public boolean visit(IResourceDelta delta) throws CoreException {
                if (sub.isCanceled()) {
                    return false;
                }
                if (delta.getResource().getType() != IResource.FILE) {
                    return true;
                }
                sub.worked(1);

                // check that it's our resource
                boolean projResource = false;
                for (IPath dir : projDirs) {
                    if (dir.isPrefixOf(delta.getFullPath())) {
                        projResource = true;
                        break;
                    }
                }
                if (!projResource) {
                    return true;
                }

                switch (delta.getKind()) {
                case IResourceDelta.REMOVED:
                case IResourceDelta.REMOVED_PHANTOM:
                    parser.removePathFromRefs(delta.getResource().getLocation().toOSString());
                    break;
                default:
                    try {
                        parser.getObjFromProjFile((IFile) delta.getResource(), sub);
                    } catch (InterruptedException e) {
                        // cancelled
                        return false;
                    } catch (IOException | LicenseException ex) {
                        throw new CoreException(PgDbParser.getLoadingErroStatus(ex));
                    }
                    break;
                }
                return true;
            }
        });
        parser.notifyListeners();
    }
}
