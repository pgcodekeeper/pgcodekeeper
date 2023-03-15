/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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

import java.util.Iterator;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.MarkerAnnotation;

import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public class SQLEditorQuickAssistProcessor implements IQuickAssistProcessor {
    private final SQLEditor editor;

    public SQLEditorQuickAssistProcessor(SQLEditor editor) {
        this.editor = editor;
    }

    /*
     * @see IContentAssistProcessor#computeCompletionProposals(ITextViewer, int)
     */
    @Override
    public ICompletionProposal[] computeQuickAssistProposals(
            IQuickAssistInvocationContext quickAssistContext) {

        ISourceViewer viewer = quickAssistContext.getSourceViewer();
        IAnnotationModel model = viewer.getAnnotationModel();

        if (model == null) {
            return null;
        }

        return computeProposals(quickAssistContext.getOffset(), model);
    }

    private MisplaceCompletionProposal[] computeProposals(
            int documentOffset, IAnnotationModel model) {
        Iterator<Annotation> iter = model.getAnnotationIterator();
        while (iter.hasNext()) {
            Annotation annotation = iter.next();
            if (annotation instanceof MarkerAnnotation) {
                Position pos = model.getPosition(annotation);
                if (pos == null) {
                    continue;
                }
                pos = new Position(pos.getOffset(), pos.getLength() + 1);
                if (pos.overlapsWith(documentOffset, 0) && canFix(annotation)) {
                    PgObjLocation obj = editor.getObjectAtOffset(documentOffset, true);
                    if (obj != null) {
                        return getMisplaceProposal(annotation, obj);
                    }
                }
            }
        }
        return null;
    }

    private MisplaceCompletionProposal[] getMisplaceProposal(Annotation annotation, PgObjLocation pgObjLocation) {
        return MisplaceCompletionProposal.getMisplaceProposals(annotation, pgObjLocation);
    }

    @Override
    public String getErrorMessage() {
        return null;
    }

    @Override
    public boolean canFix(Annotation annotation) {
        return MisplaceCompletionProposal.isMisplaceError(annotation);
    }

    @Override
    public boolean canAssist(IQuickAssistInvocationContext invocationContext) {
        return true;
    }
}