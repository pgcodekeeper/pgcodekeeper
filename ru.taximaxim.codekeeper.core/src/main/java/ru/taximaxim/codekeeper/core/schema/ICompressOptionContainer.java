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

public interface ICompressOptionContainer {

    String DEFAULT_COMPESS_TYPE = "none";
    int DEFAULT_COMPESS_LEVEL = 0;
    int DEFAULT_BLOCK_SIZE = 32768;

    void setCompressType(String compressType);
    void setCompressLevel(int compressLevel);
    void setBlockSize(int blockSize);

    static void fillCompressOptions(ICompressOptionContainer statement, String compressOptions) {
        for (String pair : compressOptions.split(",")) {
            int sep = pair.indexOf('=');
            if (sep != -1) {
                String option = pair.substring(0, sep).trim();
                String value = pair.substring(sep + 1);
                switch (option) {
                case "compresstype":
                    statement.setCompressType(value);
                    break;
                case "compresslevel":
                    statement.setCompressLevel(Integer.parseInt(value));
                    break;
                case "blocksize":
                    statement.setBlockSize(Integer.parseInt(value));
                    break;
                }
            }
        }
    }
}