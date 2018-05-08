package ru.taximaxim.codekeeper.ui.properties;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.ui.navigator.CommonNavigator;
import org.osgi.service.prefs.BackingStoreException;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.UIConsts.PROJ_PREF;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;
import ru.taximaxim.codekeeper.ui.xmlstore.DependenciesXmlStore;

public class DependencyProperties extends PropertyPage {

    private final String defaultPath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
    private DependenciesXmlStore store;
    private IEclipsePreferences prefs;

    private DependenciesListEditor editor;
    private Button btnSafeMode;
    private IProject proj;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        proj = element.getAdapter(IProject.class);
        store = new DependenciesXmlStore(proj);
        prefs = new ProjectScope(proj).getNode(UIConsts.PLUGIN_ID.THIS);
    }

    @Override
    protected Control createContents(Composite parent) {
        Composite area = new Composite(parent, SWT.NONE);
        area.setLayout(new GridLayout(2, false));

        editor = new DependenciesListEditor(area);
        editor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

        List<PgLibrary> input;
        try {
            input = store.readObjects();
        } catch (IOException e) {
            Log.log(e);
            input = new ArrayList<>();
        }
        editor.setInputList(input);

        new Label(area, SWT.NONE).setText(Messages.DependencyProperties_safe_mode);

        btnSafeMode = new Button(area, SWT.CHECK);
        btnSafeMode.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        btnSafeMode.setText(Messages.DependencyProperties_safe_mode_desc);
        btnSafeMode.setSelection(prefs.getBoolean(PROJ_PREF.LIB_SAFE_MODE, true));

        return area;
    }

    @Override
    public boolean performOk() {
        try {
            prefs.putBoolean(PROJ_PREF.LIB_SAFE_MODE, btnSafeMode.getSelection());
            prefs.flush();
            store.writeObjects(editor.getList());
            refreshProject();
            setValid(true);
            setErrorMessage(null);
        } catch (IOException | BackingStoreException e) {
            setErrorMessage(MessageFormat.format(
                    Messages.projectProperties_error_occurs_while_saving_properties,
                    e.getLocalizedMessage()));
            setValid(false);
            return false;
        }
        return true;
    }

    private void refreshProject() {
        CommonNavigator view = (CommonNavigator)PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().findView(IPageLayout.ID_PROJECT_EXPLORER);
        if (view != null) {
            view.getCommonViewer().refresh(proj);
        }
    }

    private class DependenciesListEditor extends PrefListEditor<PgLibrary, TableViewer> {

        public DependenciesListEditor(Composite parent) {
            super(parent);
        }

        @Override
        protected PgLibrary getNewObject(PgLibrary oldObject) {
            DirectoryDialog dialog = new DirectoryDialog(getShell());
            dialog.setText(Messages.DependencyProperties_select_directory);
            dialog.setFilterPath(defaultPath);
            String path = dialog.open();
            return path != null ? new PgLibrary(path) : null;
        }

        @Override
        protected String errorAlreadyExists(PgLibrary obj) {
            return MessageFormat.format(Messages.DbStorePrefPage_already_present, obj.getPath());
        }

        @Override
        protected TableViewer createViewer(Composite parent) {
            TableViewer viewer = new TableViewer(
                    parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
            viewer.setContentProvider(ArrayContentProvider.getInstance());

            addColumns(viewer);

            GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 6);
            gd.widthHint = PREF_PAGE.WIDTH_HINT_PX;
            viewer.getTable().setLayoutData(gd);
            viewer.getTable().setLinesVisible(true);
            viewer.getTable().setHeaderVisible(true);

            return viewer;
        }

        private void addColumns(TableViewer viewer) {
            TableViewerColumn path = new TableViewerColumn(viewer, SWT.LEFT);
            path.getColumn().setText(Messages.DependencyProperties_path);
            path.getColumn().setResizable(true);
            path.getColumn().setMoveable(true);
            path.setLabelProvider(new ColumnLabelProvider() {

                @Override
                public String getText(Object element) {
                    PgLibrary obj = (PgLibrary) element;
                    return obj.getPath();
                }
            });

            TableViewerColumn ignorePriv = new TableViewerColumn(viewer, SWT.CENTER);
            ignorePriv.getColumn().setText(Messages.DependencyProperties_ignore_privileges);
            ignorePriv.getColumn().setResizable(true);
            ignorePriv.getColumn().setMoveable(true);
            ignorePriv.setLabelProvider(new ColumnLabelProvider() {

                @Override
                public String getText(Object element) {
                    return (((PgLibrary)element).isIgnorePriv()) ? "\u2611" : "\u2610"; //$NON-NLS-1$ //$NON-NLS-2$
                }
            });

            ignorePriv.setEditingSupport(new IgnorePrivCheckEditingSupport(viewer));

            int width = (int)(viewer.getTable().getSize().x * 0.33f);
            path.getColumn().setWidth(Math.max(width * 2, 500));
            ignorePriv.getColumn().setWidth(Math.max(width, 200));
        }

        @Override
        protected void createButtonsForSideBar(Composite parent) {
            createButton(parent, ADD_ID, Messages.DependencyProperties_add_directory,
                    Activator.getEclipseImage(ISharedImages.IMG_OBJ_FOLDER));

            Button btnAddDump = createButton(parent, CLIENT_ID, Messages.DependencyProperties_add_dump,
                    Activator.getEclipseImage(ISharedImages.IMG_OBJ_FILE));
            btnAddDump.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    FileDialog dialog = new FileDialog(getShell());
                    dialog.setText(Messages.choose_dump_file_with_changes);
                    dialog.setFilterExtensions(new String[] {"*.sql", "*"}); //$NON-NLS-1$ //$NON-NLS-2$
                    dialog.setFilterNames(new String[] {
                            Messages.DiffPresentationPane_sql_file_filter,
                            Messages.DiffPresentationPane_any_file_filter});
                    dialog.setFilterPath(defaultPath);
                    String value = dialog.open();
                    if (value != null) {
                        getList().add(new PgLibrary(value));
                        getViewer().refresh();
                    }
                }
            });

            Button btnAddDb = createButton(parent, CLIENT_ID,
                    Messages.DependencyProperties_add_database, FILE.ICONDATABASE);
            btnAddDb.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    InputDialog dialog = new InputDialog(getShell(),
                            Messages.DependencyProperties_add_database,
                            Messages.DependencyProperties_enter_connection_string, "", null); //$NON-NLS-1$

                    if (dialog.open() == Window.OK) {
                        getList().add(new PgLibrary(dialog.getValue()));
                        getViewer().refresh();
                    }
                }
            });

            createButton(parent, DELETE_ID, Messages.delete, Activator.getEclipseImage(ISharedImages.IMG_ETOOL_DELETE));
            createButton(parent, UP_ID, null, FILE.ICONUP);
            createButton(parent, DOWN_ID, null, FILE.ICONDOWN);
        }
    }

    private static class IgnorePrivCheckEditingSupport extends EditingSupport {
        private final CheckboxCellEditor cellEditor;

        public IgnorePrivCheckEditingSupport(ColumnViewer viewer) {
            super(viewer);
            cellEditor = new CheckboxCellEditor(((TableViewer)viewer).getTable());
        }

        @Override
        protected CellEditor getCellEditor(Object element) {
            return cellEditor;
        }

        @Override
        protected boolean canEdit(Object element) {
            return true;
        }

        @Override
        protected Object getValue(Object element) {
            return ((PgLibrary) element).isIgnorePriv();
        }

        @Override
        protected void setValue(Object element, Object value) {
            ((PgLibrary) element).setIgnorePriv((boolean) value);
            getViewer().update(element, null);
        }
    }
}
