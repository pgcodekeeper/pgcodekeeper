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
package ru.taximaxim.codekeeper.ui.database.base;

import java.nio.file.Path;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.pgcodekeeper.core.database.api.IDatabaseProvider;
import org.pgcodekeeper.core.database.api.formatter.IFormatConfiguration;
import org.pgcodekeeper.core.database.api.formatter.IFormatter;
import org.pgcodekeeper.core.database.api.jdbc.IJdbcConnector;
import org.pgcodekeeper.core.database.api.loader.IJdbcLoader;
import org.pgcodekeeper.core.database.api.schema.DbObjType;
import org.pgcodekeeper.core.database.api.schema.IStatement;
import org.pgcodekeeper.core.database.api.schema.ObjectLocation;
import org.pgcodekeeper.core.settings.DiffSettings;

import ru.taximaxim.codekeeper.ui.ProjectIcon;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.differ.ObjectLevel;
import ru.taximaxim.codekeeper.ui.generators.DataType;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.refactoring.RenameDefinitionChange;

/**
 * Eclipse plugin interface for DBMS
 */
public interface IUiDatabaseProvider extends IDatabaseProvider {

    default IJdbcConnector getDbInfoJdbcConnector(DbInfo dbInfo) {
        return getDbInfoJdbcConnector(dbInfo, 0);
    }

    /**
     * @param dbInfo         {@link DbInfo}
     * @param timeoutSeconds seconds for timeout
     * @return jdbc connector for DBMS
     * @see IJdbcConnector
     */
    IJdbcConnector getDbInfoJdbcConnector(DbInfo dbInfo, int timeoutSeconds);

    /**
     * @param dbInfo       {@link DbInfo}
     * @param diffSettings {@link DiffSettings}
     * @return jdbc loader for DBMS
     * @see {@link IJdbcLoader}
     */
    IJdbcLoader getDbInfoJdbcLoader(DbInfo dbInfo, DiffSettings diffSettings);

    /**
     * @param type {@link DbObjType} of {@link IStatement}
     * @return name of directory for this {@link DbObjType}
     */
    String getDirectoryNameForType(DbObjType type);

    /**
     * @param name of {@link IStatement}
     * @return quoted name of {@link IStatement}
     */
    String getQuotedName(String name);

    /**
     * @return {@link List} of names for directories for DBMS implementation
     */
    List<String> getDirectoryNames();

    /**
     * @return Icon for DBMS implementation
     */
    ProjectIcon getIcon();

    /**
     * @return context type for DBMS implementation
     */
    String getContextType();

    /**
     * @param objType {@link DbObjType}
     * @return return {@link ObjectLevel} for this {@link DbObjType} for DBMS
     *         implementation
     */
    ObjectLevel getLevel(DbObjType objType);

    /**
     * @return {@link List} of {@link DataType} for DBMS implementation
     */
    List<DataType> getTypes();

    /**
     * @param dataType
     * @return specific data type for DBMS implementation
     */
    DataType getType(String dataType);

    /**
     * create new {@link RenameDefinitionChange} and add to {@link List}
     *
     * @param fileRenames {@link List} of {@link RenameDefinitionChange}
     * @param file        {@link IFile} of object for rename
     * @param newName     of object for rename
     * @param ref         {@link ObjectLocation} of object for rename
     */
    void addRenames(List<RenameDefinitionChange> fileRenames, IFile file, String newName, ObjectLocation ref);

    /**
     * @return array of project natures for for DBMS implementation
     */
    String[] getProjectNatures();

    /**
     * @param path project relative path
     * @return whether the path corresponds to a schema sql file
     */
    boolean isSchemaFile(IPath path);

    /**
     *
     * @param source The source SQL text to format
     * @param offset Starting offset in the source text
     * @param length Length of text to format
     * @param config Formatting configuration options
     * @return SQL formatter
     */
    IFormatter getFormatter(String source, int offset, int length, IFormatConfiguration config);

    /**
     * @param st statement to get the relative path for
     * @return relative file path for the given statement within the project
     */
    Path getRelativeFilePath(IStatement st);

    @Override
    default IJdbcConnector getJdbcConnector(String url) {
        throw new UnsupportedOperationException(
                Messages.IUiDatabaseProvider_unsuported_operation_exception.formatted("getDbInfoJdbcConnector")); //$NON-NLS-1$
    }

    @Override
    default IJdbcLoader getJdbcLoader(String url, DiffSettings diffSettings) {
        throw new UnsupportedOperationException(
                Messages.IUiDatabaseProvider_unsuported_operation_exception.formatted("getDbInfoJdbcLoader")); //$NON-NLS-1$
    }
}