package ru.taximaxim.codekeeper.apgdiff.model.difftree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.ListGeneratorPredicate.ADD_STATUS;

/**
 * служит оберткой для объектов БД, представляет состояние объекта между старой
 * и новой БД
 */
public class TreeElement {

    public abstract static class ListGeneratorPredicate {

        public enum ADD_STATUS {
            ADD, ADD_SUBTREE, SKIP_THIS, SKIP_SUBTREE
        }

        public ADD_STATUS parentStatus = ADD_STATUS.ADD;
        public TreeElement parentElement = null;

        public abstract ADD_STATUS shouldAddToList(TreeElement el);
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

    private final List<TreeElement> children = new ArrayList<>();

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
        if (child.parent != null) {
            throw new IllegalStateException(
                    "Cannot add a child that already has a parent!");
        }

        child.parent = this;
        child.hashcode = 0;
        children.add(child);
    }

    public TreeElement getChild(String name, DbObjType type) {
        for (TreeElement el : children) {
            if ((type == null || el.type == type) && el.name.equals(name)) {
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
        for (TreeElement sub : children) {
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
        switch (type) {
        // container (if root) and database end recursion
        // if container is not root - just pass through it
        case DATABASE:
            return db;

        // other elements just get from their parent, and their parent from a parent above them etc
        case EXTENSION:
            return ((PgDatabase) parent.getPgStatement(db)).getExtension(name);
        case SCHEMA:
            return ((PgDatabase) parent.getPgStatement(db)).getSchema(name);

        case FUNCTION:
            return ((PgSchema) parent.getPgStatement(db)).getFunction(name);
        case SEQUENCE:
            return ((PgSchema) parent.getPgStatement(db)).getSequence(name);
        case TYPE:
            return ((PgSchema) parent.getPgStatement(db)).getType(name);
        case DOMAIN:
            return ((PgSchema) parent.getPgStatement(db)).getDomain(name);
        case VIEW:
            return ((PgSchema) parent.getPgStatement(db)).getView(name);
        case TABLE:
            return ((PgSchema) parent.getPgStatement(db)).getTable(name);

        case INDEX:
            return ((PgTable) parent.getPgStatement(db)).getIndex(name);
        case TRIGGER:
            return ((PgTable) parent.getPgStatement(db)).getTrigger(name);
        case CONSTRAINT:
            return ((PgTable) parent.getPgStatement(db)).getConstraint(name);
        case COLUMN:
            return ((PgTable) parent.getPgStatement(db)).getColumn(name);
        case RULE:
            switch (parent.getType()) {
            case TABLE:
                return ((PgTable) parent.getPgStatement(db)).getRule(name);
            case VIEW:
                return ((PgView) parent.getPgStatement(db)).getRule(name);
            default:
                throw new IllegalStateException("Illegal RULE parent: " + type);
            }

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
     * создает коллекцию с измененными элементами
     */
    public Collection<TreeElement> flattenAlteredElements(Collection<TreeElement> result,
            PgDatabase dbSource, PgDatabase dbTarget, boolean onlySelected,
            ListGeneratorPredicate predicate) {
        ADD_STATUS addStatus = ADD_STATUS.ADD;
        if (predicate != null) {
            addStatus = predicate.shouldAddToList(this);
        }
        if (addStatus == ADD_STATUS.SKIP_SUBTREE) {
            return result;
        }

        if (addStatus == ADD_STATUS.ADD_SUBTREE) {
            predicate.parentStatus = ADD_STATUS.ADD_SUBTREE;
            predicate.parentElement = this;
        }

        for (TreeElement child : getChildren()) {
            child.flattenAlteredElements(result, dbSource, dbTarget, onlySelected, predicate);
        }

        if (predicate != null && predicate.parentElement == this) {
            predicate.parentStatus = ADD_STATUS.ADD;
        }

        boolean canCompareEdits = side == DiffSide.BOTH && dbSource != null && dbTarget != null;
        if ((onlySelected && !selected)
                || type == DbObjType.DATABASE
                || addStatus == ADD_STATUS.SKIP_THIS
                || canCompareEdits && getPgStatement(dbSource).compare(getPgStatement(dbTarget))) {
            return result;
        }

        result.add(this);
        return result;
    }

    /**
     * Создает копию элементов начиная с текущего, у которых стороны перевернуты:
     * left -> right, right -> left, both->both
     */
    public TreeElement getRevertedCopy() {
        TreeElement copy = getRevertedElement();
        for (TreeElement child : getChildren()) {
            copy.addChild(child.getRevertedCopy());
        }
        return copy;
    }

    /**
     * возвращает копию элемента с измененными сторонами
     */
    private TreeElement getRevertedElement() {
        DiffSide newSide = null;
        switch (side) {
        case BOTH:
            newSide = DiffSide.BOTH;
            break;
        case LEFT:
            newSide = DiffSide.RIGHT;
            break;
        case RIGHT:
            newSide = DiffSide.LEFT;
            break;
        }
        TreeElement copy = new TreeElement(name, type, newSide);
        copy.setSelected(selected);
        return copy;
    }

    /**
     * Принимает дерево и выбирает из него все выбранные элементы
     * @param root дерево
     * @param result список с выбранными элементами
     */
    public static void getSelected(TreeElement root, List<TreeElement> result) {
        if (root.isSelected()) {
            result.add(root);
        }
        for (TreeElement child : root.getChildren()) {
            getSelected(child, result);
        }
    }

    /**
     * начиная от текущего отмечает все элементы
     */
    public void setAllChecked() {
        setSelected(true);
        for (TreeElement child : getChildren()) {
            child.setAllChecked();
        }
    }

    /**
     * @return признак наличия выбранных элементов в поддереве начиная с текущего узла
     */
    public boolean isSubTreeSelected() {
        for (TreeElement child : getChildren()) {
            if (child.isSubTreeSelected()) {
                return true;
            }
        }
        return isSelected();
    }

    @Override
    public int hashCode() {
        if (hashcode == 0) {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + ((side == null) ? 0 : side.hashCode());
            result = prime * result + ((type == null) ? 0 : type.hashCode());
            result = prime * result + getContainerQName().hashCode();

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
        } else if (obj instanceof TreeElement) {
            TreeElement other = (TreeElement) obj;
            return Objects.equals(name, other.getName())
                    && Objects.equals(type, other.getType())
                    && Objects.equals(side, other.getSide())
                    && getContainerQName().equals(other.getContainerQName());
        }
        return false;
    }

    public String getContainerQName() {
        String qname = "";

        TreeElement par = this.parent;
        while (par != null) {
            if (par.getType() == DbObjType.DATABASE) {
                break;
            }
            qname = PgDiffUtils.getQuotedName(par.getName())
                    + (qname.isEmpty() ? qname : '.' + qname);
            par = par.getParent();
        }

        return qname;
    }

    /**
     * Note: the name of the object itself is not quoted due to it including function parameters.
     * @return this element's qualified name
     */
    public String getQualifiedName() {
        String qname = getContainerQName();
        return qname.isEmpty() ? getName() : qname + '.' + getName();
    }

    @Override
    public String toString() {
        return getName() == null ? "no name" : getName() + " " + side + " " + type;
    }

    /**
     * устанавливает родителя, использовать только в случае с колонки, создается
     * связь для получения объекта из базы в одну сторону
     */
    @Deprecated
    public void setParent(TreeElement el) {
        this.parent = el;
    }
}
