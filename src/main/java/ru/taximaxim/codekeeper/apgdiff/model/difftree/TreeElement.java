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

    public enum DbObjType {
        CONTAINER, // not a DB object, just a container for further tree elements
        DATABASE,
        SCHEMA, EXTENSION,
        FUNCTION, SEQUENCE, TABLE, VIEW,
        INDEX, TRIGGER, CONSTRAINT
    }
    
    public enum DiffSide {
        LEFT, RIGHT, BOTH
    }
    
    final private String name;
    
    final private DbObjType type;
    
    final private DbObjType containerType;
    
    final private DiffSide side;
    
    private TreeElement parent;
    
    private List<TreeElement> children = new ArrayList<>();
    
    public String getName() {
        return name;
    }
    
    public DbObjType getType() {
        return type;
    }
    
    public DbObjType getContainerType() {
        return containerType;
    }
    
    public DiffSide getSide() {
        return side;
    }
    
    public List<TreeElement> getChildren() {
        return Collections.unmodifiableList(children);
    }
    
    public TreeElement getParent() {
        return parent;
    }
    
    public TreeElement(String name, DbObjType type, DbObjType containerType,
            DiffSide side) {
        this.name = name;
        this.type = type;
        this.containerType = containerType;
        this.side = side;
    }
    
    public TreeElement(PgStatement statement, DiffSide side) {
        this.name = statement.getName();
        this.side = side;
        this.containerType = null;
        
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
    
    public static TreeElement createContainer(DbObjType containerType, DiffSide side) {
        String name = null;
        switch(containerType) {
        case CONTAINER:
            name = "<Container>";
            break;
        case DATABASE:
            name = "Databases";
            break;
        case EXTENSION:
            name = "Extensions";
            break;
        case SCHEMA:
            name = "Schemas";
            break;
        case FUNCTION:
            name = "Functions";
            break;
        case SEQUENCE:
            name = "Sequences";
            break;
        case VIEW:
            name = "Views";
            break;
        case TABLE:
            name = "Tables";
            break;
        case INDEX:
            name = "Indexes";
            break;
        case TRIGGER:
            name = "Triggers";
            break;
        case CONSTRAINT:
            name = "Constraints";
            break;
        }
        return new TreeElement(name, DbObjType.CONTAINER, containerType, side);
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
    
    public void addChildNotEmpty(TreeElement container) {
        if(!container.hasChildren()) {
            return;
        }
        
        addChild(container);
    }
    
    public TreeElement getChild(String name, DbObjType type) {
        for(TreeElement el : children) {
            if((type == null || el.type == type) && el.name.equals(name)) {
                return el;
            }
        }
        
        return null;
    }
    
    public TreeElement getChild(String name) {
        return getChild(name, null);
    }
    
    public TreeElement getChild(int index) {
        return children.get(index);
    }
    
    public int countDescendants() {
        int descendants = 0;
        for(TreeElement sub : children) {
            if(sub.getType() != DbObjType.CONTAINER) {
                descendants++;
            }
            descendants += sub.countDescendants();
        }
        
        return descendants;
    }
}
