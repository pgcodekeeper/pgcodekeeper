package cz.startnet.utils.pgdiff.hashers;

import java.util.Collection;
import java.util.Map;

public interface Hasher {
    public void put(boolean b);
    public void put(Boolean b);
    public void put(String s);
    public void put(int i);
    public void put(Integer i);
    public void put(IHashable hashable);
    public void put(Enum<?> en);
    public void put(Map<String, String> map);
    public void putOrderedStrings(Collection<String> col);
    public void putUnorderedStrings(Collection<String> col);
    public void putOrdered(Collection<? extends IHashable> col);
    public void putUnordered(Collection<? extends IHashable> col);
}
