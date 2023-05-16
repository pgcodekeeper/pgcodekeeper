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
package ru.taximaxim.codekeeper.ui.intro.actions;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.ui.PlatformUI;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.pgdbproject.DiffWizard;

public class NewDiffProjectAction {

    public NewDiffProjectAction() {
        WizardDialog dialog = new WizardDialog(
                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                new DiffWizard(null, Activator.getDefault().getPreferenceStore()));
        dialog.setShellStyle(dialog.getShellStyle() & ~SWT.PRIMARY_MODAL & ~SWT.APPLICATION_MODAL);
        dialog.open();
    }
}