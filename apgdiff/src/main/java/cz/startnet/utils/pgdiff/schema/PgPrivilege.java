package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgPrivilege extends PgStatement {

    // regex grouping here is used to preserve whitespace when doing replaceAll
    private static final Pattern PATTERN_TO = Pattern.compile("(\\s+)TO(\\s+)");

    private final boolean revoke;
    private final String definition;

    public boolean isRevoke() {
        return revoke;
    }

    public String getDefinition() {
        return definition;
    }

    public PgPrivilege(boolean revoke, String definition, String rawStatement) {
        super(null, rawStatement);

        this.revoke = revoke;
        this.definition = definition;
    }

    @Override
    public DbObjType getStatementType() {
        return null;
    }

    @Override
    public String getCreationSQL() {
        return new StringBuilder()
                .append(revoke ? "REVOKE " : "GRANT ")
                .append(definition)
                .append(';')
                .toString();
    }

    @Override
    public String getDropSQL() {
        if (revoke) {
            return null;
        }

        // TODO сделать надежнее чем просто регуляркой
        return new StringBuilder()
                .append("REVOKE ")
                // regex groups capture surrounding whitespace so we don't alter it
                .append(PATTERN_TO.matcher(definition).replaceAll("$1FROM$2"))
                .append(';')
                .toString();
    }

    public static void appendDefaultPrivileges(PgStatement newObj, StringBuilder sb) {
        DbObjType type = newObj.getStatementType();
        String name = newObj.getName();
        String column = "";
        String owner;

        if (type == DbObjType.COLUMN) {
            PgStatement parent = newObj.getParent();
            owner = PgDiffUtils.getQuotedName(parent.getOwner());
            column = '(' + PgDiffUtils.getQuotedName(name) + ')';
            name = PgDiffUtils.getQuotedName(parent.getName());
            type = DbObjType.TABLE;
        } else {
            if (type != DbObjType.FUNCTION) {
                name = PgDiffUtils.getQuotedName(name);
            }
            owner =  PgDiffUtils.getQuotedName(newObj.getOwner());
        }

        PgPrivilege priv = new PgPrivilege(true, "ALL" + column + " ON " + type + ' ' + name + " FROM PUBLIC", "");
        sb.append('\n').append(priv.getCreationSQL());
        priv = new PgPrivilege(true, "ALL" + column + " ON " + type + ' ' + name + " FROM " + owner, "");
        sb.append('\n').append(priv.getCreationSQL());
        priv = new PgPrivilege(false, "ALL" + column + " ON " + type + ' ' + name + " TO " + owner, "");
        sb.append('\n').append(priv.getCreationSQL());
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb, AtomicBoolean isNeedDepcies) {
        return false;
    }

    @Override
    public PgPrivilege deepCopy() {
        return shallowCopy();
    }

    @Override
    public PgPrivilege shallowCopy() {
        return new PgPrivilege(isRevoke(), getDefinition(), getRawStatement());
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof PgPrivilege){
            PgPrivilege priv = (PgPrivilege) obj;
            eq = revoke == priv.isRevoke()
                    && Objects.equals(definition, priv.getDefinition());
        }

        return eq;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        final int itrue = 1231;
        final int ifalse = 1237;
        int result = 1;
        result = prime * result + ((definition == null) ? 0 : definition.hashCode());
        result = prime * result + (revoke ? itrue : ifalse);
        return result;
    }

    @Override
    public String toString() {
        return getCreationSQL();
    }
}
