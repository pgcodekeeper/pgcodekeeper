package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgFtsParser extends PgStatementWithSearchPath {

    private String startFunction;
    private String getTokenFunction;
    private String endFunction;
    private String headLineFunction;
    private String lexTypesFunction;

    public PgFtsParser(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FTS_PARSER;
    }

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)getParent();
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sbSql = new StringBuilder();
        sbSql.append("CREATE TEXT SEARCH PARSER ").append(getQualifiedName()).append(" (\n\t");
        sbSql.append("START = ").append(startFunction).append(",\n\t");
        sbSql.append("GETTOKEN = ").append(getTokenFunction).append(",\n\t");
        sbSql.append("END = ").append(endFunction).append(",\n\t");
        if (headLineFunction != null) {
            sbSql.append("HEADLINE = ").append(headLineFunction).append(",\n\t");
        }
        sbSql.append("LEXTYPES = ").append(lexTypesFunction);

        sbSql.append(" );");

        if (comment != null && !comment.isEmpty()) {
            sbSql.append("\n\n");
            appendCommentSql(sbSql);
        }

        return sbSql.toString();
    }

    @Override
    protected StringBuilder appendCommentSql(StringBuilder sb) {
        sb.append("COMMENT ON TEXT SEARCH PARSER ");
        sb.append(PgDiffUtils.getQuotedName(getName()));
        return sb.append(" IS ").append(comment).append(';');
    }

    @Override
    public String getDropSQL() {
        return "DROP TEXT SEARCH PARSER " + getQualifiedName() + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        if (newCondition instanceof PgFtsParser) {
            if (!compareWithoutComments((PgFtsParser)newCondition)) {
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
    public PgFtsParser shallowCopy() {
        PgFtsParser parser = new PgFtsParser(getName(), getRawStatement());
        parser.setComment(getComment());
        parser.setStartFunction(getStartFunction());
        parser.setGetTokenFunction(getGetTokenFunction());
        parser.setEndFunction(getEndFunction());
        parser.setLexTypesFunction(getLexTypesFunction());
        parser.setHeadLineFunction(getHeadLineFunction());
        parser.deps.addAll(deps);
        return parser;
    }

    @Override
    public PgFtsParser deepCopy() {
        return shallowCopy();
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof PgFtsParser) {
            PgFtsParser parser = (PgFtsParser) obj;
            eq = compareWithoutComments(parser)
                    && Objects.equals(comment, parser.getComment());
        }

        return eq;
    }

    private boolean compareWithoutComments(PgFtsParser parser) {
        return Objects.equals(name, parser.name)
                && Objects.equals(startFunction, parser.startFunction)
                && Objects.equals(getTokenFunction, parser.getTokenFunction)
                && Objects.equals(endFunction, parser.endFunction)
                && Objects.equals(headLineFunction, parser.headLineFunction)
                && Objects.equals(lexTypesFunction, parser.lexTypesFunction);
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((startFunction == null) ? 0 : startFunction.hashCode());
        result = prime * result + ((getTokenFunction == null) ? 0 : getTokenFunction.hashCode());
        result = prime * result + ((endFunction == null) ? 0 : endFunction.hashCode());
        result = prime * result + ((headLineFunction == null) ? 0 : headLineFunction.hashCode());
        result = prime * result + ((lexTypesFunction == null) ? 0 : lexTypesFunction.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        return result;
    }

    public String getStartFunction() {
        return startFunction;
    }

    public void setStartFunction(final String startFunction) {
        this.startFunction = startFunction;
        resetHash();
    }

    public String getGetTokenFunction() {
        return getTokenFunction;
    }

    public void setGetTokenFunction(final String getTokenFunction) {
        this.getTokenFunction = getTokenFunction;
        resetHash();
    }

    public String getEndFunction() {
        return endFunction;
    }

    public void setEndFunction(final String endFunction) {
        this.endFunction = endFunction;
        resetHash();
    }

    public String getLexTypesFunction() {
        return lexTypesFunction;
    }

    public void setLexTypesFunction(final String lexTypesFunction) {
        this.lexTypesFunction = lexTypesFunction;
        resetHash();
    }

    public String getHeadLineFunction() {
        return headLineFunction;
    }

    public void setHeadLineFunction(final String headLineFunction) {
        this.headLineFunction = headLineFunction;
        resetHash();
    }
}
