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
package ru.taximaxim.codekeeper.core.schema;

import ru.taximaxim.codekeeper.core.settings.ISettings;

/**
 * A statement that is represented only by its full source code
 * separated in two parts by CREATE ZZZZ schema.name
 */
public interface SourceStatement extends ISearchPath {
    String getFirstPart();
    void setFirstPart(String firstPart);
    String getSecondPart();
    void setSecondPart(String secondPart);

    /**
     * Assembles entire statement from source parts
     * 
     * @param isCreate do CREATE or ALTER
     * @param settings
     */
    default StringBuilder appendSourceStatement(boolean isCreate, StringBuilder sb, ISettings settings) {
        sb.append(getFirstPart())
        .append(isCreate ? "CREATE " : "ALTER ")
        .append(getStatementType())
        .append(' ');
        appendName(sb, settings)
        .append(getSecondPart());
        return sb;
    }

    /**
     * Appends the only normalized statement part: its name and location, always
     * qualifies and quotes.
     * 
     * @param settings
     */
    default StringBuilder appendName(StringBuilder sb, ISettings settings) {
        return sb.append(getQualifiedName());
    }
}
