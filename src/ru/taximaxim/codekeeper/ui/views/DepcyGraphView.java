package ru.taximaxim.codekeeper.ui.views;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.IStateListener;
import org.eclipse.core.commands.State;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.commands.ICommandService;
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

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyGraph;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.COMMAND;
import ru.taximaxim.codekeeper.ui.differ.DbSource;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class DepcyGraphView extends ViewPart implements IZoomableWorkbenchPart, ISelectionListener, IStateListener{
    
    private DepcyGraph currentGraph;
    private PgDatabase currentDb;
    private GraphViewer gv;
    private boolean isSource = true;
    
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
        
        // register this as listener to command state
        ICommandService service = (ICommandService) getSite().getService(ICommandService.class);
        service.getCommand(COMMAND.DEPCY_SRC).getState(COMMAND.DEPCY_SRC_STATE).addListener(this);
    }

    @Override
    public void setFocus() {
    }

    @Override
    public void dispose() {
        super.dispose();
        if (gv != null){
            gv.getControl().dispose();
        }
        getSite().getPage().removePostSelectionListener(this);
    }

    @Override
    public AbstractZoomableViewer getZoomableViewer() {
        return gv;
    }

    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        if (!(part instanceof ProjectEditorDiffer) || 
                !(selection instanceof IStructuredSelection)) {
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
        DbSource newDbSource = isSource == isCommit ? dss.getSource() : dss.getTarget();
        PgDatabase newDb = newDbSource.getDbObject();
        if (currentDb != newDb){
            currentDb = newDb;
            currentGraph = null;
            try {
                if (currentDb != null) {
                    currentGraph = new DepcyGraph(currentDb);
                }
            } catch (PgCodekeeperException e) {
                Log.log(Log.LOG_WARNING, "Error creating dependency graph", e);
            }
        }

        if (currentDb == null || currentGraph == null){
            gv.setInput(null);
            return;
        }
        
        Set<PgStatement> newInput = new HashSet<>();
        for(Object selected : dss.toArray()){
            if (!(selected instanceof TreeElement)){
                continue;
            }
            TreeElement el = (TreeElement) selected;
            if (el.getSide() == DiffSide.RIGHT && isSource || el.getSide() == DiffSide.LEFT && !isSource){
                continue;
            }
            
            PgStatement dbObject = el.getPgStatement(currentDb);                     
            newInput.add(dbObject);
            
            for(PgStatement dependant : PgDiff.getDependantsSet(
                    dbObject, new HashSet<PgStatement>(), currentGraph)){
                if (!(dependant instanceof PgColumn)){
                    newInput.add(dependant);
                }
            }
        }
        gv.setInput(newInput);
    }
    
    @Override
    public void handleStateChange(State state, Object oldValue) {
        this.isSource = (boolean) state.getValue();
        ((DepcyGraphLabelProvider) gv.getLabelProvider()).setIsSource(isSource);
    }
    
    private class DepcyGraphViewContentProvider extends ArrayContentProvider
            implements IGraphEntityContentProvider {
        
        @Override
        public Object[] getConnectedTo(Object entity) {
            if (entity instanceof PgStatement){
                DirectedGraph<PgStatement, DefaultEdge> graph = currentGraph.getGraph();
                if (graph != null){
                    List<PgStatement> connected = new ArrayList<>();
                    for (DefaultEdge e : graph.outgoingEdgesOf((PgStatement)entity)){
                        PgStatement connectedVertex = graph.getEdgeTarget(e);
                        if (!(connectedVertex instanceof PgColumn)){
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
