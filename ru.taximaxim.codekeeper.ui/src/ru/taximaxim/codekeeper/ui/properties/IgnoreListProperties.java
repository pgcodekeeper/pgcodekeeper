package ru.taximaxim.codekeeper.ui.properties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.dialogs.MessageDialog;
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
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.dialogs.IgnoreListEditorDialog;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;
import ru.taximaxim.codekeeper.ui.xmlstore.IgnoreListsXmlStore;

public class IgnoreListProperties extends PropertyPage {

    private IgnoreListEditor editor;
    private IgnoreListsXmlStore store;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        IProject proj = element.getAdapter(IProject.class);
        store = new IgnoreListsXmlStore(proj);
    }

    @Override
    protected Control createContents(Composite parent) {
        editor = new IgnoreListEditor(parent);

        List<String> list;
        try {
            list = store.readObjects();
        } catch (IOException e) {
            list = new ArrayList<>();
        }

        editor.setInputList(list);
        return editor;
    }

    @Override
    public boolean performOk() {
        try {
            store.writeObjects(editor.getList());

            Set<String> strPathsForDel = editor.getStrPathsForDel();

            if (!strPathsForDel.isEmpty()) {
                boolean delFiles = MessageDialog.openConfirm(getShell(), Messages.IgnoreListProperties_confirm_deletion,
                        Messages.IgnoreListProperties_del_ignore_list_file);

                if (delFiles) {
                    for (String strPath : strPathsForDel) {
                        try {
                            Files.delete(Paths.get(strPath));
                        } catch (IOException ex) {
                            ExceptionNotifier.notifyDefault(MessageFormat.format(
                                    Messages.IgnoreListProperties_error_file, strPath), ex);
                        }
                    }
                }
                strPathsForDel.clear();
            }

            setValid(true);
            setErrorMessage(null);
        } catch (IOException e) {
            setErrorMessage(MessageFormat.format(
                    Messages.projectProperties_error_occurs_while_saving_properties,
                    e.getLocalizedMessage()));
            setValid(false);
            return false;
        }
        return true;
    }

    private class IgnoreListEditor extends PrefListEditor<String, ListViewer> {

        private final Set<String> strPathsForDel = new LinkedHashSet<>();

        public IgnoreListEditor(Composite parent) {
            super(parent);
        }

        public Set<String> getStrPathsForDel() {
            return strPathsForDel;
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
            createButton(parent, ADD_ID, Messages.add,
                    Activator.getEclipseImage(ISharedImages.IMG_OBJ_ADD));

            Button btnDelete = createButton(parent, CLIENT_ID, Messages.delete,
                    Activator.getEclipseImage(ISharedImages.IMG_ETOOL_DELETE));

            btnDelete.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent event) {
                    IStructuredSelection selection = (IStructuredSelection) getViewer().getSelection();
                    if (selection.isEmpty()) {
                        return;
                    }

                    String path = (String) selection.getFirstElement();
                    strPathsForDel.add(path);

                    if (getList().remove(path)) {
                        getViewer().refresh();
                    }
                }
            });

            Button btnEdit = createButton(parent, CLIENT_ID, Messages.edit, FILE.ICONEDIT);
            btnEdit.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent event) {
                    IStructuredSelection sel = getViewer().getStructuredSelection();
                    String path = (String) sel.getFirstElement();
                    new IgnoreListEditorDialog(getShell(), Paths.get(path), IgnoreListEditor.this).open();
                }
            });

            Button btnNew = createButton(parent, CLIENT_ID, Messages.IgnoreListProperties_create_new_file,
                    Activator.getEclipseImage(ISharedImages.IMG_OBJ_FILE));
            btnNew.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent event) {
                    new IgnoreListEditorDialog(getShell(), null, IgnoreListEditor.this).open();
                }
            });
        }
    }
}
