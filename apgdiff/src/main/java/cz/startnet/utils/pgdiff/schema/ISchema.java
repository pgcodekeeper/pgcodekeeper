package cz.startnet.utils.pgdiff.schema;

import java.util.List;
import java.util.stream.Stream;

public interface ISchema extends IStatement {
    Stream<? extends IRelation> getRelations();
    IRelation getRelation(String name);

    default boolean containsRelation(String name) {
        return getRelation(name) != null;
    }

    List<? extends IFunction> getFunctions();
    IFunction getFunction(String signature);

    default boolean containsFunction(String signature) {
        return getFunction(signature) != null;
    }
}
