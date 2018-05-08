package ru.taximaxim.codekeeper.ui.properties;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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

import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;
import ru.taximaxim.codekeeper.ui.xmlstore.IgnoreListsXmlStore;

public class IgnoreListProperties extends PropertyPage {

    private IEclipsePreferences prefs;
    private IProject proj;
    private IgnoreListEditor editor;

    public IgnoreListProperties() {

    }

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        proj = element.getAdapter(IProject.class);
        prefs = new ProjectScope(proj).getNode(UIConsts.PLUGIN_ID.THIS);
    }

    @Override
    protected Control createContents(Composite parent) {
        editor = new IgnoreListEditor(parent);

        // read from pref or store

        //        readIgnoreListStore()

        editor.setInputList(new ArrayList<>());
        return editor;
    }


    @Override
    public boolean performOk() {
        // save to some place
        try {
            saveChangesToSomePlace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void saveChangesToSomePlace() throws IOException {
        Path currentIgnoreListPath = editor.getCurrentIgnoreListPath();

        // write path of ignore file to the xml file.
        updateIgnoreListStore(currentIgnoreListPath);
    }

    private void readIgnoreListStore(Path ignoreListPath) {
        Path storeFilePath = Paths.get(proj.getLocationURI()).resolve(FILE.IGNORE_LISTS_STORE);

        ///// check storeFilePath

        IgnoreListsXmlStore ignoreListsXmlStore = new IgnoreListsXmlStore(storeFilePath);
        ignoreListsXmlStore.readIgnoreListsPathsFromXML();
    }

    private void updateIgnoreListStore(Path ignoreListPath) {
        Path storeFilePath = Paths.get(proj.getLocationURI()).resolve(FILE.IGNORE_LISTS_STORE);
        IgnoreListsXmlStore ignoreListsXmlStore = new IgnoreListsXmlStore(storeFilePath);
        ignoreListsXmlStore.addNewIgnoreListPath(ignoreListPath);
        ignoreListsXmlStore.writeIgnoreListsPathsToXml();
    }

    private class IgnoreListEditor extends PrefListEditor<String, ListViewer> {

        private IgnoreList currentIgnoreList;

        public IgnoreListEditor(Composite parent) {
            super(parent);
        }

        public Path getCurrentIgnoreListPath() {
            return currentIgnoreList.getPath();
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

                    IgnoreListEditorDialog d = new IgnoreListEditorDialog(getShell(), Paths.get(path));
                    currentIgnoreList = d.open() == IgnoreListEditorDialog.OK ? d.getCurrentIgnoreList() : null;
                }
            });

            Button btnNew = createButton(parent, CLIENT_ID, Messages.IgnoreListProperties_create_new_file,
                    Activator.getEclipseImage(ISharedImages.IMG_OBJ_FILE));

            btnNew.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent event) {
                    // new ignore file creation code

                    IgnoreListEditorDialog d = new IgnoreListEditorDialog(getShell(), null);
                    currentIgnoreList = d.open() == IgnoreListEditorDialog.OK ? d.getCurrentIgnoreList() : null;
                }
            });
        }
    }
}


