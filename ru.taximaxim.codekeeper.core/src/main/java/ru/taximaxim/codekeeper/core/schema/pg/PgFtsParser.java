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

import java.util.Objects;

import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.ISearchPath;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class PgFtsParser extends PgStatement implements ISearchPath {

    private static final String NEW_LINE = ",\n\t";

    private String startFunction;
    private String getTokenFunction;
    private String endFunction;
    private String headLineFunction;
    private String lexTypesFunction;

    public PgFtsParser(String name) {
        super(name);
    }

    @Override
    public DbObjType getStatementType() {
        return DbObjType.FTS_PARSER;
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) parent;
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        StringBuilder sbSql = new StringBuilder();
        sbSql.append("CREATE TEXT SEARCH PARSER ")
        .append(getQualifiedName()).append(" (\n\t")
        .append("START = ").append(startFunction).append(NEW_LINE)
        .append("GETTOKEN = ").append(getTokenFunction).append(NEW_LINE)
        .append("END = ").append(endFunction).append(NEW_LINE);
        if (headLineFunction != null) {
            sbSql.append("HEADLINE = ").append(headLineFunction).append(NEW_LINE);
        }
        sbSql.append("LEXTYPES = ").append(lexTypesFunction);

        sbSql.append(" )");
        script.addStatement(sbSql);
        appendComments(script);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        if (!compareUnalterable((PgFtsParser) newCondition)) {
            return ObjectState.RECREATE;
        }
        appendAlterComments(newCondition, script);

        return getObjectState(script, startSize);
    }

    @Override
    public PgFtsParser shallowCopy() {
        PgFtsParser parserDst = new PgFtsParser(name);
        copyBaseFields(parserDst);
        parserDst.setStartFunction(startFunction);
        parserDst.setGetTokenFunction(getTokenFunction);
        parserDst.setEndFunction(endFunction);
        parserDst.setLexTypesFunction(lexTypesFunction);
        parserDst.setHeadLineFunction(headLineFunction);
        return parserDst;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof PgFtsParser parser && super.compare(obj)) {
            return compareUnalterable(parser);
        }

        return false;
    }

    private boolean compareUnalterable(PgFtsParser parser) {
        return Objects.equals(startFunction, parser.startFunction)
                && Objects.equals(getTokenFunction, parser.getTokenFunction)
                && Objects.equals(endFunction, parser.endFunction)
                && Objects.equals(headLineFunction, parser.headLineFunction)
                && Objects.equals(lexTypesFunction, parser.lexTypesFunction);
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(startFunction);
        hasher.put(getTokenFunction);
        hasher.put(endFunction);
        hasher.put(headLineFunction);
        hasher.put(lexTypesFunction);
    }

    public void setStartFunction(final String startFunction) {
        this.startFunction = startFunction;
        resetHash();
    }

    public void setGetTokenFunction(final String getTokenFunction) {
        this.getTokenFunction = getTokenFunction;
        resetHash();
    }

    public void setEndFunction(final String endFunction) {
        this.endFunction = endFunction;
        resetHash();
    }

    public void setLexTypesFunction(final String lexTypesFunction) {
        this.lexTypesFunction = lexTypesFunction;
        resetHash();
    }

    public void setHeadLineFunction(final String headLineFunction) {
        this.headLineFunction = headLineFunction;
        resetHash();
    }
}
