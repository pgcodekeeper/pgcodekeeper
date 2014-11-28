package cz.startnet.utils.pgdiff.parsers.antlr;

import java.io.IOException;
import java.io.InputStreamReader;
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

import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;


public class SqlParserMain {
    public static void main(String[] args) throws IOException, InterruptedException {
//        String pathToFile = "/home/botov_av/workspace/pg_dump_folder/maindb_dev3.sql";
        String pathToFile = "/home/botov_av/workspace/codekeeper/apgdiff/src/test/resources/cz/startnet/utils/pgdiff";
        PgDatabase database = new PgDatabase();
        List<PgStatement> objects = new ArrayList<>(), alterObjects = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        paths = getPathsToFiles(pathToFile);
//        paths.add("/home/botov_av/workspace/codekeeper/apgdiff/src/main/java/cz/startnet/utils/pgdiff/parsers/antlr/first_part.sql");
//        paths.add("/home/botov_av/workspace/codekeeper/apgdiff/src/main/java/cz/startnet/utils/pgdiff/parsers/antlr/second_part.sql");
//        paths.add("/home/botov_av/workspace/codekeeper/apgdiff/src/main/java/cz/startnet/utils/pgdiff/parsers/antlr/third_part.sql");
        for (String path : paths) {
            if (path.endsWith("diff.sql")) {
                continue;
            }
            new SqlParserMain().testSampleInputs(
                    path,
                    new CustomSQLParserListener(objects,alterObjects, database, Paths.get(path)));
        }
    }
    public void testSampleInputs(String pathToFile, CustomSQLParserListener listener) throws IOException {
        
        SQLLexer lexer = new SQLLexer(new ANTLRInputStream(new InputStreamReader(
                Files.newInputStream(Paths.get(pathToFile)), "UTF-8")));
        lexer.removeErrorListeners();
        lexer.addErrorListener(CustomErrorListener.INSTATANCE);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        SQLParser parser = new SQLParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(CustomErrorListener.INSTATANCE);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, parser.sql());
//        System.out.println(CustomErrorListener.INSTATANCE.errors);
    }

    private static List<String> getPathsToFiles(String root) throws IOException {
        List<String> paths = new ArrayList<>();
        Path rootPath = Paths.get(root);
        if (Files.isDirectory(rootPath)) {
            try (DirectoryStream<Path> dirstrm = 
                    Files.newDirectoryStream(rootPath)) {
                for (Path entry : dirstrm) {
                    BasicFileAttributes attr = Files.readAttributes(entry, BasicFileAttributes.class); 
                    if (!attr.isDirectory() && 
                            attr.size() != 0) {
                        paths.add(entry.toAbsolutePath().toString());
                    }
                }
            }
        }
        return paths;
    }
}