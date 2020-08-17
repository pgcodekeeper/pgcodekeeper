package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.MsDiffUtils;
import cz.startnet.utils.pgdiff.NotAllowedObjectException;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffScript;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.MsColumn;
import cz.startnet.utils.pgdiff.schema.MsTable;
import cz.startnet.utils.pgdiff.schema.MsView;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;

public class ActionsToScriptConverter {

    private static final String REFRESH_MODULE = "EXEC sys.sp_refreshsqlmodule {0} \nGO";

    private static final String DROP_COMMENT = "-- DEPCY: This {0} depends on the {1}: {2}";
    private static final String CREATE_COMMENT = "-- DEPCY: This {0} is a dependency of {1}: {2}";
    private static final String HIDDEN_OBJECT = "-- HIDDEN: Object {0} of type {1}";

    private static final String RENAME_PG_OBJECT = "ALTER {0} {1} RENAME TO {2};";
    private static final String RENAME_MS_OBJECT = "EXEC sp_rename {0}, {1}\nGO";

    private final Set<ActionContainer> actions;
    private final Set<PgSequence> sequencesOwnedBy = new LinkedHashSet<>();
    private final Set<PgStatement> toRefresh;
    private final PgDiffArguments arguments;

    public ActionsToScriptConverter(Set<ActionContainer> actions, PgDiffArguments arguments) {
        this(actions, Collections.emptySet(), arguments);
    }

    /**
     * @param toRefresh an ordered set of refreshed statements in reverse order
     */
    public ActionsToScriptConverter(Set<ActionContainer> actions, Set<PgStatement> toRefresh,
            PgDiffArguments arguments) {
        this.actions = actions;
        this.arguments = arguments;
        this.toRefresh = toRefresh;
    }

    /**
     * Заполняет скрипт объектами с учетом их порядка по зависимостям
     * @param script скрипт для печати
     * @param selected коллекция выбранных элементов в панели сравнения
     */
    public void fillScript(PgDiffScript script, List<TreeElement> selected) {
        // for storing pairs of temporary table name as key and table object
        // with original name as key value
        Map<String, AbstractTable> tmpTblsMapping = null;
        // for storing pairs of original table name as a key and a set of identity
        // column names of that table as a value
        Map<String, Set<String>> tblIdentityColsMapping = null;
        if (arguments.isDataMovementMode()) {
            tmpTblsMapping = new HashMap<>();
            tblIdentityColsMapping = new HashMap<>();
        }

        Collection<DbObjType> allowedTypes = arguments.getAllowedTypes();
        Set<PgStatement> refreshed = new HashSet<>(toRefresh.size());
        for (ActionContainer action : actions) {
            DbObjType type = action.getOldObj().getStatementType();
            if (type == DbObjType.COLUMN) {
                type = DbObjType.TABLE;
            }

            if (!isAllowedAction(action, type, allowedTypes, selected)) {
                addHiddenObj(script, action);
                continue;
            }

            processSequence(action);
            PgStatement oldObj = action.getOldObj();
            String depcy = getComment(action, oldObj);
            switch (action.getAction()) {
            case CREATE:
                if (toRefresh.contains(oldObj)) {
                    // emit refreshes for views only
                    // refreshes for other objects serve as markers
                    // that allow us to skip unmodified drop+create pairs
                    if (oldObj instanceof MsView) {
                        script.addStatement(MessageFormat.format(REFRESH_MODULE,
                                PgDiffUtils.quoteString(oldObj.getQualifiedName())));
                    }
                    refreshed.add(oldObj);
                } else {
                    if (depcy != null) {
                        script.addStatement(depcy);
                    }
                    script.addCreate(oldObj, null, oldObj.getCreationSQL(), true);
                }
                break;
            case DROP:
                if (!toRefresh.contains(oldObj) && oldObj.canDrop()) {
                    if (depcy != null) {
                        script.addStatement(depcy);
                    }
                    if (arguments.isDataMovementMode()
                            && DbObjType.TABLE == oldObj.getStatementType()) {
                        addCommandsForRenameTbl(script, oldObj, tmpTblsMapping,
                                tblIdentityColsMapping);
                    } else {
                        script.addDrop(oldObj, null, oldObj.getDropSQL());
                    }
                }
                break;
            case ALTER:
                StringBuilder sb = new StringBuilder();
                oldObj.appendAlterSQL(action.getNewObj(), sb,
                        new AtomicBoolean());
                if (sb.length() > 0) {
                    if (depcy != null) {
                        script.addStatement(depcy);
                    }
                    script.addStatement(sb.toString());
                }
                break;
            default:
                throw new IllegalStateException("Not implemented action");
            }
        }

        for (PgSequence sequence : sequencesOwnedBy) {
            String ownedBy = sequence.getOwnedBySQL();
            if (!ownedBy.isEmpty()) {
                script.addStatement(ownedBy);
            }
        }

        // if any refreshes were not emitted as statement replacements
        // add them explicitly in reverse order (the resolver adds them in "drop order")
        PgStatement[] orphanRefreshes = toRefresh.stream()
                .filter(r -> r instanceof MsView && !refreshed.contains(r))
                .toArray(PgStatement[]::new);
        for (int i = orphanRefreshes.length - 1; i >= 0; --i) {
            script.addStatement(MessageFormat.format(REFRESH_MODULE,
                    PgDiffUtils.quoteString(orphanRefreshes[i].getQualifiedName())));
        }

        if (arguments.isDataMovementMode()) {
            addCommandsForMoveData(script, tmpTblsMapping, tblIdentityColsMapping);
        }
    }

    private boolean isAllowedAction(ActionContainer action, DbObjType type,
            Collection<DbObjType> allowedTypes, List<TreeElement> selected) {
        if (arguments.isSelectedOnly() && !isSelectedAction(action, selected)) {
            return false;
        }

        if (!allowedTypes.isEmpty() && !allowedTypes.contains(type)) {
            if (arguments.isStopNotAllowed()) {
                throw new NotAllowedObjectException(action.getOldObj().getQualifiedName()
                        + " (" + type + ") is not an allowed script object. Stopping.");
            }

            return false;
        }

        return true;
    }

    private void addHiddenObj(PgDiffScript script, ActionContainer action) {
        PgStatement old = action.getOldObj();
        StringBuilder sb = new StringBuilder(MessageFormat.format(HIDDEN_OBJECT,
                old.getQualifiedName(), old.getStatementType()));
        if (arguments.isSelectedOnly()) {
            sb.append(" (action ").append(action.getAction()).append(")");
        }
        script.addStatement(sb.toString());
    }

    private String getComment(ActionContainer action, PgStatement oldObj) {
        PgStatement objStarter = action.getStarter();
        if (objStarter == null || objStarter == oldObj || objStarter == action.getNewObj()) {
            return null;
        }

        // skip column to parent
        if (objStarter.getStatementType() == DbObjType.COLUMN
                && objStarter.getParent().equals(oldObj)) {
            return null;
        }

        return MessageFormat.format(
                action.getAction() == StatementActions.CREATE ?
                        CREATE_COMMENT : DROP_COMMENT,
                        oldObj.getStatementType(),
                        objStarter.getStatementType(),
                        objStarter.getQualifiedName());
    }

    private void processSequence(ActionContainer action) {
        if (action.getOldObj() instanceof PgSequence) {
            PgSequence oldSeq = (PgSequence) action.getOldObj();
            PgSequence newSeq = (PgSequence) action.getNewObj();
            if (newSeq.getOwnedBy() != null
                    && action.getAction() == StatementActions.CREATE
                    || (action.getAction() == StatementActions.ALTER &&
                    !Objects.equals(newSeq.getOwnedBy(), oldSeq.getOwnedBy()))) {
                sequencesOwnedBy.add(newSeq);
            }
        }
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

        switch (action.getAction()) {
        case CREATE:
            return isSelectedObj.test(action.getNewObj());
        case ALTER:
            return isSelectedObj.test(action.getNewObj())
                    && isSelectedObj.test(action.getOldObj());
        case DROP:
            return isSelectedObj.test(action.getOldObj());
        default:
            throw new IllegalStateException("Not implemented action");
        }
    }

    /**
     * Adds commands to the script for rename the original table name to a
     * temporary name, given the constraints. Fills the maps 'tmpTblsMapping'
     * and 'tblIdentityColsMapping' for use them later (when adding commands to
     * move data from a temporary table to a new table).
     *
     * @param script script represented as a list of SQL statements
     * @param oldObj original table object
     * @param tmpTblsMapping map for placing pairs of temporary table name as
     * key and table object with original name as key value
     * @param tblIdentityColsMapping map for placing pairs of original table name
     * as a key and a set of identity column names of that table as a value
     */
    private void addCommandsForRenameTbl(PgDiffScript script, PgStatement oldObj,
            Map<String, AbstractTable> tmpTblsMapping,
            Map<String, Set<String>> tblIdentityColsMapping) {
        String tmpSuffix = '_' + UUID.randomUUID().toString()
                .replace("-", "");
        AbstractTable oldTbl = (AbstractTable) oldObj;
        String tmpTblName = oldTbl.getName() + tmpSuffix;

        script.addStatement(getRenameCommand(oldTbl, tmpTblName));
        tmpTblsMapping.put(tmpTblName, oldTbl);

        if (arguments.isMsSql()) {
            for (MsColumn msCol : PgDiffUtils.sIter(((MsTable) oldTbl)
                    .getColumns().stream().map(col -> (MsColumn) col))) {
                if (msCol.isIdentity()) {
                    tblIdentityColsMapping.computeIfAbsent(
                            oldTbl.getQualifiedName(),
                            k -> new LinkedHashSet<>()).add(msCol.getName());
                }
                if (msCol.getDefaultName() != null) {
                    script.addStatement("ALTER TABLE "
                            + MsDiffUtils.quoteName(oldTbl.getSchemaName()) + '.'
                            + MsDiffUtils.quoteName(tmpTblName) + " DROP CONSTRAINT "
                            + MsDiffUtils.quoteName(msCol.getDefaultName()) + "\nGO");
                }
            }
        } else {
            for (PgColumn pgCol : PgDiffUtils.sIter(oldTbl.getColumns()
                    .stream().map(col -> (PgColumn) col)
                    .filter(pgCol -> pgCol.getSequence() != null))) {
                script.addStatement(getRenameCommand(pgCol.getSequence(),
                        pgCol.getSequence().getName() + tmpSuffix));
                tblIdentityColsMapping.computeIfAbsent(
                        oldTbl.getQualifiedName(),
                        k -> new LinkedHashSet<>()).add(pgCol.getName());
            }
        }
    }

    /**
     * Returns sql command to rename the given object.
     *
     * @param st object for rename
     * @param newName the new name for given object
     * @return sql command to rename the given object
     */
    private String getRenameCommand(PgStatement st, String newName) {
        return arguments.isMsSql() ?
                MessageFormat.format(RENAME_MS_OBJECT,
                        PgDiffUtils.quoteString(st.getQualifiedName()),
                        PgDiffUtils.quoteString(newName))
                : MessageFormat.format(RENAME_PG_OBJECT, st.getStatementType(),
                        st.getQualifiedName(), newName);
    }

    /**
     * Adds commands to the script for move data from a temporary table
     * to a new table, given the identity columns, and a command to delete
     * the temporary table.
     *
     * @param script script represented as a list of SQL statements
     * @param tmpTblsMapping the map containing the temporary table name as a
     * key and a table object with the original name as the key value
     * @param tblIdentityColsMapping the map that contains the original table
     * name as a key and a set of identity column names of that table as a value
     */
    private void addCommandsForMoveData(PgDiffScript script,
            Map<String, AbstractTable> tmpTblsMapping,
            Map<String, Set<String>> tblIdentityColsMapping) {
        for (Entry<String, AbstractTable> tmpTblMapping : tmpTblsMapping.entrySet()) {
            AbstractTable oldTbl = tmpTblMapping.getValue();
            String oldTblQName = oldTbl.getQualifiedName();
            String tmpTblQName = arguments.isMsSql() ? String.join(".",
                    MsDiffUtils.quoteName(oldTbl.getSchemaName()),
                    MsDiffUtils.quoteName(tmpTblMapping.getKey()))
                    : String.join(".", oldTbl.getSchemaName(), tmpTblMapping.getKey());
            String cols = getColsForMovingData(oldTbl);

            StringBuilder sb = new StringBuilder();

            if (arguments.isMsSql()
                    && tblIdentityColsMapping.containsKey(oldTblQName)) {
                // There can only be one IDENTITY column per table in MSSQL.
                sb.append("SET IDENTITY_INSERT ").append(oldTblQName)
                .append(" ON\nGO\n\n");
            }

            sb.append("INSERT INTO ").append(oldTblQName).append('(')
            .append(cols).append(") SELECT ").append(cols).append(" FROM ")
            .append(tmpTblQName).append(arguments.isMsSql() ? "\nGO" : ';');

            if (arguments.isMsSql()
                    && tblIdentityColsMapping.containsKey(oldTblQName)) {
                // There can only be one IDENTITY column per table in MSSQL.
                sb.append("\n\nSET IDENTITY_INSERT ").append(oldTblQName)
                .append(" OFF\nGO");
            }

            sb.append("\n\nDROP TABLE ").append(tmpTblQName)
            .append(arguments.isMsSql() ? "\nGO" : ';');

            if (!arguments.isMsSql()) {
                Set<String> identityCols = tblIdentityColsMapping.get(oldTblQName);
                if (identityCols != null) {
                    for (String colName : identityCols) {
                        String restartVarName = oldTbl.getSchemaName() + '_'
                                + oldTbl.getName() + '_' + colName + "_restart_value";
                        sb.append("\n\nDO $$ DECLARE ").append(restartVarName)
                        .append(" integer = (SELECT MAX(").append(colName)
                        .append(")+1 FROM ").append(oldTblQName)
                        .append(");\nBEGIN\n\texecute 'ALTER TABLE ")
                        .append(oldTblQName).append(" ALTER COLUMN ").append(colName)
                        .append(" RESTART WITH ' || ").append(restartVarName)
                        .append(" || ';';\nEND\n$$;");
                    }
                }
            }

            script.addStatement(sb.toString());
        }
    }

    /**
     * Returns the names of the columns from which data will be moved to another
     * table, excluding calculated columns.
     */
    private String getColsForMovingData(AbstractTable tbl) {
        Stream<? extends AbstractColumn> cols = tbl.getColumns().stream();
        if (arguments.isMsSql()) {
            cols = cols.map(col -> (MsColumn) col)
                    .filter(msCol -> msCol.getExpression() == null);
        } else {
            cols = cols.map(col -> (PgColumn) col)
                    .filter(pgCol -> !pgCol.isGenerated());
        }
        return cols.map(AbstractColumn::getName).collect(Collectors.joining(", "));
    }
}
