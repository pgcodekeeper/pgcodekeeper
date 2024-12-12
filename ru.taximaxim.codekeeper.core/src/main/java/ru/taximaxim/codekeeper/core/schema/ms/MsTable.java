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
package ru.taximaxim.codekeeper.core.schema.ms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

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

/**
 * Base MS SQL table class
 *
 * @since 5.3.1.
 * @author galiev_mr
 */
public class MsTable extends AbstractTable implements ISimpleOptionContainer {

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

    private final Map<String, MsStatistics> statistics = new HashMap<>();

    public MsTable(String name) {
        super(name);
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
    public ObjectState appendAlterSQL(PgStatement newCondition, AtomicBoolean isNeedDepcies, SQLScript script) {
        int startSize = script.getSize();
        MsTable newTable = (MsTable) newCondition;

        if (isRecreated(newTable)) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }

        compareOptions(newTable, script);
        appendAlterOwner(newTable, script);
        compareTableOptions(newTable, script);
        alterPrivileges(newTable, script);

        return getObjectState(script, startSize);
    }

    protected void appendAlterOptions(SQLScript script) {
        if (isTracked != null) {
            script.addStatement(enableTracking(), SQLActionType.END);
        }
    }

    protected void appendName(StringBuilder sbSQL) {
        sbSQL.append("SET QUOTED_IDENTIFIER ON").append(GO).append('\n');
        sbSQL.append("SET ANSI_NULLS ").append(ansiNulls ? "ON" : "OFF");
        sbSQL.append(GO).append('\n');
        sbSQL.append("CREATE TABLE ").append(getQualifiedName());
    }

    protected void appendColumns(StringBuilder sbSQL) {
        sbSQL.append("(\n");

        int start = sbSQL.length();
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

        if (start != sbSQL.length()) {
            sbSQL.setLength(sbSQL.length() - 2);
            sbSQL.append('\n');
        }

        sbSQL.append(')');
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

    protected void appendOptions(StringBuilder sbSQL) {
        int startLength = sbSQL.length();
        if (tablespace != null) {
            // tablespace already quoted
            sbSQL.append(" ON ").append(tablespace).append(' ');
        }

        if (getTextImage() != null) {
            sbSQL.append("TEXTIMAGE_ON ").append(MsDiffUtils.quoteName(getTextImage())).append(' ');
        }

        if (getFileStream() != null) {
            sbSQL.append("FILESTREAM_ON ").append(MsDiffUtils.quoteName(getFileStream())).append(' ');
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
            sbSQL.append("\nWITH (").append(sb).append(")");
        }
    }

    @Override
    protected boolean isNeedRecreate(AbstractTable newTable) {
        if (newTable instanceof MsTable smt) {
            return !Objects.equals(smt.getTablespace(), getTablespace())
                    || isAnsiNulls() != smt.isAnsiNulls()
                    || !PgDiffUtils.setlikeEquals(smt.getPkeys(), getPkeys())
                    || !Objects.equals(smt.getOptions(), getOptions())
                    || !Objects.equals(smt.getFileStream(), getFileStream())
                    || (smt.getTextImage() != null && getTextImage() != null
                    && !Objects.equals(smt.getTextImage(), getTextImage()));
        }

        return true;
    }

    private void compareTableOptions(MsTable table, SQLScript script) {
        if (Objects.equals(isTracked, table.isTracked())) {
            if (pkChanged(table) && isTracked != null) {
                disableEnableTracking(SQLActionType.MID, script, table);
            }
            return;
        }

        if (table.isTracked() == null) {
            script.addStatement(disableTracking(), SQLActionType.END);
            return;
        }

        if (isTracked == null) {
            script.addStatement(table.enableTracking(), SQLActionType.END);
            return;
        }

        disableEnableTracking(SQLActionType.END, script, table);
    }

    private boolean pkChanged(MsTable table) {
        var oldPk = getConstraints().stream().filter(MsConstraintPk.class::isInstance).findAny().orElse(null);
        var newPk = table.getConstraints().stream().filter(MsConstraintPk.class::isInstance).findAny().orElse(null);
        return oldPk != null && newPk != null && !Objects.equals(oldPk, newPk);
    }

    private void disableEnableTracking(SQLActionType actionType, SQLScript script, MsTable table) {
        script.addStatement(disableTracking(), actionType);
        script.addStatement(table.enableTracking(), SQLActionType.END);
    }

    private String disableTracking() {
        return getAlterTable(false) + " DISABLE CHANGE_TRACKING";
    }

    private String enableTracking() {
        return new StringBuilder(getAlterTable(false))
                .append(" ENABLE CHANGE_TRACKING WITH (TRACK_COLUMNS_UPDATED = ")
                .append(isTracked() ? "ON" : "OFF").append(')').toString();
    }

    @Override
    public String getAlterTable(boolean only) {
        return ALTER_TABLE + getQualifiedName();
    }

    public String getFileStream() {
        return fileStream;
    }

    public void setFileStream(String fileStream) {
        this.fileStream = fileStream;
        resetHash();
    }

    public String getTextImage() {
        return textImage;
    }

    public void setTextImage(String textImage) {
        this.textImage = textImage;
        resetHash();
    }

    public void setAnsiNulls(boolean ansiNulls) {
        this.ansiNulls = ansiNulls;
        resetHash();
    }

    public boolean isAnsiNulls() {
        return ansiNulls;
    }

    public Boolean isTracked() {
        return isTracked;
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

    public boolean isMemoryOptimized() {
        return "ON".equalsIgnoreCase(getOptions().get(MEMORY_OPTIMIZED));
    }

    @Override
    protected void writeInsert(SQLScript script, String tblQName, String tblTmpQName,
            List<String> identityColsForMovingData, String cols) {
        if (!identityColsForMovingData.isEmpty()) {
            // There can only be one IDENTITY column per table in MSSQL.
            script.addStatement(getIdentInsertText(tblQName, true));
        }

        StringBuilder sbInsert = new StringBuilder();

        sbInsert.append("INSERT INTO ").append(tblQName).append('(').append(cols).append(")");
        sbInsert.append("\nSELECT ").append(cols).append(" FROM ").append(tblTmpQName);
        script.addStatement(sbInsert);

        if (!identityColsForMovingData.isEmpty()) {
            // There can only be one IDENTITY column per table in MSSQL.
            script.addStatement(getIdentInsertText(tblQName, false));

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
            .filter(msCol -> msCol.getExpression() == null)
            .map(AbstractColumn::getName).toList();
    }

    @Override
    public void getDropSQL(SQLScript script, boolean generateExists) {
        if (isTracked != null && isTracked && getConstraints().stream().anyMatch(MsConstraintPk.class::isInstance)) {
            script.addStatement(disableTracking(), SQLActionType.BEGIN);
        }
        super.getDropSQL(script, generateExists);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof MsTable table && super.compare(obj)) {
            return ansiNulls == table.isAnsiNulls()
                    && Objects.equals(textImage, table.getTextImage())
                    && Objects.equals(fileStream, table.getFileStream())
                    && Objects.equals(isTracked, table.isTracked)
                    && Objects.equals(tablespace, table.getTablespace())
                    && PgDiffUtils.setlikeEquals(getPkeys(), table.getPkeys());
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(getTextImage());
        hasher.put(getFileStream());
        hasher.put(isAnsiNulls());
        hasher.put(isTracked());
        hasher.put(getTablespace());
        hasher.putUnordered(getPkeys());
    }

    @Override
    protected MsTable getTableCopy() {
        MsTable table = new MsTable(name);
        table.setFileStream(getFileStream());
        table.setTextImage(getTextImage());
        table.setAnsiNulls(isAnsiNulls());
        table.setTracked(isTracked());
        table.setTablespace(getTablespace());

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
            return statistics.get(name);
        }
        return super.getChild(name, type);
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        super.fillChildrenList(l);
        l.add(statistics.values());
    }

    public void addStatistics(final MsStatistics stat) {
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
