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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ru.taximaxim.codekeeper.core.schema.ICast;
import ru.taximaxim.codekeeper.core.schema.ICast.CastContext;
import ru.taximaxim.codekeeper.core.schema.IConstraint;
import ru.taximaxim.codekeeper.core.schema.IFunction;
import ru.taximaxim.codekeeper.core.schema.IOperator;
import ru.taximaxim.codekeeper.core.schema.IRelation;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.ch.ChFunction;

public final class MetaContainer {

    private final List<ICast> casts = new ArrayList<>();

    /**
     * Functions grouped by schema name
     */
    private final Map<String, Map<String, IFunction>> functions = new LinkedHashMap<>();

    /**
     * ClickHouse functions
     */
    private final Map<String, IFunction> chFunctions = new LinkedHashMap<>();

    /**
     * Operators grouped by schema name
     */
    private final Map<String, Map<String, IOperator>> operators = new LinkedHashMap<>();

    /**
     * Relations grouped by schema name
     */
    private final Map<String, Map<String, IRelation>> relations = new LinkedHashMap<>();

    /**
     * Constraints grouped by schema name and table name
     */
    private final Map<String, Map<String, List<IConstraint>>> constraints = new LinkedHashMap<>();

    /**
     * PostgreSQL composite types grouped by schema name
     */
    private final Map<String, Map<String, MetaCompositeType>> pgCompositeTypes = new LinkedHashMap<>();

    public void addStatement(IStatement st) {
        switch (st.getStatementType()) {
        case CAST:
            casts.add((ICast) st);
            break;
        case FUNCTION, PROCEDURE, AGGREGATE:
            if (st instanceof ChFunction f) {
                chFunctions.put(f.getName(), f);
                break;
            }
            IFunction f = (IFunction) st;
            functions.computeIfAbsent(f.getSchemaName(), e -> new LinkedHashMap<>()).put(f.getName(), f);
            break;
        case OPERATOR:
            IOperator op = (IOperator) st;
            operators.computeIfAbsent(op.getSchemaName(), e -> new LinkedHashMap<>()).put(op.getName(), op);
            break;
        case TABLE, DICTIONARY, VIEW, SEQUENCE:
            IRelation rel = (IRelation) st;
            relations.computeIfAbsent(rel.getSchemaName(), e -> new LinkedHashMap<>()).put(rel.getName(), rel);
            break;
        case CONSTRAINT:
            IConstraint con = (IConstraint) st;
            constraints
            .computeIfAbsent(con.getSchemaName(), e -> new LinkedHashMap<>())
            .computeIfAbsent(con.getTableName(), e -> new ArrayList<>())
            .add(con);
            break;
        case TYPE:
            if (st instanceof MetaCompositeType t) {
                pgCompositeTypes.computeIfAbsent(t.getSchemaName(), e -> new LinkedHashMap<>()).put(t.getName(), t);
            }
            break;
        default:
            break;
        }
    }

    public boolean containsCastImplicit(String source, String target) {
        for (ICast cast : casts) {
            if (CastContext.IMPLICIT == cast.getContext()
                    && source.equals(cast.getSource())
                    && target.equals(cast.getTarget())) {
                return true;
            }
        }
        return false;
    }

    public IRelation findRelation(String schemaName, String relationName) {
        return relations.getOrDefault(schemaName, Collections.emptyMap()).get(relationName);
    }

    public Map<String, Map<String, IRelation>> getRelations() {
        return Collections.unmodifiableMap(relations);
    }

    public IFunction findFunction(String schemaName, String functionName) {
        return functions.getOrDefault(schemaName, Collections.emptyMap()).get(functionName);
    }

    public boolean findChFunction(String functionName) {
        return chFunctions.containsKey(functionName);
    }

    public Collection<IFunction> availableChFunctions() {
        return Collections.unmodifiableCollection(chFunctions.values());
    }

    public Collection<IFunction> availableFunctions(String schemaName) {
        return Collections.unmodifiableCollection(functions
                .getOrDefault(schemaName, Collections.emptyMap()).values());
    }

    public IOperator findOperator(String schemaName, String operatorName) {
        return operators.getOrDefault(schemaName, Collections.emptyMap()).get(operatorName);
    }

    public MetaCompositeType findType(String schemaName, String typeName) {
        return pgCompositeTypes.getOrDefault(schemaName, Collections.emptyMap()).get(typeName);
    }

    public Collection<IOperator> availableOperators(String schemaName) {
        return Collections.unmodifiableCollection(operators
                .getOrDefault(schemaName, Collections.emptyMap()).values());
    }

    public Collection<IConstraint> getConstraints(String schemaName, String tableName) {
        return constraints
                .getOrDefault(schemaName, Collections.emptyMap())
                .getOrDefault(tableName, Collections.emptyList());
    }
}
