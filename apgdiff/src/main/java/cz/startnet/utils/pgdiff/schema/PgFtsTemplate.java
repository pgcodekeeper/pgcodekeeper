package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
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
        sbSql.append("CREATE TEXT SEARCH TEMPLATE ").append(getQualifiedName()).append(" (\n\t");

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
        sb.append(PgDiffUtils.getQuotedName(getName()));
        return sb.append(" IS ").append(comment).append(';');
    }

    @Override
    public String getDropSQL() {
        return "DROP TEXT SEARCH TEMPLATE " + getQualifiedName() + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        if (!Objects.equals(getComment(), newCondition.getComment())) {
            sb.append("\n\n");
            newCondition.appendCommentSql(sb);
            return true;
        }

        return false;
    }

    @Override
    public PgFtsTemplate shallowCopy() {
        PgFtsTemplate dictionary = new PgFtsTemplate(getName(), getRawStatement());
        dictionary.setComment(getComment());
        dictionary.setInitFunction(getInitFunction());
        dictionary.setLexizeFunction(getLexizeFunction());
        dictionary.deps.addAll(deps);
        return dictionary;
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
            eq = Objects.equals(name, template.name)
                    && Objects.equals(initFunction, template.initFunction)
                    && Objects.equals(lexizeFunction, template.lexizeFunction)
                    && Objects.equals(comment, template.getComment());
        }

        return eq;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((initFunction == null) ? 0 : initFunction.hashCode());
        result = prime * result + ((lexizeFunction == null) ? 0 : lexizeFunction.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        return result;
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
