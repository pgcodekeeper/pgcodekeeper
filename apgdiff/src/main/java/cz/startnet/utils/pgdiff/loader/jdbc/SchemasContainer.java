package cz.startnet.utils.pgdiff.loader.jdbc;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;

import cz.startnet.utils.pgdiff.schema.PgSchema;

public class SchemasContainer implements AutoCloseable {

    final Map<Long, PgSchema> map;
    final Array oids;
    final Array names;

    public SchemasContainer(Map<Long, PgSchema> schemas, Connection connection) throws SQLException {
        this.map = schemas;

        final int size = schemas.size();
        int i = 0;
        Long[] oids = new Long[size];
        String[] names = new String[size];
        for (Entry<Long, PgSchema> entry : schemas.entrySet()) {
            oids[i] = entry.getKey();
            names[i] = entry.getValue().getName();
            ++i;
        }
        this.oids = connection.createArrayOf("bigint", oids);
        this.names = connection.createArrayOf("text", names);
    }

    @Override
    public void close() throws SQLException {
        oids.free();
        names.free();
    }
}
