package cz.startnet.utils.pgdiff.wrappers;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class JsonResultSetWrapper implements ResultSetWrapper {

    /**
     * Hex string with even number of chars.
     */
    private static final Pattern PATTERN_BYTEA2JSON =
            Pattern.compile("^\\\\x(?:[\\da-f]{2})*$", Pattern.CASE_INSENSITIVE);
    /**
     * Get values using local {@link #get(String)} method for proper missing key handling.
     */
    private final Map <String, Object> result;

    public JsonResultSetWrapper (String json) throws WrapperAccessException {
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        try {
            result = new Gson().fromJson(json, type);
        } catch (JsonParseException ex) {
            throw new WrapperAccessException(ex.getLocalizedMessage(), ex);
        }
    }

    private Object get(String columnName) throws WrapperAccessException {
        if (result.containsKey(columnName)) {
            return result.get(columnName);
        }
        throw new WrapperAccessException("Column " + columnName + " doesn't exist in json/resultset!");
    }

    private Number getNumber(String columnName) throws WrapperAccessException {
        Object o = get(columnName);
        return o == null ? 0 : (Number) o;
    }

    @Override
    public double getDouble(String columnName) throws WrapperAccessException {
        return getNumber(columnName).doubleValue();
    }

    @Override
    public long getLong(String columnName) throws WrapperAccessException {
        return getNumber(columnName).longValue();
    }

    @Override
    public boolean getBoolean(String columnName) throws WrapperAccessException {
        Object o = get(columnName);
        return o == null ? false : (boolean) o;
    }

    @Override
    public String getString(String columnName) throws WrapperAccessException {
        Object res = get(columnName);
        return res == null ? null : res.toString();
    }

    @Override
    public float getFloat(String columnName) throws WrapperAccessException {
        return getNumber(columnName).floatValue();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] getArray(String columnName, Class<T> arrayElement) throws WrapperAccessException {
        Object obj = get(columnName);
        if (obj == null) {
            return null;
        }

        if (Number.class.isAssignableFrom(arrayElement)) {
            return ((List<Number>) obj).stream()
                    .map(getConverter(arrayElement))
                    .toArray(i -> (T[]) Array.newInstance(arrayElement, i));
        } else {
            return ((List<?>) obj).toArray((T[]) Array.newInstance(arrayElement, 0));
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
    public int getInt(String columnName) throws WrapperAccessException {
        return getNumber(columnName).intValue();
    }

    @Override
    public byte[] getBytes(String columnName) throws WrapperAccessException {
        // we have byte array in string: \x001122ff...
        String s = (String) get(columnName);
        if (PATTERN_BYTEA2JSON.matcher(s).matches()) {
            // remove \x
            s = s.substring(2);
            return hexStringToByteArray(s);
        } else {
            throw new IllegalStateException("Unknown bytea2json serialization format!");
        }
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    | Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    @Override
    public short getShort(String columnName) throws WrapperAccessException {
        return getNumber(columnName).shortValue();
    }

    public static List<JsonResultSetWrapper> getWrappersList(String json) throws WrapperAccessException {
        List <JsonResultSetWrapper> wrappers = new ArrayList<>();

        for (String st : json.split(",")) {
            wrappers.add(new JsonResultSetWrapper(st));
        }

        return wrappers;
    }
}