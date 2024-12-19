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
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.IOperator;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

/**
 * Postgres schema code generation.
 */
public class PgSchema extends AbstractSchema {

    private final Map<String, PgDomain> domains = new LinkedHashMap<>();
    private final Map<String, PgFtsParser> parsers = new LinkedHashMap<>();
    private final Map<String, PgFtsTemplate> templates = new LinkedHashMap<>();
    private final Map<String, PgFtsDictionary> dictionaries = new LinkedHashMap<>();
    private final Map<String, PgFtsConfiguration> configurations = new LinkedHashMap<>();
    private final Map<String, PgOperator> operators = new LinkedHashMap<>();
    private final Map<String, PgCollation> collations = new LinkedHashMap<>();
    private final Map<String, PgStatistics> statistics = new LinkedHashMap<>();

    public PgSchema(String name) {
        super(name);
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE SCHEMA ");
        appendIfNotExists(sbSQL);
        sbSQL.append(getQualifiedName());
        script.addStatement(sbSQL);

        appendOwnerSQL(script);
        appendPrivileges(script);
        appendComments(script);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        appendAlterOwner(newCondition, script);
        alterPrivileges(newCondition, script);
        appendAlterComments(newCondition, script);

        return getObjectState(script, startSize);
    }

    public PgDomain getDomain(String name) {
        return domains.get(name);
    }

    public PgCollation getCollation(final String name) {
        return collations.get(name);
    }

    public PgFtsParser getFtsParser(final String name) {
        return parsers.get(name);
    }

    public PgFtsTemplate getFtsTemplate(final String name) {
        return templates.get(name);
    }

    public PgFtsDictionary getFtsDictionary(final String name) {
        return dictionaries.get(name);
    }

    public PgFtsConfiguration getFtsConfiguration(final String name) {
        return configurations.get(name);
    }

    public PgOperator getOperator(final String signature) {
        return operators.get(signature);
    }

    public PgStatistics getStatistics(final String name) {
        return statistics.get(name);
    }

    public Collection<PgFtsParser> getFtsParsers() {
        return Collections.unmodifiableCollection(parsers.values());
    }

    public Collection<PgFtsTemplate> getFtsTemplates() {
        return Collections.unmodifiableCollection(templates.values());
    }

    public Collection<PgFtsDictionary> getFtsDictionaries() {
        return Collections.unmodifiableCollection(dictionaries.values());
    }

    public Collection<PgFtsConfiguration> getFtsConfigurations() {
        return Collections.unmodifiableCollection(configurations.values());
    }

    public Collection<IOperator> getOperators() {
        return Collections.unmodifiableCollection(operators.values());
    }

    public Collection<PgCollation> getCollations() {
        return Collections.unmodifiableCollection(collations.values());
    }

    public Collection<PgDomain> getDomains() {
        return Collections.unmodifiableCollection(domains.values());
    }

    public Collection<PgStatistics> getStatistics() {
        return Collections.unmodifiableCollection(statistics.values());
    }

    public void addCollation(final PgCollation collation) {
        addUnique(collations, collation);
    }

    public void addDomain(PgDomain dom) {
        addUnique(domains, dom);
    }

    public void addFtsParser(final PgFtsParser parser) {
        addUnique(parsers, parser);
    }

    public void addFtsTemplate(final PgFtsTemplate template) {
        addUnique(templates, template);
    }

    public void addFtsDictionary(final PgFtsDictionary dictionary) {
        addUnique(dictionaries, dictionary);
    }

    public void addFtsConfiguration(final PgFtsConfiguration configuration) {
        addUnique(configurations, configuration);
    }

    public void addOperator(final PgOperator oper) {
        addUnique(operators, oper);
    }

    public void addStatistics(final PgStatistics rule) {
        addUnique(statistics, rule);
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        super.fillChildrenList(l);
        l.add(domains.values());
        l.add(parsers.values());
        l.add(templates.values());
        l.add(dictionaries.values());
        l.add(configurations.values());
        l.add(operators.values());
        l.add(collations.values());
        l.add(statistics.values());
    }

    @Override
    public PgStatement getChild(String name, DbObjType type) {
        return switch (type) {
        case DOMAIN -> getDomain(name);
        case FTS_PARSER -> getFtsParser(name);
        case FTS_TEMPLATE -> getFtsTemplate(name);
        case FTS_DICTIONARY -> getFtsDictionary(name);
        case FTS_CONFIGURATION -> getFtsConfiguration(name);
        case OPERATOR -> getOperator(name);
        case COLLATION -> getCollation(name);
        case STATISTICS -> getStatistics(name);
        default -> super.getChild(name, type);
        };
    }

    @Override
    public void addChild(IStatement st) {
        DbObjType type = st.getStatementType();
        switch (type) {
        case DOMAIN:
            addDomain((PgDomain) st);
            break;
        case FTS_CONFIGURATION:
            addFtsConfiguration((PgFtsConfiguration) st);
            break;
        case FTS_DICTIONARY:
            addFtsDictionary((PgFtsDictionary) st);
            break;
        case FTS_PARSER:
            addFtsParser((PgFtsParser) st);
            break;
        case FTS_TEMPLATE:
            addFtsTemplate((PgFtsTemplate) st);
            break;
        case OPERATOR:
            addOperator((PgOperator) st);
            break;
        case COLLATION:
            addCollation((PgCollation) st);
            break;
        case STATISTICS:
            addStatistics((PgStatistics) st);
            break;
        default:
            super.addChild(st);
        }
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof PgSchema schema) {
            return super.compareChildren(obj)
                    && domains.equals(schema.domains)
                    && collations.equals(schema.collations)
                    && parsers.equals(schema.parsers)
                    && templates.equals(schema.templates)
                    && dictionaries.equals(schema.dictionaries)
                    && configurations.equals(schema.configurations)
                    && operators.equals(schema.operators)
                    && statistics.equals(schema.statistics);
        }
        return false;
    }

    @Override
    protected void computeChildrenHash(Hasher hasher) {
        super.computeChildrenHash(hasher);
        hasher.putUnordered(domains);
        hasher.putUnordered(collations);
        hasher.putUnordered(parsers);
        hasher.putUnordered(templates);
        hasher.putUnordered(dictionaries);
        hasher.putUnordered(configurations);
        hasher.putUnordered(operators);
        hasher.putUnordered(statistics);
    }

    @Override
    protected AbstractSchema getSchemaCopy() {
        return new PgSchema(getName());
    }
}
