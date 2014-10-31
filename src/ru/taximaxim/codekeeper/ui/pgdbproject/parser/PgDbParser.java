package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts.WORK_DIR_NAMES;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class PgDbParser {

    public static final String PATH_TO_OBJ_SCHEMA = ".settings/schema";
    private static final String SERIALIZATIONFILE = "objects";
    private List<PgStatement> names;
    private Set<String> objNames = new HashSet<>();
    private List<DBObjectsLocation> objLocations;
    private final IProject proj;

    public PgDbParser(IProject proj) {
        this.proj = proj;
        objLocations = new ArrayList<>();
        names = new ArrayList<>();
    }

    public PgDbParser getObjFromProject() {
        PgDatabase db = PgDumpLoader.loadDatabaseSchemaFromDirTree(proj
                .getLocation().toString(), "UTF-8", false, false);
        getObjectsFromDB(db);
        fillObjectLocations(proj.getLocationURI());
        return this;
    }

    public void saveToProject() {
        Path path = Paths.get(proj.getLocationURI())
                .resolve(PATH_TO_OBJ_SCHEMA);
        try {
            Files.createDirectories(path);

            try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ObjectOutput out = new ObjectOutputStream(bos);) {
                out.writeObject(objLocations);
                byte[] myByte = bos.toByteArray();
                Path filePath = path.resolve(SERIALIZATIONFILE);
                Files.deleteIfExists(filePath);
                try (OutputStream fout = new BufferedOutputStream(
                        Files.newOutputStream(Files.createFile(filePath)))) {
                    fout.write(myByte);
                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static PgDbParser getParserFromStore(IProject proj) {
        PgDbParser parser = new PgDbParser(proj);
        parser.load();
        parser.fillNamesFromStore();
        return parser;
    }

    private void load() {
        try {
            byte[] yourBytes = Files.readAllBytes(Paths
                    .get(proj.getLocationURI()).resolve(PATH_TO_OBJ_SCHEMA)
                    .resolve(SERIALIZATIONFILE));
            try (ByteArrayInputStream bis = new ByteArrayInputStream(yourBytes);
                    ObjectInput in = new ObjectInputStream(bis);) {
                Object o = in.readObject();
                if (o instanceof List<?>) {
                    objLocations = (List<DBObjectsLocation>) o;
                }
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }

    private void fillNamesFromStore() {
        for (DBObjectsLocation obj : objLocations) {
            objNames.add(obj.getObjName());
        }
    }

    public Set<String> getObjNames() {
        return objNames;
    }

    public List<DBObjectsLocation> getObjectsLocations() {
        return objLocations;
    }

    private void getObjectsFromDB(PgDatabase db) {
        for (PgStatement statement : db.getExtensions()) {
            names.add(statement);
        }
        for (PgSchema schema : db.getSchemas()) {
            names.add(schema);
            for (PgStatement func : schema.getFunctions()) {
                names.add(func);
            }
        }
    }

    private void fillObjectLocations(URI locationURI) {
        Path root = Paths.get(locationURI);
        try {
            if (Files.readAttributes(root, BasicFileAttributes.class)
                    .isDirectory()) {
                List<String> allowingDir = new ArrayList<>();
                for (WORK_DIR_NAMES name : ApgdiffConsts.WORK_DIR_NAMES
                        .values()) {
                    allowingDir.add(name.toString());
                }
                for (Path child : Files.newDirectoryStream(root)) {
                    if (allowingDir.contains(child.getFileName().toString())) {
                        recursiveParseFiles(child);
                    }
                }

            }
        } catch (IOException e) {
            // do nothing
        }
    }

    private void recursiveParseFiles(Path root) throws IOException {
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(root)) {
            for (Path child : dirStream) {
                BasicFileAttributes attribs = Files.readAttributes(child,
                        BasicFileAttributes.class);
                if (attribs.isDirectory()) {
                    recursiveParseFiles(child);
                } else {
                    parseFile(child);
                }
            }
        }
    }

    private void parseFile(Path children) throws IOException {
        if (Files.exists(children, LinkOption.NOFOLLOW_LINKS)) {
            List<String> lines = Files.readAllLines(children,
                    Charset.forName("UTF-8"));
            for (PgStatement obj : names) {
                int offset = 0;
                String name = obj.getName();
                for (String line : lines) {
                    int index = -1;
                    int internalOffset = 0;
                    do {
                        index = line.indexOf(name, internalOffset);
                        if (index != -1) {
                            internalOffset += index + name.length();
                            objLocations.add(new DBObjectsLocation(name, offset
                                    + index, children));
                        }
                    } while (index != -1);
                    offset += line.length() + 1;
                }
            }
        }
    }
}
