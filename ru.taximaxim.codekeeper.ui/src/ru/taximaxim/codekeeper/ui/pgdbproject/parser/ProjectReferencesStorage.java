/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import org.pgcodekeeper.core.schema.PgObjLocation;
import org.pgcodekeeper.core.schema.meta.MetaStatement;

class ProjectReferencesStorage implements Serializable {

    private static final long serialVersionUID = 2641369996771272168L;

    private final Map<String, List<MetaStatement>> objDefinitions = new ConcurrentHashMap<>();
    private final Map<String, Set<PgObjLocation>> objReferences = new ConcurrentHashMap<>();

    Set<PgObjLocation> getObjReferencesForPath(String pathToFile) {
        return objReferences.getOrDefault(pathToFile, Collections.emptySet());
    }

    List<MetaStatement> getObjDefinitionsForPath(String pathToFile) {
        return objDefinitions.getOrDefault(pathToFile, Collections.emptyList());
    }

    Stream<MetaStatement> getAllObjDefinitions() {
        return objDefinitions.values().stream().flatMap(List<MetaStatement>::stream);
    }

    Stream<PgObjLocation> getAllObjReferences() {
        return objReferences.values().stream().flatMap(Set<PgObjLocation>::stream);
    }

    Map<String, List<MetaStatement>> getObjDefinitions() {
        return objDefinitions;
    }

    Map<String, Set<PgObjLocation>> getObjReferences() {
        return objReferences;
    }

    void clear() {
        objDefinitions.clear();
        objReferences.clear();
    }

    void putReferences(Map<String, List<MetaStatement>> objDefinitions,
            Map<String, Set<PgObjLocation>> objReferences) {
        this.objDefinitions.putAll(objDefinitions);
        this.objReferences.putAll(objReferences);
    }

    void remove(String path) {
        objReferences.remove(path);
        objDefinitions.remove(path);
    }
}
