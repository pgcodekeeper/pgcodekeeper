package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrTask;

public class DatabaseLoader {

    protected final List<? super AntlrError> errors;

    protected final Queue<AntlrTask<?>> antlrTasks = new ArrayDeque<>();
    protected final Queue<PgDumpLoader> launchedLoaders = new ArrayDeque<>();

    public DatabaseLoader(List<? super AntlrError> errors) {
        this.errors = errors;
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
