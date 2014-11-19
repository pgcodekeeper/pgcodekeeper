/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgColumnUtils;
import cz.startnet.utils.pgdiff.schema.PgForeignKey;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgView;

/**
 * Diffs tables.
 *
 * @author fordfrog
 */
public final class PgDiffTables {
    
    private static final String ALTER_TABLE = "ALTER TABLE ";
    private static final String ALTER_COLUMN = "\tALTER COLUMN ";

    /**
     * Outputs statements for creation of clusters.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void dropClusters(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgTable newTable : newSchema.getTables()) {
            final PgTable oldTable;

            if (oldSchema == null) {
                oldTable = null;
            } else {
                oldTable = oldSchema.getTable(newTable.getName());
            }

            final String oldCluster;

            if (oldTable == null) {
                oldCluster = null;
            } else {
                oldCluster = oldTable.getClusterIndexName();
            }

            final String newCluster = newTable.getClusterIndexName();

            if (oldCluster != null && newCluster == null
                    && newTable.containsIndex(oldCluster)) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement(ALTER_TABLE
                        + PgDiffUtils.getQuotedName(newTable.getName())
                        + " SET WITHOUT CLUSTER;");
            }
        }
    }

    /**
     * Outputs statements for dropping of clusters.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void createClusters(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgTable newTable : newSchema.getTables()) {
            final PgTable oldTable;

            if (oldSchema == null) {
                oldTable = null;
            } else {
                oldTable = oldSchema.getTable(newTable.getName());
            }

            final String oldCluster;

            if (oldTable == null) {
                oldCluster = null;
            } else {
                oldCluster = oldTable.getClusterIndexName();
            }

            final String newCluster = newTable.getClusterIndexName();

            if ((oldCluster == null && newCluster != null)
                    || (oldCluster != null && newCluster != null
                    && !newCluster.equals(oldCluster))) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement(ALTER_TABLE
                        + PgDiffUtils.getQuotedName(newTable.getName())
                        + " CLUSTER ON "
                        + PgDiffUtils.getQuotedName(newCluster)
                        + ';');
            }
        }
    }

    /**
     * Outputs statements for altering tables.
     *
     * @param writer           writer the output should be written to
     * @param arguments        object containing arguments settings
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void alterTables(final PgDiffScript script,
            final PgDiffArguments arguments, final PgSchema oldSchema,
            final PgSchema newSchema, final SearchPathHelper searchPathHelper) {
        if (oldSchema == null) {
            return;
        }
        
        for (final PgTable newTable : newSchema.getTables()) {
            if (oldSchema.containsTable(newTable.getName())) {
                PgTable oldTable = oldSchema.getTable(newTable.getName());
                alterTable(script, arguments, oldTable, newTable, searchPathHelper);
            }
        }
    }

    public static void alterTable(final PgDiffScript script,
            final PgDiffArguments arguments, final PgTable oldTable,
            final PgTable newTable, final SearchPathHelper searchPathHelper) {
        PgTable fullTable = PgDiff.getFullDbNew().getSchema(
                newTable.getParent().getName()).getTable(newTable.getName());
        List<PgStatement> specialDepcies = 
                PgDiff.addUniqueDependenciesOnCreateEdit(script, arguments, searchPathHelper, fullTable);
        
        updateTableColumns(
                script, arguments, oldTable, newTable, searchPathHelper);
        checkWithOIDS(script, oldTable, newTable, searchPathHelper);
        checkInherits(script, oldTable, newTable, searchPathHelper);
        checkTablespace(script, oldTable, newTable, searchPathHelper);
        addAlterStatistics(script, oldTable, newTable, searchPathHelper);
        addAlterStorage(script, oldTable, newTable, searchPathHelper);
        
        if (!Objects.equals(oldTable.getOwner(), newTable.getOwner())) {
            searchPathHelper.outputSearchPath(script);
            script.addStatement(newTable.getOwnerSQL());
        }
        
        if (!oldTable.getPrivileges().equals(newTable.getPrivileges())) {
            searchPathHelper.outputSearchPath(script);
            script.addStatement(newTable.getPrivilegesSQL());
        }
        
        alterComments(script, oldTable, newTable, searchPathHelper);
        
        for(PgStatement depcy : specialDepcies){
            if (depcy instanceof PgSequence && ((PgSequence)depcy).getOwnedBy() != null){
                script.addStatement(((PgSequence)depcy).getOwnedBySQL());
            }
        }
    }

    /**
     * Generate the needed alter table xxx set statistics when needed.
     *
     * @param writer           writer the output should be written to
     * @param oldTable         original table
     * @param newTable         new table
     * @param searchPathHelper search path helper
     */
    private static void addAlterStatistics(final PgDiffScript script,
            final PgTable oldTable, final PgTable newTable,
            final SearchPathHelper searchPathHelper) {
        final Map<String, Integer> stats = new HashMap<String, Integer>();

        for (final PgColumn newColumn : newTable.getColumns()) {
            final PgColumn oldColumn = oldTable.getColumn(newColumn.getName());

            if (oldColumn != null) {
                final Integer oldStat = oldColumn.getStatistics();
                final Integer newStat = newColumn.getStatistics();
                Integer newStatValue = null;

                if (newStat != null && (oldStat == null
                        || !newStat.equals(oldStat))) {
                    newStatValue = newStat;
                } else if (oldStat != null && newStat == null) {
                    newStatValue = Integer.valueOf(-1);
                }

                if (newStatValue != null) {
                    stats.put(newColumn.getName(), newStatValue);
                }
            }
        }

        for (final Map.Entry<String, Integer> entry : stats.entrySet()) {
            searchPathHelper.outputSearchPath(script);
            script.addStatement("ALTER TABLE ONLY "
                    + PgDiffUtils.getQuotedName(newTable.getName())
                    + " ALTER COLUMN "
                    + PgDiffUtils.getQuotedName(entry.getKey())
                    + " SET STATISTICS "
                    + entry.getValue()
                    + ';');
        }
    }

    /**
     * Generate the needed alter table xxx set storage when needed.
     *
     * @param writer           writer the output should be written to
     * @param oldTable         original table
     * @param newTable         new table
     * @param searchPathHelper search path helper
     */
    private static void addAlterStorage(final PgDiffScript script,
            final PgTable oldTable, final PgTable newTable,
            final SearchPathHelper searchPathHelper) {
        for (final PgColumn newColumn : newTable.getColumns()) {
            final PgColumn oldColumn = oldTable.getColumn(newColumn.getName());
            final String oldStorage = (oldColumn == null
                    || oldColumn.getStorage() == null
                    || oldColumn.getStorage().isEmpty()) ? null
                    : oldColumn.getStorage();
            final String newStorage = (newColumn.getStorage() == null
                    || newColumn.getStorage().isEmpty()) ? null
                    : newColumn.getStorage();

            if (newStorage == null && oldStorage != null) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement(MessageFormat.format(Resources.getString(
                        "WarningUnableToDetermineStorageType"),
                        newTable.getName() + '.' + newColumn.getName()));

                continue;
            }

            if (newStorage == null || newStorage.equalsIgnoreCase(oldStorage)) {
                continue;
            }

            searchPathHelper.outputSearchPath(script);
            script.addStatement("ALTER TABLE ONLY "
                    + PgDiffUtils.getQuotedName(newTable.getName())
                    + " ALTER COLUMN "
                    + PgDiffUtils.getQuotedName(newColumn.getName())
                    + " SET STORAGE " + newStorage + ';');
        }
    }

    /**
     * Adds statements for creation of new columns to the list of statements.
     *
     * @param statements          list of statements
     * @param arguments           object containing arguments settings
     * @param oldTable            original table
     * @param newTable            new table
     * @param dropDefaultsColumns list for storing columns for which default
     *                            value should be dropped
     */
    private static void addCreateTableColumns(final List<String> statements,
            final PgDiffArguments arguments, final PgTable oldTable,
            final PgTable newTable, final List<PgColumn> dropDefaultsColumns, 
            final List<String> defaultStatements) {
        StringBuilder defaultStatement = new StringBuilder(100);
        for (final PgColumn column : newTable.getColumns()) {
            if (!oldTable.containsColumn(column.getName())) {
                statements.add("\tADD COLUMN "
                        + column.getFullDefinition(arguments.isAddDefaults(), 
                                defaultStatement));
                if (defaultStatement.length() > 0) {
                    defaultStatements.add(ALTER_COLUMN + defaultStatement);
                    defaultStatement.setLength(0);
                }
                if (arguments.isAddDefaults() && !column.getNullValue()
                        && (column.getDefaultValue() == null
                        || column.getDefaultValue().isEmpty())) {
                    dropDefaultsColumns.add(column);
                }
            }
        }
    }

    /**
     * Adds statements for removal of columns to the list of statements.
     * @param statementsToDrop 
     *
     * @param statements list of statements
     * @param oldTable   original table
     * @param newTable   new table
     */
    private static void addDropTableColumns(Map<PgStatement, String> statementsToDrop,
            final List<String> statements,
            final PgTable oldTable, final PgTable newTable) {
        for (final PgColumn column : oldTable.getColumns()) {
            if (!newTable.containsColumn(column.getName())) {
                statements.add("\tDROP COLUMN "
                        + PgDiffUtils.getQuotedName(column.getName()));
                
                // begin depcy
                // get dependent PgViews of this column, add them in pairs 
                // <dependant, reason> to the map if dependent PgView is not 
                // contained in there
                Set<PgStatement> dependants = new LinkedHashSet<>(10);
                for (PgStatement dependant : PgDiff.getDependantsSet(column, dependants)){
                    if ((dependant instanceof PgView || dependant instanceof PgForeignKey) 
                            && !statementsToDrop.containsKey(dependant)){
                        String reason = "column " + column.getName() + " of table " 
                                + oldTable.getName() + " is dropped";
                        statementsToDrop.put(dependant, reason);
                    }
                }// end depcy
            }
        }
    }

    /**
     * Adds statements for modification of columns to the list of statements.
     * @param statementsToDrop 
     *
     * @param statements          list of statements
     * @param arguments           object containing arguments settings
     * @param oldTable            original table
     * @param newTable            new table
     * @param dropDefaultsColumns list for storing columns for which default
     *                            value should be dropped
     */
    private static void addModifyTableColumns(Map<PgStatement, String> statementsToDrop, 
            final List<String> statements,
            final PgDiffArguments arguments, final PgTable oldTable,
            final PgTable newTable, final List<PgColumn> dropDefaultsColumns) {
        for (final PgColumn newColumn : newTable.getColumns()) {
            if (!oldTable.containsColumn(newColumn.getName())) {
                continue;
            }

            final PgColumn oldColumn = oldTable.getColumn(newColumn.getName());
            final String newColumnName =
                    PgDiffUtils.getQuotedName(newColumn.getName());

            if (!oldColumn.getType().equals(newColumn.getType())) {
                
                // begin depcy
                // get dependent PgViews of this column, add them in pairs 
                // <dependant, reason> to the map if dependent PgView is not 
                // contained in there
                Set<PgStatement> dependants = new LinkedHashSet<PgStatement>(10);
                for (PgStatement dependant : PgDiff.getDependantsSet(oldColumn, dependants)){
                    if ((dependant instanceof PgView || dependant instanceof PgForeignKey)
                            && !statementsToDrop.containsKey(dependant)){
                        String reason = "column " + oldColumn.getName() + " of table " 
                                    + oldTable.getName() + " is altered (type changed)";
                        statementsToDrop.put(dependant, reason);
                    }
                } // end depcy
                
                statements.add(ALTER_COLUMN + newColumnName + " TYPE "
                        + newColumn.getType() + " /* "
                        + MessageFormat.format(
                        Resources.getString("TypeParameterChange"),
                        newTable.getName(), oldColumn.getType(),
                        newColumn.getType()) + " */");
            }

            final String oldDefault = (oldColumn.getDefaultValue() == null) ? ""
                    : oldColumn.getDefaultValue();
            final String newDefault = (newColumn.getDefaultValue() == null) ? ""
                    : newColumn.getDefaultValue();

            if (!oldDefault.equals(newDefault)) {
                if (newDefault.length() == 0) {
                    statements.add(ALTER_COLUMN + newColumnName
                            + " DROP DEFAULT");
                } else {
                    statements.add(ALTER_COLUMN + newColumnName
                            + " SET DEFAULT " + newDefault);
                }
            }

            if (oldColumn.getNullValue() != newColumn.getNullValue()) {
                if (newColumn.getNullValue()) {
                    statements.add(ALTER_COLUMN + newColumnName
                            + " DROP NOT NULL");
                } else {
                    if (arguments.isAddDefaults()) {
                        final String defaultValue =
                                PgColumnUtils.getDefaultValue(
                                newColumn.getType());

                        if (defaultValue != null) {
                            statements.add(ALTER_COLUMN + newColumnName
                                    + " SET DEFAULT " + defaultValue);
                            dropDefaultsColumns.add(newColumn);
                        }
                    }

                    statements.add(ALTER_COLUMN + newColumnName
                            + " SET NOT NULL");
                }
            }
        }
    }

    /**
     * Checks whether there is a discrepancy in INHERITS for original and new
     * table.
     *
     * @param writer           writer the output should be written to
     * @param oldTable         original table
     * @param newTable         new table
     * @param searchPathHelper search path helper
     */
    private static void checkInherits(final PgDiffScript script,
            final PgTable oldTable, final PgTable newTable,
            final SearchPathHelper searchPathHelper) {
        for (final String tableName : oldTable.getInherits()) {
            if (!newTable.getInherits().contains(tableName)) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement(ALTER_TABLE
                        + PgDiffUtils.getQuotedName(newTable.getName())
                        + "\n\tNO INHERIT "
                        + PgDiffUtils.getQuotedName(tableName) + ';');
            }
        }

        for (final String tableName : newTable.getInherits()) {
            if (!oldTable.getInherits().contains(tableName)) {
                searchPathHelper.outputSearchPath(script);
                script.addStatement(ALTER_TABLE
                        + PgDiffUtils.getQuotedName(newTable.getName())
                        + "\n\tINHERIT "
                        + PgDiffUtils.getQuotedName(tableName) + ';');
            }
        }
    }

    /**
     * Checks whether OIDS are dropped from the new table. There is no way to
     * add OIDS to existing table so we do not create SQL statement for addition
     * of OIDS but we issue warning.
     *
     * @param writer           writer the output should be written to
     * @param oldTable         original table
     * @param newTable         new table
     * @param searchPathHelper search path helper
     */
    private static void checkWithOIDS(final PgDiffScript script,
            final PgTable oldTable, final PgTable newTable,
            final SearchPathHelper searchPathHelper) {
        if (oldTable.getWith() == null && newTable.getWith() == null
                || oldTable.getWith() != null
                && oldTable.getWith().equals(newTable.getWith())) {
            return;
        }

        searchPathHelper.outputSearchPath(script);
        
        StringBuilder sb = new StringBuilder();
        sb.append(ALTER_TABLE);
        sb.append(PgDiffUtils.getQuotedName(newTable.getName()));

        if (newTable.getWith() == null
                || "OIDS=false".equalsIgnoreCase(newTable.getWith())) {
            sb.append("\n\tSET WITHOUT OIDS;");
        } else if ("OIDS".equalsIgnoreCase(newTable.getWith())
                || "OIDS=true".equalsIgnoreCase(newTable.getWith())) {
            sb.append("\n\tSET WITH OIDS;");
        } else {
            sb.append("\n\tSET ");
            sb.append(newTable.getWith());
            sb.append(';');
        }
        script.addStatement(sb.toString());
    }

    /**
     * Checks tablespace modification.
     *
     * @param writer           writer
     * @param oldTable         old table
     * @param newTable         new table
     * @param searchPathHelper search path helper
     */
    private static void checkTablespace(final PgDiffScript script,
            final PgTable oldTable, final PgTable newTable,
            final SearchPathHelper searchPathHelper) {
        if (oldTable.getTablespace() == null && newTable.getTablespace() == null
                || oldTable.getTablespace() != null
                && oldTable.getTablespace().equals(newTable.getTablespace())) {
            return;
        }

        searchPathHelper.outputSearchPath(script);
        script.addStatement(ALTER_TABLE
                + PgDiffUtils.getQuotedName(newTable.getName())
                + "\n\tTABLESPACE " + newTable.getTablespace() + ';');
    }

    /**
     * Outputs statements for creation of new tables.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void createTables(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        for (final PgTable table : newSchema.getTables()) {
            if (oldSchema == null || !oldSchema.containsTable(table.getName())) {
                PgTable fullTable = PgDiff.getFullDbNew().getSchema(
                        newSchema.getName()).getTable(table.getName());
                List<PgStatement> specialDepcies = 
                        PgDiff.addUniqueDependenciesOnCreateEdit(script, null, searchPathHelper, fullTable);
                
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeCreationSql(script, null, table);
                
                for(PgStatement depcy : specialDepcies){
                    if (depcy instanceof PgSequence && ((PgSequence)depcy).getOwnedBy() != null){
                        script.addStatement(((PgSequence)depcy).getOwnedBySQL());
                    }
                }
            }
        }
    }

    /**
     * Outputs statements for dropping tables.
     *
     * @param writer           writer the output should be written to
     * @param oldSchema        original schema
     * @param newSchema        new schema
     * @param searchPathHelper search path helper
     */
    public static void dropTables(final PgDiffScript script,
            final PgSchema oldSchema, final PgSchema newSchema,
            final SearchPathHelper searchPathHelper) {
        
        if (oldSchema == null) {
            return;
        }
        
        for (final PgTable table : oldSchema.getTables()) {
            if (!newSchema.containsTable(table.getName())) {
                if (!PgDiff.isFullSelection(table)){
                    script.addStatement("-- table \"" + table.getName() + "\" was not "
                            + "dropped because it was not selected entirely");
                    continue;
                }
                // check all dependants, drop them if blocking
                // output search path, if necessary
                Set<PgStatement> dependantsSet = new LinkedHashSet<>(10);
                PgDiff.getDependantsSet(table, dependantsSet);
                // wrap Set into array for reverse iteration
                PgStatement[] dependants = dependantsSet.toArray(
                        new PgStatement[dependantsSet.size()]);
                
                for (int i = dependants.length - 1; i >= 0; i--){
                    PgStatement depnt = dependants[i];
                    
                    if (depnt instanceof PgView) {
                        PgDiff.tempSwitchSearchPath(depnt.getParent().getName(),
                                searchPathHelper, script);
                    } else if (depnt instanceof PgForeignKey) {
                        if (depnt.getParent().compare(table)
                                && depnt.getParent().getParent().compare(table.getParent())) {
                            // if this fkey is a direct descendant of the table we're dropping
                            // skip it, postgres handles direct descendants itself
                            continue;
                        }
                        
                        PgDiff.tempSwitchSearchPath(depnt.getParent().getParent().getName(),
                                searchPathHelper, script);
                    } else {
                        // explicitly specify objects to work on in the ifs above
                        // skip everything else (i.e. columns)
                        continue;
                    }
                    PgDiff.writeDropSql(script, "-- DEPCY: Dropping an object that depends"
                            + " on the table we are about to drop: " + table.getName(), depnt);
                }
                
                searchPathHelper.outputSearchPath(script);
                PgDiff.writeDropSql(script, null, table);
            }
        }
    }
    
    /**
     * Outputs statements for addition, removal and modifications of table
     * columns.
     *
     * @param writer           writer the output should be written to
     * @param arguments        object containing arguments settings
     * @param oldTable         original table
     * @param newTable         new table
     * @param searchPathHelper search path helper
     */
    private static void updateTableColumns(final PgDiffScript script,
            final PgDiffArguments arguments, final PgTable oldTable,
            final PgTable newTable, final SearchPathHelper searchPathHelper) {
        final List<String> statementsAlter = new ArrayList<>();
        final List<String> statementsCreate = new ArrayList<>();
        final List<String> statementsDrop = new ArrayList<>();
        final List<PgColumn> dropDefaultsColumns = new ArrayList<>();
        final List<String> defaultStatements = new ArrayList<>();
        
        // ordered pairs of <statementToDrop, reasonOfDrop>
        Map<PgStatement, String> statementsToDrop = new LinkedHashMap<>(10);
        
        addDropTableColumns(statementsToDrop, statementsDrop, oldTable, newTable);
        addCreateTableColumns(statementsCreate, arguments, oldTable, newTable, 
                dropDefaultsColumns, defaultStatements);
        addModifyTableColumns(statementsToDrop, 
                statementsAlter, arguments, oldTable, newTable, dropDefaultsColumns);

        // write dependent PgViews/PgForeignKey drop sql in REVERSE order before table altering
        Set<Entry<PgStatement, String>> dependants = statementsToDrop.entrySet();
        // wrap Set into array for reverse iteration
        Object[] dependantsArray = dependants.toArray();
        
        for (int i = dependantsArray.length - 1; i >= 0; i--){
            @SuppressWarnings("unchecked")
            PgStatement depnt = ((Entry<PgStatement, String>) dependantsArray[i]).getKey();

            @SuppressWarnings("unchecked")
            String reason = ((Entry<PgStatement, String>) dependantsArray[i]).getValue();
            
            if (depnt instanceof PgView){
                PgDiff.tempSwitchSearchPath(depnt.getParent().getName(),
                        searchPathHelper, script);
            }else if (depnt instanceof PgForeignKey){
                PgDiff.tempSwitchSearchPath(depnt.getParent().getParent().getName(),
                        searchPathHelper, script);
            } else {
                // explicitly specify objects to work on in the ifs above
                // skip everything else (i.e. columns)
                continue;
            }
            PgDiff.writeDropSql(script, "-- DEPCY: dropping dependant object: " + reason, depnt);
        }// end write dependent PgViews/PgForeignKey drop sql code before table altering

        final String quotedTableName = PgDiffUtils.getQuotedName(newTable.getName());
        
        alterTblDropColumns(newTable, script, searchPathHelper, statementsDrop, quotedTableName);

        alterTblCreateColumns(newTable, script, searchPathHelper, statementsCreate, quotedTableName);
        
        alterTblAlterColumns(script, searchPathHelper, statementsAlter, quotedTableName);
        
        alterTblAlterColumns(script, searchPathHelper, defaultStatements, quotedTableName);

        if (!dropDefaultsColumns.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(ALTER_TABLE);
            sb.append(quotedTableName);
            sb.append('\n');

            for (int i = 0; i < dropDefaultsColumns.size(); i++) {
                sb.append(ALTER_COLUMN);
                sb.append(PgDiffUtils.getQuotedName(
                        dropDefaultsColumns.get(i).getName()));
                sb.append(" DROP DEFAULT");
                sb.append((i + 1) < dropDefaultsColumns.size() ? ",\n" : ";");
            }
            script.addStatement(sb.toString());
        }
        
        // write dependent PgViews create sql code after table altering
        for (Object dependant : dependants){
            @SuppressWarnings("unchecked")
            PgStatement depnt = ((Entry<PgStatement, String>) dependant).getKey();

            @SuppressWarnings("unchecked")
            String reason = ((Entry<PgStatement, String>) dependant).getValue();
            
            if (depnt instanceof PgView){
                PgView view = (PgView) depnt;
                PgDiff.tempSwitchSearchPath(view.getParent().getName(),
                        searchPathHelper, script);
                PgDiff.writeCreationSql(script, "-- DEPCY: recreating dropped dependant"
                        + " object: " + reason, view);
            }
        }// end write dependent PgViews create sql code after table altering
    }

    private static void alterTblCreateColumns(PgTable table, final PgDiffScript script,
            final SearchPathHelper searchPathHelper,
            final List<String> statements, final String quotedTableName) {
        if (!statements.isEmpty()) {
            searchPathHelper.outputSearchPath(script);
            script.addCreate(table, null, getAlterTableStatements(statements, quotedTableName));
        }
    }
    
    private static void alterTblDropColumns(PgTable table, final PgDiffScript script,
            final SearchPathHelper searchPathHelper,
            final List<String> statements, final String quotedTableName) {
        if (!statements.isEmpty()) {
            searchPathHelper.outputSearchPath(script);
            script.addDrop(table, null, getAlterTableStatements(statements, quotedTableName));
        }
    }
    
    private static void alterTblAlterColumns(final PgDiffScript script,
            final SearchPathHelper searchPathHelper,
            final List<String> statements, final String quotedTableName) {
        if (!statements.isEmpty()) {
            searchPathHelper.outputSearchPath(script);
            script.addStatement(getAlterTableStatements(statements, quotedTableName));
        }
    }
    
    private static String getAlterTableStatements(final List<String> statements, final String quotedTableName){
        StringBuilder sb = new StringBuilder();
        sb.append(ALTER_TABLE);
        sb.append(quotedTableName);
        sb.append('\n');

        for (int i = 0; i < statements.size(); i++) {
            sb.append(statements.get(i));
            sb.append((i + 1) < statements.size() ? ",\n" : ";");
        }
        return sb.toString();
    }

    /**
     * Outputs statements for tables and columns for which comments have
     * changed.
     *
     * @param writer           writer
     * @param oldTable         old table
     * @param newTable         new table
     * @param searchPathHelper search path helper
     */
    private static void alterComments(final PgDiffScript script,
            final PgTable oldTable, final PgTable newTable,
            final SearchPathHelper searchPathHelper) {
        if (oldTable.getComment() == null
                && newTable.getComment() != null
                || oldTable.getComment() != null
                && newTable.getComment() != null
                && !oldTable.getComment().equals(newTable.getComment())) {
            searchPathHelper.outputSearchPath(script);
            
            script.addStatement("COMMENT ON TABLE "
                    + PgDiffUtils.getQuotedName(newTable.getName())
                    + " IS "
                    + newTable.getComment()
                    + ';');
        } else if (oldTable.getComment() != null
                && newTable.getComment() == null) {
            searchPathHelper.outputSearchPath(script);
            
            script.addStatement("COMMENT ON TABLE "
                     + PgDiffUtils.getQuotedName(newTable.getName())
                     + " IS NULL;");
        }

        for (final PgColumn newColumn : newTable.getColumns()) {
            final PgColumn oldColumn = oldTable.getColumn(newColumn.getName());
            final String oldComment =
                    oldColumn == null ? null : oldColumn.getComment();
            final String newComment = newColumn.getComment();

            if (newComment != null && (oldComment == null ? newComment != null
                    : !oldComment.equals(newComment))) {
                searchPathHelper.outputSearchPath(script);

                script.addStatement("COMMENT ON COLUMN "
                        + PgDiffUtils.getQuotedName(newTable.getName())
                        + '.'
                        + PgDiffUtils.getQuotedName(newColumn.getName())
                        + " IS "
                        + newColumn.getComment()
                        + ';');
            } else if (oldComment != null && newComment == null) {
                searchPathHelper.outputSearchPath(script);

                script.addStatement("COMMENT ON COLUMN "
                        + PgDiffUtils.getQuotedName(newTable.getName())
                        + '.'
                        + PgDiffUtils.getQuotedName(newColumn.getName())
                        + " IS NULL;");
            }
        }
    }

    /**
     * Creates a new instance of PgDiffTables.
     */
    private PgDiffTables() {
    }
}
