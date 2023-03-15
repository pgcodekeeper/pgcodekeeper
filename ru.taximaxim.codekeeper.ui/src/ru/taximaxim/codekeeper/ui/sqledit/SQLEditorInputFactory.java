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
package ru.taximaxim.codekeeper.ui.sqledit;

import java.nio.file.Paths;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

public class SQLEditorInputFactory implements IElementFactory {

    private static final String TAG_PATH = "path"; //$NON-NLS-1$
    private static final String TAG_PROJECT = "project"; //$NON-NLS-1$
    private static final String TAG_IS_MS_SQL = "isMsSql"; //$NON-NLS-1$
    private static final String TAG_IS_READ_ONLY = "isReadOnly"; //$NON-NLS-1$
    private static final String TAG_IS_TEMP = "isTemp"; //$NON-NLS-1$

    /**
     * This factory's ID.
     * <p>
     * The editor plug-in registers a factory by this name with
     * the <code>"org.eclipse.ui.elementFactories"</code> extension point.
     * </p>
     */
    static final String ID = "ru.taximaxim.codekeeper.ui.sqledit.SQLEditorInputFactory"; //$NON-NLS-1$

    /**
     * Saves the state of the given editor input into the given memento.
     *
     * @param memento the storage area for element state
     * @param input the sql editor input
     */
    static void saveState(IMemento memento, SQLEditorInput input) {
        memento.putString(TAG_PATH, input.getPath().toString());
        memento.putString(TAG_PROJECT, input.getProject());
        memento.putBoolean(TAG_IS_MS_SQL, input.isMsSql());
        memento.putBoolean(TAG_IS_READ_ONLY, input.isReadOnly());
        memento.putBoolean(TAG_IS_TEMP, input.isTemp());
    }

    @Override
    public IAdaptable createElement(IMemento memento) {
        String path = memento.getString(TAG_PATH);
        String project = memento.getString(TAG_PROJECT);
        Boolean isMsSql = memento.getBoolean(TAG_IS_MS_SQL);
        Boolean isReadOnly = memento.getBoolean(TAG_IS_READ_ONLY);
        Boolean isTemp = memento.getBoolean(TAG_IS_TEMP);
        if (path == null || isMsSql == null || isReadOnly == null || isTemp == null) {
            return null;
        }


        return new SQLEditorInput(Paths.get(path), project, isMsSql, isReadOnly, isTemp);
    }
}
