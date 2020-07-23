package cz.startnet.utils.pgdiff.schema;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public abstract class AbstractView extends PgStatementContainer {

    @Override
    public DbObjType getStatementType() {
        return DbObjType.VIEW;
    }

    public AbstractView(String name) {
        super(name);
    }

    @Override
    public void addConstraint(AbstractConstraint constraint) {
        // no op
        // throw error later?
    }

    @Override
    public AbstractConstraint getConstraint(String name) {
        return null;
    }

    @Override
    public List<AbstractConstraint> getConstraints() {
        return Collections.emptyList();
    }

    @Override
    public Stream<Pair<String, String>> getRelationColumns() {
        return Stream.empty();
    }

    @Override
    public boolean compare(PgStatement obj) {
        return this == obj || obj instanceof AbstractView && super.compare(obj);
    }

    @Override
    protected PgStatementContainer getCopy() {
        return getViewCopy();
    }

    protected abstract AbstractView getViewCopy();
}