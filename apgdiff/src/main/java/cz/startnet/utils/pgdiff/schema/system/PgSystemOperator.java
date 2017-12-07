package cz.startnet.utils.pgdiff.schema.system;

import java.io.Serializable;

public class PgSystemOperator implements Serializable {

    private static final long serialVersionUID = -6825152481472044059L;

    /**
     * The operator name is a sequence of up to NAMEDATALEN-1 (63 by default) characters from the following list:<br>
     *  + - * / < > = ~ ! @ # % ^ & | ` ?
     */
    private final String name;
    private final String schema;
    /**
     * Type of the left operand
     */
    private final String left;
    /**
     * Type of the right operand
     */
    private final String right;
    /**
     *  Type of the result
     */
    private final String returnType;

    public PgSystemOperator (String name, String schema, String left, String right, String returnType) {
        this.name = name;
        this.schema = schema;
        this.left = left;
        this.right = right;
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public String getSchema() {
        return schema;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public String getReturnType() {
        return returnType;
    }
}