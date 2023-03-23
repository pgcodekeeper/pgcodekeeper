/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.schema;

import java.util.Locale;

public enum ArgMode {
    IN,
    INOUT,
    OUT,
    VARIADIC,
    // MS SQL
    OUTPUT;

    public boolean isIn() {
        return this == IN || this == INOUT || this == VARIADIC;
    }

    public static ArgMode of(String string) {
        String s = string.toLowerCase(Locale.ROOT);
        switch (s) {
        case "in":
        case "i":
            return IN;
        case "out":
        case "o":
            return OUT;
        case "inout":
        case "b":
            return INOUT;
        case "variadic":
        case "v":
            return VARIADIC;
        case "output":
            return OUTPUT;
        default:
            return valueOf(string);
        }
    }
}
