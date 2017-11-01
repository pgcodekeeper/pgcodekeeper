package cz.startnet.utils.pgdiff.loader.jdbc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.BiConsumer;

import org.antlr.v4.runtime.ParserRuleContext;

public class AntlrTask<T extends ParserRuleContext, PgDatabase> {

    private final Future<T> future;
    private final BiConsumer<T, PgDatabase> finalizer;
    private final PgDatabase dataBase;

    public AntlrTask(Future<T> future, BiConsumer<T, PgDatabase> finalizer, PgDatabase dataBase) {
        this.future = future;
        this.finalizer = finalizer;
        this.dataBase = dataBase;
    }

    public void finish() throws InterruptedException, ExecutionException {
        finalizer.accept(future.get(), dataBase);
    }
}
