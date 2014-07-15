package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
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
import org.xml.sax.SAXException;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.XmlStringList;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.IgnoredObjectsPrefPage;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class DiffTableViewer extends Composite {

    private TreeElement tree;
    public final CheckboxTableViewer viewer;
    private TableViewerColumn columnCheck, columnType, columnChange, columnName, columnLocation;
    private final LocalResourceManager lrm;
    private TableViewerComparator comparator;
    private PgDatabase dbSource;
    private PgDatabase dbTarget;
    private Label lblObjectCount;
    private List<String> ignoredElements;
    private final IgnoresChangeListener ignoresChangeListener = new IgnoresChangeListener();
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

        viewer = new CheckboxTableViewer(new Table(this, SWT.CHECK | SWT.MULTI
                | SWT.FULL_SELECTION | SWT.BORDER));
        viewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
        viewer.getTable().setLinesVisible(true);        
        comparator = new TableViewerComparator();
        viewer.getTable().setHeaderVisible(true);
        viewer.getControl().setMenu(getMenuSelection().createContextMenu(viewer.getControl()));
        
        viewer.setComparator(comparator);
        
        initColumns();
    
        viewer.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent e) {
                CheckboxTableViewer viewer = (CheckboxTableViewer) e
                        .getViewer();
                TreeElement el = (TreeElement) ((IStructuredSelection) e
                        .getSelection()).getFirstElement();
                if (el != null) {
                    viewer.setChecked(el, !viewer.getChecked(el));
                }
            }
        });

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
                        || subtree.getType() == DbObjType.DATABASE
                        || (subtree.getSide() == DiffSide.BOTH && 
                                subtree.getPgStatement(dbSource).compare(
                                        subtree.getPgStatement(dbTarget)))) {
                    return;
                }
                // Do not add elements, which contain in ignore list
                if (!ignoredElements.contains(subtree.getName())) {
                    list.add(subtree);
                }
            }
        });
        
        Composite contButtons = new Composite(this, SWT.NONE);
        contButtons.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        GridLayout contButtonsLayout = new GridLayout(4, false);
        contButtonsLayout.marginWidth = contButtonsLayout.marginHeight = 0;
        contButtons.setLayout(contButtonsLayout);
        
        Button btnSelectAll = new Button(contButtons, SWT.PUSH);
        btnSelectAll.setText(Messages.select_all);
        btnSelectAll.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                viewer.setAllChecked(true);
            }
        });
        
        Button btnSelectNone = new Button(contButtons, SWT.PUSH);
        btnSelectNone.setText(Messages.select_none);
        btnSelectNone.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                viewer.setAllChecked(false);
            }
        });
        
        Button bntClearSort = new Button(contButtons, SWT.PUSH);
        bntClearSort.setText(Messages.diffTableViewer_reset_sorting);
        bntClearSort.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                comparator.clearSorting();
            }
        });
        
        lblObjectCount = new Label(contButtons, SWT.RIGHT);
        lblObjectCount.setLayoutData(new GridData(SWT.RIGHT, SWT.DEFAULT, true, false));

        mainPrefs.addPropertyChangeListener(ignoresChangeListener);
        viewer.getTable().addDisposeListener(new DisposeListener() {
            
            @Override
            public void widgetDisposed(DisposeEvent e) {
                mainPrefs.removePropertyChangeListener(ignoresChangeListener);
            }
        });
        
        String ignoredObjectsPref = mainPrefs.getString(UIConsts.PREF_IGNORE_OBJECTS);
        if (!ignoredObjectsPref.isEmpty()) {
            ignoresChangeListener.propertyChange(new PropertyChangeEvent(
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
                getSelectionAdapter(columnName.getColumn(), Columns.NAME));
        columnType.getColumn().addSelectionListener(
                getSelectionAdapter(columnType.getColumn(), Columns.TYPE));
        columnCheck.getColumn().addSelectionListener(
                getSelectionAdapter(columnCheck.getColumn(), Columns.CHECK));
        columnChange.getColumn().addSelectionListener(
                getSelectionAdapter(columnChange.getColumn(), Columns.CHANGE));
        columnLocation.getColumn().addSelectionListener(
                getSelectionAdapter(columnLocation.getColumn(), Columns.LOCATION));
        
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
                                                    + ".png")); //$NON-NLS-1$
                    ImageDescriptor iCont = ImageDescriptor
                            .createFromURL(Activator
                                    .getContext()
                                    .getBundle()
                                    .getResource(
                                            UIConsts.FILENAME_ICONPGADMIN
                                                    + objType.toString()
                                                            .toLowerCase()
                                                    + "s.png")); //$NON-NLS-1$

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
                switch (el.getSide()) {
                case BOTH:
                    icon = lrm.createImage(ImageDescriptor.createFromURL(
                            Activator.getContext().getBundle().getResource(
                                    UIConsts.FILENAME_ICONEDIT)));
                    break;
                case LEFT:
                    icon = lrm.createImage(ImageDescriptor.createFromURL(
                            Activator.getContext().getBundle().getResource(
                                    UIConsts.FILENAME_ICONDEL)));
                    break;
                case RIGHT:
                    icon = lrm.createImage(ImageDescriptor.createFromURL(
                            Activator.getContext().getBundle().getResource(
                                    UIConsts.FILENAME_ICONADD)));
                    break;
                }
                cell.setText(el.getSide().toString());
                cell.setImage(icon);
                super.update(cell);
            }
        });
        
        columnLocation.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                return getLocationColumntText(element);
            }
        });
        
        viewer.getTable().setSortColumn(columnName.getColumn());
        viewer.getTable().setSortDirection(SWT.UP);
    }

    public static String getLocationColumntText(Object element) {
        TreeElement e = (TreeElement)element;
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
    
    private SelectionAdapter getSelectionAdapter(final TableColumn column,
            final Columns index) {
        SelectionAdapter selectionAdapter = new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                sortViewer(column, index);
                viewer.refresh();
            }            
        };
        return selectionAdapter;
    }
    
    private void sortViewer(final TableColumn column,
            final Columns index) {
        if (index == Columns.CHECK) {
            comparator.setSelected(viewer.getCheckedElements());
        }
        comparator.setColumn(index);
        int dir = comparator.getDirection();
        viewer.getTable().setSortDirection(dir);
        viewer.getTable().setSortColumn(column);
    }
    
    public void setInput(TreeDiffer treediffer) {
        this.tree = (treediffer == null) ? null : treediffer.getDiffTree();
        this.dbSource = (treediffer == null) ? null : treediffer.getDbSource().getDbObject();
        this.dbTarget= (treediffer == null) ? null : treediffer.getDbTarget().getDbObject();
        viewer.setInput(this.tree);
        
        int widthOfColumns = 0;
        for (TableColumn c : viewer.getTable().getColumns()){
            c.pack();
            widthOfColumns += c.getWidth();
        }
        columnName.getColumn().setWidth(widthOfColumns-viewer.getTable().getSize().x);
        
        lblObjectCount.setText(Messages.diffTableViewer_objects +
                String.valueOf(viewer.getTable().getItemCount()));
        lblObjectCount.getParent().layout();
        initialSorting();
    }
    
    public void initialSorting() {
        sortViewer(columnChange.getColumn(), Columns.CHANGE);
        sortViewer(columnType.getColumn(), Columns.TYPE);
        sortViewer(columnLocation.getColumn(), Columns.LOCATION);
        viewer.refresh();
        comparator.clearSorting();
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
                viewer.refresh();
            }
        }
    }

    private MenuManager getMenuSelection() {
        MenuManager menuMgr = new MenuManager();
        menuMgr.add(new Action(Messages.diffTableViewer_select_child_elements) {
            @Override
            public void run() {
                TreeElement el = (TreeElement)((IStructuredSelection)viewer.getSelection())
                        .getFirstElement();
                if (el != null) {
                    viewer.setChecked(el, true);
                    setSubElementsChecked(el, true);
                    viewer.refresh();
                }
            }
        });
        menuMgr.add(new Action(Messages.diffTableViewer_deselect_child_elements) {
            @Override
            public void run() {
                TreeElement el = (TreeElement)((IStructuredSelection)viewer.getSelection())
                        .getFirstElement();
                if (el != null) {
                    viewer.setChecked(el, false);
                    setSubElementsChecked(el, false);
                    viewer.refresh();
                }
            }
        });
        return menuMgr;
    }
    
    private void setSubElementsChecked(TreeElement element, boolean selected) {
        if (!element.hasChildren()) {
            return;
        }
        for (TreeElement child : element.getChildren()) {
            viewer.setChecked(child, selected);
            setSubElementsChecked(child, selected);
        }
    }
}

class TableViewerComparator extends ViewerComparator {
    private DiffTableViewer.Columns propertyIndex;
    private static final int DESCENDING = 1;
    private int direction = DESCENDING;
    private Object[] selected = {};
    private LinkedList<DiffTableViewer.Columns> columnSortOrder = 
            new LinkedList<DiffTableViewer.Columns>();

    public TableViewerComparator() {
        this.propertyIndex = DiffTableViewer.Columns.NAME;
        direction = 1 - DESCENDING;
    }

    public int getDirection() {
        return direction == 1 ? SWT.DOWN : SWT.UP;
    }

    public void setColumn(DiffTableViewer.Columns column) {
        columnSortOrder.remove(column);
        columnSortOrder.add(column);
        
        if (column == this.propertyIndex) {
            // Same column as last sort; toggle the direction
            direction = 1 - direction;
        } else {
            // New column;
            this.propertyIndex = column;
        }
    }
    
    /**
     * Clear sorting sequence
     */
    public void clearSorting() {
        columnSortOrder.clear();
    }

    @Override
    public int compare(Viewer viewer, Object e1, Object e2) {        
        TreeElement p1 = (TreeElement) e1;
        TreeElement p2 = (TreeElement) e2;
        int rc = comparebyColumns(p1, p2, 0);
        
        // If descending order, flip the direction
        if (direction == DESCENDING) {
            rc = -rc;
        }
        return rc;
    }

    private int comparebyColumns(TreeElement el1, TreeElement el2, int position) {
        int rc = 0;
        
        if (columnSortOrder.size() <= position) {
            return rc;
        }
        
        switch (columnSortOrder.get(position)) {
        case CHECK:
            ArrayList<Object> selectedList = new ArrayList<Object>(
                    Arrays.asList(selected));
            boolean p1s = selectedList.contains(el1);
            boolean p2s = selectedList.contains(el2);
            if (p1s == p2s) {
                rc = 0;
            } else if (p1s) {
                rc = 1;
            } else {
                rc = -1;
            }
            break;
        case NAME:
            rc = el1.getName().compareTo(el2.getName());
            break;
        case TYPE:
            rc = el1.getType().name().compareTo(el2.getType().name());
            break;
        case CHANGE:
            rc = el1.getSide().toString().compareTo(el2.getSide().toString());
            break;
        case LOCATION:
            rc = DiffTableViewer.getLocationColumntText(el1).compareTo(
                    DiffTableViewer.getLocationColumntText(el2));
            break;
        default:
            rc = 0;
        }
        if (rc == 0) {
            position ++;
            rc = comparebyColumns(el1, el2, position);
        }
        return rc;
    }
    public void setSelected(Object[] selected) {
        this.selected = selected;
    }
}