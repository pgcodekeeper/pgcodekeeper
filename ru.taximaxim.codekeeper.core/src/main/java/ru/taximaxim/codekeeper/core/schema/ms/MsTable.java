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
package ru.taximaxim.codekeeper.core.schema.ms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.ISimpleOptionContainer;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLActionType;
import ru.taximaxim.codekeeper.core.script.SQLScript;
import ru.taximaxim.codekeeper.core.settings.ISettings;

/**
 * Base MS SQL table class
 */
public final class MsTable extends AbstractTable implements ISimpleOptionContainer {

    private static final String MEMORY_OPTIMIZED = "MEMORY_OPTIMIZED";

    /**
     * list of internal primary keys for memory optimized table
     */
    private List<AbstractConstraint> pkeys;

    private boolean ansiNulls;
    private Boolean isTracked;

    private String textImage;
    private String fileStream;
    private String tablespace;
    private String sysVersioning;

    private AbstractColumn periodStartCol;
    private AbstractColumn periodEndCol;

    private final Map<String, MsStatistics> statistics = new HashMap<>();

    public MsTable(String name, ISettings settings) {
        super(name, settings);
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder();
        appendName(sbSQL);
        appendColumns(sbSQL);
        appendOptions(sbSQL);
        script.addStatement(sbSQL);
        appendAlterOptions(script);
        appendOwnerSQL(script);
        appendPrivileges(script);
        appendColumnsPriliges(script);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        MsTable newTable = (MsTable) newCondition;

        if (isRecreated(newTable, script.getSettings())) {
            return ObjectState.RECREATE;
        }

        appendAlterOwner(newTable, script);
        compareTableOptions(newTable, script);
        alterPrivileges(newTable, script);

        return getObjectState(script, startSize);
    }

    private void appendAlterOptions(SQLScript script) {
        if (isTracked != null) {
            script.addStatement(enableTracking(), SQLActionType.END);
        }
        if (sysVersioning != null) {
            script.addStatement(enableSysVersioning(), SQLActionType.END);
        }
    }

    private void appendName(StringBuilder sbSQL) {
        sbSQL.append("SET QUOTED_IDENTIFIER ON").append(GO).append('\n');
        sbSQL.append("SET ANSI_NULLS ").append(ansiNulls ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        sbSQL.append("CREATE TABLE ").append(getQualifiedName());
    }

    private void appendColumns(StringBuilder sbSQL) {
        sbSQL.append("(\n");

        for (AbstractColumn column : columns) {
            sbSQL.append("\t");
            sbSQL.append(column.getFullDefinition());
            sbSQL.append(",\n");
        }

        for (AbstractConstraint con : getPkeys()) {
            if (con.isPrimaryKey()) {
                sbSQL.append("\t");
                String name = con.getName();
                if (!name.isEmpty()) {
                    sbSQL.append("CONSTRAINT ").append(MsDiffUtils.quoteName(name)).append(' ');
                }
                sbSQL.append(con.getDefinition());
                sbSQL.append(",\n");
            }
        }
        sbSQL.setLength(sbSQL.length() - 2);
        appendPeriodSystem(sbSQL);
        sbSQL.append('\n').append(')');
    }

    private void appendPeriodSystem(StringBuilder sb) {
        if (periodStartCol != null && periodEndCol != null) {
            sb.append(",\n\tPERIOD FOR SYSTEM_TIME (");
            sb.append(MsDiffUtils.quoteName(periodStartCol.getName())).append(", ");
            sb.append(MsDiffUtils.quoteName(periodEndCol.getName()));
            sb.append(")");
        }
    }

    public List<AbstractConstraint> getPkeys() {
        return pkeys == null ? Collections.emptyList() : Collections.unmodifiableList(pkeys);
    }

    @Override
    public void addConstraint(AbstractConstraint constraint) {
        if (constraint.isPrimaryKey() && isMemoryOptimized()) {
            if (pkeys == null) {
                pkeys = new ArrayList<>();
            }
            pkeys.add(constraint);
        } else {
            super.addConstraint(constraint);
        }
    }

    private void appendOptions(StringBuilder sbSQL) {
        int startLength = sbSQL.length();
        if (tablespace != null) {
            // tablespace already quoted
            sbSQL.append(" ON ").append(tablespace).append(' ');
        }

        if (textImage != null) {
            sbSQL.append("TEXTIMAGE_ON ").append(MsDiffUtils.quoteName(textImage)).append(' ');
        }

        if (fileStream != null) {
            sbSQL.append("FILESTREAM_ON ").append(MsDiffUtils.quoteName(fileStream)).append(' ');
        }

        if (sbSQL.length() > startLength) {
            sbSQL.setLength(sbSQL.length() - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Entry <String, String> entry : options.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            sb.append(key);
            if (!value.isEmpty()) {
                sb.append(" = ").append(value);
            }
            sb.append(", ");
        }

        if (sb.length() > 0){
            sb.setLength(sb.length() - 2);
            sbSQL.append("\nWITH (").append(sb).append(')');
        }
    }

    @Override
    protected boolean isNeedRecreate(AbstractTable newTable) {
        if (newTable instanceof MsTable smt) {
            return !Objects.equals(smt.tablespace, tablespace)
                    || ansiNulls != smt.ansiNulls
                    || !PgDiffUtils.setlikeEquals(smt.getPkeys(), getPkeys())
                    || !Objects.equals(smt.options, options)
                    || !Objects.equals(smt.fileStream, fileStream)
                    || !Objects.equals(smt.periodStartCol, periodStartCol)
                    || !Objects.equals(smt.periodEndCol, periodEndCol)
                    || (smt.textImage != null && textImage != null
                            && !Objects.equals(smt.textImage, textImage));
        }

        return true;
    }

    public void compareTableOptions(MsTable newTable, SQLScript script) {
        compareTracked(newTable, script);
        compareSysVersioning(newTable, script);
    }

    private void compareSysVersioning(MsTable newTable, SQLScript script) {
        if (Objects.equals(sysVersioning, newTable.sysVersioning)) {
            if (sysVersioning != null && pkChanged(newTable)) {
                script.addStatement(disableSysVersioning(), SQLActionType.BEGIN);
                script.addStatement(newTable.enableSysVersioning(), SQLActionType.END);
            }
            return;
        }

        if (sysVersioning != null) {
            script.addStatement(disableSysVersioning(), SQLActionType.MID);
        }

        if (newTable.sysVersioning != null) {
            script.addStatement(newTable.enableSysVersioning(), SQLActionType.MID);
        }
    }

    private void compareTracked(MsTable newTable, SQLScript script) {
        if (Objects.equals(isTracked, newTable.isTracked)) {
            if (isTracked != null && pkChanged(newTable)) {
                script.addStatement(disableTracking(), SQLActionType.BEGIN);
                script.addStatement(newTable.enableTracking(), SQLActionType.END);
            }
            return;
        }

        if (isTracked != null) {
            script.addStatement(disableTracking(), SQLActionType.MID);
        }

        if (newTable.isTracked != null) {
            script.addStatement(newTable.enableTracking(), SQLActionType.MID);
        }
    }

    private boolean pkChanged(MsTable table) {
        var oldPk = getConstraints().stream().filter(MsConstraintPk.class::isInstance).findAny().orElse(null);
        var newPk = table.getConstraints().stream().filter(MsConstraintPk.class::isInstance).findAny().orElse(null);
        return oldPk != null && newPk != null && !Objects.equals(oldPk, newPk);
    }

    private String disableTracking() {
        return getAlterTable(false) + " DISABLE CHANGE_TRACKING";
    }

    private String enableTracking() {
        return new StringBuilder(getAlterTable(false))
                .append(" ENABLE CHANGE_TRACKING WITH (TRACK_COLUMNS_UPDATED = ")
                .append(isTracked() ? "ON" : "OFF").append(')').toString();
    }

    private String disableSysVersioning() {
        return getAlterTable(false) + " SET (SYSTEM_VERSIONING = OFF)";
    }

    private String enableSysVersioning() {
        return getAlterTable(false) + " SET (SYSTEM_VERSIONING = " + sysVersioning + ')';
    }

    @Override
    public String getAlterTable(boolean only) {
        return ALTER_TABLE + getQualifiedName();
    }

    @Override
    public void getDropSQL(SQLScript script, boolean generateExists) {
        if (isTracked() && getConstraints().stream().anyMatch(MsConstraintPk.class::isInstance)) {
            script.addStatement(disableTracking(), SQLActionType.BEGIN);
        }
        if (sysVersioning != null) {
            script.addStatement(disableSysVersioning(), SQLActionType.BEGIN);
        }

        super.getDropSQL(script, generateExists);
    }

    public void setFileStream(String fileStream) {
        this.fileStream = fileStream;
        resetHash();
    }

    public void setTextImage(String textImage) {
        this.textImage = textImage;
        resetHash();
    }

    public void setAnsiNulls(boolean ansiNulls) {
        this.ansiNulls = ansiNulls;
        resetHash();
    }

    public boolean isTracked() {
        return isTracked != null && isTracked;
    }


    public void setTracked(final Boolean isTracked) {
        this.isTracked = isTracked;
        resetHash();
    }

    public String getTablespace() {
        return tablespace;
    }

    public void setTablespace(final String tablespace) {
        this.tablespace = tablespace;
        resetHash();
    }

    public void setPeriodStartCol(AbstractColumn periodStartCol) {
        this.periodStartCol = periodStartCol;
        resetHash();
    }

    public void setPeriodEndCol(AbstractColumn periodEndCol) {
        this.periodEndCol = periodEndCol;
        resetHash();
    }

    public boolean isMemoryOptimized() {
        return "ON".equalsIgnoreCase(options.get(MEMORY_OPTIMIZED));
    }

    public void setSysVersioning(String sysVersioning) {
        this.sysVersioning = sysVersioning;
        resetHash();
    }

    @Override
    protected void writeInsert(SQLScript script, AbstractTable newTable, String tblTmpQName,
            List<String> identityColsForMovingData, String cols) {
        String tblQName = newTable.getQualifiedName();
        boolean newHasIdentity = newTable.getColumns().stream().anyMatch(c -> ((MsColumn) c).isIdentity());
        if (newHasIdentity) {
            // There can only be one IDENTITY column per table in MSSQL.
            script.addStatement(getIdentInsertText(tblQName, true));
        }

        StringBuilder sbInsert = new StringBuilder();

        sbInsert.append("INSERT INTO ").append(tblQName).append('(').append(cols).append(")");
        sbInsert.append("\nSELECT ").append(cols).append(" FROM ").append(tblTmpQName);
        script.addStatement(sbInsert);

        if (newHasIdentity) {
         // There can only be one IDENTITY column per table in MSSQL.
            script.addStatement(getIdentInsertText(tblQName, false));
        }

        if (!identityColsForMovingData.isEmpty() && newHasIdentity) {
            // DECLARE'd var is only visible within its batch
            // so we shouldn't need unique names for them here
            // use the largest numeric type to fit any possible identity value
            StringBuilder sbSql = new StringBuilder();
            sbSql.append("DECLARE @restart_var numeric(38,0) = (SELECT IDENT_CURRENT (")
            .append(PgDiffUtils.quoteString(tblTmpQName))
            .append("));\nDBCC CHECKIDENT (")
            .append(PgDiffUtils.quoteString(tblQName))
            .append(", RESEED, @restart_var);");
            script.addStatement(sbSql);
        }
    }

    private String getIdentInsertText(String name, boolean isOn) {
        return "SET IDENTITY_INSERT " + name + (isOn ? " ON" : " OFF");
    }

    @Override
    protected List<String> getColsForMovingData(AbstractTable newTbl) {
        return newTbl.getColumns().stream()
            .filter(c -> containsColumn(c.getName()))
            .map(MsColumn.class::cast)
            .filter(msCol -> msCol.getExpression() == null && msCol.getGenerated() == null)
            .map(AbstractColumn::getName).toList();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        return obj instanceof MsTable table && super.compare(obj)
                && ansiNulls == table.ansiNulls
                && Objects.equals(textImage, table.textImage)
                && Objects.equals(fileStream, table.fileStream)
                && Objects.equals(isTracked, table.isTracked)
                && Objects.equals(tablespace, table.tablespace)
                && Objects.equals(periodStartCol, table.periodStartCol)
                && Objects.equals(periodEndCol, table.periodEndCol)
                && Objects.equals(sysVersioning, table.sysVersioning)
                && PgDiffUtils.setlikeEquals(getPkeys(), table.getPkeys());
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(textImage);
        hasher.put(fileStream);
        hasher.put(ansiNulls);
        hasher.put(isTracked);
        hasher.put(tablespace);
        hasher.put(periodStartCol);
        hasher.put(periodEndCol);
        hasher.put(sysVersioning);
        hasher.putUnordered(getPkeys());
    }

    @Override
    protected MsTable getTableCopy() {
        MsTable table = new MsTable(name, settings);
        table.setFileStream(fileStream);
        table.setTextImage(textImage);
        table.setAnsiNulls(ansiNulls);
        table.setTracked(isTracked);
        table.setTablespace(tablespace);
        table.setPeriodStartCol(periodStartCol);
        table.setPeriodEndCol(periodEndCol);
        table.setSysVersioning(sysVersioning);

        if (pkeys != null) {
            table.pkeys = new ArrayList<>();
            table.pkeys.addAll(pkeys);
        }
        return table;
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }

    @Override
    public void addChild(IStatement st) {
        if (st instanceof MsStatistics stat) {
            addStatistics(stat);
        } else {
            super.addChild(st);
        }
    }

    @Override
    public PgStatement getChild(String name, DbObjType type) {
        if (DbObjType.STATISTICS == type) {
            return getChildByName(statistics, name);
        }
        return super.getChild(name, type);
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        super.fillChildrenList(l);
        l.add(statistics.values());
    }

    private void addStatistics(final MsStatistics stat) {
        addUnique(statistics, stat);
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof MsTable table && super.compareChildren(obj)) {
            return statistics.equals(table.statistics);
        }
        return false;
    }

    @Override
    public void computeChildrenHash(Hasher hasher) {
        super.computeChildrenHash(hasher);
        hasher.putUnordered(statistics);
    }
}
