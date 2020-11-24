package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgCollation extends PgStatementWithSearchPath {

    public PgCollation(String name) {
        super(name);
    }

    protected String locale;
    protected String lcCollate;
    protected String lcCtype;
    protected String provider;
    protected String version;
    protected boolean deterministic = true;

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
        PgCollation collationDst = getCollationCopy();
        collationDst.locale = getILocale();
        collationDst.lcCollate = getLcCollate();
        collationDst.lcCtype = getLcCtype();
        collationDst.provider = getProvider();
        collationDst.version = getVersion();
        collationDst.deterministic = isDeterministic();
        return collationDst;
    }

    public String getILocale() {
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
            return this == obj;
        }

        if (obj instanceof PgCollation && super.compare(obj)) {
            PgCollation coll = (PgCollation) obj;
            return deterministic == coll.isDeterministic()
                    && Objects.equals(lcCollate, coll.getLcCollate())
                    && Objects.equals(lcCtype, coll.getLcCtype())
                    && Objects.equals(provider, coll.getProvider())
                    && Objects.equals(version, coll.getVersion())
                    && Objects.equals(locale, coll.getLocation());
        }
        return false;
    }

    protected PgCollation getCollationCopy() {
        PgCollation collation = new PgCollation(getName());
        return collation;
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE COLLATION ").append(getQualifiedName());
        sbSQL.append(" (");
        if (getILocale() != null) {
            sbSQL.append(" locale = '").append(getILocale()).append("'");
        } else {
            sbSQL.append(" lc_collate = '").append(getLcCollate()).append("', ");
            sbSQL.append(" lc_ctype = '").append(getLcCtype()).append("'");
        }
        if (getILocale() != null) {
            sbSQL.append(", provider = '").append(getProvider()).append("'");
        }
        if (getVersion() != null) {
            sbSQL.append(", version = '").append(getVersion()).append("'");
        }
        sbSQL.append(", deterministic = '").append(isDeterministic()).append("'");
        sbSQL.append(" );");

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

        PgCollation newCollation = (PgCollation) newCondition;

        if (newCollation.getLcCtype().equals(getLcCtype()) ||
                newCollation.getLcCollate().equals(getLcCollate()) ||
                newCollation.getProvider().equals(getProvider()) ||
                newCollation.isDeterministic() == isDeterministic()) {
            isNeedDepcies.set(true);
            return true;
        }

        if (!Objects.equals(getOwner(), newCollation.getOwner())) {
            newCollation.alterOwnerSQL(sb);
        }

        alterPrivileges(newCollation, sb);

        return false;
    }
}
