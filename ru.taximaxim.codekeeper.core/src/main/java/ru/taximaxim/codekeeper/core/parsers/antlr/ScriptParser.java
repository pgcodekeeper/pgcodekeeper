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
package ru.taximaxim.codekeeper.core.parsers.antlr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.loader.ParserListenerMode;
import ru.taximaxim.codekeeper.core.loader.PgDumpLoader;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public final class ScriptParser {

    private static final Logger LOG = LoggerFactory.getLogger(ScriptParser.class);
    private final String script;

    private final List<PgObjLocation> batches;
    private final List<Object> errors;
    private final Set<DangerStatement> dangerStatements;

    public ScriptParser(String name, String script, DatabaseType dbType)
            throws IOException, InterruptedException {
        this.script = script;
        PgDiffArguments args = new PgDiffArguments();
        args.setDbType(dbType);
        LOG.info(Messages.ScriptParser_log_load_dump);
        PgDumpLoader loader = new PgDumpLoader(
                () -> new ByteArrayInputStream(script.getBytes(StandardCharsets.UTF_8)),
                name, args, new NullProgressMonitor(), 0);
        loader.setMode(ParserListenerMode.SCRIPT);
        // script mode collects only references
        batches = new ArrayList<>(loader.load().getObjReferences(name));

        dangerStatements = batches.stream()
                .filter(PgObjLocation::isDanger)
                .map(PgObjLocation::getDanger)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(DangerStatement.class)));
        errors = loader.getErrors();
    }

    public List<PgObjLocation> batch() {
        return batches;
    }

    public boolean isDangerDdl(Collection<DangerStatement> allowedDangers) {
        return !allowedDangers.containsAll(dangerStatements);
    }

    public Set<DangerStatement> getDangerDdl(Collection<DangerStatement> allowedDangers) {
        Set<DangerStatement> danger = EnumSet.copyOf(dangerStatements);
        danger.removeAll(allowedDangers);
        return danger;
    }

    public String getErrorMessage() {
        if (!errors.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Errors while parse script:\n"); //$NON-NLS-1$
            for (Object er : errors) {
                sb.append(er).append('\n');
            }
            return sb.toString();
        }

        return null;
    }

    public String getScript() {
        return script;
    }
}
