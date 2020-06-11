package ru.taximaxim.codekeeper.ui.search;

import java.text.MessageFormat;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.IEditorMatchAdapter;
import org.eclipse.search.ui.text.IFileMatchAdapter;
import org.eclipse.search.ui.text.Match;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.ResourceUtil;

import ru.taximaxim.codekeeper.ui.sqledit.SQLEditor;

public class ReferenceSearchResult extends AbstractTextSearchResult implements IEditorMatchAdapter, IFileMatchAdapter {

    private static final String RESULT_LABEL = "''{0}'' - {1} matches";

    private static final Match[] EMPTY_ARRAY= new Match[0];

    private final ReferenceSearchQuery query;

    public ReferenceSearchResult(ReferenceSearchQuery query) {
        this.query = query;
    }

    @Override
    public String getLabel() {
        return MessageFormat.format(RESULT_LABEL, query.getReference().getObjName(), getMatchCount());
    }

    @Override
    public String getTooltip() {
        return getLabel();
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return null;
    }

    @Override
    public ISearchQuery getQuery() {
        return query;
    }

    @Override
    public IEditorMatchAdapter getEditorMatchAdapter() {
        return this;
    }

    @Override
    public IFileMatchAdapter getFileMatchAdapter() {
        return this;
    }

    @Override
    public Match[] computeContainedMatches(AbstractTextSearchResult result, IFile file) {
        return result.getMatches(file);
    }

    @Override
    public IFile getFile(Object element) {
        if (element instanceof IFile) {
            return (IFile) element;
        }
        return null;
    }

    @Override
    public boolean isShownInEditor(Match match, IEditorPart editor) {
        if (editor instanceof SQLEditor) {
            IFile file = (IFile) match.getElement();
            IFile res = ResourceUtil.getFile(editor.getEditorInput());
            return file.equals(res);
        }

        return false;
    }

    @Override
    public Match[] computeContainedMatches(AbstractTextSearchResult result, IEditorPart editor) {
        IFile file = ResourceUtil.getFile(editor.getEditorInput());
        if (file != null) {
            return getMatches(file);
        }

        return EMPTY_ARRAY;
    }
}
