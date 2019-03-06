package ru.taximaxim.codekeeper.ui.views;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import ru.taximaxim.codekeeper.apgdiff.fileutils.FileUtils;

public class ResultSetView extends ViewPart {

    private CTabFolder tabFolder;

    @Override
    public void createPartControl(Composite parent) {
        tabFolder = new CTabFolder(parent, SWT.BOTTOM);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        gd.minimumWidth = 700;
        tabFolder.setLayoutData(gd);
    }

    public void addData(List<List<Object>> results) {
        if (results.isEmpty()) {
            return;
        }

        Composite tabComposite = new Composite(tabFolder, SWT.NONE);
        tabComposite.setLayout(new GridLayout());
        tabComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        CTabItem tabItem = new CTabItem(tabFolder, SWT.CLOSE);
        tabItem.setText(FileUtils.getFileDate());
        tabItem.setControl(tabComposite);

        TableViewer viewer = new TableViewer(tabComposite);

        viewer.setContentProvider(ArrayContentProvider.getInstance());
        viewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
        viewer.getTable().setLinesVisible(true);
        viewer.getTable().setHeaderVisible(true);

        List<Object> names = results.get(0);

        TableViewerColumn num = new TableViewerColumn(viewer, SWT.LEFT);
        num.getColumn().setResizable(true);
        num.getColumn().setText("");
        num.setLabelProvider(new RowNumberLabelProvider());
        num.getColumn().setWidth(40);

        for (int i = 0; i < names.size(); i++) {
            TableViewerColumn col = new TableViewerColumn(viewer, SWT.LEFT);
            col.getColumn().setResizable(true);
            col.getColumn().setMoveable(true);
            col.getColumn().setText(names.get(i).toString());
            col.setLabelProvider(new IndexedColumnLabelProvider(i));
            col.getColumn().setWidth(150);
        }

        viewer.setInput(results.subList(1, results.size()));
        tabFolder.setSelection(tabItem);
    }

    @Override
    public void setFocus() {
        tabFolder.setFocus();
    }

    private final class IndexedColumnLabelProvider extends ColumnLabelProvider {
        private final int i;

        private IndexedColumnLabelProvider(int i) {
            this.i = i;
        }

        @Override
        public String getText(Object element) {
            List<?> l = (List<?>) element;
            Object obj = l.get(i);
            return obj == null ? null : obj.toString();
        }
    }

    private final class RowNumberLabelProvider extends ColumnLabelProvider {

        private TableViewer viewer;

        @Override
        protected void initialize(ColumnViewer viewer, ViewerColumn column) {
            super.initialize(viewer, column);
            this.viewer = null;
            if (viewer instanceof TableViewer) {
                this.viewer = (TableViewer) viewer;
            }
        }

        @Override
        public void update(ViewerCell cell) {
            super.update(cell);
            if (viewer != null) {
                int index = Arrays.asList(viewer.getTable().getItems()).indexOf(cell.getItem());
                cell.setText("" + (index + 1));
            }
        }
    }
}
