package cz.startnet.utils.pgdiff.schema.meta;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.log.Log;

public class MetaStorage implements Serializable {

    private static final long serialVersionUID = 7284212113839712191L;

    public static final String FILE_NAME = "SYSTEM_OBJECTS_";

    private static final ConcurrentMap<SupportedVersion, MetaStorage> STORAGE_CACHE = new ConcurrentHashMap<>();

    private final List<MetaStatement> definitions = new ArrayList<>();

    public void addMetaChild(MetaStatement meta) {
        definitions.add(meta);
    }

    static List<MetaStatement> getSystemObjects(SupportedVersion version) {
        MetaStorage storage = getObjectsFromResources(version);
        return storage != null ? storage.definitions : Collections.emptyList();
    }

    private static MetaStorage getObjectsFromResources(SupportedVersion ver) {
        SupportedVersion version;
        if (!SupportedVersion.VERSION_9_6.isLE(ver.getVersion())) {
            version = SupportedVersion.VERSION_9_6;
        } else {
            version = ver;
        }

        MetaStorage db = STORAGE_CACHE.get(version);
        if (db != null) {
            return db;
        }

        try {
            Path path = ApgdiffUtils.getFileFromOsgiRes(MetaStorage.class.getResource(
                    FILE_NAME + version + ".ser"));
            Object object = ApgdiffUtils.deserialize(path);

            if (object instanceof MetaStorage) {
                MetaStorage storage = (MetaStorage) object;
                MetaStorage other = STORAGE_CACHE.putIfAbsent(version, storage);
                return other == null ? storage : other;
            }
        } catch (URISyntaxException | IOException e) {
            Log.log(Log.LOG_ERROR, "Error while reading systems objects from resources");
        }

        return null;
    }
}
