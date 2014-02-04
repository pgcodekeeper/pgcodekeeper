// Simplified copy of org.eclipse.ui.internal.WorkbenchMessages

package ru.taximaxim.codekeeper.ui.copiedclasses;

/*******************************************************************************
 * Copyright (c) 2005, 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * IBM - Initial API and implementation
 * Sebastian Davids - bug 128529
 * Semion Chichelnitsky (semion@il.ibm.com) - bug 278064
 * Tristan Hume - <trishume@gmail.com> -
 *      Fix for Bug 2369 [Workbench] Would like to be able to save workspace without exiting
 *      Implemented workbench auto-save to correctly restore state in case of crash.
 *******************************************************************************/

/**
 * Simplified copy of org.eclipse.ui.internal.WorkbenchMessages
 * changed to an interface-container
 * <br>
 * Message class for workbench messages.  These messages are used 
 * throughout the workbench.
 */
public interface WorkbenchMessages {
    String SelectionDialog_selectLabel = "&Select All";
    String SelectionDialog_deselectLabel = "&Deselect All";
    
    String ScopedPreferenceStore_DefaultAddedError = "Do not add the default to the search contexts";
}
