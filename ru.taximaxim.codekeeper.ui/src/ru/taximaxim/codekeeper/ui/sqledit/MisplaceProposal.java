package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.ui.texteditor.MarkerAnnotation;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.MARKER;

public class MisplaceProposal {
    private final Annotation annotation;

    public MisplaceProposal(Annotation annotation) {
        this.annotation = annotation;
    }

    public MisplaceCompletionProposal[] getMisplaceProposals() {
        if (annotation instanceof MarkerAnnotation) {
            MarkerAnnotation markerAnnotation = (MarkerAnnotation) annotation;
            IMarker marker = markerAnnotation.getMarker();
            try {
                if (marker.getType().equals(MARKER.ERROR) &&
                        MARKER.MISPLACE_ERROR.equals(marker.getAttribute(MARKER.ERROR_TYPE))) {
                    return new MisplaceCompletionProposal[] { new MisplaceCompletionProposal() };
                }
            } catch (CoreException e) {
                Log.log(Log.LOG_ERROR, e.getLocalizedMessage(), e);
            }
        }
        return null;
    }
}
