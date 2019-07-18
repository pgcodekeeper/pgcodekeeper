package cz.startnet.utils.pgdiff.parsers.antlr.msexpr;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Full_column_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class MsAbstractExpr {

    private final String schema;
    private final MsAbstractExpr parent;
    private final Set<GenericColumn> depcies;
    private final Set<DbObjType> disabledDepcies;

    public Set<GenericColumn> getDepcies() {
        return Collections.unmodifiableSet(depcies);
    }

    public MsAbstractExpr(String schema, DbObjType... disabledDepcies) {
        this(schema, null, new LinkedHashSet<>(),
                Arrays.stream(disabledDepcies)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(DbObjType.class))));
    }

    protected MsAbstractExpr(MsAbstractExpr parent) {
        this(parent.schema, parent, parent.depcies, parent.disabledDepcies);
    }

    private MsAbstractExpr(String schema, MsAbstractExpr parent, Set<GenericColumn> depcies, Set<DbObjType> disabledDepcies) {
        this.schema = schema;
        this.parent = parent;
        this.depcies = depcies;
        this.disabledDepcies = disabledDepcies;
    }

    protected MsAbstractExprWithNmspc<?> findCte(String cteName) {
        return parent == null ? null : parent.findCte(cteName);
    }

    protected boolean hasCte(String cteName) {
        return findCte(cteName) != null;
    }

    /**
     * @param schema optional schema qualification of name, may be null
     * @param name alias of the referenced object, lower-case for case-insensitive search
     *             call {@link #findReference(String, String)} to lower-case automatically
     * @param column optional referenced column alias, may be null
     * @return a pair of (Alias, Dealiased name) where Alias is the given name.
     *          Dealiased name can be null if the name is internal to the query
     *          and is not a reference to external table.<br>
     *          null if the name is not found
     */
    protected Entry<String, GenericColumn> findReferenceRecursive(String schema, String name) {
        return parent == null ? null : parent.findReferenceRecursive(schema, name);
    }

    protected final Entry<String, GenericColumn> findReference(String schema, String name) {
        return findReferenceRecursive(schema, name.toLowerCase(Locale.ROOT));
    }

    protected GenericColumn addObjectDepcy(Qualified_nameContext qualifiedName, DbObjType type) {
        String relationName = qualifiedName.name.getText();
        IdContext schemaCtx = qualifiedName.schema;
        String schemaName = schemaCtx == null ? schema : schemaCtx.getText();
        GenericColumn depcy = new GenericColumn(schemaName, relationName, type);
        if (!ApgdiffUtils.isMsSystemSchema(schemaName)) {
            addDepcy(depcy);
        }
        return depcy;
    }

    protected void addTypeDepcy(Data_typeContext dt) {
        Qualified_nameContext name = dt.qualified_name();
        if (name != null && name.schema != null
                && !ApgdiffUtils.isMsSystemSchema(name.schema.getText())) {
            addObjectDepcy(name, DbObjType.TYPE);
        }
    }

    protected void addDepcy(GenericColumn depcy) {
        if (!disabledDepcies.contains(depcy.type)) {
            depcies.add(depcy);
        }
    }

    protected void addColumnDepcy(Full_column_nameContext fcn) {
        Qualified_nameContext tableName = fcn.qualified_name();
        if (tableName == null) {
            return;
        }
        String relationName = tableName.name.getText();
        String schemaName = tableName.schema == null ? null : tableName.schema.getText();
        String columnName = fcn.id().getText();

        Entry<String, GenericColumn> ref = findReference(schemaName, relationName);
        if (ref != null) {
            GenericColumn referencedTable = ref.getValue();
            if (referencedTable != null && !ApgdiffUtils.isMsSystemSchema(referencedTable.schema)) {
                addDepcy(new GenericColumn(referencedTable.schema,
                        referencedTable.table, columnName, DbObjType.COLUMN));
            }
        } else {
            Log.log(Log.LOG_WARNING, "Unknown column reference: "
                    + schemaName + ' ' + relationName + ' ' + columnName);
        }
    }
}