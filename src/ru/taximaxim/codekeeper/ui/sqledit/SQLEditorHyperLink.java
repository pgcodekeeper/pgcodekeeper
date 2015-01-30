package ru.taximaxim.codekeeper.ui.sqledit;

import java.nio.file.Path;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.ITextEditor;

import ru.taximaxim.codekeeper.ui.Log;

public class SQLEditorHyperLink implements IHyperlink {

    private Path location;
    private IRegion region;
    private String label;
    private IRegion regionHightLight;
    private IEditorInput input;
    private int lineNumber;

    public SQLEditorHyperLink(IRegion region, IRegion regionHightLight,
            String label, Path path, IEditorInput input, int lineNumber) {

        this.region= region;
        this.regionHightLight = regionHightLight;
        this.location = path;
        this.label = label;
        this.input = input;
        this.lineNumber = lineNumber;
    }
    
    @Override
    public IRegion getHyperlinkRegion() {
        return regionHightLight;
    }

    @Override
    public String getTypeLabel() {
        return label;
    }

    @Override
    public String getHyperlinkText() {
        return label + " - " + location.toString() + " (" + lineNumber + ")";
    }

    @Override
    public void open() {
        IWorkbenchPage page = PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getActivePage();
        
        if (!location.startsWith("")) {
            try {
                ITextEditor editor = (ITextEditor) IDE.openEditor(page,
                        location.toUri(), SQLEditor.ID, true);
                editor.selectAndReveal(region.getOffset(), region.getLength());
            } catch (PartInitException e) {
                Log.log(Log.LOG_ERROR, "Cannot find editor part", e);
            }
        } else {
            ITextEditor editor;
            try {
                editor = (ITextEditor) IDE.openEditor(page,
                        input, RollOnEditor.ID, true);
                editor.selectAndReveal(region.getOffset(), region.getLength());
            } catch (PartInitException e) {
                Log.log(Log.LOG_ERROR, "Cannot find editor part", e);
            }
        }
    }

}
