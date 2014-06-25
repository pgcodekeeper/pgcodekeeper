package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.util.Arrays;
import java.util.List;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

import ru.taximaxim.codekeeper.apgdiff.Log;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgForeignKey;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgView;

public class DepcyGraph {

    private static final List<String> ignoredColumns = Arrays.asList(new String[]{
            "oid", "tableoid", "xmin", "cmin", "xmax", "cmax", "ctid"
            });
    
    private static final List<String> ignoredSchemas = Arrays.asList(new String[]{
            "information_schema", "pg_catalog"});
    
    private final DirectedGraph<PgStatement, DefaultEdge> graph = 
            new SimpleDirectedGraph<>(DefaultEdge.class);
    
    /**
     * Направление связей в графе:<br>
     * зависящий объект → зависимость <br>
     * source → target
     */
    public DirectedGraph<PgStatement, DefaultEdge> getGraph() {
        return graph;
    }
    
    private final PgDatabase db;
    
    /**
     * Copied database, graph source.<br>
     * <b>Do not modify</b> any elements in this as it will break 
     * HashSets/HashMaps and with them the generated graph.
     */
    public PgDatabase getDb(){
        return db;
    }
    
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
                
                for(PgTrigger trig : table.getTriggers()) {
                    graph.addVertex(trig);
                    graph.addEdge(trig, table);
                }
            }
        }

        // do "special" dependencies in separate loops after the base structure has been created
        // currently: foreign keys and views
        
        // "base" dependencies for those objects are also processed here (less loops)
        // at least for now
        for (PgSchema schema : db.getSchemas()) {
            for (PgTable table : schema.getTables()) {
                for(PgConstraint cons : table.getConstraints()) {
                    graph.addVertex(cons);
                    graph.addEdge(cons, table);
                    
                    if (cons instanceof PgForeignKey){
                        for (GenericColumn ref : ((PgForeignKey) cons).getRefs()){
                            PgColumn referredColumn = 
                                    db.getSchema(ref.schema).getTable(ref.table).getColumn(ref.column);
                            graph.addEdge(cons, referredColumn);
                        }
                    }
                }
            }
            
            for(PgView view : schema.getViews()) {
                graph.addVertex(view);
                graph.addEdge(view, schema);
                
                for (GenericColumn col : view.getSelect().getColumns()){
                    String scmName = col.schema;
                    String tblName = col.table;
                    String clmnName = col.column;
                    
                    if (scmName == null){
                        scmName = schema.getName();
                    }
                    if (ignoredSchemas.contains(scmName)){
                        continue;
                    }
                    PgSchema scm = db.getSchema(scmName);
                    
                    PgTable tbl = scm.getTable(tblName);
                    if (tbl != null) {
                        graph.addEdge(view, tbl);
                        
                        if (ignoredColumns.contains(clmnName)){
                            continue;
                        }
                        
                        PgColumn clmn = tbl.getColumn(clmnName);
                        if (clmn != null){
                            graph.addEdge(view, clmn);
                        } else {
                            Log.log(Log.LOG_DEBUG,
                                    "No column " + clmnName 
                                    + " found in " + tblName 
                                    + " selected by view " + view.getName());
                        }
                    } else {
                        PgView vw = scm.getView(tblName);
                        if (vw != null){
                            graph.addVertex(vw);
                            graph.addEdge(view, vw);
                        } else {
                            Log.log(Log.LOG_DEBUG,
                                    "View " + view.getName()
                                    + " references table/view " + tblName
                                    + " that doesn't exist!");
                        }
                    }
                }
            }
        }
        
        for(PgExtension ext : db.getExtensions()) {
            graph.addVertex(ext);
            graph.addEdge(ext, db);
        }
    }
}