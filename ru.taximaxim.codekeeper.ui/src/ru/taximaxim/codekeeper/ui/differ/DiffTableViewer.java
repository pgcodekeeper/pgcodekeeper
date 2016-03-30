package ru.taximaxim.codekeeper.ui.differ;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
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
import org.eclipse.jface.text.Region;
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
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
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

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.ListGeneratorPredicate;
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
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.IgnoredObject;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.StringEditor;
import ru.taximaxim.codekeeper.ui.views.DepcyStructuredSelection;

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
    private final PgDbProject proj;
    private final IgnoresChangeListener ignoresListener = new IgnoresChangeListener();
    private List<IgnoredObject> ignoredElements;

    // values are checkedSet states of the elements
    private Set<TreeElement> elements = new HashSet<>();
    private final CheckStateListener checkListener = new CheckStateListener();
    private final TableViewerComparator comparator = new TableViewerComparator();

    private final LocalResourceManager lrm;
    private Text txtFilterName;
    private Button useRegEx;
    private final CheckboxTableViewer viewer;
    private final TableViewerFilter viewerFilter = new TableViewerFilter();
    private TableViewerColumn columnCheck, columnType, columnChange, columnName, columnLocation;
    private Label lblObjectCount;
    private Label lblCheckedCount;
    private ComboViewer cmbPrevChecked;

    private DbSource dbSource;
    private DbSource dbTarget;

    private Map<String, List<String>> prevChecked;
    private XmlHistory prevCheckedHistory;
    private final List<ICheckStateListener> programmaticCheckListeners = new ArrayList<>();

    private enum Columns {
        CHECK,
        NAME,
        TYPE,
        CHANGE,
        LOCATION
    }

    public CheckboxTableViewer getViewer() {
        return viewer;
    }

    public DiffTableViewer(Composite parent, int style, final IPreferenceStore mainPrefs,
            PgDbProject proj, boolean viewOnly) {
        super(parent, style);
        this.viewOnly = viewOnly;
        this.proj = proj;

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
        GridLayout filterLayout = new GridLayout(4, false);
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

        useRegEx = new Button(filterComp, SWT.TOGGLE);
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
            ExceptionNotifier.notifyDefault(Messages.DiffTableViewer_error_load_checked_set, e1);
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
                return new DepcyStructuredSelection(dbSource, dbTarget,
                        (IStructuredSelection) super.getSelection());
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
                    return ((TreeElement)element).isSelected();
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
        
        new Label(filterComp, SWT.NONE).setText("|");
        
        Composite contButtons = new Composite(filterComp, SWT.NONE);
        contButtons.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        GridLayout contButtonsLayout = new GridLayout(viewOnly? 2 : 11, false);
        contButtonsLayout.marginWidth = contButtonsLayout.marginHeight = 0;
        contButtons.setLayout(contButtonsLayout);

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
                    checkListener.setElementsChecked(Arrays.asList(viewer.getCheckedElements()), true);
                    viewerRefresh();
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
                    checkListener.setElementsChecked(Arrays.asList(viewer.getCheckedElements()), false);
                    viewerRefresh();
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
                    checkListener.setElementsChecked(Arrays.asList(viewer.getCheckedElements()), true);
                    checkListener.setElementsChecked(Arrays.asList(initial), false);

                    viewerRefresh();
                }
            });

            new Label(contButtons, SWT.NONE).setText(
                    Messages.diffTableViewer_stored_selections);

            cmbPrevChecked = new ComboViewer(contButtons, SWT.DROP_DOWN);
            GridData gd = new GridData();
            gd.widthHint = 200;
            cmbPrevChecked.getCombo().setLayoutData(gd);
            cmbPrevChecked.getCombo().setToolTipText(
                    Messages.diffTableViewer_Input_name_for_save_checked_elements);
            cmbPrevChecked.setContentProvider(new ArrayContentProvider());
            cmbPrevChecked.setLabelProvider(new LabelProvider());
            cmbPrevChecked.setInput(prevChecked.keySet());
            cmbPrevChecked.getCombo().setBackground(parent.getBackground());
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

            Button saveCheck2Clipboard = new Button(contButtons, SWT.PUSH);
            saveCheck2Clipboard.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(
                            FILE.ICONSAVECLIPBOARD))));
            saveCheck2Clipboard.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    saveCheckedElements2ClipboardAsExpession();
                }
            });
            
            new Label(contButtons, SWT.NONE).setText("|");

            lblCheckedCount = new Label(contButtons, SWT.LEFT);
            lblCheckedCount.setLayoutData(new GridData());// (SWT.DEFAULT, SWT.DEFAULT, true, false));
        } else {
            new Label(contButtons, SWT.NONE).setText("|");
        }

        lblObjectCount = new Label(contButtons, SWT.LEFT);
        lblObjectCount.setLayoutData(new GridData());// (SWT.DEFAULT, SWT.DEFAULT, true, false));

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
                        updateCheckedLabel();
                        notifyExternalCheckListener();
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
                        updateCheckedLabel();
                        notifyExternalCheckListener();
                        viewerRefresh();
                    }
                }
            });
            menuMgr.add(new Separator());
            menuMgr.add(new Action(Messages.diffTableViewer_mark_selected_elements) {

                @Override
                public void run() {
                    checkListener.setElementsChecked(
                            ((IStructuredSelection) viewer.getSelection()).toList(), true);
                    viewerRefresh();
                }
            });
            menuMgr.add(new Action(Messages.diffTableViewer_unmark_selected_elements) {

                @Override
                public void run() {
                    checkListener.setElementsChecked(
                            ((IStructuredSelection) viewer.getSelection()).toList(), false);
                    viewerRefresh();
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

    private void initColumns() {
        columnCheck = new TableViewerColumn(viewer, SWT.LEFT);
        columnCheck.getColumn().setResizable(true);
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

        columnType = new TableViewerColumn(viewer, SWT.LEFT);
        columnChange = new TableViewerColumn(viewer, SWT.LEFT);
        columnName = new TableViewerColumn(viewer, SWT.LEFT);
        columnLocation = new TableViewerColumn(viewer, SWT.LEFT);

        columnName.getColumn().setResizable(true);
        columnName.getColumn().setMoveable(true);

        columnType.getColumn().setResizable(true);
        columnType.getColumn().setMoveable(true);

        columnChange.getColumn().setResizable(true);
        columnChange.getColumn().setMoveable(true);

        columnLocation.getColumn().setResizable(true);
        columnLocation.getColumn().setMoveable(true);

        setColumnHeaders();
        
        columnName.getColumn().addSelectionListener(
                getHeaderSelectionAdapter(columnName.getColumn(), Columns.NAME));
        columnType.getColumn().addSelectionListener(
                getHeaderSelectionAdapter(columnType.getColumn(), Columns.TYPE));
        columnChange.getColumn().addSelectionListener(
                getHeaderSelectionAdapter(columnChange.getColumn(), Columns.CHANGE));
        columnLocation.getColumn().addSelectionListener(
                getHeaderSelectionAdapter(columnLocation.getColumn(), Columns.LOCATION));

        updateColumnsWidth();

        columnName.setLabelProvider(new StyledCellLabelProvider(){

            @Override
            public void update(ViewerCell cell) {
                String name = ((TreeElement)cell.getElement()).getName();
                cell.setText(name);

                Region loc = viewerFilter.getMatchingLocation(name, viewerFilter.filterName,
                        (viewerFilter.useRegEx) ? viewerFilter.regExPattern : null);
                if (loc != null) {
                    StyleRange highlightMatch = new StyleRange(loc.getOffset(),
                            loc.getLength(), null,
                            getDisplay().getSystemColor(SWT.COLOR_YELLOW));
                    cell.setStyleRanges(new StyleRange[] { highlightMatch });
                } else {
                    cell.setStyleRanges(null);
                }
                //super.update(cell);
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
                return ((TreeElement) element).getContainerQName();
            }
        });
    }
    
    private void setColumnHeaders(){
        columnCheck.getColumn().setText(" "); //$NON-NLS-1$
        columnName.getColumn().setText(Messages.diffTableViewer_object_name);
        columnType.getColumn().setText(Messages.diffTableViewer_object_type);
        columnChange.getColumn().setText(Messages.diffTableViewer_change_type);
        columnLocation.getColumn().setText(Messages.diffTableViewer_container);
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

    private SelectionAdapter getHeaderSelectionAdapter(final TableColumn column,
            final Columns index) {
        SelectionAdapter selectionAdapter = new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                if ((e.stateMask & SWT.CTRL) != 0){
                    comparator.clearSortList();
                    setColumnHeaders();
                }
                sortViewer(column, index);
            }
        };
        return selectionAdapter;
    }

    private void sortViewer(final TableColumn column, final Columns index) {
        comparator.addSort(index);
        List<ru.taximaxim.codekeeper.ui.differ.DiffTableViewer.TableViewerComparator.SortingColumn> sorts = 
                comparator.getSortOrder();
        for (int i=0; i<sorts.size(); i++){
            String arrow = sorts.get(i).desc == false ? "\u25BF" : "\u25B5";
            switch (sorts.get(i).col) {
             
            case CHECK:
                viewer.getTable().getColumn(0).setText(String.format("%d%s", i+1, arrow));
                break;
            case TYPE:
                columnType.getColumn().setText(String.format("%d%s\t%s", i+1, arrow, Messages.diffTableViewer_object_type));
                break;
            case CHANGE:
                columnChange.getColumn().setText(String.format("%d%s\t%s", i+1, arrow, Messages.diffTableViewer_change_type));
                break;
            case NAME:
                columnName.getColumn().setText(String.format("%d%s\t%s", i+1, arrow, Messages.diffTableViewer_object_name));
                break;  
            case LOCATION:
                columnLocation.getColumn().setText(String.format("%d%s\t%s", i+1, arrow, Messages.diffTableViewer_container));
                break;                        
            default:
                break;
            }
        }
        viewer.refresh();
    }

    /**
     * Метод используется для добавления слушателя внешнего который реагирует
     * только на нижнюю часть таблицыв коммита
     * @param listener
     */
    public void addCheckStateListener(ICheckStateListener listener) {
        viewer.addCheckStateListener(listener);
        programmaticCheckListeners.add(listener);
    }

    private void setCheckedFromPrevCheckedCombo() {
        String comboText = cmbPrevChecked.getCombo().getText();
        if (comboText != null && !comboText.isEmpty()) {
            List<String> elementsToCheck = prevChecked.get(comboText);
            if (elementsToCheck != null && !elementsToCheck.isEmpty()) {
                List<TreeElement> prevCheckedList = new ArrayList<>(elementsToCheck.size());
                for (String elementString : elementsToCheck){
                    int comma = elementString.lastIndexOf(',');
                    String elName;
                    DbObjType elType;
                    try {
                        elName = elementString.substring(0, comma);
                        elType = DbObjType.valueOf(elementString.substring(comma + 1));
                    } catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
                        Log.log(Log.LOG_WARNING,
                                "Bad checked set entry: " + elementString, ex); //$NON-NLS-1$
                        continue;
                    }
                    for (TreeElement el : elements) {
                        if (el.getType() == elType && el.getQualifiedName().equals(elName)) {
                            prevCheckedList.add(el);
                        }
                    }
                }
                checkListener.setElementsChecked(prevCheckedList, true);
                viewerRefresh();
            }
        }
    }

    private void saveCheckedElements2ClipboardAsExpession(){
        Object[] checkedElements = viewer.getCheckedElements();
        if (checkedElements == null || checkedElements.length == 0){
            return;
        }
        StringBuffer sb = new StringBuffer("^");
        String str = ((TreeElement)checkedElements[0]).getName().replaceAll("\\(", "\\\\(");
        str = str.replaceAll("\\)", "\\\\)");
        sb.append(str).append("$");
        for (int i = 1; i < checkedElements.length; i++){
            TreeElement te = (TreeElement) checkedElements[i];
            str = te.getName().replaceAll("\\(", "\\\\(");
            str = str.replaceAll("\\)", "\\\\)");
            sb.append("|").append("^").append(str).append("$");
        }
        StringSelection ss = new StringSelection(sb.toString());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    }

    private void updateCheckedSet(boolean addEntry) {
        String setName = cmbPrevChecked.getCombo().getText();
        if (!setName.isEmpty()) {
            List<String> checkedElements = new ArrayList<>();
            for (TreeElement element : elements) {
                if (element.isSelected()) {
                    checkedElements.add(element.getQualifiedName() + ',' + element.getType().name());
                }
            }
            try {
                prevCheckedHistory.updateCheckedSetHistoryEntries(setName,
                        checkedElements, addEntry);
                prevChecked = prevCheckedHistory.getMapHistory();
            } catch (IOException e) {
                ExceptionNotifier.notifyDefault(Messages.DiffTableViewer_error_save_checked_set, e);
                prevChecked = new HashMap<>();
            }
            cmbPrevChecked.setInput(prevChecked.keySet());
        }
    }

    /**
     * Устанавливает входные данные для таблицы
     * @param treediffer содержит дерево + базы
     * @param reverseSide содержит сторону
     */
    public void setInput(TreeDiffer treediffer, boolean reverseSide) {
        setDiffer(treediffer, reverseSide);

        elements = new HashSet<>();
        if (treeRoot != null) {
            generateElementsList(treeRoot);
        }

        initializeViewer();
    }
    /**
     * Используется в коммит диалоге для установки элементов
     * @param showOnlyElements элементы для показа
     * @param rootDiffer дерево + базы
     * @param reverseDiffSide сторона
     */
    public void setInputCollection(Collection<TreeElement> showOnlyElements,
            TreeDiffer rootDiffer, boolean reverseDiffSide) {
        setDiffer(rootDiffer, reverseDiffSide);

        elements = new HashSet<>();
        elements.addAll(showOnlyElements);

        initializeViewer();
    }

    private void setDiffer(TreeDiffer differ, boolean reverseDiffSide) {
        this.reverseDiffSide = reverseDiffSide;
        try {
            this.treeRoot = (differ == null) ? null : 
                reverseDiffSide ? differ.getDiffTree() : differ.getDiffTreeRevert();
            this.dbSource = (differ == null) ? null :
                reverseDiffSide ? differ.getDbTarget() : differ.getDbSource();
                this.dbTarget = (differ == null) ? null :
                    reverseDiffSide ? differ.getDbSource() : differ.getDbTarget();
        } catch (PgCodekeeperUIException e) {
            ExceptionNotifier.notifyDefault(Messages.DiffTableViewer_error_setting_input, e);
            this.treeRoot = null;
            this.dbSource = null;
            this.dbTarget = null;
        }
    }

    private void initializeViewer() {
        viewer.setInput(elements);

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

    private void generateElementsList(TreeElement tree) {
        // догружаем игноры из файла в проекте
        final List<IgnoredObject> ignores = new ArrayList<>(ignoredElements);
        if (proj != null) {
            StringEditor se = new StringEditor(Paths.get(proj.getProject()
                    .getLocation().toOSString(), FILE.IGNORED_OBJECTS));
            try {
                ignores.addAll(se.loadSettings());
            } catch (IOException e1) {
                Log.log(Log.LOG_WARNING,
                        "Some problems occured while reading ignore settings from file", e1); //$NON-NLS-1$
            }
        }

        // коллбэк указывающий на необходимость игнора элемента(ов)
        ListGeneratorPredicate predicate = new ListGeneratorPredicate() {

            @Override
            public ADD_STATUS shouldAddToList(TreeElement el) {
                for (IgnoredObject ign : ignores) {
                    if (ign.match(el.getName())) {
                        if (ign.isIgnoreContent()) {
                            return ADD_STATUS.SKIP_SUBTREE;
                        } else {
                            return ADD_STATUS.SKIP_THIS;
                        }
                    }
                }
                return ADD_STATUS.ADD;
            }
        };

        // заполняем сет элементов
        tree.flattenAlteredElements(elements, dbSource.getDbObject(), dbTarget.getDbObject(), false, predicate);
    }

    private void viewerRefresh() {
        viewer.refresh();
        updateObjectsLabel();
        if (!viewOnly) {
            updateCheckedLabel();
        }
    }

    private void updateObjectsLabel() {
        lblObjectCount.setText(MessageFormat.format(
                Messages.diffTableViewer_objects, elements.size()));
        lblObjectCount.getParent().layout();
    }

    private void updateCheckedLabel() {
        lblCheckedCount.setText(MessageFormat.format(
                Messages.DiffTableViewer_selected,
                getCheckedElementsCount()));
        lblCheckedCount.getParent().layout();
    }

    public int getCheckedElementsCount() {
        int count = 0;
        for (TreeElement el : elements) {
            if (el.isSelected()) {
                ++count;
            }
        }
        return count;
    }

    private void setSubTreeChecked(TreeElement element, boolean selected) {
        // Если элемент был проигнорирован, он будет в дереве, но его не будет в
        // таблице и выбор или снятие галочки не должно затрагивать статус
        // игнорированного элемента
        if (elements.contains(element)) {
            element.setSelected(selected);
        }

        for (TreeElement child : element.getChildren()) {
            setSubTreeChecked(child, selected);
        }
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
                    ignoredElements = IgnoredObject.parsePrefs(xml.deserializeList(
                            new StringReader((String) event.getNewValue())));
                } catch (IOException | SAXException ex) {
                    ExceptionNotifier.notifyDefault(Messages.DiffTableViewer_error_reading_ignored_objects, ex);
                    return;
                }
                viewerRefresh();
            }
        }
    }

    private class CheckStateListener implements ICheckStateListener {

        @Override
        public void checkStateChanged(CheckStateChangedEvent event) {
            ((TreeElement)event.getElement()).setSelected(event.getChecked());
            updateCheckedLabel();
        }

        public void setElementsChecked(List<?> elements, boolean state) {
            for (Object element : elements) {
                ((TreeElement)element).setSelected(state);
            }
            notifyExternalCheckListener();
            updateCheckedLabel();
        }
    }

    public void notifyExternalCheckListener() {
        for (ICheckStateListener list : programmaticCheckListeners) {
            list.checkStateChanged(null);
        }
    }

    private static class TableViewerComparator extends ViewerComparator {

        private static class SortingColumn {

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

        private final LinkedList<SortingColumn> sortOrder = new LinkedList<>();
        
        public List<SortingColumn> getSortOrder(){
            return sortOrder;
        }

        public void clearSortList() {
            sortOrder.clear();
        }

        @SuppressWarnings("unused")
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
                    res = el1.getContainerQName().compareTo(el2.getContainerQName());
                    break;
                case CHECK:
                    res = -Boolean.compare(el1.isSelected(), el2.isSelected());
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
        public boolean select(Viewer viewer, Object parentElement,
                Object element) {
            if (filterName == null) {
                return true;
            }
            if (useRegEx) {
                if (regExPattern != null) {
                    return getMatchingLocation(((TreeElement) element).getName(),
                            filterName, regExPattern) != null;
                } else {
                    return false;
                }
            } else {
                return getMatchingLocation(((TreeElement) element).getName(),
                        filterName, null) != null;
            }
        }

        private Region getMatchingLocation(String text, String filter, Pattern regExPattern) {
            if (filter != null
                    && !filter.isEmpty()
                    && text != null) {
                text = text.toLowerCase();
                int offset = -1;
                int length = 0;
                if (regExPattern != null) {
                    Matcher matcher = regExPattern.matcher(text);
                    if (matcher.find()) {
                        offset = matcher.start();
                        length = matcher.end() - offset;
                    }
                } else {
                    offset = text.indexOf(filter);
                    length = filter.length();
                }
                if (offset >= 0) {
                    return new Region(offset, length);
                }
            }
            return null;
        }
    }
}
