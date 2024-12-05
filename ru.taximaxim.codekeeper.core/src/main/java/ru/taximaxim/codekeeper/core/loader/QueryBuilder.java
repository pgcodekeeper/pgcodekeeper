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
package ru.taximaxim.codekeeper.core.loader;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class QueryBuilder {

    private Map<String, String> withs = new LinkedHashMap<>();
    private List<String> columns = new ArrayList<>();
    private String from;
    private List<String> joins = new ArrayList<>();
    private List<String> wheres = new ArrayList<>();
    private List<String> groups = new ArrayList<>();
    private String postAction;

    public QueryBuilder column(String column) {
        columns.add(column);
        return this;
    }

    public QueryBuilder column(String prefix, QueryBuilder column, String postfix) {
        StringBuilder sb = new StringBuilder();
        if (!prefix.isEmpty()) {
            sb.append(prefix).append(" ");
        }
        appendChild(sb, column, 4);
        sb.append(" ").append(postfix);
        columns.add(sb.toString());
        return this;
    }

    public QueryBuilder join(String join) {
        joins.add(join);
        return this;
    }

    public QueryBuilder join(String prefix, QueryBuilder join, String postfix) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append(" ");
        appendChild(sb, join);
        sb.append(" ").append(postfix);
        joins.add(sb.toString());
        return this;
    }

    public QueryBuilder from(String from) {
        this.from = from;
        return this;
    }

    public QueryBuilder from(QueryBuilder from, String postfix) {
        StringBuilder sb = new StringBuilder();
        appendChild(sb, from);
        sb.append(" ").append(postfix);
        this.from = sb.toString();
        return this;
    }

    public QueryBuilder where(String where) {
        wheres.add(where);
        return this;
    }

    public QueryBuilder where(String prefix, QueryBuilder where) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append(" ");
        appendChild(sb, where);
        wheres.add(sb.toString());
        return this;
    }

    public QueryBuilder postAction(String action) {
        postAction = action;
        return this;
    }

    public QueryBuilder with(String alias, String cte) {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(cte).append(")");
        withs.put(alias, sb.toString());
        return this;
    }

    public QueryBuilder with(String alias, QueryBuilder cte) {
        StringBuilder sb = new StringBuilder();
        appendChild(sb, cte);
        withs.put(alias, sb.toString());
        return this;
    }

    public QueryBuilder groupBy(String group) {
        groups.add(group);
        return this;
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        if (!withs.isEmpty()) {
            sb.append("WITH ");
            for (Entry<String, String> with : withs.entrySet()) {
                sb.append(with.getKey()).append(" AS ").append(with.getValue()).append(",\n");
            }
            sb.setLength(sb.length() - 2);
            sb.append("\n");
        }

        sb.append("SELECT\n  ");
        sb.append(String.join(",\n  ", columns));

        if (from != null) {
            sb.append("\nFROM ").append(from);
        }

        for (String join : joins) {
            sb.append("\n").append(join);
        }

        if (!wheres.isEmpty()) {
            sb.append("\nWHERE ").append(String.join("\n  AND ", wheres));
        }

        if (!groups.isEmpty()) {
            sb.append("\nGROUP BY ").append(String.join(", ", groups));
        }

        if (postAction != null) {
            sb.append("\n").append(postAction);
        }

        return sb.toString();
    }

    private void appendChild(StringBuilder sb, QueryBuilder childBuilder) {
        appendChild(sb, childBuilder, 2);
    }

    private void appendChild(StringBuilder sb, QueryBuilder childBuilder, int indent) {
        sb.append("(\n").append(childBuilder.build().indent(indent)).append(" ".repeat(indent - 2)).append(")");
    }

    public QueryBuilder copy() {
        QueryBuilder copy = new QueryBuilder();
        copy.withs.putAll(withs);
        copy.columns.addAll(columns);
        copy.from = from;
        copy.joins.addAll(joins);
        copy.wheres.addAll(wheres);
        copy.groups.addAll(groups);
        copy.postAction = postAction;

        return copy;
    }
}
