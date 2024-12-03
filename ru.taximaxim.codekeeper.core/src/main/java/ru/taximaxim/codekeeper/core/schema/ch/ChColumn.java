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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.ChDiffUtils;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLAction;

public final class ChColumn extends AbstractColumn {

    private String defaultType;

    private String ttl;
    private final List<String> codecs = new ArrayList<>();
    private boolean isAutoIncremental;
    private String option;

    public ChColumn(String name) {
        super(name);
    }

    public void setDefaultType(String defaultType) {
        this.defaultType = defaultType;
        resetHash();
    }

    public String getDefaultType() {
        return defaultType;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
        resetHash();
    }

    public String getTtl() {
        return ttl;
    }

    public void addCodec(String codec) {
        codecs.add(codec);
        resetHash();
    }

    public List<String> getCodecs() {
        return Collections.unmodifiableList(codecs);
    }

    public void setAutoIncremental(boolean isAutoIncremental) {
        this.isAutoIncremental = isAutoIncremental;
        resetHash();
    }

    public boolean isAutoIncremental() {
        return isAutoIncremental;
    }

    public void setOption(String option) {
        this.option = option;
        resetHash();
    }

    public String getOption() {
        return option;
    }

    @Override
    public String getFullDefinition() {
        var sb = new StringBuilder();
        sb.append(ChDiffUtils.quoteName(name));

        if (getType() != null) {
            sb.append(' ').append(getType());
            if (!getNullValue()) {
                sb.append(" NOT NULL");
            }
        }
        appendColumnOptions(sb);
        return sb.toString();
    }

    @Override
    public void getCreationSQL(Collection<SQLAction> createActions) {
        var sb = new StringBuilder();
        sb.append(getAlterTable(false)).append("\n\tADD COLUMN ");
        appendIfNotExists(sb);
        sb.append(ChDiffUtils.quoteName(name));

        if (getType() != null) {
            sb.append(' ').append(getType());
        }
        appendColumnOptions(sb);
        createActions.add(new SQLAction(sb));
    }

    public void appendColumnOptions(StringBuilder sb) {
        if (defaultType != null) {
            sb.append(' ').append(defaultType);
            if (getDefaultValue() != null) {
                sb.append(' ').append(getDefaultValue());
            }
        }

        if (option != null) {
            sb.append(' ').append(option);
            return;
        }

        if (getComment() != null) {
            sb.append(" COMMENT ").append(getComment());
        }

        if (!codecs.isEmpty()) {
            sb.append(" CODEC(");
            for (var codec : codecs) {
                sb.append(codec).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append(')');
        }

        if (ttl != null) {
            sb.append(" TTL ").append(ttl);
        }
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, AtomicBoolean isNeedDepcies,
            Collection<SQLAction> alterActions) {

        ChColumn newColumn = (ChColumn) newCondition;

        compareTypes(newColumn.getType(), alterActions);
        compareDefaults(newColumn, alterActions);
        compareCodecs(newColumn.getCodecs(), alterActions);
        compareTtl(newColumn.getTtl(), newColumn.getType(), alterActions);
        compareComment(newColumn.getComment(), alterActions);
        return getObjectState(alterActions);
    }

    @Override
    public void getDropSQL(Collection<SQLAction> dropActions, boolean optionExists) {
        StringBuilder sb = new StringBuilder();
        sb.append(getAlterTable(false)).append("\n\tDROP COLUMN ");
        if (optionExists) {
            sb.append(IF_EXISTS);
        }
        sb.append(ChDiffUtils.quoteName(name));
        dropActions.add(new SQLAction(sb));
    }

    private void compareTypes(String newType, Collection<SQLAction> sqlActions) {
        if (getType().equals(newType)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        appendAlterColumn(sb);
        sb.append(' ').append(newType);
        sqlActions.add(new SQLAction(sb));
    }

    private void compareDefaults(ChColumn newColumn, Collection<SQLAction> sqlActions) {
        if (Objects.equals(defaultType, newColumn.getDefaultType())
                && Objects.equals(getDefaultValue(), newColumn.getDefaultValue())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        appendAlterColumn(sb);
        if (newColumn.getDefaultType() != null) {
            sb.append(' ').append(newColumn.getDefaultType()).append(' ').append(newColumn.getDefaultValue());
            sqlActions.add(new SQLAction(sb));
        } else if ("EPHEMERAL".equals(defaultType)) {
            // because we can't drop EPHEMERAL default type
            sb.append(" DEFAULT ").append("0");
            sqlActions.add(new SQLAction(sb));
            StringBuilder sbRemove = new StringBuilder();
            appendAlterColumn(sbRemove);
            sbRemove.append(" REMOVE").append(" DEFAULT");
            sqlActions.add(new SQLAction(sbRemove));
        } else {
            sb.append(" REMOVE ").append(defaultType);
            sqlActions.add(new SQLAction(sb));
        }
    }

    private void compareCodecs(List<String> newCodecs, Collection<SQLAction> sqlActions) {
        if (Objects.equals(codecs, newCodecs)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        appendAlterColumn(sb);
        if (newCodecs.isEmpty()) {
            sb.append(" REMOVE CODEC");
        } else {
            sb.append(" CODEC(");
            for (var codec : newCodecs) {
                sb.append(codec).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append(')');
        }
        sqlActions.add(new SQLAction(sb));
    }

    private void compareTtl(String newTtl, String newType, Collection<SQLAction> sqlActions) {
        if (Objects.equals(ttl, newTtl)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        appendAlterColumn(sb);
        if (newTtl == null) {
            sb.append(" REMOVE TTL");
        } else {
            sb.append(' ').append(newType).append(" TTL ").append(newTtl);
        }
        sqlActions.add(new SQLAction(sb));
    }

    private void compareComment(String newComment, Collection<SQLAction> sqlActions) {
        if (Objects.equals(getComment(), newComment)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getAlterTable(false));
        if (newComment == null) {
            sb.append(" MODIFY COLUMN ").append(ChDiffUtils.quoteName(name)).append(" REMOVE COMMENT");
        } else {
            sb.append(" COMMENT COLUMN ");
            appendIfExists(sb);
            sb.append(ChDiffUtils.quoteName(name)).append(' ').append(newComment);
        }
        sqlActions.add(new SQLAction(sb));
    }

    private void appendAlterColumn(StringBuilder sb) {
        sb.append(getAlterTable(false)).append(" MODIFY COLUMN ");
        appendIfExists(sb);
        sb.append(ChDiffUtils.quoteName(name));
    }

    private void appendIfExists(StringBuilder sb) {
        if (getDatabaseArguments().isGenerateExists()) {
            sb.append(IF_EXISTS);
        }
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.CH;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(defaultType);
        hasher.put(option);
        hasher.put(ttl);
        hasher.put(codecs);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        return obj instanceof ChColumn column && super.compare(column)
                && Objects.equals(defaultType, column.getDefaultType())
                && Objects.equals(option, column.getOption())
                && Objects.equals(ttl, column.getTtl())
                && Objects.equals(codecs, column.getCodecs());
    }

    @Override
    protected AbstractColumn getColumnCopy() {
        var column = new ChColumn(name);
        column.setDefaultType(defaultType);
        column.setOption(option);
        column.setTtl(ttl);
        column.codecs.addAll(codecs);
        return column;
    }

    @Override
    public void appendComments(Collection<SQLAction> sqlActions) {
        // no impl
    }

    @Override
    protected void appendCommentSql(Collection<SQLAction> sqlActions) {
        // no impl
    }
}
