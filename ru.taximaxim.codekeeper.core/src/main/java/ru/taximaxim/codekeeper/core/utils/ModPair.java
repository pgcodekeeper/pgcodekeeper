/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.utils;

public class ModPair<K, V> extends Pair<K, V> {

    private static final long serialVersionUID = 7623190777562696369L;

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
