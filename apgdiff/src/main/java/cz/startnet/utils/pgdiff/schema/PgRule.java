package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores table rule information.
 *
 * @author akifiev_an
 *
 */
public class PgRule extends PgStatementWithSearchPath{

    public enum PgRuleEventType {
        SELECT, INSERT, UPDATE, DELETE
    }

    private PgRuleEventType event;
    private String targetName;
    private String condition;
    private boolean instead;
    private final List<String> commands = new ArrayList<>();

    @Override
    public DbObjType getStatementType() {
        return DbObjType.RULE;
    }

    public PgRuleEventType getEvent() {
        return event;
    }

    public void setEvent(PgRuleEventType event) {
        this.event = event;
        resetHash();
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
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

    /**
     * Adds {@link #command} to {@link #commands} with newlines as requested in arguments.
     */
    public void addCommand(PgDiffArguments args, String command) {
        addCommand(args.isForceUnixNewlines() ? command.replace("\r", "") : command);
    }

    public PgRule(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE RULE ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(" AS\n    ON ").append(getEvent());
        sbSQL.append(" TO ").append(PgDiffUtils.getQuotedName(getTargetName()));
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
        sbSQL.append(" ON ").append(PgDiffUtils.getQuotedName(getTargetName())).append(';');
        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb, AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgRule newRule;
        if (newCondition instanceof PgRule) {
            newRule = (PgRule)newCondition;
        } else {
            return false;
        }

        PgRule oldRule = this;
        if (!oldRule.compareWithoutComments(newRule)) {
            isNeedDepcies.set(true);
            return true;
        }
        if (!Objects.equals(oldRule.getComment(), newRule.getComment())) {
            sb.append("\n\n");
            newRule.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    @Override
    public PgRule shallowCopy() {
        PgRule ruleDst = new PgRule(getName(), getRawStatement());
        ruleDst.setEvent(getEvent());
        ruleDst.setTargetName(getTargetName());
        ruleDst.setCondition(getCondition());
        ruleDst.setInstead(isInstead());
        ruleDst.setComment(getComment());
        for (String command : commands) {
            ruleDst.addCommand(command);
        }
        return ruleDst;
    }

    @Override
    public PgRule deepCopy() {
        return shallowCopy();
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof PgRule) {
            PgRule rule = (PgRule) obj;
            eq = compareWithoutComments(rule)
                    && Objects.equals(comment, rule.getComment());
        }

        return eq;
    }

    public boolean compareWithoutComments(PgRule rule) {
        return event == rule.event
                && Objects.equals(targetName, rule.getTargetName())
                && Objects.equals(condition, rule.getCondition())
                && instead == rule.isInstead()
                && commands.equals(rule.commands);
    }

    @Override
    protected int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((event == null) ? 0 : event.hashCode());
        result = prime * result + ((targetName == null) ? 0 : targetName.hashCode());
        result = prime * result + ((condition == null) ? 0 : condition.hashCode());
        result = prime * result + (instead ? 1231 : 1237);
        result = prime * result + ((commands == null) ? 0 : commands.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        return result;
    }

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema) this.getParent().getParent();
    }
}
