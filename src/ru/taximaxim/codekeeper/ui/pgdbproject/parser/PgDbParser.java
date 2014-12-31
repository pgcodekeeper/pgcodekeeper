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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;

import cz.startnet.utils.pgdiff.loader.ParserClass;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;

public class PgDbParser {

    private static final Map<IProject, PgDbParser> PROJ_PARSERS = new HashMap<>();
    public static final String PATH_TO_OBJ_SCHEMA = ".settings/schema";
    private static final String SERIALIZATIONFILE = "objects";
    private Set<PgObjLocation> objDefinitions;
    private List<PgObjLocation> objReferences;
    private final IProject proj;

    private PgDbParser(IProject proj) {
        this.proj = proj;
        objDefinitions = new HashSet<>();
        objReferences = new ArrayList<>();
    }
    
    public static PgDbParser getParser(IProject proj) {
        if (PROJ_PARSERS.get(proj) != null) {
            return PROJ_PARSERS.get(proj); 
        }
        PgDbParser parser = new PgDbParser(proj);
        parser.load();
        PROJ_PARSERS.put(proj, parser);
        return parser;
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

            out.writeObject(objDefinitions);
            out.writeObject(objReferences);
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

    private void load() {
        try {
            byte[] yourBytes = Files.readAllBytes(Paths
                    .get(proj.getLocationURI()).resolve(PATH_TO_OBJ_SCHEMA)
                    .resolve(SERIALIZATIONFILE));
            try (ByteArrayInputStream bis = new ByteArrayInputStream(yourBytes);
                    ObjectInput in = new ObjectInputStream(bis);) {
                Object o = in.readObject();
                if (o instanceof Set<?>) {
                    objDefinitions = (Set<PgObjLocation>) o;
                }
                o = in.readObject();
                if (o instanceof List<?>) {
                    objReferences = (List<PgObjLocation>) o;
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

    public PgObjLocation getDefinitionForObj(PgObjLocation obj) {
        for (PgObjLocation col : objDefinitions) {
            if (col.getObject().equals(obj.getObject())
                    && col.getObjType().equals(obj.getObjType())) {
                return col;
            }
        }
        return null;
    }
    
    public List<PgObjLocation> getObjsForPath(Path pathToFile) {
        List<PgObjLocation> locations = new ArrayList<>();
        for (PgObjLocation loc : objReferences) {
            if (loc.getFilePath().equals(pathToFile) 
                    && hasDefinition(loc)) {
                locations.add(loc);
            }
        }
        return locations;
    }
    
    private boolean hasDefinition(PgObjLocation obj) {
        for (PgObjLocation loc : objDefinitions) {
            if (loc.getObject().table.equals(obj.getObject().table)
                    && loc.getObjType().equals(obj.getObjType())) {
                return true;
            }
        }
        return false;
    }
    
    public List<PgObjLocation> getObjectByPath(Path path) {
        List<PgObjLocation> locations = new ArrayList<>();
        for (PgObjLocation obj : objDefinitions) {
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
        objDefinitions.addAll(db.getObjDefinitions());
        objReferences.addAll(db.getObjReferences());
    }
}
