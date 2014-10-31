package ru.taximaxim.codekeeper.ui.editors;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgForeignKey;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;

public class DepcyGraphView extends ViewPart{
    static DirectedGraph<PgStatement, DefaultEdge> depcyGraph = null;
    private GraphViewer gv;
    
    private ISelectionListener listener = new ISelectionListener() {
        public void selectionChanged(IWorkbenchPart sourcepart, ISelection selection) {
            if (sourcepart instanceof ProjectEditorDiffer && selection instanceof DepcyStructuredSelection) {
                DepcyStructuredSelection dss = (DepcyStructuredSelection) selection;
                ArrayList<PgStatement> pgStatSele = new ArrayList<PgStatement>();
                for(Object o : dss.toArray()){
                    if (o instanceof TreeElement){
                        pgStatSele.add(((TreeElement)o).getPgStatement(dss.getDepcyGraph().getDb()));
                    }
                }
                depcyGraph = dss.getDepcyGraph() == null ? null : dss.getDepcyGraph().getGraph();
                gv.setInput(pgStatSele);
            }
        }
    };

/*        diffTable.viewer.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(final SelectionChangedEvent event) {
                final StructuredSelection selection = ((StructuredSelection) event
                        .getSelection());
                

                if (selection.size() > 0) {
                    Object[] listeners = fSelectionListeners.getListeners();
                    for (int i = 0; i < listeners.length; ++i) {
                        final ISelectionChangedListener l = (ISelectionChangedListener) listeners[i];
                        
                        ArrayList<PgStatement> pgStatSele = new ArrayList<PgStatement>();
                        for(Object o : selection.toArray()){
                            if (o instanceof TreeElement){
                                pgStatSele.add(((TreeElement)o).getPgStatement(dbSource.getDbObject()));
                            }
                        }
                        DepcyStructuredSelection dss = new DepcyStructuredSelection(diffTable.getDepcyGraphSource(), pgStatSele.toArray());
                        final SelectionChangedEvent eee = new SelectionChangedEvent(DiffPresentationPane.this, dss);
                        SafeRunnable.run(new SafeRunnable() {
                            @Override
                            public void run() {
                                l.selectionChanged(eee);
                            }
                        });
                    }
                }
            }
        });*/
        
    @Override
    public void createPartControl(Composite parent) {
        gv = new GraphViewer(parent, SWT.NONE);
        gv.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
        gv.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
        gv.setLabelProvider(new LabelProvider(){
            @Override
            public String getText(Object element) {
//                TreeElement te = (TreeElement) element;
                if (element instanceof PgStatement){
                    PgStatement st = (PgStatement) element;
                    if (st instanceof PgSchema){
                        return "Schema " + st.getBareName();
                    }else if (st instanceof PgDatabase){
                        return "Database";
                    }else if (st instanceof PgFunction){
                        return "Function " + st.getBareName();
                    }else if (st instanceof PgTable){
                        return "Table " + st.getBareName();
                    }else if (st instanceof PgForeignKey){
                        return "Foreign key " + st.getBareName();
                    }else if (st instanceof PgConstraint){
                        return "Constraint " + st.getBareName();
                    }else{
                        return st.getClass() + " " + st.getBareName();
                    }
                }else if (element instanceof EntityConnectionData){
                    return "";
                }else{
                    return "error";
                }
            }
        });
        gv.setContentProvider(new DepcyGraphViewContentProvider());
//        gv.setInput(depcyGraph.vertexSet().toArray());
        gv.getGraphControl().addSelectionListener(new SelectionListener() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                System.out.println("vovo " + e.item.getData());
            }
            
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
         
         getSite().getPage().addPostSelectionListener(listener);
    }

    @Override
    public void setFocus() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void dispose() {
        super.dispose();
        if (gv != null){
            gv.getControl().dispose();
        }
        getSite().getPage().removeSelectionListener(listener);
    }

}

class DepcyGraphViewContentProvider extends ArrayContentProvider  implements IGraphEntityContentProvider {

    @Override
    public Object[] getConnectedTo(Object entity) {
        if (entity instanceof PgStatement){
            if (DepcyGraphView.depcyGraph != null){
                ArrayList<PgStatement> connected = new ArrayList<PgStatement>(5);
                for (DefaultEdge e : DepcyGraphView.depcyGraph.outgoingEdgesOf((PgStatement)entity)){
                    PgStatement connectedVertex = DepcyGraphView.depcyGraph.getEdgeTarget(e);
                    if (!(connectedVertex instanceof PgColumn)){
                        connected.add(connectedVertex);                        
                    }
                }
                return connected.toArray();
            }
        }
        return null;
        //throw new IllegalStateException("Input type is not supported");
    }
}
