package ru.taximaxim.codekeeper.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ru.taximaxim.codekeeper.cli.Main;

@RunWith(value = Parameterized.class)
public class DiffTest {

    @Parameters
    public static Iterable<Object[]> parameters() {
        return TestUtils.getParameters(new Object[][] {
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
            {new SelectedOnlyArgumentsProvider()},
            {new MoveDataArgumentsProvider()},
            {new MoveDataIdentityArgumentsProvider()},
            {new MoveDataMSArgumentsProvider()},
            {new MoveDataMSIdentityArgumentsProvider()},
            {new MoveDataDiffColsIdentityArgumentsProvider()},
            {new MoveDataDropTableWithoutRename()},
            {new MoveDataForeignArgumentsProvider()},
            {new AddConstraintNotValid()},
        });
    }

    private final ArgumentsProvider args;

    public DiffTest(ArgumentsProvider args) {
        this.args = args;
    }

    @Test
    public void mainTest() throws IOException, URISyntaxException, InterruptedException {
        boolean result = Main.main(args.args());
        Path resFile = args.getDiffResultFile();
        Path predefined = args.getPredefinedResultFile();
        String name = args.getClass().getSimpleName();

        assertTrue(name + " - Diff finished with error", result);
        assertTrue(name + " - Predefined file does not exist: "
                + predefined, Files.exists(predefined));
        assertTrue(name + " - Resulting file does not exist: "
                + resFile, Files.exists(resFile));

        assertFalse(name + " - Predefined file is a directory: "
                + predefined, Files.isDirectory(predefined));
        assertFalse(name + " - Resulting file is a directory: "
                + resFile, Files.isDirectory(resFile));
        if (!filesEqualIgnoreNewLines(predefined, resFile)) {
            assertEquals(name + " - Predefined and resulting script differ",
                    new String(Files.readAllBytes(predefined), StandardCharsets.UTF_8),
                    args.getDiffFileContents());
        }
    }

    @After
    public void closeResources() {
        args.close();
    }

    private boolean filesEqualIgnoreNewLines(Path f1, Path f2) throws IOException {
        try (BufferedReader reader1 = Files.newBufferedReader(f1, StandardCharsets.UTF_8);
                BufferedReader reader2 = Files.newBufferedReader(f2, StandardCharsets.UTF_8);) {

            while (true) {
                String line1 = getNextLine(reader1);
                String line2 = getNextLine(reader2);
                if (!Objects.equals(line1, line2)) {
                    return false;
                }

                if (line1 == null || line2 == null) {
                    return line1 == line2;
                }
            }
        }
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

abstract class DataMovementArgumentsProvider extends RandomOutputArgumentsProvider {

    private static final Pattern RANDOM_RENAMED_TABLE = Pattern.compile("tbl_([0-9a-fA-F]{32})");

    public DataMovementArgumentsProvider(String resName) {
        super(resName);
    }

    @Override
    protected String findRandomPart(String contents) {
        Matcher matcher = RANDOM_RENAMED_TABLE.matcher(contents);
        matcher.find();
        return matcher.group(1);
    }

    @Override
    protected String getRandomReplacement() {
        return "randomly_generated_part";
    }
}
/**
 * {@link ArgumentsProvider} implementation testing src + target mode
 */
class SourceTargerArgumentsProvider extends ArgumentsProvider {

    protected SourceTargerArgumentsProvider() {
        super("drop_ms_table");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"-S", "--ms-sql", "-D", "DROP_TABLE", "-o", getDiffResultFile().toString(),
                "-t", fOriginal.toString(), "-s", fNew.toString()};
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
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"-o", getDiffResultFile().toString(),
                "-t", fOriginal.toString(), "-s",  fNew.toString()};
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
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"-o", getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString()};
    }
}

/**
 * {@link ArgumentsProvider} implementation testing successful dangerous statements
 */
class DangerTableArgumentsProvider extends ArgumentsProvider {

    public DangerTableArgumentsProvider() {
        super("drop_ms_table");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"--safe-mode", "--ms-sql", "--allow-danger-ddl", "DROP_TABLE",
                "-o", getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString()};
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
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"-S", "-D", "DROP_COLUMN",
                "-o", getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString()};
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
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"--safe-mode", "--allow-danger-ddl",
                "ALTER_COLUMN", "-o", getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString()};
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
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[]{"--safe-mode", "-X", "-F", "-Z", "UTC",
                "-D", "ALTER_COLUMN", "--output", getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString()};
    }

    @Override
    public Path getPredefinedResultFile() throws URISyntaxException, IOException {
        URL resourceUrl = PgDiffTest.class.getResource("MainTest_" + resName + FILES_POSTFIX.DIFF_SQL);
        return Utils.getFileFromOsgiRes(resourceUrl);
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
        Path black = Utils.getFileFromOsgiRes(DiffTest.class.getResource("black.ignore"));
        Path white = Utils.getFileFromOsgiRes(DiffTest.class.getResource("white.ignore"));
        Path old = Utils.getFileFromOsgiRes(PgDiffTest.class.getResource("ignore_old.sql"));
        Path new_ = Utils.getFileFromOsgiRes(PgDiffTest.class.getResource("ignore_new.sql"));

        return new String[] {"--ignore-list", black.toString(),
                "-I", white.toString(), "-o", getDiffResultFile().toString(),
                new_.toString(), old.toString()};
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
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);
        return new String[]{"--allowed-object", "FUNCTION", "--allowed-object", "VIEW",
                "-O", "INDEX", "-o", getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString()};
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
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);
        Path lib = Utils.getFileFromOsgiRes(DiffTest.class.getResource("lib.sql"));

        return new String[] {"-o", getDiffResultFile().toString(),
                "-t", fOriginal.toString(), "-s", fNew.toString(),
                "--tgt-lib", lib.toString()};
    }
}

/**
 * {@link ArgumentsProvider} implementation for test the use in script only
 * objects with difference
 */
class SelectedOnlyArgumentsProvider extends ArgumentsProvider {

    public SelectedOnlyArgumentsProvider() {
        super("selected_only");
    }

    @Override
    protected String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);
        return new String[]{"--selected-only", "-o",
                getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString()};
    }
}

/**
 * {@link ArgumentsProvider} implementation for data movement test in PG
 * (without identity columns)
 */
class MoveDataArgumentsProvider extends DataMovementArgumentsProvider {

    public MoveDataArgumentsProvider() {
        super("move_data");
    }

    @Override
    protected String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);
        return new String[]{"--migrate-data", "-o",
                getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString()};
    }
}

/**
 * {@link ArgumentsProvider} implementation for data movement test in PG
 * (with identity columns)
 */
class MoveDataIdentityArgumentsProvider extends DataMovementArgumentsProvider {

    public MoveDataIdentityArgumentsProvider() {
        super("move_data_identity");
    }

    @Override
    protected String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);
        return new String[]{"--migrate-data", "-o",
                getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString()};
    }
}

/**
 * {@link ArgumentsProvider} implementation for data movement test in MS
 *  (without identity columns)
 */
class MoveDataMSArgumentsProvider extends DataMovementArgumentsProvider {

    public MoveDataMSArgumentsProvider() {
        super("move_data_ms");
    }

    @Override
    protected String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);
        return new String[]{"--migrate-data", "--ms-sql", "-o",
                getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString()};
    }
}

/**
 * {@link ArgumentsProvider} implementation for data movement test in MS
 * (with identity column)
 */
class MoveDataMSIdentityArgumentsProvider extends DataMovementArgumentsProvider {

    public MoveDataMSIdentityArgumentsProvider() {
        super("move_data_ms_identity");
    }

    @Override
    protected String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);
        return new String[]{"--migrate-data", "--ms-sql", "-o",
                getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString()};
    }
}

/**
 * {@link ArgumentsProvider} implementation for data movement test in PG
 * for case with different columns
 * (with identity columns)
 */
class MoveDataDiffColsIdentityArgumentsProvider extends DataMovementArgumentsProvider {

    public MoveDataDiffColsIdentityArgumentsProvider() {
        super("move_data_diff_cols_identity");
    }

    @Override
    protected String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);
        return new String[]{"--migrate-data", "-o",
                getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString()};
    }
}

class MoveDataDropTableWithoutRename extends ArgumentsProvider {

    public MoveDataDropTableWithoutRename() {
        super("drop_ms_table");
    }

    @Override
    protected String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);
        return new String[]{"--migrate-data", "--ms-sql", "-o",
                getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString()};
    }
}

/**
 * {@link ArgumentsProvider} implementation for foreign table data movement test in PG
 */
class MoveDataForeignArgumentsProvider extends ArgumentsProvider {

    public MoveDataForeignArgumentsProvider() {
        super("move_data_foreign");
    }

    @Override
    protected String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);
        return new String[] { "--migrate-data", "-o",
                getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString() };
    }
}

/**
 * {@link ArgumentsProvider} implementation for generate CONSTRAINT NOT VALID test
 */
class AddConstraintNotValid extends ArgumentsProvider {

    public AddConstraintNotValid() {
        super("generate_constraint_not_valid");
    }

    @Override
    protected String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[] {"--generate-constraint-not-valid", "-o", getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString()};
    }
}
