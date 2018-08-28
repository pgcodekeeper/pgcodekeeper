package cz.startnet.utils.pgdiff.schema;

import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;

public class MsConstraint extends AbstractConstraint {

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
        if (isNotValid()) {
            sbSQL.append(" WITH NOCHECK");
        }
        sbSQL.append("\n\tADD ");
        if (!name.isEmpty()) {
            sbSQL.append("CONSTRAINT ").append(MsDiffUtils.quoteName(getName())).append(' ');
        }
        sbSQL.append(getDefinition());
        sbSQL.append(GO);

        // 1) if is not valid, after adding it is disabled by default
        // 2) can't be valid if disabled
        if (isNotValid()) {
            sbSQL.append("\n\nALTER ").append(getParent().getStatementType().name())
            .append(' ').append(MsDiffUtils.quoteName(getContainingSchema().getName()))
            .append('.').append(MsDiffUtils.quoteName(getParent().getName())).append(' ');
            if (isDisabled()) {
                sbSQL.append("NO");
            }
            sbSQL.append("CHECK CONSTRAINT ").append(MsDiffUtils.quoteName(getName()))
            .append(GO);
        }

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        if (newCondition instanceof MsConstraint) {
            MsConstraint newConstr = (MsConstraint)newCondition;
            if (!compareWithoutComments(newConstr)) {
                isNeedDepcies.set(true);
                return true;
            }

            if (isNotValid() != newConstr.isNotValid() || isDisabled() != newConstr.isDisabled()) {
                sb.append("\nALTER ").append(newConstr.getParent().getStatementType().name())
                .append(' ').append(MsDiffUtils.quoteName(newConstr.getContainingSchema().getName()))
                .append('.').append(MsDiffUtils.quoteName(newConstr.getParent().getName()))
                .append(" WITH ");
                if (newConstr.isNotValid()) {
                    sb.append("NO");
                }
                sb.append("CHECK ");
                if (newConstr.isDisabled()) {
                    sb.append("NO");
                }
                sb.append("CHECK CONSTRAINT ").append(MsDiffUtils.quoteName(newConstr.getName()))
                .append(GO);
                return true;
            }
        }

        return false;
    }

    @Override
    public String getDropSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("ALTER ").append(getParent().getStatementType().name()).append(' ');
        sbSQL.append(MsDiffUtils.quoteName(getContainingSchema().getName()));
        sbSQL.append('.').append(MsDiffUtils.quoteName(getParent().getName()));
        sbSQL.append("\n\tDROP CONSTRAINT ");
        sbSQL.append(MsDiffUtils.quoteName(getName()));
        sbSQL.append(GO);

        return sbSQL.toString();
    }

    @Override
    public boolean isPostgres() {
        return false;
    }

    @Override
    protected AbstractConstraint getConstraintCopy() {
        return new MsConstraint(getName(), getRawStatement());
    }
}
