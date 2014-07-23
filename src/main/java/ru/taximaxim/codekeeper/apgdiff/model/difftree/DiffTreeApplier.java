package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyGraph;
import cz.startnet.utils.pgdiff.PgDiff;
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

/**
 * Copies source DB into a new one updating, adding (from target DB)
 * and removing entries as per diff tree.
 * 
 * LEFT elements are not copied (removed), RIGHT & BOTH elements are copied from
 * target DB (updated/added). 
 */
public class DiffTreeApplier {

    final private PgDatabase dbSource, dbTarget;
    /**
     * Tree representation of user selected changes
     */
    final private TreeElement root;
    
    private DepcyGraph depcySource;
    private DepcyGraph depcyTarget;
    private TreeElement diffTree;
    
    private List<PgStatement> lstNoCopy = new ArrayList<>();
    
    public DiffTreeApplier(PgDatabase dbSource, PgDatabase dbTarget, TreeElement root) {
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
        this.root = root;

        // depcy graphs
        depcySource = new DepcyGraph(dbSource);
        depcyTarget = new DepcyGraph(dbTarget);
    }
    
    public PgDatabase apply() {
        // fill the no copy with all selected LEFT statements 
        noCopyLeft(root);
        
        // first get modified & added elements by filtering target DB with our selection
        PgDatabase dbNew = new PgDbFilter2(dbTarget, root, DiffSide.RIGHT).apply();
        
        // now copy everything from source that isn't already in the new DB
        // and check if statement is in no-copy list (selected for removal)
        
        for(PgExtension ext : dbSource.getExtensions()) {
            if(dbNew.getExtension(ext.getName()) == null && !isNoCopy(ext)) {
                dbNew.addExtension(ext.shallowCopy());
            }
        }
        
        for(PgSchema schema : dbSource.getSchemas()) {
            if(isNoCopy(schema)) {
                continue;
            }
            
            PgSchema dstSchema = dbNew.getSchema(schema.getName());
            if(dstSchema == null) {
                dstSchema = schema.shallowCopy();
                dbNew.addSchema(dstSchema);
            } else {
                dbNew.tryReplacePublicDef(schema);
            }
            
            for(PgFunction func : schema.getFunctions()) {
                if(!dstSchema.containsFunction(func.getSignature()) && !isNoCopy(func)) {
                    dstSchema.addFunction(func.shallowCopy());
                }
            }
            for(PgSequence seq : schema.getSequences()) {
                if(!dstSchema.containsSequence(seq.getName()) && !isNoCopy(seq)) {
                    dstSchema.addSequence(seq.shallowCopy());
                }
            }
            for(PgView view : schema.getViews()) {
                if(!dstSchema.containsView(view.getName()) && !isNoCopy(view)) {
                    dstSchema.addView(view.shallowCopy());
                }
            }
            for(PgTable table : schema.getTables()) {
                if(isNoCopy(table)) {
                    continue;
                }
                
                PgTable dstTable = dstSchema.getTable(table.getName());
                if(dstTable == null) {
                    dstTable = table.shallowCopy();
                    dstSchema.addTable(dstTable);
                }
                
                for(PgIndex idx : table.getIndexes()) {
                    if(!dstTable.containsIndex(idx.getName()) && !isNoCopy(idx)) {
                        dstTable.addIndex(idx.shallowCopy());
                    }
                }
                for(PgTrigger trigger : table.getTriggers()) {
                    if(!dstTable.containsTrigger(trigger.getName()) && !isNoCopy(trigger)) {
                        dstTable.addTrigger(trigger.shallowCopy());
                    }
                }
                for(PgConstraint constr : table.getConstraints()) {
                    if(!dstTable.containsConstraint(constr.getName()) && !isNoCopy(constr)) {
                        dstTable.addConstraint(constr.shallowCopy());
                    }
                }
            }
        }
        
        return dbNew;
    }
    
    /**
     * Set diff root (all available changes) to be used in depcy analysis
     * 
     * @param diffTree
     */
    public void setDiffTree(TreeElement diffTree) {
        this.diffTree = diffTree;
    }
    
    private boolean isNoCopy(PgStatement statement) {
        for(PgStatement e : lstNoCopy) {
            if(e == statement) {
                return true;
            }
        }
        
        return lstNoCopy.contains(statement);
    }
    
    private void noCopyLeft(TreeElement el) {
        // skip RIGHTs
        if(el.getSide() == DiffSide.RIGHT) {
            return;
        }
        // and non-left CONTAINERs (except root)
        if(el.getSide() == DiffSide.BOTH && el.getType() == DbObjType.CONTAINER && el.getParent() != null) {
            return;
        }
        
        // add LEFT statements to no-copy list
        if(el.getSide() == DiffSide.LEFT && el.getType() != DbObjType.CONTAINER) {
            PgStatement markedToDelete = el.getPgStatement(dbSource); 
            // add marked for deletion statement
            lstNoCopy.add(markedToDelete);

            // fill in set with PgStatements that should be deleted, too
            Set<PgStatement> result = new LinkedHashSet<>(10);
            PgDiff.getDependantsSet(markedToDelete, result, depcySource.getGraph());
            
            // add all dependants, that are marked for deletion, to lstNoCopy
            for (PgStatement s : result){
                DiffSide side = getObjectSide(s, diffTree, dbSource);
                // if s is marked for deletion, add it to lstNoCopy
                if (side == DiffSide.LEFT){
                    lstNoCopy.add(s);
                }
            }
            return;
        }
        
        // recurse through BOTH statements and LEFT containers
        for(TreeElement sub : el.getChildren()) {
            noCopyLeft(sub);
        }
    }
    
    /**
     * Returns the side of <code>object</code> in <code>tree</code>, if it is present there.
     * 
     * @param object DB object that we want to know the side of
     * @param tree Diff tree, in which the search for object equivalent is performed 
     * @param db Parent database for <code>object</code>
     * @return
     */
    private DiffSide getObjectSide(PgStatement object, TreeElement tree, PgDatabase db){
        if (object.equals(tree.getPgStatement(db))){
            return tree.getSide();
        }
        for (TreeElement e : tree.getChildren()){
            DiffSide side = getObjectSide(object, e, db);
            if (side != null){
                return side;
            }
        }
        return null;
    }
}
