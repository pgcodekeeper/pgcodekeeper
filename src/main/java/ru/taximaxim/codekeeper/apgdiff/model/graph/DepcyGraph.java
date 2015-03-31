package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.EdgeReversedGraph;
import org.jgrapht.graph.SimpleDirectedGraph;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.parsers.ParserUtils;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.GenericColumn.ViewReference;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgForeignKey;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgFunction.Argument;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgType;
import cz.startnet.utils.pgdiff.schema.PgView;

public class DepcyGraph {

    private static final List<String> SYS_COLUMNS = Arrays.asList(new String[]{
            "oid", "tableoid", "xmin", "cmin", "xmax", "cmax", "ctid"
            });
    
    // expect no nulls here
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
    
    public DepcyGraph(PgDatabase graphSrc) throws PgCodekeeperException {
        db = graphSrc.deepCopy();
        create();
    }
    
    private void create() throws PgCodekeeperException {
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
            
            for (PgType type : schema.getTypes()) {
                graph.addVertex(type);
                graph.addEdge(type, schema);
            }
            
            for (PgDomain domain : schema.getDomains()) {
                graph.addVertex(domain);
                graph.addEdge(domain, schema);
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
                
                for (PgConstraint cons : table.getConstraints()) {
                    graph.addVertex(cons);
                    graph.addEdge(cons, table);
                }
                
                for (PgTrigger trg : table.getTriggers()) {
                    graph.addVertex(trg);
                    graph.addEdge(trg, table);
                }
            }
            
            for(PgView view : schema.getViews()) {
                graph.addVertex(view);
                graph.addEdge(view, schema);
            }
        }

        // second loop: dependencies of objects from likely different schemas
        for(PgSchema schema : db.getSchemas()) {
            for (PgType type : schema.getTypes()) {
                createTypeToObject(type, schema);
            }
            
            for (PgDomain dom : schema.getDomains()) {
                createPgStatementToType(dom.getDataType(), schema, dom);
            }
            
            for (PgFunction func : schema.getFunctions()) {
                createFunctionToObject(func, schema);
            }
            
            for(PgTable table : schema.getTables()) {
                createFkeyToReferenced(table);
                createTableToSequences(table, schema);
                createTriggersToFuncs(table, schema);
                createTableToTable(table, schema);
                for (PgColumn col : table.getColumns()) {
                    createPgStatementToType(col.getType(), schema, col);
                }
            }
            
            for(PgView view : schema.getViews()) {
                createViewToQueried(view, schema);
            }
        }
        
        for(PgExtension ext : db.getExtensions()) {
            graph.addVertex(ext);
            graph.addEdge(ext, db);
            
            if (ext.getSchema() != null) {
                PgSchema schema = db.getSchema(ext.getSchema());
                if (schema != null) {
                    graph.addEdge(ext, schema);
                }
            }
        }
    }
    
    private void createPgStatementToType(String dataType, PgSchema schema,
            PgStatement statement) {
        String typeName = dataType;
        if (dataType.lastIndexOf(')') != -1) {
            typeName = dataType.substring(0, dataType.lastIndexOf('('));
        }
        if (typeName.lastIndexOf(']') != -1) {
            typeName = typeName.substring(0, typeName.lastIndexOf('['));
        }
        
        createPgStatementToType(
                new GenericColumn(
                        ParserUtils.getSecondObjectName(typeName),
                        ParserUtils.getObjectName(typeName), null), 
                schema, statement);
    }
    
    private void createPgStatementToType(GenericColumn dataType, PgSchema schema,
            PgStatement statement) {
        if (!ApgdiffConsts.SYS_TYPES.contains(dataType.table)) {
            PgSchema resolvedSchema = dataType.schema == null ? 
                    schema : db.getSchema(dataType.schema);
            if (resolvedSchema != null) {
                PgStatement type = resolvedSchema.getType(dataType.table);
                if (type == null) {
                    type = resolvedSchema.getDomain(dataType.table);
                }
                if (type == null) {
                    type = resolvedSchema.getTable(dataType.table);
                }
                if (type == null) {
                    type = resolvedSchema.getView(dataType.table);
                }
                if (type != null) {
                    graph.addEdge(statement, type);
                }
            }
        }
    }

    private void createTypeToObject(PgType type, PgSchema schema) {
        if (type.getSubtype() != null) {
            createPgStatementToType(type.getSubtype(), schema, type);
        }
        if (type.getElement() != null) {
            // assume that implicit array types are never loaded
            // and we have only explicit element definitions
            createPgStatementToType(type.getElement(), schema, type);
        }
        for (PgColumn attr : type.getAttrs()) {
            createPgStatementToType(attr.getType(), schema, type);
        }
        
        // TODO type funcs, caution: may introduce cyclic depcies
    }
    
    private void createFunctionToObject(PgFunction func, PgSchema schema) {
        if (func.getReturnsName() != null) {
            createPgStatementToType(func.getReturnsName(), schema, func);
        }
        
        for (Argument arg : func.getArguments()) {
            createPgStatementToType(arg.getDataType(), schema, func);
            
            for (GenericColumn obj : arg.getDefaultObjects()) {
                PgSchema resolvedSchema = schema;
                if (obj.schema != null) {
                    resolvedSchema = db.getSchema(obj.schema); 
                }
                PgFunction function = resolveFunctionCall(resolvedSchema, obj.table);
                if (function != null) {
                    graph.addEdge(func, function);
                }
            }
        }
    }

    private void createTableToTable(PgTable table, PgSchema schema) {
        for (Entry<String, String> inherit : table.getInherits()) {
            if (inherit.getKey() != null) {
                schema = db.getSchema(inherit.getKey());
            }
            PgTable tabl = schema.getTable(inherit.getValue());
            if (tabl != null) {
                graph.addEdge(table, tabl);
            }
        }
    }
    
    private void createViewToQueried(PgView view, PgSchema schema) throws PgCodekeeperException {
        for (GenericColumn col : view.getSelect().getColumns()){
            String scmName = col.schema;
            String tblName = col.table;
            String clmnName = col.column;
            
            // пропускаем системные вещи, например count(*), AVG и т.д.
            // TODO: вынести "pg_.*" в настройки, сейчас жестко забито
            // чтобы пропускать выборку из pg_views - системной таблицы
            if (tblName == null 
                    || col.getType() == ViewReference.SYSTEM 
                    || (col.table != null && col.table.startsWith("pg_")) 
                    || SYS_SCHEMAS.contains(scmName)){
                continue;
            }
            
            PgSchema scm = (scmName == null) ? schema : db.getSchema(scmName);
            
            testNotNull(scm, MessageFormat.format(Messages.View_CannotFindSchema,
                            view.getName(), tblName, scm.getName()));
            
            PgTable tbl = scm.getTable(tblName);
            if (tbl != null) {
                graph.addEdge(view, tbl);
                
                if (SYS_COLUMNS.contains(clmnName)){
                    continue;
                }
                
                PgColumn clmn = tbl.getColumn(clmnName);
                testNotNull(scm, MessageFormat.format(Messages.View_CannotFindColumn,
                        view.getName(), scm.getName(), tblName, clmnName));
                graph.addEdge(view, clmn);
                continue;
            }
            
            PgView vw = scm.getView(tblName);
            if (vw != null){
                graph.addVertex(vw);
                graph.addEdge(view, vw);
            } else if (col.getType() == ViewReference.FUNCTION) {
                // TODO: Сейчас пропускаются функции типа upper,
                // replace, toChar, now, что делать либо
                // редактировать правила на эти функции, либо
                // вычислять в коде, скорее всего правила
                PgFunction func = resolveFunctionCall(scm, tblName);
                // do not check for (func == null) because it can be a system function
                // which currently does not get skipped
                if (func != null) {    
                    graph.addEdge(view, func);
                }
            } else {
                Log.log(Log.LOG_WARNING, "Depcy: View " + view.getName()
                    + " references table/view/function " + tblName
                    + " that doesn't exist!");
            }
        }
    }

    private void createTriggersToFuncs(PgTable table, PgSchema schema) {
        for (PgTrigger trigger : table.getTriggers()) {
            graph.addVertex(trigger);
            graph.addEdge(trigger, table);
            
            String funcDef = trigger.getFunctionSignature();
            PgFunction func = getSchemaForObject(schema, funcDef).getFunction(
                    ParserUtils.getObjectName(funcDef));
            if (func != null) {
                graph.addVertex(func);
                graph.addEdge(trigger, func);
            }
        }
    }

    private void createTableToSequences(PgTable table, PgSchema schema) {
        for (String seqName : table.getSequences()) {
            PgSequence seq = getSchemaForObject(schema, seqName).getSequence(
                    ParserUtils.getObjectName(seqName));
            if (seq != null) {
                graph.addVertex(seq);
                graph.addEdge(table, seq);
            }
        }
    }

    private void createFkeyToReferenced(PgTable table) throws PgCodekeeperException {
        for(PgConstraint cons : table.getConstraints()) {
            graph.addVertex(cons);
            graph.addEdge(cons, table);
            
            if (cons instanceof PgForeignKey){
                for (GenericColumn ref : ((PgForeignKey) cons).getRefs()){
                    if (SYS_COLUMNS.contains(ref.column)){
                        continue;
                    }
                    
                    PgSchema refSchema = db.getSchema(ref.schema);
                    testNotNull(refSchema, MessageFormat.format(
                            Messages.RefColumn_CannotFindSchema,
                            table.getName(), cons.getName(), ref.schema));
                    
                    PgTable refTable = refSchema.getTable(ref.table);
                    testNotNull(refTable, MessageFormat.format(
                            Messages.RefColumn_CannotFindTable,
                            table.getName(), cons.getName(), ref.schema, ref.table));
                    
                    graph.addEdge(cons, refTable);
                    
                    PgColumn refColumn = refTable.getColumn(ref.column);
                    testNotNull(refColumn, MessageFormat.format(
                            Messages.RefColumn_CannotFindColumn,
                            table.getName(), cons.getName(), ref.column, ref.schema, ref.table));
                    
                    graph.addEdge(cons, refColumn);
                }
            }
        }
    }

    private PgFunction resolveFunctionCall(PgSchema schema, String funcName) {
        int found = 0;
        PgFunction func = null;
        for (PgFunction f : schema.getFunctions()) {
            if (f.getBareName().equals(funcName)) {
                ++found;
                func = f;
            }
        }
        // TODO right now we don't have means to resolve overloaded function calls
        // to avoid false dependencies skip resolving overloaded calls completely
        return found == 1 ? func : null;
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
    
    private void testNotNull(Object o, String message) throws PgCodekeeperException{
        if (o == null){
            throw new PgCodekeeperException(message);
        }
    }
    
    public void addCustomDepcies(List<Entry<PgStatement, PgStatement>> depcies) {
        for (Entry<PgStatement, PgStatement> depcy : depcies) {
            graph.addEdge(depcy.getKey(), depcy.getValue());
        }
    }
}