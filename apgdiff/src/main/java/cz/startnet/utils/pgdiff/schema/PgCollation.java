package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgCollation extends PgStatementWithSearchPath {

    public PgCollation(String name) {
        super(name);
    }

    private String locale;
    private String lcCollate;
    private String lcCtype;
    private String provider;
    private String version;
    private boolean deterministic = true;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.COLLATION;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(locale);
        hasher.put(lcCollate);
        hasher.put(lcCtype);
        hasher.put(provider);
        hasher.put(version);
        hasher.put(deterministic);

    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent();
    }

    @Override
    public PgStatement shallowCopy() {
        PgCollation collationDst = new PgCollation(getName());
        collationDst.locale = getLocale();
        collationDst.lcCollate = getLcCollate();
        collationDst.lcCtype = getLcCtype();
        collationDst.provider = getProvider();
        collationDst.version = getVersion();
        collationDst.deterministic = isDeterministic();
        return collationDst;
    }

    public String getLocale() {
        return locale;
    }

    public String getLcCollate() {
        return lcCollate;
    }

    public String getLcCtype() {
        return lcCtype;
    }

    public String getProvider() {
        return provider;
    }

    public String getVersion() {
        return version;
    }

    public boolean isDeterministic() {
        return deterministic;
    }

    public void setDeterministic(boolean deterministic) {
        this.deterministic = deterministic;
        resetHash();
    }

    public void setLocale(final String locale) {
        this.locale = locale;
        resetHash();
    }

    public void setLcCollate(final String lcCollate) {
        this.lcCollate = lcCollate;
        resetHash();
    }

    public void setLcCtype(final String lcCtype) {
        this.lcCtype = lcCtype;
        resetHash();
    }

    public void setProvider(final String provider) {
        this.provider = provider;
        resetHash();
    }

    public void setVersion(final String version) {
        this.version = version;
        resetHash();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgCollation && super.compare(obj)) {
            PgCollation coll = (PgCollation) obj;
            return deterministic == coll.isDeterministic()
                    && Objects.equals(lcCollate, coll.getLcCollate())
                    && Objects.equals(lcCtype, coll.getLcCtype())
                    && Objects.equals(provider, coll.getProvider())
                    && Objects.equals(version, coll.getVersion())
                    && Objects.equals(locale, coll.getLocale());
        }
        return false;
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE COLLATION ").append(getQualifiedName());
        sbSQL.append(" (");
        if (getLocale() != null) {
            sbSQL.append(" LOCALE = '").append(getLocale()).append("'");
        } else {
            sbSQL.append(" LC_COLLATE = '").append(getLcCollate()).append("', ");
            sbSQL.append(" LC_CTYPE = '").append(getLcCtype()).append("'");
        }
        if (getProvider() != null) {
            sbSQL.append(", PROVIDER = '").append(getProvider()).append("'");
        }
        if (getVersion() != null) {
            sbSQL.append(", VERSION = '").append(getVersion()).append("'");
        }
        if(!isDeterministic()) {
            sbSQL.append(", DETERMINISTIC = FALSE");
        }
        sbSQL.append(");");

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP COLLATION " + getQualifiedName() + ";";
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb, AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgCollation newCollation = (PgCollation) newCondition;

        if (!Objects.equals(newCollation.getLocale(), getLocale())
                || !Objects.equals(newCollation.getLcCtype(), getLcCtype())
                || !Objects.equals(newCollation.getLcCollate(), getLcCollate())
                || !Objects.equals(newCollation.getProvider(), getProvider())
                || !(newCollation.isDeterministic() == isDeterministic())) {
            isNeedDepcies.set(true);
            return true;
        }

        if (!Objects.equals(getOwner(), newCollation.getOwner())) {
            newCollation.alterOwnerSQL(sb);
        }

        return sb.length() > startLength;
    }
}
