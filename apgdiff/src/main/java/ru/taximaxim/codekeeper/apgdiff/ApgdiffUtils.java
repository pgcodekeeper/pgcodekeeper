package ru.taximaxim.codekeeper.apgdiff;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
            File folder = Paths.get(path).toFile();
            folder.mkdirs();
            File f = new File(folder.getAbsolutePath(), name);
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
                oos.writeObject(object);
                oos.flush();
            }
        } catch (IOException e) {
            Log.log(Log.LOG_DEBUG, "Error while serialize project!", e);
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
                File f = path.toFile();
                try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(f))) {
                    return oin.readObject();
                }
            }
        } catch (ClassCastException | ClassNotFoundException | IOException e) {
            Log.log(Log.LOG_DEBUG, "Error while deserialize project!", e);
        }

        return null;
    }

    private ApgdiffUtils() {
    }
}
