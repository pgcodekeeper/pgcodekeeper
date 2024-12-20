/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.hashers;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public void put(float f) {
        result = PRIME * result + Float.hashCode(f);
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
    public void put(List<String> col) {
        result = PRIME * result + col.hashCode();
    }

    @Override
    public void put(Set<String> col) {
        result = PRIME * result + col.hashCode();
    }

    @Override
    public void putOrdered(Collection<? extends IHashable> col) {
        result = PRIME * result + ordered(col);
    }

    @Override
    public void putUnordered(Collection<? extends IHashable> col) {
        result = PRIME * result + unordered(col);
    }

    public int getResult() {
        return result;
    }

    @Override
    public void putUnordered(Map<String, ? extends IHashable> map) {
        result = PRIME * result + map.hashCode();
    }

    private int unordered(Collection<?> c) {
        int h = 0;
        for (Object el : c) {
            h ^= el.hashCode();
        }
        return h;
    }

    private int ordered(Collection<?> c) {
        int h = 1;
        for (Object el : c) {
            h = PRIME * h + el.hashCode();
        }
        return h;
    }
}
