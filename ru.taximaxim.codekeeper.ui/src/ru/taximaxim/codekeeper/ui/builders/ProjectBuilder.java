package ru.taximaxim.codekeeper.ui.builders;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;

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
            int[] buildType = { kind };
            PgDbParser parser = PgDbParser.getParserForBuilder(proj, buildType);
            switch (buildType[0]) {
            case IncrementalProjectBuilder.AUTO_BUILD:
            case IncrementalProjectBuilder.INCREMENTAL_BUILD:
                IResourceDelta delta = getDelta(getProject());
                buildIncrement(delta, parser, SubMonitor.convert(monitor, countFiles(delta)));
                break;

            case IncrementalProjectBuilder.FULL_BUILD:
                parser.getFullDBFromPgDbProject(proj,
                        SubMonitor.convert(monitor, PgUIDumpLoader.countFiles(proj)));
                break;
            default:
                throw new IllegalStateException("Unknown build type!"); //$NON-NLS-1$
            }
        } catch (InterruptedException ex) {
            throw new OperationCanceledException();
        } catch (IOException | LicenseException | IllegalStateException ex) {
            throw new CoreException(PgDbParser.getLoadingErroStatus(ex));
        } finally {
            // update decorators if any kind of build was run
            PgDecorator.update();
        }
        return new IProject[] { proj };
    }

    private void buildIncrement(IResourceDelta delta, PgDbParser parser, SubMonitor sub)
            throws CoreException {
        delta.accept(new BuilderDeltaVisitor(sub, parser));
        parser.notifyListeners();
    }

    private int countFiles(IResourceDelta delta) throws CoreException {
        int[] count = new int[] {0};
        delta.accept(new IResourceDeltaVisitor() {

            @Override
            public boolean visit(IResourceDelta delta) throws CoreException {
                if (delta.getResource().getType() == IResource.FILE) {
                    ++count[0];
                }
                return true;
            }
        });
        return count[0];
    }
}

class BuilderDeltaVisitor implements IResourceDeltaVisitor {

    private final SubMonitor sub;
    private final PgDbParser parser;

    public BuilderDeltaVisitor(SubMonitor sub, PgDbParser parser) {
        this.sub = sub;
        this.parser = parser;
    }

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
        if (!PgUIDumpLoader.isProjectPath(delta.getProjectRelativePath())) {
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
}
