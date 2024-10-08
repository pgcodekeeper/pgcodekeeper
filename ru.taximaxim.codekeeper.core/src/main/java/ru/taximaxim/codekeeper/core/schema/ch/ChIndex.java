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
package ru.taximaxim.codekeeper.core.schema.ch;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.ChDiffUtils;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractIndex;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class ChIndex extends AbstractIndex {

    private String expr;
    private String type;
    private int granVal = 1;

    public ChIndex(String name) {
        super(name);
    }

    public void setExpr(String expr) {
        this.expr = expr;
        resetHash();
    }

    public String getExpr() {
        return expr;
    }

    public void setType(String type) {
        this.type = type;
        resetHash();
    }

    public String getType() {
        return type;
    }

    public void setGranVal(int granVal) {
        this.granVal = granVal;
        resetHash();
    }

    public int getGranVal() {
        return granVal;
    }

    public String getDefinition() {
        final StringBuilder sb = new StringBuilder();
        sb.append("INDEX ").append(getName()).append(' ').append(expr)
        .append(" TYPE ").append(type);
        if (granVal != 1) {
            sb.append(" GRANULARITY ").append(granVal);
        }
        return sb.toString();
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getAlterTable(false, false)).append(" ADD ").append(getDefinition()).append(getSeparator());
        return sb.toString();
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, StringBuilder sb, AtomicBoolean isNeedDepcies) {
        var newIndex = (ChIndex) newCondition;
        if (!compareUnalterable(newIndex)) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }
        return ObjectState.NOTHING;
    }

    @Override
    public String getDropSQL(boolean optionExists) {
        final StringBuilder sb = new StringBuilder();
        sb.append(getAlterTable(false, false)).append("\n\tDROP INDEX ");
        if (optionExists) {
            sb.append(IF_EXISTS);
        }
        sb.append(ChDiffUtils.getQuotedName(getName())).append(getSeparator());
        return sb.toString();
    }

    private String getAlterTable(boolean nextLine, boolean only) {
        return ((AbstractTable) getParent()).getAlterTable(nextLine, only);
    }

    private boolean compareUnalterable(ChIndex newIndex) {
        return Objects.equals(expr, newIndex.getExpr())
                && Objects.equals(type, newIndex.getType())
                && granVal == newIndex.getGranVal();
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.CH;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(expr);
        hasher.put(type);
        hasher.put(granVal);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChIndex)) {
            return false;
        }
        var index = (ChIndex) obj;
        return super.compare(index) && compareUnalterable(index);
    }

    @Override
    protected AbstractIndex getIndexCopy() {
        var index = new ChIndex(name);
        index.setExpr(expr);
        index.setType(type);
        index.setGranVal(granVal);
        return index;
    }
}