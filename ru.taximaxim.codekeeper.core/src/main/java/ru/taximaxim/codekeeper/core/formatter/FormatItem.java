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
package ru.taximaxim.codekeeper.core.formatter;

public class FormatItem {

    private final int start;
    private final int length;
    private final String text;

    public FormatItem(int start, int length, String text) {
        this.start = start;
        this.length = length;
        this.text = text;
    }

    public int getStart() {
        return start;
    }

    public int getLength() {
        return length;
    }

    public String getText() {
        return text;
    }
}
