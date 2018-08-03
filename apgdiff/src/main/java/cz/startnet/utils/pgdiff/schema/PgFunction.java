/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Stores Postgres function information.
 */
public class PgFunction extends AbstractFunction {

    private String signatureCache;

    public PgFunction(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE OR REPLACE FUNCTION ");
        sbSQL.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
        appendFunctionSignature(sbSQL, true, true);
        sbSQL.append(' ');
        sbSQL.append("RETURNS ");
        sbSQL.append(getReturns());
        sbSQL.append("\n    ");
        sbSQL.append(getBody());
        sbSQL.append(';');

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        return sbSQL.toString();
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
    public String getDeclaration(Argument arg, boolean includeDefaultValue, boolean includeArgName) {
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

        String def = arg.getDefaultExpression();

        if (includeDefaultValue && def != null && !def.isEmpty()) {
            sbString.append(" = ");
            sbString.append(def);
        }

        return sbString.toString();
    }

    @Override
    public String getDropSQL() {
        final StringBuilder sbString = new StringBuilder();
        sbString.append("DROP FUNCTION ");
        sbString.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
        appendFunctionSignature(sbString, false, true);
        sbString.append(';');

        return sbString.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgFunction newFunction;
        if (newCondition instanceof PgFunction) {
            newFunction = (PgFunction)newCondition;
        } else {
            return false;
        }

        if (!checkForChanges(newFunction)) {
            if (needDrop(this, newFunction)) {
                isNeedDepcies.set(true);
                return true;
            } else {
                sb.append(newFunction.getCreationSQL());
            }
        }

        if (!Objects.equals(getOwner(), newFunction.getOwner())) {
            sb.append(newFunction.getOwnerSQL());
        }
        alterPrivileges(newFunction, sb);
        if (!Objects.equals(getComment(), newFunction.getComment())) {
            sb.append("\n\n");
            newFunction.appendCommentSql(sb);
        }
        return sb.length() > startLength;
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

    @Override
    public String getQualifiedName() {
        return getParent().getQualifiedName() + '.' + getName();
    }

    /**
     * Getter for {@link #arguments}. List cannot be modified.
     *
     * @return {@link #arguments}
     */
    @Override
    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    @Override
    public void addArgument(final Argument argument) {
        arguments.add(argument);
        resetHash();
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

    @Override
    protected AbstractFunction getFunctionCopy() {
        return new PgFunction(getBareName(), getRawStatement());
    }
}
