package cz.startnet.utils.pgdiff.wrappers;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLResultSetWrapper implements ResultSetWrapper {

    private final ResultSet rs;

    public SQLResultSetWrapper (ResultSet rs) {
        this.rs = rs;
    }

    @Override
    public double getDouble(String columnName) throws WrapperAccessException {
        try {
            return rs.getDouble(columnName);
        } catch (SQLException ex) {
            throw new WrapperAccessException(ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public long getLong(String columnName) throws WrapperAccessException {
        try {
            return rs.getLong(columnName);
        } catch (SQLException ex) {
            throw new WrapperAccessException(ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public boolean getBoolean(String columnName) throws WrapperAccessException {
        try {
            return rs.getBoolean(columnName);
        } catch (SQLException ex) {
            throw new WrapperAccessException(ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public String getString(String columnName) throws WrapperAccessException {
        try {
            return rs.getString(columnName);
        } catch (SQLException ex) {
            throw new WrapperAccessException(ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public float getFloat(String columnName) throws WrapperAccessException {
        try {
            return rs.getFloat(columnName);
        } catch (SQLException ex) {
            throw new WrapperAccessException(ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public <T> T[] getArray(String columnName, Class<T> arrayElement) throws WrapperAccessException {
        try {
            Array arr = rs.getArray(columnName);
            if (arr != null) {
                @SuppressWarnings("unchecked")
                T[] ret = (T[]) arr.getArray();
                return ret;
            }
            return null;
        } catch (SQLException ex) {
            throw new WrapperAccessException(ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public int getInt(String columnName) throws WrapperAccessException {
        try {
            return rs.getInt(columnName);
        } catch (SQLException ex) {
            throw new WrapperAccessException(ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public byte[] getBytes(String columnName) throws WrapperAccessException {
        try {
            return rs.getBytes(columnName);
        } catch (SQLException ex) {
            throw new WrapperAccessException(ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public short getShort(String columnName) throws WrapperAccessException {
        try {
            return rs.getShort(columnName);
        } catch (SQLException ex) {
            throw new WrapperAccessException(ex.getLocalizedMessage(), ex);
        }
    }
}
