package cz.startnet.utils.pgdiff.schema.meta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.ISchema;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class MetaRelation extends MetaStatement implements IRelation {

    private static final long serialVersionUID = -3160120843161643684L;

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