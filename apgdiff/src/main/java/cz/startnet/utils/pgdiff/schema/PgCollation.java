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

        final int startLength = sb.length();
        PgCollation newCollation = (PgCollation) newCondition;
        StringBuilder sbSQL = new StringBuilder();

        if (compareCollationBody(newCollation, sbSQL)) {
            sb.append("\n\nALTER COLLATION ").append(newCollation.getQualifiedName()).
            append(sbSQL).append(';');
        }

        if (!Objects.equals(getOwner(), newCollation.getOwner())) {
            newCollation.alterOwnerSQL(sb);
        }

        alterPrivileges(newCollation, sb);

        if (!Objects.equals(getComment(), newCollation.getComment())) {
            sb.append("\n\n");
            newCollation.appendCommentSql(sb);
        }

        return sb.length() > startLength;
    }

    private boolean compareCollationBody(PgCollation newCollation, StringBuilder sbSQL) {

        final String newILocale = newCollation.getILocale() ;
        if (newILocale != null && !newILocale.equals(getILocale())) {
            sbSQL.append("\n\tILOCALE = ");
            sbSQL.append(newILocale);
        }

        final String newLcCollate = newCollation.getLcCollate();
        if (newLcCollate != null && !newLcCollate.equals(getLcCollate())) {
            sbSQL.append("\n\tLCCOLLATE = ");
            sbSQL.append(newLcCollate);
        }

        final String newLcCtype = newCollation.getLcCtype();
        if (newLcCtype != null && !newLcCtype.equals(getLcCtype())) {
            sbSQL.append("\n\tLCCTYPE = ");
            sbSQL.append(newLcCtype);
        }

        final String newProvider = newCollation.getProvider();
        if (newProvider != null && !(newProvider.equals(getProvider()))) {
            sbSQL.append("\n\tPROVIDER ");
            sbSQL.append(newProvider);
        }

        final String newVersion = newCollation.getVersion();
        if (newVersion != null && !newVersion.equals(getVersion())) {
            sbSQL.append("\n\tVERSION ");
            sbSQL.append(newVersion);
        }

        final boolean newDeterministic = newCollation.isDeterministic();
        if (!isDeterministic() && newDeterministic) {
            sbSQL.append("\n\tDETERMINISTIC = ");
            sbSQL.append(newDeterministic);
        }

        return sbSQL.length() > 0;
    }

}
