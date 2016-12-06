package cz.startnet.utils.pgdiff.depcies;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.TEST.FILES_POSTFIX;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;

/**
 * Тестирует сравнение БД с неполным выбором различающихся объектов
 * @author botov_av
 */
@RunWith(value = Parameterized.class)
public class PgDiffDepciesTest {

    @Parameters
    public static Collection<?> parameters() {
        return Arrays.asList(new Object[][] {
            { "empty", "empty_usr" },
            // изменяется тип колонок у обоих таблиц, пользователь выбирает
            // view v1
            { "add_change_col_type", "add_change_col_type_usr_v1" },
            // --\\-- , пользователь выбирает t1.c1
            { "add_change_col_type", "add_change_col_type_usr_t1_c1" },
            // --\\--, у вью меняется только комментарий
            { "add_change_only_col_type", "add_change_only_col_type_usr_t1_c1" },
            // изменяется тип колонок у обоих таблиц, изменяется v1, пользователь выбирает
            // view v2
            {"add_v2_change_col_type", "add_v2_change_col_type_usr_v2"},
            // долгий тест накатывает перемещение объектов из одной
            // схемы в другую, пользователь выбирает все измененные
            // объекты для наката
            {"move_object_between_schemas", "move_object_between_schemas"},
            // тестирует накат только измененных колонок, пользователь выбирает таблицу
            {"multi_alter_table", "multi_alter_table_usr_t_house"},
            // пользователь выбирает только v_house
            {"multi_alter_table", "multi_alter_table_usr_v_house"},
            // пользователь выбирает только v_house_w
            {"multi_alter_table", "multi_alter_table_usr_v_house_w"},
            // пользователь выбирает только функцию update_house_reached
            {"multi_alter_table", "multi_alter_table_usr_func"},
            // пользователь выбрал: функцию update_house_reached, v_house, v_house_w, t_house
            {"multi_alter_table", "multi_alter_table_usr_all"},
            // накат триггера и функции из разных схем, пользователь выбрал только функцию
            {"trigger_before_insert", "trigger_before_insert_usr_funct"},
            // пользователь выбрал только триггер
            {"trigger_before_insert", "trigger_before_insert_usr_trig"},
            // пользователь выбрал триггер и функцию
            {"trigger_before_insert", "trigger_before_insert_usr_all"},
            // изменяется тип колонки, пользователь выбирает таблицу
            {"trig_upd_col","trig_upd_col__usr_tbl"},
            // задача из редмайна по номеру, пользователь выбирает все объекты
            {"err6049", "err6049"},
            {"err7095", "err7095"},
            // удаляется исходная таблица, пользователь выбрал на удаление t1
            {"table_inherits_del_t1", "table_inherits_del_t1_usr_t1"},
            // удаляется исходная таблица, пользователь выбрал t2
            // TODO здесь не нужно создавать колонку, она путем удаления
            // наследования создастся
            {"table_inherits_del_t1", "table_inherits_del_t1_usr_t2"},
            // Таблица перестает наследовать,
            // TODO здесь ошибка не должно
            // быть добавления колонки исправится правильной реализацией
            // inherits
            {"table_inherits", "table_inherits_usr_t2"},
            // меняеются колонки в наследующей таблице и добавляется
            // сиквенс, пользователь выбра таблицу
            // TODO если в этом тесте удалить из исходной базы seq1,
            // то он не появится в скрипте, потому, что нет свзяи от
            // сиквенса к таблице по кр мере со стороны парсера
            {"inherit_table", "inherit_table_usr"},
            // колонка меняет тип на новый, пользователь выбрал только тип
            {"chg_col_type", "chg_col_type_usr_dom2"},
            // колонка меняет тип на новый, пользователь выбрал только таблицу
            {"chg_col_type", "chg_col_type_usr_t1"},
            // колонка меняет тип на новый, пользователь выбрал таблицу и тип
            {"chg_col_type", "chg_col_type_usr_all"},
            // тип изменяется как альтер, пользователь выбрал его
            {"alter_type", "alter_type_usr"},
            // тип изменяется через drop create, пользователь выбирает его
            {"drop_type", "drop_type_usr"},
            // удаляется таблица с содержимым индексом и триггером,
            // пользователь выбрал только таблицу
            {"drop_tbl", "drop_tbl_usr_tbl"},
            // выбраны все объекты сложное вью with запросом, также с coalesce
            {"compl_view", "compl_view"}
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

    public PgDiffDepciesTest(final String fileNameTemplate,
            final String userSelTemplate) {
        this.dbTemplate = fileNameTemplate;
        this.userSelTemplate = userSelTemplate;
        Locale.setDefault(Locale.ENGLISH);
        Log.log(Log.LOG_DEBUG, dbTemplate + ' ' + userSelTemplate);
    }

    public void runDiffSame(PgDatabase db) throws IOException {
        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        final PgDiffArguments arguments = new PgDiffArguments();
        PgDiff.diffDatabaseSchemas(writer, arguments, db, db, null);
        writer.flush();

        Assert.assertEquals("File name template: " + dbTemplate,
                "", diffInput.toString().trim());
    }

    @Test(timeout = 120000)
    public void runDiff() throws IOException, InterruptedException, LicenseException {

        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        final PgDiffArguments args = ApgdiffTestUtils.getArgsLicensed();
        PgDatabase oldDatabase = ApgdiffTestUtils.loadTestDump(
                getUsrSelName(FILES_POSTFIX.ORIGINAL_SQL), PgDiffDepciesTest.class, args);
        PgDatabase newDatabase = ApgdiffTestUtils.loadTestDump(
                getUsrSelName(FILES_POSTFIX.NEW_SQL), PgDiffDepciesTest.class, args);
        PgDatabase oldDbFull, newDbFull;
        if (userSelTemplate.equals(dbTemplate)) {
            oldDbFull = oldDatabase;
            newDbFull = newDatabase;
        } else {
            oldDbFull = ApgdiffTestUtils.loadTestDump(
                    getDbName(FILES_POSTFIX.ORIGINAL_SQL), PgDiffDepciesTest.class, args);
            newDbFull = ApgdiffTestUtils.loadTestDump(
                    getDbName(FILES_POSTFIX.NEW_SQL), PgDiffDepciesTest.class, args);
        }

        runDiffSame(oldDbFull);
        runDiffSame(newDbFull);

        TreeElement tree = DiffTree.create(oldDatabase, newDatabase);
        tree.setAllChecked();
        PgDiff.diffDatabaseSchemasAdditionalDepcies(writer, args,
                tree, oldDbFull, newDbFull, null, null);
        writer.flush();

        StringBuilder sbExpDiff;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                PgDiffDepciesTest.class.getResourceAsStream(getUsrSelName(FILES_POSTFIX.DIFF_SQL))))) {
            sbExpDiff = new StringBuilder(1024);

            String line;
            while ((line = reader.readLine()) != null) {
                sbExpDiff.append(line);
                sbExpDiff.append('\n');
            }
        }

        Assert.assertEquals("File name template: " + userSelTemplate,
                sbExpDiff.toString().trim(),
                diffInput.toString().trim());
    }

    private String getUsrSelName(FILES_POSTFIX postfix) {
        return userSelTemplate + postfix;
    }

    private String getDbName(FILES_POSTFIX postfix) {
        return dbTemplate + postfix;
    }
}
