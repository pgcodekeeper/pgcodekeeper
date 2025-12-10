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
package ru.taximaxim.codekeeper.ui.database.jdbc.ch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.pgcodekeeper.core.database.ch.jdbc.ChJdbcConnector;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.database.jdbc.base.IDbInfoConnector;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;

public class ChDbInfoConnector extends ChJdbcConnector implements IDbInfoConnector {

    private final DbInfo dbInfo;
    private final int timeoutSeconds;

    public ChDbInfoConnector(DbInfo dbInfo, int timeoutSeconds) {
        super(dbInfo.getDbHost(), dbInfo.getDbPort(), dbInfo.getDbName());
        this.dbInfo = dbInfo;
        this.timeoutSeconds = timeoutSeconds;
    }

    @Override
    public Connection getConnection() throws IOException {
        Log.log(Log.LOG_INFO, getMessage(dbInfo));
        try {
            loadDriver();
            var con = DriverManager.getConnection(getUrl(), makeProperties());
            setReadOnly(con, dbInfo);

            // FIXME when the connection() method of the clickhouse driver throws an
            // exception
            // when trying to connect to a non-existent database.

            // check connection catch and throw exception if false
            con.createStatement().executeQuery("SELECT 1");
            return con;
        } catch (SQLException e) {
            throw new IOException(e.getLocalizedMessage(), e);
        }
    }

    @Override
    protected void loadDriver() {
        com.clickhouse.jdbc.Driver.load();
    }

    @Override
    protected Properties makeProperties() {
        Properties props = super.makeProperties();
        makeDefaultDbInfoProps(props, dbInfo);
        props.setProperty("connect_timeout", String.valueOf(timeoutSeconds * 1000)); //$NON-NLS-1$
        return props;
    }
}