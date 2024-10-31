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
package ru.taximaxim.codekeeper.cli.opthandlers;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.EnumOptionHandler;
import org.kohsuke.args4j.spi.Setter;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

public class DbObjTypeOptionHandler extends EnumOptionHandler<DbObjType> {

    private static final Set<DbObjType> HIDE = Set.of(DbObjType.DATABASE, DbObjType.COLUMN);

    public DbObjTypeOptionHandler(CmdLineParser parser, OptionDef option, Setter<DbObjType> setter) {
        super(parser, option, setter, DbObjType.class);
    }

    @Override
    public String getDefaultMetaVariable() {
        return "<OBJECT_TYPE>"; //$NON-NLS-1$
    }

    public static String getMetaVariable() {
        return Arrays.stream(DbObjType.values())
                .filter(e -> !HIDE.contains(e))
                .map(DbObjType::name)
                .collect(Collectors.joining(" | ", "OBJECT_TYPE : [", "]")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }
}
