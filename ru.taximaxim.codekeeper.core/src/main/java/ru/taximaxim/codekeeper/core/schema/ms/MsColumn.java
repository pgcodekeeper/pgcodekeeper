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

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SQLAction;

public class MsColumn extends AbstractColumn {

    private boolean isSparse;
    private boolean isRowGuidCol;
    private boolean isPersisted;
    private boolean isNotForRep;
    private boolean isIdentity;
    private String seed;
    private String increment;
    private String defaultName;
    private String expession;
    private String maskingFunction;

    public MsColumn(String name) {
        super(name);
    }

    @Override
    public String getFullDefinition() {
        final StringBuilder sbDefinition = new StringBuilder();
        sbDefinition.append(MsDiffUtils.quoteName(name));
        sbDefinition.append(' ');
        if (getExpression() != null) {
            sbDefinition.append("AS ").append(getExpression());
        } else {
            sbDefinition.append(getType());
        }

        if (getCollation() != null) {
            sbDefinition.append(COLLATE).append(getCollation());
        }

        if (isSparse()) {
            sbDefinition.append(" SPARSE");
        }

        if (isRowGuidCol()) {
            sbDefinition.append(" ROWGUIDCOL");
        }

        if (isPersisted()) {
            sbDefinition.append(" PERSISTED");
        }

        if (getMaskingFunction() != null) {
            sbDefinition.append(" MASKED WITH (FUNCTION = ").append(getMaskingFunction()).append(")");
        }

        if (getExpression() == null) {
            sbDefinition.append(getNullValue() ? NULL : NOT_NULL);
        }

        if (isIdentity()) {
            sbDefinition.append(" IDENTITY (").append(getSeed()).append(',').append(getIncrement()).append(")");
            if (isNotForRep()) {
                sbDefinition.append(" NOT FOR REPLICATION");
            }
        }

        if (getDefaultValue() != null) {
            if (getDefaultName() != null) {
                sbDefinition.append(" CONSTRAINT ");
                sbDefinition.append(MsDiffUtils.quoteName(getDefaultName()));
            }
            sbDefinition.append(" DEFAULT ");
            sbDefinition.append(getDefaultValue());
        }

        return sbDefinition.toString();
    }

    @Override
    public void getCreationSQL(Collection<SQLAction> createActions) {
        SQLAction sql = new SQLAction();

        sql.append(getAlterTable(false));
        sql.append("\n\tADD ").append(MsDiffUtils.quoteName(name)).append(' ');
        if (getExpression() != null) {
            sql.append("AS ").append(getExpression());
        } else {
            sql.append(getType());
        }

        if (getCollation() != null) {
            sql.append(COLLATE).append(getCollation());
        }

        if (isIdentity()) {
            sql.append(" IDENTITY (").append(getSeed()).append(',').append(getIncrement()).append(")");
            if (isNotForRep()) {
                sql.append(" NOT FOR REPLICATION");
            }
        }

        if (getMaskingFunction() != null) {
            sql.append(" MASKED WITH (FUNCTION = ").append(getMaskingFunction()).append(")");
        }

        boolean isJoinNotNull = getExpression() == null && getDefaultValue() == null
                && !getNullValue();

        if (isJoinNotNull) {
            sql.append(NOT_NULL);
        }

        createActions.add(sql);

        compareDefaults(null, null, getDefaultName(), getDefaultValue(), createActions);

        if (!isJoinNotNull && getExpression() == null && !getNullValue()) {
            if (getDefaultValue() != null) {
                createActions.add(new SQLAction(getUpdateSql()));
            }

            SQLAction sqlAlter = new SQLAction();
            sqlAlter.append(getAlterColumn(false, getName())).append(' ').append(getType());

            if (getCollation() != null) {
                sqlAlter.append(COLLATE).append(getCollation());
            }

            sqlAlter.append(NOT_NULL);
            createActions.add(sqlAlter);
        }

        compareOption(false, isSparse(), "SPARSE", createActions);
        compareOption(false, isRowGuidCol(), "ROWGUIDCOL", createActions);
        compareOption(false, isPersisted(), "PERSISTED", createActions);

        appendPrivileges(createActions);
    }

    private void compareOption(boolean oldOption, boolean newOption, String optionName, Collection<SQLAction> sqlActions) {
        compareOption(oldOption, newOption, optionName, null, sqlActions);
    }

    private void compareOption(boolean oldOption, boolean newOption, String optionName,
            AtomicBoolean isNeedDepcies, Collection<SQLAction> sqlActions) {

        if (oldOption == newOption) {
            return;
        }

        /*
         * we can set PERSISTED without drop dependencies, but can't simple drop this option
         * for first we have to drop dependencies
         */
        if (isNeedDepcies != null && (!"PERSISTED".equalsIgnoreCase(optionName) || oldOption)) {
            isNeedDepcies.set(true);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getAlterColumn(false, name));
        sb.append(newOption ? " ADD " : " DROP ");
        sb.append(optionName);
        sqlActions.add(new SQLAction(sb));
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition,
            AtomicBoolean isNeedDepcies, Collection<SQLAction> alterActions) {
        MsColumn newColumn = (MsColumn) newCondition;

        // recreate column to change identity or computed value
        if (!Objects.equals(newColumn.getSeed(), getSeed())
                || !Objects.equals(newColumn.getIncrement(), getIncrement())
                || !Objects.equals(newColumn.getExpression(), getExpression())) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }

        boolean isNeedDropDefault = !Objects.equals(getType(), newColumn.getType())
                && (!Objects.equals(getDefaultValue(), newColumn.getDefaultValue())
                        || !Objects.equals(getDefaultName(), newColumn.getDefaultName()));

        if (isNeedDropDefault) {
            compareDefaults(getDefaultName(), getDefaultValue(), null, null, alterActions);
        }

        compareTypes(newColumn, isNeedDepcies, alterActions);

        String oldDefaultName = isNeedDropDefault ? null : getDefaultName();
        String oldDefault = isNeedDropDefault ? null : getDefaultValue();
        compareDefaults(oldDefaultName, oldDefault, newColumn.getDefaultName(),
                newColumn.getDefaultValue(), alterActions);

        compareNullValues(newColumn, isNeedDepcies, alterActions);
        compareMaskingFunctions(newColumn, alterActions);

        compareOption(isNotForRep(), newColumn.isNotForRep(), "NOT FOR REPLICATION", alterActions);
        compareOption(isSparse(), newColumn.isSparse(), "SPARSE", isNeedDepcies, alterActions);
        compareOption(isRowGuidCol(), newColumn.isRowGuidCol(), "ROWGUIDCOL", alterActions);
        compareOption(isPersisted(), newColumn.isPersisted(), "PERSISTED", isNeedDepcies, alterActions);

        alterPrivileges(newColumn, alterActions);

        return getObjectState(alterActions);
    }

    private void compareDefaults(String oldDefaultName, String oldDefault,
            String newDefaultName, String newDefault, Collection<SQLAction> alterActions) {
        if (Objects.equals(oldDefault, newDefault) && Objects.equals(oldDefaultName, newDefaultName)) {
            return;
        }

        if (oldDefault != null) {
            SQLAction sql = new SQLAction();
            sql.append(getAlterTable(false));
            sql.append("\n\tDROP CONSTRAINT ").append(MsDiffUtils.quoteName(oldDefaultName));
            alterActions.add(sql);
        }

        if (newDefault != null) {
            SQLAction sql = new SQLAction();
            sql.append(getAlterTable(false));
            sql.append("\n\tADD");
            if (newDefaultName != null) {
                sql.append(" CONSTRAINT ").append(MsDiffUtils.quoteName(newDefaultName));
            }
            sql.append(" DEFAULT ").append(newDefault);
            sql.append(" FOR ").append(MsDiffUtils.quoteName(name));
            alterActions.add(sql);
        }
    }

    private void compareTypes(MsColumn newColumn, AtomicBoolean isNeedDepcies, Collection<SQLAction> sqlActions) {
        String newCollation = newColumn.getCollation();
        if (!Objects.equals(getType(), newColumn.getType())
                || !Objects.equals(newCollation, getCollation())) {
            isNeedDepcies.set(true);
            StringBuilder sb = new StringBuilder();
            sb.append(getAlterColumn(false, newColumn.getName()))
            .append(' ').append(newColumn.getType());

            if (newCollation != null) {
                sb.append(COLLATE).append(newCollation);
            }

            if (getNullValue() == newColumn.getNullValue()) {
                sb.append(newColumn.getNullValue() ? NULL : NOT_NULL);
            }
            sqlActions.add(new SQLAction(sb));
        }
    }

    private void compareNullValues(MsColumn newColumn, AtomicBoolean isNeedDepcies, Collection<SQLAction> sqlActions) {
        if (newColumn.getNullValue() != getNullValue()) {
            if (newColumn.getDefaultValue() != null && getNullValue() && !newColumn.getNullValue()) {
                sqlActions.add(new SQLAction(getUpdateSql()));
            }
            StringBuilder sb = new StringBuilder();
            sb.append(getAlterColumn(false, newColumn.getName()))
            .append(' ').append(newColumn.getType());

            if (newColumn.getCollation() != null) {
                sb.append(COLLATE).append(newColumn.getCollation());
            }

            sb.append(newColumn.getNullValue() ? NULL : NOT_NULL);
            sqlActions.add(new SQLAction(sb));
            isNeedDepcies.set(true);
        }
    }

    private void compareMaskingFunctions(MsColumn newColumn, Collection<SQLAction> sqlActions) {
        if (!Objects.equals(newColumn.getMaskingFunction(), getMaskingFunction())) {
            StringBuilder sb = new StringBuilder();
            sb.append(getAlterColumn(false, newColumn.getName()));
            if (newColumn.getMaskingFunction() != null) {
                sb.append(" ADD MASKED WITH (FUNCTION = ").append(newColumn.getMaskingFunction()).append(")");
            } else {
                sb.append(" DROP MASKED");
            }
            sqlActions.add(new SQLAction(sb));
        }
    }

    private StringBuilder getUpdateSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ").append(getParent().getQualifiedName())
        .append("\n\tSET ").append(MsDiffUtils.quoteName(name))
        .append(" = DEFAULT WHERE ")
        .append(MsDiffUtils.quoteName(name)).append(" IS").append(NULL);
        return sb;
    }

    private String getAlterColumn(boolean only, String column) {
        return ((AbstractTable) this.getParent()).getAlterTable(only) + ALTER_COLUMN + MsDiffUtils.quoteName(column);
    }

    @Override
    public void getDropSQL(Collection<SQLAction> dropActions, boolean optionExists) {
        final StringBuilder sbString = new StringBuilder();
        // we need to drop default
        compareDefaults(getDefaultName(), getDefaultValue(), null, null, dropActions);
        sbString.append(getAlterTable(false)).append("\n\tDROP COLUMN ");
        if (optionExists) {
            sbString.append(IF_EXISTS);
        }
        sbString.append(MsDiffUtils.quoteName(name));
        dropActions.add(new SQLAction(sbString));
    }

    public boolean isSparse() {
        return isSparse;
    }

    public void setSparse(final boolean isSparse) {
        this.isSparse = isSparse;
        resetHash();
    }

    public boolean isRowGuidCol() {
        return isRowGuidCol;
    }

    public void setRowGuidCol(final boolean isRowGuidCol) {
        this.isRowGuidCol = isRowGuidCol;
        resetHash();
    }

    public boolean isPersisted() {
        return isPersisted;
    }

    public void setPersisted(final boolean isPersisted) {
        this.isPersisted = isPersisted;
        resetHash();
    }

    public boolean isNotForRep() {
        return isNotForRep;
    }

    public void setNotForRep(final boolean isNotForRep) {
        this.isNotForRep = isNotForRep;
        resetHash();
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(final String defaultName) {
        this.defaultName = defaultName;
        resetHash();
    }

    public String getExpression() {
        return expession;
    }

    public void setExpression(final String expession) {
        this.expession = expession;
        resetHash();
    }

    public String getMaskingFunction() {
        return maskingFunction;
    }

    public void setMaskingFunction(final String maskingFunction) {
        this.maskingFunction = maskingFunction;
        resetHash();
    }

    public String getSeed() {
        return seed;
    }

    public String getIncrement() {
        return increment;
    }

    public boolean isIdentity() {
        return isIdentity;
    }

    public void setIdentity(String seed, String increment) {
        this.seed = seed;
        this.increment = increment;
        this.isIdentity = true;
        resetHash();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsColumn col && super.compare(obj)) {
            return isSparse == col.isSparse()
                    && isRowGuidCol ==  col.isRowGuidCol()
                    && isPersisted == col.isPersisted()
                    && isNotForRep == col.isNotForRep()
                    && isIdentity == col.isIdentity()
                    && Objects.equals(seed, col.getSeed())
                    && Objects.equals(increment, col.getIncrement())
                    && Objects.equals(defaultName, col.getDefaultName())
                    && Objects.equals(expession, col.getExpression())
                    && Objects.equals(maskingFunction, col.getMaskingFunction());
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(isSparse);
        hasher.put(isRowGuidCol);
        hasher.put(isPersisted);
        hasher.put(isNotForRep);
        hasher.put(isIdentity);
        hasher.put(seed);
        hasher.put(increment);
        hasher.put(defaultName);
        hasher.put(expession);
        hasher.put(maskingFunction);
    }

    @Override
    protected AbstractColumn getColumnCopy() {
        MsColumn copy = new MsColumn(getName());
        copy.setSparse(isSparse());
        copy.setRowGuidCol(isRowGuidCol());
        copy.setPersisted(isPersisted());
        copy.setNotForRep(isNotForRep());
        copy.isIdentity = isIdentity();
        copy.seed = getSeed();
        copy.increment = getIncrement();
        copy.setDefaultName(getDefaultName());
        copy.setExpression(getExpression());
        copy.setMaskingFunction(getMaskingFunction());
        return copy;
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }
}
