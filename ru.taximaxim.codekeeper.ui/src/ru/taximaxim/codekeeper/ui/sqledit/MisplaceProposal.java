package ru.taximaxim.codekeeper.ui.sqledit;

import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.ui.texteditor.MarkerAnnotation;

import ru.taximaxim.codekeeper.ui.UIConsts.MARKER;

public class MisplaceProposal {
    private final Annotation annotation;
    private static final String SQLERROR = "ru.taximaxim.codekeeper.ui.sql.errormarker";

    public MisplaceProposal(Annotation annotation) {
        this.annotation = annotation;
    }

    public MisplaceCompletionProposal[] getMisplaceProposals() {
        if (annotation instanceof MarkerAnnotation) {
            MarkerAnnotation markerAnnotation = (MarkerAnnotation) annotation;
            IMarker marker = markerAnnotation.getMarker();
            try {
                if (marker.getType().equals(SQLERROR)) {
                    if ((boolean) marker.getAttribute(MARKER.MISPLACE_ERROR)) {
                        ArrayList<MisplaceCompletionProposal> proposals = new ArrayList<>();

                        MisplaceCompletionProposal mistPlaceProposal = new MisplaceCompletionProposal();
                        proposals.add(mistPlaceProposal);

                        return proposals.toArray(
                                new MisplaceCompletionProposal[proposals.size()]);
                    }
                }
            } catch (CoreException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
