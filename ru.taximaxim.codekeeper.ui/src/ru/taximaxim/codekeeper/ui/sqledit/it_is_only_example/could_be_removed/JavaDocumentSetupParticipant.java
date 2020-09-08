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

import org.eclipse.core.filebuffers.IDocumentSetupParticipant;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;

/**
 *
 */
public class JavaDocumentSetupParticipant implements IDocumentSetupParticipant {

    /**
     */
    public JavaDocumentSetupParticipant() {
    }

    /*
     * @see org.eclipse.core.filebuffers.IDocumentSetupParticipant#setup(org.eclipse.jface.text.IDocument)
     */
    @Override
    public void setup(IDocument document) {
        if (document instanceof IDocumentExtension3) {
            IDocumentExtension3 extension3= (IDocumentExtension3) document;
            IDocumentPartitioner partitioner= new FastPartitioner(JavaEditorExamplePlugin.getDefault().getJavaPartitionScanner(), JavaPartitionScanner.JAVA_PARTITION_TYPES);
            extension3.setDocumentPartitioner(JavaEditorExamplePlugin.JAVA_PARTITIONING, partitioner);
            partitioner.connect(document);
        }
    }
}
