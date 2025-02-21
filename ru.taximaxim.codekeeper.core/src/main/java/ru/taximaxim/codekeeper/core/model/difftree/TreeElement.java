/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.model.difftree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.IStatementContainer;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

/**
 * служит оберткой для объектов БД, представляет состояние объекта между старой
 * и новой БД
 */
public final class TreeElement {

    public enum DiffSide {
        LEFT, RIGHT, BOTH;
    }

    private int hashcode;
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
            throw new IllegalStateException("Cannot add a child that already has a parent!");
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
     * Gets corresponding {@link PgStatement} from {@link AbstractDatabase}.
     */
    public PgStatement getPgStatement(AbstractDatabase db) {
        if (type == DbObjType.DATABASE) {
            return db;
        }
        PgStatement stParent = parent.getPgStatement(db);
        if (stParent == null) {
            throw new IllegalArgumentException("No statement found for " + parent);
        }
        if (type == DbObjType.COLUMN) {
            return ((AbstractTable) stParent).getColumn(name);
        }
        if (stParent instanceof IStatementContainer cont) {
            return cont.getChild(name, type);
        }

        return null;
    }

    /**
     * @return Statement from the corresponding DB, based on client's side. BOTH
     *         uses left.
     */
    public PgStatement getPgStatementSide(AbstractDatabase left, AbstractDatabase right) {
        switch (side) {
        case LEFT, BOTH:
            return getPgStatement(left);
        case RIGHT:
            return getPgStatement(right);
        default:
            return null;
        }
    }

    /**
     * Ищет элемент в дереве
     */
    public TreeElement findElement(PgStatement st) {
        if (st.getStatementType() == DbObjType.DATABASE) {
            TreeElement root = this;
            while (root.parent != null) {
                root = root.parent;
            }
            return root;
        }
        TreeElement par = findElement(st.getParent());
        return par == null ? null : par.getChild(st.getName(), st.getStatementType());
    }

    /**
     * Создает копию элементов начиная с текущего, у которых стороны перевернуты:
     * {@code left -> right, right -> left, both -> both}
     */
    public TreeElement getRevertedCopy() {
        TreeElement copy = getRevertedElement();
        for (TreeElement child : children) {
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
     * Создает копию элементов начиная с текущего
     */
    public TreeElement getCopy() {
        TreeElement copy = new TreeElement(name, type, side);
        copy.setSelected(selected);
        for (TreeElement child : children) {
            copy.addChild(child.getCopy());
        }
        return copy;
    }

    /**
     * начиная от текущего отмечает все элементы
     */
    public void setAllChecked() {
        setSelected(true);
        for (TreeElement child : children) {
            child.setAllChecked();
        }
    }

    /**
     * @return признак наличия выбранных элементов в поддереве начиная с текущего
     *         узла
     */
    public boolean isSubTreeSelected() {
        for (TreeElement child : children) {
            if (child.isSubTreeSelected()) {
                return true;
            }
        }
        return selected;
    }

    public boolean isContainer() {
        return type.in(DbObjType.TABLE, DbObjType.VIEW);
    }

    public boolean isSubElement() {
        return parent != null && parent.isContainer();
    }

    @Override
    public int hashCode() {
        if (hashcode == 0) {
            int result = Objects.hash(name, side, type, getContainerQName());
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
        }

        return obj instanceof TreeElement other
                && Objects.equals(name, other.name)
                && type == other.type
                && side == other.side 
                && getContainerQName().equals(other.getContainerQName());
    }

    public String getContainerQName() {
        var qname = "";

        TreeElement par = this.parent;
        while (par != null) {
            if (par.type == DbObjType.DATABASE) {
                break;
            }
            qname = par.name + (qname.isEmpty() ? qname : '.' + qname);
            par = par.parent;
        }

        return qname;
    }

    /**
     * Note: the name of the object itself is not quoted due to it including
     * function parameters.
     * 
     * @return this element's qualified name
     */
    public String getQualifiedName() {
        String qname = getContainerQName();
        return qname.isEmpty() ? name : qname + '.' + name;
    }

    @Override
    public String toString() {
        return name == null ? "no name" : name + ' ' + side + ' ' + type;
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
