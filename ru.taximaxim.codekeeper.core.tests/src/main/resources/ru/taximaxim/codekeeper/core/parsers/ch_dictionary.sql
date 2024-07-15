CREATE DICTIONARY `01681_database_for_cache_dictionary`.cache_dictionary_simple_key_complex_attributes (  id UInt64,  value_first String DEFAULT 'value_first_default',  value_second Nullable(String) DEFAULT 'value_second_default' ) PRIMARY KEY id SOURCE(CLICKHOUSE(HOST 'localhost' PORT tcpPort() USER 'default' TABLE 'simple_key_complex_attributes_source_table')) LIFETIME(MIN 1 MAX 1000) LAYOUT(CACHE(SIZE_IN_CELLS 10));
CREATE DICTIONARY `01681_database_for_cache_dictionary`.cache_dictionary_simple_key_hierarchy (  id UInt64,  parent_id UInt64 HIERARCHICAL ) PRIMARY KEY id SOURCE(CLICKHOUSE(HOST 'localhost' PORT tcpPort() USER 'default' TABLE 'simple_key_hierarchy_table')) LIFETIME(MIN 1 MAX 1000) LAYOUT(CACHE(SIZE_IN_CELLS 10));
CREATE DICTIONARY simple_key_range_hashed_dictionary_01862 (   id UInt64,   value String,   first Date,   last Date ) PRIMARY KEY id SOURCE(CLICKHOUSE(HOST 'localhost' PORT tcpPort() TABLE 'range_key_source_table_01862')) LAYOUT(RANGE_HASHED()) RANGE(MIN first MAX last) LIFETIME(MIN 0 MAX 1000);
CREATE DICTIONARY simple_key_range_hashed_dictionary_01862 (   id UInt64,   value String,   first Date,   last Date ) PRIMARY KEY id SOURCE(CLICKHOUSE(HOST 'localhost' PORT tcpPort() TABLE 'range_key_source_table_01862')) LAYOUT(RANGE_HASHED()) RANGE(MAX first MIN last) LIFETIME(MAX 0 MIN 1000);
CREATE DICTIONARY simple_key_sparse_hashed_dictionary_01862 (   id UInt64,   value String ) PRIMARY KEY id SOURCE(CLICKHOUSE(HOST 'localhost' PORT tcpPort() TABLE 'simple_key_source_table_01862')) LAYOUT(SPARSE_HASHED()) LIFETIME(MIN 0 MAX 1000);
CREATE DICTIONARY somedict (  id UInt32,  val String,  start Date,  end Date ) PRIMARY KEY id SOURCE(CLICKHOUSE(HOST 'localhost' PORT tcpPort() USER 'default' TABLE 'date_table' DB 'database_for_dict')) LAYOUT(RANGE_HASHED()) RANGE (MIN start MAX end) LIFETIME(MIN 300 MAX 360);
CREATE DICTIONARY sqllt.dictionary (key UInt64, value UInt64) PRIMARY KEY key SOURCE(CLICKHOUSE(DB 'sqllt' TABLE 'table' HOST 'localhost' PORT 9001)) LIFETIME(0) LAYOUT(FLAT());
CREATE DICTIONARY table_function_dictionary_test_dictionary (  id UInt64,  value UInt64 DEFAULT 0 ) PRIMARY KEY id SOURCE(CLICKHOUSE(HOST 'localhost' PORT tcpPort() USER 'default' TABLE 'table_function_dictionary_source_table')) LAYOUT(DIRECT());
CREATE DICTIONARY test_01191.dict (n UInt64, s String) PRIMARY KEY n LAYOUT(DIRECT()) SOURCE(CLICKHOUSE(HOST 'localhost' PORT tcpPort() USER 'default' TABLE '_' DB 'test_01191'));
CREATE DICTIONARY test_01676.dict (key UInt64, value UInt64) PRIMARY KEY key SOURCE(CLICKHOUSE(DB 'test_01676' TABLE 'dict_data' HOST '127.0.0.1' PORT tcpPort())) LIFETIME(0) LAYOUT(HASHED());
CREATE DICTIONARY test_complex_dictionary_10_shards (   key_1 UInt64,   key_2 UInt64,   value UInt16 ) PRIMARY KEY key_1, key_2 SOURCE(CLICKHOUSE(TABLE test_table_complex)) LAYOUT(COMPLEX_KEY_SPARSE_HASHED(SHARDS 10)) LIFETIME(0);
CREATE DICTIONARY test_complex_dictionary_load_factor (   key_1 UInt64,   key_2 UInt64,   value UInt16 ) PRIMARY KEY key_1, key_2 SOURCE(CLICKHOUSE(TABLE test_table_complex)) LAYOUT(COMPLEX_KEY_HASHED(MAX_LOAD_FACTOR 0.90)) LIFETIME(0);
CREATE DICTIONARY test_dict (   `key1` UInt32,   `key2` UInt32,   `value` String ) PRIMARY KEY key1, key2 SOURCE(CLICKHOUSE(HOST 'localhost' PORT 9000 USER 'default' TABLE `test.txt` PASSWORD '' DB currentDatabase())) LIFETIME(MIN 1 MAX 3600) LAYOUT(COMPLEX_KEY_HASHED());
CREATE DICTIONARY test_dict_db.table1_dict ( col1 String, col2 Int16, col3 String, col4 Int32, col5 String, col6 Float64, col7 Float64, col8 DateTime('UTC'), col9 String, col10 String, col11 String, col12 String, col13 Int32, col14 DateTime('UTC'), col15 DateTime('UTC'), col16 DateTime('UTC'), col17 DateTime('UTC'), col18 DateTime('UTC'), col19 DateTime('UTC'), col20 String ) PRIMARY KEY col1,col2,col3,col4,col5 SOURCE(CLICKHOUSE(HOST 'localhost' PORT tcpPort() DB test_dict_db TABLE table1 USER 'default')) LIFETIME(MIN 0 MAX 0) LAYOUT(COMPLEX_KEY_HASHED());
CREATE DICTIONARY test_dictionary (   id UInt64,   value Date32 ) PRIMARY KEY id SOURCE(CLICKHOUSE(TABLE 'test_table')) LAYOUT(DIRECT());
CREATE DICTIONARY test_dictionary (   id UInt64,   value String ) PRIMARY KEY id LAYOUT(FLAT()) SOURCE(CLICKHOUSE(TABLE 'dictionary_source_table')) LIFETIME(0);
-- crash on call function NULL()
--CREATE DICTIONARY {new_db_name:Identifier}.{old_dict_name:Identifier} (id UInt64, val UInt8) PRIMARY KEY id SOURCE(NULL()) LAYOUT(FLAT()) LIFETIME(0);

drop DICTIONARY  {CLICKHOUSE_DATABASE:Identifier}.test_dict_01080;
DROP DICTIONARY `01837_db`.simple_key_direct_dictionary;
DROP DICTIONARY `01913_db`.test_dictionary;
DROP DICTIONARY `01914_db`.dictionary_1;
DROP DICTIONARY `01914_db`.dictionary_2;
DROP DICTIONARY `02015_db`.test_dictionary;
DROP DICTIONARY IF EXISTS db_01268.dict3;
drop dictionary if exists db_01721.decimal_dict;
DROP DICTIONARY ip_trie_dictionary;
DROP DICTIONARY ip_trie_dictionary_01862;
DROP DICTIONARY memory_db.dict2;
DROP DICTIONARY test_dictionary_nullable;
DROP DICTIONARY test_sparse_dictionary_load_factor;
DROP DICTIONARY {CLICKHOUSE_DATABASE:Identifier}.dict1;
DROP DICTIONARY {CLICKHOUSE_DATABASE:Identifier}.dict_exists;

ATTACH DICTIONARY `02181_test_dictionary`;
ATTACH DICTIONARY db_01018.dict1;
ATTACH DICTIONARY db_for_dict.dict_with_hashed_layout;

DETACH DICTIONARY `02181_test_dictionary`;
DETACH DICTIONARY db_01018.dict1;
DETACH DICTIONARY db_for_dict.dict_with_hashed_layout;
DETACH DICTIONARY {CLICKHOUSE_DATABASE:Identifier}.dict1;