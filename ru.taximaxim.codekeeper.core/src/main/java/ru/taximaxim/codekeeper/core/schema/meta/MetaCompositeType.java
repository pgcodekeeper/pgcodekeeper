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

import java.util.HashMap;
import java.util.Map;

import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public final class MetaCompositeType extends MetaStatement {

    private static final long serialVersionUID = 195609665520321852L;

    private Map<String, String> attrs = new HashMap<>();

    public MetaCompositeType(PgObjLocation object) {
        super(object);
    }

    public String getSchemaName() {
        return getObject().getSchema();
    }

    public void addAttr(String name, String type) {
        attrs.put(name, type);
    }

    public String getAttrType(String attrName) {
        return attrs.get(attrName);
    }
}
