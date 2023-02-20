package ru.taximaxim.codekeeper.core.schema;

public interface IPartitionTable extends IStatement {
    String getPartitionBounds();
    String getParentTable();
}
