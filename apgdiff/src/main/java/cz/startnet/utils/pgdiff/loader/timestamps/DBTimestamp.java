package cz.startnet.utils.pgdiff.loader.timestamps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class DBTimestamp implements Serializable {

    private static final long serialVersionUID = 6207954672144447111L;

    // FIXME don't bind to UI module
    private static final String FOLDER = "ru.taximaxim.codekeeper.ui";

    private final List<ObjectTimestamp> objects = new ArrayList<>();

    private static final Map<String, DBTimestamp> PROJ_TIMESTAMPS = new HashMap<>();

    public List<ObjectTimestamp> getObjects() {
        return objects;
    }

    public void addObject(ObjectTimestamp obj) {
        objects.add(obj);
    }

    public static void serialize(String name, DBTimestamp db) {
        try {
            File folder = getInternalFolder(name);
            folder.getParentFile().mkdirs();
            Path filePath = Paths.get(folder.getAbsolutePath());
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(filePath))) {
                oos.writeObject(db);
                oos.flush();
            }
        } catch (IOException | URISyntaxException e) {
            Log.log(Log.LOG_DEBUG, "Error while serialize objects modification!", e);
        }
    }

    public static DBTimestamp deserialise(String project) {
        try {
            File file = getInternalFolder(project);
            if (file.exists()) {
                try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file))) {
                    return (DBTimestamp) oin.readObject();
                }
            }
        } catch (ClassCastException | ClassNotFoundException | IOException | URISyntaxException e) {
            Log.log(Log.LOG_DEBUG, "Error while read objects modification time!", e);
        }

        return null;
    }

    public static void updateObjects (PgDatabase db, String project) {
        DBTimestamp timestamp = getDBTimastamp(project);
        if (!timestamp.objects.isEmpty()) {
            Map<GenericColumn, String> statements = new HashMap<>();
            db.getExtensions().forEach(e -> statements.put(
                    new GenericColumn(e.getName(), DbObjType.EXTENSION),
                    PgDiffUtils.sha(e.getRawStatement())));
            for (PgSchema s : db.getSchemas()) {
                s.getTypes().forEach(t -> statements.put(
                        new GenericColumn(s.getName(), t.getName(), DbObjType.TYPE),
                        PgDiffUtils.sha(t.getRawStatement())));
                s.getDomains().forEach(d -> statements.put(
                        new GenericColumn(s.getName(), d.getName(), DbObjType.TYPE),
                        PgDiffUtils.sha(d.getRawStatement())));
                s.getSequences().forEach(seq -> statements.put(
                        new GenericColumn(s.getName(), seq.getName(), DbObjType.SEQUENCE),
                        PgDiffUtils.sha(seq.getRawStatement())));
                s.getFunctions().forEach(f -> statements.put(
                        new GenericColumn(s.getName(), f.getName(), DbObjType.FUNCTION),
                        PgDiffUtils.sha(f.getRawStatement())));
                for (PgTable t : s.getTables()) {
                    t.getIndexes().forEach(i -> statements.put(
                            new GenericColumn(s.getName(), null, i.getName(), DbObjType.INDEX),
                            PgDiffUtils.sha(i.getRawStatement())));
                    t.getTriggers().forEach(tr -> statements.put(
                            new GenericColumn(s.getName(), t.getName(), tr.getName(), DbObjType.TRIGGER),
                            PgDiffUtils.sha(tr.getRawStatement())));
                    t.getRules().forEach(r -> statements.put(
                            new GenericColumn(s.getName(), t.getName(), r.getName(), DbObjType.RULE),
                            PgDiffUtils.sha(r.getRawStatement())));
                    // constraint hash join to table hash,
                    StringBuilder tableHash = new StringBuilder(PgDiffUtils.sha(t.getRawStatement()));
                    t.getConstraints().forEach(con -> tableHash.append(PgDiffUtils.sha(con.getRawStatement())));

                    statements.put(new GenericColumn(s.getName(), t.getName(), DbObjType.TABLE),
                            tableHash.toString());
                }
                for (PgView v : s.getViews()) {
                    v.getTriggers().forEach(tr -> statements.put(
                            new GenericColumn(s.getName(), v.getName(), tr.getName(), DbObjType.TRIGGER),
                            PgDiffUtils.sha(tr.getRawStatement())));
                    v.getRules().forEach(r -> statements.put(
                            new GenericColumn(s.getName(), v.getName(), r.getName(), DbObjType.RULE),
                            PgDiffUtils.sha(r.getRawStatement())));
                    statements.put(new GenericColumn(s.getName(), v.getName(), DbObjType.TABLE),
                            PgDiffUtils.sha(v.getRawStatement()));
                }
                statements.put(new GenericColumn(s.getName(), DbObjType.SCHEMA),
                        PgDiffUtils.sha(s.getRawStatement()));
            }

            // removes changed objects
            for (Iterator<ObjectTimestamp> iterator = timestamp.objects.iterator(); iterator.hasNext(); ) {
                ObjectTimestamp obj = iterator.next();
                GenericColumn name = obj.getObject();
                if (!statements.containsKey(name) || !(statements.get(name).equals(obj.getHash()))) {
                    iterator.remove();
                }
            }

            PROJ_TIMESTAMPS.put(project, timestamp);
            serialize(project, timestamp);
        }
    }

    public static DBTimestamp getDBTimastamp (String project) {
        DBTimestamp db = PROJ_TIMESTAMPS.get(project);
        if (db == null) {
            db = deserialise(project);
            if (db == null) {
                db = new DBTimestamp();
            }
            PROJ_TIMESTAMPS.put(project, db);
        }
        return db;
    }

    /**
     * Returns file with in folder: %workspace%/.metadata/.plugins/%this_plugin%/projects.<br>
     *
     * @deprecated don't use this path from apgdiff package
     *
     * @param name - file name
     * @return path to folder with serialized projects
     * @throws URISyntaxException if couldn't get path to the workspace
     */
    @Deprecated
    private static File getInternalFolder(String name) throws URISyntaxException {
        File file = new File(URIUtil.toURI(Platform.getInstanceLocation().getURL()));
        file = new File(file, ".metadata"); //$NON-NLS-1$
        file = new File(file, ".plugins"); //$NON-NLS-1$
        file = new File(file, FOLDER);
        file = new File(file, "projects"); //$NON-NLS-1$
        file = new File(file, name + ".time"); //$NON-NLS-1$
        return file;
    }
}