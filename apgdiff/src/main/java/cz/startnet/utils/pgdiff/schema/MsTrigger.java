package cz.startnet.utils.pgdiff.schema;

import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;

public class MsTrigger extends AbstractTrigger {

    public MsTrigger(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getCreationSQL() {
        return getTriggerFullSQL(true);
    }

    private String getTriggerFullSQL(boolean isCreate) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("SET QUOTED_IDENTIFIER ").append(isQuotedIdentified() ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        sbSQL.append("SET ANSI_NULLS ").append(isAnsiNulls() ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');

        sbSQL.append(isCreate ? "CREATE " : "ALTER ");
        sbSQL.append("TRIGGER ");
        sbSQL.append(MsDiffUtils.quoteName(getContainingSchema().getName()));
        sbSQL.append('.');
        sbSQL.append(MsDiffUtils.quoteName(getName()));
        sbSQL.append("\nON ");
        sbSQL.append(MsDiffUtils.quoteName(getContainingSchema().getName()));
        sbSQL.append('.');
        sbSQL.append(MsDiffUtils.quoteName(getTableName()));
        sbSQL.append("\n");

        if (!options.isEmpty()) {
            sbSQL.append("WITH ").append(String.join(", ", options)).append('\n');
        }

        switch (getType()) {
        case AFTER:
            sbSQL.append("AFTER ");
            break;
        case BEFORE:
            sbSQL.append("FOR ");
            break;
        case INSTEAD_OF:
            sbSQL.append("INSTEAD OF ");
            break;
        default:
            break;
        }

        boolean firstEvent = true;

        if (isOnInsert()) {
            sbSQL.append("INSERT");
            firstEvent = false;
        }

        if (isOnUpdate()) {
            if (firstEvent) {
                firstEvent = false;
            } else {
                sbSQL.append(", ");
            }

            sbSQL.append("UPDATE");
        }

        if (isOnDelete()) {
            if (!firstEvent) {
                sbSQL.append(", ");
            }

            sbSQL.append("DELETE");
        }

        if (isAppend()) {
            sbSQL.append("\nWITH APPEND");
        }

        if (isNotForRep()) {
            sbSQL.append("\nNOT FOR REPLICATION");
        }

        sbSQL.append("\nAS ");
        sbSQL.append(getQuery());
        sbSQL.append(GO);

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        if (newCondition instanceof MsTrigger) {
            MsTrigger newTrigger = (MsTrigger) newCondition;
            if (compareWithoutComments(newTrigger)) {
                sb.append(getTriggerFullSQL(false));
                return true;
            }
        }

        return false;
    }

    @Override
    public String getDropSQL() {
        return "DROP TRIGGER " + MsDiffUtils.quoteName(getContainingSchema().getName()) +
                '.' + MsDiffUtils.quoteName(getName()) + GO;
    }

    @Override
    public boolean isPostgres() {
        return false;
    }

    @Override
    protected AbstractTrigger getTriggerCopy() {
        return new MsTrigger(getName(), getRawStatement());
    }
}
