package ru.taximaxim.codekeeper.ui.prefs;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.ISharedImages;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.FILE;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * @param <T> needs to have its own equals for proper duplicate detection
 */
public abstract class PrefListEditor<T, V extends StructuredViewer> extends Composite {

    private List<T> objsList = new LinkedList<>();

    private final V viewerObjs;
    private final Button btnAdd, btnEdit, btnDelete, upBtn, downBtn;

    public PrefListEditor(Composite parent, boolean doSorting, boolean doEdit, boolean noMargins) {
        super(parent, SWT.NONE);

        LocalResourceManager lrm = new LocalResourceManager(
                JFaceResources.getResources(), this);

        GridLayout gridLayout = new GridLayout(2, false);
        if (noMargins) {
            gridLayout.marginHeight = 0;
            gridLayout.marginWidth = 0;
        }
        this.setLayout(gridLayout);
        this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        viewerObjs = createViewer(this);

        btnAdd = new Button(this, SWT.PUSH);
        btnAdd.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
        btnAdd.setToolTipText(Messages.add);
        btnAdd.setImage(Activator.getEclipseImage(ISharedImages.IMG_OBJ_ADD));
        btnAdd.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                addNewObject(null);
            }
        });

        if (doEdit) {
            btnEdit = new Button(this, SWT.PUSH);
            btnEdit.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
            btnEdit.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(FILE.ICONEDIT))));
            btnEdit.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    IStructuredSelection selection = (IStructuredSelection) viewerObjs.getSelection();
                    if (selection.isEmpty()) {
                        return;
                    }
                    @SuppressWarnings("unchecked")
                    T sel = (T) selection.getFirstElement();
                    T newObj = getNewObject(sel);
                    while (newObj != null && !sel.equals(newObj) && objsList.contains(newObj)) {
                        // duplicate
                        MessageBox mb = new MessageBox(getShell(), SWT.ICON_WARNING);
                        mb.setText(Messages.PrefListEditor_cannot_edit);
                        mb.setMessage(errorAlreadyExists(newObj));
                        mb.open();

                        // request object again preserving info already entered
                        newObj = getNewObject(newObj);
                    }
                    if (newObj != null) {
                        // replace existing, iterator way is more efficient on LinkedList
                        ListIterator<T> it = objsList.listIterator();
                        while (it.hasNext()) {
                            T match = it.next();
                            if (match == sel) {
                                it.set(newObj);
                                break;
                            }
                        }
                        viewerObjs.refresh();
                    }
                }
            });
        } else {
            btnEdit = null;
        }

        btnDelete = new Button(this, SWT.PUSH);
        btnDelete.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
        btnDelete.setToolTipText(Messages.delete);
        btnDelete.setImage(Activator.getEclipseImage(ISharedImages.IMG_ETOOL_DELETE));
        btnDelete.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                IStructuredSelection selection = (IStructuredSelection) viewerObjs.getSelection();
                if (selection.isEmpty()) {
                    return;
                }
                if (objsList.remove(selection.getFirstElement())) {
                    viewerObjs.refresh();
                }
            }
        });

        if (!doSorting) {
            upBtn = new Button(this, SWT.PUSH);
            upBtn.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
            upBtn.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(FILE.ICONUP))));
            upBtn.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    IStructuredSelection selection = (IStructuredSelection) viewerObjs.getSelection();
                    if (selection.isEmpty()) {
                        return;
                    }
                    Object sel = selection.getFirstElement();
                    ListIterator<T> it = objsList.listIterator();
                    while (it.hasNext()) {
                        T match = it.next();
                        if (match == sel) {
                            it.previous();
                            if (it.hasPrevious()) {
                                T prev = it.previous();
                                it.set(match);
                                it.next();
                                it.next();
                                it.set(prev);
                                viewerObjs.refresh();
                            }
                            return;
                        }
                    }
                }
            });

            downBtn = new Button(this, SWT.PUSH);
            downBtn.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
            downBtn.setImage(lrm.createImage(ImageDescriptor.createFromURL(
                    Activator.getContext().getBundle().getResource(FILE.ICONDOWN))));
            downBtn.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    IStructuredSelection selection = (IStructuredSelection) viewerObjs.getSelection();
                    if (selection.isEmpty()) {
                        return;
                    }
                    Object sel = selection.getFirstElement();
                    ListIterator<T> it = objsList.listIterator();
                    while (it.hasNext()) {
                        T match = it.next();
                        if (match == sel) {
                            if (it.hasNext()) {
                                T next = it.next();
                                it.set(match);
                                it.previous();
                                it.previous();
                                it.set(next);
                                viewerObjs.refresh();
                            }
                            return;
                        }
                    }
                }
            });

            createAdditionalButtons(this, viewerObjs, lrm);
        } else {
            viewerObjs.setComparator(new ViewerComparator());
            upBtn = null;
            downBtn = null;
        }
    }

    protected void createAdditionalButtons(PrefListEditor<T, V> prefListEditor,
            V viewer, LocalResourceManager lrm) {
        // will be overridden by subclasses if needed
    }

    public void addNewObject(T oldObject) {
        T newValue = getNewObject(oldObject);
        while (newValue != null && objsList.contains(newValue)) {
            // duplicate
            MessageBox mb = new MessageBox(getShell(), SWT.ICON_WARNING);
            mb.setText(Messages.PrefListEditor_cannot_add);
            mb.setMessage(errorAlreadyExists(newValue));
            mb.open();

            // request object again preserving info already entered
            newValue = getNewObject(newValue);
        }
        if (newValue != null) {
            objsList.add(0, newValue);
            viewerObjs.refresh();
        }
    }

    protected abstract V createViewer(Composite parent);

    /**
     * @param oldObject old edited object or duplicate object that user have created on the previous call
     * @return newly created object or null
     */
    protected abstract T getNewObject(T oldObject);

    protected abstract String errorAlreadyExists(T obj);

    public List<T> getList(){
        return objsList;
    }

    public V getViewer() {
        return viewerObjs;
    }

    public void setInputList(List<T> list){
        objsList = list;
        viewerObjs.setInput(objsList);
    }
}
