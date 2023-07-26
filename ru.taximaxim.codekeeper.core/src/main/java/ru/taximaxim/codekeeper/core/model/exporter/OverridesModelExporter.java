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
package ru.taximaxim.codekeeper.core.model.exporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgCodekeeperException;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgPrivilege;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class OverridesModelExporter extends AbstractModelExporter {

    private final boolean isMsSql;

    public OverridesModelExporter(Path outDir, PgDatabase newDb, PgDatabase oldDb,
            Collection<TreeElement> changedObjects, String sqlEncoding, boolean isMsSql) {
        super(outDir, newDb, oldDb, changedObjects, sqlEncoding);
        this.isMsSql = isMsSql;
    }

    @Override
    protected void createOutDir() throws IOException {
        throw new IllegalStateException();
    }

    @Override
    public void exportPartial() throws IOException, PgCodekeeperException {
        if (oldDb == null) {
            throw new PgCodekeeperException("Old database should not be null for partial export.");
        }
        if (Files.notExists(outDir) || !Files.isDirectory(outDir)) {
            throw new DirectoryException(MessageFormat.format(
                    "Output directory does not exist: {0}",
                    outDir.toAbsolutePath()));
        }

        List<PgStatement> list = oldDb.getDescendants().collect(Collectors.toList());
        Set<Path> paths = new HashSet<>();

        for (TreeElement el : changeList) {
            if (el.getSide() == DiffSide.BOTH) {
                switch (el.getType()) {
                case CONSTRAINT:
                case DATABASE:
                case INDEX:
                case TRIGGER:
                case RULE:
                case POLICY:
                case EXTENSION:
                case EVENT_TRIGGER:
                case CAST:
                case COLUMN:
                    break;
                default:
                    PgStatement stInNew = el.getPgStatement(newDb);
                    PgStatement stInOld = el.getPgStatement(oldDb);
                    list.set(list.indexOf(stInOld), stInNew);
                    paths.add(getRelativeFilePath(stInNew, true));
                    deleteStatementIfExists(stInNew);
                }
            }
        }

        Map<Path, StringBuilder> dumps = new HashMap<>();
        list.stream()
        .filter(st -> paths.contains(getRelativeFilePath(st, true)))
        .forEach(st -> dumpStatement(st, dumps));

        for (Entry<Path, StringBuilder> dump : dumps.entrySet()) {
            dumpSQL(dump.getValue(), dump.getKey());
        }
    }

    @Override
    protected String getDumpSql(PgStatement st) {
        StringBuilder sb = new StringBuilder();
        Set<PgPrivilege> privs = st.getPrivileges();
        PgStatement.appendOwnerSQL(st, st.getOwner(), false, sb);
        PgPrivilege.appendPrivileges(privs, st.isPostgres(), sb);
        if (privs.isEmpty() && st.isPostgres()) {
            PgPrivilege.appendDefaultPostgresPrivileges(st, sb);
        }

        if (DbObjType.TABLE == st.getStatementType()) {
            for (AbstractColumn col : ((AbstractTable)st).getColumns()) {
                PgPrivilege.appendPrivileges(col.getPrivileges(), col.isPostgres(), sb);
            }
        }

        return sb.toString();
    }

    @Override
    protected Path getRelativeFilePath(PgStatement st, boolean addExtension) {
        if (isMsSql) {
            return MsModelExporter.getRelativeFilePath(
                    st, Paths.get(Consts.OVERRIDES_DIR), addExtension);
        }

        return ModelExporter.getRelativeFilePath(
                st, Paths.get(Consts.OVERRIDES_DIR), addExtension);
    }

}
