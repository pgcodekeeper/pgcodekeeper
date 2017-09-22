/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores table information.
 *
 * @author fordfrog
 */
public class PgTable extends PgStatementWithSearchPath
implements PgRuleContainer, PgTriggerContainer, PgOptionContainer {

    private static final String OIDS = "OIDS";
    private static final String ALTER_FOREIGN_OPTION = "{0} OPTIONS ({1} {2} {3});";

    private final List<PgColumn> columns = new ArrayList<>();
    private final List<PgColumn> columnsOfType = new ArrayList<>();
    private final List<Inherits> inherits = new ArrayList<>();
    private final Map<String, String> options = new LinkedHashMap<>();
    private final List<PgConstraint> constraints = new ArrayList<>();
    private final List<PgIndex> indexes = new ArrayList<>();
    private final List<PgTrigger> triggers = new ArrayList<>();
    private final List<PgRule> rules = new ArrayList<>();
    private boolean hasOids;
    private boolean isLogged = true;
    private boolean isRowSecurity;
    private boolean isForceSecurity;
    private String tablespace;
    private String ofType;
    private String serverName;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.TABLE;
    }

    public PgTable(String name, String rawStatement) {
        super(name, rawStatement);
    }

    public boolean isClustered() {
        for (PgIndex ind : indexes) {
            if (ind.isClusterIndex()) {
                return true;
            }
        }
        return false;
    }

    private String getAlterTable(boolean nextLine, boolean only) {
        StringBuilder sb = new StringBuilder();
        if (nextLine) {
            sb.append("\n\n");
        }
        sb.append("ALTER ");
        if (isForeign()) {
            sb.append("FOREIGN ");
        }
        sb.append("TABLE ");
        if (only) {
            sb.append("ONLY ");
        }
        sb.append(PgDiffUtils.getQuotedName(getName()));
        return sb.toString();
    }

    /**
     * Finds column according to specified column {@code name}.
     *
     * @param name name of the column to be searched
     *
     * @return found column or null if no such column has been found
     */
    public PgColumn getColumn(final String name) {
        for (PgColumn column : columns) {
            if (column.getName().equals(name)) {
                return column;
            }
        }
        return null;
    }

    /**
     * Finds columnOfType according to specified columnOfType {@code name}.
     *
     * @param name name of the column to be searched
     *
     * @return found column or null if no such column has been found
     */
    public PgColumn getColumnOfType(final String name) {
        for (PgColumn column : columnsOfType) {
            if (column.getName().equals(name)) {
                return column;
            }
        }
        return null;
    }

    /**
     * Getter for {@link #columns}. The list cannot be modified.
     *
     * @return {@link #columns}
     */
    public List<PgColumn> getColumns() {
        return Collections.unmodifiableList(columns);
    }

    /**
     * Getter for {@link #columnsOfType}. The list cannot be modified.
     *
     * @return {@link #columnsOfType}
     */
    public List<PgColumn> getColumnsOfType() {
        return Collections.unmodifiableList(columnsOfType);
    }

    /**
     * Finds constraint according to specified constraint {@code name}.
     *
     * @param name name of the constraint to be searched
     *
     * @return found constraint or null if no such constraint has been found
     */
    public PgConstraint getConstraint(final String name) {
        for (PgConstraint constraint : constraints) {
            if (constraint.getName().equals(name)) {
                return constraint;
            }
        }

        return null;
    }

    /**
     * Getter for {@link #constraints}. The list cannot be modified.
     *
     * @return {@link #constraints}
     */
    public List<PgConstraint> getConstraints() {
        return Collections.unmodifiableList(constraints);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbOption = new StringBuilder();
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE ");

        if (!isLogged()) {
            sbSQL.append("UNLOGGED ");
        } else if (isForeign()) {
            sbSQL.append("FOREIGN ");
        }

        sbSQL.append("TABLE ");
        sbSQL.append(PgDiffUtils.getQuotedName(name));

        boolean first = true;
        if(ofType != null){
            sbSQL.append(" OF ")
            .append(ofType);

            if (!columnsOfType.isEmpty()){
                sbSQL.append(" (\n");

                for (PgColumn column : columnsOfType) {
                    if (first) {
                        first = false;
                    } else {
                        sbSQL.append(",\n");
                    }

                    sbSQL.append("\t");
                    sbSQL.append(column.getFullDefinition(false, null, true));
                }

                sbSQL.append("\n)");
            }
        } else {
            sbSQL.append(" (\n");
            for (PgColumn column : columns) {
                if (first) {
                    first = false;
                } else {
                    sbSQL.append(",\n");
                }

                sbSQL.append("\t");
                sbSQL.append(column.getFullDefinition(false, null, false));

                if(column.getStorage() != null){
                    sbOption.append(getAlterTable(true, false))
                    .append(" ALTER COLUMN ")
                    .append(PgDiffUtils.getQuotedName(column.name))
                    .append(" SET STORAGE ")
                    .append(column.getStorage())
                    .append(';');
                }

                writeOptions(column, sbOption, false);
                writeOptions(column, sbOption, true);
            }

            if (!first) {
                sbSQL.append('\n');
            }
            sbSQL.append(')');
            if (inherits != null && !inherits.isEmpty()) {
                sbSQL.append("\nINHERITS (");

                first = true;

                for (final Inherits tableName : inherits) {
                    if (first) {
                        first = false;
                    } else {
                        sbSQL.append(", ");
                    }

                    sbSQL.append((tableName.getKey() == null ? "" : (tableName.getKey() + ".")) +
                            tableName.getValue());
                }

                sbSQL.append(")");
            }
        }

        if (isForeign()){
            sbSQL.append("\nSERVER ").append(serverName);
        }

        StringBuilder sb = new StringBuilder();

        for (Entry <String, String> entry : options.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();

            sb.append(key);
            if (!value.isEmpty()){
                sb.append(isForeign() ? ' ' : '=').append(value);
            }
            sb.append(", ");
        }

        if (hasOids) {
            sb.append(OIDS).append('=').append(hasOids).append(", ");
        }

        if (sb.length() > 0){
            sb.setLength(sb.length() - 2);
            sbSQL.append(isForeign() ? "\nOPTIONS (" : "\nWITH (").append(sb).append(")");
        }

        if (tablespace != null && !tablespace.isEmpty()) {
            sbSQL.append("\nTABLESPACE ");
            sbSQL.append(tablespace);
        }

        sbSQL.append(';');

        sbSQL.append(sbOption);

        // since 9.5 PostgreSQL
        if (isRowSecurity) {
            sbSQL.append(getAlterTable(true, false));
            sbSQL.append(" ENABLE ROW LEVEL SECURITY;");
        }

        // since 9.5 PostgreSQL
        if (isForceSecurity) {
            sbSQL.append(getAlterTable(true, true));
            sbSQL.append(" FORCE ROW LEVEL SECURITY;");
        }

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        if(ofType != null){
            for (PgColumn col : columnsOfType) {
                col.appendPrivileges(sbSQL);
            }
        } else {
            for (PgColumn col : columns) {
                col.appendPrivileges(sbSQL);
            }
        }

        for (PgColumn column : getColumnsWithStatistics()) {
            sbSQL.append(getAlterTable(true, true));
            sbSQL.append(" ALTER COLUMN ");
            sbSQL.append(PgDiffUtils.getQuotedName(column.getName()));
            sbSQL.append(" SET STATISTICS ");
            sbSQL.append(column.getStatistics());
            sbSQL.append(';');
        }

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        if(ofType != null){
            for (final PgColumn column : columnsOfType) {
                if (column.getComment() != null && !column.getComment().isEmpty()) {
                    sbSQL.append("\n\n");
                    column.appendCommentSql(sbSQL);
                }
            }
        } else {
            for (final PgColumn column : columns) {
                if (column.getComment() != null && !column.getComment().isEmpty()) {
                    sbSQL.append("\n\n");
                    column.appendCommentSql(sbSQL);
                }
            }
        }

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP " + (isForeign() ? "FOREIGN " : "") + "TABLE "
                + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgTable newTable;
        if (newCondition instanceof PgTable) {
            newTable = (PgTable)newCondition;
        } else {
            return false;
        }
        PgTable oldTable = this;

        if (!Objects.equals(newTable.getServerName(), oldTable.getServerName())) {
            isNeedDepcies.set(true);
            return true;
        }

        if (ofType != null) {
            if (!oldTable.getOfType().equals(newTable.getOfType())) {
                if (newTable.getOfType() != null) {
                    sb.append(getAlterTable(true, false))
                    .append(" OF ")
                    .append(newTable.getOfType())
                    .append(';');
                } else {
                    sb.append(getAlterTable(true, false))
                    .append(" NOT OF")
                    .append(';');
                }
            }

            StringBuilder colsSb = new StringBuilder();
            for (PgColumn newCol : newTable.getColumnsOfType()) {
                PgColumn oldCol = oldTable.getColumnOfType(newCol.getName());

                if (oldCol != null) {
                    String oldDefault = (oldCol.getDefaultValue() == null) ? ""
                            : oldCol.getDefaultValue();
                    String newDefault = (newCol.getDefaultValue() == null) ? ""
                            : newCol.getDefaultValue();

                    if (!oldDefault.equals(newDefault)) {
                        if (newDefault.isEmpty()) {
                            colsSb.append("\n\tALTER COLUMN ")
                            .append(PgDiffUtils.getQuotedName(oldCol.getName()))
                            .append(" DROP DEFAULT");
                        } else {
                            colsSb.append("\n\tALTER COLUMN ")
                            .append(PgDiffUtils.getQuotedName(newCol.getName()))
                            .append(" SET DEFAULT ")
                            .append(newDefault);
                        }
                        colsSb.append(", ");
                    }

                    if (oldCol.getNullValue() != newCol.getNullValue()) {
                        if (newCol.getNullValue()) {
                            colsSb.append("\n\tALTER COLUMN ")
                            .append(PgDiffUtils.getQuotedName(oldCol.getName()))
                            .append(" DROP NOT NULL");
                        } else {
                            colsSb.append("\n\tALTER COLUMN ")
                            .append(PgDiffUtils.getQuotedName(oldCol.getName()))
                            .append(" SET NOT NULL");
                        }
                        colsSb.append(", ");
                    }
                } else {
                    String newDefault = (newCol.getDefaultValue() == null) ? ""
                            : newCol.getDefaultValue();

                    if (!newDefault.isEmpty()){
                        colsSb.append("\n\tALTER COLUMN ")
                        .append(PgDiffUtils.getQuotedName(newCol.getName()))
                        .append(" SET DEFAULT ")
                        .append(newDefault)
                        .append(", ");
                    }

                    if (!newCol.getNullValue()) {
                        colsSb.append("\n\tALTER COLUMN ")
                        .append(PgDiffUtils.getQuotedName(newCol.getName()))
                        .append(" SET NOT NULL")
                        .append(", ");
                    }
                }
            }

            for (PgColumn oldCol : oldTable.getColumnsOfType()) {
                PgColumn newCol = newTable.getColumnOfType(oldCol.getName());

                if (newCol == null) {
                    String oldDefault = (oldCol.getDefaultValue() == null) ? ""
                            : oldCol.getDefaultValue();

                    if (!oldDefault.isEmpty()) {
                        colsSb.append("\n\tALTER COLUMN ")
                        .append(PgDiffUtils.getQuotedName(oldCol.getName()))
                        .append(" DROP DEFAULT")
                        .append(", ");
                    }

                    if (!oldCol.getNullValue()) {
                        colsSb.append("\n\tALTER COLUMN ")
                        .append(PgDiffUtils.getQuotedName(oldCol.getName()))
                        .append(" DROP NOT NULL")
                        .append(", ");
                    }
                }
            }

            if (colsSb.length() > 0) {
                // remove last comma
                colsSb.setLength(colsSb.length() - 2);
                sb.append("\n\nALTER TABLE ")
                .append(PgDiffUtils.getQuotedName(getName()))
                .append(colsSb).append(';');
            }
        } else {
            List<Inherits> oldInherits = oldTable.getInherits();
            List<Inherits> newInherits = newTable.getInherits();
            for (final Inherits tableName : oldInherits) {
                if (!newInherits.contains(tableName)) {
                    sb.append(getAlterTable(true, false))
                    .append("\n\tNO INHERIT ")
                    .append(tableName.getKey() == null ?
                            "" : PgDiffUtils.getQuotedName(tableName.getKey()) + '.')
                    .append(PgDiffUtils.getQuotedName(tableName.getValue()))
                    .append(';');
                }
            }
            for (final Inherits tableName : newInherits) {
                if (!oldInherits.contains(tableName)) {
                    sb.append(getAlterTable(true, false))
                    .append("\n\tINHERIT ")
                    .append(tableName.getKey() == null ?
                            "" : PgDiffUtils.getQuotedName(tableName.getKey()) + '.')
                    .append(PgDiffUtils.getQuotedName(tableName.getValue()))
                    .append(';');
                }
            }
        }

        if (isForeign()) {
            compareForeignOptions(oldTable.getOptions(), newTable.getOptions(), sb);
        } else {
            compareOptions(oldTable, newTable, sb);
        }

        if (oldTable.getHasOids() && !newTable.getHasOids()) {
            sb.append(getAlterTable(true, false))
            .append(" SET WITHOUT OIDS;");
        } else if (newTable.getHasOids() && !oldTable.getHasOids()) {
            sb.append(getAlterTable(true, false))
            .append(" SET WITH OIDS;");
        }

        if (!Objects.equals(oldTable.getTablespace(), newTable.getTablespace())) {
            sb.append(getAlterTable(true, false))
            .append("\n\tSET TABLESPACE ")
            .append(newTable.getTablespace())
            .append(';');
        }

        if (!Objects.equals(oldTable.getOwner(), newTable.getOwner())) {
            sb.append(newTable.getOwnerSQL());
        }

        // since 9.5 PostgreSQL
        if (oldTable.isLogged != newTable.isLogged) {
            sb.append(getAlterTable(true, false))
            .append("\n\tSET ")
            .append(newTable.isLogged ? "LOGGED" : "UNLOGGED")
            .append(';');
        }

        // since 9.5 PostgreSQL
        if (oldTable.isRowSecurity != newTable.isRowSecurity) {
            sb.append(getAlterTable(true, false))
            .append(newTable.isRowSecurity ? " ENABLE" : " DISABLE")
            .append(" ROW LEVEL SECURITY;");
        }

        // since 9.5 PostgreSQL
        if (oldTable.isForceSecurity != newTable.isForceSecurity) {
            sb.append(getAlterTable(true, true))
            .append(newTable.isForceSecurity ? "" : " NO")
            .append(" FORCE ROW LEVEL SECURITY;");
        }

        alterPrivileges(newTable, sb);

        if (!Objects.equals(oldTable.getComment(), newTable.getComment())) {
            sb.append("\n\n");
            newTable.appendCommentSql(sb);
        }

        return sb.length() > startLength;
    }

    /**
     * Finds index according to specified index {@code name}.
     *
     * @param name name of the index to be searched
     *
     * @return found index or null if no such index has been found
     */
    public PgIndex getIndex(final String name) {
        for (PgIndex index : indexes) {
            if (index.getName().equals(name)) {
                return index;
            }
        }

        return null;
    }

    /**
     * Finds trigger according to specified trigger {@code name}.
     *
     * @param name name of the trigger to be searched
     *
     * @return found trigger or null if no such trigger has been found
     */
    @Override
    public PgTrigger getTrigger(final String name) {
        for (PgTrigger trigger : triggers) {
            if (trigger.getName().equals(name)) {
                return trigger;
            }
        }

        return null;
    }

    /**
     * Finds rule according to specified rule {@code name}.
     *
     * @param name name of the rule to be searched
     *
     * @return found rule or null if no such rule has been found
     */
    @Override
    public PgRule getRule(final String name) {
        for (PgRule rule : rules) {
            if (rule.getName().equals(name)) {
                return rule;
            }
        }

        return null;
    }

    /**
     * Getter for {@link #indexes}. The list cannot be modified.
     *
     * @return {@link #indexes}
     */
    public List<PgIndex> getIndexes() {
        return Collections.unmodifiableList(indexes);
    }

    @Override
    public Map <String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    @Override
    public void addOption(String option, String value) {
        options.put(option, value);
        resetHash();
    }

    public void addInherits(final String schemaName, final String tableName) {
        inherits.add(new Inherits(schemaName, tableName));
        resetHash();
    }

    public boolean getHasOids() {
        return hasOids;
    }

    public void setHasOids(final boolean hasOids) {
        this.hasOids = hasOids;
        resetHash();
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean isLogged) {
        this.isLogged = isLogged;
        resetHash();
    }

    public boolean isRowSecurity() {
        return isRowSecurity;
    }

    public void setRowSecurity(final boolean isRowSecurity) {
        this.isRowSecurity = isRowSecurity;
        resetHash();
    }

    public boolean isForceSecurity() {
        return isForceSecurity;
    }

    public void setForceSecurity(final boolean isForceSecurity) {
        this.isForceSecurity = isForceSecurity;
        resetHash();
    }

    public String getOfType() {
        return ofType;
    }

    public void setOfType(String ofType) {
        this.ofType = ofType;
        resetHash();
    }

    /**
     * Getter for {@link #inherits}.
     *
     * @return {@link #inherits}
     */
    public List<Inherits> getInherits() {
        return Collections.unmodifiableList(inherits);
    }

    /**
     * Getter for {@link #triggers}. The list cannot be modified.
     *
     * @return {@link #triggers}
     */
    @Override
    public List<PgTrigger> getTriggers() {
        return Collections.unmodifiableList(triggers);
    }

    /**
     * Getter for {@link #rules}. The list cannot be modified.
     *
     * @return {@link #rules}
     */
    @Override
    public List<PgRule> getRules() {
        return Collections.unmodifiableList(rules);
    }

    public String getTablespace() {
        return tablespace;
    }

    public void setTablespace(final String tablespace) {
        this.tablespace = tablespace;
        resetHash();
    }

    public boolean isForeign() {
        return serverName != null;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(final String serverName) {
        this.serverName = serverName;
        resetHash();
    }

    public void addColumn(final PgColumn column) {
        assertUnique(this::getColumn, column);
        columns.add(column);
        column.setParent(this);
        resetHash();
    }

    public void addColumnOfType(final PgColumn column) {
        assertUnique(this::getColumnOfType, column);
        columnsOfType.add(column);
        column.setParent(this);
        resetHash();
    }

    public void addConstraint(final PgConstraint constraint) {
        assertUnique(this::getConstraint, constraint);
        constraints.add(constraint);
        constraint.setParent(this);
        resetHash();
    }

    public void addIndex(final PgIndex index) {
        assertUnique(this::getIndex, index);
        indexes.add(index);
        index.setParent(this);
        resetHash();
    }

    @Override
    public void addTrigger(final PgTrigger trigger) {
        assertUnique(this::getTrigger, trigger);
        triggers.add(trigger);
        trigger.setParent(this);
        resetHash();
    }

    @Override
    public void addRule(final PgRule rule) {
        assertUnique(this::getRule, rule);
        rules.add(rule);
        rule.setParent(this);
        resetHash();
    }

    public boolean containsColumn(final String name) {
        return getColumn(name) != null;
    }

    public boolean containsColumnOfType(final String name) {
        return getColumnOfType(name) != null;
    }

    public boolean containsConstraint(final String name) {
        return getConstraint(name) != null;
    }

    public boolean containsIndex(final String name) {
        return getIndex(name) != null;
    }

    public boolean containsTrigger(String name) {
        return getTrigger(name) != null;
    }

    public boolean containsRule(String name) {
        return getRule(name) != null;
    }

    /**
     * Returns list of columns that have statistics defined.
     */
    private List<PgColumn> getColumnsWithStatistics() {
        final List<PgColumn> list = new ArrayList<>();

        for (PgColumn column : columns) {
            if (column.getStatistics() != null) {
                list.add(column);
            }
        }

        return list;
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if(this == obj) {
            eq = true;
        } else if(obj instanceof PgTable) {
            PgTable table = (PgTable) obj;

            eq = Objects.equals(name, table.getName())
                    && Objects.equals(tablespace, table.getTablespace())
                    && Objects.equals(serverName, table.getServerName())
                    && hasOids == table.getHasOids()
                    && isLogged == table.isLogged()
                    && isRowSecurity == table.isRowSecurity()
                    && isForceSecurity == table.isForceSecurity()
                    && inherits.equals(table.inherits)
                    && columns.equals(table.columns)
                    && grants.equals(table.grants)
                    && revokes.equals(table.revokes)
                    && Objects.equals(owner, table.getOwner())
                    && Objects.equals(comment, table.getComment())
                    && Objects.equals(options, table.getOptions())
                    && columnsOfType.equals(table.columnsOfType)
                    && Objects.equals(ofType, table.getOfType());
        }

        return eq;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;
        if(this == obj) {
            eq = true;
        } else if(obj instanceof PgTable) {
            PgTable table = (PgTable) obj;
            eq = super.equals(obj)
                    && PgDiffUtils.setlikeEquals(constraints, table.constraints)
                    && PgDiffUtils.setlikeEquals(indexes, table.indexes)
                    && PgDiffUtils.setlikeEquals(triggers, table.triggers)
                    && PgDiffUtils.setlikeEquals(rules, table.rules);
        }
        return eq;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int computeHash() {
        final int itrue = 1231;
        final int ifalse = 1237;
        final int prime = 31;
        int result = 1;
        result = prime * result + ((grants == null) ? 0 : grants.hashCode());
        result = prime * result + ((revokes == null) ? 0 : revokes.hashCode());
        result = prime * result + ((columns == null) ? 0 : columns.hashCode());
        result = prime * result + PgDiffUtils.setlikeHashcode(constraints);
        result = prime * result + PgDiffUtils.setlikeHashcode(indexes);
        result = prime * result + ((inherits == null) ? 0 : inherits.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((tablespace == null) ? 0 : tablespace.hashCode());
        result = prime * result + ((serverName == null) ? 0 : serverName.hashCode());
        result = prime * result + PgDiffUtils.setlikeHashcode(triggers);
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + PgDiffUtils.setlikeHashcode(rules);
        result = prime * result + ((options == null) ? 0 : options.hashCode());
        result = prime * result + (hasOids ? itrue : ifalse);
        result = prime * result + (isLogged ? itrue : ifalse);
        result = prime * result + (isRowSecurity ? itrue : ifalse);
        result = prime * result + (isForceSecurity ? itrue : ifalse);
        result = prime * result + ((columnsOfType == null) ? 0 : columnsOfType.hashCode());
        result = prime * result + ((ofType == null) ? 0 : ofType.hashCode());
        return result;
    }

    @Override
    public PgTable shallowCopy() {
        PgTable tableDst = new PgTable(getName(), getRawStatement());
        tableDst.setOfType(getOfType());
        tableDst.setTablespace(getTablespace());
        tableDst.setServerName(getServerName());
        tableDst.setHasOids(getHasOids());
        tableDst.setLogged(isLogged());
        tableDst.setRowSecurity(isRowSecurity());
        tableDst.setForceSecurity(isForceSecurity());
        tableDst.options.putAll(options);
        tableDst.inherits.addAll(inherits);
        for(PgColumn colSrc : columns) {
            tableDst.addColumn(colSrc.deepCopy());
        }
        for(PgColumn colSrc : columnsOfType) {
            tableDst.addColumnOfType(colSrc.deepCopy());
        }
        tableDst.setComment(getComment());
        for (PgPrivilege priv : revokes) {
            tableDst.addPrivilege(priv.deepCopy());
        }
        for (PgPrivilege priv : grants) {
            tableDst.addPrivilege(priv.deepCopy());
        }
        tableDst.setOwner(getOwner());
        tableDst.deps.addAll(deps);
        return tableDst;
    }

    @Override
    public PgTable deepCopy() {
        PgTable copy = shallowCopy();

        for(PgConstraint constraint : constraints) {
            copy.addConstraint(constraint.deepCopy());
        }
        for(PgIndex index : indexes) {
            copy.addIndex(index.deepCopy());
        }
        for(PgTrigger trigger : triggers) {
            copy.addTrigger(trigger.deepCopy());
        }
        for(PgRule rule : rules) {
            copy.addRule(rule.deepCopy());
        }
        return copy;
    }

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)this.getParent();
    }

    private void writeOptions(PgColumn column, StringBuilder sbOption, boolean isForeign) {
        Map<String, String> options = isForeign ? column.getForeignOptions() : column.getOptions();
        if(!options.isEmpty()){
            sbOption.append(getAlterTable(true, false))
            .append(" ALTER COLUMN ")
            .append(PgDiffUtils.getQuotedName(column.name))
            .append(isForeign ? " OPTIONS (" : " SET (");
            for(Entry<String, String> option : options.entrySet()){
                sbOption.append(option.getKey());
                if (!option.getValue().isEmpty()) {
                    sbOption.append(isForeign ? ' ' : '=').append(option.getValue());
                }
                sbOption.append(", ");
            }
            sbOption.setLength(sbOption.length() - 2);
            sbOption.append(");");
        }
    }

    public void compareForeignOptions (Map <String, String> oldForeignOptions,
            Map <String, String> newForeignOptions, StringBuilder sb){
        if (!oldForeignOptions.isEmpty() || !newForeignOptions.isEmpty()) {
            oldForeignOptions.forEach((key, value) -> {
                if (newForeignOptions.containsKey(key)) {
                    String newValue =  newForeignOptions.get(key);
                    if (!Objects.equals(value, newValue)) {
                        sb.append(MessageFormat.format(ALTER_FOREIGN_OPTION,
                                getAlterTable(true, false), "SET", key, newValue));
                    }
                } else {
                    sb.append(MessageFormat.format(ALTER_FOREIGN_OPTION,
                            getAlterTable(true, false), "DROP", key, ""));
                }
            });

            newForeignOptions.forEach((key, value) -> {
                if (!oldForeignOptions.containsKey(key)) {
                    sb.append(MessageFormat.format(ALTER_FOREIGN_OPTION,
                            getAlterTable(true, false), "ADD", key, value));
                }
            });
        }
    }

    public static class Inherits {
        private final String key;
        private final String value;

        public String getKey() {
            return key;
        }
        public String getValue() {
            return value;
        }
        public Inherits(String key, String value) {
            super();
            this.key = key;
            this.value = value;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((key == null) ? 0 : key.hashCode());
            result = prime * result + ((value == null) ? 0 : value.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Inherits) {
                Inherits other = (Inherits) obj;
                return Objects.equals(key, other.key)
                        && Objects.equals(value, other.value);
            }
            return false;
        }
    }
}
