package ru.taximaxim.codekeeper.ui.editors;

import java.util.ArrayList;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.AbstractZoomableViewer;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IFigureProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.eclipse.zest.core.viewers.IZoomableWorkbenchPart;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.core.widgets.internal.GraphLabel;
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
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgView;

public class DepcyGraphView extends ViewPart implements IZoomableWorkbenchPart{
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
        
    @Override
    public void createPartControl(Composite parent) {
        gv = new GraphViewer(parent, SWT.NONE);
        gv.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
        gv.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);

        /*
         * Setting own lable/figure provider
         */
        gv.setLabelProvider(new MyLabelProvider());
        
        gv.setContentProvider(new DepcyGraphViewContentProvider());
        
        // listen to node/connection selection events
        gv.getGraphControl().addSelectionListener(new SelectionListener() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                // stub
            }
            
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // stub
            }
        });

        // register listener to pages post selection 
        getSite().getPage().addPostSelectionListener(listener);
//         In order to listen to window changes
//         getSite().getWorkbenchWindow().getSelectionService().addPostSelectionListener(listener);
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
        getSite().getPage().removePostSelectionListener(listener);
//        getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(listener);
    }

    @Override
    public AbstractZoomableViewer getZoomableViewer() {
        return gv;
    }
}

// LABEL PROVIDER
class MyLabelProvider extends LabelProvider implements IFigureProvider{
    @Override
    public String getText(Object element) {
        if (element instanceof PgStatement){
            PgStatement st = (PgStatement) element;
            if (st instanceof PgSchema){
                return "Schema " + st.getBareName();
            }else if (st instanceof PgDatabase){
                return "DB";
            }else if (st instanceof PgFunction){
                return "FUNC " + st.getBareName();
            }else if (st instanceof PgTable){
                return "TBL " + st.getBareName();
            }else if (st instanceof PgForeignKey){
                return "FK " + st.getBareName();
            }else if (st instanceof PgConstraint){
                return "CONSTR " + st.getBareName();
            }else if (st instanceof PgIndex){
                return "IDX " + st.getBareName();
            }else if (st instanceof PgView){
                return "VIEW " + st.getBareName();
            }else if (st instanceof PgTrigger){
                return "TRG " + st.getBareName();
            }else{
                return st.getClass() + " " + st.getBareName();
            }
        }else if (element instanceof EntityConnectionData){
            return "";
        }else{
            return "error";
        }
    }

    @Override
    public IFigure getFigure(Object element) {
        if (element instanceof PgSchema){
            GraphLabel l = new GraphLabel(false);
            l.setArcWidth(0);
            l.setFont(Display.getDefault().getSystemFont());
            l.setBorderColor(ColorConstants.black);
            l.setBorderWidth(2);
            l.setLayoutManager(new StackLayout());
            l.setBorder(new MarginBorder(1));
            l.setText(((PgSchema)element).getName());
            return l;
        }else{
            return null;
        }
    }
} // END LABEL PROVIDER


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
