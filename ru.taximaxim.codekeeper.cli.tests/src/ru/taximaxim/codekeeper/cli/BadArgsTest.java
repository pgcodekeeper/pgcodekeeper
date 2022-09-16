package ru.taximaxim.codekeeper.cli;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.kohsuke.args4j.CmdLineException;

@RunWith(value = Parameterized.class)
public class BadArgsTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new String[] { "--parse" },
                        "option \"--parse\" requires the option(s) [-o]" },

                { new String[] { "--parse", "-o" },
                        "Option \"-o (--output)\" takes an operand" },

                { new String[] { "--parse", "-s", "filename", "-t", "filename", "-o", "filename" },
                        "option \"-t (--target)\" cannot be used with the option(s) [--graph, --parse]" },

                { new String[] { "--graph", "--ms-sql", "jdbc:postgresql:q" },
                        "Cannot work with PostgerSQL database as MS SQL project." },

                { new String[] { "--graph", "jdbc:sqlserver:f" },
                        "Cannot work with MS SQL database as PostgerSQL project." },

                { new String[] { "--graph", "jdbc:postgresql:q", "jdbc:postgresql:q2" },
                        "DEST argument doesn't require." },

                { new String[] { "--graph" },
                        "Please specify SCHEMA." },

                { new String[] { "jdbc:postgresql:q" },
                        "Please specify both SOURCE and DEST." },

                { new String[] { "jdbc:postgresql:q", "jdbc:postgresql:q2", "-X", "-C" },
                        "-C (--concurrently-mode) cannot be used with the option(s) -X (--add-transaction) for PostgreSQL." },

                { new String[] { "jdbc:sqlserver:f", "jdbc:postgresql:q2" },
                        "Cannot compare MS SQL and PostgerSQL databases." },

                { new String[] { "jdbc:postgresql:q2", "jdbc:sqlserver:f" },
                        "Cannot compare MS SQL and PostgerSQL databases." },

                { new String[] { "jdbc:sqlserver:f", "filename" },
                        "Cannot work with MS SQL database without --ms-sql parameter." },

                { new String[] { "filename", "jdbc:sqlserver:f" },
                        "Cannot work with MS SQL database without --ms-sql parameter." },

                { new String[] { "jdbc:postgresql:q2", "filename", "--ms-sql" },
                        "Cannot work with PostgreSQL database with --ms-sql parameter." },

                { new String[] { "filename", "jdbc:postgresql:q2", "--ms-sql" },
                        "Cannot work with PostgreSQL database with --ms-sql parameter." },

                { new String[] { "-r", "filename", "filename" },
                        "Cannot run script on non-database target." },

                { new String[] { "-R", "filename", "filename", "filename" },
                        "Option -R (--run-on) must specify JDBC connection string." },

                { new String[] { "filename", "filename", "--simplify-views", "--ms-sql" },
                        "option \"--simplify-views\" cannot be used with the option(s) [--ms-sql]" },
        });
    }

    private final String[] args;
    private final String message;

    public BadArgsTest(final String[] args, String message) {
        this.args = args;
        this.message = message;
    }

    @Test
    public void runBadArgs() {
        CliArgs cliArgs = new CliArgs();
        try {
            cliArgs.parse(null, args);
            Assert.fail();
        } catch (CmdLineException e) {
            Assert.assertEquals(message, e.getMessage());
        }
    }
}
