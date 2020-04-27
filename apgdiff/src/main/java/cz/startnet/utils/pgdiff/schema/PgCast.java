package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgCast extends PgStatement implements ICast {

    public enum CastMethod {
        FUNCTION, BINARY, INOUT
    }

    private CastMethod method = CastMethod.BINARY;
    private CastContext context = CastContext.EXPLICIT;

    private String function;

    private final String source;
    private final String target;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.CAST;
    }

    public PgCast(String source, String target) {
        super(ICast.getSimpleName(source, target));
        this.source = source;
        this.target = target;
    }

    @Override
    public CastContext getContext() {
        return context;
    }

    public void setContext(CastContext context) {
        this.context = context;
        resetHash();
    }

    public CastMethod getMethod() {
        return method;
    }

    public void setMethod(CastMethod method) {
        this.method = method;
        resetHash();
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
        resetHash();
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public String getTarget() {
        return target;
    }

    @Override
    public PgDatabase getDatabase() {
        return (PgDatabase) getParent();
    }

    @Override
    public String getQualifiedName() {
        return '(' + source + " AS " + target + ')';
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE CAST ").append(getQualifiedName());

        switch (method) {
        case FUNCTION:
            sbSQL.append(" WITH FUNCTION ").append(function);
            break;
        case BINARY:
            sbSQL.append(" WITHOUT FUNCTION");
            break;
        case INOUT:
            sbSQL.append(" WITH INOUT");
            break;
        }

        switch (context) {
        case IMPLICIT:
            sbSQL.append(" AS IMPLICIT");
            break;
        case ASSIGNMENT:
            sbSQL.append(" AS ASSIGNMENT");
            break;
        default:
            break;
        }

        sbSQL.append(';');

        if (getComment() != null && !getComment().isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP CAST " + getQualifiedName() + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgCast newCast = (PgCast) newCondition;

        if (!compareUnalterable(newCast)) {
            isNeedDepcies.set(true);
            return true;
        }

        if (!Objects.equals(getComment(), newCast.getComment())) {
            sb.append("\n\n");
            newCast.appendCommentSql(sb);
        }

        return sb.length() > startLength;
    }

    private boolean compareUnalterable(PgCast cast) {
        return Objects.equals(function, cast.function)
                && method == cast.method
                && context == cast.context;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgCast && super.compare(obj)) {
            return compareUnalterable((PgCast) obj);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(context);
        hasher.put(method);
        hasher.put(function);
    }

    @Override
    public PgCast shallowCopy() {
        PgCast copy = new PgCast(getSource(), getTarget());
        copyBaseFields(copy);
        copy.setContext(getContext());
        copy.setMethod(getMethod());
        copy.setFunction(getFunction());
        return copy;
    }
}
