package ru.taximaxim.codekeeper.ui.comparetools;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.compare.IStreamContentAccessor;
import org.eclipse.compare.ITypedElement;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.graphics.Image;

public class CompareItem implements IStreamContentAccessor, ITypedElement {

    private final String contents;
    private final String name;

    public CompareItem(String name, String contents) {
        this.name = name;
        this.contents = contents;
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
        //doesn't matter
        return "sql"; //$NON-NLS-1$
    }
}