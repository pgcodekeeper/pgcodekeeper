package ru.taximaxim.codekeeper.ui.differ;

import java.text.MessageFormat;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Stream;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TreeExpansionEvent;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeFlattener;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.dialogs.DiffPaneDialog;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.dialogs.FilterDialog;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * Use {@link #setChecked(TreeElement, boolean)} for any kind of checkbox work.
 * It refreshes all the needed states without calling slow full viewer refresh.
 * Always call {@link #viewerChecksUpdated()} after finishing checkbox work.
 */
public class DiffTableViewer extends Composite {

    private static final Pattern REGEX_SPECIAL_CHARS = Pattern.compile("[\\[\\\\\\^$.|?*+()]"); //$NON-NLS-1$

    private final Image iSideBoth;
    private final Image iSideLeft;
    private final Image iSideRight;

    private final boolean viewOnly;
    private final Set<TreeElement> elements = new HashSet<>();
    private final DiffContentProvider contentProvider = new DiffContentProvider();
    private final CheckStateProvider checkProvider;
    private final TableViewerComparator comparator = new TableViewerComparator();
    private IStructuredSelection oldSelection;
    private IStructuredSelection newSelection;

    private final LocalResourceManager lrm;
    private final Text txtFilterName;
    private final Button useRegEx;
    private Label lblObjectCount;
    private Label lblCheckedCount;

    private final CheckboxTreeViewer viewer;
    private final TableViewerFilter viewerFilter = new TableViewerFilter();
    private TreeViewerColumn columnCheck;
    private TreeViewerColumn columnType;
    private TreeViewerColumn columnChange;
    private TreeViewerColumn columnName;
    private TreeViewerColumn columnLocation;

    private DbSource dbProject;
    private DbSource dbRemote;

    private final IStatusLineManager lineManager;

    private final List<ICheckStateListener> programmaticCheckListeners = new ArrayList<>();

    private enum Columns {
        CHECK, NAME, TYPE, CHANGE, LOCATION
    }

    public StructuredViewer getViewer() {
        return viewer;
    }

    public Collection<TreeElement> getElements() {
        return Collections.unmodifiableCollection(elements);
    }

    public DiffTableViewer(Composite parent, boolean viewOnly, IStatusLineManager lineManager) {
        super(parent, SWT.NONE);
        this.viewOnly = viewOnly;
        this.lineManager = lineManager;

        PixelConverter pc = new PixelConverter(this);
        lrm = new LocalResourceManager(JFaceResources.getResources(), this);
        iSideBoth = lrm.createImage(ImageDescriptor.createFromURL(Activator.getContext()
                .getBundle().getResource(FILE.ICONEDIT)));
        iSideLeft = lrm.createImage(ImageDescriptor.createFromURL(Activator.getContext()
                .getBundle().getResource(FILE.ICONFROMPROJECT)));
        iSideRight = lrm.createImage(ImageDescriptor.createFromURL(Activator.getContext()
                .getBundle().getResource(FILE.ICONFROMREMOTE)));

        GridLayout gl = new GridLayout();
        gl.marginHeight = gl.marginWidth = 0;
        setLayout(gl);

        // upper composite
        Composite upperComp = new Composite(this, SWT.NONE);
        upperComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        int objectCount = viewOnly ? 4 : 10;

        // if manager != null remove 2 labels, add 3 button
        if (lineManager != null) {
            objectCount += 1;
        }
        gl = new GridLayout(objectCount, false);
        gl.marginWidth = gl.marginHeight = 0;
        upperComp.setLayout(gl);

        if (!viewOnly) {
            Button btnSelectAll = new Button(upperComp, SWT.PUSH);
            btnSelectAll.setToolTipText(Messages.select_all);
            btnSelectAll.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(FILE.ICONSELECTALL))));
            btnSelectAll.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    setElementsChecked(elements, true, true);
                }
            });

            Button btnSelectNone = new Button(upperComp, SWT.PUSH);
            btnSelectNone.setToolTipText(Messages.select_none);
            btnSelectNone.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(FILE.ICONSELECTNONE))));
            btnSelectNone.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    setElementsChecked(elements, false, true);
                }
            });

            Button btnInvertSelection = new Button(upperComp, SWT.PUSH);
            btnInvertSelection.setToolTipText(Messages.diffTableViewer_invert_selection);
            btnInvertSelection.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(FILE.ICONINVERTSELECTION))));
            btnInvertSelection.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    setElementsChecked(elements, el -> !el.isSelected(), true);
                }
            });

            Button saveCheck2Clipboard = new Button(upperComp, SWT.PUSH);
            saveCheck2Clipboard.setImage(Activator.getEclipseImage(ISharedImages.IMG_TOOL_COPY));
            saveCheck2Clipboard.setToolTipText(Messages.DiffTableViewer_copy_as_regex);
            saveCheck2Clipboard.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    saveCheckedElements2ClipboardAsExpession();
                }
            });

            Button btnTypeFilter = new Button(upperComp, SWT.NONE);
            btnTypeFilter.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(FILE.ICONEMPTYFILTER))));
            btnTypeFilter.setToolTipText(Messages.DiffTableViewer_show_filters);
            btnTypeFilter.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    FilterDialog dialog = new FilterDialog(
                            getShell(), viewerFilter.types, viewerFilter.sides);
                    if(dialog.open() == Dialog.OK) {
                        btnTypeFilter.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                                Activator.getContext().getBundle().getResource(
                                        viewerFilter.types.isEmpty() && viewerFilter.sides.isEmpty()
                                        ? FILE.ICONEMPTYFILTER : FILE.ICONFILTER))));
                        viewer.refresh();
                    }
                }
            });
        }

        txtFilterName = new Text(upperComp, SWT.BORDER | SWT.SEARCH | SWT.ICON_SEARCH | SWT.ICON_CANCEL);
        GridData gd = new GridData(SWT.FILL, SWT.CENTER, false, false);
        gd.widthHint = pc.convertWidthInCharsToPixels(30);
        txtFilterName.setLayoutData(gd);
        txtFilterName.setMessage(Messages.diffTableViewer_object_name);

        useRegEx = new Button(upperComp, SWT.CHECK);
        useRegEx.setToolTipText(Messages.diffTableViewer_use_java_regular_expressions_see_more);
        useRegEx.setText(Messages.diffTableViewer_use_regular_expressions);
        useRegEx.setLayoutData(new GridData(SWT.DEFAULT, SWT.CENTER, false, false));
        useRegEx.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                viewerFilter.setUseRegEx(useRegEx.getSelection());
                viewer.refresh();
            }
        });

        Label l = new Label(upperComp, SWT.NONE);
        l.setEnabled(false);

        if (lineManager != null) {
            l.setText(Messages.DiffTableViewer_apply_to);
            l.setLayoutData(new GridData(SWT.END, SWT.CENTER, true, false));

            Button commitChanges = new Button(upperComp, SWT.PUSH);
            commitChanges.setText(Messages.DiffTableViewer_to_project);
            commitChanges.setImage(lrm.createImage(ImageDescriptor.createFromURL(Activator.getContext()
                    .getBundle().getResource(FILE.ICONAPPSMALL))));
            commitChanges.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
                    if (editor instanceof ProjectEditorDiffer) {
                        try {
                            ((ProjectEditorDiffer) editor).commit();
                        } catch (PgCodekeeperException ex) {
                            ExceptionNotifier.notifyDefault(Messages.error_creating_dependency_graph, ex);
                        }
                    }
                }
            });

            Button diffChanges = new Button(upperComp, SWT.PUSH);
            diffChanges.setText(Messages.DiffTableViewer_to_database);
            diffChanges.setImage(lrm.createImage(ImageDescriptor.createFromURL(Activator.getContext()
                    .getBundle().getResource(FILE.ICONDATABASE))));
            diffChanges.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
                    if (editor instanceof ProjectEditorDiffer) {
                        ((ProjectEditorDiffer) editor).diff();
                    }
                }
            });


            Button getChanges = new Button(upperComp, SWT.PUSH);
            getChanges.setImage(lrm.createImage(ImageDescriptor.createFromURL(Activator.getContext()
                    .getBundle().getResource(FILE.ICONREFRESH))));
            getChanges.setText(Messages.DiffTableViewer_get_changes);
            getChanges.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
                    if (editor instanceof ProjectEditorDiffer) {
                        ((ProjectEditorDiffer) editor).getChanges();
                    }
                }
            });

        } else {
            l.setText("|"); //$NON-NLS-1$

            if (!viewOnly) {
                lblCheckedCount = new Label(upperComp, SWT.NONE);
            }
            lblObjectCount = new Label(upperComp, SWT.NONE);
        }

        updateObjectsLabels();
        // end upper composite

        int viewerStyle = SWT.MULTI | SWT.FULL_SELECTION | SWT.BORDER;
        if (!viewOnly) {
            viewerStyle |= SWT.CHECK;
        }
        viewer = new CheckboxTreeViewer(new Tree(this, viewerStyle));

        txtFilterName.addModifyListener(e -> {
            // TODO aggregate events with small input lengths for performance
            // "postModifyListener"
            viewerFilter.setFilter(txtFilterName.getText());
            viewer.refresh();
        });

        viewer.addSelectionChangedListener(event -> {
            oldSelection = newSelection;
            newSelection = (IStructuredSelection)event.getSelection();
        });

        viewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
        viewer.getTree().setLinesVisible(true);
        viewer.getTree().setHeaderVisible(true);

        viewer.getControl().setMenu(
                getViewerMenu().createContextMenu(viewer.getControl()));

        if (!viewOnly) {
            viewer.addCheckStateListener(new CheckStateListener());
            checkProvider = new CheckStateProvider();
            viewer.setCheckStateProvider(checkProvider);
            viewer.addTreeListener(new RefreshCheckedTreeListener());
        } else {
            checkProvider = null;
        }
        // resolves a bottleneck in findItems() which is very hot
        // and slow when using native API impl
        viewer.setUseHashlookup(true);
        viewer.setComparator(comparator);
        viewer.setFilters(viewerFilter);
        initColumns();
        viewer.setContentProvider(contentProvider);
    }

    private MenuManager getViewerMenu() {
        MenuManager menuMgr = new MenuManager();
        if (!viewOnly) {
            menuMgr.add(new Action(Messages.diffTableViewer_select_child_elements) {

                @Override
                public void run() {
                    setSelectionSubtreesChecked((IStructuredSelection) viewer.getSelection(), true);
                }
            });
            menuMgr.add(new Action(Messages.diffTableViewer_deselect_child_elements) {

                @Override
                public void run() {
                    setSelectionSubtreesChecked((IStructuredSelection) viewer.getSelection(), false);
                }
            });
            menuMgr.add(new Separator());
            menuMgr.add(new Action(Messages.diffTableViewer_mark_selected_elements) {

                @Override
                public void run() {
                    setElementsChecked(((IStructuredSelection) viewer.getSelection()).toList(), true, false);
                }
            });
            menuMgr.add(new Action(Messages.diffTableViewer_unmark_selected_elements) {

                @Override
                public void run() {
                    setElementsChecked(((IStructuredSelection) viewer.getSelection()).toList(), false, false);
                }
            });
            menuMgr.add(new Separator());
        }
        menuMgr.add(new Action(Messages.diffTableViewer_open_diff_in_new_window) {

            @Override
            public void run() {
                TreeElement el = (TreeElement)
                        ((IStructuredSelection) viewer.getSelection()).getFirstElement();
                new DiffPaneDialog(getShell(), el, getElements(), dbProject, dbRemote).open();
            }
        });

        menuMgr.addMenuListener(manager -> {
            boolean enable = !viewer.getSelection().isEmpty();
            for (IContributionItem it : manager.getItems()) {
                if (it instanceof ActionContributionItem) {
                    ((ActionContributionItem) it).getAction().setEnabled(enable);
                }
            }
        });

        return menuMgr;
    }

    private void initColumns() {
        columnCheck = new TreeViewerColumn(viewer, SWT.LEFT);
        columnCheck.getColumn().setResizable(!viewOnly);
        columnCheck.getColumn().setMoveable(!viewOnly);

        columnCheck.getColumn().addSelectionListener(getHeaderSelectionAdapter(Columns.CHECK));

        columnCheck.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                return ""; //$NON-NLS-1$
            }
        });

        columnType = new TreeViewerColumn(viewer, SWT.LEFT);
        columnChange = new TreeViewerColumn(viewer, SWT.LEFT);
        columnName = new TreeViewerColumn(viewer, SWT.LEFT);
        columnLocation = new TreeViewerColumn(viewer, SWT.LEFT);

        columnName.getColumn().setResizable(true);
        columnName.getColumn().setMoveable(true);

        columnType.getColumn().setResizable(true);
        columnType.getColumn().setMoveable(true);

        columnChange.getColumn().setResizable(true);
        columnChange.getColumn().setMoveable(true);

        columnLocation.getColumn().setResizable(true);
        columnLocation.getColumn().setMoveable(true);

        setColumnHeaders();

        columnCheck.getColumn().setToolTipText(Messages.DiffTableViewer_reset_sorting);
        columnName.getColumn().setToolTipText(Messages.DiffTableViewer_reset_sorting);
        columnType.getColumn().setToolTipText(Messages.DiffTableViewer_reset_sorting);
        columnChange.getColumn().setToolTipText(Messages.DiffTableViewer_reset_sorting);
        columnLocation.getColumn().setToolTipText(Messages.DiffTableViewer_reset_sorting);

        columnName.getColumn().addSelectionListener(getHeaderSelectionAdapter(Columns.NAME));
        columnType.getColumn().addSelectionListener(getHeaderSelectionAdapter(Columns.TYPE));
        columnChange.getColumn().addSelectionListener(getHeaderSelectionAdapter(Columns.CHANGE));
        columnLocation.getColumn().addSelectionListener(getHeaderSelectionAdapter(Columns.LOCATION));

        updateColumnsWidth();

        columnName.setLabelProvider(new StyledCellLabelProvider(){

            @Override
            public void update(ViewerCell cell) {
                String name = ((TreeElement)cell.getElement()).getName();
                cell.setText(name);

                Region loc = viewerFilter.getMatchingLocation(name, viewerFilter.filterName,
                        viewerFilter.useRegEx ? viewerFilter.regExPattern : null);
                if (loc != null) {
                    StyleRange highlightMatch = new StyleRange(loc.getOffset(),
                            loc.getLength(), null,
                            getDisplay().getSystemColor(SWT.COLOR_YELLOW));
                    cell.setStyleRanges(new StyleRange[] { highlightMatch });
                } else {
                    cell.setStyleRanges(null);
                }
                super.update(cell);
            }
        });

        columnType.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                return ((TreeElement) element).getType().toString();
            }

            @Override
            public Image getImage(Object element) {
                return Activator.getDbObjImage(((TreeElement) element).getType());
            }
        });

        columnChange.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                switch (((TreeElement) element).getSide()) {
                case BOTH: return "edit"; //$NON-NLS-1$
                case LEFT: return "project"; //$NON-NLS-1$
                case RIGHT: return "remote"; //$NON-NLS-1$
                default: return null;
                }
            }

            @Override
            public Image getImage(Object element) {
                switch (((TreeElement) element).getSide()) {
                case BOTH: return iSideBoth;
                case LEFT: return iSideLeft;
                case RIGHT: return iSideRight;
                default: return null;
                }
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
        columnCheck.getColumn().setText("✓"); //$NON-NLS-1$
        columnName.getColumn().setText(Messages.diffTableViewer_object_name);
        columnType.getColumn().setText(Messages.diffTableViewer_object_type);
        columnChange.getColumn().setText(Messages.diffTableViewer_change_type);
        columnLocation.getColumn().setText(Messages.diffTableViewer_container);
    }

    private void updateColumnsWidth(){
        PixelConverter pc = new PixelConverter(viewer.getControl());
        // set check column size to 4 chars
        columnCheck.getColumn().setWidth(viewOnly ? 0 : pc.convertWidthInCharsToPixels(10));
        // name column will take half of the space
        int width = (int)(viewer.getControl().getSize().x * 0.5f);
        columnName.getColumn().setWidth(Math.max(width, 200));
        // set type column size to 19 chars to fit "CONSTRAINT" in
        columnType.getColumn().setWidth(pc.convertWidthInCharsToPixels(19));
        // set change type column size to 14 chars
        columnChange.getColumn().setWidth(pc.convertWidthInCharsToPixels(14));
        // location takes the rest
        columnLocation.getColumn().pack();
    }

    private SelectionAdapter getHeaderSelectionAdapter(final Columns index) {
        return new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                if ((e.stateMask & SWT.CTRL) != 0){
                    comparator.clearSortList();
                    setColumnHeaders();
                }
                sortViewer(index);
            }
        };
    }

    private void sortViewer(Columns index) {
        comparator.addSort(index);
        updateSortIndexes();
        viewer.refresh();
    }

    private void updateSortIndexes(){
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (TableViewerComparator.SortingColumn col : comparator.sortOrder) {
            sb.setLength(0);
            sb.append(comparator.sortOrder.size() - i++)
            .append(!col.desc ? '\u25BF' : '\u25B5')
            .append('\t');

            switch (col.col) {
            case CHECK:
                sb.setLength(sb.length() - 1);
                columnCheck.getColumn().setText(sb.append('✓').toString());
                break;
            case TYPE:
                columnType.getColumn().setText(sb.append(Messages.diffTableViewer_object_type).toString());
                break;
            case CHANGE:
                columnChange.getColumn().setText(sb.append(Messages.diffTableViewer_change_type).toString());
                break;
            case NAME:
                columnName.getColumn().setText(sb.append(Messages.diffTableViewer_object_name).toString());
                break;
            case LOCATION:
                columnLocation.getColumn().setText(sb.append(Messages.diffTableViewer_container).toString());
                break;
            }
        }
    }

    public void addCheckStateListener(ICheckStateListener listener) {
        programmaticCheckListeners.add(listener);
    }

    private void saveCheckedElements2ClipboardAsExpession(){
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        for (TreeElement el : elements) {
            if (!el.isSelected()) {
                continue;
            }
            if (!first) {
                sb.append('|');
            } else {
                first = false;
            }
            String name = el.getName();
            if (REGEX_SPECIAL_CHARS.matcher(name).find()) {
                name = Pattern.quote(name);
            }
            sb.append('^').append(name).append('$');
        }

        if (sb.length() != 0) {
            Clipboard clip = new Clipboard(getDisplay());
            try {
                clip.setContents(new String[] { sb.toString() },
                        new TextTransfer[] { TextTransfer.getInstance() });
            } finally {
                clip.dispose();
            }
        }
    }

    public void setAutoExpand(boolean enabled) {
        viewer.setAutoExpandLevel(enabled ? AbstractTreeViewer.ALL_LEVELS : 0);
    }

    public void setInput(DbSource dbProject, DbSource dbRemote, TreeElement diffTree,
            IgnoreList ignoreList) {
        setInputCollection(diffTree == null ? Collections.<TreeElement>emptyList() :
            new TreeFlattener()
            .onlyEdits(dbProject.getDbObject(), dbRemote.getDbObject())
            .useIgnoreList(ignoreList, dbRemote.getDbName())
            .flatten(diffTree), dbProject, dbRemote);
    }

    /**
     * Используется в коммит диалоге для установки элементов
     * @param elements элементы для показа
     */
    public void setInputCollection(Collection<TreeElement> elements,
            DbSource dbProject, DbSource dbRemote) {
        this.dbProject = dbProject;
        this.dbRemote = dbRemote;

        // reset sorting while using empty input
        // no full re-sorts, no full refreshes
        viewer.setInput(null);
        comparator.clearSortList();
        sortViewer(Columns.NAME);
        sortViewer(Columns.CHANGE);
        sortViewer(Columns.TYPE);
        sortViewer(Columns.LOCATION);

        this.elements.clear();
        this.elements.addAll(elements);
        viewer.setInput(this.elements);
        updateColumnsWidth();

        updateObjectsLabels();
    }

    private void setChecked(TreeElement el, boolean checked) {
        if (elements.contains(el)) {
            // меняем состояние только элементов в наборе
            el.setSelected(checked);
        }
        if (isContainer(el)) {
            setCheckedGrayed(el, null);
        } else {
            viewer.setChecked(el, checked);
            if (isSubElement(el)) {
                setCheckedGrayed(el.getParent(), null);
            }
        }
    }

    private void setCheckedGrayed(TreeElement el, Boolean providedExpandedState) {
        Entry<Boolean, Boolean> pair = checkProvider.getState(el, providedExpandedState);
        viewer.setChecked(el, pair.getKey());
        viewer.setGrayed(el, pair.getValue());
    }

    private void viewerChecksUpdated() {
        updateObjectsLabels();
        for (ICheckStateListener list : programmaticCheckListeners) {
            list.checkStateChanged(null);
        }
    }

    private void updateObjectsLabels() {
        int count = elements.size();
        int checked = getCheckedElementsCount();
        if (lineManager != null) {
            lineManager.setMessage(lrm.createImage(ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(FILE.ICONAPPSMALL))),
                    MessageFormat.format(Messages.DiffTableViewer_selected_count, checked, count));
        } else {
            lblObjectCount.setText(MessageFormat.format(Messages.diffTableViewer_objects, count));
            if (!viewOnly) {
                lblCheckedCount.setText(MessageFormat.format(Messages.DiffTableViewer_selected,
                        checked));
            }
            lblObjectCount.getParent().layout();
        }
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

    private void setElementsChecked(Collection<?> elements, boolean state,
            boolean checkFilterMatch) {
        setElementsChecked(elements, el -> state, checkFilterMatch);
    }

    private void setElementsChecked(Collection<?> elements, Predicate<TreeElement> state,
            boolean checkFilterMatch) {
        Stream<TreeElement> stream = elements.stream().map(o -> (TreeElement) o);
        if (checkFilterMatch) {
            stream = stream.filter(el -> viewerFilter.select(viewer, el.getParent(), el));
        }
        stream.forEach(el -> setChecked(el, state.test(el)));

        viewerChecksUpdated();
    }

    private void setSelectionSubtreesChecked(IStructuredSelection selection, boolean checked) {
        for (Object o : selection.toList()) {
            TreeElement el = (TreeElement) o;
            setSubTreeChecked(el, checked);
        }
        viewerChecksUpdated();
    }

    private void setSubTreeChecked(TreeElement element, boolean selected) {
        setChecked(element, selected);
        for (TreeElement child : element.getChildren()) {
            setSubTreeChecked(child, selected);
        }
    }

    static boolean isContainer(TreeElement el) {
        return el.getType() == DbObjType.TABLE || el.getType() == DbObjType.VIEW;
    }

    static boolean isSubElement(TreeElement el) {
        TreeElement parent = el.getParent();
        return parent != null && isContainer(parent);
    }

    private class DiffContentProvider implements ITreeContentProvider {

        @Override
        public Object[] getElements(Object inputElement) {
            Collection<?> input = (Collection<?>) inputElement;
            Set<TreeElement> rootTableEntries = new HashSet<>(input.size());
            for (Object o : input) {
                TreeElement el = (TreeElement) o;
                rootTableEntries.add(isSubElement(el) ? el.getParent() : el);
            }
            return rootTableEntries.toArray();
        }

        @Override
        public Object[] getChildren(Object parentElement) {
            if (!(parentElement instanceof TreeElement)) {
                // process as root input (Collection of elements)
                return getElements(parentElement);
            }
            TreeElement el = (TreeElement) parentElement;
            if (isContainer(el) && el.hasChildren()) {
                List<TreeElement> children = el.getChildren();
                List<TreeElement> childrenInInput = new ArrayList<>(children.size());
                for (TreeElement child : children) {
                    if (elements.contains(child)) {
                        childrenInInput.add(child);
                    }
                }
                return childrenInInput.toArray();
            } else {
                return ApgdiffConsts.EMPTY_ARRAY;
            }
        }

        @Override
        public Object getParent(Object element) {
            TreeElement el = (TreeElement) element;
            return isSubElement(el) ? el.getParent() : null;
        }

        @Override
        public boolean hasChildren(Object element) {
            TreeElement el = (TreeElement) element;
            if (isContainer(el) && el.hasChildren()) {
                for (TreeElement child : el.getChildren()) {
                    if (elements.contains(child)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private class CheckStateListener implements ICheckStateListener {

        @Override
        public void checkStateChanged(CheckStateChangedEvent event) {
            List<?> selection = getSelectionList(oldSelection);
            if (selection.contains(event.getElement())) {
                for (Object element : selection) {
                    setChecked(element, event.getChecked());
                }
                viewer.setSelection(oldSelection);
            } else {
                setChecked(event.getElement(), event.getChecked());
            }
            viewerChecksUpdated();
        }

        private List<?> getSelectionList(IStructuredSelection selection) {
            return (selection != null && selection.size() > 1) ? selection.toList()
                    : Collections.emptyList();
        }

        private void setChecked(Object element, boolean checked) {
            TreeElement el = (TreeElement) element;
            if (isContainer(el)) {
                setSubTreeChecked(el, checked);
            }
            // explicitly check root even when using setSubTreeChecked
            // in case it's not in the viewer's input set
            DiffTableViewer.this.setChecked(el, checked);
        }
    }

    private class CheckStateProvider implements ICheckStateProvider {

        @Override
        public boolean isChecked(Object element) {
            TreeElement el = (TreeElement)element;
            if (el.isSelected()) {
                return true;
            }
            // gray nodes need selection to show gray state
            return contGraySelected(el, null);
        }

        @Override
        public boolean isGrayed(Object element) {
            return contGraySelected((TreeElement) element, null);
        }

        private Entry<Boolean, Boolean> getState(TreeElement el, Boolean providedExpandedState) {
            Boolean grayed = contGraySelected(el, providedExpandedState);
            return new SimpleEntry<>(el.isSelected() ? true : grayed, grayed);
        }

        /**
         * @param providedExpandedState element's expanded state, if null viewer is queried
         */
        private boolean contGraySelected(TreeElement el, Boolean providedExpandedState) {
            if (!isContainer(el) || !el.hasChildren() ||
                    (providedExpandedState != null ? providedExpandedState : viewer.getExpandedState(el))) {
                return false;
            }
            boolean hasChecked = false;
            boolean hasUnchecked = false;
            for (TreeElement child : el.getChildren()) {
                if (elements.contains(child)) {
                    if (child.isSelected()) {
                        hasChecked = true;
                    } else {
                        hasUnchecked = true;
                    }
                }
                if (hasChecked && hasUnchecked) {
                    // has both states, no further checking required
                    // also this state is always grayed so we may return here
                    return true;
                }
            }
            // both false means no subelements shown, no gray state needed
            // otherwise hasChecked means ALL or NONE checked at this point
            // and we can use XOR boolean function to get required gray state
            // ALL  PAR  GRAY
            //  0    0    0
            //  0    1    1
            //  1    0    1
            //  1    1    0
            return (hasChecked || hasUnchecked) &&
                    (hasChecked ^ el.isSelected());
        }
    }

    private class RefreshCheckedTreeListener implements ITreeViewerListener {

        @Override
        public void treeExpanded(TreeExpansionEvent event) {
            setCheckedGrayed((TreeElement) event.getElement(), true);
        }

        @Override
        public void treeCollapsed(TreeExpansionEvent event) {
            setCheckedGrayed((TreeElement) event.getElement(), false);
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
                return obj instanceof SortingColumn
                        && ((SortingColumn) obj).col == col;
            }

            @Override
            public int hashCode() {
                return col.hashCode();
            }
        }

        private final LinkedList<SortingColumn> sortOrder = new LinkedList<>();

        public void clearSortList() {
            sortOrder.clear();
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

    private class TableViewerFilter extends ViewerFilter {

        private final Collection<DbObjType> types = EnumSet.noneOf(DbObjType.class);
        private final Collection<DiffSide> sides = EnumSet.noneOf(DiffSide.class);
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
            TreeElement el = (TreeElement) element;
            boolean isSubElement = isSubElement(el);

            if (!types.isEmpty() && !isSubElement && !types.contains(el.getType())
                    || !sides.isEmpty() && !sides.contains(el.getSide())) {
                return false;
            }

            if (filterName == null) {
                return true;
            }
            Pattern filterRegex = useRegEx ? regExPattern : null;

            // show all child, if parent have match
            TreeElement parent = el.getParent();
            if (isSubElement && getMatchingLocation(parent.getName(), filterName, filterRegex) != null){
                return true;
            }

            boolean found = getMatchingLocation(el.getName(), filterName, filterRegex) != null;

            // also show containers that have content matching current filter
            if (!found && isContainer(el)) {
                Iterator<TreeElement> it = el.getChildren().iterator();
                while (!found && it.hasNext()) {
                    TreeElement child = it.next();
                    found |= elements.contains(child) &&
                            getMatchingLocation(child.getName(), filterName, filterRegex) != null;
                }
            }
            return found;
        }

        private Region getMatchingLocation(String text, String filter, Pattern regExPattern) {
            if (filter != null && !filter.isEmpty() && text != null) {
                String textLc = text.toLowerCase();
                int offset = -1;
                int length = 0;
                if (regExPattern != null) {
                    Matcher matcher = regExPattern.matcher(textLc);
                    if (matcher.find()) {
                        offset = matcher.start();
                        length = matcher.end() - offset;
                    }
                } else {
                    offset = textLc.indexOf(filter);
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