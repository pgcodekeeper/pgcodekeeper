
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
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.consoles.UiProgressReporter;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class StdStreamRedirector {

    private byte[] outStorage;
    private final StringBuilder errStorage = new StringBuilder();
    private final IProgressReporter reporter;
    private volatile boolean isDestroyed = false;

    public StdStreamRedirector(IProgressReporter reporter) {
        this.reporter = reporter;
    }

    public byte[] getInputArray() {
        return outStorage;
    }

    /**
     * A Runnable that consumes everything from the {@link InputStream},
     * redirects data to {@link UiProgressReporter} and stores it as a String.
     *
     * @author Alexander Levsha
     */
    private class StdStreamRedirectorWorker implements Runnable {

        private final BufferedReader in;
        private final StringBuilder storage;
        private final IProgressReporter reporter;
        /**
         * @param in {@link InputStream} to
         * @param reporter
         */
        StdStreamRedirectorWorker(InputStream in, StringBuilder storage,
                IProgressReporter reporter) {
            this.in = new BufferedReader(new InputStreamReader(in));
            this.storage = storage;
            this.reporter = reporter;
        }

        @Override
        public void run() {
            String line = null;
            try {
                while((line = in.readLine()) != null) {
                    reporter.writeError(line);
                    storage.append(line);
                    storage.append(UIConsts._NL);
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
     * Launches a process combining stdout & stderr and redirecting them
     * onto {@link UiProgressReporter}. Blocks until process exits and all output is consumed.
     *
     * @param pb process to start
     * @param returnedValue reference to Integer to store returned value, may be null
     * @return captured stdout & stderr output
     * @throws IOException
     */
    public void launchAndRedirect(ProcessBuilder pb) throws IOException {
        String cmd = String.join(" ", pb.command());
        reporter.writeMessage(cmd);

        final Process p = pb.start();

        final StdStreamRedirectorWorker redirectorErr = new StdStreamRedirectorWorker(
                p.getErrorStream(), errStorage, reporter);

        try (InputStream in = p.getInputStream();
                BufferedReader err = redirectorErr.in) {

            Thread redirectorThreadErr = new Thread(redirectorErr);
            final AtomicReference<Throwable> lastExceptionErr = new AtomicReference<>();
            redirectorThreadErr.setUncaughtExceptionHandler((t1, e) -> {
                lastExceptionErr.set(e);
                isDestroyed = true;
                p.destroy();
            });
            redirectorThreadErr.start();

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

            try {
                redirectorThreadErr.join();
                InputStream os = p.getInputStream();
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                int nRead;
                byte[] data = new byte[1024];
                while ((nRead = os.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, nRead);
                }

                buffer.flush();
                outStorage = buffer.toByteArray();
            } catch (InterruptedException ex) {
                throw new IOException(
                        MessageFormat.format(
                                Messages.StdStreamRedirector_wait_thread_interrupted_unexpectedly,
                                ex.getLocalizedMessage()), ex);
            }
            reporter.writeMessage(MessageFormat.format(
                    Messages.stdStreamRedirector_completed_with_code, pb
                    .command().get(0), p.exitValue()));

            if (!isDestroyed && p.exitValue() != 0) {
                throw new IOException(MessageFormat.format(Messages.StdStreamRedirector_process_returned_with_error,
                        p.exitValue()));
            }

            if (lastExceptionErr.get() != null) {
                throw new IOException(MessageFormat.format(Messages.StdStreamRedirector_error_reading_std_external,
                        lastExceptionErr.get()), lastExceptionErr.get());
            }
        } finally {
            StringBuilder msg = new StringBuilder(cmd.length() + 128);
            msg.append("External command:") //$NON-NLS-1$
            .append(UIConsts._NL)
            .append(cmd)
            .append(UIConsts._NL);

            Log.log(Log.LOG_INFO, msg.toString());
        }
    }
}
