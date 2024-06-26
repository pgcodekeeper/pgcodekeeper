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

import java.util.List;

public abstract class AbstractFormatter {

    protected final String source;
    protected final int start;
    protected final int stop;
    protected final FormatConfiguration config;

    public AbstractFormatter(String source, int start, int stop, FormatConfiguration config) {
        this.source = source;
        this.start = start;
        this.stop = stop;
        this.config = config;
    }

    protected abstract List<FormatItem> getFormatItems();
}