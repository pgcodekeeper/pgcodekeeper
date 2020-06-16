package cz.startnet.utils.pgdiff.parsers.antlr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.NullProgressMonitor;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.ParserListenerMode;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;

public class ScriptParser {

    private final String script;

    private final List<PgObjLocation> batches;
    private final List<Object> errors;
    private final Set<DangerStatement> dangerStatements;

    public ScriptParser(String name, String script, boolean isMsSql)
            throws IOException, InterruptedException {
        this.script = script;
        PgDiffArguments args = new PgDiffArguments();
        args.setMsSql(isMsSql);
        PgDumpLoader loader = new PgDumpLoader(
                () -> new ByteArrayInputStream(script.getBytes(StandardCharsets.UTF_8)),
                name, args, new NullProgressMonitor(), 0);
        loader.setMode(ParserListenerMode.SCRIPT);
        // script mode collects only references
        batches = loader.load().getObjReferences().getOrDefault(name, Collections.emptyList());

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
            sb.append("Errors while parse script:\n");
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
