parser grammar TSQLParser;

options { 
    language=Java;
    tokenVocab=TSQLLexer;
}

@header {package cz.startnet.utils.pgdiff.parsers.antlr;}

tsql_file
    : BOM? batch* EOF
    ;

batch
    : (sql_clauses | batch_statement) (go_statement+ | EOF)
    ;

// for statements that must be the only ones in an entire batch
batch_statement
    : CREATE create_or_alter_procedure
    ;

sql_clauses
    : SEMI* (st_clause SEMI*)+
    ;

st_clause
    : dml_clause
    | ddl_clause
    | cfl_statement
    | dbcc_clause
    //| empty_statement
    | another_statement
    | backup_statement;

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
    : disable_trigger
    | enable_trigger
    | schema_alter
    | schema_create
    | schema_drop
    | lock_table
    | truncate_table
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
    | alter_db_role
    | alter_endpoint
    | alter_external_data_source
    | alter_external_library
    | alter_external_resource_pool
    | alter_fulltext_catalog
    | alter_fulltext_stoplist
    | alter_login_sql_server
    | alter_master_key_sql_server
    | alter_message_type
    | alter_partition_function
    | alter_partition_scheme
    | alter_queue
    | alter_remote_service_binding
    | alter_resource_governor
    | alter_schema_sql
    | alter_sequence
    | alter_server_audit
    | alter_server_audit_specification
    | alter_server_configuration
    | alter_server_role
    | alter_server_role_pdw
    | alter_service
    | alter_service_master_key
    | alter_symmetric_key
    | alter_table
    | alter_user
    | alter_workload_group
    | create_or_alter_broker_priority
    | create_or_alter_event_session
    | create_or_alter_function
    | create_or_alter_procedure
    | create_or_alter_trigger
    | create_or_alter_view
    | create_symmetric_key
    )
    ;

schema_create
    : CREATE (create_application_role
    | create_assembly
    | create_asymmetric_key
    | create_certificate
    | create_column_encryption_key
    | create_column_master_key
    | create_contract
    | create_credential
    | create_cryptographic_provider
    | create_database
    | create_db_role
    | create_event_notification
    | create_external_library
    | create_external_resource_pool
    | create_fulltext_catalog
    | create_fulltext_stoplist
    | create_index
    | create_key
    | create_login_pdw
    | create_login_sql_server
    | create_master_key_sql_server
    | create_message_type
    | create_or_alter_broker_priority
    | create_or_alter_event_session
    | create_or_alter_function
    //| create_or_alter_procedure
    | create_or_alter_trigger
    | create_or_alter_view
    | create_queue
    | create_remote_service_binding
    | create_resource_pool
    | create_route
    | create_rule
    | create_schema
    | create_search_property_list
    | create_security_policy
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
    | create_xml_schema_collection)
    ;

schema_drop
    : DROP (drop_statements
    | drop_assembly
    | drop_asymmetric_key
    | drop_event_notifications_or_session
    | drop_index
    | drop_master_key
    | drop_signature
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
    //| goto_statement
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
    | id ':'
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
    : THROW (throw_error_number ',' throw_message ',' throw_state)?
    ;

throw_error_number
    : DECIMAL | LOCAL_ID
    ;

throw_message
    : STRING | LOCAL_ID
    ;

throw_state
    : DECIMAL | LOCAL_ID
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/try-catch-transact-sql
try_catch_statement
    : BEGIN TRY try_clauses=sql_clauses? END TRY ';'? BEGIN CATCH catch_clauses=sql_clauses? END CATCH
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/waitfor-transact-sql
waitfor_statement
    : WAITFOR receive_statement? ','? ((DELAY | TIME | TIMEOUT) time)?  expression?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/while-transact-sql
while_statement
    : WHILE search_condition (st_clause | BREAK  | CONTINUE )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/print-transact-sql
print_statement
    : PRINT (expression | DOUBLE_QUOTE_ID) (',' LOCAL_ID)*
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/raiserror-transact-sql
raiseerror_statement
    : RAISERROR '(' msg=(DECIMAL | STRING | LOCAL_ID) ',' severity=constant_LOCAL_ID ','
    state=constant_LOCAL_ID (',' constant_LOCAL_ID)* ')' (WITH (LOG | SETERROR | NOWAIT))?
    | RAISERROR DECIMAL formatstring=(STRING | LOCAL_ID | DOUBLE_QUOTE_ID) (',' argument=(DECIMAL | STRING | LOCAL_ID))*
    ;

another_statement
    : declare_statement
    | cursor_statement
    | conversation_statement
    | execute_statement
    | security_statement
    | set_statement
    | transaction_statement
    | use_statement
    | setuser_statement
    ;
// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-application-role-transact-sql

alter_application_role
    : APPLICATION ROLE appliction_role=id WITH  (COMMA? NAME EQUAL new_application_role_name=id)? (COMMA? PASSWORD EQUAL application_role_password=STRING)? (COMMA? DEFAULT_SCHEMA EQUAL app_role_default_schema=id)?
    ;

create_application_role
    : APPLICATION ROLE appliction_role=id WITH   (COMMA? PASSWORD EQUAL application_role_password=STRING)? (COMMA? DEFAULT_SCHEMA EQUAL app_role_default_schema=id)?
    ;

alter_assembly
    : ASSEMBLY name=id 
    (FROM client_assembly_specifier)? 
    (WITH assembly_option (COMMA assembly_option)*)? 
    (DROP (ALL | multiple_local_files))? 
    (ADD FILE FROM STRING (AS id)?)?
    ;

client_assembly_specifier
    : network_file_share
    | local_file
    | STRING
    | AS id
    ;

assembly_option
    : PERMISSION_SET EQUAL assembly_permission
    | VISIBILITY EQUAL (ON | OFF)
    | UNCHECKED DATA
    ;

network_file_share
    : DOUBLE_BACK_SLASH computer_name=id file_path
    ;

file_path
    : '\\' file_path
    | id
    ;

local_file
    : DISK_DRIVE file_path
    ;

multiple_local_files
    : SINGLE_QUOTE local_file SINGLE_QUOTE COMMA
    | local_file
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-assembly-transact-sql
create_assembly
    : ASSEMBLY assembly_name=id (AUTHORIZATION owner_name=id)?
    FROM string_binary (COMMA string_binary)*
    (WITH PERMISSION_SET EQUAL assembly_permission)?
    ;

string_binary
    : STRING 
    | BINARY
    ;

assembly_permission
    : SAFE
    | EXTERNAL_ACCESS
    | UNSAFE
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-assembly-transact-sql
drop_assembly
    : ASSEMBLY ( IF EXISTS )? (COMMA? assembly_name=id)+
       ( WITH NO DEPENDENTS )?
    ;
// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-asymmetric-key-transact-sql

alter_asymmetric_key
    : ASYMMETRIC KEY Asym_Key_Name=id (asymmetric_key_option | REMOVE PRIVATE KEY )
    ;

asymmetric_key_option
    : WITH PRIVATE KEY LR_BRACKET asymmetric_key_password_change_option ( COMMA asymmetric_key_password_change_option)? RR_BRACKET
    ;

asymmetric_key_password_change_option
    : DECRYPTION BY PASSWORD EQUAL STRING
    | ENCRYPTION BY PASSWORD EQUAL STRING
    ;

//https://docs.microsoft.com/en-us/sql/t-sql/statements/create-asymmetric-key-transact-sql

create_asymmetric_key
    : ASYMMETRIC KEY Asym_Key_Nam=id
       (AUTHORIZATION database_principal_name=id)?
       ( FROM (FILE EQUAL STRING |EXECUTABLE_FILE EQUAL STRING|ASSEMBLY Assembly_Name=id | PROVIDER Provider_Name=id) )?
       (WITH (ALGORITHM EQUAL ( RSA_4096 | RSA_3072 | RSA_2048 | RSA_1024 | RSA_512)  |PROVIDER_KEY_NAME EQUAL provider_key_name=STRING | CREATION_DISPOSITION EQUAL (CREATE_NEW|OPEN_EXISTING)  )   )?
       (ENCRYPTION BY PASSWORD EQUAL asymmetric_key_password=STRING )?
     ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-asymmetric-key-transact-sql
drop_asymmetric_key
     : ASYMMETRIC KEY key_name=id ( REMOVE PROVIDER KEY )?
     ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-authorization-transact-sql

alter_authorization
    : AUTHORIZATION ON (class_type COLON COLON)?
    entity=full_table_name TO authorization_grantee
    ;

authorization_grantee
    : principal_name=id
    | SCHEMA OWNER
    ;

class_type
    : OBJECT
    | ASSEMBLY
    | ASYMMETRIC KEY
    | AVAILABILITY GROUP
    | CERTIFICATE
    | CONTRACT
    | TYPE
    | DATABASE
    | ENDPOINT
    | FULLTEXT CATALOG
    | FULLTEXT STOPLIST
    | MESSAGE TYPE
    | REMOTE SERVICE BINDING
    | ROLE
    | ROUTE
    | SCHEMA
    | SEARCH PROPERTY LIST
    | SERVER ROLE
    | SERVICE
    | SYMMETRIC KEY
    | XML SCHEMA COLLECTION
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-availability-group-transact-sql
alter_availability_group
    : AVAILABILITY GROUP group_name=id alter_availability_group_options
    ;

alter_availability_group_options
    : SET LR_BRACKET ( ( AUTOMATED_BACKUP_PREFERENCE EQUAL ( PRIMARY | SECONDARY_ONLY| SECONDARY | NONE )  | FAILURE_CONDITION_LEVEL  EQUAL DECIMAL   | HEALTH_CHECK_TIMEOUT EQUAL milliseconds=DECIMAL  | DB_FAILOVER  EQUAL ( ON | OFF )   | REQUIRED_SYNCHRONIZED_SECONDARIES_TO_COMMIT EQUAL DECIMAL ) RR_BRACKET  )
    | ADD DATABASE database_name=id
    | REMOVE DATABASE database_name=id
    | ADD REPLICA ON server_instance=STRING (WITH LR_BRACKET ( (ENDPOINT_URL EQUAL STRING)?   (COMMA? AVAILABILITY_MODE EQUAL (SYNCHRONOUS_COMMIT| ASYNCHRONOUS_COMMIT))?    (COMMA? FAILOVER_MODE EQUAL (AUTOMATIC|MANUAL) )?  (COMMA?   SEEDING_MODE EQUAL (AUTOMATIC|MANUAL) )?  (COMMA?  BACKUP_PRIORITY EQUAL DECIMAL)?  ( COMMA? PRIMARY_ROLE  LR_BRACKET ALLOW_CONNECTIONS EQUAL ( READ_WRITE | ALL ) RR_BRACKET)?   ( COMMA? SECONDARY_ROLE  LR_BRACKET ALLOW_CONNECTIONS EQUAL ( READ_ONLY  ) RR_BRACKET )? )
)    RR_BRACKET
        |SECONDARY_ROLE LR_BRACKET (ALLOW_CONNECTIONS EQUAL (NO|READ_ONLY|ALL) | READ_ONLY_ROUTING_LIST EQUAL ( LR_BRACKET ( ( STRING) ) RR_BRACKET ) )
        |PRIMARY_ROLE LR_BRACKET (ALLOW_CONNECTIONS EQUAL (NO|READ_ONLY|ALL) | READ_ONLY_ROUTING_LIST EQUAL ( LR_BRACKET ( (COMMA? STRING)*|NONE ) RR_BRACKET )
        | SESSION_TIMEOUT EQUAL session_timeout=DECIMAL
)
    | MODIFY REPLICA ON server_instance=STRING (WITH LR_BRACKET (ENDPOINT_URL EQUAL STRING|  AVAILABILITY_MODE EQUAL (SYNCHRONOUS_COMMIT| ASYNCHRONOUS_COMMIT)  | FAILOVER_MODE EQUAL (AUTOMATIC|MANUAL) |   SEEDING_MODE EQUAL (AUTOMATIC|MANUAL)  |  BACKUP_PRIORITY EQUAL DECIMAL  )
        |SECONDARY_ROLE LR_BRACKET (ALLOW_CONNECTIONS EQUAL (NO|READ_ONLY|ALL) | READ_ONLY_ROUTING_LIST EQUAL ( LR_BRACKET ( ( STRING) ) RR_BRACKET ) )
        |PRIMARY_ROLE LR_BRACKET (ALLOW_CONNECTIONS EQUAL (NO|READ_ONLY|ALL) | READ_ONLY_ROUTING_LIST EQUAL ( LR_BRACKET ( (COMMA? STRING)*|NONE ) RR_BRACKET )
         | SESSION_TIMEOUT EQUAL session_timeout=DECIMAL
)   ) RR_BRACKET
    | REMOVE REPLICA ON STRING
    | JOIN
    | JOIN AVAILABILITY GROUP ON (COMMA? ag_name=STRING WITH LR_BRACKET ( LISTENER_URL EQUAL STRING COMMA AVAILABILITY_MODE EQUAL (SYNCHRONOUS_COMMIT|ASYNCHRONOUS_COMMIT) COMMA FAILOVER_MODE EQUAL MANUAL COMMA SEEDING_MODE EQUAL (AUTOMATIC|MANUAL) RR_BRACKET ) )+
     | MODIFY AVAILABILITY GROUP ON (COMMA? ag_name_modified=STRING WITH LR_BRACKET (LISTENER_URL EQUAL STRING  (COMMA? AVAILABILITY_MODE EQUAL (SYNCHRONOUS_COMMIT|ASYNCHRONOUS_COMMIT) )? (COMMA? FAILOVER_MODE EQUAL MANUAL )? (COMMA? SEEDING_MODE EQUAL (AUTOMATIC|MANUAL))? RR_BRACKET ) )+
    |GRANT CREATE ANY DATABASE
    | DENY CREATE ANY DATABASE
    | FAILOVER
    | FORCE_FAILOVER_ALLOW_DATA_LOSS
    | ADD LISTENER listener_name=STRING  LR_BRACKET ( WITH DHCP (ON LR_BRACKET (IPV4_ADDR IPV4_ADDR ) RR_BRACKET ) | WITH IP LR_BRACKET (    (COMMA? LR_BRACKET ( IPV4_ADDR  COMMA  IPV4_ADDR  | IPV6_ADDR  ) RR_BRACKET)+ RR_BRACKET  (COMMA PORT EQUAL DECIMAL)? ) ) RR_BRACKET
    | MODIFY LISTENER (ADD IP LR_BRACKET (IPV4_ADDR IPV4_ADDR | IPV6_ADDR) RR_BRACKET | PORT EQUAL DECIMAL )
    |RESTART LISTENER STRING
    |REMOVE LISTENER STRING
    |OFFLINE
    | WITH LR_BRACKET DTC_SUPPORT EQUAL PER_DB RR_BRACKET
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-broker-priority-transact-sql
// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-broker-priority-transact-sql
create_or_alter_broker_priority
    : BROKER PRIORITY ConversationPriorityName=id FOR CONVERSATION
      SET LR_BRACKET
     ( CONTRACT_NAME EQUAL ( ( id) | ANY )  COMMA?  )?
     ( LOCAL_SERVICE_NAME EQUAL (DOUBLE_FORWARD_SLASH? id | ANY ) COMMA? )?
     ( REMOTE_SERVICE_NAME  EQUAL (RemoteServiceName=STRING | ANY ) COMMA? )?
     ( PRIORITY_LEVEL EQUAL ( PriorityValue=DECIMAL | DEFAULT ) ) ?
     RR_BRACKET
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-certificate-transact-sql
alter_certificate
    : CERTIFICATE certificate_name=id (REMOVE PRIVATE_KEY | WITH PRIVATE KEY LR_BRACKET ( FILE EQUAL STRING COMMA? | DECRYPTION BY PASSWORD EQUAL STRING COMMA?| ENCRYPTION BY PASSWORD EQUAL STRING  COMMA?)+ RR_BRACKET | WITH ACTIVE FOR BEGIN_DIALOG EQUAL ( ON | OFF ) )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-column-encryption-key-transact-sql
alter_column_encryption_key
    : COLUMN ENCRYPTION KEY column_encryption_key=id (ADD | DROP) VALUE LR_BRACKET COLUMN_MASTER_KEY EQUAL column_master_key_name=id ( COMMA ALGORITHM EQUAL algorithm_name=STRING  COMMA ENCRYPTED_VALUE EQUAL BINARY)? RR_BRACKET
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-column-encryption-key-transact-sql
create_column_encryption_key
    :   COLUMN ENCRYPTION KEY column_encryption_key=id
         WITH VALUES
           (LR_BRACKET COMMA? COLUMN_MASTER_KEY EQUAL column_master_key_name=id COMMA
           ALGORITHM EQUAL algorithm_name=STRING  COMMA
           ENCRYPTED_VALUE EQUAL encrypted_value=BINARY RR_BRACKET COMMA?)+
     ;


drop_statements
    : (AGGREGATE | APPLICATION ROLE | AVAILABILITY GROUP | BROKER PRIORITY | CERTIFICATE
    | COLUMN (ENCRYPTION | MASTER) KEY | CONTRACT | CREDENTIAL | CRYPTOGRAPHIC PROVIDER
    | DATABASE (AUDIT SPECIFICATION | SCOPED CREDENTIAL)? | DEFAULT | ENDPOINT
    | EXTERNAL (DATA SOURCE | FILE FORMAT | LIBRARY | RESOURCE POOL | EXTERNAL TABLE) ( AUTHORIZATION id )?
    | FULLTEXT (CATALOG | INDEX ON | STOPLIST) | LOGIN | MESSAGE TYPE | PARTITION? FUNCTION | PARTITION SCHEME
    | PROC | PROCEDURE | QUEUE | REMOTE SERVICE BINDING | RESOURCE POOL | ROLE | ROUTE | RULE | SCHEMA | SEARCH PROPERTY LIST
    | SECURITY POLICY | SEQUENCE | SERVER AUDIT SPECIFICATION? | SERVER ROLE | SERVICE | STATISTICS | SYNONYM | TABLE
    | TYPE | TRIGGER | USER | VIEW | WORKLOAD GROUP | XML SCHEMA COLLECTION )
    ( IF EXISTS )? full_table_name (COMMA full_table_name)*
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-event-notification-transact-sql
// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-event-session-transact-sql
drop_event_notifications_or_session
    : EVENT (NOTIFICATION | SESSION) (COMMA? notification_name=id)+
        ON (SERVER|DATABASE|QUEUE queue_name=id)
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-master-key-transact-sql
drop_master_key
     : MASTER KEY
     ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-signature-transact-sql
drop_signature
     : ( COUNTER )? SIGNATURE FROM (schema_name=id DOT)? module_name=id
         BY (COMMA?  CERTIFICATE cert_name=id
            | COMMA? ASYMMETRIC KEY Asym_key_name=id
            )+
     ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-symmetric-key-transact-sql
drop_symmetric_key
     : SYMMETRIC KEY symmetric_key_name=id (REMOVE PROVIDER KEY)?
     ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/disable-trigger-transact-sql
disable_trigger
     : DISABLE TRIGGER (trigger_names | ALL) ON (table_name|DATABASE|ALL SERVER)
     ;
     
trigger_names
    : trigger_name (COMMA trigger_name)*
    ;

trigger_name
    : (schema_name=id DOT)? name=id
    ;
    
// https://docs.microsoft.com/en-us/sql/t-sql/statements/enable-trigger-transact-sql
enable_trigger
     : ENABLE TRIGGER (trigger_names| ALL) ON (table_name|DATABASE|ALL SERVER)
     ;

lock_table
     : LOCK TABLE table_name IN (SHARE | EXCLUSIVE) MODE (WAIT seconds=DECIMAL | NOWAIT)? ?
     ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/truncate-table-transact-sql
truncate_table
     : TRUNCATE TABLE full_table_name ( WITH '(' PARTITIONS '(' (COMMA? (DECIMAL|DECIMAL TO DECIMAL) )+ ')' ')' )?
     ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-column-master-key-transact-sql
create_column_master_key
     : COLUMN MASTER KEY key_name=id
         WITH LR_BRACKET
            KEY_STORE_PROVIDER_NAME EQUAL  key_store_provider_name=STRING COMMA
            KEY_PATH EQUAL key_path=STRING
           RR_BRACKET
      ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-credential-transact-sql
alter_credential
    : CREDENTIAL credential_name=id
        WITH IDENTITY EQUAL identity_name=STRING
         ( COMMA SECRET EQUAL secret=STRING )?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-credential-transact-sql
create_credential
    : CREDENTIAL credential_name=id
        WITH IDENTITY EQUAL identity_name=STRING
         ( COMMA SECRET EQUAL secret=STRING )?
         (  FOR CRYPTOGRAPHIC PROVIDER cryptographic_provider_name=id )?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-cryptographic-provider-transact-sql
alter_cryptographic_provider
    : CRYPTOGRAPHIC PROVIDER provider_name=id (FROM FILE EQUAL crypto_provider_ddl_file=STRING)? (ENABLE | DISABLE)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-cryptographic-provider-transact-sql
create_cryptographic_provider
    : CRYPTOGRAPHIC PROVIDER provider_name=id
      FROM FILE EQUAL path_of_DLL=STRING
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-event-notification-transact-sql
create_event_notification
    : EVENT NOTIFICATION event_notification_name=id
      ON (SERVER|DATABASE|QUEUE queue_name=id)
        (WITH FAN_IN)?
        FOR (COMMA? event_type_or_group=id)+
          TO SERVICE  broker_service=STRING  COMMA
             broker_service_specifier_or_current_database=STRING
    ;


// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-event-session-transact-sql
// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-event-session-transact-sql
// todo: not implemented
create_or_alter_event_session
    : EVENT SESSION event_session_name=id ON SERVER
       (COMMA? ADD EVENT ( (event_module_guid=id DOT)? event_package_name=id DOT event_name=id)
        (LR_BRACKET
          (SET ( COMMA? event_customizable_attributue=id EQUAL (DECIMAL|STRING) )* )?
          ( ACTION LR_BRACKET (COMMA? (event_module_guid=id DOT)? event_package_name=id DOT action_name=id)+  RR_BRACKET)+
          (WHERE event_session_predicate_expression)?
         RR_BRACKET )*
      )*
      (COMMA? DROP EVENT (event_module_guid=id DOT)? event_package_name=id DOT event_name=id )*

      ( (ADD TARGET (event_module_guid=id DOT)? event_package_name=id DOT target_name=id ) ( LR_BRACKET SET (COMMA? target_parameter_name=id EQUAL (LR_BRACKET? DECIMAL RR_BRACKET? |STRING) )+ RR_BRACKET )* )*
       (DROP TARGET (event_module_guid=id DOT)? event_package_name=id DOT target_name=id )*


     (WITH
           LR_BRACKET
           (COMMA? MAX_MEMORY EQUAL max_memory=DECIMAL (KB|MB) )?
           (COMMA? EVENT_RETENTION_MODE EQUAL (ALLOW_SINGLE_EVENT_LOSS | ALLOW_MULTIPLE_EVENT_LOSS | NO_EVENT_LOSS ) )?
           (COMMA? MAX_DISPATCH_LATENCY EQUAL (max_dispatch_latency_seconds=DECIMAL SECONDS | INFINITE) )?
           (COMMA?  MAX_EVENT_SIZE EQUAL max_event_size=DECIMAL (KB|MB) )?
           (COMMA? MEMORY_PARTITION_MODE EQUAL (NONE | PER_NODE | PER_CPU) )?
           (COMMA? TRACK_CAUSALITY EQUAL (ON|OFF) )?
           (COMMA? STARTUP_STATE EQUAL (ON|OFF) )?
           RR_BRACKET
     )?
     (STATE EQUAL (START|STOP) )?

    ;

event_session_predicate_expression
     : ( COMMA? (AND|OR)? NOT? ( event_session_predicate_factor | LR_BRACKET event_session_predicate_expression RR_BRACKET) )+
     ;

event_session_predicate_factor
     : event_session_predicate_leaf
     | LR_BRACKET event_session_predicate_expression RR_BRACKET
     ;

event_session_predicate_leaf
     : (event_field_name=id | (event_field_name=id |( (event_module_guid=id DOT)?  event_package_name=id DOT predicate_source_name=id ) ) (EQUAL |(LESS GREATER) | (EXCLAMATION EQUAL) | GREATER  | (GREATER EQUAL)| LESS | LESS EQUAL) (DECIMAL | STRING) )
     | (event_module_guid=id DOT)?  event_package_name=id DOT predicate_compare_name=id LR_BRACKET (event_field_name=id |( (event_module_guid=id DOT)?  event_package_name=id DOT predicate_source_name=id ) COMMA  (DECIMAL | STRING) ) RR_BRACKET
     ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-external-data-source-transact-sql
alter_external_data_source
    : EXTERNAL DATA SOURCE data_source_name=id  SET
    ( LOCATION EQUAL location=(QUOTED_URL|QUOTED_HOST_AND_PORT) COMMA? |  RESOURCE_MANAGER_LOCATION EQUAL resource_manager_location=(QUOTED_URL|QUOTED_HOST_AND_PORT) COMMA? |  CREDENTIAL EQUAL credential_name=id )+
    | ALTER EXTERNAL DATA SOURCE data_source_name=id WITH LR_BRACKET TYPE EQUAL BLOB_STORAGE COMMA LOCATION EQUAL location=STRING (COMMA CREDENTIAL EQUAL credential_name=id )? RR_BRACKET
    ;


// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-external-library-transact-sql
alter_external_library
    : EXTERNAL LIBRARY library_name=id (AUTHORIZATION owner_name=id)?
       (SET|ADD) ( LR_BRACKET CONTENT EQUAL (client_library=STRING | BINARY | NONE)
           (COMMA PLATFORM EQUAL (WINDOWS|LINUX)? RR_BRACKET)
           WITH (COMMA? LANGUAGE EQUAL (R_LETTER | PYTHON) | DATA_SOURCE EQUAL external_data_source_name=id )+ RR_BRACKET
       )
   ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-external-library-transact-sql
create_external_library
    : EXTERNAL LIBRARY library_name=id (AUTHORIZATION owner_name=id)?
       FROM (COMMA? LR_BRACKET?  (CONTENT EQUAL)?
           (client_library=STRING | BINARY | NONE) (COMMA PLATFORM EQUAL (WINDOWS|LINUX)? RR_BRACKET)?
       ) ( WITH (COMMA? LANGUAGE EQUAL (R_LETTER|PYTHON) | DATA_SOURCE EQUAL external_data_source_name=id )+ RR_BRACKET  )?
   ;


// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-external-resource-pool-transact-sql
alter_external_resource_pool
    : EXTERNAL RESOURCE POOL (pool_name=id | DEFAULT_DOUBLE_QUOTE) WITH LR_BRACKET MAX_CPU_PERCENT EQUAL max_cpu_percent=DECIMAL ( COMMA? AFFINITY CPU EQUAL (AUTO|(COMMA? DECIMAL TO DECIMAL |COMMA DECIMAL )+ ) | NUMANODE EQUAL (COMMA? DECIMAL TO DECIMAL| COMMA? DECIMAL )+  ) (COMMA? MAX_MEMORY_PERCENT EQUAL max_memory_percent=DECIMAL)? (COMMA? MAX_PROCESSES EQUAL max_processes=DECIMAL)?  RR_BRACKET
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-external-resource-pool-transact-sql
create_external_resource_pool
    : EXTERNAL RESOURCE POOL pool_name=id  WITH LR_BRACKET MAX_CPU_PERCENT EQUAL max_cpu_percent=DECIMAL ( COMMA? AFFINITY CPU EQUAL (AUTO|(COMMA? DECIMAL TO DECIMAL |COMMA DECIMAL )+ ) | NUMANODE EQUAL (COMMA? DECIMAL TO DECIMAL| COMMA? DECIMAL )+  ) (COMMA? MAX_MEMORY_PERCENT EQUAL max_memory_percent=DECIMAL)? (COMMA? MAX_PROCESSES EQUAL max_processes=DECIMAL)?  RR_BRACKET
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-fulltext-catalog-transact-sql
alter_fulltext_catalog
    : FULLTEXT CATALOG catalog_name=id (REBUILD (WITH ACCENT_SENSITIVITY EQUAL (ON|OFF) )? | REORGANIZE | AS DEFAULT )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-fulltext-catalog-transact-sql
create_fulltext_catalog
    : FULLTEXT CATALOG catalog_name=id
        (ON FILEGROUP filegroup=id)?
        (IN PATH rootpath=STRING)?
        (WITH ACCENT_SENSITIVITY EQUAL (ON|OFF) )?
        (AS DEFAULT)?
        (AUTHORIZATION owner_name=id)?
    ;



// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-fulltext-stoplist-transact-sql
alter_fulltext_stoplist
    : FULLTEXT STOPLIST stoplist_name=id (ADD stopword=STRING LANGUAGE (STRING|DECIMAL|BINARY) | DROP ( stopword=STRING LANGUAGE (STRING|DECIMAL|BINARY) |ALL (STRING|DECIMAL|BINARY) | ALL ) )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-fulltext-stoplist-transact-sql
create_fulltext_stoplist
    :   FULLTEXT STOPLIST stoplist_name=id
          (FROM ( (database_name=id DOT)? source_stoplist_name=id |SYSTEM STOPLIST ) )?
          (AUTHORIZATION owner_name=id)?
    ;


// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-login-transact-sql
alter_login_sql_server
    : LOGIN login_name=id
       ( (ENABLE|DISABLE)?  | WITH ( (PASSWORD EQUAL ( password=STRING | password_hash=BINARY HASHED ) ) (MUST_CHANGE|UNLOCK)* )? (OLD_PASSWORD EQUAL old_password=STRING (MUST_CHANGE|UNLOCK)* )? (DEFAULT_DATABASE EQUAL default_database=id)? (DEFAULT_LANGUAGE EQUAL default_laguage=id)?  (NAME EQUAL login_name=id)? (CHECK_POLICY EQUAL (ON|OFF) )? (CHECK_EXPIRATION EQUAL (ON|OFF) )? (CREDENTIAL EQUAL credential_name=id)? (NO CREDENTIAL)? | (ADD|DROP) CREDENTIAL credential_name=id )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-login-transact-sql
create_login_sql_server
    : LOGIN login_name=id
       ( WITH ( (PASSWORD EQUAL ( password=STRING | password_hash=BINARY HASHED ) ) (MUST_CHANGE|UNLOCK)* )?
       (COMMA? SID EQUAL sid=BINARY)?
       (COMMA? DEFAULT_DATABASE EQUAL default_database=id)?
       (COMMA? DEFAULT_LANGUAGE EQUAL default_laguage=id)?
       (COMMA? CHECK_EXPIRATION EQUAL (ON|OFF) )?
       (COMMA? CHECK_POLICY EQUAL (ON|OFF) )?
       (COMMA? CREDENTIAL EQUAL credential_name=id)?
      |(FROM
    (WINDOWS
          (WITH (COMMA? DEFAULT_DATABASE EQUAL default_database=id)? (COMMA?  DEFAULT_LANGUAGE EQUAL default_language=STRING)? )
        | CERTIFICATE certname=id
        | ASYMMETRIC KEY asym_key_name=id
                )
        )
      )
    ;

create_login_pdw
    : LOGIN loginName=id
        (WITH
          ( PASSWORD EQUAL password=STRING (MUST_CHANGE)? (SID EQUAL sid=BINARY)?
              (CHECK_POLICY EQUAL (ON|OFF)? )?
          )
        | FROM WINDOWS
        )
     ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-master-key-transact-sql
alter_master_key_sql_server
    : MASTER KEY ( (FORCE)? REGENERATE WITH ENCRYPTION BY PASSWORD EQUAL password=STRING | (ADD|DROP) ENCRYPTION BY (SERVICE MASTER KEY | PASSWORD EQUAL encryption_password=STRING) )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-master-key-transact-sql
create_master_key_sql_server
    : MASTER KEY ENCRYPTION BY PASSWORD EQUAL password=STRING
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-message-type-transact-sql
alter_message_type
    : MESSAGE TYPE message_type_name=id VALIDATION EQUAL (NONE | EMPTY | WELL_FORMED_XML | VALID_XML WITH SCHEMA COLLECTION schema_collection_name=id)
    ;


// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-partition-function-transact-sql
alter_partition_function
    : PARTITION FUNCTION partition_function_name=id LR_BRACKET RR_BRACKET        (SPLIT|MERGE) RANGE LR_BRACKET DECIMAL RR_BRACKET
    ;


// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-partition-scheme-transact-sql
alter_partition_scheme
    : PARTITION SCHEME partition_scheme_name=id NEXT USED (file_group_name=id)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-remote-service-binding-transact-sql
alter_remote_service_binding
    : REMOTE SERVICE BINDING binding_name=id
        WITH (USER EQUAL user_name=id)?
             (COMMA ANONYMOUS EQUAL (ON|OFF) )?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-remote-service-binding-transact-sql
create_remote_service_binding
    : REMOTE SERVICE BINDING binding_name=id
         (AUTHORIZATION owner_name=id)?
         TO SERVICE remote_service_name=STRING
         WITH (USER EQUAL user_name=id)?
              (COMMA ANONYMOUS EQUAL (ON|OFF) )?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-resource-pool-transact-sql
create_resource_pool
    : RESOURCE POOL pool_name=id
        (WITH
            LR_BRACKET
               (COMMA? MIN_CPU_PERCENT EQUAL DECIMAL)?
               (COMMA? MAX_CPU_PERCENT EQUAL DECIMAL)?
               (COMMA? CAP_CPU_PERCENT EQUAL DECIMAL)?
               (COMMA? AFFINITY SCHEDULER EQUAL
                                  (AUTO
                                   | LR_BRACKET (COMMA? (DECIMAL|DECIMAL TO DECIMAL) )+ RR_BRACKET
                                   | NUMANODE EQUAL LR_BRACKET (COMMA? (DECIMAL|DECIMAL TO DECIMAL) )+ RR_BRACKET
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
    : RESOURCE GOVERNOR ( (DISABLE | RECONFIGURE) | WITH LR_BRACKET CLASSIFIER_FUNCTION EQUAL ( schema_name=id DOT function_name=id | NULL ) RR_BRACKET | RESET STATISTICS | WITH LR_BRACKET MAX_OUTSTANDING_IO_PER_VOLUME EQUAL max_outstanding_io_per_volume=DECIMAL RR_BRACKET )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-role-transact-sql
alter_db_role
    : ROLE role_name=id
        ( (ADD|DROP) MEMBER database_principal=id
        | WITH NAME EQUAL new_role_name=id )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-role-transact-sql
create_db_role
    : ROLE role_name=id (AUTHORIZATION owner_name = id)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-route-transact-sql
create_route
    : ROUTE route_name=id
        (AUTHORIZATION owner_name=id)?
        WITH
          (COMMA? SERVICE_NAME EQUAL route_service_name=STRING)?
          (COMMA? BROKER_INSTANCE EQUAL broker_instance_identifier=STRING)?
          (COMMA? LIFETIME EQUAL DECIMAL)?
          COMMA? ADDRESS EQUAL (STRING|QUOTED_URL)
          (COMMA MIRROR_ADDRESS EQUAL (STRING|QUOTED_URL) )?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-rule-transact-sql
create_rule
    : RULE (schema_name=id DOT)? rule_name=id
        AS search_condition
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-schema-transact-sql
alter_schema_sql
    : SCHEMA schema_name=id TRANSFER ((OBJECT|TYPE|XML SCHEMA COLLECTION) COLON COLON )? id (DOT id)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-schema-transact-sql
create_schema
    : SCHEMA (schema_name=id | schema_name=id (AUTHORIZATION owner_name=id)?)
        schema_def=schema_definition?
    ;

schema_definition
    : (create_table
         |create_or_alter_view
         | (GRANT|DENY) (SELECT|INSERT|DELETE|UPDATE) ON (SCHEMA COLON COLON)? object_name=id TO owner_name=id
         | REVOKE (SELECT|INSERT|DELETE|UPDATE) ON (SCHEMA COLON COLON)? object_name=id FROM owner_name=id
        )+
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-search-property-list-transact-sql
create_search_property_list
    : SEARCH PROPERTY LIST new_list_name=id
        (FROM (database_name=id DOT)? source_list_name=id )?
        (AUTHORIZATION owner_name=id)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-security-policy-transact-sql
create_security_policy
   : SECURITY POLICY (schema_name=id DOT)? security_policy_name=id
        (COMMA? ADD (FILTER|BLOCK)? PREDICATE tvf_schema_name=id DOT security_predicate_function_name=id
            LR_BRACKET (COMMA? column_name_or_arguments=id)+ RR_BRACKET
              ON table_schema_name=id DOT name=id
                (COMMA? AFTER (INSERT|UPDATE)
                | COMMA? BEFORE (UPDATE|DELETE)
                )*
         )+
            (WITH LR_BRACKET
                     STATE EQUAL (ON|OFF)
             (SCHEMABINDING (ON|OFF) )?
                  RR_BRACKET
             )?
             not_for_replication?
     ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-sequence-transact-sql
alter_sequence
    : SEQUENCE simple_name (sequence_body | RESTART (WITH restart=signed_numerical_literal)?) *
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-sequence-transact-sql
create_sequence
    : SEQUENCE simple_name (sequence_body)*
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
        ( ( TO
              (FILE
                ( LR_BRACKET
                   ( COMMA? FILEPATH EQUAL filepath=STRING
                    | COMMA? MAXSIZE EQUAL ( DECIMAL (MB|GB|TB)
                    |  UNLIMITED
                   )
                   | COMMA? MAX_ROLLOVER_FILES EQUAL max_rollover_files=(DECIMAL|UNLIMITED)
                   | COMMA? MAX_FILES EQUAL max_files=DECIMAL
                   | COMMA? RESERVE_DISK_SPACE EQUAL (ON|OFF)  )*
                 RR_BRACKET )
                | APPLICATION_LOG
                | SECURITY_LOG
            ) )?
            ( WITH LR_BRACKET
              (COMMA? QUEUE_DELAY EQUAL queue_delay=DECIMAL
              | COMMA? ON_FAILURE EQUAL (CONTINUE | SHUTDOWN|FAIL_OPERATION)
              |COMMA?  STATE EQUAL (ON|OFF) )*
              RR_BRACKET
            )?
            ( WHERE ( COMMA? (NOT?) event_field_name=id
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
                                             (DECIMAL | STRING) ) )?
        |REMOVE WHERE
        | MODIFY NAME EQUAL new_audit_name=id
       )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-server-audit-transact-sql
create_server_audit
    : SERVER AUDIT audit_name=id
        ( ( TO
              (FILE
                ( LR_BRACKET
                   ( COMMA? FILEPATH EQUAL filepath=STRING
                    | COMMA? MAXSIZE EQUAL ( DECIMAL (MB|GB|TB)
                    |  UNLIMITED
                   )
                   | COMMA? MAX_ROLLOVER_FILES EQUAL max_rollover_files=(DECIMAL|UNLIMITED)
                   | COMMA? MAX_FILES EQUAL max_files=DECIMAL
                   | COMMA? RESERVE_DISK_SPACE EQUAL (ON|OFF)  )*
                 RR_BRACKET )
                | APPLICATION_LOG
                | SECURITY_LOG
            ) )?
            ( WITH LR_BRACKET
              (COMMA? QUEUE_DELAY EQUAL queue_delay=DECIMAL
              | COMMA? ON_FAILURE EQUAL (CONTINUE | SHUTDOWN|FAIL_OPERATION)
              |COMMA?  STATE EQUAL (ON|OFF)
              |COMMA? AUDIT_GUID EQUAL audit_guid=id
            )*

              RR_BRACKET
            )?
            ( WHERE ( COMMA? (NOT?) event_field_name=id
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
                                             (DECIMAL | STRING) ) )?
        |REMOVE WHERE
        | MODIFY NAME EQUAL new_audit_name=id
       )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-server-audit-specification-transact-sql

alter_server_audit_specification
    : SERVER AUDIT SPECIFICATION audit_specification_name=id
       (FOR SERVER AUDIT audit_name=id)?
       ( (ADD|DROP) LR_BRACKET  audit_action_group_name=id RR_BRACKET )*
         (WITH LR_BRACKET STATE EQUAL (ON|OFF) RR_BRACKET )?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-server-audit-specification-transact-sql
create_server_audit_specification
    : SERVER AUDIT SPECIFICATION audit_specification_name=id
       (FOR SERVER AUDIT audit_name=id)?
       ( ADD LR_BRACKET  audit_action_group_name=id RR_BRACKET )*
         (WITH LR_BRACKET STATE EQUAL (ON|OFF) RR_BRACKET )?
    ;


// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-server-configuration-transact-sql

alter_server_configuration
    : SERVER CONFIGURATION
      SET  ( (PROCESS AFFINITY
          (CPU EQUAL (AUTO | (COMMA? DECIMAL | COMMA? DECIMAL TO DECIMAL)+ )
              | NUMANODE EQUAL ( COMMA? DECIMAL |COMMA?  DECIMAL TO DECIMAL)+)
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
          | BUFFER POOL EXTENSION (ON LR_BRACKET FILENAME EQUAL STRING COMMA SIZE EQUAL DECIMAL (KB|MB|GB)  RR_BRACKET | OFF )
          | SET SOFTNUMA (ON|OFF)
      ) )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-server-role-transact-sql
alter_server_role
    : SERVER ROLE server_role_name=id
      ( (ADD|DROP) MEMBER server_principal=id
      | WITH NAME EQUAL new_server_role_name=id
      )
    ;
// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-server-role-transact-sql
create_server_role
    : SERVER ROLE server_role=id (AUTHORIZATION server_principal=id)?
    ;

alter_server_role_pdw
    : SERVER ROLE server_role_name=id (ADD|DROP) MEMBER login=id
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-service-transact-sql
alter_service
    : SERVICE modified_service_name=id (ON QUEUE (schema_name=id DOT) queue_name=id)? (COMMA? (ADD|DROP) modified_contract_name=id)*
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-service-transact-sql
create_service
    : SERVICE create_service_name=id
        (AUTHORIZATION owner_name=id)?
        ON QUEUE (schema_name=id DOT)? queue_name=id
          ( LR_BRACKET (COMMA? (id|DEFAULT) )+ RR_BRACKET )?
    ;


// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-service-master-key-transact-sql

alter_service_master_key
    : SERVICE MASTER KEY ( FORCE? REGENERATE | (WITH (OLD_ACCOUNT EQUAL acold_account_name=STRING COMMA OLD_PASSWORD EQUAL old_password=STRING | NEW_ACCOUNT EQUAL new_account_name=STRING COMMA NEW_PASSWORD EQUAL new_password=STRING)?  ) )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-symmetric-key-transact-sql

alter_symmetric_key
    : SYMMETRIC KEY key_name=id ( (ADD|DROP) ENCRYPTION BY (CERTIFICATE certificate_name=id | PASSWORD EQUAL password=STRING | SYMMETRIC KEY symmetric_key_name=id | ASYMMETRIC KEY Asym_key_name=id  ) )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-symmetric-key-transact-sql
create_symmetric_key
    :  SYMMETRIC KEY key_name=id
           (AUTHORIZATION owner_name=id)?
           (FROM PROVIDER provider_name=id)?
           (WITH ( (KEY_SOURCE EQUAL key_pass_phrase=STRING
                   | ALGORITHM EQUAL (DES | TRIPLE_DES | TRIPLE_DES_3KEY | RC2 | RC4 | RC4_128  | DESX | AES_128 | AES_192 | AES_256)
                   | IDENTITY_VALUE EQUAL identity_phrase=STRING
                   | PROVIDER_KEY_NAME EQUAL provider_key_name=STRING
                   | CREATION_DISPOSITION EQUAL (CREATE_NEW|OPEN_EXISTING)
                   )
                 | ENCRYPTION BY
                     ( CERTIFICATE certificate_name=id
                     | PASSWORD EQUAL password=STRING
                     | SYMMETRIC KEY symmetric_key_name=id
                     | ASYMMETRIC KEY asym_key_name=id
                     )
                 )
            )
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-synonym-transact-sql
create_synonym
    : SYNONYM (schema_name_1=id DOT )? synonym_name=id
        FOR ( (server_name=id DOT )? (database_name=id DOT)? (schema_name_2=id DOT)? object_name=id
            | (database_or_schema2=id DOT)? (schema_id_2_or_object_name=id DOT)?
            )
    ;


// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-user-transact-sql
alter_user
    : USER username=id WITH (COMMA? NAME EQUAL newusername=id | COMMA? DEFAULT_SCHEMA EQUAL ( schema_name=id |NULL ) | COMMA? LOGIN EQUAL loginame=id | COMMA? PASSWORD EQUAL STRING (OLD_PASSWORD EQUAL STRING)+ | COMMA? DEFAULT_LANGUAGE EQUAL (NONE| lcid=DECIMAL| language_name_or_alias=id) | COMMA? ALLOW_ENCRYPTED_VALUE_MODIFICATIONS EQUAL (ON|OFF) )+
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-user-transact-sql
create_user
    : USER user_name=id user_login?
    (FROM EXTERNAL PROVIDER)?
    (WITH user_option (COMMA user_option)*)?
    ((FOR|FROM) (CERTIFICATE | ASYMMETRIC KEY) cert_or_asym_key_name=id)?
    ;

user_login
    : (FOR|FROM) LOGIN login_name=id
    | WITHOUT LOGIN
    ;

user_option
    : DEFAULT_SCHEMA EQUAL schema_name=id
    | FAULT_LANGUAGE EQUAL (NONE | DECIMAL | language_name_or_alias=id)
    | SID EQUAL BINARY
    | ALLOW_ENCRYPTED_VALUE_MODIFICATIONS EQUAL (ON|OFF)
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-workload-group-transact-sql
alter_workload_group
    : WORKLOAD GROUP (workload_group_group_name=id | DEFAULT_DOUBLE_QUOTE)
         (WITH LR_BRACKET
           (IMPORTANCE EQUAL (LOW|MEDIUM|HIGH)
           | COMMA? REQUEST_MAX_MEMORY_GRANT_PERCENT EQUAL request_max_memory_grant=DECIMAL
           | COMMA? REQUEST_MAX_CPU_TIME_SEC EQUAL request_max_cpu_time_sec=DECIMAL
           | REQUEST_MEMORY_GRANT_TIMEOUT_SEC EQUAL request_memory_grant_timeout_sec=DECIMAL
           | MAX_DOP EQUAL max_dop=DECIMAL
           | GROUP_MAX_REQUESTS EQUAL group_max_requests=DECIMAL)+
          RR_BRACKET )?
     (USING (workload_group_pool_name=id | DEFAULT_DOUBLE_QUOTE) )?
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
          RR_BRACKET )?
     (USING (workload_group_pool_name=id | DEFAULT_DOUBLE_QUOTE)?
            (COMMA? EXTERNAL external_pool_name=id | DEFAULT_DOUBLE_QUOTE)?
      )?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-xml-schema-collection-transact-sql
create_xml_schema_collection
    : XML SCHEMA COLLECTION (relational_schema=id DOT)? sql_identifier=id AS  (STRING|id|LOCAL_ID)
    ;

create_queue
    : QUEUE (full_table_name | queue_name=id) queue_settings?
      (ON filegroup=id | DEFAULT)?
    ;


queue_settings
    :WITH
       (STATUS EQUAL (ON | OFF) COMMA?)?
       (RETENTION EQUAL (ON | OFF) COMMA?)?
       (ACTIVATION
         LR_BRACKET
           (
             (
              (STATUS EQUAL (ON | OFF) COMMA? )?
              (PROCEDURE_NAME EQUAL func_proc_name COMMA?)?
              (MAX_QUEUE_READERS EQUAL max_readers=DECIMAL COMMA?)?
              (EXECUTE AS (SELF | user_name=STRING | OWNER) COMMA?)?
             )
             | DROP
           )
         RR_BRACKET COMMA?
       )?
       (POISON_MESSAGE_HANDLING
         LR_BRACKET
           (STATUS EQUAL (ON | OFF))
         RR_BRACKET
       )?
    ;

alter_queue
    : QUEUE (full_table_name | queue_name=id)
      (queue_settings | queue_action)
    ;

queue_action
    : REBUILD ( WITH LR_BRACKET queue_rebuild_options RR_BRACKET)?
    | REORGANIZE (WITH LOB_COMPACTION EQUAL (ON | OFF))?
    | MOVE TO (id | DEFAULT)
    ;
queue_rebuild_options
    : MAXDOP EQUAL DECIMAL
    ;

create_contract
    : CONTRACT contract_name
      (AUTHORIZATION owner_name=id)?
      LR_BRACKET ((message_type_name=id | DEFAULT)
          SENT BY (INITIATOR | TARGET | ANY ) COMMA?)+
      RR_BRACKET
    ;

conversation_statement
    : begin_conversation_timer
    | begin_conversation_dialog
    | end_conversation
    | get_conversation
    | send_conversation
    | waitfor_conversation
    ;

create_message_type
    : MESSAGE TYPE message_type_name=id
      (AUTHORIZATION owner_name=id)?
      (VALIDATION EQUAL (NONE
      | EMPTY
      | WELL_FORMED_XML
      | VALID_XML WITH SCHEMA COLLECTION schema_collection_name=id))
    ;

// DML

// https://docs.microsoft.com/en-us/sql/t-sql/statements/merge-transact-sql
merge_statement
    : with_expression?
      MERGE (TOP '(' expression ')' PERCENT?)?
      INTO? ddl_object insert_with_table_hints? as_table_alias?
      USING table_sources
      ON search_condition
      (WHEN MATCHED (AND search_condition)?
          THEN merge_matched)*
      (WHEN NOT MATCHED (BY TARGET)? (AND search_condition)?
          THEN merge_not_matched)?
      (WHEN NOT MATCHED BY SOURCE (AND search_condition)?
          THEN merge_matched)*
      output_clause?
      option_clause? ';'
    ;


merge_matched
    : UPDATE SET update_elem (',' update_elem)*
    | DELETE
    ;

merge_not_matched
    : INSERT ('(' column_name_list ')')?
      (table_value_constructor | DEFAULT VALUES)
    ;

// https://msdn.microsoft.com/en-us/library/ms189835.aspx
delete_statement
    : with_expression?
      DELETE (TOP '(' expression ')' PERCENT? | TOP DECIMAL)?
      FROM? delete_statement_from
      insert_with_table_hints?
      output_clause?
      (FROM table_sources)?
      (WHERE (search_condition | CURRENT OF (GLOBAL? cursor_name | cursor_var=LOCAL_ID)))?
      for_clause? option_clause?
    ;

delete_statement_from
    : ddl_object
    | id with_table_hints
    | rowset_function_limited
    ;

// https://msdn.microsoft.com/en-us/library/ms174335.aspx
insert_statement
    : with_expression?
      INSERT (TOP '(' expression ')' PERCENT?)?
      INTO? (ddl_object | rowset_function_limited)
      insert_with_table_hints?
      ('(' column_name_list ')')?
      output_clause?
      insert_statement_value
      for_clause? option_clause?
    ;

insert_statement_value
    : derived_table
    | execute_statement
    | DEFAULT VALUES
    ;


receive_statement
    : '('? RECEIVE (ALL | DISTINCT | top_clause | '*')
      (LOCAL_ID '=' expression ','?)* FROM full_table_name
      (INTO table_variable=id (WHERE where=search_condition))? ')'?
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
    : '(' select_statement ')' //  parens can be used to apply "global" clauses (WITH etc) to a particular select in UNION expr
    | select_ops (INTERSECT | UNION | EXCEPT) (DISTINCT | ALL)? select_ops
    | query_specification
    ;

select_ops_no_parens
    : select_ops (INTERSECT | UNION | EXCEPT) (DISTINCT | ALL)? select_ops
    | query_specification
    ;


time
    : (LOCAL_ID | constant)
    ;

// https://msdn.microsoft.com/en-us/library/ms177523.aspx
update_statement
    : with_expression?
      UPDATE (TOP '(' expression ')' PERCENT?)?
      (ddl_object | rowset_function_limited)
      with_table_hints?
      SET update_elem (',' update_elem)*
      output_clause?
      (FROM table_sources)?
      (WHERE (search_condition_list | CURRENT OF (GLOBAL? cursor_name | cursor_var=LOCAL_ID)))?
      for_clause? option_clause?
    ;

// https://msdn.microsoft.com/en-us/library/ms177564.aspx
output_clause
    : OUTPUT output_dml_list_elem (',' output_dml_list_elem)*
      (INTO (LOCAL_ID | table_name) ('(' column_name_list ')')? )?
    ;

output_dml_list_elem
    : (output_column_name | expression) (AS? column_alias)?  // TODO: scalar_expression
    ;

output_column_name
    : (DELETED | INSERTED | table_name) '.' ('*' | id)
    | DOLLAR_ACTION
    ;

// DDL

// https://msdn.microsoft.com/en-ie/library/ms176061.aspx
create_database
    : DATABASE (database=id)
    ( CONTAINMENT '=' ( NONE | PARTIAL ) )?
    ( ON PRIMARY? database_file_spec ( ',' database_file_spec )* )?
    ( LOG ON database_file_spec ( ',' database_file_spec )* )?
    ( COLLATE collation_name = id )?
    ( WITH  create_database_option ( ',' create_database_option )* )?
    ;

// https://msdn.microsoft.com/en-us/library/ms188783.aspx
create_index
    : UNIQUE? clustered? INDEX name=id ON table_name index_rest;

index_rest
    : index_sort index_where? index_options? (ON id)?
    ;

index_sort
    : with_table_hints? '(' column_name_list_with_order ')'
    (INCLUDE '(' column_name_list ')' )?
    ;

index_where
    : WHERE where=search_condition
    ;

// https://msdn.microsoft.com/en-us/library/ms187926(v=sql.120).aspx
create_or_alter_procedure
    : (OR ALTER)? proc=(PROC | PROCEDURE) func_proc_name (';' DECIMAL)?
      ('('? procedure_param (',' procedure_param)* ')'?)?
      (WITH procedure_option (',' procedure_option)*)?
      (FOR REPLICATION)? AS proc_body
    ;

 proc_body
    : sql_clauses
    | EXTERNAL NAME full_table_name
    ;

create_or_alter_trigger
    : (OR ALTER)? TRIGGER simple_name
    ON (table_name | ALL SERVER | DATABASE)
    (WITH trigger_option (',' trigger_option)* )?
    (FOR | AFTER | INSTEAD OF) trigger_operation (',' trigger_operation)*
    with_append?
    not_for_replication?
    AS st_clause
    ;

not_for_replication
    : NOT FOR REPLICATION
    ;

with_append
    : WITH APPEND
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
    : (OR ALTER)? FUNCTION func_proc_name '(' (procedure_param (',' procedure_param)*)?  ')'
    RETURNS func_return
    func_body
    ;

func_return
    : TABLE ('(' column_def_table_constraints ')')?
    | LOCAL_ID table_type_definition
    | data_type
    ;

func_body
    : (WITH function_option (',' function_option)*)?
    AS? func_body_return
    ;

func_body_return
    : RETURN select_statement
    | BEGIN sql_clauses? RETURN ret=expression? ';'? END
    | EXTERNAL NAME full_table_name
    ;

procedure_param
    : name=LOCAL_ID (id '.')? AS? data_type VARYING? ('=' default_val=default_value)? arg_mode=(OUT | OUTPUT | READONLY)?
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
    : STATISTICS id ON table_name_with_hint '(' column_name_list ')'
      (WITH (FULLSCAN | SAMPLE DECIMAL (PERCENT | ROWS) | STATS_STREAM)
            (',' NORECOMPUTE)? (',' INCREMENTAL EQUAL on_off)? )?
    ;

update_statistics
    : UPDATE (INDEX | ALL)? STATISTICS full_table_name id?  (USING DECIMAL VALUES)?
    ;

// https://msdn.microsoft.com/en-us/library/ms174979.aspx
create_table
    : TABLE table_name '(' column_def_table_constraints ','? ')'
    (ON tablespace=id_or_default ('(' partition_col_name=id ')')?)?
    (TEXTIMAGE_ON textimage=id_or_default)?
    (FILESTREAM_ON filestream=id_or_default)?
    table_options*
    ;

id_or_default
    : id
    | DEFAULT
    ;

table_options
    : WITH ('(' index_option (',' index_option)* ')' | index_option (',' index_option)*)
    ;

// https://msdn.microsoft.com/en-us/library/ms187956.aspx
create_or_alter_view
    : (OR ALTER)? VIEW simple_name ('(' column_name_list ')')?
      (WITH view_attribute (',' view_attribute)*)?
      AS select_statement with_check_option?
    ;

with_check_option
    : WITH CHECK OPTION
    ;

view_attribute
    : ENCRYPTION | SCHEMABINDING | VIEW_METADATA
    ;

// https://msdn.microsoft.com/en-us/library/ms190273.aspx
alter_table
    : TABLE name=table_name (SET '(' LOCK_ESCALATION '=' (AUTO | TABLE | DISABLE) ')'
                             | (WITH (CHECK | nocheck_add=NOCHECK))? ADD column_def_table_constraint
                             | ALTER COLUMN column_definition
                             | DROP COLUMN id
                             | DROP CONSTRAINT constraint=id
                             | (WITH (CHECK | nocheck_check=NOCHECK))? (CHECK | nocheck=NOCHECK) CONSTRAINT con=id
                             | (ENABLE | DISABLE) TRIGGER trigger=id?
                             | (ENABLE | DISABLE) CHANGE_TRACKING (WITH '(' TRACK_COLUMNS_UPDATED '=' (ON|OFF) ')')?
                             | REBUILD table_options)

    ;

// https://msdn.microsoft.com/en-us/library/ms174269.aspx
alter_database
    : DATABASE (database=id | CURRENT)
      (MODIFY NAME '=' new_name=id | COLLATE collation=id | SET database_optionspec (WITH termination)? )
    ;

// https://msdn.microsoft.com/en-us/library/bb522682.aspx
// Runtime check.
database_optionspec
    :  auto_option
      | change_tracking_option
      | containment_option
      | cursor_option
      | database_mirroring_option
      | date_correlation_optimization_option
      | db_encryption_option
      | db_state_option
      | db_update_option
      | db_user_access_option
      | delayed_durability_option
      | external_access_option
      | FILESTREAM database_filestream_option
      | hadr_options
      | mixed_page_allocation_option
      | parameterization_option
//      | query_store_options
      | recovery_option
//      | remote_data_archive_option
      | service_broker_option
      | snapshot_option
      | sql_option
      | target_recovery_time_option
      | termination
    ;

auto_option:
     AUTO_CLOSE on_off
      | AUTO_CREATE_STATISTICS  OFF | ON ( INCREMENTAL EQUAL  ON | OFF  )
      | AUTO_SHRINK  on_off
      | AUTO_UPDATE_STATISTICS on_off
      | AUTO_UPDATE_STATISTICS_ASYNC  (ON | OFF )
    ;

change_tracking_option:
    CHANGE_TRACKING  EQUAL ( OFF | ON (change_tracking_option_list (',' change_tracking_option_list)*)*  )
    ;

change_tracking_option_list:
     AUTO_CLEANUP EQUAL on_off
     | CHANGE_RETENTION EQUAL ( DAYS | HOURS | MINUTES )
    ;

containment_option:
     CONTAINMENT EQUAL ( NONE | PARTIAL )
    ;

cursor_option:
    CURSOR_CLOSE_ON_COMMIT on_off
    | CURSOR_DEFAULT ( LOCAL | GLOBAL )
  ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/alter-endpoint-transact-sql
alter_endpoint
   : ENDPOINT endpointname=id (AUTHORIZATION login=id)?
       ( STATE EQUAL ( state=STARTED | state=STOPPED | state=DISABLED ) )?
            AS TCP LR_BRACKET
               LISTENER_PORT EQUAL port=DECIMAL
                 ( COMMA LISTENER_IP EQUAL
                   (ALL | IPV4_ADDR | IPV6_ADDR) )?
                RR_BRACKET
               (TSQL
               |
                FOR SERVICE_BROKER LR_BRACKET
                   AUTHENTICATION EQUAL
                           ( WINDOWS ( NTLM |KERBEROS | NEGOTIATE )?  (CERTIFICATE cert_name=id)?
                           | CERTIFICATE cert_name=id  WINDOWS? ( NTLM |KERBEROS | NEGOTIATE )?
                           )
                   ( COMMA? ENCRYPTION EQUAL ( DISABLED |SUPPORTED | REQUIRED )
                      ( ALGORITHM ( AES | RC4 | AES RC4 | RC4 AES ) )?
                   )?

                   ( COMMA? MESSAGE_FORWARDING EQUAL ( ENABLED | DISABLED ) )?
                   ( COMMA? MESSAGE_FORWARD_SIZE EQUAL DECIMAL)?
                   RR_BRACKET
              |
               FOR DATABASE_MIRRORING LR_BRACKET
                   AUTHENTICATION EQUAL
                           ( WINDOWS ( NTLM |KERBEROS | NEGOTIATE )?  (CERTIFICATE cert_name=id)?
                           | CERTIFICATE cert_name=id  WINDOWS? ( NTLM |KERBEROS | NEGOTIATE )?
                           )

                   ( COMMA? ENCRYPTION EQUAL ( DISABLED |SUPPORTED | REQUIRED )
                      ( ALGORITHM ( AES | RC4 | AES RC4 | RC4 AES ) )?
                   )?

                   COMMA? ROLE EQUAL ( WITNESS | PARTNER | ALL )
                   RR_BRACKET
             )
   ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/create-endpoint-transact-sql
// todo: not implemented

/* Will visit later
*/
database_mirroring_option
   : PARTNER  partner_option
   | WITNESS  witness_option
   ;

partner_option
   : EQUAL partner_server
   | FAILOVER
   | FORCE_SERVICE_ALLOW_DATA_LOSS
   | OFF
   | RESUME
   | SAFETY (FULL | OFF )
   | SUSPEND
   | TIMEOUT DECIMAL
;

witness_option
   : EQUAL partner_server
   | OFF
;

partner_server
   : partner_server_tcp_prefix host COLON port=DECIMAL
   ;

partner_server_tcp_prefix
   : TCP COLON DOUBLE_FORWARD_SLASH
   ;

host
   : id DOT host
   | (id DOT |id)
   ;

date_correlation_optimization_option:
    DATE_CORRELATION_OPTIMIZATION on_off
    ;

db_encryption_option:
     ENCRYPTION on_off
    ;
db_state_option:
     ( ONLINE | OFFLINE | EMERGENCY )
    ;

db_update_option:
    READ_ONLY | READ_WRITE
    ;

db_user_access_option:
    ( SINGLE_USER | RESTRICTED_USER | MULTI_USER )
    ;
delayed_durability_option:
     DELAYED_DURABILITY EQUAL ( DISABLED | ALLOWED | FORCED )
    ;

external_access_option:
   DB_CHAINING on_off
  | TRUSTWORTHY on_off
  | DEFAULT_LANGUAGE EQUAL ( id | STRING )
  | DEFAULT_FULLTEXT_LANGUAGE EQUAL ( id | STRING )
  | NESTED_TRIGGERS EQUAL ( OFF | ON )
  | TRANSFORM_NOISE_WORDS EQUAL ( OFF | ON )
  | TWO_DIGIT_YEAR_CUTOFF EQUAL DECIMAL
  ;

hadr_options
   : HADR
      ( ( AVAILABILITY GROUP EQUAL availability_group_name=id | OFF ) |(SUSPEND|RESUME) )
    ;

mixed_page_allocation_option:
     MIXED_PAGE_ALLOCATION ( OFF | ON )
    ;

parameterization_option:
     PARAMETERIZATION ( SIMPLE | FORCED )
    ;

recovery_option:
     RECOVERY ( FULL | BULK_LOGGED | SIMPLE )
     | TORN_PAGE_DETECTION on_off
     | PAGE_VERIFY ( CHECKSUM | TORN_PAGE_DETECTION | NONE )
    ;

service_broker_option:
    ENABLE_BROKER
    | DISABLE_BROKER
    | NEW_BROKER
    | ERROR_BROKER_CONVERSATIONS
    | HONOR_BROKER_PRIORITY on_off
  ;
snapshot_option:
   ALLOW_SNAPSHOT_ISOLATION on_off
  | READ_COMMITTED_SNAPSHOT (ON | OFF )
  | MEMORY_OPTIMIZED_ELEVATE_TO_SNAPSHOT = (ON | OFF )
  ;

sql_option:
  ANSI_NULL_DEFAULT on_off
  | ANSI_NULLS on_off
  | ANSI_PADDING on_off
  | ANSI_WARNINGS on_off
  | ARITHABORT on_off
  | COMPATIBILITY_LEVEL EQUAL DECIMAL
  | CONCAT_NULL_YIELDS_NULL on_off
  | NUMERIC_ROUNDABORT on_off
  | QUOTED_IDENTIFIER on_off
  | RECURSIVE_TRIGGERS on_off
  ;

target_recovery_time_option:
     TARGET_RECOVERY_TIME EQUAL DECIMAL ( SECONDS | MINUTES )
    ;

termination:
    ROLLBACK AFTER seconds = DECIMAL
    | ROLLBACK IMMEDIATE
    | NO_WAIT
    ;

// https://msdn.microsoft.com/en-us/library/ms176118.aspx
drop_index
    : INDEX (IF EXISTS)?
    ( drop_relational_or_xml_or_spatial_index (',' drop_relational_or_xml_or_spatial_index)*
    | drop_backward_compatible_index (',' drop_backward_compatible_index)*
    )
    ;

drop_relational_or_xml_or_spatial_index
    : index_name=id ON full_table_name
    ;

drop_backward_compatible_index
    : (owner_name=id '.')? table_or_view_name=id '.' index_name=id
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/drop-trigger-transact-sql
drop_ddl_trigger
    : TRIGGER (IF EXISTS)? simple_name (',' simple_name)*
    ON (DATABASE | ALL SERVER)
    ;

create_type
    : TYPE name = simple_name
      (FROM data_type default_value)?
      (EXTERNAL NAME assembly_name=simple_name)?
      (AS TABLE LR_BRACKET column_def_table_constraints RR_BRACKET)?
    ;

rowset_function_limited
    : openquery
    | opendatasource
    ;

// https://msdn.microsoft.com/en-us/library/ms188427(v=sql.120).aspx
openquery
    : OPENQUERY '(' linked_server=id ',' query=STRING ')'
    ;

// https://msdn.microsoft.com/en-us/library/ms179856.aspx
opendatasource
    : OPENDATASOURCE '(' provider=STRING ',' init=STRING ')'
     '.' (database=id)? '.' (scheme=id)? '.' (table=id)
    ;

// Other statements.

// https://msdn.microsoft.com/en-us/library/ms188927.aspx
declare_statement
    : DECLARE LOCAL_ID AS? table_type_definition
    | DECLARE declare_local (',' declare_local)*
    | DECLARE LOCAL_ID AS? xml_type_definition
    | WITH XMLNAMESPACES '(' xml_namespace_uri=STRING ','? AS id ')'
    ;

// https://msdn.microsoft.com/en-us/library/ms181441(v=sql.120).aspx
cursor_statement
    // https://msdn.microsoft.com/en-us/library/ms175035(v=sql.120).aspx
    : (CLOSE | OPEN | DEALLOCATE) GLOBAL? cursor_name
    // https://msdn.microsoft.com/en-us/library/ms180169(v=sql.120).aspx
    | declare_cursor
    // https://msdn.microsoft.com/en-us/library/ms180152(v=sql.120).aspx
    | fetch_cursor
    ;
// https://docs.microsoft.com/en-us/sql/t-sql/statements/backup-transact-sql
backup_database
    : BACKUP DATABASE ( database_name=id )
          (READ_WRITE_FILEGROUPS (COMMA? (FILE|FILEGROUP) EQUAL file_or_filegroup=STRING)* )?
          (COMMA? (FILE|FILEGROUP) EQUAL file_or_filegroup=STRING)*
           ( TO ( COMMA? logical_device_name=id)+
           | TO ( COMMA? (DISK|TAPE|URL) EQUAL (STRING|id) )+
           )

           ( (MIRROR TO ( COMMA? logical_device_name=id)+ )+
           | ( MIRROR TO ( COMMA? (DISK|TAPE|URL) EQUAL (STRING|id) )+ )+
           )?

             (WITH ( COMMA? DIFFERENTIAL
                   | COMMA? COPY_ONLY
                   | COMMA? (COMPRESSION|NO_COMPRESSION)
                   | COMMA? DESCRIPTION EQUAL (STRING|id)
                   | COMMA? NAME EQUAL backup_set_name=id
                   | COMMA? CREDENTIAL
                   | COMMA? FILE_SNAPSHOT
                   | COMMA? (EXPIREDATE EQUAL (STRING|id) | RETAINDAYS EQUAL (DECIMAL|id) )
                   | COMMA? (NOINIT|INIT)
                   | COMMA? (NOSKIP|SKIP_KEYWORD)
                   | COMMA? (NOFORMAT|FORMAT)
                   | COMMA? MEDIADESCRIPTION EQUAL (STRING|id)
                   | COMMA? MEDIANAME EQUAL (medianame=STRING)
                   | COMMA? BLOCKSIZE EQUAL (DECIMAL|id)
                   | COMMA? BUFFERCOUNT EQUAL (DECIMAL|id)
                   | COMMA? MAXTRANSFER EQUAL (DECIMAL|id)
                   | COMMA? (NO_CHECKSUM|CHECKSUM)
                   | COMMA? (STOP_ON_ERROR|CONTINUE_AFTER_ERROR)
                   | COMMA? RESTART
                   | COMMA? STATS (EQUAL stats_percent=DECIMAL)?
                   | COMMA? (REWIND|NOREWIND)
                   | COMMA? (LOAD|NOUNLOAD)
                   | COMMA? ENCRYPTION LR_BRACKET
                                         ALGORITHM EQUAL
                                         (AES_128
                                         | AES_192
                                         | AES_256
                                         | TRIPLE_DES_3KEY
                                         )
                                         COMMA
                                         SERVER CERTIFICATE EQUAL
                                           (encryptor_name=id
                                           | SERVER ASYMMETRIC KEY EQUAL encryptor_name=id
                                           )
                  )*
              )?

    ;

backup_log
    : BACKUP LOG ( database_name=id )
           ( TO ( COMMA? logical_device_name=id)+
           | TO ( COMMA? (DISK|TAPE|URL) EQUAL (STRING|id) )+
           )

           ( (MIRROR TO ( COMMA? logical_device_name=id)+ )+
           | ( MIRROR TO ( COMMA? (DISK|TAPE|URL) EQUAL (STRING|id) )+ )+
           )?

             (WITH ( COMMA? DIFFERENTIAL
                   | COMMA? COPY_ONLY
                   | COMMA? (COMPRESSION|NO_COMPRESSION)
                   | COMMA? DESCRIPTION EQUAL (STRING|id)
                   | COMMA? NAME EQUAL backup_set_name=id
                   | COMMA? CREDENTIAL
                   | COMMA? FILE_SNAPSHOT
                   | COMMA? (EXPIREDATE EQUAL (STRING|id) | RETAINDAYS EQUAL (DECIMAL|id) )
                   | COMMA? (NOINIT|INIT)
                   | COMMA? (NOSKIP|SKIP_KEYWORD)
                   | COMMA? (NOFORMAT|FORMAT)
                   | COMMA? MEDIADESCRIPTION EQUAL (STRING|id)
                   | COMMA? MEDIANAME EQUAL (medianame=STRING)
                   | COMMA? BLOCKSIZE EQUAL (DECIMAL|id)
                   | COMMA? BUFFERCOUNT EQUAL (DECIMAL|id)
                   | COMMA? MAXTRANSFER EQUAL (DECIMAL|id)
                   | COMMA? (NO_CHECKSUM|CHECKSUM)
                   | COMMA? (STOP_ON_ERROR|CONTINUE_AFTER_ERROR)
                   | COMMA? RESTART
                   | COMMA? STATS (EQUAL stats_percent=DECIMAL)?
                   | COMMA? (REWIND|NOREWIND)
                   | COMMA? (LOAD|NOUNLOAD)
                   | COMMA? (NORECOVERY| STANDBY EQUAL undo_file_name=STRING)
                   | COMMA? NO_TRUNCATE
                   | COMMA? ENCRYPTION LR_BRACKET
                                         ALGORITHM EQUAL
                                         (AES_128
                                         | AES_192
                                         | AES_256
                                         | TRIPLE_DES_3KEY
                                         )
                                         COMMA
                                         SERVER CERTIFICATE EQUAL
                                           (encryptor_name=id
                                           | SERVER ASYMMETRIC KEY EQUAL encryptor_name=id
                                           )
                  )*
              )?

    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/backup-certificate-transact-sql
backup_certificate
    : BACKUP CERTIFICATE certname=id TO FILE EQUAL cert_file=STRING
       ( WITH PRIVATE KEY
           LR_BRACKET
             (COMMA? FILE EQUAL private_key_file=STRING
             |COMMA? ENCRYPTION BY PASSWORD EQUAL encryption_password=STRING
             |COMMA? DECRYPTION BY PASSWORD EQUAL decryption_pasword=STRING
             )+
           RR_BRACKET
       )?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/backup-master-key-transact-sql
backup_master_key
    : BACKUP MASTER KEY TO FILE EQUAL master_key_backup_file=STRING
         ENCRYPTION BY PASSWORD EQUAL encryption_password=STRING
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/statements/backup-service-master-key-transact-sql
backup_service_master_key
    : BACKUP SERVICE MASTER KEY TO FILE EQUAL service_master_key_backup_file=STRING
         ENCRYPTION BY PASSWORD EQUAL encryption_password=STRING
    ;


// https://msdn.microsoft.com/en-us/library/ms188332.aspx
execute_statement
    : EXECUTE execute_body
    ;

execute_body
    : expression (execute_statement_arg (',' execute_statement_arg)*)? (AS? (LOGIN | USER) '=' STRING)?
    ;

execute_statement_arg
    : (parameter=LOCAL_ID '=')? ((constant_LOCAL_ID | id) (OUTPUT | OUT)? | DEFAULT | NULL)
    ;

// https://msdn.microsoft.com/en-us/library/ff848791.aspx
security_statement
    // https://msdn.microsoft.com/en-us/library/ms188354.aspx
    : execute_clause
    // https://msdn.microsoft.com/en-us/library/ms187965.aspx
    | rule_common
    // https://msdn.microsoft.com/en-us/library/ms178632.aspx
    | REVERT ('(' WITH COOKIE '=' LOCAL_ID ')')?
    | open_key
    | close_key
    ;
    
rule_common
    : (GRANT | DENY | REVOKE (GRANT OPTION FOR)?)
    (permissions | columns_permissions)
    object_type?  
    (TO | FROM) role_names (WITH GRANT OPTION | CASCADE)? 
    (AS as_principal=id)?
    ;
        
permissions
    : permission (COMMA permission)*
    ; 
    
columns_permissions
    : table_column_privileges (COMMA table_column_privileges)*
    ;

table_column_privileges
    : permission table_columns
    ;

table_columns
    : '(' column+=id (COMMA column+=id)* ')'
    ;
    
permission
    : ALL PRIVILEGES? 
    | EXECUTE
    | VIEW id // DEFINITION
    | TAKE id // OWNERSHIP
    | CONTROL id? // SERVER
    | CREATE (TABLE | VIEW)
    | SHOWPLAN
    | IMPERSONATE
    | SELECT
    | DELETE
    | UPDATE
    | REFERENCES
    | INSERT
    | CONNECT
    | ALTER (ANY? (id | DATABASE))?
    ;
    
object_type
    : ON (type=(LOGIN | DATABASE | OBJECT | ROLE | SCHEMA | USER | ASSEMBLY) ':' ':')? 
    on_id=table_name table_columns?
    ; 
    
role_names
    : (to_principal+=id) (',' to_principal+=id)*
    ;

create_certificate
    : CERTIFICATE certificate_name=id (AUTHORIZATION user_name=id)?
      (FROM existing_keys | generate_new_keys)
      (ACTIVE FOR BEGIN DIALOG '=' (ON | OFF))?
    ;

existing_keys
    : ASSEMBLY assembly_name=id
    | EXECUTABLE? FILE EQUAL path_to_file=STRING (WITH PRIVATE KEY '(' private_key_options ')')?
    ;

private_key_options
    : (FILE | BINARY) '=' path=STRING (',' (DECRYPTION | ENCRYPTION) BY PASSWORD '=' password=STRING)?
    ;

generate_new_keys
    : (ENCRYPTION BY PASSWORD '=' password=STRING)?
      WITH SUBJECT EQUAL certificate_subject_name=STRING (',' date_options)*
    ;

date_options
    : (START_DATE | EXPIRY_DATE) EQUAL STRING
    ;

open_key
    : OPEN SYMMETRIC KEY key_name=id DECRYPTION BY decryption_mechanism
    | OPEN MASTER KEY DECRYPTION BY PASSWORD '=' password=STRING
    ;

close_key
    : CLOSE SYMMETRIC KEY key_name=id
    | CLOSE ALL SYMMETRIC KEYS
    | CLOSE MASTER KEY
    ;

create_key
    : MASTER KEY ENCRYPTION BY PASSWORD '=' password=STRING
    | SYMMETRIC KEY key_name=id
      (AUTHORIZATION user_name=id)?
      (FROM PROVIDER provider_name=id)?
      WITH ((key_options | ENCRYPTION BY encryption_mechanism)','?)+
    ;

key_options
    : KEY_SOURCE EQUAL pass_phrase=STRING
    | ALGORITHM EQUAL algorithm
    | IDENTITY_VALUE EQUAL identity_phrase=STRING
    | PROVIDER_KEY_NAME EQUAL key_name_in_provider=STRING
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

encryption_mechanism
    : CERTIFICATE certificate_name=id
    | ASYMMETRIC KEY asym_key_name=id
    | SYMMETRIC KEY decrypting_Key_name=id
    | PASSWORD '=' STRING
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
    : SET LOCAL_ID ('.' member_name=id)? '=' expression
    | SET LOCAL_ID assignment_operator expression
    | SET LOCAL_ID '='
      CURSOR declare_set_cursor_common (FOR (READ ONLY | UPDATE (OF column_name_list)?))?
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
    | COMMIT (TRAN | TRANSACTION) ((id | LOCAL_ID) (WITH '(' DELAYED_DURABILITY EQUAL (OFF | ON) ')')?)?
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
    : DBCC name=simple_id ('(' expression_list ')')? (WITH dbcc_options)?
    ;

dbcc_options
    :  simple_id (',' simple_id)?
    ;

execute_clause
    : EXECUTE AS clause=(CALLER | SELF | OWNER | STRING)
    ;

declare_local
    : LOCAL_ID AS? data_type ('=' expression)?
    ;

table_type_definition
    : TABLE '(' column_def_table_constraints ')'
    ;

xml_type_definition
    : XML '(' ( CONTENT | DOCUMENT )? xml_schema_collection ')'
    ;

xml_schema_collection
    : ID '.' ID
    ;

column_def_table_constraints
    : column_def_table_constraint (','? column_def_table_constraint)*
    ;

column_def_table_constraint
    : id (data_type | AS expression) column_option* (MATERIALIZED | NOT MATERIALIZED)?
    | table_constraint
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
    ;

identity_value
    : ('(' seed=DECIMAL ',' increment=DECIMAL ')')
    ;

column_constraint_body
    : (PRIMARY KEY | UNIQUE) clustered? index_options?
    | CHECK not_for_replication? '(' search_condition ')'
    | (FOREIGN KEY)? REFERENCES table_name '(' pk = column_name_list')' on_delete? on_update? not_for_replication?
    ;

// https://msdn.microsoft.com/en-us/library/ms188066.aspx
table_constraint
    : (CONSTRAINT constraint=id)? table_constraint_body
    ;

table_constraint_body
    : (PRIMARY KEY | UNIQUE) clustered? '(' column_name_list_with_order ')' index_options? (ON id)?
    | CHECK not_for_replication? '(' search_condition ')'
    | DEFAULT expression FOR id
    | FOREIGN KEY '(' fk = column_name_list ')' REFERENCES table_name ('(' pk = column_name_list')')? on_delete? on_update? not_for_replication?
    ;

on_delete
    : ON DELETE (NO ACTION | CASCADE | SET NULL | SET DEFAULT)
    ;

on_update
    : ON UPDATE (NO ACTION | CASCADE | SET NULL | SET DEFAULT)
    ;

index_options
    : WITH '(' index_option (',' index_option)* ')'
    ;

// https://msdn.microsoft.com/en-us/library/ms186869.aspx
// Id runtime checking. Id in (PAD_INDEX, FILLFACTOR, IGNORE_DUP_KEY, STATISTICS_NORECOMPUTE, ALLOW_ROW_LOCKS,
// ALLOW_PAGE_LOCKS, SORT_IN_TEMPDB, ONLINE, MAXDOP, DATA_COMPRESSION, ONLINE).
index_option
    : key=simple_id '=' index_option_value
    ;

index_option_value
    : simple_id
    | on_off
    | DECIMAL
    ;

// https://msdn.microsoft.com/en-us/library/ms180169.aspx
declare_cursor
    : DECLARE cursor_name (SEMI_SENSITIVE | INSENSITIVE)? SCROLL? CURSOR declare_set_cursor_common_partial*
    FOR select_statement (FOR (READ ONLY | UPDATE) (OF column_name_list)?)?
    ;

declare_set_cursor_common
    : declare_set_cursor_common_partial*
      FOR select_statement
    ;

declare_set_cursor_common_partial
    : (LOCAL | GLOBAL)
    | (FORWARD_ONLY | SCROLL)
    | (STATIC | KEYSET | DYNAMIC | FAST_FORWARD)
    | (READ_ONLY | SCROLL_LOCKS | OPTIMISTIC)
    | TYPE_WARNING
    ;

fetch_cursor
    : FETCH ((NEXT | PRIOR | FIRST | LAST | (ABSOLUTE | RELATIVE) expression)? FROM)?
      GLOBAL? cursor_name (INTO LOCAL_ID (',' LOCAL_ID)*)?
    ;

// https://msdn.microsoft.com/en-us/library/ms190356.aspx
// Runtime check.
set_special
    : SET name=id (id | constant_LOCAL_ID | ON | OFF)
    // https://msdn.microsoft.com/en-us/library/ms173763.aspx
    | SET TRANSACTION ISOLATION LEVEL
      (READ UNCOMMITTED | READ COMMITTED | REPEATABLE READ | SNAPSHOT | SERIALIZABLE | DECIMAL)
    // https://msdn.microsoft.com/en-us/library/ms188059.aspx
    | SET IDENTITY_INSERT table_name (ON | OFF)
    | SET modify_method
    ;

constant_LOCAL_ID
    : constant
    | LOCAL_ID
    ;

// Expression.

// https://docs.microsoft.com/en-us/sql/t-sql/language-elements/expressions-transact-sql
// Operator precendence: https://docs.microsoft.com/en-us/sql/t-sql/language-elements/operator-precedence-transact-sql
expression
    : '(' expression ')'
    | ('+' | '-' | '~') expression
    | expression op=('*' | '/' | '%') expression
    | expression op=('+' | '-' | '&' | '^' | '|' | '||') expression
    | expression comparison_operator expression
    | expression assignment_operator expression
    | function_call
    | expression COLLATE id
    | object_expression DOT function_call
    | full_column_name ':' ':' function_call
    | id ':' ':' id
    | case_expression
    | full_column_name
    |  over_clause
    | date_expression
    | sequence_call
    | '(' select_stmt_no_parens ')'
    |  primitive_expression
    ;

object_expression
    : object_expression DOT function_call
    | function_call
    | full_column_name ':' ':' function_call
    | id ':' ':' id
    | case_expression
    | over_clause
    | '(' expression ')'
    | '(' select_stmt_no_parens ')'
    ;

sequence_call
    : NEXT VALUE FOR full_table_name
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
    | (REAL | FLOAT)  // float or decimal
    | dollar='$' (DECIMAL | FLOAT)       // money
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
    | '(' constant_expression ')'
    ;

// https://msdn.microsoft.com/en-us/library/ms175972.aspx
with_expression
    : WITH (XMLNAMESPACES ',')? common_table_expression (',' common_table_expression)*
    | WITH BLOCKING_HIERARCHY ('(' full_column_name_list ')')? AS '(' select_statement ')'
    ;

common_table_expression
    : expression_name=id ('(' column_name_list ')')? AS '(' select_statement ')'
    ;

update_elem
    : (full_column_name | LOCAL_ID) ('=' | assignment_operator) expression
    | udt_column_name=id '.' method_name=id '(' expression_list ')'
    //| full_column_name '.' WRITE (expression, )
    ;

// https://msdn.microsoft.com/en-us/library/ms173545.aspx
search_condition_list
    : search_condition (',' search_condition)*
    ;

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
    : EXISTS '(' select_statement ')'
    | expression comparison_operator expression
    | expression comparison_operator (ALL | SOME | ANY) '(' select_statement ')'
    | expression NOT? BETWEEN expression AND expression
    | expression NOT? IN '(' (select_statement | expression_list) ')'
    | expression NOT? LIKE expression (ESCAPE expression)?
    | expression IS null_notnull
    | '(' search_condition ')'
    ;

// https://msdn.microsoft.com/en-us/library/ms176104.aspx
query_specification
    : SELECT (ALL | DISTINCT)? top_clause?
      select_list
      // https://msdn.microsoft.com/en-us/library/ms188029.aspx
      (INTO table_name)?
      (FROM table_sources)?
      (WHERE where=search_condition)?
      // https://msdn.microsoft.com/en-us/library/ms177673.aspx
      (GROUP BY (ALL)? expression (',' expression)*)?
      (HAVING having=search_condition)?
      order_by_clause?
    ;

// https://msdn.microsoft.com/en-us/library/ms189463.aspx
top_clause
    : TOP (top_percent | top_count) (WITH TIES)?
    ;

top_percent
    : (REAL | FLOAT) PERCENT
    | '(' expression ')' PERCENT
    ;

top_count
    : DECIMAL
    | '(' expression ')'
    ;

// https://msdn.microsoft.com/en-us/library/ms188385.aspx
order_by_clause
    : ORDER BY order_by_expression (',' order_by_expression)*
      (OFFSET expression (ROW | ROWS) (FETCH (FIRST | NEXT) expression (ROW | ROWS) ONLY)?)?
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/queries/select-for-clause-transact-sql
for_clause
    : FOR BROWSE
    | FOR XML (RAW ('(' STRING ')')? | AUTO) xml_common_directives*
      (COMMA (XMLDATA | XMLSCHEMA ('(' STRING ')')?))?
      (COMMA ELEMENTS (XSINIL | ABSENT))?
    | FOR XML EXPLICIT xml_common_directives*
      (COMMA XMLDATA)?
    | FOR XML PATH ('(' STRING ')')? xml_common_directives*
      (COMMA ELEMENTS (XSINIL | ABSENT))?
    | FOR JSON (AUTO | PATH)
      (COMMA ROOT ('(' STRING ')')?)?
      (COMMA INCLUDE_NULL_VALUES)?
      (COMMA WITHOUT_ARRAY_WRAPPER)?
    ;

xml_common_directives
    : ',' (BINARY_BASE64 | TYPE | ROOT)
    ;

order_by_expression
    : expression (ASC | DESC)?
    ;

option_clause
    // https://msdn.microsoft.com/en-us/library/ms181714.aspx
    : OPTION '(' option (',' option)* ')'
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
    | OPTIMIZE FOR '(' optimize_for_arg (',' optimize_for_arg)* ')'
    | OPTIMIZE FOR UNKNOWN
    | PARAMETERIZATION (SIMPLE | FORCED)
    | RECOMPILE
    | ROBUST PLAN
    | USE PLAN STRING
    | QUERYTRACEON DECIMAL
    ;

optimize_for_arg
    : LOCAL_ID (UNKNOWN | '=' (constant | NULL))
    ;

// https://msdn.microsoft.com/en-us/library/ms176104.aspx
select_list
    : select_list_elem (',' select_list_elem)*
    ;

select_list_elem
    : (table_name '.')? '*'
    | ('$' IDENTITY | '$' ROWGUID | expression) (AS? column_alias)?
    ;

table_sources
    : table_source (',' table_source)*
    ;

// https://msdn.microsoft.com/en-us/library/ms177634.aspx
table_source
    : table_source_item_joined
    | '(' table_source_item_joined ')'
    ;

table_source_item_joined
    : table_source_item join_part*
    ;

table_source_item
    // column_alias_list is in conflict with deprecated form of
    // with_table_hints which omits WITH
    : full_table_name insert_with_table_hints? as_table_alias?
    | rowset_function             as_table_alias?
    | derived_table              (as_table_alias /*column_alias_list?*/)?
    | change_table                as_table_alias
    | function_call               as_table_alias?
    | LOCAL_ID                    as_table_alias?
    | LOCAL_ID '.' function_call (as_table_alias /*column_alias_list?*/)?
    | open_xml
    | ':' ':' function_call       as_table_alias? // Build-in function (old syntax)
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/functions/openxml-transact-sql
open_xml
    : OPENXML '(' expression ',' expression (',' expression)? ')'
    (WITH '(' schema_declaration ')' )?
    ;

schema_declaration
    : column_declaration (',' column_declaration)*
    ;

column_declaration
    : simple_id data_type (STRING)?
    ;

change_table
    : CHANGETABLE '(' CHANGES table_name ',' (NULL | DECIMAL | LOCAL_ID) ')'
    ;

// https://msdn.microsoft.com/en-us/library/ms191472.aspx
join_part
    // https://msdn.microsoft.com/en-us/library/ms173815(v=sql.120).aspx
    : (INNER? |
       join_type=(LEFT | RIGHT | FULL) OUTER?) (join_hint=(LOOP | HASH | MERGE | REMOTE))?
       JOIN table_source ON search_condition
    | CROSS JOIN table_source_item
    | CROSS APPLY table_source_item
    | OUTER APPLY table_source_item
    | PIVOT pivot_clause as_table_alias
    | UNPIVOT unpivot_clause as_table_alias
    ;

pivot_clause
    : '(' aggregate_windowed_function FOR full_column_name IN column_alias_list ')'
    ;

unpivot_clause
    : '(' expression FOR full_column_name IN '(' full_column_name_list ')' ')'
    ;

full_column_name_list
    : full_column_name (',' full_column_name)*
    ;

table_name_with_hint
    : table_name with_table_hints?
    ;

// https://msdn.microsoft.com/en-us/library/ms190312.aspx
rowset_function
    :  (
        OPENROWSET LR_BRACKET provider_name = STRING COMMA connectionString = STRING COMMA sql = STRING RR_BRACKET
     )
     | ( OPENROWSET '(' BULK data_file=STRING ',' (bulk_option (',' bulk_option)* | id)')' )
    ;

// runtime check.
bulk_option
    : id '=' bulk_option_value=(DECIMAL | STRING)
    ;

derived_table
    : select_statement
    | table_value_constructor
    | '(' table_value_constructor ')'
    ;

function_call
    : ranking_windowed_function                         #RANKING_WINDOWED_FUNC
    | aggregate_windowed_function                       #AGGREGATE_WINDOWED_FUNC
    | analytic_windowed_function                        #ANALYTIC_WINDOWED_FUNC
    | scalar_function_name '(' expression_list? ')'     #SCALAR_FUNCTION
    // https://msdn.microsoft.com/en-us/library/ms173784.aspx
    | BINARY_CHECKSUM '(' '*' ')'                       #BINARY_CHECKSUM
    // https://msdn.microsoft.com/en-us/library/hh231076.aspx
    // https://msdn.microsoft.com/en-us/library/ms187928.aspx
    | CAST '(' expression AS data_type ')'              #CAST
    | CONVERT '(' convert_data_type=data_type ','convert_expression=expression (',' style=expression)? ')'                              #CONVERT
    // https://msdn.microsoft.com/en-us/library/ms189788.aspx
    | CHECKSUM '(' '*' ')'                              #CHECKSUM
    // https://msdn.microsoft.com/en-us/library/ms190349.aspx
    | COALESCE '(' expression_list ')'                  #COALESCE
    // https://msdn.microsoft.com/en-us/library/ms188751.aspx
    | CURRENT_TIMESTAMP                                 #CURRENT_TIMESTAMP
    // https://msdn.microsoft.com/en-us/library/ms176050.aspx
    | CURRENT_USER                                      #CURRENT_USER
    // https://msdn.microsoft.com/en-us/library/ms189838.aspx
    | IDENTITY '(' data_type (',' seed=DECIMAL)? (',' increment=DECIMAL)? ')'                                                           #IDENTITY
    // https://msdn.microsoft.com/en-us/library/bb839514.aspx
    | MIN_ACTIVE_ROWVERSION                             #MIN_ACTIVE_ROWVERSION
    // https://msdn.microsoft.com/en-us/library/ms177562.aspx
    | NULLIF '(' expression ',' expression ')'          #NULLIF
    // https://msdn.microsoft.com/en-us/library/ms177587.aspx
    | SESSION_USER                                      #SESSION_USER
    // https://msdn.microsoft.com/en-us/library/ms179930.aspx
    | SYSTEM_USER                                       #SYSTEM_USER
    | USER                                              #USER
    // https://msdn.microsoft.com/en-us/library/ms184325.aspx
    | ISNULL '(' expression ',' expression ')'          #ISNULL
    // https://docs.microsoft.com/en-us/sql/t-sql/xml/xml-data-type-methods
    | xml_data_type_methods                             #XML_DATA_TYPE_FUNC
    ;

xml_data_type_methods
    : value_method
    | query_method
    | exist_method
    | modify_method
    | nodes_method
    ;

value_method
    : (LOCAL_ID | ID | EVENTDATA | query_method) '.' VALUE '(' xquery=STRING ',' sqltype=STRING ')'
    | (LOCAL_ID | ID | EVENTDATA | query_method) '.' ROW '.' VALUE '(' xquery=STRING ',' sqltype=STRING ')'
    | (LOCAL_ID | ID | EVENTDATA | query_method) '.' PARAM_NODE '.' VALUE '(' xquery=STRING ',' sqltype=STRING ')'
    ;

query_method
    : (LOCAL_ID | ID | full_table_name) '.' QUERY '(' xquery=STRING ')'
    | (LOCAL_ID | ID | full_table_name) '.' ROW '.' QUERY '(' xquery=STRING ')'
    ;

exist_method
    : (LOCAL_ID | ID) '.' EXIST '(' xquery=STRING ')'
    ;

modify_method
    : (LOCAL_ID | ID) '.' MODIFY '(' xml_dml=STRING ')'
    ;

nodes_method
    : (LOCAL_ID | ID) '.' NODES '(' xquery=STRING ')'
    ;


switch_section
    : WHEN expression THEN expression
    ;

switch_search_condition_section
    : WHEN search_condition THEN expression
    ;

as_table_alias
    : AS? id with_table_hints?
    ;

// https://msdn.microsoft.com/en-us/library/ms187373.aspx
with_table_hints
    : WITH? '(' table_hint (','? table_hint)* ')'
    ;

// https://msdn.microsoft.com/en-us/library/ms187373.aspx
insert_with_table_hints
    : WITH '(' table_hint (','? table_hint)* ')'
    ;

// Id runtime check. Id can be (FORCESCAN, HOLDLOCK, NOLOCK, NOWAIT, PAGLOCK, READCOMMITTED,
// READCOMMITTEDLOCK, READPAST, READUNCOMMITTED, REPEATABLEREAD, ROWLOCK, TABLOCK, TABLOCKX
// UPDLOCK, XLOCK)
table_hint
    : NOEXPAND? ( INDEX ('(' index_value (',' index_value)* ')' | index_value (',' index_value)*)
                | INDEX '=' index_value
                | FORCESEEK ('(' index_value '(' ID  (',' ID)* ')' ')')?
                | SERIALIZABLE
                | SNAPSHOT
                | SPATIAL_WINDOW_MAX_CELLS '=' DECIMAL
                | ID)
    ;

index_value
    : id | DECIMAL
    ;

column_alias_list
    : '(' column_alias (',' column_alias)* ')'
    ;

column_alias
    : id
    | STRING
    ;

table_value_constructor
    : VALUES '(' expression_list ')' (',' '(' expression_list ')')*
    ;

expression_list
    : expression (',' expression)*
    ;

// https://msdn.microsoft.com/en-us/library/ms189798.aspx
ranking_windowed_function
    : (RANK | DENSE_RANK | ROW_NUMBER) '(' ')' over_clause
    | NTILE '(' expression ')' over_clause
    ;

// https://msdn.microsoft.com/en-us/library/ms173454.aspx
aggregate_windowed_function
    : (AVG | MAX | MIN | SUM | STDEV | STDEVP | VAR | VARP)
      '(' all_distinct_expression ')' over_clause?
    | (COUNT | COUNT_BIG)
      '(' ('*' | all_distinct_expression) ')' over_clause?
    | CHECKSUM_AGG '(' all_distinct_expression ')'
    | GROUPING '(' expression ')'
    | GROUPING_ID '(' expression_list ')'
    ;

// https://docs.microsoft.com/en-us/sql/t-sql/functions/analytic-functions-transact-sql
analytic_windowed_function
    : (FIRST_VALUE | LAST_VALUE) '(' expression ')' over_clause
    | (LAG | LEAD) '(' expression  (',' expression (',' expression)? )? ')' over_clause
    ;

all_distinct_expression
    : (ALL | DISTINCT) expression
    ;

// https://msdn.microsoft.com/en-us/library/ms189461.aspx
over_clause
    : OVER '(' (PARTITION BY expression_list)? order_by_clause? row_or_range_clause? ')'
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

create_database_option:
    FILESTREAM ( database_filestream_option (',' database_filestream_option)* )
    | DEFAULT_LANGUAGE EQUAL ( id | STRING )
    | DEFAULT_FULLTEXT_LANGUAGE EQUAL ( id | STRING )
    | NESTED_TRIGGERS EQUAL ( OFF | ON )
    | TRANSFORM_NOISE_WORDS EQUAL ( OFF | ON )
    | TWO_DIGIT_YEAR_CUTOFF EQUAL DECIMAL
    | DB_CHAINING ( OFF | ON )
    | TRUSTWORTHY ( OFF | ON )
    ;

database_filestream_option:
     LR_BRACKET
     (
         ( NON_TRANSACTED_ACCESS EQUAL ( OFF | READ_ONLY | FULL ) )
         |
         ( DIRECTORY_NAME EQUAL STRING )
     )
     RR_BRACKET
    ;

database_file_spec:
    file_group | file_spec;

file_group:
     FILEGROUP id
     ( CONTAINS FILESTREAM )?
     ( DEFAULT )?
     ( CONTAINS MEMORY_OPTIMIZED_DATA )?
     file_spec ( ',' file_spec )*
    ;
file_spec
    : LR_BRACKET
      NAME EQUAL ( id | STRING ) ','?
      FILENAME EQUAL file = STRING ','?
      ( SIZE EQUAL file_size ','? )?
      ( MAXSIZE EQUAL (file_size | UNLIMITED )','? )?
      ( FILEGROWTH EQUAL file_size ','? )?
      RR_BRACKET
    ;

full_table_name
    : (server=id '.' database=id '.'  schema=id   '.'
      |              database=id '.' (schema=id)? '.'
      |                               schema=id   '.')? table=id
    ;

table_name
    : (database=id '.' (schema=id)? '.' | schema=id '.')? table=id
   // | (database=id '.' (schema=id)? '.' | schema=id '.')? BLOCKING_HIERARCHY
    ;

simple_name
    : (schema=id '.')? name=id
    ;

func_proc_name
    : (database=id '.' (schema=id)? '.' | (schema=id) '.')? procedure=id
    | server=id '.' database=id '.' (schema=id)? '.' procedure=id
    ;

ddl_object
    : full_table_name
    | LOCAL_ID
    ;
/*  There are some RESERVED WORDS that can be column names */
full_column_name
    : (table_name '.')? (COMPATIBILITY_LEVEL | QUOTED_IDENTIFIER | ARITHABORT | ANSI_WARNINGS | ANSI_PADDING | ANSI_NULLS | id)
    ;

column_name_list_with_order
    : id (ASC | DESC)? (',' id (ASC | DESC)?)*
    ;

column_name_list
    : id (',' id)*
    ;

cursor_name
    : id
    | LOCAL_ID
    ;

on_off
    : ON
    | OFF
    ;

clustered
    : CLUSTERED
    | NONCLUSTERED
    ;

null_notnull
    : NOT? NULL
    ;

scalar_function_name
    : func_proc_name
    | RIGHT
    | LEFT
    | BINARY_CHECKSUM
    | CHECKSUM
    ;

begin_conversation_timer
    : BEGIN CONVERSATION TIMER '(' LOCAL_ID ')' TIMEOUT '=' time
    ;

begin_conversation_dialog
    : BEGIN DIALOG (CONVERSATION)? dialog_handle=LOCAL_ID
      FROM SERVICE initiator_service_name=service_name
      TO SERVICE target_service_name=service_name (',' service_broker_guid=STRING)?
      ON CONTRACT contract_name
      (WITH
        ((RELATED_CONVERSATION | RELATED_CONVERSATION_GROUP) '=' LOCAL_ID ','?)?
        (LIFETIME '=' (DECIMAL | LOCAL_ID) ','?)?
        (ENCRYPTION '=' (ON | OFF))? )?
    ;

contract_name
    : (id | expression)
    ;

service_name
    : (id | expression)
    ;

end_conversation
    : END CONVERSATION conversation_handle=LOCAL_ID
      (WITH (ERROR '=' faliure_code=(LOCAL_ID | STRING) DESCRIPTION '=' failure_text=(LOCAL_ID | STRING))? CLEANUP? )?
    ;

waitfor_conversation
    : WAITFOR? '(' get_conversation ')' (','? TIMEOUT timeout=time)?
    ;

get_conversation
    :GET CONVERSATION GROUP conversation_group_id=(STRING | LOCAL_ID) FROM queue=queue_id
    ;

queue_id
    : (database_name=id '.' schema_name=id '.' name=id)
    | id
    ;

send_conversation
    : SEND ON CONVERSATION conversation_handle=(STRING | LOCAL_ID)
      MESSAGE TYPE message_type_name=expression
      ('(' message_body_expression=(STRING | LOCAL_ID) ')' )?
    ;

// https://msdn.microsoft.com/en-us/library/ms187752.aspx
// TODO: implement runtime check or add new tokens.
data_type
    : simple_name size=data_type_size?
    | DOUBLE PRECISION
    ;
    
data_type_size
    : ('(' (presicion=DECIMAL | MAX) (',' scale=DECIMAL)? ')')
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
    | sign? dollar='$' (DECIMAL | FLOAT)       // money
    | TRUE // bit
    | FALSE // bit
    | IPV4_ADDR
    ;

signed_numerical_literal
  : sign? (DECIMAL | REAL | FLOAT)
  ;

sign
    : '+'
    | '-'
    ;

// https://msdn.microsoft.com/en-us/library/ms175874.aspx
id
    : simple_id
    | DOUBLE_QUOTE_ID
    | SQUARE_BRACKET_ID
    ;

simple_id
    : ID
    | ABSOLUTE
    | ACCENT_SENSITIVITY
    | ACTION
    | ACTIVATION
    | ACTIVE
    | ADDRESS
    | AES_128
    | AES_192
    | AES_256
    | AFFINITY
    | AFTER
    | AGGREGATE
    | ALGORITHM
    | ALLOW_ENCRYPTED_VALUE_MODIFICATIONS
    | ALLOW_SNAPSHOT_ISOLATION
    | ALLOWED
    | ANSI_NULL_DEFAULT
    | ANSI_NULLS
    | ANSI_PADDING
    | ANSI_WARNINGS
    | APPLICATION_LOG
    | APPLY
    | ARITHABORT
    | ASSEMBLY
    | AUDIT
    | AUDIT_GUID
    | AUTO
    | AUTO_CLEANUP
    | AUTO_CLOSE
    | AUTO_CREATE_STATISTICS
    | AUTO_SHRINK
    | AUTO_UPDATE_STATISTICS
    | AUTO_UPDATE_STATISTICS_ASYNC
    | AVAILABILITY
    | AVG
    | BACKUP_PRIORITY
    | BEGIN_DIALOG
    | BIGINT
    | BINARY_BASE64
    | BINARY_CHECKSUM
    | BINDING
    | BLOB_STORAGE
    | BLOCK
    | BROKER
    | BROKER_INSTANCE
    | BULK_LOGGED
    | CALLED
    | CALLER
    | CAP_CPU_PERCENT
    | CAST
    | CATALOG
    | CATCH
    | CHANGE_RETENTION
    | CHANGE_TRACKING
    | CHECKSUM
    | CHECKSUM_AGG
    | CLEANUP
    | COLLECTION
    | COLUMN_MASTER_KEY
    | COMMITTED
    | COMPATIBILITY_LEVEL
    | CONCAT
    | CONCAT_NULL_YIELDS_NULL
    | CONNECT
    | CONTENT
    | CONTROL
    | COOKIE
    | COUNT
    | COUNT_BIG
    | COUNTER
    | CPU
    | CREATE_NEW
    | CREATION_DISPOSITION
    | CREDENTIAL
    | CRYPTOGRAPHIC
    | CURSOR_CLOSE_ON_COMMIT
    | CURSOR_DEFAULT
    | DATA_COMPRESSION
    | DATE_CORRELATION_OPTIMIZATION
    | DATEADD
    | DATEDIFF
    | DATENAME
    | DATEPART
    | DAYS
    | DB_CHAINING
    | DB_FAILOVER
    | DECRYPTION
    | DEFAULT_DOUBLE_QUOTE
    | DEFAULT_FULLTEXT_LANGUAGE
    | DEFAULT_LANGUAGE
    | DELAY
    | DELAYED_DURABILITY
    | DELETED
    | DENSE_RANK
    | DEPENDENTS
    | DES
    | DESCRIPTION
    | DESX
    | DHCP
    | DIALOG
    | DIRECTORY_NAME
    | DISABLE
    | DISABLE_BROKER
    | DISABLED
    | DISK_DRIVE
    | DOCUMENT
    | DYNAMIC
    | EMERGENCY
    | EMPTY
    | ENABLE
    | ENABLED
    | ENABLE_BROKER
    | ENCRYPTED_VALUE
    | ENCRYPTION
    | ENDPOINT_URL
    | ERROR
    | ERROR_BROKER_CONVERSATIONS
    | EVENTDATA
    | EXCLUSIVE
    | EXECUTABLE
    | EXIST
    | EXPAND
    | EXPIRY_DATE
    | EXPLICIT
    | FAIL_OPERATION
    | FAILOVER_MODE
    | FAILURE
    | FAILURE_CONDITION_LEVEL
    | FAST
    | FAST_FORWARD
    | FILEGROUP
    | FILEGROWTH
    | FILENAME
    | FILEPATH
    | FILESTREAM
    | FILLFACTOR
    | FILTER
    | FIRST
    | FIRST_VALUE
    | FOLLOWING
    | FORCE
    | FORCE_FAILOVER_ALLOW_DATA_LOSS
    | FORCED
    | FORCESEEK
    | FORMAT
    | FORWARD_ONLY
    | FULLSCAN
    | FULLTEXT
    | GB
    | GETDATE
    | GETUTCDATE
    | GLOBAL
    | GROUP_MAX_REQUESTS
    | GROUPING
    | GROUPING_ID
    | HADR
    | HASH
    | HEALTH_CHECK_TIMEOUT
    | HIGH
    | HONOR_BROKER_PRIORITY
    | HOURS
    | IDENTITY
    | IDENTITY_VALUE
    | IGNORE_NONCLUSTERED_COLUMNSTORE_INDEX
    | IMMEDIATE
    | IMPERSONATE
    | IMPORTANCE
    | INCREMENTAL
    | INIT
    | INITIATOR
    | INPUT
    | INSENSITIVE
    | INSERTED
    | INT
    | IP
    | ISOLATION
    | KB
    | KEEP
    | KEEPFIXED
    | KEY
    | KEY_SOURCE
    | KEYS
    | KEYSET
    | LAG
    | LAST
    | LAST_VALUE
    | LEAD
    | LEVEL
    | LIST
    | LISTENER
    | LISTENER_URL
    | LOB_COMPACTION
    | LOCAL
    | LOCATION
    | LOCK
    | LOCK_ESCALATION
    | LOG
    | LOGIN
    | LOOP
    | LOW
    | MANUAL
    | MARK
    | MASTER
    | MATERIALIZED
    | MAX
    | MAX_CPU_PERCENT
    | MAX_DOP
    | MAX_FILES
    | MAX_IOPS_PER_VOLUME
    | MAX_MEMORY
    | MAX_MEMORY_PERCENT
    | MAX_PROCESSES
    | MAX_QUEUE_READERS
    | MAX_ROLLOVER_FILES
    | MAXDOP
    | MAXRECURSION
    | MAXSIZE
    | MB
    | MEDIUM
    | MEMORY_OPTIMIZED_DATA
    | MESSAGE
    | MIN
    | MIN_ACTIVE_ROWVERSION
    | MIN_CPU_PERCENT
    | MIN_IOPS_PER_VOLUME
    | MIN_MEMORY_PERCENT
    | MINUTES
    | MIRROR_ADDRESS
    | MIXED_PAGE_ALLOCATION
    | MODE
    | MODIFY
    | MOVE
    | MULTI_USER
    | NAME
    | NESTED_TRIGGERS
    | NEW_ACCOUNT
    | NEW_BROKER
    | NEW_PASSWORD
    | NEXT
    | NO
    | NO_TRUNCATE
    | NO_WAIT
    | NOCOUNT
    | NODES
    | NOEXPAND
    | NON_TRANSACTED_ACCESS
    | NORECOMPUTE
    | NORECOVERY
    | NOWAIT
    | NTILE
    | NUMANODE
    | NUMBER
    | NUMERIC_ROUNDABORT
    | OBJECT
    | OFFLINE
    | OFFSET
    | OFFSETS
    | OLD_ACCOUNT
    | ONLINE
    | ONLY
    | OPEN_EXISTING
    | OPTIMISTIC
    | OPTIMIZE
    | OUT
    | OUTPUT
    | OWNER
    | PAGE
    | PAGE_VERIFY
    | PARAMETERIZATION
    | PARTITION
    | PARTITIONS
    | PARTNER
    | PASSWORD
    | PATH
    | POISON_MESSAGE_HANDLING
    | POOL
    | PORT
    | PRECEDING
    | PRECISION
    | PRIMARY_ROLE
    | PRIOR
    | PRIORITY
    | PRIORITY_LEVEL
    | PRIVATE
    | PRIVATE_KEY
    | PRIVILEGES
    | PROCEDURE_NAME
    | PROPERTY
    | PROVIDER
    | PROVIDER_KEY_NAME
    | PUBLIC
    | QUERY
    | QUEUE
    | QUEUE_DELAY
    | QUOTED_IDENTIFIER
    | R_LETTER
    | RANGE
    | RANK
    | RAW
    | RC2
    | RC4
    | RC4_128
    | READ_COMMITTED_SNAPSHOT
    | READ_ONLY
    | READ_ONLY_ROUTING_LIST
    | READ_WRITE
    | READONLY
    | REBUILD
    | RECEIVE
    | RECOMPILE
    | RECOVERY
    | RECURSIVE_TRIGGERS
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
    | REQUIRED_SYNCHRONIZED_SECONDARIES_TO_COMMIT
    | RESERVE_DISK_SPACE
    | RESOURCE
    | RESOURCE_MANAGER_LOCATION
    | RESTRICTED_USER
    | RETENTION
    | RETURN
    | RETURNS
    | ROBUST
    | ROOT
    | ROUTE
    | ROW
    | ROW_NUMBER
    | ROWCOUNT
    | ROWGUID
    | ROWS
    | SAFETY
    | SAMPLE
    | SCHEMABINDING
    | SCOPED
    | SCROLL
    | SCROLL_LOCKS
    | SEARCH
    | SECONDARY
    | SECONDARY_ONLY
    | SECONDARY_ROLE
    | SECONDS
    | SECRET
    | SECURITY_LOG
    | SEEDING_MODE
    | SELF
    | SEMI_SENSITIVE
    | SEND
    | SENT
    | SEQUENCE
    | SERVER
    | SESSION_TIMEOUT
    | SETERROR
    | SHARE
    | SHOWPLAN
    | SID
    | SID
    | SIGNATURE
    | SIMPLE
    | SINGLE_USER
    | SIZE
    | SMALLINT
    | SNAPSHOT
    | SOURCE
    | SPATIAL_WINDOW_MAX_CELLS
    | SPLIT
    | STANDBY
    | START
    | START_DATE
    | STATE
    | STATIC
    | STATS_STREAM
    | STATUS
    | STDEV
    | STDEVP
    | STOPLIST
    | STUFF
    | SUBJECT
    | SUM
    | SUSPEND
    | SYMMETRIC
    | SYNCHRONOUS_COMMIT
    | SYNONYM
    | SYSTEM
    | TAKE
    | TARGET
    | TARGET_RECOVERY_TIME
    | TB
    | TEXTIMAGE_ON
    | THROW
    | TIES
    | TIME
    | TIMEOUT
    | TIMER
    | TINYINT
    | TORN_PAGE_DETECTION
    | TRACK_COLUMNS_UPDATED
    | TRANSFORM_NOISE_WORDS
    | TRIPLE_DES
    | TRIPLE_DES_3KEY
    | TRUSTWORTHY
    | TRY
    | TSQL
    | TWO_DIGIT_YEAR_CUTOFF
    | TYPE
    | TYPE_WARNING
    | UNBOUNDED
    | UNCOMMITTED
    | UNKNOWN
    | UNLIMITED
    | USING
    | VALID_XML
    | VALIDATION
    | VALUE
    | VAR
    | VARP
    | VIEW_METADATA
    | VIEWS
    | WAIT
    | WELL_FORMED_XML
    | WORK
    | WORKLOAD
    | XML
    | XMLNAMESPACES
    ;

// https://msdn.microsoft.com/en-us/library/ms188074.aspx
// Spaces are allowed for comparison operators.
comparison_operator
    : '=' | '>' | '<' | '<' '=' | '>' '=' | '<' '>' | '!' '=' | '!' '>' | '!' '<'
    ;

assignment_operator
    : '+=' | '-=' | '*=' | '/=' | '%=' | '&=' | '^=' | '|='
    ;

file_size
    : DECIMAL( KB | MB | GB | TB | '%' )?
    ;