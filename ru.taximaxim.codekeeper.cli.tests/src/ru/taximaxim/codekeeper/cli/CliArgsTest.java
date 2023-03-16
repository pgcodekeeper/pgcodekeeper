/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.kohsuke.args4j.CmdLineException;

class CliArgsTest {

    @ParameterizedTest(name = "{0}")
    @CsvSource(delimiter = ';', value = {
            "--parse;" +
                    "option \"--parse\" requires the option(s) [-o];",

            "--parse -o;" +
                    "Option \"-o (--output)\" takes an operand",

            "--parse -s filename -t filename -o filename;" +
                    "option \"-t (--target)\" cannot be used with the option(s) [--graph, --parse]",

            "--graph --ms-sql jdbc:postgresql:q;" +
                    "Cannot work with PostgerSQL database as MS SQL project.",

            "--graph jdbc:sqlserver:f;"
                    + "Cannot work with MS SQL database as PostgerSQL project.",

            "--graph jdbc:postgresql:q jdbc:postgresql:q2;"
                    + "DEST argument isn't required.",

            "--graph;"
                    + "Please specify SCHEMA.",

            "jdbc:postgresql:q;"
                    + "Please specify both SOURCE and DEST.",

            "jdbc:postgresql:q jdbc:postgresql:q2 -X -C;"
                    + "-C (--concurrently-mode) cannot be used with the option(s) -X (--add-transaction) for PostgreSQL.",

            "jdbc:sqlserver:f jdbc:postgresql:q2;"
                    + "Cannot compare MS SQL and PostgerSQL databases.",

            "jdbc:postgresql:q2 jdbc:sqlserver:f;"
                    + "Cannot compare MS SQL and PostgerSQL databases.",

            "jdbc:sqlserver:f filename;"
                    + "Cannot work with MS SQL database without --ms-sql parameter.",

            "filename jdbc:sqlserver:f;"
                    + "Cannot work with MS SQL database without --ms-sql parameter.",

            "jdbc:postgresql:q2 filename --ms-sql;"
                    + "Cannot work with PostgreSQL database with --ms-sql parameter.",

            "filename jdbc:postgresql:q2 --ms-sql;"
                    + "Cannot work with PostgreSQL database with --ms-sql parameter.",

            "-r filename filename;"
                    + "Cannot run script on non-database target.",

            "-R filename filename filename;"
                    + "Option -R (--run-on) must specify JDBC connection string.",

            "filename filename --simplify-views --ms-sql;"
                    + "option \"--simplify-views\" cannot be used with the option(s) [--ms-sql]",
    })
    void badArgsTest(String arguments, String message) {
        String[] args = arguments.split(" ");
        CliArgs cliArgs = new CliArgs();
        try {
            cliArgs.parse(null, args);
            Assertions.fail();
        } catch (CmdLineException e) {
            Assertions.assertEquals(message, e.getMessage());
        }
    }
}
