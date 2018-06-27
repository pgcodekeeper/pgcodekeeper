package cz.startnet.utils.pgdiff.schema;

import cz.startnet.utils.pgdiff.MsDiffUtils;

public class MsFunction extends PgFunction {

    public MsFunction(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getQualifiedName() {
        return MsDiffUtils.getQuotedName(getContainingSchema().getName()) + '.' + MsDiffUtils.getQuotedName(name);
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

        // appendOwnerSQL(sbSQL);
        // appendPrivileges(sbSQL);

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP FUNCTION " + getQualifiedName() + GO;
    }

    @Override
    protected void alterPrivileges(PgStatement newObj, StringBuilder sb) {
        // TODO MS SQL version
        super.alterPrivileges(newObj, sb);
    }
}
