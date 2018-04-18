package ru.taximaxim.codekeeper.ui.views;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgOverride;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.VIEW;
import ru.taximaxim.codekeeper.ui.UiSync;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectOverrideView extends ViewPart implements ISelectionListener {

    private TableViewer viewer;

    private boolean filterStatement;
    private PgDatabase db;
    private List<?> selected;

    public static void fillView(PgDatabase db, boolean isSafeMode) {
        List<PgOverride> overrides = db.getOverrides();

        if (!overrides.isEmpty()) {
            UiSync.exec(PlatformUI.getWorkbench().getDisplay(), () -> {
                try {
                    ((ProjectOverrideView) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                            .getActivePage().showView(VIEW.OVERRIDE_VIEW)).setDatabase(db, null);
                } catch (PartInitException e) {
                    ExceptionNotifier.notifyDefault(e.getLocalizedMessage(), e);
                }
            });

            if (isSafeMode) {
                throw new IllegalArgumentException("Library duplication exception"); //$NON-NLS-1$
            }
        }
    }

    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            List<?> selected = ((IStructuredSelection) selection).toList();
            DBPair dss = selected.stream().filter(e -> e instanceof DBPair)
                    .map(e -> (DBPair)e).findAny().orElse(null);

            if (dss != null) {
                setDatabase(dss.dbProject.getDbObject(), selected);
            }
        }
    }

    public void setDatabase(PgDatabase db, List<?> selected) {
        this.db = db;
        this.selected = selected;

        List<PgOverride> overrides = db.getOverrides();

        if (!filterStatement || selected == null) {
            viewer.setInput(overrides);
        } else {
            viewer.setInput(overrides.stream()
                    .filter(o -> selected.stream()
                            .filter(e -> e instanceof TreeElement)
                            .map(e -> (TreeElement)e)
                            .filter(e -> e.getSide() != DiffSide.RIGHT)
                            .map(e -> e.getPgStatement(db))
                            .anyMatch(o::checkStatement))
                    .collect(Collectors.toList()));
        }
    }

    @Override
    public void init(IViewSite site) throws PartInitException {
        super.init(site);

        Action action = new Action(Messages.ProjectOverrideView_link_with_editor, Action.AS_CHECK_BOX) {

            @Override
            public void run() {
                setState(!filterStatement);
                setDatabase(db, selected);
            }

            private void setState(boolean state) {
                filterStatement = state;
                setChecked(state);
                viewer.refresh(false);
            }
        };

        action.setImageDescriptor(ImageDescriptor.createFromImage(
                Activator.getEclipseImage(ISharedImages.IMG_ELCL_SYNCED)));

        getViewSite().getActionBars().getToolBarManager().add(action);
    }

    @Override
    public void createPartControl(Composite parent) {
        viewer = new TableViewer(parent, SWT.NONE);

        viewer.setContentProvider(ArrayContentProvider.getInstance());
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 320;
        viewer.getTable().setLayoutData(gd);
        viewer.getTable().setLinesVisible(true);
        viewer.getTable().setHeaderVisible(true);

        addColumns();

        viewer.getTable().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                ISelection selection = viewer.getSelection();
                if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
                    Object obj = ((IStructuredSelection) selection).getFirstElement();
                    if (obj instanceof PgOverride) {
                        try {
                            FileUtilsUi.openFileInSqlEditor(((PgOverride)obj).getOldLocation());
                        } catch (PartInitException ex) {
                            ExceptionNotifier.notifyDefault(ex.getLocalizedMessage(), ex);
                        }
                    }
                }
            }
        });

        viewer.getControl().setMenu(getViewerMenu().createContextMenu(viewer.getControl()));
        getSite().getPage().addPostSelectionListener(this);
    }

    private MenuManager getViewerMenu() {
        MenuManager menuMgr = new MenuManager();

        menuMgr.add(new Action(Messages.ProjectOverrideView_open_new_location) {

            @Override
            public void run() {
                openFile(false);
            }
        });

        menuMgr.add(new Action(Messages.ProjectOverrideView_open_old_location) {

            @Override
            public void run() {
                openFile(true);
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

    private void openFile(boolean openOldFile) {
        ISelection selection = viewer.getSelection();
        if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
            Object obj = ((IStructuredSelection) selection).getFirstElement();
            if (obj instanceof PgOverride) {
                try {
                    PgOverride ov = (PgOverride)obj;
                    FileUtilsUi.openFileInSqlEditor(openOldFile ? ov.getOldLocation() : ov.getNewLocation());
                } catch (PartInitException ex) {
                    ExceptionNotifier.notifyDefault(ex.getLocalizedMessage(), ex);
                }
            }
        }
    }

    private void addColumns() {
        TableViewerColumn type = new TableViewerColumn(viewer, SWT.LEFT);
        type.getColumn().setResizable(true);
        type.getColumn().setMoveable(true);
        type.getColumn().setText(Messages.diffTableViewer_object_type);
        type.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                PgOverride c = (PgOverride) element;
                return c.getType().name();
            }
        });

        TableViewerColumn name = new TableViewerColumn(viewer, SWT.LEFT);
        name.getColumn().setResizable(true);
        name.getColumn().setMoveable(true);
        name.getColumn().setText(Messages.diffTableViewer_object_name);
        name.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                PgOverride c = (PgOverride) element;
                return c.getName();
            }
        });

        TableViewerColumn oldLocation = new TableViewerColumn(viewer, SWT.LEFT);
        oldLocation.getColumn().setResizable(true);
        oldLocation.getColumn().setMoveable(true);
        oldLocation.getColumn().setText(Messages.ProjectOverrideView_old_location);
        oldLocation.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                PgOverride c = (PgOverride) element;
                return c.getOldLocation();
            }
        });

        TableViewerColumn newLocation = new TableViewerColumn(viewer, SWT.LEFT);
        newLocation.getColumn().setResizable(true);
        newLocation.getColumn().setMoveable(true);
        newLocation.getColumn().setText(Messages.ProjectOverrideView_new_location);
        newLocation.setLabelProvider(new ColumnLabelProvider() {

            @Override
            public String getText(Object element) {
                PgOverride c = (PgOverride) element;
                return c.getNewLocation();
            }
        });

        int width = (int)(viewer.getTable().getSize().x * 0.25);
        type.getColumn().setWidth(Math.max(width, 150));
        name.getColumn().setWidth(Math.max(width, 150));
        oldLocation.getColumn().setWidth(Math.max(width, 300));
        newLocation.getColumn().setWidth(Math.max(width, 300));
    }

    @Override
    public void setFocus() {
        viewer.getControl().setFocus();
    }

    @Override
    public void dispose() {
        getSite().getPage().removePostSelectionListener(this);
        super.dispose();
    }
}
