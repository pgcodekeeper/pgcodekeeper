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
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;

import org.eclipse.core.runtime.SubMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.jdbc.JdbcLoaderBase;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.CastsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.CollationsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.ConstraintsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.EventTriggersReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.ExtensionsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.ForeignDataWrappersReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.FtsConfigurationsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.FtsDictionariesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.FtsParsersReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.FtsTemplatesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.FunctionsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.IndicesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.OperatorsReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.PoliciesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.RulesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.SchemasReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.SequencesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.ServersReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.TablesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.TriggersReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.TypesReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.UserMappingReader;
import ru.taximaxim.codekeeper.core.loader.jdbc.pg.ViewsReader;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class JdbcLoader extends JdbcLoaderBase {

    private static final Logger LOG = LoggerFactory.getLogger(JdbcLoader.class);

    public JdbcLoader(JdbcConnector connector, PgDiffArguments pgDiffArguments) {
        this(connector, pgDiffArguments, SubMonitor.convert(null), null);
    }

    public JdbcLoader(JdbcConnector connector, PgDiffArguments pgDiffArguments,
            SubMonitor monitor, IgnoreSchemaList ignoreSchemaList) {
        super(connector, monitor, pgDiffArguments, ignoreSchemaList);
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
            getRunner().run(statement, "SET TRANSACTION ISOLATION LEVEL REPEATABLE READ, READ ONLY");
            getRunner().run(statement, "SET search_path TO pg_catalog;");
            getRunner().run(statement, "SET timezone = " + PgDiffUtils.quoteString(connector.getTimezone()));

            queryCheckVersion();
            queryCheckGreenplumDb();
            queryCheckLastSysOid();
            queryTypesForCache();
            queryRoles();
            queryCheckExtension();
            setupMonitorWork();
            new SchemasReader(this, d).read();

            // NOTE: order of readers has been changed to move the heaviest ANTLR tasks to the beginning
            // to give them a chance to finish while JDBC processes other non-ANTLR stuff
            new FunctionsReader(this).read();
            new ViewsReader(this).read();
            new TablesReader(this).read();
            new RulesReader(this).read();
            if (SupportedVersion.VERSION_9_5.isLE(getVersion())) {
                new PoliciesReader(this).read();
            }
            new TriggersReader(this).read();
            new IndicesReader(this).read();
            // non-ANTLR tasks
            new ConstraintsReader(this).read();
            new TypesReader(this).read();
            new SequencesReader(this).read();
            new FtsParsersReader(this).read();
            new FtsTemplatesReader(this).read();
            new FtsDictionariesReader(this).read();
            new FtsConfigurationsReader(this).read();
            new OperatorsReader(this).read();

            new ExtensionsReader(this, d).read();
            new EventTriggersReader(this, d).read();
            new CastsReader(this, d).read();
            new ForeignDataWrappersReader(this, d).read();
            new ServersReader(this, d).read();
            try (ResultSet res = getRunner().runScript(statement, JdbcQueries.QUERY_CHECK_USER_PRIVILEGES)) {
                if (res.next() && res.getBoolean("result")) {
                    new UserMappingReader(this, d).read();
                }
            }
            new CollationsReader(this).read();

            if (!SupportedVersion.VERSION_10.isLE(getVersion())) {
                SequencesReader.querySequencesData(d, this);
            }
            connection.commit();
            finishLoaders();

            d.sortColumns();

            d.setPostgresVersion(SupportedVersion.valueOf(getVersion()));
            LOG.info("Database object has been successfully queried from JDBC");
        } catch (InterruptedException ex) {
            throw ex;
        } catch (Exception e) {
            // connection is closed at this point, trust Postgres to rollback it; we're a read-only xact anyway
            throw new IOException(MessageFormat.format(Messages.Connection_DatabaseJdbcAccessError,
                    e.getLocalizedMessage(), getCurrentLocation()), e);
        }
        return d;
    }
}
