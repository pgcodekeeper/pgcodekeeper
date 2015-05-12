/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.InputStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.CompareTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.apgdiff.model.graph.ActionsToScriptConverter;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyResolver;
import cz.startnet.utils.pgdiff.loader.ParserClass;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;

/**
 * Creates diff of two database schemas.
 *
 * @author fordfrog
 */
public final class PgDiff {

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
        return diffDatabaseSchemas(writer, arguments, oldDatabase, newDatabase);
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
            diffDatabaseSchemas(writer, arguments, oldDatabase, newDatabase);
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
            PgDiffArguments arguments, PgDatabase oldDbFull, PgDatabase newDbFull) {
        TreeElement root = DiffTree.create(oldDbFull, newDbFull);
        root.setAllchecked();
        return diffDatabaseSchemasAdditionalDepcies(writer, arguments,
                root, oldDbFull, newDbFull, null, null);
    }
    
    /**
     * Делает то же что и метод выше, однако принимает TreeElement - как
     * элементы нужные для наката
     * 
     * @param writer
     * @param arguments
     * @param selected
     * @param oldDbFull
     * @param newDbFull
     * @param additionalDepciesSource
     * @param additionalDepciesTarget
     * @return
     */
    public static PgDiffScript diffDatabaseSchemasAdditionalDepcies(PrintWriter writer,
            PgDiffArguments arguments, TreeElement root,
            PgDatabase oldDbFull, PgDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget) {
        PgDiffScript script = new PgDiffScript();
        
        List<TreeElement> selected = new ArrayList<TreeElement>();
        TreeElement.getSelected(root, selected);
        //TODO----------КОСТЫЛЬ колонки добавляются как выбранные если выбрана таблица-----------
        selected.addAll(addColumns(oldDbFull, newDbFull,
                selected));
        // ---КОСТЫЛЬ-----------
        Collections.sort(selected, new CompareTree());
        
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

        for (TreeElement st : selected) {
            switch (st.getSide()) {
            case LEFT:
                depRes.addDropStatements(st.getPgStatement(oldDbFull));
                break;
            case BOTH:
                depRes.addAlterStatements(st.getPgStatement(oldDbFull),
                        st.getPgStatement(newDbFull));
                break;
            case RIGHT:
                depRes.addCreateStatements(st.getPgStatement(newDbFull));
                break;
            }
        }
        depRes.recreateDrops();
        
        new ActionsToScriptConverter(depRes.getActions()).fillScript(script);
        if (arguments.isAddTransaction()) {
            script.addStatement("COMMIT TRANSACTION;");
        }

        script.printStatements(writer);
        if (arguments.isOutputIgnoredStatements()) {
            addIgnoredStatements(oldDbFull, Messages.Database_OriginalDatabaseIgnoredStatements, writer);
            addIgnoredStatements(newDbFull, Messages.Database_NewDatabaseIgnoredStatements, writer);
        }
        return script;
    }

    /**
     * После реализации колонко как подъелементов таблицы выпилить метод!
     * @param oldDbFull
     * @param newDbFull
     * @param selected
     * @return
     */
    private static List<TreeElement> addColumns(PgDatabase oldDbFull,
            PgDatabase newDbFull, List<TreeElement> selected) {
        List<TreeElement> tempColumns = new ArrayList<>();
        for (TreeElement el : selected) {
            if (el.getType() == DbObjType.TABLE
                    && el.getSide() == DiffSide.BOTH) {
                PgTable oldTbl =(PgTable) el.getPgStatement(oldDbFull);
                PgTable newTbl =(PgTable) el.getPgStatement(newDbFull);
                for (PgColumn oldCol : oldTbl.getColumns()) {
                    PgColumn newCol = newTbl.getColumn(oldCol.getName()); 
                    if (newCol == null) {
                        TreeElement col = new TreeElement(oldCol.getName(), DbObjType.COLUMN, DiffSide.LEFT);
                        col.setParent(el);
                        tempColumns.add(col);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        AtomicBoolean isNeedDepcies = new AtomicBoolean();
                        if (oldCol.appendAlterSQL(newCol, sb, isNeedDepcies)) {
                            TreeElement col = new TreeElement(oldCol.getName(), DbObjType.COLUMN, DiffSide.BOTH);
                            col.setParent(el);
                            tempColumns.add(col);
                        }
                    }
                }
                for (PgColumn newCol : newTbl.getColumns()) {
                    if (!oldTbl.containsColumn(newCol.getName())) {
                        TreeElement col = new TreeElement(newCol.getName(), DbObjType.COLUMN, DiffSide.RIGHT);
                        col.setParent(el);
                        tempColumns.add(col);
                    }
                }
            }
        }
        return tempColumns;
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
