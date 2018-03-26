package ru.taximaxim.codekeeper.ui.sqledit;

import java.nio.file.Paths;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.ITextEditor;

import ru.taximaxim.codekeeper.ui.UIConsts.EDITOR;
import ru.taximaxim.codekeeper.ui.dialogs.ExceptionNotifier;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class SQLEditorHyperLink implements IHyperlink {

    private final String location;
    private final IRegion region;
    private final String label;
    private final IRegion regionHightLight;
    private final int lineNumber;
    private final String relativePath;

    public SQLEditorHyperLink(IRegion region, IRegion regionHightLight, String label,
            String location, int lineNumber) {

        this.region = region;
        this.regionHightLight = regionHightLight;
        this.location = location;
        this.label = label;
        this.lineNumber = lineNumber;
        IFile file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(location));
        relativePath = file == null ? location : file.getProjectRelativePath().toString();
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
        return label + " - " + relativePath + ':' + lineNumber; //$NON-NLS-1$
    }

    @Override
    public void open() {
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage();

        try {
            ITextEditor editor = (ITextEditor) IDE.openEditor(
                    page, Paths.get(location).toUri(), EDITOR.SQL, true);
            editor.selectAndReveal(region.getOffset(), region.getLength());
        } catch (PartInitException ex) {
            ExceptionNotifier.notifyDefault(
                    Messages.ProjectEditorDiffer_error_opening_script_editor, ex);
        }
    }
}