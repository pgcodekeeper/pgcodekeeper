/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import cz.startnet.utils.pgdiff.PgDiffUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * Stores function information.
 *
 * @author fordfrog
 */
public class PgFunction extends PgStatementWithSearchPath {

    /**
     * Name of the function including argument types.
     */
    private String name;
    /**
     * List of arguments.
     */
    private final List<Argument> arguments = new ArrayList<Argument>();
    /**
     * Whole definition of the function from RETURNS keyword.
     */
    private String body;
    /**
     * Comment.
     */
    private String comment;
    
    /**
     * Create a new PgFunction object
     */
    public PgFunction(final String rawStatement, final String searchPath) {
    	super(rawStatement, searchPath);
    }

    /**
     * Getter for {@link #comment}.
     *
     * @return {@link #comment}
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter for {@link #comment}.
     *
     * @param comment {@link #comment}
     */
    public void setComment(final String comment) {
        this.comment = comment;
    }

    /**
     * Returns creation SQL of the function.
     *
     * @return creation SQL
     */
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder(500);
        sbSQL.append("CREATE OR REPLACE FUNCTION ");
        sbSQL.append(PgDiffUtils.getQuotedName(name));
        sbSQL.append('(');

        boolean addComma = false;

        for (final Argument argument : arguments) {
            if (addComma) {
                sbSQL.append(", ");
            }

            sbSQL.append(argument.getDeclaration(true));

            addComma = true;
        }

        sbSQL.append(") ");
        sbSQL.append(body);
        sbSQL.append(';');

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\nCOMMENT ON FUNCTION ");
            sbSQL.append(PgDiffUtils.getQuotedName(name));
            sbSQL.append('(');

            addComma = false;

            for (final Argument argument : arguments) {
                if (addComma) {
                    sbSQL.append(", ");
                }

                sbSQL.append(argument.getDeclaration(false));

                addComma = true;
            }

            sbSQL.append(") IS ");
            sbSQL.append(comment);
            sbSQL.append(';');
        }

        return sbSQL.toString();
    }

    /**
     * Setter for {@link #body}.
     *
     * @param body {@link #body}
     */
    public void setBody(final String body) {
        this.body = body;
    }

    /**
     * Getter for {@link #body}.
     *
     * @return {@link #body}
     */
    public String getBody() {
        return body;
    }

    /**
     * Creates and returns SQL for dropping the function.
     *
     * @return created SQL
     */
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
     * Setter for {@link #name}.
     *
     * @param name {@link #name}
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Alias for {@link #getSignature()} which provides a unique function ID.
     * 
     * Use {@link #getBareName()} to get just the function name.
     */
    public String getName() {
        return getSignature();
    }
    
    /**
     * Getter for {@link #name}.
     * 
     * @return {@link #name}
     */
    
    public String getBareName() {
        return name;
    }

    /**
     * Getter for {@link #arguments}. List cannot be modified.
     *
     * @return {@link #arguments}
     */
    public List<Argument> getArguments() {
        return Collections.unmodifiableList(arguments);
    }

    /**
     * Adds argument to the list of arguments.
     *
     * @param argument argument
     */
    public void addArgument(final Argument argument) {
        arguments.add(argument);
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
     * @param func                   object to be compared
     * @param ignoreFunctionWhitespace whether multiple whitespaces in function
     *                                 {@link #body} should be ignored
     *
     * @return true if {@code object} is pg function and the function code is
     *         the same when compared ignoring whitespace, otherwise returns
     *         false
     */
    public boolean equalsWhitespace(final PgFunction func,
            final boolean ignoreFunctionWhitespace) {
        boolean equals = false;

        if (this == func) {
            equals = true;
        } else {
            equals = Objects.equals(name, func.getBareName())
                    && arguments.equals(func.arguments);
            
            if(equals) {
                String thisBody, thatBody;
                if(ignoreFunctionWhitespace) {
                    thisBody = body.replaceAll("\\s+", " ");
                    thatBody = func.getBody().replaceAll("\\s+", " ");
                } else {
                    thisBody = body;
                    thatBody = func.getBody();
                }
                equals = equals && Objects.equals(thisBody, thatBody);
            }
        }
        return equals;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        } else if (object instanceof PgFunction) {
            return equalsWhitespace((PgFunction) object, false);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((arguments == null) ? 0 : arguments.hashCode());
        result = prime * result + ((body == null) ? 0 : body.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /**
     * Function argument information.
     */
    public static class Argument {

        /**
         * Argument mode.
         */
        private String mode = "IN";
        /**
         * Argument name.
         */
        private String name;
        /**
         * Argument data type.
         */
        private String dataType;
        /**
         * Argument default expression.
         */
        private String defaultExpression;

        /**
         * Getter for {@link #dataType}.
         *
         * @return {@link #dataType}
         */
        public String getDataType() {
            return dataType;
        }

        /**
         * Setter for {@link #dataType}.
         *
         * @param dataType {@link #dataType}
         */
        public void setDataType(final String dataType) {
            this.dataType = dataType;
        }

        /**
         * Getter for {@link #defaultExpression}.
         *
         * @return {@link #defaultExpression}
         */
        public String getDefaultExpression() {
            return defaultExpression;
        }

        /**
         * Setter for {@link #defaultExpression}.
         *
         * @param defaultExpression {@link #defaultExpression}
         */
        public void setDefaultExpression(final String defaultExpression) {
            this.defaultExpression = defaultExpression;
        }

        /**
         * Getter for {@link #mode}.
         *
         * @return {@link #mode}
         */
        public String getMode() {
            return mode;
        }

        /**
         * Setter for {@link #mode}.
         *
         * @param mode {@link #mode}
         */
        public void setMode(final String mode) {
            this.mode = mode == null || mode.isEmpty() ? "IN" : mode;
        }

        /**
         * Getter for {@link #name}.
         *
         * @return {@link #name}
         */
        public String getName() {
            return name;
        }

        /**
         * Setter for {@link #name}.
         *
         * @param name {@link #name}
         */
        public void setName(final String name) {
            this.name = name;
        }

        /**
         * Creates argument declaration.
         *
         * @param includeDefaultValue whether to include default value
         *
         * @return argument declaration
         */
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
        PgFunction functionDst = new PgFunction(getRawStatement(), getSearchPath());
        functionDst.setName(getBareName());
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
        return functionDst;
    }
    
    @Override
    public PgFunction deepCopy() {
        return shallowCopy();
    }
}
