package ru.taximaxim.codekeeper.ui.properties;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.dialogs.PropertyPage;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF_PAGE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.prefs.PrefListEditor;
import ru.taximaxim.codekeeper.ui.xmlstore.DependenciesXmlStore;

public class DependencyProperties extends PropertyPage {

    private final String path = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
    private DependenciesXmlStore store;
    private DependenciesListEditor editor;

    @Override
    public void setElement(IAdaptable element) {
        super.setElement(element);
        store = new DependenciesXmlStore(element.getAdapter(IProject.class));
    }

    @Override
    protected Control createContents(Composite parent) {
        editor = new DependenciesListEditor(parent);
        List<Dependency> input;
        try {
            input = store.readObjects();
        } catch (IOException e) {
            Log.log(e);
            input = new ArrayList<>();
        }
        editor.setInputList(input);
        return editor;
    }

    @Override
    public boolean performOk() {
        try {
            store.writeObjects(editor.getList());
        } catch (IOException e) {
            Log.log(e);
        }
        return true;
    }

    private class DependenciesListEditor extends PrefListEditor<Dependency, TableViewer> {

        public DependenciesListEditor(Composite parent) {
            super(parent);
        }

        @Override
        protected Dependency getNewObject(Dependency oldObject) {
            DirectoryDialog dialog = new DirectoryDialog(getShell());
            dialog.setText(Messages.DependencyProperties_select_pgcodekeeper_project);
            dialog.setFilterPath(path);
            String path = dialog.open();
            return path != null ? new Dependency(path, DepType.PROJECT) : null;
        }

        @Override
        protected String errorAlreadyExists(Dependency obj) {
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
                    Dependency obj = (Dependency) element;
                    return obj.getPath();
                }
            });

            TableViewerColumn type = new TableViewerColumn(viewer, SWT.CENTER);
            type.getColumn().setText(Messages.DependencyProperties_type);
            type.getColumn().setResizable(true);
            type.getColumn().setMoveable(true);
            type.setLabelProvider(new ColumnLabelProvider() {

                @Override
                public String getText(Object element) {
                    Dependency obj = (Dependency) element;
                    return obj.getType().name();
                }
            });

            TableViewerColumn ignorePriv = new TableViewerColumn(viewer, SWT.CENTER);
            ignorePriv.getColumn().setText(Messages.DependencyProperties_ignore_privileges);
            ignorePriv.getColumn().setResizable(true);
            ignorePriv.getColumn().setMoveable(true);
            ignorePriv.setLabelProvider(new ColumnLabelProvider() {

                @Override
                public String getText(Object element) {
                    if (((Dependency)element).isIgnorePriv()) {
                        return Character.toString((char)0x2611);
                    } else {
                        return Character.toString((char)0x2610);
                    }
                }
            });

            ignorePriv.setEditingSupport(new IgnorePrivCheckEditingSupport(viewer));

            int width = (int)(viewer.getTable().getSize().x * 0.25);
            path.getColumn().setWidth(Math.max(width * 2, 300));
            type.getColumn().setWidth(Math.max(width, 150));
            ignorePriv.getColumn().setWidth(Math.max(width, 150));
        }

        @Override
        protected void createButtonsForSideBar(Composite parent) {
            createButton(parent, ADD_ID, Messages.DependencyProperties_add_pgcodekeeper_project, FILE.ICONAPPSMALL);

            Button btnAddDirectory = createButton(parent, CLIENT_ID, Messages.DependencyProperties_add_directory,
                    Activator.getEclipseImage(ISharedImages.IMG_OBJ_FOLDER));
            btnAddDirectory.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    DirectoryDialog dialog = new DirectoryDialog(getShell());
                    dialog.setText(Messages.DependencyProperties_select_directory);
                    dialog.setFilterPath(path);
                    String value = dialog.open();
                    if (value != null) {
                        getList().add(new Dependency(value, DepType.DIRECTORY));
                        getViewer().refresh();
                    }
                }
            });

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
                    dialog.setFilterPath(path);
                    String value = dialog.open();
                    if (value != null) {
                        getList().add(new Dependency(value, DepType.DUMP));
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
                        getList().add(new Dependency(dialog.getValue(), DepType.DATABASE));
                        getViewer().refresh();
                    }
                }
            });

            createButton(parent, DELETE_ID, Messages.delete, Activator.getEclipseImage(ISharedImages.IMG_ETOOL_DELETE));
            createButton(parent, UP_ID, null, FILE.ICONUP);
            createButton(parent, DOWN_ID, null, FILE.ICONDOWN);
        }
    }

    private class IgnorePrivCheckEditingSupport extends EditingSupport{
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
            return ((Dependency) element).isIgnorePriv();
        }

        @Override
        protected void setValue(Object element, Object value) {
            ((Dependency) element).setIgnorePriv((boolean) value);
            getViewer().update(element, null);
        }
    }
}
