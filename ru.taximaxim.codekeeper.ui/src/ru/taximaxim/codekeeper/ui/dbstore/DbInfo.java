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
package ru.taximaxim.codekeeper.ui.dbstore;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.pgcodekeeper.core.DatabaseType;
import org.pgcodekeeper.core.ignorelist.IgnoreList;

import ru.taximaxim.codekeeper.ui.prefs.ignoredobjects.InternalIgnoreList;
import ru.taximaxim.codekeeper.ui.xmlstore.DbXmlStore;

public final class DbInfo {

    public static final String DEFAULT_EXECUTE_PATH = "pg_dump"; //$NON-NLS-1$
    private static final String DEFAULT_CUSTOM_PARAMS = "--schema-only --no-password"; //$NON-NLS-1$

    private final String name;
    private final String dbname;
    private final String dbuser;
    private final String dbpass;
    private final String dbhost;
    private final int dbport;
    private final String pgdumpExePath;
    private final String pgdumpCustomParams;
    private final boolean pgDumpSwitch;
    private final boolean readOnly;
    private final boolean winAuth;
    private final DatabaseType dbType;
    private final String domain;
    private final String dbGroup;
    private final boolean generateName;
    private final List<String> ignoreFiles;
    private final Map<String, String> properties;
    private final String conType;

    public String getName() {
        return name;
    }

    public String getDbName() {
        return dbname;
    }

    public String getDbUser() {
        return dbuser;
    }

    public String getDbPass() {
        return dbpass;
    }

    public String getDbGroup() {
        return dbGroup;
    }

    public String getDbHost() {
        return dbhost;
    }

    public int getDbPort() {
        return dbport;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public boolean isWinAuth() {
        return winAuth;
    }

    public DatabaseType getDbType() {
        return dbType;
    }

    public String getDomain() {
        return domain;
    }

    public boolean isGeneratedName() {
        return generateName;
    }

    public List<String> getIgnoreFiles() {
        return ignoreFiles;
    }

    public Map<String, String> getProperties() {
        return Collections.unmodifiableMap(properties);
    }

    public String getPgdumpExePath() {
        return pgdumpExePath;
    }

    public String getPgdumpCustomParams() {
        return pgdumpCustomParams;
    }

    public boolean isPgDumpSwitch() {
        return pgDumpSwitch;
    }

    public String getConType() {
        return conType;
    }

    public DbInfo(String name, String dbname, String dbuser, String dbpass,
            String dbhost, int dbport) {
        this(name, dbname, dbuser, dbpass, dbhost, dbport, false, false, Collections.emptyList(),
                Collections.emptyMap(), DatabaseType.PG, false, "", //$NON-NLS-1$
                DEFAULT_EXECUTE_PATH, DEFAULT_CUSTOM_PARAMS, false, "", ""); //$NON-NLS-1$ //$NON-NLS-2$
    }

    public DbInfo(String name, String dbname, String dbuser, String dbpass,
            String dbhost, int dbport, boolean readOnly, boolean generateName,
            List<String> ignoreFiles, Map<String, String> properties, DatabaseType dbType, boolean winAuth,
            String domain, String pgdumpExePath, String pgdumpCustomParams, boolean pgDumpSwitch,
            String dbGroup, String conType) {
        this.name = name;
        this.dbname = dbname;
        this.dbuser = dbuser;
        this.dbpass = dbpass;
        this.dbhost = dbhost;
        this.dbport = dbport;
        this.readOnly = readOnly;
        this.generateName = generateName;
        this.ignoreFiles = ignoreFiles;
        this.properties = properties;
        this.dbType = dbType;
        this.winAuth = winAuth;
        this.domain = domain;
        this.pgdumpExePath = pgdumpExePath == null ? DEFAULT_EXECUTE_PATH : pgdumpExePath;
        this.pgdumpCustomParams = pgdumpCustomParams == null ? DEFAULT_CUSTOM_PARAMS : pgdumpCustomParams;
        this.pgDumpSwitch = pgDumpSwitch;
        this.dbGroup = dbGroup;
        this.conType = conType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DbInfo other)) {
            return false;
        }
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /**
     * Sorts the list by DbInfo.dbGroup in order of group occurrence
     */
    public static void sortDbGroups(List<DbInfo> list) {
        Map<String, List<DbInfo>> map = groupDbs(list);
        list.clear();
        map.values().stream().forEach(v -> v.forEach(list::add));
    }

    /**
     * @return Map of DbInfo's grouped by their dbGroup
     */
    public static Map<String, List<DbInfo>> groupDbs(List<DbInfo> list) {
        Map<String, List<DbInfo>> map = new LinkedHashMap<>();

        for (DbInfo dbInfo : list) {
            map.computeIfAbsent(dbInfo.getDbGroup(), k -> new ArrayList<>()).add(dbInfo);
        }
        return map;
    }

    public static DbInfo getLastDb(String preference, DatabaseType dbType) {
        return DbXmlStore.getStore().stream()
                .filter(e -> e.getDbType() == dbType && preference.equals(e.getName()))
                .findAny().orElse(null);
    }

    public void appendIgnoreFiles(IgnoreList ignoreList) {
        for (String file : getIgnoreFiles()) {
            InternalIgnoreList.readAppendList(Paths.get(file), ignoreList, true);
        }
    }
}