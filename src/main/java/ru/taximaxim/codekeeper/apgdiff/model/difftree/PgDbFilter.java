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
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgView;

public class PgDbFilter {

    public static PgDatabase apply(PgDatabase db, TreeElement filterRoot,
            DiffSide dbSide) {
        if(dbSide == DiffSide.BOTH) {
            throw new IllegalArgumentException("Must specify DB side, not BOTH!");
        }
        
        if(filterRoot.getType() != DbObjType.DATABASE) {
            throw new IllegalArgumentException("Filter root of wrong type: "
                    + filterRoot.getType());
        }
        
        PgDatabase dbFiltered = new PgDatabase();
        dbFiltered.setComment(db.getComment());
        
        for(TreeElement dbSub : filterRoot.getChildren()) {
            // if the element does not exist on the side we're currently processing
            // continue
            if(dbSub.getSide() != dbSide && dbSub.getSide() != DiffSide.BOTH) {
                continue;
            }
            
            switch(dbSub.getType()) {
            case EXTENSION:
                PgExtension ext = db.getExtension(dbSub.getName());
                PgExtension extCopy = new PgExtension(ext.getName(), ext.getRawStatement());
                extCopy.setSchema(ext.getSchema());
                extCopy.setVersion(ext.getVersion());
                extCopy.setOldVersion(ext.getOldVersion());
                extCopy.setComment(ext.getComment());
                dbFiltered.addExtension(extCopy);
                
                break;
            case SCHEMA:
                PgSchema schema = db.getSchema(dbSub.getName());
                PgSchema schemaCopy;
                if(dbSub.getName().equals("public")) {
                    schemaCopy = dbFiltered.getSchema("public");
                } else {
                    schemaCopy = new PgSchema(schema.getName(), schema.getRawStatement());
                    schemaCopy.setAuthorization(schema.getAuthorization());
                    schemaCopy.setDefinition(schema.getDefinition());
                    schemaCopy.setComment(schema.getComment());
                    dbFiltered.addSchema(schemaCopy);
                }
                
                for(TreeElement schemaSub : dbSub.getChildren()) {
                    if(schemaSub.getSide() != dbSide && schemaSub.getSide() != DiffSide.BOTH) {
                        continue;
                    }
                    
                    switch(schemaSub.getType()) {
                    case FUNCTION:
                        PgFunction func = schema.getFunction(schemaSub.getName());
                        PgFunction funcCopy = new PgFunction(func.getRawStatement(), func.getSearchPath());
                        funcCopy.setName(func.getBareName());
                        funcCopy.setBody(func.getBody());
                        funcCopy.setComment(func.getComment());
                        for(PgFunction.Argument arg : func.getArguments()) {
                            PgFunction.Argument argCopy = new PgFunction.Argument();
                            argCopy.setName(arg.getName());
                            argCopy.setMode(arg.getMode());
                            argCopy.setDataType(arg.getDataType());
                            argCopy.setDefaultExpression(arg.getDefaultExpression());
                            funcCopy.addArgument(argCopy);
                        }
                        schemaCopy.addFunction(funcCopy);
                        
                        break;
                    case SEQUENCE:
                        PgSequence seq = schema.getSequence(schemaSub.getName());
                        PgSequence seqCopy = new PgSequence(seq.getName(), seq.getRawStatement(), seq.getSearchPath());
                        seqCopy.setCache(seq.getCache());
                        seqCopy.setCycle(seq.isCycle());
                        seqCopy.setIncrement(seq.getIncrement());
                        seqCopy.setMaxValue(seq.getMaxValue());
                        seqCopy.setMinValue(seq.getMinValue());
                        seqCopy.setOwnedBy(seq.getOwnedBy());
                        seqCopy.setStartWith(seq.getStartWith());
                        seqCopy.setComment(seq.getComment());
                        schemaCopy.addSequence(seqCopy);
                        
                        break;
                    case VIEW:
                        PgView view = schema.getView(schemaSub.getName());
                        PgView viewCopy = new PgView(view.getName(), view.getRawStatement(), view.getSearchPath());
                        viewCopy.setQuery(view.getQuery());
                        viewCopy.setComment(view.getComment());
                        viewCopy.setColumnNames(new ArrayList<>(view.getColumnNames()));
                        for(PgView.DefaultValue defval : view.getDefaultValues()) {
                            viewCopy.addColumnDefaultValue(defval.getColumnName(), defval.getDefaultValue());
                        }
                        for(PgView.ColumnComment colcomment : view.getColumnComments()) {
                            viewCopy.addColumnComment(colcomment.getColumnName(), colcomment.getComment());
                        }
                        schemaCopy.addView(viewCopy);
                        
                        break;
                    case TABLE:
                        PgTable table = schema.getTable(schemaSub.getName());
                        PgTable tableCopy = new PgTable(table.getName(), table.getRawStatement(), table.getSearchPath());
                        tableCopy.setClusterIndexName(table.getClusterIndexName());
                        tableCopy.setIgnored(tableCopy.getIgnored());
                        tableCopy.setTablespace(table.getTablespace());
                        tableCopy.setWith(table.getWith());
                        for(String inherits : table.getInherits()) {
                            tableCopy.addInherits(inherits);
                        }
                        for(PgColumn col : table.getColumns()) {
                            PgColumn colCopy = new PgColumn(col.getName());
                            colCopy.setDefaultValue(col.getDefaultValue());
                            colCopy.setNullValue(col.getNullValue());
                            colCopy.setStatistics(col.getStatistics());
                            colCopy.setStorage(col.getStorage());
                            colCopy.setType(col.getType());
                            colCopy.setComment(col.getComment());
                            tableCopy.addColumn(colCopy);
                        }
                        tableCopy.setComment(table.getComment());
                        schemaCopy.addTable(tableCopy);
                        
                        for(TreeElement tableSub : schemaSub.getChildren()) {
                            if(tableSub.getSide() != dbSide && tableSub.getSide() != DiffSide.BOTH) {
                                continue;
                            }
                            
                            switch(tableSub.getType()) {
                            case INDEX:
                                PgIndex idx = table.getIndex(tableSub.getName());
                                PgIndex idxCopy = new PgIndex(idx.getName(), idx.getRawStatement(), idx.getSearchPath());
                                idxCopy.setDefinition(idx.getDefinition());
                                idxCopy.setTableName(idx.getTableName());
                                idxCopy.setUnique(idx.isUnique());
                                idxCopy.setComment(idx.getComment());
                                tableCopy.addIndex(idxCopy);
                                
                                break;
                            case TRIGGER:
                                PgTrigger trigger = table.getTrigger(tableSub.getName());
                                PgTrigger triggerCopy = new PgTrigger(trigger.getRawStatement(), trigger.getSearchPath());
                                triggerCopy.setName(trigger.getName());
                                triggerCopy.setBefore(trigger.isBefore());
                                triggerCopy.setForEachRow(trigger.isForEachRow());
                                triggerCopy.setFunction(trigger.getFunction());
                                triggerCopy.setOnDelete(trigger.isOnDelete());
                                triggerCopy.setOnInsert(trigger.isOnInsert());
                                triggerCopy.setOnTruncate(trigger.isOnTruncate());
                                triggerCopy.setOnUpdate(trigger.isOnUpdate());
                                triggerCopy.setTableName(trigger.getTableName());
                                triggerCopy.setWhen(trigger.getWhen());
                                triggerCopy.setComment(trigger.getComment());
                                for(String updCol : trigger.getUpdateColumns()) {
                                    triggerCopy.addUpdateColumn(updCol);
                                }
                                tableCopy.addTrigger(triggerCopy);
                                
                                break;
                            case CONSTRAINT:
                                PgConstraint cons = table.getConstraint(tableSub.getName());
                                PgConstraint consCopy = new PgConstraint(cons.getName(), cons.getRawStatement(), cons.getSearchPath());
                                consCopy.setDefinition(cons.getDefinition());
                                consCopy.setTableName(cons.getTableName());
                                consCopy.setComment(cons.getComment());
                                tableCopy.addConstraint(consCopy);
                                
                                break;
                            default:
                                illegalTreeStructure(schemaSub, tableSub);
                            }
                        }
                        
                        break;
                    default:
                        illegalTreeStructure(dbSub, schemaSub);
                    }
                }
                
                break;
            default:
                illegalTreeStructure(filterRoot, dbSub);
            }
        }
        
        return dbFiltered;
    }
    
    /**
     * Throws and ends {@link PgDbFilter} due to illegal filter tree structure.
     * 
     * @param parent
     * @param illegalChild
     * 
     * @throws IllegalArgumentException
     */
    private static void illegalTreeStructure(TreeElement parent, TreeElement illegalChild) {
        throw new IllegalArgumentException(
                String.format("Illegal child %s of type %s in the node %s of type %s",
                illegalChild.getName(), illegalChild.getType(),
                parent.getName(), parent.getType()));
    }
}