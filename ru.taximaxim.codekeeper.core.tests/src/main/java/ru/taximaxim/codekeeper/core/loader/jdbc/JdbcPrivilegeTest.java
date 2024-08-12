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
package ru.taximaxim.codekeeper.core.loader.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class JdbcPrivilegeTest {

    @Test
    void testParse() {
        String order = "CU";
        String acl = "{main=UC/main,user=U*/main,guest=C/main,=UC/main}";
        List<JdbcPrivilege> privs = JdbcPrivilege.parse(acl, order, null);
        assertEquals(4, privs.size());

        JdbcPrivilege first = privs.get(0);
        assertEquals("ALL", first.getGrantString(""));
        assertEquals("main", first.getGrantee());
        assertFalse(first.isDefault());
        assertFalse(first.isGrantAllToPublic());
        assertFalse(first.isGO());

        JdbcPrivilege second = privs.get(1);
        assertEquals("USAGE", second.getGrantString(""));
        assertEquals("\"user\"", second.getGrantee());
        assertFalse(second.isDefault());
        assertFalse(second.isGrantAllToPublic());
        assertTrue(second.isGO());

        JdbcPrivilege third = privs.get(2);
        assertEquals("CREATE", third.getGrantString(""));
        assertEquals("guest", third.getGrantee());
        assertFalse(third.isDefault());
        assertFalse(third.isGrantAllToPublic());
        assertFalse(third.isGO());

        JdbcPrivilege fourth = privs.get(3);
        assertEquals("ALL", fourth.getGrantString(""));
        assertEquals("PUBLIC", fourth.getGrantee());
        assertFalse(fourth.isDefault());
        assertTrue(fourth.isGrantAllToPublic());
        assertFalse(fourth.isGO());
    }

    @Test
    void testEmpty() {
        String order = "CU";
        String acl = "{}";
        List<JdbcPrivilege> privs = JdbcPrivilege.parse(acl, order, null);
        assertEquals(0, privs.size());
    }
}
