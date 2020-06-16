package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores table rule information.
 *
 * @author akifiev_an
 *
 */
public class PgRule extends PgStatementWithSearchPath{

    private PgEventType event;
    private String condition;
    private boolean instead;
    private final List<String> commands = new ArrayList<>();
    /**
     * null is default (ENABLED), otherwise contains "{ENABLE|DISABLE} [ALWAYS|REPLICA]" string
     */
    private String enabledState;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.RULE;
    }

    public PgEventType getEvent() {
        return event;
    }

    public void setEvent(PgEventType event) {
        this.event = event;
        resetHash();
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
        resetHash();
    }

    public boolean isInstead() {
        return instead;
    }

    public void setInstead(boolean instead) {
        this.instead = instead;
        resetHash();
    }

    public List<String> getCommands() {
        return Collections.unmodifiableList(commands);
    }

    public void addCommand(String command) {
        commands.add(command);
        resetHash();
    }

    public String getEnabledState() {
        return enabledState;
    }

    public void setEnabledState(String enabledState) {
        this.enabledState = enabledState;
        resetHash();
    }

    /**
     * Adds {@link #command} to {@link #commands} with newlines as requested in arguments.
     */
    public void addCommand(PgDiffArguments args, String command) {
        addCommand(args.isKeepNewlines() ? command : command.replace("\r", ""));
    }

    public PgRule(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE RULE ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(" AS\n    ON ").append(getEvent());
        sbSQL.append(" TO ").append(getParent().getQualifiedName());
        if (getCondition() != null && !getCondition().isEmpty()){
            sbSQL.append("\n  WHERE ").append(getCondition());
        }
        sbSQL.append(" DO ");
        if (isInstead()){
            sbSQL.append("INSTEAD ");
        }
        switch (commands.size()) {
        case 0:
            sbSQL.append("NOTHING");
            break;
        case 1:
            // space before is defined by get_query_def
            sbSQL.append(' ').append(commands.get(0));
            break;
        default:
            sbSQL.append('(');
            for (String command : commands) {
                sbSQL.append(' ').append(command).append(";\n");
            }
            sbSQL.append(')');
        }
        sbSQL.append(';');

        if (enabledState != null) {
            sbSQL.append("\n\nALTER TABLE ")
            .append(getParent().getQualifiedName())
            .append(' ')
            .append(enabledState)
            .append(" RULE ")
            .append(PgDiffUtils.getQuotedName(getName()))
            .append(';');
        }

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }
        return sbSQL.toString();
    }

    @Override
    public String getDropSQL() {
        StringBuilder sbSQL = new StringBuilder("DROP RULE ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(" ON ").append(getParent().getQualifiedName()).append(';');
        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb, AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgRule newRule = (PgRule) newCondition;

        if (!compareUnalterable(newRule)) {
            isNeedDepcies.set(true);
            return true;
        }
        String newEnabledState = newRule.getEnabledState();
        if (!Objects.equals(getEnabledState(), newEnabledState)) {
            if (newEnabledState == null) {
                newEnabledState = "ENABLE";
            }
            sb.append("\n\nALTER TABLE ")
            .append(getParent().getQualifiedName())
            .append(' ')
            .append(newEnabledState)
            .append(" RULE ")
            .append(PgDiffUtils.getQuotedName(newRule.getName()))
            .append(';');
        }
        if (!Objects.equals(getComment(), newRule.getComment())) {
            sb.append("\n\n");
            newRule.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    @Override
    public PgRule shallowCopy() {
        PgRule ruleDst = new PgRule(getName());
        copyBaseFields(ruleDst);
        ruleDst.setEvent(getEvent());
        ruleDst.setCondition(getCondition());
        ruleDst.setInstead(isInstead());
        ruleDst.commands.addAll(commands);
        ruleDst.setEnabledState(getEnabledState());
        return ruleDst;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgRule && super.compare(obj)) {
            PgRule rule = (PgRule) obj;
            return compareUnalterable(rule)
                    && Objects.equals(enabledState, rule.getEnabledState());
        }

        return false;
    }

    private boolean compareUnalterable(PgRule rule) {
        return event == rule.event
                && Objects.equals(condition, rule.getCondition())
                && instead == rule.isInstead()
                && commands.equals(rule.commands);
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(event);
        hasher.put(condition);
        hasher.put(instead);
        hasher.put(commands);
        hasher.put(enabledState);
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) this.getParent().getParent();
    }
}
