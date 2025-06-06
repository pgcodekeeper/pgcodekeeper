/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.loader.ch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.SubMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.AbstractJdbcConnector;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.ch.ChFunctionsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ch.ChPoliciesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ch.ChPrivillegesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ch.ChRelationsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ch.ChRolesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ch.ChSchemasReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ch.ChUsersReader;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.settings.ISettings;

public final class JdbcChLoader extends JdbcLoaderBase {

    private static final Logger LOG = LoggerFactory.getLogger(JdbcChLoader.class);

    public JdbcChLoader(AbstractJdbcConnector connector, ISettings settings, SubMonitor monitor,
            IgnoreSchemaList ignoreSchemaList) {
        super(connector, monitor, settings, ignoreSchemaList);
    }

    @Override
    public AbstractDatabase load() throws IOException, InterruptedException {
        ChDatabase d = (ChDatabase) createDb(getSettings());

        LOG.info(Messages.JdbcLoader_log_reading_db_jdbc);
        setCurrentOperation(Messages.JdbcChLoader_log_connection_db);
        try (Connection connection = connector.getConnection();
                Statement statement = connection.createStatement()) {
            this.connection = connection;
            this.statement = statement;

            connection.setAutoCommit(false);

            LOG.info(Messages.JdbcLoader_log_read_db_objects);
            new ChSchemasReader(this, d).read();
            new ChFunctionsReader(this, d).read();
            new ChRelationsReader(this).read();
            new ChPoliciesReader(this, d).read();
            new ChUsersReader(this, d).read();
            new ChRolesReader(this, d).read();
            if (!getSettings().isIgnorePrivileges()) {
                new ChPrivillegesReader(this, d).read();
            }

            finishLoaders();
            connection.commit();

            LOG.info(Messages.JdbcLoader_log_succes_queried);
        } catch (InterruptedException ex) {
            throw ex;
        } catch (Exception e) {
            // connection is closed at this point
            throw new IOException(MessageFormat.format(Messages.Connection_DatabaseJdbcAccessError,
                    e.getLocalizedMessage(), getCurrentLocation()), e);
        }
        return d;
    }

    @Override
    public String getSchemas() {
        return schemaIds.keySet().stream()
                .map(e -> PgDiffUtils.quoteString(e.toString()))
                .collect(Collectors.joining(", ")); //$NON-NLS-1$
    }
}
