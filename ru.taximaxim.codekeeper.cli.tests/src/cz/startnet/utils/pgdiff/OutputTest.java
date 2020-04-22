package cz.startnet.utils.pgdiff;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.osgi.framework.BundleContext;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.cli.Activator;
import ru.taximaxim.codekeeper.cli.Main;
import ru.taximaxim.codekeeper.cli.localizations.Messages;

@RunWith(value = Parameterized.class)
public class OutputTest {

    @Parameters
    public static Iterable<ArgumentsProvider[]> parameters() {
        List<ArgumentsProvider[]> p = Arrays.asList(new ArgumentsProvider[][] {
            {new UsageArgumentsProvider()},
            {new VersionArgumentsProvider()},
            {new CharsetsArgumentsProvider()},
            {new EmptyArgumentsProvider()},
            {new FailSourceArgumentsProvider()},
            {new FailParseArgumentsProvider()},
            {new FailDangerTableArgumentsProvider()},
            {new FailDangerDropColArgumentsProvider()},
            {new FailDangerAlterColArgumentsProvider()},
            {new FailDangerRestartArgumentsProvider()},
            {new DangerRestartArgumentsProvider()},
            {new FailDangerUpdateArgumentsProvider()},
            {new DangerUpdateArgumentsProvider()},
            {new FailConcurrentlyArgumentsProvider()},
            {new ConcurrentlyArgumentsProvider()},
            {new MsConcurrentlyArgumentsProvider()},
            {new FailMsArgumentsProvider()},
            {new FailPgArgumentsProvider()},
            {new FailCompareArgumentsProvider()},
            {new FailMsParseArgumentsProvider()},
            {new FailPgParseArgumentsProvider()},
            {new OverrideArgumentsProvider()},
            {new FailGraphReverseArgumentsProvider()},
            {new FailGraphDepthArgumentsProvider()},
            {new FailGraphNameArgumentsProvider()},
            {new FailGraphArgumentsProvider()},
        });

        return p.stream()::iterator;
    }

    private final ArgumentsProvider args;

    public OutputTest(ArgumentsProvider args) {
        this.args = args;
    }

    @Test
    public void mainTest() throws IOException, URISyntaxException, InterruptedException {
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
                    OutputTest.class.getResource("usage_check.txt")).toPath()),
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
                    OutputTest.class.getResource("usage_check.txt")).toPath()),
                    StandardCharsets.UTF_8);
        } catch (IOException | URISyntaxException ex) {
            throw new IllegalStateException(ex);
        }
    }
}

/**
 * {@link ArgumentsProvider} implementation testing wrong src/target using message error
 */
class FailSourceArgumentsProvider extends ArgumentsProvider {

    public FailSourceArgumentsProvider() {
        super("drop_ms_table");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"--safe-mode", "--ms-sql", "--allow-danger-ddl", "DROP_TABLE",
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
        return new String[]{"--parse", "-o", "out", "-s", "dumb", "-t", "tgt"};
    }

    @Override
    public String output() {
        return "option \"-t (--target)\" cannot be used with the option(s) [--graph, --parse]\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing dangerous statements ERROR
 */
class FailDangerTableArgumentsProvider extends ArgumentsProvider{

    public FailDangerTableArgumentsProvider() {
        super("drop_ms_table");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{ "-S", "--ms-sql", "-o", getDiffResultFile().getAbsolutePath(),
                fNew.getAbsolutePath(), fOriginal.getAbsolutePath()};
    }

    @Override
    public String output() {
        return "Script contains dangerous statements: DROP_TABLE. Use --allow-danger-ddl to override.\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing dangerous statements ERROR
 */
class FailDangerDropColArgumentsProvider extends ArgumentsProvider {

    public FailDangerDropColArgumentsProvider() {
        super("drop_column");
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
 * {@link ArgumentsProvider} implementation testing dangerous statements ERROR
 */
class FailDangerAlterColArgumentsProvider extends ArgumentsProvider {

    public FailDangerAlterColArgumentsProvider() {
        super("modify_column_type");
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
 * {@link ArgumentsProvider} implementation testing ALTER SEQUENCE RESTART WITH
 * dangerous statements
 */
class FailDangerRestartArgumentsProvider extends ArgumentsProvider {

    public FailDangerRestartArgumentsProvider() {
        super("modify_sequence_start_ignore_off");
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
 * {@link ArgumentsProvider} implementation testing successful ALTER SEQUENCE RESTART WITH
 * dangerous statements
 */
class DangerRestartArgumentsProvider extends ArgumentsProvider {

    public DangerRestartArgumentsProvider() {
        super("modify_sequence_start_ignore_off");
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
        super("add_not_null");
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
class DangerUpdateArgumentsProvider extends ArgumentsProvider {

    public DangerUpdateArgumentsProvider() {
        super("add_column_add_defaults");
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
        super("add_view_index");
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
                "CREATE INDEX CONCURRENTLY testindex ON public.testview USING btree (first);\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing CREATE INDEX CONCURRENTLY
 * options for MS SQL in TRANSACTION with output to console
 */
class MsConcurrentlyArgumentsProvider extends ArgumentsProvider {

    public MsConcurrentlyArgumentsProvider() {
        super("add_ms_index");
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
        return "Cannot work with PostgerSQL database as MS SQL project.\n";
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
        return "Cannot work with MS SQL database as PostgerSQL project.\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation for libraries test with override
 */
class OverrideArgumentsProvider extends ArgumentsProvider {

    public OverrideArgumentsProvider() {
        super("libraries");
    }

    @Override
    protected String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);
        File lib = ApgdiffUtils.getFileFromOsgiRes(OutputTest.class.getResource("lib.sql"));

        return new String[] {"-o", getDiffResultFile().getAbsolutePath(),
                "-t", fOriginal.getAbsolutePath(), "-s", fNew.getAbsolutePath(),
                "--src-lib", lib.getAbsolutePath()};
    }
}

/**
 * {@link ArgumentsProvider} implementation testing graph reverse ERROR
 */
class FailGraphReverseArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[]{"--graph-reverse", "--graph-name", "t1", "fisrt", "second"};
    }

    @Override
    public String output() {
        return "option --graph-name cannot be used without the option(s) [--graph]\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing graph depth ERROR
 */
class FailGraphDepthArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[]{"--graph-depth", "5", "tgt", "src"};
    }

    @Override
    public String output() {
        return "option --graph-depth cannot be used without the option(s) [--graph]\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing graph name ERROR
 */
class FailGraphNameArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[]{"--graph-name", "t1", "tgt", "src"};
    }

    @Override
    public String output() {
        return "option --graph-name cannot be used without the option(s) [--graph]\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing graph ERROR
 */
class FailGraphArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[]{"--graph", "--graph-reverse", "db"};
    }

    @Override
    public String output() {
        return "option \"--graph-reverse\" requires the option(s) [--graph-name]\n";
    }
}
