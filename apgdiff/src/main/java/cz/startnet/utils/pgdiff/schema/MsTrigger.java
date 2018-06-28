package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;

public class MsTrigger extends PgTrigger {

    private final List<String> options = new ArrayList<>();
    private String query;
    private boolean isAppend;
    private boolean isNotForRep;

    public MsTrigger(String name, String rawStatement) {
        super(name, rawStatement);
        setPostgres(false);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE OR ALTER TRIGGER ");
        sbSQL.append(MsDiffUtils.quoteName(getContainingSchema().getName()));
        sbSQL.append('.');
        sbSQL.append(MsDiffUtils.quoteName(getName()));
        sbSQL.append("\nON ");
        sbSQL.append(MsDiffUtils.quoteName(getContainingSchema().getName()));
        sbSQL.append('.');
        sbSQL.append(MsDiffUtils.quoteName(getTableName()));
        sbSQL.append("\n");

        if (!getOptions().isEmpty()) {
            sbSQL.append("WITH ").append(String.join(", ", getOptions())).append('\n');
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
        final int startLength = sb.length();
        MsTrigger newTrigger;
        if (newCondition instanceof MsTrigger) {
            newTrigger = (MsTrigger) newCondition;
        } else {
            return false;
        }

        if (compareWithoutComments(newTrigger)) {
            sb.append(newTrigger.getCreationSQL());
            return true;
        }

        return sb.length() > startLength;
    }


    @Override
    public String getDropSQL() {
        return "DROP TRIGGER " + MsDiffUtils.quoteName(getContainingSchema().getName())
        + '.' + MsDiffUtils.quoteName(getName());
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(options);
        hasher.put(query);
        hasher.put(isAppend);
        hasher.put(isNotForRep);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsTrigger && super.compare(obj)) {
            MsTrigger trigger = (MsTrigger) obj;
            return Objects.equals(options, trigger.getOptions())
                    && Objects.equals(query, trigger.getQuery())
                    && Objects.equals(isAppend, trigger.isAppend())
                    && Objects.equals(isNotForRep, trigger.isNotForRep());
        }

        return false;
    }

    public List<String> getOptions() {
        return Collections.unmodifiableList(options);
    }

    public void addOption(String option) {
        options.add(option);
        resetHash();
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(final String query) {
        this.query = query;
        resetHash();
    }

    public boolean isAppend() {
        return isAppend;
    }

    public void setAppend(final boolean isAppend) {
        this.isAppend = isAppend;
        resetHash();
    }

    public boolean isNotForRep() {
        return isNotForRep;
    }

    public void setNotForRep(final boolean isNotForRep) {
        this.isNotForRep = isNotForRep;
        resetHash();
    }

    @Override
    public MsTrigger shallowCopy() {
        MsTrigger tr = new MsTrigger(getName(), getRawStatement());
        tr.setType(getType());
        tr.setOnDelete(isOnDelete());
        tr.setOnInsert(isOnInsert());
        tr.setOnUpdate(isOnUpdate());
        tr.setTableName(getTableName());
        tr.deps.addAll(deps);
        tr.options.addAll(options);
        tr.setQuery(getQuery());
        tr.setAppend(isAppend());
        tr.setNotForRep(isNotForRep());
        return tr;
    }
}
