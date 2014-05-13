package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.util.Arrays;
import java.util.List;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

import ru.taximaxim.codekeeper.apgdiff.Log;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSelect.SelectColumn;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgView;

public class DepcyGraph {
    
    /**
     * Направление связей в графе:<br>
     * зависимость --> зависящий объект <br>
     * source --> target
     */
    private final DirectedGraph<PgStatement, DefaultEdge> graph = 
            new SimpleDirectedGraph<>(DefaultEdge.class);

    private final List<String> ignoredColumns = Arrays.asList(new String[]{"oid", "tableoid", "xmin", "cmin", "xmax", "cmax", "ctid"});
            
    public DirectedGraph<PgStatement, DefaultEdge> getGraph() {
        return graph;
    }
    
    /**
     * Copied database, graph source.<br>
     * <b>Do not modify</b> any elements in this as it will break 
     * HashSets/HashMaps and with them the generated graph.
     */
    private final PgDatabase db;
    
    public DepcyGraph(PgDatabase graphSrc) {
        db = graphSrc.deepCopy();
        create();
    }
    
    private void create() {
        graph.addVertex(db);
        
        for(PgSchema schema : db.getSchemas()) {
            graph.addVertex(schema);
            graph.addEdge(schema, db);
            
            for(PgFunction func : schema.getFunctions()) {
                graph.addVertex(func);
                graph.addEdge(func, schema);
            }
            
            for(PgSequence seq : schema.getSequences()) {
                graph.addVertex(seq);
                graph.addEdge(seq, schema);
            }
            
            for(PgTable table : schema.getTables()) {
                graph.addVertex(table);
                graph.addEdge(table, schema);
                
                for(PgColumn col : table.getColumns()) {
                    graph.addVertex(col);
                    graph.addEdge(col, table);
                }
                
                for(PgIndex idx : table.getIndexes()) {
                    graph.addVertex(idx);
                    graph.addEdge(idx, table);
                }
                
                for(PgConstraint cons : table.getConstraints()) {
                    graph.addVertex(cons);
                    graph.addEdge(cons, table);
                }
                
                for(PgTrigger trig : table.getTriggers()) {
                    graph.addVertex(trig);
                    graph.addEdge(trig, table);
                }
            }
            
            for(PgView view : schema.getViews()) {
                graph.addVertex(view);
                graph.addEdge(view, schema);
                
                // for all selected columns
                for (SelectColumn col : view.getSelect().getColumns()){
                    String scmName = col.schema;
                    String tblName = col.table;
                    String clmnName = col.column;
                    
                    if (scmName == null){
                        scmName = view.getParent().getName();
                    }
                    
                    PgSchema scm = db.getSchema(scmName);
                    PgTable tbl = scm.getTable(tblName);
                    if (tbl != null) {
                        PgColumn clmn = tbl.getColumn(clmnName);
                        if (ignoredColumns.contains(clmnName)){
                            graph.addEdge(view, tbl);
                            Log.log(Log.LOG_INFO, "Added view <-> table edge to depcy graph: " + view.getName() + " <-> " + tbl.getName());
                            continue;
                        }
                        if (clmn != null){
                            // column vertex 's been added already
                            graph.addEdge(view, clmn);
                            Log.log(Log.LOG_INFO, "Added view <-> column edge to depcy graph: " + view.getName() + " <-> " + clmn.getName());
                        }else{
                            Log.log(Log.LOG_WARNING, "No column " + clmnName + " found at " + tblName);
                        }
                    } else {
                        PgView vw = scm.getView(tblName);
                        if (vw != null){
                            graph.addVertex(vw);
                            graph.addEdge(view, vw);
                            Log.log(Log.LOG_INFO, "Added view <-> view edge to depcy graph: " + view.getName() + " <-> " + vw.getName());
                        }else{
                            Log.log(Log.LOG_WARNING, "Couldn't parse view \"" + view.getName() + "\": table name \"" + tblName + "\" not found.\n"
                                    + "View raw statement is as follows: \n" /*+ view.getRawStatement()*/);
                        continue;
                        }
                    }
                }
            }
        }
        
        for(PgExtension ext : db.getExtensions()) {
            graph.addVertex(ext);
            graph.addEdge(ext, db);
        }
        
        //DirGraDrawer.draw(graph);
    }
    
    public PgDatabase getDb(){
        return db;
    }
}