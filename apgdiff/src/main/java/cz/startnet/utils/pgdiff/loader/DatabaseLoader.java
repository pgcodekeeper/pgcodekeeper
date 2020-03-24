package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrTask;

public class DatabaseLoader {

    protected final List<Object> errors;

    protected final Queue<AntlrTask<?>> antlrTasks = new ArrayDeque<>();
    protected final Queue<PgDumpLoader> launchedLoaders = new ArrayDeque<>();

    public DatabaseLoader(List<Object> errors) {
        this.errors = errors;
    }

    public List<Object> getErrors() {
        return errors;
    }

    protected void finishLoaders() throws InterruptedException, IOException {
        AntlrParser.finishAntlr(antlrTasks);
        PgDumpLoader l;
        while ((l = launchedLoaders.poll()) != null) {
            finishLoader(l);
        }
    }

    protected void finishLoader(PgDumpLoader l) {
        if (errors != null) {
            errors.addAll(l.getErrors());
        }
    }
}
