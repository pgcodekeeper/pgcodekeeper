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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.differ.ElementMetaInfo;

class UserFilterTest extends AbstractFilterTest {

    @Mock
    private ElementMetaInfo parent;
    @Mock
    private ElementMetaInfo child;
    @Mock
    private ElementMetaInfo meta;

    @Mock
    Function<ElementMetaInfo, String> getter;

    private static Stream<Arguments> arguments() {
        return Stream.of(
          Arguments.of(false, RIGHT, true),
          Arguments.of(false, INVALID, false),
          Arguments.of(true, RIGHT, false)
        );
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        filter = new UserFilter(getter);
    }

    @Test
    void testElementMatch() {
        whenElementIsInMetaInfoMap();
        whenGetterReturns(RIGHT);
        whenSearchPatternIs(RIGHT);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote, SETTINGS);

        assertEquals(true, result);
    }

    @Test
    void testElementNotMatch() {
        whenElementIsInMetaInfoMap();
        whenGetterReturns(INVALID);
        whenSearchPatternIs(RIGHT);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote, SETTINGS);

        assertEquals(false, result);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testElementIsSub(boolean isParentNull, String getterReturnedValue, boolean excepted) {
        whenElementIsInMetaInfoMap();
        whenElementIsSub(isParentNull);
        whenGetterReturns(INVALID, getterReturnedValue);
        whenSearchPatternIs(RIGHT);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote, SETTINGS);

        assertEquals(excepted, result);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testElementIsContainer(boolean isChild, String getterReturnedValue, boolean excepted) {
        whenElementIsInMetaInfoMap();
        whenElementIsContainer(isChild);
        whenGetterReturns(INVALID, getterReturnedValue);
        whenSearchPatternIs(RIGHT);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote, SETTINGS);

        assertEquals(excepted, result);
    }

    @Test
    void testElementNotInElementMetaInfoMap() {
        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote, SETTINGS);

        assertEquals(false, result);
    }

    private void whenElementIsInMetaInfoMap() {
        when(elementInfoMap.get(treeElement)).thenReturn(meta);
    }

    private void whenGetterReturns(String first, String... others) {
        when(getter.apply(any(ElementMetaInfo.class))).thenReturn(first, others);
    }

    private void whenElementIsSub(boolean isParentNull) {
        TreeElement parentElement = mock(TreeElement.class);
        when(treeElement.getParent()).thenReturn(parentElement);
        when(treeElement.isSubElement()).thenReturn(true);
        when(elementInfoMap.get(parentElement)).thenReturn(isParentNull ? null : parent);
    }

    private void whenElementIsContainer(boolean isChildNull) {
        TreeElement childElement = mock(TreeElement.class);
        when(treeElement.isContainer()).thenReturn(true);
        when(treeElement.getChildren()).thenReturn(Arrays.asList(childElement));
        when(elementInfoMap.containsKey(childElement)).thenReturn(true);
        when(elementInfoMap.get(childElement)).thenReturn(isChildNull ? null :child);
    }
}
