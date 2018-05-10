package ru.taximaxim.codekeeper.ui.properties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
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

import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;
import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.InternalIgnoreList;
import ru.taximaxim.codekeeper.ui.xmlstore.IgnoreListsXmlStore;

public class IgnoreListProperties extends PropertyPage {

    private IEclipsePreferences prefs;
    private IProject proj;
    private Path xmlStoreFilePath;
    private IgnoreListEditor editor;
    private IgnoreListsXmlStore ignoreListsXmlStore;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        proj = element.getAdapter(IProject.class);
        prefs = new ProjectScope(proj).getNode(UIConsts.PLUGIN_ID.THIS);

        xmlStoreFilePath = Paths.get(proj.getLocationURI()).resolve(".settings")  //$NON-NLS-1$
                .resolve(FILE.IGNORE_LISTS_STORE);
        ignoreListsXmlStore = new IgnoreListsXmlStore(xmlStoreFilePath);
    }

    @Override
    protected Control createContents(Composite parent) {
        editor = new IgnoreListEditor(parent);

        // read from pref or store
        editor.setInputList(new ArrayList<>(readIgnoreListStore()));
        return editor;
    }

    @Override
    public boolean performOk() {
        // write information about ignore files to the xml file.
        updateIgnoreListStore(editor.getList().stream()
                .map(Paths::get).collect(Collectors.toSet()));

        // delete processing
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

        return true;
    }

    private Set<String> readIgnoreListStore() {
        return isXmlStoreExists() ? ignoreListsXmlStore.readIgnoreListsPathsFromXML()
                : new LinkedHashSet<>() ;
    }

    private void updateIgnoreListStore(Set<Path> ignoreListsPaths) {
        if (!isXmlStoreExists()) {
            try {
                if (!xmlStoreFilePath.getParent().toFile().exists()) {
                    Files.createDirectory(xmlStoreFilePath.getParent());
                }
                if (!xmlStoreFilePath.toFile().exists()) {
                    Files.createFile(xmlStoreFilePath);
                }
            } catch (IOException ex) {
                ExceptionNotifier.notifyDefault(MessageFormat.format(
                        Messages.IgnoreListProperties_error_file, xmlStoreFilePath), ex);
            }
        }

        ignoreListsXmlStore.setIgnoreListsPaths(ignoreListsPaths);
        ignoreListsXmlStore.writeIgnoreListsPathsToXml();
    }

    private boolean isXmlStoreExists() {
        return xmlStoreFilePath.getParent().toFile().exists()
                && xmlStoreFilePath.toFile().exists();
    }

    private class IgnoreListEditor extends PrefListEditor<String, ListViewer> {

        private IgnoreList currentIgnoreList;

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
            Button btnAdd = createButton(parent, ADD_ID, Messages.delete,
                    Activator.getEclipseImage(ISharedImages.IMG_OBJ_ADD));
            btnAdd.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    if (!getList().isEmpty()) {
                        // TODO make it visible in ListViewer
                        currentIgnoreList = InternalIgnoreList.getIgnoreListFromPath(Paths.get(getList().get(0)));
                    }
                }
            });

            createButton(parent, DELETE_ID, Messages.delete,
                    Activator.getEclipseImage(ISharedImages.IMG_ETOOL_DELETE));


            Button btnEdit = createButton(parent, CLIENT_ID, Messages.edit, FILE.ICONEDIT);
            btnEdit.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent event) {
                    IStructuredSelection sel = getViewer().getStructuredSelection();
                    String path = (String) sel.getFirstElement();

                    IgnoreListEditorDialog d = new IgnoreListEditorDialog(getShell(), Paths.get(path));
                    currentIgnoreList = d.open() == IgnoreListEditorDialog.OK ? d.getCurrentIgnoreList() : null;
                }
            });

            Button btnNew = createButton(parent, CLIENT_ID, Messages.IgnoreListProperties_create_new_file,
                    Activator.getEclipseImage(ISharedImages.IMG_OBJ_FILE));
            btnNew.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent event) {

                    IgnoreListEditorDialog d = new IgnoreListEditorDialog(getShell(), null);
                    currentIgnoreList = d.open() == IgnoreListEditorDialog.OK ? d.getCurrentIgnoreList() : null;
                }
            });
        }

        @Override
        protected void deleteObject() {
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
    }
}


