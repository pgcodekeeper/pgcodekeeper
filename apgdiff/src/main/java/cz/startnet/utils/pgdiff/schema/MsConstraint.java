package cz.startnet.utils.pgdiff.schema;

import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;

public class MsConstraint extends PgConstraint {

    public MsConstraint(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("ALTER ").append(getParent().getStatementType().name());
        sbSQL.append(' ');
        sbSQL.append(MsDiffUtils.quoteName(getContainingSchema().getName()));
        sbSQL.append('.').append(MsDiffUtils.quoteName(getParent().getName()));
        sbSQL.append("\n\tADD CONSTRAINT ");
        sbSQL.append(MsDiffUtils.quoteName(getName()));
        sbSQL.append(' ');
        sbSQL.append(getDefinition());
        sbSQL.append(GO);

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsConstraint newConstr;
        if (newCondition instanceof MsConstraint) {
            newConstr = (MsConstraint)newCondition;
        } else {
            return false;
        }

        if (!compareWithoutComments(newConstr)) {
            isNeedDepcies.set(true);
            return true;
        }
        return sb.length() > startLength;
    }

    @Override
    public String getDropSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("ALTER ").append(getParent().getStatementType().name()).append(' ');
        sbSQL.append(MsDiffUtils.quoteName(getParent().getName()));
        sbSQL.append("\n\tDROP CONSTRAINT ");
        sbSQL.append(MsDiffUtils.quoteName(getName()));
        sbSQL.append(GO);

        return sbSQL.toString();
    }

    @Override
    public boolean isPostgres() {
        return false;
    }

}
