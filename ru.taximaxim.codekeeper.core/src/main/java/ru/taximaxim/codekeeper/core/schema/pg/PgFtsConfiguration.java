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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.ISearchPath;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SQLAction;

public class PgFtsConfiguration extends PgStatement implements ISearchPath {

    private static final String ALTER_CONFIGURATION = "ALTER TEXT SEARCH CONFIGURATION ";
    private static final String WITH = "\n\tWITH ";

    private String parser;
    /**key - fragment, value - dictionaries */
    private final Map<String, String> dictionariesMap = new HashMap<>();


    public PgFtsConfiguration(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FTS_CONFIGURATION;
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema)getParent();
    }

    @Override
    public void getCreationSQL(Collection<SQLAction> createActions) {
        SQLAction sql = new SQLAction();
        sql.append("CREATE TEXT SEARCH CONFIGURATION ")
        .append(getQualifiedName()).append(" (\n\t");
        sql.append("PARSER = ").append(parser).append(" )");
        createActions.add(sql);

        dictionariesMap.forEach((fragment, dictionaries) -> {
            SQLAction sqlAction = new SQLAction();
            sqlAction.append(ALTER_CONFIGURATION).append(getQualifiedName());
            sqlAction.append("\n\tADD MAPPING FOR ").append(fragment)
            .append(WITH).append(dictionaries);
            createActions.add(sqlAction);
        });

        appendOwnerSQL(createActions);
        appendComments(createActions);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition,
            AtomicBoolean isNeedDepcies, Collection<SQLAction> alterActions) {
        PgFtsConfiguration newConf = (PgFtsConfiguration) newCondition;

        if (!newConf.getParser().equals(parser)) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }

        compareOptions(newConf, alterActions);

        appendAlterOwner(newConf, alterActions);
        appendAlterComments(newConf, alterActions);

        return getObjectState(alterActions);
    }

    public void compareOptions(PgFtsConfiguration newConf, Collection<SQLAction> sqlActions) {
        Map <String, String> oldMap = dictionariesMap;
        Map <String, String> newMap = newConf.dictionariesMap;

        if (oldMap.isEmpty() && newMap.isEmpty()) {
            return;
        }

        oldMap.forEach((fragment, dictionary) -> {
            String newDictionary = newMap.get(fragment);
            if (newDictionary == null) {
                sqlActions.add(getAlterConfiguration("DROP", fragment));
            } else if (!dictionary.equals(newDictionary)) {
                sqlActions.add(getAlterConfiguration("ALTER", fragment, newDictionary));
            }
        });

        newMap.forEach((fragment, dictionary) -> {
            if (!oldMap.containsKey(fragment)) {
                sqlActions.add(getAlterConfiguration("ADD", fragment, dictionary));
            }
        });
    }


    private SQLAction getAlterConfiguration(String action, String fragment) {
        return getAlterConfiguration(action, fragment, null);
    }

    private SQLAction getAlterConfiguration(String action, String fragment, String dictionary) {
        SQLAction sqlAction = new SQLAction(ALTER_CONFIGURATION).append(getQualifiedName())
                .append(MessageFormat.format("\n\t{0} MAPPING FOR ", action))
                .append(fragment);
        if (null != dictionary) {
            sqlAction.append(WITH).append(dictionary);
        }
        return sqlAction;
    }



    @Override
    public PgFtsConfiguration shallowCopy() {
        PgFtsConfiguration confDst = new PgFtsConfiguration(getName());
        copyBaseFields(confDst);
        confDst.setParser(getParser());
        confDst.dictionariesMap.putAll(dictionariesMap);
        return confDst;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgFtsConfiguration config && super.compare(obj)) {
            return Objects.equals(parser, config.getParser())
                    && dictionariesMap.equals(config.dictionariesMap);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(parser);
        hasher.put(dictionariesMap);
    }

    public String getParser() {
        return parser;
    }

    public void setParser(final String parser) {
        this.parser = parser;
        resetHash();
    }

    public void addDictionary(String fragment, List<String> dictionaries) {
        dictionariesMap.put(fragment, String.join(", ", dictionaries));
        resetHash();
    }

    public Map<String, String> getDictionariesMap() {
        return Collections.unmodifiableMap(dictionariesMap);
    }
}
