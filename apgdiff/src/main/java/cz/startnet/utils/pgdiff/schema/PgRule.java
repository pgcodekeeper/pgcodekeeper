package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores table rule information.
 *
 * @author akifiev_an
 *
 */
public class PgRule extends PgStatementWithSearchPath{

    public PgRule(String name, String rawStatement) {
        super(name, rawStatement);
        instead = false;
        also = false;
        orReplace = false;
    }
    public enum PgRuleEventType {
        SELECT, INSERT, UPDATE, DELETE
    }

    private boolean orReplace;
    private PgRuleEventType ruleEvent;
    private String ruleTargetName;
    private String ruleCondition;
    private String ruleCommand;
    private boolean instead;
    private boolean also;

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)this.getParent().getParent();
    }
    @Override
    public DbObjType getStatementType() {
        return DbObjType.RULE;
    }
    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE");
        if (isOrReplace()){
            sbSQL.append(" OR REPLACE");
        }
        sbSQL.append(" RULE ");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(" AS\n    ON ").append(getRuleEvent().toString());
        sbSQL.append(" TO ").append(getRuleTargetName());
        if (getRuleCondition() != null && !"".equals(getRuleCondition())){
            sbSQL.append("\n   ").append(getRuleCondition());
        }
        sbSQL.append(" DO ");
        if (isInstead()){
            sbSQL.append("INSTEAD ");
        }

        if (isAlso()){
            sbSQL.append("ALSO ");
        }
        sbSQL.append(getRuleCommand()).append(";");
        return sbSQL.toString();
    }
    @Override
    public String getDropSQL() {
        final StringBuilder sbSQL = new StringBuilder("DROP RULE");
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));
        sbSQL.append(" ON ").append(PgDiffUtils.getQuotedName(ruleTargetName)).append(";");
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
        PgRule pgRule = new PgRule(getName(), getRawStatement());
        pgRule.setRuleTargetName(getRuleTargetName());
        pgRule.setInstead(isInstead());
        pgRule.setAlso(isAlso());
        pgRule.setOrReplace(isOrReplace());
        pgRule.setRuleCondition(getRuleCondition());
        pgRule.setRuleCommand(getRuleCommand());
        pgRule.setRuleEvent(getRuleEvent());
        pgRule.setComment(getComment());
        return pgRule;
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
        return (ruleEvent == rule.ruleEvent)
                && (instead == rule.isInstead())
                && (ruleCondition != null? ruleCondition.equals(rule.getRuleCondition()) :
                    ruleCondition == rule.getRuleCondition())
                && (ruleCommand != null? ruleCommand.equals(rule.getRuleCommand()) :
                    ruleCommand == rule.getRuleCommand());
    }

    @Override
    protected int computeHash() {
        if (ruleCommand != null && ruleCommand.startsWith("CREATE")){
            return ruleCommand.hashCode();
        }
        final int prime = 31;
        int result = 1;
        result = prime * result + (instead ? 1231 : 1237);
        result = prime * result + ((ruleCommand == null) ? 0 : ruleCommand.hashCode());
        result = prime * result + ((ruleCondition == null) ? 0 : ruleCondition.hashCode());
        result = prime * result + ((ruleEvent == null) ? 0 : ruleEvent.hashCode());
        result = prime * result + ((ruleTargetName == null) ? 0 : ruleTargetName.hashCode());
        return result;
    }
    public PgRuleEventType getRuleEvent() {
        return ruleEvent;
    }
    public void setRuleEvent(PgRuleEventType ruleEvent) {
        this.ruleEvent = ruleEvent;
    }
    public String getRuleTargetName() {
        return ruleTargetName;
    }
    public void setRuleTargetName(String ruleTableName) {
        this.ruleTargetName = ruleTableName;
    }
    public String getRuleCondition() {
        return ruleCondition;
    }
    public void setRuleCondition(String ruleCondition) {
        this.ruleCondition = ruleCondition;
    }
    public boolean isInstead() {
        return instead;
    }
    public void setInstead(boolean instead) {
        this.instead = instead;
    }
    public boolean isAlso() {
        return also;
    }
    public void setAlso(boolean also) {
        this.also = also;
    }
    public String getRuleCommand() {
        return ruleCommand;
    }
    public void setRuleCommand(String ruleCommand) {
        this.ruleCommand = ruleCommand;
    }
    public boolean isOrReplace() {
        return orReplace;
    }
    public void setOrReplace(boolean orReplace) {
        this.orReplace = orReplace;
    }

}
