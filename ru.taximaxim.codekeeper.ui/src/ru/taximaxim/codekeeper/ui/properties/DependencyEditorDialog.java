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
package ru.taximaxim.codekeeper.ui.properties;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.pgcodekeeper.core.library.PgLibrary;
import org.pgcodekeeper.core.library.PgLibrarySource;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class DependencyEditorDialog extends TrayDialog {

    private String action;
    private PgLibrary initialLibrary;
    private PgLibrary library;
    private String defaultPath;
    private Path xmlStorePath;

    private Text txtName;
    private Text txtPath;
    private Text txtOwner;
    private Button btnIgnorePriv;

    protected DependencyEditorDialog(Shell shell, PgLibrary initialLibrary, String action, String defaultPath,
            Path xmlStorePath) {
        super(shell);
        this.initialLibrary = initialLibrary;
        this.action = action;
        this.defaultPath = defaultPath;
        this.xmlStorePath = xmlStorePath;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        String dialogName = (initialLibrary != null) ? action + ": " + initialLibrary.getTitle() : action; //$NON-NLS-1$
        newShell.setText(dialogName);

        newShell.addShellListener(new ShellAdapter() {

            @Override
            public void shellActivated(ShellEvent e) {
                // one time listener
                newShell.removeShellListener(this);

                if (initialLibrary != null) {
                    txtName.setText(initialLibrary.name());
                    txtPath.setText(initialLibrary.path());
                    txtOwner.setText(initialLibrary.owner());
                    btnIgnorePriv.setSelection(initialLibrary.isIgnorePrivileges());
                }
            }
        });
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);

        Composite composite = new Composite(area, SWT.NONE);
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        gd.minimumWidth = 600;
        composite.setLayoutData(gd);
        composite.setLayout(new GridLayout(4, false));

        // name
        Label lblName = new Label(composite, SWT.NONE);
        gd = new GridData(SWT.FILL, SWT.DEFAULT, false, false, 4, 1);
        lblName.setLayoutData(gd);
        lblName.setText(Messages.DependencyEditorDialog_name);

        txtName = new Text(composite, SWT.BORDER);
        txtName.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 4, 1));

        // path
        Label lblPath = new Label(composite, SWT.NONE);
        gd = new GridData(SWT.FILL, SWT.DEFAULT, false, false, 4, 1);
        lblPath.setLayoutData(gd);
        lblPath.setText(Messages.DependencyProperties_path);

        txtPath = new Text(composite, SWT.BORDER);
        txtPath.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 1, 1));
        txtPath.addModifyListener(e -> {
            Text txtSource = (Text) e.getSource();
            txtSource.setToolTipText(txtSource.getText());
        });

        Button btnRelative = new Button(composite, SWT.PUSH);
        btnRelative.setText(Messages.DependencyEditorDialog_relative_path);
        btnRelative.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                String path = txtPath.getText();
                PgLibrarySource source = PgLibrarySource.getSource(path);
                if (source == PgLibrarySource.LOCAL) {
                    Path p = Paths.get(path);
                    if (p.isAbsolute()) {
                        txtPath.setText(xmlStorePath.getParent().relativize(p).toString());
                    } else {
                        txtPath.setText(xmlStorePath.resolveSibling(path).normalize().toString());
                    }
                }
            }
        });

        Button btnDirectory = new Button(composite, SWT.PUSH);
        btnDirectory.setImage(Activator.getEclipseImage(ISharedImages.IMG_OBJ_FOLDER));
        btnDirectory.setToolTipText(Messages.DependencyProperties_add_directory);
        btnDirectory.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                DirectoryDialog dialog = new DirectoryDialog(getShell());
                dialog.setText(Messages.DependencyProperties_select_directory);
                dialog.setFilterPath(defaultPath);
                String path = dialog.open();
                if (path != null) {
                    txtPath.setText(path);
                }
            }
        });

        Button btnFile = new Button(composite, SWT.PUSH);
        btnFile.setImage(Activator.getEclipseImage(ISharedImages.IMG_OBJ_FILE));
        btnFile.setToolTipText(Messages.DependencyProperties_add_file);
        btnFile.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                FileDialog dialog = new FileDialog(getShell());
                dialog.setText(Messages.choose_dump_file_with_changes);
                dialog.setFilterExtensions(new String[] { "*.sql", "*.zip", "*" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                dialog.setFilterNames(new String[] {
                        Messages.DiffPresentationPane_sql_file_filter,
                        Messages.DiffPresentationPane_zip_file_filter,
                        Messages.DiffPresentationPane_any_file_filter });
                dialog.setFilterPath(defaultPath);
                String value = dialog.open();
                if (value != null) {
                    txtPath.setText(value);
                }
            }
        });

        // owner
        Label lblOwner = new Label(composite, SWT.NONE);
        lblOwner.setText(Messages.DependencyProperties_owner);
        gd = new GridData(SWT.FILL, SWT.DEFAULT, false, false, 4, 1);
        lblOwner.setLayoutData(gd);

        txtOwner = new Text(composite, SWT.BORDER);
        txtOwner.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT, true, false, 4, 1));

        // privileges
        btnIgnorePriv = new Button(composite, SWT.CHECK);
        btnIgnorePriv.setLayoutData(gd);
        btnIgnorePriv.setText(Messages.DependencyProperties_ignore_privileges);
        btnIgnorePriv.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                if (btnIgnorePriv.getSelection()) {
                    MessageBox mb = new MessageBox(getShell(), SWT.ICON_INFORMATION);
                    mb.setText(Messages.DependencyProperties_attention);
                    mb.setMessage(Messages.DependencyProperties_ignore_priv_warn);
                    mb.open();
                }
            }
        });

        return area;
    }

    public PgLibrary getLibrary() {
        return library;
    }

    @Override
    protected void okPressed() {
        String path = txtPath.getText();
        if (path.isEmpty()) {
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_WARNING);
            mb.setText(Messages.dbStoreEditorDialog_cannot_save_entry);
            mb.setMessage(Messages.DependencyEditorDialog_enter_path);
            mb.open();
            return;
        }

        String name = txtName.getText().trim();
        String owner = txtOwner.getText().trim();
        library = new PgLibrary(name, path, btnIgnorePriv.getSelection(), owner);
        super.okPressed();
    }

    @Override
    protected boolean isResizable() {
        return true;
    }
}
