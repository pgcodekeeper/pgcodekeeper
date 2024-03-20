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

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.IOptionContainer;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class ChTable extends AbstractTable {

    private String engineType;
    private String engineBody;
    /**
     * key - name, value - expression(select_stmt)
     */
    private final Map<String, String> projections = new LinkedHashMap<>();

    private String partExpr;
    private String pkExpr;
    private String orderExpr;
    private String sampleBy;
    // TODO with action, where or group by, maybe better someway split it and save
    // where and group by part separate. maybe Map<String, String> with keys: name,
    // expr, where, group by and etc. but we can have more then one expr with all
    // options. append counter for keys?
    private String ttlExpr;

    public ChTable(String name) {
        super(name);
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
        resetHash();
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineBody(String engineBody) {
        this.engineBody = engineBody;
        resetHash();
    }

    public String getEngineBody() {
        return engineBody;
    }

    public void addProjection(String key, String expression) {
        projections.put(key, expression);
        resetHash();
    }

    public Map<String, String> getProjections() {
        return Collections.unmodifiableMap(projections);
    }

    public void setPartExpr(String partExpr) {
        this.partExpr = partExpr;
        resetHash();
    }

    public String getPartExpr() {
        return partExpr;
    }

    public void setPkExpr(String pkExpr) {
        this.pkExpr = pkExpr;
        resetHash();
    }

    public String getPkExpr() {
        return pkExpr;
    }

    public void setOrderExpr(String orderExpr) {
        this.orderExpr = orderExpr;
        resetHash();
    }

    public String getOrderExpr() {
        return orderExpr;
    }

    public void setSampleBy(String sampleBy) {
        this.sampleBy = sampleBy;
        resetHash();
    }

    public String getSampleBy() {
        return sampleBy;
    }

    public void setTtlExpr(String ttlExpr) {
        this.ttlExpr = ttlExpr;
        resetHash();
    }

    public String getTtlExpr() {
        return ttlExpr;
    }

    public Set<String> getOptionsKey() {
        return Collections.unmodifiableSet(options.keySet());
    }

    @Override
    public void compareOptions(IOptionContainer newContainer, StringBuilder sb) {
        // TODO Auto-generated method stub
    }

    @Override
    public String getAlterTable(boolean nextLine, boolean only) {
        final StringBuilder sb = new StringBuilder();
        if (nextLine) {
            sb.append("\n\n");
        }
        sb.append("ALTER TABLE ");
        sb.append(getQualifiedName());
        return sb.toString();
    }

    @Override
    protected boolean isNeedRecreate(AbstractTable newTable) {
        var newChTable = (ChTable) newTable;
        return !Objects.equals(pkExpr, newChTable.getPkExpr())
                || !Objects.equals(orderExpr, newChTable.getOrderExpr())
                || !Objects.equals(engineType, newChTable.getEngineType())
                || !Objects.equals(engineBody, newChTable.getEngineBody())
                // TODO remove it when it will be done
                || !Objects.equals(partExpr, newChTable.getPartExpr());
    }

    @Override
    protected AbstractTable getTableCopy() {
        var table = new ChTable(name);
        table.setEngineType(engineType);
        table.setEngineBody(engineBody);
        table.projections.putAll(projections);
        table.setPartExpr(partExpr);
        table.setPkExpr(pkExpr);
        table.setOrderExpr(orderExpr);
        table.setSampleBy(sampleBy);
        table.setTtlExpr(ttlExpr);
        return table;
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ").append(getQualifiedName()).append("\n(");

        for (AbstractColumn column : columns) {
            sb.append("\n\t").append(column.getFullDefinition()).append(",");
        }

        for (Entry<String, String> proj : projections.entrySet()) {
            sb.append("\n\tPROJECTION ").append(proj.getKey()).append(' ').append(proj.getValue()).append(',');
        }

        if (!columns.isEmpty() || !projections.isEmpty()) {
            sb.setLength(sb.length() - 1);
        }
        sb.append("\n)");

        sb.append("\nENGINE = ").append(engineType);
        if (engineBody != null) {
            sb.append(" (").append(engineBody).append(')');
        }

        if (partExpr != null) {
            sb.append("\nPARTITION BY ").append(partExpr);
        }
        if (pkExpr != null) {
            sb.append("\nPRIMARY KEY ").append(pkExpr);
        }
        if (orderExpr != null) {
            sb.append("\nORDER BY ").append(orderExpr);
        }
        if (sampleBy != null) {
            sb.append("\nSAMPLE BY ").append(sampleBy);
        }
        if (ttlExpr != null) {
            sb.append("\nTTL ").append(ttlExpr);
        }

        // it's must be every time? is important order by?
        if (!options.isEmpty()) {
            sb.append("\nSETTINGS ");
            // in DB stored not like Map. settings can be duplicate. example in table `primary`
            for (var option : options.entrySet()) {
                // in db stored in one line
                sb.append(option.getKey()).append(" = ").append(option.getValue()).append(",\n\t");
            }
            sb.setLength(sb.length() - 3);
        }

        if (getComment() != null) {
            sb.append("\nCOMMENT ").append(getComment());
        }
        sb.append(getSeparator());

        return sb.toString();
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb, AtomicBoolean isNeedDepcies) {
        final int startLengtt = sb.length();
        ChTable newTable = (ChTable) newCondition;

        if (isRecreated(newTable)) {
            isNeedDepcies.set(true);
            return true;
        }

        comparePojections(sb, newTable.getProjections());
        compareSampleBy(sb, newTable.getSampleBy(), isNeedDepcies);
        if (isNeedDepcies.get()) {
            return true;
        }
        compareTtl(sb, newTable.getTtlExpr());
        compareOptions(sb, newTable.getOptions());
        compareComment(sb, newTable.getComment());
        return sb.length() > startLengtt;
    }

    private void comparePojections(StringBuilder sb, Map<String, String> newProjections) {
        if (Objects.equals(projections, newProjections)) {
            return;
        }
        Set<String> toDrops = new HashSet<>();
        Map<String, String> toAdds = new HashMap<>();

        String newValue;

        for (String oldKey : projections.keySet()) {
            if (!newProjections.containsKey(oldKey)) {
                toDrops.add(oldKey);
                continue;
            }
            newValue = newProjections.get(oldKey);
            if (!Objects.equals(newValue, projections.get(oldKey))) {
                toDrops.add(oldKey);
                toAdds.put(oldKey, newValue);
            }
        }

        for (String newKey : newProjections.keySet()) {
            if (!projections.containsKey(newKey)) {
                toAdds.put(newKey, newProjections.get(newKey));
            }
        }

        appendAlterProjections(sb, toDrops, toAdds);
    }

    private void appendAlterProjections(StringBuilder sb, Set<String> toDrops, Map<String, String> toAdds) {
        for (String toDrop : toDrops) {
            sb.append(getAlterTable(true, false)).append("\n\tDROP PROJECTION IF EXISTS ").append(toDrop)
                    .append(getSeparator());
        }
        for (Entry<String, String> toAdd : toAdds.entrySet()) {
            sb.append(getAlterTable(true, false)).append("\n\tADD PROJECTION ");
            appendIfNotExists(sb);
            sb.append(toAdd.getKey()).append(' ').append(toAdd.getValue()).append(getSeparator());
        }
    }

    private void compareSampleBy(StringBuilder sb, String newSampleBy, AtomicBoolean isNeedDepcies) {
        if (Objects.equals(sampleBy, newSampleBy)) {
            return;
        }
        if (newSampleBy == null) {
            sb.append(getAlterTable(true, false));
            sb.append("\n\tREMOVE SAMPLE BY");
        } else if (sampleBy == null) {
            sb.append(getAlterTable(true, false));
            sb.append("\n\tMODIFY SAMPLE BY ").append(newSampleBy);
        } else {
            isNeedDepcies.set(true);
            return;
        }
        sb.append(getSeparator());
    }

    private void compareTtl(StringBuilder sb, String newTtlExpr) {
        if (Objects.equals(ttlExpr, newTtlExpr)) {
            return;
        }
        sb.append(getAlterTable(true, false));
        if (newTtlExpr == null) {
            sb.append("\n\tREMOVE TTL");
        } else {
            sb.append("\n\tMODIFY TTL ").append(newTtlExpr);
        }
        sb.append(getSeparator());
    }

    private void compareOptions(StringBuilder sb, Map<String, String> newOptions) {
        if (options.equals(newOptions)) {
            return;
        }
        
        Set<String> resetOptions = new HashSet<>();
        Map<String, String> modifyOptions = new HashMap<>();
        
        String newValue;
        for (String option : options.keySet()) {
            // added to reset if in new condition havn't this option
            if (!newOptions.containsKey(option)) {
                resetOptions.add(option);
                continue;
            }

            // add to modify if options have different values
            newValue = newOptions.get(option);
            if (!Objects.equals(newValue, options.get(option))) {
                modifyOptions.put(option, newValue);
            }
        }

        // add to modify if old condition havn't this option
        for (String key : newOptions.keySet()) {
            if (!getOptions().containsKey(key)) {
                modifyOptions.put(key, newOptions.get(key));
            }
        }

        appendAlterOptions(sb, resetOptions, modifyOptions);
    }

    private void appendAlterOptions(StringBuilder sb, Set<String> resetOptions, Map<String, String> modifyOptions) {
        if (!resetOptions.isEmpty()) {
            sb.append(getAlterTable(true, false))
              .append("\n\tRESET SETTING");
            for(String key : resetOptions) {
                sb.append(' ').append(key).append(',');
            }
            sb.setLength(sb.length() - 1);
            sb.append(getSeparator());
        }
        
        if (modifyOptions.isEmpty()) {
            return;
        }
        
        sb.append(getAlterTable(true, false))
          .append("\n\tMODIFY SETTING");
        for (Entry<String, String> option : modifyOptions.entrySet()) {
            sb.append(' ').append(option.getKey()).append('=').append(option.getValue()).append(',');
        }
        sb.setLength(sb.length() - 1);
        sb.append(getSeparator());
    }

    private void compareComment(StringBuilder sb, String newComment) {
        if (Objects.equals(getComment(), newComment)) {
            return;
        }
        sb.append(getAlterTable(true, false)).append("\n\tMODIFY COMMENT ");
        if (newComment == null) {
            sb.append("''");
        } else {
            sb.append(newComment);
        }
        sb.append(getSeparator());
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChTable)) {
            return false;
        }
        var table = (ChTable) obj;
        return super.compare(table)
                && Objects.equals(engineType, table.getEngineType())
                && Objects.equals(engineBody, table.getEngineBody())
                && Objects.equals(projections, table.projections)
                && Objects.equals(partExpr, table.getPartExpr())
                && Objects.equals(pkExpr, table.getPkExpr())
                && Objects.equals(orderExpr, table.getOrderExpr())
                && Objects.equals(sampleBy, table.getSampleBy())
                && Objects.equals(ttlExpr, table.getTtlExpr());
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(engineType);
        hasher.put(engineBody);
        hasher.put(projections);
        hasher.put(partExpr);
        hasher.put(pkExpr);
        hasher.put(orderExpr);
        hasher.put(sampleBy);
        hasher.put(ttlExpr);
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.CH;
    }

    @Override
    public void appendComments(StringBuilder sb) {
        // no impl
    }

    @Override
    protected void appendCommentSql(StringBuilder sb) {
        // no impl
    }
}
