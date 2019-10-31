/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores table index information.
 */
public abstract class AbstractIndex extends PgStatementWithSearchPath
implements PgOptionContainer {

    /**
     * Contains columns with sort order
     */
    private String definition;
    private String where;
    private String tablespace;
    private boolean unique;
    private boolean clusterIndex;

    private final Set<String> columns = new HashSet<>();

    protected final Set<String> includes = new LinkedHashSet<>();
    protected final Map<String, String> options = new LinkedHashMap<>();

    @Override
    public DbObjType getStatementType() {
        return DbObjType.INDEX;
    }

    public AbstractIndex(String name) {
        super(name);
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

    public void addInclude(String column) {
        includes.add(column);
    }

    public Set<String> getIncludes(){
        return Collections.unmodifiableSet(includes);
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(final boolean unique) {
        this.unique = unique;
        resetHash();
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(final String where) {
        this.where = where;
        resetHash();
    }

    public String getTablespace() {
        return tablespace;
    }

    public void setTablespace(String tableSpace) {
        this.tablespace = tableSpace;
        resetHash();
    }

    @Override
    public Map<String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    @Override
    public void addOption(String key, String value) {
        options.put(key, value);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof AbstractIndex && super.compare(obj)) {
            AbstractIndex index = (AbstractIndex) obj;
            return compareUnalterable(index)
                    && clusterIndex == index.isClusterIndex()
                    && Objects.equals(tablespace, index.getTablespace())
                    && Objects.equals(options, index.options);
        }

        return false;
    }

    protected boolean compareUnalterable(AbstractIndex index) {
        return Objects.equals(definition, index.getDefinition())
                && Objects.equals(where, index.getWhere())
                && Objects.equals(includes, index.includes)
                && unique == index.isUnique();
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(definition);
        hasher.put(unique);
        hasher.put(clusterIndex);
        hasher.put(where);
        hasher.put(tablespace);
        hasher.put(options);
        hasher.put(includes);
    }

    @Override
    public AbstractIndex shallowCopy() {
        AbstractIndex indexDst = getIndexCopy();
        copyBaseFields(indexDst);
        indexDst.setDefinition(getDefinition());
        indexDst.setUnique(isUnique());
        indexDst.setClusterIndex(isClusterIndex());
        indexDst.setWhere(getWhere());
        indexDst.setTablespace(getTablespace());
        indexDst.columns.addAll(columns);
        indexDst.options.putAll(options);
        indexDst.includes.addAll(includes);
        return indexDst;
    }

    protected abstract AbstractIndex getIndexCopy();

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) getParent().getParent();
    }
}
