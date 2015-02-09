
package ru.taximaxim.codekeeper.ui.externalcalls.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.MessageFormat;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.consoles.ConsoleFactory;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class StdStreamRedirector {
    
    private StringBuilder storage = new StringBuilder();
    
    public String getStorage() {
        return storage.toString();
    }
    
    /**
     * A Runnable that consumes everything from the {@link InputStream},
     * redirects data to {@link ConsoleFactory} and stores it as a String.
     * 
     * @author Alexander Levsha
     */
    private static class StdStreamRedirectorWorker implements Runnable {

        private BufferedReader in;
        private StringBuilder storage;
        private AtomicBoolean isDestroyed = new AtomicBoolean(false);
        
        /**
         * @param in {@link InputStream} to 
         */
        StdStreamRedirectorWorker(InputStream in, StringBuilder storage) {
            this.in = new BufferedReader(new InputStreamReader(in));
            this.storage = storage;
        }
        
        @Override
        public void run() {
            String line = null;
            try {
                while((line = in.readLine()) != null) {
                    ConsoleFactory.write(line);
                    storage.append(line);
                    storage.append(UIConsts._NL);
                }
            } catch(IOException ex) {
                if (isDestroyed.get()) {
                    // the process was destroyed by us, exit silently
                    return;
                }
                throw new IllegalStateException(
                        Messages.StdStreamRedirector_error_reading_std, ex);
            }
        }
    }
    
    /**
     * Launches a process combining stdout & stderr and redirecting them
     * onto {@link ConsoleFactory}. Blocks until process exits and all output is consumed.
     * 
     * @param pb process to start
     * @param returnedValue reference to Integer to store returned value, may be null 
     * @return captured stdout & stderr output
     * @throws IOException
     */
    public String launchAndRedirect(ProcessBuilder pb) throws IOException {
        StringBuilder sb = new StringBuilder();
        for(String param : pb.command()) {
            sb.append(param);
            sb.append(' ');
        }
        String cmd = sb.toString();
        ConsoleFactory.write(cmd);
        
        pb.redirectErrorStream(true);
        final Process p = pb.start();
        
        final StdStreamRedirectorWorker redirector = new StdStreamRedirectorWorker(
                p.getInputStream(), storage);
        try (BufferedReader t = redirector.in) {
            Thread redirectorThread = new Thread(redirector);
            final AtomicReference<Throwable> lastException = new AtomicReference<>();
            redirectorThread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    lastException.set(e);
                    redirector.isDestroyed.set(true);
                    p.destroy();
                }
            });
            redirectorThread.start();
            
            try {
                p.waitFor();
            } catch (InterruptedException ex) {
                redirector.isDestroyed.set(true);
                p.destroy();
                try {
                    // wait for destroy to get the exitValue()
                    p.waitFor();
                } catch (InterruptedException ex2) {
                    throw new IOException(
                            Messages.StdStreamRedirector_wait_destroy_interrupted_unexpectedly, ex2);
                }
            }
            
            try {
                redirectorThread.join();
            } catch (InterruptedException ex) {
                throw new IOException(
                        Messages.StdStreamRedirector_wait_thread_interrupted_unexpectedly, ex);
            }
            ConsoleFactory.write(MessageFormat.format(
                    Messages.stdStreamRedirector_completed_with_code, pb
                            .command().get(0), p.exitValue()));

            if (!redirector.isDestroyed.get() && p.exitValue() != 0) {
                throw new IOException(MessageFormat.format(Messages.StdStreamRedirector_process_returned_with_error,
                                        p.exitValue()));
            }
            
            if (lastException.get() != null){
                throw new IOException(Messages.StdStreamRedirector_error_reading_std_external,
                        lastException.get());
            }
            return storage.toString();
        } finally {
            StringBuilder msg = new StringBuilder(cmd.length() + storage.length() + 128);
            msg.append("External command:") //$NON-NLS-1$
                .append(UIConsts._NL)
                .append(cmd)
                .append(UIConsts._NL)
                .append("Output: ") //$NON-NLS-1$
                .append(UIConsts._NL)
                .append(storage);
            
            Log.log(Log.LOG_INFO, msg.toString());
        }
    }
}
