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
package ru.taximaxim.codekeeper.core.schema;

import java.util.Collection;
import java.util.Map;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.script.SQLAction;

public interface ISimpleOptionContainer extends IOptionContainer {

    @Override
    default void compareOptions(IOptionContainer newContainer, Collection<SQLAction> sqlActions) {
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
            appendOptions(newContainer, setOptions, resetOptions,  sqlActions);
        }
    }

    default void appendOptions(IOptionContainer newContainer, StringBuilder setOptions,
            StringBuilder resetOptions,  Collection<SQLAction> sqlActions) {
        DbObjType type = getStatementType();
        String typeName = type == DbObjType.VIEW ? ((PgStatement) newContainer).getTypeName() : type.name();

        if (setOptions.length() > 0) {
            setOptions.setLength(setOptions.length() - 2);
            SQLAction sql = new SQLAction();
            sql.append("ALTER ");
            if (type == DbObjType.COLUMN) {
                sql.append("TABLE ONLY ")
                .append(PgDiffUtils.getQuotedName(getParent().getParent().getName()))
                .append('.').append(PgDiffUtils.getQuotedName(getParent().getName()))
                .append(" ALTER ");
            }
            sql.append(typeName).append(' ');
            if (type != DbObjType.COLUMN) {
                IStatement parent = getParent();
                if (type == DbObjType.INDEX) {
                    parent = parent.getParent();
                }
                sql.append(PgDiffUtils.getQuotedName(parent.getName())).append('.');
            }
            sql.append(PgDiffUtils.getQuotedName(getName())).append(" SET (").append(setOptions).append(")");
            sqlActions.add(sql);
        }

        if (resetOptions.length() > 0) {
            SQLAction sql = new SQLAction();
            resetOptions.setLength(resetOptions.length() - 2);
            sql.append("ALTER ");
            if (type == DbObjType.COLUMN) {
                sql.append("TABLE ONLY ")
                .append(PgDiffUtils.getQuotedName(getParent().getParent().getName()))
                .append('.').append(PgDiffUtils.getQuotedName(getParent().getName()))
                .append(" ALTER ");
            }
            sql.append(typeName).append(' ');
            if (type != DbObjType.COLUMN) {
                IStatement parent = getParent();
                if (type == DbObjType.INDEX) {
                    parent = parent.getParent();
                }
                sql.append(PgDiffUtils.getQuotedName(parent.getName())).append('.');
            }
            sql.append(PgDiffUtils.getQuotedName(getName())).append(" RESET (").append(resetOptions).append(")");
            sqlActions.add(sql);
        }
    }
}
