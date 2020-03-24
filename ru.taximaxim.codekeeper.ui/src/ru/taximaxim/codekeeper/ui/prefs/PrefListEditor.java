package ru.taximaxim.codekeeper.ui.prefs;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.ISharedImages;

import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * @param <T> needs to have its own equals for proper duplicate detection
 */
public abstract class PrefListEditor<T> extends Composite {

    public static final int ADD_ID = 1;
    public static final int EDIT_ID = 2;
    public static final int COPY_ID = 3;
    public static final int DELETE_ID = 4;
    public static final int CLIENT_ID = 1024;

    private static final int WIDTH_HINT_PX = 240;
    private static final int HEIGHT_HINT_PX = 400;

    private List<T> objsList = new LinkedList<>();

    private final LocalResourceManager lrm = new LocalResourceManager(JFaceResources.getResources(), this);

    private final TableViewer viewerObjs;

    public PrefListEditor(Composite parent) {
        super(parent, SWT.NONE);

        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        setLayout(gridLayout);
        setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        viewerObjs = new TableViewer(
                this, SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
        viewerObjs.setContentProvider(ArrayContentProvider.getInstance());

        addColumns(viewerObjs);

        GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
        viewerObjs.getTable().setLayoutData(gd);
        if (viewerObjs.getTable().getColumnCount() > 1) {
            viewerObjs.getTable().setLinesVisible(true);
            viewerObjs.getTable().setHeaderVisible(true);
        } else {
            // set nonzero width to make column visible
            viewerObjs.getTable().getColumn(0).setWidth(WIDTH_HINT_PX);
        }
        gd.widthHint = WIDTH_HINT_PX;
        gd.heightHint = HEIGHT_HINT_PX;

        Transfer[] transferTypes = {LocalSelectionTransfer.getTransfer()};
        viewerObjs.addDragSupport(DND.DROP_MOVE, transferTypes, new DragListener());
        viewerObjs.addDropSupport(DND.DROP_MOVE, transferTypes, new DropListener());

        createSideBar();
    }

    private void createSideBar() {
        Composite sideBar = new Composite(this, SWT.NONE);
        GridLayout gridLayout = new GridLayout();
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        sideBar.setLayout(gridLayout);
        sideBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
        createButtonsForSideBar(sideBar);
    }

    protected void createButtonsForSideBar(Composite parent) {
        createButton(parent, ADD_ID, Messages.add, Activator.getEclipseImage(ISharedImages.IMG_OBJ_ADD));
        createButton(parent, DELETE_ID, Messages.delete, Activator.getEclipseImage(ISharedImages.IMG_ETOOL_DELETE));
    }

    protected Button createButton(Composite parent, int id, String tooltip, String image) {
        return createButton(parent, id, tooltip, lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(image))));
    }

    protected Button createButton(Composite parent, int id, String tooltip, Image image) {
        Button button = new Button(parent, SWT.PUSH);
        button.setToolTipText(tooltip);
        button.setImage(image);
        button.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
        button.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                buttonPressed(id);
            }
        });

        return button;
    }

    private void buttonPressed(int buttonId) {
        switch (buttonId) {
        case ADD_ID:
            addNewObject(null);
            break;
        case EDIT_ID:
            editObject();
            break;
        case COPY_ID:
            copyObject();
            break;
        case DELETE_ID:
            deleteObject();
            break;
        default:
            break;
        }
    }

    private boolean hasDuplicate(T newObj) {
        return objsList.stream().anyMatch(obj -> checkDuplicate(obj, newObj));
    }

    private void copyObject() {
        IStructuredSelection selection = (IStructuredSelection) viewerObjs.getSelection();
        if (selection.isEmpty()) {
            return;
        }
        @SuppressWarnings("unchecked")
        T sel = (T) selection.getFirstElement();
        T newObj = getNewObject(sel);
        while (newObj != null && hasDuplicate(newObj)) {
            newObj = getAnotherObject(newObj);
        }
        if (newObj != null) {
            objsList.add(0, newObj);
            viewerObjs.refresh();
        }
    }

    public void addNewObject(T oldObject) {
        T newObj = getNewObject(oldObject);
        while (newObj != null && hasDuplicate(newObj)) {
            newObj = getAnotherObject(newObj);
        }

        if (newObj != null) {
            objsList.add(0, newObj);
            viewerObjs.refresh();
        }
    }

    private T getAnotherObject(T value) {
        MessageBox mb = new MessageBox(getShell(), SWT.ICON_WARNING);
        mb.setText(Messages.PrefListEditor_cannot_add);
        mb.setMessage(errorAlreadyExists(value));
        mb.open();

        return getNewObject(value);
    }

    protected void editObject() {
        IStructuredSelection selection = (IStructuredSelection) viewerObjs.getSelection();
        if (selection.isEmpty()) {
            return;
        }
        @SuppressWarnings("unchecked")
        T sel = (T) selection.getFirstElement();
        T newObj = getNewObject(sel);
        while (newObj != null && !sel.equals(newObj) && hasDuplicate(newObj)) {
            newObj = getAnotherObject(newObj);
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

    private void deleteObject() {
        IStructuredSelection selection = (IStructuredSelection) viewerObjs.getSelection();
        if (selection.isEmpty()) {
            return;
        }
        if (objsList.remove(selection.getFirstElement())) {
            viewerObjs.refresh();
        }
    }

    protected abstract void addColumns(TableViewer viewer);

    /**
     * @param oldObject old edited object or duplicate object that user have created on the previous call
     * @return newly created object or null
     */
    protected abstract T getNewObject(T oldObject);

    protected abstract String errorAlreadyExists(T obj);

    public boolean checkDuplicate(T o1, T o2) {
        return o1.equals(o2);
    }

    public List<T> getList(){
        return objsList;
    }

    public TableViewer getViewer() {
        return viewerObjs;
    }

    public void setInputList(List<T> list){
        objsList = list;
        viewerObjs.setInput(objsList);
    }

    private Object dragSource;
    private Object dragTarget;

    private class DragListener extends DragSourceAdapter {

        @Override
        public void dragStart(DragSourceEvent event) {
            dragSource = viewerObjs.getStructuredSelection().getFirstElement();
        }
    }

    private class DropListener extends ViewerDropAdapter {

        public DropListener() {
            super(viewerObjs);
        }

        @Override
        public boolean performDrop(Object data) {
            if (dragSource != dragTarget) {
                @SuppressWarnings("unchecked")
                T source = (T) dragSource;

                int targetIndex = objsList.indexOf(dragTarget);
                objsList.remove(source);
                objsList.add(targetIndex, source);
                dragSource = dragTarget = null;
                viewerObjs.refresh();
                return true;
            }
            return false;
        }

        @Override
        public boolean validateDrop(Object target, int operation,
                TransferData transferType) {
            if (target != null) {
                dragTarget = target;
            }
            return true;
        }
    }
}
