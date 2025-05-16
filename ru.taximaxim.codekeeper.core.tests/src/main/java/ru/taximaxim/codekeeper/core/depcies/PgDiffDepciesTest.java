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
package ru.taximaxim.codekeeper.core.depcies;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.taximaxim.codekeeper.core.TestUtils;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.settings.TestCoreSettings;

/**
 * Тестирует сравнение БД с неполным выбором различающихся объектов
 * @author botov_av
 */
class PgDiffDepciesTest {

    private static Stream<Arguments> provideSelectedObjects() {
        return Stream.of(
                Arguments.of("empty", null, Collections.emptyMap()),
                // изменяется тип колонок у обоих таблиц, пользователь выбирает
                // view v1
                Arguments.of("add_change_col_type", "usr_v1", Map.of("public-v1", DbObjType.VIEW)),
                // --\\-- , пользователь выбирает t1.c1
                Arguments.of("add_change_col_type", "usr_t1_c1", Map.of("public-t1", DbObjType.TABLE)),
                // --\\--, у вью меняется только комментарий
                Arguments.of("add_change_only_col_type", "usr_t1_c1", Map.of("public-t1", DbObjType.TABLE)),
                // изменяется тип колонок у обоих таблиц, изменяется v1, пользователь выбирает
                // view v2
                Arguments.of("add_v2_change_col_type", "usr_v2", Map.of("public-v2", DbObjType.VIEW)),
                // изменяется тип колонки, пользователь выбирает таблицу
                Arguments.of("trig_upd_col", "usr_tbl", Map.of("public-t1", DbObjType.TABLE)),
                // удаляется исходная таблица, пользователь выбрал на удаление t1
                Arguments.of("table_inherits_del_t1", "usr_t1", Map.of("public-t1", DbObjType.TABLE)),
                // удаляется исходная таблица, пользователь выбрал t2
                // TODO здесь не нужно создавать колонку, она создастся путем удаления
                // наследования
                Arguments.of("table_inherits_del_t1", "usr_t2", Map.of("public-t2", DbObjType.TABLE)),
                // Таблица перестает наследовать,
                // TODO здесь ошибка не должно
                // быть добавления колонки исправится правильной реализацией
                // inherits
                Arguments.of("table_inherits", "usr_t2", Map.of("public-t2", DbObjType.TABLE)),
                // меняеются колонки в наследующей таблице и добавляется
                // сиквенс, пользователь выбрал таблицу
                Arguments.of("inherit_table", "usr", Map.of("public-t2", DbObjType.TABLE)),
                // колонка меняет тип на новый, пользователь выбрал только тип
                Arguments.of("chg_col_type", "usr_dom2", Map.of("public-dom2", DbObjType.DOMAIN)),
                // колонка меняет тип на новый, пользователь выбрал только таблицу
                Arguments.of("chg_col_type", "usr_t1", Map.of("public-t1", DbObjType.TABLE)),
                // колонка меняет тип на новый, пользователь выбрал таблицу и тип
                Arguments.of("chg_col_type", "usr_all", null),
                // Удаляется индекс и внешний ключ, пользователь выбрал индекс
                Arguments.of("drop_index", "usr_ind", Map.of("public-testindex", DbObjType.INDEX)),
                // тип изменяется как альтер, пользователь выбрал его
                Arguments.of("alter_type", "usr", Map.of("public-ty1", DbObjType.TYPE)),
                // тип изменяется через drop create, пользователь выбирает его
                Arguments.of("drop_type", "usr", Map.of("public-ty1", DbObjType.TYPE)),
                // удаляется таблица с содержимым индексом и триггером,
                // пользователь выбрал только таблицу
                Arguments.of("drop_tbl", "usr_tbl", Map.of("public-t1", DbObjType.TABLE)),
                // к таблице добавляется триггер и функция,
                // пользователь выбрал только функцию
                Arguments.of("add_table_and_trigger", "usr_function", Map.of("test-emp_stamp()", DbObjType.FUNCTION)),
                // к таблице добавляется триггер и функция,
                // пользователь выбрал только триггер
                Arguments.of("add_table_and_trigger", "usr_trigger", Map.of("public-emp-emp_stamp", DbObjType.TRIGGER)),
                // к таблице добавляется триггер и функция,
                // пользователь выбрал все
                Arguments.of("add_table_and_trigger", null, null),
                // перенос объектов из одной схемы в другую,
                // пользователь выбрал таблицу
                Arguments.of("move_obj_to_schema", "usr_table",
                        Map.of("public-emp", DbObjType.TABLE, "test-emp", DbObjType.TABLE, "test-name_ind",
                                DbObjType.INDEX, "test-emp_view", DbObjType.VIEW, "test-emp-emp_stamp",
                                DbObjType.TRIGGER, "test-emp-notify_me", DbObjType.RULE)),
                // зависимости от вьюхи, пользователь выбрал вьюху с FROM ROW FROM
                // https://github.com/pgcodekeeper/pgcodekeeper/issues/54
                Arguments.of("add_view_with_dep", "usr_v1", Map.of("public-v1", DbObjType.VIEW)),
                // зависимости от вьюхи,
                // пользователь выбрал вьюху с regproc, regprocedure, regnamespace
                Arguments.of("add_view_with_dep", "usr_v2", Map.of("public-v2", DbObjType.VIEW)),
                // зависимости от вьюхи,
                // пользователь выбрал вьюху с синтаксическим сахаром
                Arguments.of("add_view_with_dep", "usr_v3", Map.of("public-v3", DbObjType.VIEW)),
                // зависимости от вьюхи,
                // пользователь выбрал вьюху с оконной функцией
                Arguments.of("add_view_with_dep", "usr_v4", Map.of("public-v4", DbObjType.VIEW)),
                // зависимости от вьюхи,
                // пользователь выбрал вьюху с группировкой
                Arguments.of("add_view_with_dep", "usr_v5", Map.of("public-v5", DbObjType.VIEW)),
                // зависимости от вьюхи,
                // пользователь выбрал вьюху с группировкой по primary key
                Arguments.of("add_view_with_dep", "usr_v6", Map.of("public-v6", DbObjType.VIEW)),
                // изменение таблиц и вьюх, зависящих от них
                // пользователь выбрал таблицу t1
                Arguments.of("change_view", "usr_t1", Map.of("public-t1", DbObjType.TABLE)),
                // изменение таблиц и вьюх, зависящих от них
                // пользователь выбрал таблицу t2
                Arguments.of("change_view", "usr_t2", Map.of("public-t2", DbObjType.TABLE)),
                // изменение таблиц и вьюх, зависящих от них
                // пользователь выбрал таблицу t3
                Arguments.of("change_view", "usr_t3", Map.of("public-t3", DbObjType.TABLE)),
                // изменение таблиц и вьюх, зависящих от них
                // пользователь выбрал вьюху v2
                Arguments.of("change_view", "usr_v2", Map.of("public-v2", DbObjType.VIEW)),
                // изменение таблиц и вьюх, зависящих от них
                // пользователь выбрал вьюху v3
                Arguments.of("change_view", "usr_v3", Map.of("public-v3", DbObjType.VIEW)),
                // изменение таблиц и вьюх, зависящих от них
                // пользователь выбрал вьюху v4
                Arguments.of("change_view", "usr_v4", Map.of("public-v4", DbObjType.VIEW)),
                // изменение таблиц и вьюх, зависящих от них
                // пользователь выбрал вьюху v5
                Arguments.of("change_view", "usr_v5", Map.of("public-v5", DbObjType.VIEW)),
                // изменение таблиц и вьюх, зависящих от них
                // пользователь выбрал вьюху v6
                Arguments.of("change_view", "usr_v6", Map.of("public-v6", DbObjType.VIEW)),
                // изменение таблиц и вьюх, зависящих от них
                // пользователь выбрал вьюху v8
                Arguments.of("change_view", "usr_v8", Map.of("public-v8", DbObjType.VIEW)),
                // изменение таблиц и вьюх, зависящих от них
                // пользователь выбрал вьюху v8 и таблицу t1
                // задача 6049
                Arguments.of("change_view", "usr_v8_t1",
                        Map.of("public-v8", DbObjType.VIEW, "public-t1", DbObjType.TABLE)),
                // изменение таблиц и вьюх, зависящих от них
                // пользователь выбрал все объекты
                Arguments.of("change_view", null, null),
                // пересоздание вьюхи с комментарием
                // пользователь выбрал таблицу
                // задача 7095
                Arguments.of("chg_view_with_comment", "usr_table", Map.of("public-testtable", DbObjType.TABLE)),
                // изменение зависимых объектов полнотекстового поиска
                // пользователь выбрал парсер
                Arguments.of("chg_fts_statements", "usr_parser",
                        Map.of("public-first_parser", DbObjType.FTS_PARSER)),
                // изменение зависимых объектов полнотекстового поиска
                // пользователь выбрал словарь
                Arguments.of("chg_fts_statements", "usr_dictionary",
                        Map.of("public-first_dictionary", DbObjType.FTS_DICTIONARY)),
                // изменение зависимых объектов полнотекстового поиска
                // пользователь выбрал шаблон
                Arguments.of("chg_fts_statements", "usr_template",
                        Map.of("public-second_template", DbObjType.FTS_TEMPLATE, "public-first_template",
                                DbObjType.FTS_TEMPLATE)),
                // изменение зависимых объектов полнотекстового поиска
                // пользователь выбрал конфигурацию
                Arguments.of("chg_fts_statements", "usr_configuration",
                        Map.of("public-first_configuration", DbObjType.FTS_CONFIGURATION)),
                // добавление агрегатов с зависимыми от них функциями,
                // пользователь выбрал только агрегаты
                Arguments.of("add_aggr_func", "usr_aggr",
                        Map.of("public-mode1(boolean)", DbObjType.AGGREGATE, "public-mode3()", DbObjType.AGGREGATE,
                                "public-mode4(boolean)", DbObjType.AGGREGATE,
                                "public-mode11_params(boolean, integer, text, boolean, text)", DbObjType.AGGREGATE)),
                // добавление вьюхи с зависимыми от нее объектами,
                // пользователь выбрал только вьюху
                Arguments.of("add_view", "usr_view", Map.of("public-test", DbObjType.VIEW)),
                // изменение схемы расширения и создание этой схемы
                // пользователь выбрал расширение
                Arguments.of("chg_extension_schema", "usr_extension", Map.of("postgis", DbObjType.EXTENSION)),
                // изменение типа колонки таблицы, зависящей от функции, удаление функции
                // пользователь выбрал таблицу tbl
                Arguments.of("chg_col_type_dep_from_func", "usr_tbl", Map.of("public-tbl", DbObjType.TABLE)),
                // изменение типа и дефолтного значения колонки родительской и дочерней таблицы
                // пользователь выбрал таблицу дочернюю таблицу
                Arguments.of("chg_inherit_col", "usr_child", Map.of("public-test_2", DbObjType.TABLE)),
                // изменение типа и дефолтного значения колонки родительской и дочерней таблицы
                // пользователь выбрал таблицу родительскую таблицу
                Arguments.of("chg_inherit_col", "usr_parent", Map.of("public-test_1", DbObjType.TABLE)),
                // добавление exclude ограничения с зависимой функцией
                // пользователь выбрал ограничение
                Arguments.of("add_exclude", "usr_constraint",
                        Map.of("public-test_table-test_constraint", DbObjType.CONSTRAINT)),
                // добавление объекта fts_template с зависимыми от него объектами,
                // пользователь выбрал fts_template
                Arguments.of("add_fts_tmpl", "usr_fts_tmpl",
                        Map.of("public-fts_template", DbObjType.FTS_TEMPLATE)),
                // добавление объекта fts_parser с зависимыми от него объектами,
                // пользователь выбрал fts_parser
                Arguments.of("add_fts_parser", "usr_fts_parser",
                        Map.of("public-fts_parser", DbObjType.FTS_PARSER)),
                // зависимости от функции,
                // пользователь выбрал функцию
                Arguments.of("add_func_with_dep", "usr_f1",
                        Map.of("public-f1(integer, integer)", DbObjType.FUNCTION)),
                // добавление функции с зависимостями
                // пользователь выбрал функции с телами в команде CREATE
                Arguments.of("add_func_with_dep", "usr_f_inline",
                        Map.of("public-f_inline_short()", DbObjType.FUNCTION, "public-f_inline_full()",
                                DbObjType.FUNCTION)),
                // добавление функции с зависимостями
                // пользователь выбрал функцию f1
                Arguments.of("add_function_with_dep", "usr_f1", Map.of("public-f1()", DbObjType.FUNCTION)),
                // изменение сиквенсов с зависимостями
                // пользователь выбрал сиквенс s1
                Arguments.of("change_sequence", "usr_s1", Map.of("public-s1", DbObjType.SEQUENCE)),
                // изменение сиквенсов с зависимостями
                // пользователь выбрал сиквенс s2
                Arguments.of("change_sequence", "usr_s2", Map.of("public-s2", DbObjType.SEQUENCE)),
                // изменение сиквенсов с зависимостями
                // пользователь выбрал сиквенс s3
                Arguments.of("change_sequence", "usr_s3", Map.of("public-s3", DbObjType.SEQUENCE)),
                // изменение сиквенсов с зависимостями
                // пользователь выбрал сиквенс s4
                Arguments.of("change_sequence", "usr_s4", Map.of("public-s4", DbObjType.SEQUENCE)),
                // изменение сиквенсов с зависимостями
                // пользователь выбрал сиквенс s5
                Arguments.of("change_sequence", "usr_s5", Map.of("public-s5", DbObjType.SEQUENCE)),
                // изменение сиквенсов с зависимостями
                // пользователь выбрал таблицу t0
                Arguments.of("change_sequence", "usr_t0", Map.of("public-t0", DbObjType.TABLE)),
                // изменение сиквенсов с зависимостями
                // пользователь выбрал таблицу t6
                Arguments.of("change_sequence", "usr_t6", Map.of("public-t6", DbObjType.TABLE)),
                // изменение функции от которой зависит триггер
                // пользователь выбрал функцию f1
                Arguments.of("modify_trigger_function", "usr_f1", Map.of("public-f1()", DbObjType.FUNCTION)),
                // добавление оператора с перегруженными функциями
                // пользователь выбрал оператор
                Arguments.of("add_operator", "usr_op", Map.of("public->", DbObjType.OPERATOR)),
                // проверка объекта forein_data_wrapper, server
                // пользователь выбрал объект forein_table с зависимыми от него
                // forein_data_wrapper, server
                Arguments.of("change_fdw", "usr", Map.of("public-test_ft", DbObjType.TABLE)),
                // проверка объекта user mapping
                // пользователь выбрал объект user mapping с зависимостью server
                Arguments.of("add_user_mapping", "usr",
                        Map.of("testuser SERVER myserver", DbObjType.USER_MAPPING)),
                // добавление предсталение с перегруженной агрегатной функцией
                // пользователь выбрал только представление v1 (с finalfunc)
                Arguments.of("add_view_with_over_aggr", "usr_v1", Map.of("public-v1", DbObjType.VIEW)),
                // добавление предсталение с перегруженной агрегатной функцией
                // пользователь выбрал только представление v2 (без finalFunc)
                Arguments.of("add_view_with_over_aggr", "usr_v2", Map.of("public-v2", DbObjType.VIEW)),
                // пользователь изменил ConstraintPk
                // пользователь выбрал только таблицу с ConstraintPk
                Arguments.of("change_constrPk", "usr",
                        Map.of("public-test_t1-test_t1_pkey", DbObjType.CONSTRAINT)),
                // CREATE objects with collation dependency, USER SELECTION: all except
                // collations
                Arguments.of("add_objects_with_collation", "usr_all",
                        Map.of("test-v1", DbObjType.VIEW, "test-t1", DbObjType.TABLE, "test-i1", DbObjType.INDEX,
                                "test-d1", DbObjType.DOMAIN, "test-tt1", DbObjType.TYPE)),
                // CREATE statistics object with dependencies, user selection : statistics
                Arguments.of("add_statistics", "usr_s1", Map.of("second-s1", DbObjType.STATISTICS)),
                Arguments.of("add_statistics", "usr_s2", Map.of("second-s2", DbObjType.STATISTICS))
                );
    }

    @ParameterizedTest
    @MethodSource("provideSelectedObjects")
    void runDiff(final String dbTemplate, String userTemplateName, Map<String, DbObjType> selectedObjs)
            throws IOException, InterruptedException {
        TestUtils.testDepcy(dbTemplate, userTemplateName, selectedObjs, getClass(), new TestCoreSettings());
    }

    private static Stream<Arguments> provideSelectedObjectsWithFunctionBody() {
        return Stream.of(
                // в функции 'f1' изменяется имя аргумента функции,
                // в функции 'f2' изменяется определение функции,
                // пользователь выбирает 'f1'
                // (опеределение обеих функций написано на языке SQL)
                // ('f2' зависит от 'f1')
                Arguments.of("change_func_arg_name", "usr_f1", Map.of("public-f1(text)", DbObjType.FUNCTION)),
                // в функции 'f1' изменяется имя аргумента функции,
                // в функции 'f2' изменяется определение функции,
                // пользователь выбирает 'f1'
                // (опеределение обеих функций написано на языке SQL)
                // ('f2' зависит от 'f1')
                // (обе функции находятся в разных схемах)
                Arguments.of("change_func_arg_name_sch", "usr_f1", Map.of("tester-f1(text)", DbObjType.FUNCTION)),
                // добавление таблицы с цикличной зависимотью к функции
                // пользователь выбрал таблицу t1
                Arguments.of("add_table_with_cyclic_dep", "usr_t1", Map.of("public-t1", DbObjType.TABLE)),
                // добавление функции с merge statement и с зависимостями function & table
                // пользователь выбрал функцию.
                Arguments.of("add_function_with_merge_stat", "usr", Map.of("public-func()", DbObjType.FUNCTION)),
                // добавленны пять функций func_1, func_2 и func_3 перегруженные, где func_1
                // зависит от func_2(int, text) и
                // func_3(int, int) в рамках контекста правила loop_statement, а также в func_1
                // прописанн не валидный кейс
                // вызыва func_2(int, int) вне рамок контекста loop_statement.
                // пользователь выбирает func_1.
                Arguments.of("add_func_with_dep", "usr_func_1", Map.of("public-func_1(jsonb)", DbObjType.FUNCTION)),
                Arguments.of("change_view_and_function", null,
                        Map.of("public-v1", DbObjType.TABLE, "public-function_contract(integer)", DbObjType.FUNCTION)),
                // create functions with regcast dependencies
                // user selected function with regoper dependency
                Arguments.of("add_func_with_regcast", "usr_func_regoper",
                        Map.of("public-f_regoper(integer)", DbObjType.FUNCTION)),
                // user selected function with regoperator dependency
                Arguments.of("add_func_with_regcast", "usr_func_regoperator",
                        Map.of("public-f_regoperator(integer)", DbObjType.FUNCTION)),
                // user selected function with regproc dependency
                Arguments.of("add_func_with_regcast", "usr_func_regproc",
                        Map.of("public-f_regproc(integer)", DbObjType.FUNCTION)),
                // user selected function with regprocedure dependency
                Arguments.of("add_func_with_regcast", "usr_func_regprocedure",
                        Map.of("public-f_regprocedure(integer)", DbObjType.FUNCTION)),
                // user selected function with copying types (%TYPE) dependency
                Arguments.of("add_func_with_copying_type", "usr_func_f2",
                        Map.of("public-f2(anyarray)", DbObjType.FUNCTION)),
                Arguments.of("add_type", "usr_t1", Map.of("public-t1", DbObjType.TYPE)),
                // function is altered so that it has a new dependency that did not exist
                // before,
                // user selected the function
                Arguments.of("change_func_dep", "usr_f1", Map.of("public-f1()", DbObjType.FUNCTION)));
    }

    @ParameterizedTest
    @MethodSource("provideSelectedObjectsWithFunctionBody")
    void runDiffWithFunctionDependencies(final String dbTemplate, String userTemplateName,
            Map<String, DbObjType> selectedObjs) throws IOException, InterruptedException {
        var settings = new TestCoreSettings();
        settings.setEnableFunctionBodiesDependencies(true);
        TestUtils.testDepcy(dbTemplate, userTemplateName, selectedObjs, getClass(), settings);
    }
}