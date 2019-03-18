package cz.startnet.utils.pgdiff.schema;

public interface ISearchPath extends IStatement {
    ISchema getContainingSchema();

    default String getSchemaName() {
        return getContainingSchema().getName();
    }
}
