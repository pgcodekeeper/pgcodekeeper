package cz.startnet.utils.pgdiff.wrappers;

/**
 * Wrapper for ResultSet
 *
 * @author galiev_mr
 */
public interface ResultSetWrapper {

    public double getDouble(String columnName) throws WrapperAccessException;

    public long getLong(String columnName) throws WrapperAccessException;

    public boolean getBoolean(String columnName) throws WrapperAccessException;

    public String getString(String columnName) throws WrapperAccessException;

    public float getFloat(String columnName) throws WrapperAccessException;

    public <T> T[] getArray(String columnName, Class<T> array) throws WrapperAccessException;

    public int getInt(String columnName) throws WrapperAccessException;

    public byte[] getBytes(String columnName) throws WrapperAccessException;

    public short getShort(String columnName) throws WrapperAccessException;
}