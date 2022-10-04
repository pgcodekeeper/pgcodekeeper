package ru.taximaxim.codekeeper.core.schema;

import java.util.Collection;

public interface IDatabase extends IStatement {
    Collection<? extends ISchema> getSchemas();
    ISchema getSchema(String name);

    Collection<? extends ICast> getCasts();
    ICast getCast(String name);
}
