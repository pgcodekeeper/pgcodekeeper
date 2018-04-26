package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;

public class SegmentsWithParent extends Segments implements IAdaptable {

    private final IFile parentFile;

    public SegmentsWithParent(PgObjLocation loc, IFile parentFile) {
        super(loc);
        this.parentFile = parentFile;
    }

    public IFile getParentFile() {
        return parentFile;
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        if (adapter.isAssignableFrom(IFile.class)) {
            return adapter.cast(parentFile);
        }
        return null;
    }
}
