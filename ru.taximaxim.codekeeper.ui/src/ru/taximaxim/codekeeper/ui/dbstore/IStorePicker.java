/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.dbstore;

import java.io.File;

import ru.taximaxim.codekeeper.core.DatabaseType;

public interface IStorePicker {

    void setUseFileSources(boolean useFileSources);

    DbInfo getDbInfo();

    default File getPathOfFile() {
        return getPath(false);
    }

    default File getPathOfDir() {
        return getPath(true);
    }

    File getPath(boolean getDirectory);

    Object getSelection();

    void setSelection(Object selection);

    void setSelection(Object selection, boolean triggerEvent);

    default void clearSelection() {
        setSelection(null);
    }

    void setEnabled(boolean enabled);

    boolean isEnabled();

    void addSelectionListener(Runnable runnable);

    void filter(DatabaseType dbType);

    void dispose();
}