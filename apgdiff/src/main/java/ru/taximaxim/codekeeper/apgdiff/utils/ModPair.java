package ru.taximaxim.codekeeper.apgdiff.utils;

public class ModPair<K, V> extends Pair<K, V> {

    private static final long serialVersionUID = -7969872100428006517L;

    public ModPair(K first, V second) {
        super(first, second);
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public V setSecond(V second) {
        V old = this.second;
        this.second = second;
        return old;
    }
}
