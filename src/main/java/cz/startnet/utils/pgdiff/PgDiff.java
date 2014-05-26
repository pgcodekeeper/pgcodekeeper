/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyGraph;
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
public class PgDiff {

    private static DirectedGraph<PgStatement, DefaultEdge> oldDepcyGraph;
    private static DepcyGraph depcyOld;
    // TODO unused for now
    private static DepcyGraph depcyNew;

    /**
     * Creates diff on the two database schemas.
     *
     * @param writer    writer the output should be written to
     * @param arguments object containing arguments settings
     */
    public static void createDiff(final PrintWriter writer,
            final PgDiffArguments arguments) {
        PgDatabase dbOld = loadDatabaseSchema(
                arguments.getOldSrcFormat(), arguments.getOldSrc(), arguments);
        PgDatabase dbNew = loadDatabaseSchema(
                arguments.getNewSrcFormat(), arguments.getNewSrc(), arguments); 
        diffDatabaseSchemas(writer, arguments, dbOld, dbNew, dbOld, dbNew);
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

        diffDatabaseSchemas(writer, arguments, oldDatabase, newDatabase,
                oldDatabase, newDatabase);
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
            final PgDatabase newDatabase, PgStatement oldDbFull, PgStatement newDbFull) {
        if (arguments.isAddTransaction()) {
            writer.println("START TRANSACTION;");
        }

        // temp solution
        if (oldDbFull != null && newDbFull != null){
            depcyOld = new DepcyGraph((PgDatabase)oldDbFull);
            depcyNew = new DepcyGraph((PgDatabase)newDbFull);
        }else{
            depcyOld = new DepcyGraph(new PgDatabase());
            depcyNew = new DepcyGraph(new PgDatabase());
        }
        oldDepcyGraph = depcyOld.getGraph();
        
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

        dropOldSchemas(writer, arguments, oldDatabase, newDatabase);
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
     * Fills in the result list with all PgStatements, that are dependent from parent.
     * <br>
     * (that is, finds those vertices, that have common edge with parent where 
     * parent is the target)
     */
    public static Set<PgStatement> getDependantsSet(PgStatement parent,
            Set<PgStatement> result) {
        if (oldDepcyGraph.containsVertex(parent)){
            for (DefaultEdge edge : oldDepcyGraph.incomingEdgesOf(parent)) {
                PgStatement dependant = oldDepcyGraph.getEdgeSource(edge);
                if (result.add(dependant)) {
                    getDependantsSet(dependant, result);
                }
            }
        }
        return result;
    }

    /**
     * Fills in the result list with all PgStatements, that child is dependent from.
     * <br>
     * (that is, finds those vertices, that have common edge with child where 
     * child is the source)
     */
    public static Set<PgStatement> getDependenciesSet(PgStatement child,
            Set<PgStatement> result) {
        if (oldDepcyGraph.containsVertex(child)){
            for (DefaultEdge edge : oldDepcyGraph.outgoingEdgesOf(child)){
                    PgStatement dependency = oldDepcyGraph.getEdgeTarget(edge);
                    if (result.add(dependency)) {
                        getDependenciesSet(dependency, result);
                    }
            }
        }
        return result;
    }
    
    /**
     * Checks, whether the child is in a subtree of the parent.
     * <br>
     * (as trigger would be a child of a table)
     * 
     * TODO add more class checking for parent
     */
    public static boolean containsChild(PgStatement parent, PgStatement child) {
        String name = child.getName();
        if (parent instanceof PgTable){
            PgTable t = (PgTable)parent;
            return t.containsConstraint(name) ||
                   t.containsColumn(name) || 
                   t.containsIndex(name) || 
                   t.containsTrigger(name);
        }else if (parent instanceof PgSchema){
            PgSchema s = (PgSchema) parent;
            return s.containsFunction(name) ||
                   s.containsSequence(name) || 
                   s.containsTable(name) || 
                   s.containsView(name);
        }else{
            Log.log(Log.LOG_DEBUG, "Error in PgDiff.containsChild: parent is neither "
                    + "a table nor a schema.\nParent's creation SQL:\n" + parent.getCreationSQL());
            return true;
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
                writeCreationSql(writer, null, newExt);
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
                writeDropSql(writer, null, oldExt);
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
                writeCreationSql(writer, null, newSchema);
            }
        }
    }

    /**
     * Drops old schemas that do not exist anymore.
     *
     * @param writer      writer the output should be written to
     * @param arguments 
     * @param oldDatabase original database schema
     * @param newDatabase new database schema
     */
    private static void dropOldSchemas(final PrintWriter writer,
            PgDiffArguments arguments, final PgDatabase oldDatabase, final PgDatabase newDatabase) {
        for (final PgSchema oldSchema : oldDatabase.getSchemas()) {
            if (newDatabase.getSchema(oldSchema.getName()) == null) {
                if (!isFullSelection(oldSchema)){
                    writer.println("-- schema \"" + oldSchema.getName() + "\" was "
                            + "not dropped because it was not selected entirely");
                    writer.println();
                    continue;
                }
                // drop all contents of the schema
                PgSchema newSchema = new PgSchema(oldSchema.getName(), "CREATE SCHEMA " + oldSchema.getName());
                updateSchemaContent(writer,
                        depcyOld.getDb().getSchema(oldSchema.getName()), newSchema,
                        new SearchPathHelper(oldSchema.getName()), arguments);
                writer.println();
                writer.println(oldSchema.getDropSQL());
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
    private static void updateSchemas(final PrintWriter writer,
            final PgDiffArguments arguments, final PgDatabase oldDatabase,
            final PgDatabase newDatabase) {
        final boolean setSearchPath = newDatabase.getSchemas().size() > 1
                || !newDatabase.getSchemas().get(0).getName().equals("public");

        for (final PgSchema newSchema : newDatabase.getSchemas()) {
            final SearchPathHelper searchPathHelper =
                    new SearchPathHelper(newSchema.getName());
            if (!setSearchPath) {
                searchPathHelper.setWasOutput(true);
            }

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
            updateSchemaContent(writer, oldSchema, newSchema, searchPathHelper, arguments);
        }
        
        // КОСТЫЛЬ
        // update contents of schema, if it is not present in new db and 
        // is partly selected by the user
        for (final PgSchema oldSchema : oldDatabase.getSchemas()) {
            if (newDatabase.getSchema(oldSchema.getName()) == null && !isFullSelection(oldSchema)){
                SearchPathHelper searchPath =
                        new SearchPathHelper(oldSchema.getName());
                PgSchema newSchema = new PgSchema(oldSchema.getName(), null);
                newSchema.setAuthorization(oldSchema.getAuthorization());
                newSchema.setComment(oldSchema.getComment());
                newSchema.setDefinition(oldSchema.getDefinition());
                
                updateSchemaContent(writer, oldSchema, newSchema, searchPath, arguments);
            }
        }// КОСТЫЛЬ
    }

    private static void updateSchemaContent(PrintWriter writer, PgSchema oldSchema,
            PgSchema newSchema, SearchPathHelper searchPathHelper, PgDiffArguments arguments) {
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
    
    static void tempSwitchSearchPath(String switchTo, 
            final SearchPathHelper searchPathHelper, final PrintWriter writer){
        
        if (searchPathHelper.getWasOutput() == false ||
                !searchPathHelper.getSchemaName().equals(switchTo)){
            new SearchPathHelper(switchTo).outputSearchPath(writer);
            
            searchPathHelper.setWasOutput(false);
        }
    }
    
    static void writeCreationSql(PrintWriter writer, String comment, PgStatement pgObject){
        writer.println();
        if (comment != null){
            writer.println(comment);
        }
        writer.println(pgObject.getCreationSQL());
    }
    
    static void writeDropSql(PrintWriter writer, String comment, PgStatement pgObject){
        writer.println();
        if (comment != null){
            writer.println(comment);
        }
        writer.println(pgObject.getDropSQL());
    }
    
    private PgDiff() {
    }
}
