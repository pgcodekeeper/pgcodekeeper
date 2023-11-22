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

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public interface PgSimpleOptionContainer extends OptionContainer {

    @Override
    default void compareOptions(OptionContainer newContainer, StringBuilder sb) {
        Map <String, String> oldOptions = getOptions();
        Map <String, String> newOptions = newContainer.getOptions();

        StringBuilder setOptions = new StringBuilder();
        StringBuilder resetOptions = new StringBuilder();

        if (!oldOptions.isEmpty() || !newOptions.isEmpty()) {
            oldOptions.forEach((key, value) -> {
                String newValue = newOptions.get(key);
                if (newValue != null) {
                    if (!value.equals(newValue)) {
                        setOptions.append(key);
                        if (!newValue.isEmpty()) {
                            setOptions.append('=');
                            setOptions.append(newValue);
                        }
                        setOptions.append(", ");
                    }
                } else {
                    resetOptions.append(key).append(", ");
                }
            });

            newOptions.forEach((key, value) -> {
                if (!oldOptions.containsKey(key)) {
                    setOptions.append(key);
                    if (!value.isEmpty()) {
                        setOptions.append('=');
                        setOptions.append(value);
                    }
                    setOptions.append(", ");
                }
            });
        }

        if (setOptions.length() > 0 || resetOptions.length() > 0) {
            appendOptions(newContainer, setOptions, resetOptions, sb);
        }
    }

    default void appendOptions(OptionContainer newContainer, StringBuilder setOptions,
            StringBuilder resetOptions, StringBuilder sb) {
        DbObjType type = getStatementType();

        if (setOptions.length() > 0) {
            setOptions.setLength(setOptions.length() - 2);
            sb.append("\n\nALTER ");
            if (type == DbObjType.COLUMN) {
                sb.append("TABLE ONLY ")
                .append(PgDiffUtils.getQuotedName(getParent().getParent().getName()))
                .append('.').append(PgDiffUtils.getQuotedName(getParent().getName()))
                .append(" ALTER ");
            } else if (type == DbObjType.VIEW && ((PgView)newContainer).isMatView()) {
                sb.append("MATERIALIZED ");
            }
            sb.append(type)
            .append(' ');
            if (type != DbObjType.COLUMN) {
                IStatement parent = getParent();
                if (type == DbObjType.INDEX) {
                    parent = parent.getParent();
                }
                sb.append(PgDiffUtils.getQuotedName(parent.getName())).append('.');
            }
            sb.append(PgDiffUtils.getQuotedName(getName())).append(" SET (")
            .append(setOptions).append(");");
        }

        if (resetOptions.length() > 0) {
            resetOptions.setLength(resetOptions.length() - 2);
            sb.append("\n\nALTER ");
            if (type == DbObjType.COLUMN) {
                sb.append("TABLE ONLY ")
                .append(PgDiffUtils.getQuotedName(getParent().getParent().getName()))
                .append('.').append(PgDiffUtils.getQuotedName(getParent().getName()))
                .append(" ALTER ");
            } else if (type == DbObjType.VIEW && ((PgView)newContainer).isMatView()) {
                sb.append("MATERIALIZED ");
            }
            sb.append(type)
            .append(' ');
            if (type != DbObjType.COLUMN) {
                IStatement parent = getParent();
                if (type == DbObjType.INDEX) {
                    parent = parent.getParent();
                }
                sb.append(PgDiffUtils.getQuotedName(parent.getName())).append('.');
            }
            sb.append(PgDiffUtils.getQuotedName(getName()))
            .append(" RESET (").append(resetOptions).append(");");
        }
    }
}
