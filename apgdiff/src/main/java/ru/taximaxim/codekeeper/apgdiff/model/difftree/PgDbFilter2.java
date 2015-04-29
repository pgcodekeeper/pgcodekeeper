package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgType;
import cz.startnet.utils.pgdiff.schema.PgView;

/**
 * фильтрует базу на основании дерева диффа (и селекшенов в нем): не копирует
 * элементы БД, которые не выбраны/отсутствуют в дереве
 */
public class PgDbFilter2 {

    private final PgDatabase db;
    
    private final TreeElement root;
    
    private final DiffSide side;
    
    public PgDbFilter2(PgDatabase db, TreeElement root, DiffSide side) {
        if(side != DiffSide.LEFT && side != DiffSide.RIGHT) {
            throw new IllegalArgumentException(
                    "Must specify concrete filter side: LEFT or RIGHT!");
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
        // Если элемент или его дети не выбраны, его добавлять в базу не нужно
        if (!el.isSubTreeSelected()) {
            return;
        }
        ProcessResult res = null;
        try {
            switch(el.getType()) {
            case DATABASE:
                PgDatabase dbSrc = (PgDatabase) src;
                PgDatabase dbDst = (PgDatabase) dst;
                
                dbDst.setComment(dbSrc.getComment());
                
                // special case: we do not create/find Db objects, they are already supplied
                // we also do not use shallowCopy() because PgDatabase is already supplied
                // due to limitations imposed by processElement recursion
                res = new ProcessResult(src, dst);
                break;
                
            case EXTENSION:
                PgExtension extSrc = ((PgDatabase) src).getExtension(el.getName());
                ((PgDatabase) dst).addExtension(extSrc.shallowCopy());
                break;
                
            case SCHEMA:
                PgSchema schemaSrc = ((PgDatabase) src).getSchema(el.getName());
                PgSchema schemaEx = ((PgDatabase) dst).getSchema(schemaSrc.getName());
                PgSchema schemaDst = schemaSrc.shallowCopy();
                if(schemaEx == null) {
                    ((PgDatabase) dst).addSchema(schemaDst);
                } else {
                    ((PgDatabase) dst).tryReplacePublicDef(schemaDst);
                    schemaDst = schemaEx;
                }
                
                res = new ProcessResult(schemaSrc, schemaDst);
                break;
                
            case FUNCTION:
                PgFunction functionSrc = ((PgSchema) src).getFunction(el.getName());
                ((PgSchema) dst).addFunction(functionSrc.shallowCopy());
                break;
                
            case SEQUENCE:
                PgSequence sequenceSrc = ((PgSchema) src).getSequence(el.getName());
                ((PgSchema) dst).addSequence(sequenceSrc.shallowCopy());
                break;
                
            case TYPE:
                PgType typeSrc = ((PgSchema) src).getType(el.getName());
                ((PgSchema) dst).addType(typeSrc.shallowCopy());
                break;
                
            case DOMAIN:
                PgDomain domainSrc = ((PgSchema) src).getDomain(el.getName());
                ((PgSchema) dst).addDomain(domainSrc.shallowCopy());
                break;
                
            case VIEW:
                PgView viewSrc = ((PgSchema) src).getView(el.getName());
                ((PgSchema) dst).addView(viewSrc.shallowCopy());
                break;
                
            case TABLE:
                PgTable tableSrc = ((PgSchema) src).getTable(el.getName());
                PgTable tableDst = ((PgSchema) dst).getTable(tableSrc.getName());
                
                if(tableDst == null) {
                    tableDst = tableSrc.shallowCopy();
                    ((PgSchema) dst).addTable(tableDst);
                }
                
                res = new ProcessResult(tableSrc, tableDst);
                break;
                
            case INDEX:
                PgIndex indexSrc = ((PgTable) src).getIndex(el.getName());
                ((PgTable) dst).addIndex(indexSrc.shallowCopy());
                break;
                
            case TRIGGER:
                PgTrigger triggerSrc = ((PgTable) src).getTrigger(el.getName());
                ((PgTable) dst).addTrigger(triggerSrc.shallowCopy());
                break;
                
            case CONSTRAINT:
                PgConstraint constraintSrc = ((PgTable) src).getConstraint(el.getName());
                ((PgTable) dst).addConstraint(constraintSrc.shallowCopy());
                break;
            }
        } catch (ClassCastException ex) {
            illegalTreeStructure(el, ex);
        }
        
        if(res == null && el.hasChildren()) {
            illegalTreeStructure(el.getChild(0),new IllegalStateException(
                    "No container generated but el.hasChildren()"));
        }
        
        for(TreeElement sub : el.getChildren()) {
            processElement(sub, res.src, res.dst);
        }
    }

    private boolean checkSide(TreeElement el) {
        return el.getSide() == side || el.getSide() == DiffSide.BOTH;
    }
    
    /**
     * Throws and notifies about illegal diff tree structure.
     * 
     * @throws IllegalArgumentException
     */
    private static void illegalTreeStructure(TreeElement illegalChild, Throwable cause) {
        TreeElement parent = illegalChild.getParent();
        throw new IllegalArgumentException(
                String.format("Illegal child %s of type %s in the node %s of type %s",
                illegalChild.getName(), illegalChild.getType(),
                (parent == null)? null : parent.getName(),
                (parent == null)? null : parent.getType()), cause);
    }
}

class ProcessResult {
    final PgStatement src;
    final PgStatement dst;
    
    public ProcessResult(PgStatement src, PgStatement dst) {
        this.src = src;
        this.dst = dst;
    }
}
