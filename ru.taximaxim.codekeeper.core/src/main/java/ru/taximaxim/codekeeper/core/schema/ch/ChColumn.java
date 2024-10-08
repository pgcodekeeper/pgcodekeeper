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
    public String getCreationSQL() {
        var sb = new StringBuilder();
        sb.append(getAlterTable(false, false)).append("\n\tADD COLUMN ");
        appendIfNotExists(sb);
        sb.append(ChDiffUtils.quoteName(name));

        if (getType() != null) {
            sb.append(' ').append(getType());
        }
        appendColumnOptions(sb);
        sb.append(getSeparator());
        return sb.toString();
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
    public ObjectState appendAlterSQL(PgStatement newCondition, StringBuilder sb, AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        ChColumn newColumn = (ChColumn) newCondition;

        compareTypes(sb, newColumn.getType());
        compareDefaults(sb, newColumn);
        compareCodecs(sb, newColumn.getCodecs());
        compareTtl(sb, newColumn.getTtl(), newColumn.getType());
        compareComment(sb, newColumn.getComment());
        return getObjectState(sb, startLength);
    }

    @Override
    public String getDropSQL(boolean optionExists) {
        final StringBuilder sb = new StringBuilder();
        sb.append(getAlterTable(false, false)).append("\n\tDROP COLUMN ");
        if (optionExists) {
            sb.append(IF_EXISTS);
        }
        sb.append(ChDiffUtils.quoteName(name)).append(getSeparator());
        return sb.toString();
    }

    private void compareTypes(StringBuilder sb, String newType) {
        if (getType().equals(newType)) {
            return;
        }
        appendAlterColumn(sb, true);
        sb.append(' ').append(newType).append(getSeparator());
    }

    private void compareDefaults(StringBuilder sb, ChColumn newColumn) {
        if (Objects.equals(defaultType, newColumn.getDefaultType())
                && Objects.equals(getDefaultValue(), newColumn.getDefaultValue())) {
            return;
        }
        appendAlterColumn(sb, true);
        if (newColumn.getDefaultType() != null) {
            sb.append(' ').append(newColumn.getDefaultType()).append(' ').append(newColumn.getDefaultValue());
        } else if ("EPHEMERAL".equals(defaultType)) {
            // because we can't drop EPHEMERAL default type
            sb.append(" DEFAULT ").append("0").append(getSeparator());
            appendAlterColumn(sb, true);
            sb.append(" REMOVE").append(" DEFAULT ");
        } else {
            sb.append(" REMOVE ").append(defaultType);
        }
        sb.append(getSeparator());
    }

    private void compareCodecs(StringBuilder sb, List<String> newCodecs) {
        if (Objects.equals(codecs, newCodecs)) {
            return;
        }
        appendAlterColumn(sb, true);
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
        sb.append(getSeparator());
    }

    private void compareTtl(StringBuilder sb, String newTtl, String newType) {
        if (Objects.equals(ttl, newTtl)) {
            return;
        }
        appendAlterColumn(sb, true);
        if (newTtl == null) {
            sb.append(" REMOVE TTL");
        } else {
            sb.append(' ').append(newType).append(" TTL ").append(newTtl);
        }
        sb.append(getSeparator());
    }

    private void compareComment(StringBuilder sb, String newComment) {
        if (Objects.equals(getComment(), newComment)) {
            return;
        }
        sb.append(getAlterTable(true, false));
        if (newComment == null) {
            sb.append(" MODIFY COLUMN ").append(ChDiffUtils.quoteName(name)).append(" REMOVE COMMENT");
        } else {
            sb.append(" COMMENT COLUMN ");
            appendIfExists(sb);
            sb.append(ChDiffUtils.quoteName(name)).append(' ').append(newComment);
        }
        sb.append(getSeparator());
    }

    private void appendAlterColumn(StringBuilder sb, boolean nextLine) {
        sb.append(getAlterTable(nextLine, false)).append(" MODIFY COLUMN ");
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
        if (!(obj instanceof ChColumn)) {
            return false;
        }
        var column = (ChColumn) obj;
        return super.compare(column)
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
    public void appendComments(StringBuilder sb) {
        // no impl
    }

    @Override
    protected void appendCommentSql(StringBuilder sb) {
        // no impl
    }
}
