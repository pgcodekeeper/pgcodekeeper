package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.core.resources.IFile;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;

public class SegmentsWithParent extends Segments {

    private final IFile parentFile;

    public SegmentsWithParent(PgObjLocation loc, IFile parentFile) {
        super(loc);
        this.parentFile = parentFile;
    }

    public IFile getParentFile() {
        return parentFile;
    }
}
