/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
 *******************************************************************************/
package ru.taximaxim.codekeeper.cli;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.List;

import ru.taximaxim.codekeeper.cli.localizations.Messages;
import ru.taximaxim.codekeeper.core.PgCodekeeperException;
import ru.taximaxim.codekeeper.core.PgDiff;
import ru.taximaxim.codekeeper.core.SourceFormat;
import ru.taximaxim.codekeeper.core.ignoreparser.IgnoreParser;
import ru.taximaxim.codekeeper.core.loader.DatabaseLoader;
import ru.taximaxim.codekeeper.core.loader.FullAnalyze;
import ru.taximaxim.codekeeper.core.loader.LibraryLoader;
import ru.taximaxim.codekeeper.core.loader.LoaderFactory;
import ru.taximaxim.codekeeper.core.loader.PgDumpLoader;
import ru.taximaxim.codekeeper.core.loader.ProjectLoader;
import ru.taximaxim.codekeeper.core.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreSchemaList;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.PgOverride;
import ru.taximaxim.codekeeper.core.utils.ProjectUpdater;
import ru.taximaxim.codekeeper.core.xmlstore.DependenciesXmlStore;

public final class PgDiffCli extends PgDiff {

    private static final Path META_PATH = Paths
            .get(System.getProperty("user.home"), ".pgcodekeeper-cli", "dependencies"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//            .resolve(".pgcodekeeper-cli").resolve("dependencies"); //$NON-NLS-1$ //$NON-NLS-2$

    private final CliArgs arguments;

    public PgDiffCli(CliArgs arguments) {
        super(arguments);
        this.arguments = arguments;
    }

    public void updateProject()
            throws IOException, InterruptedException, PgCodekeeperException {

        AbstractDatabase oldDatabase = loadOldDatabaseWithLibraries();
        AbstractDatabase newDatabase = loadNewDatabaseWithLibraries();
        IgnoreList ignoreList = getIgnoreList();
        TreeElement root = DiffTree.create(oldDatabase, newDatabase, null);
        root.setAllChecked();

        List<TreeElement> selected = getSelectedElements(root, ignoreList);

        new ProjectUpdater(newDatabase, oldDatabase, selected, arguments.getDbType(),
                arguments.getOutCharsetName(), Paths.get(arguments.getOutputTarget()),
                false, settings).updatePartial();
    }

    public void exportProject() throws IOException, InterruptedException, PgCodekeeperException {
        AbstractDatabase newDb = loadNewDatabase();
        TreeElement root = DiffTree.create(newDb, null, null);
        root.setAllChecked();

        IgnoreList ignoreList = getIgnoreList();
        List<TreeElement> selected = getSelectedElements(root, ignoreList);
        new ModelExporter(Paths.get(arguments.getOutputTarget()), newDb, null,
                arguments.getDbType(), selected, arguments.getOutCharsetName(), settings).exportProject();
    }

    private IgnoreList getIgnoreList() throws IOException {
        IgnoreList ignoreList = new IgnoreList();
        IgnoreParser ignoreParser = new IgnoreParser(ignoreList);
        for (String listFilename : arguments.getIgnoreLists()) {
            ignoreParser.parse(Paths.get(listFilename));
        }
        return ignoreList;
    }

    public String createDiff() throws InterruptedException, IOException, PgCodekeeperException {
        AbstractDatabase oldDatabase = loadOldDatabaseWithLibraries();
        AbstractDatabase newDatabase = loadNewDatabaseWithLibraries();
        IgnoreList ignoreList = new IgnoreList();
        IgnoreParser ignoreParser = new IgnoreParser(ignoreList);

        for (String listFilename : arguments.getIgnoreLists()) {
            ignoreParser.parse(Paths.get(listFilename));
        }

        return diff(oldDatabase, newDatabase, ignoreList);
    }

    public AbstractDatabase loadNewDatabaseWithLibraries()
            throws IOException, InterruptedException, PgCodekeeperException {
        LOG.info(Messages.PgDiffCli_log_load_new_db);
        AbstractDatabase newDatabase = loadNewDatabase();
        LOG.info(Messages.PgDiffCli_log_load_new_db_lib);
        loadLibraries(newDatabase, arguments.getTargetLibXmls(), arguments.getTargetLibs(),
                arguments.getTargetLibsWithoutPriv());

        List<PgOverride> overrides = newDatabase.getOverrides();
        if (arguments.isLibSafeMode() && !overrides.isEmpty()) {
            LOG.error(Messages.PgDiffCli_log_lib_have_dupl);
            throw new LibraryObjectDuplicationException(overrides);
        }

        // read additional privileges from special folder
        LOG.info(Messages.PgDiffCli_log_load_new_db_overrides);
        loadOverrides(newDatabase, arguments.getNewSrcFormat(), arguments.getNewSrc());

        LOG.info(Messages.PgDiffCli_log_start_db_analyze);
        analyzeDatabase(newDatabase);

        return newDatabase;
    }

    public AbstractDatabase loadOldDatabaseWithLibraries()
            throws IOException, InterruptedException, PgCodekeeperException {
        LOG.info(Messages.PgDiffCli_log_load_old_db);
        AbstractDatabase oldDatabase = loadOldDatabase();

        LOG.info(Messages.PgDiffCli_log_load_old_db_lib);
        loadLibraries(oldDatabase, arguments.getSourceLibXmls(), arguments.getSourceLibs(),
                arguments.getSourceLibsWithoutPriv());

        List<PgOverride> overrides = oldDatabase.getOverrides();
        if (arguments.isLibSafeMode() && !overrides.isEmpty()) {
            LOG.error(Messages.PgDiffCli_log_lib_have_dupl);
            throw new LibraryObjectDuplicationException(overrides);
        }
        LOG.info(Messages.PgDiffCli_log_load_old_db_overrides);
        // read additional privileges from special folder
        loadOverrides(oldDatabase, arguments.getOldSrcFormat(), arguments.getOldSrc());

        LOG.info(Messages.PgDiffCli_log_start_db_analyze);
        analyzeDatabase(oldDatabase);

        return oldDatabase;
    }

    private void analyzeDatabase(AbstractDatabase db)
            throws InterruptedException, IOException, PgCodekeeperException {
        FullAnalyze.fullAnalyze(db, errors);
        assertErrors();
    }

    private void loadOverrides(AbstractDatabase db, SourceFormat format, String source)
            throws InterruptedException, IOException, PgCodekeeperException {
        if (SourceFormat.PARSED != format) {
            return;
        }

        new ProjectLoader(source, settings, errors).loadOverrides(db);
        assertErrors();
    }

    private void loadLibraries(AbstractDatabase db, Collection<String> libXmls, Collection<String> libs,
            Collection<String> libsWithoutPriv)
            throws InterruptedException, IOException, PgCodekeeperException {
        LibraryLoader ll = new LibraryLoader(db, META_PATH, errors);

        for (String xml : libXmls) {
            ll.loadXml(new DependenciesXmlStore(Paths.get(xml)), settings);
        }

        ll.loadLibraries(settings, false, libs);
        ll.loadLibraries(settings, true, libsWithoutPriv);
        assertErrors();
    }

    private AbstractDatabase loadNewDatabase()
            throws IOException, InterruptedException, PgCodekeeperException {
        AbstractDatabase db = loadDatabaseSchema(arguments.getNewSrcFormat(), arguments.getNewSrc());
        assertErrors();
        return db;
    }

    private AbstractDatabase loadOldDatabase()
            throws IOException, InterruptedException, PgCodekeeperException {
        AbstractDatabase db = loadDatabaseSchema(arguments.getOldSrcFormat(), arguments.getOldSrc());
        assertErrors();
        return db;
    }

    /**
     * Loads database schema choosing the provided method.
     *
     * @param format  format of the database source, must be "dump", "parsed" or
     *                "db" otherwise exception is thrown
     * @param srcPath path to the database source to load
     *
     * @return the loaded database
     */
    private AbstractDatabase loadDatabaseSchema(SourceFormat format, String srcPath)
            throws InterruptedException, IOException {
        LOG.info(Messages.PgDiffCli_log_load_ignored_schemas);
        IgnoreSchemaList ignoreSchemaList = new IgnoreSchemaList();
        IgnoreParser ignoreParser = new IgnoreParser(ignoreSchemaList);
        if (arguments.getIgnoreSchemaList() != null) {
            ignoreParser.parse(Paths.get(arguments.getIgnoreSchemaList()));
        }
        DatabaseLoader loader = switch (format) {
        case DB -> LoaderFactory.createJdbcLoader(settings, srcPath, ignoreSchemaList);
        case DUMP -> new PgDumpLoader(Paths.get(srcPath), settings);
        case PARSED -> new ProjectLoader(srcPath, settings, null, errors, ignoreSchemaList);
        default -> throw new UnsupportedOperationException(MessageFormat.format(Messages.UnknownDBFormat, format));
        };

        try {
            return loader.load();
        } finally {
            errors.addAll(loader.getErrors());
        }
    }

    private void assertErrors() throws PgCodekeeperException {
        if (!errors.isEmpty() && !arguments.isIgnoreErrors()) {
            throw new PgCodekeeperException("Error while load database"); //$NON-NLS-1$
        }
    }
}
