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
package ru.taximaxim.codekeeper.core.hashers;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Hasher {
    public void put(boolean b);
    public void put(Boolean b);
    public void put(String s);
    public void put(float f);
    public void put(int i);
    public void put(Integer i);
    public void put(IHashable hashable);
    public void put(Enum<?> en);
    public void put(Map<String, String> map);
    public void put(List<String> col);
    public void put(Set<String> col);
    public void putOrdered(Collection<? extends IHashable> col);
    public void putUnordered(Collection<? extends IHashable> col);
    public void putUnordered(Map<String, ? extends IHashable> map);
}
