/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

public class PgDiffCli extends PgDiff {

    private final CliArgs arguments;

    public PgDiffCli(CliArgs arguments) {
        super(arguments);
        this.arguments = arguments;
    }

    public void updateProject()
            throws IOException, InterruptedException, PgCodekeeperException {

        PgDatabase oldDatabase = loadOldDatabaseWithLibraries();
        PgDatabase newDatabase = loadNewDatabaseWithLibraries();
        IgnoreList ignoreList = new IgnoreList();
        IgnoreParser ignoreParser = new IgnoreParser(ignoreList);
        for (String listFilename : arguments.getIgnoreLists()) {
            ignoreParser.parse(Paths.get(listFilename));
        }
        TreeElement root = DiffTree.create(oldDatabase, newDatabase, null);
        root.setAllChecked();

        List<TreeElement> selected = getSelectedElements(root, ignoreList);

        new ProjectUpdater(newDatabase, oldDatabase, selected, arguments.getDbType(),
                arguments.getOutCharsetName(), Paths.get(arguments.getOutputTarget()),
                false).updatePartial();
    }

}
