/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.loader;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cz.startnet.utils.pgdiff.schema.*;

/**
 * An abstract 'factory' that creates 'artificial'
 * PgDatabase objects for specific test-cases.
 *  
 * @author Alexander Levsha 
*/
abstract class PgDatabaseObjectCreator {
	
	/**
	 * The method makes up a PgDatabase object specific to the test needs.
	 * 
	 * @return PgDatabase
	 */
	abstract public PgDatabase getDatabase();
}

/**
 * Tests for PgDiffLoader class.
 *
 * @author fordfrog
 */
@RunWith(value = Parameterized.class)
public class PgDumpLoaderTest {

    /**
     * Provides parameters for running the tests.
     *
     * @return parameters for the tests
     */
    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(
                new Object[][]{
                    {1},
                    {2},
                    {3},
                    {4},
                    {5},
                    {6},
                    {7},
                    {8},
                    {9},
                    {10},
                    {11},
                    {12},
                    {13},
                    {14},
                    {15}
                });
    }
    /**
     * Index of the file that should be tested.
     */
    private final int fileIndex;
    
    /**
     * Array of implementations of {@link PgDatabaseObjectCreator}
     * each returning a specific {@link PgDatabase} for a test-case.
     */
    private final PgDatabaseObjectCreator[] dbCreators = {
    	new PgDB1(),
    	new PgDB2(),
    	new PgDB3(), 
    	new PgDB4(),
    	new PgDB5(),
    	new PgDB6(),
    	new PgDB7(),
    	new PgDB8(),
    	new PgDB9(),
    	new PgDB10(),
    	new PgDB11(),
    	new PgDB12(),
    	new PgDB13(),
    	new PgDB14(),
    	new PgDB15()
    };

    /**
     * Creates a new instance of PgDumpLoaderTest.
     *
     * @param fileIndex {@link #fileIndex}
     */
    public PgDumpLoaderTest(final int fileIndex) {
        this.fileIndex = fileIndex;
    }

    /**
     * Runs single test.
     */
    @Test(timeout = 1000)
    public void loadSchema() {
    	String filename = "schema_" + fileIndex + ".sql";
        PgDatabase d = PgDumpLoader.loadDatabaseSchema(
                getClass().getResourceAsStream(filename),
                "UTF-8", false, false);
        
        if(fileIndex > dbCreators.length) {        
        	Assert.fail("No predefined object for file:"
        			+ filename);
        }
        Assert.assertEquals(dbCreators[fileIndex - 1].getDatabase(), d);
    }
}

class PgDB1 extends PgDatabaseObjectCreator {
    @Override
    public PgDatabase getDatabase() {
    	PgDatabase d = new PgDatabase();
    	PgSchema schema = d.getDefaultSchema();
    	
    	PgTable table = new PgTable("fax_boxes", "", "");
    	schema.addTable(table);
    	
    	PgColumn col = new PgColumn("fax_box_id");
    	col.setType("serial");
    	col.setNullValue(false);
    	table.addColumn(col);
    	
    	col = new PgColumn("name");
    	col.setType("text");
    	table.addColumn(col);
    	
    	PgConstraint constraint = new PgConstraint("fax_boxes_pkey", "", "");
    	table.addConstraint(constraint);
    //	schema.addPrimaryKey(constraint);
    	constraint.setTableName("fax_boxes");
    	constraint.setDefinition("PRIMARY KEY (fax_box_id)");
    	    	
    	table = new PgTable("extensions", "", "");
    	schema.addTable(table);
    	
    	col = new PgColumn("id");
    	col.setType("serial");
    	col.setNullValue(false);
    	table.addColumn(col);
    	
    	constraint = new PgConstraint("extensions_fax_box_id_fkey", "", "");
    	constraint.setDefinition("REFERENCES fax_boxes\n(fax_box_id)    ON UPDATE RESTRICT ON DELETE RESTRICT");
    	constraint.setTableName("extensions");
    	table.addConstraint(constraint);
    	
    	table = new PgTable("faxes", "", "");
    	schema.addTable(table);
    	
    	col = new PgColumn("fax_id");
    	col.setType("serial");
    	col.setNullValue(false);
    	table.addColumn(col);
    	
    	col = new PgColumn("fax_box_id");
    	col.setType("int4");
    	table.addColumn(col);
    	
    	col = new PgColumn("from_name");
    	col.setType("text");
    	table.addColumn(col);
    	
    	col = new PgColumn("from_number");
    	col.setType("text");
    	table.addColumn(col);
    	
    	col = new PgColumn("status");
    	col.setType("int4");
    	table.addColumn(col);
    	
    	col = new PgColumn("pages");
    	col.setType("int4");
    	table.addColumn(col);
    	
    	col = new PgColumn("time_received");
    	col.setType("timestamp");
    	col.setDefaultValue("now()");
    	table.addColumn(col);
    	
    	col = new PgColumn("time_finished_received");
    	col.setType("timestamp");
    	table.addColumn(col);
    	
    	col = new PgColumn("read");
    	col.setType("int2");
    	col.setDefaultValue("0");
    	table.addColumn(col);
    	
    	col = new PgColumn("station_id");
    	col.setType("text");
    	table.addColumn(col);
    	
    	constraint = new PgConstraint("faxes_pkey", "", "");
    	constraint.setTableName("faxes");
    	constraint.setDefinition("PRIMARY KEY (fax_id)");
    	table.addConstraint(constraint);
   // 	schema.addPrimaryKey(constraint);
    	
    	constraint = new PgConstraint("faxes_fax_box_id_fkey", "", "");
    	constraint.setTableName("faxes");
    	constraint.setDefinition("FOREIGN KEY (fax_box_id)\n      REFERENCES fax_boxes (fax_box_id) MATCH SIMPLE\n      ON UPDATE RESTRICT ON DELETE CASCADE");
    	table.addConstraint(constraint);
    	
    	return d;
    }
}

class PgDB2 extends PgDatabaseObjectCreator {
	@Override
    public PgDatabase getDatabase() {
		PgDatabase d = new PgDatabase();
    	PgSchema schema = d.getDefaultSchema();
    	
    	PgTable table = new PgTable("contacts", "", "");
    	schema.addTable(table);
    	
    	PgColumn col = new PgColumn("id");
    	col.setType("int PRIMARY KEY");
    	table.addColumn(col);
    	
    	col = new PgColumn("number_pool_id");
    	col.setType("int");
    	table.addColumn(col);
    	
    	col = new PgColumn("name");
    	col.setType("varchar(50)");
    	table.addColumn(col);
    	
    	PgIndex idx = new PgIndex("contacts_number_pool_id_idx", "", "");
    	table.addIndex(idx);
    	schema.addIndex(idx);
    	idx.setTableName("contacts");
    	idx.setDefinition("(number_pool_id)");    	
    	
    	return d;
    }
}

class PgDB3 extends PgDatabaseObjectCreator {
	@Override
	public PgDatabase getDatabase() {
		PgDatabase d = new PgDatabase();
		PgSchema schema = d.getDefaultSchema();
		
		PgSequence seq = new PgSequence("admins_aid_seq", "", "");
		seq.setStartWith("1");
		seq.setIncrement("1");
		seq.setMaxValue("1000000000");
		seq.setMinValue("1");
		seq.setCache("1");
		schema.addSequence(seq);
		
		PgTable table = new PgTable("admins", "", "");
		schema.addTable(table);
		
		PgColumn col = new PgColumn("aid");
		col.setType("integer");
		col.setDefaultValue("nextval('\"admins_aid_seq\"'::text)");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("companyid");
		col.setType("integer");
		col.setDefaultValue("0");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("groupid");
		col.setType("integer");
		col.setDefaultValue("0");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("username");
		col.setType("character varying");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("password");
		col.setType("character varying(40)");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("superuser");
		col.setType("boolean");
		col.setDefaultValue("'f'::bool");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("name");
		col.setType("character varying(40)");
		table.addColumn(col);
		
		col = new PgColumn("surname");
		col.setType("character varying(40)");
		table.addColumn(col);
		
		col = new PgColumn("email");
		col.setType("character varying(100)");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("tel");
		col.setType("character varying(40)");
		table.addColumn(col);
		
		col = new PgColumn("mobile");
		col.setType("character varying(40)");
		table.addColumn(col);
		
		col = new PgColumn("enabled");
		col.setType("boolean");
		col.setDefaultValue("'t'::bool");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("lastlogints");
		col.setType("timestamp with time zone");
		col.setDefaultValue("now()");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("expirienced");
		col.setType("boolean");
		col.setDefaultValue("'f'::bool");
		table.addColumn(col);
		
		PgConstraint constraint = new PgConstraint("admins_pkey", "", "");
		constraint.setTableName("admins");
		constraint.setDefinition("Primary Key (\"aid\")");
		table.addConstraint(constraint);
				
		return d;
	}
}

class PgDB4 extends PgDatabaseObjectCreator {
	@Override
	public PgDatabase getDatabase() {
		PgDatabase d = new PgDatabase();
		PgSchema schema = d.getDefaultSchema();
		
		PgTable table = new PgTable("call_logs", "", "");
		schema.addTable(table);
		
		PgColumn col = new PgColumn("id");
		col.setType("bigint");
		col.setNullValue(false);
		col.setDefaultValue("nextval('call_logs_id_seq'::regclass)");
		table.addColumn(col);
		
		return d;
	}
}

class PgDB5 extends	 PgDatabaseObjectCreator {
	@Override
	public PgDatabase getDatabase() {
		PgDatabase d = new PgDatabase();
		PgSchema schema = d.getDefaultSchema();
		
		PgFunction func = new PgFunction("", "");
		func.setName("gtsq_in");
		func.setBody("RETURNS gtsq\n    AS '$libdir/tsearch2', 'gtsq_in'\n    LANGUAGE c STRICT");
		schema.addFunction(func);
		
		PgFunction.Argument arg = new PgFunction.Argument();
		arg.setDataType("cstring");
		func.addArgument(arg);
		
		func = new PgFunction("", "");
		func.setName("multiply_numbers");;
		func.setBody("RETURNS integer\n    AS $$\nbegin\n	return number1 * number2;\nend;\n$$\n    LANGUAGE plpgsql STRICT");
		schema.addFunction(func);
		
		arg = new PgFunction.Argument();
		arg.setName("number1");
		arg.setDataType("integer");
		func.addArgument(arg);
		
		arg = new PgFunction.Argument();
		arg.setName("number2");
		arg.setDataType("integer");
		func.addArgument(arg);
		
		func = new PgFunction("", "");
		func.setName("select_something");
		func.setBody("RETURNS integer\n    AS $_$SELECT number1 * number2$_$ LANGUAGE plpgsql");
		schema.addFunction(func);
		
		arg = new PgFunction.Argument();
		arg.setName("number1");
		arg.setDataType("integer");
		func.addArgument(arg);
		
		arg = new PgFunction.Argument();
		arg.setName("number2");
		arg.setDataType("integer");
		func.addArgument(arg);
		
		func = new PgFunction("", "");
		func.setName("select_something2");
		func.setBody("RETURNS integer\n    AS 'SELECT number1 * number2 || \\'text\\'' LANGUAGE plpgsql");
		schema.addFunction(func);
		
		arg = new PgFunction.Argument();
		arg.setName("number1");
		arg.setDataType("integer");
		func.addArgument(arg);
		
		arg = new PgFunction.Argument();
		arg.setName("number2");
		arg.setDataType("integer");
		func.addArgument(arg);
		
		func = new PgFunction("", "");
		func.setName("select_something3");
		func.setBody("RETURNS integer\n    AS '\nSELECT number1 * number2 || \\'text\\'\n' LANGUAGE plpgsql");
		schema.addFunction(func);
		
		arg = new PgFunction.Argument();
		arg.setName("number1");
		arg.setDataType("integer");
		func.addArgument(arg);
		
		arg = new PgFunction.Argument();
		arg.setName("number2");
		arg.setDataType("integer");
		func.addArgument(arg);
		
		return d;
	}
}

class PgDB6 extends PgDatabaseObjectCreator {
	@Override
	public PgDatabase getDatabase() {
		PgDatabase d = new PgDatabase();
		PgSchema schema = d.getDefaultSchema();
		schema.setComment("'Standard public schema'");
		
		PgTable table = new PgTable("test_table", "", "");
		schema.addTable(table);
		
		PgColumn col = new PgColumn("id");
		col.setType("bigint");
		table.addColumn(col);
		
		col = new PgColumn("date_deleted");
		col.setType("timestamp without time zone");
		table.addColumn(col);
		
		PgIndex idx = new PgIndex("test_table_deleted", "", "");
		idx.setTableName("test_table");
		idx.setDefinition("USING btree (date_deleted) WHERE (date_deleted IS NULL)");
		table.addIndex(idx);
		schema.addIndex(idx);
		
		return d;
	}
}

class PgDB7 extends PgDatabaseObjectCreator {
	@Override
	public PgDatabase getDatabase() {
		PgDatabase d = new PgDatabase();
		
		PgSchema schema = new PgSchema("common", "");
		d.addSchema(schema);
		d.setDefaultSchema("common");
		
		PgFunction func = new PgFunction("", "");
		func.setName("t_common_casttotext");
		func.setBody("RETURNS text\n    AS $_$SELECT textin(timetz_out($1));$_$\n    LANGUAGE sql IMMUTABLE STRICT");
		schema.addFunction(func);
		
		PgFunction.Argument arg = new PgFunction.Argument();
		arg.setDataType("time with time zone");
		func.addArgument(arg);
		
		func = new PgFunction("", "");
		func.setName("t_common_casttotext");
		func.setBody("RETURNS text\n    AS $_$SELECT textin(time_out($1));$_$\n    LANGUAGE sql IMMUTABLE STRICT");
		schema.addFunction(func);
		
		arg = new PgFunction.Argument();
		arg.setDataType("time without time zone");
		func.addArgument(arg);
		
		func = new PgFunction("", "");
		func.setName("t_common_casttotext");
		func.setBody("RETURNS text\n    AS $_$SELECT textin(timestamptz_out($1));$_$\n    LANGUAGE sql IMMUTABLE STRICT");
		schema.addFunction(func);
		
		arg = new PgFunction.Argument();
		arg.setDataType("timestamp with time zone");
		func.addArgument(arg);
		
		func = new PgFunction("", "");
		func.setName("t_common_casttotext");
		func.setBody("RETURNS text\n    AS $_$SELECT textin(timestamp_out($1));$_$\n    LANGUAGE sql IMMUTABLE STRICT");
		schema.addFunction(func);
		
		arg = new PgFunction.Argument();
		arg.setDataType("timestamp without time zone");
		func.addArgument(arg);
		
		return d;
	}
}

class PgDB8 extends PgDatabaseObjectCreator {
	@Override
	public PgDatabase getDatabase() {
		PgDatabase d = new PgDatabase();
		PgSchema schema = d.getDefaultSchema();
		schema.setComment("'Standard public schema'");
		
		PgFunction func = new PgFunction("", "");
		func.setName(".x");
		func.setBody("RETURNS boolean\n    AS $_$\ndeclare\nbegin\nraise notice 'inside: %', $1;\nreturn true;\nend;\n$_$\n    LANGUAGE plpgsql");
		schema.addFunction(func);
		
		PgFunction.Argument arg = new PgFunction.Argument();
		arg.setDataType("integer");
		func.addArgument(arg);
		
		return d;
	}
}

class PgDB9 extends PgDatabaseObjectCreator {
	@Override
	public PgDatabase getDatabase() {
		PgDatabase d = new PgDatabase();
		PgSchema schema = d.getDefaultSchema();
		
		PgTable table = new PgTable("user_data", "", "");
		schema.addTable(table);
		
		PgColumn col = new PgColumn("id");
		col.setType("bigint");
		col.setNullValue(false);
		col.setDefaultValue("nextval('user_id_seq'::regclass)");
		table.addColumn(col);
		
		col = new PgColumn("email");
		col.setType("character varying(128)");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("created");
		col.setType("timestamp with time zone");
		col.setDefaultValue("now()");
		table.addColumn(col);
		
		PgSequence seq = new PgSequence("user_id_seq", "", "");
		seq.setIncrement("1");
		seq.setCache("1");
		seq.setOwnedBy("user_data.id");
		schema.addSequence(seq);
		
		PgView view = new PgView("user", "", "");
		view.setQuery("SELECT user_data.id, user_data.email, user_data.created FROM user_data");
		view.addColumnDefaultValue("created", "now()");
		schema.addView(view);
		
		return d;
	}
}

class PgDB10 extends PgDatabaseObjectCreator {
	@Override
	public PgDatabase getDatabase() {
		PgDatabase d = new PgDatabase();
		PgSchema schema = new PgSchema("admin", "");
		d.addSchema(schema);
		d.setDefaultSchema("admin");
		
		PgTable table = new PgTable("acl_role", "", "");
		schema.addTable(table);
		
		PgColumn col = new PgColumn("id");
		col.setType("bigint");
		col.setNullValue(false);
		table.addColumn(col);
		
		PgConstraint constraint = new PgConstraint("acl_role_pkey", "", "");
		constraint.setTableName("acl_role");
		constraint.setDefinition("PRIMARY KEY (id)");
		table.addConstraint(constraint);
		schema.addPrimaryKey(constraint);
		
		table = new PgTable("user", "", "");
		schema.addTable(table);
		
		col = new PgColumn("id");
		col.setType("bigint");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("email");
		col.setType("character varying(255)");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("name");
		col.setType("character varying(255)");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("password");
		col.setType("character varying(40)");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("is_active");
		col.setType("boolean");
		col.setDefaultValue("false");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("updated");
		col.setType("timestamp without time zone");
		col.setDefaultValue("now()");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("created");
		col.setType("timestamp without time zone");
		col.setDefaultValue("now()");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("role_id");
		col.setType("bigint");
		col.setNullValue(false);
		table.addColumn(col);
		
		col = new PgColumn("last_visit");
		col.setType("timestamp without time zone");
		col.setDefaultValue("now()");
		col.setNullValue(false);
		table.addColumn(col);
		
		PgIndex idx = new PgIndex("fki_user_role_id_fkey", "", "");
		idx.setTableName("user");
		idx.setDefinition("USING btree (role_id)");
		table.addIndex(idx);
		schema.addIndex(idx);
		
		constraint = new PgConstraint("user_role_id_fkey", "", "");
		constraint.setTableName("user");
		constraint.setDefinition("FOREIGN KEY (role_id) REFERENCES acl_role(id)");
		table.addConstraint(constraint);
		
		return d;
	}
}

class PgDB11 extends PgDatabaseObjectCreator {
	@Override
	public PgDatabase getDatabase() {
		PgDatabase d = new PgDatabase();
		PgSchema schema = d.getDefaultSchema();
		
		PgFunction func = new PgFunction("", "");
		func.setName("curdate");
		func.setBody("RETURNS date\n    LANGUAGE sql\n    AS $$SELECT CAST('now' AS date);\n$$");
		schema.addFunction(func);
		
		return d;
	}
}

class PgDB12 extends PgDatabaseObjectCreator {
	@Override
	public PgDatabase getDatabase() {
		PgDatabase d = new PgDatabase();
		
		d.setComment("'The status : ''E'' for enabled, ''D'' for disabled.'");
		
		return d;
	}
}

class PgDB13 extends PgDatabaseObjectCreator {
	@Override
	public PgDatabase getDatabase() {
		PgDatabase d = new PgDatabase();
		PgSchema schema = d.getDefaultSchema();
		
		PgFunction func = new PgFunction("", "");
		func.setName("drop_fk_except_for");
		func.setBody("RETURNS SETOF character varying\n    LANGUAGE plpgsql\n    AS $$\nDECLARE\nBEGIN\n  -- aaa\nEND;\n$$");
		schema.addFunction(func);
		
		PgFunction.Argument arg = new PgFunction.Argument();
		arg.setDataType("character varying[]");
		arg.setName("tables_in");
		func.addArgument(arg);
		
		return d;
	}
}

class PgDB14 extends PgDatabaseObjectCreator {
	@Override
	public PgDatabase getDatabase() {
		PgDatabase d = new PgDatabase();
		PgSchema schema = d.getDefaultSchema();
		
		d.setComment("'comments database'");
		schema.setComment("'public schema'");
		
		PgFunction func = new PgFunction("", "");
		func.setName("test_fnc");
		func.setBody("RETURNS boolean\n    LANGUAGE plpgsql\n    AS $$BEGIN\nRETURN true;\nEND;$$");
		schema.addFunction(func);
		
		PgFunction.Argument arg = new PgFunction.Argument();
		arg.setDataType("character varying");
		arg.setName("arg");
		func.addArgument(arg);
		
		func.setComment("'test function'");
		
		func = new PgFunction("", "");
		func.setName("trigger_fnc");
		func.setBody("RETURNS trigger\n    LANGUAGE plpgsql\n    AS $$begin\nend;$$");
		schema.addFunction(func);
		
		PgTable table = new PgTable("test", "", "");
		schema.addTable(table);
		
		PgColumn col = new PgColumn("id");
		col.setType("integer");
		col.setNullValue(false);
		col.setComment("'id column'");
		col.setDefaultValue("nextval('test_id_seq'::regclass)");
		table.addColumn(col);
		
		col = new PgColumn("text");
		col.setType("character varying(20)");
		col.setNullValue(false);
		col.setComment("'text column'");
		table.addColumn(col);
		
		PgConstraint constraint = new PgConstraint("text_check", "", "");
		constraint.setTableName("test");
		constraint.setDefinition("CHECK ((length((text)::text) > 0))");
		constraint.setComment("'text check'");
		table.addConstraint(constraint);
		
		table.setComment("'test table'");
		
		constraint = new PgConstraint("test_pkey", "", "");
		constraint.setTableName("test");
		constraint.setDefinition("PRIMARY KEY (id)");
		table.addConstraint(constraint);
		schema.addPrimaryKey(constraint);
		
		constraint.setComment("'primary key'");
		
		PgSequence seq = new PgSequence("test_id_seq", "", "");
		seq.setStartWith("1");
		seq.setIncrement("1");
		seq.setCache("1");
		schema.addSequence(seq);
		
		seq.setOwnedBy("test.id");
		
		seq.setComment("'test table sequence'");
		
		PgView view = new PgView("test_view", "", "");
		view.setQuery("SELECT test.id, test.text FROM test");
		schema.addView(view);
		
		view.setComment("'test view'");
		view.addColumnComment("id", "'view id col'");
		
		PgTrigger trigger = new PgTrigger("", "");
		trigger.setName("test_trigger");
		trigger.setBefore(true);
		trigger.setOnUpdate(true);
		trigger.setTableName("test");
		trigger.setForEachRow(false);
		trigger.setFunction("trigger_fnc()");
		table.addTrigger(trigger);
		
		trigger.setComment("'test trigger'");
		
		return d;
	}
}

class PgDB15 extends PgDatabaseObjectCreator {
	@Override
	public PgDatabase getDatabase() {
		PgDatabase d = new PgDatabase();
		PgSchema schema = d.getDefaultSchema();
		
		PgTable table = new PgTable("test", "", "");
		schema.addTable(table);
		
		PgColumn col = new PgColumn("id");
		col.setType("bigint");
		table.addColumn(col);
		
		table.setComment("'multiline\ncomment\n'");
		
		return d;
	}
}
