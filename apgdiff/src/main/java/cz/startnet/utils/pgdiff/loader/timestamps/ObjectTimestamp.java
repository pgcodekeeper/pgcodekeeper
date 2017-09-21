package cz.startnet.utils.pgdiff.loader.timestamps;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((object == null) ? 0 : object.hashCode());
        result = prime * result + ((modificationTime == null) ? 0 : modificationTime.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof ObjectTimestamp) {
            ObjectTimestamp t = (ObjectTimestamp) obj;
            eq = Objects.equals(object, t.object)
                    && Objects.equals(modificationTime, t.modificationTime);
        }

        return eq;
    }

}
