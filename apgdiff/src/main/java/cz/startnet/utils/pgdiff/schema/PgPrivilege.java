package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgPrivilege extends PgStatement {

    // regex grouping here is used to preserve whitespace when doing replaceAll
    private static final Pattern PATTERN_TO = Pattern.compile("(\\s+)TO(\\s+)");
    public static final String WITH_GRANT_OPTION = " WITH GRANT OPTION";

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

        String definitionWithoutGO = definition.endsWith(WITH_GRANT_OPTION) ?
                definition.substring(0, definition.length() - WITH_GRANT_OPTION.length()) : definition;

        // TODO сделать надежнее чем просто регуляркой
        return new StringBuilder()
                .append("REVOKE ")
                // regex groups capture surrounding whitespace so we don't alter it
                .append(PATTERN_TO.matcher(definitionWithoutGO).replaceAll("$1FROM$2"))
                .append(';')
                .toString();
    }

    public static void appendDefaultPrivileges(PgStatement newObj, StringBuilder sb) {
        DbObjType type = newObj.getStatementType();
        String owner = type != DbObjType.COLUMN ? newObj.getOwner() : newObj.getParent().getOwner();
        if (owner == null) {
            return;
        }

        String name = newObj.getName();
        String column = "";

        if (type == DbObjType.COLUMN) {
            column = '(' + PgDiffUtils.getQuotedName(name) + ')';
            name = PgDiffUtils.getQuotedName(newObj.getParent().getName());
            type = DbObjType.TABLE;
        } else if (type != DbObjType.FUNCTION) {
            name = PgDiffUtils.getQuotedName(name);
        }

        owner =  PgDiffUtils.getQuotedName(owner);

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
    public void computeHash(Hasher hasher) {
        hasher.put(definition);
        hasher.put(revoke);
    }

    @Override
    public String toString() {
        return getCreationSQL();
    }

    @Override
    public PgDatabase getDatabase() {
        return null;
    }
}
