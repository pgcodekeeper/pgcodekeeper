package cz.startnet.utils.pgdiff.loader.jdbc;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class JsonReader {

    /**
     * Hex string with even number of chars.
     */
    private static final Pattern PATTERN_BYTEA2JSON =
            Pattern.compile("^\\\\x(?:[\\da-f]{2})*$", Pattern.CASE_INSENSITIVE);
    /**
     * Get values using local {@link #get(String)} method for proper missing key handling.
     */
    private final Map <String, Object> result;

    private JsonReader(Map<String, Object> result) {
        this.result = result;
    }

    public JsonReader(String json) throws JsonReaderException {
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        try {
            result = new Gson().fromJson(json, type);
        } catch (JsonParseException ex) {
            throw new JsonReaderException(ex.getLocalizedMessage(), ex);
        }
    }

    private Object get(String columnName) throws JsonReaderException {
        if (result.containsKey(columnName)) {
            return result.get(columnName);
        }
        throw new JsonReaderException("Column " + columnName + " doesn't exist in json/resultset!");
    }

    private Number getNumber(String columnName) throws JsonReaderException {
        Object o = get(columnName);
        return o == null ? 0 : (Number) o;
    }

    public double getDouble(String columnName) throws JsonReaderException {
        return getNumber(columnName).doubleValue();
    }

    public long getLong(String columnName) throws JsonReaderException {
        return getNumber(columnName).longValue();
    }

    public boolean getBoolean(String columnName) throws JsonReaderException {
        Object o = get(columnName);
        return o == null ? false : (boolean) o;
    }

    public String getString(String columnName) throws JsonReaderException {
        Object res = get(columnName);
        return res == null ? null : res.toString();
    }

    public float getFloat(String columnName) throws JsonReaderException {
        return getNumber(columnName).floatValue();
    }

    @SuppressWarnings("unchecked")
    public <T> T[] getArray(String columnName, Class<T> arrayElement) throws JsonReaderException {
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

    public int getInt(String columnName) throws JsonReaderException {
        return getNumber(columnName).intValue();
    }

    public byte[] getBytes(String columnName) throws JsonReaderException {
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

    public short getShort(String columnName) throws JsonReaderException {
        return getNumber(columnName).shortValue();
    }

    public static List<JsonReader> fromArray(String json) throws JsonReaderException {
        if (json == null) {
            return new ArrayList<>();
        }

        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();

        try {
            List<Map<String, Object>> stt = new Gson().fromJson(json, type);
            return stt.stream().map(JsonReader::new).collect(Collectors.toList());
        } catch (JsonParseException ex) {
            throw new JsonReaderException(ex.getLocalizedMessage(), ex);
        }
    }
}