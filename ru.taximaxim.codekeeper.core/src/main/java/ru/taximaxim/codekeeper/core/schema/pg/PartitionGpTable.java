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

package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public class PartitionGpTable extends AbstractRegularTable {

    private String partitionGpBounds;
    private String normalizedPartitionGpBounds;
    private final Map<String, PartitionTemplateContainer> templates = new HashMap<>();

    public PartitionGpTable(String name) {
        super(name);
    }

    public void setPartitionGpBound(String partitionGpBounds, String normalizedPartitionGpBounds) {
        this.partitionGpBounds = partitionGpBounds;
        this.normalizedPartitionGpBounds = normalizedPartitionGpBounds;
        resetHash();
    }

    public void addTemplate(PartitionTemplateContainer template) {
        this.templates.put(template.getPartitionName(), template);
        resetHash();
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, SQLScript script) {
        sbSQL.append(" (\n");

        int start = sbSQL.length();
        for (AbstractColumn column : columns) {
            writeColumn((PgColumn) column, sbSQL, script);
        }

        if (start != sbSQL.length()) {
            sbSQL.setLength(sbSQL.length() - 2);
            sbSQL.append('\n');
        }

        sbSQL.append(')');
    }

    @Override
    protected boolean isNeedRecreate(AbstractTable newTable) {
        return super.isNeedRecreate(newTable) || !this.getClass().equals(newTable.getClass());
    }

    public String getPartitionGpBounds() {
        return partitionGpBounds;
    }

    public Collection<PartitionTemplateContainer> getTemplates() {
        return Collections.unmodifiableCollection(templates.values());
    }

    /**
     * @return query string with whitespace normalized.
     * @see AntlrUtils#normalizeWhitespaceUnquoted
     */
    public String getNormalizedPartitionGpBounds() {
        return normalizedPartitionGpBounds;
    }

    @Override
    protected void convertTable(SQLScript script) {
        // available in 7 version
    }

    @Override
    protected void appendOptions(StringBuilder sbSQL) {
        super.appendOptions(sbSQL);
        sbSQL.append("\n").append(partitionGpBounds);
    }

    @Override
    protected void appendAlterOptions(SQLScript script) {
        super.appendAlterOptions(script);
        for (var template : templates.values()) {
            StringBuilder sql = new StringBuilder();
            sql.append(getAlterTable(false));
            template.appendCreateSQL(sql);
            script.addStatement(sql);
        }
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PartitionGpTable table && super.compare(obj)) {
            return Objects.equals(normalizedPartitionGpBounds, table.getNormalizedPartitionGpBounds())
                    && Objects.equals(templates, table.templates);
        }
        return false;
    }

    @Override
    protected void compareTableOptions(AbstractPgTable newTable, SQLScript script) {
        super.compareTableOptions(newTable, script);

        PartitionGpTable newPartGptable = (PartitionGpTable) newTable;
        if (!Objects.equals(normalizedPartitionGpBounds, newPartGptable.getNormalizedPartitionGpBounds())) {
            script.addStatement("\n --The PARTTITION clause have differences. Add ALTER statement manually");
        }
        compareTemplates(newPartGptable, script);
    }

    private void compareTemplates(PartitionGpTable newTable, SQLScript script) {
        if (Objects.equals(templates, newTable.templates)) {
            return;
        }

        templates.forEach((key, value) -> {
            PartitionTemplateContainer newValue = newTable.templates.get(key);
            StringBuilder sql;
            if (newValue == null) {
                sql = new StringBuilder();
                sql.append(getAlterTable(false));
                value.appendDropSql(sql);
                script.addStatement(sql);
            } else if (!value.equals(newValue)) {
                sql = new StringBuilder();
                sql.append(getAlterTable(false));
                newValue.appendCreateSQL(sql);
                script.addStatement(sql);
            }
        });

        newTable.templates.forEach((key, value) -> {
            if (!templates.containsKey(key)) {
                StringBuilder sql = new StringBuilder();
                sql.append(getAlterTable(false));
                value.appendCreateSQL(sql);
                script.addStatement(sql);
            }
        });
    }

    @Override
    protected void compareTableTypes(AbstractPgTable newTable, SQLScript script) {
        // no implements
    }

    @Override
    protected AbstractTable getTableCopy() {
        return new PartitionGpTable(name);
    }

    @Override
    public AbstractTable shallowCopy() {
        PartitionGpTable copy = (PartitionGpTable) super.shallowCopy();
        copy.templates.putAll(templates);
        copy.setPartitionGpBound(partitionGpBounds, normalizedPartitionGpBounds);
        return copy;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.putUnordered(templates);
        hasher.put(normalizedPartitionGpBounds);
    }
}
