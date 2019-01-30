package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Consumer;

public class AntlrTask<T> {

    private final Future<T> future;
    private final Consumer<T> finalizer;

    public AntlrTask(Future<T> future, Consumer<T> finalizer) {
        this.future = future;
        this.finalizer = finalizer;
    }

    public void finish() throws ExecutionException {
        T t;
        try {
            t = future.get();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new ExecutionException(ex);
        }
        finalizer.accept(t);
    }
}
