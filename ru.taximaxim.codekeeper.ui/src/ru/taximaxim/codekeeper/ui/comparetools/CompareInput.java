package ru.taximaxim.codekeeper.ui.comparetools;

import java.lang.reflect.InvocationTargetException;
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

    private CompareItem left;
    private CompareItem right;
    private final DiffNode diffNode ;
    public CompareInput(PgOverride override) {
        super(new CompareConfiguration());

        PgStatement oldStatement = override.getOldStatement();
        PgStatement newStatement = override.getNewStatement();

        String oldPath = oldStatement.getLocation().getFilePath();
        String newPath = newStatement.getLocation().getFilePath();

        diffNode = getFormattedContents(oldPath, newPath, oldStatement, newStatement);

        getCompareConfiguration().setLeftLabel(oldPath);
        getCompareConfiguration().setRightLabel(newPath);

        setTitle(MessageFormat.format(TITLE, oldPath, newPath));
    }

    public CompareInput(String name, DbObjType type, PgStatement project, PgStatement remote) {
        super(new CompareConfiguration());

        getCompareConfiguration().setLeftLabel(Messages.database);
        getCompareConfiguration().setRightLabel(Messages.DiffPaneViewer_project);

        diffNode = getFormattedContents(name, name, project, remote);

        setTitle("Compare " + type + ' ' + name); //$NON-NLS-1$
    }

    private DiffNode getFormattedContents(String oldPath, String newPath, PgStatement project, PgStatement remote) {
        String contentsLeft = project == null ? "" : project.getFormattedCreationSQL(); //$NON-NLS-1$
        String contentsRight = remote == null ? "" : remote.getFormattedCreationSQL(); //$NON-NLS-1$

        if (contentsLeft.equals(contentsRight)) {
            left = new CompareItem(oldPath, project == null ? "" : project.getFullSQL()); //$NON-NLS-1$
            right =  new CompareItem(newPath, remote == null ? "" : remote.getFullSQL()); //$NON-NLS-1$
        } else {
            left = new CompareItem(oldPath, contentsLeft);
            right =  new CompareItem(newPath, contentsRight);
        }

        return new DiffNode(left, right);
    }

    @Override
    protected Object prepareInput(IProgressMonitor monitor)
            throws InvocationTargetException, InterruptedException {
        return diffNode;
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
