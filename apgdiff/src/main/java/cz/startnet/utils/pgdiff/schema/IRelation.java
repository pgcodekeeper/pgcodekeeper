package cz.startnet.utils.pgdiff.schema;

import java.util.Map.Entry;
import java.util.stream.Stream;

public interface IRelation extends IStatement {
    Stream<Entry<String, String>> getRelationColumns();
}
