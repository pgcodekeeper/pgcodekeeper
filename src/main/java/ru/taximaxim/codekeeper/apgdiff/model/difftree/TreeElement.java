package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgView;

public class TreeElement {

    enum DbObjType {
        DATABASE,
        SCHEMA, EXTENSION,
        FUNCTION, SEQUENCE, TABLE, VIEW,
        INDEX, TRIGGER, CONSTRAINT
    }
    
    enum DiffSide {
        LEFT, RIGHT, BOTH
    }
    
    final private String name;
    
    final private DbObjType type;
    
    final private DiffSide side;
    
    private TreeElement parent;
    
    private List<TreeElement> children = new ArrayList<>();
    
    public String getName() {
        return name;
    }
    
    public DbObjType getType() {
        return type;
    }
    
    public DiffSide getSide() {
        return side;
    }
    
    public List<TreeElement> getChildren() {
        return Collections.unmodifiableList(children);
    }
    
    public TreeElement(String name, DbObjType type, DiffSide side) {
        this.name = name;
        this.type = type;
        this.side = side;
    }
    
    public TreeElement(PgStatement statement, DiffSide side) {
        this.name = statement.getName();
        this.side = side;
        
        if(statement instanceof PgSchema) {
            type = DbObjType.SCHEMA;
        } else if(statement instanceof PgExtension){
            type = DbObjType.EXTENSION;
        } else if(statement instanceof PgFunction){
            type = DbObjType.FUNCTION;
        } else if(statement instanceof PgSequence){
            type = DbObjType.SEQUENCE;
        } else if(statement instanceof PgTable){
            type = DbObjType.TABLE;
        } else if(statement instanceof PgView){
            type = DbObjType.VIEW;
        } else if(statement instanceof PgIndex){
            type = DbObjType.INDEX;
        } else if(statement instanceof PgTrigger){
            type = DbObjType.TRIGGER;
        } else if(statement instanceof PgConstraint){
            type = DbObjType.CONSTRAINT;
        } else {
            throw new IllegalArgumentException("PgStatement of unknown subtype!");
        }
    }
    
    public TreeElement getParent() {
        return parent;
    }
    
    public boolean hasChildren() {
        return !children.isEmpty();
    }
    
    public void addChild(TreeElement child) {
        if(child.parent != null) {
            throw new IllegalStateException(
                    "Cannot add a child that already has a parent!");
        }
        
        child.parent = this;
        children.add(child);
    }
    
    public TreeElement getChild(String name) {
        for(TreeElement el : children) {
            if(el.name.equals(name)) {
                return el;
            }
        }
        return null;
    }
}
