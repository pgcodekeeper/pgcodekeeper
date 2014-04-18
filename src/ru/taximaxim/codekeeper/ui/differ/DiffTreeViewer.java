package ru.taximaxim.codekeeper.ui.differ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
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

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.copiedclasses.CheckedTreeViewer;

public class DiffTreeViewer extends Composite {

    public TreeElement tree;
    final public CheckedTreeViewer viewer;
    
    final private Button btnDebugView;
    
    private LocalResourceManager lrm;
    
    private String subTreeLeft, subTreeRight, subTreeBoth;
    
    public DiffTreeViewer(Composite parent, int style) {
        super(parent, style);
        
        GridLayout gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        setLayout(gl);
        
        this.lrm = new LocalResourceManager(JFaceResources.getResources(), this);
        
        viewer = new CheckedTreeViewer(this);
        viewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
        
        viewer.setContentProvider(new ITreeContentProvider() {
            
            @Override
            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            }
            
            @Override
            public void dispose() {
            }
            
            @Override
            public boolean hasChildren(Object element) {
                return ((TreeElement) element).hasChildren();
            }
            
            @Override
            public Object getParent(Object element) {
                return ((TreeElement) element).getParent();
            }
            
            @Override
            public Object[] getElements(Object inputElement) {
                return ((TreeElement) inputElement).getChildren().toArray();
            }
            
            @Override
            public Object[] getChildren(Object parentElement) {
                return getElements(parentElement);
            }
        });
        viewer.setLabelProvider(new StyledCellLabelProvider() {
            
            private final Map<DbObjType, Image> mapObjIcons =
                    new HashMap<>(DbObjType.values().length);
            private final Map<DbObjType, Image> mapContIcons = 
                    new HashMap<>(DbObjType.values().length);
            
            {
                for(DbObjType objType : DbObjType.values()) {
                    ImageDescriptor iObj = ImageDescriptor.createFromURL(
                            Activator.getContext().getBundle().getResource(
                                    UIConsts.FILENAME_ICONPGADMIN
                                    + objType.toString().toLowerCase()
                                    + ".png"));
                    ImageDescriptor iCont = ImageDescriptor.createFromURL(
                            Activator.getContext().getBundle().getResource(
                                    UIConsts.FILENAME_ICONPGADMIN
                                    + objType.toString().toLowerCase()
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
                String name = null;
                
                if(el.getType() == DbObjType.CONTAINER
                        && el.getContainerType() == DbObjType.CONTAINER) {
                    switch(el.getSide()) {
                    case LEFT:
                        name = subTreeLeft;
                        break;
                    case RIGHT:
                        name = subTreeRight;
                        break;
                    case BOTH:
                        name = subTreeBoth;
                        break;
                    }
                }
                if(name == null) {
                    name = el.getName();
                }
                
                if(btnDebugView.getSelection()) {
                    cell.setText(String.format("%s:%s:%s",
                            el.getType(), name, el.getSide()));
                } else {
                    StringBuilder label = new StringBuilder(name);
                    
                    if(el.getType() == DbObjType.CONTAINER 
                            || el.getType() == DbObjType.DATABASE
                            || el.getType() == DbObjType.SCHEMA
                            || el.getType() == DbObjType.TABLE) {
                        label.append(" (")
                            .append(el.countChildren())
                            .append(") [")
                            .append(el.countDescendants())
                            .append(']');
                        
                        TextStyle styleGray = new TextStyle();
                        styleGray.foreground = getDisplay().getSystemColor(
                                SWT.COLOR_GRAY);
                        
                        StyleRange styleCount = new StyleRange(styleGray);
                        styleCount.start = name.length();
                        styleCount.length = label.length() - name.length();
                        
                        styles.add(styleCount);
                        
                        if(el.getType() == DbObjType.CONTAINER) {
                            icon = mapContIcons.get(el.getContainerType());
                        }
                    }
                    
                    if(el.getSide() == DiffSide.BOTH
                            && el.getParent().getSide() != DiffSide.BOTH) {
                        TextStyle styleDarkGray = new TextStyle();
                        styleDarkGray.foreground = getDisplay().getSystemColor(
                                SWT.COLOR_DARK_GRAY);
                        
                        StyleRange styleUnaltered = new StyleRange(styleDarkGray);
                        styleUnaltered.start = 0;
                        styleUnaltered.length = name.length();
                        
                        styles.add(styleUnaltered);
                    }
                    
                    cell.setText(label.toString());
                }
                
                cell.setStyleRanges(styles.toArray(new StyleRange[styles.size()]));
                cell.setImage(icon);
                
                super.update(cell);
            }
        });
        
        viewer.addDoubleClickListener(new IDoubleClickListener() {
            
            @Override
            public void doubleClick(DoubleClickEvent event) {
                TreePath path = ((TreeSelection) event.getSelection()).getPaths()[0];
                TreeViewer viewer = (TreeViewer) event.getViewer();
                viewer.setExpandedState(path, !viewer.getExpandedState(path));
                viewer.refresh();
            }
        });
        
        MenuManager menuMgr = new MenuManager();
        menuMgr.add(new Action("Select Subtree") {
            @Override
            public void run() {
                TreeElement el = (TreeElement) ((TreeSelection) viewer.getSelection())
                        .getFirstElement();
                viewer.setSubtreeChecked(el, true);
            }
        });
        menuMgr.add(new Action("Deselect Subtree") {
            @Override
            public void run() {
                TreeElement el = (TreeElement) ((TreeSelection) viewer.getSelection())
                        .getFirstElement();
                viewer.setSubtreeChecked(el, false);
            }
        });
        menuMgr.add(new Separator());
        menuMgr.add(new Action("Expand Subtree") {
            @Override
            public void run() {
                TreePath path = ((TreeSelection) viewer.getSelection()).getPaths()[0];
                viewer.expandToLevel(path, TreeViewer.ALL_LEVELS);
            }
        });
        menuMgr.add(new Action("Collapse Subtree") {
            @Override
            public void run() {
                TreePath path = ((TreeSelection) viewer.getSelection()).getPaths()[0];
                viewer.collapseToLevel(path, TreeViewer.ALL_LEVELS);
            }
        });
        menuMgr.addMenuListener(new IMenuListener() {
            
            @Override
            public void menuAboutToShow(IMenuManager manager) {
                boolean enable = !viewer.getSelection().isEmpty();
                for(IContributionItem item : manager.getItems()) {
                    if(item instanceof ActionContributionItem) {
                        ((ActionContributionItem) item).getAction().setEnabled(enable);
                    }
                }
            }
        });
        
        viewer.getControl().setMenu(menuMgr.createContextMenu(viewer.getControl()));
        
        Composite contButtons = new Composite(this, SWT.NONE);
        contButtons.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        GridLayout contButtonsLayout = new GridLayout(5, false);
        contButtonsLayout.marginWidth = contButtonsLayout.marginHeight = 0;
        contButtons.setLayout(contButtonsLayout);
        
        Button btnSelectAll = new Button(contButtons, SWT.PUSH);
        btnSelectAll.setText("Select All");
        btnSelectAll.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                TreeElement root = (TreeElement) viewer.getInput();
                if(root != null) {
                    for(TreeElement sub : root.getChildren()) {
                        viewer.setSubtreeChecked(sub, true);
                    }
                }
            }
        });
        
        Button btnSelectNone = new Button(contButtons, SWT.PUSH);
        btnSelectNone.setText("Select None");
        btnSelectNone.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                TreeElement root = (TreeElement) viewer.getInput();
                if(root != null) {
                    for(TreeElement sub : root.getChildren()) {
                        viewer.setSubtreeChecked(sub, false);
                    }
                }
            }
        });
        
        Button btnExpandAll = new Button(contButtons, SWT.PUSH);
        btnExpandAll.setText("Expand All");
        btnExpandAll.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                viewer.expandAll();
            }
        });
        
        Button btnCollapseAll = new Button(contButtons, SWT.PUSH);
        btnCollapseAll.setText("Collapse All");
        btnCollapseAll.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                viewer.collapseAll();
            }
        });
        
        btnDebugView = new Button(contButtons, SWT.CHECK);
        btnDebugView.setText("Debug view");
        btnDebugView.setLayoutData(new GridData(
                GridData.HORIZONTAL_ALIGN_END | GridData.FILL_HORIZONTAL));
        btnDebugView.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                viewer.refresh();
            }
        });
    }
    
    public void setTreeInput(TreeElement tree) {
        this.tree = tree;
        viewer.setInput(tree);
    }
    
    public void setSubtreeNames(String subTreeLeft, String subTreeRight,
            String subTreeBoth) {
        this.subTreeLeft = subTreeLeft;
        this.subTreeRight = subTreeRight;
        this.subTreeBoth = subTreeBoth;
        
        viewer.refresh();
    }
    
    /**
     * Recursively copy only selected tree elements into a new tree
     */
    public TreeElement filterDiffTree() {
        if (tree == null) {
            return null;
        }
        
        Log.log(Log.LOG_INFO, "Filtering diff tree based on GUI selection");
        
        return filterDiffTree(tree);
    }
    
    // TODO move away from using GUI logic and use TreeElement.getFilteredCopy instead
    private TreeElement filterDiffTree(TreeElement tree) {
        if(tree.getType() != DbObjType.CONTAINER 
                && !viewer.getChecked(tree)
                && !viewer.getGrayed(tree)) {
            // skip unselected non-root nodes and all their children
            return null;
        }
        
        TreeElement copy = new TreeElement(
                tree.getName(), tree.getType(),
                tree.getContainerType(), tree.getSide());
        
        for(TreeElement sub : tree.getChildren()) {
            TreeElement subCopy = filterDiffTree(sub);
            if(subCopy != null) {
                copy.addChild(subCopy);
            }
        }
        return copy;
    }
}
