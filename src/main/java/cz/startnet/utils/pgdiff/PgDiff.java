/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.InputStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import ru.taximaxim.codekeeper.apgdiff.model.graph.ActionsToScriptConverter;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyGraph;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyResolver;
import cz.startnet.utils.pgdiff.loader.ParserClass;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgExtension;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;

/**
 * Creates diff of two database schemas.
 *
 * @author fordfrog
 */
public final class PgDiff {

    private static DepcyGraph depcyOld;
    
    private static DepcyResolver depRes;

    /**
     * Creates diff on the two database schemas.
     *
     * @param writer    writer the output should be written to
     * @param arguments object containing arguments settings
     */
    public static PgDiffScript createDiff(final PrintWriter writer,
            final PgDiffArguments arguments) {
        PgDatabase oldDatabase = loadDatabaseSchema(
                arguments.getOldSrcFormat(), arguments.getOldSrc(), arguments);
        PgDatabase newDatabase = loadDatabaseSchema(
                arguments.getNewSrcFormat(), arguments.getNewSrc(), arguments); 
        return diffDatabaseSchemas(writer, arguments,
                oldDatabase, newDatabase, oldDatabase, newDatabase);
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
        try {
            PgDatabase oldDatabase = PgDumpLoader.loadDatabaseSchemaFromDump(
                    oldInputStream, arguments, ParserClass.getAntlr(null, 1));
            PgDatabase newDatabase = PgDumpLoader.loadDatabaseSchemaFromDump(
                    newInputStream, arguments, ParserClass.getAntlr(null, 1));
            diffDatabaseSchemas(writer, arguments, oldDatabase, newDatabase,
                    oldDatabase, newDatabase);
        } catch (InterruptedException ex) {
            Log.log(Log.LOG_ERROR, "Parser cancelled unexpectedly!", ex);
        }
    }
    
    /**
     * Loads database schema choosing the provided method.
     * 
     * @param format        format of the database source, must be "dump", "parsed" or "db"
     *                         otherwise exception is thrown
     * @param srcPath        path to the database source to load
     * @param arguments        object containing arguments settings
     * 
     * @return the loaded database
     */
    static PgDatabase loadDatabaseSchema(final String format, final String srcPath,
                final PgDiffArguments arguments) {
        try {
            if(format.equals("dump")) {
                return PgDumpLoader.loadDatabaseSchemaFromDump(srcPath,
                        arguments, ParserClass.getAntlr(null, 1));
            } else if(format.equals("parsed")) {
                return PgDumpLoader.loadDatabaseSchemaFromDirTree(srcPath,
                        arguments, ParserClass.getAntlr(null, 1));
            } else if(format.equals("db")) {
                throw new UnsupportedOperationException("DB connection is not yet implemented!");
            }
        } catch (InterruptedException ex) {
            Log.log(Log.LOG_ERROR, "Parser cancelled unexpectedly!", ex);
        }
        
        throw new UnsupportedOperationException(
                MessageFormat.format(Messages.UnknownDBFormat, format));
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
    public static PgDiffScript diffDatabaseSchemas(PrintWriter writer,
            PgDiffArguments arguments, PgDatabase oldDatabase, PgDatabase newDatabase,
            PgDatabase oldDbFull, PgDatabase newDbFull) {
        return diffDatabaseSchemasAdditionalDepcies(writer, arguments,
                oldDatabase, newDatabase, oldDbFull, newDbFull, null, null);
    }
    
    public static PgDiffScript diffDatabaseSchemasAdditionalDepcies(PrintWriter writer,
            PgDiffArguments arguments, PgDatabase oldDatabase, PgDatabase newDatabase,
            PgDatabase oldDbFull, PgDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget) {
        
        PgDiffScript script = new PgDiffScript();

        if (arguments.getTimeZone() != null) {
            script.addStatement(MessageFormat.format(
                    ApgdiffConsts.SET_TIMEZONE, arguments.getTimeZone()));
        }
        
        if (!arguments.isCheckFunctionBodies()) {
            script.addStatement("SET check_function_bodies = false;");
        }
        
        if (arguments.isAddTransaction()) {
            script.addStatement("START TRANSACTION;");
        }
        depRes = null;
        
        // temp solution
        if (oldDbFull != null && newDbFull != null) {
            try {
                depcyOld = new DepcyGraph(oldDbFull);
                depRes = new DepcyResolver(oldDbFull, newDbFull);
            } catch (PgCodekeeperException e) {
                throw new IllegalStateException(MessageFormat.format(
                        "Error creating dependency graph: {0}",
                        e.getLocalizedMessage()), e);
            }

            if (additionalDepciesSource != null) {
                depRes.addCustomDepciesToOld(additionalDepciesSource);
            }
            if (additionalDepciesTarget != null) {
                depRes.addCustomDepciesToNew(additionalDepciesTarget);
            }
        }

        diffComments(oldDatabase, newDatabase, script);

        dropOldExtensions(depRes, oldDatabase, newDatabase);
        dropOldSchemas(script, depRes, arguments, oldDatabase, newDatabase);
        createNewSchemas(depRes, oldDatabase, newDatabase);
        createNewExtensions(depRes, oldDatabase, newDatabase);
        updateExtensions(depRes, oldDatabase, newDatabase);
        updateSchemas(script, arguments, oldDatabase, newDatabase);

        new ActionsToScriptConverter(depRes.getActions()).fillScript(script);
        if (arguments.isAddTransaction()) {
            script.addStatement("COMMIT TRANSACTION;");
        }

        script.printStatements(writer);
        if (arguments.isOutputIgnoredStatements()) {
            addIgnoredStatements(oldDatabase, Messages.Database_OriginalDatabaseIgnoredStatements, writer);
            addIgnoredStatements(newDatabase, Messages.Database_NewDatabaseIgnoredStatements, writer);
        }
        return script;
    }

    /**
     * Adds ignored Statements to script
     * @param database database with ignored statements
     * @param messageText resource for localization message
     * @param script script to output statements
     */
    private static void addIgnoredStatements(PgDatabase database,
            String messageText, PrintWriter writer) {
        if (!database.getIgnoredStatements().isEmpty()) {
            writer.println();
            writer.print("/*");
            writer.println(messageText);

            for (final String statement : database.getIgnoredStatements()) {
                writer.println();
                writer.println(statement);
            }
            writer.println("*/");
        }
    }
    /**
     * Creates new extensions.
     * 
     * @param writer      writer the output should be written to
     * @param oldDatabase original database schema
     * @param newDatabase new database schema
     */
    private static void createNewExtensions(final DepcyResolver depRes, 
            final PgDatabase oldDatabase, final PgDatabase newDatabase) {
        for(final PgExtension newExt : newDatabase.getExtensions()) {
            if(oldDatabase.getExtension(newExt.getName()) == null) {
                depRes.addCreateStatements(newExt);
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
    private static void dropOldExtensions(final DepcyResolver depRes, 
            final PgDatabase oldDatabase, final PgDatabase newDatabase) {
        for(final PgExtension oldExt : oldDatabase.getExtensions()) {
            if(newDatabase.getExtension(oldExt.getName()) == null) {
                depRes.addDropStatements(oldExt);
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
    private static void updateExtensions(final DepcyResolver depRes,
            final PgDatabase oldDatabase, final PgDatabase newDatabase) {
        for(final PgExtension oldExt : oldDatabase.getExtensions()) {
            depRes.addAlterStatements(oldExt,
                    newDatabase.getExtension(oldExt.getName()));
        }
    }
    
    /**
     * Creates new schemas (not the objects inside the schemas).
     *
     * @param writer      writer the output should be written to
     * @param oldDatabase original database schema
     * @param newDatabase new database schema
     */
    private static void createNewSchemas(final DepcyResolver depRes,
            final PgDatabase oldDatabase, final PgDatabase newDatabase) {
        for (final PgSchema newSchema : newDatabase.getSchemas()) {
            if (oldDatabase.getSchema(newSchema.getName()) == null) {
                depRes.addCreateStatements(newSchema);
            }
        }
    }

    /**
     * Drops old schemas that do not exist anymore.
     *
     * @param depRes 
     * @param writer      writer the output should be written to
     * @param arguments 
     * @param oldDatabase original database schema
     * @param newDatabase new database schema
     */
    private static void dropOldSchemas(final PgDiffScript script,
            DepcyResolver depRes, PgDiffArguments arguments, final PgDatabase oldDatabase, final PgDatabase newDatabase) {
        for (final PgSchema oldSchema : oldDatabase.getSchemas()) {
            if (newDatabase.getSchema(oldSchema.getName()) == null) {
                if (!isFullSelection(oldSchema)){
                    script.addStatement("-- schema " + oldSchema.getName() + " was "
                            + "not dropped because it was not selected entirely");
                    continue;
                }
                // drop all contents of the schema
                depRes.addDropStatements(oldSchema);
            }
        }
    }

    static boolean isFullSelection(PgStatement filtered) {
        PgDatabase fullDb = depcyOld.getDb();
        if (filtered instanceof PgSchema) {
            PgSchema filteredSchema = (PgSchema) filtered;
            PgSchema fullSchema = fullDb.getSchema(filteredSchema.getName());
            return fullSchema.equals(filteredSchema);
        } else if (filtered instanceof PgTable) {
            PgTable filteredTable = (PgTable) filtered;
            PgSchema fullSchema = fullDb.getSchema(filteredTable.getParent().getName()); 
            PgTable fullTable = fullSchema.getTable(filteredTable.getName());
            return fullTable.equals(filteredTable);
        }
        
        return true;
    }

    /**
     * Updates objects in schemas.
     *
     * @param writer      writer the output should be written to
     * @param arguments   object containing arguments settings
     * @param oldDatabase original database schema
     * @param newDatabase new database schema
     */
    private static void updateSchemas(final PgDiffScript script,
            final PgDiffArguments arguments, final PgDatabase oldDatabase,
            final PgDatabase newDatabase) {
        for (final PgSchema newSchema : newDatabase.getSchemas()) {
            final SearchPathHelper searchPathHelper =
                    new SearchPathHelper(newSchema.getName());

            final PgSchema oldSchema = oldDatabase.getSchema(newSchema.getName());
            depRes.addAlterStatements(oldSchema, newSchema);
            updateSchemaContent(script, oldSchema, newSchema, searchPathHelper, arguments);
        }
        
        // КОСТЫЛЬ
        // update contents of schema, if it is not present in new db and 
        // is partly selected by the user
        for (final PgSchema oldSchema : oldDatabase.getSchemas()) {
            if (newDatabase.getSchema(oldSchema.getName()) == null 
                    && !isFullSelection(oldSchema)){
                SearchPathHelper searchPath =
                        new SearchPathHelper(oldSchema.getName());
                
                updateSchemaContent(script, oldSchema, oldSchema.shallowCopy(),
                        searchPath, arguments);
            }
        }// КОСТЫЛЬ
    }

    private static void updateSchemaContent(PgDiffScript script, PgSchema oldSchema,
            PgSchema newSchema, SearchPathHelper searchPathHelper, PgDiffArguments arguments) {
        PgDiffTriggers.dropTriggers(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffFunctions.dropFunctions(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffViews.dropViews(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffConstraints.dropConstraints(
                depRes, oldSchema, newSchema, true, searchPathHelper);
        PgDiffConstraints.dropConstraints(
                depRes, oldSchema, newSchema, false, searchPathHelper);
        PgDiffIndexes.dropIndexes(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffColumns.dropColumns(
                depRes, script, oldSchema, newSchema, searchPathHelper);
        PgDiffTables.dropTables(
                depRes, script, oldSchema, newSchema, searchPathHelper);
        PgDiffSequences.dropSequences(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffDomains.dropDomains(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffTypes.dropTypes(
                depRes, oldSchema, newSchema, searchPathHelper);
        
        PgDiffTypes.createTypes(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffTypes.alterTypes(
                depRes, arguments, oldSchema, newSchema, searchPathHelper);
        PgDiffDomains.createDomains(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffDomains.alterDomains(
                depRes, arguments, oldSchema, newSchema, searchPathHelper);
        PgDiffSequences.createSequences(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffSequences.alterSequences(
                depRes, arguments, oldSchema, newSchema, searchPathHelper);
        PgDiffTables.createTables(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffTables.alterTables(
                depRes, arguments, oldSchema, newSchema, searchPathHelper);
        PgDiffColumns.createColumns(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffColumns.alterColumns(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffFunctions.createFunctions(
                depRes, arguments, oldSchema, newSchema, searchPathHelper);
        PgDiffConstraints.createConstraints(
                depRes, oldSchema, newSchema, true, searchPathHelper);
        PgDiffConstraints.createConstraints(
                depRes, oldSchema, newSchema, false, searchPathHelper);
        PgDiffIndexes.createIndexes(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffTriggers.createTriggers(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffViews.createViews(
                depRes, arguments, oldSchema, newSchema, searchPathHelper);
        PgDiffViews.alterViews(
                depRes, arguments, oldSchema, newSchema, searchPathHelper);

        PgDiffFunctions.alterComments(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffConstraints.alterComments(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffIndexes.alterComments(
                depRes, oldSchema, newSchema, searchPathHelper);
        PgDiffTriggers.alterComments(
                depRes, oldSchema, newSchema, searchPathHelper);
    
        depRes.recreateDrops();
    }

    public static void diffComments(PgStatement oldStatement, PgStatement newStatement,
            PgDiffScript script) {
        String oldComment = oldStatement == null ? null : oldStatement.getComment();
        // new statements are null checked before these calls
        // but we may add a check here later if needed
        
        if (!Objects.equals(oldComment, newStatement.getComment())) {
            script.addStatement(newStatement.getCommentSql());
        }
    }
    
    private PgDiff() {
    }
}
