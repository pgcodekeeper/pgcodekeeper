package ru.taximaxim.codekeeper.ui.differ;

import java.util.ArrayList;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;;

public class DiffTableViewer extends Composite {

    private enum Status {
        NEW, EDIT, DELETE
    }

    private TreeElement tree;
    private CheckboxTableViewer viewer;

    public DiffTableViewer(Composite parent, int style) {
        super(parent, style);
        GridLayout gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        setLayout(gl);
        
        final Table baseTable = new Table(this, SWT.CHECK | SWT.SINGLE
                | SWT.FULL_SELECTION);
        viewer = new CheckboxTableViewer(baseTable);
        viewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
        viewer.getTable().setLinesVisible(true);
        
        TableViewerColumn columnName = new TableViewerColumn(viewer, SWT.LEFT);
        TableViewerColumn columnType = new TableViewerColumn(viewer, SWT.LEFT);
        TableViewerColumn columnChange = new TableViewerColumn(viewer, SWT.LEFT);
        
        columnName.setLabelProvider(new ColumnLabelProvider(){
            @Override
            public String getText(Object element) {
                TreeElement tree = (TreeElement) element;
                return tree.getName();
            }
        });
        
        columnType.setLabelProvider(new ColumnLabelProvider(){
            @Override
            public String getText(Object element) {
                TreeElement tree = (TreeElement) element;
                return tree.getType().name();
            }
            
            public Image getImage(Object element){
                return null;
            }
        });
        
        columnChange.setLabelProvider(new ColumnLabelProvider(){
            @Override
            public String getText(Object element) {
                TreeElement tree = (TreeElement) element;
                String change = "";
                switch (tree.getSide()) {
                case BOTH:
                    change = "edit";
                    break;
                case LEFT:
                    change = "delete";
                    break;
                case RIGHT:
                    change = "new";
                    break;
                }
                return change;
            }
        });
        
        columnName.getColumn().setText("Object name");
        columnName.getColumn().setResizable(true);
        
        columnType.getColumn().setText("Object type");
        columnType.getColumn().setResizable(true);
        
        columnChange.getColumn().setText("Change type");
        columnChange.getColumn().setResizable(true);
        
        columnName.getColumn().pack();
        columnType.getColumn().pack();
        columnChange.getColumn().pack();
        baseTable.setHeaderVisible(true);
        
        viewer.setContentProvider(new IStructuredContentProvider() {

            @Override
            public void dispose() {
                
            }

            @Override
            public void inputChanged(Viewer viewer, Object oldInput,
                    Object newInput) {

            }

            @Override
            public Object[] getElements(Object inputElement) {
                ArrayList<TreeElement> list = new ArrayList<TreeElement>();
                for (TreeElement subtree : ((TreeElement) inputElement).getChildren()) {
                    visit(subtree, list);
                }
                return list.toArray();
            }
            
            private void visit(TreeElement subtree, ArrayList<TreeElement> list) {
                if (subtree.hasChildren()) {
                    for (TreeElement child : subtree.getChildren()) {
                        visit(child, list);
                    }
                }
                if (subtree.getType() != DbObjType.CONTAINER) {
                    list.add(subtree);
                }
            }
        });
    }

    public void setInput(TreeElement tree) {
        this.tree = tree;
        viewer.setInput(tree);
    }
}
