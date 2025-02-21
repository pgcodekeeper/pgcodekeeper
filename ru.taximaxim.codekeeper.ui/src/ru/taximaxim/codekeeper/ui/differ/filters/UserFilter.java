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
import java.util.function.Function;

import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.ui.differ.ElementMetaInfo;

public class UserFilter extends AbstractFilter {

    private final Function<ElementMetaInfo, String> getter;

    public UserFilter(Function<ElementMetaInfo, String> getter) {
        this.getter = getter;
    }

    @Override
    public boolean checkElement(TreeElement el, Map<TreeElement, ElementMetaInfo> elementInfoMap,
            AbstractDatabase dbProject, AbstractDatabase dbRemote) {
        ElementMetaInfo meta = elementInfoMap.get(el);

        if (meta != null) {
            if (searchMatches(getter.apply(meta))) {
                return true;
            }

            if (el.isSubElement()) {
                ElementMetaInfo parent = elementInfoMap.get(el.getParent());
                if (parent != null) {
                    return searchMatches(getter.apply(parent));
                }
            }

            if (el.isContainer()) {
                return el.getChildren().stream().filter(elementInfoMap::containsKey)
                        .map(elementInfoMap::get)
                        .anyMatch(s -> s != null && searchMatches(getter.apply(s)));
            }
        }

        return false;
    }
}
