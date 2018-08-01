package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgFtsTemplate extends PgStatementWithSearchPath {

    private String initFunction;
    private String lexizeFunction;

    public PgFtsTemplate(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FTS_TEMPLATE;
    }

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)getParent();
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sbSql = new StringBuilder();
        sbSql.append("CREATE TEXT SEARCH TEMPLATE ")
        .append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.')
        .append(PgDiffUtils.getQuotedName(getName())).append(" (\n\t");

        if (initFunction != null) {
            sbSql.append("INIT = ").append(initFunction).append(",\n\t");
        }

        sbSql.append("LEXIZE = ").append(lexizeFunction).append(" );");

        if (comment != null && !comment.isEmpty()) {
            sbSql.append("\n\n");
            appendCommentSql(sbSql);
        }

        return sbSql.toString();
    }

    @Override
    protected StringBuilder appendCommentSql(StringBuilder sb) {
        sb.append("COMMENT ON TEXT SEARCH TEMPLATE ");
        sb.append(PgDiffUtils.getQuotedName(getContainingSchema().getName()))
        .append('.').append(PgDiffUtils.getQuotedName(getName()));
        return sb.append(" IS ").append(comment).append(';');
    }

    @Override
    public String getDropSQL() {
        return "DROP TEXT SEARCH TEMPLATE " + PgDiffUtils.getQuotedName(getContainingSchema().getName())
        + '.' + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        if (newCondition instanceof PgFtsTemplate) {
            if (!compareWithoutComments((PgFtsTemplate)newCondition)) {
                isNeedDepcies.set(true);
                return true;
            }
        } else {
            return false;
        }

        if (!Objects.equals(getComment(), newCondition.getComment())) {
            sb.append("\n\n");
            newCondition.appendCommentSql(sb);
        }

        return sb.length() > startLength;
    }

    @Override
    public PgFtsTemplate shallowCopy() {
        PgFtsTemplate template = new PgFtsTemplate(getName(), getRawStatement());
        template.setComment(getComment());
        template.setInitFunction(getInitFunction());
        template.setLexizeFunction(getLexizeFunction());
        template.deps.addAll(deps);
        return template;
    }

    @Override
    public PgFtsTemplate deepCopy() {
        return shallowCopy();
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if(obj instanceof PgFtsTemplate) {
            PgFtsTemplate template = (PgFtsTemplate) obj;
            eq = compareWithoutComments(template)
                    && Objects.equals(comment, template.getComment());
        }

        return eq;
    }

    private boolean compareWithoutComments(PgFtsTemplate template) {
        return Objects.equals(name, template.name)
                && Objects.equals(initFunction, template.initFunction)
                && Objects.equals(lexizeFunction, template.lexizeFunction);
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(name);
        hasher.put(initFunction);
        hasher.put(lexizeFunction);
        hasher.put(comment);
    }

    public String getInitFunction() {
        return initFunction;
    }

    public void setInitFunction(final String initFunction) {
        this.initFunction = initFunction;
        resetHash();
    }

    public String getLexizeFunction() {
        return lexizeFunction;
    }

    public void setLexizeFunction(final String lexizeFunction) {
        this.lexizeFunction = lexizeFunction;
        resetHash();
    }
}
