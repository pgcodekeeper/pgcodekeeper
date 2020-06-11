package ru.taximaxim.codekeeper.ui.search;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.search.ui.text.AbstractTextSearchViewPage;
import org.eclipse.search.ui.text.Match;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class ReferenceResultPage extends AbstractTextSearchViewPage {

    private ReferenceContentProvider provider;

    @Override
    protected void elementsChanged(Object[] objects) {
        provider.inputChanged(getViewer(), null, getInput());
        getViewer().refresh();
    }

    @Override
    protected void clear() {
        // no impl
    }

    @Override
    protected void configureTreeViewer(TreeViewer viewer) {
        viewer.setLabelProvider(new WorkbenchLabelProvider());
        provider = new ReferenceContentProvider(viewer);
        viewer.setContentProvider(provider);
    }

    @Override
    protected void showMatch(Match match, int offset, int length, boolean activate) throws PartInitException {
        IFile file = (IFile) match.getElement();
        IWorkbenchPage page = getSite().getPage();

        if (offset >= 0 && length != 0) {
            openAndSelect(page, file, offset, length, activate);
        } else {
            open(page, file, activate);
        }
    }

    @Override
    protected void configureTableViewer(TableViewer viewer) {
        throw new IllegalStateException("Doesn't support table mode."); //$NON-NLS-1$
    }
}