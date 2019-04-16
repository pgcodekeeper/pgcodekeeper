
package ru.taximaxim.codekeeper.ui.externalcalls.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.concurrent.atomic.AtomicReference;

import cz.startnet.utils.pgdiff.IProgressReporter;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.consoles.UiProgressReporter;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class StdStreamRedirector {

    private final IProgressReporter reporter;
    private volatile boolean isDestroyed = false;

    public StdStreamRedirector(IProgressReporter reporter) {
        this.reporter = reporter;
    }

    private class StdStreamRedirectorWorker implements Runnable {

        private final BufferedReader in;

        StdStreamRedirectorWorker(InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        @Override
        public void run() {
            try {
                for (String line; (line = in.readLine()) != null;) {
                    reporter.writeError(line);
                }
            } catch(IOException ex) {
                if (isDestroyed) {
                    // the process was destroyed by us, exit silently
                    return;
                }
                throw new IllegalStateException(MessageFormat.format(
                        Messages.StdStreamRedirector_error_reading_std,
                        ex.getLocalizedMessage()), ex);
            }
        }
    }

    /**
     * Launches a process redirecting stderr messages into {@link UiProgressReporter}.
     * Stdout is read and returned after the process finishes.<br>
     * Blocks until process finishes and all output is consumed.
     *
     * @param pb process to start
     * @return captured stdout output
     * @throws IOException
     */
    public byte[] launchAndRedirect(ProcessBuilder pb) throws IOException {
        String cmd = String.join(" ", pb.command()); //$NON-NLS-1$
        Log.log(Log.LOG_INFO, cmd);
        reporter.writeMessage(cmd);

        Process p = pb.start();
        try (InputStream in = p.getInputStream(); InputStream err = p.getErrorStream()) {
            Thread redirectorThread = new Thread(new StdStreamRedirectorWorker(err));
            AtomicReference<Throwable> lastException = new AtomicReference<>();
            redirectorThread.setUncaughtExceptionHandler((t1, e) -> {
                lastException.set(e);
                isDestroyed = true;
                p.destroy();
            });
            redirectorThread.start();

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = in.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }

            try {
                p.waitFor();
            } catch (InterruptedException ex) {
                isDestroyed = true;
                p.destroy();
                try {
                    // wait for destroy to get the exitValue()
                    p.waitFor();
                } catch (InterruptedException ex2) {
                    throw new IOException(
                            MessageFormat.format(
                                    Messages.StdStreamRedirector_wait_destroy_interrupted_unexpectedly,
                                    ex2.getLocalizedMessage()), ex2);
                }
            }
            int exitValue = p.exitValue();

            try {
                redirectorThread.join();
            } catch (InterruptedException ex) {
                throw new IOException(
                        MessageFormat.format(
                                Messages.StdStreamRedirector_wait_thread_interrupted_unexpectedly,
                                ex.getLocalizedMessage()), ex);
            }
            reporter.writeMessage(MessageFormat.format(
                    Messages.stdStreamRedirector_completed_with_code, pb
                    .command().get(0), exitValue));

            if (!isDestroyed && 0 != exitValue) {
                throw new IOException(MessageFormat.format(
                        Messages.StdStreamRedirector_process_returned_with_error,
                        exitValue));
            }

            if (lastException.get() != null) {
                throw new IOException(MessageFormat.format(
                        Messages.StdStreamRedirector_error_reading_std_external,
                        lastException.get().getLocalizedMessage()), lastException.get());
            }

            return buffer.toByteArray();
        }
    }
}
