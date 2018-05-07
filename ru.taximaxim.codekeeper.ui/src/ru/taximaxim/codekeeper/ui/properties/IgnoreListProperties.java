package ru.taximaxim.codekeeper.ui.properties;

import java.text.MessageFormat;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.dialogs.PropertyPage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;

public class IgnoreListProperties extends PropertyPage {

    private IEclipsePreferences prefs;
    private IProject proj;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        proj = element.getAdapter(IProject.class);
        prefs = new ProjectScope(proj).getNode(UIConsts.PLUGIN_ID.THIS);
    }

    @Override
    protected Control createContents(Composite parent) {
        IgnoreListEditor editor = new IgnoreListEditor(parent);

        // read from pref or store
        editor.setInputList(new ArrayList<>());
        return editor;
    }


    @Override
    public boolean performOk() {
        // save to some place
        return true;
    }



    private class IgnoreListEditor extends PrefListEditor<String, ListViewer> {

        public IgnoreListEditor(Composite parent) {
            super(parent);
        }

        @Override
        protected ListViewer createViewer(Composite parent) {
            ListViewer viewer = new ListViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
            GridData gd =  new GridData(SWT.FILL, SWT.FILL, true, true, 1, 6);
            viewer.getControl().setLayoutData(gd);
            viewer.setContentProvider(ArrayContentProvider.getInstance());
            return viewer;
        }

        @Override
        protected String getNewObject(String oldObject) {
            FileDialog dialog = new FileDialog(getShell());
            dialog.setText(Messages.DbStoreEditorDialog_select_ignore_file);
            dialog.setFilterExtensions(new String[] {"*.pgcodekeeperignore", "*"}); //$NON-NLS-1$ //$NON-NLS-2$
            dialog.setFilterNames(new String[] {
                    Messages.DbStoreEditorDialog_pgcodekeeperignore_files_filter,
                    Messages.DiffPresentationPane_any_file_filter});
            dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());
            return dialog.open();
        }

        @Override
        protected String errorAlreadyExists(String obj) {
            return MessageFormat.format(Messages.DbStorePrefPage_already_present, obj);
        }

        @Override
        protected void createButtonsForSideBar(Composite parent) {
            createButton(parent, ADD_ID, Messages.delete,
                    Activator.getEclipseImage(ISharedImages.IMG_OBJ_ADD));
            createButton(parent, DELETE_ID, Messages.delete,
                    Activator.getEclipseImage(ISharedImages.IMG_ETOOL_DELETE));
            Button btnEdit = createButton(parent, CLIENT_ID, Messages.edit, FILE.ICONEDIT);

            btnEdit.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent event) {
                    IStructuredSelection sel = getViewer().getStructuredSelection();
                    String path = (String) sel.getFirstElement();
                    // edit code
                }
            });

            Button btnNew = createButton(parent, CLIENT_ID, Messages.IgnoreListProperties_create_new_file,
                    Activator.getEclipseImage(ISharedImages.IMG_OBJ_FILE));

            btnNew.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent event) {
                    // new ignore file creation code
                }
            });
        }
    }
}
