package ru.taximaxim.codekeeper.ui.differ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.XMLStringBuild;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
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
    private List<String> ignoredElements = new ArrayList<String>();
    private IPreferenceStore mainPrefs;
    private PropertyChangeListener propChangeListener = new PropertyChangeListener();
    
    public DiffTableViewer(Composite parent, int style, 
            IPreferenceStore preferenceStore) {
        
        super(parent, style);
        
        this.mainPrefs = preferenceStore;
        mainPrefs.addPropertyChangeListener(propChangeListener);
        this.ignoredElements = XMLStringBuild.getListFromXMLString(
                mainPrefs.getString(UIConsts.PREF_IGNORE_OBJECTS));
        
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
        viewer.setComparator(comparator);
        viewer.getTable().addDisposeListener(new DisposeListener() {
            
            @Override
            public void widgetDisposed(DisposeEvent e) {
                mainPrefs.removePropertyChangeListener(propChangeListener);
            }
        });
        
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
        GridLayout contButtonsLayout = new GridLayout(3, false);
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
        
        lblObjectCount = new Label(contButtons, SWT.RIGHT);
        lblObjectCount.setLayoutData(new GridData(SWT.RIGHT, SWT.DEFAULT, true, false));
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
        
        columnName.getColumn().addSelectionListener(getSelectionAdapter(columnName.getColumn(), 1));
        columnType.getColumn().addSelectionListener(getSelectionAdapter(columnType.getColumn(), 2));
        columnCheck.getColumn().addSelectionListener(getSelectionAdapter(columnCheck.getColumn(), 0));
        columnChange.getColumn().addSelectionListener(getSelectionAdapter(columnChange.getColumn(), 3));
        columnLocation.getColumn().addSelectionListener(getSelectionAdapter(columnLocation.getColumn(), 4));
        
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
            final int index) {
        SelectionAdapter selectionAdapter = new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (index == 0) {
                    comparator.setSelected(viewer.getCheckedElements());
                }
                comparator.setColumn(index);
                int dir = comparator.getDirection();
                viewer.getTable().setSortDirection(dir);
                viewer.getTable().setSortColumn(column);
                viewer.refresh();
            }
        };
        return selectionAdapter;
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
    
    class PropertyChangeListener implements IPropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent event) {
            if (event.getProperty().equals(UIConsts.PREF_IGNORE_OBJECTS) &&
                    ! event.getNewValue().equals(event.getOldValue())) {
                ignoredElements = XMLStringBuild.getListFromXMLString(
                        mainPrefs.getString(UIConsts.PREF_IGNORE_OBJECTS));
                viewer.refresh();
            }
        }
    }
}

class TableViewerComparator extends ViewerComparator {
    private int propertyIndex;
    private static final int DESCENDING = 1;
    private int direction = DESCENDING;
    private Object[] selected = {};

    public TableViewerComparator() {
        this.propertyIndex = 1;
        direction = 1 - DESCENDING;
    }

    public int getDirection() {
        return direction == 1 ? SWT.DOWN : SWT.UP;
    }

    public void setColumn(int column) {
        if (column == this.propertyIndex) {
            // Same column as last sort; toggle the direction
            direction = 1 - direction;
        } else {
            // New column; do an ascending sort
            this.propertyIndex = column;
            direction = DESCENDING;
        }
    }

    @Override
    public int compare(Viewer viewer, Object e1, Object e2) {
        TreeElement p1 = (TreeElement) e1;
        TreeElement p2 = (TreeElement) e2;
        int rc = 0;
        switch (propertyIndex) {
        case 0:
            ArrayList<Object> selectedList = new ArrayList<Object>(
                    Arrays.asList(selected));
            boolean p1s = selectedList.contains(p1);
            boolean p2s = selectedList.contains(p2);
            if (p1s == p2s) {
                rc = 0;
            } else if (p1s) {
                rc = 1;
            } else {
                rc = -1;
            }
            break;
        case 1:
            rc = p1.getName().compareTo(p2.getName());
            break;
        case 2:
            rc = p1.getType().name().compareTo(p2.getType().name());
            break;
        case 3:
            rc = p1.getSide().toString().compareTo(p2.getSide().toString());
            break;
        case 4:
            rc = DiffTableViewer.getLocationColumntText(p1).compareTo(
                    DiffTableViewer.getLocationColumntText(p2));
            break;
        default:
            rc = 0;
        }
        // If descending order, flip the direction
        if (direction == DESCENDING) {
            rc = -rc;
        }
        return rc;
    }

    public void setSelected(Object[] selected) {
        this.selected = selected;
    }
}