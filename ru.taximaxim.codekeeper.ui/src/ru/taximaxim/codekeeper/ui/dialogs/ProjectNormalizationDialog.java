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
package ru.taximaxim.codekeeper.ui.dialogs;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class ProjectNormalizationDialog extends Dialog {

    private final Map<String, String> dirMappings;
    private final Map<String, String> defaultDirMappings;
    private ObjectDirectoryViewer objectTypeViewer;
    private Button btnSplitBySchema;
    private Button btnUseAltDirs;
    private Button defaultButton;
    private boolean useAltDirs;
    private boolean splitBySchema;

    public ProjectNormalizationDialog(Shell parentShell, Map<String, String> currentMappings,
            Map<String, String> defaultDirMappings, boolean splitBySchema) {
        super(parentShell);
        this.dirMappings = new LinkedHashMap<>(currentMappings);
        this.defaultDirMappings = defaultDirMappings;
        this.splitBySchema = splitBySchema;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.ProjectNormalizationDialog_title);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new GridLayout(2, false));
        GridData gb = new GridData(GridData.FILL_BOTH);
        container.setLayoutData(gb);

        Composite leftComposite = new Composite(container, SWT.NONE);
        leftComposite.setLayout(new GridLayout());
        leftComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
        btnSplitBySchema = new Button(leftComposite, SWT.CHECK);
        btnSplitBySchema.setText(Messages.ProjectNormalizationDialog_split_by_schema);
        btnSplitBySchema.setSelection(splitBySchema);
        btnUseAltDirs = new Button(leftComposite, SWT.CHECK);
        btnUseAltDirs.setText(Messages.ProjectNormalizationDialog_set_alt_dirs);
        objectTypeViewer = new ObjectDirectoryViewer(leftComposite, dirMappings, true);
        objectTypeViewer.createViewer();
        objectTypeViewer.setEnabled(false);

        Composite rightComposite = new Composite(container, SWT.NONE);
        rightComposite.setLayout(new GridLayout(1, false));
        rightComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

        btnUseAltDirs.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                checkSelection();
            }
        });

        btnUseAltDirs.setSelection(hasAltDirs());

        return container;
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        defaultButton = createButton(parent, IDialogConstants.BACK_ID,
                Messages.ProjectNormalizationDialog_restore_default_dirs, false);
        defaultButton.setEnabled(false);

        defaultButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                objectTypeViewer.restoreDefaults(defaultDirMappings);
            }
        });
        checkSelection();

        super.createButtonsForButtonBar(parent);
    }

    @Override
    protected void okPressed() {
        useAltDirs = btnUseAltDirs.getSelection();
        splitBySchema = btnSplitBySchema.getSelection();
        super.okPressed();
    }

    private void checkSelection() {
        boolean enabled = btnUseAltDirs.getSelection();
        objectTypeViewer.setEnabled(enabled);
        defaultButton.setEnabled(enabled);
    }

    private boolean hasAltDirs() {
        return !dirMappings.equals(defaultDirMappings);
    }

    public Map<String, String> getDirMappings() {
        if (!useAltDirs) {
            return new LinkedHashMap<>(defaultDirMappings);
        }
        return dirMappings;
    }

    public boolean isSplitBySchema() {
        return splitBySchema;
    }
}
