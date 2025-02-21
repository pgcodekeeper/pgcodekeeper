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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.ISearchPath;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class PgFtsConfiguration extends PgStatement implements ISearchPath {

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
        return (AbstractSchema) parent;
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TEXT SEARCH CONFIGURATION ")
        .append(getQualifiedName()).append(" (\n\t");
        sql.append("PARSER = ").append(parser).append(" )");
        script.addStatement(sql);

        dictionariesMap.forEach((fragment, dictionaries) -> {
            StringBuilder sqlAction = new StringBuilder();
            sqlAction.append(ALTER_CONFIGURATION).append(getQualifiedName());
            sqlAction.append("\n\tADD MAPPING FOR ").append(fragment)
            .append(WITH).append(dictionaries);
            script.addStatement(sqlAction);
        });

        appendOwnerSQL(script);
        appendComments(script);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        PgFtsConfiguration newConf = (PgFtsConfiguration) newCondition;

        if (!newConf.getParser().equals(parser)) {
            return ObjectState.RECREATE;
        }

        compareOptions(newConf, script);

        appendAlterOwner(newConf, script);
        appendAlterComments(newConf, script);

        return getObjectState(script, startSize);
    }

    private void compareOptions(PgFtsConfiguration newConf, SQLScript script) {
        Map <String, String> oldMap = dictionariesMap;
        Map <String, String> newMap = newConf.dictionariesMap;

        if (oldMap.isEmpty() && newMap.isEmpty()) {
            return;
        }

        oldMap.forEach((fragment, dictionary) -> {
            String newDictionary = newMap.get(fragment);
            if (newDictionary == null) {
                script.addStatement(getAlterConfiguration("DROP", fragment));
            } else if (!dictionary.equals(newDictionary)) {
                script.addStatement(getAlterConfiguration("ALTER", fragment, newDictionary));
            }
        });

        newMap.forEach((fragment, dictionary) -> {
            if (!oldMap.containsKey(fragment)) {
                script.addStatement(getAlterConfiguration("ADD", fragment, dictionary));
            }
        });
    }

    private String getAlterConfiguration(String action, String fragment) {
        return getAlterConfiguration(action, fragment, null);
    }

    private String getAlterConfiguration(String action, String fragment, String dictionary) {
        StringBuilder sqlAction = new StringBuilder(ALTER_CONFIGURATION).append(getQualifiedName())
                .append(MessageFormat.format("\n\t{0} MAPPING FOR ", action))
                .append(fragment);
        if (null != dictionary) {
            sqlAction.append(WITH).append(dictionary);
        }
        return sqlAction.toString();
    }



    @Override
    public PgFtsConfiguration shallowCopy() {
        PgFtsConfiguration confDst = new PgFtsConfiguration(name);
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
}
