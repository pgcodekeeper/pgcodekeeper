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

package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.pgdbproject.DiffWizard;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

public class Diff extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        PgDbProject proj = OpenProjectUtils.getProject(event);
        Shell shell = HandlerUtil.getActiveShell(event);
        IPreferenceStore prefStore = Activator.getDefault().getPreferenceStore();
        Log.log(Log.LOG_DEBUG, "Diff wizard about to show"); //$NON-NLS-1$

        WizardDialog dialog = new WizardDialog(
                shell, new DiffWizard(proj, prefStore));
        dialog.setShellStyle(dialog.getShellStyle() & ~SWT.PRIMARY_MODAL & ~SWT.APPLICATION_MODAL);
        dialog.open();
        return null;
    }
}