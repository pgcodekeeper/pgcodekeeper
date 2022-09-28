package ru.taximaxim.codekeeper.core.schema;

import java.util.Objects;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.hashers.IHashable;
import ru.taximaxim.codekeeper.core.hashers.JavaHasher;

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