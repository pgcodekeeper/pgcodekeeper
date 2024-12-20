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
package ru.taximaxim.codekeeper.core.schema.meta;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.loader.pg.SupportedPgVersion;

public class MetaStorage implements Serializable {

    private static final long serialVersionUID = 8194906497159326596L;

    public static final String FILE_NAME = "SYSTEM_OBJECTS_";

    private static final ConcurrentMap<SupportedPgVersion, MetaStorage> STORAGE_CACHE = new ConcurrentHashMap<>();

    private final List<MetaStatement> definitions = new ArrayList<>();

    public void addMetaChild(MetaStatement meta) {
        definitions.add(meta);
    }

    static List<MetaStatement> getSystemObjects(SupportedPgVersion version) {
        MetaStorage storage = getObjectsFromResources(version);
        return storage != null ? storage.definitions : Collections.emptyList();
    }

    private static MetaStorage getObjectsFromResources(SupportedPgVersion ver) {
        MetaStorage db = STORAGE_CACHE.get(ver);
        if (db != null) {
            return db;
        }

        InputStream inputStream = MetaStorage.class.getResourceAsStream(FILE_NAME + ver + ".ser");

        Object object = Utils.deserialize(inputStream);
        if (object instanceof MetaStorage storage) {
            MetaStorage other = STORAGE_CACHE.putIfAbsent(ver, storage);
            return other == null ? storage : other;
        }

        return null;
    }
}
