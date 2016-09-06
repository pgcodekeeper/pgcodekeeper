package ru.taximaxim.codekeeper.ui.sqledit.marker;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.ui.texteditor.IMarkerUpdater;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.MARKER;

public class SQLMarkerUpdate implements IMarkerUpdater {

    @Override
    public String getMarkerType() {
        return MARKER.ERROR;
    }

    @Override
    public String[] getAttribute() {
        return null;
    }

    @Override
    public boolean updateMarker(IMarker marker, IDocument document, Position position) {
        try {
            int start = position.getOffset();
            int end = position.getOffset() + position.getLength();
            marker.setAttribute(IMarker.CHAR_START, start);
            marker.setAttribute(IMarker.CHAR_END, end);
        } catch (CoreException e) {
            Log.log(e);
        }
        return true;
    }
}
