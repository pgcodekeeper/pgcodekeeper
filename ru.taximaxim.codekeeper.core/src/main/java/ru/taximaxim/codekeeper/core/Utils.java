package ru.taximaxim.codekeeper.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import ru.taximaxim.codekeeper.core.log.Log;

public final class Utils {

    public static void serialize(String path, Serializable object) {
        serialize(Paths.get(path), object);
    }

    /**
     * Serializes object
     *
     * @param path - full path to file where the serialized object will be
     * @param object - the object that you want to serialize
     */
    public static void serialize(Path path, Serializable object) {
        try {
            if (Files.notExists(path)) {
                Files.createDirectories(path.getParent());
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
                oos.writeObject(object);
                oos.flush();
            }
        } catch (IOException e) {
            Log.log(Log.LOG_DEBUG, "Error while serialize object!", e);
        }
    }

    /**
     * Deserializes object
     *
     * @param inputStream
     *            - stream of serialized file
     *
     * @return deserialized object or null if not found
     */
    public static Object deserialize(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try (ObjectInputStream oin = new ObjectInputStream(inputStream)) {
            return oin.readObject();
        } catch (ClassNotFoundException | IOException e) {
            Log.log(Log.LOG_DEBUG, "Error while deserialize object!", e);
        }
        return null;
    }

    public static boolean isSystemSchema(String schema, boolean isPostgres) {
        return isPostgres ? isPgSystemSchema(schema) : isMsSystemSchema(schema);
    }

    public static boolean isPgSystemSchema(String schema) {
        return Consts.PG_CATALOG.equalsIgnoreCase(schema)
                || Consts.INFORMATION_SCHEMA.equalsIgnoreCase(schema);
    }

    public static boolean isMsSystemSchema(String schema) {
        return Consts.SYS.equalsIgnoreCase(schema);
    }

    private Utils() {
    }
}
