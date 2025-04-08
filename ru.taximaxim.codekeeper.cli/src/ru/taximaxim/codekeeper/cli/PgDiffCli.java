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
import java.nio.file.Paths;
import java.util.List;

import ru.taximaxim.codekeeper.core.PgCodekeeperException;
import ru.taximaxim.codekeeper.core.PgDiff;
import ru.taximaxim.codekeeper.core.fileutils.ProjectUpdater;
import ru.taximaxim.codekeeper.core.ignoreparser.IgnoreParser;
import ru.taximaxim.codekeeper.core.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.core.model.difftree.IgnoreList;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.model.exporter.ModelExporter;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.settings.CliSettings;

public final class PgDiffCli extends PgDiff {

    private final CliArgs arguments;

    public PgDiffCli(CliArgs arguments) {
        super(new CliSettings(arguments));
        this.arguments = arguments;
    }

    public void updateProject()
            throws IOException, InterruptedException, PgCodekeeperException {

        AbstractDatabase oldDatabase = loadOldDatabaseWithLibraries(arguments);
        AbstractDatabase newDatabase = loadNewDatabaseWithLibraries(arguments);
        IgnoreList ignoreList = getIgnoreList();
        TreeElement root = DiffTree.create(oldDatabase, newDatabase, null);
        root.setAllChecked();

        List<TreeElement> selected = getSelectedElements(root, ignoreList);

        new ProjectUpdater(newDatabase, oldDatabase, selected, arguments.getDbType(),
                arguments.getOutCharsetName(), Paths.get(arguments.getOutputTarget()),
                false, getSettings()).updatePartial();
    }

    public void exportProject() throws IOException, InterruptedException, PgCodekeeperException {
        AbstractDatabase newDb = loadNewDatabase(arguments);
        TreeElement root = DiffTree.create(newDb, null, null);
        root.setAllChecked();

        IgnoreList ignoreList = getIgnoreList();
        List<TreeElement> selected = getSelectedElements(root, ignoreList);
        new ModelExporter(Paths.get(arguments.getOutputTarget()), newDb, null,
                arguments.getDbType(), selected, arguments.getOutCharsetName(), getSettings()).exportProject();
    }

    private IgnoreList getIgnoreList() throws IOException {
        IgnoreList ignoreList = new IgnoreList();
        IgnoreParser ignoreParser = new IgnoreParser(ignoreList);
        for (String listFilename : arguments.getIgnoreLists()) {
            ignoreParser.parse(Paths.get(listFilename));
        }
        return ignoreList;
    }
}
