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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Collection;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.WorkDirs;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class ChModelExporter extends AbstractModelExporter {

    public ChModelExporter(Path outDir, PgDatabase db, String sqlEncoding) {
        super(outDir, db, sqlEncoding);
    }

    public ChModelExporter(Path outDir, PgDatabase newDb, PgDatabase oldDb, Collection<TreeElement> changedObjects,
            String sqlEncoding) {
        super(outDir, newDb, oldDb, changedObjects, sqlEncoding);
    }

    @Override
    protected void createOutDir() throws IOException {
        if (Files.exists(outDir)) {
            if (!Files.isDirectory(outDir)) {
                throw new NotDirectoryException(outDir.toString());
            }

            for (String subdirName : WorkDirs.getDirectoryNames(DatabaseType.CH)) {
                if (Files.exists(outDir.resolve(subdirName))) {
                    throw new DirectoryException(
                            MessageFormat.format("Output directory already contains {0} directory.", subdirName));
                }
            }
        } else {
            Files.createDirectories(outDir);
        }
    }

    @Override
    protected Path getRelativeFilePath(PgStatement st, boolean addExtension) {
        return getRelativeFilePath(st, Paths.get(""), addExtension);
    }

    static Path getRelativeFilePath(PgStatement st, Path baseDir, boolean addExtension) {
        PgStatement parentSt = st.getParent();

        Path path = baseDir;
        DbObjType type = st.getStatementType();
        var dbType = st.getDbType();
        String dirName = WorkDirs.getDirectoryNameForType(dbType, type);
        switch (type) {
        case TABLE:
        case FUNCTION:
        case VIEW:
        case USER:
        case ROLE:
        case DICTIONARY:
            path = path.resolve(dirName);
            break;
        case CONSTRAINT:
        case INDEX:
        case COLUMN:
            st = parentSt;
            dirName = WorkDirs.getDirectoryNameForType(dbType, parentSt.getStatementType());
            path = path.resolve(dirName);
            break;
        default:
            throw new IllegalStateException(Messages.DbObjType_unsupported_type + type);
        }
        return path.resolve(addExtension ? getExportedFilenameSql(st) : getExportedFilename(st));
    }
}
