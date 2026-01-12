/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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

import java.util.LinkedList;
import java.util.Map;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.TypedPosition;
import org.eclipse.jface.text.formatter.ContextBasedFormattingStrategy;
import org.eclipse.jface.text.formatter.FormattingContextProperties;
import org.eclipse.jface.text.formatter.IFormattingContext;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.formatter.Formatter;

public class SQLFormattingStrategy extends ContextBasedFormattingStrategy {

    /** Documents to be formatted by this strategy */
    private final LinkedList<IDocument> fDocuments = new LinkedList<>();
    /** Partitions to be formatted by this strategy */
    private final LinkedList<TypedPosition> fPartitions = new LinkedList<>();

    private final SQLEditor editor;

    public SQLFormattingStrategy(SQLEditor editor) {
        this.editor = editor;
    }

    @Override
    public void format() {
        super.format();

        final IDocument document = fDocuments.removeFirst();
        final TypedPosition partition = fPartitions.removeFirst();

        if (document != null && partition != null) {
            Map<String, IDocumentPartitioner> partitioners = null;
            int offset = partition.getOffset();
            int length = partition.getLength();

            try {
                TextEdit edit = Formatter.formatDoc(offset, length, document.get(), editor.getDbType());

                if (edit != null) {
                    if (edit.getChildrenSize() > 20) {
                        partitioners = TextUtilities
                                .removeDocumentPartitioners(document);
                    }

                    edit.apply(document);
                }
            } catch (MalformedTreeException | BadLocationException e) {
                Log.log(e);
            } finally {
                if (partitioners != null) {
                    TextUtilities.addDocumentPartitioners(document,
                            partitioners);
                }
            }
        }
    }

    @Override
    public void formatterStarts(final IFormattingContext context) {
        super.formatterStarts(context);

        fPartitions.addLast((TypedPosition) context
                .getProperty(FormattingContextProperties.CONTEXT_PARTITION));
        fDocuments.addLast((IDocument) context
                .getProperty(FormattingContextProperties.CONTEXT_MEDIUM));
    }

    @Override
    public void formatterStops() {
        super.formatterStops();

        fPartitions.clear();
        fDocuments.clear();
    }
}
