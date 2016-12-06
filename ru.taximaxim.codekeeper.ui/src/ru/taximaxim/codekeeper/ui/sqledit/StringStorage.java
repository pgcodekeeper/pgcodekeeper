package ru.taximaxim.codekeeper.ui.sqledit;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.eclipse.core.resources.IEncodedStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

public class StringStorage implements IEncodedStorage {

    private final byte[] content;
    private final String name;

    public StringStorage(String str, String name) {
        this.content = str.getBytes(StandardCharsets.UTF_8);
        this.name = name;
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        return null;
    }

    @Override
    public InputStream getContents() throws CoreException {
        // return a fresh stream of the same content for repeated reads
        return new ByteArrayInputStream(content);
    }

    @Override
    public IPath getFullPath() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public String getCharset() throws CoreException {
        return StandardCharsets.UTF_8.name();
    }
}
