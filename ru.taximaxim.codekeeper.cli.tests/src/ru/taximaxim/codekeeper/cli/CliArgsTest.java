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

            "--graph --db-type MS jdbc:postgresql:q;" +
                    "Cannot work with PG database as MS project.",

            "--graph jdbc:sqlserver:f;"
                    + "Cannot work with MS database as PG project.",

            "--graph jdbc:postgresql:q jdbc:postgresql:q2;"
                    + "DEST argument isn't required.",

            "--graph;"
                    + "Please specify SCHEMA.",

            "jdbc:postgresql:q;"
                    + "Please specify both SOURCE and DEST.",

            "jdbc:postgresql:q jdbc:postgresql:q2 -X -C;"
                    + "-C (--concurrently-mode) cannot be used with the option(s) -X (--add-transaction) for PostgreSQL.",

            "jdbc:sqlserver:f jdbc:postgresql:q2;"
                    + "Source (MS) and target (PG) are of different types, possibly missing --db-type parameter.",

            "jdbc:postgresql:q2 jdbc:sqlserver:f;"
                    + "Source (PG) and target (MS) are of different types, possibly missing --db-type parameter.",
                    
            "jdbc:sqlserver:f jdbc:ch:c;"
                    + "Source (MS) and target (CH) are of different types, possibly missing --db-type parameter.",
               
            "jdbc:ch:c jdbc:sqlserver:f;"
                    + "Source (CH) and target (MS) are of different types, possibly missing --db-type parameter.",
                    
            "jdbc:sqlserver:f jdbc:clickhouse:c;"
                    + "Source (MS) and target (CH) are of different types, possibly missing --db-type parameter.",

            "jdbc:clickhouse:c jdbc:sqlserver:f;"
                    + "Source (CH) and target (MS) are of different types, possibly missing --db-type parameter.",

            "jdbc:postgresql:q2 jdbc:ch:c;"
                    + "Source (PG) and target (CH) are of different types, possibly missing --db-type parameter.",

            "jdbc:ch:c jdbc:postgresql:q2;"
                    + "Source (CH) and target (PG) are of different types, possibly missing --db-type parameter.",

            "jdbc:postgresql:q2 jdbc:clickhouse:c;"
                    + "Source (PG) and target (CH) are of different types, possibly missing --db-type parameter.",

            "jdbc:clickhouse:c jdbc:postgresql:q2;"
                    + "Source (CH) and target (PG) are of different types, possibly missing --db-type parameter.",
                    
            "jdbc:sqlserver:f filename;"
                    + "Source (MS) and target (PG) are of different types, possibly missing --db-type parameter.",

            "filename jdbc:sqlserver:f;"
                    + "Source (PG) and target (MS) are of different types, possibly missing --db-type parameter.",
                    
            "jdbc:sqlserver:f filename --db-type CH;"
                    + "Source (MS) and target (CH) are of different types, possibly missing --db-type parameter.",
                    
            "filename jdbc:sqlserver:f --db-type CH;"
                    + "Source (CH) and target (MS) are of different types, possibly missing --db-type parameter.",

            "jdbc:postgresql:q2 filename --db-type MS;"
                    + "Source (PG) and target (MS) are of different types, possibly missing --db-type parameter.",

            "filename jdbc:postgresql:q2 --db-type MS;"
                    + "Source (MS) and target (PG) are of different types, possibly missing --db-type parameter.",
                    
            "jdbc:postgresql:q2 filename --db-type CH;"
                    + "Source (PG) and target (CH) are of different types, possibly missing --db-type parameter.",
                    
            "filename jdbc:postgresql:q2 --db-type CH;"
                    + "Source (CH) and target (PG) are of different types, possibly missing --db-type parameter.",
                    
            "filename jdbc:ch:c;"
                    + "Source (PG) and target (CH) are of different types, possibly missing --db-type parameter.",

            "jdbc:ch:c filename;"
                    + "Source (CH) and target (PG) are of different types, possibly missing --db-type parameter.",
                    
            "filename jdbc:ch:c --db-type MS;"
                    + "Source (MS) and target (CH) are of different types, possibly missing --db-type parameter.",

            "jdbc:ch:c filename --db-type MS;"
                    + "Source (CH) and target (MS) are of different types, possibly missing --db-type parameter.",

            "filename jdbc:clickhouse:c;"
                    + "Source (PG) and target (CH) are of different types, possibly missing --db-type parameter.",

            "jdbc:clickhouse:c filename;"
                    + "Source (CH) and target (PG) are of different types, possibly missing --db-type parameter.",
                    
            "filename jdbc:clickhouse:c --db-type MS;"
                    + "Source (MS) and target (CH) are of different types, possibly missing --db-type parameter.",

            "jdbc:clickhouse:c filename --db-type MS;"
                    + "Source (CH) and target (MS) are of different types, possibly missing --db-type parameter.",

            "-r filename filename;"
                    + "Cannot run script on non-database target.",

            "-R filename filename filename;"
                    + "Option -R (--run-on) must specify JDBC connection string.",

            "filename filename --simplify-views --db-type MS;"
                    + "option \"--simplify-views\" cannot be used with the option(s) [--db-type mssql]",
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
