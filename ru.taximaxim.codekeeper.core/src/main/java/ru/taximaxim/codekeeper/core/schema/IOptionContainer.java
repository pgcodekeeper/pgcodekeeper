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
package ru.taximaxim.codekeeper.core.schema;

import java.util.List;
import java.util.Map;

public interface IOptionContainer extends IStatement {

    List<String> GP_OPTION_LIST = List.of(
            "appendonly",
            "appendoptimized",
            "blocksize",
            "orientation",
            "checksum",
            "compresstype",
            "compresslevel",
            "analyze_hll_non_part_table");

    void addOption(String key, String value);
    Map<String, String> getOptions();
    void compareOptions(IOptionContainer newContainer, StringBuilder sb);
}
