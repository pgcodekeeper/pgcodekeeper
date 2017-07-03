package cz.startnet.utils.pgdiff.wrappers;

import java.sql.SQLException;

/**
 * Wrapper for ResultSet
 *
 * @author galiev_mr
 *
 */
public interface ResultSetWrapper {

    public Long getLong(String columnName) throws SQLException;

    public Boolean getBoolean(String columnName) throws SQLException;

    public String getString(String columnName) throws SQLException;

    public float getFloat(String columnName) throws SQLException;

    public <T> T[] getArray(String columnName, Class<T> array) throws SQLException;

    public int getInt(String columnName) throws SQLException;

    public byte[] getBytes(String columnName) throws SQLException;

    public short getShort(String columnName) throws SQLException;

}