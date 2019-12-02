package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

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
        sbSQL.append(getProcedureFullSQL(true));

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        return sbSQL.toString();
    }

    private String getProcedureFullSQL(boolean isCreate) {
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
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        if (newCondition instanceof MsClrProcedure) {
            isNeedDepcies.set(true);
            return true;
        }

        final int startLength = sb.length();
        MsProcedure newProcedure = (MsProcedure) newCondition;

        if (isAnsiNulls() != newProcedure.isAnsiNulls()
                || isQuotedIdentified() != newProcedure.isQuotedIdentified()
                || !Objects.equals(getFirstPart(), newProcedure.getFirstPart())
                || !Objects.equals(getSecondPart(), newProcedure.getSecondPart())) {
            sb.append(newProcedure.getProcedureFullSQL(false));
            isNeedDepcies.set(true);
        }

        if (!Objects.equals(getOwner(), newProcedure.getOwner())) {
            newProcedure.alterOwnerSQL(sb);
        }

        alterPrivileges(newProcedure, sb);

        return sb.length() > startLength;
    }

    @Override
    public boolean compare(PgStatement obj) {
        return obj instanceof MsProcedure && super.compare(obj);
    }

    @Override
    protected AbstractMsFunction getFunctionCopy() {
        return new MsProcedure(getName());
    }
}
