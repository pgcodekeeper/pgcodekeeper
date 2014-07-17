package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.xml.sax.SAXException;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.XmlStringList;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.IgnoredObjectsPrefPage;

/*
 * Call CheckStateListener.updateCountLabels() when programmatically changing 
 * elements' checked state. 
 */
public class DiffTableViewer extends Composite {

    private final IgnoresChangeListener ignoresListener = new IgnoresChangeListener();
    private final CheckStateListener checkListener = new CheckStateListener();

    private final TableViewerComparator comparator = new TableViewerComparator();
    
    private final LocalResourceManager lrm;
    
    private TreeElement tree;
    public final CheckboxTableViewer viewer;
    private TableViewerColumn columnCheck, columnType, columnChange, columnName, columnLocation;
    private Label lblObjectCount;
    private Label lblCheckedCount;
    
    private List<String> ignoredElements;
    private PgDatabase dbSource;
    private PgDatabase dbTarget;

    private Text txtFilterName;
    private ViewerFilter[] viewerFilters = new ViewerFilter[1];
    
    private HashSet<TreeElement> checkedElementsHash = new HashSet<TreeElement>();
    
    enum Columns {
        CHECK,
        NAME,
        TYPE, 
        CHANGE,
        LOCATION
    }
    
    public DiffTableViewer(Composite parent, int style, final IPreferenceStore mainPrefs) {
        super(parent, style);

        lrm = new LocalResourceManager(JFaceResources.getResources(), this);
        GridLayout gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        setLayout(gl);

        txtFilterName = new Text(this, SWT.BORDER | SWT.SEARCH | SWT.ICON_SEARCH);
        txtFilterName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtFilterName.setMessage(Messages.diffTableViewer_object_name);
        txtFilterName.addModifyListener(new ModifyListener() {
            
            @Override
            public void modifyText(ModifyEvent e) {
                ((TableViewerFilter)viewerFilters[0]).setFilteName(txtFilterName.getText());
                viewerRefresh();
            }
        });
        
        viewer = new CheckboxTableViewer(new Table(this, SWT.CHECK | SWT.MULTI
                | SWT.FULL_SELECTION | SWT.BORDER));
        viewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
        viewer.getTable().setLinesVisible(true);  
        viewer.getTable().setHeaderVisible(true);
        viewer.getControl().setMenu(getViewerMenu().createContextMenu(viewer.getControl()));     
        
        viewer.setComparator(comparator);
        
        viewerFilters[0] = new TableViewerFilter();
        viewer.setFilters(viewerFilters);
        
        initColumns();

        viewer.addCheckStateListener(checkListener);
        viewer.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent e) {
                TreeElement el = (TreeElement) ((IStructuredSelection) e
                        .getSelection()).getFirstElement();
                if (el != null) {
                    viewer.setChecked(el, !viewer.getChecked(el));                    
                    checkListener.setElementToHashUpdateLabels(el, !viewer.getChecked(el));
                }
            }
        });

        viewer.setContentProvider(new IStructuredContentProvider() {
            @Override
            public void dispose() {
            }

            @Override
            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            }

            @Override
            public Object[] getElements(Object inputElement) {
                ArrayList<TreeElement> list = new ArrayList<>();
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

                if ((subtree.getSide() == DiffSide.BOTH && subtree.getParent().getSide() != DiffSide.BOTH)
                        || subtree.getType() == DbObjType.CONTAINER
                        || subtree.getType() == DbObjType.DATABASE
                        || (subtree.getSide() == DiffSide.BOTH && 
                                subtree.getPgStatement(dbSource).compare(subtree.getPgStatement(dbTarget)))) {
                    return;
                }
                // Do not add elements, which contain in ignore list
                if (!ignoredElements.contains(subtree.getName())) {
                    list.add(subtree);
                }
            }
        });
        
        viewer.setCheckStateProvider(new ICheckStateProvider() {

            @Override
            public boolean isChecked(Object element) {
                return checkedElementsHash.contains(element);
            }

            @Override
            public boolean isGrayed(Object element) {
                // TODO Auto-generated method stub
                return false;
            }
            
        });
        Composite contButtons = new Composite(this, SWT.NONE);
        contButtons.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        GridLayout contButtonsLayout = new GridLayout(5, false);
        contButtonsLayout.marginWidth = contButtonsLayout.marginHeight = 0;
        contButtons.setLayout(contButtonsLayout);
        
        Button btnSelectAll = new Button(contButtons, SWT.PUSH);
        btnSelectAll.setText(Messages.select_all);
        btnSelectAll.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                viewer.setAllChecked(true);
                checkListener.setElementsToHashUpdateLabels(viewer.getCheckedElements(), true);
            }
        });
        
        Button btnSelectNone = new Button(contButtons, SWT.PUSH);
        btnSelectNone.setText(Messages.select_none);
        btnSelectNone.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                checkListener.setElementsToHashUpdateLabels(viewer.getCheckedElements(), false);
                viewer.setAllChecked(false);
            }
        });
        
        Button bntClearSort = new Button(contButtons, SWT.PUSH);
        bntClearSort.setText(Messages.diffTableViewer_reset_sorting);
        bntClearSort.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                comparator.clearSortList();
                sortViewer(columnName.getColumn(), Columns.NAME);
            }
        });
        
        lblCheckedCount = new Label(contButtons, SWT.RIGHT);
        lblCheckedCount.setLayoutData(new GridData(SWT.RIGHT, SWT.DEFAULT, true, false));
        
        lblObjectCount = new Label(contButtons, SWT.RIGHT);
        lblObjectCount.setLayoutData(new GridData(SWT.RIGHT, SWT.DEFAULT, false, false));

        mainPrefs.addPropertyChangeListener(ignoresListener);
        viewer.getTable().addDisposeListener(new DisposeListener() {
            
            @Override
            public void widgetDisposed(DisposeEvent e) {
                mainPrefs.removePropertyChangeListener(ignoresListener);
            }
        });
        
        String ignoredObjectsPref = mainPrefs.getString(UIConsts.PREF_IGNORE_OBJECTS);
        if (!ignoredObjectsPref.isEmpty()) {
            ignoresListener.propertyChange(new PropertyChangeEvent(
                    mainPrefs, UIConsts.PREF_IGNORE_OBJECTS, null, ignoredObjectsPref));
        } else {
            ignoredElements = new LinkedList<>();
        }
    }

    private void initColumns() {
        columnCheck = new TableViewerColumn(viewer, SWT.LEFT);
        columnType = new TableViewerColumn(viewer, SWT.LEFT);
        columnChange = new TableViewerColumn(viewer, SWT.LEFT);
        columnName = new TableViewerColumn(viewer, SWT.LEFT);
        columnLocation = new TableViewerColumn(viewer, SWT.LEFT);
        
        columnName.getColumn().setText(Messages.diffTableViewer_object_name);
        columnName.getColumn().setResizable(true);
        columnName.getColumn().setMoveable(true);
        
        columnType.getColumn().setText(Messages.diffTableViewer_object_type);
        columnType.getColumn().setResizable(true);
        columnType.getColumn().setMoveable(true);
        
        columnChange.getColumn().setText(Messages.diffTableViewer_change_type);
        columnChange.getColumn().setResizable(true);
        columnChange.getColumn().setMoveable(true);
        
        columnCheck.getColumn().setResizable(false);
        columnCheck.getColumn().setText(" "); //$NON-NLS-1$
        columnCheck.getColumn().setMoveable(true);

        columnLocation.getColumn().setResizable(false);
        columnLocation.getColumn().setText(Messages.diffTableViewer_container);
        columnLocation.getColumn().setMoveable(true);
        
        columnName.getColumn().addSelectionListener(
                getHeaderSelectionAdapter(columnName.getColumn(), Columns.NAME));
        columnType.getColumn().addSelectionListener(
                getHeaderSelectionAdapter(columnType.getColumn(), Columns.TYPE));
        columnCheck.getColumn().addSelectionListener(
                getHeaderSelectionAdapter(columnCheck.getColumn(), Columns.CHECK));
        columnChange.getColumn().addSelectionListener(
                getHeaderSelectionAdapter(columnChange.getColumn(), Columns.CHANGE));
        columnLocation.getColumn().addSelectionListener(
                getHeaderSelectionAdapter(columnLocation.getColumn(), Columns.LOCATION));
        
        for (TableColumn c : viewer.getTable().getColumns()){
            c.pack();
        }
        
        columnCheck.setLabelProvider(new ColumnLabelProvider(){
            
            @Override
            public String getText(Object element) {
                return " "; //$NON-NLS-1$
            }
        });
        
        columnName.setLabelProvider(new ColumnLabelProvider(){
            
            @Override
            public String getText(Object element) {
                return ((TreeElement) element).getName();
            }
        });

        columnType.setLabelProvider(new ColumnLabelProvider() {

            private final Map<DbObjType, Image> mapObjIcons = new HashMap<>(
                    DbObjType.values().length);

            {
                for (DbObjType objType : DbObjType.values()) {
                    ImageDescriptor iObj = ImageDescriptor
                            .createFromURL(Activator
                                    .getContext()
                                    .getBundle()
                                    .getResource(
                                            UIConsts.FILENAME_ICONPGADMIN
                                                    + objType.toString().toLowerCase()
                                                    + ".png")); //$NON-NLS-1$
                    mapObjIcons.put(objType, lrm.createImage(iObj));
                }
            }

            @Override
            public String getText(Object element) {
                return ((TreeElement) element).getType().toString();
            }
            
            @Override
            public Image getImage(Object element) {
                return mapObjIcons.get(((TreeElement) element).getType());
            }
        });

        columnChange.setLabelProvider(new ColumnLabelProvider() {
            
            private Image both = 
                    lrm.createImage(ImageDescriptor.createFromURL(
                            Activator.getContext().getBundle().getResource(
                                    UIConsts.FILENAME_ICONEDIT)));
            private Image left = 
                    lrm.createImage(ImageDescriptor.createFromURL(
                            Activator.getContext().getBundle().getResource(
                                    UIConsts.FILENAME_ICONDEL)));
            private Image right = 
                    lrm.createImage(ImageDescriptor.createFromURL(
                            Activator.getContext().getBundle().getResource(
                                    UIConsts.FILENAME_ICONADD)));
            
            @Override
            public String getText(Object element) {
                return ((TreeElement) element).getSide().toString();
            }
            
            @Override
            public Image getImage(Object element) {
                switch (((TreeElement) element).getSide()) {
                case BOTH: return both;
                case LEFT: return left;
                case RIGHT: return right;
                }
                return null;
            }
        });
        
        columnLocation.setLabelProvider(new ColumnLabelProvider() {
            
            @Override
            public String getText(Object element) {
                return getLocationColumnText(element);
            }
        });
        
        viewer.getTable().setSortColumn(columnName.getColumn());
        viewer.getTable().setSortDirection(SWT.UP);
    }

    private String getLocationColumnText(Object element) {
        TreeElement e = (TreeElement) element;
        if (e.getType() == DbObjType.EXTENSION || e.getType() == DbObjType.SCHEMA){
            return ""; //$NON-NLS-1$
        }
        String path = null;
        TreeElement parent = e.getParent();
        while(parent != null){
            if (parent.getType() == DbObjType.CONTAINER || 
                    parent.getType() == DbObjType.DATABASE){
                parent = parent.getParent();
                continue;
            }
            if (path == null){
                path = PgDiffUtils.getQuotedName(parent.getName(), true);
            } else {
                path = PgDiffUtils.getQuotedName(parent.getName(), true) + 
                        "." + path; //$NON-NLS-1$
            }
            parent = parent.getParent();
        }
        return path;
    }
    
    private SelectionAdapter getHeaderSelectionAdapter(final TableColumn column,
            final Columns index) {
        SelectionAdapter selectionAdapter = new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                sortViewer(column, index);
            }            
        };
        return selectionAdapter;
    }
    
    private void sortViewer(final TableColumn column, final Columns index) {
        comparator.addSort(index);
        
        viewer.refresh();
        
        viewer.getTable().setSortDirection(comparator.getSwtDirection());
        viewer.getTable().setSortColumn(column);
    }
    
    public void setInput(TreeDiffer treediffer) {
        this.tree = (treediffer == null) ? null : treediffer.getDiffTree();
        this.dbSource = (treediffer == null) ? null : treediffer.getDbSource().getDbObject();
        this.dbTarget = (treediffer == null) ? null : treediffer.getDbTarget().getDbObject();
        viewer.setInput(this.tree);
        
        int widthOfColumns = 0;
        for (TableColumn c : viewer.getTable().getColumns()){
            c.pack();
            widthOfColumns += c.getWidth();
        }
        columnName.getColumn().setWidth(widthOfColumns-viewer.getTable().getSize().x);
        
        lblObjectCount.setText(Messages.diffTableViewer_objects
                + viewer.getTable().getItemCount());
        lblObjectCount.getParent().layout();
        
        initialSorting();
    }
    
    private void initialSorting() {
        comparator.clearSortList();
        sortViewer(columnName.getColumn(), Columns.NAME);
        sortViewer(columnChange.getColumn(), Columns.CHANGE);
        sortViewer(columnType.getColumn(), Columns.TYPE);
        sortViewer(columnLocation.getColumn(), Columns.LOCATION);
    } 
    
    private void viewerRefresh() {
        viewer.refresh();
        
        lblObjectCount.setText(Messages.diffTableViewer_objects
                + viewer.getTable().getItemCount());
        lblObjectCount.getParent().layout();
        checkListener.setElementsToHashUpdateLabels(viewer.getCheckedElements(), true);
    }
    
    public TreeElement filterDiffTree() {
        if (tree == null){
            return null;
        }
        
        Log.log(Log.LOG_INFO, Messages.diffTableViewer_filtering_diff_tree_based_on_gui_selection);
        
        Object[] checked = viewer.getCheckedElements();
        Set<TreeElement> checkedSet = new HashSet<>(checked.length);
        
        for (Object o : checked) {
            if (!checkedSet.add((TreeElement) o)) {
                throw new IllegalStateException(
                        Messages.diffTableViewer_tried_to_add_equal_elements_to_checkedset);
            }
        }
        
        return tree.getFilteredCopy(checkedSet);
    }
    
    class IgnoresChangeListener implements IPropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent event) {
            if (event.getProperty().equals(UIConsts.PREF_IGNORE_OBJECTS)
                    && !event.getNewValue().equals(event.getOldValue())) {
                XmlStringList xml = new XmlStringList(
                        IgnoredObjectsPrefPage.IGNORED_OBJS_TAG,
                        IgnoredObjectsPrefPage.IGNORED_OBJS_ELEMENT);
                try {
                    ignoredElements = xml.deserialize(
                            new StringReader((String) event.getNewValue()));
                } catch (IOException | SAXException ex) {
                    throw new IllegalStateException(ex);
                }
                viewerRefresh();
            }
        }
    }

    private MenuManager getViewerMenu() {
        MenuManager menuMgr = new MenuManager();
        menuMgr.add(new Action(Messages.diffTableViewer_select_child_elements) {
            
            @Override
            public void run() {
                TreeElement el = (TreeElement)((IStructuredSelection)viewer.getSelection())
                        .getFirstElement();
                if (el != null) {
                    setSubTreeChecked(el, true);
                }
            }
        });
        menuMgr.add(new Action(Messages.diffTableViewer_deselect_child_elements) {
            
            @Override
            public void run() {
                TreeElement el = (TreeElement)((IStructuredSelection)viewer.getSelection())
                        .getFirstElement();
                if (el != null) {
                    setSubTreeChecked(el, false);
                }
            }
        });
        return menuMgr;
    }
    
    private void setSubTreeChecked(TreeElement element, boolean selected) {
        viewer.setChecked(element, selected);
        
        checkListener.setElementToHashUpdateLabels(element, selected);
        
        for (TreeElement child : element.getChildren()) {
            setSubTreeChecked(child, selected);
        }
    }
    
    private class CheckStateListener implements ICheckStateListener {
        
        @Override
        public void checkStateChanged(CheckStateChangedEvent event) {
            setElementToHashUpdateLabels((TreeElement)event.getElement(), event.getChecked());
        }
        
        void setElementsToHashUpdateLabels(Object[] elements, boolean state) {
            for (Object element : elements) {
                setElementToHash((TreeElement)element, state);
            }
            updateCountLabels();
        }
        
        void setElementToHashUpdateLabels(TreeElement element, boolean state) {
            setElementToHash(element, state);
            updateCountLabels();
        }
        
        private void setElementToHash(TreeElement element, boolean state) {
            if (state) {
                checkedElementsHash.add(element);
            } else {
                checkedElementsHash.remove(element);
            }
        }
        
        private void updateCountLabels() {
            lblCheckedCount.setText(Messages.DiffTableViewer_selected + viewer.getCheckedElements().length);
            lblCheckedCount.getParent().layout();
        }
    }
    
    private class TableViewerComparator extends ViewerComparator {
        
        private class SortingColumn {
            
            public final Columns col;
            public final boolean desc;
            
            public SortingColumn(Columns col, boolean desc) {
                this.col = col;
                this.desc = desc;
            }
            
            @Override
            public boolean equals(Object obj) {
                if (obj instanceof SortingColumn) {
                    return ((SortingColumn) obj).col == col;
                } else {
                    return false;
                }
            }
            
            @Override
            public int hashCode() {
                return col.hashCode();
            }
        }
        
        private LinkedList<SortingColumn> sortOrder = new LinkedList<>();

        public void clearSortList() {
            sortOrder.clear();
        }
        
        public int getSwtDirection() {
            if (sortOrder.isEmpty() || !sortOrder.getLast().desc) {
                return SWT.UP;
            } else {
                return SWT.DOWN;
            }
        }

        public void addSort(Columns column) {
            if (!sortOrder.isEmpty() && column.equals(sortOrder.getLast().col)) {
                SortingColumn oldCol = sortOrder.pollLast();
                sortOrder.addLast(new SortingColumn(column, !oldCol.desc));
            } else {
                SortingColumn c = new SortingColumn(column, false);
                sortOrder.remove(c);
                sortOrder.addLast(c);
            }
        }
        
        @Override
        public int compare(Viewer v, Object e1, Object e2) {
            TreeElement el1 = (TreeElement) e1;
            TreeElement el2 = (TreeElement) e2;
            
            Iterator<SortingColumn> it = sortOrder.descendingIterator();
            while (it.hasNext()) {
                SortingColumn c = it.next();
                int res = 0;
                switch (c.col) {
                case CHANGE:
                    res = el1.getSide().toString().compareTo(el2.getSide().toString());
                    break;
                case LOCATION:
                    res = getLocationColumnText(el1).compareTo(getLocationColumnText(el2));
                    break;
                case CHECK:
                    res = Boolean.compare(viewer.getChecked(el1), viewer.getChecked(el2));
                    break;
                case NAME:
                    res = el1.getName().compareTo(el2.getName());
                    break;
                case TYPE:
                    res = el1.getType().toString().compareTo(el2.getType().toString());
                    break;
                }
                if (res != 0) {
                    if (c.desc) {
                        res = -res;
                    }
                    return res;
                }
            }
            
            return 0;
        }
    }

    class TableViewerFilter extends ViewerFilter {

        private String filterName;
        
        public void setFilteName(String value) {
            filterName = value == null || value.isEmpty() ? null : 
                value.toLowerCase();
        }
        @Override
        public boolean select(Viewer viewer, Object parentElement, Object element) {
            if (filterName == null) {
                return true;
            }
            return ((TreeElement) element).getName().toLowerCase().contains(filterName);
        }
    }
}