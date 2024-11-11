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
package ru.taximaxim.codekeeper.core.parsers;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.FILES_POSTFIX;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.loader.ParserListenerMode;
import ru.taximaxim.codekeeper.core.loader.PgDumpLoader;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

class ObjReferencesTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "aggregates",
            "alter_table",
            "arrays",
            "case",
            "cluster",
            "collate",
            "conversion",
            "copy",
            "create_cast",
            "create_function",
            "create_misc",
            "create_procedure",
            "create_table",
            "create_table_like",
            "database",
            "date",
            "delete",
            "dependency",
            "domain",
            "drop_if_exists",
            "drop_operator",
            "enum",
            "event_trigger",
            "extension",
            "fast_default",
            "float8",
            "foreign_data",
            "foreign_key",
            "fts_configuration",
            "fts_parser",
            "fts_template",
            "functional_deps",
            "geometry",
            "groupingsets",
            "index",
            "inherit",
            "insert",
            "insert_conflict",
            "interval",
            "join",
            "json_encoding",
            "jsonb",
            "lseg",
            "merge",
            "misc_functions",
            "misc_sanity",
            "name",
            "namespace",
            "numeric",
            "numeric_big",
            "numerology",
            "oid",
            "oidjoins",
            "operator",
            "opr_sanity",
            "other",
            "partition_aggregate",
            "partition_join",
            "partition_prune",
            "plancache",
            "point",
            "policy",
            "polygon",
            "polymorphism",
            "privileges",
            "publication",
            "rangefuncs",
            "rangetypes",
            "reloptions",
            "role",
            "rowtypes",
            "rules",
            "schema",
            "select",
            "sequence",
            "server",
            "set",
            "spgist",
            "strings",
            "subscription",
            "subselect",
            "sysviews",
            "time",
            "timestamp",
            "timestamptz",
            "timetz",
            "transactions",
            "triggers",
            "tsdicts",
            "tsearch",
            "type",
            "update",
            "user_mapping",
            "view",
            "window",
            "with",
    })
    void comparePgReferences(final String fileNameTemplate) throws IOException, InterruptedException {
        compareReferences(fileNameTemplate, DatabaseType.PG);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ms_aggregate",
            "ms_assemblies",
            "ms_authorizations",
            "ms_availability_group",
            "ms_backup",
            "ms_broker_priority",
            "ms_certificates",
            "ms_control_flow",
            "ms_cursors",
            "ms_database",
            "ms_delete",
            "ms_drop",
            "ms_event",
            "ms_full_width_chars",
            "ms_function",
            "ms_index",
            "ms_insert",
            "ms_key",
            "ms_logins",
            "ms_merge",
            "ms_other",
            "ms_predicates",
            "ms_procedures",
            "ms_restore",
            "ms_roles",
            "ms_rule",
            "ms_schema",
            "ms_select",
            "ms_select_match",
            "ms_sequences",
            "ms_server",
            "ms_statements",
            "ms_table",
            "ms_transactions",
            "ms_triggers",
            "ms_type",
            "ms_update",
            "ms_users",
            "ms_view",
            "ms_xml_data_type",
    })
    void compareMsReferences(final String fileNameTemplate) throws IOException, InterruptedException {
        compareReferences(fileNameTemplate, DatabaseType.MS);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ch_database",
            "ch_function",
            "ch_show",
            "ch_view",
            "ch_policy",
            "ch_table",
            "ch_select",
            "ch_privileges",
            "ch_user",
            "ch_role",
            "ch_dictionary"
    })
    void compareChReferences(final String fileNameTemplate) throws IOException, InterruptedException {
        compareReferences(fileNameTemplate, DatabaseType.CH);
    }

    void compareReferences(String fileNameTemplate, DatabaseType dbType) throws IOException, InterruptedException {
        PgDiffArguments args = new PgDiffArguments();
        args.setDbType(dbType);

        String resource = fileNameTemplate + FILES_POSTFIX.SQL;
        PgDumpLoader loader = new PgDumpLoader(() -> getClass().getResourceAsStream(resource), resource, args);
        loader.setMode(ParserListenerMode.REF);
        AbstractDatabase db = loader.load();

        String expected = TestUtils
                .readResource(fileNameTemplate + FILES_POSTFIX.REFS_TXT, getClass()).strip();

        String actual = getRefsAsString(db.getObjReferences()).strip();

        Assertions.assertEquals("[]", loader.getErrors().toString());
        Assertions.assertEquals(expected, actual);
    }

    private String getRefsAsString(Map<String, Set<PgObjLocation>> refs) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Set<PgObjLocation>> entry : refs.entrySet()) {
            entry.getValue().stream().sorted((e1, e2) -> Integer.compare(e1.getOffset(), e2.getOffset())).forEach(loc -> {
                sb.append("Reference: ");
                GenericColumn col = loc.getObj();
                if (col != null) {
                    sb.append("Object = ").append(col).append(", ");
                }
                sb.append("action = ").append(loc.getAction()).append(", ");
                sb.append("offset = ").append(loc.getOffset()).append(", ");
                sb.append("line number = ").append(loc.getLineNumber()).append(", ");
                sb.append("charPositionInLine = ").append(loc.getCharPositionInLine());
                sb.append(System.lineSeparator());
            });
        }

        return sb.toString();
    }
}
