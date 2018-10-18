package cz.startnet.utils.pgdiff.parsers.antlr.msexpr;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Full_table_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Func_proc_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_nameContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class MsAbstractExpr {

    private final String schema;
    private final MsAbstractExpr parent;
    private final Set<GenericColumn> depcies;

    public Set<GenericColumn> getDepcies() {
        return Collections.unmodifiableSet(depcies);
    }

    public MsAbstractExpr(String schema) {
        this.schema = schema;
        parent = null;
        depcies = new LinkedHashSet<>();
    }

    protected MsAbstractExpr(MsAbstractExpr parent) {
        this.schema = parent.schema;
        this.parent = parent;
        depcies = parent.depcies;
    }

    protected MsAbstractExprWithNmspc<?> findCte(String cteName) {
        return parent == null ? null : parent.findCte(cteName);
    }

    protected boolean hasCte(String cteName) {
        return findCte(cteName) != null;
    }

    /**
     * @param schema optional schema qualification of name, may be null
     * @param name alias of the referenced object
     * @param column optional referenced column alias, may be null
     * @return a pair of (Alias, Dealiased name) where Alias is the given name.
     *          Dealiased name can be null if the name is internal to the query
     *          and is not a reference to external table.<br>
     *          null if the name is not found
     */
    protected Entry<String, GenericColumn> findReference(String schema, String name) {
        return parent == null ? null : parent.findReference(schema, name);
    }

    protected GenericColumn addObjectDepcy(Full_table_nameContext tableName, DbObjType type) {
        String relationName = tableName.table.getText();
        IdContext schemaCtx = tableName.schema;
        String schemaName = schemaCtx == null ? schema : schemaCtx.getText();
        GenericColumn depcy = new GenericColumn(schemaName, relationName, type);
        depcies.add(depcy);
        return depcy;
    }

    // TODO wait MS TYPE
    /* protected void addTypeDepcy(Data_typeContext type) {
        Schema_qualified_name_nontypeContext typeName = type.predefined_type().schema_qualified_name_nontype();

        if (typeName != null) {
            IdentifierContext qual = typeName.identifier();
            String schema = qual == null ? this.schema : qual.getText();

            depcies.add(new GenericColumn(schema,
                    typeName.identifier_nontype().getText(), DbObjType.TYPE));
        }
    }*/

    protected void addColumnDepcy(Table_nameContext tableName, String colName) {
        String relationName = tableName.table.getText();
        IdContext schemaCtx = tableName.schema;
        String schemaName = schemaCtx == null ? schema : schemaCtx.getText();
        depcies.add(new GenericColumn(schemaName, relationName, colName, DbObjType.COLUMN));
    }

    protected GenericColumn addFunctionDepcy(Func_proc_nameContext fullName) {
        String functionName = fullName.procedure.getText();
        IdContext schemaCtx = fullName.schema;
        String schemaName = schemaCtx == null ? schema : schemaCtx.getText();
        GenericColumn depcy = new GenericColumn(schemaName, functionName, DbObjType.FUNCTION);
        depcies.add(depcy);
        return depcy;
    }

    protected void addSequenceDepcy(Full_table_nameContext name) {
        IdContext schemaCtx = name.schema;
        String schemaName = schemaCtx == null ? schema : schemaCtx.getText();
        depcies.add(new GenericColumn(schemaName, name.table.getText(), DbObjType.SEQUENCE));
    }
}
