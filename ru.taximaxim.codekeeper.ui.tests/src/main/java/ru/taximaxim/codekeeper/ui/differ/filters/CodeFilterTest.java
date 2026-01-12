/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.pgcodekeeper.core.DatabaseType;
import org.pgcodekeeper.core.model.difftree.TreeElement;
import org.pgcodekeeper.core.model.difftree.TreeElement.DiffSide;
import org.pgcodekeeper.core.schema.AbstractDatabase;
import org.pgcodekeeper.core.schema.PgStatement;
import org.pgcodekeeper.core.script.SQLScript;

class CodeFilterTest extends AbstractFilterTest{

    @Mock
    private PgStatement pgStatement;
    @Mock
    private PgStatement parent;
    @Mock
    private PgStatement child;

    @BeforeEach
    void setup() {
        filter = new CodeFilter();
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @EnumSource(value = DiffSide.class)
    void testElementMatch(DiffSide side) {
        whenElementSideIs(side);
        whenStatementIsNotNull(true);
        whenSearchPatternIs(RIGHT);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote, SETTINGS);

        assertEquals(true, result);
    }

    @ParameterizedTest
    @EnumSource(value = DiffSide.class)
    void testElementNotMatch(DiffSide side) {
        whenElementSideIs(side);
        whenStatementIsNotNull(true);
        whenSearchPatternIs(INVALID);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote, SETTINGS);

        assertEquals(false, result);
    }

    @ParameterizedTest
    @EnumSource(value = DiffSide.class)
    void testElementPgStatementIsNull(DiffSide side) {
        whenElementSideIs(side);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote, SETTINGS);

        assertEquals(false, result);
    }

    @ParameterizedTest
    @EnumSource(value = DiffSide.class)
    void testElementIsChildAndParentMatch(DiffSide side) {
        whenElementSideIs(side);
        whenElementIsChild(false);
        whenSearchPatternIs(RIGHT);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote, SETTINGS);

        assertEquals(true, result);
    }

    @ParameterizedTest
    @EnumSource(value = DiffSide.class)
    void testElementIsChildAndParentNotMatch(DiffSide side) {
        whenElementSideIs(side);
        whenElementIsChild(false);
        whenSearchPatternIs(INVALID);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote, SETTINGS);

        assertEquals(false, result);
    }

    @Test
    void testElementIsChildAndParentNotMatch() {
        whenElementSideIs(DiffSide.BOTH);
        whenElementIsChild(true);
        whenSearchPatternIs(INVALID);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote, SETTINGS);

        assertEquals(false, result);
    }

    @ParameterizedTest
    @EnumSource(value = DiffSide.class)
    void testElementIsContainerAndChildMatch(DiffSide side) {
        whenElementSideIs(side);
        whenElementIsContainer(false);
        whenSearchPatternIs(RIGHT);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote, SETTINGS);

        assertEquals(true, result);
    }

    @ParameterizedTest
    @EnumSource(value = DiffSide.class)
    void testElementIsContainerAndChildNotMatch(DiffSide side) {
        whenElementSideIs(side);
        whenElementIsContainer(false);
        whenSearchPatternIs(INVALID);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote, SETTINGS);

        assertEquals(false, result);
    }

    @Test
    void testElementIsContainerAndChildStatementIsNull() {
        whenElementSideIs(DiffSide.BOTH);
        whenElementIsContainer(true);
        whenSearchPatternIs(RIGHT);

        boolean result = filter.checkElement(treeElement, elementInfoMap, dbProject, dbRemote, SETTINGS);

        assertEquals(false, result);
    }

    private void whenElementSideIs(DiffSide side) {
        when(treeElement.getSide()).thenReturn(side);
    }

    private void whenStatementIsNotNull(boolean hasCreationSql) {
        pgStatement = mock(PgStatement.class);

        when(treeElement.getPgStatement(any(AbstractDatabase.class))).thenReturn(pgStatement);
        when(pgStatement.getDbType()).thenReturn(DatabaseType.PG);
        if (hasCreationSql) {
            setCreationSql(pgStatement);
        }
    }

    private void whenElementIsChild(boolean isParentNull) {
        whenStatementIsNotNull(false);
        when(treeElement.isSubElement()).thenReturn(true);
        when(pgStatement.getParent()).thenReturn(isParentNull ? null : parent);
        when(parent.getDbType()).thenReturn(DatabaseType.PG);
        setCreationSql(parent);
    }

    private void whenElementIsContainer(boolean isChildNull) {
        TreeElement childElement = mock(TreeElement.class);
        @SuppressWarnings("unchecked")
        Set<TreeElement> elements = mock(Set.class);

        when(elements.contains(childElement)).thenReturn(true);
        when(elementInfoMap.keySet()).thenReturn(elements);
        whenStatementIsNotNull(false);
        when(treeElement.isContainer()).thenReturn(true);
        when(treeElement.getChildren()).thenReturn(Arrays.asList(childElement));
        when(childElement.getPgStatement(any(AbstractDatabase.class))).thenReturn(isChildNull ? null : child);
        when(child.getDbType()).thenReturn(DatabaseType.PG);
        setCreationSql(child);
    }

    private void setCreationSql(PgStatement statement) {
        doAnswer(invocation -> {
            SQLScript script = (SQLScript) invocation.getArgument(0);
            script.addStatement(RIGHT);
            return null;
        }).when(statement).getCreationSQL(any(SQLScript.class));
    }
}
