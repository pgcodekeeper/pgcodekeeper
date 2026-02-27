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
package ru.taximaxim.codekeeper.ui.database.pg;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.pgcodekeeper.core.Consts;
import org.pgcodekeeper.core.database.api.formatter.IFormatConfiguration;
import org.pgcodekeeper.core.database.api.schema.DbObjType;
import org.pgcodekeeper.core.database.api.schema.ObjectLocation;
import org.pgcodekeeper.core.database.base.project.AbstractModelExporter;
import org.pgcodekeeper.core.database.pg.PgDatabaseProvider;
import org.pgcodekeeper.core.database.pg.formatter.PgFormatter;
import org.pgcodekeeper.core.database.pg.jdbc.PgJdbcConnector;
import org.pgcodekeeper.core.database.pg.loader.PgJdbcLoader;
import org.pgcodekeeper.core.database.pg.project.PgWorkDirs;
import org.pgcodekeeper.core.database.pg.utils.PgDiffUtils;
import org.pgcodekeeper.core.settings.DiffSettings;
import org.pgcodekeeper.core.utils.FileUtils;

import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.database.base.IUiDatabaseProvider;
import ru.taximaxim.codekeeper.ui.database.pg.jdbc.PgDbInfoConnector;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.differ.ObjectLevel;
import ru.taximaxim.codekeeper.ui.generators.DataType;
import ru.taximaxim.codekeeper.ui.refactoring.RenameDefinitionChange;
import ru.taximaxim.codekeeper.ui.sqledit.SQLEditorTemplateContextType;
import ru.taximaxim.codekeeper.ui.utils.ProjectUtils;

public class PgUiDatabaseProvider extends PgDatabaseProvider implements IUiDatabaseProvider {

    @Override
    public PgJdbcConnector getDbInfoJdbcConnector(DbInfo dbInfo, int timeoutSeconds) {
        return new PgDbInfoConnector(dbInfo, timeoutSeconds);
    }

    @Override
    public PgJdbcLoader getDbInfoJdbcLoader(DbInfo dbInfo, DiffSettings diffSettings) {
        String timezone = diffSettings.getSettings().getTimeZone() == null ? Consts.UTC
                : diffSettings.getSettings().getTimeZone();
        return new PgJdbcLoader(getDbInfoJdbcConnector(dbInfo), timezone, diffSettings);
    }

    @Override
    public List<String> getDirectoryNames() {
        return PgWorkDirs.getDirectoryNames();
    }

    @Override
    public String getDirectoryNameForType(DbObjType type) {
        return PgWorkDirs.getDirectoryNameForType(type);
    }

    @Override
    public String getQuotedName(String name) {
        return PgDiffUtils.getQuotedName(name);
    }

    @Override
    public PgFormatter getFormatter(String source, int offset, int length, IFormatConfiguration config) {
        return new PgFormatter(source, offset, length, config);
    }

    @Override
    public ProjectIcon getIcon() {
        return ProjectIcon.PG_ICON;
    }

    @Override
    public String getContextType() {
        return SQLEditorTemplateContextType.CONTEXT_TYPE_PG;
    }

    @Override
    public ObjectLevel getLevel(DbObjType objType) {
        return switch (objType) {
        case SCHEMA, SERVER, CAST, EVENT_TRIGGER, EXTENSION, FOREIGN_DATA_WRAPPER, USER_MAPPING -> ObjectLevel.SCHEMA;
        case AGGREGATE, COLLATION, DOMAIN, FTS_CONFIGURATION, FTS_DICTIONARY, FTS_TEMPLATE, FTS_PARSER, OPERATOR, TABLE,
                VIEW, FUNCTION, PROCEDURE, TYPE, SEQUENCE, STATISTICS ->
            ObjectLevel.CONTAINER;
        case INDEX, CONSTRAINT, RULE, POLICY, TRIGGER -> ObjectLevel.SUB_ELEMENT;
        default -> ObjectLevel.UNKNOWN;
        };
    }

    @Override
    public List<DataType> getTypes() {
        return Arrays.asList(DataType.BIGINT, DataType.BIT, DataType.DATE, DataType.BOOLEAN, DataType.DOUBLE,
                DataType.INTEGER, DataType.JSON, DataType.NUMERIC, DataType.REAL, DataType.SMALLINT, DataType.TEXT,
                DataType.TIME, DataType.TIMESTAMP, DataType.TIMESTAMPTZ, DataType.OTHER);
    }

    @Override
    public DataType getType(String dataType) {
        if (dataType.startsWith(DataType.BIT.getType())) {
            return DataType.BIT;
        }
        if (dataType.startsWith(DataType.NUMERIC.getType())) {
            return DataType.NUMERIC;
        }
        if (dataType.startsWith("varchar") || dataType.startsWith("char")) { //$NON-NLS-1$ //$NON-NLS-2$
            return DataType.TEXT;
        }
        if (dataType.startsWith("timestamp without time zone")) { //$NON-NLS-1$
            return DataType.TIMESTAMP;
        }
        if (dataType.startsWith("timestamp with time zone")) { //$NON-NLS-1$
            return DataType.TIMESTAMPTZ;
        }
        if (dataType.startsWith("time without time zone")) { //$NON-NLS-1$
            return DataType.TIME;
        }
        return null;
    }

    @Override
    public void addRenames(List<RenameDefinitionChange> fileRenames, IFile file, String newName, ObjectLocation ref) {
        fileRenames
                .add(new RenameDefinitionChange(file.getFullPath(),
                        AbstractModelExporter.getExportedFilenameSql(newName)));
        if (ref.getType() == DbObjType.SCHEMA) {
            // rename schema folder for PG
            fileRenames.add(
                    new RenameDefinitionChange(file.getParent().getFullPath(), FileUtils.getValidFilename(newName)));
        }
    }

    @Override
    public boolean isSchemaFile(IPath path) {
        int c = path.segmentCount();
        return c == 3
                && path.segment(0).equals(PgWorkDirs.SCHEMA)
                && path.segment(c - 1).endsWith(".sql"); //$NON-NLS-1$
    }

    @Override
    public String[] getProjectNatures() {
        return new String[] { ProjectUtils.NATURE_ID };
    }
}