/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgSchema;

import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Creates diff of two database schemas.
 *
 * @author fordfrog
 */
public class PgDiff {

    /**
     * Creates diff on the two database schemas.
     *
     * @param writer    writer the output should be written to
     * @param arguments object containing arguments settings
     */
    public static void createDiff(final PrintWriter writer,
            final PgDiffArguments arguments) {
        diffDatabaseSchemas(writer, arguments,
        		loadDatabaseSchema(arguments.getOldSrcFormat(), arguments.getOldSrc(), arguments),
        		loadDatabaseSchema(arguments.getNewSrcFormat(), arguments.getNewSrc(), arguments));
    }
    
    /**
     * Loads database schema choosing the provided method.
     * 
     * @param format		format of the database source, must be "dump", "parsed" or "db"
     * 						otherwise exception is thrown
     * @param srcPath		path to the database source to load
     * @param arguments		object containing arguments settings
     * 
     * @return the loaded database
     */
    static PgDatabase loadDatabaseSchema(final String format, final String srcPath,
    			final PgDiffArguments arguments) {
    	if(format.equals("dump")) {
    		return PgDumpLoader.loadDatabaseSchemaFromDump(srcPath,
    				arguments.getInCharsetName(), arguments.isOutputIgnoredStatements(),
    				arguments.isIgnoreSlonyTriggers());
    	} else if(format.equals("parsed")) {
    		return PgDumpLoader.loadDatabaseSchemaFromDirTree(srcPath,
    				arguments.getInCharsetName(), arguments.isOutputIgnoredStatements(),
    				arguments.isIgnoreSlonyTriggers());
    	} else if(format.equals("db")) {
    		throw new UnsupportedOperationException("DB connection is not yet implemented!");
    	}
    	
    	throw new UnsupportedOperationException("Unknown DB format!");
    }

    /**
     * Creates diff on the two database schemas.
     *
     * @param writer         writer the output should be written to
     * @param arguments      object containing arguments settings
     * @param oldInputStream input stream of file containing dump of the
     *                       original schema
     * @param newInputStream input stream of file containing dump of the new
     *                       schema
     */
    public static void createDiff(final PrintWriter writer,
            final PgDiffArguments arguments, final InputStream oldInputStream,
            final InputStream newInputStream) {
        final PgDatabase oldDatabase = PgDumpLoader.loadDatabaseSchemaFromDump(
                oldInputStream, arguments.getInCharsetName(),
                arguments.isOutputIgnoredStatements(),
                arguments.isIgnoreSlonyTriggers());
        final PgDatabase newDatabase = PgDumpLoader.loadDatabaseSchemaFromDump(
                newInputStream, arguments.getInCharsetName(),
                arguments.isOutputIgnoredStatements(),
                arguments.isIgnoreSlonyTriggers());

        diffDatabaseSchemas(writer, arguments, oldDatabase, newDatabase);
    }
    
    /**
     * Creates diff from comparison of two database schemas.<br><br>
     * Following PgDiffArguments methods are called from this method:<br>
     * isAddTransaction()<br>
     * isOutputIgnoredStatements()<br>
     * isIgnoreStartWith()<br>
     * isAddDefaults()<br>
     * isIgnoreFunctionWhitespace()<br>
     *
     * @param writer      writer the output should be written to
     * @param arguments   object containing arguments settings
     * @param oldDatabase original database schema
     * @param newDatabase new database schema
     */
    public static void diffDatabaseSchemas(final PrintWriter writer,
            final PgDiffArguments arguments, final PgDatabase oldDatabase,
            final PgDatabase newDatabase) {
        if (arguments.isAddTransaction()) {
            writer.println("START TRANSACTION;");
        }

        if (oldDatabase.getComment() == null
                && newDatabase.getComment() != null
                || oldDatabase.getComment() != null
                && newDatabase.getComment() != null
                && !oldDatabase.getComment().equals(newDatabase.getComment())) {
            writer.println();
            writer.print("COMMENT ON DATABASE current_database() IS ");
            writer.print(newDatabase.getComment());
            writer.println(';');
        } else if (oldDatabase.getComment() != null
                && newDatabase.getComment() == null) {
            writer.println();
            writer.println("COMMENT ON DATABASE current_database() IS NULL;");
        }

        dropOldSchemas(writer, oldDatabase, newDatabase);
        createNewSchemas(writer, oldDatabase, newDatabase);
        
        dropOldExtensions(writer, oldDatabase, newDatabase);
        createNewExtensions(writer, oldDatabase, newDatabase);
        updateExtensions(writer, oldDatabase, newDatabase);
        
        updateSchemas(writer, arguments, oldDatabase, newDatabase);

        if (arguments.isAddTransaction()) {
            writer.println();
            writer.println("COMMIT TRANSACTION;");
        }

        if (arguments.isOutputIgnoredStatements()) {
            if (!oldDatabase.getIgnoredStatements().isEmpty()) {
                writer.println();
                writer.print("/* ");
                writer.println(Resources.getString(
                        "OriginalDatabaseIgnoredStatements"));

                for (final String statement :
                        oldDatabase.getIgnoredStatements()) {
                    writer.println();
                    writer.println(statement);
                }

                writer.println("*/");
            }

            if (!newDatabase.getIgnoredStatements().isEmpty()) {
                writer.println();
                writer.print("/* ");
                writer.println(
                        Resources.getString("NewDatabaseIgnoredStatements"));

                for (final String statement :
                        newDatabase.getIgnoredStatements()) {
                    writer.println();
                    writer.println(statement);
                }

                writer.println("*/");
            }
        }
    }

    /**
     * Creates new extensions.
     * 
     * @param writer      writer the output should be written to
     * @param oldDatabase original database schema
     * @param newDatabase new database schema
     */
    
    private static void createNewExtensions(final PrintWriter writer, 
    		final PgDatabase oldDatabase, final PgDatabase newDatabase) {
    	for(final PgExtension newExt : newDatabase.getExtensions()) {
    		if(oldDatabase.getExtension(newExt.getName()) == null) {
    			writer.println();
    			writer.println(newExt.getCreationSQL());
    		}
    	}
    }
    
    /**
     * Drops old extensions that do not exist anymore.
     *
     * @param writer      writer the output should be written to
     * @param oldDatabase original database schema
     * @param newDatabase new database schema
     */
    private static void dropOldExtensions(final PrintWriter writer, 
    		final PgDatabase oldDatabase, final PgDatabase newDatabase) {
    	for(final PgExtension oldExt : oldDatabase.getExtensions()) {
    		if(newDatabase.getExtension(oldExt.getName()) == null) {
    			writer.println();
    			writer.println("DROP EXTENSION "
    					+ PgDiffUtils.getQuotedName(oldExt.getName())
    					+ ";");
    		}
    	}
    }
    
    /**
     * Updates changed extensions.
     *
     * @param writer      writer the output should be written to
     * @param oldDatabase original database schema
     * @param newDatabase new database schema
     */
    private static void updateExtensions(final PrintWriter writer,
            final PgDatabase oldDatabase, final PgDatabase newDatabase) {
    	for(final PgExtension newExt : newDatabase.getExtensions()) {
    		final PgExtension oldExt = oldDatabase.getExtension(
    				newExt.getName());
    		if(oldExt == null) {
    			continue;
    		}
    		/*
    		// TODO do this with DROP/CREATE? as an option?
    		if(newExt.getVersion() != null 
    				&& !newExt.getVersion().equals(
    						oldExt.getVersion())) {
    			writer.println();
    			writer.println("ALTER EXTENSION "
    					+ PgDiffUtils.getQuotedName(oldExt.getName())
    					+ " UPDATE TO " + newExt.getVersion() + ";");
    		}
    		*/
    		if(newExt.getSchema() != null
    				&& !newExt.getSchema().equals(
    						oldExt.getSchema())) {
    			writer.println();
    			writer.println("ALTER EXTENSION "
    					+ PgDiffUtils.getQuotedName(oldExt.getName())
    					+ " SET SCHEMA " + newExt.getSchema() + ";");
    		}
    	}
    }
    
    /**
     * Creates new schemas (not the objects inside the schemas).
     *
     * @param writer      writer the output should be written to
     * @param oldDatabase original database schema
     * @param newDatabase new database schema
     */
    private static void createNewSchemas(final PrintWriter writer,
            final PgDatabase oldDatabase, final PgDatabase newDatabase) {
        for (final PgSchema newSchema : newDatabase.getSchemas()) {
            if (oldDatabase.getSchema(newSchema.getName()) == null) {
                writer.println();
                writer.println(newSchema.getCreationSQL());
            }
        }
    }

    /**
     * Drops old schemas that do not exist anymore.
     *
     * @param writer      writer the output should be written to
     * @param oldDatabase original database schema
     * @param newDatabase new database schema
     */
    private static void dropOldSchemas(final PrintWriter writer,
            final PgDatabase oldDatabase, final PgDatabase newDatabase) {
        for (final PgSchema oldSchema : oldDatabase.getSchemas()) {
            if (newDatabase.getSchema(oldSchema.getName()) == null) {
                writer.println();
                writer.println("DROP SCHEMA "
                        + PgDiffUtils.getQuotedName(oldSchema.getName())
                        + " CASCADE;");
            }
        }
    }

    /**
     * Updates objects in schemas.
     *
     * @param writer      writer the output should be written to
     * @param arguments   object containing arguments settings
     * @param oldDatabase original database schema
     * @param newDatabase new database schema
     */
    private static void updateSchemas(final PrintWriter writer,
            final PgDiffArguments arguments, final PgDatabase oldDatabase,
            final PgDatabase newDatabase) {
        final boolean setSearchPath = newDatabase.getSchemas().size() > 1
                || !newDatabase.getSchemas().get(0).getName().equals("public");

        for (final PgSchema newSchema : newDatabase.getSchemas()) {
            final SearchPathHelper searchPathHelper;

            if (setSearchPath) {
                searchPathHelper = new SearchPathHelper("SET search_path = "
                        + PgDiffUtils.getQuotedName(newSchema.getName(), true)
                        + ", pg_catalog;");
            } else {
                searchPathHelper = new SearchPathHelper(null);
            }
            // TODO is this search_path setting sufficient ?

            final PgSchema oldSchema =
                    oldDatabase.getSchema(newSchema.getName());

            if (oldSchema != null) {
                if (oldSchema.getComment() == null
                        && newSchema.getComment() != null
                        || oldSchema.getComment() != null
                        && newSchema.getComment() != null
                        && !oldSchema.getComment().equals(
                        		newSchema.getComment())) {
                    writer.println();
                    writer.print("COMMENT ON SCHEMA ");
                    writer.print(
                            PgDiffUtils.getQuotedName(newSchema.getName()));
                    writer.print(" IS ");
                    writer.print(newSchema.getComment());
                    writer.println(';');
                } else if (oldSchema.getComment() != null
                        && newSchema.getComment() == null) {
                    writer.println();
                    writer.print("COMMENT ON SCHEMA ");
                    writer.print(
                            PgDiffUtils.getQuotedName(newSchema.getName()));
                    writer.println(" IS NULL;");
                }
            }

            PgDiffTriggers.dropTriggers(
                    writer, oldSchema, newSchema, searchPathHelper);
            PgDiffFunctions.dropFunctions(
                    writer, oldSchema, newSchema, searchPathHelper);
            PgDiffViews.dropViews(
                    writer, oldSchema, newSchema, searchPathHelper);
            PgDiffConstraints.dropConstraints(
                    writer, oldSchema, newSchema, true, searchPathHelper);
            PgDiffConstraints.dropConstraints(
                    writer, oldSchema, newSchema, false, searchPathHelper);
            PgDiffIndexes.dropIndexes(
                    writer, oldSchema, newSchema, searchPathHelper);
            PgDiffTables.dropClusters(
                    writer, oldSchema, newSchema, searchPathHelper);
            PgDiffTables.dropTables(
                    writer, oldSchema, newSchema, searchPathHelper);
            PgDiffSequences.dropSequences(
                    writer, oldSchema, newSchema, searchPathHelper);

            PgDiffSequences.createSequences(
                    writer, oldSchema, newSchema, searchPathHelper);
            PgDiffSequences.alterSequences(
                    writer, arguments, oldSchema, newSchema, searchPathHelper);
            PgDiffTables.createTables(
                    writer, oldSchema, newSchema, searchPathHelper);
            PgDiffTables.alterTables(
                    writer, arguments, oldSchema, newSchema, searchPathHelper);
            PgDiffSequences.alterCreatedSequences(
                    writer, oldSchema, newSchema, searchPathHelper);
            PgDiffFunctions.createFunctions(
                    writer, arguments, oldSchema, newSchema, searchPathHelper);
            PgDiffConstraints.createConstraints(
                    writer, oldSchema, newSchema, true, searchPathHelper);
            PgDiffConstraints.createConstraints(
                    writer, oldSchema, newSchema, false, searchPathHelper);
            PgDiffIndexes.createIndexes(
                    writer, oldSchema, newSchema, searchPathHelper);
            PgDiffTables.createClusters(
                    writer, oldSchema, newSchema, searchPathHelper);
            PgDiffTriggers.createTriggers(
                    writer, oldSchema, newSchema, searchPathHelper);
            PgDiffViews.createViews(
                    writer, oldSchema, newSchema, searchPathHelper);
            PgDiffViews.alterViews(
                    writer, oldSchema, newSchema, searchPathHelper);

            PgDiffFunctions.alterComments(
                    writer, oldSchema, newSchema, searchPathHelper);
            PgDiffConstraints.alterComments(
                    writer, oldSchema, newSchema, searchPathHelper);
            PgDiffIndexes.alterComments(
                    writer, oldSchema, newSchema, searchPathHelper);
            PgDiffTriggers.alterComments(
                    writer, oldSchema, newSchema, searchPathHelper);
        }
    }

    /**
     * Creates a new instance of PgDiff.
     */
    private PgDiff() {
    }
}
