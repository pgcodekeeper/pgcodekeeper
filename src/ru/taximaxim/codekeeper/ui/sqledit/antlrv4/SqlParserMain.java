package ru.taximaxim.codekeeper.ui.sqledit.antlrv4;

import java.io.IOException;
import java.io.InputStream;
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
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import ru.taximaxim.codekeeper.ui.pgdbproject.parser.DBObjectsLocation;

public class SqlParserMain {
    public static void main(String[] args) throws IOException, InterruptedException {
//        String pathToFile = "/home/botov_av/workspace/pg_dump_folder/maindb_dev3.sql";
        String pathToFile = "/home/botov_av/workspace/codekeeper/apgdiff/src/test/resources/cz/startnet/utils/pgdiff";
        List<DBObjectsLocation> objLocation = new ArrayList<>();
        List<String> paths = getPathsToFiles(pathToFile);
        paths.add("/home/botov_av/workspace/codekeeper/ru.taximaxim.codekeeper.ui/src/ru/taximaxim/codekeeper/ui/sqledit/antlrv4/first_part.sql");
        paths.add("/home/botov_av/workspace/codekeeper/ru.taximaxim.codekeeper.ui/src/ru/taximaxim/codekeeper/ui/sqledit/antlrv4/second_part.sql");
        paths.add("/home/botov_av/workspace/codekeeper/ru.taximaxim.codekeeper.ui/src/ru/taximaxim/codekeeper/ui/sqledit/antlrv4/third_part.sql");
        for (String path : paths) {
            if (path.endsWith("diff.sql")) {
                continue;
            }
            objLocation.clear();
            
            new SqlParserMain().testSampleInputs(
                    path,
                    new CustomSQLParserListener(objLocation, Paths.get("/")));
            Thread.currentThread().sleep(100);
            System.out.println(path + "\n" + objLocation);
            System.out.println(objLocation.size());
        }
    }
    public void testSampleInputs(String pathToFile, ParseTreeListener listener) throws IOException {
        String input = loadSample(pathToFile, "UTF-8");

        SQLLexer lexer = new SQLLexer(new ANTLRInputStream(input));
        lexer.removeErrorListeners();
        lexer.addErrorListener(CustomErrorListener.INSTATANCE);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        SQLParser parser = new SQLParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(CustomErrorListener.INSTATANCE);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, parser.sql());
    }

    protected String loadSample(String fileName, String encoding) throws IOException
    {
        if ( fileName==null ) {
            return null;
        }

        String fullFileName = fileName;
        int size = 1024 * 1024;
        InputStreamReader isr;
        InputStream fis = Files.newInputStream(Paths.get(fullFileName));
        if ( encoding!=null ) {
            isr = new InputStreamReader(fis, encoding);
        }
        else {
            isr = new InputStreamReader(fis);
        }
        try {
            char[] data = new char[size];
            int n = isr.read(data);
            return new String(data, 0, n);
        }
        finally {
            isr.close();
        }
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