package cz.startnet.utils.pgdiff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.cli.Main;

@RunWith(value = Parameterized.class)
public class DiffTest {

    @Parameters
    public static Iterable<ArgumentsProvider[]> parameters() {
        List<ArgumentsProvider[]> p = Arrays.asList(new ArgumentsProvider[][] {
            {new SourceTargerArgumentsProvider()},
            {new AddTestArgumentsProvider()},
            {new ModifyTestArgumentsProvider()},
            {new DangerTableArgumentsProvider()},
            {new DangerDropColArgumentsProvider()},
            {new DangerAlterColArgumentsProvider()},
            {new FlagsArgumentsProvider()},
            {new IgnoreListsArgumentsProvider()},
            {new AllowedObjectsArgumentsProvider()},
            {new LibrariesArgumentsProvider()},
        });

        return p.stream()::iterator;
    }

    private final ArgumentsProvider args;

    public DiffTest(ArgumentsProvider args) {
        this.args = args;
    }

    @Test
    public void mainTest() throws IOException, URISyntaxException, InterruptedException {
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

/**
 * {@link ArgumentsProvider} implementation testing src + target mode
 */
class SourceTargerArgumentsProvider extends ArgumentsProvider {

    protected SourceTargerArgumentsProvider() {
        super("drop_table");
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
        super("add_cluster");
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
        super("modify_function_args2");
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
 * {@link ArgumentsProvider} implementation testing successful dangerous statements
 */
class DangerTableArgumentsProvider extends ArgumentsProvider {

    public DangerTableArgumentsProvider() {
        super("drop_table");
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
 * {@link ArgumentsProvider} implementation testing successful dangerous statements
 */
class DangerDropColArgumentsProvider extends ArgumentsProvider {

    public DangerDropColArgumentsProvider() {
        super("drop_column");
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
 * {@link ArgumentsProvider} implementation testing successful dangerous statements
 */
class DangerAlterColArgumentsProvider extends ArgumentsProvider {

    public DangerAlterColArgumentsProvider() {
        super("modify_column_type");
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
 * {@link ArgumentsProvider} implementation testing all other flags
 */
class FlagsArgumentsProvider extends ArgumentsProvider {

    public FlagsArgumentsProvider() {
        super("modify_column_type");
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
 * {@link ArgumentsProvider} implementation for IgnoreList test
 */
class IgnoreListsArgumentsProvider extends ArgumentsProvider {

    public IgnoreListsArgumentsProvider() {
        super("ignore");
    }

    @Override
    protected String[] args() throws URISyntaxException, IOException {
        File black = ApgdiffUtils.getFileFromOsgiRes(DiffTest.class.getResource("black.ignore"));
        File white = ApgdiffUtils.getFileFromOsgiRes(DiffTest.class.getResource("white.ignore"));
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
        super("same_allowed_object");
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
 * {@link ArgumentsProvider} implementation for libraries test
 */
class LibrariesArgumentsProvider extends ArgumentsProvider {

    public LibrariesArgumentsProvider() {
        super("libraries");
    }

    @Override
    protected String[] args() throws URISyntaxException, IOException {
        File fNew = getFile(FILES_POSTFIX.NEW_SQL);
        File fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);
        File lib = ApgdiffUtils.getFileFromOsgiRes(DiffTest.class.getResource("lib.sql"));

        return new String[] {"-o", getDiffResultFile().getAbsolutePath(),
                "-t", fOriginal.getAbsolutePath(), "-s", fNew.getAbsolutePath(),
                "--tgt-lib", lib.getAbsolutePath()};
    }
}
