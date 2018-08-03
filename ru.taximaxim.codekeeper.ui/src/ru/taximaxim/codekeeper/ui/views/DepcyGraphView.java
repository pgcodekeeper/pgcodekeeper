package ru.taximaxim.codekeeper.ui.views;

import java.util.ArrayList;
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
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyResolver;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.COMMAND;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DepcyGraphView extends ViewPart implements IZoomableWorkbenchPart, ISelectionListener {

    private final Action projectAction, remoteAction;
    private GraphViewer gv;
    private DepcyGraphLabelProvider labelProvider;

    private PgDatabase currentDb;
    private DepcyResolver depRes;
    private IWorkbenchPart lastSelectionPart;
    private ISelection lastSelection;
    private IProject currentProject;

    public DepcyGraphView() {
        projectAction = new ProjectAction(Messages.DepcyGraphView_project, ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONBALLBLUE)));
        remoteAction = new ToggleAction(Messages.DepcyGraphView_remote, ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONBALLGREEN)));
    }

    @Override
    public void init(IViewSite site) throws PartInitException {
        super.init(site);

        IToolBarManager toolman = getViewSite().getActionBars().getToolBarManager();

        CommandContributionItemParameter param = new CommandContributionItemParameter(
                getViewSite(), null, COMMAND.ADD_DEPCY, CommandContributionItem.STYLE_PUSH);
        param.icon = ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(FILE.ICONADDDEP));
        param.mode = CommandContributionItem.MODE_FORCE_TEXT;

        toolman.add(new CommandContributionItem(param));

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
                        && selection instanceof IStructuredSelection) {
                    Object obj = ((IStructuredSelection) selection).getFirstElement();
                    if (obj instanceof PgStatement) {
                        try {
                            FileUtilsUi.openFileInSqlEditor(((PgStatement)obj).getLocation());
                        } catch (PartInitException ex) {
                            ExceptionNotifier.notifyDefault(ex.getLocalizedMessage(), ex);
                        }
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
        DBPair dss = null;
        List<?> selected = ((IStructuredSelection) selection).toList();

        for (Object object : selected) {
            if (object instanceof DBPair) {
                dss = (DBPair) object;
            } else if (object instanceof IProject) {
                selectedProj  = (IProject) object;
            }
        }
        if (dss == null) {
            return;
        }
        lastSelectionPart = part;
        lastSelection = selection;
        currentProject = selectedProj;

        boolean showProject = projectAction.isChecked();
        PgDatabase newDb = showProject ? dss.dbProject.getDbObject() : dss.dbRemote.getDbObject();
        if (currentDb != newDb) {
            currentDb = newDb;
            depRes = new DepcyResolver(currentDb,
                    showProject ? dss.dbRemote.getDbObject() : dss.dbProject.getDbObject());
        }

        if (currentDb == null || depRes == null) {
            gv.setInput(null);
            return;
        }

        Set<PgStatement> newInput = new HashSet<>();
        for (Object object : selected) {
            if (object instanceof TreeElement){
                TreeElement el = (TreeElement) object;
                // does el exist in the chosen graph (or DB)
                boolean elIsProject = el.getSide() == DiffSide.LEFT;
                if (elIsProject == showProject || el.getSide() == DiffSide.BOTH) {
                    for (PgStatement dependant : depRes.getDropDepcies(el.getPgStatement(currentDb))) {
                        if (!(dependant instanceof AbstractColumn)) {
                            newInput.add(dependant);
                        }
                    }
                }
            }
        }
        gv.setInput(newInput);
    }

    private class DepcyGraphViewContentProvider implements IGraphEntityContentProvider {

        @Override
        public Object[] getElements(Object inputElement) {
            return ArrayContentProvider.getInstance().getElements(inputElement);
        }

        @Override
        public Object[] getConnectedTo(Object entity) {
            if (entity instanceof PgStatement){
                DirectedGraph<PgStatement, DefaultEdge> currentGraph = depRes.getOldGraph();
                if (currentGraph != null){
                    List<PgStatement> connected = new ArrayList<>();
                    for (DefaultEdge e : currentGraph.outgoingEdgesOf((PgStatement)entity)){
                        PgStatement connectedVertex = currentGraph.getEdgeTarget(e);
                        if (!(connectedVertex instanceof AbstractColumn)) {
                            connected.add(connectedVertex);
                        }
                    }
                    return connected.toArray();
                }
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
