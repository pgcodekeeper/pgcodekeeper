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
package ru.taximaxim.codekeeper.ui.libraries;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LibraryStorage {

    /*
     * this collection store libs which we need for correct work links
     */
    private static final Map<String, FileLibrary> LOADED_LIBRARIES = new ConcurrentHashMap<>();

    public static void addLibrary(FileLibrary lib) {
        LOADED_LIBRARIES.put(lib.getPath().toString(), lib);
    }

    public static FileLibrary getLibrary(String filePath) {
        return LOADED_LIBRARIES.get(filePath);
    }

    public static void removeLibrary(String string) {
        LOADED_LIBRARIES.remove(string);
    }

    public static void clean(RootLibrary root) {
        clearAllChildren(root.getChildren());
    }

    private static void clearAllChildren(List<AbstractLibrary> children) {
        for (AbstractLibrary child : children) {
            clearAllChildren(child.getChildren());
            if (child instanceof FileLibrary lib) {
                removeLibrary(lib.getPath().toString());
            }
        }
    }

    private LibraryStorage() {
        // only statics
    }
}
