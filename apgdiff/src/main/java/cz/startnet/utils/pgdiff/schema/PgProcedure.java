/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores Postgres procedure information.
 */
public class PgProcedure extends AbstractPgFunction {

    public PgProcedure(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.PROCEDURE;
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE OR REPLACE PROCEDURE ");
        sbSQL.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
        appendFunctionSignature(sbSQL, true, true);
        sbSQL.append("\n    ");

        if (getLanguage() != null) {
            sbSQL.append("LANGUAGE ").append(PgDiffUtils.getQuotedName(getLanguage()));
        }

        if (!transforms.isEmpty()) {
            sbSQL.append(" TRANSFORM ");
            for (String tran : transforms) {
                sbSQL.append("FOR TYPE ").append(tran).append(", ");
            }

            sbSQL.setLength(sbSQL.length() - 2);
        }

        if (isSecurityDefiner()) {
            sbSQL.append(" SECURITY DEFINER");
        }

        if (!configurations.isEmpty()) {
            for (Entry<String, String> param : configurations.entrySet()) {
                String val = param.getValue();
                sbSQL.append("\n    SET ").append(param.getKey());
                if (FROM_CURRENT.equals(val)) {
                    sbSQL.append(val);
                } else {
                    sbSQL.append(" TO ").append(val);
                }
            }
        }

        sbSQL.append("\n    AS ");
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

    @Override
    public String getDeclaration(Argument arg, boolean includeDefaultValue, boolean includeArgName) {
        final StringBuilder sbString = new StringBuilder();

        if (includeArgName) {
            String mode = arg.getMode();
            if (mode != null && !"IN".equalsIgnoreCase(mode)) {
                sbString.append(mode);
                sbString.append(' ');
            }

            String name = arg.getName();

            if (name != null && !name.isEmpty()) {
                sbString.append(PgDiffUtils.getQuotedName(name));
                sbString.append(' ');
            }
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
        sbString.append("DROP PROCEDURE ");
        sbString.append(PgDiffUtils.getQuotedName(getContainingSchema().getName())).append('.');
        appendFunctionSignature(sbString, false, true);
        sbString.append(';');

        return sbString.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgProcedure newProcedure;
        if (newCondition instanceof PgProcedure) {
            newProcedure = (PgProcedure)newCondition;
        } else {
            return false;
        }

        if (!compareUnalterable(newProcedure)) {
            if (needDrop(newProcedure)) {
                isNeedDepcies.set(true);
                return true;
            } else {
                sb.append(newProcedure.getCreationSQL());
            }
        }

        if (!Objects.equals(getOwner(), newProcedure.getOwner())) {
            newProcedure.alterOwnerSQL(sb);
        }
        alterPrivileges(newProcedure, sb);
        if (!Objects.equals(getComment(), newProcedure.getComment())) {
            sb.append("\n\n");
            newProcedure.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    private boolean needDrop(AbstractPgFunction newFunction) {
        Iterator<Argument> iOld = arguments.iterator();
        Iterator<Argument> iNew = newFunction.arguments.iterator();
        while (iOld.hasNext() && iNew.hasNext()) {
            Argument argOld = iOld.next();
            Argument argNew = iNew.next();

            String oldDef = argOld.getDefaultExpression();
            String newDef = argNew.getDefaultExpression();
            // allow creation of defaults (old==null && new!=null)
            if (oldDef != null && !oldDef.equals(newDef)) {
                return true;
            }
        }

        return false;
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

    @Override
    protected AbstractPgFunction getFunctionCopy() {
        return new PgProcedure(getBareName());
    }
}
