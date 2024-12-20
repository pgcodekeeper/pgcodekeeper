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
package ru.taximaxim.codekeeper.core.formatter;

import java.util.Collections;
import java.util.List;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.formatter.ch.ChFormatter;
import ru.taximaxim.codekeeper.core.formatter.ms.MsFormatter;
import ru.taximaxim.codekeeper.core.formatter.pg.PgFormatter;
import ru.taximaxim.codekeeper.core.localizations.Messages;

public class FileFormatter {

    private final String source;
    private final int start;
    private final int stop;
    private final DatabaseType dbType;

    private final FormatConfiguration config;

    public FileFormatter(String source, int offset, int length, FormatConfiguration config, DatabaseType dbType) {
        this.source = source;
        this.start = offset;
        this.stop = offset + length;
        this.config = config;
        this.dbType = dbType;
    }

    public String formatText() {
        List<FormatItem> list = getFormatItems();
        if (list.isEmpty()) {
            return source;
        }

        Collections.reverse(list);
        var sb = new StringBuilder(source);
        for (var item : list) {
            var itemStart = item.getStart();
            sb.replace(itemStart, itemStart + item.getLength(), item.getText());
        }

        return sb.toString();
    }

    /**
     * @return list of formatting operations
     */
    public List<FormatItem> getFormatItems() {
        AbstractFormatter formatter;
        switch (dbType) {
        case CH:
            formatter = new ChFormatter(source, start, stop, config);
            break;
        case PG:
            formatter = new PgFormatter(source, start, stop, config);
            break;
        case MS:
            formatter = new MsFormatter(source, start, stop, config);
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        }

        return formatter.getFormatItems();
    }
}