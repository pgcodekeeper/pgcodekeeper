package cz.startnet.utils.pgdiff.schema;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import cz.startnet.utils.pgdiff.hashers.IHashable;
import cz.startnet.utils.pgdiff.hashers.JavaHasher;
import cz.startnet.utils.pgdiff.hashers.ShaHasher;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.ObjectCreationException;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * The superclass for general pgsql statement.
 * All changes to hashed fields of extending classes must be
 * followed by a {@link #resetHash()} call.
 *
 * @author Alexander Levsha
 */
public abstract class PgStatement implements IStatement, IHashable {
    //TODO move to MS SQL statement abstract class.
    public static final String GO = "\nGO";
    /**
     * The statement as it's been read from dump before parsing.
     */
    private final String rawStatement;
    protected final String name;
    protected String owner;
    protected String comment;
    protected final Set<PgPrivilege> grants = new LinkedHashSet<>();
    protected final Set<PgPrivilege> revokes = new LinkedHashSet<>();

    private PgStatement parent;
    protected final Set<GenericColumn> deps = new LinkedHashSet<>();

    private String location;
    private boolean isLib;

    // 0 means not calculated yet and/or hash has been reset
    private int hash;

    public PgStatement(String name, String rawStatement) {
        this.name = name;
        this.rawStatement = rawStatement;
    }

    public String getRawStatement() {
        return rawStatement;
    }

    @Override
    public String getName() {
        return name;
    }

    //TODO enum later
    public boolean isPostgres() {
        return true;
    }

    /**
     * @return Always returns just the object's name.
     */
    public final String getBareName() {
        return name;
    }

    @Override
    public PgStatement getParent() {
        return parent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isLib() {
        return isLib;
    }

    public void markAsLib() {
        this.isLib = true;
    }

    public abstract PgDatabase getDatabase();

    public void dropParent() {
        parent = null;
    }

    public void setParent(PgStatement parent) {
        if(this.parent != null) {
            throw new IllegalStateException("Statement already has a parent: "
                    + this.getClass() + " Name: " + this.getName());
        }

        this.parent = parent;
    }

    public Set<GenericColumn> getDeps() {
        return Collections.unmodifiableSet(deps);
    }

    public void addDep(GenericColumn dep){
        // TODO remove after fix
        if (dep == null) {
            Log.log(new Exception("null dependency added for " + getQualifiedName()));
        }
        deps.add(dep);
    }

    public void addAllDeps(Collection<GenericColumn> deps){
        // TODO remove after fix
        if (deps.contains(null)) {
            Log.log(new Exception("null dependency added for " + getQualifiedName()));
        }
        this.deps.addAll(deps);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
        resetHash();
    }

    /**
     * Sets {@link #comment} with newlines as requested in arguments.
     */
    public void setComment(PgDiffArguments args, String comment) {
        setComment(args.isKeepNewlines() ? comment : comment.replace("\r", ""));
    }

    protected StringBuilder appendCommentSql(StringBuilder sb) {
        sb.append("COMMENT ON ");
        DbObjType type = getStatementType();
        sb.append(type).append(' ');
        switch (type) {
        case COLUMN:
            sb.append(PgDiffUtils.getQuotedName(getParent().getParent().getName()))
            .append('.')
            .append(PgDiffUtils.getQuotedName(getParent().getName()))
            .append('.')
            .append(PgDiffUtils.getQuotedName(getName()));
            break;
        case FUNCTION:
            sb.append(PgDiffUtils.getQuotedName(getParent().getName()))
            .append('.');
            ((PgFunction) this).appendFunctionSignature(sb, false, true);
            break;

        case CONSTRAINT:
        case TRIGGER:
        case RULE:
            sb.append(PgDiffUtils.getQuotedName(getName()))
            .append(" ON ")
            .append(PgDiffUtils.getQuotedName(getParent().getParent().getName()))
            .append('.')
            .append(PgDiffUtils.getQuotedName(getParent().getName()));
            break;

        case INDEX:
            sb.append(PgDiffUtils.getQuotedName(getParent().getParent().getName()))
            .append('.')
            .append(PgDiffUtils.getQuotedName(getName()));
            break;

        case DATABASE:
            sb.append("current_database()");
            break;

        case SCHEMA:
        case EXTENSION:
            sb.append(PgDiffUtils.getQuotedName(getName()));
            break;

        default:
            sb.append(PgDiffUtils.getQuotedName(getParent().getName()))
            .append('.')
            .append(PgDiffUtils.getQuotedName(getName()));
        }

        return sb.append(" IS ")
                .append(comment == null || comment.isEmpty() ? "NULL" : comment)
                .append(';');
    }

    public String getCommentSql() {
        return appendCommentSql(new StringBuilder()).toString();
    }

    public Set<PgPrivilege> getGrants() {
        return Collections.unmodifiableSet(grants);
    }

    public Set<PgPrivilege> getRevokes() {
        return Collections.unmodifiableSet(revokes);
    }

    public void addPrivilege(PgPrivilege privilege) {
        if (privilege.isRevoke()) {
            revokes.add(privilege);
        } else {
            grants.add(privilege);
        }
        resetHash();
    }

    public void clearPrivileges() {
        grants.clear();
        revokes.clear();
        resetHash();
    }

    protected StringBuilder appendPrivileges(StringBuilder sb) {
        if (grants.isEmpty() && revokes.isEmpty()) {
            return sb;
        }

        sb.append("\n\n-- ")
        .append(getStatementType())
        .append(' ');
        if (DbObjType.SCHEMA != getStatementType()) {
            if (this instanceof PgStatementWithSearchPath) {
                sb.append(((PgStatementWithSearchPath)this).getContainingSchema().getName())
                .append('.');
            }

            if (DbObjType.COLUMN == getStatementType()) {
                sb.append(getParent().getName()).append('.');
            }
        }
        sb.append(getName())
        .append(' ')
        .append("GRANT\n");

        for (PgPrivilege priv : revokes) {
            sb.append('\n').append(priv.getCreationSQL()).append(isPostgres() ? ';' : "\nGO");
        }
        for (PgPrivilege priv : grants) {
            sb.append('\n').append(priv.getCreationSQL()).append(isPostgres() ? ';' : "\nGO");
        }

        return sb;
    }

    protected void alterPrivileges(PgStatement newObj, StringBuilder sb) {
        // first drop (revoke) missing grants
        boolean grantsChanged = false;
        Set<PgPrivilege> newGrants = newObj.getGrants();
        for (PgPrivilege grant : grants) {
            if (!newGrants.contains(grant)) {
                grantsChanged = true;
                sb.append('\n').append(grant.getDropSQL()).append(isPostgres() ? ';' : "\nGO");
            }
        }

        // now set all privileges if there are any changes
        grantsChanged = grantsChanged || grants.size() != newGrants.size();
        if (grantsChanged || !revokes.equals(newObj.getRevokes())) {
            newObj.appendPrivileges(sb);
            if (newObj.isPostgres() && newObj.revokes.isEmpty() && newObj.grants.isEmpty()) {
                PgPrivilege.appendDefaultPrivileges(newObj, sb);
            }
        }
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
        resetHash();
    }

    protected StringBuilder appendOwnerSQL(StringBuilder sb) {
        if (owner == null) {
            return sb;
        }
        sb.append("\n\nALTER ");

        if (isPostgres()) {
            DbObjType type = getStatementType();
            sb.append(type).append(' ');
            if (type == DbObjType.SCHEMA) {
                sb.append(PgDiffUtils.getQuotedName(getName()));
            } else {
                sb.append(PgDiffUtils.getQuotedName(getParent().getName())).append('.');
                if (type == DbObjType.FUNCTION) {
                    ((PgFunction) this).appendFunctionSignature(sb, false, true);
                } else {
                    sb.append(PgDiffUtils.getQuotedName(getName()));
                }
            }
            sb.append(" OWNER TO ")
            .append(PgDiffUtils.getQuotedName(owner))
            .append(';');
        } else {
            sb.append("AUTHORIZATION ON ").append(getQualifiedName())
            .append(" TO ").append(MsDiffUtils.quoteName(owner)).append(GO);
        }

        return sb;
    }

    public String getOwnerSQL() {
        if (!isPostgres() && owner == null) {
            return "\n\nALTER AUTHORIZATION ON " + getQualifiedName() + " TO SCHEMA OWNER" + GO;
        }
        return appendOwnerSQL(new StringBuilder()).toString();
    }

    public abstract String getCreationSQL();

    public String getFullSQL() {
        return getCreationSQL();
    }

    public abstract String getDropSQL();

    /**
     * Метод заполняет sb выражением изменения объекта, можно ли изменить объект
     * ALTER.<br><br>
     *
     * Результат работы метода определяется по паре значений:
     * возвращаемое значение и длина sb.length().<br>
     * Возвращаемое значение говорит о статусе объекта: изменился или нет.<br>
     * sb.length() говорит о возможностиизменить состояние объекта ALTERом
     * (если объект вообще изменился).<br><br>
     *
     * <code>sb == 0 && rv == false</code> - не требуется действий<br>
     * <code>sb >  0 && rv == false</code> - illegal state, неизмененный объект с ALTER<br>
     * <code>sb == 0 && rv == true</code>  - ALTER невозможен, делаем DROP/CREATE<br>
     * <code>sb >  0 && rv == true</code>  - делаем ALTER
     *
     * @param newCondition новое состоятние объекта
     * @param sb скрипт изменения
     * @param isNeedDepcies out параметр: нужно ли использовать зависимости объекта
     * @return true - необходимо изменить объект, используя DROP в случае
     *                 невозможности ALTER, false - объект не изменился
     */
    public abstract boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies);

    /**
     * Copies all object properties into a new object and leaves all its children empty.
     *
     * @return shallow copy of a DB object.
     */
    public abstract PgStatement shallowCopy();

    /**
     * Performs {@link #shallowCopy()} on this object and all its children.
     *
     * @return a fully recursive copy of this statement.
     */
    public abstract PgStatement deepCopy();

    /**
     * This method does not account for nested child PgStatements.
     * Shallow version of {@link #equals(Object)}
     */
    public abstract boolean compare(PgStatement obj);

    /**
     * Returns all subtree elements
     */
    public Stream<PgStatement> getDescendants() {
        return getChildren();
    }

    /**
     * Returns all subelements of current element
     */
    public Stream<PgStatement> getChildren() {
        return Stream.empty();
    }

    public boolean hasChildren() {
        return getChildren().anyMatch(e -> true);
    }

    /**
     * Deep part of {@link #equals(Object)}.
     * Compares all object's child PgStatements for equality.
     */
    public boolean compareChildren(PgStatement obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Null PgStatement!");
        }
        return true;
    }

    /**
     * Compares this object and all its children with another statement.
     * <hr><br>
     * {@inheritDoc}
     */
    @Override
    public final boolean equals(Object obj){
        if (this == obj) {
            return true;
        } else if (obj instanceof PgStatement) {
            PgStatement st = (PgStatement) obj;
            return this.parentNamesEquals(st)
                    && this.compare(st)
                    && this.compareChildren(st);
        }
        return false;
    }

    /**
     * Recursively compares objects' parents
     * to ensure their equal position in their object trees.
     */
    private boolean parentNamesEquals(PgStatement st){
        PgStatement p = parent;
        PgStatement p2 = st.getParent();
        while (p != null && p2 != null){
            if (!Objects.equals(p.getName(), p2.getName())){
                return false;
            }
            p = p.getParent();
            p2 = p2.getParent();
        }
        return p == null && p2 == null;
    }

    /**
     * Calls {@link #computeHash()}. Modifies that value with combined hashcode
     * of all parents of this object in the tree to complement
     * {@link #parentNamesEquals(PgStatement)} and {@link #equals(Object)}<br>
     * Caches the hashcode value until recalculation is requested via {@link #resetHash()}.
     * Always request recalculation when you change the hashed fields.<br>
     * Do actual hashing in {@link #computeHash()}.
     * <hr><br>
     * {@inheritDoc}
     */
    @Override
    public final int hashCode() {
        int h = hash;
        if (h == 0) {
            JavaHasher hasher = new JavaHasher();
            computeHash(hasher);
            computeChildrenHash(hasher);
            computeNamesHash(hasher);
            h = hasher.getResult();

            if (h == 0) {
                h = Integer.MAX_VALUE;
            }
            hash = h;
        }
        return h;
    }


    /**
     * Compute local hash
     *
     * @return hash byte array
     */
    public final byte[] shaHash() {
        ShaHasher hasher = new ShaHasher();
        computeHash(hasher);
        return hasher.getArray();
    }


    protected void resetHash(){
        PgStatement st = this;
        while (st != null){
            st.hash = 0;
            st = st.getParent();
        }
    }

    protected void computeChildrenHash(Hasher hasher) {
        // subclasses with children must override
    }

    private void computeNamesHash(Hasher hasher) {
        PgStatement p = parent;
        while (p != null) {
            String pName = p.getName();
            hasher.put(pName);
            p = p.getParent();
        }
    }

    /**
     * @return fully qualified (up to schema) dot-delimited object name.
     *          Identifiers are quoted.
     */
    public String getQualifiedName() {
        Function<String, String> quoter = isPostgres() ? PgDiffUtils::getQuotedName : MsDiffUtils::quoteName;
        StringBuilder sb = new StringBuilder(quoter.apply(getName()));

        PgStatement par = this.parent;
        while (par != null && !(par instanceof PgDatabase)) {
            sb.insert(0, '.').insert(0, quoter.apply(par.getName()));
            par = par.getParent();
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return name == null ? "Unnamed object" : name;
    }

    protected void assertUnique(Function<String, ? extends PgStatement> getter,
            PgStatement newSt) {
        PgStatement found = getter.apply(newSt.getName());
        if (found != null) {
            PgStatement foundParent = found.getParent();
            throw foundParent instanceof PgStatementWithSearchPath
            ? new ObjectCreationException(newSt, foundParent)
                    : new ObjectCreationException(newSt);
        }
    }

    @Override
    public DbObjNature getStatementNature() {
        return DbObjNature.USER;
    }
}
