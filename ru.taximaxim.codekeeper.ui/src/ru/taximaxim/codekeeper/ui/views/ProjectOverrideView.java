/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.views;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgOverride;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.comparetools.CompareAction;
import ru.taximaxim.codekeeper.ui.comparetools.CompareInput;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectOverrideView extends ViewPart implements ISelectionListener {

    private TableViewer viewer;

    private boolean filterStatement;

    private IWorkbenchPart part;
    private ISelection selection;
    private IProject project;

    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        this.part = part;
        this.selection = selection;

        if (!(selection instanceof IStructuredSelection)) {
            return;
        }

        DBPair dbPair = null;
        List<?> selected = ((IStructuredSelection) selection).toList();
        for (Object object : selected) {
            if (object instanceof DBPair pair) {
                dbPair = pair;
            } else if (object instanceof IProject proj) {
                project = proj;
            }
        }

        if (dbPair == null) {
            viewer.setInput(null);
            return;
        }

        AbstractDatabase db = dbPair.dbProject.getDbObject();

        List<PgOverride> overrides = db.getOverrides();

        if (!filterStatement) {
            viewer.setInput(overrides);
        } else {
            viewer.setInput(overrides.stream()
                    .filter(o -> selected.stream()
                            .filter(TreeElement.class::isInstance)
                            .map(TreeElement.class::cast)
                            .filter(e -> e.getSide() != DiffSide.RIGHT)
                            .map(e -> e.getPgStatement(db))
                            .anyMatch(st -> o.getNewStatement().equals(st)))
                    .toList());
        }
    }

    @Override
    public void init(IViewSite site) throws PartInitException {
        super.init(site);

        Action action = new Action(Messages.ProjectOverrideView_link_with_editor, IAction.AS_CHECK_BOX) {

            @Override
            public void run() {
                setState(!filterStatement);
                selectionChanged(part, selection);
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
        viewer = new TableViewer(parent, SWT.FULL_SELECTION);
        viewer.setContentProvider(ArrayContentProvider.getInstance());
        viewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
        viewer.getTable().setLinesVisible(true);
        viewer.getTable().setHeaderVisible(true);

        addColumns();

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

            @Override
            public boolean isEnabled() {
                return canOpen(false);
            }
        });

        menuMgr.add(new Action(Messages.ProjectOverrideView_open_old_location) {

            @Override
            public void run() {
                openFile(true);
            }

            @Override
            public boolean isEnabled() {
                return canOpen(true);
            }
        });

        menuMgr.add(new Action(Messages.diffTableViewer_open_diff_in_new_window) {

            @Override
            public void run() {
                ISelection sel = viewer.getSelection();
                if (!sel.isEmpty() && sel instanceof IStructuredSelection ss) {
                    Object obj = ss.getFirstElement();
                    if (obj instanceof PgOverride override) {
                        CompareAction.openCompareEditor(new CompareInput(override));
                    }
                }
            }
        });

        menuMgr.addMenuListener(manager -> {
            boolean enable = !viewer.getSelection().isEmpty();
            for (IContributionItem item : manager.getItems()) {
                if (item instanceof ActionContributionItem actionItem) {
                    actionItem.getAction().setEnabled(enable);
                }
            }
        });

        return menuMgr;
    }

    private void openFile(boolean openOldFile) {
        ISelection sel = viewer.getSelection();
        if (!sel.isEmpty() && sel instanceof IStructuredSelection ss) {
            Object obj = ss.getFirstElement();
            if (obj instanceof PgOverride ov) {
                try {
                    PgStatement st = openOldFile ? ov.getOldStatement() : ov.getNewStatement();
                    PgObjLocation loc = st.getLocation();
                    String proj = project == null ? null : project.getName();
                    FileUtilsUi.openFileInSqlEditor(loc, proj, st.getDbType(), st.isLib());
                } catch (PartInitException ex) {
                    ExceptionNotifier.notifyDefault(ex.getLocalizedMessage(), ex);
                }
            }
        }
    }

    private boolean canOpen(boolean isOld) {
        ISelection sel = viewer.getSelection();
        if (!sel.isEmpty() && sel instanceof IStructuredSelection ss) {
            Object obj = ss.getFirstElement();
            if (obj instanceof PgOverride ov) {
                PgStatement st = isOld ? ov.getOldStatement() : ov.getNewStatement();
                return st.getLocation() != null;
            }
        }

        return false;
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
                return c.getOldPath();
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
                return c.getNewPath();
            }
        });

        type.getColumn().setWidth(150);
        name.getColumn().setWidth(150);
        oldLocation.getColumn().setWidth(300);
        newLocation.getColumn().setWidth(300);
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
