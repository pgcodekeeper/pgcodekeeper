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
package ru.taximaxim.codekeeper.core.schema.meta;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.loader.JdbcSystemLoader;
import ru.taximaxim.codekeeper.core.loader.UrlJdbcConnector;
import ru.taximaxim.codekeeper.core.loader.pg.SupportedPgVersion;
import ru.taximaxim.codekeeper.core.localizations.Messages;

public final class MetaStorage implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(MetaStorage.class);

    private static final long serialVersionUID = 8194906497159326596L;

    private static final String FILTER_PATTERN = """
        maxdepth=7;\
        ru.taximaxim.codekeeper.core.schema.meta.MetaStorage;\
        ru.taximaxim.codekeeper.core.schema.meta.MetaCast;\
        ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;\
        ru.taximaxim.codekeeper.core.schema.meta.MetaFunction;\
        ru.taximaxim.codekeeper.core.schema.meta.MetaOperator;\
        ru.taximaxim.codekeeper.core.schema.meta.MetaRelation;\
        ru.taximaxim.codekeeper.core.schema.meta.MetaStatement;\
        ru.taximaxim.codekeeper.core.schema.PgObjLocation;\
        ru.taximaxim.codekeeper.core.schema.PgObjLocation$LocationType;\
        ru.taximaxim.codekeeper.core.schema.Argument;\
        ru.taximaxim.codekeeper.core.schema.ArgMode;\
        ru.taximaxim.codekeeper.core.schema.GenericColumn;\
        ru.taximaxim.codekeeper.core.schema.ICast$CastContext;\
        ru.taximaxim.codekeeper.core.DangerStatement;\
        ru.taximaxim.codekeeper.core.model.difftree.DbObjType;\
        ru.taximaxim.codekeeper.core.ContextLocation;\
        ru.taximaxim.codekeeper.core.utils.Pair;\
        java.util.ArrayList;\
        java.lang.Object;\
        java.lang.Enum;\
        !*""";

    private static final ObjectInputFilter DESERIALIZATION_FILTER = ObjectInputFilter.Config.createFilter(FILTER_PATTERN);

    public static final String FILE_NAME = "SYSTEM_OBJECTS_";

    private static final ConcurrentMap<SupportedPgVersion, MetaStorage> STORAGE_CACHE = new ConcurrentHashMap<>();

    private final List<MetaStatement> definitions = new ArrayList<>();

    public void addMetaChild(MetaStatement meta) {
        definitions.add(meta);
    }

    static List<MetaStatement> getSystemObjects(SupportedPgVersion version) {
        MetaStorage storage = getObjectsFromResources(version);
        return storage != null ? storage.definitions : Collections.emptyList();
    }

    private static MetaStorage getObjectsFromResources(SupportedPgVersion ver) {
        MetaStorage db = STORAGE_CACHE.get(ver);
        if (db != null) {
            return db;
        }

        InputStream inputStream = MetaStorage.class.getResourceAsStream(FILE_NAME + ver + ".ser");

        MetaStorage object = deserialize(inputStream);
        if (object != null) {
            STORAGE_CACHE.putIfAbsent(ver, object);
        }

        return object;
    }

    /**
     * Deserializes object
     *
     * @param inputStream
     *            - stream of serialized file
     *
     * @return deserialized object or null if not found
     */
    private static MetaStorage deserialize(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }

        try (ObjectInputStream oin = new ObjectInputStream(inputStream)) {
            oin.setObjectInputFilter(DESERIALIZATION_FILTER);
            return (MetaStorage) oin.readObject();
        } catch (ClassNotFoundException | IOException e) {
            LOG.debug(Messages.Utils_log_err_deserialize, e);
        }
        return null;
    }

    static void serialize(String path, String url) throws IOException, InterruptedException {
        UrlJdbcConnector jdbcConnector = new UrlJdbcConnector(url);
        Serializable storage = new JdbcSystemLoader(jdbcConnector, Consts.UTC,
                SubMonitor.convert(new NullProgressMonitor())).getStorageFromJdbc();
        Utils.serialize(path, storage);
    }
}
