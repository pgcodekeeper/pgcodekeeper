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
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
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

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.XmlHistory;
import ru.taximaxim.codekeeper.ui.XmlStringList;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.IgnoredObjectsPrefPage;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

/*
 * Call CheckStateListener.updateCountLabels() when programmatically changing 
 * elements' checked state. 
 */
public class DiffTableViewer extends Composite {

    private final static String PREVCHECKED_HIST_ROOT = "CheckSets"; //$NON-NLS-1$
    private final static String PREVCHECKED_HIST_SET = "CheckSet"; //$NON-NLS-1$
    private final static String PREVCHECKED_HIST_EL = "Checked"; //$NON-NLS-1$
    private final static String PREVCHECKED_HIST_FILENAME = "check_sets.xml"; //$NON-NLS-1$
    private final static int PREVCHECKED_HIST_MAX_STORED = 10;
    
    private final boolean viewOnly;
    
    private TreeElement treeRoot;
    // values are checked states of the elements
    private Map<TreeElement, Boolean> elements = new HashMap<>();
    
    private final IgnoresChangeListener ignoresListener = new IgnoresChangeListener();
    
    private final CheckStateListener checkListener = new CheckStateListener();
    
    private final TableViewerComparator comparator = new TableViewerComparator();
    
    private final LocalResourceManager lrm;
    
    private Text txtFilterName;
    public final CheckboxTableViewer viewer;
    private TableViewerFilter viewerFilter = new TableViewerFilter();
    private TableViewerColumn columnCheck, columnType, columnChange, columnName, columnLocation;
    private Label lblObjectCount;
    private Label lblCheckedCount;
    private ComboViewer cmbPrevChecked;
    
    private List<String> ignoredElements;
    private PgDatabase dbSource;
    private PgDatabase dbTarget;
    
    private Map<String, LinkedList<String>> prevChecked; 
    private XmlHistory prevCheckedHistory;
    
    private enum Columns {
        CHECK,
        NAME,
        TYPE, 
        CHANGE,
        LOCATION
    }
    
    public DiffTableViewer(Composite parent, int style, final IPreferenceStore mainPrefs, boolean viewOnly) {
        super(parent, style);

        this.viewOnly = viewOnly;
        
        lrm = new LocalResourceManager(JFaceResources.getResources(), this);
        GridLayout gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        setLayout(gl);

        txtFilterName = new Text(this, SWT.BORDER | SWT.SEARCH | SWT.ICON_SEARCH 
                | SWT.ICON_CANCEL);
        txtFilterName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtFilterName.setMessage(Messages.diffTableViewer_object_name);
        txtFilterName.addModifyListener(new ModifyListener() {
            
            @Override
            public void modifyText(ModifyEvent e) {
                viewerFilter.setFilter(txtFilterName.getText());
                viewerRefresh();
            }
        });
        
        prevCheckedHistory = new XmlHistory.Builder(PREVCHECKED_HIST_MAX_STORED,
                PREVCHECKED_HIST_FILENAME, 
                PREVCHECKED_HIST_ROOT,
                PREVCHECKED_HIST_EL).elementSetTag(PREVCHECKED_HIST_SET).build();
        prevChecked = prevCheckedHistory.getMapHistory();
        
        int viewerStyle = SWT.MULTI | SWT.FULL_SELECTION | SWT.BORDER;
        if (!viewOnly) {
            viewerStyle |= SWT.CHECK;  
        }
        viewer = new CheckboxTableViewer(new Table(this, viewerStyle));
        
        viewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
        viewer.getTable().setLinesVisible(true);  
        viewer.getTable().setHeaderVisible(true);
        
        if (!viewOnly) {
            viewer.getControl().setMenu(
                    getViewerMenu().createContextMenu(viewer.getControl()));

            viewer.addDoubleClickListener(new IDoubleClickListener() {

                @Override
                public void doubleClick(DoubleClickEvent e) {
                    TreeElement el = (TreeElement) ((IStructuredSelection) e
                            .getSelection()).getFirstElement();
                    if (el != null) {
                        boolean newChecked = !elements.get(el);
                        viewer.setChecked(el, newChecked);
                        checkListener.setElementChecked(el, newChecked);
                    }
                }
            });

            viewer.addCheckStateListener(checkListener);

            viewer.setCheckStateProvider(new ICheckStateProvider() {

                @Override
                public boolean isChecked(Object element) {
                    return elements.get(element);
                }

                @Override
                public boolean isGrayed(Object element) {
                    return false;
                }

            });
        }
        
        viewer.setComparator(comparator);
        viewer.setFilters(new ViewerFilter[] { viewerFilter });
        
        initColumns();
        
        viewer.setContentProvider(new ArrayContentProvider());
        
        Composite contButtons = new Composite(this, SWT.NONE);
        contButtons.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        GridLayout contButtonsLayout = new GridLayout(viewOnly? 2 : 7, false);
        contButtonsLayout.marginWidth = contButtonsLayout.marginHeight = 0;
        contButtons.setLayout(contButtonsLayout);
        
        if (!viewOnly) {
            Button btnSelectAll = new Button(contButtons, SWT.PUSH);
            btnSelectAll.setText(Messages.select_all);
            btnSelectAll.addSelectionListener(new SelectionAdapter() {
                
                @Override
                public void widgetSelected(SelectionEvent e) {
                    viewer.setAllChecked(true);
                    checkListener.setElementsChecked(viewer.getCheckedElements(), true);
                    cmbPrevChecked.setSelection(StructuredSelection.EMPTY);
                }
            });
            
            Button btnSelectNone = new Button(contButtons, SWT.PUSH);
            btnSelectNone.setText(Messages.select_none);
            btnSelectNone.addSelectionListener(new SelectionAdapter() {
                
                @Override
                public void widgetSelected(SelectionEvent e) {
                    checkListener.setElementsChecked(viewer.getCheckedElements(), false);
                    viewer.setAllChecked(false);
                    cmbPrevChecked.setSelection(StructuredSelection.EMPTY);
                }
            });
            
            cmbPrevChecked = new ComboViewer(contButtons, SWT.DROP_DOWN);
            GridData gd = new GridData();
            gd.widthHint = 200;
            cmbPrevChecked.getCombo().setLayoutData(gd);
            cmbPrevChecked.setContentProvider(new ArrayContentProvider());
            cmbPrevChecked.setLabelProvider(new LabelProvider());
            cmbPrevChecked.setInput(prevChecked.keySet());
            cmbPrevChecked.addSelectionChangedListener(new ISelectionChangedListener() {
                
                @Override
                public void selectionChanged(SelectionChangedEvent event) {
                    setCheckedFromPrevCheckedCombo();
                }
            });
            
            Button saveChecked = new Button(contButtons, SWT.PUSH);
            saveChecked.setText(Messages.diffTableViewer_save_checked);
            saveChecked.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    String setName = cmbPrevChecked.getCombo().getText();
                    if (!setName.isEmpty()) {
                        LinkedList<String> checkedElements = new LinkedList<>();
                        for (TreeElement element : getCheckedElements()) {
                            checkedElements.add(element.getName());
                        }
                        prevCheckedHistory.addCheckedSetHistoryEntry(setName, 
                                    checkedElements);
                        prevChecked = prevCheckedHistory.getMapHistory();
                        cmbPrevChecked.setInput(prevChecked.keySet());
                    }
                }
            });
        }
        
        Button btnClearSort = new Button(contButtons, SWT.PUSH);
        if (viewOnly) {
            btnClearSort.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, true, false));
        }
        btnClearSort.setText(Messages.diffTableViewer_reset_sorting);
        btnClearSort.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                comparator.clearSortList();
                sortViewer(columnName.getColumn(), Columns.NAME);
            }
        });
        
        if (!viewOnly) {
            lblCheckedCount = new Label(contButtons, SWT.RIGHT);
            lblCheckedCount.setLayoutData(new GridData(SWT.RIGHT, SWT.DEFAULT, true, false));
        }
        lblObjectCount = new Label(contButtons, SWT.RIGHT);
        lblObjectCount.setLayoutData(new GridData(SWT.RIGHT, SWT.DEFAULT, false, false));

        mainPrefs.addPropertyChangeListener(ignoresListener);
        viewer.getTable().addDisposeListener(new DisposeListener() {
            
            @Override
            public void widgetDisposed(DisposeEvent e) {
                mainPrefs.removePropertyChangeListener(ignoresListener);
            }
        });
        
        String ignoredObjectsPref = mainPrefs.getString(PREF.IGNORE_OBJECTS);
        if (!ignoredObjectsPref.isEmpty()) {
            ignoresListener.propertyChange(new PropertyChangeEvent(
                    mainPrefs, PREF.IGNORE_OBJECTS, null, ignoredObjectsPref));
        } else {
            ignoredElements = new LinkedList<>();
        }
    }

    private void setCheckedFromPrevCheckedCombo() {
        String comboText = cmbPrevChecked.getCombo().getText();
        if (comboText != null && !comboText.isEmpty()) {
            LinkedList<String> elementsToCheck = prevChecked.get(comboText);
            List<TreeElement> prevCheckedList = new ArrayList<>();
            if (!elementsToCheck.isEmpty()) {
                for (TreeElement elementKey : elements.keySet()) {
                    if (elementsToCheck.contains((elementKey.getName()))) {
                        prevCheckedList.add(elementKey);
                    }
                }
                checkListener.setElementsChecked(prevCheckedList.toArray(),
                        true);
                viewerRefresh();
            }
        }
    }
    
    private void initColumns() {
        if (!viewOnly) {
            columnCheck = new TableViewerColumn(viewer, SWT.LEFT);
            
            columnCheck.getColumn().setResizable(false);
            columnCheck.getColumn().setText(" "); //$NON-NLS-1$
            columnCheck.getColumn().setMoveable(true);
            
            columnCheck.getColumn().addSelectionListener(
                    getHeaderSelectionAdapter(columnCheck.getColumn(), Columns.CHECK));
            
            columnCheck.setLabelProvider(new ColumnLabelProvider(){
                
                @Override
                public String getText(Object element) {
                    return " "; //$NON-NLS-1$
                }
            });
        }
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
        
        columnLocation.getColumn().setResizable(false);
        columnLocation.getColumn().setText(Messages.diffTableViewer_container);
        columnLocation.getColumn().setMoveable(true);

        columnName.getColumn().addSelectionListener(
                getHeaderSelectionAdapter(columnName.getColumn(), Columns.NAME));
        columnType.getColumn().addSelectionListener(
                getHeaderSelectionAdapter(columnType.getColumn(), Columns.TYPE));
        
        columnChange.getColumn().addSelectionListener(
                getHeaderSelectionAdapter(columnChange.getColumn(), Columns.CHANGE));
            
        columnLocation.getColumn().addSelectionListener(
                getHeaderSelectionAdapter(columnLocation.getColumn(), Columns.LOCATION));
            
        for (TableColumn c : viewer.getTable().getColumns()){
            c.pack();
        }
        
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
                                            FILE.ICONPGADMIN
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
                                    FILE.ICONEDIT)));
            private Image left = 
                    lrm.createImage(ImageDescriptor.createFromURL(
                            Activator.getContext().getBundle().getResource(
                                    FILE.ICONDEL)));
            private Image right = 
                    lrm.createImage(ImageDescriptor.createFromURL(
                            Activator.getContext().getBundle().getResource(
                                    FILE.ICONADD)));
            
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
        this.treeRoot = (treediffer == null) ? null : treediffer.getDiffTree();
        this.dbSource = (treediffer == null) ? null : treediffer.getDbSource().getDbObject();
        this.dbTarget = (treediffer == null) ? null : treediffer.getDbTarget().getDbObject();
        
        setInputTreeElement(treeRoot);
    }
    
    public void setFilteredInput(TreeElement filteredElement, 
            TreeDiffer rootDiffer) {
        this.treeRoot = (rootDiffer == null) ? null : rootDiffer.getDiffTree();
        this.dbSource = (rootDiffer == null) ? null : rootDiffer.getDbSource().getDbObject();
        this.dbTarget = (rootDiffer == null) ? null : rootDiffer.getDbTarget().getDbObject();
        
        setInputTreeElement(filteredElement);
    }
    
    private void setInputTreeElement(TreeElement treeElement) {
        elements = new HashMap<>();
        if (treeElement != null) {
            generateFlatElementsMap(treeElement);
        }
        viewer.setInput(elements.keySet());
        
        int widthOfColumns = 0;
        for (TableColumn c : viewer.getTable().getColumns()){
            c.pack();
            widthOfColumns += c.getWidth();
        }
        columnName.getColumn().setWidth(widthOfColumns - viewer.getTable().getSize().x);
        
        updateObjectsLabel();
        
        if (!viewOnly) {
            updateCheckedLabel();
            setCheckedFromPrevCheckedCombo();
        }
        
        initialSorting();
    }
    
    private void initialSorting() {
        comparator.clearSortList();
        sortViewer(columnName.getColumn(), Columns.NAME);
        sortViewer(columnChange.getColumn(), Columns.CHANGE);
        sortViewer(columnType.getColumn(), Columns.TYPE);
        sortViewer(columnLocation.getColumn(), Columns.LOCATION);
    }
    
    private void generateFlatElementsMap(TreeElement subtree) {
        if (subtree.hasChildren()) {
            for (TreeElement child : subtree.getChildren()) {
                generateFlatElementsMap(child);
            }
        }
        
        if ((subtree.getSide() == DiffSide.BOTH && subtree.getParent() != null 
                && subtree.getParent().getSide() != DiffSide.BOTH)
                || subtree.getType() == DbObjType.CONTAINER
                || subtree.getType() == DbObjType.DATABASE 
                ||(subtree.getSide() == DiffSide.BOTH && 
                subtree.getPgStatement(dbSource).compare(
                        subtree.getPgStatement(dbTarget)))) {
            return;
        }
        // Do not add elements, that are in ignore list
        if (!ignoredElements.contains(subtree.getName())) {
            elements.put(subtree, false);
        }
    }
    
    private void viewerRefresh() {
        viewer.refresh();
        updateObjectsLabel();
        if (!viewOnly) {
            updateCheckedLabel();
        }
    }
    
    private void updateObjectsLabel() {
        lblObjectCount.setText(Messages.diffTableViewer_objects + elements.size());
        lblObjectCount.getParent().layout();
    }
    
    private void updateCheckedLabel() {
        lblCheckedCount.setText(Messages.DiffTableViewer_selected + getCheckedElementsCount());
        lblCheckedCount.getParent().layout();
    }
    
    public int getCheckedElementsCount() {
        int i = 0;
        for (boolean checked : elements.values()) {
            if (checked) {
                ++i;
            }
        }
        return i;
    }
    
    private Set<TreeElement> getCheckedElements() {
        Set<TreeElement> checked = new HashSet<>(elements.size());
        for (Entry<TreeElement, Boolean> el : elements.entrySet()) {
            if (el.getValue()) {
                checked.add(el.getKey());
            }
        }
        return checked;
    }
    
    public TreeElement filterDiffTree() {
        if (treeRoot == null){
            return null;
        }
        
        Log.log(Log.LOG_INFO, Messages.diffTableViewer_filtering_diff_tree_based_on_gui_selection);
        
        return treeRoot.getFilteredCopy(getCheckedElements());
    }
    
    private class IgnoresChangeListener implements IPropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent event) {
            if (event.getProperty().equals(PREF.IGNORE_OBJECTS)
                    && !event.getNewValue().equals(event.getOldValue())) {
                XmlStringList xml = new XmlStringList(
                        IgnoredObjectsPrefPage.IGNORED_OBJS_TAG,
                        IgnoredObjectsPrefPage.IGNORED_OBJS_ELEMENT);
                try {
                    ignoredElements = xml.deserializeList(
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
        checkListener.setElementChecked(element, selected);
        
        for (TreeElement child : element.getChildren()) {
            setSubTreeChecked(child, selected);
        }
    }
    
    private class CheckStateListener implements ICheckStateListener {
        
        @Override
        public void checkStateChanged(CheckStateChangedEvent event) {
            setElementChecked((TreeElement)event.getElement(), event.getChecked());
        }
        
        public void setElementsChecked(Object[] elements, boolean state) {
            for (Object element : elements) {
                setChecked((TreeElement)element, state);
            }
            updateCheckedLabel();
        }
        
        public void setElementChecked(TreeElement element, boolean state) {
            setChecked(element, state);
            updateCheckedLabel();
        }
        
        private void setChecked(TreeElement element, boolean state) {
            // do not populate the map outside of setInput()
            if (elements.containsKey(element)) {
                elements.put(element, state);
            }
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
                    res = -Boolean.compare(viewer.getChecked(el1), viewer.getChecked(el2));
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

    private class TableViewerFilter extends ViewerFilter {

        private String filterName;
        
        public void setFilter(String value) {
            filterName = (value == null || value.isEmpty()) ? 
                    null : value.toLowerCase();
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
