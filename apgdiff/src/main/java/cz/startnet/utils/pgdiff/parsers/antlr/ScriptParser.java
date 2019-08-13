package cz.startnet.utils.pgdiff.parsers.antlr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.ParserListenerMode;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.loader.QueryLocation;
import ru.taximaxim.codekeeper.apgdiff.Log;

public class ScriptParser {

    private final String script;
    private final PgDumpLoader loader;

    public ScriptParser(String name, String script, boolean isMsSql) {
        this.script = script;
        PgDiffArguments args = new PgDiffArguments();
        args.setMsSql(isMsSql);
        loader = new PgDumpLoader(
                () -> new ByteArrayInputStream(script.getBytes(StandardCharsets.UTF_8)),
                name, args, new NullProgressMonitor(), 0);
        loader.setMode(ParserListenerMode.SCRIPT);

        try {
            Queue<AntlrTask<?>> antlrTasks = new ArrayDeque<>();
            loader.loadDatabase(null, antlrTasks);
            AntlrParser.finishAntlr(antlrTasks);
        } catch (InterruptedException e) {
            Log.log(e);
            // Restore interrupted state...
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            Log.log(e);
        }
    }

    public List<List<QueryLocation>> batch() {
        return loader.batch();
    }

    public boolean isDangerDdl(Collection<DangerStatement> allowedDangers) {
        return loader.isDangerDdl(allowedDangers);
    }

    public Set<DangerStatement> getDangerDdl(Collection<DangerStatement> allowedDangers) {
        return loader.getDangerDdl(allowedDangers);
    }


    public String getErrorMessage() {
        List<AntlrError> errors = loader.getErrors();
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
