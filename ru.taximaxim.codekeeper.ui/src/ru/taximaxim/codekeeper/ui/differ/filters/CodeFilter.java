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

import java.util.Map;
import java.util.Set;

import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.ui.differ.DiffTableViewer;
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
            PgDatabase dbProject, PgDatabase dbRemote) {

        Set<TreeElement> elements = elementInfoMap.keySet();
        if (el.getSide() != DiffSide.RIGHT && checkSide(el, dbProject, elements)) {
            return true;
        }

        if (el.getSide() != DiffSide.LEFT) {
            return checkSide(el, dbRemote, elements);
        }

        return false;
    }

    private boolean checkSide(TreeElement el, PgDatabase db, Set<TreeElement> elements) {
        PgStatement statement = el.getPgStatement(db);
        if (statement != null) {
            if (searchMatches(statement.getCreationSQL())) {
                return true;
            }

            if (DiffTableViewer.isSubElement(el)) {
                PgStatement parent = statement.getParent();
                if (parent != null) {
                    return searchMatches(parent.getCreationSQL());
                }
            }

            if (DiffTableViewer.isContainer(el)) {
                return el.getChildren().stream().filter(elements::contains)
                        .map(e -> e.getPgStatement(db))
                        .anyMatch(s -> s != null && searchMatches(s.getCreationSQL()));
            }
        }

        return false;
    }
}
