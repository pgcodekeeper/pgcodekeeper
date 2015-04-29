package ru.taximaxim.codekeeper.apgdiff;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class UnixPrintWriter extends PrintWriter {
    
    private boolean autoFlush = false; 

    public UnixPrintWriter(Writer out) {
        super(out);
    }

    public UnixPrintWriter(OutputStream out) {
        super(out);
    }

    public UnixPrintWriter(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public UnixPrintWriter(File file) throws FileNotFoundException {
        super(file);
    }

    public UnixPrintWriter(Writer out, boolean autoFlush) {
        super(out, autoFlush);
        this.autoFlush = autoFlush;
    }

    public UnixPrintWriter(OutputStream out, boolean autoFlush) {
        super(out, autoFlush);
        this.autoFlush = autoFlush;
    }

    public UnixPrintWriter(String fileName, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        super(fileName, csn);
    }

    public UnixPrintWriter(File file, String csn) throws FileNotFoundException,
            UnsupportedEncodingException {
        super(file, csn);
    }
    
    /**
     * {@inheritDoc}
     * <br><br>
     * This version always terminates with '\n'.
     */
    @Override
    public void println() {
        try {
            synchronized (lock) {
                print('\n');
                if (autoFlush) {
                    out.flush();
                }
            }
        }
        catch (InterruptedIOException x) {
            Thread.currentThread().interrupt();
        }
        catch (IOException x) {
            setError();
        }
    }
}
