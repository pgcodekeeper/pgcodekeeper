package ru.taximaxim.codekeeper.apgdiff;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import org.jgraph.JGraph;
import org.jgraph.graph.CellView;
import org.jgraph.graph.EdgeView;
import org.jgraph.graph.GraphLayoutCache;
import org.jgraph.graph.VertexView;
import org.jgrapht.DirectedGraph;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.DefaultEdge;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;

/**
 * Displays a frame with jgraphT in it
 * 
 * @author ryabinin_av
 *
 */
public class DirGraDrawer {

    public static void draw(DirectedGraph<PgStatement, DefaultEdge> graph, String title){
        final JFrame frame = new JFrame(title);
        JGraphModelAdapter<PgStatement, DefaultEdge> model = new JGraphModelAdapter<PgStatement, DefaultEdge>(graph); 

        /**
         * Use this code to set labels without changing userObject (it is either
         * PgDatabase or PgStatement for further operations) 
         */
        /*Object [] cells =DefaultGraphModel.getAll(bb);
        for (Object o : cells){
            DefaultGraphCell cell = (DefaultGraphCell) o;
            Object oo = cell.getUserObject();
            if (oo instanceof PgDatabase){
                cell.getAttributes().put(org.jgraph.graph.GraphConstants.VALUE , "Database");                
                cell.getAttributes().put(org.jgraph.graph.GraphConstants.VALUE , "Statement: " + ((PgStatement)oo).getName());
            }
        }*/

        final JGraph jgraph = new JGraph(model);
        
        GraphLayoutCache cache = jgraph.getGraphLayoutCache();
        CellView [] cells2 = cache.getCellViews();
        for (CellView c : cells2){
            if (c instanceof EdgeView){
                EdgeView ev = (EdgeView) c;
                org.jgraph.graph.DefaultEdge eval = (org.jgraph.graph.DefaultEdge) ev.getCell();
                eval.setUserObject("");
            }else if (c instanceof VertexView){
                VertexView vv = (VertexView) c;
                org.jgraph.graph.DefaultGraphCell eval = (org.jgraph.graph.DefaultGraphCell) vv.getCell();
                Object oo = eval.getUserObject();
                if (oo instanceof PgDatabase){
                    eval.setUserObject("Database");                
                }else if (oo instanceof PgStatement){
                    eval.setUserObject(((PgStatement)oo).getName());                    
                }else{
                    eval.setUserObject("bazooka!");    
                }
            }
        }
        
        jgraph.setEnabled(true);
        frame.getContentPane().add(jgraph, BorderLayout.CENTER);
        frame.validate();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
