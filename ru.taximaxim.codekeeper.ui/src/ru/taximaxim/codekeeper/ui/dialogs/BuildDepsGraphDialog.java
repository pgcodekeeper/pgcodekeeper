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
package ru.taximaxim.codekeeper.ui.dialogs;

import java.util.EnumSet;
import java.util.Set;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class BuildDepsGraphDialog extends Dialog {

    private final String objName;
    private boolean isProject;
    private boolean isBothEnabled;

    private ObjectTypeViewer objTypeViewer;
    private Text txtDepth;
    private Button btnReverse;
    private String sourceType;
    private int graphDepth;
    private boolean isReverse;
    private Set<DbObjType> types = EnumSet.noneOf(DbObjType.class);

    public BuildDepsGraphDialog(Shell shell, String objName, boolean isProject, boolean isBothEnabled) {
        super(shell);
        this.objName = objName;
        this.isProject = isProject;
        this.isBothEnabled = isBothEnabled;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.BuildDepsGraphDialog_build_dep_graph + objName);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        gd.minimumWidth = 550;
        composite.setLayoutData(gd);
        composite.setLayout(new GridLayout(2, false));

        // source type
        createSourceGroup(composite);

        // graph depth
        new Label(composite, SWT.NONE).setText(Messages.BuildDepsGraphDialog_search_dep);

        txtDepth = new Text(composite, SWT.BORDER);
        txtDepth.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        txtDepth.setText("10"); //$NON-NLS-1$
        txtDepth.addVerifyListener(e -> {
            try {
                if (!e.text.isEmpty() && Integer.valueOf(e.text) < 0) {
                    e.doit = false;
                }
            } catch(NumberFormatException ex) {
                e.doit = false;
            }
        });

        // graph reverse
        btnReverse = new Button(composite, SWT.CHECK | SWT.LEFT);
        btnReverse.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
        btnReverse.setText(Messages.BuildDepsGraphDialog_reverse);

        //object types
        Composite container = new Composite(composite, SWT.NONE);
        container.setLayout(new GridLayout());

        GridData g = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
        g.heightHint = 300;
        container.setLayoutData(g);
        objTypeViewer = new ObjectTypeViewer(container, Messages.diffTableViewer_object_type, true, true, types);
        return composite;
    }

    private void createSourceGroup(Composite composite) {
        Composite group = new Composite(composite, SWT.NONE);
        group.setLayout(new RowLayout());
        group.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 2, 1));

        new Label(group, SWT.NONE).setText(Messages.BuildDepsGraphDialog_schema_source);

        Button btnProject = new Button(group, SWT.RADIO);
        btnProject.setText(Messages.DepcyGraphView_project);
        btnProject.setSelection(isProject);
        btnProject.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                isProject = true;
            }
        });

        Button btnRemote = new Button(group, SWT.RADIO);
        btnRemote.setText(Messages.DepcyGraphView_remote);
        btnRemote.setSelection(!isProject);
        btnRemote.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                isProject = false;
            }
        });

        btnProject.setEnabled(isBothEnabled || isProject);
        btnRemote.setEnabled(isBothEnabled || !isProject);
    }

    @Override
    protected void okPressed() {
        graphDepth = Integer.parseInt(txtDepth.getText());
        isReverse = btnReverse.getSelection();

        types.clear();
        for (Object obj : objTypeViewer.getSelectedElements()) {
            types.add((DbObjType) obj);
        }
        super.okPressed();
    }

    public boolean isProject() {
        return isProject;
    }

    public String getSourceType() {
        return sourceType;
    }

    public Integer getGraphDepth() {
        return graphDepth;
    }

    public boolean isReverse() {
        return isReverse;
    }

    public Set<DbObjType> getObjTypes() {
        return types;
    }

    @Override
    protected boolean isResizable() {
        return true;
    }
}
