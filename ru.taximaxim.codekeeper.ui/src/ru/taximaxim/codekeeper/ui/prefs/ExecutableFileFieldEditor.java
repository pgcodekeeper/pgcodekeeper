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
package ru.taximaxim.codekeeper.ui.prefs;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.swt.widgets.Composite;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * Extends {@link FileFieldEditor} to check whether an executable
 * can be found in PATH system variable and if it can be executed.
 *
 * @author Alexander Levsha
 */
public class ExecutableFileFieldEditor extends FileFieldEditor {

    public ExecutableFileFieldEditor(String name, String labelText,
            Composite parent) {
        // always create without enforcing absolute paths
        super(name, labelText, false, VALIDATE_ON_KEY_STROKE, parent);
    }

    @Override
    protected boolean checkState() {
        File f = null;

        if (!super.checkState()) {
            // we cannot search filepaths in %PATH%,
            // only filenames are allowed in this case
            // always block '/' because on Windows File.separator will be '\'
            // but '/' will work as well
            if (getStringValue().contains(File.separator)
                    || getStringValue().indexOf('/') != -1) {
                return false;
            }

            String pathSep = Pattern.quote(File.pathSeparator);

            List<String> pathExts = new ArrayList<>();
            // since we always try to search with extension add empty one too
            pathExts.add(""); //$NON-NLS-1$

            String pathext = System.getenv("PATHEXT"); //$NON-NLS-1$
            if (pathext != null) {
                Collections.addAll(pathExts, pathext.split(pathSep));
            }

            String envVarPath = System.getenv("PATH"); //$NON-NLS-1$
            for (String subVarPath : envVarPath.split(pathSep)) {
                for (String ext : pathExts) {
                    File fTry = new File(subVarPath, getStringValue() + ext);
                    if (fTry.isFile()) {
                        f = fTry;
                        break;
                    }
                }
            }

            if (f == null) {
                return false;
            }
        } else {
            f = new File(getStringValue());
        }

        if (!f.canExecute()) {
            showErrorMessage(
                    Messages.executableFileFieldEditor_value_must_be_file_with_execute_permission_set);
            return false;
        }

        clearErrorMessage();
        return true;
    }
}
