package ru.taximaxim.codekeeper.ui.search;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.text.Match;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgDbParser;

public class ReferenceSearchQuery implements ISearchQuery {

    private final ReferenceSearchResult result;

    private final PgObjLocation ref;
    private final IProject proj;

    public ReferenceSearchQuery(PgObjLocation ref, IProject proj) {
        this.result = new ReferenceSearchResult(this);
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
                res.addMatch(new Match(loc, loc.getOffset(), loc.getObjLength()));
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
        return "Searching for '" + ref.getQualifiedName() + '\''; //$NON-NLS-1$
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
        return result;
    }
}
