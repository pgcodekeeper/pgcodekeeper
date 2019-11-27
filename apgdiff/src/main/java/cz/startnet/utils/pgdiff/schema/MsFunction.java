package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsFunction extends AbstractMsFunction {

    private FuncTypes funcType = FuncTypes.SCALAR;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FUNCTION;
    }

    public MsFunction(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append(getFunctionFullSQL(true));

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);
        return sbSQL.toString();
    }

    private String getFunctionFullSQL(boolean isCreate) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("SET QUOTED_IDENTIFIER ").append(isQuotedIdentified() ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        sbSQL.append("SET ANSI_NULLS ").append(isAnsiNulls() ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        appendSourceStatement(isCreate, sbSQL);
        sbSQL.append(GO);
        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        if (newCondition instanceof MsClrFunction) {
            isNeedDepcies.set(true);
            return true;
        }

        final int startLength = sb.length();
        MsFunction newFunction = (MsFunction) newCondition;

        if (isAnsiNulls() != newFunction.isAnsiNulls()
                || isQuotedIdentified() != newFunction.isQuotedIdentified()
                || !Objects.equals(getFirstPart(), newFunction.getFirstPart())
                || !Objects.equals(getSecondPart(), newFunction.getSecondPart())) {
            isNeedDepcies.set(true);
            if (!getFuncType().equals(newFunction.getFuncType())) {
                return true;
            } else {
                sb.append(newFunction.getFunctionFullSQL(false));
            }
        }

        if (!Objects.equals(getOwner(), newFunction.getOwner())) {
            newFunction.alterOwnerSQL(sb);
        }

        alterPrivileges(newFunction, sb);

        return sb.length() > startLength;
    }

    @Override
    public String getDropSQL() {
        return "DROP FUNCTION " + getQualifiedName() + GO;
    }

    @Override
    public boolean compare(PgStatement obj) {
        return obj instanceof MsFunction && super.compare(obj)
                && getFuncType() == ((MsFunction) obj).getFuncType();
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(getFuncType());
    }

    @Override
    protected AbstractMsFunction getFunctionCopy() {
        MsFunction func = new MsFunction(getName());
        func.setFuncType(getFuncType());
        return func;
    }

    public FuncTypes getFuncType() {
        return funcType;
    }

    public void setFuncType(FuncTypes funcType) {
        this.funcType = funcType;
        resetHash();
    }
}
