package cz.startnet.utils.pgdiff.schema;

import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import cz.startnet.utils.pgdiff.hashers.IHashable;
import cz.startnet.utils.pgdiff.hashers.JavaHasher;

public class Inherits implements IHashable {

    private final String key;
    private final String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Inherits(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getQualifiedName() {
        return (key == null ? "" : (PgDiffUtils.getQuotedName(key) + '.'))
                + PgDiffUtils.getQuotedName(value);
    }

    @Override
    public int hashCode() {
        JavaHasher hasher = new JavaHasher();
        computeHash(hasher);
        return hasher.getResult();
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(key);
        hasher.put(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Inherits) {
            Inherits other = (Inherits) obj;
            return Objects.equals(key, other.key)
                    && Objects.equals(value, other.value);
        }
        return false;
    }
}