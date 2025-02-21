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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

class ContainerFilterTest extends AbstractFilterTest{

    @BeforeEach
    void setup() {
        filter = new ContainerFilter();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testElementMatch() {
        whenElementWithName(RIGHT);
        whenSearchPatternIs(RIGHT);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote);

        assertEquals(true, result);
    }

    @Test
    void testElementNotMatch() {
        whenElementWithName(INVALID);
        whenSearchPatternIs(RIGHT);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote);

        assertEquals(false, result);
    }

    @Test
    void testElementTypeIsSchemaAndMatch() {
        whenElementIsSchemaWithName(RIGHT);
        whenSearchPatternIs(RIGHT);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote);

        assertEquals(true, result);
    }

    @Test
    void testElementTypeIsSchemaAndNotMatch() {
        whenElementIsSchemaWithName(INVALID);
        whenSearchPatternIs(RIGHT);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote);

        assertEquals(false, result);
    }

    @Test
    void testElementNameIsEmpty() {
        whenElementWithName("");

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote);

        assertEquals(false, result);
    }

    private void whenElementWithName(String name) {
        when(treeElement.getContainerQName()).thenReturn(name);
    }

    private void whenElementIsSchemaWithName(String name) {
        when(treeElement.getContainerQName()).thenReturn("");
        when(treeElement.getType()).thenReturn(DbObjType.SCHEMA);
        when(treeElement.getName()).thenReturn(name);
    }
}
