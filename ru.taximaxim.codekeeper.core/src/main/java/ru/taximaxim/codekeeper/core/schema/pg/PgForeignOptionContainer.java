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

import java.text.MessageFormat;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.schema.IOptionContainer;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public interface PgForeignOptionContainer extends IOptionContainer {

    static final String ALTER_FOREIGN_OPTION = "{0} OPTIONS ({1} {2} {3})";
    static final String DELIM = ",\n    ";

    String getAlterHeader();

    default void appendOptions(StringBuilder sb) {
        Map<String, String> options = getOptions();
        if (!options.isEmpty()) {
            sb.append("OPTIONS (\n    ");
            for (Entry<String, String> entry : options.entrySet()) {
                sb.append(entry.getKey())
                .append(' ')
                .append(entry.getValue())
                .append(DELIM);
            }
            sb.setLength(sb.length() - DELIM.length());
            sb.append("\n)");
        }
    }

    @Override
    default void compareOptions(IOptionContainer newContainer, SQLScript script) {
        Map <String, String> oldForeignOptions = getOptions();
        Map <String, String> newForeignOptions = newContainer.getOptions();

        if (Objects.equals(oldForeignOptions, newForeignOptions)) {
            return;
        }

        if (!oldForeignOptions.isEmpty() || !newForeignOptions.isEmpty()) {
            oldForeignOptions.forEach((key, value) -> {
                String newValue = newForeignOptions.get(key);
                if (newValue != null) {
                    if (!value.equals(newValue)) {
                        script.addStatement(getAlterOption("SET", key, newValue));
                    }
                } else {
                    script.addStatement(getAlterOption("DROP", key, ""));
                }
            });

            newForeignOptions.forEach((key, value) -> {
                if (!oldForeignOptions.containsKey(key)) {
                    script.addStatement(getAlterOption("ADD", key, value));
                }
            });
        }
    }

    private String getAlterOption(String action, String key, String value) {
        return MessageFormat.format(ALTER_FOREIGN_OPTION, getAlterHeader(), action, key, value);
    }
}
