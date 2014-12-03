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

public final class DiffTree {
    
    private static final List<? extends PgStatement> EMPTY_LIST = 
            Collections.unmodifiableList(new ArrayList<PgStatement>());

    public static TreeElement create(PgDatabase left, PgDatabase right) {
        TreeElement root = new TreeElement(
                "<root>", DbObjType.CONTAINER, DbObjType.DATABASE, DiffSide.BOTH);
        
        TreeElement db = new TreeElement("Database", DbObjType.DATABASE, null, DiffSide.BOTH);
        root.addChild(db);
        
        TreeElement leftTree = new TreeElement(
                "Source only", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.LEFT);
        TreeElement rightTree = new TreeElement(
                "Target only", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.RIGHT);
        TreeElement bothTree = new TreeElement(
                "Different", DbObjType.CONTAINER, DbObjType.CONTAINER, DiffSide.BOTH);
        db.addChild(bothTree);
        db.addChild(leftTree);
        db.addChild(rightTree);
        
        TreeElement extContainerLeft = TreeElement.createContainer(DbObjType.EXTENSION, DiffSide.LEFT);
        TreeElement extContainerRight = TreeElement.createContainer(DbObjType.EXTENSION, DiffSide.RIGHT);
        TreeElement extContainerBoth = TreeElement.createContainer(DbObjType.EXTENSION, DiffSide.BOTH);
        
        compareLists(left.getExtensions(), right.getExtensions(), extContainerLeft,
                extContainerRight, extContainerBoth);
        leftTree.addChildNotEmpty(extContainerLeft);
        rightTree.addChildNotEmpty(extContainerRight);
        bothTree.addChildNotEmpty(extContainerBoth);
        
        TreeElement schemaContLeft = TreeElement.createContainer(DbObjType.SCHEMA, DiffSide.LEFT);
        TreeElement schemaContRight = TreeElement.createContainer(DbObjType.SCHEMA, DiffSide.RIGHT);
        TreeElement schemaContBoth = TreeElement.createContainer(DbObjType.SCHEMA, DiffSide.BOTH);
        
        for(CompareResult resSchema : compareLists(left.getSchemas(), right.getSchemas(),
                schemaContLeft, schemaContRight, schemaContBoth)) {
            TreeElement elSchemaLeft, elSchemaRight, elSchemaBoth;
            
            // sides other than the current should always be empty except when current is BOTH 
            switch(resSchema.getSide()) {
            case LEFT:
                elSchemaLeft = schemaContLeft.getChild(
                        resSchema.getStatement().getName(), DbObjType.SCHEMA);
                elSchemaRight = new TreeElement(resSchema.getStatement(), DiffSide.BOTH);
                elSchemaBoth = new TreeElement(resSchema.getStatement(), DiffSide.BOTH);
                break;
            case RIGHT:
                elSchemaLeft = new TreeElement(resSchema.getStatement(), DiffSide.BOTH);
                elSchemaRight = schemaContRight.getChild(
                        resSchema.getStatement().getName(), DbObjType.SCHEMA);
                elSchemaBoth = new TreeElement(resSchema.getStatement(), DiffSide.BOTH);
                break;
            case BOTH:
                elSchemaLeft = new TreeElement(resSchema.getStatement(), DiffSide.BOTH);
                elSchemaRight = new TreeElement(resSchema.getStatement(), DiffSide.BOTH);
                elSchemaBoth = schemaContBoth.getChild(
                        resSchema.getStatement().getName(), DbObjType.SCHEMA);
                break;
            default:
                elSchemaLeft = elSchemaRight = elSchemaBoth = null;
            }
            
            List<? extends PgStatement> leftSub = EMPTY_LIST;
            List<? extends PgStatement> rightSub = EMPTY_LIST;
            
            PgSchema schemaLeft = (PgSchema) resSchema.getLeft();
            PgSchema schemaRight = (PgSchema) resSchema.getRight();
            
            TreeElement schemaSubLeft, schemaSubRight, schemaSubBoth;
            
            // functions
            if(schemaLeft != null) {
                leftSub = schemaLeft.getFunctions();
            }
            if(schemaRight != null) {
                rightSub = schemaRight.getFunctions();
            }
            schemaSubLeft = TreeElement.createContainer(DbObjType.FUNCTION, DiffSide.LEFT);
            schemaSubRight = TreeElement.createContainer(DbObjType.FUNCTION, DiffSide.RIGHT);
            schemaSubBoth = TreeElement.createContainer(DbObjType.FUNCTION, DiffSide.BOTH);
            
            compareLists(leftSub, rightSub, schemaSubLeft, schemaSubRight, schemaSubBoth);
            elSchemaLeft.addChildNotEmpty(schemaSubLeft);
            elSchemaRight.addChildNotEmpty(schemaSubRight);
            elSchemaBoth.addChildNotEmpty(schemaSubBoth);
            
            // sequences
            if(schemaLeft != null) {
                leftSub = schemaLeft.getSequences();
            }
            if(schemaRight != null) {
                rightSub = schemaRight.getSequences();
            }
            schemaSubLeft = TreeElement.createContainer(DbObjType.SEQUENCE, DiffSide.LEFT);
            schemaSubRight = TreeElement.createContainer(DbObjType.SEQUENCE, DiffSide.RIGHT);
            schemaSubBoth = TreeElement.createContainer(DbObjType.SEQUENCE, DiffSide.BOTH);
            
            compareLists(leftSub, rightSub, schemaSubLeft, schemaSubRight, schemaSubBoth);
            elSchemaLeft.addChildNotEmpty(schemaSubLeft);
            elSchemaRight.addChildNotEmpty(schemaSubRight);
            elSchemaBoth.addChildNotEmpty(schemaSubBoth);
            
            // view
            if(schemaLeft != null) {
                leftSub = schemaLeft.getViews();
            }
            if(schemaRight != null) {
                rightSub = schemaRight.getViews();
            }
            schemaSubLeft = TreeElement.createContainer(DbObjType.VIEW, DiffSide.LEFT);
            schemaSubRight = TreeElement.createContainer(DbObjType.VIEW, DiffSide.RIGHT);
            schemaSubBoth = TreeElement.createContainer(DbObjType.VIEW, DiffSide.BOTH);
            
            compareLists(leftSub, rightSub, schemaSubLeft, schemaSubRight, schemaSubBoth);
            elSchemaLeft.addChildNotEmpty(schemaSubLeft);
            elSchemaRight.addChildNotEmpty(schemaSubRight);
            elSchemaBoth.addChildNotEmpty(schemaSubBoth);
            
            // tables
            if(schemaLeft != null) {
                leftSub = schemaLeft.getTables();
            }
            if(schemaRight != null) {
                rightSub = schemaRight.getTables();
            }
            schemaSubLeft = TreeElement.createContainer(DbObjType.TABLE, DiffSide.LEFT);
            schemaSubRight = TreeElement.createContainer(DbObjType.TABLE, DiffSide.RIGHT);
            schemaSubBoth = TreeElement.createContainer(DbObjType.TABLE, DiffSide.BOTH);
            
            for(CompareResult resSub : compareLists(leftSub, rightSub,
                    schemaSubLeft, schemaSubRight, schemaSubBoth)) {
                TreeElement elTableLeft, elTableRight, elTableBoth;

                // sides other than the current should always be empty except when current is BOTH 
                switch(resSub.getSide()) {
                case LEFT:
                    elTableLeft = schemaSubLeft.getChild(
                            resSub.getStatement().getName(), DbObjType.TABLE);
                    elTableRight = new TreeElement(resSub.getStatement(), DiffSide.BOTH);
                    elTableBoth = new TreeElement(resSub.getStatement(), DiffSide.BOTH);
                    break;
                case RIGHT:
                    elTableLeft = new TreeElement(resSub.getStatement(), DiffSide.BOTH);
                    elTableRight = schemaSubRight.getChild(
                            resSub.getStatement().getName(), DbObjType.TABLE);
                    elTableBoth = new TreeElement(resSub.getStatement(), DiffSide.BOTH);
                    break;
                case BOTH:
                    elTableLeft = new TreeElement(resSub.getStatement(), DiffSide.BOTH);
                    elTableRight = new TreeElement(resSub.getStatement(), DiffSide.BOTH);
                    elTableBoth = schemaSubBoth.getChild(
                            resSub.getStatement().getName(), DbObjType.TABLE);
                    break;
                default:
                    elTableLeft = elTableRight = elTableBoth = null;
                }
                
                List<? extends PgStatement> leftTableSub = EMPTY_LIST;
                List<? extends PgStatement> rightTableSub = EMPTY_LIST;
                
                PgTable tableLeft = (PgTable) resSub.getLeft();
                PgTable tableRight = (PgTable) resSub.getRight();
                
                TreeElement tableSubLeft, tableSubRight, tableSubBoth;
                
                // indexes
                if(tableLeft != null) {
                    leftTableSub = tableLeft.getIndexes();
                }
                if(tableRight != null) {
                    rightTableSub = tableRight.getIndexes();
                }
                tableSubLeft = TreeElement.createContainer(DbObjType.INDEX, DiffSide.LEFT);
                tableSubRight = TreeElement.createContainer(DbObjType.INDEX, DiffSide.RIGHT);
                tableSubBoth = TreeElement.createContainer(DbObjType.INDEX, DiffSide.BOTH);
                
                compareLists(leftTableSub, rightTableSub, tableSubLeft,
                        tableSubRight, tableSubBoth);
                elTableLeft.addChildNotEmpty(tableSubLeft);
                elTableRight.addChildNotEmpty(tableSubRight);
                elTableBoth.addChildNotEmpty(tableSubBoth);
                
                // triggers
                if(tableLeft != null) {
                    leftTableSub = tableLeft.getTriggers();
                }
                if(tableRight != null) {
                    rightTableSub = tableRight.getTriggers();
                }
                tableSubLeft = TreeElement.createContainer(DbObjType.TRIGGER, DiffSide.LEFT);
                tableSubRight = TreeElement.createContainer(DbObjType.TRIGGER, DiffSide.RIGHT);
                tableSubBoth = TreeElement.createContainer(DbObjType.TRIGGER, DiffSide.BOTH);
                
                compareLists(leftTableSub, rightTableSub, tableSubLeft,
                        tableSubRight, tableSubBoth);
                elTableLeft.addChildNotEmpty(tableSubLeft);
                elTableRight.addChildNotEmpty(tableSubRight);
                elTableBoth.addChildNotEmpty(tableSubBoth);
                
                // constraints
                if(tableLeft != null) {
                    leftTableSub = tableLeft.getConstraints();
                }
                if(tableRight != null) {
                    rightTableSub = tableRight.getConstraints();
                }
                tableSubLeft = TreeElement.createContainer(DbObjType.CONSTRAINT, DiffSide.LEFT);
                tableSubRight = TreeElement.createContainer(DbObjType.CONSTRAINT, DiffSide.RIGHT);
                tableSubBoth = TreeElement.createContainer(DbObjType.CONSTRAINT, DiffSide.BOTH);
                
                compareLists(leftTableSub, rightTableSub, tableSubLeft,
                        tableSubRight, tableSubBoth);
                elTableLeft.addChildNotEmpty(tableSubLeft);
                elTableRight.addChildNotEmpty(tableSubRight);
                elTableBoth.addChildNotEmpty(tableSubBoth);
                
                switch(resSub.getSide()) {
                case LEFT:
                    schemaSubRight.addChildNotEmpty(elTableRight);
                    schemaSubBoth.addChildNotEmpty(elTableBoth);
                    break;
                case RIGHT:
                    schemaSubLeft.addChildNotEmpty(elTableLeft);
                    schemaSubBoth.addChildNotEmpty(elTableBoth);
                    break;
                case BOTH:
                    schemaSubLeft.addChildNotEmpty(elTableLeft);
                    schemaSubRight.addChildNotEmpty(elTableRight);
                    break;
                }
            }
            elSchemaLeft.addChildNotEmpty(schemaSubLeft);
            elSchemaRight.addChildNotEmpty(schemaSubRight);
            elSchemaBoth.addChildNotEmpty(schemaSubBoth);
            
            switch(resSchema.getSide()) {
            case LEFT:
                schemaContRight.addChildNotEmpty(elSchemaRight);
                schemaContBoth.addChildNotEmpty(elSchemaBoth);
                break;
            case RIGHT:
                schemaContLeft.addChildNotEmpty(elSchemaLeft);
                schemaContBoth.addChildNotEmpty(elSchemaBoth);
                break;
            case BOTH:
                schemaContLeft.addChildNotEmpty(elSchemaLeft);
                schemaContRight.addChildNotEmpty(elSchemaRight);
                break;
            }
        }
        leftTree.addChildNotEmpty(schemaContLeft);
        rightTree.addChildNotEmpty(schemaContRight);
        bothTree.addChildNotEmpty(schemaContBoth);
        
        return root;
    }
    
    /**
     * Compare lists and put elements onto appropriate sides.
     */
    private static List<CompareResult> compareLists(List<? extends PgStatement> left,
            List<? extends PgStatement> right, TreeElement leftCont, TreeElement rightCont,
            TreeElement bothCont) {
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
            
            // special case: if right schema is a bare default public schema
            // and left one is not bare - assume that right doesn't exist at all
            // and mark left as LEFT, not BOTH
            if(foundRight == null || (foundRight instanceof PgSchema
                    && foundRight.equals(new PgDatabase().getDefaultSchema())
                    && !sLeft.compare(foundRight))) {
                rv.add(new CompareResult(sLeft, null));
                leftCont.addChild(new TreeElement(sLeft, DiffSide.LEFT));
            } else if(!sLeft.equals(foundRight)) {
                rv.add(new CompareResult(sLeft, foundRight));
                bothCont.addChild(new TreeElement(sLeft, DiffSide.BOTH));
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
                rightCont.addChild(new TreeElement(sRight, DiffSide.RIGHT));
            }
        }
        
        return rv;
    }
    
    private DiffTree() {
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