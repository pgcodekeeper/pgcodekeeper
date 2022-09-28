package ru.taximaxim.codekeeper.core.schema.meta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IRelation;
import ru.taximaxim.codekeeper.core.schema.ISchema;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class MetaRelation extends MetaStatement implements IRelation {

    private static final long serialVersionUID = -6057721257178245883L;

    /**
     * Contains columns names and types
     */
    private List<Pair<String, String>> columns;

    public MetaRelation(PgObjLocation object) {
        super(object);
    }

    public MetaRelation(String schemaName, String relationName, DbObjType type) {
        super(new GenericColumn(schemaName, relationName, type));
    }

    @Override
    public Stream<Pair<String, String>> getRelationColumns() {
        return columns == null ? null : columns.stream();
    }

    public void addColumns(List<? extends Pair<String, String>> columns) {
        this.columns = new ArrayList<>();
        this.columns.addAll(columns);
    }

    @Override
    public ISchema getContainingSchema() {
        throw new IllegalStateException("Unsupported operation");
    }

    @Override
    public String getSchemaName() {
        return getObject().getSchema();
    }
}