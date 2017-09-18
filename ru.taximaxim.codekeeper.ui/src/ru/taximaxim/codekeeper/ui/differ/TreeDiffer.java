package ru.taximaxim.codekeeper.ui.differ;

import org.eclipse.jface.operation.IRunnableWithProgress;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * строит дерево сравнения из двух баз
 */
public abstract class TreeDiffer implements IRunnableWithProgress {

    protected static final int JOB_CHECK_MS = 20;

    protected final DbSource dbSource;
    protected final DbSource dbTarget;
    protected final boolean needTwoWay;

    protected TreeElement diffTree;
    protected TreeElement diffTreeRevert;

    public DbSource getDbSource() {
        return dbSource;
    }

    public DbSource getDbTarget() {
        return dbTarget;
    }

    public TreeElement getDiffTree() {
        if (diffTree == null) {
            throw new IllegalStateException(Messages.runnable_has_not_finished);
        }
        return diffTree;
    }

    public TreeElement getDiffTreeRevert() {
        if (diffTreeRevert == null) {
            throw new IllegalStateException(Messages.runnable_has_not_finished);
        }
        return diffTreeRevert;
    }

    public TreeDiffer(DbSource dbSource, DbSource dbTarget, boolean needTwoWay) {
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
        this.needTwoWay = needTwoWay;
    }
}
