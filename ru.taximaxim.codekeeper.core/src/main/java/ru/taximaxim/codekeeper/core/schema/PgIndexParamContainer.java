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

import java.util.Map;
import java.util.Set;

import ru.taximaxim.codekeeper.core.Utils;

public interface PgIndexParamContainer {
    void addParam(String key, String value);
    void addInclude(String include);
    void setTablespace(String tablespace);

    Set<String> getIncludes();
    Map<String, String> getParams();
    String getTablespace();

    default void appendIndexParam(StringBuilder sb) {
        if (!getIncludes().isEmpty()) {
            sb.append(" INCLUDE ");
            Utils.appendCols(sb, getIncludes(), true);
        }
        if (!getParams().isEmpty()) {
            sb.append(" WITH ");
            Utils.appendOptions(sb, getParams(), true);
        }
        if (getTablespace() != null) {
            sb.append("\n\tUSING INDEX TABLESPACE ").append(getTablespace());
        }
    }
}