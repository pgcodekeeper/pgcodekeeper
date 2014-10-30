package ru.taximaxim.codekeeper.ui.editors;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyGraph;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class DepcyGraphView extends ViewPart{
//    private Graph graph;
    static DirectedGraph<PgStatement, DefaultEdge> graa;
    
    @Override
    public void createPartControl(Composite parent) {
        PgDatabase newDb =  PgDumpLoader.loadDatabaseSchemaFromDump("/home/ryabinin_av/dumps/chelny-dev4-litl2.sql", "UTF-8", false, false);
        DepcyGraph dg = new DepcyGraph(newDb);
        graa = dg.getGraph();
        
        GraphViewer gv = new GraphViewer(parent, SWT.NONE);
        gv.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
        gv.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
        gv.setLabelProvider(new LabelProvider(){
            @Override
            public String getText(Object element) {
                if (element instanceof PgStatement){
                    PgStatement st = (PgStatement) element;
                    if (st instanceof PgSchema){
                        return "Schema " + st.getBareName();
                    }else if (st instanceof PgDatabase){
                        return "Database";
                    }else if (st instanceof PgFunction){
                        return "Function " + st.getBareName();
                    }else{
                        return st.getClass() + " " + st.getBareName();
                    }
                }else if (element instanceof DefaultEdge){
                    return "e";
                }else{
                    return "error";
                }
            }
        });
        gv.setContentProvider(new DepcyGraphViewContentProvider()/*new IGraphEntityContentProvider() {
            
            @Override
            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void dispose() {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public Object[] getElements(Object inputElement) {
                if (!(inputElement instanceof DirectedGraph)){   
                    return null;
                }
                DirectedGraph<PgStatement, DefaultEdge> gra = (DirectedGraph<PgStatement, DefaultEdge>)inputElement;
                return gra.vertexSet().toArray();
            }
            
            @Override
            public Object[] getConnectedTo(Object entity) {
                // TODO Auto-generated method stub
                return null;
            }
        }*/);
        gv.setInput(graa.vertexSet().toArray());
        /*
        
     // Graph will hold all other objects
        graph = new Graph(parent, SWT.NONE);
        // now a few nodes
        GraphNode node1 = new GraphNode(graph, SWT .NONE, "Jim");
        GraphNode node2 = new GraphNode(graph, SWT.NONE, "Jack");
        GraphNode node3 = new GraphNode(graph, SWT.NONE, "Joe");
        GraphNode node4 = new GraphNode(graph, SWT.NONE, "Bill");
        // Lets have a directed connection
        new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, node1,
            node2);
        // Lets have a dotted graph connection
        new GraphConnection(graph, ZestStyles.CONNECTIONS_DOT, node2, node3);
        // Standard connection
        new GraphConnection(graph, SWT.NONE, node3, node1);
        // Change line color and line width
        GraphConnection graphConnection = new GraphConnection(graph, SWT.NONE,
            node1, node4);
        graphConnection.changeLineColor(parent.getDisplay().getSystemColor(SWT.COLOR_GREEN));
        // Also set a text
        graphConnection.setText("This is a text");
        graphConnection.setHighlightColor(parent.getDisplay().getSystemColor(SWT.COLOR_RED));
        graphConnection.setLineWidth(3);

        graph.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
        // Selection listener on graphConnect or GraphNode is not supported
        // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=236528
        graph.addSelectionListener(new SelectionAdapter() {
          @Override
          public void widgetSelected(SelectionEvent e) {
            System.out.println(e);
          }

        });
*/    }

    @Override
    public void setFocus() {
        // TODO Auto-generated method stub
        
    }

 

}
