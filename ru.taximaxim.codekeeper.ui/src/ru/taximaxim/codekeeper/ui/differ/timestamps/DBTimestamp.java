package ru.taximaxim.codekeeper.ui.differ.timestamps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.URIUtil;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PLUGIN_ID;

public class DBTimestamp implements Serializable {

    private static final long serialVersionUID = 6207954672144447111L;

    private final List<ObjectTimestamp> objects = new ArrayList<>();

    public List<ObjectTimestamp> getObjects() {
        return objects;
    }

    public void serialize(String name) {
        serialize(name, this);
    }

    public static void serialize(String name, DBTimestamp db) {
        try {
            File folder = getInternalFolder().toFile();
            folder.mkdirs();
            File f = new File(folder.getAbsolutePath(), name + ".time");
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
                oos.writeObject(db);
                oos.flush();
            }
        } catch (IOException | URISyntaxException e) {
            Log.log(Log.LOG_DEBUG, "Error while serialize objects modification time!", e);
        }
    }

    public static DBTimestamp deserialise(String project) {
        try {
            Path path = getInternalFolder();
            Path filePath = path.resolve(project + ".time");
            if (path.toFile().exists() && filePath.toFile().exists()) {
                try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(filePath.toFile()))) {
                    return (DBTimestamp) oin.readObject();
                }
            }
        } catch (ClassCastException | ClassNotFoundException | IOException | URISyntaxException e) {
            Log.log(Log.LOG_DEBUG, "Error while read objects modification time!", e);
        }

        return null;
    }

    public static void updateObjects (PgDatabase db, String project) {
        DBTimestamp timestamp = deserialise(project);

        if (timestamp != null) {
            Map <GenericColumn, String> statements = new HashMap<>();
            db.getExtensions().forEach(e -> statements.put(
                    new GenericColumn(null, e.getName(), DbObjType.EXTENSION),
                    PgDiffUtils.sha(e.getRawStatement())));
            for (PgSchema s : db.getSchemas()) {
                s.getTypes().forEach(t -> statements.put(
                        new GenericColumn(s.getName(), t.getName(), DbObjType.TYPE),
                        PgDiffUtils.sha(t.getRawStatement())));
                s.getDomains().forEach(d -> statements.put(
                        new GenericColumn(s.getName(), d.getName(), DbObjType.DOMAIN),
                        PgDiffUtils.sha(d.getRawStatement())));
                s.getSequences().forEach(seq -> statements.put(
                        new GenericColumn(s.getName(), seq.getName(), DbObjType.SEQUENCE),
                        PgDiffUtils.sha(seq.getRawStatement())));
                s.getFunctions().forEach(f -> statements.put(
                        new GenericColumn(f.getName(), f.getName(), DbObjType.FUNCTION),
                        PgDiffUtils.sha(f.getRawStatement())));
                for (PgTable t : s.getTables()) {
                    t.getTriggers().forEach(tr -> statements.put(
                            new GenericColumn(s.getName(), tr.getName(), DbObjType.TRIGGER),
                            PgDiffUtils.sha(tr.getRawStatement())));
                    t.getRules().forEach(r -> statements.put(
                            new GenericColumn(s.getName(), r.getName(), DbObjType.RULE),
                            PgDiffUtils.sha(r.getRawStatement())));
                    statements.put(new GenericColumn(s.getName(), t.getName(), DbObjType.TABLE),
                            PgDiffUtils.sha(t.getRawStatement()));
                }
                for (PgView v : s.getViews()) {
                    v.getTriggers().forEach(tr -> statements.put(
                            new GenericColumn(s.getName(), tr.getName(), DbObjType.TRIGGER),
                            PgDiffUtils.sha(tr.getRawStatement())));
                    v.getRules().forEach(r -> statements.put(
                            new GenericColumn(s.getName(), r.getName(), DbObjType.RULE),
                            PgDiffUtils.sha(r.getRawStatement())));
                    statements.put(new GenericColumn(s.getName(), v.getName(), DbObjType.TABLE),
                            PgDiffUtils.sha(v.getRawStatement()));
                }
                statements.put(new GenericColumn(null, s.getName(), DbObjType.TYPE),
                        PgDiffUtils.sha(s.getRawStatement()));
            }

            for (Iterator<ObjectTimestamp> iterator = timestamp.getObjects().iterator(); iterator.hasNext(); ) {
                ObjectTimestamp obj = iterator.next();
                GenericColumn name = obj.getObject();
                if (!statements.containsKey(name) || !(statements.get(name).equals(obj.getHash()))) {
                    iterator.remove();
                }
            }

            serialize(project, timestamp);
        }
    }


    public void addObject (String schema, String object, DbObjType type, String hash, Instant instant) {
        objects.add(new ObjectTimestamp(new GenericColumn(schema, object, type), hash, instant));
    }

    /**
     * Returns path to %workspace%/.metadata/.plugins/%this_plugin%/projects.<br>
     *
     * @return path to folder with serialized projects
     * @throws URISyntaxException if couldn't get path to the workspace
     */
    private static Path getInternalFolder() throws URISyntaxException {
        return Paths.get(URIUtil.toURI(Platform.getInstanceLocation().getURL()))
                .resolve(".metadata").resolve(".plugins").resolve(PLUGIN_ID.THIS) //$NON-NLS-1$ //$NON-NLS-2$
                .resolve("projects"); //$NON-NLS-1$
    }

}
