package cz.startnet.utils.pgdiff.loader.jdbc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Consumer;

import cz.startnet.utils.pgdiff.schema.GenericColumn;

public class AntlrTask<T> {

    private final Future<T> future;
    private final Consumer<T> finalizer;
    final GenericColumn object;

    public AntlrTask(Future<T> future, Consumer<T> finalizer, GenericColumn object) {
        this.future = future;
        this.finalizer = finalizer;
        this.object = object;
    }

    public void finish() throws InterruptedException, ExecutionException {
        finalizer.accept(future.get());
    }
}
