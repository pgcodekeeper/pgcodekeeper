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
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema.pg;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Stream;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractView;
import ru.taximaxim.codekeeper.core.schema.ISimpleOptionContainer;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.PgStatementContainer;
import ru.taximaxim.codekeeper.core.script.SQLScript;
import ru.taximaxim.codekeeper.core.settings.ISettings;
import ru.taximaxim.codekeeper.core.utils.Pair;

/**
 * Stores view information.
 *
 * @author fordfrog
 */
public abstract class AbstractPgView extends AbstractView implements ISimpleOptionContainer {

    private static final String COLUMN_COMMENT = "COMMENT ON COLUMN {0}.{1} IS {2}";
    public static final String CHECK_OPTION = "check_option";
    protected static final String ALTER_COLUMN = " ALTER COLUMN ";

    protected String query;
    protected final Map<String, String> options = new LinkedHashMap<>();

    private String normalizedQuery;
    private final Map<String, String> columnComments = new LinkedHashMap<>();
    private final List<String> columnNames = new ArrayList<>();

    protected AbstractPgView(String name) {
        super(name);
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder(query.length() * 2);

        sbSQL.append("CREATE ").append(getTypeName()).append(' ');
        appendIfNotExists(sbSQL, script.getSettings());
        sbSQL.append(getQualifiedName());
        appendColumnNames(sbSQL);
        appendOptions(sbSQL);

        script.addStatement(sbSQL);
        appendOwnerSQL(script);
        appendPrivileges(script);
        appendDefaultValues(script);
        appendComments(script);
    }

    @Override
    public void appendComments(SQLScript script) {
        super.appendComments(script);
        appendChildrenComments(script);
    }

    protected void appendOptions(StringBuilder sbSQL) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : options.entrySet()) {
            if (!CHECK_OPTION.equals(entry.getKey())) {
                sb.append(entry.getKey());
                if (!entry.getValue().isEmpty()) {
                    sb.append("=").append(entry.getValue());
                }
                sb.append(", ");
            }
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
            sbSQL.append("\nWITH (").append(sb).append(")");
        }
    }

    protected void appendDefaultValues(SQLScript script) {
        // noimpl
    }

    private void appendChildrenComments(SQLScript script) {
        for (final Entry<String, String> columnComment : columnComments.entrySet()) {
            script.addCommentStatement(MessageFormat.format(COLUMN_COMMENT, getQualifiedName(),
                    PgDiffUtils.getQuotedName(columnComment.getKey()), columnComment.getValue()));
        }
    }

    protected void appendColumnNames(final StringBuilder sbSQL) {
        if (columnNames.isEmpty()) {
            return;
        }

        sbSQL.append(" (");
        for (String columnName : columnNames) {
            sbSQL.append(PgDiffUtils.getQuotedName(columnName)).append(", ");
        }
        sbSQL.setLength(sbSQL.length() - 2);
        sbSQL.append(')');
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        AbstractPgView newAbstractView = (AbstractPgView) newCondition;
        if (needDrop(newAbstractView)) {
            return ObjectState.RECREATE;
        }

        int startSize = script.getSize();
        alterViewOptions(script, newAbstractView);

        appendAlterOwner(newAbstractView, script);
        alterPrivileges(newAbstractView, script);
        compareOptions(newAbstractView, script);
        appendAlterComments(newAbstractView, script);

        return getObjectState(script, startSize);
    }

    protected abstract void alterViewOptions(SQLScript script, AbstractPgView newAbstractView);

    @Override
    public void appendAlterComments(PgStatement newObj, SQLScript script) {
        AbstractPgView newView = (AbstractPgView) newObj;
        super.appendAlterComments(newView, script);
        appendAlterChildrenComments(newObj, script);
    }

    private void appendAlterChildrenComments(PgStatement newObj, SQLScript script) {
        AbstractPgView newView = (AbstractPgView) newObj;
        for (final Entry<String, String> newColumnComment : newView.columnComments.entrySet()) {
            String newColumn = newColumnComment.getKey();
            String newValue = newColumnComment.getValue();

            String oldValue = columnComments.get(newColumn);
            if (!Objects.equals(oldValue, newValue)) {
                script.addCommentStatement(MessageFormat.format(COLUMN_COMMENT, getQualifiedName(),
                        PgDiffUtils.getQuotedName(newColumn), newValue));
            }
        }

        for (final Entry<String, String> columnComment : columnComments.entrySet()) {
            String oldColumn = columnComment.getKey();

            if (!newView.columnComments.containsKey(oldColumn)) {
                script.addCommentStatement(MessageFormat.format(COLUMN_COMMENT, getQualifiedName(),
                        PgDiffUtils.getQuotedName(oldColumn), "NULL"));
            }
        }
    }

    @Override
    public boolean canDropBeforeCreate() {
        return true;
    }

    /**
     * Returns true if either column names or query of the view has been
     * modified.
     *
     * @param newView new view
     *
     * @return true if view has been modified, otherwise false
     */
    protected boolean needDrop(final AbstractPgView newView) {
        if (getClass() != newView.getClass()) {
            return true;
        }

        List<String> oldColumnNames = columnNames;
        List<String> newColumnNames = newView.columnNames;

        if (oldColumnNames.isEmpty() && newColumnNames.isEmpty()) {
            return !normalizedQuery.equals(newView.normalizedQuery);
        }

        return !oldColumnNames.equals(newColumnNames);
    }

    public void addColumnName(String colName) {
        columnNames.add(colName);
        resetHash();
    }

    public void setQuery(final String query, final String normalizedQuery) {
        this.query = query;
        this.normalizedQuery = normalizedQuery;
        resetHash();
    }

    @Override
    public Map<String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    @Override
    public void addOption(String option, String value) {
        options.put(option, value);
        resetHash();
    }

    public void addColumnComment(ISettings settings, String columnName, String comment) {
        if (comment == null || comment.isEmpty()) {
            return;
        }

        columnComments.put(columnName, settings.isKeepNewlines() ? comment : comment.replace("\r", ""));
        resetHash();
    }

    @Override
    public Stream<Pair<String, String>> getRelationColumns() {
        return null;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof AbstractPgView view && super.compare(obj)) {
            return Objects.equals(normalizedQuery, view.normalizedQuery)
                    && columnNames.equals(view.columnNames)
                    && columnComments.equals(view.columnComments)
                    && options.equals(view.options);
        }

        return false;
    }

    @Override
    protected PgStatementContainer getCopy() {
        AbstractPgView view = (AbstractPgView) super.getCopy();
        view.query = query;
        view.normalizedQuery = normalizedQuery;
        view.columnNames.addAll(columnNames);
        view.columnComments.putAll(columnComments);
        view.options.putAll(options);
        return view;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(columnNames);
        hasher.put(normalizedQuery);
        hasher.put(columnComments);
        hasher.put(options);
    }
}