/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.eclipse.core.runtime.SubMonitor;

import ru.taximaxim.codekeeper.core.ignoreparser.IgnoreParser;
import ru.taximaxim.codekeeper.core.loader.DatabaseLoader;
import ru.taximaxim.codekeeper.core.loader.FullAnalyze;
import ru.taximaxim.codekeeper.core.loader.JdbcChLoader;
import ru.taximaxim.codekeeper.core.loader.JdbcConnector;
import ru.taximaxim.codekeeper.core.loader.JdbcLoader;
import ru.taximaxim.codekeeper.core.loader.JdbcMsLoader;
import ru.taximaxim.codekeeper.core.loader.LibraryLoader;
import ru.taximaxim.codekeeper.core.loader.PgDumpLoader;
import ru.taximaxim.codekeeper.core.loader.ProjectLoader;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.CompareTree;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement.DiffSide;
import ru.taximaxim.codekeeper.core.model.difftree.TreeFlattener;
import ru.taximaxim.codekeeper.core.model.graph.ActionsToScriptConverter;
import ru.taximaxim.codekeeper.core.model.graph.DepcyResolver;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.LibraryObjectDuplicationException;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.PgOverride;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.xmlstore.DependenciesXmlStore;

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
        AbstractDatabase oldDatabase = loadOldDatabaseWithLibraries();
        AbstractDatabase newDatabase = loadNewDatabaseWithLibraries();
        IgnoreList ignoreList =  new IgnoreList();
        IgnoreParser ignoreParser = new IgnoreParser(ignoreList);

        for (String listFilename : arguments.getIgnoreLists()) {
            ignoreParser.parse(Paths.get(listFilename));
        }

        return diffDatabaseSchemas(oldDatabase, newDatabase, ignoreList);
    }

    private void analyzeDatabase(AbstractDatabase db)
            throws InterruptedException, IOException, PgCodekeeperException {
        FullAnalyze.fullAnalyze(db, errors);
        assertErrors();
    }

    private void loadOverrides(AbstractDatabase db, String format, String source)
            throws InterruptedException, IOException, PgCodekeeperException {
        if (!"parsed".equals(format)) {
            return;
        }

        new ProjectLoader(source, arguments, errors).loadOverrides(db);
        assertErrors();
    }

    private void loadLibraries(AbstractDatabase db, Collection<String> libXmls,
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

    public AbstractDatabase loadNewDatabaseWithLibraries()
            throws IOException, InterruptedException, PgCodekeeperException {
        AbstractDatabase newDatabase = loadNewDatabase();

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

    public AbstractDatabase loadOldDatabaseWithLibraries()
            throws IOException, InterruptedException, PgCodekeeperException {
        AbstractDatabase oldDatabase = loadOldDatabase();

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

    public AbstractDatabase loadNewDatabase() throws IOException, InterruptedException, PgCodekeeperException {
        AbstractDatabase db = loadDatabaseSchema(arguments.getNewSrcFormat(), arguments.getNewSrc());
        assertErrors();
        return db;
    }

    public AbstractDatabase loadOldDatabase() throws IOException, InterruptedException, PgCodekeeperException {
        AbstractDatabase db = loadDatabaseSchema(arguments.getOldSrcFormat(), arguments.getOldSrc());
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
    public AbstractDatabase loadDatabaseSchema(String format, String srcPath)
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
            String timezone = arguments.getTimeZone() == null ? Consts.UTC : arguments.getTimeZone();
            switch (arguments.getDbType()) {
            case MS:
                loader = new JdbcMsLoader(JdbcConnector.fromUrl(srcPath, timezone),
                        arguments, SubMonitor.convert(null), ignoreSchemaList);
                break;
            case PG:
                loader = new JdbcLoader(JdbcConnector.fromUrl(srcPath, timezone),
                        arguments, SubMonitor.convert(null), ignoreSchemaList);
                break;
            case CH:
                loader = new JdbcChLoader(JdbcConnector.fromUrl(srcPath, timezone),
                        arguments, SubMonitor.convert(null), ignoreSchemaList);
                break;
            default:
                throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + arguments.getDbType());
            }
        } else {
            throw new UnsupportedOperationException(MessageFormat.format(Messages.UnknownDBFormat, format));
        }

        try {
            return loader.load();
        } finally {
            errors.addAll(loader.getErrors());
        }
    }

    public String diffDatabaseSchemas(AbstractDatabase oldDbFull, AbstractDatabase newDbFull,
            IgnoreList ignoreList) throws InterruptedException, IOException {
        TreeElement root = DiffTree.create(oldDbFull, newDbFull);
        root.setAllChecked();

        switch (arguments.getDbType()) {
        case MS:
            return diffMsDatabaseSchemas(root, oldDbFull, newDbFull, null, null, ignoreList);
        case PG:
            return diffPgDatabaseSchemas(root, oldDbFull, newDbFull, null, null, ignoreList);
        case CH:
            return diffChDatabaseSchemas(root, oldDbFull, newDbFull, null, null, ignoreList);
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + arguments.getDbType());
        }
    }

    /**
     * Делает то же, что и метод выше, однако принимает TreeElement - как
     * элементы нужные для наката
     */
    public String diffDatabaseSchemasAdditionalDepcies(TreeElement root,
            AbstractDatabase oldDbFull, AbstractDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget) throws IOException {
        switch (arguments.getDbType()) {
        case MS:
            return diffMsDatabaseSchemas(root, oldDbFull, newDbFull,
                    additionalDepciesSource, additionalDepciesTarget, null);
        case PG:
            return diffPgDatabaseSchemas(root, oldDbFull, newDbFull,
                    additionalDepciesSource, additionalDepciesTarget, null);
        case CH:
            return diffChDatabaseSchemas(root, oldDbFull, newDbFull,
                    additionalDepciesSource, additionalDepciesTarget, null);
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + arguments.getDbType());
        }
    }

    private String diffPgDatabaseSchemas(
            TreeElement root, AbstractDatabase oldDbFull, AbstractDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget,
            IgnoreList ignoreList) throws IOException {
        PgDiffScript script = new PgDiffScript();

        for (String preFilePath : arguments.getPreFilePath()) {
            addPrePostPath(script, preFilePath);
        }

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

        for (String postFilePath : arguments.getPostFilePath()) {
            addPrePostPath(script, postFilePath);
        }
        return script.getText();
    }

    private void addPrePostPath(PgDiffScript script, String scriptPath) throws IOException {
        Path path = Paths.get(scriptPath);
        addPrePostPath(script, path);
    }

    private void addPrePostPath(PgDiffScript script, Path path) throws IOException {
        if (Files.isRegularFile(path)) {
            addPrePostScript(script, path);
            return;
        }
        Stream<Path> stream = Files.list(path).sorted();
        for (Path child : PgDiffUtils.sIter(stream)) {
            addPrePostPath(script, child);
        }
    }

    private void addPrePostScript(PgDiffScript script, Path fileName) throws IOException {
        try {
            String prePostScript = new String(Files.readAllBytes(fileName), StandardCharsets.UTF_8);
            prePostScript = "-- " + fileName + "\n\n" + prePostScript;
            script.addStatement(prePostScript);
        } catch (IOException e) {
            throw new IOException(Messages.PgDiff_read_error + e.getLocalizedMessage(), e);
        }
    }

    private String diffMsDatabaseSchemas(
            TreeElement root, AbstractDatabase oldDbFull, AbstractDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget,
            IgnoreList ignoreList) {
        PgDiffScript script = new PgDiffScript();

        if (arguments.isAddTransaction()) {
            script.addStatement("BEGIN TRANSACTION\nGO");
        }

        DepcyResolver depRes = new DepcyResolver(oldDbFull, newDbFull);
        List<TreeElement> selected = getSelectedElements(root, ignoreList);
        createScript(depRes, selected, oldDbFull, newDbFull, additionalDepciesSource, additionalDepciesTarget);

        new ActionsToScriptConverter(script, depRes.getActions(), depRes.getToRefresh(),
                arguments, oldDbFull, newDbFull).fillScript(selected);

        if (arguments.isAddTransaction()) {
            script.addStatement("COMMIT\nGO");
        }

        return script.getText();
    }

    private String diffChDatabaseSchemas(
            TreeElement root, AbstractDatabase oldDbFull, AbstractDatabase newDbFull,
            List<Entry<PgStatement, PgStatement>> additionalDepciesSource,
            List<Entry<PgStatement, PgStatement>> additionalDepciesTarget,
            IgnoreList ignoreList) {
        PgDiffScript script = new PgDiffScript();

        DepcyResolver depRes = new DepcyResolver(oldDbFull, newDbFull);
        List<TreeElement> selected = getSelectedElements(root, ignoreList);
        createScript(depRes, selected, oldDbFull, newDbFull,
                additionalDepciesSource, additionalDepciesTarget);

        new ActionsToScriptConverter(script, depRes.getActions(), arguments, oldDbFull, newDbFull).fillScript(selected);

        return script.getText();
    }

    protected List<TreeElement> getSelectedElements(TreeElement root, IgnoreList ignoreList) {
        return new TreeFlattener()
                .onlySelected()
                .useIgnoreList(ignoreList)
                .onlyTypes(arguments.getAllowedTypes())
                .flatten(root);
    }

    private void createScript(DepcyResolver depRes, List<TreeElement> selected,
            AbstractDatabase oldDbFull, AbstractDatabase newDbFull,
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
        depRes.removeExtraActions();
    }

    /**
     * После реализации колонок как подэлементов таблицы выпилить метод!
     */
    @Deprecated
    private void addColumnsAsElements(AbstractDatabase oldDbFull, AbstractDatabase newDbFull,
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
