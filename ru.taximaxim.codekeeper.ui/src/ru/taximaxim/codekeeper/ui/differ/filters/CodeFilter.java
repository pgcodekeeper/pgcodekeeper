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
package ru.taximaxim.codekeeper.ui.differ.filters;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLAction;
import ru.taximaxim.codekeeper.ui.differ.ElementMetaInfo;

/**
 * Contains information of code search
 *
 * @since 4.1.2.
 * @author galiev_mr
 *
 */
public class CodeFilter extends AbstractFilter {

    @Override
    public boolean checkElement(TreeElement el, Map<TreeElement, ElementMetaInfo> elementInfoMap,
            AbstractDatabase dbProject, AbstractDatabase dbRemote) {

        Set<TreeElement> elements = elementInfoMap.keySet();
        if (el.getSide() != DiffSide.RIGHT && checkSide(el, dbProject, elements)) {
            return true;
        }

        if (el.getSide() != DiffSide.LEFT) {
            return checkSide(el, dbRemote, elements);
        }

        return false;
    }

    private String getScript(PgStatement st) {
        Set<SQLAction> sqlActions = new LinkedHashSet<>();
        st.getCreationSQL(sqlActions);
        StringBuilder sb = new StringBuilder();
        sqlActions.forEach(sb::append);
        return sb.toString();
    }

    private boolean checkSide(TreeElement el, AbstractDatabase db, Set<TreeElement> elements) {
        PgStatement statement = el.getPgStatement(db);
        if (statement != null) {
            if (searchMatches(getScript(statement))) {
                return true;
            }

            if (el.isSubElement()) {
                PgStatement parent = statement.getParent();
                if (parent != null) {
                    return searchMatches(getScript(parent));
                }
            }

            if (el.isContainer()) {
                return el.getChildren().stream().filter(elements::contains)
                        .map(e -> e.getPgStatement(db))
                        .anyMatch(s -> s != null && searchMatches(getScript(s)));
            }
        }

        return false;
    }
}
