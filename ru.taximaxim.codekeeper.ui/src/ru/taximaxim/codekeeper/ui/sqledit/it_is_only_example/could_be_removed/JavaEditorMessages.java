/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.sqledit.it_is_only_example.could_be_removed;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class JavaEditorMessages {

    private static final String RESOURCE_BUNDLE= "org.eclipse.ui.examples.javaeditor.JavaEditorMessages";//$NON-NLS-1$

    private static ResourceBundle fgResourceBundle= ResourceBundle.getBundle(RESOURCE_BUNDLE);

    private JavaEditorMessages() {
    }

    public static String getString(String key) {
        try {
            return fgResourceBundle.getString(key);
        } catch (MissingResourceException e) {
            return "!" + key + "!";//$NON-NLS-2$ //$NON-NLS-1$
        }
    }

    public static ResourceBundle getResourceBundle() {
        return fgResourceBundle;
    }
}
