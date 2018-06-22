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

import cz.startnet.utils.pgdiff.FILES_POSTFIX;
import cz.startnet.utils.pgdiff.PgDiff;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffTestUtils;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.UnixPrintWriter;
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
            // изменяется тип колонки, пользователь выбирает таблицу
            {"trig_upd_col","trig_upd_col__usr_tbl"},
            // удаляется исходная таблица, пользователь выбрал на удаление t1
            {"table_inherits_del_t1", "table_inherits_del_t1_usr_t1"},
            // удаляется исходная таблица, пользователь выбрал t2
            // TODO здесь не нужно создавать колонку, она создастся путем удаления
            // наследования
            {"table_inherits_del_t1", "table_inherits_del_t1_usr_t2"},
            // Таблица перестает наследовать,
            // TODO здесь ошибка не должно
            // быть добавления колонки исправится правильной реализацией
            // inherits
            {"table_inherits", "table_inherits_usr_t2"},
            // меняеются колонки в наследующей таблице и добавляется
            // сиквенс, пользователь выбра таблицу
            // TODO если в этом тесте удалить из исходной базы seq1,
            // то он не появится в скрипте, потому, что нет связи от
            // сиквенса к таблице по кр мере со стороны парсера
            {"inherit_table", "inherit_table_usr"},
            // колонка меняет тип на новый, пользователь выбрал только тип
            {"chg_col_type", "chg_col_type_usr_dom2"},
            // колонка меняет тип на новый, пользователь выбрал только таблицу
            {"chg_col_type", "chg_col_type_usr_t1"},
            // колонка меняет тип на новый, пользователь выбрал таблицу и тип
            {"chg_col_type", "chg_col_type_usr_all"},
            // Удаляется индекс и внешний ключ, пользователь выбрал индекс
            {"drop_index", "drop_index_usr_ind"},
            // тип изменяется как альтер, пользователь выбрал его
            {"alter_type", "alter_type_usr"},
            // тип изменяется через drop create, пользователь выбирает его
            {"drop_type", "drop_type_usr"},
            // удаляется таблица с содержимым индексом и триггером,
            // пользователь выбрал только таблицу
            {"drop_tbl", "drop_tbl_usr_tbl"},
            // к таблице добавляется триггер и функция,
            // пользователь выбрал только функцию
            {"add_table_and_trigger", "add_table_and_trigger_usr_function"},
            // к таблице добавляется триггер и функция,
            // пользователь выбрал только триггер
            {"add_table_and_trigger", "add_table_and_trigger_usr_trigger"},
            // к таблице добавляется триггер и функция,
            // пользователь выбрал все
            {"add_table_and_trigger", "add_table_and_trigger"},
            // перенос объектов из одной схемы в другую,
            // пользователь выбрал все объекты
            // TODO ошибки при частичном выборе, к примеру при выборе таблицы не подтягивается
            // тип и последовательность, исправляется переработкой алгоритма работой с колонками
            {"move_obj_to_schema", "move_obj_to_schema"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал таблицу t1
            {"change_view","change_view_usr_t1"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал таблицу t2
            {"change_view","change_view_usr_t2"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал таблицу t3
            {"change_view","change_view_usr_t3"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v2
            {"change_view","change_view_usr_v2"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v3
            {"change_view","change_view_usr_v3"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v4
            {"change_view","change_view_usr_v4"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v5
            {"change_view","change_view_usr_v5"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v6
            {"change_view","change_view_usr_v6"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v8
            {"change_view","change_view_usr_v8"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v8 и таблицу t1
            // задача 6049
            {"change_view","change_view_usr_v8_t1"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал все объекты
            {"change_view","change_view"},
            // пересоздание вьюхи с комментарием
            // пользователь выбрал таблицу
            // задача 7095
            {"chg_view_with_comment", "chg_view_with_comment_usr_table"}
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

    public void runDiffSame(PgDatabase db) throws IOException, InterruptedException {
        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        final PgDiffArguments arguments = new PgDiffArguments();
        PgDiff.diffDatabaseSchemas(writer, arguments, db, db, null);
        writer.flush();

        Assert.assertEquals("File name template: " + dbTemplate,
                PgDiff.SET_SEARCH_PATH_PG_CATALOG, diffInput.toString().trim());
    }

    @Test(timeout = 120000)
    public void runDiff() throws IOException, InterruptedException {

        final ByteArrayOutputStream diffInput = new ByteArrayOutputStream();
        final PrintWriter writer = new UnixPrintWriter(diffInput, true);
        final PgDiffArguments args = new PgDiffArguments();
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

        TreeElement tree = DiffTree.create(oldDatabase, newDatabase, null);
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
