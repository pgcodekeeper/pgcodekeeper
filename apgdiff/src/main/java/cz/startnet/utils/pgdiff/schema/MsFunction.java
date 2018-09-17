package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.MsDiffUtils;

public class MsFunction extends AbstractFunction {

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

        sbSQL.append(isCreate ? "CREATE" : "ALTER");
        sbSQL.append(" FUNCTION ");
        sbSQL.append(MsDiffUtils.quoteName(getContainingSchema().getName())).append('.');
        appendFunctionSignature(sbSQL);
        sbSQL.append(' ');
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

        if (!checkForChanges(newFunction)) {
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
        if (getReturns().toUpperCase().startsWith("TABLE") !=
                newFunc.getReturns().toUpperCase().startsWith("TABLE")) {
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
    protected AbstractFunction getFunctionCopy() {
        return new MsFunction(getName(), getRawStatement());
    }
}
