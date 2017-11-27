package ru.taximaxim.codekeeper.apgdiff;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.URIUtil;

public final class ApgdiffUtils {

    /**
     * @param url url should NOT be URL-encoded
     */
    public static File getFileFromOsgiRes(URL url) throws URISyntaxException, IOException {
        return new File(
                URIUtil.toURI(url.getProtocol().equals("file") ?
                        url : FileLocator.toFileURL(url)));
    }

    /**
     * Serializes object
     *
     * @param path - path to the folder where the serialized object will be
     * @param name - file name
     * @param object - the object that you want to serialize
     */
    public static void serialize(String path, String name, Serializable object) {
        try {
            Path folderPath = Paths.get(path);
            Files.createDirectories(folderPath);
            Path filePath = Paths.get(path, name);
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(filePath))) {
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
     * @param path - full path to the serialized file
     *
     * @return deserialized object or null if not found
     */
    public static Object deserialize(String filePath) {
        try {
            Path path = Paths.get(filePath);
            if (Files.exists(path)) {
                try (ObjectInputStream oin = new ObjectInputStream(Files.newInputStream(path))) {
                    return oin.readObject();
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            Log.log(Log.LOG_DEBUG, "Error while deserialize object!", e);
        }

        return null;
    }

    private ApgdiffUtils() {
    }
}