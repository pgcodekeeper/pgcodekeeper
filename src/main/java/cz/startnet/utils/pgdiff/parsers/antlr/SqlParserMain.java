package cz.startnet.utils.pgdiff.parsers.antlr;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import cz.startnet.utils.pgdiff.schema.PgComment;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgGrant;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgRevoke;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgView;

public class SqlParserMain {
    public static void main(String[] args) throws IOException,
            InterruptedException {
        // String pathToFile =
        // "/home/botov_av/workspace/pg_dump_folder/maindb_dev3.sql";
        String pathToFile = "/home/botov_av/workspace/codekeeper/apgdiff/src/test/resources/cz/startnet/utils/pgdiff";
        PgDatabase database = new PgDatabase();
        List<PgStatement> alterObjects = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        paths = getPathsToFiles(pathToFile);
//        paths.add("/home/botov_av/workspace/codekeeper/tmp_dump_9221153347570520215.sql");
         paths.add("/home/botov_av/workspace/codekeeper/apgdiff/src/main/java/cz/startnet/utils/pgdiff/parsers/antlr/first_part.sql");
         paths.add("/home/botov_av/workspace/codekeeper/apgdiff/src/main/java/cz/startnet/utils/pgdiff/parsers/antlr/second_part.sql");
         paths.add("/home/botov_av/workspace/codekeeper/apgdiff/src/main/java/cz/startnet/utils/pgdiff/parsers/antlr/third_part.sql");
        for (String path : paths) {
            if (path.endsWith("diff.sql")) {
                continue;
            }
            new SqlParserMain().testSampleInputs(
                    Files.newInputStream(Paths
                            .get(path)),
                    new CustomSQLParserListener(alterObjects, database, Paths
                            .get(path)));
        }
//        fillDB(alterObjects, database);
        System.out.println("2");
    }

    public static void fillDB(List<PgStatement> alterObjects,
            PgDatabase database) {
        List<PgObjLocation> schemas = new ArrayList<>();
        List<PgObjLocation> extensions = new ArrayList<>();
        List<PgObjLocation> tables = new ArrayList<>();
        List<PgObjLocation> indexes = new ArrayList<>();
        List<PgObjLocation> triggers = new ArrayList<>();
        List<PgObjLocation> constraint = new ArrayList<>();
        List<PgObjLocation> functions = new ArrayList<>();
        List<PgObjLocation> sequences = new ArrayList<>();
        List<PgObjLocation> views = new ArrayList<>();
        List<PgObjLocation> comments = new ArrayList<>();
        List<PgObjLocation> revokes = new ArrayList<>();
        List<PgObjLocation> grants = new ArrayList<>();

        for (PgObjLocation object : database.getObjLocations()) {
            if (object.getObj() instanceof PgSchema) {
                schemas.add(object);
            }
            if (object.getObj() instanceof PgExtension) {
                extensions.add(object);
            }
            if (object.getObj() instanceof PgTable) {
                tables.add(object);
            }
            if (object.getObj() instanceof PgIndex) {
                indexes.add(object);
            }
            if (object.getObj() instanceof PgTrigger) {
                triggers.add(object);
            }
            if (object.getObj() instanceof PgConstraint) {
                constraint.add(object);
            }
            if (object.getObj() instanceof PgFunction) {
                functions.add(object);
            }
            if (object.getObj() instanceof PgSequence) {
                sequences.add(object);
            }
            if (object.getObj() instanceof PgView) {
                views.add(object);
            }
            if (object.getObj() instanceof PgComment) {
                comments.add(object);
            }
            if (object.getObj() instanceof PgRevoke) {
                revokes.add(object);
            }
            if (object.getObj() instanceof PgGrant) {
                grants.add(object);
            }
        }

        for (PgObjLocation schema : schemas) {
            database.addSchema((PgSchema) schema.getObj());
        }
        for (PgObjLocation extension : extensions) {
            database.addExtension((PgExtension) extension.getObj());
        }
        for (PgObjLocation table : tables) {
            database.getSchema(table.getSchemaName()).addTable(
                    (PgTable) table.getObj());
        }
        for (PgObjLocation index : indexes) {
            for (PgTable table : database.getSchema(index.getSchemaName())
                    .getTables()) {
                if (table.getBareName().equals(
                        ((PgIndex) index.getObj()).getTableName())) {
                    table.addIndex((PgIndex) index.getObj());
                }
            }
        }
        for (PgObjLocation trigger : triggers) {
            for (PgTable table : database.getSchema(trigger.getSchemaName())
                    .getTables()) {
                if (table.getBareName().equals(
                        ((PgTrigger) trigger.getObj()).getTableName())) {
                    table.addTrigger((PgTrigger) trigger.getObj());
                }
            }
        }
        for (PgObjLocation function : functions) {
            database.getSchema(function.getSchemaName()).addFunction(
                    (PgFunction) function.getObj());
        }
        for (PgObjLocation sequence : sequences) {
            database.getSchema(sequence.getSchemaName()).addSequence(
                    (PgSequence) sequence.getObj());
        }
        for (PgObjLocation view : views) {
            database.getSchema(view.getSchemaName()).addView(
                    (PgView) view.getObj());
        }
        for (PgObjLocation comment : comments) {
            String obj_name = ((PgComment) comment.getObj()).getObjName();
            String commentText = ((PgComment) comment.getObj()).getComment();
            boolean found = false;
            for (PgExtension ext : database.getExtensions()) {
                if (ext.getBareName().equals(obj_name)) {
                    ext.setComment(commentText);
                    found = true;
                }
            }

            if (!found) {
                lable: for (PgSchema schema : database.getSchemas()) {
                    if (schema.getBareName().equals(obj_name)) {
                        schema.setComment(commentText);
                        break lable;
                    }
                    for (PgFunction function : schema.getFunctions()) {
                        if (function.getBareName().equals(obj_name)) {
                            function.setComment(commentText);
                            break lable;
                        }
                    }
                    for (PgSequence sequence : schema.getSequences()) {
                        if (sequence.getBareName().equals(obj_name)) {
                            sequence.setComment(commentText);
                            break lable;
                        }
                    }
                    for (PgView view : schema.getViews()) {
                        if (view.getBareName().equals(obj_name)) {
                            view.setComment(commentText);
                            break lable;
                        }
                    }
                    for (PgTable table : schema.getTables()) {
                        if (table.getBareName().equals(obj_name)) {
                            table.setComment(commentText);
                            break lable;
                        }
                        for (PgIndex index : table.getIndexes()) {
                            if (index.getBareName().equals(obj_name)) {
                                index.setComment(commentText);
                                break lable;
                            }
                        }
                        for (PgTrigger trigger : table.getTriggers()) {
                            if (trigger.getBareName().equals(obj_name)) {
                                trigger.setComment(commentText);
                                break lable;
                            }
                        }
                        for (PgConstraint constr : table.getConstraints()) {
                            if (constr.getBareName().equals(obj_name)) {
                                constr.setComment(commentText);
                                break lable;
                            }
                        }
                    }
                }
            }
        }
    }

    public void testSampleInputs(InputStream inputStream,
            CustomSQLParserListener listener) throws IOException {

        SQLLexer lexer = new SQLLexer(new ANTLRInputStream(inputStream));
        lexer.removeErrorListeners();
        lexer.addErrorListener(CustomErrorListener.INSTATANCE);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        SQLParser parser = new SQLParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(CustomErrorListener.INSTATANCE);
//        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
//        parser.addErrorListener(new DiagnosticErrorListener());
        ParseTreeWalker walker = new ParseTreeWalker();
        
        walker.walk(listener, parser.sql());
         System.out.println(CustomErrorListener.INSTATANCE.errors);
    }

    private static List<String> getPathsToFiles(String root) throws IOException {
        List<String> paths = new ArrayList<>();
        Path rootPath = Paths.get(root);
        if (Files.isDirectory(rootPath)) {
            try (DirectoryStream<Path> dirstrm = Files
                    .newDirectoryStream(rootPath)) {
                for (Path entry : dirstrm) {
                    BasicFileAttributes attr = Files.readAttributes(entry,
                            BasicFileAttributes.class);
                    if (!attr.isDirectory() && attr.size() != 0) {
                        paths.add(entry.toAbsolutePath().toString());
                    }
                }
            }
        }
        return paths;
    }
}