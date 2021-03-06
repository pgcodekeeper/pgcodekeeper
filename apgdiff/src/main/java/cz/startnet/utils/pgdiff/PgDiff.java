/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.loader.DatabaseLoader;
import cz.startnet.utils.pgdiff.loader.FullAnalyze;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcLoader;
import cz.startnet.utils.pgdiff.loader.JdbcMsLoader;
import cz.startnet.utils.pgdiff.loader.LibraryLoader;
import cz.startnet.utils.pgdiff.loader.PgDumpLoader;
import cz.startnet.utils.pgdiff.loader.ProjectLoader;
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
import ru.taximaxim.codekeeper.apgdiff.model.difftree.IgnoreSchemaList;
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

    private static final Path META_PATH = Paths.get(System.getProperty("user.home"))
            .resolve(".pgcodekeeper-cli").resolve("dependencies");

    /**
     * Creates diff on the two database schemas.
     */
    public String createDiff() throws InterruptedException, IOException, PgCodekeeperException {
        PgDatabase oldDatabase = loadOldDatabaseWithLibraries();
        PgDatabase newDatabase = loadNewDatabaseWithLibraries();
        IgnoreList ignoreList =  new IgnoreList();
        IgnoreParser ignoreParser = new IgnoreParser(ignoreList);

        for (String listFilename : arguments.getIgnoreLists()) {
            ignoreParser.parse(Paths.get(listFilename));
        }

        return diffDatabaseSchemas(oldDatabase, newDatabase, ignoreList);
    }

    private void analyzeDatabase(PgDatabase db)
            throws InterruptedException, IOException, PgCodekeeperException {
        FullAnalyze.fullAnalyze(db, errors);
        assertErrors();
    }

    private void loadOverrides(PgDatabase db, String format, String source)
            throws InterruptedException, IOException, PgCodekeeperException {
        if (!"parsed".equals(format)) {
            return;
        }

        new ProjectLoader(source, arguments, errors).loadOverrides(db);
        assertErrors();
    }

    private void loadLibraries(PgDatabase db, Collection<String> libXmls,
            Collection<String> libs, Collection<String> libsWithoutPriv)
                    throws InterruptedException, IOException, PgCodekeeperException {
        LibraryLoader ll = new LibraryLoader(db, META_PATH, errors);

        for (String xml : libXmls) {
            ll.loadXml(new DependenciesXmlStore(Paths.get(xml)), arguments);
        }

        ll.loadLibraries(arguments, false, libs);
        ll.loadLibraries(arguments, true, libsWithoutPriv);
        assertErrors();
    }

    public PgDatabase loadNewDatabaseWithLibraries()
            throws IOException, InterruptedException, PgCodekeeperException {
        PgDatabase newDatabase = loadNewDatabase();

        loadLibraries(newDatabase, arguments.getTargetLibXmls(),
                arguments.getTargetLibs(), arguments.getTargetLibsWithoutPriv());

        List<PgOverride> overrides = newDatabase.getOverrides();
        if (arguments.isLibSafeMode() && !overrides.isEmpty()) {
            throw new LibraryObjectDuplicationException(overrides);
        }

        // read additional privileges from special folder
        loadOverrides(newDatabase, arguments.getNewSrcFormat(), arguments.getNewSrc());

        analyzeDatabase(newDatabase);

        return newDatabase;
    }

    public PgDatabase loadOldDatabaseWithLibraries()
            throws IOException, InterruptedException, PgCodekeeperException {
        PgDatabase oldDatabase = loadOldDatabase();

        loadLibraries(oldDatabase, arguments.getSourceLibXmls(),
                arguments.getSourceLibs(), arguments.getSourceLibsWithoutPriv());

        List<PgOverride> overrides = oldDatabase.getOverrides();
        if (arguments.isLibSafeMode() && !overrides.isEmpty()) {
            throw new LibraryObjectDuplicationException(overrides);
        }

        // read additional privileges from special folder
        loadOverrides(oldDatabase, arguments.getOldSrcFormat(), arguments.getOldSrc());

        analyzeDatabase(oldDatabase);

        return oldDatabase;
    }

    public PgDatabase loadNewDatabase() throws IOException, InterruptedException, PgCodekeeperException {
        PgDatabase db = loadDatabaseSchema(arguments.getNewSrcFormat(), arguments.getNewSrc());
        assertErrors();
        return db;
    }

    public PgDatabase loadOldDatabase() throws IOException, InterruptedException, PgCodekeeperException {
        PgDatabase db = loadDatabaseSchema(arguments.getOldSrcFormat(), arguments.getOldSrc());
        assertErrors();
        return db;
    }

    private void assertErrors() throws PgCodekeeperException {
        if (!errors.isEmpty() && !arguments.isIgnoreErrors()) {
            throw new PgCodekeeperException("Error while load database");
        }
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
        DatabaseLoader loader;
        IgnoreSchemaList ignoreSchemaList =  new IgnoreSchemaList();
        IgnoreParser ignoreParser = new IgnoreParser(ignoreSchemaList);
        if (arguments.getIgnoreSchemaList() != null) {
            ignoreParser.parse(Paths.get(arguments.getIgnoreSchemaList()));
        }
        if ("dump".equals(format)) {
            loader = new PgDumpLoader(Paths.get(srcPath), arguments);
        } else if ("parsed".equals(format)) {
            loader = new ProjectLoader(srcPath, arguments, null, errors, ignoreSchemaList);
        } else if ("db".equals(format)) {
            String timezone = arguments.getTimeZone() == null ? ApgdiffConsts.UTC : arguments.getTimeZone();
            if (arguments.isMsSql()) {
                loader = new JdbcMsLoader(JdbcConnector.fromUrl(srcPath, timezone), arguments, SubMonitor.convert(null), ignoreSchemaList);
            } else {
                loader = new JdbcLoader(JdbcConnector.fromUrl(srcPath, timezone), arguments, SubMonitor.convert(null), ignoreSchemaList);
            }
        } else {
            throw new UnsupportedOperationException(
                    MessageFormat.format(Messages.UnknownDBFormat, format));
        }

        try {
            return loader.load();
        } finally {
            errors.addAll(loader.getErrors());
        }
    }

    public String diffDatabaseSchemas(PgDatabase oldDbFull, PgDatabase newDbFull,
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
    public String diffDatabaseSchemasAdditionalDepcies(TreeElement root,
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

    private String diffDatabaseSchemasAdditionalDepcies(
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
        List<TreeElement> selected = getSelectedElements(root, ignoreList);
        createScript(depRes, selected, oldDbFull, newDbFull,
                additionalDepciesSource, additionalDepciesTarget);

        if (!depRes.getActions().isEmpty()) {
            script.addStatement("SET search_path = pg_catalog;");
        }
        new ActionsToScriptConverter(script, depRes.getActions(), arguments, oldDbFull, newDbFull)
        .fillScript(selected);
        if (arguments.isAddTransaction()) {
            script.addStatement("COMMIT TRANSACTION;");
        }

        return script.getText();
    }

    private String diffMsDatabaseSchemas(
            TreeElement root, PgDatabase oldDbFull, PgDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget,
            IgnoreList ignoreList) {
        PgDiffScript script = new PgDiffScript();

        if (arguments.isAddTransaction()) {
            script.addStatement("BEGIN TRANSACTION\nGO");
        }

        DepcyResolver depRes = new DepcyResolver(oldDbFull, newDbFull);
        List<TreeElement> selected = getSelectedElements(root, ignoreList);
        createScript(depRes, selected, oldDbFull, newDbFull,
                additionalDepciesSource, additionalDepciesTarget);

        new ActionsToScriptConverter(script, depRes.getActions(),
                depRes.getToRefresh(), arguments, oldDbFull, newDbFull).fillScript(selected);

        if (arguments.isAddTransaction()) {
            script.addStatement("COMMIT\nGO");
        }

        return script.getText();
    }

    private List<TreeElement> getSelectedElements(TreeElement root, IgnoreList ignoreList) {
        return new TreeFlattener()
                .onlySelected()
                .useIgnoreList(ignoreList)
                .onlyTypes(arguments.getAllowedTypes())
                .flatten(root);
    }

    private void createScript(DepcyResolver depRes, List<TreeElement> selected,
            PgDatabase oldDbFull, PgDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget) {
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
            if (el.getType() == DbObjType.TABLE && el.getSide() == DiffSide.BOTH) {
                AbstractTable oldTbl = (AbstractTable) el.getPgStatement(oldDbFull);
                AbstractTable newTbl = (AbstractTable) el.getPgStatement(newDbFull);
                DiffTree.addColumns(oldTbl.getColumns(), newTbl.getColumns(), el, tempColumns);
            }
        }
        selected.addAll(tempColumns);
    }
}
