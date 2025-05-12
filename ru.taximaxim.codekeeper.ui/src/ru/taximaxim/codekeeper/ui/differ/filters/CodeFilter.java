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
package ru.taximaxim.codekeeper.ui.differ.filters;

import java.util.Map;
import java.util.Set;

import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;
import ru.taximaxim.codekeeper.core.settings.ISettings;
import ru.taximaxim.codekeeper.ui.differ.ElementMetaInfo;

/**
 * Contains information of code search
 *
 * @since 4.1.2.
 * @author galiev_mr
 *
 */
public final class CodeFilter extends AbstractFilter {

    @Override
    public boolean checkElement(TreeElement el, Map<TreeElement, ElementMetaInfo> elementInfoMap,
            AbstractDatabase dbProject, AbstractDatabase dbRemote, ISettings settings) {

        Set<TreeElement> elements = elementInfoMap.keySet();
        if (el.getSide() != DiffSide.RIGHT && checkSide(el, dbProject, elements, settings)) {
            return true;
        }

        if (el.getSide() != DiffSide.LEFT) {
            return checkSide(el, dbRemote, elements, settings);
        }

        return false;
    }

    private String getScript(PgStatement st, ISettings settings) {
        SQLScript script = new SQLScript(settings);
        st.getCreationSQL(script);
        return script.getFullScript();
    }

    private boolean checkSide(TreeElement el, AbstractDatabase db, Set<TreeElement> elements, ISettings settings) {
        PgStatement statement = el.getPgStatement(db);
        if (statement != null) {
            if (searchMatches(getScript(statement, settings))) {
                return true;
            }

            if (el.isSubElement()) {
                PgStatement parent = statement.getParent();
                if (parent != null) {
                    return searchMatches(getScript(parent, settings));
                }
            }

            if (el.isContainer()) {
                return el.getChildren().stream().filter(elements::contains)
                        .map(e -> e.getPgStatement(db))
                        .anyMatch(s -> s != null && searchMatches(getScript(s, settings)));
            }
        }

        return false;
    }
}
