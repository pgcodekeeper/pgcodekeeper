package cz.startnet.utils.pgdiff;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
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
public class ParseTest {

    @Parameters
    public static Iterable<ArgumentsProvider[]> parameters() {
        List<ArgumentsProvider[]> p = Arrays.asList(new ArgumentsProvider[][] {
            {new ParseTestArgumentsProvider()},
        });

        return p.stream()::iterator;
    }

    private final ArgumentsProvider args;

    public ParseTest(ArgumentsProvider args) {
        this.args = args;
    }

    @Test
    public void mainTest() throws IOException, URISyntaxException, InterruptedException {
        Main.main(args.args());
        String name = args.getClass().getSimpleName();
        assertTrue(name + " - .pgcodekeeper doesn't exist",
                Files.isRegularFile(args.getParseResultDir().get().resolve(".pgcodekeeper")));
        assertTrue(name + " - SCHEMA doesn't exist",
                Files.isDirectory(args.getParseResultDir().get().resolve("SCHEMA")));
    }

    @After
    public void closeResources() {
        args.close();
    }
}


/**
 * {@link ArgumentsProvider} implementation testing parsing option
 */
class ParseTestArgumentsProvider extends ArgumentsProvider {

    public ParseTestArgumentsProvider() {
        super("parse_test.sql");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        File db = ApgdiffUtils.getFileFromOsgiRes(PgDiffTest.class.getResource(resName));
        return new String[]{"--parse", "-o", getParseResultDir().get().toFile().getAbsolutePath(), db.getAbsolutePath()};
    }
}