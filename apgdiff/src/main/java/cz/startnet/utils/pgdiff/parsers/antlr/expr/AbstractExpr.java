package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class AbstractExpr {

    private final String schema;
    private final AbstractExpr parent;
    private final Set<GenericColumn> depcies;

    public Set<GenericColumn> getDepcies() {
        return Collections.unmodifiableSet(depcies);
    }

    public AbstractExpr(String schema) {
        this.schema = schema;
        parent = null;
        depcies = new LinkedHashSet<>();
    }

    protected AbstractExpr(AbstractExpr parent) {
        this.schema = parent.schema;
        this.parent = parent;
        depcies = parent.depcies;
    }

    protected Select findCte(String cteName) {
        return parent == null ? null : parent.findCte(cteName);
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
    protected Entry<String, GenericColumn> findReference(String schema, String name, String column) {
        return parent == null ? null : parent.findReference(schema, name, column);
    }

    protected GenericColumn addObjectDepcy(List<IdentifierContext> ids, DbObjType type) {
        String schema = QNameParser.getSchemaName(ids);
        if (schema == null) {
            schema = this.schema;
        }
        GenericColumn depcy = new GenericColumn(schema, QNameParser.getFirstName(ids), null, type);
        depcies.add(depcy);
        return depcy;
    }

    protected void addTypeDepcy(Data_typeContext type) {
        Schema_qualified_name_nontypeContext typeName =
                type.predefined_type().schema_qualified_name_nontype();

        if (typeName != null) {
            IdentifierContext qual = typeName.identifier();
            String schema = qual == null ? this.schema : qual.getText();

            depcies.add(new GenericColumn(schema,
                    typeName.identifier_nontype().getText(), null, DbObjType.TYPE));
        }
    }

    /**
     * @return column name or null if referenced qname is not found
     */
    protected String addColumnDepcy(Schema_qualified_nameContext qname) {
        List<IdentifierContext> ids = qname.identifier();
        String column = QNameParser.getFirstName(ids);

        // TODO table-less columns are pending full analysis
        if (ids.size() > 1) {
            String schema = QNameParser.getThirdName(ids);
            String table = QNameParser.getSecondName(ids);

            Entry<String, GenericColumn> ref = findReference(schema, table, column);
            if (ref == null) {
                Log.log(Log.LOG_WARNING, "Unknown column reference: "
                        + schema + ' ' + table + ' ' + column);
                return null;
            }

            GenericColumn referencedTable = ref.getValue();
            if (referencedTable != null) {
                depcies.add(new GenericColumn(referencedTable.schema, referencedTable.table, column));
            }
        }
        return column;
    }
}
