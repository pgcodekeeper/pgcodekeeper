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
package ru.taximaxim.codekeeper.core.loader;

import org.eclipse.core.runtime.SubMonitor;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.loader.ch.JdbcChLoader;
import ru.taximaxim.codekeeper.core.loader.ms.JdbcMsLoader;
import ru.taximaxim.codekeeper.core.loader.pg.JdbcPgLoader;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;

public final class LoaderFactory {

    public static DatabaseLoader createJdbcLoader(PgDiffArguments arguments, String url,
            IgnoreSchemaList ignoreSchemaList) {
        String timezone = arguments.getTimeZone() == null ? Consts.UTC : arguments.getTimeZone();
        return createJdbcLoader(arguments, timezone, new UrlJdbcConnector(url), SubMonitor.convert(null),
                ignoreSchemaList);
    }

    public static DatabaseLoader createJdbcLoader(PgDiffArguments arguments, String timezone,
            AbstractJdbcConnector connnector, SubMonitor monitor, IgnoreSchemaList ignoreSchemaList) {
        var dbType = arguments.getDbType();
        switch (dbType) {
        case MS:
            return new JdbcMsLoader(connnector, arguments, monitor, ignoreSchemaList);
        case PG:
            return new JdbcPgLoader(connnector, timezone, arguments, monitor, ignoreSchemaList);
        case CH:
            return new JdbcChLoader(connnector, arguments, monitor, ignoreSchemaList);
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        }
    }

    private LoaderFactory() {
    }
}