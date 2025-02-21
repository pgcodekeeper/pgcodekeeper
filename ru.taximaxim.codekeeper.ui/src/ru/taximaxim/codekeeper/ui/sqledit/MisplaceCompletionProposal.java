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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.texteditor.MarkerAnnotation;

import ru.taximaxim.codekeeper.core.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.UIConsts.MARKER;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.refactoring.PgRefactory;

public class MisplaceCompletionProposal implements ICompletionProposal{

    private final PgObjLocation pgObjLocation;

    public static boolean isMisplaceError(Annotation annotation) {
        if (annotation instanceof MarkerAnnotation markerAnnotation) {
            IMarker marker = markerAnnotation.getMarker();
            try {
                return (marker.getType().equals(MARKER.ERROR) &&
                        MARKER.MISPLACE_ERROR.equals(marker.getAttribute(MARKER.ERROR_TYPE)));
            } catch (CoreException e) {
                ExceptionNotifier.notifyCoreException(e);
            }
        }
        return false;
    }

    public static MisplaceCompletionProposal[] getMisplaceProposals(Annotation annotation, PgObjLocation pgObjLocation) {
        if (isMisplaceError(annotation)) {
            return new MisplaceCompletionProposal[] { new MisplaceCompletionProposal(pgObjLocation)};
        }
        return null;
    }

    public MisplaceCompletionProposal(PgObjLocation pgObjLocation) {
        this.pgObjLocation = pgObjLocation;
    }

    @Override
    public void apply(IDocument document) {
        try {
            PgRefactory.getInstance().fixFileName(pgObjLocation);
        } catch (CoreException e) {
            ExceptionNotifier.notifyCoreException(e);
        }
    }

    @Override
    public Point getSelection(IDocument document) {
        return null;
    }

    @Override
    public String getAdditionalProposalInfo() {
        return null;
    }

    @Override
    public String getDisplayString() {
        return Messages.MisplaceCompletionProposal_rename_file_to + ModelExporter.getExportedFilenameSql(pgObjLocation.getBareName());
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public IContextInformation getContextInformation() {
        return null;
    }
}
