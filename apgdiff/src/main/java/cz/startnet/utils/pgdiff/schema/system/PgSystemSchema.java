package cz.startnet.utils.pgdiff.schema.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.schema.IFunction;
import cz.startnet.utils.pgdiff.schema.ISchema;
import cz.startnet.utils.pgdiff.schema.IStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgSystemSchema extends PgSystemStatement implements ISchema, Serializable {

    private static final long serialVersionUID = -5092245933861789744L;
    private final List<PgSystemStatement> relations = new ArrayList<>();
    private final List<PgSystemFunction> functions = new ArrayList<>();

    public PgSystemSchema(String name) {
        super(name, DbObjType.SCHEMA);
    }

    @Override
    public Stream<? extends IStatement> getRelations() {
        return relations.stream();
    }

    public void addRelation(PgSystemStatement relation) {
        relation.setParent(this);
        relations.add(relation);
    }

    public void addFunction(PgSystemFunction function) {
        function.setParent(this);
        functions.add(function);
    }

    @Override
    public List<? extends IFunction> getFunctions() {
        return functions;
    }
}
