package ru.taximaxim.codekeeper.ui.propertytests;

import java.io.IOException;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgUIDumpLoader;

public class MockDataPropertyTester extends PropertyTester {

    @Override
    public boolean test(Object receiver, String property, Object[] args,
            Object expectedValue) {
        Object element = null;

        // project explorer
        if (receiver instanceof TreeSelection) {
            element = ((TreeSelection)receiver).getFirstElement();
        }

        // editor
        if (element == null) {
            IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
            element = page.getActiveEditor().getEditorInput();
        }

        IFile file = Platform.getAdapterManager().getAdapter(element, IFile.class);
        PgStatement statement = null;
        if (file != null) {
            try {
                statement = PgUIDumpLoader.parseStatement(file, DbObjType.TABLE);
            } catch (InterruptedException | IOException | CoreException e) {
                Log.log(Log.LOG_ERROR, "Error parsing file: " + file.getName(), e); //$NON-NLS-1$
            }
        }

        return statement != null;
    }
}