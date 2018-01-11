package cz.startnet.utils.pgdiff.schema;

import java.util.List;
import java.util.stream.Stream;

public interface ISchema extends IStatement {
    Stream<IRelation> getRelations();
    List<IFunction> getFunctions();
}
