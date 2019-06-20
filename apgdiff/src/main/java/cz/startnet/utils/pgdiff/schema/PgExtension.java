package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

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
        sbSQL.append("CREATE EXTENSION ");
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
    public String getDropSQL() {
        return "DROP EXTENSION " + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgExtension newExt;
        if (newCondition instanceof PgExtension) {
            newExt = (PgExtension)newCondition;
        } else {
            return false;
        }
        PgExtension oldExt = this;

        if(!Objects.equals(newExt.getSchema(), oldExt.getSchema())) {
            sb.append("\n\nALTER EXTENSION "
                    + PgDiffUtils.getQuotedName(oldExt.getName())
                    + " SET SCHEMA " + newExt.getSchema() + ';');
        }
        // TODO ALTER EXTENSION UPDATE TO ?
        if (!Objects.equals(oldExt.getComment(), newExt.getComment())) {
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
