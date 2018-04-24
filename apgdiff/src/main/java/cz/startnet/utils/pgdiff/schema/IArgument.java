package cz.startnet.utils.pgdiff.schema;

public interface IArgument {
    String getDataType();
    String getMode();
    String getName();
    String getDefaultExpression();
    String getDeclaration(boolean includeDefaultValue, boolean includeArgName);
    void setDefaultExpression(String defaultExpression);
}