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

public class PgFtsConfiguration extends PgStatement implements ISearchPath {

    private static final String ALTER_CONFIGURATION = "\n\nALTER TEXT SEARCH CONFIGURATION ";

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
    public String getCreationSQL() {
        StringBuilder sbSql = new StringBuilder();
        sbSql.append("CREATE TEXT SEARCH CONFIGURATION ")
        .append(getQualifiedName()).append(" (\n\t");
        sbSql.append("PARSER = ").append(parser).append(" );");

        dictionariesMap.forEach((fragment, dictionaries) -> {
            sbSql.append(ALTER_CONFIGURATION).append(getQualifiedName());
            sbSql.append("\n\tADD MAPPING FOR ").append(fragment)
            .append("\n\tWITH ").append(dictionaries).append(";");
        });

        appendOwnerSQL(sbSql);

        return sbSql.toString();
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgFtsConfiguration newConf = (PgFtsConfiguration) newCondition;

        if (!newConf.getParser().equals(parser)) {
            isNeedDepcies.set(true);
            return ObjectState.RECREATE;
        }

        compareOptions(newConf, sb);

        if (!Objects.equals(getOwner(), newConf.getOwner())) {
            newConf.alterOwnerSQL(sb);
        }
        compareComments(sb, newConf);

        return getObjectState(sb, startLength);
    }

    public void compareOptions(PgFtsConfiguration newConf, StringBuilder sb) {
        Map <String, String> oldMap = dictionariesMap;
        Map <String, String> newMap = newConf.dictionariesMap;

        if (oldMap.isEmpty() && newMap.isEmpty()) {
            return;
        }

        oldMap.forEach((fragment, dictionaries) -> {
            String newDictionaries = newMap.get(fragment);

            if (newDictionaries == null) {
                sb.append(ALTER_CONFIGURATION)
                .append(getQualifiedName())
                .append("\n\tDROP MAPPING FOR ").append(fragment).append(';');
            } else if (!dictionaries.equals(newDictionaries)) {
                sb.append(ALTER_CONFIGURATION)
                .append(getQualifiedName())
                .append("\n\tALTER MAPPING FOR ").append(fragment)
                .append("\n\tWITH ").append(newDictionaries).append(";");
            }
        });

        newMap.forEach((fragment, dictionaries) -> {
            if (!oldMap.containsKey(fragment)) {
                sb.append(ALTER_CONFIGURATION)
                .append(getQualifiedName())
                .append("\n\tADD MAPPING FOR ").append(fragment)
                .append("\n\tWITH ").append(dictionaries).append(";");
            }
        });
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
