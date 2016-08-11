package ru.taximaxim.codekeeper.ui.builders;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;
import ru.taximaxim.codekeeper.ui.prefs.LicensePrefs;

public class ProjectBuilder extends IncrementalProjectBuilder {

    @Override
    protected IProject[] build(int kind, Map<String, String> args,
            IProgressMonitor monitor) throws CoreException {
        IProject proj = getProject();
        if (!proj.hasNature(NATURE.ID)) {
            return null;
        }
        PgDbParser parser = null;
        try {
            parser = PgDbParser.getParserForBuilder(proj, monitor);
        } catch (InterruptedException ex) {
            // cancelled
        } catch (IOException | LicenseException ex) {
            throw new CoreException(PgDbParser.getLoadingErroStatus(ex));
        }

        // parser loaded from scratch or cancelled in the process
        // no futher changes to load
        if (parser == null) {
            return new IProject[] { proj };
        }

        switch (kind) {
        case IncrementalProjectBuilder.AUTO_BUILD:
        case IncrementalProjectBuilder.INCREMENTAL_BUILD:
            IResourceDelta delta = getDelta(getProject());
            buildIncrement(delta, parser, monitor);
            break;

        case IncrementalProjectBuilder.FULL_BUILD:
            try {
                parser.getObjFromProject(monitor);
            } catch (InterruptedException ex) {
                // cancelled
            } catch (IOException | LicenseException ex) {
                throw new CoreException(PgDbParser.getLoadingErroStatus(ex));
            }
            break;
        }
        return new IProject[] { proj };
    }

    private void buildIncrement(IResourceDelta delta, final PgDbParser parser,
            IProgressMonitor monitor) throws CoreException {
        final AtomicInteger count = new AtomicInteger();
        delta.accept(new IResourceDeltaVisitor() {

            @Override
            public boolean visit(IResourceDelta delta) throws CoreException {
                if (delta.getResource() instanceof IFile) {
                    count.incrementAndGet();
                }
                return true;
            }
        });
        final SubMonitor sub = SubMonitor.convert(monitor, count.get());

        delta.accept(new IResourceDeltaVisitor() {

            @Override
            public boolean visit(IResourceDelta delta) throws CoreException {
                if (sub.isCanceled()) {
                    return false;
                }
                if (!(delta.getResource() instanceof IFile)) {
                    return true;
                }
				PgDiffArguments args = new PgDiffArguments();
                sub.worked(1);

                switch (delta.getKind()) {
                case IResourceDelta.REMOVED:
                case IResourceDelta.REMOVED_PHANTOM:
                case IResourceDelta.REPLACED:
                    parser.removePathFromRefs(Paths.get(delta.getResource().getLocationURI()));
                    break;
				case IResourceDelta.CHANGED:
					IFile iFile = (IFile) delta.getResource();

					iFile.deleteMarkers(null, false, IResource.DEPTH_INFINITE);
					try {
						LicensePrefs.setLicense(args);
						PgDumpLoader dumpLoader = new PgDumpLoader(iFile.getContents(),
								delta.getResource().getLocation().toOSString(), args);
						dumpLoader.load(true);
						dumpLoader.close();
						for (AntlrError antlrError : dumpLoader.getErrors()) {
							IMarker marker = iFile.createMarker(UIConsts.MARKER.ID);
							marker.setAttribute(IMarker.LINE_NUMBER, antlrError.getLine());
							marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
							marker.setAttribute(IMarker.MESSAGE, antlrError.getMsg());
						}
					} catch (IOException | LicenseException | InterruptedException ex) {
						throw new CoreException(PgDbParser.getLoadingErroStatus(ex));
					}
					break;
                default:
                    try {
                        parser.getObjFromProjFile(
                                delta.getResource().getLocationURI(), sub);
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
