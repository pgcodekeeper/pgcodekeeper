/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.parsers.antlr;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DaemonThreadFactory;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.MonitorCancelledRuntimeException;

public final class AntlrTaskManager {

    private static final int POOL_SIZE = Integer.max(1,
            Integer.getInteger(Consts.POOL_SIZE, Runtime.getRuntime().availableProcessors() - 1));

    private static final ExecutorService ANTLR_POOL =
            Executors.newFixedThreadPool(POOL_SIZE, new DaemonThreadFactory());

    public static int getPoolSize() {
        return POOL_SIZE;
    }

    public static <T> Future<T> submit(Callable<T> task) {
        return ANTLR_POOL.submit(task);
    }

    public static <T> void submit(Queue<AntlrTask<?>> antlrTasks, Callable<T> task, Consumer<T> finalizer) {
        Future<T> future = submit(task);
        antlrTasks.add(new AntlrTask<>(future, finalizer));
    }

    public static void finish(Queue<AntlrTask<?>> antlrTasks) throws InterruptedException, IOException {
        AntlrTask<?> task;
        try {
            while ((task = antlrTasks.poll()) != null) {
                task.finish();
            }
        } catch (ExecutionException ex) {
            handleAntlrTaskException(ex);
        } catch (MonitorCancelledRuntimeException ex) {
            // finalizing parser listeners' cancellations will reach here
            throw new InterruptedException();
        }
    }

    /**
     * Uwraps potential parser Interrupted and IO Exceptions from ExecutionException.<br>
     * If non-standard parser exception is caught in the wrapper, it is rethrown
     * as an IllegalStateException.
     *
     * @throws InterruptedException
     * @throws IOException
     * @throws IllegalStateException
     */
    private static void handleAntlrTaskException(ExecutionException ex)
            throws InterruptedException, IOException {
        Throwable t = ex.getCause();
        if (t instanceof InterruptedException in) {
            throw in;
        }
        if (t instanceof IOException io) {
            throw io;
        }

        throw new IllegalStateException(ex);
    }

    private AntlrTaskManager() {
        // only static
    }
}