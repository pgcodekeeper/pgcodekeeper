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
package ru.taximaxim.codekeeper.ui.pgdbproject;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.handlers.OpenProjectUtils;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class MockDataWizard extends Wizard implements INewWizard {

    private MockDataPage page;
    private IStructuredSelection selection;
    private DatabaseType dbType = DatabaseType.PG;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
        setDefaultPageImageDescriptor(Activator.getRegisteredDescriptor(ProjectIcon.APP_WIZ));
        Object element = selection.getFirstElement();
        if (element instanceof IResource res) {
            dbType = OpenProjectUtils.getDatabaseType(res.getProject());
        }
    }

    @Override
    public boolean performFinish() {
        return page.createFile(dbType);
    }

    @Override
    public void addPages() {
        setWindowTitle(Messages.MockDataWizard_create_data);
        page = new MockDataPage(Messages.MockDataWizard_create_data_table, selection);
        addPage(page);
    }
}
