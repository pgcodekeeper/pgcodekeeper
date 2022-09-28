package ru.taximaxim.codekeeper.core.schema.meta;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IOperator;
import ru.taximaxim.codekeeper.core.schema.ISchema;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public class MetaOperator extends MetaStatement implements IOperator {

    private static final long serialVersionUID = 5893184839623238431L;

    private String left;
    private String right;
    private String returns;

    public MetaOperator(PgObjLocation object) {
        super(object);
    }

    public MetaOperator(String schemaName, String name) {
        super(new GenericColumn(schemaName, name, DbObjType.OPERATOR));
    }

    @Override
    public String getName() {
        return getSignature();
    }

    public String getSignature() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBareName());
        sb.append('(');
        sb.append(left == null ? "NONE" : left);
        sb.append(", ");
        sb.append(right == null ? "NONE" : right);
        sb.append(')');
        return sb.toString();
    }

    @Override
    public String getRightArg() {
        return right;
    }

    @Override
    public String getLeftArg() {
        return left;
    }

    @Override
    public String getReturns() {
        return returns;
    }

    public void setLeftArg(String left) {
        this.left = left;
    }

    public void setRightArg(String right) {
        this.right = right;
    }

    @Override
    public void setReturns(String returns) {
        this.returns = returns;
    }

    @Override
    public ISchema getContainingSchema() {
        throw new IllegalStateException("Unsupported operation");
    }

    @Override
    public String getSchemaName() {
        return getObject().getSchema();
    }
}
