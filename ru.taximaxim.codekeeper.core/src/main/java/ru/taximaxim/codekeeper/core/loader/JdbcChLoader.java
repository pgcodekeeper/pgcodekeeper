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
package ru.taximaxim.codekeeper.core.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.text.MessageFormat;

import org.eclipse.core.runtime.SubMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public final class JdbcChLoader extends JdbcLoaderBase {
    
    private static final Logger LOG = LoggerFactory.getLogger(JdbcLoader.class);
    
    public JdbcChLoader(JdbcConnector connector, PgDiffArguments pgDiffArguments) {
        this(connector, pgDiffArguments, SubMonitor.convert(null), null);
    }

    public JdbcChLoader(JdbcConnector connector, PgDiffArguments arguments, SubMonitor monitor,
            IgnoreSchemaList ignoreSchemaList) {
        super(connector, monitor, arguments, ignoreSchemaList);
    }

    @Override
    public PgDatabase load() throws IOException, InterruptedException {
        PgDatabase d = new PgDatabase(getArgs());

        LOG.info("Reading db using JDBC.");
        setCurrentOperation("connection setup");
        try (Connection connection = connector.getConnection();
                Statement statement = connection.createStatement()) {
            this.connection = connection;
            this.statement = statement;

            connection.setAutoCommit(false);

            finishLoaders();
            connection.commit();

            LOG.info("Database object has been successfully queried from JDBC");
        } catch (InterruptedException ex) {
            throw ex;
        } catch (Exception e) {
            // connection is closed at this point
            throw new IOException(MessageFormat.format(Messages.Connection_DatabaseJdbcAccessError,
                    e.getLocalizedMessage(), getCurrentLocation()), e);
        }
        return d;
    }
}