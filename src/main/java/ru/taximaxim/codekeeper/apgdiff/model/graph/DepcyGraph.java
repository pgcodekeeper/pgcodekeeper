package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.EdgeReversedGraph;
import org.jgrapht.graph.SimpleDirectedGraph;

import ru.taximaxim.codekeeper.apgdiff.Log;
import cz.startnet.utils.pgdiff.parsers.ParserUtils;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.GenericColumn.ViewReference;
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

    private static final List<String> SYS_COLUMNS = Arrays.asList(new String[]{
            "oid", "tableoid", "xmin", "cmin", "xmax", "cmax", "ctid"
            });
    
    private static final List<String> SYS_SCHEMAS = Arrays.asList(new String[]{
            "information_schema", "pg_catalog"});
    
    private final DirectedGraph<PgStatement, DefaultEdge> graph = 
            new SimpleDirectedGraph<>(DefaultEdge.class);
    
    private final EdgeReversedGraph<PgStatement, DefaultEdge> reversedGraph =
            new EdgeReversedGraph<>(graph);
    
    /**
     * Направление связей в графе:<br>
     * зависящий объект → зависимость <br>
     * source → target
     */
    public DirectedGraph<PgStatement, DefaultEdge> getGraph() {
        return graph;
    }
    
    public EdgeReversedGraph<PgStatement, DefaultEdge> getReversedGraph(){
        return reversedGraph;
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
                
                for (String seqName : table.getSequences()) {
                    PgSequence seq = getSchemaForObject(schema, seqName).getSequence(
                            ParserUtils.getObjectName(seqName));
                    if (seq != null) {
                        graph.addVertex(seq);
                        graph.addEdge(table, seq);
                         
                        String owned = seq.getOwnedBy();
                        if (owned != null) {
                            if (table.getName().equals(ParserUtils.getSecondObjectName(owned))) {
                                graph.addEdge(seq, table);
                            }
                        }
                    }
                }
                
                for (PgTrigger trigger : table.getTriggers()) {
                    String funcDef = trigger.getFunction();
                    PgFunction func = getSchemaForObject(schema, funcDef).getFunction(
                            ParserUtils.getObjectName(funcDef));
                    if (func != null) {
                        graph.addVertex(func);
                        graph.addEdge(trigger, func);
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
                    // пропускаем системные вещи, например count(*), AVG и т.д.
                    // TODO: вынести "pg_.*" в настройки, сейчас жесток забито
                    // чтобы пропускать выборку из pg_views - системной таблицы
                    if (col.getType() == ViewReference.SYSTEM ||
                            (col.table != null &&col.table.matches("pg_.*"))){
                        continue;
                    }
                    if (scmName == null){
                        scmName = schema.getName();
                    }
                    if (SYS_SCHEMAS.contains(scmName)){
                        continue;
                    }
                    PgSchema scm = db.getSchema(scmName);
                    
                    PgTable tbl = scm.getTable(tblName);
                    if (tbl != null) {
                        graph.addEdge(view, tbl);
                        
                        if (SYS_COLUMNS.contains(clmnName)){
                            continue;
                        }
                        
                        PgColumn clmn = tbl.getColumn(clmnName);
                        if (clmn != null){
                            graph.addEdge(view, clmn);
                        } else {
                            Log.log(Log.LOG_WARNING,
                                    "Depcy: No column " + clmnName 
                                    + " found in " + tblName 
                                    + " selected by view " + view.getName());
                        }
                    } else {
                        PgView vw = scm.getView(tblName);
                        if (vw != null){
                            graph.addVertex(vw);
                            graph.addEdge(view, vw);
                        } else if (col.getType() == ViewReference.FUNCTION) {
                            // TODO: Сейчас пропускаются функции типа upper,
                            // replace, toChar, now, что делать либо
                            // редактировать правила на эти функции, либо
                            // вычислять в коде, скорее всего правила
                            PgFunction func = scm.getFunction(tblName);
                            if (func != null) {
                                graph.addVertex(func);
                                graph.addEdge(view, func);
                            }
                        } else {
                        Log.log(Log.LOG_WARNING,
                                "Depcy: View " + view.getName()
                                + " references table/view/function " + tblName
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
    /**
     * Возвращает схему, на которую указывает строковое определение объекта,
     * либо текущую схему
     * @param currSchema текущая схема
     * @param objQualifiedName определение объекта (имя_объекта, либо имя_схемы.имя_объекта)
     * @return схема, содержащая объект, либо текущая схема
     */
    private PgSchema getSchemaForObject(PgSchema currSchema, String objQualifiedName) {
        String schemaName = ParserUtils.getSecondObjectName(objQualifiedName);
        PgSchema schemaToSearch = null;
        if (schemaName != null) {
            schemaToSearch = db.getSchema(schemaName);
        }
        if (schemaToSearch == null) {
            schemaToSearch = currSchema;
        }        
        return schemaToSearch;
    }
    
    public void addCustomDepcies(List<Entry<PgStatement, PgStatement>> depcies) {
        for (Entry<PgStatement, PgStatement> depcy : depcies) {
            graph.addEdge(depcy.getKey(), depcy.getValue());
        }
    }
}