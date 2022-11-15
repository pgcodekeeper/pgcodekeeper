package ru.taximaxim.codekeeper.core.schema.meta;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.loader.SupportedVersion;

public class MetaStorage implements Serializable {

    private static final long serialVersionUID = 8194906497159326596L;

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
        MetaStorage db = STORAGE_CACHE.get(ver);
        if (db != null) {
            return db;
        }

        InputStream inputStream = MetaStorage.class.getResourceAsStream(FILE_NAME + ver + ".ser");

        Object object = Utils.deserialize(inputStream);
        if (object instanceof MetaStorage) {
            MetaStorage storage = (MetaStorage) object;
            MetaStorage other = STORAGE_CACHE.putIfAbsent(ver, storage);
            return other == null ? storage : other;
        }

        return null;
    }
}
