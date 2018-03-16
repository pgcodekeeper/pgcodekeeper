package cz.startnet.utils.pgdiff.loader.jdbc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Consumer;

import org.antlr.v4.runtime.ParserRuleContext;

public class AntlrTask<T extends ParserRuleContext> {

    private final Future<T> future;
    private final Consumer<T> finalizer;

    public AntlrTask(Future<T> future, Consumer<T> finalizer) {
        this.future = future;
        this.finalizer = finalizer;
    }

    public void finish() throws InterruptedException, ExecutionException {
        finalizer.accept(future.get());
    }
}
