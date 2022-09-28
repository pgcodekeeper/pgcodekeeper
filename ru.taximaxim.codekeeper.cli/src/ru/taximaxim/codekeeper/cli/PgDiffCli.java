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

        new ProjectUpdater(newDatabase, oldDatabase, selected, arguments.isMsSql(),
                arguments.getOutCharsetName(), Paths.get(arguments.getOutputTarget()),
                false).updatePartial();
    }

}
