package cz.startnet.utils.pgdiff.schema.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.schema.IFunction;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.ISchema;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgSystemSchema extends PgSystemStatement implements ISchema, Serializable {

    private static final long serialVersionUID = -5092245933861789744L;
    private final List<IRelation> relations = new ArrayList<>();
    private final List<IFunction> functions = new ArrayList<>();

    public PgSystemSchema(String name) {
        super(name, DbObjType.SCHEMA);
    }

    @Override
    public Stream<IRelation> getRelations() {
        return relations.stream();
    }

    @Override
    public List<IFunction> getFunctions() {
        return functions;
    }

    public void addRelation(PgSystemRelation relation) {
        relation.setParent(this);
        relations.add(relation);
    }

    public void addFunction(PgSystemFunction function) {
        function.setParent(this);
        functions.add(function);
    }
}
