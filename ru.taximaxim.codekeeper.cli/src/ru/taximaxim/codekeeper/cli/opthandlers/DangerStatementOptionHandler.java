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
import java.util.stream.Collectors;

import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.EnumOptionHandler;
import org.kohsuke.args4j.spi.Setter;

import ru.taximaxim.codekeeper.core.DangerStatement;

public class DangerStatementOptionHandler extends EnumOptionHandler<DangerStatement> {

    public DangerStatementOptionHandler(CmdLineParser parser, OptionDef option, Setter<DangerStatement> setter) {
        super(parser, option, setter, DangerStatement.class);
    }

    @Override
    public String getDefaultMetaVariable() {
        return "<DANGER_STATEMENT>"; //$NON-NLS-1$
    }

    public static String getMetaVariable() {
        return Arrays.stream(DangerStatement.values())
                .map(DangerStatement::name)
                .collect(Collectors.joining(" | ", "DANGER_STATEMENT : [", "]")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }
}
