package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.MsDiffUtils;

/**
 * MS SQL schema code generation.
 */
public class MsSchema extends AbstractSchema {

    public MsSchema(String name, String rawStatement) {
        super(name, rawStatement);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE SCHEMA ");
        sbSQL.append(MsDiffUtils.quoteName(getName()));
        if (owner != null) {
            sbSQL.append("\nAUTHORIZATION ").append(MsDiffUtils.quoteName(owner));
        }
        sbSQL.append(GO);
        appendPrivileges(sbSQL);

        return sbSQL.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        MsSchema newSchema;
        if (newCondition instanceof MsSchema) {
            newSchema = (MsSchema) newCondition;
        } else {
            return false;
        }

        if (!Objects.equals(getOwner(), newSchema.getOwner())) {
            sb.append(newSchema.getOwnerSQL());
        }

        alterPrivileges(newSchema, sb);

        return sb.length() > startLength;
    }

    @Override
    public String getDropSQL() {
        return "DROP SCHEMA " + MsDiffUtils.quoteName(getName()) + GO;
    }

    @Override
    public boolean isPostgres() {
        return false;
    }

    @Override
    protected AbstractSchema getSchemaCopy() {
        return new MsSchema(getName(), getRawStatement());
    }
}
