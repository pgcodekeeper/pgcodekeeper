package cz.startnet.utils.pgdiff.schema;

import java.util.List;
import java.util.stream.Stream;

public interface ISchema extends IStatement {
    Stream<? extends IRelation> getRelations();
    IRelation getRelation(String name);

    List<? extends IFunction> getFunctions();
    IFunction getFunction(String signature);
}
