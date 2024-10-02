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
package ru.taximaxim.codekeeper.core.loader.ms;

/**
 * MS SQL Supported versions
 */
public enum SupportedMsVersion {
    VERSION_12 (11, "2012"),
    VERSION_14 (12, "2014"),
    VERSION_16 (13, "2016"),
    VERSION_17 (14, "2017"),
    VERSION_19 (15, "2019"),
    VERSION_22 (16, "2022");

    private final int version;
    private final String text;

    SupportedMsVersion(int version, String text) {
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

    public static SupportedMsVersion valueOf(int checkVersion) {
        SupportedMsVersion[] set = SupportedMsVersion.values();

        for (int i = set.length - 1; i >= 0; i--) {
            SupportedMsVersion verEnum = set[i];
            if (verEnum.isLE(checkVersion)) {
                return verEnum;
            }
        }

        return SupportedMsVersion.VERSION_12;
    }
}