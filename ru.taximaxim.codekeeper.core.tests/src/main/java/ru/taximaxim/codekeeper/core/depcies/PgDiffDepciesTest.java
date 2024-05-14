/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.TestUtils;

/**
 * Тестирует сравнение БД с неполным выбором различающихся объектов
 * @author botov_av
 */
class PgDiffDepciesTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "empty_usr",
            // изменяется тип колонок у обоих таблиц, пользователь выбирает
            // view v1
            "add_change_col_type_usr_v1",
            // --\\-- , пользователь выбирает t1.c1
            "add_change_col_type_usr_t1_c1",
            // --\\--, у вью меняется только комментарий
            "add_change_only_col_type_usr_t1_c1",
            // изменяется тип колонок у обоих таблиц, изменяется v1, пользователь выбирает
            // view v2
            "add_v2_change_col_type_usr_v2",
            // изменяется тип колонки, пользователь выбирает таблицу
            "trig_upd_col_usr_tbl",
            // удаляется исходная таблица, пользователь выбрал на удаление t1
            "table_inherits_del_t1_usr_t1",
            // удаляется исходная таблица, пользователь выбрал t2
            // TODO здесь не нужно создавать колонку, она создастся путем удаления
            // наследования
            "table_inherits_del_t1_usr_t2",
            // Таблица перестает наследовать,
            // TODO здесь ошибка не должно
            // быть добавления колонки исправится правильной реализацией
            // inherits
            "table_inherits_usr_t2",
            // меняеются колонки в наследующей таблице и добавляется
            // сиквенс, пользователь выбрал таблицу
            "inherit_table_usr",
            // колонка меняет тип на новый, пользователь выбрал только тип
            "chg_col_type_usr_dom2",
            // колонка меняет тип на новый, пользователь выбрал только таблицу
            "chg_col_type_usr_t1",
            // колонка меняет тип на новый, пользователь выбрал таблицу и тип
            "chg_col_type_usr_all",
            // Удаляется индекс и внешний ключ, пользователь выбрал индекс
            "drop_index_usr_ind",
            // тип изменяется как альтер, пользователь выбрал его
            "alter_type_usr",
            // тип изменяется через drop create, пользователь выбирает его
            "drop_type_usr",
            // удаляется таблица с содержимым индексом и триггером,
            // пользователь выбрал только таблицу
            "drop_tbl_usr_tbl",
            // к таблице добавляется триггер и функция,
            // пользователь выбрал только функцию
            "add_table_and_trigger_usr_function",
            // к таблице добавляется триггер и функция,
            // пользователь выбрал только триггер
            "add_table_and_trigger_usr_trigger",
            // к таблице добавляется триггер и функция,
            // пользователь выбрал все
            "add_table_and_trigger",
            // перенос объектов из одной схемы в другую,
            // пользователь выбрал таблицу
            "move_obj_to_schema_usr_table",
            // зависимости от вьюхи, пользователь выбрал вьюху с FROM ROW FROM
            // https://github.com/pgcodekeeper/pgcodekeeper/issues/54
            "add_view_with_dep_usr_v1",
            // зависимости от вьюхи,
            // пользователь выбрал вьюху с regproc, regprocedure, regnamespace
            "add_view_with_dep_usr_v2",
            // зависимости от вьюхи,
            // пользователь выбрал вьюху с синтаксическим сахаром
            "add_view_with_dep_usr_v3",
            // зависимости от вьюхи,
            // пользователь выбрал вьюху с оконной функцией
            "add_view_with_dep_usr_v4",
            // зависимости от вьюхи,
            // пользователь выбрал вьюху с группировкой
            "add_view_with_dep_usr_v5",
            // зависимости от вьюхи,
            // пользователь выбрал вьюху с группировкой по primary key
            "add_view_with_dep_usr_v6",
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал таблицу t1
            "change_view_usr_t1",
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал таблицу t2
            "change_view_usr_t2",
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал таблицу t3
            "change_view_usr_t3",
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v2
            "change_view_usr_v2",
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v3
            "change_view_usr_v3",
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v4
            "change_view_usr_v4",
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v5
            "change_view_usr_v5",
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v6
            "change_view_usr_v6",
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v8
            "change_view_usr_v8",
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал вьюху v8 и таблицу t1
            // задача 6049
            "change_view_usr_v8_t1",
            // изменение таблиц и вьюх, зависящих от них
            // пользователь выбрал все объекты
            "change_view",
            // пересоздание вьюхи с комментарием
            // пользователь выбрал таблицу
            // задача 7095
            "chg_view_with_comment_usr_table",
            // изменение зависимых объектов полнотекстового поиска
            // пользователь выбрал парсер
            "chg_fts_statements_usr_parser",
            // изменение зависимых объектов полнотекстового поиска
            // пользователь выбрал словарь
            "chg_fts_statements_usr_dictionary",
            // изменение зависимых объектов полнотекстового поиска
            // пользователь выбрал шаблон
            "chg_fts_statements_usr_template",
            // изменение зависимых объектов полнотекстового поиска
            // пользователь выбрал конфигурацию
            "chg_fts_statements_usr_configuration",
            // добавление агрегатов с зависимыми от них функциями,
            // пользователь выбрал только агрегаты
            "add_aggr_func_usr_aggr",
            // добавление вьюхи с зависимыми от нее объектами,
            // пользователь выбрал только вьюху
            "add_view_usr_view",
            // изменение схемы расширения и создание этой схемы
            // пользователь выбрал расширение
            "chg_extension_schema_usr_extension",
            // изменение типа колонки таблицы, зависящей от функции, удаление функции
            // пользователь выбрал таблицу tbl
            "chg_col_type_dep_from_func_usr_tbl",
            // изменение типа и дефолтного значения колонки родительской и дочерней таблицы
            // пользователь выбрал таблицу дочернюю таблицу
            "chg_inherit_col_usr_child",
            // изменение типа и дефолтного значения колонки родительской и дочерней таблицы
            // пользователь выбрал таблицу родительскую таблицу
            "chg_inherit_col_usr_parent",
            // добавление exclude ограничения с зависимой функцией
            // пользователь выбрал ограничение
            "add_exclude_usr_constraint",
            // добавление объекта fts_template с зависимыми от него объектами,
            // пользователь выбрал fts_template
            "add_fts_tmpl_usr_fts_tmpl",
            // добавление объекта fts_parser с зависимыми от него объектами,
            // пользователь выбрал fts_parser
            "add_fts_parser_usr_fts_parser",
            // зависимости от функции,
            // пользователь выбрал функцию
            "add_func_with_dep_usr_f1",
            // добавление функции с зависимостями
            // пользователь выбрал функции с телами в команде CREATE
            "add_func_with_dep_usr_f_inline",
            // добавление функции с зависимостями
            // пользователь выбрал функцию f1
            "add_function_with_dep_usr_f1",
            // изменение сиквенсов с зависимостями
            // пользователь выбрал сиквенс s1
            "change_sequence_usr_s1",
            // изменение сиквенсов с зависимостями
            // пользователь выбрал сиквенс s2
            "change_sequence_usr_s2",
            // изменение сиквенсов с зависимостями
            // пользователь выбрал сиквенс s3
            "change_sequence_usr_s3",
            // изменение сиквенсов с зависимостями
            // пользователь выбрал сиквенс s4
            "change_sequence_usr_s4",
            // изменение сиквенсов с зависимостями
            // пользователь выбрал сиквенс s5
            "change_sequence_usr_s5",
            // изменение сиквенсов с зависимостями
            // пользователь выбрал таблицу t0
            "change_sequence_usr_t0",
            // изменение сиквенсов с зависимостями
            // пользователь выбрал таблицу t6
            "change_sequence_usr_t6",
            // изменение функции от которой зависит триггер
            // пользователь выбрал функцию f1
            "modify_trigger_function_usr_f1",
            // добавление оператора с перегруженными функциями
            // пользователь выбрал оператор
            "add_operator_usr_op",
            // проверка объекта forein_data_wrapper, server
            // пользователь выбрал объект forein_table с зависимыми от него forein_data_wrapper, server
            "change_fdw_usr",
            // проверка объекта user mapping
            // пользователь выбрал объект user mapping с зависимостью server
            "add_user_mapping_usr",
            //добавление предсталение с перегруженной агрегатной функцией
            //пользователь выбрал только представление v1 (с finalfunc)
            "add_view_with_over_aggr_usr_v1",
            //добавление предсталение с перегруженной агрегатной функцией
            //пользователь выбрал только представление v2 (без finalFunc)
            "add_view_with_over_aggr_usr_v2",
            // пользователь изменил ConstraintPk
            // пользователь выбрал только таблицу с ConstraintPk
            "change_constrPk_usr",
            // CREATE objects with collation dependency, USER SELECTION: all except collations
            "add_objects_with_collation_usr_all",
    })
    void runDiff(final String userSelTemplate) throws IOException, InterruptedException {
        testDepcy(userSelTemplate, false);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            // в функции 'f1' изменяется имя аргумента функции,
            // в функции 'f2' изменяется определение функции,
            // пользователь выбирает 'f1'
            // (опеределение обеих функций написано на языке SQL)
            // ('f2' зависит от 'f1')
            "change_func_arg_name_usr_f1",
            // в функции 'f1' изменяется имя аргумента функции,
            // в функции 'f2' изменяется определение функции,
            // пользователь выбирает 'f1'
            // (опеределение обеих функций написано на языке SQL)
            // ('f2' зависит от 'f1')
            // (обе функции находятся в разных схемах)
            "change_func_arg_name_sch_usr_f1",
            // добавление таблицы с цикличной зависимотью к функции
            // пользователь выбрал таблицу t1
            "add_table_with_cyclic_dep_usr_t1",
            // добавление функции с merge statement и с зависимостями function & table
            // пользователь выбрал функцию.
            "add_function_with_merge_stat_usr",
            // добавленны пять функций func_1, func_2 и func_3 перегруженные, где func_1 зависит от func_2(int, text) и
            // func_3(int, int) в рамках контекста правила loop_statement, а также в func_1 прописанн не валидный кейс
            // вызыва func_2(int, int) вне рамок контекста loop_statement.
            // пользователь выбирает func_1.
            "add_func_with_dep_usr_func_1",
            //
            "change_view_and_function",
            // create functions with regcast dependencies
            // user selected function with regoper dependency
            "add_func_with_regcast_usr_func_regoper",
            // user selected function with regoperator dependency
            "add_func_with_regcast_usr_func_regoperator",
            // user selected function with regproc dependency
            "add_func_with_regcast_usr_func_regproc",
            // user selected function with regprocedure dependency
            "add_func_with_regcast_usr_func_regprocedure",
            // user selected function with copying types (%TYPE) dependency
            "add_func_with_copying_type_usr_func_f2",
    })
    void runDiffWithFunctionDependencies(final String userSelTemplate) throws IOException, InterruptedException {
        testDepcy(userSelTemplate, true);
    }

    void testDepcy(String userSelTemplate, boolean isEnableFunctionBodiesDependencies)
            throws IOException, InterruptedException {
        TestUtils.testDepcy(userSelTemplate, isEnableFunctionBodiesDependencies, DatabaseType.PG, getClass());
    }
}