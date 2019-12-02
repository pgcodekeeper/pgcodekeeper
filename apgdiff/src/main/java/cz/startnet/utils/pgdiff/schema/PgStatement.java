package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
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
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.log.Log;
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
    protected final String name;
    protected String owner;
    protected String comment;
    protected final Set<PgPrivilege> privileges = new LinkedHashSet<>();

    private PgStatement parent;
    protected final Set<GenericColumn> deps = new LinkedHashSet<>();

    private final PgStatementMeta meta = new PgStatementMeta();

    // 0 means not calculated yet and/or hash has been reset
    private int hash;

    public PgStatement(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    //TODO enum later
    public boolean isPostgres() {
        return true;
    }

    public boolean canDrop() {
        return true;
    }

    public boolean isOwned() {
        switch (getStatementType()) {
        case FTS_CONFIGURATION:
        case FTS_DICTIONARY:
        case TABLE:
        case VIEW:
        case SCHEMA:
        case FUNCTION:
        case OPERATOR:
        case PROCEDURE:
        case AGGREGATE:
        case SEQUENCE:
        case TYPE:
        case DOMAIN:
        case ASSEMBLY:
            return true;
        default :
            return false;
        }
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

    public PgObjLocation getLocation() {
        return getMeta().getLocation();
    }

    public void setLocation(PgObjLocation location) {
        getMeta().setLocation(location);
    }

    public boolean isLib() {
        return getMeta().isLib();
    }

    public void markAsLib() {
        getMeta().setLib(true);
    }

    public String getAuthor() {
        return getMeta().getAuthor();
    }

    public void setAuthor(String author) {
        getMeta().setAuthor(author);
    }

    public PgStatementMeta getMeta() {
        return meta;
    }

    public abstract PgDatabase getDatabase();

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
        case FUNCTION:
        case PROCEDURE:
            sb.append(PgDiffUtils.getQuotedName(getParent().getName()))
            .append('.');
            ((AbstractPgFunction) this).appendFunctionSignature(sb, false, true);
            break;
        case AGGREGATE:
            sb.append(PgDiffUtils.getQuotedName(getParent().getName()))
            .append('.');
            ((PgAggregate) this).appendAggSignature(sb);
            break;
        case OPERATOR:
            sb.append(PgDiffUtils.getQuotedName(getParent().getName()))
            .append('.');
            ((PgOperator) this).appendOperatorSignature(sb);
            break;

        case CONSTRAINT:
        case TRIGGER:
        case RULE:
            sb.append(PgDiffUtils.getQuotedName(getName()))
            .append(" ON ")
            .append(getParent().getQualifiedName());
            break;

        case DATABASE:
            sb.append("current_database()");
            break;

        default:
            sb.append(getQualifiedName());
        }

        return sb.append(" IS ")
                .append(comment == null || comment.isEmpty() ? "NULL" : comment)
                .append(';');
    }

    public Set<PgPrivilege> getPrivileges() {
        return Collections.unmodifiableSet(privileges);
    }

    public void addPrivilege(PgPrivilege privilege) {
        if (isPostgres()) {
            String locOwner;
            if (owner == null && getStatementType() == DbObjType.SCHEMA
                    && ApgdiffConsts.PUBLIC.equals(getName())) {
                locOwner = "postgres";
            } else {
                locOwner = owner;
            }

            // Skip filtering if statement type is COLUMN, because of the
            // specific relationship with table privileges.
            // The privileges of columns for role are not set lower than for the
            // same role in the parent table, they may be the same or higher.
            if (DbObjType.COLUMN != getStatementType()
                    && privilege.getPermission().equalsIgnoreCase("ALL")) {
                addPrivilegeFiltered(privilege, locOwner);
            } else {
                privileges.add(privilege);
            }

        } else {
            privileges.add(privilege);
        }
        resetHash();
    }

    private void addPrivilegeFiltered(PgPrivilege privilege, String locOwner) {
        if (privilege.isRevoke()) {
            if ("PUBLIC".equals(privilege.getRole())) {
                switch (getStatementType()) {
                // revoke public is non-default for these
                case FUNCTION:
                case PROCEDURE:
                case AGGREGATE:
                case DOMAIN:
                case TYPE:
                    break;
                default:
                    return;
                }
            }
            privileges.add(privilege);
        } else if (!privilege.getRole().equals(locOwner)) {
            privileges.add(privilege);
        } else {
            PgPrivilege delRevoke = privileges.stream()
                    .filter(p -> p.isRevoke()
                            && p.getRole().equals(privilege.getRole())
                            && p.getPermission().equals(privilege.getPermission()))
                    .findAny().orElse(null);
            if (delRevoke != null) {
                privileges.remove(delRevoke);
            } else {
                privileges.add(privilege);
            }
        }
    }

    public void clearPrivileges() {
        privileges.clear();
        resetHash();
    }

    protected StringBuilder appendPrivileges(StringBuilder sb) {
        PgPrivilege.appendPrivileges(privileges, isPostgres(), sb);
        return sb;
    }

    protected void alterPrivileges(PgStatement newObj, StringBuilder sb) {
        // first drop (revoke) missing grants
        Set<PgPrivilege> newPrivileges = newObj.getPrivileges();
        for (PgPrivilege privilege : privileges) {
            if (!privilege.isRevoke() && !newPrivileges.contains(privilege)) {
                sb.append('\n').append(privilege.getDropSQL()).append(isPostgres() ? ';' : "\nGO");
            }
        }

        // now set all privileges if there are any changes
        if (!privileges.equals(newPrivileges)) {
            if (newObj.isPostgres()) {
                // first, reset all default privileges
                // this generates noisier bit more correct scripts
                // we may have revoked implicit owner GRANT in the previous step, it needs to be restored
                // any privileges in non-default state will be set to their final state in the next step
                // this solution also requires the least amount of handling code: no edge cases
                PgPrivilege.appendDefaultPrivileges(newObj, sb);
            }
            newObj.appendPrivileges(sb);
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
        return appendOwnerSQL(this, owner, true, sb);
    }

    public StringBuilder alterOwnerSQL(StringBuilder sb) {
        if (!isPostgres() && owner == null) {
            sb.append("\n\nALTER AUTHORIZATION ON ");
            DbObjType type = getStatementType();
            if (DbObjType.TYPE == type || DbObjType.SCHEMA == type
                    || DbObjType.ASSEMBLY == type) {
                sb.append(type).append("::");
            }

            sb.append(getQualifiedName()).append(" TO ");

            if (DbObjType.SCHEMA == type || DbObjType.ASSEMBLY == type) {
                sb.append("[dbo]");
            } else {
                sb.append("SCHEMA OWNER");
            }

            sb.append(GO);
        } else {
            appendOwnerSQL(sb);
        }
        return sb;
    }

    public static StringBuilder appendOwnerSQL(PgStatement st, String owner,
            boolean addNewLine, StringBuilder sb) {
        if (owner == null || !st.isOwned()) {
            return sb;
        }
        if (addNewLine) {
            sb.append("\n\n");
        }
        sb.append("ALTER ");
        if (st.isPostgres()) {
            DbObjType type = st.getStatementType();
            switch (type) {
            case FTS_CONFIGURATION:
                sb.append("TEXT SEARCH CONFIGURATION ");
                break;
            case FTS_DICTIONARY:
                sb.append("TEXT SEARCH DICTIONARY ");
                break;
            case TABLE:
                if (st instanceof AbstractForeignTable) {
                    sb.append("FOREIGN ");
                }
                sb.append("TABLE ");
                break;
            case VIEW:
                if (((PgView) st).isMatView()) {
                    sb.append("MATERIALIZED ");
                }
                sb.append("VIEW ");
                break;
            default :
                sb.append(type).append(' ');
            }

            if (type == DbObjType.SCHEMA) {
                sb.append(PgDiffUtils.getQuotedName(st.getName()));
            } else {
                sb.append(PgDiffUtils.getQuotedName(st.getParent().getName())).append('.');
                if (type == DbObjType.FUNCTION || type == DbObjType.PROCEDURE) {
                    ((AbstractPgFunction) st).appendFunctionSignature(sb, false, true);
                } else if (type == DbObjType.AGGREGATE) {
                    ((PgAggregate) st).appendAggSignature(sb);
                } else if (type == DbObjType.OPERATOR) {
                    ((PgOperator) st).appendOperatorSignature(sb);
                } else {
                    sb.append(PgDiffUtils.getQuotedName(st.getName()));
                }
            }
            sb.append(" OWNER TO ")
            .append(PgDiffUtils.getQuotedName(owner))
            .append(';');
        } else {
            sb.append("AUTHORIZATION ON ");
            DbObjType type = st.getStatementType();
            if (DbObjType.TYPE == type || DbObjType.SCHEMA == type
                    || DbObjType.ASSEMBLY == type) {
                sb.append(type).append("::");
            }

            sb.append(st.getQualifiedName()).append(" TO ")
            .append(MsDiffUtils.quoteName(owner)).append(GO);
        }

        return sb;
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
    public final PgStatement deepCopy() {
        PgStatement copy = shallowCopy();
        getChildren().forEach(st -> copy.addChild(st.deepCopy()));
        return copy;
    }

    /**
     * This method does not account for nested child PgStatements.
     * Shallow version of {@link #equals(Object)}
     */
    public boolean compare(PgStatement obj) {
        return Objects.equals(name, obj.name)
                && privileges.equals(obj.privileges)
                && Objects.equals(owner, obj.owner)
                && Objects.equals(comment, obj.comment);
    }

    protected final void copyBaseFields(PgStatement copy) {
        copy.setOwner(owner);
        copy.setComment(comment);
        copy.deps.addAll(deps);
        copy.privileges.addAll(privileges);
        copy.meta.copy(meta);
    }

    /**
     * @return an element in another db sharing the same name and location
     */
    public PgStatement getTwin(PgDatabase db) {
        if (getStatementType() == DbObjType.DATABASE) {
            return db;
        }
        PgStatement twinParent = getParent().getTwin(db);
        if (twinParent == null) {
            return null;
        }
        return getStatementType() == DbObjType.COLUMN ? ((AbstractTable) twinParent).getColumn(getName())
                : twinParent.getChild(getName(), getStatementType());
    }

    /**
     * Returns all subtree elements
     */
    public final Stream<PgStatement> getDescendants() {
        List<List<? extends PgStatement>> l = new ArrayList<>();
        fillDescendantsList(l);
        return l.stream().flatMap(List::stream);
    }

    /**
     * Returns all subelements of current element
     */
    public final Stream<PgStatement> getChildren() {
        List<List<? extends PgStatement>> l = new ArrayList<>();
        fillChildrenList(l);
        return l.stream().flatMap(List::stream);
    }

    public PgStatement getChild(String name, DbObjType type) {
        return getChildren()
                .filter(st -> type == st.getStatementType() && name.equals(st.getName()))
                .findAny()
                .orElse(null);
    }

    public boolean hasChildren() {
        return getChildren().anyMatch(e -> true);
    }

    protected void fillDescendantsList(List<List<? extends PgStatement>> l) {
        fillChildrenList(l);
    }

    protected void fillChildrenList(List<List<? extends PgStatement>> l) {
        // default no op
    }

    public void addChild(PgStatement st) {
        //  subclasses with children must override
        throw new IllegalStateException("Statement can't have child");
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
            computeLocalHash(hasher);
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
        computeLocalHash(hasher);
        computeHash(hasher);
        return hasher.getArray();
    }

    private final void computeLocalHash(Hasher hasher) {
        hasher.put(name);
        hasher.put(owner);
        hasher.put(comment);
        hasher.putUnordered(privileges);
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
    @Override
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