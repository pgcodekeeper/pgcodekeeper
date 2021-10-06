package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
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
import cz.startnet.utils.pgdiff.schema.MsView;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
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

    private final PgDiffScript script;
    private final Set<ActionContainer> actions;
    private final Set<PgStatement> toRefresh;
    private final PgDiffArguments arguments;
    private final PgDatabase oldDbFull;
    private final PgDatabase newDbFull;

    private final Set<PgSequence> sequencesOwnedBy = new LinkedHashSet<>();
    /**
     * renamed table qualified names and their temporary (simple) names
     */
    private Map<String, String> tblTmpNames;
    /**
     * old tables q-names (before rename) and their identity columns' names
     */
    private Map<String, List<String>> tblIdentityCols;

    public ActionsToScriptConverter(PgDiffScript script, Set<ActionContainer> actions,
            PgDiffArguments arguments, PgDatabase oldDbFull, PgDatabase newDbFull) {
        this(script, actions, Collections.emptySet(), arguments, oldDbFull, newDbFull);
    }

    /**
     * @param toRefresh an ordered set of refreshed statements in reverse order
     */
    public ActionsToScriptConverter(PgDiffScript script, Set<ActionContainer> actions,
            Set<PgStatement> toRefresh, PgDiffArguments arguments, PgDatabase oldDbFull, PgDatabase newDbFull) {
        this.script = script;
        this.actions = actions;
        this.arguments = arguments;
        this.toRefresh = toRefresh;
        this.oldDbFull = oldDbFull;
        this.newDbFull = newDbFull;
        if (arguments.isDataMovementMode()) {
            tblTmpNames = new HashMap<>();
            tblIdentityCols = new HashMap<>();
        }
    }

    /**
     * Заполняет скрипт объектами с учетом их порядка по зависимостям
     * @param script скрипт для печати
     * @param selected коллекция выбранных элементов в панели сравнения
     */
    public void fillScript(List<TreeElement> selected) {
        Collection<DbObjType> allowedTypes = arguments.getAllowedTypes();
        Set<PgStatement> refreshed = new HashSet<>(toRefresh.size());
        for (ActionContainer action : actions) {
            DbObjType type = action.getOldObj().getStatementType();
            if (type == DbObjType.COLUMN) {
                type = DbObjType.TABLE;
            }

            if (!isAllowedAction(action, type, allowedTypes, selected)) {
                addHiddenObj(action);
                continue;
            }

            processSequence(action);
            PgStatement obj = action.getOldObj();
            String depcy = getComment(action, obj);
            switch (action.getAction()) {
            case CREATE:
                if (toRefresh.contains(obj)) {
                    // emit refreshes for views only
                    // refreshes for other objects serve as markers
                    // that allow us to skip unmodified drop+create pairs
                    if (obj instanceof MsView) {
                        script.addStatement(MessageFormat.format(REFRESH_MODULE,
                                PgDiffUtils.quoteString(obj.getQualifiedName())));
                    }
                    refreshed.add(obj);
                } else {
                    if (depcy != null) {
                        script.addStatement(depcy);
                    }
                    script.addCreate(obj, null, obj.getFormattedCreationSQL(), true);

                    if (arguments.isDataMovementMode()
                            && DbObjType.TABLE == obj.getStatementType()
                            && obj.getTwin(oldDbFull) != null) {
                        addCommandsForMoveData((AbstractTable) obj);
                    }
                }
                break;
            case DROP:
                if (!toRefresh.contains(obj) && obj.canDrop()) {
                    if (depcy != null) {
                        script.addStatement(depcy);
                    }
                    if (arguments.isDataMovementMode()
                            && DbObjType.TABLE == obj.getStatementType()
                            && obj.getTwin(newDbFull) != null) {
                        addCommandsForRenameTbl((AbstractTable) obj);
                    } else {
                        script.addDrop(obj, null, obj.getDropSQL());
                    }
                }
                break;
            case ALTER:
                StringBuilder sb = new StringBuilder();
                obj.appendAlterSQL(action.getNewObj(), sb,
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

    private void addHiddenObj(ActionContainer action) {
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
     * temporary name, given the constraints. Fills the maps {@link #tblTmpNames}
     * and {@link #tblIdentityCols} for use them later (when adding commands to
     * move data from a temporary table to a new table).
     */
    private void addCommandsForRenameTbl(AbstractTable oldTbl) {
        String tmpSuffix = '_' + UUID.randomUUID().toString().replace("-", "");
        String qname = oldTbl.getQualifiedName();
        String tmpTblName = oldTbl.getName() + tmpSuffix;

        script.addStatement(getRenameCommand(oldTbl, tmpTblName));
        tblTmpNames.put(qname, tmpTblName);

        for (AbstractColumn col : oldTbl.getColumns()) {
            if (arguments.isMsSql()) {
                MsColumn msCol = (MsColumn) col;
                if (msCol.isIdentity()) {
                    tblIdentityCols.computeIfAbsent(qname, k -> new ArrayList<>())
                    .add(msCol.getName());
                }
                if (msCol.getDefaultName() != null) {
                    script.addStatement("ALTER TABLE "
                            + MsDiffUtils.quoteName(oldTbl.getSchemaName()) + '.'
                            + MsDiffUtils.quoteName(tmpTblName) + " DROP CONSTRAINT "
                            + MsDiffUtils.quoteName(msCol.getDefaultName())
                            + PgStatement.GO);
                }
            } else {
                PgColumn pgCol = (PgColumn) col;
                if (pgCol.getSequence() != null) {
                    script.addStatement(getRenameCommand(pgCol.getSequence(),
                            pgCol.getSequence().getName() + tmpSuffix));
                    tblIdentityCols.computeIfAbsent(qname, k -> new ArrayList<>())
                    .add(pgCol.getName());
                }
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
                        st.getQualifiedName(), PgDiffUtils.getQuotedName(newName));
    }

    /**
     * Adds commands to the script for move data from the temporary table
     * to the new table, given the identity columns, and a command to delete
     * the temporary table.
     */
    private void addCommandsForMoveData(AbstractTable newTbl) {
        AbstractTable oldTbl = (AbstractTable) newTbl.getTwin(oldDbFull);
        String tblQName = newTbl.getQualifiedName();
        String tblTmpBareName = tblTmpNames.get(tblQName);

        if (tblTmpBareName == null) {
            return;
        }

        Function<String, String> quoter = arguments.isMsSql() ?
                MsDiffUtils::quoteName : PgDiffUtils::getQuotedName;
        String tblTmpQName = quoter.apply(oldTbl.getSchemaName()) + '.'
                + quoter.apply(tblTmpBareName);

        List<String> colsForMovingData = getColsForMovingData(newTbl);
        List<String> identityCols = tblIdentityCols.get(tblQName);
        List<String> identityColsForMovingData = identityCols == null ? Collections.emptyList()
                : identityCols.stream().filter(colsForMovingData::contains)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        if (arguments.isMsSql() && !identityColsForMovingData.isEmpty()) {
            // There can only be one IDENTITY column per table in MSSQL.
            sb.append("SET IDENTITY_INSERT ").append(tblQName)
            .append(" ON").append(PgStatement.GO).append("\n\n");
        }

        String cols = colsForMovingData.stream()
                .map(quoter)
                .collect(Collectors.joining(", "));
        sb.append("INSERT INTO ").append(tblQName).append('(')
        .append(cols).append(") SELECT ").append(cols).append(" FROM ")
        .append(tblTmpQName).append(arguments.isMsSql() ? PgStatement.GO : ";");

        if (arguments.isMsSql() && !identityColsForMovingData.isEmpty()) {
            // There can only be one IDENTITY column per table in MSSQL.
            sb.append("\n\nSET IDENTITY_INSERT ").append(tblQName)
            .append(" OFF").append(PgStatement.GO);
        }

        if (!identityColsForMovingData.isEmpty()) {
            if (arguments.isMsSql()) {
                // There can only be one IDENTITY column per table in MSSQL.
                // DECLARE'd var is only visible within its batch
                // so we shouldn't need unique names for them here
                // use the largest numeric type to fit any possible identity value
                sb.append("\n\nDECLARE @restart_var numeric(38,0) = (SELECT IDENT_CURRENT (")
                .append(PgDiffUtils.quoteString(tblTmpQName))
                .append("));\nDBCC CHECKIDENT (")
                .append(PgDiffUtils.quoteString(tblQName))
                .append(", RESEED, @restart_var);")
                .append(PgStatement.GO);
            } else {
                for (String colName : identityColsForMovingData) {
                    String restartWith = " ALTER TABLE " + tblQName + " ALTER COLUMN "
                            + PgDiffUtils.getQuotedName(colName)
                            + " RESTART WITH ";
                    restartWith = PgDiffUtils.quoteStringDollar(restartWith)
                            + " || restart_var || ';'";
                    String doBody = "\nDECLARE restart_var bigint = (SELECT nextval(pg_get_serial_sequence("
                            + PgDiffUtils.quoteString(tblTmpQName) + ", "
                            + PgDiffUtils.quoteString(PgDiffUtils.getQuotedName(colName))
                            + ")));\nBEGIN\n\tEXECUTE " + restartWith + " ;\nEND;\n";
                    sb.append("\n\nDO LANGUAGE plpgsql ")
                    .append(PgDiffUtils.quoteStringDollar(doBody))
                    .append(';');
                }
            }
        }

        sb.append("\n\nDROP TABLE ").append(tblTmpQName)
        .append(arguments.isMsSql() ? PgStatement.GO : ';');

        script.addStatement(sb.toString());
    }

    /**
     * Returns the names of the columns from which data will be moved to another
     * table, excluding calculated columns.
     */
    private List<String> getColsForMovingData(AbstractTable newTbl) {
        List<AbstractColumn> oldCols = ((AbstractTable) newTbl.getTwin(oldDbFull)).getColumns();
        Stream<? extends AbstractColumn> cols = newTbl.getColumns().stream()
                .filter(oldCols::contains);
        if (arguments.isMsSql()) {
            cols = cols.map(col -> (MsColumn) col)
                    .filter(msCol -> msCol.getExpression() == null);
        } else {
            cols = cols.map(col -> (PgColumn) col)
                    .filter(pgCol -> !pgCol.isGenerated());
        }
        return cols.map(AbstractColumn::getName).collect(Collectors.toList());
    }
}
