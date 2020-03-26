package cz.startnet.utils.pgdiff.schema.meta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.IStatement;
import cz.startnet.utils.pgdiff.schema.StatementLocation;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class MetaStatement implements IStatement, Serializable {

    private static final long serialVersionUID = 2536408124864807650L;

    private MetaStatement parent;
    private StatementLocation location;

    private final DbObjType type;
    private final String name;
    private final List<MetaStatement> children = new ArrayList<>();
    private final List<Pair<String, String>> columns = new ArrayList<>();
    private final List<Argument> arguments = new ArrayList<>();

    public MetaStatement(String name, DbObjType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public DbObjType getStatementType() {
        return type;
    }

    @Override
    public MetaStatement getParent() {
        return parent;
    }

    public List<MetaStatement> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(MetaStatement child) {
        if(child.parent != null) {
            throw new IllegalStateException(
                    "Cannot add a child that already has a parent!");
        }

        child.parent = this;
        children.add(child);
    }

    public MetaStatement getChild(String name, DbObjType type) {
        for (MetaStatement el : children) {
            if ((type == null || el.type == type) && el.name.equals(name)) {
                return el;
            }
        }

        return null;
    }

    public MetaStatement getChild(String name) {
        return getChild(name, null);
    }

    public void addColumn(Pair<String, String> col) {
        columns.add(col);
    }

    public List<Pair<String, String>> getColumns() {
        return columns;
    }

    public StatementLocation getLocation() {
        return location;
    }

    public void setLocation(StatementLocation location) {
        this.location = location;
    }

    public void addArgument(Argument arg) {
        arguments.add(arg);
    }

    public MetaStatement getCopy() {
        MetaStatement copy = new MetaStatement(name, type);
        for (MetaStatement child : getChildren()) {
            copy.addChild(child.getCopy());
        }
        return copy;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + getQualifiedName().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof MetaStatement) {
            MetaStatement other = (MetaStatement) obj;
            return Objects.equals(type, other.type)
                    && Objects.equals(location, other.location)
                    && getQualifiedName().equals(other.getQualifiedName());
        }
        return false;
    }

    @Override
    public String getQualifiedName() {
        StringBuilder sb = new StringBuilder(PgDiffUtils.getQuotedName(getName()));

        MetaStatement par = this.parent;
        while (par != null && par.getStatementType() != DbObjType.DATABASE) {
            sb.append('.').append(PgDiffUtils.getQuotedName(par.getName()));
            par = par.getParent();
        }

        return sb.toString();
    }
}
