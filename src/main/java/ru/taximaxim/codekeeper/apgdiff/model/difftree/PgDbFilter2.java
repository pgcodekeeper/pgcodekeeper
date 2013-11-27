package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import java.util.ArrayList;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgView;

public class PgDbFilter2 {

    final private PgDatabase db;
    
    final private TreeElement root;
    
    final private DiffSide side;
    
    public PgDbFilter2(PgDatabase db, TreeElement root, DiffSide side) {
        if(side != DiffSide.LEFT && side != DiffSide.RIGHT) {
            throw new IllegalArgumentException(
                    "Must specify concrete filter side: LEFT or RIGHT!");
        }
        if(root.getType() != DbObjType.CONTAINER) {
            illegalTreeStructure(root);
        }
        
        this.db = db;
        this.root = root;
        this.side = side;
    }
    
    public PgDatabase apply() {
        PgDatabase dbFiltered = new PgDatabase();
        processElement(root, db, dbFiltered);
        
        return dbFiltered;
    }
    
    /**
     * The general idea is that el is an element for processing, src is a source of its original,
     * dst is destination for its copy. If element can have children then its processing function returns
     * a pair of a found object as res.src and a generated copy as res.dst.
     * These are then used to process children on the tree level one deeper.
     * 
     * @param el element for processing
     * @param src source of el
     * @param dst destination for copy of el
     * 
     * @throws IllegalArgumentException
     */
    private void processElement(TreeElement el, PgStatement src, PgStatement dst) {
        if(!checkSide(el)) {
            return;
        }
        
        ProcessResult res = null;
        try {
            switch(el.getType()) {
            case CONTAINER:
                // just go straight to processing children
                res = new ProcessResult(src, dst);
                break;
                
            case DATABASE:
                res = processDatabase(el, src, dst);
                break;
                
            case EXTENSION:
                processExtension(el, src, dst);
                break;
                
            case SCHEMA:
                res = processSchema(el, src, dst);
                break;
                
            case FUNCTION:
                processFunction(el, src, dst);
                break;
                
            case SEQUENCE:
                processSequence(el, src, dst);
                break;
                
            case VIEW:
                processView(el, src, dst);
                break;
                
            case TABLE:
                res = processTable(el, src, dst);
                break;
                
            case INDEX:
                processIndex(el, src, dst);
                break;
                
            case TRIGGER:
                processTrigger(el, src, dst);
                break;
                
            case CONSTRAINT:
                processConstraint(el, src, dst);
                break;
            }
        } catch (ClassCastException ex) {
            illegalTreeStructure(el, ex);
        }
        
        for(TreeElement sub : el.getChildren()) {
            if(res == null) {
                illegalTreeStructure(sub, new NullPointerException());
            }
            processElement(sub, res.src, res.dst);
        }
    }
    
    private ProcessResult processDatabase(TreeElement db, PgStatement src, PgStatement dst) {
        PgDatabase dbSrc = (PgDatabase) src;
        PgDatabase dbDst = (PgDatabase) dst;
        
        dbDst.setComment(dbSrc.getComment());
        
        // special case: we do not create/find Db objects, they are already supplied
        return new ProcessResult(src, dst);
    }
    
    private void processExtension(TreeElement extension, PgStatement src, PgStatement dst) {
        PgExtension extSrc = ((PgDatabase) src).getExtension(extension.getName());
        PgExtension extDst = new PgExtension(extSrc.getName(), extSrc.getRawStatement());
        extDst.setSchema(extSrc.getSchema());
        extDst.setVersion(extSrc.getVersion());
        extDst.setOldVersion(extSrc.getOldVersion());
        extDst.setComment(extSrc.getComment());
        ((PgDatabase) dst).addExtension(extDst);
    }
    
    private ProcessResult processSchema(TreeElement schema, PgStatement src, PgStatement dst) {
        PgSchema schemaSrc = ((PgDatabase) src).getSchema(schema.getName());
        PgSchema schemaDst = ((PgDatabase) dst).getSchema(schemaSrc.getName());
        if(schemaDst == null) {
            schemaDst = new PgSchema(schemaSrc.getName(), schemaSrc.getRawStatement());
            schemaDst.setAuthorization(schemaSrc.getAuthorization());
            schemaDst.setDefinition(schemaSrc.getDefinition());
            schemaDst.setComment(schemaSrc.getComment());
            ((PgDatabase) dst).addSchema(schemaDst);
        }
        
        return new ProcessResult(schemaSrc, schemaDst);
    }
    
    private void processFunction(TreeElement function, PgStatement src, PgStatement dst) {
        PgFunction functionSrc = ((PgSchema) src).getFunction(function.getName());
        PgFunction functionDst = new PgFunction(functionSrc.getRawStatement(), functionSrc.getSearchPath());
        functionDst.setName(functionSrc.getBareName());
        functionDst.setBody(functionSrc.getBody());
        functionDst.setComment(functionSrc.getComment());
        for(PgFunction.Argument argSrc : functionSrc.getArguments()) {
            PgFunction.Argument argDst = new PgFunction.Argument();
            argDst.setName(argSrc.getName());
            argDst.setMode(argSrc.getMode());
            argDst.setDataType(argSrc.getDataType());
            argDst.setDefaultExpression(argSrc.getDefaultExpression());
            functionDst.addArgument(argDst);
        }
        ((PgSchema) dst).addFunction(functionDst);
    }
    
    private void processSequence(TreeElement sequence, PgStatement src, PgStatement dst) {
        PgSequence sequenceSrc = ((PgSchema) src).getSequence(sequence.getName());
        PgSequence sequenceDst = new PgSequence(sequenceSrc.getName(), sequenceSrc.getRawStatement(), sequenceSrc.getSearchPath());
        sequenceDst.setCache(sequenceSrc.getCache());
        sequenceDst.setCycle(sequenceSrc.isCycle());
        sequenceDst.setIncrement(sequenceSrc.getIncrement());
        sequenceDst.setMaxValue(sequenceSrc.getMaxValue());
        sequenceDst.setMinValue(sequenceSrc.getMinValue());
        sequenceDst.setOwnedBy(sequenceSrc.getOwnedBy());
        sequenceDst.setStartWith(sequenceSrc.getStartWith());
        sequenceDst.setComment(sequenceSrc.getComment());
        ((PgSchema) dst).addSequence(sequenceDst);
    }
    
    private void processView(TreeElement view, PgStatement src, PgStatement dst) {
        PgView viewSrc = ((PgSchema) src).getView(view.getName());
        PgView viewDst = new PgView(viewSrc.getName(), viewSrc.getRawStatement(), viewSrc.getSearchPath());
        viewDst.setQuery(viewSrc.getQuery());
        viewDst.setComment(viewSrc.getComment());
        viewDst.setColumnNames(new ArrayList<>(viewSrc.getColumnNames()));
        for(PgView.DefaultValue defval : viewSrc.getDefaultValues()) {
            viewDst.addColumnDefaultValue(defval.getColumnName(), defval.getDefaultValue());
        }
        for(PgView.ColumnComment colcomment : viewSrc.getColumnComments()) {
            viewDst.addColumnComment(colcomment.getColumnName(), colcomment.getComment());
        }
        ((PgSchema) dst).addView(viewDst);
    }
    
    private ProcessResult processTable(TreeElement table, PgStatement src, PgStatement dst) {
        PgTable tableSrc = ((PgSchema) src).getTable(table.getName());
        PgTable tableDst = ((PgSchema) dst).getTable(tableSrc.getName());
        
        if(tableDst == null) {
            tableDst = new PgTable(tableSrc.getName(), tableSrc.getRawStatement(), tableSrc.getSearchPath());
            tableDst.setClusterIndexName(tableSrc.getClusterIndexName());
            tableDst.setIgnored(tableDst.getIgnored());
            tableDst.setTablespace(tableSrc.getTablespace());
            tableDst.setWith(tableSrc.getWith());
            for(String inherits : tableSrc.getInherits()) {
                tableDst.addInherits(inherits);
            }
            for(PgColumn colSrc : tableSrc.getColumns()) {
                PgColumn colDst = new PgColumn(colSrc.getName());
                colDst.setDefaultValue(colSrc.getDefaultValue());
                colDst.setNullValue(colSrc.getNullValue());
                colDst.setStatistics(colSrc.getStatistics());
                colDst.setStorage(colSrc.getStorage());
                colDst.setType(colSrc.getType());
                colDst.setComment(colSrc.getComment());
                tableDst.addColumn(colDst);
            }
            tableDst.setComment(tableSrc.getComment());
            ((PgSchema) dst).addTable(tableDst);
        }
        
        return new ProcessResult(tableSrc, tableDst);
    }
    
    private void processIndex(TreeElement index, PgStatement src, PgStatement dst) {
        PgIndex indexSrc = ((PgTable) src).getIndex(index.getName());
        PgIndex indexDst = new PgIndex(indexSrc.getName(), indexSrc.getRawStatement(), indexSrc.getSearchPath());
        indexDst.setDefinition(indexSrc.getDefinition());
        indexDst.setTableName(indexSrc.getTableName());
        indexDst.setUnique(indexSrc.isUnique());
        indexDst.setComment(indexSrc.getComment());
        ((PgTable) dst).addIndex(indexDst);
    }
    
    private void processTrigger(TreeElement trigger, PgStatement src, PgStatement dst) {
        PgTrigger triggerSrc = ((PgTable) src).getTrigger(trigger.getName());
        PgTrigger triggerDst = new PgTrigger(triggerSrc.getRawStatement(), triggerSrc.getSearchPath());
        triggerDst.setName(triggerSrc.getName());
        triggerDst.setBefore(triggerSrc.isBefore());
        triggerDst.setForEachRow(triggerSrc.isForEachRow());
        triggerDst.setFunction(triggerSrc.getFunction());
        triggerDst.setOnDelete(triggerSrc.isOnDelete());
        triggerDst.setOnInsert(triggerSrc.isOnInsert());
        triggerDst.setOnTruncate(triggerSrc.isOnTruncate());
        triggerDst.setOnUpdate(triggerSrc.isOnUpdate());
        triggerDst.setTableName(triggerSrc.getTableName());
        triggerDst.setWhen(triggerSrc.getWhen());
        triggerDst.setComment(triggerSrc.getComment());
        for(String updCol : triggerSrc.getUpdateColumns()) {
            triggerDst.addUpdateColumn(updCol);
        }
        ((PgTable) dst).addTrigger(triggerDst);
    }
    
    private void processConstraint(TreeElement constraint, PgStatement src, PgStatement dst) {
        PgConstraint constraintSrc = ((PgTable) src).getConstraint(constraint.getName());
        PgConstraint constraintDst = new PgConstraint(constraintSrc.getName(), constraintSrc.getRawStatement(), constraintSrc.getSearchPath());
        constraintDst.setDefinition(constraintSrc.getDefinition());
        constraintDst.setTableName(constraintSrc.getTableName());
        constraintDst.setComment(constraintSrc.getComment());
        ((PgTable) dst).addConstraint(constraintDst);
    }
    
    private boolean checkSide(TreeElement el) {
        return (el.getType() == DbObjType.CONTAINER)? true : // do not check for CONTAINER elements 
            (el.getSide() == side || el.getSide() == DiffSide.BOTH);
    }
    
    /**
     * Throws and ends {@link PgDbFilter} due to illegal filter tree structure.
     * 
     * @param parent
     * @param illegalChild
     * 
     * @throws IllegalArgumentException
     */
    private void illegalTreeStructure(TreeElement illegalChild) {
        illegalTreeStructure(illegalChild, null);
    }
    
    private void illegalTreeStructure(TreeElement illegalChild, Throwable cause) {
        TreeElement parent = illegalChild.getParent();
        throw new IllegalArgumentException(
                String.format("Illegal child %s of type %s in the node %s of type %s",
                illegalChild.getName(), illegalChild.getType(),
                (parent == null)? null : parent.getName(),
                (parent == null)? null : parent.getType()), cause);
    }
}

class ProcessResult {
    final public PgStatement src;
    final public PgStatement dst;
    
    public ProcessResult(PgStatement src, PgStatement dst) {
        this.src = src;
        this.dst = dst;
    }
}
