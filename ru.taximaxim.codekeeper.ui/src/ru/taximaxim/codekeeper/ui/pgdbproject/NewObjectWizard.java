package ru.taximaxim.codekeeper.ui.pgdbproject;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.ui.UIConsts.NATURE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class NewObjectWizard extends Wizard implements INewWizard {

    private IProject currentProj;
    private DbObjType type = DbObjType.SCHEMA;
    private String name = "";  //$NON-NLS-1$
    private String schema = "";  //$NON-NLS-1$
    private String parent = "";  //$NON-NLS-1$
    private String column = "";  //$NON-NLS-1$
    private boolean parentIsTable = true;

    private IStructuredSelection selection;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
    }

    @Override
    public boolean performFinish() {
        return ((IPgObjectPage)getContainer().getCurrentPage()).createFile();
    }

    @Override
    public void addPages() {
        setWindowTitle(Messages.PgObject_wizard_title);
        addPage(new NewObjectProjPage(Messages.PgObject_create_object, selection));
        addPage(new NewObjectRelationPage());
    }

    @Override
    public boolean canFinish() {
        IWizardPage page = (getContainer().getCurrentPage());
        if (page == null || !(page instanceof IPgObjectPage)) {
            return false;
        }

        return ((IPgObjectPage)page).canFinish();
    }

    /**
     * New object creation wizard's first page. <br>
     * Last page for schemas and extensions
     *
     * @author galiev_mr
     * @see DbObjType
     */
    private final class NewObjectProjPage extends WizardPage implements IPgObjectPage {

        private final IStructuredSelection selection;
        private ComboViewer viewerProject;
        private ComboViewer viewerType;

        protected NewObjectProjPage(String pageName, IStructuredSelection selection) {
            super(pageName, pageName, null);
            this.selection = selection;
        }

        @Override
        public void createControl(Composite parent) {
            Composite area = new Composite(parent, SWT.NONE);
            area.setLayout(new GridLayout(2, false));
            area.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

            new Label(area, SWT.NONE).setText(Messages.PgObject_project_name);
            viewerProject = new ComboViewer(area, SWT.READ_ONLY | SWT.DROP_DOWN);

            new Label(area, SWT.NONE).setText(Messages.PgObject_object_type);
            viewerType = new ComboViewer(area, SWT.READ_ONLY | SWT.DROP_DOWN);

            new Label(area, SWT.NONE).setText(Messages.PgObject_object_name);
            final Text txtName = new Text(area, SWT.BORDER);
            txtName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
            txtName.addModifyListener(e -> {
                name = txtName.getText();
                getWizard().getContainer().updateButtons();
            });
            fillProjects();
            fillTypes();
            setControl(area);
        }

        private void fillProjects() {
            viewerProject.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
            viewerProject.setContentProvider(ArrayContentProvider.getInstance());
            viewerProject.setLabelProvider(new LabelProvider() {

                @Override
                public String getText(Object element) {
                    if (element instanceof IProject) {
                        return ((IProject)element).getName();
                    }
                    return super.getText(element);
                }
            });

            List<IProject> projectList = new ArrayList<>();
            IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
            IProject[] projects = workspaceRoot.getProjects();

            for (IProject project : projects) {
                try {
                    if (project.isOpen() && project.hasNature(NATURE.ID)) {
                        projectList.add(project);
                    }
                } catch (CoreException ex) {
                    Log.log(Log.LOG_ERROR, "Project nature identifier error" //$NON-NLS-1$
                            + ex.getLocalizedMessage(), ex);
                }
            }

            if (projectList.isEmpty()) {
                setErrorMessage(Messages.PgObject_cant_find_projects);
            } else {
                viewerProject.setInput(projectList);
            }

            viewerProject.addSelectionChangedListener(e -> {
                Object object = e.getStructuredSelection().getFirstElement();
                if (object != null) {
                    currentProj = ((IProject) object);
                }
                getWizard().getContainer().updateButtons();
            });

            Object element = selection.getFirstElement();
            if (element instanceof IResource) {
                IProject current = ((IResource)element).getProject();
                if (projectList.contains(current)) {
                    viewerProject.setSelection(new StructuredSelection(current));
                }
            }
        }

        private void fillTypes() {
            viewerType.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
            viewerType.setContentProvider(ArrayContentProvider.getInstance());
            viewerType.setInput(EnumSet.complementOf(EnumSet.of(DbObjType.COLUMN,
                    DbObjType.DATABASE, DbObjType.SEQUENCE)));
            viewerType.setSelection(new StructuredSelection(DbObjType.SCHEMA));
            viewerType.addSelectionChangedListener(e -> {
                type = (DbObjType) e.getStructuredSelection().getFirstElement();
                IWizardPage page = getContainer().getCurrentPage().getNextPage();
                if (page != null) {
                    ((NewObjectRelationPage)page).refresh();
                }
                getWizard().getContainer().updateButtons();
            });
        }

        @Override
        public boolean isPageComplete() {
            if (name.isEmpty()) {
                setDescription(Messages.PgObject_empty_name);
                return false;
            }

            if (viewerProject.getStructuredSelection().getFirstElement() == null) {
                setDescription(Messages.PgObject_select_project);
                return false;
            }

            setDescription(getTitle());
            return true;
        }

        @Override
        public IWizardPage getNextPage() {
            if (canFinish()) {
                return null;
            }
            return super.getNextPage();
        }

        @Override
        public boolean canFinish() {
            return isPageComplete() && (type == DbObjType.SCHEMA || type == DbObjType.EXTENSION);
        }

        @Override
        public boolean createFile() {
            try {
                if (type == DbObjType.EXTENSION) {
                    IPgObjectPage.createExtension(name, currentProj);
                } else {
                    IPgObjectPage.createSchema(name, true, currentProj);
                }
                return true;
            } catch (CoreException ex) {
                Log.log(Log.LOG_ERROR, Messages.PgObject_file_creation_error
                        + ex.getLocalizedMessage(), ex);
                setErrorMessage(Messages.PgObject_file_creation_error);
                return false;
            }
        }
    }

    /**
     * New object creation wizard's last page.
     *
     * @author galiev_mr
     * @see DbObjType
     */
    private class NewObjectRelationPage extends WizardPage implements IPgObjectPage {
        private Group group;
        private Label lblSchema;
        private Label lblParent;
        private Label lblColumn;
        private Text txtSchema;
        private Text txtParent;
        private Text txtColumn;

        protected NewObjectRelationPage() {
            super(Messages.PgObject_create_object, Messages.PgObject_create_object, null);
        }

        @Override
        public void createControl(Composite composite) {
            Composite area = new Composite(composite, SWT.NONE);
            area.setLayout(new GridLayout(2, false));
            area.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

            lblSchema = new Label(area, SWT.NONE);
            lblSchema.setText(Messages.PgObject_schema_name);
            txtSchema = new Text(area, SWT.BORDER);
            txtSchema.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
            txtSchema.addModifyListener(e -> {
                schema = txtSchema.getText();
                getWizard().getContainer().updateButtons();
            });

            lblParent = new Label(area, SWT.NONE);
            lblParent.setText(Messages.PgObject_parent_name);
            txtParent = new Text(area, SWT.BORDER);
            txtParent.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
            txtParent.addModifyListener(e -> {
                parent = txtParent.getText();
                getWizard().getContainer().updateButtons();
            });

            lblColumn = new Label(area, SWT.NONE);
            lblColumn.setText(Messages.PgObject_column_name);
            txtColumn = new Text(area, SWT.BORDER);
            txtColumn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
            txtColumn.addModifyListener(e -> {
                column = txtColumn.getText();
                getWizard().getContainer().updateButtons();
            });

            createAdditionalFields(area);
            setControl(area);
        }

        private void createAdditionalFields(Composite area) {
            group = new Group(area, SWT.NONE);
            group.setText(Messages.PgObject_parent_type);
            group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
            group.setLayout(new GridLayout(2, true));

            final Button btnTable = new Button(group, SWT.RADIO);
            btnTable.setText(Messages.PgObject_table);
            btnTable.setSelection(parentIsTable);
            btnTable.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    parentIsTable = true;
                }
            });

            final Button btnView = new Button(group, SWT.RADIO);
            btnView.setText(Messages.PgObject_view);
            btnView.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    parentIsTable = false;
                }
            });
        }

        @Override
        public boolean isPageComplete() {
            if (schema.isEmpty()) {
                setDescription(Messages.PgObject_enter_schema);
                return false;
            }
            if (isSubElement() && parent.isEmpty()) {
                setDescription(Messages.PgObject_enter_parent);
                return false;
            }
            if (isHaveColumn() && column.isEmpty()) {
                setDescription(Messages.PgObject_enter_column);
                return false;
            }

            setDescription(getTitle());
            return true;
        }

        @Override
        public boolean canFinish() {
            return isPageComplete();
        }

        @Override
        public boolean createFile() {
            try {
                if (!isSubElement()) {
                    IPgObjectPage.createObject(schema, name, type, true, currentProj);
                } else {
                    IPgObjectPage.createSubElement(schema, parent, column, name,
                            !isHaveChoise() || parentIsTable, currentProj, type);
                }
                return true;
            } catch (CoreException ex) {
                Log.log(Log.LOG_ERROR, Messages.PgObject_file_creation_error
                        + ex.getLocalizedMessage(), ex);
                setErrorMessage(Messages.PgObject_file_creation_error);
                return false;
            }
        }

        public boolean isHaveColumn() {
            return type == DbObjType.CONSTRAINT
                    || type == DbObjType.INDEX;
        }

        public boolean isSubElement() {
            return isHaveChoise() || isHaveColumn();
        }

        private boolean isHaveChoise() {
            return type == DbObjType.TRIGGER
                    || type == DbObjType.RULE;
        }

        public void refresh() {
            GridData data;
            lblParent.setVisible(isSubElement());
            txtParent.setVisible(isSubElement());

            lblColumn.setVisible(isHaveColumn());
            data = (GridData)lblColumn.getLayoutData();
            data.exclude = !isHaveColumn();

            txtColumn.setVisible(isHaveColumn());
            data = (GridData)txtColumn.getLayoutData();
            data.exclude = !isHaveColumn();

            group.setVisible(isHaveChoise());

            txtColumn.getParent().layout(false);
        }
    }
}