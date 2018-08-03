/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores table index information.
 */
public abstract class AbstractIndex extends PgStatementWithSearchPath {

    private String definition;
    private String tableName;
    private boolean unique;
    private boolean clusterIndex;
    private final Set<String> columns = new HashSet<>();

    @Override
    public DbObjType getStatementType() {
        return DbObjType.INDEX;
    }

    public AbstractIndex(String name, String rawStatement) {
        super(name, rawStatement);
    }

    public void setDefinition(final String definition) {
        this.definition = definition;
        resetHash();
    }

    public String getDefinition() {
        return definition;
    }

    public void setClusterIndex(boolean value) {
        clusterIndex = value;
        resetHash();
    }

    public boolean isClusterIndex() {
        return clusterIndex;
    }

    public void addColumn(String column) {
        columns.add(column);
    }

    public Set<String> getColumns(){
        return Collections.unmodifiableSet(columns);
    }

    public void setTableName(final String tableName) {
        this.tableName = tableName;
        resetHash();
    }

    public String getTableName() {
        return tableName;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(final boolean unique) {
        this.unique = unique;
        resetHash();
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean equals = false;

        if (this == obj) {
            equals = true;
        } else if (obj instanceof AbstractIndex) {
            AbstractIndex index = (AbstractIndex) obj;
            equals = compareWithoutComments(index)
                    && Objects.equals(comment, index.getComment())
                    && Objects.equals(clusterIndex, index.isClusterIndex());
        }

        return equals;
    }

    protected boolean compareWithoutComments(AbstractIndex index) {
        return Objects.equals(definition, index.getDefinition())
                && Objects.equals(name, index.getName())
                && Objects.equals(tableName, index.getTableName())
                && unique == index.isUnique();
    }


    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(definition);
        hasher.put(name);
        hasher.put(tableName);
        hasher.put(unique);
        hasher.put(clusterIndex);
        hasher.put(comment);
    }

    @Override
    public AbstractIndex shallowCopy() {
        AbstractIndex indexDst = getIndexCopy();
        indexDst.setDefinition(getDefinition());
        indexDst.setTableName(getTableName());
        indexDst.setUnique(isUnique());
        indexDst.setClusterIndex(isClusterIndex());
        indexDst.setComment(getComment());
        indexDst.deps.addAll(deps);
        indexDst.columns.addAll(columns);
        return indexDst;
    }

    protected abstract AbstractIndex getIndexCopy();

    @Override
    public AbstractIndex deepCopy() {
        return shallowCopy();
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent().getParent();
    }
}
