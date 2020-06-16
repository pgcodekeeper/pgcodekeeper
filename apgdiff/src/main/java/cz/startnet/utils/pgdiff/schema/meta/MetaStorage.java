package cz.startnet.utils.pgdiff.schema.meta;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.log.Log;

public class MetaStorage implements Serializable {

    private static final long serialVersionUID = 7284212113839712191L;

    public static final String FILE_NAME = "SYSTEM_OBJECTS_";

    private static final ConcurrentMap<SupportedVersion, MetaDatabase> STORAGE_CACHE = new ConcurrentHashMap<>();

    private final List<MetaStatement> definitions = new ArrayList<>();

    public void addMetaChild(MetaStatement meta) {
        definitions.add(meta);
    }

    static MetaDatabase getObjectsFromResources(SupportedVersion ver) {
        SupportedVersion version;
        if (!SupportedVersion.VERSION_9_5.isLE(ver.getVersion())) {
            version = SupportedVersion.VERSION_9_5;
        } else {
            version = ver;
        }

        MetaDatabase db = STORAGE_CACHE.get(version);
        if (db != null) {
            return db;
        }

        try {
            String path = ApgdiffUtils.getFileFromOsgiRes(MetaStorage.class.getResource(
                    FILE_NAME + version + ".ser")).toString();
            Object object = ApgdiffUtils.deserialize(path);

            if (object instanceof MetaStorage) {
                MetaStorage storage = (MetaStorage) object;
                MetaDatabase systemStorage = new MetaDatabase();
                storage.definitions.forEach(e -> MetaUtils.addChild(systemStorage, e.getCopy()));

                MetaDatabase other = STORAGE_CACHE.putIfAbsent(version, systemStorage);
                return other == null ? systemStorage : other;
            }
        } catch (URISyntaxException | IOException e) {
            Log.log(Log.LOG_ERROR, "Error while reading systems objects from resources");
        }

        return null;
    }
}
