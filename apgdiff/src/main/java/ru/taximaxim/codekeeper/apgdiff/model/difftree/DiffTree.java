package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;

public final class DiffTree {

    public static TreeElement create(PgDatabase left, PgDatabase right, SubMonitor sMonitor) throws InterruptedException {
        return new DiffTree(sMonitor).createTree(left, right);
    }

    @Deprecated
    public static void addColumns(List<PgColumn> left, List<PgColumn> right,
            TreeElement parent, List<TreeElement> list) {
        for (PgColumn sLeft : left) {
            PgColumn foundRight = right.stream().filter(
                    sRight -> sLeft.getName().equals(sRight.getName()))
                    .findAny().orElse(null);

            if (!sLeft.equals(foundRight)) {
                TreeElement col = new TreeElement(sLeft, foundRight != null ? DiffSide.BOTH : DiffSide.LEFT);
                col.setParent(parent);
                list.add(col);
            }
        }

        for (PgColumn sRight : right) {
            if (!left.stream().anyMatch(sLeft -> sRight.getName().equals(sLeft.getName()))) {
                TreeElement col = new TreeElement(sRight, DiffSide.RIGHT);
                col.setParent(parent);
                list.add(col);
            }
        }
    }

    private final List<PgStatement> equalsStatements = new ArrayList<>();
    private final IProgressMonitor monitor;

    public DiffTree(IProgressMonitor monitor) {
        this.monitor = monitor;
    }

    public TreeElement createTree(PgDatabase left, PgDatabase right) throws InterruptedException {
        PgDiffUtils.checkCancelled(monitor);
        TreeElement db = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);
        addChildren(left, right, db);

        return db;
    }

    private void addChildren(PgStatement left, PgStatement right, TreeElement parent) throws InterruptedException {
        for (CompareResult res : compareStatements(left, right)) {
            PgDiffUtils.checkCancelled(monitor);
            TreeElement child = new TreeElement(res.getStatement(), res.getSide());
            parent.addChild(child);

            if (res.hasChildren()) {
                addChildren(res.getLeft(), res.getRight(), child);
            }
        }
    }

    /**
     * Compare lists and put elements onto appropriate sides.
     */
    private List<CompareResult> compareStatements(PgStatement left, PgStatement right) {
        List<CompareResult> rv = new ArrayList<>();

        // add LEFT and BOTH here
        // and RIGHT in a separate pass
        if (left != null) {
            left.getChildren().forEach(sLeft -> {
                PgStatement foundRight = null;
                if (right != null) {
                    foundRight = right.getChildren().filter(
                            sRight -> sLeft.getName().equals(sRight.getName())
                            && sLeft.getStatementType() == sRight.getStatementType())
                            .findAny().orElse(null);
                }

                if (foundRight == null) {
                    rv.add(new CompareResult(sLeft, null));
                } else if(!sLeft.equals(foundRight)) {
                    rv.add(new CompareResult(sLeft, foundRight));

                    if (sLeft.compare(foundRight)) {
                        equalsStatements.add(sLeft);
                    }
                } else {
                    equalsStatements.add(sLeft);
                    // equals includes all descendants so they are equal too
                    sLeft.getDescendants().forEach(equalsStatements::add);
                }
            });
        }

        if (right != null) {
            right.getChildren().forEach(sRight -> {
                if (left == null || !left.getChildren().anyMatch(
                        sLeft -> sRight.getName().equals(sLeft.getName())
                        && sLeft.getStatementType() == sRight.getStatementType())) {
                    rv.add(new CompareResult(null, sRight));
                }
            });
        }

        return rv;
    }

    public List<PgStatement> getEqualsObjects() {
        return equalsStatements;
    }
}

class CompareResult {

    private final PgStatement left;
    private final PgStatement right;

    public PgStatement getLeft() {
        return left;
    }

    public PgStatement getRight() {
        return right;
    }

    public CompareResult(PgStatement left, PgStatement right) {
        this.left = left;
        this.right = right;
    }

    public DiffSide getSide() {
        if (left != null && right != null) {
            return DiffSide.BOTH;
        }
        if (left != null) {
            return DiffSide.LEFT;
        }
        if (right != null) {
            return DiffSide.RIGHT;
        }
        throw new IllegalStateException("Both diff sides are null!");
    }

    public PgStatement getStatement() {
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        throw new IllegalStateException("Both diff sides are null!");
    }

    public boolean hasChildren() {
        if (left != null && left.hasChildren()) {
            return true;
        }

        return right != null && right.hasChildren();
    }
}
