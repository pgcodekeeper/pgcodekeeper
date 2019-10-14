package ru.taximaxim.codekeeper.apgdiff.utils;

import java.io.Serializable;

/**
 * Objects of this class are unmodifiable.
 * Use {@link ModPair} and {@link #copyMod()} to get modifiable Pairs.
 */
public class Pair<K, V> implements Serializable {

    private static final long serialVersionUID = 3151284706296455602L;

    protected K first;
    protected V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond(){
        return second;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((first == null) ? 0 : first.hashCode());
        result = prime * result + ((second == null) ? 0 : second.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Pair<?, ?> other = (Pair<?, ?>) obj;
        if (first == null) {
            if (other.first != null) {
                return false;
            }
        } else if (!first.equals(other.first)) {
            return false;
        }
        if (second == null) {
            if (other.second != null) {
                return false;
            }
        } else if (!second.equals(other.second)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "(" + first + " - " + second + ")";
    }

    public Pair<K, V> copy() {
        return new Pair<>(first, second);
    }

    public ModPair<K, V> copyMod() {
        return new ModPair<>(first, second);
    }
}
