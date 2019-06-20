package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;

public class MsTrigger extends AbstractTrigger implements SourceStatement {

    private boolean ansiNulls;
    private boolean quotedIdentified;
    private boolean isDisable;

    private String firstPart;
    private String secondPart;

    public MsTrigger(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTriggerFullSQL(true));

        if (isDisable()) {
            sb.append("\nDISABLE TRIGGER ");
            appendName(sb);
            sb.append(GO);
        }

        return sb.toString();
    }

    private String getTriggerFullSQL(boolean isCreate) {
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
    public StringBuilder appendName(StringBuilder sb) {
        sb.append(MsDiffUtils.quoteName(getSchemaName()))
        .append('.')
        .append(MsDiffUtils.quoteName(getName()))
        .append(" ON ")
        .append(getParent().getQualifiedName());
        return sb;
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        if (newCondition instanceof MsTrigger) {
            MsTrigger newTrigger = (MsTrigger) newCondition;
            final int startLength = sb.length();

            if (!Objects.equals(getFirstPart(), newTrigger.getFirstPart())
                    || !Objects.equals(getSecondPart(), newTrigger.getSecondPart())) {
                sb.append(newTrigger.getTriggerFullSQL(false));
                isNeedDepcies.set(true);
            }

            if (isDisable() != newTrigger.isDisable()) {
                sb.append('\n');
                sb.append(newTrigger.isDisable() ? "DISABLE" : "ENABLE");
                sb.append(" TRIGGER ");
                appendName(sb);
                sb.append(GO);
            }

            return sb.length() > startLength;
        }

        return false;
    }

    @Override
    public String getDropSQL() {
        return "DROP TRIGGER " + MsDiffUtils.quoteName(getSchemaName()) +
                '.' + MsDiffUtils.quoteName(getName()) + GO;
    }

    @Override
    public boolean isPostgres() {
        return false;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsTrigger && super.compare(obj)) {
            MsTrigger trigger = (MsTrigger) obj;
            return Objects.equals(getFirstPart(), trigger.getFirstPart())
                    && Objects.equals(getSecondPart(), trigger.getSecondPart())
                    && isQuotedIdentified() == trigger.isQuotedIdentified()
                    && isAnsiNulls() == trigger.isAnsiNulls()
                    && isDisable() == trigger.isDisable();
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(getFirstPart());
        hasher.put(getSecondPart());
        hasher.put(isQuotedIdentified());
        hasher.put(isAnsiNulls());
        hasher.put(isDisable());
    }

    @Override
    protected AbstractTrigger getTriggerCopy() {
        MsTrigger trigger = new MsTrigger(getName());
        trigger.setFirstPart(getFirstPart());
        trigger.setSecondPart(getSecondPart());
        trigger.setAnsiNulls(isAnsiNulls());
        trigger.setQuotedIdentified(isQuotedIdentified());
        trigger.setDisable(isDisable());
        return trigger;
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

    public boolean isDisable() {
        return isDisable;
    }

    public void setDisable(boolean isDisable) {
        this.isDisable = isDisable;
        resetHash();
    }

    @Override
    public String getFirstPart() {
        return firstPart;
    }

    @Override
    public void setFirstPart(String firstPart) {
        this.firstPart = firstPart;
        resetHash();
    }

    @Override
    public String getSecondPart() {
        return secondPart;
    }

    @Override
    public void setSecondPart(String secondPart) {
        this.secondPart = secondPart;
        resetHash();
    }
}
