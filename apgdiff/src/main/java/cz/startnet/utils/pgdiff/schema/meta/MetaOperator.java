package cz.startnet.utils.pgdiff.schema.meta;

import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.IOperator;
import cz.startnet.utils.pgdiff.schema.ISchema;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MetaOperator extends MetaStatement implements IOperator {

    private static final long serialVersionUID = -2089402889496328620L;

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
    public String getBareName() {
        return super.getName();
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
        return (MetaSchema) getParent();
    }

    @Override
    public MetaStatement getCopy() {
        MetaOperator operator = new MetaOperator(getObject());
        operator.setLeftArg(getLeftArg());
        operator.setRightArg(getRightArg());
        operator.setReturns(getReturns());
        return operator;
    }
}
