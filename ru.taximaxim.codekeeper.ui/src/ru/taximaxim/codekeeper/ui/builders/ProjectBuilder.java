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

import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
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
            PgDbParser parser = PgDbParser.getParserForBuilder(proj, monitor);
            if (parser != null) {
                switch (kind) {
                case IncrementalProjectBuilder.AUTO_BUILD:
                case IncrementalProjectBuilder.INCREMENTAL_BUILD:
                    buildIncrement(getDelta(getProject()), parser, monitor);
                    break;

                case IncrementalProjectBuilder.FULL_BUILD:
                    parser.getFullDBFromPgDbProject(monitor);
                    break;
                default:
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
            SubMonitor.done(monitor);
        }
        return new IProject[] { proj };
    }

    private void buildIncrement(IResourceDelta delta, PgDbParser parser, IProgressMonitor monitor)
            throws CoreException, InterruptedException, IOException, LicenseException {
        List<IFile> files = new ArrayList<>();
        delta.accept(d -> {
            IResource res = d.getResource();
            if (res.getType() == IResource.FILE) {
                files.add((IFile) res);
            }
            return true;
        });

        parser.getObjFromProjFiles(files, monitor);
        parser.notifyListeners();
    }
}
