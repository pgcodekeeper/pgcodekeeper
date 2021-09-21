package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.ui.texteditor.MarkerAnnotation;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.MARKER;

public class MisplaceProposal {

    public static boolean isMisplaceError(Annotation annotation) {
        if (annotation instanceof MarkerAnnotation) {
            MarkerAnnotation markerAnnotation = (MarkerAnnotation) annotation;
            IMarker marker = markerAnnotation.getMarker();
            try {
                return (marker.getType().equals(MARKER.ERROR) &&
                        MARKER.MISPLACE_ERROR.equals(marker.getAttribute(MARKER.ERROR_TYPE)));
            } catch (CoreException e) {
                Log.log(Log.LOG_ERROR, e.getLocalizedMessage(), e);
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
}
