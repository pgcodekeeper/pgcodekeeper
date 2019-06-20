package cz.startnet.utils.pgdiff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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

import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.fileutils.TempDir;
import ru.taximaxim.codekeeper.cli.Activator;
import ru.taximaxim.codekeeper.cli.Main;
import ru.taximaxim.codekeeper.cli.localizations.Messages;

@RunWith(value = Parameterized.class)
public class MainTest {

    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(new ArgumentsProvider[][]{
            {new UsageArgumentsProvider()},
            {new VersionArgumentsProvider()},
            {new CharsetsArgumentsProvider()},
            {new EmptyArgumentsProvider()},
            {new SourceTargerArgumentsProvider()},
            {new AddTestArgumentsProvider()},
            {new ModifyTestArgumentsProvider()},
            {new FailSourceArgumentsProvider()},
            {new FailParseArgumentsProvider()},
            {new FailDangerTableArgumentsProvider()},
            {new DangerTableArgumentsProvider()},
            {new FailDangerDropColArgumentsProvider()},
            {new DangerDropColArgumentsProvider()},
            {new FailDangerAlterColArgumentsProvider()},
            {new DangerAlterColArgumentsProvider()},
            {new FailDangerRestartArgumentsProvider()},
            {new DangerRestartAgumentsProvider()},
            {new FailDangerUpdateArgumentsProvider()},
            {new DangerUpdateAgumentsProvider()},
            {new FlagsArgumentsProvider()},
            {new ParseTestArgumentsProvider()},
            {new IgnoreListsArgumentsProvider()},
            {new AllowedObjectsArgumentsProvider()},
            {new FailConcurrentlyArgumentsProvider()},
            {new ConcurrentlyArgumentsProvider()},
            {new MsConcurrentlyArgumentsProvider()},
            {new FailMsArgumentsProvider()},
            {new FailPgArgumentsProvider()},
            {new FailCompareArgumentsProvider()},
            {new FailMsParseArgumentsProvider()},
            {new FailPgParseArgumentsProvider()},
            {new LibrariesArgumentsProvider()},
            {new OverrideArgumentsProvider()},
        });
    }

    private final ArgumentsProvider args;

    public MainTest(ArgumentsProvider args) {
        this.args = args;
    }

    @Test
    public void mainTest() throws IOException, URISyntaxException, InterruptedException {
        switch (args.testType) {
        case TEST_DIFF:
            diff();
            break;
        case TEST_PARSE:
            Main.main(args.args());
            String name = args.getClass().getSimpleName();
            assertTrue(name + " - .pgcodekeeper doesn't exist",
                    Files.isRegularFile(args.getParseResultDir().get().resolve(".pgcodekeeper")));
            assertTrue(name + " - SCHEMA doesn't exist",
                    Files.isDirectory(args.getParseResultDir().get().resolve("SCHEMA")));
            break;
        case TEST_OUTPUT:
            output();
            break;
        }
    }

    private void diff() throws IOException, URISyntaxException, InterruptedException {
        Main.main(args.args());
        File resFile = args.getDiffResultFile();
        File predefined = args.getPredefinedResultFile();
        String name = args.getClass().getSimpleName();
        assertTrue(name + " - Predefined file does not exist: "
                + predefined.getAbsolutePath(), predefined.exists());
        assertTrue(name + " - Resulting file does not exist: "
                + resFile.getAbsolutePath(), resFile.exists());

        assertFalse(name + " - Predefined file is a directory: "
                + predefined.getAbsolutePath(), predefined.isDirectory());
        assertFalse(name + " - Resulting file is a directory: "
                + resFile.getAbsolutePath(), resFile.isDirectory());
        if (!filesEqualIgnoreNewLines(predefined, resFile)) {
            assertEquals(name + " - Predefined and resulting script differ",
                    new String(Files.readAllBytes(predefined.toPath()), StandardCharsets.UTF_8),
                    new String(Files.readAllBytes(resFile.toPath()), StandardCharsets.UTF_8));
        }
    }

    private void output() throws IOException, URISyntaxException, InterruptedException {
        PrintStream old = System.out;
        PrintStream olde = System.err;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos)) {
            System.setOut(ps);
            System.setErr(ps);

            Main.main(args.args());

            System.out.flush();
            assertEquals(args.getClass().getSimpleName() + " - Output is not as expected",
                    args.output(), baos.toString());
        } finally {
            System.setOut(old);
            System.setErr(olde);
        }
    }

    @After
    public void closeResources() {
        args.close();
    }

    private boolean filesEqualIgnoreNewLines(File f1, File f2) throws IOException {
        try (InputStreamReader isr1 = new InputStreamReader(new FileInputStream(f1), "UTF-8");
                BufferedReader reader1 = new BufferedReader(isr1);
                InputStreamReader isr2 = new InputStreamReader(new FileInputStream(f2), "UTF-8");
                BufferedReader reader2 = new BufferedReader(isr2);) {

            String line1;
            String line2;
            while ((line1 = getNextLine(reader1)) != null & (line2 = getNextLine(reader2)) != null) {
                if (!line1.equals(line2)){
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
    private String getNextLine(BufferedReader reader) throws IOException {
        String nextLine;

        while ((nextLine = reader.readLine()) != null && nextLine.isEmpty()) {
            // skip to next line
        }

        return nextLine;
    }
}

abstract class ArgumentsProvider {

    protected static final String STANDALONE = "pgcodekeeper_standalone_";

    enum TestType {TEST_OUTPUT, TEST_DIFF, TEST_PARSE}

    protected final TestType testType;
    protected final String resName;
    protected File resFile;
    protected TempDir resDir;

    protected ArgumentsProvider() {
        this(TestType.TEST_OUTPUT);
    }

    protected ArgumentsProvider(TestType testType) {
        this(testType, null);
    }

    protected ArgumentsProvider(TestType testType, String resName) {
        this.testType = testType;
        this.resName = resName;
    }


    protected abstract String[] args() throws URISyntaxException, IOException;

    public String output() {
        return "";
    }

    public File getPredefinedResultFile() throws URISyntaxException, IOException {
        return getFile(FILES_POSTFIX.DIFF_SQL);
    }

    protected final File getFile(FILES_POSTFIX postfix) throws URISyntaxException, IOException {
        return ApgdiffUtils.getFileFromOsgiRes(PgDiffTest.class.getResource(resName + postfix));
    }

    public File getDiffResultFile() throws IOException {
        if (resFile == null){
            resFile = Files.createTempFile(STANDALONE, "").toFile();
        }

        return resFile;
    }

    public TempDir getParseResultDir() throws IOException {
        if (resDir == null){
            resDir = new TempDir(STANDALONE);
        }

        return resDir;
    }

    public void close() {
        try {
            if (resFile != null && !resFile.isDirectory()){
                Files.deleteIfExists(resFile.toPath());
            }
        } catch (Exception e) {
            // do nothing
        }

        try {
            if (resDir != null) {
                resDir.close();
            }
        } catch (Exception e) {
            // do nothing
        }
    }
}

/**
 * {@link ArgumentsProvider} implementation testing help message
 */
class UsageArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() {
        return new String[]{"--help"};
    }

    @Override
    public String output() {
        try {
            return new String(Files.readAllBytes(ApgdiffUtils.getFileFromOsgiRes(
                    MainTest.class.getResource("usage_check.txt")).toPath()),
                    StandardCharsets.UTF_8);
        } catch (IOException | URISyntaxException ex) {
            throw new IllegalStateException(ex);
        }
    }
}

/**
 * {@link ArgumentsProvider} implementation testing version message
 */
class VersionArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() {
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
class CharsetsArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() {
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
class EmptyArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() {
        return new String[]{};
    }

    @Override
    public String output() {
        try {
            return new String(Files.readAllBytes(ApgdiffUtils.getFileFromOsgiRes(
                    MainTest.class.getResource("usage_check.txt")).toPath()),
                    StandardCharsets.UTF_8);
        } catch (IOException | URISyntaxException ex) {
            throw new IllegalStateException(ex);
        }
    }
}

/**
 * {@link ArgumentsProvider} implementation testing src + target mode
 */
class SourceTargerArgumentsProvider extends ArgumentsProvider {

    protected SourceTargerArgumentsProvider() {
        super(TestType.TEST_DIFF, "drop_table");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"-S", "-D", "DROP_TABLE", "-o", getDiffResultFile().getAbsolutePath(),
                "-t", fOriginal.getAbsolutePath(), "-s", fNew.getAbsolutePath()};
    }
}

/**
 * {@link ArgumentsProvider} implementation testing diff
 */
class AddTestArgumentsProvider extends ArgumentsProvider {

    protected AddTestArgumentsProvider() {
        super(TestType.TEST_DIFF, "add_cluster");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"-o", getDiffResultFile().getAbsolutePath(),
                "-t", fOriginal.getAbsolutePath(), "-s",  fNew.getAbsolutePath()};
    }
}

/**
 * {@link ArgumentsProvider} implementation testing diff
 */
class ModifyTestArgumentsProvider extends ArgumentsProvider {

    protected ModifyTestArgumentsProvider() {
        super(TestType.TEST_DIFF, "modify_function_args2");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"-o", getDiffResultFile().getAbsolutePath(),
                fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }
}

/**
 * {@link ArgumentsProvider} implementation testing wrong src/target using message error
 */
class FailSourceArgumentsProvider extends ArgumentsProvider {

    public FailSourceArgumentsProvider() {
        super(TestType.TEST_OUTPUT, "drop_table");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"--safe-mode", "--allow-danger-ddl", "DROP_TABLE",
                "--output", getDiffResultFile().getAbsolutePath(),
                "-s", fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }

    @Override
    public String output() {
        return "option \"-s (--source)\" requires the option(s) [-t]\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing src/target using in parse mode error message
 */
class FailParseArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[]{"--parse", "-o", "out", "-s", "dumb", "--target", "tgt"};
    }

    @Override
    public String output() {
        return "option \"-t (--target)\" cannot be used with the option(s) [--parse]\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing dangerous statements ERROR
 */
class FailDangerTableArgumentsProvider extends ArgumentsProvider{

    public FailDangerTableArgumentsProvider() {
        super(TestType.TEST_OUTPUT, "drop_table");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{ "-S", "-o", getDiffResultFile().getAbsolutePath(),
                fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }

    @Override
    public String output() {
        return "Script contains dangerous statements: DROP_TABLE. Use --allow-danger-ddl to override.\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing successful dangerous statements
 */
class DangerTableArgumentsProvider extends ArgumentsProvider {

    public DangerTableArgumentsProvider() {
        super(TestType.TEST_DIFF, "drop_table");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"--safe-mode", "--allow-danger-ddl", "DROP_TABLE",
                "-o", getDiffResultFile().getAbsolutePath(),
                fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }
}

/**
 * {@link ArgumentsProvider} implementation testing dangerous statements ERROR
 */
class FailDangerDropColArgumentsProvider extends ArgumentsProvider {

    public FailDangerDropColArgumentsProvider() {
        super(TestType.TEST_OUTPUT, "drop_column");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"-S", "-o", getDiffResultFile().getAbsolutePath(),
                fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }

    @Override
    public String output() {
        return "Script contains dangerous statements: DROP_COLUMN. Use --allow-danger-ddl to override.\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing successful dangerous statements
 */
class DangerDropColArgumentsProvider extends ArgumentsProvider {

    public DangerDropColArgumentsProvider() {
        super(TestType.TEST_DIFF, "drop_column");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"-S", "-D", "DROP_COLUMN",
                "-o", getDiffResultFile().getAbsolutePath(),
                fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }
}

/**
 * {@link ArgumentsProvider} implementation testing dangerous statements ERROR
 */
class FailDangerAlterColArgumentsProvider extends ArgumentsProvider {

    public FailDangerAlterColArgumentsProvider() {
        super(TestType.TEST_OUTPUT, "modify_column_type");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"--safe-mode", "--output", getDiffResultFile().getAbsolutePath(),
                fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }

    @Override
    public String output() {
        return "Script contains dangerous statements: ALTER_COLUMN. Use --allow-danger-ddl to override.\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing successful dangerous statements
 */
class DangerAlterColArgumentsProvider extends ArgumentsProvider {

    public DangerAlterColArgumentsProvider() {
        super(TestType.TEST_DIFF, "modify_column_type");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"--safe-mode", "--allow-danger-ddl",
                "ALTER_COLUMN", "-o", getDiffResultFile().getAbsolutePath(),
                fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }
}

/**
 * {@link ArgumentsProvider} implementation testing ALTER SEQUENCE RESTART WITH
 * dangerous statements
 */
class FailDangerRestartArgumentsProvider extends ArgumentsProvider {

    public FailDangerRestartArgumentsProvider() {
        super(TestType.TEST_OUTPUT, "modify_sequence_start_ignore_off");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"--safe-mode", "-o", getDiffResultFile().getAbsolutePath(),
                fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }

    @Override
    public String output() {
        return "Script contains dangerous statements: RESTART_WITH. Use --allow-danger-ddl to override.\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing successfull ALTER SEQUENCE RESTART WITH
 * dangerous statements
 */
class DangerRestartAgumentsProvider extends ArgumentsProvider {

    public DangerRestartAgumentsProvider() {
        super(TestType.TEST_OUTPUT, "modify_sequence_start_ignore_off");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"--safe-mode", "--allow-danger-ddl",
                "RESTART_WITH", "-o", getDiffResultFile().getAbsolutePath(),
                fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }
}

/**
 * {@link ArgumentsProvider} implementation testing UPDATE dangerous statements
 */
class FailDangerUpdateArgumentsProvider extends ArgumentsProvider {

    public FailDangerUpdateArgumentsProvider() {
        super(TestType.TEST_OUTPUT, "add_not_null");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"--safe-mode", "-o", getDiffResultFile().getAbsolutePath(),
                fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }

    @Override
    public String output() {
        return "Script contains dangerous statements: UPDATE. Use --allow-danger-ddl to override.\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing successfull UPDATE dangerous statements
 */
class DangerUpdateAgumentsProvider extends ArgumentsProvider {

    public DangerUpdateAgumentsProvider() {
        super(TestType.TEST_OUTPUT, "add_column_add_defaults");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"--safe-mode", "--allow-danger-ddl",
                "UPDATE", "-o", getDiffResultFile().getAbsolutePath(),
                fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }
}

/**
 * {@link ArgumentsProvider} implementation testing all other flags
 */
class FlagsArgumentsProvider extends ArgumentsProvider {

    public FlagsArgumentsProvider() {
        super(TestType.TEST_DIFF, "modify_column_type");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"--safe-mode", "-X", "-F", "-Z", "UTC",
                "-D", "ALTER_COLUMN", "--output", getDiffResultFile().getAbsolutePath(),
                fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }

    @Override
    public File getPredefinedResultFile() throws URISyntaxException, IOException {
        URL resourceUrl = PgDiffTest.class.getResource("MainTest_" + resName + FILES_POSTFIX.DIFF_SQL);
        return ApgdiffUtils.getFileFromOsgiRes(resourceUrl);
    }
}

/**
 * {@link ArgumentsProvider} implementation testing parsing option
 */
class ParseTestArgumentsProvider extends ArgumentsProvider {

    public ParseTestArgumentsProvider() {
        super(TestType.TEST_PARSE, "parse_test.sql");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File db = ApgdiffUtils.getFileFromOsgiRes(PgDiffTest.class.getResource(resName));
        return new String[]{"--parse", "-o", getParseResultDir().get().toFile().getAbsolutePath(), db.getAbsolutePath()};
    }
}

/**
 * {@link ArgumentsProvider} implementation for IgnoreList test
 */
class IgnoreListsArgumentsProvider extends ArgumentsProvider {

    public IgnoreListsArgumentsProvider() {
        super(TestType.TEST_DIFF, "ignore");
    }

    @Override
    protected String[] args() throws URISyntaxException, IOException {
        File black = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource("black.ignore"));
        File white = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource("white.ignore"));
        File old = ApgdiffUtils.getFileFromOsgiRes(PgDiffTest.class.getResource("ignore_old.sql"));
        File new_ = ApgdiffUtils.getFileFromOsgiRes(PgDiffTest.class.getResource("ignore_new.sql"));

        return new String[] {"--ignore-list", black.getAbsolutePath(),
                "-I", white.getAbsolutePath(), "-o", getDiffResultFile().getAbsolutePath(),
                new_.getAbsolutePath(), old.getAbsolutePath()};
    }
}

/**
 * {@link ArgumentsProvider} implementation for AllowedObjects test
 */
class AllowedObjectsArgumentsProvider extends ArgumentsProvider {

    public AllowedObjectsArgumentsProvider() {
        super(TestType.TEST_DIFF, "same_allowed_object");
    }

    @Override
    protected String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);
        return new String[]{"--allowed-object", "FUNCTION", "--allowed-object", "VIEW",
                "-O", "INDEX", "-o", getDiffResultFile().getAbsolutePath(),
                fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }
}

/**
 * {@link ArgumentsProvider} implementation testing -X and -C options using in same time error message
 */
class FailConcurrentlyArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[]{"-o", "out", "-s", "dumb", "--target", "tgt", "-X", "-C"};
    }

    @Override
    public String output() {
        return "-C (--concurrently-mode) cannot be used with the option(s) -X (--add-transaction) for PostgreSQL.\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing CREATE INDEX CONCURRENTLY options with output to console
 */
class ConcurrentlyArgumentsProvider extends ArgumentsProvider {

    public ConcurrentlyArgumentsProvider() {
        super(TestType.TEST_OUTPUT, "add_index");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"-C", fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }

    @Override
    public String output() {
        return "SET search_path = pg_catalog;\n\n" +
                "CREATE INDEX CONCURRENTLY testindex3 ON public.testtable USING btree (field3);\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing CREATE INDEX CONCURRENTLY
 * options for MS SQL in TRANSACTION with output to console
 */
class MsConcurrentlyArgumentsProvider extends ArgumentsProvider {

    public MsConcurrentlyArgumentsProvider() {
        super(TestType.TEST_OUTPUT, "add_ms_index");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"-C", "-X", "--ms-sql", fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }

    @Override
    public String output() {
        return "BEGIN TRANSACTION\nGO\n\nCREATE CLUSTERED INDEX [index_c2] ON [dbo].[table1] ([c2])\n" +
                "WITH (ONLINE = ON)\nGO\n\nCOMMIT\nGO\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing MS SQL database without --ms-sql mode
 */
class FailMsArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[]{"-s", "dumb", "--target", "jdbc:sqlserver://xxx"};
    }

    @Override
    public String output() {
        return "Cannot work with MS SQL database without --ms-sql parameter.\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing PostgreSQL database with --ms-sql mode
 */
class FailPgArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[]{"--ms-sql", "-s", "dumb", "--target", "jdbc:postgresql://xxx"};
    }

    @Override
    public String output() {
        return "Cannot work with PostgreSQL database with --ms-sql parameter.\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing compare PostgreSQL and MS SQL databases
 */
class FailCompareArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[]{"-s", "jdbc:sqlserver://xxx", "--target", "jdbc:postgresql://xxx"};
    }

    @Override
    public String output() {
        return "Cannot compare MS SQL and PostgerSQL databases.\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing parse PostgreSQL database as MS SQL project
 */
class FailMsParseArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[]{"--ms-sql", "--parse", "-o", "dir", "jdbc:postgresql://xxx"};
    }

    @Override
    public String output() {
        return "Cannot parse PostgerSQL database as MS SQL project.\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing parse MS SQL database as PostgreSQL project
 */
class FailPgParseArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[]{"--parse", "-o", "dir", "jdbc:sqlserver://xxx"};
    }

    @Override
    public String output() {
        return "Cannot parse MS SQL database as PostgerSQL project.\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation for libraries test
 */
class LibrariesArgumentsProvider extends ArgumentsProvider {

    public LibrariesArgumentsProvider() {
        super(TestType.TEST_DIFF, "libraries");
    }

    @Override
    protected String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);
        File lib = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource("lib.sql"));

        return new String[] {"-o", getDiffResultFile().getAbsolutePath(),
                "-t", fOriginal.getAbsolutePath(), "-s", fNew.getAbsolutePath(),
                "--tgt-lib", lib.getAbsolutePath()};
    }
}

/**
 * {@link ArgumentsProvider} implementation for libraries test with override
 */
class OverrideArgumentsProvider extends ArgumentsProvider {

    public OverrideArgumentsProvider() {
        super(TestType.TEST_OUTPUT, "libraries");
    }

    @Override
    protected String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);
        File lib = ApgdiffUtils.getFileFromOsgiRes(MainTest.class.getResource("lib.sql"));

        return new String[] {"-o", getDiffResultFile().getAbsolutePath(),
                "-t", fOriginal.getAbsolutePath(), "-s", fNew.getAbsolutePath(),
                "--src-lib", lib.getAbsolutePath()};
    }
}