package cz.startnet.utils.pgdiff.depcies;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cz.startnet.utils.pgdiff.FILES_POSTFIX;
import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.log.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;

/**
 * Тестирует сравнение БД с неполным выбором различающихся объектов
 * @author botov_av
 */
@RunWith(value = Parameterized.class)
public class MsDiffDepciesTest {

    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(new Object[][] {
            {"empty_usr"},
            // создаются две функции f1 и f2, в f2 через 'EXECUTE' вызвается f1,
            // пользователь выбирает функцию f2
            {"add_ms_func_exec_usr_f2"},
            // создаются процедура p1 и функция f2, в f2 через 'EXECUTE' вызвается p1,
            // пользователь выбирает функцию f2
            {"add_ms_proc_exec_usr_f2"},
            // t1 <- v1 <- v2 <- v3 <- v4
            // изменяются t1, v1, v2, v4
            // пользователь выбирает t1
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

    public MsDiffDepciesTest(final String userSelTemplate) {
        this.dbTemplate = userSelTemplate.replaceAll("_usr.*", "");
        this.userSelTemplate = userSelTemplate;
        Log.log(Log.LOG_DEBUG, dbTemplate + ' ' + userSelTemplate);
    }

    @Test(timeout = 120000)
    public void runDiff() throws IOException, InterruptedException {
        final PgDiffArguments args = new PgDiffArguments();
        args.setMsSql(true);
        PgDatabase oldDatabase = ApgdiffTestUtils.loadTestDump(
                getUsrSelName(FILES_POSTFIX.ORIGINAL_SQL), MsDiffDepciesTest.class, args);
        PgDatabase newDatabase = ApgdiffTestUtils.loadTestDump(
                getUsrSelName(FILES_POSTFIX.NEW_SQL), MsDiffDepciesTest.class, args);
        PgDatabase oldDbFull;
        PgDatabase newDbFull;
        if (userSelTemplate.equals(dbTemplate)) {
            oldDbFull = oldDatabase;
            newDbFull = newDatabase;
        } else {
            oldDbFull = ApgdiffTestUtils.loadTestDump(
                    getDbName(FILES_POSTFIX.ORIGINAL_SQL), MsDiffDepciesTest.class, args);
            newDbFull = ApgdiffTestUtils.loadTestDump(
                    getDbName(FILES_POSTFIX.NEW_SQL), MsDiffDepciesTest.class, args);
        }

        ApgdiffTestUtils.runDiffSame(oldDbFull, dbTemplate, args);
        ApgdiffTestUtils.runDiffSame(newDbFull, dbTemplate, args);

        TreeElement tree = DiffTree.create(oldDatabase, newDatabase, null);
        tree.setAllChecked();
        String script = new PgDiff(args).diffDatabaseSchemasAdditionalDepcies(
                tree, oldDbFull, newDbFull, null, null);

        ApgdiffTestUtils.compareResult(script, userSelTemplate, MsDiffDepciesTest.class);
    }

    private String getUsrSelName(FILES_POSTFIX postfix) {
        return userSelTemplate + postfix;
    }

    private String getDbName(FILES_POSTFIX postfix) {
        return dbTemplate + postfix;
    }
}
