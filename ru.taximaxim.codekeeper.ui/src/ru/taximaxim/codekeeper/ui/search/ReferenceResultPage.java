package ru.taximaxim.codekeeper.ui.search;

import java.text.MessageFormat;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.search.ui.text.AbstractTextSearchViewPage;
import org.eclipse.search.ui.text.Match;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;

public class ReferenceResultPage extends AbstractTextSearchViewPage {

    private static final String LOCATION_LABEL = "{0}: {1}";

    private ReferenceContentProvider provider;
    private final WorkbenchLabelProvider labelProvider = new WorkbenchLabelProvider();

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
        viewer.setLabelProvider(new LabelProvider() {

            @Override
            public String getText(Object element) {
                if (element instanceof PgObjLocation) {
                    PgObjLocation loc = (PgObjLocation) element;
                    return MessageFormat.format(LOCATION_LABEL,
                            loc.getLineNumber(), loc.getQualifiedName());
                }

                return labelProvider.getText(element);
            }

            @Override
            public Image getImage(Object element) {
                if (element instanceof PgObjLocation) {
                    return Activator.getRegisteredImage(FILE.ICONSEARCHLINE);
                }

                return labelProvider.getImage(element);
            }
        });

        provider = new ReferenceContentProvider();
        viewer.setContentProvider(provider);
        viewer.setComparator(new ViewerComparator() {

            @Override
            public int compare(Viewer viewer, Object e1, Object e2) {
                if (e1 instanceof PgObjLocation && e2 instanceof PgObjLocation) {
                    int x = ((PgObjLocation) e1).getOffset();
                    int y = ((PgObjLocation) e2).getOffset();
                    return Integer.compare(x, y);
                }

                return super.compare(viewer, e1, e2);
            }
        });
    }

    @Override
    protected void showMatch(Match match, int offset, int length, boolean activate) throws PartInitException {
        PgObjLocation loc = (PgObjLocation) match.getElement();

        IFile file = ResourcesPlugin.getWorkspace().getRoot()
                .getFileForLocation(new Path(loc.getFilePath()));

        if (file == null) {
            return;
        }

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