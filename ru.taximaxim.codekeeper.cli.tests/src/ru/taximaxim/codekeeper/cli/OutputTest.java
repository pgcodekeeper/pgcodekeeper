/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.cli;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.taximaxim.codekeeper.cli.localizations.Messages;

class OutputTest {

    private static Stream<Arguments> generator() {
        return Stream.of(
                Arguments.of(new UsageArgumentsProvider()),
                Arguments.of(new VersionArgumentsProvider()),
                Arguments.of(new CharsetsArgumentsProvider()),
                Arguments.of(new EmptyArgumentsProvider()),
                Arguments.of(new FailSourceArgumentsProvider()),
                Arguments.of(new FailParseArgumentsProvider()),
                Arguments.of(new FailDangerTableArgumentsProvider()),
                Arguments.of(new FailDangerDropColArgumentsProvider()),
                Arguments.of(new FailDangerAlterColArgumentsProvider()),
                Arguments.of(new FailDangerRestartArgumentsProvider()),
                Arguments.of(new DangerRestartArgumentsProvider()),
                Arguments.of(new FailDangerUpdateArgumentsProvider()),
                Arguments.of(new DangerUpdateArgumentsProvider()),
                Arguments.of(new FailConcurrentlyArgumentsProvider()),
                Arguments.of(new ConcurrentlyArgumentsProvider()),
                Arguments.of(new MsConcurrentlyArgumentsProvider()),
                Arguments.of(new FailMsArgumentsProvider()),
                Arguments.of(new FailPgArgumentsProvider()),
                Arguments.of(new FailCompareArgumentsProvider()),
                Arguments.of(new FailMsParseArgumentsProvider()),
                Arguments.of(new FailPgParseArgumentsProvider()),
                Arguments.of(new OverrideArgumentsProvider()),
                Arguments.of(new FailGraphReverseArgumentsProvider()),
                Arguments.of(new FailGraphDepthArgumentsProvider()),
                Arguments.of(new FailGraphNameArgumentsProvider()),
                Arguments.of(new FailGraphArgumentsProvider()),
                Arguments.of(new IgnoreColumnOrderArgumentsProvider()),
                Arguments.of(new MsDeprecatedOption()));
    }

    @ParameterizedTest
    @MethodSource("generator")
    void mainTest(ArgumentsProvider args) throws IOException, URISyntaxException {
        PrintStream old = System.out;
        PrintStream olde = System.err;
        try (args;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos)) {
            System.setOut(ps);
            System.setErr(ps);

            Main.main(args.args());

            System.out.flush();
            Assertions.assertEquals(args.output(), baos.toString().replace("\r\n", "\n"),
                    args.getClass().getSimpleName() + " - Output is not as expected");
        } finally {
            System.setOut(old);
            System.setErr(olde);
        }
    }
}

/**
 * {@link ArgumentsProvider} implementation testing help message
 */
class UsageArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() {
        return new String[] { "--help" };
    }

    @Override
    public String output() {
        try {
            return TestUtils.readResource(OutputTest.class, "usage_check.txt");
        } catch (IOException ex) {
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
        return new String[] { "--version" };
    }

    @Override
    public String output() {
        return MessageFormat.format(Messages.Version, Utils.getVersion()) + '\n';
    }
}

/**
 * {@link ArgumentsProvider} implementation testing list-charsets message
 */
class CharsetsArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() {
        return new String[] { "--list-charsets" };
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
        return new String[] {};
    }

    @Override
    public String output() {
        try {
            return TestUtils.readResource(OutputTest.class, "usage_check.txt");
        } catch (IOException ex) {
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
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[] { "--safe-mode", "--db-type", "MS", "--allow-danger-ddl", "DROP_TABLE",
                "--output", getDiffResultFile().toString(),
                "-s", fNew.toString(), fOriginal.toString() };
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
        return new String[] { "--parse", "-o", "out", "-s", "dumb", "-t", "tgt" };
    }

    @Override
    public String output() {
        return "option \"-t (--target)\" cannot be used with the option(s) [--graph, --parse]\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing dangerous statements ERROR
 */
class FailDangerTableArgumentsProvider extends ArgumentsProvider {

    public FailDangerTableArgumentsProvider() {
        super("drop_ms_table");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[] { "-S", "--db-type", "MS", "-o", getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString() };
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
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[] { "-S", "-o", getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString() };
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
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[] { "--safe-mode", "--output", getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString() };
    }

    @Override
    public String output() {
        return "Script contains dangerous statements: ALTER_COLUMN. Use --allow-danger-ddl to override.\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing ALTER SEQUENCE RESTART WITH dangerous statements
 */
class FailDangerRestartArgumentsProvider extends ArgumentsProvider {

    public FailDangerRestartArgumentsProvider() {
        super("modify_sequence_start_ignore_off");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[] { "--safe-mode", "-o", getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString() };
    }

    @Override
    public String output() {
        // return "Script contains dangerous statements: RESTART_WITH. Use --allow-danger-ddl to override.\n";
        // TODO we do not generate RESTART anymore
        return "";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing successful ALTER SEQUENCE RESTART WITH dangerous statements
 */
class DangerRestartArgumentsProvider extends ArgumentsProvider {

    public DangerRestartArgumentsProvider() {
        super("modify_sequence_start_ignore_off");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[] { "--safe-mode", "--allow-danger-ddl",
                "RESTART_WITH", "-o", getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString() };
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
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[] { "--safe-mode", "-o", getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString() };
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
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[] { "--safe-mode", "--allow-danger-ddl",
                "UPDATE", "-o", getDiffResultFile().toString(),
                fNew.toString(), fOriginal.toString() };
    }
}

/**
 * {@link ArgumentsProvider} implementation testing -X and -C options using in same time error message
 */
class FailConcurrentlyArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[] { "-o", "out", "-s", "dumb", "--target", "tgt", "-X", "-C" };
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
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[] { "-C", fNew.toString(), fOriginal.toString() };
    }

    @Override
    public String output() {
        return "SET search_path = pg_catalog;\n\n" +
                "CREATE INDEX CONCURRENTLY testindex ON public.testview USING btree (first);\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing CREATE INDEX CONCURRENTLY options for MS SQL in TRANSACTION with
 * output to console
 */
class MsConcurrentlyArgumentsProvider extends ArgumentsProvider {

    public MsConcurrentlyArgumentsProvider() {
        super("add_ms_index");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[] { "-C", "-X", "--db-type", "MS", fNew.toString(), fOriginal.toString() };
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
        return new String[] { "-s", "dumb", "--target", "jdbc:sqlserver://xxx" };
    }

    @Override
    public String output() {
        return "Cannot work with MS SQL database without --db-type MS parameter.\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing PostgreSQL database with --ms-sql mode
 */
class FailPgArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[] { "--db-type", "MS", "-s", "dumb", "--target", "jdbc:postgresql://xxx" };
    }

    @Override
    public String output() {
        return "Cannot work with PostgreSQL database with --db-type MS parameter.\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing compare PostgreSQL and MS SQL databases
 */
class FailCompareArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[] { "-s", "jdbc:sqlserver://xxx", "--target", "jdbc:postgresql://xxx" };
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
        return new String[] { "--db-type", "MS", "--parse", "-o", "dir", "jdbc:postgresql://xxx" };
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
        return new String[] { "--parse", "-o", "dir", "jdbc:sqlserver://xxx" };
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
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);
        Path lib = TestUtils.getPathToResource(OutputTest.class, "lib.sql");

        return new String[] { "-o", getDiffResultFile().toString(),
                "-t", fOriginal.toString(), "-s", fNew.toString(),
                "--src-lib", lib.toString() };
    }
}

/**
 * {@link ArgumentsProvider} implementation testing graph reverse ERROR
 */
class FailGraphReverseArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[] { "--graph-reverse", "fisrt", "second" };
    }

    @Override
    public String output() {
        return "option \"--graph-reverse\" requires the option(s) [--graph-name, --graph]\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing graph depth ERROR
 */
class FailGraphDepthArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[] { "--graph-depth", "5", "tgt", "src" };
    }

    @Override
    public String output() {
        return "option \"--graph-depth\" requires the option(s) [--graph]\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing graph name ERROR
 */
class FailGraphNameArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[] { "--graph-name", "t1", "tgt", "src" };
    }

    @Override
    public String output() {
        return "option \"--graph-name\" requires the option(s) [--graph]\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing graph ERROR
 */
class FailGraphArgumentsProvider extends ArgumentsProvider {

    @Override
    public String[] args() throws URISyntaxException, IOException {
        return new String[] { "--graph", "--graph-reverse", "db" };
    }

    @Override
    public String output() {
        return "option \"--graph-reverse\" requires the option(s) [--graph-name, --graph]\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing table column order
 */
class IgnoreColumnOrderArgumentsProvider extends ArgumentsProvider {

    public IgnoreColumnOrderArgumentsProvider() {
        super("modify_column_order");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[] { "--ignore-column-order", fNew.toString(), fOriginal.toString() };
    }

    @Override
    public String output() {
        return "\n";
    }
}

/**
 * {@link ArgumentsProvider} implementation testing  with deprecated --ms-sql option
 */
class MsDeprecatedOption extends ArgumentsProvider {

    public MsDeprecatedOption() {
        super("drop_ms_table");
    }

    @Override
    public String[] args() throws URISyntaxException, IOException {
        Path fNew = getFile(FILES_POSTFIX.NEW_SQL);
        Path fOriginal = getFile(FILES_POSTFIX.ORIGINAL_SQL);

        return new String[] { "--safe-mode", "--ms-sql", "--allow-danger-ddl", "DROP_TABLE",
                "--output", getDiffResultFile().toString(),
                "-s", fNew.toString(), fOriginal.toString() };
    }

    @Override
    public String output() {
        return "option \"-s (--source)\" requires the option(s) [-t]\n";
    }
}
