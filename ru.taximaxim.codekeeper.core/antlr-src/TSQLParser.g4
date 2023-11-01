parser grammar TSQLParser;

options {
    language=Java;
    tokenVocab=TSQLLexer;
}

@header {package ru.taximaxim.codekeeper.core.parsers.antlr.generated;}

tsql_file
    : BOM? go_statement* batch* EOF
    ;

expression_eof
    : expression (COMMA expression)* EOF
    ;

batch
    : (sql_clauses | batch_statement) (go_statement+ | EOF)
    ;

// for statements that must be the only ones in an entire batch
batch_statement
    : (CREATE (OR ALTER)? | ALTER) batch_statement_body
    | CREATE create_schema SEMI*
    ;

batch_statement_body
    : create_or_alter_procedure
    | create_or_alter_function SEMI*
    | create_or_alter_view SEMI*
    | create_or_alter_trigger
    ;

sql_clauses
    : SEMI* (st_clause SEMI*)+
    ;

st_clause
    : dml_clause
    | ddl_clause
    | cfl_statement
    | dbcc_clause
    | another_statement
    | backup_statement
    ;

// Data Manipulation Language: https://msdn.microsoft.com/en-us/library/ff848766(v=sql.120).aspx
dml_clause
    : merge_statement
    | delete_statement
    | insert_statement
    | select_statement
    | update_statement
    ;

// Data Definition Language: https://msdn.microsoft.com/en-us/library/ff848799.aspx)
ddl_clause
    : schema_create
    | schema_alter
    | schema_drop
    | lock_table
    | truncate_table
    | enable_disable_trigger
    | update_statistics
    ;

schema_alter
    : ALTER (alter_application_role
    | alter_assembly
    | alter_asymmetric_key
    | alter_authorization
    | alter_availability_group
    | alter_certificate
    | alter_column_encryption_key
    | alter_credential
    | alter_cryptographic_provider
    | alter_database
    | alter_database_encryption_key
    | alter_database_scoped_credential
    | alter_db_role
    | alter_endpoint
    | alter_external_data_source
    | alter_external_library
    | alter_external_resource_pool
    | alter_fulltext_catalog
    | alter_fulltext_index
    | alter_fulltext_stoplist
    | alter_login_sql_server
    | alter_master_key_sql_server
    | alter_message_type
    | alter_partition_function
    | alter_partition_scheme
    | alter_queue
    | alter_remote_service_binding
    | alter_resource_governor
    | alter_route
    | alter_schema_sql
    | alter_search_property_list
    | alter_security_policy
    | alter_sequence
    | alter_server_audit
    | alter_server_audit_specification
    | alter_server_configuration
    | alter_server_role
    | alter_service
    | alter_service_master_key
    | alter_symmetric_key
    | alter_table
    | alter_user
    | alter_workload_group
    | alter_xml_schema_collection
    | create_or_alter_broker_priority
    | create_or_alter_event_session
    | create_or_alter_resource_pool)
    ;

schema_create
    : CREATE (create_aggregate
    | create_application_role
    | create_assembly
    | create_asymmetric_key
    | create_certificate
    | create_column_encryption_key
    | create_column_master_key
    | create_contract
    | create_credential
    | create_cryptographic_provider
    | create_database
    | create_database_encryption_key
    | create_database_scoped_credential
    | create_default
    | create_db_role
    | create_event_notification
    | create_external_library
    | create_external_resource_pool
    | create_external_table
    | create_fulltext_catalog
    | create_fulltext_index
    | create_fulltext_stoplist
    | create_index
    | create_key
    | create_login_sql_server
    | create_master_key_sql_server
    | create_message_type
    | create_or_alter_broker_priority
    | create_or_alter_event_session
    | create_or_alter_resource_pool
    | create_partition_function
    | create_partition_scheme
    | create_queue
    | create_remote_service_binding
    | create_route
    | create_rule
    | create_search_property_list
    | create_security_policy
    | create_selective_index
    | create_sequence
    | create_server_audit
    | create_server_audit_specification
    | create_server_role
    | create_service
    | create_statistics
    | create_synonym
    | create_table
    | create_type
    | create_user
    | create_workload_group
    | create_xml_index
    | create_xml_schema_collection)
    ;

schema_drop
    : DROP (drop_assembly
    | drop_asymmetric_key
    | drop_database_encryption_key
    | drop_event_notifications_or_session
    | drop_external_library
    | drop_index
    | drop_master_key
    | drop_signature
    | drop_statements
    | drop_symmetric_key
    | drop_ddl_trigger)
    ;

backup_statement
    : backup_database
    | backup_log
    | backup_certificate
    | backup_master_key
    | backup_service_master_key
    ;

// Control-of-Flow Language: https://docs.microsoft.com/en-us/sql/t-sql/language-elements/control-of-flow
cfl_statement
    : block_statement
    | break_statement
    | continue_statement
    | goto_statement
    | if_statement
    | return_statement
    | throw_statement
    | try_catch_statement
    | waitfor_statement
    | while_statement
    | print_statement
    | raiseerror_statement
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/begin-end-transact-sql
block_statement
    : BEGIN sql_clauses END
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/break-transact-sql
break_statement
    : BREAK
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/continue-transact-sql
continue_statement
    : CONTINUE
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/goto-transact-sql
goto_statement
    : GOTO id
    | id COLON
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/return-transact-sql
return_statement
    : RETURN expression?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/if-else-transact-sql
if_statement
    : IF search_condition st_clause (SEMI? ELSE st_clause)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/throw-transact-sql
throw_statement
    : THROW (decimal_or_local_id COMMA string_or_local_id COMMA decimal_or_local_id)?
    ;

decimal_or_local_id
    : DECIMAL | LOCAL_ID
    ;

string_or_local_id
    : STRING | LOCAL_ID
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/try-catch-transact-sql
try_catch_statement
    : BEGIN TRY try_clauses=sql_clauses? END TRY SEMI? BEGIN CATCH catch_clauses=sql_clauses? END CATCH
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/waitfor-transact-sql
waitfor_statement
    : WAITFOR (waitfor_receive | (DELAY | TIME) time)
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/while-transact-sql
while_statement
    : WHILE search_condition st_clause
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/print-transact-sql
print_statement
    : PRINT expression (COMMA LOCAL_ID)*
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/raiserror-transact-sql
raiseerror_statement
    : RAISERROR LR_BRACKET (DECIMAL | STRING | LOCAL_ID) COMMA constant_LOCAL_ID (COMMA constant_LOCAL_ID)+ RR_BRACKET (WITH (LOG | SETERROR | NOWAIT))?
    | RAISERROR DECIMAL (STRING | LOCAL_ID | DOUBLE_QUOTE_ID) (COMMA (DECIMAL | STRING | LOCAL_ID))*
    ;

another_statement
    : declare_statement
    | cursor_statement
    | conversation_statement
    | receive_statement
    | execute_statement
    | security_statement
    | set_statement
    | transaction_statement
    | use_statement
    | setuser_statement
    ;

create_aggregate
    : AGGREGATE qualified_name
    (LR_BRACKET? procedure_param (COMMA procedure_param)* RR_BRACKET?)?
    RETURNS data_type
    EXTERNAL NAME assembly_name=qualified_name
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-application-role-transact-sql
alter_application_role
    : APPLICATION ROLE id WITH alter_app_role_option (COMMA alter_app_role_option)*
    ;

create_application_role
    : APPLICATION ROLE id WITH create_app_role_option (COMMA create_app_role_option)*
    ;

alter_app_role_option
    : NAME EQUAL id
    | create_app_role_option
    ;

create_app_role_option
    : PASSWORD EQUAL STRING
    | DEFAULT_SCHEMA EQUAL id
    ;

alter_assembly
    : ASSEMBLY name=id
    (FROM expression_list)?
    (WITH assembly_option (COMMA assembly_option)*)?
    (DROP FILE (ALL | STRING (COMMA STRING)))?
    (ADD FILE FROM expression (AS id)? (COMMA expression (AS id))*)?
    ;

assembly_option
    : PERMISSION_SET EQUAL assembly_permission
    | VISIBILITY EQUAL on_off
    | UNCHECKED DATA
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-assembly-transact-sql
create_assembly
    : ASSEMBLY assembly_name=id (AUTHORIZATION owner_name=id)?
    FROM expression (COMMA expression)*
    (WITH PERMISSION_SET EQUAL assembly_permission)?
    ;

assembly_permission
    : SAFE
    | EXTERNAL_ACCESS
    | UNSAFE
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-assembly-transact-sql
drop_assembly
    : ASSEMBLY (IF EXISTS)? name_list (WITH NO DEPENDENTS)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-asymmetric-key-transact-sql
alter_asymmetric_key
    : ASYMMETRIC KEY id asymmetric_key_option
    ;

asymmetric_key_option
    : WITH PRIVATE KEY LR_BRACKET asymmetric_key_password_change_option (COMMA asymmetric_key_password_change_option)? RR_BRACKET
    | REMOVE PRIVATE KEY
    ;

asymmetric_key_password_change_option
    : (DECRYPTION | ENCRYPTION) BY PASSWORD EQUAL STRING
    ;

//https://docs.microsoft.com/en-us/sql/t-sql/statements/create-asymmetric-key-transact-sql
create_asymmetric_key
    : ASYMMETRIC KEY id (AUTHORIZATION id)?
    (FROM (FILE EQUAL STRING | EXECUTABLE_FILE EQUAL STRING | ASSEMBLY id | PROVIDER id))?
    (WITH (ALGORITHM EQUAL (RSA_4096 | RSA_3072 | RSA_2048 | RSA_1024 | RSA_512) | PROVIDER_KEY_NAME EQUAL STRING | CREATION_DISPOSITION EQUAL (CREATE_NEW | OPEN_EXISTING)))?
    (ENCRYPTION BY PASSWORD EQUAL STRING)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-asymmetric-key-transact-sql
drop_asymmetric_key
    : ASYMMETRIC KEY id (REMOVE PROVIDER KEY)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-authorization-transact-sql
alter_authorization
    : AUTHORIZATION ON (class_type COLON COLON)? qualified_name TO (id | SCHEMA OWNER)
    ;

class_type
    : APPLICATION ROLE
    | ASSEMBLY
    | ASYMMETRIC KEY
    | AUDIT
    | AVAILABILITY GROUP
    | BROKER PRIORITY
    | CERTIFICATE
    | COLUMN (ENCRYPTION | MASTER) KEY
    | CONTRACT
    | CREDENTIAL
    | CRYPTOGRAPHIC PROVIDER
    | DATABASE
    | DATABASE (AUDIT SPECIFICATION | ENCRYPTION KEY | EVENT SESSION)
    | DATABASE SCOPED (CONFIGURATION | CREDENTIAL | RESOURCE GOVERNOR)
    | ENDPOINT
    | EVENT NOTIFICATION (DATABASE | OBJECT | SERVER)
    | EVENT SESSION
    | EXTERNAL (DATA SOURCE | FILE FORMAT | LIBRARY | RESOURCE POOL | TABLE)
    | FULLTEXT (CATALOG | STOPLIST)
    | LOGIN
    | MASTER KEY
    | MESSAGE TYPE
    | OBJECT
    | PARTITION (FUNCTION | SCHEME)
    | REMOTE SERVICE BINDING
    | RESOURCE GOVERNOR
    | ROLE
    | ROUTE
    | SCHEMA
    | SEARCH PROPERTY LIST
    | SERVER (AUDIT SPECIFICATION? | ROLE)
    | SERVICE
    | SQL LOGIN
    | SYMMETRIC KEY
    | TRIGGER (DATABASE | SERVER)
    | TYPE
    | USER
    | XML SCHEMA COLLECTION
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-availability-group-transact-sql
alter_availability_group
    : AVAILABILITY GROUP id alter_availability_group_options
    ;

alter_availability_group_options
    : SET LR_BRACKET set_option_spec RR_BRACKET
    | ADD DATABASE id
    | REMOVE DATABASE id
    | (ADD | MODIFY) REPLICA ON replica_spec
    | REMOVE REPLICA ON STRING
    | JOIN
    | (JOIN | MODIFY) AVAILABILITY GROUP ON availability_group_spec (COMMA availability_group_spec)*
    | GRANT CREATE ANY DATABASE
    | DENY CREATE ANY DATABASE
    | FAILOVER
    | FORCE_FAILOVER_ALLOW_DATA_LOSS
    | ADD LISTENER STRING LR_BRACKET WITH add_listener_option RR_BRACKET
    | MODIFY LISTENER (ADD IP LR_BRACKET ip_address_option RR_BRACKET | PORT EQUAL DECIMAL)
    | RESTART LISTENER STRING
    | REMOVE LISTENER STRING
    | OFFLINE
    ;

replica_spec
    : STRING WITH LR_BRACKET replica_option (COMMA replica_option)* RR_BRACKET
    ;

replica_option
    : SEEDING_MODE EQUAL automatic_manual
    | BACKUP_PRIORITY EQUAL DECIMAL
    | SECONDARY_ROLE LR_BRACKET (secondary_role_option (COMMA secondary_role_option)*)? RR_BRACKET
    | PRIMARY_ROLE LR_BRACKET (primary_role_option (COMMA primary_role_option)*)? RR_BRACKET
    | SESSION_TIMEOUT EQUAL DECIMAL
    | ENDPOINT_URL EQUAL STRING
    | AVAILABILITY_MODE EQUAL (SYNCHRONOUS_COMMIT | ASYNCHRONOUS_COMMIT)
    | FAILOVER_MODE EQUAL automatic_manual
    ;

primary_role_option
    : ALLOW_CONNECTIONS EQUAL (READ_WRITE | ALL)
    | READ_ONLY_ROUTING_LIST EQUAL (LR_BRACKET STRING (COMMA STRING)* RR_BRACKET | NONE)
    | READ_WRITE_ROUTING_URL EQUAL LR_BRACKET STRING RR_BRACKET
    ;

secondary_role_option
    : ALLOW_CONNECTIONS EQUAL (NO | READ_ONLY | ALL)
    | READ_ONLY_ROUTING_URL EQUAL STRING
    ;

set_option_spec
    : AUTOMATED_BACKUP_PREFERENCE EQUAL (PRIMARY | SECONDARY_ONLY| SECONDARY | NONE)
    | FAILURE_CONDITION_LEVEL EQUAL DECIMAL
    | HEALTH_CHECK_TIMEOUT EQUAL DECIMAL
    | DB_FAILOVER  EQUAL on_off
    | REQUIRED_SYNCHRONIZED_SECONDARIES_TO_COMMIT EQUAL DECIMAL
    | DTC_SUPPORT EQUAL (PER_DB | NONE)
    | ROLE EQUAL SECONDARY
    ;

availability_group_spec
    : STRING WITH LR_BRACKET (availability_group_spec_option (COMMA availability_group_spec_option)*) RR_BRACKET
    ;

availability_group_spec_option
   : LISTENER_URL EQUAL STRING
   | AVAILABILITY_MODE EQUAL (SYNCHRONOUS_COMMIT | ASYNCHRONOUS_COMMIT)
   | FAILOVER_MODE EQUAL MANUAL
   | SEEDING_MODE EQUAL automatic_manual
   ;

add_listener_option
    : DHCP (ON LR_BRACKET IPV4_ADDR IPV4_ADDR RR_BRACKET)?
    | IP LR_BRACKET (COMMA? LR_BRACKET ip_address_option RR_BRACKET)+ RR_BRACKET (COMMA PORT EQUAL DECIMAL)?
    ;

automatic_manual
    : AUTOMATIC
    | MANUAL
    ;

ip_address_option
    : IPV4_ADDR COMMA (IPV4_ADDR | STRING)
    | IPV6_ADDR
    | STRING (COMMA (IPV4_ADDR | STRING))?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-broker-priority-transact-sql
// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-broker-priority-transact-sql
create_or_alter_broker_priority
    : BROKER PRIORITY id FOR CONVERSATION SET LR_BRACKET
    (CONTRACT_NAME EQUAL (id | ANY) COMMA?)?
    (LOCAL_SERVICE_NAME EQUAL (DOUBLE_FORWARD_SLASH? id | ANY) COMMA?)?
    (REMOTE_SERVICE_NAME  EQUAL (STRING | ANY) COMMA?)?
    (PRIORITY_LEVEL EQUAL (DECIMAL | DEFAULT)) ? RR_BRACKET
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-certificate-transact-sql
alter_certificate
    : CERTIFICATE certificate_name=id
        (REMOVE PRIVATE_KEY
        | WITH PRIVATE KEY LR_BRACKET ((FILE | ENCRYPTION BY PASSWORD | DECRYPTION BY PASSWORD) EQUAL STRING COMMA?)+ RR_BRACKET
        | WITH ACTIVE FOR BEGIN_DIALOG EQUAL on_off)
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-column-encryption-key-transact-sql
alter_column_encryption_key
    : COLUMN ENCRYPTION KEY id (ADD | DROP) VALUE
    LR_BRACKET COLUMN_MASTER_KEY EQUAL id (COMMA ALGORITHM EQUAL STRING COMMA ENCRYPTED_VALUE EQUAL BINARY)? RR_BRACKET
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-column-encryption-key-transact-sql
create_column_encryption_key
    : COLUMN ENCRYPTION KEY id WITH VALUES
    (LR_BRACKET COMMA? COLUMN_MASTER_KEY EQUAL id COMMA
    ALGORITHM EQUAL STRING COMMA
    ENCRYPTED_VALUE EQUAL BINARY RR_BRACKET COMMA?)+
    ;

drop_statements
    : (AGGREGATE | APPLICATION ROLE | AVAILABILITY GROUP | BROKER PRIORITY | CERTIFICATE
        | COLUMN (ENCRYPTION | MASTER) KEY | CONTRACT | CREDENTIAL | CRYPTOGRAPHIC PROVIDER
        | DATABASE (AUDIT SPECIFICATION | SCOPED CREDENTIAL)? | DEFAULT | ENDPOINT
        | EXTERNAL (DATA SOURCE | FILE FORMAT | RESOURCE POOL | TABLE)
        | FULLTEXT (CATALOG | INDEX ON | STOPLIST) | LOGIN | MESSAGE TYPE | PARTITION? FUNCTION | PARTITION SCHEME
        | PROC | PROCEDURE | QUEUE | REMOTE SERVICE BINDING | RESOURCE POOL | ROLE | ROUTE | RULE | SCHEMA | SEARCH PROPERTY LIST
        | SECURITY POLICY | SEQUENCE | SERVER AUDIT SPECIFICATION? | SERVER ROLE | SERVICE | STATISTICS | SYNONYM | TABLE
        | TYPE | TRIGGER | USER | VIEW | WORKLOAD GROUP | XML SCHEMA COLLECTION)
    (IF EXISTS)? names_references
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-event-notification-transact-sql
// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-event-session-transact-sql
drop_event_notifications_or_session
    : EVENT (NOTIFICATION | SESSION) name_list ON (SERVER | DATABASE | QUEUE id)
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-external-library-transact-sql
drop_external_library
    : EXTERNAL LIBRARY id (AUTHORIZATION id)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-master-key-transact-sql
drop_master_key
    : MASTER KEY
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-database-encryption-key-transact-sql
drop_database_encryption_key
    : DATABASE ENCRYPTION KEY
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-signature-transact-sql
drop_signature
    : COUNTER? SIGNATURE FROM qualified_name BY (COMMA? (CERTIFICATE | ASYMMETRIC KEY) id)+
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-symmetric-key-transact-sql
drop_symmetric_key
    : SYMMETRIC KEY id (REMOVE PROVIDER KEY)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/disable-trigger-transact-sql
// https://docs.microsoft.com/en-us/sql/t-sql/statements/enable-trigger-transact-sql
enable_disable_trigger
    : (ENABLE | DISABLE) TRIGGER (names_references | ALL) ON (qualified_name | DATABASE | ALL SERVER)
    ;

names_references
    : name+=qualified_name (COMMA name+=qualified_name)*
    ;

lock_table
    : LOCK TABLE qualified_name IN (SHARE | EXCLUSIVE) MODE (WAIT DECIMAL | NOWAIT)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/truncate-table-transact-sql
truncate_table
    : TRUNCATE TABLE qualified_name (WITH LR_BRACKET PARTITIONS LR_BRACKET (COMMA? (expression | expression TO expression))+ RR_BRACKET RR_BRACKET)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-column-master-key-transact-sql
create_column_master_key
    : COLUMN MASTER KEY id WITH LR_BRACKET KEY_STORE_PROVIDER_NAME EQUAL STRING COMMA KEY_PATH EQUAL STRING RR_BRACKET
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-credential-transact-sql
alter_credential
    : CREDENTIAL id WITH IDENTITY EQUAL STRING (COMMA SECRET EQUAL STRING)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-credential-transact-sql
create_credential
    : CREDENTIAL id WITH IDENTITY EQUAL STRING (COMMA SECRET EQUAL STRING)? (FOR CRYPTOGRAPHIC PROVIDER id)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-cryptographic-provider-transact-sql
alter_cryptographic_provider
    : CRYPTOGRAPHIC PROVIDER id (FROM FILE EQUAL STRING)? (ENABLE | DISABLE)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-cryptographic-provider-transact-sql
create_cryptographic_provider
    : CRYPTOGRAPHIC PROVIDER id FROM FILE EQUAL STRING
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-event-notification-transact-sql
create_event_notification
    : EVENT NOTIFICATION id ON (SERVER | DATABASE | QUEUE id) (WITH FAN_IN)? FOR name_list TO SERVICE STRING COMMA STRING
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-event-session-transact-sql
// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-event-session-transact-sql
// todo: not implemented
create_or_alter_event_session
    : EVENT SESSION id ON SERVER (COMMA? (add_drop_event | add_drop_event_target))*
    create_or_alter_event_session_with? (STATE EQUAL (START|STOP))?
    ;

add_drop_event
    : ADD EVENT (id DOT)? id DOT id
    (LR_BRACKET
        (SET set_parameter (COMMA? set_parameter)*)?
        (ACTION LR_BRACKET (event_action (COMMA event_action)* RR_BRACKET))?
        (WHERE event_session_predicate_expression)?
    RR_BRACKET)?
    | DROP EVENT (id DOT)? id DOT id
    ;

event_action
    : (id DOT)? id DOT id
    ;

add_drop_event_target
    : ADD TARGET (id DOT)? id DOT id (LR_BRACKET SET set_parameter (COMMA? set_parameter)* RR_BRACKET)?
    | DROP TARGET (id DOT)? id DOT id
    ;

set_parameter
    : id EQUAL (LR_BRACKET? DECIMAL RR_BRACKET? |STRING)
    ;

create_or_alter_event_session_with
    : WITH LR_BRACKET
    (COMMA? MAX_MEMORY EQUAL DECIMAL (KB|MB))?
    (COMMA? EVENT_RETENTION_MODE EQUAL (ALLOW_SINGLE_EVENT_LOSS | ALLOW_MULTIPLE_EVENT_LOSS | NO_EVENT_LOSS))?
    (COMMA? MAX_DISPATCH_LATENCY EQUAL (DECIMAL SECONDS | INFINITE))?
    (COMMA? MAX_EVENT_SIZE EQUAL DECIMAL (KB|MB))?
    (COMMA? MEMORY_PARTITION_MODE EQUAL (NONE | PER_NODE | PER_CPU))?
    (COMMA? TRACK_CAUSALITY EQUAL on_off)?
    (COMMA? STARTUP_STATE EQUAL on_off)?
    RR_BRACKET
    ;

event_session_predicate_expression
    : (COMMA? (AND|OR)? NOT? (event_session_predicate_factor | LR_BRACKET event_session_predicate_expression RR_BRACKET))+
    ;

event_session_predicate_factor
    : event_session_predicate_leaf
    | LR_BRACKET event_session_predicate_expression RR_BRACKET
    ;

event_session_predicate_leaf
    : id
    | ((id DOT)? id DOT)? id (EQUAL | LESS GREATER | EXCLAMATION EQUAL | GREATER | GREATER EQUAL | LESS | LESS EQUAL) (DECIMAL | STRING)
    | (id DOT)? id DOT id LR_BRACKET (id | ((id DOT)? id DOT id) COMMA (DECIMAL | STRING)) RR_BRACKET
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-external-data-source-transact-sql
alter_external_data_source
    : EXTERNAL DATA SOURCE id SET (LOCATION EQUAL STRING COMMA? | RESOURCE_MANAGER_LOCATION EQUAL STRING COMMA? | CREDENTIAL EQUAL id)+
    | EXTERNAL DATA SOURCE id WITH LR_BRACKET TYPE EQUAL BLOB_STORAGE COMMA LOCATION EQUAL STRING (COMMA CREDENTIAL EQUAL id)? RR_BRACKET
    ;


// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-external-library-transact-sql
alter_external_library
    : EXTERNAL LIBRARY library_name=id (AUTHORIZATION id)? (SET|ADD) library_file_spec library_language
   ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-external-library-transact-sql
create_external_library
    : EXTERNAL LIBRARY id (AUTHORIZATION id)? FROM library_file_spec (COMMA library_file_spec)* library_language
    ;

library_file_spec
    : LR_BRACKET CONTENT EQUAL (STRING | BINARY | NONE) (COMMA PLATFORM EQUAL (WINDOWS | LINUX))? RR_BRACKET
    ;

library_language
    : WITH LR_BRACKET LANGUAGE EQUAL (R_LETTER | PYTHON | STRING) RR_BRACKET
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-external-resource-pool-transact-sql
alter_external_resource_pool
    : EXTERNAL RESOURCE POOL id (WITH LR_BRACKET external_resource_pool_option (COMMA external_resource_pool_option)* RR_BRACKET)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-external-resource-pool-transact-sql
create_external_resource_pool
    : EXTERNAL RESOURCE POOL id (WITH LR_BRACKET external_resource_pool_option (COMMA external_resource_pool_option)* RR_BRACKET)?
    ;

external_resource_pool_option
    : MAX_CPU_PERCENT EQUAL DECIMAL
    | MAX_MEMORY_PERCENT EQUAL DECIMAL
    | MAX_PROCESSES EQUAL DECIMAL
    ;

create_external_table
    : EXTERNAL TABLE qualified_name LR_BRACKET column_def_table_constraints RR_BRACKET
    WITH LR_BRACKET external_table_option (COMMA external_table_option)* RR_BRACKET
    ;

external_table_option
    : id EQUAL value=expression
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-fulltext-catalog-transact-sql
alter_fulltext_catalog
    : FULLTEXT CATALOG catalog_name=id (REBUILD (WITH ACCENT_SENSITIVITY EQUAL on_off)? | REORGANIZE | AS DEFAULT)
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-fulltext-catalog-transact-sql
create_fulltext_catalog
    : FULLTEXT CATALOG id
    (ON FILEGROUP id)?
    (IN PATH STRING)?
    (WITH ACCENT_SENSITIVITY EQUAL on_off)?
    (AS DEFAULT)?
    (AUTHORIZATION id)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-fulltext-stoplist-transact-sql
alter_fulltext_stoplist
    : FULLTEXT STOPLIST id ((ADD | DROP) STRING language_term | DROP ALL language_term?)
    ;

language_term
    : LANGUAGE (STRING | DECIMAL | BINARY)
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-fulltext-stoplist-transact-sql
create_fulltext_stoplist
    : FULLTEXT STOPLIST id (FROM ((id DOT)? id | SYSTEM STOPLIST))? (AUTHORIZATION id)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-login-transact-sql
alter_login_sql_server
    : LOGIN id
       ((ENABLE | DISABLE)? | WITH ((PASSWORD EQUAL (STRING | BINARY HASHED)) (MUST_CHANGE | UNLOCK)*)?
       (OLD_PASSWORD EQUAL STRING (MUST_CHANGE|UNLOCK)*)?
       (DEFAULT_DATABASE EQUAL id)? (DEFAULT_LANGUAGE EQUAL id)?
       (NAME EQUAL id)? (CHECK_POLICY EQUAL on_off)? (CHECK_EXPIRATION EQUAL on_off)?
       (CREDENTIAL EQUAL id)? (NO CREDENTIAL)? | (ADD|DROP) CREDENTIAL id)
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-login-transact-sql
create_login_sql_server
    : LOGIN id (WITH login_option_list | FROM login_sources)
    ;

login_option_list
    : PASSWORD EQUAL (STRING | BINARY HASHED) MUST_CHANGE? (COMMA login_sub_option_list)*
    ;

login_sub_option_list
    : SID EQUAL BINARY
    | DEFAULT_DATABASE EQUAL id
    | DEFAULT_LANGUAGE EQUAL STRING
    | CHECK_EXPIRATION EQUAL on_off
    | CHECK_POLICY EQUAL on_off
    | CREDENTIAL EQUAL id
    ;

login_sources
    : WINDOWS (WITH windows_options (COMMA windows_options)*)?
    | CERTIFICATE id
    | ASYMMETRIC KEY id
    ;

windows_options
    : DEFAULT_DATABASE EQUAL id
    | DEFAULT_LANGUAGE EQUAL STRING
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-master-key-transact-sql
alter_master_key_sql_server
    : MASTER KEY
        ((FORCE)? REGENERATE WITH ENCRYPTION BY PASSWORD EQUAL STRING
        | (ADD | DROP) ENCRYPTION BY (SERVICE MASTER KEY | PASSWORD EQUAL STRING))
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-master-key-transact-sql
create_master_key_sql_server
    : MASTER KEY (ENCRYPTION BY PASSWORD EQUAL STRING)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-message-type-transact-sql
alter_message_type
    : MESSAGE TYPE id VALIDATION EQUAL (NONE | EMPTY | WELL_FORMED_XML | VALID_XML WITH SCHEMA COLLECTION id)
    ;

create_partition_function
    : PARTITION FUNCTION id LR_BRACKET data_type RR_BRACKET
    AS RANGE (LEFT | RIGHT)? FOR VALUES
    LR_BRACKET expression_list? RR_BRACKET
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-partition-function-transact-sql
alter_partition_function
    : PARTITION FUNCTION id LR_BRACKET RR_BRACKET (SPLIT | MERGE) RANGE LR_BRACKET expression RR_BRACKET
    ;

create_partition_scheme
    : PARTITION SCHEME id AS PARTITION id ALL? TO LR_BRACKET id_or_primary (COMMA id_or_primary)* RR_BRACKET
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-partition-scheme-transact-sql
alter_partition_scheme
    : PARTITION SCHEME partition_scheme_name=id NEXT USED (id)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-remote-service-binding-transact-sql
alter_remote_service_binding
    : REMOTE SERVICE BINDING id WITH (USER EQUAL id)? (COMMA ANONYMOUS EQUAL on_off)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-remote-service-binding-transact-sql
create_remote_service_binding
    : REMOTE SERVICE BINDING id (AUTHORIZATION id)? TO SERVICE STRING WITH USER EQUAL id (COMMA ANONYMOUS EQUAL on_off)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-resource-pool-transact-sql
create_or_alter_resource_pool
    : RESOURCE POOL pool_name=id
        (WITH
            LR_BRACKET
               (COMMA? MIN_CPU_PERCENT EQUAL DECIMAL)?
               (COMMA? MAX_CPU_PERCENT EQUAL DECIMAL)?
               (COMMA? CAP_CPU_PERCENT EQUAL DECIMAL)?
               (COMMA? AFFINITY SCHEDULER EQUAL
                                  (AUTO
                                   | LR_BRACKET (COMMA? (DECIMAL|DECIMAL TO DECIMAL))+ RR_BRACKET
                                   | NUMANODE EQUAL LR_BRACKET (COMMA? (DECIMAL|DECIMAL TO DECIMAL))+ RR_BRACKET
                                  )
              )?
               (COMMA? MIN_MEMORY_PERCENT EQUAL DECIMAL)?
               (COMMA? MAX_MEMORY_PERCENT EQUAL DECIMAL)?
               (COMMA? MIN_IOPS_PER_VOLUME EQUAL DECIMAL)?
               (COMMA? MAX_IOPS_PER_VOLUME EQUAL DECIMAL)?
            RR_BRACKET
       )?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-resource-governor-transact-sql
alter_resource_governor
    : RESOURCE GOVERNOR
        ((DISABLE | RECONFIGURE)
        | WITH LR_BRACKET CLASSIFIER_FUNCTION EQUAL (qualified_name | NULL) RR_BRACKET
        | RESET STATISTICS
        | WITH LR_BRACKET MAX_OUTSTANDING_IO_PER_VOLUME EQUAL DECIMAL RR_BRACKET)
    ;

alter_route
    : ROUTE id WITH
    (SERVICE_NAME EQUAL STRING COMMA?)?
    (BROKER_INSTANCE EQUAL STRING COMMA?)?
    (LIFETIME EQUAL DECIMAL COMMA?)?
    (ADDRESS EQUAL STRING COMMA?)?
    (MIRROR_ADDRESS EQUAL STRING)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-role-transact-sql
alter_db_role
    : ROLE role_name=id ((ADD|DROP) MEMBER database_principal=id | WITH NAME EQUAL new_role_name=id)
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-role-transact-sql
create_db_role
    : ROLE role_name=id (AUTHORIZATION owner_name=id)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-route-transact-sql
create_route
    : ROUTE route_name=id (AUTHORIZATION id)? WITH
    (COMMA? SERVICE_NAME EQUAL route_service_name=STRING)?
    (COMMA? BROKER_INSTANCE EQUAL broker_instance_identifier=STRING)?
    (COMMA? LIFETIME EQUAL DECIMAL)?
    COMMA? ADDRESS EQUAL STRING
    (COMMA MIRROR_ADDRESS EQUAL STRING)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-rule-transact-sql
create_rule
    : RULE qualified_name AS search_condition
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-schema-transact-sql
alter_schema_sql
    : SCHEMA schema_name=id TRANSFER ((OBJECT | TYPE | XML SCHEMA COLLECTION) COLON COLON)? (id DOT)? id
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-schema-transact-sql
create_schema
    : SCHEMA schema_name=id (AUTHORIZATION owner_name=id)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-search-property-list-transact-sql
create_search_property_list
    : SEARCH PROPERTY LIST id (FROM (id DOT)? id)? (AUTHORIZATION id)?
    ;

alter_search_property_list
    : SEARCH PROPERTY LIST id add_drop_property
    ;

add_drop_property
    : ADD id WITH LR_BRACKET
    PROPERTY_SET_GUID EQUAL id COMMA PROPERTY_INT_ID EQUAL DECIMAL
    (COMMA PROPERTY_DESCRIPTION EQUAL STRING)?
    RR_BRACKET
    | DROP id
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-security-policy-transact-sql
create_security_policy
    : SECURITY POLICY qualified_name
        (COMMA? ADD (FILTER|BLOCK)? PREDICATE qualified_name
            LR_BRACKET expression_list RR_BRACKET ON qualified_name (COMMA? block_dml_operation)*)+
    (WITH LR_BRACKET STATE EQUAL on_off (SCHEMABINDING on_off)? RR_BRACKET)? not_for_replication?
    ;

alter_security_policy
    : SECURITY POLICY qualified_name
    LR_BRACKET? add_alter_drop_predicate (COMMA add_alter_drop_predicate)* RR_BRACKET?
    (WITH LR_BRACKET STATE EQUAL on_off RR_BRACKET)? not_for_replication?
    ;

add_alter_drop_predicate
    : (ADD | ALTER) (FILTER | BLOCK) PREDICATE qualified_name LR_BRACKET expression_list RR_BRACKET ON qualified_name block_dml_operation?
    | DROP (FILTER | BLOCK) PREDICATE ON qualified_name
    ;

block_dml_operation
    : AFTER (INSERT | UPDATE)
    | BEFORE (UPDATE | DELETE)
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-sequence-transact-sql
alter_sequence
    : SEQUENCE qualified_name (sequence_body | RESTART (WITH restart=signed_numerical_literal)?) *
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-sequence-transact-sql
create_sequence
    : SEQUENCE qualified_name (sequence_body)*
    ;

sequence_body
    : AS data_type
    | START WITH start_val=signed_numerical_literal
    | INCREMENT BY incr=signed_numerical_literal
    | (MINVALUE minval=signed_numerical_literal | NO MINVALUE)
    | (MAXVALUE maxval=signed_numerical_literal | NO MAXVALUE)
    | cycle_true = NO? cycle_val=CYCLE
    | (CACHE cache_val=signed_numerical_literal? | NO CACHE)
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-server-audit-transact-sql
alter_server_audit
    : SERVER AUDIT audit_name=id
        ((TO
              (FILE
                (LR_BRACKET
                   (COMMA? FILEPATH EQUAL filepath=STRING
                    | COMMA? MAXSIZE EQUAL (DECIMAL (MB|GB|TB)
                    |  UNLIMITED
                   )
                   | COMMA? MAX_ROLLOVER_FILES EQUAL max_rollover_files=(DECIMAL|UNLIMITED)
                   | COMMA? MAX_FILES EQUAL max_files=DECIMAL
                   | COMMA? RESERVE_DISK_SPACE EQUAL on_off )*
                 RR_BRACKET)
                | APPLICATION_LOG
                | SECURITY_LOG
            ))?
            (WITH LR_BRACKET
              (COMMA? QUEUE_DELAY EQUAL queue_delay=DECIMAL
              | COMMA? ON_FAILURE EQUAL (CONTINUE | SHUTDOWN|FAIL_OPERATION)
              |COMMA?  STATE EQUAL on_off)*
              RR_BRACKET
             )?
            (WHERE (COMMA? (NOT?) event_field_name=id
                                    (EQUAL
                                    |(LESS GREATER)
                                    | (EXCLAMATION EQUAL)
                                    | GREATER
                                    | (GREATER EQUAL)
                                    | LESS
                                    | LESS EQUAL
                                   )
                                      (DECIMAL | STRING)
                    | COMMA? (AND|OR) NOT? (EQUAL
                                           |(LESS GREATER)
                                           | (EXCLAMATION EQUAL)
                                           | GREATER
                                           | (GREATER EQUAL)
                                           | LESS
                                           | LESS EQUAL)
                                             (DECIMAL | STRING)))?
        |REMOVE WHERE
        | MODIFY NAME EQUAL new_audit_name=id
      )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-server-audit-transact-sql
create_server_audit
    : SERVER AUDIT audit_name=id
        ((TO
              (FILE
                (LR_BRACKET
                   (COMMA? FILEPATH EQUAL filepath=STRING
                    | COMMA? MAXSIZE EQUAL (DECIMAL (MB|GB|TB)
                    |  UNLIMITED
                  )
                   | COMMA? MAX_ROLLOVER_FILES EQUAL max_rollover_files=(DECIMAL|UNLIMITED)
                   | COMMA? MAX_FILES EQUAL max_files=DECIMAL
                   | COMMA? RESERVE_DISK_SPACE EQUAL on_off )*
                 RR_BRACKET)
                | APPLICATION_LOG
                | SECURITY_LOG
           ))?
            (WITH LR_BRACKET
              (COMMA? QUEUE_DELAY EQUAL queue_delay=DECIMAL
              | COMMA? ON_FAILURE EQUAL (CONTINUE | SHUTDOWN|FAIL_OPERATION)
              |COMMA?  STATE EQUAL on_off
              |COMMA? AUDIT_GUID EQUAL audit_guid=id
           )*

              RR_BRACKET
           )?
            (WHERE (COMMA? (NOT?) event_field_name=id
                                    (EQUAL
                                    |(LESS GREATER)
                                    | (EXCLAMATION EQUAL)
                                    | GREATER
                                    | (GREATER EQUAL)
                                    | LESS
                                    | LESS EQUAL
                                   )
                                      (DECIMAL | STRING)
                    | COMMA? (AND|OR) NOT? (EQUAL
                                           |(LESS GREATER)
                                           | (EXCLAMATION EQUAL)
                                           | GREATER
                                           | (GREATER EQUAL)
                                           | LESS
                                           | LESS EQUAL)
                                             (DECIMAL | STRING)))?
        |REMOVE WHERE
        | MODIFY NAME EQUAL new_audit_name=id
      )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-server-audit-specification-transact-sql

alter_server_audit_specification
    : SERVER AUDIT SPECIFICATION audit_specification_name=id
       (FOR SERVER AUDIT audit_name=id)?
       ((ADD|DROP) LR_BRACKET  audit_action_group_name=id RR_BRACKET)*
         (WITH LR_BRACKET STATE EQUAL on_off RR_BRACKET)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-server-audit-specification-transact-sql
create_server_audit_specification
    : SERVER AUDIT SPECIFICATION audit_specification_name=id
       (FOR SERVER AUDIT audit_name=id)?
       (ADD LR_BRACKET  audit_action_group_name=id RR_BRACKET)*
         (WITH LR_BRACKET STATE EQUAL on_off RR_BRACKET)?
    ;


// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-server-configuration-transact-sql

alter_server_configuration
    : SERVER CONFIGURATION
      SET  ((PROCESS AFFINITY
          (CPU EQUAL (AUTO | (COMMA? DECIMAL | COMMA? DECIMAL TO DECIMAL)+)
              | NUMANODE EQUAL (COMMA? DECIMAL |COMMA?  DECIMAL TO DECIMAL)+)
              | DIAGNOSTICS LOG (ON|OFF|PATH EQUAL (STRING | DEFAULT)
              |MAX_SIZE EQUAL (DECIMAL MB |DEFAULT)|MAX_FILES EQUAL (DECIMAL|DEFAULT)
             )
          | FAILOVER CLUSTER PROPERTY (VERBOSELOGGING EQUAL (STRING|DEFAULT)
          | SQLDUMPERFLAGS EQUAL (STRING|DEFAULT)
          | SQLDUMPERPATH EQUAL (STRING|DEFAULT)
          | SQLDUMPERTIMEOUT (STRING|DEFAULT)
          | FAILURECONDITIONLEVEL EQUAL (STRING|DEFAULT)
          | HEALTHCHECKTIMEOUT EQUAL (DECIMAL|DEFAULT)
          ) | HADR CLUSTER CONTEXT EQUAL (STRING|LOCAL)
          | BUFFER POOL EXTENSION (ON LR_BRACKET FILENAME EQUAL STRING COMMA SIZE EQUAL DECIMAL (KB|MB|GB)  RR_BRACKET | OFF)
          | SET SOFTNUMA on_off
      ))
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-server-role-transact-sql
alter_server_role
    : SERVER ROLE id ((ADD|DROP) MEMBER id | WITH NAME EQUAL id)
    ;
// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-server-role-transact-sql
create_server_role
    : SERVER ROLE id (AUTHORIZATION id)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-service-transact-sql
alter_service
    : SERVICE id (ON QUEUE qualified_name)? (COMMA? (ADD|DROP) id)*
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-service-transact-sql
create_service
    : SERVICE id (AUTHORIZATION id)? ON QUEUE qualified_name (LR_BRACKET (COMMA? id_or_default)+ RR_BRACKET)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-service-master-key-transact-sql
alter_service_master_key
    : SERVICE MASTER KEY
    (FORCE? REGENERATE | WITH (OLD_ACCOUNT | NEW_ACCOUNT) EQUAL STRING COMMA (OLD_PASSWORD | NEW_PASSWORD) EQUAL STRING)
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-synonym-transact-sql
create_synonym
    : SYNONYM qualified_name FOR qualified_name
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-user-transact-sql
alter_user
    : USER username=id WITH (COMMA? NAME EQUAL newusername=id
        | COMMA? DEFAULT_SCHEMA EQUAL (schema_name=id |NULL)
        | COMMA? LOGIN EQUAL loginame=id
        | COMMA? PASSWORD EQUAL STRING (OLD_PASSWORD EQUAL STRING)+
        | COMMA? DEFAULT_LANGUAGE EQUAL (NONE| lcid=DECIMAL| language_name_or_alias=id)
        | COMMA? ALLOW_ENCRYPTED_VALUE_MODIFICATIONS EQUAL on_off)+
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-user-transact-sql
create_user
    : USER user_name=id user_login?
    (FROM EXTERNAL PROVIDER)?
    (WITH user_option (COMMA user_option)*)?
    ((FOR|FROM) (CERTIFICATE | ASYMMETRIC KEY) cert_or_asym_key_name=id)?
    ;

user_login
    : (FOR|FROM) LOGIN id
    | WITHOUT LOGIN
    ;

user_option
    : DEFAULT_SCHEMA EQUAL schema_name=id
    | DEFAULT_LANGUAGE EQUAL (NONE | DECIMAL | language_name_or_alias=id)
    | SID EQUAL BINARY
    | ALLOW_ENCRYPTED_VALUE_MODIFICATIONS EQUAL on_off
    | PASSWORD EQUAL STRING
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-workload-group-transact-sql
alter_workload_group
    : WORKLOAD GROUP workload_group_group_name=id
         (WITH LR_BRACKET
           (IMPORTANCE EQUAL (LOW|MEDIUM|HIGH)
           | COMMA? REQUEST_MAX_MEMORY_GRANT_PERCENT EQUAL request_max_memory_grant=DECIMAL
           | COMMA? REQUEST_MAX_CPU_TIME_SEC EQUAL request_max_cpu_time_sec=DECIMAL
           | REQUEST_MEMORY_GRANT_TIMEOUT_SEC EQUAL request_memory_grant_timeout_sec=DECIMAL
           | MAX_DOP EQUAL max_dop=DECIMAL
           | GROUP_MAX_REQUESTS EQUAL group_max_requests=DECIMAL)+
          RR_BRACKET)?
    (USING workload_group_pool_name=id)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-workload-group-transact-sql
create_workload_group
    : WORKLOAD GROUP workload_group_group_name=id
         (WITH LR_BRACKET
           (IMPORTANCE EQUAL (LOW|MEDIUM|HIGH)
           | COMMA? REQUEST_MAX_MEMORY_GRANT_PERCENT EQUAL request_max_memory_grant=DECIMAL
           | COMMA? REQUEST_MAX_CPU_TIME_SEC EQUAL request_max_cpu_time_sec=DECIMAL
           | REQUEST_MEMORY_GRANT_TIMEOUT_SEC EQUAL request_memory_grant_timeout_sec=DECIMAL
           | MAX_DOP EQUAL max_dop=DECIMAL
           | GROUP_MAX_REQUESTS EQUAL group_max_requests=DECIMAL)+
          RR_BRACKET)?
    (USING workload_group_pool_name=id? (COMMA? EXTERNAL external_pool_name=id)?)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-xml-schema-collection-transact-sql
create_xml_schema_collection
    : XML SCHEMA COLLECTION (id DOT)? id AS string_id_local_id
    ;

alter_xml_schema_collection
    : XML SCHEMA COLLECTION (id DOT)? id ADD string_id_local_id
    ;

create_queue
    : QUEUE qualified_name queue_settings? (ON id | DEFAULT)?
    ;

queue_settings
    : WITH
    (STATUS EQUAL on_off COMMA?)?
    (RETENTION EQUAL on_off COMMA?)?
    (ACTIVATION LR_BRACKET
        ((STATUS EQUAL on_off COMMA?)?
        (PROCEDURE_NAME EQUAL qualified_name COMMA?)?
        (MAX_QUEUE_READERS EQUAL max_readers=DECIMAL COMMA?)?
        (execute_clause COMMA?)?
        | DROP)
    RR_BRACKET COMMA?)?
    (POISON_MESSAGE_HANDLING LR_BRACKET (STATUS EQUAL on_off) RR_BRACKET)?
    ;

alter_queue
    : QUEUE qualified_name (queue_settings | queue_action)
    ;

queue_action
    : REBUILD (WITH LR_BRACKET queue_rebuild_options RR_BRACKET)?
    | REORGANIZE (WITH LOB_COMPACTION EQUAL on_off)?
    | MOVE TO id_or_default
    ;

queue_rebuild_options
    : MAXDOP EQUAL DECIMAL
    ;

create_contract
    : CONTRACT expression (AUTHORIZATION id)?
    LR_BRACKET (id_or_default? SENT BY (INITIATOR | TARGET | ANY) COMMA?)+ RR_BRACKET
    ;

conversation_statement
    : begin_conversation_timer
    | begin_conversation_dialog
    | end_conversation
    | get_conversation
    | send_conversation
    | waitfor_conversation
    | move_conversation
    ;

create_message_type
    : MESSAGE TYPE id (AUTHORIZATION id)?
    VALIDATION EQUAL (NONE | EMPTY | WELL_FORMED_XML | VALID_XML WITH SCHEMA COLLECTION id)
    ;

// DML

// https://docs.microsoft.com/en-us/sql/t-sql/statements/merge-transact-sql
merge_statement
    : with_expression? MERGE (TOP LR_BRACKET expression RR_BRACKET PERCENT?)?
    INTO? (qualified_name | LOCAL_ID) insert_with_table_hints? as_table_alias?
    USING from_item (COMMA from_item)* ON search_condition
    merge_when*
    output_clause? option_clause?
    ;

merge_when
    : WHEN MATCHED (AND search_condition)? THEN merge_matched
    | WHEN NOT MATCHED (BY TARGET)? (AND search_condition)? THEN merge_not_matched
    | WHEN NOT MATCHED BY SOURCE (AND search_condition)? THEN merge_matched
    ;

merge_matched
    : UPDATE SET update_elem (COMMA update_elem)*
    | DELETE
    ;

merge_not_matched
    : INSERT name_list_in_brackets? (table_value_constructor | DEFAULT VALUES)
    ;

// https://msdn.microsoft.com/en-us/library/ms189835.aspx
delete_statement
    : with_expression? DELETE (TOP top_count)?
    FROM? (qualified_name | rowset_function_limited | LOCAL_ID)
    insert_with_table_hints?
    output_clause?
    (FROM from_item (COMMA from_item)*)?
    (WHERE (search_condition | CURRENT OF (GLOBAL? cursor_name | cursor_var=LOCAL_ID)))?
    for_clause? option_clause?
    ;

// https://msdn.microsoft.com/en-us/library/ms174335.aspx
insert_statement
    : with_expression?
    INSERT (TOP LR_BRACKET expression RR_BRACKET PERCENT?)?
    INTO? (qualified_name | rowset_function_limited | LOCAL_ID)
    insert_with_table_hints?
    name_list_in_brackets?
    output_clause?
    (select_statement | execute_statement | DEFAULT VALUES)
    for_clause? option_clause?
    ;

waitfor_receive
    : LR_BRACKET receive_statement RR_BRACKET (COMMA TIMEOUT timeout=time)?
    ;

receive_statement
    : RECEIVE top_clause? receive_column_specifier (COMMA receive_column_specifier)*
    FROM qualified_name (INTO LOCAL_ID)? (WHERE search_condition)?
    ;

receive_column_specifier
    : STAR
    | expression AS? column_alias?
    ;

// https://msdn.microsoft.com/en-us/library/ms189499.aspx
select_statement
    : with_expression? select_ops for_clause? option_clause?
    ;

// select_stmt copy that doesn't consume external parens
// for use in vex
// we let the expression rule to consume as many parens as it can
select_stmt_no_parens
    : with_expression? select_ops_no_parens for_clause? option_clause?
    ;

select_ops
    : LR_BRACKET select_statement RR_BRACKET //  parens can be used to apply "global" clauses (WITH etc) to a particular select in UNION expr
    | select_ops (INTERSECT | UNION | EXCEPT) set_qualifier? select_ops
    | query_specification
    ;

select_ops_no_parens
    : select_ops (INTERSECT | UNION | EXCEPT) set_qualifier? select_ops
    | query_specification
    ;

set_qualifier
    : DISTINCT
    | ALL
    ;

time
    : LOCAL_ID
    | constant
    ;

// https://msdn.microsoft.com/en-us/library/ms177523.aspx
update_statement
    : with_expression?
    UPDATE (TOP LR_BRACKET expression RR_BRACKET PERCENT?)?
    (qualified_name | rowset_function_limited | LOCAL_ID)
    with_table_hints?
    SET update_elem (COMMA update_elem)*
    output_clause?
    (FROM from_item (COMMA from_item)*)?
    (WHERE (search_condition | CURRENT OF (GLOBAL? cursor_name | cursor_var=LOCAL_ID)))?
    for_clause? option_clause?
    ;

// https://msdn.microsoft.com/en-us/library/ms177564.aspx
output_clause
    : OUTPUT output_dml_list_elem (COMMA output_dml_list_elem)*
    (INTO (LOCAL_ID | qualified_name) name_list_in_brackets?)?
    ;

output_dml_list_elem
    : expression (DOT STAR)? (AS? column_alias)?
    ;

// DDL

// https://msdn.microsoft.com/en-ie/library/ms176061.aspx
create_database
    : DATABASE database = id
    (CONTAINMENT EQUAL (NONE | PARTIAL))?
    (ON
       PRIMARY? file_spec (COMMA file_spec)*
       (COMMA file_group)*
       (LOG ON file_spec (COMMA file_spec)*)?
   )?
    (COLLATE id)?
    (WITH create_database_option (COMMA create_database_option)*)?
    ;

create_database_encryption_key
    : DATABASE ENCRYPTION KEY WITH base_algorithm ENCRYPTION BY SERVER (CERTIFICATE | ASYMMETRIC KEY) id
    ;

create_database_scoped_credential
    : DATABASE SCOPED CREDENTIAL credential_name=id WITH IDENTITY EQUAL STRING (COMMA SECRET EQUAL STRING)?
    ;

create_default
    : DEFAULT qualified_name AS expression
    ;

alter_fulltext_index
    : FULLTEXT INDEX ON qualified_name alter_fulltext_index_option
    ;

alter_fulltext_index_option
    : ENABLE
    | DISABLE
    | SET CHANGE_TRACKING EQUAL? (MANUAL | AUTO | OFF)
    | ADD fulltext_index_columns with_no_population?
    | ALTER COLUMN column_name=id (ADD | DROP) STATISTICAL_SEMANTICS with_no_population?
    | DROP name_list_in_brackets with_no_population?
    | START (FULL | INCREMENTAL | UPDATE) POPULATION
    | (STOP | PAUSE | RESUME) POPULATION
    | SET STOPLIST EQUAL? (OFF| SYSTEM | stoplist_name=id) with_no_population?
    | SET SEARCH PROPERTY LIST EQUAL? (OFF | property_list_name=id) with_no_population?
    ;

with_no_population
    : WITH NO POPULATION
    ;

create_fulltext_index
    : FULLTEXT INDEX ON qualified_name fulltext_index_columns?
    KEY INDEX id (ON catalog_filegroup_option)?
    fulltext_index_options?
    ;

fulltext_index_columns
    : LR_BRACKET fulltext_index_column (COMMA fulltext_index_column)* RR_BRACKET
    ;

fulltext_index_column
    : column_name=id (TYPE COLUMN type_column_name=data_type)? language_term? STATISTICAL_SEMANTICS?
    ;

fulltext_index_options
    : WITH LR_BRACKET? fulltext_index_option (COMMA fulltext_index_option)* RR_BRACKET?
    ;

catalog_filegroup_option
    : id
    | LR_BRACKET id COMMA FILEGROUP id RR_BRACKET
    | LR_BRACKET FILEGROUP id COMMA id RR_BRACKET
    | LR_BRACKET FILEGROUP id RR_BRACKET
    ;

fulltext_index_option
    : CHANGE_TRACKING EQUAL? (MANUAL | AUTO | OFF (COMMA NO POPULATION)?)
    | STOPLIST EQUAL? (OFF | SYSTEM | stoplist_name=id)
    | SEARCH PROPERTY LIST EQUAL? property_list_name=id
    ;

create_selective_index
    : SELECTIVE XML INDEX index_name LR_BRACKET id RR_BRACKET
    (WITH XMLNAMESPACES LR_BRACKET xmlnamespace_list RR_BRACKET)?
    FOR LR_BRACKET promoted_node_path_list RR_BRACKET
    index_options?
    ;

xmlnamespace_list
    : xmlnamespace_item (COMMA xmlnamespace_list)?
    ;

xmlnamespace_item
    : string_id_local_id AS string_id_local_id
    ;

promoted_node_path_list
    : named_promoted_node_path_item (COMMA named_promoted_node_path_item)*
    ;

named_promoted_node_path_item
    : string_id_local_id EQUAL node_path=string_id_local_id (AS (XQUERY expression function_call? | SQL data_type))? SINGLETON?
    ;

string_id_local_id
    : id
    | string_or_local_id
    ;

create_xml_index
    : PRIMARY? XML INDEX index_name LR_BRACKET id RR_BRACKET xml_index_using? index_options?
    ;

xml_index_using
    : USING XML INDEX name=id (FOR (VALUE | PATH | PROPERTY | LR_BRACKET id RR_BRACKET))?
    ;

// https://msdn.microsoft.com/en-us/library/ms188783.aspx
create_index
    : UNIQUE? clustered? INDEX index_name index_rest;

index_name
    : name=id ON table_name=qualified_name
    ;

index_rest
    : index_sort index_include? index_where? index_options? (ON id)?
    ;

index_sort
    : LR_BRACKET column_name_list_with_order RR_BRACKET
    ;

index_include
    : INCLUDE name_list_in_brackets
    ;

index_where
    : WHERE where=search_condition
    ;

// https://msdn.microsoft.com/en-us/library/ms187926(v=sql.120).aspx
create_or_alter_procedure
    : proc=(PROC | PROCEDURE) qualified_name (SEMI DECIMAL)?
      (LR_BRACKET? procedure_param (COMMA procedure_param)* RR_BRACKET?)?
      (WITH procedure_option (COMMA procedure_option)*)?
      (FOR REPLICATION)? AS proc_body
    ;

 proc_body
    : sql_clauses
    | EXTERNAL NAME assembly_specifier
    ;

create_or_alter_trigger
    : TRIGGER trigger_name=qualified_name
    ON (table_name=qualified_name | ALL SERVER | DATABASE)
    (WITH trigger_option (COMMA trigger_option)*)?
    (FOR | AFTER | INSTEAD OF) trigger_operation (COMMA trigger_operation)*
    (WITH APPEND)?
    not_for_replication?
    AS sql_clauses
    ;

not_for_replication
    : NOT FOR REPLICATION
    ;

trigger_option
    : ENCRYPTION
    | execute_clause
    ;

trigger_operation
    : INSERT
    | UPDATE
    | DELETE
    | simple_id
    ;

// https://msdn.microsoft.com/en-us/library/ms186755.aspx
create_or_alter_function
    : FUNCTION qualified_name LR_BRACKET (procedure_param (COMMA procedure_param)*)?  RR_BRACKET
    RETURNS func_return
    (WITH function_option (COMMA function_option)*)?
    AS? func_body
    ;

func_return
    : TABLE (LR_BRACKET column_def_table_constraints RR_BRACKET)?
    | LOCAL_ID TABLE LR_BRACKET column_def_table_constraints RR_BRACKET
    | data_type
    ;

func_body
    : RETURN select_statement
    | BEGIN sql_clauses? RETURN ret=expression? SEMI? END
    | EXTERNAL NAME assembly_specifier
    ;

assembly_specifier
    : assembly_name=id DOT class_name=id DOT method_name=id
    ;

procedure_param
    : name=LOCAL_ID AS? data_type null_notnull? (EQUAL default_val=default_value)? arg_mode? READONLY?
    ;

arg_mode
    : OUT
    | OUTPUT
    ;

procedure_option
    : ENCRYPTION
    | RECOMPILE
    | execute_clause
    ;

function_option
    : ENCRYPTION
    | SCHEMABINDING
    | RETURNS NULL ON NULL INPUT
    | CALLED ON NULL INPUT
    | execute_clause
    ;

// https://msdn.microsoft.com/en-us/library/ms188038.aspx
create_statistics
    : STATISTICS id ON table_name_with_hint name_list_in_brackets
    (WITH update_statistics_with_option (COMMA update_statistics_with_option)*)?
    ;

update_statistics
    : UPDATE STATISTICS table=qualified_name (index=qualified_name | LR_BRACKET names_references RR_BRACKET)?
    (WITH update_statistics_with_option (COMMA update_statistics_with_option)*)?
    ;

update_statistics_with_option
    : FULLSCAN (COMMA PERSIST_SAMPLE_PERSENT EQUAL on_off)?
    | SAMPLE DECIMAL (PERCENT | ROWS) (COMMA PERSIST_SAMPLE_PERSENT EQUAL on_off)?
    | RESAMPLE (ON PARTITIONS LR_BRACKET (COMMA? (DECIMAL | DECIMAL TO DECIMAL))+ RR_BRACKET)
    | NORECOMPUTE
    | INCREMENTAL EQUAL on_off
    | MAXDOP EQUAL DECIMAL
    ;

// https://msdn.microsoft.com/en-us/library/ms174979.aspx
create_table
    : TABLE qualified_name LR_BRACKET column_def_table_constraints COMMA? RR_BRACKET
    (ON tablespace=id_or_default (LR_BRACKET partition_col_name=id RR_BRACKET)?)?
    (TEXTIMAGE_ON textimage=id_or_default)?
    (FILESTREAM_ON filestream=id_or_default)?
    table_options*
    ;

id_or_default
    : id
    | DEFAULT
    ;

id_or_primary
    : id
    | PRIMARY
    ;

table_options
    : WITH (LR_BRACKET index_option (COMMA index_option)* RR_BRACKET | index_option (COMMA index_option)*)
    ;

// https://msdn.microsoft.com/en-us/library/ms187956.aspx
create_or_alter_view
    : VIEW qualified_name name_list_in_brackets?
    (WITH view_attribute (COMMA view_attribute)*)?
    AS select_statement (WITH CHECK OPTION)?
    ;

view_attribute
    : ENCRYPTION | SCHEMABINDING | VIEW_METADATA
    ;

// https://msdn.microsoft.com/en-us/library/ms190273.aspx
alter_table
    : TABLE name=qualified_name
    (SET LR_BRACKET LOCK_ESCALATION EQUAL (AUTO | TABLE | DISABLE) RR_BRACKET
        | (WITH (CHECK | nocheck_add=NOCHECK))? ADD column_def_table_constraints
        | ALTER COLUMN (column_definition | id  alter_column_option)
        | table_drop=DROP table_action_drop (COMMA table_action_drop)*
        | (WITH (CHECK | nocheck_check=NOCHECK))? (CHECK | nocheck=NOCHECK) CONSTRAINT (ALL | name_list)
        | (ENABLE | DISABLE) TRIGGER (ALL | name_list)
        | (ENABLE | DISABLE) CHANGE_TRACKING (WITH LR_BRACKET TRACK_COLUMNS_UPDATED EQUAL on_off RR_BRACKET)?
        | SWITCH (PARTITION expression)? TO qualified_name (PARTITION expression)? (WITH LR_BRACKET low_priority_lock_wait RR_BRACKET)?
        | REBUILD rebuild_options?)
    ;

table_action_drop
    : (COLUMN | CONSTRAINT?) (IF EXISTS)? name_list
    ;

rebuild_options
    : (PARTITION EQUAL (ALL|DECIMAL))? WITH
    LR_BRACKET simple_id EQUAL rebuild_option_value (COMMA simple_id EQUAL rebuild_option_value)* RR_BRACKET
    ;

rebuild_option_value
    : simple_id (ON (PARTITIONS LR_BRACKET DECIMAL RR_BRACKET)?| OFF)?
    | ON (LR_BRACKET low_priority_lock_wait RR_BRACKET)?
    | OFF
    | DECIMAL
    ;

low_priority_lock_wait
    : WAIT_AT_LOW_PRIORITY LR_BRACKET MAX_DURATION EQUAL time MINUTES? COMMA
           ABORT_AFTER_WAIT EQUAL (NONE | SELF | BLOCKERS) RR_BRACKET
    ;

// https://msdn.microsoft.com/en-us/library/ms174269.aspx
alter_database
    : DATABASE (database=id | CURRENT) (MODIFY NAME EQUAL new_name=id | COLLATE collation=id | file_and_filegroup_options | SET database_optionspec (WITH termination)?)
    ;

alter_database_encryption_key
    : DATABASE ENCRYPTION KEY (REGENERATE WITH base_algorithm)? (ENCRYPTION BY SERVER (CERTIFICATE | ASYMMETRIC KEY) id)?
    ;

alter_database_scoped_credential
    : DATABASE SCOPED CREDENTIAL id WITH IDENTITY EQUAL STRING (COMMA SECRET EQUAL STRING)?
    ;

// https://msdn.microsoft.com/en-us/library/bb522682.aspx
// Runtime check.
database_optionspec
    : AUTO_CLOSE on_off
    | AUTO_CREATE_STATISTICS (OFF | ON (INCREMENTAL EQUAL on_off)?)
    | AUTO_SHRINK  on_off
    | AUTO_UPDATE_STATISTICS on_off
    | AUTO_UPDATE_STATISTICS_ASYNC on_off
    | change_tracking_option
    | CONTAINMENT EQUAL (NONE | PARTIAL)
    | CURSOR_CLOSE_ON_COMMIT on_off
    | CURSOR_DEFAULT (LOCAL | GLOBAL)
    | database_mirroring_option
    | DATE_CORRELATION_OPTIMIZATION on_off
    | ENCRYPTION on_off
    | ONLINE
    | OFFLINE
    | EMERGENCY
    | READ_ONLY
    | READ_WRITE
    | SINGLE_USER
    | RESTRICTED_USER
    | MULTI_USER
    | DELAYED_DURABILITY EQUAL (DISABLED | ALLOWED | FORCED)
    | DB_CHAINING on_off
    | TRUSTWORTHY on_off
    | DEFAULT_LANGUAGE EQUAL (id | STRING)
    | DEFAULT_FULLTEXT_LANGUAGE EQUAL (id | STRING)
    | NESTED_TRIGGERS EQUAL on_off
    | TRANSFORM_NOISE_WORDS EQUAL on_off
    | TWO_DIGIT_YEAR_CUTOFF EQUAL DECIMAL
    | FILESTREAM database_filestream_option
    | HADR  (AVAILABILITY GROUP EQUAL id | OFF | SUSPEND | RESUME)
    | MIXED_PAGE_ALLOCATION on_off
    | PARAMETERIZATION (SIMPLE | FORCED)
//  | query_store_options
    | RECOVERY (FULL | BULK_LOGGED | SIMPLE)
    | TORN_PAGE_DETECTION on_off
    | PAGE_VERIFY (CHECKSUM | TORN_PAGE_DETECTION | NONE)
//  | remote_data_archive_option
    | ENABLE_BROKER
    | DISABLE_BROKER
    | NEW_BROKER
    | ERROR_BROKER_CONVERSATIONS
    | HONOR_BROKER_PRIORITY on_off
    | ALLOW_SNAPSHOT_ISOLATION on_off
    | READ_COMMITTED_SNAPSHOT on_off
    | MEMORY_OPTIMIZED_ELEVATE_TO_SNAPSHOT EQUAL on_off
    | ANSI_NULL_DEFAULT on_off
    | ANSI_NULLS on_off
    | ANSI_PADDING on_off
    | ANSI_WARNINGS on_off
    | ARITHABORT on_off
    | COMPATIBILITY_LEVEL EQUAL DECIMAL
    | CONCAT_NULL_YIELDS_NULL on_off
    | NUMERIC_ROUNDABORT on_off
    | QUOTED_IDENTIFIER on_off
    | RECURSIVE_TRIGGERS on_off
    | TARGET_RECOVERY_TIME EQUAL DECIMAL (SECONDS | MINUTES)
    | termination
    ;

change_tracking_option
    : CHANGE_TRACKING  EQUAL (OFF | ON (change_tracking_option_list (COMMA change_tracking_option_list)*)*)
    ;

change_tracking_option_list
    : AUTO_CLEANUP EQUAL on_off
    | CHANGE_RETENTION EQUAL (DAYS | HOURS | MINUTES)
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-endpoint-transact-sql
alter_endpoint
    : ENDPOINT id (AUTHORIZATION id)?
        (STATE EQUAL (STARTED | STOPPED | DISABLED))?
                AS TCP LR_BRACKET
                LISTENER_PORT EQUAL port=DECIMAL
                    (COMMA LISTENER_IP EQUAL (ALL | IPV4_ADDR | IPV6_ADDR | STRING))?
                    RR_BRACKET
                (TSQL
                |
                    FOR SERVICE_BROKER LR_BRACKET
                    AUTHENTICATION EQUAL
                            (WINDOWS (NTLM |KERBEROS | NEGOTIATE)?  (CERTIFICATE cert_name=id)?
                            | CERTIFICATE cert_name=id  WINDOWS? (NTLM |KERBEROS | NEGOTIATE)?
                           )
                    (COMMA? ENCRYPTION EQUAL (DISABLED |SUPPORTED | REQUIRED)
                        (ALGORITHM (AES | RC4 | AES RC4 | RC4 AES))?
                   )?

                    (COMMA? MESSAGE_FORWARDING EQUAL (ENABLED | DISABLED))?
                    (COMMA? MESSAGE_FORWARD_SIZE EQUAL DECIMAL)?
                    RR_BRACKET
                |
                FOR DATABASE_MIRRORING LR_BRACKET
                    AUTHENTICATION EQUAL
                            (WINDOWS (NTLM |KERBEROS | NEGOTIATE)?  (CERTIFICATE cert_name=id)?
                            | CERTIFICATE cert_name=id  WINDOWS? (NTLM |KERBEROS | NEGOTIATE)?
                           )

                    (COMMA? ENCRYPTION EQUAL (DISABLED |SUPPORTED | REQUIRED)
                        (ALGORITHM (AES | RC4 | AES RC4 | RC4 AES))?
                   )?

                    COMMA? ROLE EQUAL (WITNESS | PARTNER | ALL)
                    RR_BRACKET
               )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-endpoint-transact-sql
// todo: not implemented

/* Will visit later
*/
database_mirroring_option
    : PARTNER partner_option
    | WITNESS (EQUAL STRING | OFF)
    ;

partner_option
    : EQUAL STRING
    | FAILOVER
    | FORCE_SERVICE_ALLOW_DATA_LOSS
    | OFF
    | RESUME
    | SAFETY (FULL | OFF)
    | SUSPEND
    | TIMEOUT DECIMAL
    ;

termination
    : ROLLBACK AFTER DECIMAL
    | ROLLBACK IMMEDIATE
    | NO_WAIT
    ;

// https://msdn.microsoft.com/en-us/library/ms176118.aspx
drop_index
    : INDEX (IF EXISTS)? (index_name (COMMA index_name)* | drop_backward_compatible_index (COMMA drop_backward_compatible_index)*)
    ;

drop_backward_compatible_index
    : (owner_name=id DOT)? table_or_view_name=id DOT index=id
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-trigger-transact-sql
drop_ddl_trigger
    : TRIGGER (IF EXISTS)? names_references ON (DATABASE | ALL SERVER)
    ;

create_type
    : TYPE name=qualified_name type_definition
    ;

type_definition
    : FROM data_type null_notnull?
    | EXTERNAL NAME assembly_name=id (DOT class_name=id)?
    | AS TABLE LR_BRACKET column_def_table_constraints RR_BRACKET (WITH LR_BRACKET MEMORY_OPTIMIZED EQUAL on_off RR_BRACKET)?
    ;

rowset_function_limited
    : openquery
    | opendatasource
    ;

// https://msdn.microsoft.com/en-us/library/ms188427(v=sql.120).aspx
openquery
    : OPENQUERY LR_BRACKET linked_server=id COMMA query=STRING RR_BRACKET
    ;

// https://msdn.microsoft.com/en-us/library/ms179856.aspx
opendatasource
    : OPENDATASOURCE LR_BRACKET provider=STRING COMMA init=STRING RR_BRACKET DOT (database=id)? DOT (scheme=id)? DOT (table=id)
    ;

// Other statements.

// https://msdn.microsoft.com/en-us/library/ms188927.aspx
declare_statement
    : DECLARE LOCAL_ID AS? TABLE LR_BRACKET column_def_table_constraints RR_BRACKET
    | DECLARE declare_local (COMMA declare_local)*
    | DECLARE LOCAL_ID AS? XML LR_BRACKET (CONTENT | DOCUMENT)? xml_schema_collection RR_BRACKET
    | WITH XMLNAMESPACES LR_BRACKET xml_namespace_uri=STRING COMMA? AS id RR_BRACKET
    ;

// https://msdn.microsoft.com/en-us/library/ms181441(v=sql.120).aspx
cursor_statement
    // https://msdn.microsoft.com/en-us/library/ms175035(v=sql.120).aspx
    : (CLOSE | OPEN | DEALLOCATE) GLOBAL? cursor_name
    // https://msdn.microsoft.com/en-us/library/ms180169.aspx
    | DECLARE cursor_name (SEMI_SENSITIVE | INSENSITIVE)? SCROLL? cursor_common
    // https://msdn.microsoft.com/en-us/library/ms180152(v=sql.120).aspx
    | FETCH ((NEXT | PRIOR | FIRST | LAST | (ABSOLUTE | RELATIVE) expression)? FROM)?
    GLOBAL? cursor_name (INTO LOCAL_ID (COMMA LOCAL_ID)*)?
    ;
// https://docs.microsoft.com/en-us/sql/t-sql/statements/backup-transact-sql
backup_database
    : BACKUP DATABASE id
    (READ_WRITE_FILEGROUPS (COMMA? (FILE|FILEGROUP) EQUAL STRING)*)? (COMMA? (FILE|FILEGROUP) EQUAL STRING)*
    TO backup_device (COMMA backup_device)* mirror_to* (WITH backup_option (COMMA backup_option)*)?
    ;

backup_log
    : BACKUP LOG id TO backup_device (COMMA backup_device)* mirror_to* (WITH backup_option (COMMA backup_option)*)?
    ;

mirror_to
    : MIRROR TO backup_device (COMMA backup_device)*
    ;

backup_device
    : id
    | (DISK | TAPE | URL) EQUAL (STRING | id)
    ;

backup_option
    : DIFFERENTIAL
    | COPY_ONLY
    | COMPRESSION
    | NO_COMPRESSION
    | DESCRIPTION EQUAL (STRING | id)
    | NAME EQUAL id
    | CREDENTIAL
    | FILE_SNAPSHOT
    | EXPIREDATE EQUAL (STRING | id)
    | RETAINDAYS EQUAL (DECIMAL | id)
    | NOINIT
    | INIT
    | NOSKIP
    | SKIP_KEYWORD
    | NOFORMAT
    | FORMAT
    | MEDIADESCRIPTION EQUAL (STRING | id)
    | MEDIANAME EQUAL STRING
    | BLOCKSIZE EQUAL (DECIMAL | id)
    | BUFFERCOUNT EQUAL (DECIMAL | id)
    | MAXTRANSFER EQUAL (DECIMAL | id)
    | NO_CHECKSUM
    | CHECKSUM
    | STOP_ON_ERROR
    | CONTINUE_AFTER_ERROR
    | RESTART
    | STATS (EQUAL DECIMAL)?
    | REWIND
    | NOREWIND
    | LOAD
    | NOUNLOAD
    | NORECOVERY
    | STANDBY EQUAL STRING
    | NO_TRUNCATE
    | ENCRYPTION LR_BRACKET base_algorithm COMMA (SERVER (CERTIFICATE | ASYMMETRIC KEY)? EQUAL id) RR_BRACKET
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/backup-certificate-transact-sql
backup_certificate
    : BACKUP CERTIFICATE certname=id TO FILE EQUAL STRING (WITH PRIVATE KEY LR_BRACKET
        (COMMA? FILE EQUAL STRING
        |COMMA? ENCRYPTION BY PASSWORD EQUAL STRING
        |COMMA? DECRYPTION BY PASSWORD EQUAL STRING)+
    RR_BRACKET)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/backup-master-key-transact-sql
backup_master_key
    : BACKUP MASTER KEY TO FILE EQUAL STRING ENCRYPTION BY PASSWORD EQUAL STRING
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/backup-service-master-key-transact-sql
backup_service_master_key
    : BACKUP SERVICE MASTER KEY TO FILE EQUAL STRING ENCRYPTION BY PASSWORD EQUAL STRING
    ;

// https://msdn.microsoft.com/en-us/library/ms188332.aspx
execute_statement
    : EXECUTE (execute_string | execute_module)
    ;

execute_string
    : LR_BRACKET
    execute_string_part (PLUS execute_string_part)*
    (COMMA (default_value | id | (LOCAL_ID (OUTPUT | OUT)?)))*
    RR_BRACKET
    (AS (LOGIN | USER) EQUAL STRING)?
    (AT qualified_name)?
    ;

execute_string_part
    : LOCAL_ID
    | STRING
    ;

execute_module
    : (return_status=LOCAL_ID EQUAL)? (qualified_name (SEMI DECIMAL)? | LOCAL_ID)
    (execute_statement_arg (COMMA execute_statement_arg)*)?
    (WITH execute_option (COMMA execute_option)*)?
    ;

execute_statement_arg
    : (parameter=LOCAL_ID EQUAL)? (default_value | id | (LOCAL_ID (OUTPUT | OUT)?))
    ;

execute_option
    : RECOMPILE
    | RESULT SETS result_sets_value
    ;

result_sets_value
    : UNDEFINED
    | NONE
    | LR_BRACKET result_sets_definition (COMMA result_sets_definition)* RR_BRACKET
    ;

result_sets_definition
    : LR_BRACKET column_definition (COMMA column_definition) RR_BRACKET
    | AS (OBJECT | TYPE) qualified_name
    | AS FOR XML
    ;

// https://msdn.microsoft.com/en-us/library/ff848791.aspx
security_statement
    // https://msdn.microsoft.com/en-us/library/ms188354.aspx
    : execute_clause
    // https://msdn.microsoft.com/en-us/library/ms187965.aspx
    | rule_common
    // https://msdn.microsoft.com/en-us/library/ms178632.aspx
    | REVERT (WITH COOKIE EQUAL LOCAL_ID)?
    | open_key
    | close_key
    | add_signature
    ;

rule_common
    : (GRANT | DENY | REVOKE (GRANT OPTION FOR)?)
    (permissions | columns_permissions) object_type?
    (TO | FROM) name_list
    (WITH GRANT OPTION | CASCADE)? (AS as_principal=id)?
    ;

permissions
    : permission (COMMA permission)*
    ;

columns_permissions
    : table_column_privileges (COMMA table_column_privileges)*
    ;

table_column_privileges
    : permission name_list_in_brackets
    ;

permission
    : ALL PRIVILEGES?
    | ADMINISTER BULK OPERATIONS
    | ADMINISTER DATABASE BULK OPERATIONS
    | ALTER
    | ALTER ANY (APPLICATION ROLE | ASSEMBLY | ASYMMETRIC KEY | AVAILABILITY GROUP | CERTIFICATE | COLUMN ENCRYPTION KEY
                | COLUMN MASTER KEY | CONNECTION | CONTRACT | CREDENTIAL | DATABASE | DATABASE AUDIT
                | DATABASE DDL TRIGGER | DATABASE EVENT NOTIFICATION | DATABASE EVENT SESSION
                | DATABASE SCOPED CONFIGURATION | DATASPACE | ENDPOINT | EVENT NOTIFICATION | EVENT SESSION
                | EXTERNAL DATA SOURCE | EXTERNAL FILE FORMAT | EXTERNAL LIBRARY | FULLTEXT CATALOG | LINKED SERVER
                | LOGIN | MASK | MESSAGE TYPE | REMOTE SERVICE BINDING | ROLE | ROUTE | SCHEMA | SECURITY POLICY
                | SERVER AUDIT | SERVER ROLE | SERVICE | SYMMETRIC KEY | USER)
    | ALTER (RESOURCES | SERVER STATE | SETTINGS | TRACE)
    | AUTHENTICATE SERVER?
    | BACKUP DATABASE
    | BACKUP LOG
    | CHECKPOINT
    | CONNECT (ANY DATABASE | REPLICATION | SQL)?
    | CONTROL SERVER?
    | CREATE (AGGREGATE | ANY DATABASE | ASSEMBLY | ASYMMETRIC KEY | AVAILABILITY GROUP | CERTIFICATE | CONTRACT
             | DATABASE | DATABASE DDL EVENT NOTIFICATION | DDL EVENT NOTIFICATION | DEFAULT | ENDPOINT
             | EXTERNAL LIBRARY | FULLTEXT CATALOG | FUNCTION | MESSAGE TYPE | PROCEDURE | QUEUE
             | REMOTE SERVICE BINDING | ROLE | ROUTE | RULE | SCHEMA | SEQUENCE | SERVER ROLE | SERVICE | SYMMETRIC KEY
             | SYNONYM | TABLE | TRACE EVENT NOTIFICATION | TYPE | VIEW | XML SCHEMA COLLECTION)
    | DELETE
    | EXECUTE (ANY EXTERNAL SCRIPT)?
    | EXTERNAL ACCESS ASSEMBLY
    | IMPERSONATE (ANY LOGIN)?
    | INSERT
    | KILL DATABASE CONNECTION
    | RECEIVE
    | REFERENCES
    | SELECT (ALL USER SECURABLES)?
    | SEND
    | SHOWPLAN
    | SHUTDOWN
    | SUBSCRIBE QUERY NOTIFICATIONS
    | TAKE OWNERSHIP
    | UNMASK
    | UNSAFE ASSEMBLY
    | UPDATE
    | VIEW ANY COLUMN (ENCRYPTION | MASTER) KEY DEFINITION
    | VIEW ANY (DATABASE | DEFINITION)
    | VIEW (CHANGE TRACKING | DATABASE STATE | DEFINITION | SERVER STATE)
    ;

object_type
    : ON (type=class_type COLON COLON)? qualified_name name_list_in_brackets?
    ;

create_certificate
    : CERTIFICATE certificate_name=id (AUTHORIZATION id)?
    (FROM existing_keys | generate_new_keys)
    (ACTIVE FOR BEGIN DIALOG EQUAL on_off)?
    ;

existing_keys
    : ASSEMBLY assembly_name=id
    | EXECUTABLE? FILE EQUAL STRING (WITH (FORMAT EQUAL STRING)? PRIVATE KEY LR_BRACKET private_key_options RR_BRACKET)?
    ;

private_key_options
    : FILE EQUAL STRING (COMMA (DECRYPTION | ENCRYPTION) BY PASSWORD EQUAL STRING)?
    ;

generate_new_keys
    : (ENCRYPTION BY PASSWORD EQUAL STRING)? WITH SUBJECT EQUAL STRING (COMMA date_options)*
    ;

date_options
    : (START_DATE | EXPIRY_DATE) EQUAL STRING
    ;

open_key
    : OPEN SYMMETRIC KEY key_name=id DECRYPTION BY decryption_mechanism
    | OPEN MASTER KEY DECRYPTION BY PASSWORD EQUAL password=STRING
    ;

close_key
    : CLOSE SYMMETRIC KEY key_name=id
    | CLOSE ALL SYMMETRIC KEYS
    | CLOSE MASTER KEY
    ;

add_signature
    : ADD COUNTER? SIGNATURE TO (class_type COLON COLON)? qualified_name
    BY cripto_list (COMMA cripto_list)*
    ;

cripto_list
    : (CERTIFICATE | ASYMMETRIC KEY) id (WITH (PASSWORD EQUAL STRING | SIGNATURE EQUAL BINARY))?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-symmetric-key-transact-sql
create_key
    : SYMMETRIC KEY id (AUTHORIZATION id)? (FROM PROVIDER id)? WITH ((key_options | ENCRYPTION BY encryption_mechanism) COMMA?)+
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-symmetric-key-transact-sql
alter_symmetric_key
    : SYMMETRIC KEY id ((ADD | DROP) ENCRYPTION BY (CERTIFICATE id | PASSWORD EQUAL STRING | SYMMETRIC KEY id | ASYMMETRIC KEY id))
    ;

key_options
    : KEY_SOURCE EQUAL STRING
    | ALGORITHM EQUAL algorithm
    | IDENTITY_VALUE EQUAL STRING
    | PROVIDER_KEY_NAME EQUAL STRING
    | CREATION_DISPOSITION EQUAL (CREATE_NEW | OPEN_EXISTING)
    ;

algorithm
    : DES
    | TRIPLE_DES
    | TRIPLE_DES_3KEY
    | RC2
    | RC4
    | RC4_128
    | DESX
    | AES_128
    | AES_192
    | AES_256
    ;

base_algorithm
    : ALGORITHM EQUAL (AES_128 | AES_192 | AES_256 | TRIPLE_DES_3KEY)
    ;

encryption_mechanism
    : CERTIFICATE certificate_name=id
    | ASYMMETRIC KEY asym_key_name=id
    | SYMMETRIC KEY decrypting_Key_name=id
    | PASSWORD EQUAL STRING
    ;

decryption_mechanism
    : CERTIFICATE certificate_name=id (WITH PASSWORD EQUAL STRING)?
    | ASYMMETRIC KEY asym_key_name=id (WITH PASSWORD EQUAL STRING)?
    | SYMMETRIC KEY decrypting_Key_name=id
    | PASSWORD EQUAL STRING
    ;

// https://msdn.microsoft.com/en-us/library/ms190356.aspx
// https://msdn.microsoft.com/en-us/library/ms189484.aspx
set_statement
    : SET LOCAL_ID (DOT member_name=id)? EQUAL expression
    | SET LOCAL_ID assignment_operator expression
    | SET LOCAL_ID EQUAL cursor_common
    // https://msdn.microsoft.com/en-us/library/ms189837.aspx
    | set_special
    ;

// https://msdn.microsoft.com/en-us/library/ms174377.aspx
transaction_statement
    // https://msdn.microsoft.com/en-us/library/ms188386.aspx
    : BEGIN DISTRIBUTED (TRAN | TRANSACTION) (id | LOCAL_ID)?
    // https://msdn.microsoft.com/en-us/library/ms188929.aspx
    | BEGIN (TRAN | TRANSACTION) ((id | LOCAL_ID) (WITH MARK STRING)?)?
    // https://msdn.microsoft.com/en-us/library/ms190295.aspx
    | COMMIT (TRAN | TRANSACTION) ((id | LOCAL_ID) (WITH LR_BRACKET DELAYED_DURABILITY EQUAL on_off RR_BRACKET)?)?
    // https://msdn.microsoft.com/en-us/library/ms178628.aspx
    | COMMIT WORK?
    | COMMIT id
    | ROLLBACK id
    // https://msdn.microsoft.com/en-us/library/ms181299.aspx
    | ROLLBACK (TRAN | TRANSACTION) (id | LOCAL_ID)?
    // https://msdn.microsoft.com/en-us/library/ms174973.aspx
    | ROLLBACK WORK?
    // https://msdn.microsoft.com/en-us/library/ms188378.aspx
    | SAVE (TRAN | TRANSACTION) (id | LOCAL_ID)?
    ;

// https://msdn.microsoft.com/en-us/library/ms188037.aspx
go_statement
    : GO //(count=DECIMAL)?
    ;

// https://msdn.microsoft.com/en-us/library/ms188366.aspx
use_statement
    : USE database=id
    ;

setuser_statement
    : SETUSER user=STRING?
    ;

dbcc_clause
    : DBCC name=simple_id (LR_BRACKET expression_list RR_BRACKET)? (WITH names_references)?
    ;

execute_clause
    : EXECUTE AS execute_clause_user
    ;

execute_clause_user
    : (LOGIN | USER) EQUAL STRING (WITH (NO REVERT | COOKIE INTO LOCAL_ID))?
    | CALLER
    | SELF
    | OWNER
    | STRING
    ;

declare_local
    : LOCAL_ID AS? data_type (EQUAL expression)?
    ;

xml_schema_collection
    : ID DOT ID
    ;

column_def_table_constraints
    : column_def_table_constraint (COMMA column_def_table_constraint)*
    ;

column_def_table_constraint
    : id (data_type | AS expression) column_option* (MATERIALIZED | NOT MATERIALIZED)?
    | table_constraint
    | table_index
    ;

table_index
    : INDEX id UNIQUE? clustered? HASH? index_rest
    ;

// https://msdn.microsoft.com/en-us/library/ms187742.aspx
column_definition
    : id (data_type | AS expression) column_option*
    ;

column_option
    : PERSISTED
    | SPARSE
    | COLLATE collate=id
    | ROWGUIDCOL
    | NOT? NULL
    | IDENTITY identity_value? not_for_rep=not_for_replication?
    | (CONSTRAINT constraint=id)? column_constraint_body
    | (CONSTRAINT constraint=id)? DEFAULT expression (WITH VALUES)?
    | MASKED WITH LR_BRACKET FUNCTION EQUAL STRING RR_BRACKET
    | INDEX index=id clustered? index_options? (ON file_group_name=id)?
    ;

alter_column_option
    : (ADD|DROP) (ROWGUIDCOL|PERSISTED|SPARSE|not_for_replication)
    | ADD MASKED WITH LR_BRACKET FUNCTION EQUAL STRING RR_BRACKET
    | DROP MASKED
    ;

identity_value
    : (LR_BRACKET seed=signed_numerical_literal COMMA increment=signed_numerical_literal RR_BRACKET)
    ;

column_constraint_body
    : (PRIMARY KEY | UNIQUE) clustered? HASH? index_options?
    | CHECK not_for_replication? LR_BRACKET search_condition RR_BRACKET
    | (FOREIGN KEY)? REFERENCES qualified_name (LR_BRACKET id RR_BRACKET)? on_delete? on_update? not_for_replication?
    ;

// https://msdn.microsoft.com/en-us/library/ms188066.aspx
table_constraint
    : (CONSTRAINT constraint=id)? table_constraint_body
    ;

table_constraint_body
    : (PRIMARY KEY | UNIQUE) clustered? HASH? LR_BRACKET column_name_list_with_order RR_BRACKET index_options? (ON id)?
    | CHECK not_for_replication? LR_BRACKET search_condition RR_BRACKET
    | DEFAULT expression FOR id
    | FOREIGN KEY fk=name_list_in_brackets REFERENCES qualified_name pk=name_list_in_brackets? on_delete? on_update? not_for_replication?
    ;

on_delete
    : ON DELETE (NO ACTION | CASCADE | SET NULL | SET DEFAULT)
    ;

on_update
    : ON UPDATE (NO ACTION | CASCADE | SET NULL | SET DEFAULT)
    ;

index_options
    : WITH LR_BRACKET index_option (COMMA index_option)* RR_BRACKET
    ;

// https://msdn.microsoft.com/en-us/library/ms186869.aspx
// Id runtime checking. Id in (PAD_INDEX, FILLFACTOR, IGNORE_DUP_KEY, STATISTICS_NORECOMPUTE, ALLOW_ROW_LOCKS,
// ALLOW_PAGE_LOCKS, SORT_IN_TEMPDB, ONLINE, MAXDOP, DATA_COMPRESSION, ONLINE).
index_option
    : key=simple_id EQUAL index_option_value
    ;

index_option_value
    : simple_id
    | on_off
    | DECIMAL
    ;

cursor_common
    : CURSOR declare_cursor_partial* FOR select_statement
    (FOR (READ ONLY | UPDATE (OF names_references)?))?
    ;

declare_cursor_partial
    : LOCAL
    | GLOBAL
    | FORWARD_ONLY
    | SCROLL
    | STATIC
    | KEYSET
    | DYNAMIC
    | FAST_FORWARD
    | READ_ONLY
    | SCROLL_LOCKS
    | OPTIMISTIC
    | TYPE_WARNING
    ;

// https://msdn.microsoft.com/en-us/library/ms190356.aspx
// Runtime check.
set_special
    : SET name=id (id | constant_LOCAL_ID | ON | OFF)
    // https://msdn.microsoft.com/en-us/library/ms173763.aspx
    | SET (TRAN | TRANSACTION) ISOLATION LEVEL
      (READ UNCOMMITTED | READ COMMITTED | REPEATABLE READ | SNAPSHOT | SERIALIZABLE | DECIMAL)
    // https://msdn.microsoft.com/en-us/library/ms188059.aspx
    | SET IDENTITY_INSERT qualified_name on_off
    | SET TEXTSIZE DECIMAL
    | SET LANGUAGE (id | constant_LOCAL_ID)
    | SET STATISTICS (IO | XML | PROFILE | TIME) on_off
    | SET object_expression
    | SET ROWCOUNT decimal_or_local_id
    ;

constant_LOCAL_ID
    : constant
    | LOCAL_ID
    ;

// Expression.

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/expressions-transact-sql
// Operator precendence: https://docs.microsoft.com/en-us/sql/t-sql/language-elements/operator-precedence-transact-sql
expression
    : LR_BRACKET expression RR_BRACKET
    | op=(PLUS | MINUS | BIT_NOT) expression
    | expression op=(STAR | DIVIDE | MODULE) expression
    | expression op=(PLUS | MINUS | BIT_AND | BIT_XOR | BIT_OR) expression
    | expression EQUAL expression
    | expression assignment_operator expression
    | function_call
    | expression COLLATE id
    | object_expression DOT function_call
    | full_column_name (COLON COLON function_call)?
    | id COLON COLON id
    | case_expression
    | over_clause
    | date_expression
    | LR_BRACKET select_stmt_no_parens RR_BRACKET
    | primitive_expression
    | DOLLAR_ACTION
    ;

object_expression
    : object_expression DOT function_call
    | function_call
    | full_column_name COLON COLON function_call
    | id COLON COLON id
    | case_expression
    | over_clause
    | LR_BRACKET expression RR_BRACKET
    | LR_BRACKET select_stmt_no_parens RR_BRACKET
    | LOCAL_ID
    ;

date_expression
    : LEFT_FIGURE_PAREN id expression RIGHT_FIGURE_PAREN
    ;

primitive_expression
    : DEFAULT
    | NULL
    | LOCAL_ID
    | STRING // string, datetime or uniqueidentifier
    | BINARY
    | DECIMAL
    | REAL
    | FLOAT
    | dollar=DOLLAR (DECIMAL | FLOAT)       // money
    | TRUE // bit
    | FALSE // bit
    | IPV4_ADDR
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/case-transact-sql
case_expression
    : CASE caseExpr=expression switch_section+ (ELSE elseExpr=expression)? END
    | CASE switch_search_condition_section+ (ELSE elseExpr=expression)? END
    ;

constant_expression
    : NULL
    | constant
    // system functions: https://msdn.microsoft.com/en-us/library/ms187786.aspx
    | function_call
    | LOCAL_ID         // TODO: remove.
    | LR_BRACKET constant_expression RR_BRACKET
    ;

// https://msdn.microsoft.com/en-us/library/ms175972.aspx
with_expression
    : WITH (XMLNAMESPACES COMMA)? common_table_expression (COMMA common_table_expression)*
    //| WITH BLOCKING_HIERARCHY (LR_BRACKET full_column_name_list RR_BRACKET)? AS LR_BRACKET select_statement RR_BRACKET
    ;

common_table_expression
    : id name_list_in_brackets? AS LR_BRACKET select_statement RR_BRACKET
    ;

update_elem
    : (full_column_name | LOCAL_ID) (EQUAL | assignment_operator) expression
    | udt_column_name=id DOT method_name=id LR_BRACKET expression_list RR_BRACKET
    //| full_column_name DOT WRITE (expression,)
    ;

// https://msdn.microsoft.com/en-us/library/ms173545.aspx
search_condition
    : search_condition_and (OR search_condition_and)*
    ;

search_condition_and
    : search_condition_not (AND search_condition_not)*
    ;

search_condition_not
    : NOT? predicate
    ;

predicate
    : EXISTS LR_BRACKET select_statement RR_BRACKET
    | expression comparison_operator expression
    | expression comparison_operator (ALL | SOME | ANY) LR_BRACKET select_statement RR_BRACKET
    | expression NOT? BETWEEN expression AND expression
    | expression NOT? IN LR_BRACKET (select_statement | expression_list) RR_BRACKET
    | expression NOT? LIKE expression (ESCAPE expression)?
    | expression IS null_notnull
    | expression IS NOT? DISTINCT FROM expression
    | MATCH LR_BRACKET match_specification (AND match_specification)* RR_BRACKET
    | LR_BRACKET search_condition RR_BRACKET
    | UPDATE LR_BRACKET expression_list? RR_BRACKET
    | (CONTAINS | FREETEXT) LR_BRACKET (expression | LR_BRACKET expression (COMMA expression)+ RR_BRACKET | STAR)
       COMMA expression (COMMA language_term)? RR_BRACKET
    ;

// https://msdn.microsoft.com/en-us/library/ms176104.aspx
query_specification
    : SELECT set_qualifier? top_clause?
    select_list
    // https://msdn.microsoft.com/en-us/library/ms188029.aspx
    (INTO qualified_name)?
    (FROM from_item (COMMA from_item)*)?
    (WHERE where=search_condition)?
    // https://msdn.microsoft.com/en-us/library/ms177673.aspx
    (GROUP BY group_by_clause)?
    (HAVING having=search_condition)?
    order_by_clause?
    | table_value_constructor
    ;

group_by_clause
    : group_by_item (COMMA group_by_item)*
    | ALL expression_list
    | expression_list WITH (ROLLUP | CUBE | LR_BRACKET DISTRIBUTED_AGG RR_BRACKET)
    ;

group_by_item
    : expression
    | GROUPING SETS LR_BRACKET (expression | LR_BRACKET RR_BRACKET) (COMMA (expression | LR_BRACKET RR_BRACKET))* RR_BRACKET
    | LR_BRACKET RR_BRACKET
    ;

match_specification
    : simple_match_pattern+
    | SHORTEST_PATH LR_BRACKET arbitrary_length_pattern (AND? arbitrary_length_pattern)* RR_BRACKET
    | last_node EQUAL last_node
    ;

simple_match_pattern
    : (last_node | qualified_name) (edge_pattern qualified_name? | last_node)
    ;

arbitrary_length_pattern
    : (last_node | qualified_name) LR_BRACKET (edge_pattern qualified_name)+ RR_BRACKET al_pattern_quantifier
    | LR_BRACKET (qualified_name edge_pattern)+ RR_BRACKET al_pattern_quantifier (last_node | qualified_name)
    ;

last_node
    : LAST_NODE LR_BRACKET qualified_name RR_BRACKET
    ;

edge_pattern
    : MINUS LR_BRACKET qualified_name RR_BRACKET MINUS GREATER
    | LESS MINUS LR_BRACKET qualified_name RR_BRACKET MINUS
    ;

al_pattern_quantifier
    : PLUS
    | LEFT_FIGURE_PAREN DECIMAL COMMA DECIMAL RIGHT_FIGURE_PAREN
    ;

from_item
    : LR_BRACKET sub_item=from_item RR_BRACKET
    | from_item ((INNER | (LEFT | RIGHT | FULL) OUTER?) (LOOP | HASH | MERGE | REMOTE)?)?
       JOIN from_item ON search_condition
    | from_item CROSS JOIN from_item
    | from_item CROSS APPLY from_item
    | from_item OUTER APPLY from_item
    | from_item PIVOT LR_BRACKET function_call FOR full_column_name IN column_alias_list RR_BRACKET as_table_alias
    | from_item UNPIVOT LR_BRACKET expression FOR full_column_name IN LR_BRACKET full_column_name_list RR_BRACKET RR_BRACKET as_table_alias
    | from_primary
    ;

from_primary
    : qualified_name              as_table_alias? insert_with_table_hints?
    | rowset_function             as_table_alias?
    | derived_table               as_table_alias
    | change_table                as_table_alias
    | function_call               as_table_alias?
    | LOCAL_ID                    as_table_alias?
    | LOCAL_ID DOT function_call  as_table_alias?
    | open_xml                    as_table_alias?
    | COLON COLON function_call   as_table_alias? // Build-in function (old syntax)
    ;

// https://msdn.microsoft.com/en-us/library/ms189463.aspx
top_clause
    : TOP top_count (WITH TIES)?
    ;

top_count
    : (REAL | FLOAT) PERCENT
    | DECIMAL
    | LR_BRACKET expression RR_BRACKET
    | LR_BRACKET expression RR_BRACKET PERCENT
    ;

// https://msdn.microsoft.com/en-us/library/ms188385.aspx
order_by_clause
    : ORDER BY order_by_expression (COMMA order_by_expression)*
    (OFFSET expression (ROW | ROWS) (FETCH (FIRST | NEXT) expression (ROW | ROWS) ONLY)?)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/queries/select-for-clause-transact-sql
for_clause
    : FOR BROWSE
    | FOR XML ((RAW | PATH) (LR_BRACKET STRING RR_BRACKET)? | EXPLICIT | AUTO) (COMMA xml_common_directives)*
    | FOR JSON (AUTO | PATH) (COMMA (ROOT (LR_BRACKET STRING RR_BRACKET)? | INCLUDE_NULL_VALUES | WITHOUT_ARRAY_WRAPPER))*
    ;

xml_common_directives
    : BINARY_BASE64
    | TYPE
    | ROOT (LR_BRACKET STRING RR_BRACKET)?
    | XMLSCHEMA (LR_BRACKET STRING RR_BRACKET)?
    | XMLDATA
    | ELEMENTS (XSINIL | ABSENT)?
    ;

order_by_expression
    : expression asc_desc?
    ;

option_clause
    // https://msdn.microsoft.com/en-us/library/ms181714.aspx
    : OPTION LR_BRACKET option (COMMA option)* RR_BRACKET
    ;

option
    : FAST number_rows=DECIMAL
    | (HASH | ORDER) GROUP
    | (MERGE | HASH | CONCAT) UNION
    | (LOOP | MERGE | HASH) JOIN
    | EXPAND VIEWS
    | FORCE ORDER
    | IGNORE_NONCLUSTERED_COLUMNSTORE_INDEX
    | KEEP PLAN
    | KEEPFIXED PLAN
    | MAXDOP number_of_processors=DECIMAL
    | MAXRECURSION number_recursion=DECIMAL
    | OPTIMIZE FOR LR_BRACKET optimize_for_arg (COMMA optimize_for_arg)* RR_BRACKET
    | OPTIMIZE FOR UNKNOWN
    | PARAMETERIZATION (SIMPLE | FORCED)
    | RECOMPILE
    | ROBUST PLAN
    | USE PLAN STRING
    | QUERYTRACEON DECIMAL
    ;

optimize_for_arg
    : LOCAL_ID (UNKNOWN | EQUAL (constant | NULL))
    ;

// https://msdn.microsoft.com/en-us/library/ms176104.aspx
select_list
    : select_list_elem (COMMA select_list_elem)*
    ;

select_list_elem
    : (qualified_name DOT)? STAR
    | (DOLLAR IDENTITY | DOLLAR ROWGUID | expression) (AS? column_alias)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/functions/openxml-transact-sql
open_xml
    : OPENXML LR_BRACKET expression COMMA expression_list RR_BRACKET
    (WITH LR_BRACKET schema_declaration RR_BRACKET)?
    ;

schema_declaration
    : column_declaration (COMMA column_declaration)*
    ;

column_declaration
    : id data_type (STRING)?
    ;

change_table
    : CHANGETABLE LR_BRACKET
    (CHANGES qualified_name COMMA (NULL | DECIMAL | LOCAL_ID) | VERSION qualified_name COMMA primary_key_values)
    RR_BRACKET
    ;

primary_key_values
    : LR_BRACKET full_column_name_list RR_BRACKET COMMA LR_BRACKET expression_list RR_BRACKET
    ;

full_column_name_list
    : full_column_name (COMMA full_column_name)*
    ;

table_name_with_hint
    : qualified_name with_table_hints?
    ;

// https://msdn.microsoft.com/en-us/library/ms190312.aspx
rowset_function
    : OPENROWSET LR_BRACKET provider_name = STRING COMMA connectionString = STRING COMMA sql = STRING RR_BRACKET
    | OPENROWSET LR_BRACKET BULK data_file=STRING COMMA (bulk_option (COMMA bulk_option)* | id) RR_BRACKET
    ;

// runtime check.
bulk_option
    : id EQUAL bulk_option_value=(DECIMAL | STRING)
    ;

derived_table
    : LR_BRACKET dml_clause RR_BRACKET
    ;

function_call
    : scalar_function_name LR_BRACKET (STAR | all_distinct_expression | expression_list?) RR_BRACKET over_clause?
    // https://msdn.microsoft.com/en-us/library/hh231076.aspx
    | CAST LR_BRACKET expression AS data_type RR_BRACKET
    // https://msdn.microsoft.com/en-us/library/ms187928.aspx
    | CONVERT LR_BRACKET convert_data_type=data_type COMMA convert_expression=expression (COMMA style=expression)? RR_BRACKET
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/parse-transact-sql
    | PARSE LR_BRACKET expression AS data_type (USING expression)? RR_BRACKET
    // https://msdn.microsoft.com/en-us/library/ms190349.aspx
    | COALESCE LR_BRACKET expression_list RR_BRACKET
    // https://msdn.microsoft.com/en-us/library/ms188751.aspx
    | CURRENT_TIMESTAMP
    // https://msdn.microsoft.com/en-us/library/ms176050.aspx
    | CURRENT_USER
    // https://msdn.microsoft.com/en-us/library/ms189838.aspx
    | IDENTITY LR_BRACKET data_type (COMMA seed=DECIMAL)? (COMMA increment=DECIMAL)? RR_BRACKET
    | IIF LR_BRACKET search_condition COMMA expression COMMA expression RR_BRACKET
    // https://msdn.microsoft.com/en-us/library/bb839514.aspx
    | MIN_ACTIVE_ROWVERSION
    // https://docs.microsoft.com/en-us/sql/t-sql/xml/nodes-method-xml-data-type
    | NODES LR_BRACKET xquery=STRING RR_BRACKET as_table_alias
    // https://msdn.microsoft.com/en-us/library/ms177562.aspx
    | NULLIF LR_BRACKET expression COMMA expression RR_BRACKET
    // https://msdn.microsoft.com/en-us/library/ms177587.aspx
    | SESSION_USER
    // https://msdn.microsoft.com/en-us/library/ms179930.aspx
    | SYSTEM_USER
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/openjson-transact-sql
    | OPENJSON LR_BRACKET expression (COMMA expression)? RR_BRACKET
    WITH LR_BRACKET column_declaration (AS JSON)? (COMMA column_declaration (AS JSON)?)* RR_BRACKET
    | USER
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/cursor-rows-transact-sql
    | FUNC_CURSOR_ROWS
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/fetch-status-transact-sql
    | FUNC_FETCH_STATUS
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/datefirst-transact-sql
    | FUNC_DATEFIRST
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/procid-transact-sql
    | FUNC_PROCID
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/error-transact-sql
    | FUNC_ERROR
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/identity-transact-sql
    | FUNC_IDENTITY
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/pack-received-transact-sql
    | FUNC_PACK_RECEIVED
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/rowcount-transact-sql
    | FUNC_ROWCOUNT
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/trancount-transact-sql
    | FUNC_TRANCOUNT
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/next-value-for-transact-sql
    | NEXT VALUE FOR sequence_name = qualified_name over_clause?
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/string-agg-transact-sql
    | STRING_AGG LR_BRACKET expression COMMA expression RR_BRACKET WITHIN_GROUP LR_BRACKET order_by_clause RR_BRACKET
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/trim-transact-sql
    | TRIM LR_BRACKET expression FROM expression RR_BRACKET
    // https://docs.microsoft.com/en-us/sql/t-sql/functions/partition-transact-sql
    | (id DOT)? DOLLAR_PARTITION DOT function_call
    ;

switch_section
    : WHEN expression THEN expression
    ;

switch_search_condition_section
    : WHEN search_condition THEN expression
    ;

as_table_alias
    : AS? id column_alias_list?
    ;

// https://msdn.microsoft.com/en-us/library/ms187373.aspx
with_table_hints
    : WITH? LR_BRACKET table_hint (COMMA? table_hint)* RR_BRACKET
    ;

// https://msdn.microsoft.com/en-us/library/ms187373.aspx
insert_with_table_hints
    : WITH LR_BRACKET table_hint (COMMA? table_hint)* RR_BRACKET
    ;

// Id runtime check. Id can be (FORCESCAN, HOLDLOCK, NOLOCK, NOWAIT, PAGLOCK, READCOMMITTED,
// READCOMMITTEDLOCK, READPAST, READUNCOMMITTED, REPEATABLEREAD, ROWLOCK, TABLOCK, TABLOCKX
// UPDLOCK, XLOCK)
table_hint
    : NOEXPAND
    | INDEX LR_BRACKET index_value (COMMA index_value)* RR_BRACKET
    | INDEX EQUAL index_value
    | FORCESEEK (LR_BRACKET index_value LR_BRACKET ID (COMMA ID)* RR_BRACKET RR_BRACKET)?
    | SERIALIZABLE
    | SNAPSHOT
    | SPATIAL_WINDOW_MAX_CELLS EQUAL DECIMAL
    | ID
    ;

index_value
    : id | DECIMAL
    ;

column_alias_list
    : LR_BRACKET column_alias (COMMA column_alias)* RR_BRACKET
    ;

column_alias
    : id | STRING
    ;

table_value_constructor
    : VALUES LR_BRACKET expression_list RR_BRACKET (COMMA LR_BRACKET expression_list RR_BRACKET)*
    ;

expression_list
    : expression (COMMA expression)*
    ;

all_distinct_expression
    : (ALL | DISTINCT) expression
    ;

// https://msdn.microsoft.com/en-us/library/ms189461.aspx
over_clause
    : OVER LR_BRACKET (PARTITION BY expression_list)? order_by_clause? row_or_range_clause? RR_BRACKET
    ;

row_or_range_clause
    : (ROWS | RANGE) window_frame_extent
    ;

window_frame_extent
    : window_frame_preceding
    | BETWEEN window_frame_bound AND window_frame_bound
    ;

window_frame_bound
    : window_frame_preceding
    | window_frame_following
    ;

window_frame_preceding
    : UNBOUNDED PRECEDING
    | DECIMAL PRECEDING
    | CURRENT ROW
    ;

window_frame_following
    : UNBOUNDED FOLLOWING
    | DECIMAL FOLLOWING
    ;

create_database_option
    : FILESTREAM (database_filestream_option (COMMA database_filestream_option)*)
    | DEFAULT_LANGUAGE EQUAL (id | STRING)
    | DEFAULT_FULLTEXT_LANGUAGE EQUAL (id | STRING)
    | NESTED_TRIGGERS EQUAL on_off
    | TRANSFORM_NOISE_WORDS EQUAL on_off
    | TWO_DIGIT_YEAR_CUTOFF EQUAL DECIMAL
    | DB_CHAINING on_off
    | TRUSTWORTHY on_off
    | PERSISTENT_LOG_BUFFER EQUAL ON LR_BRACKET DIRECTORY_NAME EQUAL STRING RR_BRACKET
    | LEDGER EQUAL on_off
    ;

database_filestream_option
    : LR_BRACKET (NON_TRANSACTED_ACCESS EQUAL (OFF | READ_ONLY | FULL) | DIRECTORY_NAME EQUAL STRING) RR_BRACKET
    ;

file_and_filegroup_options
    : ADD FILE file_spec_alter (COMMA file_spec_alter)* (TO FILEGROUP id)?
    | ADD LOG FILE file_spec_alter (COMMA file_spec_alter)*
    | REMOVE FILE (id | STRING)
    | MODIFY FILE file_spec_alter
    | ADD FILEGROUP id CONTAINS? (FILESTREAM | MEMORY_OPTIMIZED_DATA)?
    | REMOVE FILEGROUP id
    | MODIFY FILEGROUP id filegroup_modify_option
    ;

file_spec_alter
    : LR_BRACKET NAME EQUAL (id | STRING) (COMMA NEWNAME EQUAL (id | STRING))?
    (COMMA FILENAME EQUAL STRING)? (COMMA SIZE EQUAL file_size)?
    (COMMA MAXSIZE EQUAL (file_size | UNLIMITED))? (COMMA FILEGROWTH EQUAL file_size)?
    (COMMA OFFLINE)? RR_BRACKET
    ;

filegroup_modify_option
    : READONLY
    | READWRITE
    | READ_ONLY
    | READ_WRITE
    | DEFAULT
    | NAME EQUAL id
    | AUTOGROW_SINGLE_FILE
    | AUTOGROW_ALL_FILES
    ;

file_group
    : FILEGROUP id (CONTAINS FILESTREAM)? DEFAULT? (CONTAINS MEMORY_OPTIMIZED_DATA)? file_spec (COMMA file_spec)*
    ;

file_spec
    : LR_BRACKET
    NAME EQUAL (id | STRING) COMMA
    FILENAME EQUAL STRING
    (COMMA SIZE EQUAL file_size)?
    (COMMA MAXSIZE EQUAL (file_size | UNLIMITED))?
    (COMMA FILEGROWTH EQUAL file_size)?
    RR_BRACKET
    ;

qualified_name
    : (id DOT id DOT  schema=id   DOT
      |       id DOT (schema=id)? DOT
      |               schema=id   DOT)? name=id
    ;

full_column_name
    : (qualified_name DOT)? id
    ;

column_name_list_with_order
    : column_with_order (COMMA column_with_order)*
    ;

column_with_order
    : id asc_desc?
    ;

asc_desc
    : ASC | DESC
    ;

name_list
    : id (COMMA id)*
    ;

name_list_in_brackets
    : LR_BRACKET id (COMMA id)* RR_BRACKET
    ;

cursor_name
    : id
    | LOCAL_ID
    ;

on_off
    : ON | OFF
    ;

clustered
    : CLUSTERED | NONCLUSTERED
    ;

null_notnull
    : NOT? NULL
    ;

scalar_function_name
    : qualified_name
    | RIGHT
    | LEFT
    ;

begin_conversation_timer
    : BEGIN CONVERSATION TIMER LR_BRACKET LOCAL_ID RR_BRACKET TIMEOUT EQUAL time
    ;

begin_conversation_dialog
    : BEGIN DIALOG (CONVERSATION)? LOCAL_ID
      FROM SERVICE expression
      TO SERVICE expression (COMMA STRING)?
      ON CONTRACT expression
      (WITH
        ((RELATED_CONVERSATION | RELATED_CONVERSATION_GROUP) EQUAL LOCAL_ID COMMA?)?
        (LIFETIME EQUAL (DECIMAL | LOCAL_ID) COMMA?)?
        (ENCRYPTION EQUAL on_off)?)?
    ;

move_conversation
    : MOVE CONVERSATION constant_LOCAL_ID  TO constant_LOCAL_ID
    ;

end_conversation
    : END CONVERSATION LOCAL_ID
    (WITH (ERROR EQUAL (LOCAL_ID | STRING) DESCRIPTION EQUAL (LOCAL_ID | STRING))? CLEANUP?)?
    ;

waitfor_conversation
    : WAITFOR? LR_BRACKET get_conversation RR_BRACKET (COMMA? TIMEOUT time)?
    ;

get_conversation
    : GET CONVERSATION GROUP string_or_local_id FROM qualified_name
    ;

send_conversation
    : SEND ON CONVERSATION string_or_local_id (MESSAGE TYPE expression)? (LR_BRACKET string_or_local_id RR_BRACKET)?
    ;

// https://msdn.microsoft.com/en-us/library/ms187752.aspx
// TODO: implement runtime check or add new tokens.
data_type
    : qualified_name size=data_type_size?
    | DOUBLE PRECISION
    | (CHAR | CHARACTER | NCHAR) VARYING size=data_type_size?
    | NATIONAL (CHAR | CHARACTER) VARYING? size=data_type_size?
    | CURSOR VARYING?
    ;

data_type_size
    : LR_BRACKET (presicion=DECIMAL | MAX) (COMMA scale=DECIMAL)? RR_BRACKET
    ;

default_value
    : NULL
    | DEFAULT
    | constant
    ;

// https://msdn.microsoft.com/en-us/library/ms179899.aspx
constant
    : STRING // string, datetime or uniqueidentifier
    | BINARY
    | signed_numerical_literal
    | sign? dollar=DOLLAR (DECIMAL | FLOAT)       // money
    | TRUE // bit
    | FALSE // bit
    | IPV4_ADDR
    ;

signed_numerical_literal
    : sign? (DECIMAL | REAL | FLOAT)
    ;

sign
    : PLUS | MINUS
    ;

// https://msdn.microsoft.com/en-us/library/ms175874.aspx
id
    : simple_id
    | DOUBLE_QUOTE_ID
    | SQUARE_BRACKET_ID
    ;

simple_id
    : ID
    | ABORT_AFTER_WAIT
    | ABSENT
    | ABSOLUTE
    | ACCENT_SENSITIVITY
    | ACCESS
    | ACTION
    | ACTIVATION
    | ACTIVE
    | ADDRESS
    | ADMINISTER
    | AES
    | AES_128
    | AES_192
    | AES_256
    | AFFINITY
    | AFTER
    | AGGREGATE
    | ALGORITHM
    | ALLOW_CONNECTIONS
    | ALLOW_ENCRYPTED_VALUE_MODIFICATIONS
    | ALLOW_MULTIPLE_EVENT_LOSS
    | ALLOW_SINGLE_EVENT_LOSS
    | ALLOW_SNAPSHOT_ISOLATION
    | ALLOWED
    | ANONYMOUS
    | ANSI_NULL_DEFAULT
    | ANSI_NULLS
    | ANSI_PADDING
    | ANSI_WARNINGS
    | APPEND
    | APPLICATION
    | APPLICATION_LOG
    | APPLY
    | ARITHABORT
    | ASSEMBLY
    | ASYMMETRIC
    | ASYNCHRONOUS_COMMIT
    | AUDIT
    | AUDIT_GUID
    | AUTHENTICATE
    | AUTHENTICATION
    | AUTO
    | AUTO_CLEANUP
    | AUTO_CLOSE
    | AUTO_CREATE_STATISTICS
    | AUTO_SHRINK
    | AUTO_UPDATE_STATISTICS
    | AUTO_UPDATE_STATISTICS_ASYNC
    | AUTOGROW_ALL_FILES
    | AUTOGROW_SINGLE_FILE
    | AUTOMATED_BACKUP_PREFERENCE
    | AUTOMATIC
    | AVAILABILITY
    | AVAILABILITY_MODE
    | BACKUP_PRIORITY
    | BEFORE
    | BEGIN_DIALOG
    | BINARY_BASE64
    | BINDING
    | BLOB_STORAGE
    | BLOCK
    | BLOCKERS
    | BLOCKING_HIERARCHY
    | BLOCKSIZE
    | BROKER
    | BROKER_INSTANCE
    | BUFFER
    | BUFFERCOUNT
    | BULK_LOGGED
    | CACHE
    | CALLED
    | CALLER
    | CAP_CPU_PERCENT
    | CAST
    | CATALOG
    | CATCH
    | CERTIFICATE
    | CHANGE
    | CHANGE_RETENTION
    | CHANGE_TRACKING
    | CHANGES
    | CHANGETABLE
    | CHAR
    | CHARACTER
    | CHECK_EXPIRATION
    | CHECK_POLICY
    | CHECKSUM
    | CLASSIFIER_FUNCTION
    | CLEANUP
    | CLUSTER
    | COLLECTION
    | COLUMN_MASTER_KEY
    | COMMITTED
    | COMPATIBILITY_LEVEL
    | COMPRESSION
    | CONCAT
    | CONCAT_NULL_YIELDS_NULL
    | CONFIGURATION
    | CONNECT
    | CONNECTION
    | CONTAINMENT
    | CONTENT
    | CONTEXT
    | CONTINUE_AFTER_ERROR
    | CONTRACT
    | CONTRACT_NAME
    | CONTROL
    | CONVERSATION
    | COOKIE
    | COPY_ONLY
    | COUNTER
    | CPU
    | CREATE_NEW
    | CREATION_DISPOSITION
    | CREDENTIAL
    | CRYPTOGRAPHIC
    | CUBE
    | CURSOR_CLOSE_ON_COMMIT
    | CURSOR_DEFAULT
    | CYCLE
    | DATA
    | DATA_COMPRESSION
    | DATA_SOURCE
    | DATABASE_MIRRORING
    | DATASPACE
    | DATE_CORRELATION_OPTIMIZATION
    | DAYS
    | DB_CHAINING
    | DB_FAILOVER
    | DDL
    | DECRYPTION
    | DEFAULT_DATABASE
    | DEFAULT_FULLTEXT_LANGUAGE
    | DEFAULT_LANGUAGE
    | DEFAULT_SCHEMA
    | DEFINITION
    | DELAY
    | DELAYED_DURABILITY
    | DEPENDENTS
    | DES
    | DESCRIPTION
    | DESX
    | DHCP
    | DIAGNOSTICS
    | DIALOG
    | DIFFERENTIAL
    | DIRECTORY_NAME
    | DISABLE
    | DISABLE_BROKER
    | DISABLED
    | DISTRIBUTED_AGG
    | DOCUMENT
    | DTC_SUPPORT
    | DYNAMIC
    | ELEMENTS
    | EMERGENCY
    | EMPTY
    | ENABLE
    | ENABLE_BROKER
    | ENABLED
    | ENCRYPTED_VALUE
    | ENCRYPTION
    | ENDPOINT
    | ENDPOINT_URL
    | ERROR
    | ERROR_BROKER_CONVERSATIONS
    | EVENT
    | EVENT_RETENTION_MODE
    | EXCLUSIVE
    | EXECUTABLE
    | EXECUTABLE_FILE
    | EXPAND
    | EXPIREDATE
    | EXPIRY_DATE
    | EXPLICIT
    | EXTENSION
    | EXTERNAL_ACCESS
    | FAIL_OPERATION
    | FAILOVER
    | FAILOVER_MODE
    | FAILURE_CONDITION_LEVEL
    | FAILURECONDITIONLEVEL
    | FALSE
    | FAN_IN
    | FAST
    | FAST_FORWARD
    | FILE_SNAPSHOT
    | FILEGROUP
    | FILEGROWTH
    | FILENAME
    | FILEPATH
    | FILESTREAM
    | FILESTREAM_ON
    | FILLFACTOR
    | FILTER
    | FIRST
    | FOLLOWING
    | FORCE
    | FORCE_FAILOVER_ALLOW_DATA_LOSS
    | FORCE_SERVICE_ALLOW_DATA_LOSS
    | FORCED
    | FORCESEEK
    | FORMAT
    | FORWARD_ONLY
    | FULLSCAN
    | FULLTEXT
    | GB
    | GET
    | GLOBAL
    | GOVERNOR
    | GROUP_MAX_REQUESTS
    | GROUPING
    | HADR
    | HASH
    | HASHED
    | HEALTH_CHECK_TIMEOUT
    | HEALTHCHECKTIMEOUT
    | HIGH
    | HONOR_BROKER_PRIORITY
    | HOURS
    | IDENTITY_VALUE
    | IGNORE_NONCLUSTERED_COLUMNSTORE_INDEX
    | IIF
    | IMMEDIATE
    | IMPERSONATE
    | IMPORTANCE
    | INCLUDE
    | INCLUDE_NULL_VALUES
    | INCREMENT
    | INCREMENTAL
    | INFINITE
    | INIT
    | INITIATOR
    | INPUT
    | INSENSITIVE
    | INSTEAD
    | IO
    | IP
    | ISOLATION
    | JSON
    | KB
    | KEEP
    | KEEPFIXED
    | KERBEROS
    | KEY_PATH
    | KEY_SOURCE
    | KEY_STORE_PROVIDER_NAME
    | KEYS
    | KEYSET
    | LANGUAGE
    | LAST
    | LAST_NODE
    | LEDGER
    | LEVEL
    | LIBRARY
    | LIFETIME
    | LINKED
    | LINUX
    | LIST
    | LISTENER
    | LISTENER_IP
    | LISTENER_PORT
    | LISTENER_URL
    | LOB_COMPACTION
    | LOCAL
    | LOCAL_SERVICE_NAME
    | LOCATION
    | LOCK
    | LOCK_ESCALATION
    | LOG
    | LOGIN
    | LOOP
    | LOW
    | MANUAL
    | MARK
    | MASK
    | MASKED
    | MASTER
    | MATCH
    | MATCHED
    | MATERIALIZED
    | MAX
    | MAX_CPU_PERCENT
    | MAX_DISPATCH_LATENCY
    | MAX_DOP
    | MAX_DURATION
    | MAX_EVENT_SIZE
    | MAX_FILES
    | MAX_IOPS_PER_VOLUME
    | MAX_MEMORY
    | MAX_MEMORY_PERCENT
    | MAX_OUTSTANDING_IO_PER_VOLUME
    | MAX_PROCESSES
    | MAX_QUEUE_READERS
    | MAX_ROLLOVER_FILES
    | MAX_SIZE
    | MAXDOP
    | MAXRECURSION
    | MAXSIZE
    | MAXTRANSFER
    | MAXVALUE
    | MB
    | MEDIADESCRIPTION
    | MEDIANAME
    | MEDIUM
    | MEMBER
    | MEMORY_OPTIMIZED
    | MEMORY_OPTIMIZED_DATA
    | MEMORY_OPTIMIZED_ELEVATE_TO_SNAPSHOT
    | MEMORY_PARTITION_MODE
    | MESSAGE
    | MESSAGE_FORWARD_SIZE
    | MESSAGE_FORWARDING
    | MIN_ACTIVE_ROWVERSION
    | MIN_CPU_PERCENT
    | MIN_IOPS_PER_VOLUME
    | MIN_MEMORY_PERCENT
    | MINUTES
    | MINVALUE
    | MIRROR
    | MIRROR_ADDRESS
    | MIXED_PAGE_ALLOCATION
    | MODE
    | MODIFY
    | MOVE
    | MULTI_USER
    | MUST_CHANGE
    | NAME
    | NCHAR
    | NEGOTIATE
    | NESTED_TRIGGERS
    | NEW_ACCOUNT
    | NEW_BROKER
    | NEW_PASSWORD
    | NEWNAME
    | NEXT
    | NO
    | NO_CHECKSUM
    | NO_COMPRESSION
    | NO_EVENT_LOSS
    | NO_TRUNCATE
    | NO_WAIT
    | NODES
    | NOEXPAND
    | NOFORMAT
    | NOINIT
    | NON_TRANSACTED_ACCESS
    | NONE
    | NORECOMPUTE
    | NORECOVERY
    | NOREWIND
    | NOSKIP
    | NOTIFICATION
    | NOTIFICATIONS
    | NOUNLOAD
    | NOWAIT
    | NTLM
    | NUMANODE
    | NUMERIC_ROUNDABORT
    | OBJECT
    | OFFLINE
    | OFFSET
    | OLD_ACCOUNT
    | OLD_PASSWORD
    | ON_FAILURE
    | ONLINE
    | ONLY
    | OPEN_EXISTING
    | OPENJSON
    | OPERATIONS
    | OPTIMISTIC
    | OPTIMIZE
    | OUT
    | OUTPUT
    | OWNER
    | OWNERSHIP
    | PAGE_VERIFY
    | PARAMETERIZATION
    | PARSE
    | PARTIAL
    | PARTITION
    | PARTITIONS
    | PARTNER
    | PASSWORD
    | PATH
    | PAUSE
    | PER_CPU
    | PER_DB
    | PER_NODE
    | PERMISSION_SET
    | PERSIST_SAMPLE_PERSENT
    | PERSISTED
    | PERSISTENT_LOG_BUFFER
    | PLATFORM
    | POISON_MESSAGE_HANDLING
    | POLICY
    | POOL
    | POPULATION
    | PORT
    | PRECEDING
    | PRECISION
    | PREDICATE
    | PRIMARY_ROLE
    | PRIOR
    | PRIORITY
    | PRIORITY_LEVEL
    | PRIVATE
    | PRIVATE_KEY
    | PRIVILEGES
    | PROCEDURE_NAME
    | PROCESS
    | PROFILE
    | PROPERTY
    | PROPERTY_DESCRIPTION
    | PROPERTY_INT_ID
    | PROPERTY_SET_GUID
    | PROVIDER
    | PROVIDER_KEY_NAME
    | QUERY
    | QUERYTRACEON
    | QUEUE
    | QUEUE_DELAY
    | QUOTED_IDENTIFIER
    | R_LETTER
    | RANGE
    | RAW
    | RC2
    | RC4
    | RC4_128
    | READ_COMMITTED_SNAPSHOT
    | READ_ONLY
    | READ_ONLY_ROUTING_LIST
    | READ_ONLY_ROUTING_URL
    | READ_WRITE
    | READ_WRITE_FILEGROUPS
    | READ_WRITE_ROUTING_URL
    | READONLY
    | READWRITE
    | REBUILD
    | RECEIVE
    | RECOMPILE
    | RECOVERY
    | RECURSIVE_TRIGGERS
    | REGENERATE
    | RELATED_CONVERSATION
    | RELATED_CONVERSATION_GROUP
    | RELATIVE
    | REMOTE
    | REMOTE_SERVICE_NAME
    | REMOVE
    | REORGANIZE
    | REPEATABLE
    | REPLICA
    | REQUEST_MAX_CPU_TIME_SEC
    | REQUEST_MAX_MEMORY_GRANT_PERCENT
    | REQUEST_MEMORY_GRANT_TIMEOUT_SEC
    | REQUIRED
    | REQUIRED_SYNCHRONIZED_SECONDARIES_TO_COMMIT
    | RESAMPLE
    | RESERVE_DISK_SPACE
    | RESET
    | RESOURCE
    | RESOURCE_MANAGER_LOCATION
    | RESOURCES
    | RESTART
    | RESTRICTED_USER
    | RESULT
    | RESUME
    | RETAINDAYS
    | RETENTION
    | RETURNS
    | REWIND
    | ROBUST
    | ROLE
    | ROLLUP
    | ROOT
    | ROUTE
    | ROW
    | ROWGUID
    | ROWS
    | RSA_1024
    | RSA_2048
    | RSA_3072
    | RSA_4096
    | RSA_512
    | SAFE
    | SAFETY
    | SAMPLE
    | SCHEDULER
    | SCHEMABINDING
    | SCHEME
    | SCOPED
    | SCRIPT
    | SCROLL
    | SCROLL_LOCKS
    | SEARCH
    | SECONDARY
    | SECONDARY_ONLY
    | SECONDARY_ROLE
    | SECONDS
    | SECRET
    | SECURABLES
    | SECURITY
    | SECURITY_LOG
    | SEEDING_MODE
    | SELECTIVE
    | SELF
    | SEMI_SENSITIVE
    | SEND
    | SENT
    | SEQUENCE
    | SERIALIZABLE
    | SERVER
    | SERVICE
    | SERVICE_BROKER
    | SERVICE_NAME
    | SESSION
    | SESSION_TIMEOUT
    | SETERROR
    | SETS
    | SETTINGS
    | SHARE
    | SHORTEST_PATH
    | SHOWPLAN
    | SID
    | SIGNATURE
    | SIMPLE
    | SINGLE_USER
    | SINGLETON
    | SIZE
    | SKIP_KEYWORD
    | SNAPSHOT
    | SOFTNUMA
    | SOURCE
    | SPARSE
    | SPATIAL_WINDOW_MAX_CELLS
    | SPECIFICATION
    | SPLIT
    | SQL
    | SQLDUMPERFLAGS
    | SQLDUMPERPATH
    | SQLDUMPERTIMEOUT
    | STANDBY
    | START
    | START_DATE
    | STARTED
    | STARTUP_STATE
    | STATE
    | STATIC
    | STATISTICAL_SEMANTICS
    | STATISTICS_INCREMENTAL
    | STATS
    | STATUS
    | STOP
    | STOP_ON_ERROR
    | STOPLIST
    | STOPPED
    | STRING_AGG
    | SUBJECT
    | SUBSCRIBE
    | SUPPORTED
    | SUSPEND
    | SWITCH
    | SYMMETRIC
    | SYNCHRONOUS_COMMIT
    | SYNONYM
    | SYSTEM
    | TAKE
    | TAPE
    | TARGET
    | TARGET_RECOVERY_TIME
    | TB
    | TCP
    | TEXTIMAGE_ON
    | THROW
    | TIES
    | TIME
    | TIMEOUT
    | TIMER
    | TORN_PAGE_DETECTION
    | TRACE
    | TRACK_CAUSALITY
    | TRACK_COLUMNS_UPDATED
    | TRACKING
    | TRANSFER
    | TRANSFORM_NOISE_WORDS
    | TRIM
    | TRIPLE_DES
    | TRIPLE_DES_3KEY
    | TRUE
    | TRUSTWORTHY
    | TRY
    | TSQL
    | TWO_DIGIT_YEAR_CUTOFF
    | TYPE
    | TYPE_WARNING
    | UNBOUNDED
    | UNCHECKED
    | UNCOMMITTED
    | UNDEFINED
    | UNKNOWN
    | UNLIMITED
    | UNLOCK
    | UNMASK
    | UNSAFE
    | URL
    | USED
    | USING
    | VALID_XML
    | VALIDATION
    | VALUE
    | VERBOSELOGGING
    | VERSION
    | VIEW_METADATA
    | VIEWS
    | VISIBILITY
    | WAIT
    | WAIT_AT_LOW_PRIORITY
    | WELL_FORMED_XML
    | WINDOWS
    | WITHOUT
    | WITHOUT_ARRAY_WRAPPER
    | WITNESS
    | WORK
    | WORKLOAD
    | XML
    | XMLDATA
    | XMLNAMESPACES
    | XMLSCHEMA
    | XQUERY
    | XSINIL
    ;

// https://msdn.microsoft.com/en-us/library/ms188074.aspx
// Spaces are allowed for comparison operators.
comparison_operator
    : EQUAL | GREATER | LESS | LESS EQUAL | GREATER EQUAL | LESS GREATER | EXCLAMATION EQUAL | EXCLAMATION GREATER | EXCLAMATION LESS
    ;

assignment_operator
    : PLUS_ASSIGN | MINUS_ASSIGN | MULT_ASSIGN | DIV_ASSIGN | MOD_ASSIGN | AND_ASSIGN | XOR_ASSIGN | OR_ASSIGN
    ;

file_size
    : DECIMAL(KB | MB | GB | TB | MODULE)?
    ;