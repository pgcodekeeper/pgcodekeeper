/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import cz.startnet.utils.pgdiff.loader.FullAnalyze;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcLoader;
import cz.startnet.utils.pgdiff.loader.JdbcMsLoader;
import cz.startnet.utils.pgdiff.loader.LibraryLoader;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.loader.ProjectLoader;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.LibraryObjectDuplicationException;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgOverride;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.xmlstore.DependenciesXmlStore;
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
public class PgDiff {

    private final PgDiffArguments arguments;
    private final List<Object> errors = new ArrayList<>();

    public PgDiff(PgDiffArguments arguments) {
        this.arguments = arguments;
    }

    public List<Object> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    /**
     * Creates diff on the two database schemas.
     */
    public PgDiffScript createDiff() throws InterruptedException, IOException, PgCodekeeperException {
        PgDatabase oldDatabase = loadOldDatabase();
        PgDatabase newDatabase = loadNewDatabase();

        Path metaPath = Paths.get(System.getProperty("user.home")).resolve(".pgcodekeeper-cli")
                .resolve("dependencies");

        LibraryLoader oldLib = new LibraryLoader(oldDatabase, metaPath);

        for (String xml : arguments.getSourceLibXmls()) {
            oldLib.loadXml(new DependenciesXmlStore(Paths.get(xml)), arguments);
        }

        oldLib.loadLibraries(arguments, false, arguments.getSourceLibs());
        oldLib.loadLibraries(arguments, true, arguments.getSourceLibsWithoutPriv());

        LibraryLoader newLib = new LibraryLoader(newDatabase, metaPath);

        for (String xml : arguments.getTargetLibXmls()) {
            newLib.loadXml(new DependenciesXmlStore(Paths.get(xml)), arguments);
        }

        newLib.loadLibraries(arguments, false, arguments.getTargetLibs());
        newLib.loadLibraries(arguments, true, arguments.getTargetLibsWithoutPriv());

        if (arguments.isLibSafeMode() &&
                (!oldDatabase.getOverrides().isEmpty() || !newDatabase.getOverrides().isEmpty())) {
            List<PgOverride> overrides = oldDatabase.getOverrides();
            overrides.addAll(newDatabase.getOverrides());
            throw new LibraryObjectDuplicationException(overrides);
        }

        // read additional privileges from special folder
        if ("parsed".equals(arguments.getOldSrcFormat())) {
            new ProjectLoader(arguments.getOldSrc(), arguments).loadOverrides(oldDatabase);
        }
        if ("parsed".equals(arguments.getNewSrcFormat())) {
            new ProjectLoader(arguments.getNewSrc(), arguments).loadOverrides(newDatabase);
        }

        FullAnalyze.fullAnalyze(oldDatabase, null);
        FullAnalyze.fullAnalyze(newDatabase, null);

        IgnoreParser ignoreParser = new IgnoreParser();
        for (String listFilename : arguments.getIgnoreLists()) {
            ignoreParser.parse(Paths.get(listFilename));
        }

        return diffDatabaseSchemas(oldDatabase, newDatabase, ignoreParser.getIgnoreList());
    }

    public PgDatabase loadNewDatabase() throws IOException, InterruptedException, PgCodekeeperException {
        PgDatabase db = loadDatabaseSchema(arguments.getNewSrcFormat(), arguments.getNewSrc());
        if (!errors.isEmpty()) {
            throw new PgCodekeeperException("Error while load database");
        }
        return db;
    }

    public PgDatabase loadOldDatabase() throws IOException, InterruptedException, PgCodekeeperException {
        PgDatabase db = loadDatabaseSchema(arguments.getOldSrcFormat(), arguments.getOldSrc());
        if (!errors.isEmpty()) {
            throw new PgCodekeeperException("Error while load database");
        }
        return db;
    }

    /**
     * Loads database schema choosing the provided method.
     *
     * @param format        format of the database source, must be "dump", "parsed" or "db"
     *                         otherwise exception is thrown
     * @param srcPath        path to the database source to load
     *
     * @return the loaded database
     */
    private PgDatabase loadDatabaseSchema(String format, String srcPath)
            throws InterruptedException, IOException {
        PgDatabase db = new PgDatabase(arguments);

        if ("dump".equals(format)) {
            PgDumpLoader loader = new PgDumpLoader(new File(srcPath), arguments);
            try {
                return loader.load(db);
            } finally {
                errors.addAll(loader.getErrors());
            }
        }

        if ("parsed".equals(format)) {
            List<AntlrError> err = new ArrayList<>();
            ProjectLoader loader = new ProjectLoader(srcPath, arguments, null, err);
            try {
                return loader.loadSchemaOnly();
            } finally {
                errors.addAll(err);
            }
        }

        if ("db".equals(format)) {
            String timezone = arguments.getTimeZone() == null ? ApgdiffConsts.UTC : arguments.getTimeZone();
            if (arguments.isMsSql()) {
                return new JdbcMsLoader(JdbcConnector.fromUrl(srcPath), arguments).readDb();
            } else {
                JdbcLoader loader = new JdbcLoader(JdbcConnector.fromUrl(srcPath, timezone), arguments);
                try {
                    return loader.getDbFromJdbc();
                } finally {
                    errors.addAll(loader.getErrors());
                }
            }
        }

        throw new UnsupportedOperationException(
                MessageFormat.format(Messages.UnknownDBFormat, format));
    }

    private PgDiffScript diffDatabaseSchemas(PgDatabase oldDbFull, PgDatabase newDbFull,
            IgnoreList ignoreList) throws InterruptedException {
        TreeElement root = DiffTree.create(oldDbFull, newDbFull, null);
        root.setAllChecked();
        return arguments.isMsSql() ? diffMsDatabaseSchemas(root, oldDbFull, newDbFull, null, null, ignoreList) :
            diffDatabaseSchemasAdditionalDepcies(root, oldDbFull, newDbFull, null, null, ignoreList);
    }

    /**
     * Делает то же, что и метод выше, однако принимает TreeElement - как
     * элементы нужные для наката
     */
    public PgDiffScript diffDatabaseSchemasAdditionalDepcies(TreeElement root,
            PgDatabase oldDbFull, PgDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget) {
        if (arguments.isMsSql()) {
            return diffMsDatabaseSchemas(root, oldDbFull, newDbFull,
                    additionalDepciesSource, additionalDepciesTarget, null);
        }
        return diffDatabaseSchemasAdditionalDepcies(root, oldDbFull, newDbFull,
                additionalDepciesSource, additionalDepciesTarget, null);
    }

    private PgDiffScript diffDatabaseSchemasAdditionalDepcies(
            TreeElement root, PgDatabase oldDbFull, PgDatabase newDbFull,
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
        createScript(depRes, root, oldDbFull, newDbFull,
                additionalDepciesSource, additionalDepciesTarget, ignoreList);

        if (!depRes.getActions().isEmpty()) {
            script.addStatement("SET search_path = pg_catalog;");
        }
        new ActionsToScriptConverter(depRes.getActions(), arguments).fillScript(script);
        if (arguments.isAddTransaction()) {
            script.addStatement("COMMIT TRANSACTION;");
        }

        return script;
    }

    private PgDiffScript diffMsDatabaseSchemas(
            TreeElement root, PgDatabase oldDbFull, PgDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget,
            IgnoreList ignoreList) {
        PgDiffScript script = new PgDiffScript();

        if (arguments.isAddTransaction()) {
            script.addStatement("BEGIN TRANSACTION\nGO");
        }

        DepcyResolver depRes = new DepcyResolver(oldDbFull, newDbFull);
        createScript(depRes, root, oldDbFull, newDbFull,
                additionalDepciesSource, additionalDepciesTarget, ignoreList);

        new ActionsToScriptConverter(depRes.getActions(),
                depRes.getToRefresh(), arguments).fillScript(script);

        if (arguments.isAddTransaction()) {
            script.addStatement("COMMIT\nGO");
        }

        return script;
    }

    private void createScript(DepcyResolver depRes, TreeElement root,
            PgDatabase oldDbFull, PgDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget,
            IgnoreList ignoreList) {
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
    }


    /**
     * После реализации колонок как подэлементов таблицы выпилить метод!
     */
    @Deprecated
    private void addColumnsAsElements(PgDatabase oldDbFull, PgDatabase newDbFull,
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

    // used in tests
    public static PgDiffScript diffDatabaseSchemas(PgDiffArguments arguments,
            PgDatabase oldDbFull, PgDatabase newDbFull, IgnoreList ignoreList)
                    throws InterruptedException {
        return new PgDiff(arguments).diffDatabaseSchemas(oldDbFull, newDbFull, ignoreList);
    }
}
