package ru.taximaxim.codekeeper.ui.views;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.IStateListener;
import org.eclipse.core.commands.State;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.AbstractZoomableViewer;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.eclipse.zest.core.viewers.IZoomableWorkbenchPart;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyResolver;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.COMMAND;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class DepcyGraphView extends ViewPart implements IZoomableWorkbenchPart, ISelectionListener, IStateListener {

    private PgDatabase currentDb;
    private GraphViewer gv;
    private boolean isSource = true;
    private DepcyResolver depRes;
    private boolean isDBSource;

    private IWorkbenchPart currentPath;
    private ISelection currentSelection;
    private PgDbProject currentProject;

    @Override
    public void createPartControl(Composite parent) {
        gv = new GraphViewer(parent, SWT.NONE);
        gv.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
        gv.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);

        gv.setLabelProvider(new DepcyGraphLabelProvider(isSource));
        gv.setContentProvider(new DepcyGraphViewContentProvider());

        // listen to node/connection selection events
        gv.getGraphControl().addSelectionListener(new SelectionAdapter() {
        });

        // register listener to pages post selection
        getSite().getPage().addPostSelectionListener(this);

        gv.getGraphControl().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseDoubleClick(MouseEvent e) {
                List<?> nodes = gv.getGraphControl().getSelection();
                if (nodes != null && !nodes.isEmpty()) {
                    PgStatement node = (PgStatement) ((GraphNode) nodes.get(0)).getData();
                    openElementInEditor(node);
                }
            }
        });

        // register this as listener to command state
        ICommandService service = getSite().getService(ICommandService.class);
        service.getCommand(COMMAND.DEPCY_SRC).getState(COMMAND.DEPCY_SRC_STATE).addListener(this);
    }

    private void openElementInEditor(PgStatement pgState) {
        File projectDir = currentProject.getPathToProject().toFile();
        File file = new File(projectDir, "SCHEMA"); //$NON-NLS-1$

        PgStatement pgParent = pgState.getParent();
        String parentExportedFileName = pgParent == null ? null : ModelExporter.getExportedFilename(pgParent);

        switch (pgState.getStatementType()) {
        case EXTENSION:
            file = new File(projectDir, "EXTENSION"); //$NON-NLS-1$
            break;
        case SEQUENCE:
            file = new File(new File(file, parentExportedFileName), "SEQUENCE"); //$NON-NLS-1$
            break;
        case VIEW:
            file = new File(new File(file, parentExportedFileName), "VIEW"); //$NON-NLS-1$
            break;
        case TABLE:
            file = new File(new File(file, parentExportedFileName), "TABLE"); //$NON-NLS-1$
            break;
        case FUNCTION:
            file = new File(new File(file, parentExportedFileName), "FUNCTION"); //$NON-NLS-1$
            break;
        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
            pgState = pgParent;
            String schemaName = ModelExporter.getExportedFilename(pgParent.getParent());
            file = new File(new File(file, schemaName), "TABLE"); //$NON-NLS-1$
            break;
        case RULE:
            String schemaName4Rule = ModelExporter.getExportedFilename(pgParent.getParent());
            if (pgParent.getStatementType() == DbObjType.TABLE) {
                file = new File(new File(file, schemaName4Rule), "TABLE");//$NON-NLS-1$
            } else {
                if (pgParent.getStatementType() == DbObjType.VIEW) {
                    file = new File(new File(file, schemaName4Rule), "VIEW");//$NON-NLS-1$
                } else {
                    Log.log(Log.LOG_ERROR,
                            DepcyGraphView.class + ": " + pgState.getName() + "rule out of table or view");
                }
            }
            pgState = pgState.getParent();
            break;
        default:
            break;
        }

        file = new File(file, ModelExporter.getExportedFilename(pgState) + ".sql"); //$NON-NLS-1$

        if (file.exists() && file.isFile()) {
            Log.log(Log.LOG_INFO, "Opening editor for file " + file.getAbsolutePath()); //$NON-NLS-1$

            IFileStore fileStore = EFS.getLocalFileSystem().getStore(file.toURI());
            IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

            try {
                IDE.openEditorOnFileStore(page, fileStore);
            } catch (PartInitException e) {
                ExceptionNotifier.notifyDefault(
                        MessageFormat.format(Messages.could_not_open_editor_for_file, file.getAbsolutePath()), e);
            }
        } else {
            Log.log(Log.LOG_WARNING, "Editor will not be opened for file " + //$NON-NLS-1$
                    file.getAbsolutePath() + " because it is either nonexistent or not a file."); //$NON-NLS-1$
        }
    }

    @Override
    public void setFocus() {
    }

    @Override
    public void dispose() {
        super.dispose();
        if (gv != null) {
            gv.getControl().dispose();
        }
        getSite().getPage().removePostSelectionListener(this);
    }

    @Override
    public AbstractZoomableViewer getZoomableViewer() {
        return gv;
    }

    @Override
    public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
        if (!(part instanceof ProjectEditorDiffer) || !(selection instanceof IStructuredSelection)) {
            return;
        }

        DepcyStructuredSelection dss = null;
        if (selection instanceof DepcyStructuredSelection) {
            dss = (DepcyStructuredSelection) selection;
        } else {
            for (Object selected : ((IStructuredSelection) selection).toList()) {
                if (selected instanceof DepcyStructuredSelection) {
                    dss = (DepcyStructuredSelection) selected;
                }
            }
        }
        if (dss == null) {
            return;
        }

        boolean isCommit = ((ProjectEditorDiffer) part).getActivePage() == 0;
        isDBSource = isSource == isCommit;
        DbSource newDbSource = isDBSource ? dss.getSource() : dss.getTarget();
        DbSource newDbTarget = isDBSource ? dss.getTarget() : dss.getSource();
        PgDatabase newDb = newDbSource.getDbObject();

        if (currentDb != newDb) {
            currentDb = newDb;
            try {
                depRes = new DepcyResolver(newDbSource.getDbObject(), newDbTarget.getDbObject());
            } catch (PgCodekeeperException e) {
                Log.log(Log.LOG_WARNING, "Error creating dependency graph", e); //$NON-NLS-1$
            }
        }

        if (currentDb == null || depRes == null) {
            gv.setInput(null);
            return;
        }

        Set<PgStatement> newInput = new HashSet<>();
        for (Object selected : dss.toArray()) {
            if (!(selected instanceof TreeElement)) {
                continue;
            }
            TreeElement el = (TreeElement) selected;
            if (el.getSide() == DiffSide.RIGHT && isSource || el.getSide() == DiffSide.LEFT && !isSource) {
                continue;
            }

            for (PgStatement dependant : depRes.getDropDepcies(el.getPgStatement(currentDb))) {
                if (!(dependant instanceof PgColumn)) {
                    newInput.add(dependant);
                }
            }
        }
        gv.setInput(newInput);
        currentPath = part;
        currentSelection = selection;
        currentProject = ((ProjectEditorDiffer) part).getProj();
    }

    @Override
    public void handleStateChange(State state, Object oldValue) {
        this.isSource = (boolean) state.getValue();
        ((DepcyGraphLabelProvider) gv.getLabelProvider()).setIsSource(isSource);
        selectionChanged(currentPath, currentSelection);
    }

    private class DepcyGraphViewContentProvider extends ArrayContentProvider implements IGraphEntityContentProvider {

        @Override
        public Object[] getConnectedTo(Object entity) {
            if (entity instanceof PgStatement) {
                Set<?> input = (Set<?>) gv.getInput();
                DirectedGraph<PgStatement, DefaultEdge> currentGraph = depRes.getOldGraph();
                if (currentGraph != null) {
                    List<PgStatement> connected = new ArrayList<>();
                    for (DefaultEdge e : currentGraph.outgoingEdgesOf((PgStatement) entity)) {
                        PgStatement connectedVertex = currentGraph.getEdgeTarget(e);
                        if (!(connectedVertex instanceof PgColumn) && input.contains(connectedVertex)) {
                            connected.add(connectedVertex);
                        }
                    }
                    return connected.toArray();
                }
            }
            return null;
        }
    }
}
