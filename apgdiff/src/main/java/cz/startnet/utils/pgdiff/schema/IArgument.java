package cz.startnet.utils.pgdiff.schema;

import java.io.Serializable;

public interface IArgument extends Serializable {
    String getDataType();
    String getMode();
    String getName();
    String getDefaultExpression();
    void setDefaultExpression(String defaultExpression);
}