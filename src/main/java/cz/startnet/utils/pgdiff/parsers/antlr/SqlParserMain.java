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
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import cz.startnet.utils.pgdiff.parsers.ParserUtils;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgComment;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgRuleCommon;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSelect;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgView;
import cz.startnet.utils.pgdiff.schema.PgView.DefaultValue;

public class SqlParserMain {
    public static void main(String[] args) throws IOException,
            InterruptedException {
        // String pathToFile =
        // "/home/botov_av/workspace/pg_dump_folder/maindb_dev3.sql";
        String pathToFile = "/home/botov_av/workspace/codekeeper/apgdiff/src/test/resources/cz/startnet/utils/pgdiff";
        PgDatabase database = new PgDatabase();
        List<PgObjLocation> alterObjects = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        // paths = getPathsToFiles(pathToFile);
        // pathToFile =
        // "/home/botov_av/workspace/codekeeper/apgdiff/src/test/resources/cz/startnet/utils/pgdiff/loader";
        // paths = getPathsToFiles(pathToFile);
        // paths.add("/home/botov_av/workspace/codekeeper/apgdiff/src/test/resources/cz/startnet/utils/pgdiff/loader/schema_17.sql");
        long timeout = System.currentTimeMillis();
        // paths.add("/home/botov_av/workspace/pg_dump_folder/maindb_dev2.sql");
        // paths.add("/home/botov_av/workspace/codekeeper/tmp_dump_9221153347570520215.sql");
        // paths.add("/home/botov_av/workspace/codekeeper/apgdiff/src/main/java/cz/startnet/utils/pgdiff/parsers/antlr/first_part.sql");
        paths.add("/home/botov_av/workspace/codekeeper/apgdiff/src/main/java/cz/startnet/utils/pgdiff/parsers/antlr/second_part.sql");
        // paths.add("/home/botov_av/workspace/codekeeper/apgdiff/src/main/java/cz/startnet/utils/pgdiff/parsers/antlr/third_part.sql");
        for (String path : paths) {
            if (path.endsWith("diff.sql")) {
                continue;
            }
            new SqlParserMain().testSampleInputs(Files.newInputStream(Paths
                    .get(path)), new CustomSQLParserListener(alterObjects,
                    database, Paths.get(path)));
        }
        // fillDB(alterObjects, database);
        System.out.println((System.currentTimeMillis() - timeout) / 1000);
    }

    public static void fillDB(PgDatabase database) {
        List<PgObjLocation> schemas = new ArrayList<>();
        List<PgObjLocation> extensions = new ArrayList<>();
        List<PgObjLocation> tables = new ArrayList<>();
        List<PgObjLocation> indexes = new ArrayList<>();
        List<PgObjLocation> triggers = new ArrayList<>();
        List<PgObjLocation> constraints = new ArrayList<>();
        List<PgObjLocation> functions = new ArrayList<>();
        List<PgObjLocation> sequences = new ArrayList<>();
        List<PgObjLocation> views = new ArrayList<>();
        List<PgObjLocation> comments = new ArrayList<>();
        List<PgObjLocation> revokes = new ArrayList<>();

        for (PgObjLocation object : database.getObjLocations()) {
            if (object.isAddedToDB()) {
                continue;
            }
            if (object.getObj() instanceof PgSchema) {
                schemas.add(object);
                object.setAddedToDB(true);
            }
            if (object.getObj() instanceof PgExtension) {
                extensions.add(object);
                object.setAddedToDB(true);
            }
            if (object.getObj() instanceof PgTable) {
                tables.add(object);
                object.setAddedToDB(true);
            }
            if (object.getObj() instanceof PgIndex) {
                indexes.add(object);
                object.setAddedToDB(true);
            }
            if (object.getObj() instanceof PgTrigger) {
                triggers.add(object);
                object.setAddedToDB(true);
            }
            if (object.getObj() instanceof PgConstraint) {
                constraints.add(object);
                object.setAddedToDB(true);
            }
            if (object.getObj() instanceof PgFunction) {
                functions.add(object);
                object.setAddedToDB(true);
            }
            if (object.getObj() instanceof PgSequence) {
                sequences.add(object);
                object.setAddedToDB(true);
            }
            if (object.getObj() instanceof PgView) {
                views.add(object);
                object.setAddedToDB(true);
            }
            if (object.getObj() instanceof PgComment) {
                comments.add(object);
                object.setAddedToDB(true);
            }
            if (object.getObj() instanceof PgRuleCommon) {
                revokes.add(object);
                object.setAddedToDB(true);
            }
        }

        for (PgObjLocation schema : schemas) {
            PgSchema exists = database.getSchema(schema.getObj().getName());
            if (exists == null) {
                database.addSchema((PgSchema) schema.getObj());
            } else {
                database.tryReplacePublicDef((PgSchema) schema.getObj());
            }
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
        for (PgObjLocation constraint : constraints) {
            for (PgTable table : database.getSchema(constraint.getSchemaName())
                    .getTables()) {
                if (table.getBareName().equals(
                        ((PgConstraint) constraint.getObj()).getTableName())) {
                    table.addConstraint((PgConstraint) constraint.getObj());
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
            for (PgExtension ext : database.getExtensions()) {
                if (ext.getBareName().equals(obj_name)) {
                    ext.setComment(commentText);
                }
            }

            if (((PgComment) comment.getObj()).getType() != DbObjType.EXTENSION) {
                for (PgSchema schema : database.getSchemas()) {
                    if (schema.getBareName().equals(obj_name)) {
                        schema.setComment(commentText);
                    }
                    for (PgFunction function : schema.getFunctions()) {
                        if (function.getName().equals(obj_name)) {
                            function.setComment(commentText);
                        }
                    }
                    for (PgSequence sequence : schema.getSequences()) {
                        if (sequence.getBareName().equals(obj_name)) {
                            sequence.setComment(commentText);
                        }
                    }
                    for (PgView view : schema.getViews()) {
                        if (view.getBareName().equals(obj_name)) {
                            view.setComment(commentText);
                        }
                    }
                    for (PgTable table : schema.getTables()) {
                        if (table.getBareName().equals(obj_name)) {
                            table.setComment(commentText);
                        }
                        for (PgIndex index : table.getIndexes()) {
                            if (index.getBareName().equals(obj_name)) {
                                index.setComment(commentText);
                            }
                        }
                        for (PgTrigger trigger : table.getTriggers()) {
                            if (trigger.getBareName().equals(obj_name)) {
                                trigger.setComment(commentText);
                            }
                        }
                        for (PgConstraint constr : table.getConstraints()) {
                            if (constr.getBareName().equals(obj_name)) {
                                constr.setComment(commentText);
                            }
                        }
                    }
                }
            }
        }
        for (PgObjLocation revoke : revokes) {
            PgRuleCommon rule = (PgRuleCommon) revoke.getObj();
            String obj_name = rule.getObjName();
            PgPrivilege privilege = new PgPrivilege(rule.isRevoke(),
                    rule.getBody(), rule.getRawStatement());

            lable: for (PgSchema schema : database.getSchemas()) {
                if (schema.getBareName().equals(obj_name)) {
                    schema.addPrivilege(privilege);
                    break lable;
                }
                for (PgFunction function : schema.getFunctions()) {
                    if (function.getSignature().equals(obj_name)) {
                        function.addPrivilege(privilege);
                        break lable;
                    }
                }
                for (PgSequence sequence : schema.getSequences()) {
                    if (sequence.getBareName().equals(obj_name)) {
                        sequence.addPrivilege(privilege);
                        break lable;
                    }
                }
                for (PgView view : schema.getViews()) {
                    if (view.getBareName().equals(obj_name)) {
                        view.addPrivilege(privilege);
                        break lable;
                    }
                }
                for (PgTable table : schema.getTables()) {
                    if (table.getBareName().equals(obj_name)) {
                        table.addPrivilege(privilege);
                        break lable;
                    }
                    for (PgIndex index : table.getIndexes()) {
                        if (index.getBareName().equals(obj_name)) {
                            index.addPrivilege(privilege);
                            break lable;
                        }
                    }
                    for (PgTrigger trigger : table.getTriggers()) {
                        if (trigger.getBareName().equals(obj_name)) {
                            trigger.addPrivilege(privilege);
                            break lable;
                        }
                    }
                    for (PgConstraint constr : table.getConstraints()) {
                        if (constr.getBareName().equals(obj_name)) {
                            constr.addPrivilege(privilege);
                            break lable;
                        }
                    }
                }
            }
        }
    }

    public static void fillAlterObjects(List<PgObjLocation> alterObjects,
            PgDatabase database) {
        for (PgObjLocation obj : alterObjects) {
            if (obj.getObj() instanceof PgFunction) {
                PgFunction func = (PgFunction) obj.getObj();
                PgFunction function = database.getSchema(obj.getSchemaName())
                        .getFunction(func.getSignature());
                if (function != null) {
                    function.setOwner(func.getOwner());
                }
            } else if (obj.getObj() instanceof PgSchema) {
                PgSchema sch = (PgSchema) obj.getObj();
                PgSchema schema = database.getSchema(sch.getName());
                if (schema != null) {
                    schema.setOwner(sch.getOwner());
                }
            } else if (obj.getObj() instanceof PgTable) {
                PgTable tabl = (PgTable) obj.getObj();
                PgTable table = database.getSchema(obj.getSchemaName())
                        .getTable(tabl.getName());
                if (table != null) {
                    if (tabl.getOwner() != null) {
                        table.setOwner(tabl.getOwner());
                    }
                    if (tabl.getClusterIndexName() != null) {
                        table.setClusterIndexName(tabl.getClusterIndexName());
                    }
                    if (tabl.getWith() != null) {
                        table.setWith(tabl.getWith());
                    }
                    for (PgConstraint constr : tabl.getConstraints()) {
                        if (table.getConstraint(constr.getName()) == null) {
                            constr.dropParent();
                            table.addConstraint(constr);
                        }
                    }
                    for (PgColumn col : tabl.getColumns()) {
                        PgColumn column = table.getColumn(col.getName());
                        if (column == null) {
                            table.addColumn(col);
                        } else {
                            if (col.getStatistics() != null) {
                                column.setStatistics(col.getStatistics());
                            }
                            if (col.getDefaultValue() != null) {
                                column.setDefaultValue(col.getDefaultValue());
                            }
                        }
                    }
                }
            } else if (obj.getObj() instanceof PgSequence) {
                PgSequence seq = (PgSequence) obj.getObj();
                PgSequence sequence = database.getSchema(obj.getSchemaName())
                        .getSequence(seq.getName());
                if (sequence != null) {
                    if (seq.getOwner() != null) {
                        sequence.setOwner(seq.getOwner());
                    }
                    if (seq.getOwnedBy() != null) {
                        sequence.setOwnedBy(seq.getOwnedBy());
                    }
                }
            } else if (obj.getObj() instanceof PgView) {
                PgView vie = (PgView) obj.getObj();
                PgView view = database.getSchema(obj.getSchemaName()).getView(
                        vie.getName());
                if (view != null) {
                    for (DefaultValue col : view.getDefaultValues()) {
                        if (!vie.getDefaultValues().contains(col)) {
                            view.removeColumnDefaultValue(col.getColumnName());
                        }
                    }
                    if (vie.getOwner() != null) {
                        view.setOwner(vie.getOwner());
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
        // parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
        // parser.addErrorListener(new DiagnosticErrorListener());
        ParseTreeWalker walker = new ParseTreeWalker();

        walker.walk(listener, parser.sql());
        // System.out.println(CustomErrorListener.INSTATANCE.errors);
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