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
package ru.taximaxim.codekeeper.ui.database.ch;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.pgcodekeeper.core.database.api.formatter.IFormatConfiguration;
import org.pgcodekeeper.core.database.api.schema.DbObjType;
import org.pgcodekeeper.core.database.api.schema.IStatement;
import org.pgcodekeeper.core.database.api.schema.ObjectLocation;
import org.pgcodekeeper.core.database.ch.ChDatabaseProvider;
import org.pgcodekeeper.core.database.ch.formatter.ChFormatter;
import org.pgcodekeeper.core.database.ch.jdbc.ChJdbcConnector;
import org.pgcodekeeper.core.database.ch.loader.ChJdbcLoader;
import org.pgcodekeeper.core.database.ch.project.ChWorkDirs;
import org.pgcodekeeper.core.database.ch.utils.ChDiffUtils;
import org.pgcodekeeper.core.settings.DiffSettings;

import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.database.base.IUiDatabaseProvider;
import ru.taximaxim.codekeeper.ui.database.ch.jdbc.ChDbInfoConnector;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.differ.ObjectLevel;
import ru.taximaxim.codekeeper.ui.generators.DataType;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.refactoring.RenameDefinitionChange;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorTemplateContextType;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;

public class ChUiDatabaseProvider extends ChDatabaseProvider implements IUiDatabaseProvider {

    @Override
    public ChJdbcConnector getDbInfoJdbcConnector(DbInfo dbInfo, int timeoutSeconds) {
        return new ChDbInfoConnector(dbInfo, timeoutSeconds);
    }

    @Override
    public ChJdbcLoader getDbInfoJdbcLoader(DbInfo dbInfo, DiffSettings diffSettings) {
        return new ChJdbcLoader(getDbInfoJdbcConnector(dbInfo), diffSettings);
    }

    @Override
    public List<String> getDirectoryNames() {
        return ChWorkDirs.getDirectoryNames();
    }

    @Override
    public String getDirectoryNameForType(DbObjType type) {
        return ChWorkDirs.getDirectoryNameForType(type);
    }

    @Override
    public String getQuotedName(String name) {
        return ChDiffUtils.getQuotedName(name);
    }

    @Override
    public ChFormatter getFormatter(String source, int offset, int length, IFormatConfiguration config) {
        return new ChFormatter(source, offset, length, config);
    }

    @Override
    public ProjectIcon getIcon() {
        return ProjectIcon.CH_ICON;
    }

    @Override
    public String getContextType() {
        return SQLEditorTemplateContextType.CONTEXT_TYPE_CH;
    }

    @Override
    public ObjectLevel getLevel(DbObjType objType) {
        return switch (objType) {
        case SCHEMA, ROLE, USER, FUNCTION, POLICY -> ObjectLevel.SCHEMA;
        case TABLE, VIEW, DICTIONARY -> ObjectLevel.CONTAINER;
        case INDEX, CONSTRAINT -> ObjectLevel.SUB_ELEMENT;
        default -> ObjectLevel.UNKNOWN;
        };
    }

    @Override
    public List<DataType> getTypes() {
        return Arrays.asList(DataType.BIGINT, DataType.BOOLEAN, DataType.INTEGER, DataType.SMALLINT, DataType.JSON,
                DataType.DOUBLE, DataType.REAL, DataType.NUMERIC, DataType.DATETIME, DataType.TIME, DataType.TEXT,
                DataType.OTHER);
    }

    @Override
    public DataType getType(String dataType) {
        if (dataType.startsWith(DataType.BIT.getType())) {
            return DataType.BIT;
        }
        if (dataType.startsWith(DataType.NUMERIC.getType())) {
            return DataType.NUMERIC;
        }
        if (dataType.contains("char") || dataType.startsWith("string")) { //$NON-NLS-1$ //$NON-NLS-2$
            return DataType.TEXT;
        }
        if (dataType.startsWith("int")) { //$NON-NLS-1$
            return DataType.INTEGER;
        }
        if (dataType.startsWith("bool")) { //$NON-NLS-1$
            return DataType.BOOLEAN;
        }
        if (dataType.startsWith("real") || dataType.startsWith("float") || dataType.startsWith("decimal")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            return DataType.REAL;
        }
        if (dataType.startsWith("datetime")) { //$NON-NLS-1$
            return DataType.DATETIME;
        }
        return null;
    }

    @Override
    public void addRenames(List<RenameDefinitionChange> fileRenames, IFile file, String newName, ObjectLocation ref) {
        throw new UnsupportedOperationException(Messages.DatabaseType_unsupported_type + getFullName());
    }

    @Override
    public Path getRelativeFilePath(IStatement st) {
        return ChWorkDirs.getRelativeFilePath(st);
    }

    @Override
    public boolean isSchemaFile(IPath path) {
        return path.segmentCount() == 3
                && path.segment(0).equals(ChWorkDirs.DATABASE)
                && path.segment(2).endsWith(".sql"); //$NON-NLS-1$
    }

    @Override
    public String[] getProjectNatures() {
        return new String[] { ProjectUtils.NATURE_ID, ProjectUtils.NATURE_CH };
    }
}