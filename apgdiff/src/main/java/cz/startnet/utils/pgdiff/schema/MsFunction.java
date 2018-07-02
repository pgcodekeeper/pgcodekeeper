package cz.startnet.utils.pgdiff.schema;

import cz.startnet.utils.pgdiff.MsDiffUtils;

public class MsFunction extends PgFunction {

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
        sbSQL.append("CREATE OR ALTER FUNCTION ");
        appendFunctionSignature(sbSQL, true, true);
        sbSQL.append(' ');
        sbSQL.append("RETURNS ").append(getReturns());
        sbSQL.append("\n    ");
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
