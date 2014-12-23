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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;

import cz.startnet.utils.pgdiff.loader.ParserClass;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;

public class PgDbParser {

    public static final String PATH_TO_OBJ_SCHEMA = ".settings/schema";
    private static final String SERIALIZATIONFILE = "objects";
    private Set<String> objNames = new HashSet<>();
    private List<PgObjLocation> objLocations;
    private final IProject proj;

    public PgDbParser(IProject proj) {
        this.proj = proj;
        objLocations = new ArrayList<>();
    }

    public PgDbParser getObjFromProject() {
        getDBFromDirectory(proj.getLocationURI());
        return this;
    }

    public void saveToProject() {
        Path path = Paths.get(proj.getLocationURI())
                .resolve(PATH_TO_OBJ_SCHEMA);
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutput out = new ObjectOutputStream(bos);) {
            Files.createDirectories(path);

            out.writeObject(objLocations);
            byte[] myByte = bos.toByteArray();
            Path filePath = path.resolve(SERIALIZATIONFILE);
            Files.deleteIfExists(filePath);
            try (OutputStream fout = new BufferedOutputStream(
                    Files.newOutputStream(Files.createFile(filePath)))) {
                fout.write(myByte);
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
                    objLocations = (List<PgObjLocation>) o;
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
        for (PgObjLocation obj : objLocations) {
            objNames.add(obj.getObjName());
        }
    }

    public Set<String> getObjNames() {
        return objNames;
    }
    
    public List<PgObjLocation> getObjectLocations(String objName) {
        List<PgObjLocation> locations = new ArrayList<>();
        for (PgObjLocation loc : objLocations) {
            if (loc.getObjName().equals(objName)) {
                locations.add(loc);
            }
        }
        return locations;
    }
    
    public List<PgObjLocation> getObjectByPath(Path path) {
        List<PgObjLocation> locations = new ArrayList<>();
        for (PgObjLocation obj : objLocations) {
            if (obj.getFilePath().equals(path)) {
                locations.add(obj);
            }
        }
        return locations;
    }
    
    private void getDBFromDirectory(URI locationURI) {
        String dirPath = Paths.get(locationURI).toAbsolutePath().toString();
        PgDatabase db = PgDumpLoader.loadDatabaseSchemaFromDirTree(dirPath,
                "UTF-8", false, false, ParserClass.ANTLR);
        objLocations.addAll(db.getObjLocations());
    }
}
