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

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ICast;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;

public final class MetaCast extends MetaStatement implements ICast {

    private static final long serialVersionUID = 3309369936371201302L;

    private final String source;
    private final String target;

    private final CastContext context;

    public MetaCast(String source, String target, CastContext context) {
        super(new GenericColumn(ICast.getSimpleName(source, target), DbObjType.CAST));
        this.source = source;
        this.target = target;
        this.context = context;
    }

    public MetaCast(String source, String target, CastContext context, PgObjLocation object) {
        super(object);
        this.source = source;
        this.target = target;
        this.context = context;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public String getTarget() {
        return target;
    }

    @Override
    public CastContext getContext() {
        return context;
    }
}
