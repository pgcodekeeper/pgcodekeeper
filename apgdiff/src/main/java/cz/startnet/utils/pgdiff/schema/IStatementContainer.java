package cz.startnet.utils.pgdiff.schema;

import java.util.Collection;

public interface IStatementContainer extends IRelation {
    Collection<? extends IConstraint> getConstraints();
}
