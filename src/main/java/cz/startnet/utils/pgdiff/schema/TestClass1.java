package cz.startnet.utils.pgdiff.schema;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.loader.ParserClass;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgFunction.Argument;
import cz.startnet.utils.pgdiff.schema.PgType.PgTypeForm;

public class TestClass1 {

    public static void main(String[] wat) throws InterruptedException  {
        PgDatabase dbPredef = fillDB();
        PgDatabase dbDump = PgDumpLoader.loadDatabaseSchemaFromDump(TestClass1.class.getResourceAsStream("test.sql"), new PgDiffArguments(), ParserClass.getAntlr(null, 1));
        System.out.println(CompareStatements.getDifferences(dbPredef, dbDump));
    }
    
    private static PgDatabase fillDB() {
        PgDatabase db = new PgDatabase();
        db.setComment("'Test DB'");
        PgExtension ex1 = new PgExtension("dblink", "CREATE EXTENSION dblink SCHEMA dblink");
        ex1.setSchema("dblink");
        db.addExtension(ex1);
        // schema
        PgSchema scm = new PgSchema("dblink", "Create schema dblink;");
        scm.setComment("'This is test schema'");
        scm.setOwner("botov_av");
        db.addSchema(scm);
        scm = db.getSchema(ApgdiffConsts.PUBLIC);
        
        PgPrivilege priv = new PgPrivilege(true, "ALL ON SCHEMA public FROM PUBLIC", "REVOKE ALL ON SCHEMA public FROM PUBLIC");
        scm.addPrivilege(priv);
        priv = new PgPrivilege(true, "ALL ON SCHEMA public FROM postgres", "REVOKE ALL ON SCHEMA public FROM postgres");
        scm.addPrivilege(priv);
        priv = new PgPrivilege(false, "ALL ON SCHEMA public TO postgres", "GRANT ALL ON SCHEMA public TO postgres");
        scm.addPrivilege(priv);
        priv = new PgPrivilege(false, "ALL ON SCHEMA public TO PUBLIC", "GRANT ALL ON SCHEMA public TO PUBLIC");
        scm.addPrivilege(priv);
        // domain
        PgDomain dom = new PgDomain("dom1", "create domain dom1 as text collate pg_catalog.\"ru_RU.utf8\" default 'as' constraint dom1_check not null check (value <> ''::text);");
        dom.setCollation("pg_catalog.\"ru_RU.utf8\"");
        dom.setComment("'This is test domain'");
        dom.setDataType("text");
        dom.setDefaultValue("'as'::text");
        dom.setNotNull(true);
        PgConstraint constr = new PgConstraint("dom1_check", "");
        constr.setDefinition("CHECK ((VALUE <> ''::text))");
        dom.addConstraint(constr);
        dom.setOwner("botov_av");
        scm.addDomain(dom);
        // function
        PgFunction func = new PgFunction("increment", "CREATE OR REPLACE FUNCTION increment(IN i integer = 0, j integer default 0) RETURNS integer AS $$ BEGIN RETURN i + 1; END; $$ LANGUAGE plpgsql;");
        func.setComment("'this is test function'");
        func.setBody("LANGUAGE plpgsql\n    AS $$ BEGIN RETURN i + 1; END; $$");
        func.setReturns("integer");
        func.setOwner("botov_av");
        PgFunction.Argument arg = new Argument();
        arg.setName("i");
        arg.setDataType("integer");
        arg.setDefaultExpression("0");
        arg.setMode("IN");
        func.addArgument(arg);
        arg = new Argument();
        arg.setName("j");
        arg.setDataType("integer");
        arg.setDefaultExpression("0");
        func.addArgument(arg);
        scm.addFunction(func);
        // table 
        PgTable tbl = new PgTable("t1", "create table t1 (c1 integer, c2 text collate pg_catalog.\"ru_RU.utf8\" constraint t1_c2_check not null check (c2 <> ''::text) default 'as', "
                + "c3 integer CONSTRAINT c3_const CHECK ((c3 > 0)))  WITHOUT OIDS");
        tbl.setComment("'This is test table'");
        PgColumn col = new PgColumn("c1");
        col.setType("integer");
        tbl.addColumn(col);
        col = new PgColumn("c2");
        col.setType("text COLLATE pg_catalog.\"ru_RU.utf8\"");
        col.setDefaultValue("as");
        col.setNullValue(false);
        col.setDefaultValue("'as'::text");
        tbl.addColumn(col);
        col = new PgColumn("c3");
        col.setType("integer");
        tbl.addColumn(col);
        constr = new PgConstraint("c3_const", "CONSTRAINT c3_const CHECK ((c3 > 0))");
        constr.setTableName("t1");
        constr.setDefinition("CHECK ((c3 > 0))");
        tbl.addConstraint(constr);
        constr = new PgConstraint("t1_c2_check", "constraint t1_c2_check not null check (c2 <> ''::text)");
        constr.setTableName("t1");
        constr.setDefinition("CHECK ((c2 <> ''::text))");
        tbl.addConstraint(constr);
        tbl.setOwner("botov_av");
        scm.addTable(tbl);
        // Sequence
        PgSequence seq = new PgSequence("seq1", "Create sequence seq1 increment by 1 minvalue 0 no maxvalue start with 0 cache 1 no cycle owned by t1.c1;");
        seq.setComment("'this is test sequence'");
        seq.setCache("1");
        seq.setIncrement("1");
        seq.setMinValue("0");
        seq.setStartWith("0");
        seq.setCycle(false);
        seq.setOwnedBy("t1.c1");
        seq.setOwner("botov_av");
        scm.addSequence(seq);
        // trig funct 
        func = new PgFunction("trfunc", "CREATE OR REPLACE FUNCTION trFunc() RETURNS trigger AS $$BEGIN RETURN 1; END; $$ LANGUAGE plpgsql;");
        func.setBody("LANGUAGE plpgsql\n    AS $$BEGIN RETURN 1; END; $$");
        func.setOwner("botov_av");
        func.setReturns("trigger");
        scm.addFunction(func);
        //trigger
        PgTrigger trig = new PgTrigger("trig1", "CREATE TRIGGER trig1 BEFORE UPDATE ON t1 FOR EACH ROW WHEN ((old.c1 IS DISTINCT FROM new.c1)) EXECUTE PROCEDURE trfunc()");
        trig.setComment("'this is test trigger'");
        trig.setForEachRow(true);
        trig.setBefore(true);
        trig.setOnUpdate(true);
        trig.setTableName("t1");
        trig.setWhen("((old.c1 IS DISTINCT FROM new.c1))");
        trig.setFunction("trfunc()", "trfunc()");
        tbl.addTrigger(trig);
        //index
        PgIndex ind = new PgIndex("ind1", "create index ind1 on t1 USING btree(c2 COLLATE pg_catalog.\"default\")");
        ind.setComment("'this is test index'");
        ind.setTableName("t1");
        ind.setDefinition("USING btree (c2 COLLATE \"default\")");
        tbl.addIndex(ind);
        // view
        PgView v1 = new PgView("v1", "create view v1 as select c1 from t1;");
        v1.setComment("'this is test view'");
        v1.setQuery("SELECT t1.c1 AS i\n   FROM t1");
        PgSelect sel = new PgSelect("SELECT t1.c1 AS i\n   FROM t1");
        sel.addColumn(new GenericColumn("public", "t1", "c1"));
        v1.setSelect(sel);
        v1.setOwner("botov_av");
        scm.addView(v1);
        // type composite
        PgType typ1 = new PgType("typ_composite", PgTypeForm.COMPOSITE, "CREATE TYPE typ_composite AS (\nkey character varying(80) COLLATE pg_catalog.\"ru_RU.utf8\",\nval text COLLATE pg_catalog.\"en_GB\"\n);");
        typ1.setComment("'this is test composite type'");
        col = new PgColumn("key");
        col.setType("character varying(80) COLLATE pg_catalog.\"ru_RU.utf8\"");
        typ1.addAttr(col);
        col = new PgColumn("val");
        col.setType("text COLLATE pg_catalog.\"en_GB\"");
        typ1.addAttr(col);
        typ1.setOwner("botov_av");
        scm.addType(typ1);
        // type enum
        typ1 = new PgType("typ_enum", PgTypeForm.ENUM, "CREATE TYPE typ_enum AS ENUM (\n'wat',\n'wut',\n'weed'\n);");
        typ1.addEnum("'wat'");
        typ1.addEnum("'wut'");
        typ1.addEnum("'weed'");
        typ1.setOwner("botov_av");
        scm.addType(typ1);
        // type range
        typ1 = new PgType("typ_range", PgTypeForm.RANGE, "CREATE TYPE typ_range AS RANGE (\n\tsubtype = character varying,\n\tcollation = pg_catalog.\"ru_RU.utf8\"\n)");
        typ1.setSubtype("character varying");
        typ1.setCollation("pg_catalog.\"ru_RU.utf8\"");
        typ1.setOwner("botov_av");
        scm.addType(typ1);
        return db;
    }
}
