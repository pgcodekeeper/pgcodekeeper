/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;

/**
 * Stores function information.
 *
 * @author fordfrog
 */
public class PgFunction extends PgStatementWithSearchPath {

    private final List<Argument> arguments = new ArrayList<Argument>();
    private String body;
    private String comment;
    private String returns;
    
    public PgFunction(String name, String rawStatement, String searchPath) {
        super(name, rawStatement, searchPath);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder(500);
        sbSQL.append("CREATE OR REPLACE FUNCTION ");
        appendFunctionSignature(sbSQL, true);
        sbSQL.append(' ');
        sbSQL.append("RETURNS ");
        sbSQL.append(returns);
        sbSQL.append("\n    ");
        sbSQL.append(body);
        sbSQL.append(';');
        
        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\nCOMMENT ON FUNCTION ");
            appendFunctionSignature(sbSQL, false);
            sbSQL.append(" IS ");
            sbSQL.append(comment);
            sbSQL.append(';');
        }

        return sbSQL.toString();
    }
    
    @Override
    protected StringBuilder appendOwnerSQL(StringBuilder sb) {
        if (owner == null) {
            return sb;
        }
        
        sb.append("\n\nALTER FUNCTION ");
        appendFunctionSignature(sb, false)
            .append(" OWNER TO ")
            .append(owner)
            .append(';');
        
        return sb;
    }
    
    public StringBuilder appendFunctionSignature(StringBuilder sb,
            boolean includeDefaulValues) {
        sb.append(PgDiffUtils.getQuotedName(name));
        
        sb.append('(');
        boolean addComma = false;
        for (final Argument argument : arguments) {
            if (addComma) {
                sb.append(", ");
            }
            sb.append(argument.getDeclaration(includeDefaulValues));
            addComma = true;
        }
        sb.append(')');
        
        return sb;
    }

    public void setBody(final String body) {
        this.body = body;
        resetHash();
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
        final StringBuilder sbString = new StringBuilder(100);
        sbString.append("DROP FUNCTION ");
        sbString.append(name);
        sbString.append('(');

        boolean addComma = false;

        for (final Argument argument : arguments) {
            if ("OUT".equalsIgnoreCase(argument.getMode())) {
                continue;
            }

            if (addComma) {
                sbString.append(", ");
            }

            sbString.append(argument.getDeclaration(false));

            addComma = true;
        }

        sbString.append(");");

        return sbString.toString();
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
        final StringBuilder sbString = new StringBuilder(100);
        sbString.append(name);
        sbString.append('(');

        boolean addComma = false;

        for (final Argument argument : arguments) {
            if ("OUT".equalsIgnoreCase(argument.getMode())) {
                continue;
            }

            if (addComma) {
                sbString.append(',');
            }

            sbString.append(argument.getDataType().toLowerCase(Locale.ENGLISH));

            addComma = true;
        }

        sbString.append(')');

        return sbString.toString();
    }

    /**
     * Compares two objects whether they are equal. If both objects are of the
     * same class but they equal just in whitespace in {@link #body}, they are
     * considered being equal.
     *
     * @param func                     object to be compared
     * @param ignoreFunctionWhitespace whether multiple whitespaces in function
     *                                 {@link #body} should be ignored
     *
     * @return true if {@code object} is PgFunction and the function code is
     *         the same when compared ignoring whitespace, otherwise returns
     *         false
     */
    public boolean equalsWhitespace(PgFunction func, boolean ignoreFunctionWhitespace) {
        boolean equals = false;

        if (this == func) {
            equals = true;
        } else {
            equals = Objects.equals(name, func.getBareName())
                    && arguments.equals(func.arguments)
                    && privileges.equals(func.privileges)
                    && Objects.equals(owner, func.getOwner());
            
            if(equals) {
                String thisBody, thatBody;
                if(ignoreFunctionWhitespace) {
                    thisBody = body.replaceAll("\\s+", " ");
                    thatBody = func.getBody().replaceAll("\\s+", " ");
                } else {
                    thisBody = body;
                    thatBody = func.getBody();
                }
                equals = equals
                        && Objects.equals(thisBody, thatBody)
                        && Objects.equals(returns, func.getReturns());
            }
        }
        return equals;
    }
    
    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj instanceof PgFunction) {
            return equalsWhitespace((PgFunction) obj, false)
                    && Objects.equals(comment, ((PgFunction)obj).getComment());
        }
        return false;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((privileges == null) ? 0 : privileges.hashCode());
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

        public String getDeclaration(final boolean includeDefaultValue) {
            final StringBuilder sbString = new StringBuilder(50);

            if (mode != null && !"IN".equalsIgnoreCase(mode)) {
                sbString.append(mode);
                sbString.append(' ');
            }

            if (name != null && !name.isEmpty()) {
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
                new PgFunction(getBareName(),getRawStatement(), getSearchPath());
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
        for (PgPrivilege priv : privileges) {
            functionDst.addPrivilege(priv.shallowCopy());
        }
        functionDst.setOwner(getOwner());
        return functionDst;
    }
    
    @Override
    public PgFunction deepCopy() {
        return shallowCopy();
    }
}
