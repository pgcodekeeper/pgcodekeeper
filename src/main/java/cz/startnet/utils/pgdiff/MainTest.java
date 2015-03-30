package cz.startnet.utils.pgdiff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.osgi.framework.BundleContext;

import ru.taximaxim.codekeeper.apgdiff.Activator;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;

@RunWith(value = Parameterized.class)
public class MainTest {

    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(new ArgumentsProvider[][]{
                                {new ArgumentsProvider_usage()},
                                {new ArgumentsProvider_2()},
                                {new ArgumentsProvider_3()},
                                {new ArgumentsProvider_4()},
                                {new ArgumentsProvider_5()},
                                {new ArgumentsProvider_6()},
                                {new ArgumentsProvider_7()},
                                {new ArgumentsProvider_unsupportedDbFormat()},
                                {new ArgumentsProvider_9()},
                                {new ArgumentsProvider_DangerTbl()},
                                {new ArgumentsProvider_DangerTblOk()},
                                {new ArgumentsProvider_DangerDropCol()},
                                {new ArgumentsProvider_DangerDropColOk()},
                                {new ArgumentsProvider_DangerAlterCol()},
                                {new ArgumentsProvider_DangerAlterColOk()},
                                {new ArgumentsProvider_16()},
                                {new ArgumentsProvider_17()},
                            });
    }

    private final ArgumentsProvider args;
    
    public MainTest(ArgumentsProvider args) {
        this.args = args;
    }
    
    @Test
    public void mainTest() throws IOException, URISyntaxException{
        switch (args.testType) {
        case TEST_DIFF:
            Main.main(args.arguments());
            File resFile = args.getDiffResultFile();
            File predefined = args.getPredefinedResultFile();
            assertTrue("Predefined file does not exist: " + predefined.getAbsolutePath(), predefined.exists());
            assertTrue("Resulting file does not exist: " + resFile.getAbsolutePath(), resFile.exists());
            
            assertFalse("Predefined file is a directory: " + predefined.getAbsolutePath(), predefined.isDirectory());
            assertFalse("Resulting file is a directory: " + resFile.getAbsolutePath(), resFile.isDirectory());
            if (!filesEqualIgnoreNewLines(predefined, resFile)) {
                System.err.println("");
            }
            assertTrue("Predefined and resulting script differ", filesEqualIgnoreNewLines(predefined, resFile));
            break;
        case TEST_PARSE:
            Main.main(args.arguments());
            break;
        case TEST_OUTPUT:
            PrintStream old = System.out;
            try(ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
                    PrintStream ps = new PrintStream(baos)){
                System.setOut(ps);
                
                Main.main(args.arguments());
                
                System.out.flush();
                assertEquals("Output is not as expected", args.output(), baos.toString());
            }finally{
                System.setOut(old);                
            }
            break;
        }
    }
    
    @After
    public void closeResources(){
        args.close();
    }
    
    private boolean filesEqualIgnoreNewLines(File f1, File f2) throws IOException{
        try (InputStreamReader isr1 = new InputStreamReader(new FileInputStream(f1), "UTF-8");
                BufferedReader reader1 = new BufferedReader(isr1);
                InputStreamReader isr2 = new InputStreamReader(new FileInputStream(f2), "UTF-8");
                BufferedReader reader2 = new BufferedReader(isr2);) {
    
            String line1, line2;
            while((line1 = getNextLine(reader1)) != null & (line2 = getNextLine(reader2)) != null ) {
                if(!line1.equals(line2)){
                    return false;
                }
            }
            
            if (line1 == line2){
                return true;
            }
        }
        
        return true;
    }
    
    /**
     * Iterates through <code>reader</code> line by line until reaches not empty line or EOF
     * 
     * @return  next not empty line or null if EOF is reached
     */
    private String getNextLine(BufferedReader reader) throws IOException{
        String nextLine;
        
        while((nextLine = reader.readLine()) != null && nextLine.equals("")){
            // skip to next line
        }
        
        return nextLine;
    }
}

abstract class ArgumentsProvider implements Closeable{

    enum TestType {TEST_OUTPUT, TEST_DIFF, TEST_PARSE}
    
    public TestType testType = TestType.TEST_OUTPUT;
    public String resName = null;
    public File resFile = null;
    public File resDir = null;
    
    public abstract String[] arguments() throws URISyntaxException, IOException;
    
    public String output(){
        return "";
    }
    
    public File getPredefinedResultFile() throws URISyntaxException, IOException {
        return ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_diff.sql"));
    }

    public File getDiffResultFile() throws IOException {
        return null;
    }
    
    public File getParseResultDir() throws IOException {
        return null;
    }
    
    @Override
    public void close() {
        try{
            if (resFile != null && !resFile.isDirectory()){
                Files.deleteIfExists(resFile.toPath());
            }
        }catch(Exception e){
            // do nothing
        }
        
        try{
            if (resDir != null && resDir.isDirectory()){
                deleteRecursive(resDir);
            }
        }catch(Exception e){
            // do nothing
        }
    }
    
    /**
     * Deletes folder and its contents recursively. FOLLOWS SYMLINKS!
     */
    private static void deleteRecursive(File f) throws IOException {
        if (f.isDirectory()) {
            for (File sub : f.listFiles()) {
                deleteRecursive(sub);
            }
        }
        Files.deleteIfExists(f.toPath());
    }
}

/**
 * {@link ArgumentsProvider} implementation testing help message
 */
class ArgumentsProvider_usage extends ArgumentsProvider{

    @Override
    public String[] arguments() {
        return new String[]{"--help"};
    }

    @Override
    public String output() {
        return Messages.UsageHelp.replace("${tab}", "\t").concat("\n");
    }
}

/**
 * {@link ArgumentsProvider} implementation testing version message
 */
class ArgumentsProvider_2 extends ArgumentsProvider{

    @Override
    public String[] arguments() {
        return new String[]{"--version"};
    }

    @Override
    public String output() {
        BundleContext ctx = Activator.getContext();
        return MessageFormat.format(Messages.Version, 
                ctx == null ? "error: no OSGI running" : ctx.getBundle().getVersion()) + '\n';
    }
}

/**
 * {@link ArgumentsProvider} implementation testing list-charsets message
 */
class ArgumentsProvider_3 extends ArgumentsProvider{

    @Override
    public String[] arguments() {
        return new String[]{"--list-charsets"};
    }

    @Override
    public String output() {
        StringBuilder sb = new StringBuilder();
        for (final String name : Charset.availableCharsets().keySet()) {
            sb.append(name + "\n");
        }
        return sb.toString();
    }
}

/**
 * {@link ArgumentsProvider} implementation testing empty args message
 */
class ArgumentsProvider_4 extends ArgumentsProvider{

    @Override
    public String[] arguments() {
        return new String[]{};
    }

    @SuppressWarnings("resource")
    @Override
    public String output() {
        return new ArgumentsProvider_usage().output();
    }
}

/**
 * {@link ArgumentsProvider} implementation testing diff+parse error message
 */
class ArgumentsProvider_5 extends ArgumentsProvider{

    @Override
    public String[] arguments() {
        return new String[]{"--diff", "--parse", "--dbOld-format", "dump", "--allow-danger-ddl", "DROP_TABLE"};
    }

    @SuppressWarnings("resource")
    @Override
    public String output() {
        return "Only one of --diff or --parse mode can be set!" + "\n" + new ArgumentsProvider_usage().output();
    }
}

/**
 * {@link ArgumentsProvider} implementation testing diff
 */
class ArgumentsProvider_6 extends ArgumentsProvider{
    
    {
        super.resName = "add_cluster";
        super.testType = TestType.TEST_DIFF;
    }
    
    @Override
    public String[] arguments() throws URISyntaxException, IOException {
        File fNew = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_new.sql"));
        File fOriginal = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_original.sql"));
        
        return new String[]{"--diff", "--dbOld-format", "dump", "--allow-danger-ddl", "DROP_TABLE", 
                fOriginal.getAbsolutePath(), fNew.getAbsolutePath(), getDiffResultFile().getAbsolutePath()};
    }
    
    @Override
    public File getDiffResultFile() throws IOException {
        if (resFile == null){
            resFile = Files.createTempFile("pgcodekeeper_standalone_", "").toFile();
        }
        
        return resFile;
    }
}

/**
 * {@link ArgumentsProvider} implementation testing diff
 */
class ArgumentsProvider_7 extends ArgumentsProvider{
    
    {
        super.resName = "modify_function_args2";
        super.testType = TestType.TEST_DIFF;
    }
    
    @Override
    public String[] arguments() throws URISyntaxException, IOException {
        File fNew = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_new.sql"));
        File fOriginal = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_original.sql"));
        
        return new String[]{"--diff", "--dbNew-format", "dump", "--allow-danger-ddl", "DROP_TABLE", 
                fOriginal.getAbsolutePath(), fNew.getAbsolutePath(), getDiffResultFile().getAbsolutePath()};
    }
    
    @Override
    public File getDiffResultFile() throws IOException {
        if (resFile == null){
            resFile = Files.createTempFile("pgcodekeeper_standalone_", "").toFile();
        }
        
        return resFile;
    }
}

/**
 * {@link ArgumentsProvider} implementation testing wrong source db format 
 */
class ArgumentsProvider_unsupportedDbFormat extends ArgumentsProvider{
    
    @Override
    public String[] arguments() throws URISyntaxException, IOException {
        return new String[]{"--diff", "--dbOld-format", "dumpa", "--allow-danger-ddl", "DROP_TABLE", 
                getDiffResultFile().getAbsolutePath()};
    }
    
    @Override
    public File getDiffResultFile() throws IOException {
        if (resFile == null){
            resFile = Files.createTempFile("pgcodekeeper_standalone_", "").toFile();
        }
        
        return resFile;
    }
    
    @SuppressWarnings("resource")
    @Override
    public String output() {
        return "Unsupported DB format!\n" + new ArgumentsProvider_usage().output();
    }
}

/**
 * {@link ArgumentsProvider} implementation testing wrong source db format 
 */
class ArgumentsProvider_9 extends ArgumentsProvider{
    
    @Override
    public String[] arguments() throws URISyntaxException, IOException {
        return new String[]{"--diff", "--dbNew-format", "dumpa", "--allow-danger-ddl", "DROP_TABLE", 
                getDiffResultFile().getAbsolutePath()};
    }
    
    @Override
    public File getDiffResultFile() throws IOException {
        if (resFile == null){
            resFile = Files.createTempFile("pgcodekeeper_standalone_", "").toFile();
        }
        
        return resFile;
    }
    
    @SuppressWarnings("resource")
    @Override
    public String output() {
        return "Unsupported DB format!\n" + new ArgumentsProvider_usage().output();
    }
}

/**
 * {@link ArgumentsProvider} implementation testing dangerous statements ERROR
 */
class ArgumentsProvider_DangerTbl extends ArgumentsProvider{
    
    {
        super.resName = "drop_table";
    }
    
    @Override
    public String[] arguments() throws URISyntaxException, IOException {
        File fNew = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_new.sql"));
        File fOriginal = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_original.sql"));
        
        return new String[]{"--diff", "--dbNew-format", "dump", fOriginal.getAbsolutePath(), 
                fNew.getAbsolutePath(), getDiffResultFile().getAbsolutePath()};
    }
    
    @Override
    public File getDiffResultFile() throws IOException {
        if (resFile == null){
            resFile = Files.createTempFile("pgcodekeeper_standalone_", "").toFile();
        }
        
        return resFile;
    }
    
    @Override
    public String output() {
        return "Script contains dangerous statements, use --allow-danger-ddl to override\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing successful dangerous statements
 */
class ArgumentsProvider_DangerTblOk extends ArgumentsProvider{
    
    {
        super.resName = "drop_table";
        super.testType = TestType.TEST_DIFF;
    }
    
    @Override
    public String[] arguments() throws URISyntaxException, IOException {
        File fNew = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_new.sql"));
        File fOriginal = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_original.sql"));
        
        return new String[]{"--diff", "--dbNew-format", "dump", "--allow-danger-ddl", "DROP_TABLE", 
                fOriginal.getAbsolutePath(), fNew.getAbsolutePath(), getDiffResultFile().getAbsolutePath()};
    }
    
    @Override
    public File getDiffResultFile() throws IOException {
        if (resFile == null){
            resFile = Files.createTempFile("pgcodekeeper_standalone_", "").toFile();
        }
        
        return resFile;
    }
}

/**
 * {@link ArgumentsProvider} implementation testing dangerous statements ERROR
 */
class ArgumentsProvider_DangerDropCol extends ArgumentsProvider{
    
    {
        super.resName = "drop_column";
    }
    
    @Override
    public String[] arguments() throws URISyntaxException, IOException {
        File fNew = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_new.sql"));
        File fOriginal = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_original.sql"));
        
        return new String[]{"--diff", "--dbNew-format", "dump", fOriginal.getAbsolutePath(), 
                fNew.getAbsolutePath(), getDiffResultFile().getAbsolutePath()};
    }
    
    @Override
    public File getDiffResultFile() throws IOException {
        if (resFile == null){
            resFile = Files.createTempFile("pgcodekeeper_standalone_", "").toFile();
        }
        
        return resFile;
    }
    
    @Override
    public String output() {
        return "Script contains dangerous statements, use --allow-danger-ddl to override\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing successful dangerous statements
 */
class ArgumentsProvider_DangerDropColOk extends ArgumentsProvider{
    
    {
        super.resName = "drop_column";
        super.testType = TestType.TEST_DIFF;
    }
    
    @Override
    public String[] arguments() throws URISyntaxException, IOException {
        File fNew = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_new.sql"));
        File fOriginal = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_original.sql"));
        
        return new String[]{"--diff", "--dbNew-format", "dump", "--allow-danger-ddl", 
                "DROP_COLUMN", fOriginal.getAbsolutePath(), fNew.getAbsolutePath(), 
                getDiffResultFile().getAbsolutePath()};
    }
    
    @Override
    public File getDiffResultFile() throws IOException {
        if (resFile == null){
            resFile = Files.createTempFile("pgcodekeeper_standalone_", "").toFile();
        }
        
        return resFile;
    }
}

/**
 * {@link ArgumentsProvider} implementation testing dangerous statements ERROR
 */
class ArgumentsProvider_DangerAlterCol extends ArgumentsProvider{
    
    {
        super.resName = "modify_column_type";
    }
    
    @Override
    public String[] arguments() throws URISyntaxException, IOException {
        File fNew = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_new.sql"));
        File fOriginal = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_original.sql"));
        
        return new String[]{"--diff", "--dbNew-format", "dump", fOriginal.getAbsolutePath(), 
                fNew.getAbsolutePath(), getDiffResultFile().getAbsolutePath()};
    }

    @Override
    public File getDiffResultFile() throws IOException {
        if (resFile == null){
            resFile = Files.createTempFile("pgcodekeeper_standalone_", "").toFile();
        }
        
        return resFile;
    }
    
    @Override
    public String output() {
        return "Script contains dangerous statements, use --allow-danger-ddl to override\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing successful dangerous statements
 */
class ArgumentsProvider_DangerAlterColOk extends ArgumentsProvider{
    
    {
        super.resName = "modify_column_type";
        super.testType = TestType.TEST_DIFF;
    }
    
    @Override
    public String[] arguments() throws URISyntaxException, IOException {
        File fNew = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_new.sql"));
        File fOriginal = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_original.sql"));
        
        return new String[]{"--diff", "--dbNew-format", "dump", "--allow-danger-ddl", 
                "ALTER_COLUMN", fOriginal.getAbsolutePath(), fNew.getAbsolutePath(), 
                getDiffResultFile().getAbsolutePath()};
    }
    
    @Override
    public File getDiffResultFile() throws IOException {
        if (resFile == null){
            resFile = Files.createTempFile("pgcodekeeper_standalone_", "").toFile();
        }
        
        return resFile;
    }
}

/**
 * {@link ArgumentsProvider} implementation testing all other flags
 */
class ArgumentsProvider_16 extends ArgumentsProvider{
    
    {
        super.resName = "modify_column_type";
        super.testType = TestType.TEST_DIFF;
    }
    
    @Override
    public String[] arguments() throws URISyntaxException, IOException {
        File fNew = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_new.sql"));
        File fOriginal = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName + "_original.sql"));
        
        return new String[]{"--diff", "--output-ignored-statements", 
                "--ignore-slony-triggers", "--add-transaction", 
                "--no-check-function-bodies", "--time-zone", "UTC",
                "--allow-danger-ddl", "ALTER_COLUMN", fOriginal.getAbsolutePath(), 
                fNew.getAbsolutePath(), getDiffResultFile().getAbsolutePath()};
    }
    
    @Override
    public File getPredefinedResultFile() throws URISyntaxException, IOException {
        URL resourceUrl = MainTest.class.getResource("MainTest_" + resName + "_diff.sql");
        return ApgdiffUtils.getFileFromOsgiRes(resourceUrl);
    }
    
    @Override
    public File getDiffResultFile() throws IOException {
        if (resFile == null){
            resFile = Files.createTempFile("pgcodekeeper_standalone_", "").toFile();
        }
        
        return resFile;
    }
}

/**
 * {@link ArgumentsProvider} implementation testing parsing option
 */
class ArgumentsProvider_17 extends ArgumentsProvider{
    
    {
        super.resName = "loader/remote/testing_dump.sql";
        super.testType = TestType.TEST_PARSE;
    }
    
    @Override
    public String[] arguments() throws URISyntaxException, IOException {
        File db = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource(resName));
        
        return new String[]{"--parse", db.getAbsolutePath(), getParseResultDir().getAbsolutePath()};
    }
    
    @Override
    public File getParseResultDir() throws IOException {
        if (resDir == null){
            resDir = Files.createTempDirectory("pgcodekeeper_standalone_").toFile();
        }
        
        return resDir;
    }
}