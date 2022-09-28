package ru.taximaxim.codekeeper.core.fileutils;

import java.io.IOException;
import java.io.InputStream;

@FunctionalInterface
public interface InputStreamProvider {
    InputStream getStream() throws IOException;
}
