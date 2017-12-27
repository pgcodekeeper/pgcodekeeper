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
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgSystemStorage implements Serializable {

    private static final long serialVersionUID = -5150584184929914163L;

    public static final String FILE_NAME = "SYSTEM_OBJECTS_";

    private static final ConcurrentMap<SupportedVersion, PgSystemStorage> STORAGE_CACHE = new ConcurrentHashMap<>();

    private final List<PgSystemStatement> objects = new ArrayList<>();
    private final List<PgSystemCast> casts = new ArrayList<>();

    public List<PgSystemStatement> getObjects() {
        return objects;
    }

    public void addObject(PgSystemStatement object) {
        objects.add(object);
    }

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

    public static List<PgSystemStatement> getPgSystemStatement(PgSystemStorage storage,
            DbObjType objType, String objName) {
        return storage.getObjects().stream()
                .filter(systemStmt -> objType.equals(systemStmt.getType())
                        && objName.equals(systemStmt.getName()))
                .collect(Collectors.toList());
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
}