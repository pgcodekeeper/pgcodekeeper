package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;

public class MsFunction extends AbstractFunction implements SourceStatement {

    private String firstPart;
    private String secondPart;

    public enum FuncTypes {
        SCALAR, TABLE, MULTI
    }

    private FuncTypes funcType = FuncTypes.SCALAR;


    public MsFunction(String name, String rawStatement) {
        super(name, rawStatement);
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


        if (!isCLR()) {
            appendSourceStatement(isCreate, sbSQL);
            sbSQL.append(GO);

            return sbSQL.toString();
        }

        sbSQL.append(isCreate ? "CREATE" : "ALTER");
        sbSQL.append(" FUNCTION ");
        sbSQL.append(MsDiffUtils.quoteName(getContainingSchema().getName())).append('.');
        appendFunctionSignature(sbSQL);
        sbSQL.append("\nRETURNS ").append(getReturns());
        sbSQL.append("\n");
        sbSQL.append(getBody());
        sbSQL.append(GO);

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsFunction newFunction;
        if (newCondition instanceof MsFunction) {
            newFunction = (MsFunction)newCondition;
        } else {
            return false;
        }

        if (!checkForChanges(newFunction)
                || !Objects.equals(getFirstPart(), newFunction.getFirstPart())
                || !Objects.equals(getSecondPart(), newFunction.getSecondPart())) {
            if (needDrop(newFunction)) {
                isNeedDepcies.set(true);
                return true;
            } else {
                sb.append(newFunction.getFunctionFullSQL(false));
            }
        }

        if (!Objects.equals(getOwner(), newFunction.getOwner())) {
            sb.append(newFunction.getOwnerSQL());
        }

        alterPrivileges(newFunction, sb);
        if (!Objects.equals(getComment(), newFunction.getComment())) {
            sb.append("\n\n");
            newFunction.appendCommentSql(sb);
        }

        return sb.length() > startLength;
    }

    private boolean needDrop(MsFunction newFunc) {
        if (!getFuncType().equals(newFunc.getFuncType())) {
            return true;
        }

        return isCLR() != newFunc.isCLR();
    }

    @Override
    public String getDropSQL() {
        return "DROP FUNCTION " + getQualifiedName() + GO;
    }

    public StringBuilder appendFunctionSignature(StringBuilder sb) {
        sb.append(MsDiffUtils.quoteName(name)).append('(');
        sb.append(arguments.stream().map(arg -> getDeclaration(arg, true, true))
                .collect(Collectors.joining(", ")));
        sb.append(')');

        return sb;
    }

    @Override
    public String getDeclaration(Argument arg, boolean includeDefaultValue,  boolean includeArgName) {
        final StringBuilder sbString = new StringBuilder();
        sbString.append(arg.getName()).append(' ').append(arg.getDataType());

        String def = arg.getDefaultExpression();

        if (includeDefaultValue && def != null && !def.isEmpty()) {
            sbString.append(" = ");
            sbString.append(def);
        }

        String mode = arg.getMode();

        if (mode != null && !"IN".equalsIgnoreCase(mode)) {
            sbString.append(' ').append(mode);
        }

        return sbString.toString();
    }

    @Override
    public boolean isPostgres() {
        return false;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsFunction && super.compare(obj)) {
            MsFunction func = (MsFunction) obj;
            return Objects.equals(getFirstPart(), func.getFirstPart())
                    && Objects.equals(getSecondPart(), func.getSecondPart())
                    && getFuncType() == func.getFuncType();
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(getFirstPart());
        hasher.put(getSecondPart());
        hasher.put(getFuncType());
    }

    @Override
    protected AbstractFunction getFunctionCopy() {
        MsFunction func = new MsFunction(getName(), getRawStatement());
        func.setFirstPart(getFirstPart());
        func.setSecondPart(getSecondPart());
        func.setFuncType(getFuncType());
        return func;
    }

    @Override
    public String getFirstPart() {
        return firstPart;
    }

    @Override
    public void setFirstPart(String firstPart) {
        this.firstPart = firstPart;
        resetHash();
    }

    @Override
    public String getSecondPart() {
        return secondPart;
    }

    @Override
    public void setSecondPart(String secondPart) {
        this.secondPart = secondPart;
        resetHash();
    }

    public FuncTypes getFuncType() {
        return funcType;
    }

    public void setFuncType(FuncTypes funcType) {
        this.funcType = funcType;
        resetHash();
    }

}
