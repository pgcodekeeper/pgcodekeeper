/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.model.graph;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import ru.taximaxim.codekeeper.core.ChDiffUtils;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.NotAllowedObjectException;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractSequence;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.IForeignTable;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.ms.MsColumn;
import ru.taximaxim.codekeeper.core.schema.ms.MsView;
import ru.taximaxim.codekeeper.core.schema.pg.PartitionPgTable;
import ru.taximaxim.codekeeper.core.schema.pg.PgColumn;
import ru.taximaxim.codekeeper.core.schema.pg.PgSequence;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public class ActionsToScriptConverter {

    private static final String REFRESH_MODULE = "EXEC sys.sp_refreshsqlmodule {0}";

    private static final String DROP_COMMENT = "-- DEPCY: This {0} {1} depends on the {2}: {3}";
    private static final String CREATE_COMMENT = "-- DEPCY: This {0} {1} is a dependency of {2}: {3}";
    private static final String HIDDEN_OBJECT = "-- HIDDEN: Object {0} of type {1} (action: {2}, reason: {3})";

    private static final String RENAME_PG_OBJECT = "ALTER {0} {1} RENAME TO {2}";
    private static final String RENAME_MS_OBJECT = "EXEC sp_rename {0}, {1}";
    private static final String RENAME_CH_OBJECT = "RENAME {0} {1} TO {2};";

    private final SQLScript script;
    private final Set<ActionContainer> actions;
    private final Set<PgStatement> toRefresh;
    private final PgDiffArguments arguments;
    private final AbstractDatabase oldDbFull;
    private final AbstractDatabase newDbFull;

    private final Map<ActionContainer, List<ActionContainer>> joinableTableActions = new HashMap<>();
    private final Set<ActionContainer> toSkip = new HashSet<>();
    private final Set<PgStatement> droppedObjects = new HashSet<>();

    /**
     * renamed table qualified names and their temporary (simple) names
     */
    private Map<String, String> tblTmpNames;
    /**
     * old tables q-names (before rename) and their identity columns' names
     */
    private Map<String, List<String>> tblIdentityCols;

    /**
     * map where key - parent table and values - children tables
     */
    private Map<String, List<PartitionPgTable>> partitionTables;

    private List<String> partitionChildren;

    public ActionsToScriptConverter(SQLScript script, Set<ActionContainer> actions,
            PgDiffArguments arguments, AbstractDatabase oldDbFull, AbstractDatabase newDbFull) {
        this(script, actions, Collections.emptySet(), arguments, oldDbFull, newDbFull);
    }

    /**
     * @param toRefresh an ordered set of refreshed statements in reverse order
     */
    public ActionsToScriptConverter(SQLScript script, Set<ActionContainer> actions,
            Set<PgStatement> toRefresh, PgDiffArguments arguments, AbstractDatabase oldDbFull,
            AbstractDatabase newDbFull) {
        this.script = script;
        this.actions = actions;
        this.arguments = arguments;
        this.toRefresh = toRefresh;
        this.oldDbFull = oldDbFull;
        this.newDbFull = newDbFull;
        if (arguments.isDataMovementMode()) {
            tblTmpNames = new HashMap<>();
            tblIdentityCols = new HashMap<>();
            partitionTables = new HashMap<>();
            partitionChildren = new ArrayList<>();
        }
    }

    /**
     * Fills a script with objects based on their dependency order
     *
     * @param selected
     *            list of selected elements
     */
    public void fillScript(List<TreeElement> selected) {
        Set<PgStatement> refreshed = new HashSet<>(toRefresh.size());
        if (arguments.isDataMovementMode()) {
            fillPartitionTables();
        }

        fillJoinableTableActions();
        for (ActionContainer action : actions) {
            if (toSkip.contains(action)) {
                continue;
            }

            PgStatement obj = action.getOldObj();

            if (toRefresh.contains(obj)) {
                if (action.getAction() == StatementActions.CREATE && obj instanceof MsView) {
                    // emit refreshes for views only
                    // refreshes for other objects serve as markers
                    // that allow us to skip unmodified drop+create pairs
                    script.addStatement(MessageFormat.format(REFRESH_MODULE,
                            PgDiffUtils.quoteString(obj.getQualifiedName())));
                    refreshed.add(obj);
                }
            } else if (!hideAction(action, selected)) {
                printAction(action, obj);
            }
        }

        // As a result of discussion with the SQL database developers, it was
        // decided that, in pgCodeKeeper, refresh operations are required only
        // for MsView objects. This is why a filter is used here that only
        // leaves refresh operations for MsView objects.
        //
        // if any refreshes were not emitted as statement replacements
        // add them explicitly in reverse order (the resolver adds them in "drop order")
        PgStatement[] orphanRefreshes = toRefresh.stream()
                .filter(r -> r instanceof MsView && !refreshed.contains(r))
                .toArray(PgStatement[]::new);
        for (int i = orphanRefreshes.length - 1; i >= 0; --i) {
            script.addStatement(MessageFormat.format(REFRESH_MODULE,
                    PgDiffUtils.quoteString(orphanRefreshes[i].getQualifiedName())));
        }
    }

    /**
     * collects joinable table actions
     */
    private void fillJoinableTableActions() {
        List<List<ActionContainer>> changedColumnTables = new ArrayList<>();
        String previousParent = null;
        List<ActionContainer> currentList = null;
        for (ActionContainer action : actions) {
            var oldObj = action.getOldObj();
            if (action.getAction() == StatementActions.ALTER && oldObj instanceof PgColumn oldCol
                    && oldCol.isJoinable((PgColumn) action.getNewObj())) {
                String parent = oldObj.getParent().getQualifiedName();
                if (!parent.equals(previousParent)) {
                    currentList = new ArrayList<>();
                    changedColumnTables.add(currentList);
                    previousParent = parent;
                }

                currentList.add(action);
            } else {
                previousParent = null;
            }
        }

        // filling joinableTableActions map where:
        //   key - first action
        //   value - all joinable actions for table
        for (List<ActionContainer> tableChanges : changedColumnTables) {
            if (tableChanges.size() == 1) {
                continue;
            }
            boolean isFirst = true;
            for (ActionContainer action : tableChanges) {
                if (isFirst) {
                    joinableTableActions.put(action, tableChanges);
                    isFirst = false;
                } else {
                    toSkip.add(action);
                }
            }
        }
    }

    private void printAction(ActionContainer action, PgStatement obj) {
        String depcy = getComment(action, obj);
        switch (action.getAction()) {
        case CREATE:
            if (depcy != null) {
                script.addStatementWithoutSeparator(depcy);
            }

            var oldObj = obj.getTwin(oldDbFull);

            // explicitly deleting a sequence due to a name conflict
            if (arguments.isDataMovementMode() && obj instanceof PgSequence && oldObj != null) {
                addToDropScript(obj, false);
            }

            if (obj.isDropBeforeCreate()) {
                addToDropScript(obj, true);
            }

            addToAddScript(obj);

            if (arguments.isDataMovementMode() && oldObj instanceof AbstractTable oldTable) {
                moveData(oldTable, obj);
            }
            break;
        case DROP:
            if (depcy != null) {
                script.addStatementWithoutSeparator(depcy);
            }
            if (arguments.isDataMovementMode()
                    && DbObjType.TABLE == obj.getStatementType()
                    && !(obj instanceof IForeignTable)
                    && obj.getTwin(newDbFull) != null) {
                addCommandsForRenameTbl((AbstractTable) obj);
            } else {
                addToDropScript(obj, false);
            }
            break;
        case ALTER:
            var joinableActions = joinableTableActions.get(action);
            if (joinableActions != null) {
                getAlterTableScript(joinableActions);
                return;
            }
            SQLScript temp = new SQLScript(action.getNewObj().getDbType());
            ObjectState state = obj.appendAlterSQL(action.getNewObj(), new AtomicBoolean(), temp);

            if (state == ObjectState.ALTER) {
                if (depcy != null) {
                    script.addStatementWithoutSeparator(depcy);
                }
                script.addAllStatements(temp);
            }
            break;
        case NONE:
            throw new IllegalStateException("Not implemented action");
        }
    }

    private void addToAddScript(PgStatement obj) {
        obj.getCreationSQL(script);
    }

    private void addToDropScript(PgStatement obj, boolean isExist) {
        // check "drop before create"
        if (!droppedObjects.add(obj.getTwin(oldDbFull))) {
            return;
        }
        obj.getDropSQL(script, isExist);
    }

    /**
     * get ALTER TABLE script with all joinable changes
     */
    private void getAlterTableScript(List<ActionContainer> actionsList) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (var colAction : actionsList) {
            PgColumn oldNextCol = (PgColumn) colAction.getOldObj();
            PgColumn newNextCol = (PgColumn) colAction.getNewObj();
            oldNextCol.joinAction(sb, newNextCol, i == 1, i == actionsList.size());
            i++;
        }
        script.addStatement(sb);
    }

    private void fillPartitionTables() {
        for (ActionContainer action : actions) {
            PgStatement obj = action.getOldObj();

            if (action.getAction() == StatementActions.CREATE && obj instanceof PartitionPgTable table) {
                partitionTables.computeIfAbsent(table.getParentTable(), tables -> new ArrayList<>()).add(table);
            }
        }

        Iterator<Entry<String, List<PartitionPgTable>>> iterator = partitionTables.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, List<PartitionPgTable>> next = iterator.next();
            String parent = next.getKey();
            for (Entry<String, List<PartitionPgTable>> partitions : partitionTables.entrySet()) {
                List<PartitionPgTable> tables = partitions.getValue();
                if (tables.stream().map(PgStatement::getQualifiedName).anyMatch(el -> el.equals(parent))) {
                    tables.addAll(next.getValue());
                    iterator.remove();
                    break;
                }
            }
        }

        partitionChildren = partitionTables.values().stream()
                .flatMap(List::stream)
                .map(PgStatement::getQualifiedName)
                .toList();
    }

    private void moveData(AbstractTable oldTable, PgStatement newObj) {
        String qname = newObj.getQualifiedName();
        String tempName = tblTmpNames.get(qname);
        if (tempName == null) {
            return;
        }

        List<PartitionPgTable> tables = partitionTables.get(qname);
        if (tables != null) {
            // print create for partition tables
            for (PartitionPgTable table : tables) {
                addToAddScript(table);
            }
        }

        oldTable.appendMoveDataSql(newObj, script, tempName, tblIdentityCols.get(qname));

        if (tables != null) {
            List<PartitionPgTable> list = new ArrayList<>(tables);
            Collections.reverse(list);
            list.forEach(this::printDropTempTable);
        }

        printDropTempTable(oldTable);
    }

    private void printDropTempTable(AbstractTable table) {
        String tblTmpName = tblTmpNames.get(table.getQualifiedName());
        if (tblTmpName != null) {
            UnaryOperator<String> quoter = Utils.getQuoter(arguments.getDbType());
            StringBuilder sb = new StringBuilder();
            sb.append("DROP TABLE ")
            .append(quoter.apply(table.getSchemaName())).append('.').append(quoter.apply(tblTmpName));
            script.addStatement(sb);
        }
    }

    private String getComment(ActionContainer action, PgStatement oldObj) {
        PgStatement objStarter = action.getStarter();
        if (objStarter == null || objStarter == oldObj || objStarter == action.getNewObj()) {
            return null;
        }

        // skip column to parent
        if (objStarter.getStatementType() == DbObjType.COLUMN && objStarter.getParent().equals(oldObj)) {
            return null;
        }

        // skip partition tables in data move mode
        if (arguments.isDataMovementMode() && partitionChildren.contains(oldObj.getQualifiedName())) {
            return null;
        }

        return MessageFormat.format(
                action.getAction() == StatementActions.CREATE ?
                        CREATE_COMMENT : DROP_COMMENT,
                        oldObj.getStatementType(),
                        oldObj.getBareName(),
                        objStarter.getStatementType(),
                        objStarter.getQualifiedName());
    }

    /**
     * @return true if action was hidden, false if it may be executed
     */
    private boolean hideAction(ActionContainer action, List<TreeElement> selected) {
        PgStatement obj = action.getOldObj();
        if (action.getAction() == StatementActions.DROP && !obj.canDrop()) {
            addHiddenObj(action, "object cannot be dropped");
            return true;
        }
        if (arguments.isSelectedOnly() && !isSelectedAction(action, selected)) {
            addHiddenObj(action, "cannot change unselected objects in selected-only mode");
            return true;
        }

        DbObjType type = obj.getStatementType();
        if (type == DbObjType.COLUMN) {
            type = DbObjType.TABLE;
        }
        Collection<DbObjType> allowedTypes = arguments.getAllowedTypes();
        if (!allowedTypes.isEmpty() && !allowedTypes.contains(type)) {
            if (arguments.isStopNotAllowed()) {
                throw new NotAllowedObjectException(action.getOldObj().getQualifiedName()
                        + " (" + type + ") is not an allowed script object. Stopping.");
            }
            addHiddenObj(action, "object type is not in allowed types list");
            return true;
        }

        return false;
    }

    private void addHiddenObj(ActionContainer action, String reason) {
        PgStatement old = action.getOldObj();
        String message = MessageFormat.format(HIDDEN_OBJECT,
                old.getQualifiedName(), old.getStatementType(), action.getAction(), reason);
        script.addStatement(message);
    }

    /**
     * Determines whether an action object has been selected in the diff panel.
     *
     * @param action script action element
     * @param selected collection of selected elements in diff panel
     *
     * @return TRUE if the action object was selected in the diff panel, otherwise FALSE
     */
    private boolean isSelectedAction(ActionContainer action, List<TreeElement> selected) {
        Predicate<PgStatement> isSelectedObj = obj ->
        selected.stream()
        .filter(e -> e.getType().equals(obj.getStatementType()))
        .filter(e -> e.getName().equals(obj.getName()))
        .map(e -> e.getPgStatement(obj.getDatabase()))
        .anyMatch(obj::equals);

        return switch (action.getAction()) {
        case CREATE -> isSelectedObj.test(action.getNewObj());
        case ALTER -> isSelectedObj.test(action.getNewObj()) && isSelectedObj.test(action.getOldObj());
        case DROP -> isSelectedObj.test(action.getOldObj());
        default -> throw new IllegalStateException("Not implemented action");
        };
    }

    /**
     * Adds commands to the script for rename the original table name to a
     * temporary name, given the constraints. Fills the maps {@link #tblTmpNames}
     * and {@link #tblIdentityCols} for use them later (when adding commands to
     * move data from a temporary table to a new table).
     */
    private void addCommandsForRenameTbl(AbstractTable oldTbl) {
        String tmpSuffix = '_' + UUID.randomUUID().toString().replace("-", "");
        String qname = oldTbl.getQualifiedName();

        String tmpTblName = getTempName(oldTbl, tmpSuffix);

        script.addStatement(getRenameCommand(oldTbl, tmpTblName));
        tblTmpNames.put(qname, tmpTblName);

        DatabaseType dbtype = arguments.getDbType();
        List<String> identityCols = new ArrayList<>();
        for (AbstractColumn col : oldTbl.getColumns()) {
            switch (dbtype) {
            case PG:
                PgColumn oldPgCol = (PgColumn) col;
                PgColumn newPgCol = (PgColumn) oldPgCol.getTwin(newDbFull);
                if (newPgCol != null && newPgCol.getSequence() != null) {
                    AbstractSequence seq = oldPgCol.getSequence();
                    if (seq != null) {
                        script.addStatement(getRenameCommand(seq, getTempName(seq, tmpSuffix)));
                    }
                    identityCols.add(oldPgCol.getName());
                }
                break;
            case MS:
                MsColumn msCol = (MsColumn) col;
                if (msCol.isIdentity()) {
                    identityCols.add(msCol.getName());
                }
                if (msCol.getDefaultName() != null) {
                    script.addStatement("ALTER TABLE "
                            + MsDiffUtils.quoteName(oldTbl.getSchemaName()) + '.'
                            + MsDiffUtils.quoteName(tmpTblName) + " DROP CONSTRAINT "
                            + MsDiffUtils.quoteName(msCol.getDefaultName()));
                }
                break;
            case CH:
                break;
            default:
                throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbtype);
            }
        }

        if (!identityCols.isEmpty()) {
            tblIdentityCols.put(qname, identityCols);
        }
    }

    private String getTempName(PgStatement st, String tmpSuffix) {
        String name = st.getName();
        if (name.length() > 30) {
            return name.substring(0, 30) + tmpSuffix;
        }

        return name + tmpSuffix;
    }

    /**
     * Returns sql command to rename the given object.
     *
     * @param st object for rename
     * @param newName the new name for given object
     * @return sql command to rename the given object
     */
    private String getRenameCommand(PgStatement st, String newName) {
        return switch (arguments.getDbType()) {
        case PG -> MessageFormat.format(RENAME_PG_OBJECT,
                st.getStatementType(), st.getQualifiedName(), PgDiffUtils.getQuotedName(newName));
        case MS -> MessageFormat.format(RENAME_MS_OBJECT,
                PgDiffUtils.quoteString(st.getQualifiedName()), PgDiffUtils.quoteString(newName));
        case CH -> MessageFormat.format(RENAME_CH_OBJECT,
                st.getStatementType(), st.getQualifiedName(), ChDiffUtils.getQuotedName(newName));
        default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + arguments.getDbType());
        };
    }
}
