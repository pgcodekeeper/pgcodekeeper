/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;

public class SQLEditorCommonDocumentProvider extends TextFileDocumentProvider {

    /**
     * The recipe partitioning. It contains two partition types: {@link #SQL_CODE} and
     * {@link #SQL_SINGLE_COMMENT}.
     */
    public static final String SQL_PARTITIONING = "ru.taximaxim.codekeeper.ui.sqleditor.partitioning"; //$NON-NLS-1$

    /**
     * The identifier of the comment body type.
     */
    public static final String SQL_CODE = IDocument.DEFAULT_CONTENT_TYPE;
    /**
     * The identifier of the comment partition type.
     */
    public static final String SQL_SINGLE_COMMENT = "SQL_SINGLE_COMMENT"; //$NON-NLS-1$
    public static final String SQL_MULTI_COMMENT = "SQL_MULTI_COMMENT"; //$NON-NLS-1$
    public static final String SQL_CHARACTER_STRING_LITERAL = "SQL_CHARACTER_STRING_LITERAL"; //$NON-NLS-1$
    public static final String SQL_QUOTED_IDENTIFIER = "SQL_QUOTED_IDENTIFIER"; //$NON-NLS-1$

    private static final String[] CONTENT_TYPES = {
            SQL_CODE,
            SQL_SINGLE_COMMENT,
            SQL_MULTI_COMMENT,
            SQL_CHARACTER_STRING_LITERAL,
            SQL_QUOTED_IDENTIFIER
    };

    @Override
    protected FileInfo createFileInfo(Object element) throws CoreException{
        FileInfo info = super.createFileInfo(element);
        if (info == null) {
            return null;
        }

        if (element instanceof SQLEditorInput sqlEditorInput && sqlEditorInput.isTemp()) {
            info.fTextFileBuffer.setDirty(true);
        }

        IDocument document = info.fTextFileBuffer.getDocument();
        if (document != null) {
            setupDocument(document);
        }

        return info;
    }

    private void setupDocument(IDocument document) {
        if (document instanceof IDocumentExtension3 ext) {
            IDocumentPartitioner partitioner= createRecipePartitioner();
            partitioner.connect(document);
            ext.setDocumentPartitioner(SQL_PARTITIONING, partitioner);
        }
    }

    @Override
    public boolean isReadOnly(Object element) {
        if (element instanceof SQLEditorInput sqlEditorInput) {
            return sqlEditorInput.isReadOnly();
        }

        return super.isReadOnly(element);
    }

    IDocumentPartitioner createRecipePartitioner() {
        IPredicateRule[] rules = {
                new SingleLineRule("--", null, new Token(SQL_SINGLE_COMMENT), (char) 0, true, false), //$NON-NLS-1$
                new MultiLineRule("/*", "*/", new Token(SQL_MULTI_COMMENT), (char) 0, true),  //$NON-NLS-1$ //$NON-NLS-2$
                new MultiLineRule( "'", "'", new Token(SQL_CHARACTER_STRING_LITERAL), (char) 0 , true), //$NON-NLS-1$ //$NON-NLS-2$
                new MultiLineRule( "\"", "\"", new Token(SQL_QUOTED_IDENTIFIER), (char) 0 , true), //$NON-NLS-1$ //$NON-NLS-2$
        };

        RuleBasedPartitionScanner scanner = new RuleBasedPartitionScanner();
        scanner.setPredicateRules(rules);

        return new FastPartitioner(scanner, CONTENT_TYPES);
    }
}
