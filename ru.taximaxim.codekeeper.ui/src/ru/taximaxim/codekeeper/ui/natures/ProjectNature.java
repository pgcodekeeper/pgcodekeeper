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
package ru.taximaxim.codekeeper.ui.natures;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

import ru.taximaxim.codekeeper.ui.handlers.AddBuilder;
import ru.taximaxim.codekeeper.ui.handlers.RemoveBuilder;

public class ProjectNature implements IProjectNature {
    
    private IProject proj;

    @Override
    public void configure() throws CoreException {
        AddBuilder.addBuilder(proj);
    }

    @Override
    public void deconfigure() throws CoreException {
        RemoveBuilder.removeBuilder(proj);
    }

    @Override
    public IProject getProject() {
        return proj;
    }

    @Override
    public void setProject(IProject project) {
        proj = project;
    }
}
