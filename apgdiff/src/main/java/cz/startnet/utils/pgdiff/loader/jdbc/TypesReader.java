package cz.startnet.utils.pgdiff.loader.jdbc;

import java.util.AbstractMap;
import java.util.Map;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constr_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_actionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.UtilExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgType;
import cz.startnet.utils.pgdiff.schema.PgType.PgTypeForm;
import cz.startnet.utils.pgdiff.wrappers.ResultSetWrapper;
import cz.startnet.utils.pgdiff.wrappers.WrapperAccessException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class TypesReader extends JdbcReader {

    public static String DOMAIN_CONSTRAINT = ".domainConstraint";

    public static class TypesReaderFactory extends JdbcReaderFactory {

        public TypesReaderFactory(long hasHelperMask, String helperFunction, Map<SupportedVersion, String> queries) {
            super(hasHelperMask, helperFunction, queries);
        }

        @Override
        public JdbcReader getReader(JdbcLoaderBase loader) {
            return new TypesReader(this, loader);
        }
    }

    private TypesReader(JdbcReaderFactory factory, JdbcLoaderBase loader) {
        super(factory, loader);
    }

    @Override
    protected void processResult(ResultSetWrapper result, PgSchema schema) throws WrapperAccessException {
        PgStatement typeOrDomain = getTypeDomain(result, schema);
        if (typeOrDomain != null) {
            if (typeOrDomain.getStatementType() == DbObjType.DOMAIN) {
                schema.addDomain((PgDomain) typeOrDomain);
            } else {
                schema.addType((PgType) typeOrDomain);
            }
        }
    }

    private PgStatement getTypeDomain(ResultSetWrapper res, PgSchema schema) throws WrapperAccessException {
        PgStatement st;
        String typtype = res.getString("typtype");
        if ("d".equals(typtype)) {
            st = getDomain(res, schema);
        } else {
            st = getType(res, schema.getName(), typtype);
        }
        if (st != null) {
            loader.setOwner(st, res.getLong("typowner"));
            loader.setPrivileges(st, PgDiffUtils.getQuotedName(st.getName()), res.getString("typacl"), st.getOwner(), null);
            String comment = res.getString("description");
            if (comment != null && !comment.isEmpty()) {
                st.setComment(loader.args, PgDiffUtils.quoteString(comment));
            }
        }
        return st;
    }

    private PgDomain getDomain(ResultSetWrapper res, PgSchema schema) throws WrapperAccessException {
        String schemaName = schema.getName();
        PgDomain d = new PgDomain(res.getString("typname"), "");
        loader.setCurrentObject(new GenericColumn(schemaName, d.getName(), DbObjType.DOMAIN));

        d.setDataType(res.getString("dom_basetypefmt"));
        loader.cachedTypesByOid.get(res.getLong("dom_basetype")).addTypeDepcy(d);

        long collation = res.getLong("typcollation");
        if (collation != 0 && collation != res.getLong("dom_basecollation")) {
            d.setCollation(PgDiffUtils.getQuotedName(res.getString("dom_collationnspname"))
                    + '.' + PgDiffUtils.getQuotedName(res.getString("dom_collationname")));
        }

        PgDatabase dataBase = (PgDatabase)schema.getParent();

        String def = res.getString("dom_defaultbin");
        if (def == null) {
            def = res.getString("typdefault");
            if (def != null) {
                def = PgDiffUtils.quoteString(def);
            }
        } else {
            loader.submitAntlrTask(def, dataBase,
                    p -> p.vex_eof().vex().get(0),
                    (ctx, db) -> {
                        db.getContextsForAnalyze().add(new AbstractMap.SimpleEntry<>(d, ctx));

                        UtilExpr.analyze(new Vex(ctx), new ValueExpr(schemaName), d);
                    });
        }
        d.setDefaultValue(def);

        d.setNotNull(res.getBoolean("dom_notnull"));

        String[] connames = res.getArray("dom_connames", String.class);
        if (connames != null) {
            String[] condefs = res.getArray("dom_condefs", String.class);
            String[] concomments = res.getArray("dom_concomments", String.class);

            for (int i = 0; i < connames.length; ++i) {
                PgConstraint c = new PgConstraint(connames[i], "");
                loader.submitAntlrTask(ConstraintsReader.ADD_CONSTRAINT + condefs[i] + ';', dataBase,
                        p -> {
                            Table_actionContext tableActionCtx = p.sql().statement(0).schema_statement().schema_alter()
                                    .alter_table_statement().table_action(0);
                            Constr_bodyContext body = tableActionCtx.tabl_constraint.constr_body();

                            c.setDefinition(ParserAbstract.getFullCtxText(body));
                            c.setNotValid(tableActionCtx.not_valid != null);

                            return body;
                        }, (ctx, db) -> {
                            db.getContextsForAnalyze().add(new AbstractMap.SimpleEntry<>(c, ctx));

                            ParserAbstract.parseConstraintExpr(ctx, schemaName, c);
                        });

                d.addConstraint(c);
                if (concomments[i] != null && !concomments[i].isEmpty()) {
                    c.setComment(loader.args, PgDiffUtils.quoteString(concomments[i]));
                }
            }
        }

        return d;
    }

    private PgType getType(ResultSetWrapper res, String schemaName, String typtype) throws WrapperAccessException {
        String name = res.getString("typname");
        loader.setCurrentObject(new GenericColumn(schemaName, name, DbObjType.TYPE));
        PgType t;
        switch (typtype) {
        case "b":
            t = new PgType(name, PgTypeForm.BASE, "");

            t.setInputFunction(res.getString("typinput"));
            t.setOutputFunction(res.getString("typoutput"));
            if (res.getBoolean("typreceiveset")) {
                t.setReceiveFunction(res.getString("typreceive"));
            }
            if (res.getBoolean("typsendset")) {
                t.setSendFunction(res.getString("typsend"));
            }
            if (res.getBoolean("typmodinset")) {
                t.setTypmodInputFunction(res.getString("typmodin"));
            }
            if (res.getBoolean("typmodoutset")) {
                t.setTypmodOutputFunction(res.getString("typmodout"));
            }
            if (res.getBoolean("typanalyzeset")) {
                t.setAnalyzeFunction(res.getString("typanalyze"));
            }

            short len = res.getShort("typlen");
            t.setInternalLength(len == -1 ? "variable" : "" + len);
            t.setPassedByValue(res.getBoolean("typbyval"));

            String align = res.getString("typalign");
            switch (align) {
            case "c":
                align = "char";
                break;
            case "s":
                align = "int2";
                break;
            case "i":
                align = "int4";
                break;
            case "d":
                align = "double";
                break;
            }
            t.setAlignment(align);

            String storage = res.getString("typstorage");
            switch (storage) {
            case "p":
                storage = "plain";
                break;
            case "e":
                storage = "external";
                break;
            case "x":
                storage = "extended";
                break;
            case "m":
                storage = "main";
                break;
            }
            t.setStorage(storage);

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
                t.setElement(typeElem.getFullName(schemaName));
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
            break;

        case "c":
            t = new PgType(name, PgTypeForm.COMPOSITE, "");

            String[] attnames = res.getArray("comp_attnames", String.class);
            if (attnames == null) {
                break;
            }
            String[] atttypes = res.getArray("comp_atttypdefns", String.class);
            Long[] atttypeids = res.getArray("comp_atttypids", Long.class);
            Long[] attcollations = res.getArray("comp_attcollations", Long.class);
            Long[] atttypcollations = res.getArray("comp_atttypcollations", Long.class);
            String[] attcollationnames = res.getArray("comp_attcollationnames", String.class);
            String[] attcollationnspnames = res.getArray("comp_attcollationnspnames", String.class);
            String[] attcomments = res.getArray("comp_attcomments", String.class);

            for (int i = 0; i < attnames.length; ++i) {
                PgColumn a = new PgColumn(attnames[i]);
                a.setType(atttypes[i]);
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
            break;

        case "e":
            t = new PgType(name, PgTypeForm.ENUM, "");

            String[] enums = res.getArray("enums", String.class);
            if (enums == null) {
                break;
            }
            for (String enum_ : enums) {
                t.addEnum(PgDiffUtils.quoteString(enum_));
            }
            break;

        case "r":
            t = new PgType(name, PgTypeForm.RANGE, "");

            JdbcType subtype = loader.cachedTypesByOid.get(res.getLong("rngsubtype"));
            t.setSubtype(subtype.getFullName(schemaName));
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
                t.setCanonical(res.getString("rngcanonical"));
            }
            if (res.getBoolean("rngsubdiffset")) {
                t.setCanonical(res.getString("rngsubdiff"));
            }
            break;
        default:
            t = null;
        }
        return t;
    }
}
