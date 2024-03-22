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
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class ChModelExporter extends AbstractModelExporter {

    public ChModelExporter(Path outDir, AbstractDatabase db, String sqlEncoding) {
        super(outDir, db, sqlEncoding);
    }

    public ChModelExporter(Path outDir, AbstractDatabase newDb, AbstractDatabase oldDb,
            Collection<TreeElement> changedObjects, String sqlEncoding) {
        super(outDir, newDb, oldDb, changedObjects, sqlEncoding);
    }

    @Override
    protected Path getRelativeFilePath(PgStatement st, boolean addExtension) {
        return getRelativeFilePath(st, Paths.get(""), addExtension);
    }

    static Path getRelativeFilePath(PgStatement st, Path baseDir, boolean addExtension) {
        PgStatement parentSt = st.getParent();
        String parentExportedFileName = parentSt == null ? null : getExportedFilename(parentSt);

        Path path = baseDir.resolve(WorkDirs.CH_DATABASES);
        DbObjType type = st.getStatementType();
        switch (type) {
        case USER:
        case ROLE:
        case FUNCTION:
            path = baseDir.resolve(WorkDirs.getDirectoryNameForType(st.getDbType(), type));
            break;

        case SCHEMA:
            path = path.resolve(getExportedFilename(st));
            if (!addExtension) {
                // return schema dir path
                return path;
            }
            break;

        case TABLE:
        case VIEW:
            path = path.resolve(parentExportedFileName).resolve(type.name());
            break;

        case CONSTRAINT:
        case INDEX:
        case COLUMN:
            st = parentSt;
            String dirName = getExportedFilename(parentSt.getParent());
            path = path.resolve(dirName).resolve(parentSt.getStatementType().name());
            break;
        default:
            throw new IllegalStateException(Messages.DbObjType_unsupported_type + type);
        }
        return path.resolve(addExtension ? getExportedFilenameSql(st) : getExportedFilename(st));
    }

    @Override
    protected DatabaseType getDatabaseType() {
        return DatabaseType.CH;
    }
}
