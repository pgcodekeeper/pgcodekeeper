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

    @Override
    protected boolean compare(Object obj) {
        if (super.compare(obj) && obj instanceof SegmentsWithParent) {
            return parentFile.equals(((SegmentsWithParent) obj).getParentFile());
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return prime * super.hashCode() + ((parentFile == null) ? 0 : parentFile.hashCode());
    }
}
