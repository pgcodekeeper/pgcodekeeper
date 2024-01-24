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

    public QueryBuilder column(String column) {
        columns.add(column);
        return this;
    }

    public QueryBuilder join(String join) {
        joins.add(join);
        return this;
    }

    public QueryBuilder from(String from) {
        this.from = from;
        return this;
    }

    public QueryBuilder where(String where) {
        this.wheres.add(where);
        return this;
    }

    public QueryBuilder with(String alias, String cte) {
        withs.put(alias, cte);
        return this;
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        if (!withs.isEmpty()) {
            sb.append("WITH ");
            for (Entry<String, String> with : withs.entrySet()) {
                sb.append(with.getKey()).append(" AS (").append(with.getValue()).append("),\n");
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
            sb.append("\nWHERE ").append(String.join("\n AND ", wheres));
        }

        return sb.toString();
    }
}
