package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores extension information.
 *
 * @author Alexander Levsha
 */
public class PgExtension extends PgStatement {

    private String schema;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.EXTENSION;
    }

    public PgExtension(String name) {
        super(name);
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(final String schema) {
        this.schema = schema;
        resetHash();
    }

    @Override
    public PgDatabase getDatabase() {
        return (PgDatabase)getParent();
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        PgDiffArguments args = getDatabase().getArguments();
        if (args.isOptionDropObject()) {
            sbSQL.append(getDropSQL(true));
            sbSQL.append("\n\n");
        }
        sbSQL.append("CREATE EXTENSION ");
        if (args != null && args.isOptionExisting()) {
            sbSQL.append("IF NOT EXISTS ");
        }
        sbSQL.append(PgDiffUtils.getQuotedName(getName()));

        if(getSchema() != null && !getSchema().isEmpty()) {
            sbSQL.append(" SCHEMA ");
            sbSQL.append(getSchema());
        }

        sbSQL.append(';');

        if(getComment() != null && !getComment().isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL(boolean optionExists) {
        StringBuilder dropSb = new StringBuilder();
        dropSb.append("DROP EXTENSION ");
        if (optionExists) {
            dropSb.append("IF EXISTS ");
        }
        dropSb.append(PgDiffUtils.getQuotedName(getName())).append(";");
        return dropSb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgExtension newExt = (PgExtension) newCondition;

        if (!Objects.equals(newExt.getSchema(), getSchema())) {
            sb.append("\n\nALTER EXTENSION ")
            .append(PgDiffUtils.getQuotedName(getName()))
            .append(" SET SCHEMA ")
            .append(newExt.getSchema())
            .append(';');
            isNeedDepcies.set(true);
        }
        // TODO ALTER EXTENSION UPDATE TO ?
        if (!Objects.equals(getComment(), newExt.getComment())) {
            sb.append("\n\n");
            newExt.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        return obj instanceof PgExtension && super.compare(obj)
                && Objects.equals(schema, ((PgExtension) obj).getSchema());
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(schema);
    }

    @Override
    public PgExtension shallowCopy() {
        PgExtension extDst = new PgExtension(getName());
        copyBaseFields(extDst);
        extDst.setSchema(getSchema());
        return extDst;
    }
}
