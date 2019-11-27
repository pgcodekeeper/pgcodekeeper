package cz.startnet.utils.pgdiff.depcies;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
public class PgDiffDepciesTest {

    @Parameters
    public static Iterable<Object[]> parameters() {
        List<Object[]> p = Arrays.asList(new Object[][] {
            {"empty_usr"},
            // изменяется тип колонок у обоих таблиц, пользователь выбирает
            // view v1
            {"add_change_col_type_usr_v1"},
            // --\\-- , пользователь выбирает t1.c1
            {"add_change_col_type_usr_t1_c1"},
            // --\\--, у вью меняется только комментарий
            {"add_change_only_col_type_usr_t1_c1"},
            // изменяется тип колонок у обоих таблиц, изменяется v1, пользователь выбирает
            // view v2
            {"add_v2_change_col_type_usr_v2"},
            // изменяется тип колонки, пользователь выбирает таблицу
            {"trig_upd_col_usr_tbl"},
            // удаляется исходная таблица, пользователь выбрал на удаление t1
            {"table_inherits_del_t1_usr_t1"},
            // удаляется исходная таблица, пользователь выбрал t2
            // TODO здесь не нужно создавать колонку, она создастся путем удаления
            // наследования
            {"table_inherits_del_t1_usr_t2"},
            // Таблица перестает наследовать,
            // TODO здесь ошибка не должно
            // быть добавления колонки исправится правильной реализацией
            // inherits
            {"table_inherits_usr_t2"},
            // меняеются колонки в наследующей таблице и добавляется
            // сиквенс, пользователь выбра таблицу
            // TODO если в этом тесте удалить из исходной базы seq1,
            // то он не появится в скрипте, потому, что нет связи от
            // сиквенса к таблице по кр мере со стороны парсера
            {"inherit_table_usr"},
            // колонка меняет тип на новый, пользователь выбрал только тип
            {"chg_col_type_usr_dom2"},
            // колонка меняет тип на новый, пользователь выбрал только таблицу
            {"chg_col_type_usr_t1"},
            // колонка меняет тип на новый, пользователь выбрал таблицу и тип
            {"chg_col_type_usr_all"},
            // Удаляется индекс и внешний ключ, пользователь выбрал индекс
            {"drop_index_usr_ind"},
            // тип изменяется как альтер, пользователь выбрал его
            {"alter_type_usr"},
            // тип изменяется через drop create, пользователь выбирает его
            {"drop_type_usr"},
            // удаляется таблица с содержимым индексом и триггером,
            // пользователь выбрал только таблицу
            {"drop_tbl_usr_tbl"},
            // к таблице добавляется триггер и функция,
            // пользователь выбрал только функцию
            {"add_table_and_trigger_usr_function"},
            // к таблице добавляется триггер и функция,
            // пользователь выбрал только триггер
            {"add_table_and_trigger_usr_trigger"},
            // к таблице добавляется триггер и функция,
            // пользователь выбрал все
            {"add_table_and_trigger"},
            // перенос объектов из одной схемы в другую,
            // пользователь выбрал таблицу
            {"move_obj_to_schema_usr_table"},
            // зависимости от вьюхи, пользователь выбрал вьюху с FROM ROW FROM
            // https://github.com/pgcodekeeper/pgcodekeeper/issues/54
            {"add_view_with_dep_usr_v1"},
            // зависимости от вьюхи,
            // пользователь выбрал вьюху с regproc, regprocedure, regnamespace
            {"add_view_with_dep_usr_v2"},
            // зависимости от вьюхи,
            // пользователь выбрал вьюху с синтаксическим сахаром
            {"add_view_with_dep_usr_v3"},
            // зависимости от вьюхи,
            // пользователь выбрал вьюху с оконной функцией
            {"add_view_with_dep_usr_v4"},
            // зависимости от вьюхи,
            // пользователь выбрал вьюху с группировкой
            {"add_view_with_dep_usr_v5"},
            // зависимости от вьюхи,
            // пользователь выбрал вьюху с группировкой по primary key
            {"add_view_with_dep_usr_v6"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал таблицу t1
            {"change_view_usr_t1"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал таблицу t2
            {"change_view_usr_t2"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал таблицу t3
            {"change_view_usr_t3"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v2
            {"change_view_usr_v2"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v3
            {"change_view_usr_v3"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v4
            {"change_view_usr_v4"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v5
            {"change_view_usr_v5"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v6
            {"change_view_usr_v6"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v8
            {"change_view_usr_v8"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v8 и таблицу t1
            // задача 6049
            {"change_view_usr_v8_t1"},
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал все объекты
            {"change_view"},
            // пересоздание вьюхи с комментарием
            // пользователь выбрал таблицу
            // задача 7095
            {"chg_view_with_comment_usr_table"},
            // изменение зависимых объектов полнотекстового поиска
            // пользователь выбрал парсер
            {"chg_fts_statements_usr_parser"},
            // изменение зависимых объектов полнотекстового поиска
            // пользователь выбрал словарь
            {"chg_fts_statements_usr_dictionary"},
            // изменение зависимых объектов полнотекстового поиска
            // пользователь выбрал шаблон
            {"chg_fts_statements_usr_template"},
            // изменение зависимых объектов полнотекстового поиска
            // пользователь выбрал конфигурацию
            {"chg_fts_statements_usr_configuration"},
            // добавление агрегатов с зависимыми от них функциями,
            // пользователь выбрал только агрегаты
            {"add_aggr_func_usr_aggr"},
            // в функции 'f1' изменяется имя аргумента функции,
            // в функции 'f2' изменяется определение функции,
            // пользователь выбирает 'f1'
            // (опеределение обеих функций написано на языке SQL)
            // ('f2' зависит от 'f1')
            {"change_func_arg_name_usr_f1", true},
            // в функции 'f1' изменяется имя аргумента функции,
            // в функции 'f2' изменяется определение функции,
            // пользователь выбирает 'f1'
            // (опеределение обеих функций написано на языке SQL)
            // ('f2' зависит от 'f1')
            // (обе функции находятся в разных схемах)
            {"change_func_arg_name_sch_usr_f1", true},
            // добавление вьюхи с зависимыми от нее объектами,
            // пользователь выбрал только вьюху
            {"add_view_usr_view"},
            // изменение схемы расширения и создание этой схемы
            // пользователь выбрал расширение
            {"chg_extension_schema_usr_extension"},
            // изменение типа колонки таблицы, зависящей от функции, удаление функции
            // пользователь выбрал таблицу tbl
            {"chg_col_type_dep_from_func_usr_tbl"},
            // изменение типа и дефолтного значения колонки родительской и дочерней таблицы
            // пользователь выбрал таблицу дочернюю таблицу
            {"chg_inherit_col_usr_child"},
            // изменение типа и дефолтного значения колонки родительской и дочерней таблицы
            // пользователь выбрал таблицу родительскую таблицу
            {"chg_inherit_col_usr_parent"},
            // добавление exclude ограничения с зависимой функцией
            // пользователь выбрал ограничение
            {"add_exclude_usr_constraint"},
            // добавление объекта fts_template с зависимыми от него объектами,
            // пользователь выбрал fts_template
            {"add_fts_tmpl_usr_fts_tmpl"},
            // добавление объекта fts_parser с зависимыми от него объектами,
            // пользователь выбрал fts_parser
            {"add_fts_parser_usr_fts_parser"},
            // зависимости от функции,
            // пользователь выбрал функцию
            {"add_func_with_dep_usr_f1"},
            // изменение сиквенсов с зависимостями
            // пользователь выбрал сиквенс s1
            {"change_sequence_usr_s1"},
            // изменение сиквенсов с зависимостями
            // пользователь выбрал сиквенс s2
            {"change_sequence_usr_s2"},
            // изменение сиквенсов с зависимостями
            // пользователь выбрал сиквенс s3
            {"change_sequence_usr_s3"},
            // изменение сиквенсов с зависимостями
            // пользователь выбрал сиквенс s4
            {"change_sequence_usr_s4"},
            // изменение сиквенсов с зависимостями
            // пользователь выбрал сиквенс s5
            {"change_sequence_usr_s5"},
            // изменение сиквенсов с зависимостями
            // пользователь выбрал таблицу t0
            {"change_sequence_usr_t0"},
            // изменение сиквенсов с зависимостями
            // пользователь выбрал таблицу t6
            {"change_sequence_usr_t6"},
            // добавление таблицы с цикличной зависимотью к функции
            // пользователь выбрал таблицу t1
            {"add_table_with_cyclic_dep_usr_t1", true},
        });

        int maxLength = p.stream()
                .mapToInt(oo -> oo.length)
                .max().getAsInt();
        return p.stream()
                .map(oo -> oo.length < maxLength ? Arrays.copyOf(oo, maxLength) : oo)
                ::iterator;
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

    final PgDiffArguments args = new PgDiffArguments();

    public PgDiffDepciesTest(final String userSelTemplate, Boolean isEnableDepcies) {
        this.dbTemplate = userSelTemplate.replaceAll("_usr.*", "");
        this.userSelTemplate = userSelTemplate;
        if (isEnableDepcies != null && isEnableDepcies) {
            args.setEnableFunctionBodiesDependencies(true);
        }
        Log.log(Log.LOG_DEBUG, dbTemplate + ' ' + userSelTemplate);
    }

    @Test(timeout = 120000)
    public void runDiff() throws IOException, InterruptedException {
        PgDatabase oldDatabase;
        PgDatabase newDatabase;
        PgDatabase oldDbFull;
        PgDatabase newDbFull;
        if (userSelTemplate.equals(dbTemplate)) {
            oldDatabase = ApgdiffTestUtils.loadTestDump(
                    getUsrSelName(FILES_POSTFIX.ORIGINAL_SQL), PgDiffDepciesTest.class, args);
            newDatabase = ApgdiffTestUtils.loadTestDump(
                    getUsrSelName(FILES_POSTFIX.NEW_SQL), PgDiffDepciesTest.class, args);
            oldDbFull = oldDatabase;
            newDbFull = newDatabase;
        } else {
            oldDatabase = ApgdiffTestUtils.loadTestDump(
                    getUsrSelName(FILES_POSTFIX.ORIGINAL_SQL), PgDiffDepciesTest.class, args, false);
            newDatabase = ApgdiffTestUtils.loadTestDump(
                    getUsrSelName(FILES_POSTFIX.NEW_SQL), PgDiffDepciesTest.class, args, false);
            oldDbFull = ApgdiffTestUtils.loadTestDump(
                    getDbName(FILES_POSTFIX.ORIGINAL_SQL), PgDiffDepciesTest.class, args);
            newDbFull = ApgdiffTestUtils.loadTestDump(
                    getDbName(FILES_POSTFIX.NEW_SQL), PgDiffDepciesTest.class, args);
        }

        ApgdiffTestUtils.runDiffSame(oldDbFull, dbTemplate, args);
        ApgdiffTestUtils.runDiffSame(newDbFull, dbTemplate, args);

        TreeElement tree = DiffTree.create(oldDatabase, newDatabase, null);
        tree.setAllChecked();
        String script = new PgDiff(args).diffDatabaseSchemasAdditionalDepcies(
                tree, oldDbFull, newDbFull, null, null);

        ApgdiffTestUtils.compareResult(script, userSelTemplate, PgDiffDepciesTest.class);
    }

    private String getUsrSelName(FILES_POSTFIX postfix) {
        return userSelTemplate + postfix;
    }

    private String getDbName(FILES_POSTFIX postfix) {
        return dbTemplate + postfix;
    }
}
