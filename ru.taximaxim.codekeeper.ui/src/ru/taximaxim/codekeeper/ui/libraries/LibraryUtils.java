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
package ru.taximaxim.codekeeper.ui.libraries;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.pgcodekeeper.core.library.PgLibrary;
import org.pgcodekeeper.core.xmlstore.DependenciesXmlStore;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;

public class LibraryUtils {

    public static final Path META_PATH = Paths.get(Platform.getStateLocation(
            Activator.getContext().getBundle()).append("dependencies").toString()); //$NON-NLS-1$

    public static RootLibrary create(IProject proj) throws IOException {
        Path xmlPath = Paths.get(proj.getLocation().toString()).resolve(DependenciesXmlStore.FILE_NAME);
        DependenciesXmlStore xml = new DependenciesXmlStore(xmlPath);
        List<PgLibrary> libs = xml.readObjects();
        return new UiLibraryLoader(proj.getName(), ProjectUtils.getDatabaseType(proj), xml.readLoadNestedFlag(),
                xmlPath)
                .load(libs);
    }

    public static RootLibrary getRoot(IProject project) throws IOException {
        String projectName = project.getName();
        if (RootLibrary.hasRootLib(projectName)) {
            return RootLibrary.getRootLib(projectName);
        }

        return create(project);
    }

    private LibraryUtils() {
        // only statics
    }
}
