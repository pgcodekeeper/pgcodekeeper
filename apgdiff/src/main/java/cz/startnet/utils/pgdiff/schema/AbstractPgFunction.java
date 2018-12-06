package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class AbstractPgFunction extends AbstractFunction {

    protected String signatureCache;

    public AbstractPgFunction(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getDropSQL() {
        final StringBuilder sbString = new StringBuilder();
        sbString.append("DROP ");
        sbString.append(getStatementType().name());
        sbString.append(' ');
        sbString.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
        if (DbObjType.AGGREGATE == getStatementType()) {
            ((PgAggregate)this).appendFunctionSignatureExtended(sbString, false, true);
        } else {
            appendFunctionSignature(sbString, false, true);
        }
        sbString.append(';');
        return sbString.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        AbstractPgFunction newAbstractPgFunction;
        if (newCondition instanceof AbstractPgFunction) {
            newAbstractPgFunction = (AbstractPgFunction)newCondition;
        } else {
            return false;
        }

        if (!checkForChanges(newAbstractPgFunction)) {
            if (needDrop(newAbstractPgFunction)) {
                isNeedDepcies.set(true);
                return true;
            } else {
                sb.append(newAbstractPgFunction.getCreationSQL());
            }
        }

        if (!Objects.equals(getOwner(), newAbstractPgFunction.getOwner())) {
            sb.append(newAbstractPgFunction.getOwnerSQL());
        }
        alterPrivileges(newAbstractPgFunction, sb);
        if (!Objects.equals(getComment(), newAbstractPgFunction.getComment())) {
            sb.append("\n\n");
            newAbstractPgFunction.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    // By default, this method returns 'true', it is necessary for AGGREGATE.
    protected boolean needDrop(AbstractFunction newFunction) {
        return true;
    }

    /**
     * Alias for {@link #getSignature()} which provides a unique function ID.
     *
     * Use {@link #getBareName()} to get just the function name.
     */
    @Override
    public String getName() {
        return getSignature();
    }

    public StringBuilder appendFunctionSignature(StringBuilder sb,
            boolean includeDefaultValues, boolean includeArgNames) {
        boolean cache = !includeDefaultValues && !includeArgNames;
        if (cache && signatureCache != null) {
            return sb.append(signatureCache);
        }
        final int sigStart = sb.length();

        sb.append(isPostgres() ? PgDiffUtils.getQuotedName(name) : MsDiffUtils.quoteName(name)).append('(');
        boolean addComma = false;
        for (final Argument argument : arguments) {
            if (!includeArgNames && "OUT".equalsIgnoreCase(argument.getMode())) {
                continue;
            }
            if (addComma) {
                sb.append(", ");
            }
            sb.append(getDeclaration(argument, includeDefaultValues, includeArgNames));
            addComma = true;
        }
        sb.append(')');

        if (cache) {
            signatureCache = sb.substring(sigStart, sb.length());
        }
        return sb;
    }

    @Override
    protected String getDeclaration(Argument arg, boolean includeDefaultValue, boolean includeArgName) {
        final StringBuilder sbString = new StringBuilder();

        String mode = arg.getMode();
        if (mode != null && !"IN".equalsIgnoreCase(mode)) {
            sbString.append(mode);
            sbString.append(' ');
        }

        String name = arg.getName();

        if (name != null && !name.isEmpty() && includeArgName) {
            sbString.append(PgDiffUtils.getQuotedName(name));
            sbString.append(' ');
        }

        sbString.append(arg.getDataType());

        if (includeDefaultValue) {
            String def = arg.getDefaultExpression();
            if (def != null && !def.isEmpty()) {
                sbString.append(" = ");
                sbString.append(def);
            }
        }

        return sbString.toString();
    }

    /**
     * Returns function signature. It consists of unquoted name and argument
     * data types.
     *
     * @return function signature
     */
    public String getSignature() {
        if (signatureCache == null) {
            signatureCache = appendFunctionSignature(new StringBuilder(), false, false).toString();
        }
        return signatureCache;
    }
}
