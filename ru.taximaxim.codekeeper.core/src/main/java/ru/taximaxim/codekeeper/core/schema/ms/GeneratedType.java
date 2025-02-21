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
package ru.taximaxim.codekeeper.core.schema.ms;

public enum GeneratedType {

    ROW_START("ROW START"),
    ROW_END("ROW END"),
    TRAN_START("TRANSACTION_ID START"),
    TRAN_END("TRANSACTION_ID END"),
    SEQ_START("SEQUENCE_NUMBER START"),
    SEQ_END("SEQUENCE_NUMBER END");

    private String value;

    private GeneratedType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GeneratedType parseDbType(int type) {
        return switch (type) {
            case 0 -> null;
            case 1 -> ROW_START;
            case 2 -> ROW_END;
            case 7 -> TRAN_START;
            case 8 -> TRAN_END;
            case 9 -> SEQ_START;
            case 10 -> SEQ_END;
            default -> throw new IllegalStateException("Unsupported GENERATED ALWAYS column type: " + type);
        };
    }
}