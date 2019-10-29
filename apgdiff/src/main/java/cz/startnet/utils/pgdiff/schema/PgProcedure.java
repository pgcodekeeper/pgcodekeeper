/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Iterator;
import java.util.Map.Entry;

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
        sbSQL.append(PgDiffUtils.getQuotedName(getSchemaName())).append('.');
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

        for (Entry<String, String> param : configurations.entrySet()) {
            String val = param.getValue();
            sbSQL.append("\n    SET ").append(param.getKey());
            if (FROM_CURRENT.equals(val)) {
                sbSQL.append(val);
            } else {
                sbSQL.append(" TO ").append(val);
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
    protected boolean needDrop(AbstractPgFunction newFunction) {
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

    @Override
    protected AbstractPgFunction getFunctionCopy() {
        return new PgProcedure(getBareName());
    }
}
