package ru.taximaxim.codekeeper.core.schema;

import java.util.stream.Stream;

import ru.taximaxim.codekeeper.core.utils.Pair;

public interface IRelation extends ISearchPath {
    Stream<Pair<String, String>> getRelationColumns();
}
