package cz.startnet.utils.pgdiff.wrappers;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class JsonResultSetWrapper implements ResultSetWrapper {

    private final Map <String, Object> result;

    public JsonResultSetWrapper (String json) throws SQLException {
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        result = new Gson().fromJson(json, type);
    }

    @Override
    public Long getLong(String columnName) throws SQLException {
        return Long.valueOf((((Double) result.get(columnName)).longValue()));
    }

    @Override
    public Boolean getBoolean(String columnName) throws SQLException {
        return (Boolean) result.get(columnName);
    }

    @Override
    public String getString(String columnName) throws SQLException {
        return (String) result.get(columnName);
    }

    @Override
    public float getFloat(String columnName) throws SQLException {
        return Float.valueOf(((Double) result.get(columnName)).floatValue());
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] getArray(String columnName, Class<T> arrayElement) throws SQLException {
        Object obj = result.get(columnName);
        if (obj == null) {
            return null;
        }

        List<?> l = (List<?>) obj;
        if (Number.class.isAssignableFrom(arrayElement)) {
            Function<Number, T> converter = getConverter(arrayElement);
            return (l).stream().map(e -> converter.apply((Number) e))
                    .toArray(i -> (T[]) Array.newInstance(arrayElement, i));
        } else {
            return (l).toArray((T[]) Array.newInstance(arrayElement, 0));
        }
    }

    @SuppressWarnings("unchecked")
    private <T> Function<Number, T> getConverter(Class<T> arrayElement) {
        if (Long.class == arrayElement) {
            return (n) -> (T) (Long) n.longValue();
        } else if (Integer.class == arrayElement) {
            return (n) -> (T) (Integer) n.intValue();
        } else {
            throw new IllegalStateException("Unknown Number subclass!");
        }
    }

    @Override
    public int getInt(String columnName) throws SQLException {
        return ((Double)result.get(columnName)).intValue();
    }

    @Override
    public byte[] getBytes(String columnName) throws SQLException {
        // we have byte array in string
        String s = (String) result.get(columnName);
        // remove /x
        s = s.substring(2);
        return hexStringToByteArray(s);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    @Override
    public short getShort(String columnName) throws SQLException {
        return ((Double)result.get(columnName)).shortValue();
    }
}