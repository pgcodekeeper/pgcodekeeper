package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.IStatement;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;

public final class DiffTree {

    public static TreeElement create(PgDatabase left, PgDatabase right, SubMonitor sMonitor) throws InterruptedException {
        PgDiffUtils.checkCancelled(sMonitor);

        TreeElement db = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);

        for (CompareResult res : compareLists(left.getExtensions(), right.getExtensions())) {
            db.addChild(new TreeElement(res.getStatement(), res.getSide()));
        }

        for(CompareResult resSchema : compareLists(left.getSchemas(), right.getSchemas())) {
            PgDiffUtils.checkCancelled(sMonitor);

            TreeElement elSchema = new TreeElement(resSchema.getStatement(), resSchema.getSide());
            db.addChild(elSchema);

            List<? extends IStatement> leftSub = Collections.emptyList();
            List<? extends IStatement> rightSub = Collections.emptyList();

            PgSchema schemaLeft = (PgSchema) resSchema.getLeft();
            PgSchema schemaRight = (PgSchema) resSchema.getRight();
            // functions
            if(schemaLeft != null) {
                leftSub = schemaLeft.getFunctions();
            }
            if(schemaRight != null) {
                rightSub =schemaRight.getFunctions();
            }

            for (CompareResult func : compareLists(leftSub, rightSub)) {
                elSchema.addChild(new TreeElement(func.getStatement(), func.getSide()));
            }

            // sequences
            if(schemaLeft != null) {
                leftSub = schemaLeft.getSequences();
            }
            if(schemaRight != null) {
                rightSub = schemaRight.getSequences();
            }

            for (CompareResult seq : compareLists(leftSub, rightSub)) {
                elSchema.addChild(new TreeElement(seq.getStatement(), seq.getSide()));
            }

            // types
            if(schemaLeft != null) {
                leftSub = schemaLeft.getTypes();
            }
            if(schemaRight != null) {
                rightSub = schemaRight.getTypes();
            }

            for (CompareResult type : compareLists(leftSub, rightSub)) {
                elSchema.addChild(new TreeElement(type.getStatement(), type.getSide()));
            }

            // domains
            if(schemaLeft != null) {
                leftSub = schemaLeft.getDomains();
            }
            if(schemaRight != null) {
                rightSub = schemaRight.getDomains();
            }

            for (CompareResult dom : compareLists(leftSub, rightSub)) {
                elSchema.addChild(new TreeElement(dom.getStatement(), dom.getSide()));
            }

            // view
            if(schemaLeft != null) {
                leftSub = schemaLeft.getViews();
            }
            if(schemaRight != null) {
                rightSub = schemaRight.getViews();
            }

            for (CompareResult view : compareLists(leftSub, rightSub)) {
                TreeElement vw = new TreeElement(view.getStatement(), view.getSide());
                elSchema.addChild(vw);

                List<? extends PgStatement> leftViewSub = Collections.emptyList();
                List<? extends PgStatement> rightViewSub = Collections.emptyList();

                PgView viewLeft = (PgView) view.getLeft();
                PgView viewRight = (PgView) view.getRight();

                // rules
                if(viewLeft != null) {
                    leftViewSub = viewLeft.getRules();
                }
                if(viewRight != null) {
                    rightViewSub = viewRight.getRules();
                }

                for (CompareResult rule : compareLists(leftViewSub, rightViewSub)) {
                    vw.addChild(new TreeElement(rule.getStatement(), rule.getSide()));
                }

                // triggers
                if(viewLeft != null) {
                    leftViewSub = viewLeft.getTriggers();
                }
                if(viewRight != null) {
                    rightViewSub = viewRight.getTriggers();
                }

                for (CompareResult trg : compareLists(leftViewSub, rightViewSub)) {
                    vw.addChild(new TreeElement(trg.getStatement(), trg.getSide()));
                }
            }

            // tables
            if(schemaLeft != null) {
                leftSub = schemaLeft.getTables();
            }
            if(schemaRight != null) {
                rightSub = schemaRight.getTables();
            }

            for(CompareResult resSub : compareLists(leftSub, rightSub)) {
                PgDiffUtils.checkCancelled(sMonitor);

                TreeElement tbl = new TreeElement(resSub.getStatement(), resSub.getSide());
                elSchema.addChild(tbl);

                List<? extends PgStatement> leftTableSub = Collections.emptyList();
                List<? extends PgStatement> rightTableSub = Collections.emptyList();

                PgTable tableLeft = (PgTable) resSub.getLeft();
                PgTable tableRight = (PgTable) resSub.getRight();

                // indexes
                if(tableLeft != null) {
                    leftTableSub = tableLeft.getIndexes();
                }
                if(tableRight != null) {
                    rightTableSub = tableRight.getIndexes();
                }

                for (CompareResult ind : compareLists(leftTableSub, rightTableSub)) {
                    tbl.addChild(new TreeElement(ind.getStatement(), ind.getSide()));
                }

                // triggers
                if(tableLeft != null) {
                    leftTableSub = tableLeft.getTriggers();
                }
                if(tableRight != null) {
                    rightTableSub = tableRight.getTriggers();
                }

                for (CompareResult trg : compareLists(leftTableSub, rightTableSub)) {
                    tbl.addChild(new TreeElement(trg.getStatement(), trg.getSide()));
                }

                // rules
                if(tableLeft != null) {
                    leftTableSub = tableLeft.getRules();
                }
                if(tableRight != null) {
                    rightTableSub = tableRight.getRules();
                }

                for (CompareResult rule : compareLists(leftTableSub, rightTableSub)) {
                    tbl.addChild(new TreeElement(rule.getStatement(), rule.getSide()));
                }

                // constraints
                if(tableLeft != null) {
                    leftTableSub = tableLeft.getConstraints();
                }
                if(tableRight != null) {
                    rightTableSub = tableRight.getConstraints();
                }

                for (CompareResult constr : compareLists(leftTableSub, rightTableSub)) {
                    tbl.addChild(new TreeElement(constr.getStatement(), constr.getSide()));
                }
            }
        }

        return db;
    }

    /**
     * Compare lists and put elements onto appropriate sides.
     */
    private static List<CompareResult> compareLists(List<? extends IStatement> left,
            List<? extends IStatement> right) {
        List<CompareResult> rv = new ArrayList<>();

        // add LEFT and BOTH here
        // and RIGHT in a separate pass
        for(IStatement sLeft : left) {
            IStatement foundRight = null;
            for(IStatement sRight : right) {
                if(sLeft.getName().equals(sRight.getName())) {
                    foundRight = sRight;
                    break;
                }
            }

            if(foundRight == null) {
                rv.add(new CompareResult(sLeft, null));
            } else if(!sLeft.equals(foundRight)) {
                rv.add(new CompareResult(sLeft, foundRight));
            } else {
                // do nothing if both statements exist and are equal
            }
        }

        for(IStatement sRight : right) {
            boolean foundLeft = false;
            for(IStatement sLeft : left) {
                if(sRight.getName().equals(sLeft.getName())) {
                    foundLeft = true;
                    break;
                }
            }
            if(!foundLeft) {
                rv.add(new CompareResult(null, sRight));
            }
        }
        return rv;
    }

    @Deprecated
    public static void addColumns(List<? extends PgStatement> left,
            List<? extends PgStatement> right, TreeElement parent,
            List<TreeElement> list) {
        for (CompareResult col : compareLists(left, right)) {
            TreeElement colEl = new TreeElement(col.getStatement(), col.getSide());
            colEl.setParent(parent);
            list.add(colEl);
        }
    }

    private DiffTree() {
    }
}

class CompareResult {

    private final IStatement left, right;

    public IStatement getLeft() {
        return left;
    }

    public IStatement getRight() {
        return right;
    }

    public CompareResult(IStatement left, IStatement right) {
        this.left = left;
        this.right = right;
    }

    public DiffSide getSide() {
        if(left != null && right != null) {
            return DiffSide.BOTH;
        }
        if(left != null && right == null) {
            return DiffSide.LEFT;
        }
        if(left == null && right != null) {
            return DiffSide.RIGHT;
        }
        throw new IllegalStateException("Both diff sides are null!");
    }

    public IStatement getStatement() {
        if(left != null) {
            return left;
        }
        if(right != null) {
            return right;
        }
        throw new IllegalStateException("Both diff sides are null!");
    }
}