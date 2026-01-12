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
package ru.taximaxim.codekeeper.ui.refactoring;

import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class PgRenameRefactoringInputPage extends UserInputWizardPage {

    public static final String PAGE_NAME = "RenameRefactoringPage"; //$NON-NLS-1$

    private Text txtName;

    public PgRenameRefactoringInputPage() {
        super(PAGE_NAME);
    }

    @Override
    public void createControl(Composite parent) {
        Composite top = new Composite(parent, SWT.NONE);
        initializeDialogUnits(top);
        setControl(top);

        top.setLayout(new GridLayout(2, false));

        Label label= new Label(top, SWT.NONE);
        label.setText(Messages.PgRenameRefactoringInputPage_new_name);
        txtName = new Text(top, SWT.BORDER);
        txtName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        txtName.addModifyListener(e ->  {
            updatePageComplete();
            getRenameProcessor().setNewName(txtName.getText());
        });
        txtName.setText(getOldName());
        txtName.selectAll();
    }

    private RenameDefinitionProcessor getRenameProcessor() {
        RenameRefactoring refactoring = (RenameRefactoring) getRefactoring();
        return (RenameDefinitionProcessor) refactoring.getProcessor();
    }

    private String getOldName() {
        return getRenameProcessor().getOldName();
    }

    private void updatePageComplete() {
        String txt = txtName.getText();
        setPageComplete(!txt.isEmpty() && !txt.equals(getOldName()));
    }
}
