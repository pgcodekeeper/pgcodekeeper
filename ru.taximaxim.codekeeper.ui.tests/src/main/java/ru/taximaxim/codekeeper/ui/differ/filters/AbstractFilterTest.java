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

import org.mockito.Mock;

import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.ui.differ.ElementMetaInfo;

abstract class AbstractFilterTest {

    protected static final String INVALID = "INVALID";

    protected static final String RIGHT = "RIGHT STRING";

    @Mock
    protected TreeElement treeElement;
    @Mock
    protected Map<TreeElement, ElementMetaInfo> elementInfoMap;
    @Mock
    protected AbstractDatabase dbProject;
    @Mock
    protected AbstractDatabase dbRemote;

    protected AbstractFilter filter;

    protected void whenSearchPatternIs(String pattern) {
        filter.updateFields(pattern, true);
    }
}
