package cz.startnet.utils.pgdiff.parsers.antlr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
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

    private final Map<String, Set<PgObjLocation>> batches;
    private final List<AntlrError> errors;
    private final Set<DangerStatement> dangerStatements;

    public ScriptParser(String filePath, String script, boolean isMsSql)
            throws IOException, InterruptedException {
        this.script = script;
        PgDiffArguments args = new PgDiffArguments();
        args.setMsSql(isMsSql);
        PgDumpLoader loader = new PgDumpLoader(
                () -> new ByteArrayInputStream(script.getBytes(StandardCharsets.UTF_8)),
                filePath, args, new NullProgressMonitor(), 0);
        loader.setMode(ParserListenerMode.SCRIPT);
        batches = loader.load().getObjDefinitions();
        dangerStatements = batches.get(filePath).stream()
                .filter(PgObjLocation::isDanger)
                .map(PgObjLocation::getDanger)
                .collect(Collectors.toSet());
        errors = loader.getErrors();
    }

    public Map<String, Set<PgObjLocation>> batch() {
        return batches;
    }

    public boolean isDangerDdl(Collection<DangerStatement> allowedDangers) {
        return !allowedDangers.containsAll(dangerStatements);
    }

    public Set<DangerStatement> getDangerDdl(Collection<DangerStatement> allowedDangers) {
        Set<DangerStatement> danger = EnumSet.noneOf(DangerStatement.class);

        for (DangerStatement d : dangerStatements) {
            if (!allowedDangers.contains(d)) {
                danger.add(d);
            }
        }

        return danger;
    }

    public String getErrorMessage() {
        if (!errors.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Errors while parse script:\n");
            for (AntlrError er : errors) {
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
