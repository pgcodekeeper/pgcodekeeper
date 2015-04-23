package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;

/**
 * служит оберткой для объектов БД, представляет состояние объекта между старой
 * и новой БД
 */
public class TreeElement {

    public enum DbObjType {
        DATABASE,
        SCHEMA, EXTENSION,
        TYPE, DOMAIN, FUNCTION, SEQUENCE, TABLE, VIEW,
        INDEX, TRIGGER, CONSTRAINT, COLUMN
    }
    
    public enum DiffSide {
        LEFT("delete"), RIGHT("new"), BOTH("edit");
        private String changeType;

        private DiffSide(String changeType) {
            this.changeType = changeType;
        }
        
        @Override
        public String toString() {
            return changeType;
        }
    }
    
    private volatile int hashcode;
    
    private final String name;
    
    private final DbObjType type;
    
    private final DiffSide side;
    
    private boolean selected;
    
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
    
    public TreeElement getParent() {
        return parent;
    }
    
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public TreeElement(String name, DbObjType type, DiffSide side) {
        this.name = name;
        this.type = type;
        this.side = side;
    }
    
    public TreeElement(PgStatement statement, DiffSide side) {
        this.name = statement.getName();
        this.side = side;
        this.type = statement.getStatementType();
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
        child.hashcode = 0;
        children.add(child);
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
            descendants++;
            descendants += sub.countDescendants();
        }
        
        return descendants;
    }
    
    public int countChildren() {
        return children.size();
    }
    
    /**
     * Gets corresponding {@link PgStatement} from Database model.
     * 
     * @param db
     * @return
     */
    public PgStatement getPgStatement(PgDatabase db) {
        switch(type) {
        // container (if root) and database end recursion
        // if container is not root - just pass through it
        case DATABASE:   return db;
        
        // other elements just get from their parent, and their parent from a parent above them etc
        case EXTENSION:  return ((PgDatabase) parent.getPgStatement(db)).getExtension(name);
        case SCHEMA:     return ((PgDatabase) parent.getPgStatement(db)).getSchema(name);
        
        case FUNCTION:   return ((PgSchema) parent.getPgStatement(db)).getFunction(name);
        case SEQUENCE:   return ((PgSchema) parent.getPgStatement(db)).getSequence(name);
        case TYPE:          return ((PgSchema) parent.getPgStatement(db)).getType(name);
        case DOMAIN:      return ((PgSchema) parent.getPgStatement(db)).getDomain(name);
        case VIEW:       return ((PgSchema) parent.getPgStatement(db)).getView(name);
        case TABLE:      return ((PgSchema) parent.getPgStatement(db)).getTable(name);
        
        case INDEX:      return ((PgTable) parent.getPgStatement(db)).getIndex(name);
        case TRIGGER:    return ((PgTable) parent.getPgStatement(db)).getTrigger(name);
        case CONSTRAINT: return ((PgTable) parent.getPgStatement(db)).getConstraint(name);
        default:
            throw new IllegalStateException("Unknown element type: " + type);
        }
    }
    
    /**
     * Ищет элемент в дереве
     * @param st
     * @return
     */
    public TreeElement findElement(PgStatement st) {
        if (st.getStatementType() == DbObjType.DATABASE) {
            TreeElement root = this;
            while (root.parent != null) {
                root = root.parent;
            }
            return root;
        }
        TreeElement parent = findElement(st.getParent());
        return parent == null ? null : parent.getChild(st.getName(), st.getStatementType());
    }
    /**
     * создает список с измененными элементами
     * @param result
     * @param dbSource
     * @param dbTarget
     * @return
     */
    public List<TreeElement> generateElementsList(List<TreeElement> result, 
            PgDatabase dbSource, PgDatabase dbTarget) {
        for (TreeElement child : getChildren()) {
            child.generateElementsList(result, dbSource, dbTarget);
        }
        
        boolean shouldCompareEdits = side == DiffSide.BOTH && dbSource != null && dbTarget != null;
        if ((side == DiffSide.BOTH && parent != null && parent.getSide() != DiffSide.BOTH)
                || type == DbObjType.DATABASE 
                || shouldCompareEdits && getPgStatement(dbSource).compare(getPgStatement(dbTarget))) {
            return result;
        }
        
        result.add(this);
        return result;
    }
    
    /**
     * Принимает дерево и выбирает из него все выбранные элементы
     * @param root дерево
     * @param result список с выбранными элементами
     */
    public static void getSelected(TreeElement root, List<TreeElement> result){
        if (root.isSelected()) {
            result.add(root);
        }
        for (TreeElement child : root.getChildren()) {
            getSelected(child, result);
        }
    }
    
    /**
     * Recursively walk a tree, copying nodes that exist in filterSubset to returned tree.
     * Important: filterSubset should be a subset of this tree
     * (because TreeElement equals method compares references of parents)
     */
    public TreeElement getFilteredCopy(Set<TreeElement> filterSubset){
        TreeElement copy = null;
        for(TreeElement e : children) {
            TreeElement child = e.getFilteredCopy(filterSubset);
            
            if (child != null) {
                if (copy == null){
                    copy = new TreeElement(getName(), getType(), getSide());
                }
                copy.addChild(child);
            }
        }
        
        if (copy == null && filterSubset.contains(this)){
            copy = new TreeElement(getName(), getType(), getSide());
        }
        return copy;
    }
    
    @Override
    public int hashCode() {
        if (hashcode == 0) {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + ((side == null) ? 0 : side.hashCode());
            result = prime * result + ((type == null) ? 0 : type.hashCode());
            result = prime * result + System.identityHashCode(parent);
            
            if (result == 0) {
                ++result;
            }
            hashcode = result;
        }
        
        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }else if(obj instanceof TreeElement) {
            TreeElement other = (TreeElement) obj;
            return Objects.equals(name, other.getName())
                    && Objects.equals(type, other.getType())
                    && Objects.equals(side, other.getSide())
                    && this.parent == other.parent;
        }
        return false;
    }
    @Override
    public String toString() {
        return getName() == null ? "no name" : getName();
    }
}
