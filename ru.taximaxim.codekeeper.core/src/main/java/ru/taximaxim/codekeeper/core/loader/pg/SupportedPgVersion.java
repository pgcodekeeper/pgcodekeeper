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
package ru.taximaxim.codekeeper.core.loader.pg;

/**
 * PostgreSQL supported versions
 */
public enum SupportedPgVersion {
    VERSION_9_4 (90400, "9.4"),
    VERSION_9_5 (90500, "9.5"),
    VERSION_9_6 (90600, "9.6"),
    VERSION_10 (100000, "10.0"),
    VERSION_11 (110000, "11.0"),
    VERSION_12 (120000, "12.0"),
    VERSION_13 (130000, "13.0"),
    VERSION_14 (140000, "14.0"),
    VERSION_15 (150000, "15.0"),
    VERSION_16 (160000, "16.0"),
    VERSION_17 (170000, "17.0");

    private final int version;
    private final String text;

    SupportedPgVersion(int version, String text) {
        this.version = version;
        this.text = text;
    }

    public int getVersion() {
        return version;
    }

    public String getText() {
        return text;
    }

    public boolean isLE(int version) {
        return this.version <= version;
    }

    public static SupportedPgVersion valueOf(int checkVersion) {
        SupportedPgVersion[] set = SupportedPgVersion.values();

        for (int i = set.length - 1; i >= 0; i--) {
            SupportedPgVersion verEnum = set[i];
            if (verEnum.isLE(checkVersion)) {
                return verEnum;
            }
        }

        return SupportedPgVersion.VERSION_9_4;
    }
}