package ru.taximaxim.codekeeper.ui.comparetools;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.compare.IStreamContentAccessor;
import org.eclipse.compare.ITypedElement;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.graphics.Image;

public class CompareItem implements IStreamContentAccessor, ITypedElement {

    public static final String SQL = "sql"; //$NON-NLS-1$

    private final String contents;
    private final String name;

    public CompareItem(String name, String contents) {
        this.name = name;
        this.contents = contents == null ? "" : contents; //$NON-NLS-1$
    }

    @Override
    public InputStream getContents() throws CoreException {
        return new ByteArrayInputStream(contents.getBytes());
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
        result = prime * result + ((contents == null) ? 0 : contents.hashCode());
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
            eq = name.equals(val.name) && contents.equals(val.contents);
        }

        return eq;
    }
}