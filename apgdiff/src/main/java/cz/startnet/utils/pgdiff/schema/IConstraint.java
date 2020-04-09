package cz.startnet.utils.pgdiff.schema;

import java.util.Set;

public interface IConstraint extends IStatement {
    boolean isUnique();
    boolean isPrimaryKey();
    Set<String> getColumns();
}
