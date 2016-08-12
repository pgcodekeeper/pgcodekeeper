/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores function information.
 *
 * @author fordfrog
 */
public class PgFunction extends PgStatementWithSearchPath {

    private String signatureCache;
    private final List<Argument> arguments = new ArrayList<>();
    private String body;
    private String returns;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FUNCTION;
    }

    public PgFunction(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE OR REPLACE FUNCTION ");
        appendFunctionSignature(sbSQL, true, true);
        sbSQL.append(' ');
        sbSQL.append("RETURNS ");
        sbSQL.append(returns);
        sbSQL.append("\n    ");
        sbSQL.append(body);
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

        sb.append(PgDiffUtils.getQuotedName(name)).append('(');
        boolean addComma = false;
        for (final Argument argument : arguments) {
            if (!includeArgNames && argument.getMode().equalsIgnoreCase("OUT")) {
                continue;
            }
            if (addComma) {
                sb.append(", ");
            }
            sb.append(argument.getDeclaration(includeDefaultValues, includeArgNames));
            addComma = true;
        }
        sb.append(')');

        if (cache) {
            signatureCache = sb.substring(sigStart, sb.length());
        }
        return sb;
    }

    public void setBody(final String body) {
        this.body = body;
        resetHash();
    }

    /**
     * Sets {@link #body} with newlines as requested in arguments.
     */
    public void setBody(PgDiffArguments args, String body) {
        setBody(args.isForceUnixNewlines() ? body.replace("\r", "") : body);
    }

    public String getBody() {
        return body;
    }

    /**
     * @return the returns
     */
    public String getReturns() {
        return returns;
    }

    /**
     * @param returns the returns to set
     */
    public void setReturns(String returns) {
        this.returns = returns;
        resetHash();
    }

    @Override
    public String getDropSQL() {
        final StringBuilder sbString = new StringBuilder();
        sbString.append("DROP FUNCTION ");
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
        PgFunction oldFunction = this;

        if (!oldFunction.checkForChanges(newFunction)) {
            if (PgFunction.needDrop(oldFunction, newFunction)) {
                isNeedDepcies.set(true);
                return true;
            } else {
                sb.append(newFunction.getCreationSQL());
            }
        }

        if (!Objects.equals(oldFunction.getOwner(), newFunction.getOwner())) {
            sb.append(newFunction.getOwnerSQL());
        }
        alterPrivileges(newFunction, sb);
        if (!Objects.equals(oldFunction.getComment(), newFunction.getComment())) {
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

    /**
     * Getter for {@link #arguments}. List cannot be modified.
     *
     * @return {@link #arguments}
     */
    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

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

    /**
     * Compares two objects whether they are equal. If both objects are of the
     * same class but they equal just in whitespace in {@link #body}, they are
     * considered being equal.
     *
     * @param func                     object to be compared
     * @return true if {@code object} is PgFunction and the function code is
     *         the same when compared ignoring whitespace, otherwise returns
     *         false
     */
    public boolean checkForChanges(PgFunction func) {
        boolean equals = false;

        if (this == func) {
            equals = true;
        } else {
            equals = Objects.equals(name, func.getBareName())
                    && arguments.equals(func.arguments)
                    && Objects.equals(body, func.getBody())
                    && Objects.equals(returns, func.getReturns());
        }
        return equals;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgFunction) {
            PgFunction func  = (PgFunction) obj;
            return checkForChanges(func)
                    && Objects.equals(owner, func.getOwner())
                    && Objects.equals(grants, func.grants)
                    && Objects.equals(revokes, func.revokes)
                    && Objects.equals(comment, func.getComment());
        }
        return false;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((grants == null) ? 0 : grants.hashCode());
        result = prime * result + ((revokes == null) ? 0 : revokes.hashCode());
        result = prime * result + ((arguments == null) ? 0 : arguments.hashCode());
        result = prime * result + ((returns == null) ? 0 : returns.hashCode());
        result = prime * result + ((body == null) ? 0 : body.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        return result;
    }

    public static class Argument {

        private String mode = "IN";
        private String name;
        private String dataType;
        private String defaultExpression;

        public String getDataType() {
            return dataType;
        }

        public void setDataType(final String dataType) {
            this.dataType = dataType;
        }

        public String getDefaultExpression() {
            return defaultExpression;
        }

        public void setDefaultExpression(final String defaultExpression) {
            this.defaultExpression = defaultExpression;
        }

        public String getMode() {
            return mode;
        }

        public void setMode(final String mode) {
            this.mode = mode == null || mode.isEmpty() ? "IN" : mode;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public String getDeclaration(boolean includeDefaultValue, boolean includeArgName) {
            final StringBuilder sbString = new StringBuilder();

            if (mode != null && !"IN".equalsIgnoreCase(mode)) {
                sbString.append(mode);
                sbString.append(' ');
            }

            if (name != null && !name.isEmpty() && includeArgName) {
                sbString.append(PgDiffUtils.getQuotedName(name));
                sbString.append(' ');
            }

            sbString.append(dataType);

            if (includeDefaultValue && defaultExpression != null
                    && !defaultExpression.isEmpty()) {
                sbString.append(" = ");
                sbString.append(defaultExpression);
            }

            return sbString.toString();
        }

        @Override
        public boolean equals(Object obj) {
            boolean eq = false;

            if(this == obj) {
                eq = true;
            } else if(obj instanceof Argument) {
                final Argument arg = (Argument) obj;
                eq = Objects.equals(dataType, arg.getDataType())
                        && Objects.equals(defaultExpression, arg.getDefaultExpression())
                        && Objects.equals(mode, arg.getMode())
                        && Objects.equals(name, arg.getName());
            }

            return eq;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((dataType == null) ? 0 : dataType.hashCode());
            result = prime * result
                    + ((defaultExpression == null) ? 0 : defaultExpression.hashCode());
            result = prime * result + ((mode == null) ? 0 : mode.hashCode());
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }
    }

    @Override
    public PgFunction shallowCopy() {
        PgFunction functionDst =
                new PgFunction(getBareName(),getRawStatement());
        functionDst.setReturns(getReturns());
        functionDst.setBody(getBody());
        functionDst.setComment(getComment());
        for(Argument argSrc : arguments) {
            Argument argDst = new Argument();
            argDst.setName(argSrc.getName());
            argDst.setMode(argSrc.getMode());
            argDst.setDataType(argSrc.getDataType());
            argDst.setDefaultExpression(argSrc.getDefaultExpression());
            functionDst.addArgument(argDst);
        }
        for (PgPrivilege priv : revokes) {
            functionDst.addPrivilege(priv.deepCopy());
        }
        for (PgPrivilege priv : grants) {
            functionDst.addPrivilege(priv.deepCopy());
        }
        functionDst.setOwner(getOwner());
        functionDst.deps.addAll(deps);
        return functionDst;
    }

    @Override
    public PgFunction deepCopy() {
        return shallowCopy();
    }

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)this.getParent();
    }

    private static boolean needDrop(PgFunction oldFunction,
            PgFunction newFunction) {
        if (newFunction == null ||
                !Objects.equals(oldFunction.getReturns(), newFunction.getReturns())) {
            return true;
        }

        Iterator<Argument> iOld = oldFunction.getArguments().iterator();
        Iterator<Argument> iNew = newFunction.getArguments().iterator();
        while (iOld.hasNext() && iNew.hasNext()) {
            Argument argOld = iOld.next();
            Argument argNew = iNew.next();

            String oldDef = argOld.getDefaultExpression();
            String newDef = argNew.getDefaultExpression();
            // allow creation of defaults (old==null && new!=null)
            if (oldDef != null && !oldDef.equals(newDef)) {
                return true;
            }

            // [IN]OUT args that change their names implicitly change the function's
            // return type due to it being "SETOF record" in case of
            // multiple [IN]OUT args present

            // actually any argument name change requires drop
            if (!Objects.equals(argOld.getName(), argNew.getName())) {
                return true;
            }
            // нельзя менять тип out параметров
            if ("OUT".equalsIgnoreCase(argOld.getMode()) &&
                    !Objects.equals(argOld.getDataType(), argNew.getDataType())) {
                return true;
            }
        }
        // Если добавляется или удаляется out параметр нужно удалить функцию,
        // т.к. меняется её возвращаемое значение
        while (iOld.hasNext()) {
            if (iOld.next().getMode().equalsIgnoreCase("OUT")) {
                return true;
            }
        }
        while (iNew.hasNext()) {
            if (iNew.next().getMode().equalsIgnoreCase("OUT")) {
                return true;
            }
        }

        return false;
    }
}
