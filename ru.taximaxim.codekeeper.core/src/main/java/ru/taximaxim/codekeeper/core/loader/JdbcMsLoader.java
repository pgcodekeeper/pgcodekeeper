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
import ru.taximaxim.codekeeper.core.loader.jdbc.ms.MsAssembliesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ms.MsCheckConstraintsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ms.MsExtendedObjectsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ms.MsFKReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ms.MsFPVTReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ms.MsIndicesAndPKReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ms.MsRolesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ms.MsSchemasReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ms.MsSequencesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ms.MsTablesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ms.MsTypesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.ms.MsUsersReader;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.ms.MsDatabase;

public class JdbcMsLoader extends JdbcLoaderBase {

    private static final Logger LOG = LoggerFactory.getLogger(JdbcMsLoader.class);

    public JdbcMsLoader(JdbcConnector connector, PgDiffArguments args) {
        this(connector, args, SubMonitor.convert(null), null);
    }

    public JdbcMsLoader(JdbcConnector connector, PgDiffArguments args,
            SubMonitor monitor, IgnoreSchemaList ignoreSchemaList) {
        super(connector, monitor, args, ignoreSchemaList);
    }

    @Override
    public AbstractDatabase load() throws IOException, InterruptedException {
        MsDatabase d = (MsDatabase) createDb(getArgs());

        LOG.info("Reading db using JDBC.");
        setCurrentOperation("connection setup");
        try (Connection connection = connector.getConnection();
                Statement statement = connection.createStatement()) {
            this.connection = connection;
            this.statement = statement;

            connection.setAutoCommit(false);
            // TODO maybe not needed and/or may cause extra locking (compared to PG)
            // may need to be removed, Source Control seems to work in default READ COMMITTED state
            getRunner().run(statement, "SET TRANSACTION ISOLATION LEVEL REPEATABLE READ");

            // TODO add role cache if needed to process permissions, or remove this
            //queryRoles();
            // TODO add counting objects later
            //setupMonitorWork();

            new MsSchemasReader(this, d).read();
            new MsFPVTReader(this).read();
            new MsExtendedObjectsReader(this).read();
            new MsTablesReader(this).read();
            new MsSequencesReader(this).read();
            new MsIndicesAndPKReader(this).read();
            new MsFKReader(this).read();
            new MsCheckConstraintsReader(this).read();
            new MsTypesReader(this).read();
            new MsAssembliesReader(this, d).read();
            new MsRolesReader(this, d).read();
            new MsUsersReader(this, d).read();

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
