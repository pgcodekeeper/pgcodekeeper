package cz.startnet.utils.pgdiff.schema;

import java.util.Collection;

public interface IDatabase {
    Collection<? extends ISchema> getSchemas();
    ISchema getSchema(String name);
}
