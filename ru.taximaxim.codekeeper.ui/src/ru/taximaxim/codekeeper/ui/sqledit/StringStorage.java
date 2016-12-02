package ru.taximaxim.codekeeper.ui.sqledit;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.eclipse.core.resources.IEncodedStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

public class StringStorage implements IEncodedStorage {

    private final ByteArrayInputStream stream;
    private final String name;

    public StringStorage(String str, String name) {
        this.stream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        this.name = name;
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        return null;
    }

    @Override
    public InputStream getContents() throws CoreException {
        return stream;
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
