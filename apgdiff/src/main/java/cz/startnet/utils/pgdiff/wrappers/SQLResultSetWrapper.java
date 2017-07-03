package cz.startnet.utils.pgdiff.wrappers;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLResultSetWrapper implements ResultSetWrapper {

    private final ResultSet rs;

    public SQLResultSetWrapper (ResultSet rs) throws SQLException {
        this.rs = rs;
    }

    @Override
    public Long getLong(String columnName) throws SQLException {
        return rs.getLong(columnName);
    }

    @Override
    public Boolean getBoolean(String columnName) throws SQLException {
        return rs.getBoolean(columnName);
    }

    @Override
    public String getString(String columnName) throws SQLException {
        return rs.getString(columnName);
    }

    @Override
    public float getFloat(String columnName) throws SQLException {
        return rs.getFloat(columnName);
    }

    @Override
    public <T> T[] getArray(String columnName, Class<T> array) throws SQLException {
        Array arr = rs.getArray(columnName);
        if (arr != null) {
            @SuppressWarnings("unchecked")
            T[] ret = (T[]) arr.getArray();
            return ret;
        }
        return null;
    }

    @Override
    public int getInt(String columnName) throws SQLException {
        return rs.getInt(columnName);
    }

    @Override
    public byte[] getBytes(String columnName) throws SQLException {
        return rs.getBytes(columnName);
    }

    @Override
    public short getShort(String columnName) throws SQLException {
        return rs.getShort(columnName);
    }
}
