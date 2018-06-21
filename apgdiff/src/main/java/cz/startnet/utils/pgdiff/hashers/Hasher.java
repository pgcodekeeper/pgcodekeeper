package cz.startnet.utils.pgdiff.hashers;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Hasher {
    public void put(boolean b);
    public void put(Boolean b);
    public void put(String s);
    public void put(int i);
    public void put(Integer i);
    public void put(IHashable hashable);
    public void put(Enum<?> en);
    public void put(Map<String, String> map);
    public void put(List<String> col);
    public void put(Set<String> col);
    public void putOrdered(Collection<? extends IHashable> col);
    public void putUnordered(Collection<? extends IHashable> col);
}
