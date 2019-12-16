package cz.startnet.utils.pgdiff.schema;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsProcedure extends AbstractMsFunction {

    public MsProcedure(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.PROCEDURE;
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append(getFunctionFullSQL(true));

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        return sbSQL.toString();
    }

    @Override
    protected String getFunctionFullSQL(boolean isCreate) {
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
    public String getDropSQL() {
        return "DROP PROCEDURE " + getQualifiedName() + GO;
    }

    @Override
    public boolean needDrop(AbstractFunction newFunction) {
        return newFunction instanceof MsClrProcedure;
    }

    @Override
    protected AbstractMsFunction getFunctionCopy() {
        return new MsProcedure(getName());
    }
}
