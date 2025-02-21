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
package ru.taximaxim.codekeeper.core.model.graph;

import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class PrintObj {

    private final PgStatement statement;
    private final PgStatement parentSt;
    private final int indent;
    private final int hiddenObj;
    private final boolean isCyclic;

    public PrintObj(PgStatement statement, PgStatement parentSt, int indent, int hiddenObj, boolean isCyclic) {
        this.statement = statement;
        this.parentSt = parentSt;
        this.indent = indent;
        this.hiddenObj = hiddenObj;
        this.isCyclic = isCyclic;
    }

    public PgStatement getStatement() {
        return statement;
    }

    public PgStatement getParentSt() {
        return parentSt;
    }

    public int getIndent() {
        return indent;
    }

    public int getHiddenObj() {
        return hiddenObj;
    }

    public boolean isCyclic() {
        return isCyclic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("\t");
        }

        sb.append(statement.getStatementType()).append(" ").append(statement.getQualifiedName());
        if (hiddenObj > 0) {
            sb.append(" (hidden ").append(hiddenObj).append(" objects)");
        }
        if (isCyclic) {
            sb.append(" - cyclic dependency");
        }

        return sb.toString();
    }

}
