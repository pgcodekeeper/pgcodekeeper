package ru.taximaxim.codekeeper.ui.prefs;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
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
public abstract class PrefListEditor<T, V extends StructuredViewer> extends Composite {

    public static final int ADD_ID = 1;
    public static final int EDIT_ID = 2;
    public static final int COPY_ID = 3;
    public static final int DELETE_ID = 4;
    public static final int UP_ID = 5;
    public static final int DOWN_ID = 6;
    public static final int CLIENT_ID = 1024;

    private List<T> objsList = new LinkedList<>();

    protected final LocalResourceManager lrm = new LocalResourceManager(JFaceResources.getResources(), this);

    private final V viewerObjs;

    public PrefListEditor(Composite parent) {
        super(parent, SWT.NONE);

        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginHeight = 0;
        gridLayout.marginWidth = 0;
        setLayout(gridLayout);
        setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        viewerObjs = createViewer(this);
        createButtonsForSideBar(this);
    }


    protected void createButtonsForSideBar(Composite parent) {
        createButton(parent, ADD_ID, Messages.add, Activator.getEclipseImage(ISharedImages.IMG_OBJ_ADD), GridData.VERTICAL_ALIGN_BEGINNING);
    }

    protected Button createButton(Composite parent, int id, String label, String image, int gridDataStyle) {
        return createButton(parent, id, label, lrm.createImage(ImageDescriptor.createFromURL(
                Activator.getContext().getBundle().getResource(image))), gridDataStyle);
    }

    protected Button createButton(Composite parent, int id, String label, Image image, int gridDataStyle) {
        Button button = new Button(parent, SWT.PUSH);
        if (label != null) {
            button.setToolTipText(label);
        }
        button.setFont(JFaceResources.getDialogFont());
        button.setImage(image);
        button.setLayoutData(new GridData(gridDataStyle));
        button.setData(Integer.valueOf(id));
        button.addSelectionListener(widgetSelectedAdapter(event -> buttonPressed(((Integer) event.widget.getData()).intValue())));
        return button;
    }

    private void buttonPressed(int buttonId) {
        if (ADD_ID == buttonId) {
            addNewObject(null);
        } else if (EDIT_ID == buttonId) {
            editObject();
        } else if (COPY_ID == buttonId) {
            copyObject();
        } else if (DELETE_ID == buttonId) {
            deleteObject();
        } else if (UP_ID == buttonId) {
            upObject();
        } else if (DOWN_ID == buttonId) {
            downObject();
        }
    }

    private void copyObject() {
        IStructuredSelection selection = (IStructuredSelection) viewerObjs.getSelection();
        if (selection.isEmpty()) {
            return;
        }
        @SuppressWarnings("unchecked")
        T sel = (T) selection.getFirstElement();
        T newObj = getNewObject(sel);
        while (newObj != null && objsList.contains(newObj)) {
            newObj = getAnotherObject(newObj);
        }
        if (newObj != null) {
            objsList.add(0, newObj);
            viewerObjs.refresh();
        }
    }

    private void upObject() {
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

    private void downObject() {
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

    public void addNewObject(T oldObject) {
        T newObj = getNewObject(oldObject);
        while (newObj != null && objsList.contains(newObj)) {
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


    private void editObject() {
        IStructuredSelection selection = (IStructuredSelection) viewerObjs.getSelection();
        if (selection.isEmpty()) {
            return;
        }
        @SuppressWarnings("unchecked")
        T sel = (T) selection.getFirstElement();
        T newObj = getNewObject(sel);
        while (newObj != null && !sel.equals(newObj) && objsList.contains(newObj)) {
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
