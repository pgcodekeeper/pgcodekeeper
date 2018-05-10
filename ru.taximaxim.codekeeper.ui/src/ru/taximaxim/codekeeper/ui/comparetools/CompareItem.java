package ru.taximaxim.codekeeper.ui.comparetools;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.eclipse.compare.IEncodedStreamContentAccessor;
import org.eclipse.compare.ITypedElement;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.graphics.Image;

public class CompareItem implements IEncodedStreamContentAccessor, ITypedElement {

    public static final String SQL = "sql"; //$NON-NLS-1$

    private final byte[] contents;
    private final String name;

    public CompareItem(String name, String contents) {
        this.name = name;
        this.contents = contents == null ? null : contents.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public String getCharset() throws CoreException {
        return StandardCharsets.UTF_8.toString();
    }

    @Override
    public InputStream getContents() throws CoreException {
        return contents == null ? null : new ByteArrayInputStream(contents);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public String getType() {
        return SQL;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(contents);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof CompareItem) {
            CompareItem val = (CompareItem) obj;
            eq = name.equals(val.name) && Arrays.equals(contents, val.contents);
        }

        return eq;
    }
}