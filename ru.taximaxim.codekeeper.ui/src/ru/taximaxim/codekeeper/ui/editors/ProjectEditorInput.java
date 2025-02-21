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
package ru.taximaxim.codekeeper.ui.editors;

import java.text.MessageFormat;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.model.IWorkbenchAdapter;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.PgCodekeeperUIException;
import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectEditorInput extends PlatformObject implements IEditorInput, IPersistableElement {

    private final String projName;
    private PgCodekeeperUIException ex;
    private String toolTip;

    public ProjectEditorInput(String projectName) {
        projName = projectName;
    }

    public IProject getProject() {
        return ResourcesPlugin.getWorkspace().getRoot().getProject(projName);
    }

    public PgCodekeeperUIException getError() {
        return ex;
    }

    public void setError(PgCodekeeperUIException ex) {
        this.ex = ex;
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        Object ad;
        if (adapter.isAssignableFrom(IProject.class)) {
            ad = getProject();
        } else if (adapter.isAssignableFrom(IWorkbenchAdapter.class)) {
            ad = new IWorkbenchAdapter() {

                @Override
                public Object getParent(Object o) {
                    return getProject().getParent();
                }

                @Override
                public Object[] getChildren(Object o) {
                    IProject proj = getProject();
                    if (proj.isOpen()) {
                        try {
                            return proj.members();
                        } catch (CoreException ex) {
                            // return empty array
                        }
                    }
                    return new Object[0];
                }

                @Override
                public String getLabel(Object o) {
                    return getProject().getName();
                }

                @Override
                public ImageDescriptor getImageDescriptor(Object object) {
                    return Activator.getRegisteredDescriptor(ProjectIcon.APP_SMALL);
                }
            };
        } else if (adapter.isAssignableFrom(IPersistableElement.class)){
            ad = this;
        } else {
            return super.getAdapter(adapter);
        }
        return adapter.cast(ad);
    }

    @Override
    public boolean exists() {
        return projName != null && !projName.isEmpty();
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return Activator.getRegisteredDescriptor(ProjectIcon.APP_SMALL);
    }

    @Override
    public String getName() {
        return projName;
    }

    @Override
    public IPersistableElement getPersistable() {
        return this;
    }

    public void setToolTipText(String toolTip) {
        this.toolTip = toolTip;
    }

    @Override
    public String getToolTipText() {
        return toolTip != null ? toolTip : MessageFormat.format(
                Messages.ProjectEditorInput_pgcodekeeper_project, projName);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + projName.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProjectEditorInput)) {
            return false;
        }
        ProjectEditorInput other = (ProjectEditorInput) obj;
        return projName.equals(other.projName);
    }

    @Override
    public void saveState(IMemento memento) {
        ProjectEditorInputFactory.saveState(memento, this);
    }

    @Override
    public String getFactoryId() {
        return ProjectEditorInputFactory.getFactoryId();
    }
}
