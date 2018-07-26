package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;

public class MsFunction extends PgFunction {

    private boolean ansiNulls;
    private boolean quotedIdentified;

    public MsFunction(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getQualifiedName() {
        return MsDiffUtils.quoteName(getContainingSchema().getName()) + '.' + MsDiffUtils.quoteName(name);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("SET QUOTED_IDENTIFIER ").append(quotedIdentified ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        sbSQL.append("SET ANSI_NULLS ").append(ansiNulls ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');

        sbSQL.append("CREATE OR ALTER FUNCTION ");
        appendFunctionSignature(sbSQL, true, true);
        sbSQL.append(' ');
        sbSQL.append("\nRETURNS ").append(getReturns());
        sbSQL.append("\n");
        sbSQL.append(getBody());
        sbSQL.append(GO);

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP FUNCTION " + getQualifiedName() + GO;
    }

    public void setAnsiNulls(boolean ansiNulls) {
        this.ansiNulls = ansiNulls;
        resetHash();
    }

    public boolean isAnsiNulls() {
        return ansiNulls;
    }

    public void setQuotedIdentified(boolean quotedIdentified) {
        this.quotedIdentified = quotedIdentified;
        resetHash();
    }

    public boolean isQuotedIdentified() {
        return quotedIdentified;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsFunction && super.compare(obj)) {
            MsFunction func = (MsFunction) obj;
            return Objects.equals(quotedIdentified, func.isQuotedIdentified())
                    && Objects.equals(ansiNulls, func.isAnsiNulls());
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(isQuotedIdentified());
        hasher.put(isAnsiNulls());
    }

    @Override
    public MsFunction shallowCopy() {
        MsFunction functionDst = new MsFunction(getBareName(),getRawStatement());
        functionDst.setReturns(getReturns());
        functionDst.returnsColumns.putAll(returnsColumns);
        functionDst.setBody(getBody());
        functionDst.setComment(getComment());

        for (Argument argSrc : arguments) {
            Argument argDst = functionDst.new MsArgument(argSrc.getMode(), argSrc.getName(), argSrc.getDataType());
            argDst.setDefaultExpression(argSrc.getDefaultExpression());
            functionDst.addArgument(argDst);
        }

        for (PgPrivilege priv : revokes) {
            functionDst.addPrivilege(priv);
        }

        for (PgPrivilege priv : grants) {
            functionDst.addPrivilege(priv);
        }

        functionDst.setOwner(getOwner());
        functionDst.deps.addAll(deps);
        functionDst.setAnsiNulls(isAnsiNulls());
        functionDst.setQuotedIdentified(isQuotedIdentified());
        return functionDst;
    }

    @Override
    public boolean isPostgres() {
        return false;
    }

    public class MsArgument extends Argument {

        private static final long serialVersionUID = -8595307351991231778L;

        public MsArgument(String name, String dataType) {
            super(name, dataType);
        }

        public MsArgument(String mode, String name, String dataType) {
            super(mode, name, dataType);
        }

        @Override
        public String getDeclaration(boolean includeDefaultValue,
                boolean includeArgName) {
            final StringBuilder sbString = new StringBuilder();
            sbString.append(getName()).append(' ').append(getDataType());

            if (includeDefaultValue && getDefaultExpression() != null
                    && !getDefaultExpression().isEmpty()) {
                sbString.append(" = ");
                sbString.append(getDefaultExpression());
            }

            if (getMode() != null && !"IN".equalsIgnoreCase(getMode())) {
                sbString.append(' ').append(getMode());
            }


            return sbString.toString();
        }

    }
}
