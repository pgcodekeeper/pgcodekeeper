package ru.taximaxim.codekeeper.ui.search;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.text.Match;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class ReferenceSearchQuery implements ISearchQuery {

    private ReferenceSearchResult result;

    private final PgObjLocation ref;
    private final IProject proj;

    public ReferenceSearchQuery(PgObjLocation ref, IProject proj) {
        this.ref = ref;
        this.proj = proj;
    }

    @Override
    public IStatus run(IProgressMonitor monitor) {
        ReferenceSearchResult res = (ReferenceSearchResult) getSearchResult();
        res.removeAll();

        PgDbParser parser = PgDbParser.getParser(proj);
        if (parser != null) {
            List<PgObjLocation> locs = parser.getAllObjReferences().filter(ref::compare).collect(Collectors.toList());
            SubMonitor sub = SubMonitor.convert(monitor, locs.size());
            for (PgObjLocation loc : locs) {
                IFile file = ResourcesPlugin.getWorkspace().getRoot()
                        .getFileForLocation(new Path(loc.getFilePath()));
                if (file != null ) {
                    res.addMatch(new Match(file, loc.getOffset(), loc.getObjLength()));
                }
                sub.worked(1);
            }
        }

        return Status.OK_STATUS;
    }

    public PgObjLocation getReference() {
        return ref;
    }

    @Override
    public String getLabel() {
        return "Searching for '" + ref.getObjName() + '\''; //$NON-NLS-1$
    }

    @Override
    public boolean canRerun() {
        return true;
    }

    @Override
    public boolean canRunInBackground() {
        return true;
    }

    @Override
    public ISearchResult getSearchResult() {
        if (result == null) {
            ReferenceSearchResult r = new ReferenceSearchResult(this);
            new ReferenceSearchResultUpdater(r);
            result = r;
        }

        return result;
    }
}
