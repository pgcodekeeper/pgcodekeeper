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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcLoader;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgTable;
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

        for (String path : arguments.getTargetLibs()) {
            oldDatabase.addLib(getLibrary(path, arguments, false));
        }

        for (String path : arguments.getTargetLibsWithoutPriv()) {
            oldDatabase.addLib(getLibrary(path, arguments, true));
        }

        for (String path : arguments.getSourceLibs()) {
            newDatabase.addLib(getLibrary(path, arguments, false));
        }

        for (String path : arguments.getSourceLibsWithoutPriv()) {
            newDatabase.addLib(getLibrary(path, arguments, true));
        }

        IgnoreParser ignoreParser = new IgnoreParser();
        for (String listFilename : arguments.getIgnoreLists()) {
            ignoreParser.parse(Paths.get(listFilename));
        }

        return diffDatabaseSchemas(writer, arguments, oldDatabase, newDatabase, ignoreParser.getIgnoreList());
    }

    public static PgDatabase getLibrary(String path, PgDiffArguments arguments,
            boolean isIgnorePriv) throws InterruptedException, IOException, URISyntaxException {

        PgDiffArguments args = arguments.clone();
        args.setIgnorePrivileges(isIgnorePriv);

        if (path.startsWith("jdbc:")) {
            PgDatabase db = loadDatabaseSchema("db", path, args);
            PgDatabase.listPgObjects(db).values().forEach(st -> st.setLocation(path));
            return db;
        }

        Path p = Paths.get(path);

        if (Files.isDirectory(p)) {
            if (Files.exists(p.resolve(ApgdiffConsts.FILENAME_WORKING_DIR_MARKER))) {
                return loadDatabaseSchema("parsed", path, args);
            } else {
                PgDatabase db = new PgDatabase(false);
                db.setArguments(args);
                readStatementsFromDirectory(p, db, args);
                return db;
            }
        }

        PgDatabase dump = loadDatabaseSchema("dump", path, args);
        // dumps are loaded with default public schema
        dump.getSchema(ApgdiffConsts.PUBLIC).setLocation(path);
        return dump;
    }

    private static void readStatementsFromDirectory(final Path f, PgDatabase db, PgDiffArguments args)
            throws IOException, InterruptedException, URISyntaxException {
        if (Files.isDirectory(f)) {
            try (Stream<Path> stream = Files.list(f)) {
                for (Path sub : (Iterable<Path>) stream::iterator) {
                    readStatementsFromDirectory(sub, db, args);
                }
            }
        } else {
            db.addLib(PgDiff.loadDatabaseSchema("dump", f.toString(), args));
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
     * @throws IOException
     * @throws InterruptedException
     * @throws URISyntaxException
     */
    public static PgDatabase loadDatabaseSchema(String format, String srcPath, PgDiffArguments arguments)
            throws InterruptedException, IOException, URISyntaxException {
        if ("dump".equals(format)) {
            try (PgDumpLoader loader = new PgDumpLoader(new File(srcPath), arguments)) {
                return loader.load();
            }
        } else if ("parsed".equals(format)) {
            return PgDumpLoader.loadDatabaseSchemaFromDirTree(srcPath,  arguments, null, null);
        } else if ("db".equals(format)) {
            JdbcLoader loader = new JdbcLoader(new JdbcConnector(srcPath), arguments);
            return loader.getDbFromJdbc();
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
        return diffDatabaseSchemasAdditionalDepcies(writer, arguments,
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
        new ActionsToScriptConverter(depRes.getActions(), arguments).fillScript(script);
        if (arguments.isAddTransaction()) {
            script.addStatement("COMMIT TRANSACTION;");
        }

        script.printStatements(writer);

        return script;
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
                PgTable oldTbl = null;
                PgTable newTbl =(PgTable) el.getPgStatement(newDbFull);
                if (el.getSide() == DiffSide.BOTH) {
                    oldTbl =(PgTable) el.getPgStatement(oldDbFull);
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
