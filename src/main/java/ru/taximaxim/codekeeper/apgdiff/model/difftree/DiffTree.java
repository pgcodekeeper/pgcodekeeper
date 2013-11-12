package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;

public class DiffTree {
    
    final private static List<? extends PgStatement> EMPTY_LIST = 
            Collections.unmodifiableList(new ArrayList<PgStatement>());

    public static TreeElement create(PgDatabase left, PgDatabase right) {
        TreeElement root = new TreeElement("", DbObjType.DATABASE, DiffSide.BOTH);
        
        for(CompareResult res
                : compareLists(left.getExtensions(), right.getExtensions())) {
            root.addChild(new TreeElement(res.getStatement(), res.getSide()));
        }
        
        for(CompareResult resSchema
                : compareLists(left.getSchemas(), right.getSchemas())) {
            TreeElement elSchema =
                    new TreeElement(resSchema.getStatement(), resSchema.getSide());
            root.addChild(elSchema);

            List<? extends PgStatement> leftSub = EMPTY_LIST;
            List<? extends PgStatement> rightSub = EMPTY_LIST;
            
            PgSchema schemaLeft = (PgSchema) resSchema.getLeft();
            PgSchema schemaRight = (PgSchema) resSchema.getRight();
            
            // functions
            if(schemaLeft != null) {
                leftSub = schemaLeft.getFunctions();
            }
            if(schemaRight != null) {
                rightSub = schemaRight.getFunctions();
            }
            for(CompareResult resSub : compareLists(leftSub, rightSub)) {
                elSchema.addChild(new TreeElement(resSub.getStatement(), resSub.getSide()));
            }
            
            // sequences
            if(schemaLeft != null) {
                leftSub = schemaLeft.getSequences();
            }
            if(schemaRight != null) {
                rightSub = schemaRight.getSequences();
            }
            for(CompareResult resSub : compareLists(leftSub, rightSub)) {
                elSchema.addChild(new TreeElement(resSub.getStatement(), resSub.getSide()));
            }
            
            // view
            if(schemaLeft != null) {
                leftSub = schemaLeft.getViews();
            }
            if(schemaRight != null) {
                rightSub = schemaRight.getViews();
            }
            for(CompareResult resSub : compareLists(leftSub, rightSub)) {
                elSchema.addChild(new TreeElement(resSub.getStatement(), resSub.getSide()));
            }
            
            // tables
            if(schemaLeft != null) {
                leftSub = schemaLeft.getTables();
            }
            if(schemaRight != null) {
                rightSub = schemaRight.getTables();
            }
            for(CompareResult resSub : compareLists(leftSub, rightSub)) {
                TreeElement elTable =
                        new TreeElement(resSub.getStatement(), resSub.getSide());
                elSchema.addChild(elTable);
                
                List<? extends PgStatement> leftTableSub = EMPTY_LIST;
                List<? extends PgStatement> rightTableSub = EMPTY_LIST;
                
                PgTable tableLeft = (PgTable) resSub.getLeft();
                PgTable tableRight = (PgTable) resSub.getRight();
                
                // indexes
                if(tableLeft != null) {
                    leftTableSub = tableLeft.getIndexes();
                }
                if(tableRight!= null) {
                    rightTableSub = tableRight.getIndexes();
                }
                for(CompareResult resTable : compareLists(leftTableSub, rightTableSub)) {
                    elTable.addChild(new TreeElement(
                            resTable.getStatement(), resTable.getSide()));
                }
                
                // triggers
                if(tableLeft != null) {
                    leftTableSub = tableLeft.getTriggers();
                }
                if(tableRight!= null) {
                    rightTableSub = tableRight.getTriggers();
                }
                for(CompareResult resTable : compareLists(leftTableSub, rightTableSub)) {
                    elTable.addChild(new TreeElement(
                            resTable.getStatement(), resTable.getSide()));
                }
                
                // constraints
                if(tableLeft != null) {
                    leftTableSub = tableLeft.getIndexes();
                }
                if(tableRight!= null) {
                    rightTableSub = tableRight.getIndexes();
                }
                for(CompareResult resTable : compareLists(leftTableSub, rightTableSub)) {
                    elTable.addChild(new TreeElement(
                            resTable.getStatement(), resTable.getSide()));
                }
            }
        }
        
        return root;
    }
    
    private static List<CompareResult> compareLists(List<? extends PgStatement> left,
            List<? extends PgStatement> right) {
        List<CompareResult> rv = new ArrayList<>();
        
        // add LEFT and BOTH here
        // and RIGHT in a separate pass
        for(PgStatement sLeft : left) {
            PgStatement foundRight = null;
            for(PgStatement sRight : right) {
                if(sLeft.getName().equals(sRight.getName())) {
                    foundRight = sRight;
                    break;
                }
            }
            
            if(foundRight == null || !sLeft.equals(foundRight)) {
                rv.add(new CompareResult(sLeft, foundRight));
            } else {
                // do nothing if both statements exist and equal
            }
        }
        
        for(PgStatement sRight : right) {
            boolean foundLeft = false;
            for(PgStatement sLeft : left) {
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
}

class CompareResult {
    private final PgStatement left, right;
    
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
    
    public PgStatement getStatement() {
        if(left != null) {
            return left;
        }
        if(right != null) {
            return right;
        }
        throw new IllegalStateException("Both diff sides are null!");
    }
}