package ru.taximaxim.codekeeper.core.schema;

public interface ISearchPath extends IStatement {
    ISchema getContainingSchema();

    default String getSchemaName() {
        return getContainingSchema().getName();
    }
}
