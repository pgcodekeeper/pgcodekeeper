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
package ru.taximaxim.codekeeper.core.parsers.antlr.chexpr;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Alias_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IRelation;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation.LocationType;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.Pair;

public abstract class ChAbstractExpr {

    private static final Logger LOG = LoggerFactory.getLogger(ChAbstractExpr.class);

    private final MetaContainer meta;
    private final String schema;
    private final ChAbstractExpr parent;
    private final Set<PgObjLocation> depcies;

    private ChAbstractExpr(String schema, ChAbstractExpr parent, Set<PgObjLocation> depcies, MetaContainer meta) {
        this.schema = schema;
        this.parent = parent;
        this.depcies = depcies;
        this.meta = meta;
    }

    protected ChAbstractExpr(String schema, MetaContainer meta) {
        this(schema, null, new LinkedHashSet<>(), meta);
    }

    protected ChAbstractExpr(MetaContainer meta) {
        this(null, meta);
    }

    public Set<PgObjLocation> getDepcies() {
        return Collections.unmodifiableSet(depcies);
    }

    protected ChAbstractExpr(ChAbstractExpr parent) {
        this(parent.schema, parent, parent.depcies, parent.meta);
    }

    protected ChAbstractExprWithNmspc<?> findCte(String cteName) {
        return hasParent() ? parent.findCte(cteName) : null;
    }

    protected boolean hasCte(String cteName) {
        return findCte(cteName) != null;
    }

    /**
     * @param schema
     *            optional schema qualification of name, may be null
     * @param name
     *            alias of the referenced object, lower-case for case-insensitive search call
     *            {@link #findReference(String, String)} to lower-case automatically
     * @return a pair of (Alias, Dealiased name) where Alias is the given name. Dealiased name can be null if the name
     *         is internal to the query and is not a reference to external table.<br>
     *         null if the name is not found
     */
    protected Entry<String, GenericColumn> findReferenceRecursive(String schema, String name) {
        return !hasParent() ? null : parent.findReferenceRecursive(schema, name);
    }

    protected void addReferenceInRootParent(Qualified_nameContext name, Alias_clauseContext alias, boolean isFrom) {
        if (hasParent()) {
            parent.addReferenceInRootParent(name, alias, isFrom);
        }
    }

    protected final boolean hasParent() {
        return parent != null;
    }

    protected final Entry<String, GenericColumn> findReference(String schema, String name) {
        return findReferenceRecursive(schema, name);
    }

    protected Pair<IRelation, Pair<String, String>> findColumn(String name) {
        return hasParent() ? parent.findColumn(name) : null;
    }

    protected IRelation findRelation(String schemaName, String relationName) {
        return meta.findRelation(schemaName, relationName);
    }

    protected final void addDepcy(GenericColumn depcy, ParserRuleContext ctx) {
        addDepcy(depcy, ctx, null);
    }

    protected final void addDepcy(GenericColumn depcy, ParserRuleContext ctx, Token start) {
        if (!Utils.isChSystemSchema(depcy.schema)) {
            PgObjLocation loc = new PgObjLocation.Builder()
                    .setObject(depcy)
                    .setCtx(ctx)
                    .build();
            if (start != null) {
                loc = loc.copyWithOffset(start.getStartIndex(),
                        start.getLine() - 1, start.getCharPositionInLine(), null);
            }

            depcies.add(loc);
        }
    }

    protected final void addReference(GenericColumn depcy, ParserRuleContext ctx, LocationType type) {
        depcies.add(new PgObjLocation.Builder()
                .setObject(depcy)
                .setCtx(ctx)
                .setLocationType(type)
                .setAlias(ctx.getText())
                .build());
    }

    protected final GenericColumn addObjectDepcy(Qualified_nameContext qualifiedName, DbObjType type) {
        var ids = qualifiedName.identifier();
        var schemaCtx = QNameParser.getSchemaNameCtx(ids);
        var relationName = QNameParser.getFirstName(ids);
        var relationCtx = QNameParser.getFirstNameCtx(ids);
        var schemaName = schemaCtx != null ? schemaCtx.getText() : Consts.CH_DEFAULT_DB;

        addDepcy(new GenericColumn(schemaName, DbObjType.SCHEMA), schemaCtx);
        GenericColumn depcy = new GenericColumn(schemaName, relationName, type);
        addDepcy(depcy, relationCtx);
        return depcy;
    }

    protected final void log(String msg, Object... args) {
        LOG.trace(msg, args);
    }
}
