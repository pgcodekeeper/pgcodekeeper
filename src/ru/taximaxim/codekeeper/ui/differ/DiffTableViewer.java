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
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.layout.PixelConverter;
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
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ISelection;
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
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyGraph;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.UIConsts.XML_TAGS;
import ru.taximaxim.codekeeper.ui.XmlHistory;
import ru.taximaxim.codekeeper.ui.XmlStringList;
import ru.taximaxim.codekeeper.ui.dialogs.DiffPaneDialog;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.views.DepcyStructuredSelection;
import cz.startnet.utils.pgdiff.PgDiffUtils;

/*
 * Call CheckStateListener.updateCountLabels() when programmatically changing 
 * elements' checkedSet state. 
 */
public class DiffTableViewer extends Composite {

    private static final String PREVCHECKED_HIST_ROOT = "CheckSets"; //$NON-NLS-1$
    private static final String PREVCHECKED_HIST_SET = "CheckSet"; //$NON-NLS-1$
    private static final String PREVCHECKED_HIST_EL = "Checked"; //$NON-NLS-1$
    private static final String PREVCHECKED_HIST_FILENAME = "check_sets.xml"; //$NON-NLS-1$
    private static final int PREVCHECKED_HIST_MAX_STORED = 20;
    
    private final Map<DbObjType, Image> mapObjIcons = new HashMap<>(
            DbObjType.values().length);
    private final Image iSideBoth;
    private final Image iSideLeft;
    private final Image iSideRight;
    
    private final boolean viewOnly;
    private boolean reverseDiffSide;
    
    private TreeElement treeRoot;
    // values are checkedSet states of the elements
    private ElementsModel<TreeElement> elements = new ElementsModel<>();
    
    private final IgnoresChangeListener ignoresListener = new IgnoresChangeListener();
    
    private final CheckStateListener checkListener = new CheckStateListener();
    
    private final TableViewerComparator comparator = new TableViewerComparator();
    
    private final LocalResourceManager lrm;
    
    private Text txtFilterName;
    private Button useRegEx;
    private final CheckboxTableViewer viewer;
    private TableViewerFilter viewerFilter = new TableViewerFilter();
    private TableViewerColumn columnType, columnChange, columnName, columnLocation;
    private Label lblObjectCount;
    private Label lblCheckedCount;
    private ComboViewer cmbPrevChecked;
    
    private List<String> ignoredElements;
    private DbSource dbSource;
    private DbSource dbTarget;
    
    private DepcyGraph depcyGraphSource;
    private DepcyGraph depcyGraphTarget;

    private Map<String, List<String>> prevChecked; 
    private XmlHistory prevCheckedHistory;
    
    private enum Columns {
        CHECK,
        NAME,
        TYPE, 
        CHANGE,
        LOCATION
    }
    
    public DiffTableViewer(Composite parent, int style, final IPreferenceStore mainPrefs, 
            boolean viewOnly) {
        super(parent, style);
        this.viewOnly = viewOnly;
        
        lrm = new LocalResourceManager(JFaceResources.getResources(), this);
        for (DbObjType objType : DbObjType.values()) {
            ImageDescriptor iObj = ImageDescriptor.createFromURL(Activator.getContext()
                    .getBundle().getResource(
                            FILE.ICONPGADMIN + objType.toString().toLowerCase() + ".png")); //$NON-NLS-1$
            mapObjIcons.put(objType, lrm.createImage(iObj));
        }
        iSideBoth = lrm.createImage(ImageDescriptor.createFromURL(Activator.getContext()
                .getBundle().getResource(FILE.ICONEDIT)));
        iSideLeft = lrm.createImage(ImageDescriptor.createFromURL(Activator.getContext()
                .getBundle().getResource(FILE.ICONDEL)));
        iSideRight = lrm.createImage(ImageDescriptor.createFromURL(Activator.getContext()
                .getBundle().getResource(FILE.ICONADD)));
        
        GridLayout gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        setLayout(gl);

        Composite filterComp = new Composite(this, SWT.NONE);
        filterComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        GridLayout filterLayout = new GridLayout(2, false);
        filterLayout.marginWidth = filterLayout.marginHeight = 0;
        filterComp.setLayout(filterLayout);
        
        txtFilterName = new Text(filterComp, SWT.BORDER | SWT.SEARCH | SWT.ICON_SEARCH 
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
        
        useRegEx = new Button(filterComp, SWT.CHECK);
        useRegEx.setToolTipText(Messages.diffTableViewer_use_java_regular_expressions_see_more);
        useRegEx.setText(Messages.diffTableViewer_use_regular_expressions);
        useRegEx.addSelectionListener(new SelectionAdapter() {
           @Override
            public void widgetSelected(SelectionEvent e) {
               viewerFilter.setUseRegEx(useRegEx.getSelection());
               viewerRefresh();
            } 
        });
        
        prevCheckedHistory = new XmlHistory.Builder(PREVCHECKED_HIST_MAX_STORED,
                PREVCHECKED_HIST_FILENAME, 
                PREVCHECKED_HIST_ROOT,
                PREVCHECKED_HIST_EL).elementSetTag(PREVCHECKED_HIST_SET).build();
        try {
            prevChecked = prevCheckedHistory.getMapHistory();
        } catch (IOException e1) {
            ExceptionNotifier.showErrorDialog(Messages.DiffTableViewer_error_load_checked_set, e1);
            prevChecked = new HashMap<>();
        }
        
        int viewerStyle = SWT.MULTI | SWT.FULL_SELECTION | SWT.BORDER;
        if (!viewOnly) {
            // TODO always needs SWT.CHECK?
            // Creates a table viewer on the given table control.
            // The SWT.CHECK style bit must be set on the given table control. 
            viewerStyle |= SWT.CHECK;
        }
        viewer = new CheckboxTableViewer(new Table(this, viewerStyle)){
            
            @Override
            public ISelection getSelection() {
                return new DepcyStructuredSelection(
                        depcyGraphSource, depcyGraphTarget,
                        ((IStructuredSelection) super.getSelection()).toArray());
            }
        };
        
        viewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
        viewer.getTable().setLinesVisible(true);  
        viewer.getTable().setHeaderVisible(true);
        
        viewer.getControl().setMenu(
                getViewerMenu().createContextMenu(viewer.getControl()));
        
        if (!viewOnly) {
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
        viewer.getTable().pack();
        initColumns();
        
        viewer.setContentProvider(new ArrayContentProvider());
        
        Composite contButtons = new Composite(this, SWT.NONE);
        contButtons.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        GridLayout contButtonsLayout = new GridLayout(viewOnly? 2 : 10, false);
        contButtonsLayout.marginWidth = contButtonsLayout.marginHeight = 0;
        contButtons.setLayout(contButtonsLayout);
        
        Button btnClearSort = new Button(contButtons, SWT.PUSH);
        if (viewOnly) {
            btnClearSort.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT, true, false));
        }
        btnClearSort.setToolTipText(Messages.diffTableViewer_reset_sorting);
        btnClearSort.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(
                        FILE.ICONDEFAULTSORT))));
        btnClearSort.addSelectionListener(new SelectionAdapter() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                comparator.clearSortList();
                sortViewer(columnName.getColumn(), Columns.NAME);
                viewer.refresh();
            }
        });
        
        if (!viewOnly) {
            Button btnSelectAll = new Button(contButtons, SWT.PUSH);
            btnSelectAll.setToolTipText(Messages.select_all);
            btnSelectAll.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(
                            FILE.ICONSELECTALL))));
            btnSelectAll.addSelectionListener(new SelectionAdapter() {
                
                @Override
                public void widgetSelected(SelectionEvent e) {
                    viewer.setAllChecked(true);
                    setCheckedElements(viewer.getCheckedElements(), true);
                    cmbPrevChecked.setSelection(StructuredSelection.EMPTY);
                }
            });
            
            Button btnSelectNone = new Button(contButtons, SWT.PUSH);
            btnSelectNone.setToolTipText(Messages.select_none);
            btnSelectNone.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(
                            FILE.ICONSELECTNONE))));
            btnSelectNone.addSelectionListener(new SelectionAdapter() {
                
                @Override
                public void widgetSelected(SelectionEvent e) {
                    setCheckedElements(viewer.getCheckedElements(), false);
                    viewer.setAllChecked(false);
                    cmbPrevChecked.setSelection(StructuredSelection.EMPTY);
                }
            });
            
            Button btnInvertSelection = new Button(contButtons, SWT.PUSH);
            btnInvertSelection.setToolTipText(Messages.diffTableViewer_invert_selection);
            btnInvertSelection.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(
                            FILE.ICONINVERTSELECTION))));
            btnInvertSelection.addSelectionListener(new SelectionAdapter() {
                
                @Override
                public void widgetSelected(SelectionEvent e) {
                    Object[] initial = viewer.getCheckedElements();
                    
                    viewer.setAllChecked(true);
                    checkListener.setElementsChecked(viewer.getCheckedElements(), true);
                    checkListener.setElementsChecked(initial, false);
                    
                    viewerRefresh();
                }
            });
            
            new Label(contButtons, SWT.NONE).setText(Messages.diffTableViewer_stored_selections);
            
            cmbPrevChecked = new ComboViewer(contButtons, SWT.DROP_DOWN);
            GridData gd = new GridData();
            gd.widthHint = 200;
            cmbPrevChecked.getCombo().setLayoutData(gd);
            cmbPrevChecked.getCombo().setToolTipText(
                    Messages.diffTableViewer_Input_name_for_save_checked_elements);
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
            saveChecked.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(
                            FILE.ICONSAVE))));
            saveChecked.setToolTipText(Messages.diffTableViewer_save_checked);
            
            saveChecked.addSelectionListener(new SelectionAdapter() {
                
                @Override
                public void widgetSelected(SelectionEvent e) {
                    updateCheckedSet(true);
                }
            });
            
            Button deleteCheckSet = new Button(contButtons, SWT.PUSH);
            deleteCheckSet.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(
                            FILE.ICONDEL))));
            deleteCheckSet.setToolTipText(Messages.diffTableViewer_delete_checked_set);
            
            deleteCheckSet.addSelectionListener(new SelectionAdapter() {
                
                @Override
                public void widgetSelected(SelectionEvent e) {
                    updateCheckedSet(false);
                }
            });
        
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
            List<String> elementsToCheck = prevChecked.get(comboText);
            if (elementsToCheck != null && !elementsToCheck.isEmpty()) {
                List<TreeElement> prevCheckedList = new ArrayList<>();
                for (TreeElement elementKey : elements.keySet()) {
                    if (elementsToCheck.contains((elementKey.getName()))) {
                        prevCheckedList.add(elementKey);
                    }
                }
                checkListener.setElementsChecked(prevCheckedList.toArray(), true);
                viewerRefresh();
            }
        }
    }
    
    private void initColumns() {
        TableViewerColumn columnCheck = new TableViewerColumn(viewer, SWT.LEFT);

        columnCheck.getColumn().setResizable(false);
        columnCheck.getColumn().setText(" "); //$NON-NLS-1$
        columnCheck.getColumn().setMoveable(true);

        columnCheck.getColumn().addSelectionListener(
                getHeaderSelectionAdapter(columnCheck.getColumn(),
                        Columns.CHECK));

        columnCheck.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                return " "; //$NON-NLS-1$
            }
        });

        viewer.getTable().getColumns()[0].setResizable(true);
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
        
        columnLocation.getColumn().setResizable(true);
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
            
        updateColumnsWidth();
        
        columnName.setLabelProvider(new ColumnLabelProvider(){
            
            @Override
            public String getText(Object element) {
                return ((TreeElement) element).getName();
            }
        });

        columnType.setLabelProvider(new ColumnLabelProvider() {

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
            
            @Override
            public String getText(Object element) {
                return ((TreeElement) element).getSide().toString();
            }
            
            @Override
            public Image getImage(Object element) {
                switch (((TreeElement) element).getSide()) {
                case BOTH: return iSideBoth;
                case LEFT: return iSideLeft;
                case RIGHT: return iSideRight;
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
    
    private void updateCheckedSet(boolean addEntry) {
        String setName = cmbPrevChecked.getCombo().getText();
        if (!setName.isEmpty()) {
            LinkedList<String> checkedElements = new LinkedList<>();
            for (TreeElement element : getCheckedElements(true)) {
                checkedElements.add(element.getName());
            }
            try {
                prevCheckedHistory.updateCheckedSetHistoryEntries(setName, 
                            checkedElements, addEntry);
                prevChecked = prevCheckedHistory.getMapHistory();
            } catch (IOException e) {
                ExceptionNotifier.showErrorDialog(Messages.DiffTableViewer_error_save_checked_set, e);
                prevChecked = new HashMap<>();
            }
            cmbPrevChecked.setInput(prevChecked.keySet());
        }
    }
    
    private SelectionAdapter getHeaderSelectionAdapter(final TableColumn column,
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
    
    private void sortViewer(final TableColumn column, final Columns index) {
        comparator.addSort(index);
        
        viewer.getTable().setSortDirection(comparator.getSwtDirection());
        viewer.getTable().setSortColumn(column);
    }
    
    public void setInput(TreeDiffer treediffer, boolean reverseSide) {
        setDiffer(treediffer, reverseSide);
        
        setInputTreeElement(treeRoot);
    }
    
    public void setFilteredInput(TreeElement filteredElement, 
            TreeDiffer rootDiffer, boolean reverseDiffSide) {
        setDiffer(rootDiffer, reverseDiffSide);
        
        setInputTreeElement(filteredElement);
    }

    private void setDiffer(TreeDiffer differ, boolean reverseDiffSide) {
        this.reverseDiffSide = reverseDiffSide;
        try {
            this.treeRoot = (differ == null) ? null : differ.getDiffTree();
            this.dbSource = (differ == null) ? null : 
                reverseDiffSide ? differ.getDbTarget() : differ.getDbSource();
            this.depcyGraphSource = (dbSource == null) ? null : new DepcyGraph(dbSource.getDbObject());
            this.dbTarget = (differ == null) ? null : 
                reverseDiffSide ? differ.getDbSource() : differ.getDbTarget();
            this.depcyGraphTarget = (dbTarget == null) ? null : new DepcyGraph(dbTarget.getDbObject());
        } catch (PgCodekeeperUIException e) {
            ExceptionNotifier.showErrorDialog(Messages.DiffTableViewer_error_setting_input, e);
            this.treeRoot = null;
            this.dbSource = null;
            this.depcyGraphSource = null;
            this.depcyGraphTarget = null;
            this.dbTarget = null;
        }
    }
    
    private void setInputTreeElement(TreeElement treeElement) {
        elements = new ElementsModel<>();
        if (treeElement != null) {
            generateFlatElementsMap(treeElement);
        }
        viewer.setInput(elements.keySet());
        
        updateColumnsWidth();
        
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
        viewer.refresh();
    }
    
    private void generateFlatElementsMap(TreeElement subtree) {
        List<TreeElement> elementsList = subtree.generateElementsList(
                new ArrayList<TreeElement>(), dbSource.getDbObject(), dbTarget.getDbObject());
        
        for(TreeElement e : elementsList){
            // Do not add elements, that are in ignore list
            if (!ignoredElements.contains(e.getName())) {
                elements.put(e, false);
            }
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
        lblCheckedCount.setText(Messages.DiffTableViewer_selected + elements.getCheckedElementsCount());
        lblCheckedCount.getParent().layout();
    }
    
    public int getCheckedElementsCount() {
        return elements.getCheckedElementsCount();
    }
    
    public CheckboxTableViewer getViewer() {
        return viewer;
    }
    
    public DepcyGraph getDepcyGraphSource() {
        return depcyGraphSource;
    }
    
    public Set<TreeElement> getCheckedElements(boolean checkedStatus) {
        return elements.getCheckedElements(checkedStatus);
    }
    
    /**
     * ВНИМАНИЕ!!!<br>
     * 
     * Список объектов в таблице должен быть поднабором рута, который попадает в таблицу из TreeDiffer
     */
    public TreeElement filterDiffTree() {
        if (treeRoot == null){
            return null;
        }
        Log.log(Log.LOG_INFO, "Filtering diff tree based on user selection");
        return treeRoot.getFilteredCopy(getCheckedElements(true));
    }
    
    private MenuManager getViewerMenu() {
        MenuManager menuMgr = new MenuManager();
        if (!viewOnly) {
            menuMgr.add(new Action(
                    Messages.diffTableViewer_select_child_elements) {

                @Override
                public void run() {
                    TreeElement el = (TreeElement) 
                            ((IStructuredSelection) viewer.getSelection()).getFirstElement();
                    if (el != null) {
                        setSubTreeChecked(el, true);
                        viewerRefresh();
                    }
                }
            });
            menuMgr.add(new Action(
                    Messages.diffTableViewer_deselect_child_elements) {

                @Override
                public void run() {
                    TreeElement el = (TreeElement) 
                            ((IStructuredSelection) viewer.getSelection()).getFirstElement();
                    if (el != null) {
                        setSubTreeChecked(el, false);
                        viewerRefresh();
                    }
                }
            });
            menuMgr.add(new Separator());
            menuMgr.add(new Action(Messages.diffTableViewer_mark_selected_elements) {

                @Override
                public void run() {
                    setCheckedElements(((IStructuredSelection) viewer.getSelection()).toArray(), true);
                }
            });
            menuMgr.add(new Action(Messages.diffTableViewer_unmark_selected_elements) {

                @Override
                public void run() {
                    setCheckedElements(((IStructuredSelection) viewer.getSelection()).toArray(), false);
                }
            });
            menuMgr.add(new Separator());
        }
        menuMgr.add(new Action(Messages.diffTableViewer_open_diff_in_new_window) {

            @Override
            public void run() {
                TreeElement el = (TreeElement) 
                        ((IStructuredSelection) viewer.getSelection()).getFirstElement();
                DiffPaneDialog dpd = new DiffPaneDialog(
                        DiffTableViewer.this.getShell(), dbSource, dbTarget, reverseDiffSide);
                dpd.setInput(el);
                dpd.open();
            }
        });
        
        menuMgr.addMenuListener(new IMenuListener() {
            
            @Override
            public void menuAboutToShow(IMenuManager manager) {
                boolean enable = !viewer.getSelection().isEmpty();
                for (IContributionItem it : manager.getItems()) {
                    if (it instanceof ActionContributionItem) {
                        ((ActionContributionItem) it).getAction().setEnabled(enable);
                    }
                }
            }
        });
        return menuMgr;
    }
    
    private void setSubTreeChecked(TreeElement element, boolean selected) {
        checkListener.setElementChecked(element, selected);
        
        for (TreeElement child : element.getChildren()) {
            setSubTreeChecked(child, selected);
        }
    }
    
    public void setCheckedElements(Object[] elementsToCheck, boolean markChecked) {
        checkListener.setElementsChecked(elementsToCheck, markChecked);
        viewerRefresh();
    }
    
    public void setInputCollection(Set<TreeElement> shouldBeDeleted, 
            TreeDiffer rootDiffer, boolean reverseDiffSide) {
        setDiffer(rootDiffer, reverseDiffSide);
        elements = new ElementsModel<>();
        for (TreeElement e : shouldBeDeleted){
            elements.put(e, true);
        }
        viewer.setInput(elements.keySet());
        
        updateColumnsWidth();
        
        updateObjectsLabel();
        
        if (!viewOnly) {
            updateCheckedLabel();
        }
        
        initialSorting();
    }
    
    private void updateColumnsWidth(){
        PixelConverter pc = new PixelConverter(viewer.getControl());
        // set check column size to 4 chars
        viewer.getTable().getColumns()[0].setWidth(pc.convertWidthInCharsToPixels(4));
        // name column will take half of the space
        int width = (int)(viewer.getTable().getSize().x * 0.5);
        columnName.getColumn().setWidth(Math.max(width, 200));
        // set type column size to 19 chars to fit "CONSTRAINT" in
        columnType.getColumn().setWidth(pc.convertWidthInCharsToPixels(19));
        // set change type column size to 14 chars
        columnChange.getColumn().setWidth(pc.convertWidthInCharsToPixels(14));
        // location takes the rest
        columnLocation.getColumn().pack();
    }
    
    private class IgnoresChangeListener implements IPropertyChangeListener {

        @Override
        public void propertyChange(PropertyChangeEvent event) {
            if (event.getProperty().equals(PREF.IGNORE_OBJECTS)
                    && !event.getNewValue().equals(event.getOldValue())) {
                XmlStringList xml = new XmlStringList(
                        XML_TAGS.IGNORED_OBJS_ROOT,
                        XML_TAGS.IGNORED_OBJS_ELEMENT);
                try {
                    ignoredElements = xml.deserializeList(
                            new StringReader((String) event.getNewValue()));
                } catch (IOException | SAXException ex) {
                    ExceptionNotifier.showErrorDialog(Messages.DiffTableViewer_error_reading_ignored_objects, ex);
                    return;
                }
                viewerRefresh();
            }
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
            
            private final Columns col;
            private final boolean desc;
            
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
                    res = -Boolean.compare(elements.get(el1), elements.get(el2));
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
    
    private static class TableViewerFilter extends ViewerFilter {

        private String filterName;
        private boolean useRegEx;
        private Pattern regExPattern; 
        
        public void setFilter(String value) {
            if (value == null || value.isEmpty()) {
                filterName = null;
                regExPattern = null;
            } else {
                filterName = value.toLowerCase();
                try {
                    regExPattern = Pattern.compile(value, Pattern.CASE_INSENSITIVE);
                } catch (PatternSyntaxException e) {
                    regExPattern = null;
                }
            }
        }
        
        public void setUseRegEx(Boolean useRegEx) {
            this.useRegEx = useRegEx;
        }
        
        @Override
        public boolean select(Viewer viewer, Object parentElement, Object element) {
            if (filterName == null) {
                return true;
            }
            if (useRegEx) {
                if (regExPattern != null) {
                    return regExPattern.matcher(((TreeElement) element).getName()).find();
                } else {
                    return false;
                }
            } else {
                return ((TreeElement) element).getName().toLowerCase().contains(filterName);
            }
        }
    }

}

class ElementsModel<T> {
    
    private Map<T, Boolean> elements = new HashMap<>();

    private boolean updateChecked;
    private int checkedCount;
    private Set<T> checkedSet = new HashSet<>();

    public Boolean get(Object el) {
        return elements.get(el);
    }

    public void put(T el, boolean isChecked) {
        elements.put(el, isChecked);
        if (isChecked) {
            checkedSet.add(el);
        } else {
            checkedSet.remove(el);
        }
        updateChecked = true;
    }

    public boolean containsKey(Object element) {
        return elements.containsKey(element);
    }
    
    public Set<T> keySet() {
        return elements.keySet();
    }

    public Set<Map.Entry<T, Boolean>> entrySet() {
        return elements.entrySet();
    }

    public int size() {
        return elements.size();
    }
    
    public int getCheckedElementsCount() {
        if (updateChecked) {
            checkedCount = 0;
            updateChecked = false;
            for (boolean checked : elements.values()) {
                if (checked) {
                    ++checkedCount;
                }
            }
        }
        return checkedCount;
    }
    
    public Set<T> getCheckedElements(boolean checkedStatus) {
        if (checkedStatus) {
            return checkedSet;
        } else {
            Set<T> difference = new HashSet<>(elements.keySet());
            difference.removeAll(checkedSet);
            return difference;
        }
    }
}
