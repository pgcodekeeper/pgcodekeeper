package ru.taximaxim.codekeeper.ui.search;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.search.ui.IQueryListener;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.Match;

import ru.taximaxim.codekeeper.ui.Log;

public class ReferenceSearchResultUpdater implements IResourceChangeListener, IQueryListener {

    private final AbstractTextSearchResult result;

    public ReferenceSearchResultUpdater(AbstractTextSearchResult result) {
        this.result = result;
        NewSearchUI.addQueryListener(this);
        ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
    }

    @Override
    public void resourceChanged(IResourceChangeEvent event) {
        IResourceDelta delta = event.getDelta();
        if (delta != null) {
            handleDelta(delta);
        }
    }

    private void handleDelta(IResourceDelta d) {
        try {
            d.accept(delta -> {
                switch (delta.getKind()) {
                case IResourceDelta.ADDED:
                    return false;
                case IResourceDelta.REMOVED:
                    IResource res = delta.getResource();
                    if (res instanceof IFile) {
                        Match[] matches = result.getMatches(res);
                        result.removeMatches(matches);
                    }
                    return true;
                default:
                    return true;
                }
            });
        } catch (CoreException e) {
            Log.log(e);
        }
    }

    @Override
    public void queryRemoved(ISearchQuery query) {
        if (result.equals(query.getSearchResult())) {
            ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
            NewSearchUI.removeQueryListener(this);
        }
    }

    @Override
    public void queryAdded(ISearchQuery query) {
        // no impl
    }

    @Override
    public void queryStarting(ISearchQuery query) {
        // no impl
    }

    @Override
    public void queryFinished(ISearchQuery query) {
        // no impl
    }
}
