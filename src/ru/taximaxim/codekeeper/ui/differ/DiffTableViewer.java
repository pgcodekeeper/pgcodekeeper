package ru.taximaxim.codekeeper.ui.differ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;

public class DiffTableViewer extends Composite {

    private TreeElement tree;
    private CheckboxTableViewer viewer;
    
    public DiffTableViewer(Composite parent, int style) {
        super(parent, style);
        final LocalResourceManager lrm = new LocalResourceManager(JFaceResources.getResources(), this);
        GridLayout gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        setLayout(gl);
        
        final Table baseTable = new Table(this, SWT.CHECK | SWT.MULTI
                | SWT.FULL_SELECTION);
        viewer = new CheckboxTableViewer(baseTable);
        viewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
        viewer.getTable().setLinesVisible(true);
        baseTable.setDragDetect(true);
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

        columnType.setLabelProvider(new StyledCellLabelProvider() {

            private final Map<DbObjType, Image> mapObjIcons = new HashMap<>(
                    DbObjType.values().length);
            private final Map<DbObjType, Image> mapContIcons = new HashMap<>(
                    DbObjType.values().length);

            {
                for (DbObjType objType : DbObjType.values()) {
                    ImageDescriptor iObj = ImageDescriptor
                            .createFromURL(Activator
                                    .getContext()
                                    .getBundle()
                                    .getResource(
                                            UIConsts.FILENAME_ICONPGADMIN
                                                    + objType.toString()
                                                            .toLowerCase()
                                                    + ".png"));
                    ImageDescriptor iCont = ImageDescriptor
                            .createFromURL(Activator
                                    .getContext()
                                    .getBundle()
                                    .getResource(
                                            UIConsts.FILENAME_ICONPGADMIN
                                                    + objType.toString()
                                                            .toLowerCase()
                                                    + "s.png"));

                    mapObjIcons.put(objType, lrm.createImage(iObj));
                    mapContIcons.put(objType, lrm.createImage(iCont));
                }
            }

            @Override
            public void update(ViewerCell cell) {
                TreeElement el = (TreeElement) cell.getElement();
                List<StyleRange> styles = new ArrayList<>();

                Image icon = mapObjIcons.get(el.getType());
                String name = el.getType().name();

                StringBuilder label = new StringBuilder(name);

                if (el.getType() == DbObjType.CONTAINER
                        || el.getType() == DbObjType.DATABASE
                        || el.getType() == DbObjType.SCHEMA
                        || el.getType() == DbObjType.TABLE) {
                    label.append(" (").append(el.countChildren()).append(") [")
                            .append(el.countDescendants()).append(']');

                    TextStyle styleGray = new TextStyle();
                    styleGray.foreground = getDisplay().getSystemColor(
                            SWT.COLOR_GRAY);

                    StyleRange styleCount = new StyleRange(styleGray);
                    styleCount.start = name.length();
                    styleCount.length = label.length() - name.length();

                    styles.add(styleCount);
                }

                cell.setText(label.toString());

                cell.setStyleRanges(styles.toArray(new StyleRange[styles.size()]));
                cell.setImage(icon);

                super.update(cell);
            }
        });

        columnChange.setLabelProvider(new StyledCellLabelProvider() {           
            @Override
            public void update(ViewerCell cell) {
                TreeElement el = (TreeElement) cell.getElement();
                Image icon = null;
                String name = "";
                switch (el.getSide()) {
                case BOTH:
                    name = "edit";
                    icon = lrm.createImage(ImageDescriptor.createFromURL(
                            Activator.getContext().getBundle().getResource(
                                    UIConsts.FILENAME_ICONEDIT)));
                    break;
                case LEFT:
                    name = "delete";
                    icon = lrm.createImage(ImageDescriptor.createFromURL(
                            Activator.getContext().getBundle().getResource(
                                    UIConsts.FILENAME_ICONDEL)));
                    break;
                case RIGHT:
                    name = "new";
                    icon = lrm.createImage(ImageDescriptor.createFromURL(
                            Activator.getContext().getBundle().getResource(
                                    UIConsts.FILENAME_ICONADD)));
                    break;
                }
                cell.setText(name);
                cell.setImage(icon);
                super.update(cell);
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

                if ((subtree.getSide() == DiffSide.BOTH && subtree.getParent()
                        .getSide() != DiffSide.BOTH)
                        || subtree.getType() == DbObjType.CONTAINER
                        || subtree.getType() == DbObjType.DATABASE) {
                    return;
                }

                list.add(subtree);
            }
        });

        Composite contButtons = new Composite(this, SWT.NONE);
        contButtons.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        GridLayout contButtonsLayout = new GridLayout(5, false);
        contButtonsLayout.marginWidth = contButtonsLayout.marginHeight = 0;
        contButtons.setLayout(contButtonsLayout);
        
        Button btnSelectAll = new Button(contButtons, SWT.PUSH);
        btnSelectAll.setText("Select all");
        btnSelectAll.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                viewer.setAllChecked(true);
            }
        });
        
        Button btnSelectNone = new Button(contButtons, SWT.PUSH);
        btnSelectNone.setText("Select None");
        btnSelectNone.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                viewer.setAllChecked(false);
            }
        });
        
        Button btnTestFilter = new Button(contButtons, SWT.PUSH);
        btnTestFilter.setText("Test filter");
        btnTestFilter.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                TreeElement x = filterDiffTree();
                System.out.println(x);
            }
        });
        
        
    }

    public void setInput(TreeElement tree) {
        this.tree = tree;
        viewer.setInput(tree);
    }
    
    public TreeElement filterDiffTree() {
        if (tree == null){
            return null;
        }
        Object[] checked = viewer.getCheckedElements();
        TreeElement rootOfCopy = new TreeElement(
                tree.getName(), tree.getType(),
                tree.getContainerType(), tree.getSide());
        for (Object e : checked){
            TreeElement current = (TreeElement)e;
            addToTree(current, rootOfCopy);
        }
        return rootOfCopy;
    }

    private TreeElement addToTree(TreeElement current, TreeElement rootOfCopy) {
        TreeElement parentOfCurrent = findSameInTree(current.getParent(), rootOfCopy);
        if (parentOfCurrent != null){
            TreeElement xxx = new TreeElement(
                    current.getName(), current.getType(),
                    current.getContainerType(), current.getSide());
            parentOfCurrent.addChild(xxx);
            return xxx;
        }else {
            TreeElement hhh = new TreeElement(
                    current.getName(), current.getType(),
                    current.getContainerType(), current.getSide());
            addToTree(current.getParent(), rootOfCopy).addChild(hhh);
            return hhh;
        }
    }
    
    /**
     * walk through the tree, represented as copy root, and find same element, 
     * as target. If found, returns it, otherwise returns null.
     * 
     * @param target
     * @param root
     * @return
     */
    private TreeElement findSameInTree(TreeElement target,  TreeElement root){
        if (root.equals(target)) {
            if ((target.getParent() != null && target.getParent().equals(root.getParent())) || 
                    (target.getParent() == null && root.getParent() == null)){
                return root;
            }
        }
        for (TreeElement child : root.getChildren()) {
            TreeElement e = findSameInTree(target, child);
            if (e != null){
                return e;
            }
        }
        return null;
    }   
}
