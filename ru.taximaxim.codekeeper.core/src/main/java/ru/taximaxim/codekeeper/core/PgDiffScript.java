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
package ru.taximaxim.codekeeper.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import ru.taximaxim.codekeeper.core.PgDiffStatement.DiffStatementType;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SQLAction;

/**
 * Contains list of SQL statements.<br>
 * A set is used to ensure that {@link #addStatementUnique} does not add multiple entries.
 *
 * @author Alexander Levsha
 */
public class PgDiffScript {

    private final List<PgDiffStatement> statements = new ArrayList<>();

    // this is faster because HashSet.contains() is O(1)
    // List.contains() is O(n)
    // also String caches hashcodes, so that's a minor performance plus
    private final Set<PgDiffStatement> unique = new HashSet<>();

    private final DatabaseType dbType;

    public PgDiffScript(DatabaseType dbType) {
        this.dbType = dbType;
    }

    public void addStatement(String statement) {
        addStatement(List.of(new SQLAction(statement)));
    }

    public void addStatement(Collection<SQLAction> sqlActions) {
        PgDiffStatement st = new PgDiffStatement(DiffStatementType.OTHER, null, sqlActions);
        if (statements.isEmpty()) {
            statements.add(st);
            return;
        }

        PgDiffStatement last = statements.get(statements.size() - 1);
        if (!st.equals(last)) {
            statements.add(st);
        }
    }

    public void addDrop(PgStatement obj, String comment, Collection<SQLAction> sqlActions) {
        addStatementUnique(DiffStatementType.DROP, obj, comment, sqlActions, false);
    }

    public void addCreate(PgStatement obj, String comment, Collection<SQLAction> sqlActions, boolean replaceExisting) {
        addStatementUnique(DiffStatementType.CREATE, obj, comment, sqlActions, replaceExisting);
    }

    /**
     * Adds statement only if it's not present in the statements list.
     */
    private void addStatementUnique(DiffStatementType type, PgStatement obj,
            String comment, Collection<SQLAction> sqlActions, boolean replaceExisting) {
        if (type != DiffStatementType.DROP && type != DiffStatementType.CREATE) {
            throw new IllegalArgumentException(
                    "Only DROPs and CREATEs can be tracked as unique statements!");
        }

        PgDiffStatement st = new PgDiffStatement(type, obj, sqlActions);
        if (!unique.contains(st)) {
            if (comment != null){
                addStatement(comment);
            }
            statements.add(st);
            unique.add(st);
        } else if (replaceExisting) {
            statements.set(statements.indexOf(st), st);
        }
    }

    public String getText() {
        return statements.stream()
                .flatMap(t -> t.getStatements().stream())
                .sorted((e1, e2) -> e1.getType().compareTo(e2.getType()))
                .map(el -> el.getSQL(dbType))
                .collect(Collectors.joining("\n\n"));
    }
}
