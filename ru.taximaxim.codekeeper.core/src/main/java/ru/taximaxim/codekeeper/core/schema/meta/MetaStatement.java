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

import java.io.Serializable;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public class MetaStatement implements IStatement, Serializable {

    private static final long serialVersionUID = 5744769530265917940L;

    private final PgObjLocation object;
    private String comment = "";

    public MetaStatement(PgObjLocation object) {
        this.object = object;
    }

    public MetaStatement(GenericColumn column) {
        this(new PgObjLocation.Builder().setObject(column).build());
    }

    @Override
    public String getName() {
        return getBareName();
    }

    @Override
    public String getBareName() {
        return object.getObjName();
    }

    @Override
    public DbObjType getStatementType() {
        return object.getType();
    }

    public GenericColumn getGenericColumn() {
        return object.getObj();
    }

    public PgObjLocation getObject() {
        return object;
    }

    @Override
    public String getQualifiedName() {
        return getGenericColumn().getQualifiedName();
    }

    @Override
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getObjLength() {
        return object.getObjLength();
    }

    public int getOffset() {
        return object.getOffset();
    }

    public String getFilePath() {
        return object.getFilePath();
    }

    public int getLineNumber() {
        return object.getLineNumber();
    }

    @Override
    public MetaStatement getParent() {
        throw new IllegalStateException("Unsupported operation");
    }

    @Override
    public AbstractDatabase getDatabase() {
        throw new IllegalStateException("Unsupported operation");
    }
}
