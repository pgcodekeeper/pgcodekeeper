package ru.taximaxim.codekeeper.ui.comparetools;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.structuremergeviewer.DiffNode;
import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.schema.PgOverride;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class CompareInput extends CompareEditorInput {

    private static final String TITLE = "Compare (''{0}'' - ''{1}'')"; //$NON-NLS-1$

    private final CompareItem left;
    private final CompareItem right;

    public CompareInput(PgOverride override) {
        super(new CompareConfiguration());

        String oldPath = override.getOldLocation();
        String newPath = override.getNewLocation();

        left = getContent(oldPath);
        right = getContent(newPath);

        getCompareConfiguration().setLeftLabel(oldPath);
        getCompareConfiguration().setRightLabel(newPath);

        setTitle(MessageFormat.format(TITLE, oldPath, newPath));
    }

    public CompareInput(String name, DbObjType type, PgStatement project, PgStatement remote) {
        super(new CompareConfiguration());

        getCompareConfiguration().setLeftLabel(Messages.database);
        getCompareConfiguration().setRightLabel(Messages.DiffPaneViewer_project);

        left = new CompareItem(name, project == null ? "" : project.getCreationSQL());
        right =  new CompareItem(name, remote == null ? "" : remote.getCreationSQL());

        setTitle("Compare " + type + ' ' + name); //$NON-NLS-1$
    }

    private CompareItem getContent(String path) {
        if (path.startsWith("jdbc:")) { //$NON-NLS-1$
            return new CompareItem(path, "JDBC content is not available"); //$NON-NLS-1$
        }

        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            content = "File not found"; //$NON-NLS-1$
        }
        return new CompareItem(path, content);
    }

    @Override
    protected Object prepareInput(IProgressMonitor monitor)
            throws InvocationTargetException, InterruptedException {
        return new DiffNode(left, right);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((left == null) ? 0 : left.hashCode());
        result = prime * result + ((right == null) ? 0 : right.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;

        if (this == obj) {
            eq = true;
        } else if (obj instanceof CompareInput) {
            CompareInput val = (CompareInput) obj;
            eq = left.equals(val.left) && right.equals(val.right);
        }

        return eq;
    }
}
