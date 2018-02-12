package ru.taximaxim.codekeeper.ui.propertytests;

import java.io.IOException;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.pgdbproject.parser.PgUIDumpLoader;

public class MockDataPropertyTester extends PropertyTester {

    @Override
    public boolean test(Object receiver, String property, Object[] args,
            Object expectedValue) {
        IFile file = (IFile) receiver;
        if (PgUIDumpLoader.isInProject(file)) {
            try {
                return PgUIDumpLoader.parseStatement(file, DbObjType.TABLE) != null;
            } catch (InterruptedException | IOException | CoreException e) {
                Log.log(Log.LOG_ERROR, "Error parsing file: " + file.getName(), e); //$NON-NLS-1$
            }
        }

        return false;
    }
}