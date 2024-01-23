/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;

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

    public UnixPrintWriter(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        super(file, csn);
    }

    public UnixPrintWriter(OutputStream out, String csn) throws UnsupportedEncodingException {
        this(new BufferedWriter(new OutputStreamWriter(out, csn)), false);
    }

    public UnixPrintWriter(String fileName, Charset csn) throws FileNotFoundException {
        this(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName)), csn)), false);
    }

    public UnixPrintWriter(File file, Charset csn) throws FileNotFoundException {
        this(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), csn)), false);
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
