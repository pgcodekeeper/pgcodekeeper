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

import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import ru.taximaxim.codekeeper.ui.sqledit.it_is_only_example.could_be_removed.java.JavaCodeScanner;
import ru.taximaxim.codekeeper.ui.sqledit.it_is_only_example.could_be_removed.javadoc.JavaDocScanner;
import ru.taximaxim.codekeeper.ui.sqledit.it_is_only_example.could_be_removed.util.JavaColorProvider;

/**
 * The example java editor plug-in class.
 *
 * @since 3.0
 */
public class JavaEditorExamplePlugin extends AbstractUIPlugin {

    public final static String JAVA_PARTITIONING= "__java_example_partitioning";   //$NON-NLS-1$

    private static JavaEditorExamplePlugin fgInstance;
    private JavaPartitionScanner fPartitionScanner;
    private JavaColorProvider fColorProvider;
    private JavaCodeScanner fCodeScanner;
    private JavaDocScanner fDocScanner;

    /**
     * Creates a new plug-in instance.
     */
    public JavaEditorExamplePlugin() {
        fgInstance= this;
    }

    /**
     * Returns the default plug-in instance.
     *
     * @return the default plug-in instance
     */
    public static JavaEditorExamplePlugin getDefault() {
        return fgInstance;
    }

    /**
     * Return a scanner for creating Java partitions.
     *
     * @return a scanner for creating Java partitions
     */
    public JavaPartitionScanner getJavaPartitionScanner() {
        if (fPartitionScanner == null) {
            fPartitionScanner= new JavaPartitionScanner();
        }
        return fPartitionScanner;
    }

    /**
     * Returns the singleton Java code scanner.
     *
     * @return the singleton Java code scanner
     */
    public RuleBasedScanner getJavaCodeScanner() {
        if (fCodeScanner == null) {
            fCodeScanner= new JavaCodeScanner(getJavaColorProvider());
        }
        return fCodeScanner;
    }

    /**
     * Returns the singleton Java color provider.
     *
     * @return the singleton Java color provider
     */
    public JavaColorProvider getJavaColorProvider() {
        if (fColorProvider == null) {
            fColorProvider= new JavaColorProvider();
        }
        return fColorProvider;
    }

    /**
     * Returns the singleton Javadoc scanner.
     *
     * @return the singleton Javadoc scanner
     */
    public RuleBasedScanner getJavaDocScanner() {
        if (fDocScanner == null) {
            fDocScanner= new JavaDocScanner(fColorProvider);
        }
        return fDocScanner;
    }
}
