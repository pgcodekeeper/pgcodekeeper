package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.Objects;

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
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hashCode(parentFile);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SegmentsWithParent other = (SegmentsWithParent) obj;
        return Objects.equals(parentFile, other.parentFile);
    }
}
