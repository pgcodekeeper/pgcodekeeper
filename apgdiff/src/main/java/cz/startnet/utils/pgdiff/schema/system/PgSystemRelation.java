package cz.startnet.utils.pgdiff.schema.system;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.schema.IRelation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgSystemRelation extends PgSystemStatement implements IRelation {

    private static final long serialVersionUID = -3372437548966681543L;

    /**
     * Contains columns names and types
     */
    private final List<SimpleEntry<String, String>> columns = new ArrayList<>();

    public PgSystemRelation(String name, DbObjType type) {
        super(name, type);
    }

    @Override
    public Stream<SimpleEntry<String, String>> getRelationColumns() {
        return columns.stream();
    }

    public void addColumn(String name, String type) {
        columns.add(new SimpleEntry<>(name, type));
    }

    @Override
    public PgSystemSchema getContainingSchema() {
        return (PgSystemSchema) getParent();
    }
}