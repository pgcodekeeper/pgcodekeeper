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
package ru.taximaxim.codekeeper.ui.database.jdbc.ms;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import org.pgcodekeeper.core.database.ms.jdbc.MsJdbcConnector;

import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.database.jdbc.base.IDbInfoConnector;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;

public class MsDbInfoConnector extends MsJdbcConnector implements IDbInfoConnector {

    private final DbInfo dbInfo;
    private final int timeoutSeconds;

    public MsDbInfoConnector(DbInfo dbInfo, int timeoutSeconds) {
        super(dbInfo.getDbHost(), dbInfo.getDbPort(), isDbNameEscapable(dbInfo) ? dbInfo.getDbName() : null);
        this.dbInfo = dbInfo;
        this.timeoutSeconds = timeoutSeconds;
    }

    @Override
    public Connection getConnection() throws IOException {
        Log.log(Log.LOG_INFO, getMessage(dbInfo));
        var con = super.getConnection();
        setReadOnly(con, dbInfo);
        return con;
    }

    @Override
    protected Properties makeProperties() {
        Properties props = super.makeProperties();
        makeDefaultDbInfoProps(props, dbInfo);
        props.setProperty("loginTimeout", String.valueOf(timeoutSeconds)); //$NON-NLS-1$
        if (!isDbNameEscapable(dbInfo)) {
            props.setProperty("databaseName", dbInfo.getDbName()); //$NON-NLS-1$
        }
        var domain = dbInfo.getDomain();
        if (dbInfo.isWinAuth()) {
            props.setProperty("integratedSecurity", "true"); //$NON-NLS-1$ //$NON-NLS-2$
        } else if (domain != null && !"".equals(domain)) { //$NON-NLS-1$
            props.setProperty("authenticationScheme", "NTLM"); //$NON-NLS-1$ //$NON-NLS-2$
            props.setProperty("integratedSecurity", "true"); //$NON-NLS-1$ //$NON-NLS-2$
            props.setProperty("domain", domain); //$NON-NLS-1$
        }
        return props;
    }

    private static boolean isDbNameEscapable(DbInfo dbInfo) {
        return dbInfo.getDbName().indexOf('}') < 0;
    }
}