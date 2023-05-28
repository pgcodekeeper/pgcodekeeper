/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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

package ru.taximaxim.codekeeper.core.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;

public class PartitionGpTable extends AbstractRegularTable {

    private String partitionGpBounds;
    private String normalizedPartitionGpBounds;

    private List<String> templates = new ArrayList<>();
    private List<String> normalizedTemplates = new ArrayList<>();

    public PartitionGpTable(String name) {
        super(name);
    }

    public void setPartitionGpBound(String partitionGpBounds, String normalizedPartitionGpBounds) {
        this.partitionGpBounds = partitionGpBounds;
        this.normalizedPartitionGpBounds = normalizedPartitionGpBounds;
        resetHash();
    }

    public void addTemplate(String template, String normalizedTemplate) {
        this.templates.add(template);
        this.normalizedTemplates.add(normalizedTemplate);
        resetHash();
    }

    @Override
    protected void appendColumns(StringBuilder sbSQL, StringBuilder sbOption) {
        sbSQL.append(" (\n");

        int start = sbSQL.length();
        for (AbstractColumn column : columns) {
            writeColumn((PgColumn) column, sbSQL, sbOption);
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

    public List<String> getTemplates() {
        return Collections.unmodifiableList(templates);
    }
    /**
     * @return query string with whitespace normalized.
     * @see AntlrUtils#normalizeWhitespaceUnquoted
     */
    public String getNormalizedPartitionGpBounds() {
        return normalizedPartitionGpBounds;
    }

    public List<String> getNormalizedTemplates() {
        return Collections.unmodifiableList(normalizedTemplates);
    }

    @Override
    protected void convertTable(StringBuilder sb) {
        // available in 7 version
    }

    @Override
    protected void appendOptions(StringBuilder sbSQL) {
        super.appendOptions(sbSQL);
        sbSQL.setLength(sbSQL.length() - 1);
        sbSQL.append("\n").append(partitionGpBounds).append(";");
    }

    @Override
    protected void appendAlterOptions(StringBuilder sbSQL) {
        super.appendAlterOptions(sbSQL);
        for (String template : templates) {
            sbSQL.append(getAlterTable(true, false)).append("\n").append(template).append(";");
        }
    }

    @Override
    protected void compareTableTypes(AbstractPgTable newTable, StringBuilder sb) {
        // no implements
    }

    @Override
    protected AbstractTable getTableCopy() {
        return new PartitionGpTable(name);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PartitionGpTable && super.compare(obj)) {
            PartitionGpTable table = (PartitionGpTable) obj;
            return Objects.equals(normalizedPartitionGpBounds, table.getNormalizedPartitionGpBounds())
                    && Objects.equals(normalizedTemplates, table.getNormalizedTemplates());
        }
        return false;
    }


    @Override
    protected void compareTableOptions(AbstractPgTable newTable, StringBuilder sb) {
        super.compareTableOptions(newTable, sb);

        PartitionGpTable newPartGptable = (PartitionGpTable) newTable;
        if (!Objects.equals(normalizedPartitionGpBounds, newPartGptable.getNormalizedPartitionGpBounds())) {
            sb.append("\n --The PARTTITION clause have differences. Add ALTER statement manually");
        }
        if (!Objects.equals(normalizedTemplates, newPartGptable.getNormalizedTemplates())) {
            sb.append("\n --The ALTER TEMPLATE clause have differences. Add ALTER statement manually");
        }
    }

    @Override
    public AbstractTable shallowCopy() {
        PartitionGpTable copy = (PartitionGpTable) super.shallowCopy();
        copy.templates.addAll(templates);
        copy.normalizedTemplates.addAll(normalizedTemplates);
        copy.setPartitionGpBound(partitionGpBounds, normalizedPartitionGpBounds);
        return copy;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(normalizedTemplates);
        hasher.put(normalizedPartitionGpBounds);
    }
}
