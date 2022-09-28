package ru.taximaxim.codekeeper.core.depcies;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.FILES_POSTFIX;
import ru.taximaxim.codekeeper.core.PgDiff;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.log.Log;
import ru.taximaxim.codekeeper.core.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.core.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;

/**
 * Тестирует сравнение БД с неполным выбором различающихся объектов
 * @author botov_av
 */
@RunWith(value = Parameterized.class)
public class MsDiffDepciesTest {

    @Parameters
    public static Iterable<Object[]> parameters() {
        return TestUtils.getParameters(new Object[][] {
            {"empty_usr"},
            // f1 <- f2
            // added: f1, f2
            // user: f2
            {"add_ms_func_exec_usr_f2", true},
            // p1 <- f2
            // added: p1, f2
            // user: f2
            {"add_ms_proc_exec_usr_f2", true},
            // f1 <- f2 <- f3
            // changed: f1, f2, f3
            // user: f2
            {"change_ms_func_arg_usr_f2", true},
            // t1 <- v1 <- v2 <- v3 <- v4
            // changed: t1, v1, v2, v4
            // user: t1
            {"change_ms_table_usr_t1" }
        });
    }

    /**
     * Template name for file names that should be used for the test. Testing
     * method adds _original.sql and _new.sql to the file name
     * template.
     */
    private final String dbTemplate;
    /**
     * Шаблон для выбора пользователя, содержит часть БД, выбранную пользователем
     * _original.sql, _new.sql and _diff.sql to the file name
     */
    private final String userSelTemplate;

    private final PgDiffArguments args = new PgDiffArguments();

    public MsDiffDepciesTest(final String userSelTemplate, Boolean isEnableDepcies) {
        this.dbTemplate = userSelTemplate.replaceAll("_usr.*", "");
        this.userSelTemplate = userSelTemplate;
        args.setMsSql(true);
        if (isEnableDepcies != null) {
            args.setEnableFunctionBodiesDependencies(isEnableDepcies);
        }
        Log.log(Log.LOG_DEBUG, dbTemplate + ' ' + userSelTemplate);
    }

    @Test(timeout = 120000)
    public void runDiff() throws IOException, InterruptedException {
        PgDatabase oldDatabase = TestUtils.loadTestDump(
                getUsrSelName(FILES_POSTFIX.ORIGINAL_SQL), MsDiffDepciesTest.class, args);
        PgDatabase newDatabase = TestUtils.loadTestDump(
                getUsrSelName(FILES_POSTFIX.NEW_SQL), MsDiffDepciesTest.class, args);
        PgDatabase oldDbFull;
        PgDatabase newDbFull;
        if (userSelTemplate.equals(dbTemplate)) {
            oldDbFull = oldDatabase;
            newDbFull = newDatabase;
        } else {
            oldDbFull = TestUtils.loadTestDump(
                    getDbName(FILES_POSTFIX.ORIGINAL_SQL), MsDiffDepciesTest.class, args);
            newDbFull = TestUtils.loadTestDump(
                    getDbName(FILES_POSTFIX.NEW_SQL), MsDiffDepciesTest.class, args);
        }

        TestUtils.runDiffSame(oldDbFull, dbTemplate, args);
        TestUtils.runDiffSame(newDbFull, dbTemplate, args);

        TreeElement tree = DiffTree.create(oldDatabase, newDatabase, null);
        tree.setAllChecked();
        String script = new PgDiff(args).diffDatabaseSchemasAdditionalDepcies(
                tree, oldDbFull, newDbFull, null, null);

        TestUtils.compareResult(script, userSelTemplate, MsDiffDepciesTest.class);
    }

    private String getUsrSelName(FILES_POSTFIX postfix) {
        return userSelTemplate + postfix;
    }

    private String getDbName(FILES_POSTFIX postfix) {
        return dbTemplate + postfix;
    }
}
