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
package ru.taximaxim.codekeeper.core.schema.ch;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.ChDiffUtils;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class ChColumn extends AbstractColumn {

    private String defaultType;

    private String ttl;
    private final List<String> codecs = new ArrayList<>();
    private String option;

    public ChColumn(String name) {
        super(name);
    }

    public void setDefaultType(String defaultType) {
        this.defaultType = defaultType;
        resetHash();
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
        resetHash();
    }

    public void addCodec(String codec) {
        codecs.add(codec);
        resetHash();
    }

    public void setOption(String option) {
        this.option = option;
        resetHash();
    }

    @Override
    public String getFullDefinition() {
        var sb = new StringBuilder();
        sb.append(ChDiffUtils.quoteName(name));

        if (type != null) {
            sb.append(' ').append(type);
            if (!nullValue) {
                sb.append(" NOT NULL");
            }
        }
        appendColumnOptions(sb);
        return sb.toString();
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        var sb = new StringBuilder();
        sb.append(getAlterTable(false)).append("\n\tADD COLUMN ");
        appendIfNotExists(sb);
        sb.append(ChDiffUtils.quoteName(name));

        if (type != null) {
            sb.append(' ').append(type);
        }
        appendColumnOptions(sb);
        script.addStatement(sb);
    }

    private void appendColumnOptions(StringBuilder sb) {
        if (defaultType != null) {
            sb.append(' ').append(defaultType);
            if (defaultValue != null) {
                sb.append(' ').append(defaultValue);
            }
        }

        if (option != null) {
            sb.append(' ').append(option);
            return;
        }

        if (comment != null) {
            sb.append(" COMMENT ").append(comment);
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
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        ChColumn newColumn = (ChColumn) newCondition;

        compareTypes(newColumn.type, script);
        compareDefaults(newColumn, script);
        compareCodecs(newColumn.codecs, script);
        compareTtl(newColumn.ttl, newColumn.type, script);
        compareComment(newColumn.comment, script);
        return getObjectState(script, startSize);
    }

    @Override
    public void getDropSQL(SQLScript script, boolean optionExists) {
        StringBuilder sb = new StringBuilder();
        sb.append(getAlterTable(false)).append("\n\tDROP COLUMN ");
        if (optionExists) {
            sb.append(IF_EXISTS);
        }
        sb.append(ChDiffUtils.quoteName(name));
        script.addStatement(sb);
    }

    private void compareTypes(String newType, SQLScript script) {
        if (type.equals(newType)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        appendAlterColumn(sb);
        sb.append(' ').append(newType);
        script.addStatement(sb);
    }

    private void compareDefaults(ChColumn newColumn, SQLScript script) {
        if (Objects.equals(defaultType, newColumn.defaultType)
                && Objects.equals(defaultValue, newColumn.defaultValue)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        appendAlterColumn(sb);
        if (newColumn.defaultType != null) {
            sb.append(' ').append(newColumn.defaultType).append(' ').append(newColumn.defaultValue);
            script.addStatement(sb);
        } else if ("EPHEMERAL".equals(defaultType)) {
            // because we can't drop EPHEMERAL default type
            sb.append(" DEFAULT ").append("0");
            script.addStatement(sb);
            StringBuilder sbRemove = new StringBuilder();
            appendAlterColumn(sbRemove);
            sbRemove.append(" REMOVE").append(" DEFAULT");
            script.addStatement(sbRemove);
        } else {
            sb.append(" REMOVE ").append(defaultType);
            script.addStatement(sb);
        }
    }

    private void compareCodecs(List<String> newCodecs, SQLScript script) {
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
        script.addStatement(sb);
    }

    private void compareTtl(String newTtl, String newType, SQLScript script) {
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
        script.addStatement(sb);
    }

    private void compareComment(String newComment, SQLScript script) {
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
        script.addStatement(sb);
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
                && Objects.equals(defaultType, column.defaultType)
                && Objects.equals(option, column.option)
                && Objects.equals(ttl, column.ttl)
                && Objects.equals(codecs, column.codecs);
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
    public void appendComments(SQLScript script) {
        // no impl
    }

    @Override
    protected void appendCommentSql(SQLScript script) {
        // no impl
    }
}
