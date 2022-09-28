package ru.taximaxim.codekeeper.core.schema;

public interface IOperator extends ISearchPath {
    String getRightArg();
    String getLeftArg();
    String getReturns();
    void setReturns(String returns);
}
