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
package ru.taximaxim.codekeeper.ui.reports;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UsageEventTest {

    @Mock
    UsageEventType type;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInitializationWhenTypeIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new UsageEvent(null, "test", 1));
    }

    @Test
    void testInitializationWhenTypeDescriptionIsNullAndValueNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new UsageEvent(type, "test", 1));
    }

    @Test
    void testCopy() {
        when(type.getValueDescription()).thenReturn("test");
        UsageEvent original = new UsageEvent(type, "test", 1);

        UsageEvent copy = original.copy();

        assertEquals(original.getType(), copy.getType());
        assertEquals(original.getLabel(), copy.getLabel());
        assertEquals(original.getValue(), copy.getValue());
    }

    @Test
    void testToString() {
        when(type.getValueDescription()).thenReturn("test");
        assertEquals("{Type=type; Label=\"test\"; Value=\"1\"}",
                new UsageEvent(type, "test", 1).toString());
        assertEquals("{Type=type; Label=\"test\"}",
                new UsageEvent(type, "test", null).toString());
        assertEquals("{Type=type; Value=\"1\"}",
                new UsageEvent(type, null, 1).toString());
        assertEquals("{Type=type}",
                new UsageEvent(type, null, null).toString());
    }
}
