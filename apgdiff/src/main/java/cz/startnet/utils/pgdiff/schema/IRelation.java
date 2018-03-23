package cz.startnet.utils.pgdiff.schema;

import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Stream;

public interface IRelation extends IStatement {
    Stream<SimpleEntry<String, String>> getRelationColumns();
}
