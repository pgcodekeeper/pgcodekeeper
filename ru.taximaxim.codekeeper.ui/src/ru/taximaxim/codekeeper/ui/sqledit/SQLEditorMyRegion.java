package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.jface.text.IRegion;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;

public class SQLEditorMyRegion implements IRegion {

    private final PgObjLocation pgObjLocation;
    private final String comment;

    public SQLEditorMyRegion(PgObjLocation pgObjLocation, String comment) {
        this.pgObjLocation = pgObjLocation;
        this.comment = comment;
    }

    @Override
    public int getLength() {
        return pgObjLocation.getObjLength();
    }

    @Override
    public int getOffset() {
        return pgObjLocation.getOffset();
    }

    public PgObjLocation getPgObjLocation() {
        return pgObjLocation;
    }

    public String getComment() {
        return comment;
    }
}
