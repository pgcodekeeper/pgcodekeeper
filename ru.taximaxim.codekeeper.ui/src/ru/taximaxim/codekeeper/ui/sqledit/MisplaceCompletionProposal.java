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

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.AbstractModelExporter;
import ru.taximaxim.codekeeper.ui.UIConsts.MARKER;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.refactoring.PgRefactory;

public class MisplaceCompletionProposal implements ICompletionProposal{

    private final PgObjLocation pgObjLocation;

    public static boolean isMisplaceError(Annotation annotation) {
        if (annotation instanceof MarkerAnnotation) {
            MarkerAnnotation markerAnnotation = (MarkerAnnotation) annotation;
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
        return Messages.MisplaceCompletionProposal_rename_file_to + AbstractModelExporter.getExportedFilenameSql(pgObjLocation.getBareName());
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
