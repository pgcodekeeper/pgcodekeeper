package ru.taximaxim.codekeeper.ui.sqledit;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import ru.taximaxim.codekeeper.apgdiff.model.exporter.AbstractModelExporter;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.refactoring.PgRefactory;

public class MisplaceCompletionProposal implements ICompletionProposal{

    private static final String  MISCOR = "Rename file to ";
    private final PgObjLocation pgObjLocation;

    public MisplaceCompletionProposal(PgObjLocation pgObjLocation) {
        this.pgObjLocation = pgObjLocation;
    }

    @Override
    public void apply(IDocument document) {
        PgRefactory pgRefactory =  new PgRefactory();
        try {
            pgRefactory.fixFileName(pgObjLocation);
        } catch (CoreException e) {
            Log.log(Log.LOG_ERROR, e.getLocalizedMessage());
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
        return MISCOR + AbstractModelExporter.getExportedFilenameSql(pgObjLocation.getObjName());
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
