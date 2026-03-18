/*******************************************************************************
 * Copyright 2017-2026 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.ui.database.ms;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.pgcodekeeper.core.database.api.formatter.IFormatConfiguration;
import org.pgcodekeeper.core.database.api.schema.DbObjType;
import org.pgcodekeeper.core.database.api.schema.IStatement;
import org.pgcodekeeper.core.database.api.schema.ObjectLocation;
import org.pgcodekeeper.core.database.base.project.AbstractModelExporter;
import org.pgcodekeeper.core.database.ms.MsDatabaseProvider;
import org.pgcodekeeper.core.database.ms.formatter.MsFormatter;
import org.pgcodekeeper.core.database.ms.jdbc.MsJdbcConnector;
import org.pgcodekeeper.core.database.ms.loader.MsJdbcLoader;
import org.pgcodekeeper.core.database.ms.project.MsWorkDirs;
import org.pgcodekeeper.core.database.ms.utils.MsDiffUtils;
import org.pgcodekeeper.core.settings.DiffSettings;

import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.database.base.IUiDatabaseProvider;
import ru.taximaxim.codekeeper.ui.database.ms.jdbc.MsDbInfoConnector;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.differ.ObjectLevel;
import ru.taximaxim.codekeeper.ui.generators.DataType;
import ru.taximaxim.codekeeper.ui.refactoring.RenameDefinitionChange;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorTemplateContextType;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;

public class MsUiDatabaseProvider extends MsDatabaseProvider implements IUiDatabaseProvider {

    @Override
    public MsJdbcConnector getDbInfoJdbcConnector(DbInfo dbInfo, int timeoutSeconds) {
        return new MsDbInfoConnector(dbInfo, timeoutSeconds);
    }

    @Override
    public MsJdbcLoader getDbInfoJdbcLoader(DbInfo dbInfo, DiffSettings diffSettings) {
        return new MsJdbcLoader(getDbInfoJdbcConnector(dbInfo), diffSettings);
    }

    @Override
    public List<String> getDirectoryNames() {
        return MsWorkDirs.getDirectoryNames();
    }

    @Override
    public String getDirectoryNameForType(DbObjType type) {
        return MsWorkDirs.getDirectoryNameForType(type);
    }

    @Override
    public String getQuotedName(String name) {
        return MsDiffUtils.getQuotedName(name);
    }

    @Override
    public MsFormatter getFormatter(String source, int offset, int length, IFormatConfiguration config) {
        return new MsFormatter(source, offset, length, config);
    }

    @Override
    public ProjectIcon getIcon() {
        return ProjectIcon.MS_ICON;
    }

    @Override
    public String getContextType() {
        return SQLEditorTemplateContextType.CONTEXT_TYPE_MS;
    }

    @Override
    public ObjectLevel getLevel(DbObjType objType) {
        return switch (objType) {
        case SCHEMA, ROLE, USER, ASSEMBLY -> ObjectLevel.SCHEMA;
        case TABLE, VIEW, FUNCTION, PROCEDURE, TYPE, SEQUENCE -> ObjectLevel.CONTAINER;
        case INDEX, CONSTRAINT, TRIGGER, STATISTICS -> ObjectLevel.SUB_ELEMENT;
        default -> ObjectLevel.UNKNOWN;
        };
    }

    @Override
    public List<DataType> getTypes() {
        return Arrays.asList(DataType.BIGINT, DataType.BOOLEAN, DataType.INTEGER, DataType.JSON, DataType.REAL,
                DataType.NUMERIC, DataType.DATETIME, DataType.DATETIME2, DataType.TIME, DataType.SMALLINT,
                DataType.TINYINT, DataType.TEXT, DataType.BIT, DataType.OTHER);
    }

    @Override
    public DataType getType(String dataType) {
        if (dataType.startsWith(DataType.BIT.getType())) {
            return DataType.BIT_MS;
        }
        if (dataType.startsWith(DataType.NUMERIC.getType())) {
            return DataType.NUMERIC;
        }
        if (dataType.contains("varchar") || dataType.contains("char") || dataType.contains("nchar")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            return DataType.TEXT;
        }
        if (dataType.startsWith("int")) { //$NON-NLS-1$
            return DataType.INTEGER;
        }
        if ("tinyint".equals(dataType)) { //$NON-NLS-1$
            return DataType.TINYINT;
        }
        if (dataType.contains("datetime")) { //$NON-NLS-1$
            return DataType.DATETIME;
        }
        if (dataType.startsWith("real") || dataType.startsWith("float") || dataType.startsWith("decimal")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            return DataType.REAL;
        }
        return null;
    }

    @Override
    public void addRenames(List<RenameDefinitionChange> fileRenames, IFile file, String newName, ObjectLocation ref) {
        if (ref.getTable() != null) {
            newName = ref.getSchema() + '.' + newName;
        }

        fileRenames
                .add(new RenameDefinitionChange(file.getFullPath(),
                        AbstractModelExporter.getExportedFilenameSql(newName)));
    }

    @Override
    public Path getRelativeFilePath(IStatement st) {
        return MsWorkDirs.getRelativeFilePath(st);
    }

    @Override
    public boolean isSchemaFile(IPath path) {
        return path.segmentCount() == 3
                && MsWorkDirs.SECURITY.equals(path.segment(0))
                && MsWorkDirs.SCHEMAS.equals(path.segment(1))
                && path.segment(2).endsWith(".sql"); //$NON-NLS-1$
    }

    @Override
    public String[] getProjectNatures() {
        return new String[] { ProjectUtils.NATURE_ID, ProjectUtils.NATURE_MS };
    }
}