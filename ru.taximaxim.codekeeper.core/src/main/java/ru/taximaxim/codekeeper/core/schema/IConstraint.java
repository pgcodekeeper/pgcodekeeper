package ru.taximaxim.codekeeper.core.schema;

import java.util.Set;

public interface IConstraint extends ISearchPath {
    boolean isUnique();
    boolean isPrimaryKey();
    Set<String> getColumns();
    String getTableName();
}
