/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.formatter.FileFormatter;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.hashers.IHashable;
import ru.taximaxim.codekeeper.core.hashers.JavaHasher;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.ObjectCreationException;
import ru.taximaxim.codekeeper.core.script.SQLScript;
import ru.taximaxim.codekeeper.core.settings.ISettings;

/**
 * The superclass for general pgsql statement.
 * All changes to hashed fields of extending classes must be
 * followed by a {@link #resetHash()} call.
 *
 * @author Alexander Levsha
 */
public abstract class PgStatement implements IStatement, IHashable {

    protected static final String IF_EXISTS = "IF EXISTS ";
    protected static final String ALTER_TABLE = "ALTER TABLE ";

    //TODO move to MS SQL statement abstract class.
    public static final String GO = "\nGO";
    protected final String name;
    protected String owner;
    protected String comment;
    private final Set<PgPrivilege> privileges = new LinkedHashSet<>();

    protected PgStatement parent;
    protected final Set<GenericColumn> deps = new LinkedHashSet<>();

    protected final PgStatementMeta meta = new PgStatementMeta();

    // 0 means not calculated yet and/or hash has been reset
    private int hash;
    protected String qualifiedName;

    protected PgStatement(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public DatabaseType getDbType() {
        return DatabaseType.PG;
    }

    public boolean canDrop() {
        return true;
    }

    public boolean isSubElement() {
        return false;
    }

    public boolean isOwned() {
        return switch (getStatementType()) {
        case FOREIGN_DATA_WRAPPER, SERVER, EVENT_TRIGGER, FTS_CONFIGURATION, FTS_DICTIONARY, TABLE, VIEW, SCHEMA,
        FUNCTION, OPERATOR, PROCEDURE, AGGREGATE, SEQUENCE, COLLATION, TYPE, DOMAIN, ASSEMBLY, STATISTICS -> true;
        default -> false;
        };
    }

    /**
     * @return Always returns just the object's name.
     */
    // TODO super?
    @Override
    public final String getBareName() {
        return name;
    }

    @Override
    public PgStatement getParent() {
        return parent;
    }

    public PgObjLocation getLocation() {
        return meta.getLocation();
    }

    public void setLocation(PgObjLocation location) {
        meta.setLocation(location);
    }

    public boolean isLib() {
        return meta.isLib();
    }

    public String getLibName() {
        return meta.getLibName();
    }

    public void setLibName(String libName) {
        meta.setLibName(libName);
    }

    public String getAuthor() {
        return meta.getAuthor();
    }

    public void setAuthor(String author) {
        meta.setAuthor(author);
    }

    public void setParent(PgStatement parent) {
        if(parent != null && this.parent != null) {
            throw new IllegalStateException("Statement already has a parent: "
                    + this.getClass() + " Name: " + this.getName());
        }

        qualifiedName = null;
        this.parent = parent;
    }

    public Set<GenericColumn> getDeps() {
        return Collections.unmodifiableSet(deps);
    }

    public void addDep(GenericColumn dep){
        deps.add(dep);
    }

    public void addAllDeps(Collection<GenericColumn> deps){
        this.deps.addAll(deps);
    }

    @Override
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
        resetHash();
    }

    public String getTypeName() {
        return getStatementType().getTypeName();
    }

    protected StringBuilder appendFullName(StringBuilder sb) {
        return sb.append(getQualifiedName());
    }

    public void appendComments(SQLScript script) {
        if (checkComments()) {
            appendCommentSql(script);
        }
    }

    public boolean checkComments() {
        return comment != null && !comment.isEmpty();
    }

    public void appendAlterComments(PgStatement newObj, SQLScript script) {
        if (!Objects.equals(getComment(), newObj.getComment())) {
            newObj.appendCommentSql(script);
        }
    }

    protected void appendCommentSql(SQLScript script) {
        StringBuilder sb = new StringBuilder();
        sb.append("COMMENT ON ").append(getTypeName()).append(' ');
        appendFullName(sb);
        sb.append(" IS ")
        .append(checkComments() ? comment : "NULL");
        script.addCommentStatement(sb.toString());
    }

    protected void appendAlterOwner(PgStatement newObj, SQLScript script) {
        if (!Objects.equals(owner, newObj.owner)) {
            newObj.alterOwnerSQL(script);
        }
    }

    public Set<PgPrivilege> getPrivileges() {
        return Collections.unmodifiableSet(privileges);
    }

    public void addPrivilege(PgPrivilege privilege) {
        switch (getDbType()) {
        case PG:
            String locOwner;
            if (owner == null && getStatementType() == DbObjType.SCHEMA
                    && Consts.PUBLIC.equals(getName())) {
                locOwner = "postgres";
            } else {
                locOwner = owner;
            }

            // Skip filtering if statement type is COLUMN, because of the
            // specific relationship with table privileges.
            // The privileges of columns for role are not set lower than for the
            // same role in the parent table, they may be the same or higher.
            if (DbObjType.COLUMN != getStatementType()
                    && "ALL".equalsIgnoreCase(privilege.getPermission())) {
                addPrivilegeFiltered(privilege, locOwner);
            } else {
                privileges.add(privilege);
            }
            break;
        case MS:
        case CH:
            privileges.add(privilege);
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + getDbType());
        }
        resetHash();
    }

    private void addPrivilegeFiltered(PgPrivilege privilege, String locOwner) {
        if ("PUBLIC".equals(privilege.getRole())) {
            boolean isFunc = switch (getStatementType()) {
            case FUNCTION, PROCEDURE, AGGREGATE, DOMAIN, TYPE -> true;
            default -> false;
            };
            if (isFunc != privilege.isRevoke()) {
                return;
            }
        }

        if (!privilege.isRevoke() && privilege.getRole().equals(locOwner)) {
            PgPrivilege delRevoke = privileges.stream()
                    .filter(p -> p.isRevoke()
                            && p.getRole().equals(privilege.getRole())
                            && p.getPermission().equals(privilege.getPermission()))
                    .findAny().orElse(null);
            if (delRevoke != null) {
                privileges.remove(delRevoke);
                return;
            }
        }
        privileges.add(privilege);
    }

    public void clearPrivileges() {
        privileges.clear();
        resetHash();
    }

    protected void appendPrivileges(SQLScript script) {
        PgPrivilege.appendPrivileges(privileges, script);
    }

    protected void alterPrivileges(PgStatement newObj, SQLScript script) {
        Set<PgPrivilege> newPrivileges = newObj.privileges;

        // if new object has all privileges from old object and if it doesn't have
        // new revokes, then we can just grant difference between new and old privileges
        if (getDbType() == DatabaseType.PG && newPrivileges.containsAll(privileges)
                && Objects.equals(owner, newObj.owner)) {
            Set<PgPrivilege> diff = new LinkedHashSet<>(newPrivileges);
            diff.removeAll(privileges);
            boolean isGrantOnly = diff.stream().noneMatch(PgPrivilege::isRevoke);
            if (isGrantOnly) {
                PgPrivilege.appendPrivileges(diff, script);
                return;
            }
        }

        // first drop (revoke) missing grants
        for (PgPrivilege privilege : privileges) {
            if (!privilege.isRevoke() && !newPrivileges.contains(privilege)) {
                script.addStatement(privilege.getDropSQL());
            }
        }

        // now set all privileges if there are any changes
        if (!privileges.equals(newPrivileges)) {
            if (newObj.getDbType() == DatabaseType.PG) {
                // first, reset all default privileges
                // this generates noisier bit more correct scripts
                // we may have revoked implicit owner GRANT in the previous step, it needs to be restored
                // any privileges in non-default state will be set to their final state in the next step
                // this solution also requires the least amount of handling code: no edge cases
                PgPrivilege.appendDefaultPostgresPrivileges(newObj, script);
            }
            newObj.appendPrivileges(script);
        }
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
        resetHash();
    }

    private void alterOwnerSQL(SQLScript script) {
        if (getDbType() == DatabaseType.MS && owner == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("ALTER AUTHORIZATION ON ");
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

            script.addStatement(sb);
        } else {
            appendOwnerSQL(script);
        }
    }

    public void appendOwnerSQL(SQLScript script) {
        if (owner == null || !isOwned()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ALTER ");

        switch (getDbType()) {
        case PG:
            sb.append(getTypeName()).append(' ');
            appendFullName(sb);
            sb.append(" OWNER TO ")
            .append(PgDiffUtils.getQuotedName(owner));
            break;
        case MS:
            sb.append("AUTHORIZATION ON ");
            DbObjType type = getStatementType();
            if (DbObjType.TYPE == type || DbObjType.SCHEMA == type
                    || DbObjType.ASSEMBLY == type) {
                sb.append(type).append("::");
            }

            sb.append(getQualifiedName()).append(" TO ")
            .append(MsDiffUtils.quoteName(owner));
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + getDbType());
        }
        script.addStatement(sb);
    }

    public abstract void getCreationSQL(SQLScript script);

    public String getSQL(boolean isFormatted, ISettings settings) {
        SQLScript script = new SQLScript(settings);
        getCreationSQL(script);
        String sql = script.getFullScript();
        if (!isFormatted || !settings.isAutoFormatObjectCode()) {
            return sql;
        }
        FileFormatter fileForm = new FileFormatter(sql, 0, sql.length(), settings.getFormatConfiguration(),
                getDbType());
        return fileForm.formatText();
    }

    public final void getDropSQL(SQLScript script) {
        getDropSQL(script, script.getSettings().isGenerateExists());
    }

    public boolean canDropBeforeCreate() {
        return false;
    }

    public void getDropSQL(SQLScript script, boolean generateExists) {
        final StringBuilder sb = new StringBuilder();
        sb.append("DROP ").append(getTypeName()).append(' ');
        if (generateExists) {
            sb.append(IF_EXISTS);
        }
        appendFullName(sb);
        script.addStatement(sb);
    }

    protected void appendIfNotExists(StringBuilder sb, ISettings settings) {
        if (settings.isGenerateExists()) {
            sb.append("IF NOT EXISTS ");
        }
    }

    /**
     * Fill script with object changes and return change type <br>
     * <br>
     *
     * @param newCondition
     *            new object state
     * @param script
     *            script to collect changes
     * @return object change type
     */
    public abstract ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script);

    public ObjectState getObjectState(SQLScript script, int startSize) {
        return getObjectState(false, script, startSize);
    }

    public ObjectState getObjectState(boolean isNeedDepcies, SQLScript script, int startSize) {
        if (script.getSize() == startSize) {
            return ObjectState.NOTHING;
        }

        return isNeedDepcies ? ObjectState.ALTER_WITH_DEP : ObjectState.ALTER;
    }
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
        if (copy instanceof IStatementContainer cont) {
            getChildren().forEach(st -> cont.addChild(st.deepCopy()));
        }
        return copy;
    }

    /**
     * This method does not account for nested child PgStatements.
     * Shallow version of {@link #equals(Object)}
     */
    public boolean compare(PgStatement obj) {
        return getStatementType() == obj.getStatementType()
                && Objects.equals(name, obj.name)
                && Objects.equals(owner, obj.owner)
                && Objects.equals(comment, obj.comment)
                && privileges.equals(obj.privileges);
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
    public PgStatement getTwin(AbstractDatabase db) {
        // fast path for getting a "twin" from the same database
        // return the same object immediately
        return getDatabase() == db ? this : getTwinRecursive(db);
    }

    private PgStatement getTwinRecursive(AbstractDatabase db) {
        DbObjType type = getStatementType();
        if (DbObjType.DATABASE == type) {
            return db;
        }
        PgStatement twinParent = parent.getTwinRecursive(db);
        if (twinParent == null) {
            return null;
        }
        if (DbObjType.COLUMN == type) {
            return ((AbstractTable) twinParent).getColumn(getName());
        }
        if (twinParent instanceof IStatementContainer cont) {
            return cont.getChild(getName(), type);
        }

        return null;
    }

    /**
     * Returns all subtree elements
     */
    public final Stream<PgStatement> getDescendants() {
        List<Collection<? extends PgStatement>> l = new ArrayList<>();
        fillDescendantsList(l);
        return l.stream().flatMap(Collection::stream);
    }

    /**
     * Returns all subelements of current element
     */
    public final Stream<PgStatement> getChildren() {
        List<Collection<? extends PgStatement>> l = new ArrayList<>();
        fillChildrenList(l);
        return l.stream().flatMap(Collection::stream);
    }

    public boolean hasChildren() {
        return getChildren().anyMatch(e -> true);
    }

    protected void fillDescendantsList(List<Collection<? extends PgStatement>> l) {
        fillChildrenList(l);
    }

    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        // default no op
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
        }

        if (obj instanceof PgStatement st) {
            return this.compare(st)
                    && this.parentNamesEquals(st)
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
        PgStatement p2 = st.parent;
        while (p != null && p2 != null) {
            if (!Objects.equals(p.getName(), p2.getName())) {
                return false;
            }
            p = p.parent;
            p2 = p2.parent;
        }
        return p == null && p2 == null;
    }

    /**
     * Calls {@link #computeHash}. Modifies that value with combined hashcode
     * of all parents of this object in the tree to complement
     * {@link #parentNamesEquals(PgStatement)} and {@link #equals(Object)}<br>
     * Caches the hashcode value until recalculation is requested via {@link #resetHash()}.
     * Always request recalculation when you change the hashed fields.<br>
     * Do actual hashing in {@link #computeHash}.
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

    private final void computeLocalHash(Hasher hasher) {
        hasher.put(name);
        hasher.put(owner);
        hasher.put(comment);
        hasher.putUnordered(privileges);
    }

    protected void resetHash(){
        PgStatement st = this;
        while (st != null) {
            st.hash = 0;
            st = st.parent;
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
            p = p.parent;
        }
    }

    /**
     * @return fully qualified (up to schema) dot-delimited object name.
     *          Identifiers are quoted.
     */
    @Override
    public String getQualifiedName() {
        if (qualifiedName == null) {
            UnaryOperator<String> quoter = Utils.getQuoter(getDbType());
            StringBuilder sb = new StringBuilder(quoter.apply(name));

            PgStatement par = this.parent;
            while (par != null && !(par instanceof AbstractDatabase)) {
                sb.insert(0, '.').insert(0, quoter.apply(par.name));
                par = par.parent;
            }

            qualifiedName = sb.toString();
        }

        return qualifiedName;
    }


    @Override
    public String toString() {
        return name == null ? "Unnamed object" : name;
    }

    protected void assertUnique(PgStatement found, PgStatement newSt) {
        if (found != null) {
            PgStatement foundParent = found.parent;
            throw foundParent instanceof ISearchPath
            ? new ObjectCreationException(newSt, foundParent)
                    : new ObjectCreationException(newSt);
        }
    }

    protected <T extends PgStatement> void addUnique(Map<String, T> map, T newSt) {
        PgStatement found = map.putIfAbsent(getNameInCorrectCase(newSt.getName()), newSt);
        assertUnique(found, newSt);
        newSt.setParent(this);
        resetHash();
    }

    protected <T extends PgStatement> T getChildByName(Map<String, T> map, String name) {
        String lowerCaseName = getNameInCorrectCase(name);
        return map.get(lowerCaseName);
    }

    private String getNameInCorrectCase(String name) {
        return DatabaseType.MS == getDbType() ? name.toLowerCase(Locale.ROOT) : name;
    }
}
