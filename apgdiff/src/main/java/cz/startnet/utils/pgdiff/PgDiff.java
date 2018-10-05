/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.loader.FullAnalyze;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcLoader;
import cz.startnet.utils.pgdiff.loader.JdbcMsLoader;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.loader.ProjectLoader;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.LibraryObjectDuplicationException;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgOverride;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.ignoreparser.IgnoreParser;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.CompareTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeFlattener;
import ru.taximaxim.codekeeper.apgdiff.model.graph.ActionsToScriptConverter;
import ru.taximaxim.codekeeper.apgdiff.model.graph.DepcyResolver;

/**
 * Creates diff of two database schemas.
 *
 * @author fordfrog
 */
public final class PgDiff {

    /**
     * Creates diff on the two database schemas.
     *
     * @param writer    writer the output should be written to
     * @param arguments object containing arguments settings
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    public static PgDiffScript createDiff(PrintWriter writer, PgDiffArguments arguments)
            throws InterruptedException, IOException, URISyntaxException {
        PgDatabase oldDatabase = loadDatabaseSchema(
                arguments.getOldSrcFormat(), arguments.getOldSrc(), arguments);

        PgDatabase newDatabase = loadDatabaseSchema(
                arguments.getNewSrcFormat(), arguments.getNewSrc(), arguments);

        ProjectLoader.loadLibraries(oldDatabase, arguments, false, arguments.getTargetLibs());
        ProjectLoader.loadLibraries(oldDatabase, arguments, true, arguments.getTargetLibsWithoutPriv());
        ProjectLoader.loadLibraries(newDatabase, arguments, false, arguments.getSourceLibs());
        ProjectLoader.loadLibraries(newDatabase, arguments, true, arguments.getSourceLibsWithoutPriv());

        if (arguments.isLibSafeMode()) {
            List<PgOverride> overrides = oldDatabase.getOverrides();
            overrides.addAll(newDatabase.getOverrides());
            if (!overrides.isEmpty()) {
                throw new LibraryObjectDuplicationException(overrides);
            }
        }

        FullAnalyze.fullAnalyze(oldDatabase, null);
        FullAnalyze.fullAnalyze(newDatabase, null);

        IgnoreParser ignoreParser = new IgnoreParser();
        for (String listFilename : arguments.getIgnoreLists()) {
            ignoreParser.parse(Paths.get(listFilename));
        }

        return diffDatabaseSchemas(writer, arguments, oldDatabase, newDatabase, ignoreParser.getIgnoreList());
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
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    public static PgDatabase loadDatabaseSchema(String format, String srcPath, PgDiffArguments arguments)
            throws InterruptedException, IOException, URISyntaxException {

        PgDatabase db = new PgDatabase();
        db.setArguments(arguments);

        if ("dump".equals(format)) {
            try (PgDumpLoader loader = new PgDumpLoader(new File(srcPath), arguments)) {
                return loader.load(db);
            }
        } else if ("parsed".equals(format)) {
            ProjectLoader loader = new ProjectLoader(srcPath, arguments);
            return arguments.isMsSql() ? loader.loadMsDatabaseSchemaFromDirTree() :
                loader.loadDatabaseSchemaFromDirTree(db);
        } else if ("db".equals(format)) {
            String timezone = arguments.getTimeZone() == null ? ApgdiffConsts.UTC : arguments.getTimeZone();
            return arguments.isMsSql() ?
                    new JdbcMsLoader(JdbcConnector.fromUrl(srcPath), arguments).readDb()
                    : new JdbcLoader(JdbcConnector.fromUrl(srcPath, timezone), arguments).getDbFromJdbc(db);
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
     * @throws InterruptedException
     */
    public static PgDiffScript diffDatabaseSchemas(PrintWriter writer,
            PgDiffArguments arguments, PgDatabase oldDbFull, PgDatabase newDbFull,
            IgnoreList ignoreList) throws InterruptedException {
        TreeElement root = DiffTree.create(oldDbFull, newDbFull, null);
        root.setAllChecked();
        return arguments.isMsSql() ? diffMsDatabaseSchemas(writer, arguments,
                root, oldDbFull, newDbFull, ignoreList) :
                    diffDatabaseSchemasAdditionalDepcies(writer, arguments,
                            root, oldDbFull, newDbFull, null, null, ignoreList);
    }

    /**
     * Делает то же, что и метод выше, однако принимает TreeElement - как
     * элементы нужные для наката
     */
    public static PgDiffScript diffDatabaseSchemasAdditionalDepcies(PrintWriter writer,
            PgDiffArguments arguments, TreeElement root,
            PgDatabase oldDbFull, PgDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget) {
        if (arguments.isMsSql()) {
            return diffMsDatabaseSchemas(writer, arguments, root, oldDbFull, newDbFull, null);
        }
        return diffDatabaseSchemasAdditionalDepcies(writer, arguments, root,
                oldDbFull, newDbFull, additionalDepciesSource, additionalDepciesTarget, null);
    }

    private static PgDiffScript diffDatabaseSchemasAdditionalDepcies(PrintWriter writer,
            PgDiffArguments arguments, TreeElement root,
            PgDatabase oldDbFull, PgDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget,
            IgnoreList ignoreList) {
        PgDiffScript script = new PgDiffScript();

        if (arguments.getTimeZone() != null) {
            script.addStatement("SET TIMEZONE TO "
                    + PgDiffUtils.quoteString(arguments.getTimeZone()) + ';');
        }

        if (arguments.isDisableCheckFunctionBodies()) {
            script.addStatement("SET check_function_bodies = false;");
        }

        if (arguments.isAddTransaction()) {
            script.addStatement("START TRANSACTION;");
        }

        DepcyResolver depRes = new DepcyResolver(oldDbFull, newDbFull);
        if (additionalDepciesSource != null) {
            depRes.addCustomDepciesToOld(additionalDepciesSource);
        }
        if (additionalDepciesTarget != null) {
            depRes.addCustomDepciesToNew(additionalDepciesTarget);
        }

        List<String> dbNames = new ArrayList<>();
        if ("db".equals(arguments.getNewSrcFormat())) {
            dbNames.add(JdbcConnector.dbNameFromUrl(arguments.getNewSrc()));
        }
        if ("db".equals(arguments.getOldSrcFormat())) {
            dbNames.add(JdbcConnector.dbNameFromUrl(arguments.getOldSrc()));
        }

        List<TreeElement> selected = new TreeFlattener()
                .onlySelected()
                .useIgnoreList(ignoreList)
                .onlyTypes(arguments.getAllowedTypes())
                .flatten(root);
        //TODO----------КОСТЫЛЬ колонки добавляются как выбранные если выбрана таблица-----------
        addColumnsAsElements(oldDbFull, newDbFull, selected);
        // ---КОСТЫЛЬ-----------

        Collections.sort(selected, new CompareTree());
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

        if (!depRes.getActions().isEmpty()) {
            script.addStatement("SET search_path = pg_catalog;");
        }
        new ActionsToScriptConverter(depRes.getActions(), arguments).fillScript(script);
        if (arguments.isAddTransaction()) {
            script.addStatement("COMMIT TRANSACTION;");
        }

        script.printStatements(writer);

        return script;
    }


    private static PgDiffScript diffMsDatabaseSchemas(PrintWriter writer,
            PgDiffArguments arguments, TreeElement root, PgDatabase oldDbFull,
            PgDatabase newDbFull, IgnoreList ignoreList) {
        PgDiffScript script = new PgDiffScript();

        if (arguments.isAddTransaction()) {
            script.addStatement("BEGIN TRANSACTION\nGO");
        }

        List<String> dbNames = new ArrayList<>();

        if ("db".equals(arguments.getNewSrcFormat())) {
            dbNames.add(JdbcConnector.dbNameFromUrl(arguments.getNewSrc()));
        }

        if ("db".equals(arguments.getOldSrcFormat())) {
            dbNames.add(JdbcConnector.dbNameFromUrl(arguments.getOldSrc()));
        }

        List<TreeElement> selected = new TreeFlattener()
                .onlySelected()
                .useIgnoreList(ignoreList)
                .onlyTypes(arguments.getAllowedTypes())
                .flatten(root);
        //TODO----------КОСТЫЛЬ колонки добавляются как выбранные если выбрана таблица-----------
        addColumnsAsElements(oldDbFull, newDbFull, selected);
        // ---КОСТЫЛЬ-----------

        Collections.sort(selected, new CompareTree());

        for (TreeElement st : selected) {
            switch (st.getSide()) {
            case LEFT:
                if (st.getType() != DbObjType.COLUMN || !isTableRecreated(st.getParent(), oldDbFull, newDbFull)) {
                    script.addStatement(st.getPgStatement(oldDbFull).getDropSQL());
                }
                break;
            case BOTH:
                AtomicBoolean isNeedDepcies = new AtomicBoolean();
                StringBuilder sb = new StringBuilder();
                PgStatement oldObj = st.getPgStatement(oldDbFull);
                PgStatement newObj = st.getPgStatement(newDbFull);

                if (st.getType() == DbObjType.COLUMN && isTableRecreated(st.getParent(), oldDbFull, newDbFull)) {
                    continue;
                }

                if (oldObj.appendAlterSQL(newObj, sb, isNeedDepcies)) {
                    if (isNeedDepcies.get()) {
                        script.addStatement(oldObj.getDropSQL());
                        script.addStatement(newObj.getCreationSQL());
                    }
                    script.addStatement(sb.toString());
                }
                break;
            case RIGHT:
                if (st.getType() != DbObjType.COLUMN || !isTableRecreated(st.getParent(), oldDbFull, newDbFull)) {
                    script.addStatement(st.getPgStatement(newDbFull).getCreationSQL());
                }
                break;
            }
        }

        if (arguments.isAddTransaction()) {
            script.addStatement("COMMIT\nGO");
        }

        script.printStatements(writer);

        return script;
    }

    private static boolean isTableRecreated(TreeElement table, PgDatabase oldDb, PgDatabase newDb) {
        PgStatement oldSt = table.getSide() != DiffSide.RIGHT ? table.getPgStatement(oldDb) : null;
        PgStatement newSt = table.getSide() != DiffSide.LEFT  ? table.getPgStatement(newDb) : null;
        if (oldSt == null || newSt == null) {
            return true;
        }

        AtomicBoolean isRecreate = new AtomicBoolean();
        oldSt.appendAlterSQL(newSt, new StringBuilder(), isRecreate);

        return isRecreate.get();
    }

    /**
     * После реализации колонок как подэлементов таблицы выпилить метод!
     */
    @Deprecated
    private static void addColumnsAsElements(PgDatabase oldDbFull, PgDatabase newDbFull,
            List<TreeElement> selected) {
        List<TreeElement> tempColumns = new ArrayList<>();
        for (TreeElement el : selected) {
            if (el.getType() == DbObjType.TABLE && el.getSide() != DiffSide.LEFT) {
                AbstractTable oldTbl = null;
                AbstractTable newTbl =(AbstractTable) el.getPgStatement(newDbFull);
                if (el.getSide() == DiffSide.BOTH) {
                    oldTbl =(AbstractTable) el.getPgStatement(oldDbFull);
                }
                DiffTree.addColumns(oldTbl == null ? Collections.emptyList() : oldTbl.getColumns(),
                        newTbl.getColumns(), el, tempColumns);
            }
        }
        selected.addAll(tempColumns);
    }

    private PgDiff() {
    }
}
