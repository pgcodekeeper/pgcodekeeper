/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.loader.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.loader.QueryBuilder;
import ru.taximaxim.codekeeper.core.loader.SupportedVersion;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.VexAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.CreateDomain;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractType;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.ICompressOptionContainer;
import ru.taximaxim.codekeeper.core.schema.PgBaseType;
import ru.taximaxim.codekeeper.core.schema.PgColumn;
import ru.taximaxim.codekeeper.core.schema.PgCompositeType;
import ru.taximaxim.codekeeper.core.schema.PgConstraint;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgDomain;
import ru.taximaxim.codekeeper.core.schema.PgEnumType;
import ru.taximaxim.codekeeper.core.schema.PgRangeType;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public final class TypesReader extends JdbcReader {

    private static final String EMPTY_FUNCTION = "-";
    private static final String ADD_CONSTRAINT = "ALTER DOMAIN noname ADD CONSTRAINT noname ";

    public TypesReader(JdbcLoaderBase loader) {
        super(loader);
    }

    @Override
    protected void processResult(ResultSet result, AbstractSchema schema) throws SQLException {
        PgStatement typeOrDomain = getTypeDomain(result, schema);
        if (typeOrDomain != null) {
            if (typeOrDomain.getStatementType() == DbObjType.DOMAIN) {
                schema.addDomain((PgDomain) typeOrDomain);
            } else {
                schema.addType((AbstractType) typeOrDomain);
            }
        }
    }

    private PgStatement getTypeDomain(ResultSet res, AbstractSchema schema) throws SQLException {
        PgStatement st;
        String typtype = res.getString("typtype");
        if ("d".equals(typtype)) {
            st = getDomain(res, schema);
        } else {
            st = getType(res, schema.getName(), typtype);
        }
        if (st != null) {
            loader.setOwner(st, res.getLong("typowner"));
            loader.setPrivileges(st, res.getString("typacl"), schema.getName());
            loader.setAuthor(st, res);
            loader.setComment(st, res);
        }
        return st;
    }

    private PgDomain getDomain(ResultSet res, AbstractSchema schema) throws SQLException {
        String schemaName = schema.getName();
        PgDomain d = new PgDomain(res.getString("typname"));
        loader.setCurrentObject(new GenericColumn(schemaName, d.getName(), DbObjType.DOMAIN));

        String type = res.getString("dom_basetypefmt");
        checkTypeValidity(type);
        d.setDataType(type);
        loader.cachedTypesByOid.get(res.getLong("dom_basetype")).addTypeDepcy(d);

        long collation = res.getLong("typcollation");
        if (collation != 0 && collation != res.getLong("dom_basecollation")) {
            d.setCollation(PgDiffUtils.getQuotedName(res.getString("dom_collationnspname"))
                    + '.' + PgDiffUtils.getQuotedName(res.getString("dom_collationname")));
        }

        PgDatabase dataBase = schema.getDatabase();

        String def = res.getString("dom_defaultbin");
        if (def == null) {
            def = res.getString("typdefault");
            if (def != null) {
                def = PgDiffUtils.quoteString(def);
            }
        } else {
            loader.submitAntlrTask(def, p -> p.vex_eof().vex().get(0),
                    ctx -> dataBase.addAnalysisLauncher(
                            new VexAnalysisLauncher(d, ctx, loader.getCurrentLocation())));
        }

        d.setDefaultValue(def);
        d.setNotNull(res.getBoolean("dom_notnull"));

        String[] connames = getColArray(res, "dom_connames");
        if (connames != null) {
            String[] condefs = getColArray(res, "dom_condefs");
            String[] concomments = getColArray(res, "dom_concomments");

            for (int i = 0; i < connames.length; ++i) {
                String conName = connames[i];
                AbstractConstraint c = new PgConstraint(conName);
                String definition = condefs[i];
                checkObjectValidity(definition, DbObjType.CONSTRAINT, conName);
                loader.submitAntlrTask(ADD_CONSTRAINT + definition + ';',
                        p -> p.sql().statement(0).schema_statement().schema_alter()
                        .alter_domain_statement().dom_constraint,
                        ctx -> CreateDomain.parseDomainConstraint(d, c, ctx,
                                dataBase, loader.getCurrentLocation()));

                d.addConstraint(c);
                if (concomments[i] != null && !concomments[i].isEmpty()) {
                    c.setComment(loader.args, PgDiffUtils.quoteString(concomments[i]));
                }
            }
        }

        return d;
    }

    private AbstractType getType(ResultSet res, String schemaName, String typtype) throws SQLException {
        String name = res.getString("typname");
        loader.setCurrentObject(new GenericColumn(schemaName, name, DbObjType.TYPE));
        switch (typtype) {
        case "b":
            return getBaseType(res, name);
        case "c": return getCompositeType(res, name);
        case "e": return getEnumType(res, name);
        case "r":
            return getRangeType(res, name);
        default: return null;
        }
    }

    private PgBaseType getBaseType(ResultSet res, String name) throws SQLException {
        PgBaseType t = new PgBaseType(name);
        String typinput = res.getString("typinput");
        setFunctionWithDep(PgBaseType::setInputFunction, t, typinput);
        setFunctionWithDep(PgBaseType::setOutputFunction, t, res.getString("typoutput"));

        String typreceive = res.getString("typreceive");
        if (!EMPTY_FUNCTION.equals(typreceive)) {
            setFunctionWithDep(PgBaseType::setReceiveFunction, t, typreceive);
        }

        String typsend = res.getString("typsend");
        if (!EMPTY_FUNCTION.equals(typsend)) {
            setFunctionWithDep(PgBaseType::setSendFunction, t, typsend);
        }

        String typmodin = res.getString("typmodin");
        if (!EMPTY_FUNCTION.equals(typmodin)) {
            setFunctionWithDep(PgBaseType::setTypmodInputFunction, t, typmodin);
        }

        String typmodout = res.getString("typmodout");
        if (!EMPTY_FUNCTION.equals(typmodout)) {
            setFunctionWithDep(PgBaseType::setTypmodOutputFunction, t, typmodout);
        }

        String typanalyzeset = res.getString("typanalyze");
        if (!EMPTY_FUNCTION.equals(typanalyzeset)) {
            setFunctionWithDep(PgBaseType::setAnalyzeFunction, t, typanalyzeset);
        }

        if (SupportedVersion.VERSION_14.isLE(loader.version)) {
            String typsubscript = res.getString("typsubscript");
            if (!EMPTY_FUNCTION.equals(typsubscript)) {
                setFunctionWithDep(PgBaseType::setSubscriptFunction, t, typsubscript);
            }
        }


        short len = res.getShort("typlen");
        t.setInternalLength(len == -1 ? "variable" : "" + len);
        t.setPassedByValue(res.getBoolean("typbyval"));

        String align = res.getString("typalign");
        switch (align) {
        case "c": t.setAlignment("char"); break;
        case "s": t.setAlignment("int2"); break;
        case "i": t.setAlignment("int4"); break;
        case "d": t.setAlignment("double"); break;
        default : t.setAlignment(align);
        }

        String storage = res.getString("typstorage");
        switch (storage) {
        case "p": t.setStorage("plain"); break;
        case "e": t.setStorage("external"); break;
        case "x": t.setStorage("extended"); break;
        case "m": t.setStorage("main"); break;
        default : t.setStorage(storage);
        }

        String cat = res.getString("typcategory");
        if (cat != null && !"U".equals(cat)) {
            t.setCategory(PgDiffUtils.quoteString(cat));
        }

        if (res.getBoolean("typispreferred")) {
            t.setPreferred("true");
        }

        String def = res.getString("typdefaultbin");
        if (def == null) {
            def = res.getString("typdefault");
            if (def != null) {
                def = PgDiffUtils.quoteString(def);
            }
        }
        t.setDefaultValue(def);

        long elem = res.getLong("typelem");
        if (elem != 0) {
            JdbcType typeElem = loader.cachedTypesByOid.get(elem);
            t.setElement(typeElem.getFullName());
            // autogenerated array types are hidden
            // so we should only get explicitly defined typelems as dependencies
            typeElem.addTypeDepcy(t);
        }

        String delim = res.getString("typdelim");
        if (delim != null && !",".equals(delim)) {
            t.setDelimiter(PgDiffUtils.quoteString(delim));
        }

        if (res.getLong("typcollation") != 0) {
            t.setCollatable("true");
        }

        if (loader.isGreenplumDb) {
            ICompressOptionContainer.fillCompressOptions(t, res.getString("typoptions"));
        }

        return t;
    }

    private PgCompositeType getCompositeType(ResultSet res, String name) throws SQLException {
        PgCompositeType t = new PgCompositeType(name);
        String[] attnames = getColArray(res, "comp_attnames");
        if (attnames == null) {
            return t;
        }
        String[] atttypes = getColArray(res, "comp_atttypdefns");
        Long[] atttypeids = getColArray(res, "comp_atttypids");
        Long[] attcollations = getColArray(res, "comp_attcollations");
        Long[] atttypcollations = getColArray(res, "comp_atttypcollations");
        String[] attcollationnames = getColArray(res, "comp_attcollationnames");
        String[] attcollationnspnames = getColArray(res, "comp_attcollationnspnames");
        String[] attcomments = getColArray(res, "comp_attcomments");

        for (int i = 0; i < attnames.length; ++i) {
            AbstractColumn a = new PgColumn(attnames[i]);
            String type = atttypes[i];
            checkTypeValidity(type);
            a.setType(type);
            loader.cachedTypesByOid.get(atttypeids[i]).addTypeDepcy(t);

            // unbox
            long attcollation = attcollations[i];
            if (attcollation != 0 && attcollation != atttypcollations[i]) {
                a.setCollation(PgDiffUtils.getQuotedName(attcollationnspnames[i])
                        + '.' + PgDiffUtils.getQuotedName(attcollationnames[i]));
            }
            t.addAttr(a);
            if (attcomments[i] != null && !attcomments[i].isEmpty()) {
                a.setComment(loader.args, PgDiffUtils.quoteString(attcomments[i]));
            }
        }

        return t;
    }

    private PgEnumType getEnumType(ResultSet res, String name) throws SQLException {
        PgEnumType t = new PgEnumType(name);
        String[] enums = getColArray(res, "enums");
        if (enums != null) {
            for (String enum_ : enums) {
                t.addEnum(PgDiffUtils.quoteString(enum_));
            }
        }

        return t;
    }

    private PgRangeType getRangeType(ResultSet res, String name) throws SQLException {
        PgRangeType t = new PgRangeType(name);
        JdbcType subtype = loader.cachedTypesByOid.get(res.getLong("rngsubtype"));
        t.setSubtype(subtype.getFullName());
        subtype.addTypeDepcy(t);

        if (!res.getBoolean("opcdefault")) {
            t.setSubtypeOpClass(PgDiffUtils.getQuotedName(res.getString("opcnspname")
                    + '.' + PgDiffUtils.getQuotedName(res.getString("opcname"))));
        }

        long collation = res.getLong("rngcollation");
        if (collation != 0 && collation != res.getLong("rngsubtypcollation")) {
            t.setCollation(PgDiffUtils.getQuotedName(res.getString("rngcollationnspname"))
                    + '.' + PgDiffUtils.getQuotedName(res.getString("rngcollationname")));
        }

        if (res.getBoolean("rngcanonicalset")) {
            setFunctionWithDep(PgRangeType::setCanonical, t, res.getString("rngcanonical"));
        }
        if (res.getBoolean("rngsubdiffset")) {
            setFunctionWithDep(PgRangeType::setSubtypeDiff, t, res.getString("rngsubdiff"));
        }

        if (SupportedVersion.VERSION_14.isLE(loader.version)) {
            long multiRangeLong = res.getLong("rngmultirange");
            if (multiRangeLong != 0) {
                JdbcType multiRangeType = loader.cachedTypesByOid.get(multiRangeLong);
                t.setMultirange(multiRangeType.getFullName());
                multiRangeType.addTypeDepcy(t);
            }
        }
        return t;
    }

    @Override
    protected String getClassId() {
        return "pg_type";
    }

    @Override
    protected String getSchemaColumn() {
        return "res.typnamespace";
    }

    @Override
    protected void fillQueryBuilder(QueryBuilder builder) {
        addSysSchemasCte(builder);
        addExtensionDepsCte(builder);
        addDescriptionPart(builder);

        builder
        // common part
        .with("nspnames", "SELECT n.oid, n.nspname FROM pg_catalog.pg_namespace n")
        .with("collations",
                "SELECT c.oid, c.collname, n.nspname FROM pg_catalog.pg_collation c LEFT JOIN nspnames n ON n.oid = c.collnamespace")
        .column("res.typname")
        .column("res.typowner::bigint")
        .column("res.typacl::text")
        .column("res.typtype")
        .from("pg_catalog.pg_type res")
        .where("res.typisdefined = TRUE")
        .where("(res.typrelid = 0 OR (SELECT c.relkind FROM pg_catalog.pg_class c WHERE c.oid = res.typrelid) = 'c')")
        .where("NOT EXISTS(SELECT 1 FROM pg_catalog.pg_type el WHERE el.oid = res.typelem AND el.typarray = res.oid)")

        // for base and domain
        .column("res.typdefault")
        .column("res.typcollation::bigint")

        // for enum
        .column("(SELECT pg_catalog.array_agg(en.enumlabel ORDER BY en.enumsortorder) FROM pg_catalog.pg_enum en WHERE en.enumtypid = res.oid GROUP BY en.enumtypid) AS enums");

        addRangePart(builder);
        addBasePart(builder);
        addDomainPart(builder);
        addCompositePart(builder);
    }

    private void addRangePart(QueryBuilder builder) {
        builder
        .column("r.rngsubtype::bigint")
        .column("opc.opcname")
        .column("(SELECT n.nspname FROM nspnames n WHERE n.oid = opc.opcnamespace) AS opcnspname")
        .column("opc.opcdefault")
        .column("r.rngcollation::bigint")
        .column("(SELECT tsub.typcollation::bigint FROM pg_catalog.pg_type tsub WHERE tsub.oid = r.rngsubtype) AS rngsubtypcollation")
        .column("(SELECT cl.collname FROM collations cl WHERE cl.oid = r.rngcollation) AS rngcollationname")
        .column("(SELECT cl.nspname FROM collations cl WHERE cl.oid = r.rngcollation) AS rngcollationnspname")
        .column("r.rngcanonical")
        .column("r.rngsubdiff")
        .column("r.rngcanonical != 0 AS rngcanonicalset")
        .column("r.rngsubdiff != 0 AS rngsubdiffset")
        .join("LEFT JOIN pg_catalog.pg_range r ON r.rngtypid = res.oid")
        .join("LEFT JOIN pg_catalog.pg_opclass opc ON opc.oid = r.rngsubopc");

        if (SupportedVersion.VERSION_14.isLE(loader.version)) {
            builder.column("r.rngmultitypid::bigint AS rngmultirange");
        }
    }

    private void addBasePart(QueryBuilder builder) {
        builder
        .column("res.typinput")
        .column("res.typoutput")
        .column("res.typreceive")
        .column("res.typsend")
        .column("res.typmodin")
        .column("res.typmodout")
        .column("res.typanalyze")
        .column("res.typlen")
        .column("res.typbyval")
        .column("res.typalign")
        .column("res.typstorage")
        .column("res.typcategory")
        .column("res.typispreferred")
        .column("pg_catalog.pg_get_expr(res.typdefaultbin, 0) AS typdefaultbin")
        .column("res.typelem::bigint")
        .column("res.typdelim");

        if (SupportedVersion.VERSION_14.isLE(loader.version)) {
            builder.column("res.typsubscript");
        }

        if (loader.isGreenplumDb) {
            builder
            .column("coalesce(array_to_string(e.typoptions, ', '), '') AS typoptions")
            .join("LEFT JOIN pg_type_encoding e ON res.oid = e.typid");
        }
    }

    private void addDomainPart(QueryBuilder builder) {
        String constraints = "LEFT JOIN(\n"
                + "  SELECT\n"
                + "    c.contypid,\n"
                + "    pg_catalog.array_agg(c.conname ORDER BY c.conname) AS connames,\n"
                + "    pg_catalog.array_agg(pg_catalog.pg_get_constraintdef(c.oid) ORDER BY c.conname) AS condefs,\n"
                + "    pg_catalog.array_agg(cd.description ORDER BY c.conname) AS concomments\n"
                + "  FROM pg_catalog.pg_constraint c\n"
                + "  LEFT JOIN pg_catalog.pg_description cd ON cd.objoid = c.oid\n"
                + "    AND cd.classoid = 'pg_catalog.pg_constraint'::pg_catalog.regclass\n"
                + "  WHERE c.contypid != 0\n"
                + "  GROUP BY c.contypid\n"
                + ") dom_constraints ON dom_constraints.contypid = res.oid";

        builder.column("dom_constraints.connames AS dom_connames");
        builder.column("dom_constraints.condefs AS dom_condefs");
        builder.column("dom_constraints.concomments AS dom_concomments");
        builder.join(constraints);
    }

    private void addCompositePart(QueryBuilder builder) {
        String columns = "LEFT JOIN(\n"
                + "  SELECT\n"
                + "    a.attrelid,\n"
                + "    pg_catalog.array_agg(a.attname ORDER BY a.attnum) AS attnames,\n"
                + "    pg_catalog.array_agg(pg_catalog.format_type(a.atttypid, a.atttypmod) ORDER BY a.attnum) AS atttypdefns,\n"
                + "    pg_catalog.array_agg(a.atttypid::bigint ORDER BY a.attnum) AS atttypids,\n"
                + "    pg_catalog.array_agg(a.attcollation::bigint ORDER BY a.attnum) AS attcollations,\n"
                + "    pg_catalog.array_agg(ta.typcollation::bigint ORDER BY a.attnum) AS atttypcollations,\n"
                + "    pg_catalog.array_agg(cl.collname ORDER BY a.attnum) AS attcollationnames,\n"
                + "    pg_catalog.array_agg(cl.nspname ORDER BY a.attnum) AS attcollationnspnames,\n"
                + "    pg_catalog.array_agg(d.description ORDER BY a.attnum) AS attcomments\n"
                + "  FROM pg_catalog.pg_attribute a\n"
                + "  LEFT JOIN pg_catalog.pg_type ta ON ta.oid = a.atttypid\n"
                + "  LEFT JOIN collations cl ON cl.oid = a.attcollation\n"
                + "  LEFT JOIN pg_catalog.pg_description d ON d.objoid = a.attrelid AND d.objsubid = a.attnum\n"
                + "    AND d.classoid = 'pg_catalog.pg_class'::pg_catalog.regclass\n"
                + "  WHERE a.attisdropped = FALSE\n"
                + "  GROUP BY a.attrelid\n"
                + ") comp_attrs ON comp_attrs.attrelid = res.typrelid";

        builder
        .column("pg_catalog.format_type(res.typbasetype, res.typtypmod) AS dom_basetypefmt")
        .column("res.typbasetype::bigint AS dom_basetype")
        .column("(SELECT tbase.typcollation::bigint FROM pg_catalog.pg_type tbase WHERE tbase.oid = res.typbasetype) AS dom_basecollation")
        .column("(SELECT cl.collname FROM collations cl WHERE cl.oid = res.typcollation) AS dom_collationname")
        .column("(SELECT cl.nspname FROM collations cl WHERE cl.oid = res.typcollation) AS dom_collationnspname")
        .column("pg_catalog.pg_get_expr(res.typdefaultbin, 'pg_catalog.pg_type'::pg_catalog.regclass) AS dom_defaultbin")
        .column("res.typnotnull AS dom_notnull")
        .column("comp_attrs.attnames AS comp_attnames")
        .column("comp_attrs.atttypdefns AS comp_atttypdefns")
        .column("comp_attrs.atttypids AS comp_atttypids")
        .column("comp_attrs.attcollations AS comp_attcollations")
        .column("comp_attrs.atttypcollations AS comp_atttypcollations")
        .column("comp_attrs.attcollationnames AS comp_attcollationnames")
        .column("comp_attrs.attcollationnspnames AS comp_attcollationnspnames")
        .column("comp_attrs.attcomments AS comp_attcomments")
        .join(columns);
    }
}
