// Copy of org.eclipse.ui.dialogs.ListDialog, supressed warnings 

package ru.taximaxim.codekeeper.ui.copiedclasses;

/*******************************************************************************
 * Copyright (c) 2000, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

/**
 * Copy of org.eclipse.ui.dialogs.ListDialog, suppressed warnings
 * <br>
 * A dialog that prompts for one element out of a list of elements. Uses
 * <code>IStructuredContentProvider</code> to provide the elements and
 * <code>ILabelProvider</code> to provide their labels.
 * 
 * @since 2.1
 */
@SuppressWarnings("rawtypes")
public class ListDialog extends SelectionDialog {
    private IStructuredContentProvider fContentProvider;

    private ILabelProvider fLabelProvider;

    private Object fInput;

    private TableViewer fTableViewer;

    private boolean fAddCancelButton = true;

    private int widthInChars = 55;

    private int heightInChars = 15;

    /**
     * Create a new instance of the receiver with parent shell of parent.
     * @param parent
     */
    public ListDialog(Shell parent) {
        super(parent);
    }

    /**
     * @param input The input for the list.
     */
    public void setInput(Object input) {
        fInput = input;
    }

    /**
     * @param sp The content provider for the list.
     */
    public void setContentProvider(IStructuredContentProvider sp) {
        fContentProvider = sp;
    }

    /**
     * @param lp The labelProvider for the list.
     */
    public void setLabelProvider(ILabelProvider lp) {
        fLabelProvider = lp;
    }

    /**
     *@param addCancelButton if <code>true</code> there will be a cancel
     * button.
     */
    public void setAddCancelButton(boolean addCancelButton) {
        fAddCancelButton = addCancelButton;
    }

    /**
     * @return the TableViewer for the receiver.
     */
    public TableViewer getTableViewer() {
        return fTableViewer;
    }

    protected void createButtonsForButtonBar(Composite parent) {
        if (!fAddCancelButton) {
            createButton(parent, IDialogConstants.OK_ID,
                    IDialogConstants.OK_LABEL, true);
        } else {
            super.createButtonsForButtonBar(parent);
        }
    }

    protected Control createDialogArea(Composite container) {
        Composite parent = (Composite) super.createDialogArea(container);
        createMessageArea(parent);
        fTableViewer = new TableViewer(parent, getTableStyle());
        fTableViewer.setContentProvider(fContentProvider);
        fTableViewer.setLabelProvider(fLabelProvider);
        fTableViewer.setInput(fInput);
        fTableViewer.addDoubleClickListener(new IDoubleClickListener() {
            public void doubleClick(DoubleClickEvent event) {
                if (fAddCancelButton) {
                    okPressed();
                }
            }
        });
        List initialSelection = getInitialElementSelections();
        if (initialSelection != null) {
            fTableViewer
                    .setSelection(new StructuredSelection(initialSelection));
        }
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = convertHeightInCharsToPixels(heightInChars);
        gd.widthHint = convertWidthInCharsToPixels(widthInChars);
        Table table = fTableViewer.getTable();
        table.setLayoutData(gd);
        table.setFont(container.getFont());
        return parent;
    }

    /**
     * Return the style flags for the table viewer.
     * @return int
     */
    protected int getTableStyle() {
        return SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER;
    }

    /*
     * Overrides method from Dialog
     */
    protected void okPressed() {
        // Build a list of selected children.
        IStructuredSelection selection = (IStructuredSelection) fTableViewer
                .getSelection();
        setResult(selection.toList());
        super.okPressed();
    }

    /**
     * Returns the initial height of the dialog in number of characters.
     * 
     * @return the initial height of the dialog in number of characters
     */
    public int getHeightInChars() {
        return heightInChars;
    }

    /**
     * Returns the initial width of the dialog in number of characters.
     * 
     * @return the initial width of the dialog in number of characters
     */
    public int getWidthInChars() {
        return widthInChars;
    }

    /**
     * Sets the initial height of the dialog in number of characters.
     * 
     * @param heightInChars
     *            the initialheight of the dialog in number of characters
     */
    public void setHeightInChars(int heightInChars) {
        this.heightInChars = heightInChars;
    }

    /**
     * Sets the initial width of the dialog in number of characters.
     * 
     * @param widthInChars
     *            the initial width of the dialog in number of characters
     */
    public void setWidthInChars(int widthInChars) {
        this.widthInChars = widthInChars;
    }
}
