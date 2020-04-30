package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrTask;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public abstract class DatabaseLoader {

    protected final List<Object> errors;

    protected final Queue<AntlrTask<?>> antlrTasks = new ArrayDeque<>();
    protected final Queue<DatabaseLoader> launchedLoaders = new ArrayDeque<>();

    /**
     * Loads database schema with analyze.
     *
     * @return database schema
     */
    public PgDatabase loadAndAnalyze() throws IOException, InterruptedException {
        PgDatabase d = load();
        FullAnalyze.fullAnalyze(d, errors);
        return d;
    }

    /**
     * Loads database schema without analyze.
     *
     * @return database schema
     */
    public abstract PgDatabase load() throws IOException, InterruptedException;

    public DatabaseLoader() {
        this(new ArrayList<>());
    }

    public DatabaseLoader(List<Object> errors) {
        this.errors = errors;
    }

    public List<Object> getErrors() {
        return errors;
    }

    protected void finishLoaders() throws InterruptedException, IOException {
        AntlrParser.finishAntlr(antlrTasks);
        DatabaseLoader l;
        while ((l = launchedLoaders.poll()) != null) {
            finishLoader(l);
        }
    }

    protected void finishLoader(DatabaseLoader l) {
        if (errors != null) {
            errors.addAll(l.getErrors());
        }
    }
}
