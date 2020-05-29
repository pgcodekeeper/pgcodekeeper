package cz.startnet.utils.pgdiff.schema.meta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class MetaRelation extends MetaStatement implements IRelation {

    private static final long serialVersionUID = -3160120843161643684L;

    private boolean initialized;

    /**
     * Contains columns names and types
     */
    private final List<Pair<String, String>> columns = new ArrayList<>();

    public MetaRelation(PgObjLocation object) {
        super(object);
    }

    @Override
    public Stream<Pair<String, String>> getRelationColumns() {
        return initialized ? columns.stream() : null;
    }

    public void addColumn(String name, String type) {
        columns.add(new Pair<>(name, type));
    }

    @Override
    public MetaSchema getContainingSchema() {
        return (MetaSchema) getParent();
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    protected void copyBaseFields(MetaRelation relation) {
        relation.setInitialized(initialized);
        relation.columns.addAll(columns);
    }

    @Override
    public MetaStatement getCopy() {
        MetaRelation copy = new MetaRelation(getObject());
        copyBaseFields(copy);
        return copy;
    }
}