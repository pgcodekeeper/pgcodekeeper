package ru.taximaxim.codekeeper.ui.differ.timestamps;

import java.io.Serializable;
import java.time.Instant;

import cz.startnet.utils.pgdiff.schema.GenericColumn;

public class ObjectTimestamp implements Serializable{

    private static final long serialVersionUID = 6000537650992667481L;

    private final GenericColumn object;
    private final String hash;
    private final Instant modificationTime;

    public ObjectTimestamp(GenericColumn object, String hash, Instant modificationtime) {
        this.object = object;
        this.hash = hash;
        this.modificationTime = modificationtime;
    }

    public GenericColumn getObject() {
        return object;
    }

    public String getHash() {
        return hash;
    }

    public Instant getModificationTime() {
        return modificationTime;
    }

}
