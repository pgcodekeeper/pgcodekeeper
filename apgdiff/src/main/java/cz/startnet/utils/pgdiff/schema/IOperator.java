package cz.startnet.utils.pgdiff.schema;

public interface IOperator extends ISearchPath {
    String getRightArg();
    String getLeftArg();
    String getReturns();
    void setReturns(String returns);
}
