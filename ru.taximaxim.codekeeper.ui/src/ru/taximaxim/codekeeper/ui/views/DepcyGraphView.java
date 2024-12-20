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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.AbstractZoomableViewer;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.eclipse.zest.core.viewers.IZoomableWorkbenchPart;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;

import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.core.model.graph.SimpleDepcyResolver;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.UIConsts.COMMAND;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DepcyGraphView extends ViewPart implements IZoomableWorkbenchPart, ISelectionListener {

    private final Action projectAction;
    private final Action remoteAction;
    private final Action addColumnAction;
    private GraphViewer gv;
    private DepcyGraphLabelProvider labelProvider;

    private SimpleDepcyResolver depRes;
    private IWorkbenchPart lastSelectionPart;
    private ISelection lastSelection;
    private IProject currentProject;
    private boolean isShowColumns;

    public DepcyGraphView() {
        projectAction = new ProjectAction(Messages.DepcyGraphView_project,
                Activator.getRegisteredDescriptor(ProjectIcon.BALL_BLUE));
        remoteAction = new ToggleAction(Messages.DepcyGraphView_remote,
                Activator.getRegisteredDescriptor(ProjectIcon.BALL_GREEN));
        addColumnAction = new ShowColumnAction(Messages.DepcyGraphView_show_columns,
                Activator.getRegisteredDescriptor(ProjectIcon.COLUMN));
    }

    @Override
    public void init(IViewSite site) throws PartInitException {
        super.init(site);

        IToolBarManager toolman = getViewSite().getActionBars().getToolBarManager();

        CommandContributionItemParameter param = new CommandContributionItemParameter(
                getViewSite(), null, COMMAND.ADD_DEPCY, CommandContributionItem.STYLE_PUSH);
        param.icon = Activator.getRegisteredDescriptor(ProjectIcon.ADD_DEP);

        toolman.add(new CommandContributionItem(param));

        toolman.add(new ActionContributionItem(addColumnAction));

        ActionContributionItem ac = new ActionContributionItem(projectAction);
        ac.setMode(ActionContributionItem.MODE_FORCE_TEXT);
        toolman.add(ac);

        ac = new ActionContributionItem(remoteAction);
        ac.setMode(ActionContributionItem.MODE_FORCE_TEXT);
        toolman.add(ac);
    }

    @Override
    public void createPartControl(Composite parent) {
        gv = new GraphViewer(parent, SWT.NONE);
        gv.setNodeStyle(ZestStyles.NODES_NO_ANIMATION);
        gv.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
        gv.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);

        labelProvider = new DepcyGraphLabelProvider(gv.getControl());
        gv.setLabelProvider(labelProvider);
        gv.setContentProvider(new DepcyGraphViewContentProvider());

        // listen to node/connection selection events
        gv.getGraphControl().addSelectionListener(new SelectionAdapter() {
        });

        // register listener to pages post selection
        getSite().getPage().addPostSelectionListener(this);

        gv.getGraphControl().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                ISelection selection = gv.getSelection();
                if (currentProject != null && !selection.isEmpty()
                        && selection instanceof IStructuredSelection ss
                        && ss.getFirstElement() instanceof PgStatement st) {
                    try {
                        FileUtilsUi.openFileInSqlEditor(
                                st.getLocation(), currentProject.getName(), st.getDbType(), st.isLib());
                    } catch (PartInitException ex) {
                        ExceptionNotifier.notifyDefault(ex.getLocalizedMessage(), ex);
                    }
                }
            }
        });
    }

    @Override
    public void setFocus() {
        gv.getControl().setFocus();
    }

    @Override
    public void dispose() {
        getSite().getPage().removePostSelectionListener(this);
        super.dispose();
    }

    @Override
    public AbstractZoomableViewer getZoomableViewer() {
        return gv;
    }

    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        if (!(selection instanceof IStructuredSelection)) {
            return;
        }

        IProject selectedProj = null;
        DBPair dbPair = null;
        List<?> selected = ((IStructuredSelection) selection).toList();

        for (Object object : selected) {
            if (object instanceof DBPair pair) {
                dbPair = pair;
            } else if (object instanceof IProject proj) {
                selectedProj = proj;
            }
        }
        if (dbPair == null) {
            return;
        }
        lastSelectionPart = part;
        lastSelection = selection;
        currentProject = selectedProj;

        boolean showProject = projectAction.isChecked();
        AbstractDatabase newDb = showProject ? dbPair.dbProject.getDbObject() : dbPair.dbRemote.getDbObject();
        AbstractDatabase currentDb = newDb;
        depRes = new SimpleDepcyResolver(currentDb, isShowColumns);
        if (currentDb == null || depRes == null) {
            gv.setInput(null);
            return;
        }

        Set<PgStatement> newInput = new HashSet<>();
        Set<PgStatement> rootSet = new HashSet<>();
        for (Object object : selected) {
            if (object instanceof TreeElement el) {
                // does el exist in the chosen graph (or DB)
                boolean elIsProject = el.getSide() == DiffSide.LEFT;
                if (elIsProject == showProject || el.getSide() == DiffSide.BOTH) {
                    PgStatement root = el.getPgStatement(currentDb);
                    rootSet.add(root);
                    for (PgStatement dependant : depRes.getDropDepcies(root)) {
                        newInput.add(dependant);
                    }
                }
            }
        }
        labelProvider.setCurrentRootSet(rootSet);
        gv.setInput(newInput);
    }

    private class DepcyGraphViewContentProvider implements IGraphEntityContentProvider {

        @Override
        public Object[] getElements(Object inputElement) {
            return ArrayContentProvider.getInstance().getElements(inputElement);
        }

        @Override
        public Object[] getConnectedTo(Object entity) {
            if (entity instanceof PgStatement st) {
                return depRes.getConnectedTo(st).toArray();
            }
            return null;
        }
    }

    private static class ToggleAction extends Action {

        public ToggleAction(String text, ImageDescriptor imgDesc) {
            super(text, AS_RADIO_BUTTON);
            setImageDescriptor(imgDesc);
        }
    }

    private class ShowColumnAction extends Action {

        public ShowColumnAction(String text, ImageDescriptor imgDesc) {
            super(text, AS_CHECK_BOX);
            setImageDescriptor(imgDesc);
            setToolTipText(text);
        }

        @Override
        public void run() {
            isShowColumns = addColumnAction.isChecked();
            selectionChanged(lastSelectionPart, lastSelection);
        }
    }

    private class ProjectAction extends ToggleAction {

        public ProjectAction(String text, ImageDescriptor imgDesc) {
            super(text, imgDesc);
            setChecked(true);
        }

        @Override
        public void run() {
            labelProvider.setIsSource(isChecked());
            selectionChanged(lastSelectionPart, lastSelection);
        }
    }
}
