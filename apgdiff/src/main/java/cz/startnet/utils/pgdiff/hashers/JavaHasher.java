package cz.startnet.utils.pgdiff.hashers;

import java.util.Collection;
import java.util.Map;

public class JavaHasher implements Hasher {

    private static final int PRIME = 31;

    private int result = 1;

    @Override
    public void put(boolean b) {
        result = PRIME * result + (b ? HashConstant.TRUE : HashConstant.FALSE);
    }

    @Override
    public void put(Boolean b) {
        result = PRIME * result + ((b == null) ? 0 : b.hashCode());
    }

    @Override
    public void put(String s) {
        result = PRIME * result + ((s == null) ? 0 : s.hashCode());
    }

    @Override
    public void put(int i) {
        result = PRIME * result + i;
    }

    @Override
    public void put(Integer i) {
        result = PRIME * result + ((i == null) ? 0 : i.hashCode());
    }

    @Override
    public void put(IHashable hashable) {
        result = PRIME * result + ((hashable == null) ? 0 : hashable.hashCode());
    }

    @Override
    public void put(Enum<?> en) {
        result = PRIME * result + ((en == null) ? 0 : en.hashCode());
    }

    @Override
    public void put(Map<String, String> map) {
        result = PRIME * result + map.hashCode();
    }

    @Override
    public void putOrderedStrings(Collection<String> col) {
        result = PRIME * result + col.hashCode();
    }

    @Override
    public void putUnorderedStrings(Collection<String> col) {
        result = PRIME * result + unordered(col);
    }

    @Override
    public void putOrdered(Collection<? extends IHashable> col) {
        result = PRIME * result + col.hashCode();
    }

    @Override
    public void putUnordered(Collection<? extends IHashable> col) {
        result = PRIME * result + unordered(col);
    }

    public int getResult() {
        return result;
    }

    private int unordered(Collection<?> c) {
        int h = 0;
        for (Object el : c) {
            h ^= el.hashCode();
        }
        return h;
    }
}
