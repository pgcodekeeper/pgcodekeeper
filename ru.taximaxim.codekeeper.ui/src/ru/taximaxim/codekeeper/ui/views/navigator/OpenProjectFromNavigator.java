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
package ru.taximaxim.codekeeper.ui.views.navigator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.PlatformObject;

public class OpenProjectFromNavigator extends PlatformObject {

    private final IProject proj;

    public IProject getProject() {
        return proj;
    }

    public OpenProjectFromNavigator(IProject proj) {
        this.proj = proj;
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        if (adapter.isAssignableFrom(IProject.class)) {
            return adapter.cast(proj);
        }
        return super.getAdapter(adapter);
    }
}
