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

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.settings.ISettings;
import ru.taximaxim.codekeeper.ui.differ.ElementMetaInfo;

/**
 * Contains information of search by container
 *
 * @since 4.2.0.
 * @author galiev_mr
 */
public final class ContainerFilter extends AbstractFilter {

    @Override
    public boolean checkElement(TreeElement el, Map<TreeElement, ElementMetaInfo> elementInfoMap,
            AbstractDatabase dbProject, AbstractDatabase dbRemote, ISettings settings) {

        String container = el.getContainerQName();
        if (!container.isEmpty()) {
            return searchMatches(container);
        } else if (el.getType() == DbObjType.SCHEMA) {
            return searchMatches(el.getName());
        }

        return false;
    }
}