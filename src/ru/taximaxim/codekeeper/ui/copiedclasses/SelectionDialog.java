// Copy of org.eclipse.ui.dialogs.SelectionDialog, supressed warnings

package ru.taximaxim.codekeeper.ui.copiedclasses;

/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * Copy of org.eclipse.ui.dialogs.SelectionDialog, supressed warnings
 * <br>
 * The abstract implementation of a selection dialog. It can be primed with
 * initial selections (<code>setInitialSelections</code>), and returns the
 * final selection (via <code>getResult</code>) after completion.
 * <p>
 * Clients may subclass this dialog to inherit its selection facilities.
 * </p>
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class SelectionDialog extends TrayDialog {
    // the final collection of selected elements, or null if this dialog was
    // canceled
    private Object[] result;

    // a collection of the initially-selected elements
    private List initialSelections = new ArrayList();

    // title of dialog
    private String title;

    // message to show user
    private String message = ""; //$NON-NLS-1$

    // dialog bounds strategy (since 3.2)
    private int dialogBoundsStrategy = Dialog.DIALOG_PERSISTLOCATION | Dialog.DIALOG_PERSISTSIZE;

    // dialog settings for storing bounds (since 3.2)
    private IDialogSettings dialogBoundsSettings = null;

    static String SELECT_ALL_TITLE = WorkbenchMessages.SelectionDialog_selectLabel;

    static String DESELECT_ALL_TITLE = WorkbenchMessages.SelectionDialog_deselectLabel;

    /**
     * Creates a dialog instance. Note that the dialog will have no visual
     * representation (no widgets) until it is told to open.
     * 
     * @param parentShell
     *            the parent shell
     */
    protected SelectionDialog(Shell parentShell) {
        super(parentShell);
    }

    /*
     * (non-Javadoc) Method declared in Window.
     */
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        if (title != null) {
            shell.setText(title);
        }
    }

    /*
     * (non-Javadoc) Method declared on Dialog.
     */
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
                true);
        createButton(parent, IDialogConstants.CANCEL_ID,
                IDialogConstants.CANCEL_LABEL, false);
    }

    /**
     * Creates the message area for this dialog.
     * <p>
     * This method is provided to allow subclasses to decide where the message
     * will appear on the screen.
     * </p>
     * 
     * @param composite
     *            the parent composite
     * @return the message label
     */
    protected Label createMessageArea(Composite composite) {
        Label label = new Label(composite, SWT.NONE);
        if (message != null) {
            label.setText(message);
        }
        label.setFont(composite.getFont());
        return label;
    }

    /**
     * Returns the initial selection in this selection dialog.
     * 
     * @deprecated use getInitialElementSelections() instead
     * @return the list of initial selected elements or null
     */
    protected List getInitialSelections() {
        if (initialSelections.isEmpty()) {
            return null;
        }
        return getInitialElementSelections();
    }

    /**
     * Returns the list of initial element selections.
     * 
     * @return List
     */
    protected List getInitialElementSelections() {
        return initialSelections;
    }

    /**
     * Returns the message for this dialog.
     * 
     * @return the message for this dialog
     */
    protected String getMessage() {
        return message;
    }

    /**
     * Returns the ok button.
     * 
     * @return the ok button or <code>null</code> if the button is not created
     *         yet.
     */
    public Button getOkButton() {
        return getButton(IDialogConstants.OK_ID);
    }

    /**
     * Returns the list of selections made by the user, or <code>null</code>
     * if the selection was canceled.
     * 
     * @return the array of selected elements, or <code>null</code> if Cancel
     *         was pressed
     */
    public Object[] getResult() {
        return result;
    }

    /**
     * Sets the initial selection in this selection dialog to the given
     * elements.
     * 
     * @param selectedElements
     *            the array of elements to select
     */
    public void setInitialSelections(Object[] selectedElements) {
        initialSelections = new ArrayList(selectedElements.length);
        for (int i = 0; i < selectedElements.length; i++) {
            initialSelections.add(selectedElements[i]);
        }
    }

    /**
     * Sets the initial selection in this selection dialog to the given
     * elements.
     * 
     * @param selectedElements
     *            the List of elements to select
     */
    public void setInitialElementSelections(List selectedElements) {
        initialSelections = selectedElements;
    }

    /**
     * Sets the message for this dialog.
     * 
     * @param message
     *            the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Set the selections made by the user, or <code>null</code> if the
     * selection was canceled.
     * 
     * @param newResult
     *            list of selected elements, or <code>null</code> if Cancel
     *            was pressed
     */
    protected void setResult(List newResult) {
        if (newResult == null) {
            result = null;
        } else {
            result = new Object[newResult.size()];
            newResult.toArray(result);
        }
    }

    /**
     * Set the selections made by the user, or <code>null</code> if the
     * selection was canceled.
     * <p>
     * The selections may accessed using <code>getResult</code>.
     * </p>
     * 
     * @param newResult -
     *            the new values
     * @since 2.0
     */
    protected void setSelectionResult(Object[] newResult) {
        result = newResult;
    }

    /**
     * Sets the title for this dialog.
     * 
     * @param title
     *            the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set the dialog settings that should be used to save the bounds of this
     * dialog. This method is provided so that clients that directly use
     * SelectionDialogs without subclassing them may specify how the bounds of
     * the dialog are to be saved.
     * 
     * @param settings
     *            the {@link IDialogSettings} that should be used to store the
     *            bounds of the dialog
     * 
     * @param strategy
     *            the integer constant specifying how the bounds are saved.
     *            Specified using {@link Dialog#DIALOG_PERSISTLOCATION}
     *            and {@link Dialog#DIALOG_PERSISTSIZE}.
     * 
     * @since 3.2
     * 
     * @see Dialog#getDialogBoundsStrategy()
     * @see Dialog#getDialogBoundsSettings()
     */
    public void setDialogBoundsSettings(IDialogSettings settings, int strategy) {
        dialogBoundsStrategy = strategy;
        dialogBoundsSettings = settings;
    }

    /**
     * Gets the dialog settings that should be used for remembering the bounds
     * of the dialog, according to the dialog bounds strategy. Overridden to
     * provide the dialog settings that were set using
     * {@link #setDialogBoundsSettings(IDialogSettings, int)}.
     * 
     * @return the dialog settings used to store the dialog's location and/or
     *         size, or <code>null</code> if the dialog's bounds should not be
     *         stored.
     * 
     * @since 3.2
     * 
     * @see Dialog#getDialogBoundsStrategy()
     * @see #setDialogBoundsSettings(IDialogSettings, int)
     */
    protected IDialogSettings getDialogBoundsSettings() {
        return dialogBoundsSettings;
    }

    /**
     * Get the integer constant that describes the strategy for persisting the
     * dialog bounds. Overridden to provide the dialog bounds strategy that was
     * set using {@link #setDialogBoundsSettings(IDialogSettings, int)}.
     * 
     * @return the constant describing the strategy for persisting the dialog
     *         bounds.
     * 
     * @since 3.2
     * @see Dialog#DIALOG_PERSISTLOCATION
     * @see Dialog#DIALOG_PERSISTSIZE
     * @see Dialog#getDialogBoundsSettings()
     * @see #setDialogBoundsSettings(IDialogSettings, int)
     */
    protected int getDialogBoundsStrategy() {
        return dialogBoundsStrategy;
    }
    
    /**
     * @since 3.4
     */
    protected boolean isResizable() {
        return true;
    }
}
