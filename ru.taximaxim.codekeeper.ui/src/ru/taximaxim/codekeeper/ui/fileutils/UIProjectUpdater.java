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
package ru.taximaxim.codekeeper.ui.fileutils;

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;

import ru.taximaxim.codekeeper.core.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class UIProjectUpdater extends ProjectUpdater{

    public UIProjectUpdater(PgDatabase dbNew, PgDbProject proj) throws CoreException {
        this(dbNew, null, null, proj, false);
    }

    public UIProjectUpdater(PgDatabase dbNew, PgDatabase dbOld,
            Collection<TreeElement> changedObjects, PgDbProject proj,
            boolean overridesOnly) throws CoreException {
        super(dbNew, dbOld, changedObjects,
                OpenProjectUtils.checkMsSql(proj.getProject()), proj.getProjectCharset(),
                proj.getPathToProject(), overridesOnly);
    }
}
