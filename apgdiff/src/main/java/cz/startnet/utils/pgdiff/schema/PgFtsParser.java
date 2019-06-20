package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgFtsParser extends PgStatementWithSearchPath {

    private String startFunction;
    private String getTokenFunction;
    private String endFunction;
    private String headLineFunction;
    private String lexTypesFunction;

    public PgFtsParser(String name) {
        super(name);
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
        .append(getQualifiedName()).append(" (\n\t")
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
        sb.append(getQualifiedName());
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
            if (!compareUnalterable((PgFtsParser)newCondition)) {
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
        PgFtsParser parserDst = new PgFtsParser(getName());
        copyBaseFields(parserDst);
        parserDst.setStartFunction(getStartFunction());
        parserDst.setGetTokenFunction(getGetTokenFunction());
        parserDst.setEndFunction(getEndFunction());
        parserDst.setLexTypesFunction(getLexTypesFunction());
        parserDst.setHeadLineFunction(getHeadLineFunction());
        return parserDst;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        return obj instanceof PgFtsParser && super.compare(obj)
                && compareUnalterable((PgFtsParser) obj);
    }

    private boolean compareUnalterable(PgFtsParser parser) {
        return Objects.equals(startFunction, parser.startFunction)
                && Objects.equals(getTokenFunction, parser.getTokenFunction)
                && Objects.equals(endFunction, parser.endFunction)
                && Objects.equals(headLineFunction, parser.headLineFunction)
                && Objects.equals(lexTypesFunction, parser.lexTypesFunction);
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(startFunction);
        hasher.put(getTokenFunction);
        hasher.put(endFunction);
        hasher.put(headLineFunction);
        hasher.put(lexTypesFunction);
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
