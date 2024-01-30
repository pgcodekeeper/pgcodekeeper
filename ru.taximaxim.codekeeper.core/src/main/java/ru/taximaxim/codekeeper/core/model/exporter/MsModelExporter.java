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
package ru.taximaxim.codekeeper.core.model.exporter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.WorkDirs;
import ru.taximaxim.codekeeper.core.fileutils.FileUtils;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.PgStatementWithSearchPath;

public class MsModelExporter extends AbstractModelExporter {

    public MsModelExporter(Path outDir, PgDatabase db, String sqlEncoding) {
        super(outDir, db, sqlEncoding);
    }

    public MsModelExporter(Path outDir, PgDatabase newDb, PgDatabase oldDb,
            Collection<TreeElement> changedObjects, String sqlEncoding) {
        super(outDir, newDb, oldDb, changedObjects, sqlEncoding);
    }

    @Override
    protected Path getRelativeFilePath(PgStatement st, boolean addExtension) {
        return getRelativeFilePath(st, Paths.get(""), addExtension);
    }

    static Path getRelativeFilePath(PgStatement st, Path baseDir, boolean addExtension){
        PgStatement parentSt = st.getParent();

        Path path = baseDir;
        DbObjType type = st.getStatementType();
        var dbType = st.getDbType();
        String dirName = WorkDirs.getDirectoryNameForType(dbType, type);
        switch (type) {

        case SCHEMA:
        case ROLE:
        case USER:
            path = path.resolve(WorkDirs.MS_SECURITY).resolve(dirName);
            if (!addExtension) {
                return path;
            }
            break;
        case ASSEMBLY:
        case SEQUENCE:
        case VIEW:
        case TABLE:
        case FUNCTION:
        case PROCEDURE:
        case TYPE:
            path = path.resolve(dirName);
            break;
        case CONSTRAINT:
        case INDEX:
        case TRIGGER:
        case COLUMN:
            st = parentSt;
            dirName = WorkDirs.getDirectoryNameForType(dbType, parentSt.getStatementType());
            path = path.resolve(dirName);
            break;
        default:
            throw new IllegalStateException(Messages.DbObjType_unsupported_type + type);
        }

        String fileName = addExtension ? getExportedFilenameSql(st) : getExportedFilename(st);
        if (st instanceof PgStatementWithSearchPath) {
            fileName = FileUtils.getValidFilename(
                    ((PgStatementWithSearchPath)st).getSchemaName()) + '.' + fileName;
        }

        return path.resolve(fileName);
    }

    @Override
    protected DatabaseType getDatabaseType() {
        return DatabaseType.MS;
    }
}
