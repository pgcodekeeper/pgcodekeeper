package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.timestamps.DBTimestampPair;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;

public final class DiffTree {

    public static TreeElement create(PgDatabase dbSrc, PgDatabase dbTgt,
            SubMonitor pm) throws InterruptedException {
        return create(dbSrc,dbTgt,pm, null);
    }

    public static TreeElement create(PgDatabase left, PgDatabase right, SubMonitor sMonitor, DBTimestampPair dbTime) throws InterruptedException {
        PgDiffUtils.checkCancelled(sMonitor);

        TreeElement db = new TreeElement("Database", DbObjType.DATABASE, DiffSide.BOTH);

        for (CompareResult res : compareLists(left.getExtensions(), right.getExtensions(), dbTime)) {
            db.addChild(new TreeElement(res.getStatement(), res.getSide()));
        }

        for(CompareResult resSchema : compareLists(left.getSchemas(), right.getSchemas(), dbTime)) {
            PgDiffUtils.checkCancelled(sMonitor);

            TreeElement elSchema = new TreeElement(resSchema.getStatement(), resSchema.getSide());
            db.addChild(elSchema);

            List<? extends PgStatement> leftSub = Collections.emptyList();
            List<? extends PgStatement> rightSub = Collections.emptyList();

            PgSchema schemaLeft = (PgSchema) resSchema.getLeft();
            PgSchema schemaRight = (PgSchema) resSchema.getRight();
            // functions
            if (schemaLeft != null) {
                leftSub = schemaLeft.getFunctions();
            }
            if (schemaRight != null) {
                rightSub = schemaRight.getFunctions();
            }

            for (CompareResult func : compareLists(leftSub, rightSub, dbTime)) {
                elSchema.addChild(new TreeElement(func.getStatement(), func.getSide()));
            }

            // sequences
            if (schemaLeft != null) {
                leftSub = schemaLeft.getSequences();
            }
            if (schemaRight != null) {
                rightSub = schemaRight.getSequences();
            }

            for (CompareResult seq : compareLists(leftSub, rightSub, dbTime)) {
                elSchema.addChild(new TreeElement(seq.getStatement(), seq.getSide()));
            }

            // types
            if (schemaLeft != null) {
                leftSub = schemaLeft.getTypes();
            }
            if (schemaRight != null) {
                rightSub = schemaRight.getTypes();
            }

            for (CompareResult type : compareLists(leftSub, rightSub, dbTime)) {
                elSchema.addChild(new TreeElement(type.getStatement(), type.getSide()));
            }

            // domains
            if (schemaLeft != null) {
                leftSub = schemaLeft.getDomains();
            }
            if (schemaRight != null) {
                rightSub = schemaRight.getDomains();
            }

            for (CompareResult dom : compareLists(leftSub, rightSub, dbTime)) {
                elSchema.addChild(new TreeElement(dom.getStatement(), dom.getSide()));
            }

            // view
            if (schemaLeft != null) {
                leftSub = schemaLeft.getViews();
            }
            if (schemaRight != null) {
                rightSub = schemaRight.getViews();
            }

            for (CompareResult view : compareLists(leftSub, rightSub, dbTime)) {
                TreeElement vw = new TreeElement(view.getStatement(), view.getSide());
                elSchema.addChild(vw);

                List<? extends PgStatement> leftViewSub = Collections.emptyList();
                List<? extends PgStatement> rightViewSub = Collections.emptyList();

                PgView viewLeft = (PgView) view.getLeft();
                PgView viewRight = (PgView) view.getRight();

                // rules
                if (viewLeft != null) {
                    leftViewSub = viewLeft.getRules();
                }
                if (viewRight != null) {
                    rightViewSub = viewRight.getRules();
                }

                for (CompareResult rule : compareLists(leftViewSub, rightViewSub, dbTime)) {
                    vw.addChild(new TreeElement(rule.getStatement(), rule.getSide()));
                }

                // triggers
                if (viewLeft != null) {
                    leftViewSub = viewLeft.getTriggers();
                }
                if (viewRight != null) {
                    rightViewSub = viewRight.getTriggers();
                }

                for (CompareResult trg : compareLists(leftViewSub, rightViewSub, dbTime)) {
                    vw.addChild(new TreeElement(trg.getStatement(), trg.getSide()));
                }
            }

            // tables
            if (schemaLeft != null) {
                leftSub = schemaLeft.getTables();
            }
            if (schemaRight != null) {
                rightSub = schemaRight.getTables();
            }

            for(CompareResult resSub : compareLists(leftSub, rightSub, dbTime)) {
                PgDiffUtils.checkCancelled(sMonitor);

                TreeElement tbl = new TreeElement(resSub.getStatement(), resSub.getSide());
                elSchema.addChild(tbl);

                List<? extends PgStatement> leftTableSub = Collections.emptyList();
                List<? extends PgStatement> rightTableSub = Collections.emptyList();

                PgTable tableLeft = (PgTable) resSub.getLeft();
                PgTable tableRight = (PgTable) resSub.getRight();

                // indexes
                if (tableLeft != null) {
                    leftTableSub = tableLeft.getIndexes();
                }
                if (tableRight != null) {
                    rightTableSub = tableRight.getIndexes();
                }

                for (CompareResult ind : compareLists(leftTableSub, rightTableSub, dbTime)) {
                    tbl.addChild(new TreeElement(ind.getStatement(), ind.getSide()));
                }

                // triggers
                if (tableLeft != null) {
                    leftTableSub = tableLeft.getTriggers();
                }
                if (tableRight != null) {
                    rightTableSub = tableRight.getTriggers();
                }

                for (CompareResult trg : compareLists(leftTableSub, rightTableSub, dbTime)) {
                    tbl.addChild(new TreeElement(trg.getStatement(), trg.getSide()));
                }

                // rules
                if (tableLeft != null) {
                    leftTableSub = tableLeft.getRules();
                }
                if (tableRight != null) {
                    rightTableSub = tableRight.getRules();
                }

                for (CompareResult rule : compareLists(leftTableSub, rightTableSub, dbTime)) {
                    tbl.addChild(new TreeElement(rule.getStatement(), rule.getSide()));
                }

                // constraints
                if (tableLeft != null) {
                    leftTableSub = tableLeft.getConstraints();
                }
                if (tableRight != null) {
                    rightTableSub = tableRight.getConstraints();
                }

                for (CompareResult constr : compareLists(leftTableSub, rightTableSub, dbTime)) {
                    tbl.addChild(new TreeElement(constr.getStatement(), constr.getSide()));
                }
            }
        }

        return db;
    }

    /**
     * Compare lists and put elements onto appropriate sides.
     */
    private static List<CompareResult> compareLists(List<? extends PgStatement> left,
            List<? extends PgStatement> right, DBTimestampPair pair) {
        List<CompareResult> rv = new ArrayList<>();

        // add LEFT and BOTH here
        // and RIGHT in a separate pass
        for (PgStatement sLeft : left) {
            PgStatement foundRight = null;
            for (PgStatement sRight : right) {
                if (sLeft.getName().equals(sRight.getName())) {
                    foundRight = sRight;
                    break;
                }
            }

            if(foundRight == null) {
                rv.add(new CompareResult(sLeft, null));
            } else if(!sLeft.equals(foundRight)) {
                rv.add(new CompareResult(sLeft, foundRight));
            } else if (pair != null) {
                pair.addObject(sLeft);
            } else {
                // do nothing if both statements exist and are equal and extension not used
            }
        }

        for (PgStatement sRight : right) {
            boolean foundLeft = false;
            for (PgStatement sLeft : left) {
                if (sRight.getName().equals(sLeft.getName())) {
                    foundLeft = true;
                    break;
                }
            }
            if (!foundLeft) {
                rv.add(new CompareResult(null, sRight));
            }
        }
        return rv;
    }

    private DiffTree() {
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
}