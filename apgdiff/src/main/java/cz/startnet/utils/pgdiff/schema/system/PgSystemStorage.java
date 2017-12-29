package cz.startnet.utils.pgdiff.schema.system;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.Log;

public class PgSystemStorage implements Serializable {

    private static final long serialVersionUID = -5150584184929914163L;

    public static final String FILE_NAME = "SYSTEM_OBJECTS_";
    public static final String SCHEMA_PG_CATALOG = "pg_catalog";
    public static final String SCHEMA_INFORMATION_SCHEMA = "information_schema";

    private static final ConcurrentMap<SupportedVersion, PgSystemStorage> STORAGE_CACHE = new ConcurrentHashMap<>();

    private final List<PgSystemCast> casts = new ArrayList<>();
    private final PgSystemSchema pgCatalogSchema = new PgSystemSchema(SCHEMA_PG_CATALOG);
    private final PgSystemSchema informationSchema = new PgSystemSchema(SCHEMA_INFORMATION_SCHEMA);

    public List<PgSystemCast> getCasts() {
        return casts;
    }

    public void addCast(PgSystemCast cast) {
        casts.add(cast);
    }

    public static PgSystemStorage getObjectsFromResources(SupportedVersion version) {
        PgSystemStorage systemStorage = STORAGE_CACHE.get(version);
        if (systemStorage != null) {
            return systemStorage;
        }

        try {
            String path = ApgdiffUtils.getFileFromOsgiRes(PgSystemStorage.class.getResource(
                    FILE_NAME + version + ".ser")).toString();
            Object object = ApgdiffUtils.deserialize(path);

            if (object != null && object instanceof PgSystemStorage) {
                systemStorage = (PgSystemStorage) object;
                PgSystemStorage other = STORAGE_CACHE.putIfAbsent(version, systemStorage);
                return other == null ? systemStorage : other;
            }
        } catch (URISyntaxException | IOException e) {
            Log.log(Log.LOG_ERROR, "Error while reading systems objects from resources");
        }

        return null;
    }

    /**
     *  Returns the {@link cz.startnet.utils.pgdiff.schema.system.PgSystemCast#type context of the cast}
     *  between two types.
     */
    public static String getCastContext(PgSystemStorage storage, String source, String target) {
        for (PgSystemCast cast : storage.getCasts().stream()
                .filter(c -> CastContext.I.equals(c.getType()))
                .collect(Collectors.toList())) {
            if (source.equals(cast.getSource()) && target.equals(cast.getTarget())) {
                return cast.getType();
            }
        }

        return null;
    }

    public PgSystemSchema getSchema(String schemaName) {
        if (SCHEMA_PG_CATALOG.equals(schemaName)) {
            return pgCatalogSchema;
        } else if (SCHEMA_INFORMATION_SCHEMA.equals(schemaName)) {
            return informationSchema;
        }
        throw new RuntimeException("Unknown schema name");
    }
}