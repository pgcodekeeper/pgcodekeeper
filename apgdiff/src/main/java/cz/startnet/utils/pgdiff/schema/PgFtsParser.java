package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
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
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema)getParent();
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sbSql = new StringBuilder();
        sbSql.append("CREATE TEXT SEARCH PARSER ")
        .append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.')
        .append(PgDiffUtils.getQuotedName(getName())).append(" (\n\t")
        .append("START = ").append(startFunction).append(",\n\t")
        .append("GETTOKEN = ").append(getTokenFunction).append(",\n\t")
        .append("END = ").append(endFunction).append(",\n\t");
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
        sb.append(PgDiffUtils.getQuotedName(getContainingSchema().getName()))
        .append('.').append(PgDiffUtils.getQuotedName(getName()));
        return sb.append(" IS ").append(comment).append(';');
    }

    @Override
    public String getDropSQL() {
        return "DROP TEXT SEARCH PARSER " + PgDiffUtils.getQuotedName(getContainingSchema().getName())
        + '.' + PgDiffUtils.getQuotedName(getName()) + ';';
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
    public void computeHash(Hasher hasher) {
        hasher.put(name);
        hasher.put(startFunction);
        hasher.put(getTokenFunction);
        hasher.put(endFunction);
        hasher.put(headLineFunction);
        hasher.put(lexTypesFunction);
        hasher.put(comment);
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
