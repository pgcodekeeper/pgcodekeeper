# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

## [Unreleased]

### Added

### Changed

### Fixed

- Fixed parser rule for PostgreSQL.

### Removed

## [10.14.2] - 2025-05-28

### Fixed

- Fixed text of settings.
- Fixed error message during analysis.

## [10.14.1] - 2025-05-27

### Fixed

- Fixed setting `Use Unix-style newline characters`.

## [10.14.0] - 2025-05-27

### Added

- Added the ability to change the state of inherited triggers in partition tables.

### Changed

- Improved code completion functionality.

### Fixed

- Fixed text in `Diff wizard`.
- Fixed reading of column length for char and nchar types in MS SQL database.
- Fixed an error when analyzing a query in PostgreSQL.

## [10.13.0] - 2025-05-13

### Added

- Added rows count limit and logging in `insert` mode.

### Changed

- Removed generation of unnecessary comments when recreating objects in the migration script.

### Fixed

- Fixed a bug in processing rules from the ignore list.

## [10.12.0] - 2025-04-15

### Added

- Added pgCodeKeeper build for Mac OS.
- The ability to use a custom logback.xml configuration file for logging in the CLI version has been added. Additionally, logging of main operations has been added to the log file.

### Fixed

- Fixed a bug with the case of names of objects in MS SQL.
- Fixed the error of incorrect reading of privileges with user names from the database.
- Fixed loading of a scheme from a directory in the diff wizard.

## [10.11.0] - 2025-04-01

### Added

- Added the ability to generate test table data for MS SQL and ClickHouse.

### Changed

- Changed code generation when adding new privileges in PostgreSQL.

## [10.10.0] - 2025-03-18

### Added

- The ability to save a project using ignore lists has been added in the CLI version in `--parse` mode.

### Fixed

- Fixed parser errors for PostgreSQL.

## [10.9.0] - 2025-03-04

### Changed

- A setting to ignore owners and privileges now works for libraries as well.

### Fixed

- Fixed an error when formatting an invalid function.
- Fixed duplication of object names when generating code with data migration to PostgreSQL.
- Fixed a bug in the expression parser in PostgreSQL.

## [10.8.0] - 2025-02-18

### Added

- Added preference for the number of parser threads to optimize CPU resource consumption.

### Fixed

- Fixed parser rule for aggregate functions in PostgreSQL.
- Fixed incomplete deletion of files when creation of a project failed.
- Fixed a bug in generating code with data migration when adding an IDENTITY column.
- Fixed migration script for tables from the Log engine family to ClickHouse.
- Fixed a bug when installing the plugin in Eclipse 2024-12.
- Fixed `Print DROP before CREATE statement` option work.
- Fixed a bug when building MS SQL project with incorrect file names.
- Fixed code generation when changing a function with adding new dependencies.

## [10.7.1] - 2025-02-05

### Fixed

- Fixed object reading order for MS SQL.
- Fixed parser rules for MS SQL.

## [10.7.0] - 2025-02-04

### Added

- Added support for Unicode escape sequences in identifiers and strings for PostgreSQL.
- Added the ability to copy all error messages in standalone pgCodeKeeper packages.

### Fixed

- Fixed a bug in generating a migration script for partitioned tables with indexes.
- Fixed parser rule for partitioned tables in Greenplum.

## [10.6.0] - 2025-01-21

### Added

- Added support for MS SQL 2022.
- Added links to library objects.

### Changed

- The mechanism for generating the migration script has been rewritten, allowing for more fine-grained control over the order of operations. In the process, the order of some operations was corrected.
- Disabled formatting option for read-only files.
- Updated license year.

### Fixed

- Fixed error when loading DOMAIN object with NOT NULL constraint.
- Fixed a bug in generating code for a DOMAIN object with constraints.
- Fixed UI freeze when testing connection with database.
- Fixed code generation for CREATE OR REPLACE PROCEDURE command.

## [10.5.0] - 2024-12-10

### Added

- Added comments before INSERT commands in --insert mode.

### Changed

- Updated library dependencies.

### Fixed

- Fixed error with triggers on partition tables.

## [10.4.0] - 2024-11-27

### Added

- Added support object STATISTICS in MS SQL.
- Added CREDITS.md file.
- Added the ability to sort by library in the diff table of the project editor.

### Changed

- Improved parser rules for MS SQL.
- Items that do not correspond to the current database type have been removed from the object type filter.

### Fixed

- Fixed errors when working with libraries in the project tree.

## [10.3.1] - 2024-11-12

### Fixed

- Fixed a bug when reading from a database in MS SQL.

## [10.3.0] - 2024-11-12

### Added

- Added localization of information messages in the CLI version.

### Changed

- Improved parser rules for MS SQL.

### Fixed

- Fixed code generation when deleting column with a default value in MS SQL.
- Fixed a bug when reading from a database in MS SQL.

## [10.2.0] - 2024-10-29

### Added

- Added support for new options for INDEX in MS SQL.

### Changed

- Improved parser rules for MS SQL.
- Optimized query for reading functions from PostgreSQL.

### Fixed

- Fixed a bug with auto-substitution of the name when creating an SQL object.
- Fixed error text in CLI version.

## [10.1.0] - 2024-10-15

### Added

- Added the ability to create objects from templates for all types of databases.
- Added support for COLUMNSTORE INDEX in MS SQL.
- Added a new mode [--mode verify](https://pgcodekeeper.readthedocs.io/ru/latest/cli_version.html#verifymode) for code verification.

### Changed

- Renamed view `pg Dependencies` to `Dependency graph`.

## [10.0.0] - 2024-10-01

### Added

- Added support for PostgreSQL 17.

### Changed

- Increased minimum JAVA version to 17.
- Standalone pgCodeKeeper packages now use latest version of Eclipse again.

### Fixed

- Fixed error when explicitly specifying default schema in dump.
- Fixed parser rule for Greenplum `CREATE TABLE AS`.
- Fixed a bug when comparing partitions in Greenplum.
- Fixed compatibility bug with Eclipse 2024-09 (4.33.0).

### Removed

- Removed deprecated `--ms-sql` parameter.
- Removed support for old version of project structure (pgCodeKeeper versions < 4.0.0).
- Removed the "Create snapshot of system objects" item from the pgCodeKeeper menu.

## [9.14.0] - 2024-09-04

### Added

- Added toolbar to comparison panel.

### Changed

- Added concatenation of sequential column type change commands for PostgreSQL.
- Reduced size of CLI version.
- Improved text in dependency graph building settings window.

## [9.13.2] - 2024-08-23

### Changed

- Added text display of selected options in the window of ignored objects and schemas.

### Fixed

- Fixed a bug in saving selected options in the ignored objects, schemas window.
- Fixed code generation for `CHANGE_TRACKING` option in MS SQL tables.
- Fixed a bug in the container filtering mechanism.
- Fixed path to save overrides.
- Fixed a bug when reading columns.

## [9.13.1] - 2024-08-21

### Fixed

- Added missing dependencies in types.

## [9.13.0] - 2024-08-20

### Added

- Added the ability to build a dependency graph for an object for GUI version. To build a graph, you need to right-click on an object in the comparison editor and select “Build a dependency graph”.

### Changed

- Changed the arguments for calling modes in the CLI version. Use `--mode DIFF` to compare data sources and get the migration script, `--mode PARSE` instead of the deprecated `--parse` option, `--mode GRAPH` instead of `--graph` and `--mode INSERT` instead of `--insert`.
- Disabled code generation for creating index without locks when using transactions for PostgreSQL.
- Expanded usage of project setting `Use Unix-style newline characters`.
- The clear cache button in global settings additionally deletes cache files for all projects. Also added deletion of the project cache file when deleting a project.

## [9.12.0] - 2024-08-06

### Added

- Added support for UNLOGGED option for GENERATED SEQUENCE in PostgreSQL.
- Added the ability to specify several types of objects in the list of ignored objects.

### Changed

- In the `--insert` mode, added ignoring of columns with the `timestamp` type for MS SQL.
- Updated PostgreSQL JDBC driver version.
- Updated pgpass library version.

### Fixed

- Fixed a bug when using special characters in the password in the CLI.

## [9.11.0] - 2024-07-23

### Changed

- Parameters for filtering objects `--graph-name` and `--insert-name` are no longer case sensitive and do not require quotes, it is now possible to specify a function name without a signature.

### Fixed

- Fixed a error when using `-R` and `--insert` parameters together.

## [9.10.0] - 2024-07-09

### Added

- Added support for STATISTICS object in PostgreSQL.
- Added code formatting feature for SELECT queries in views in ClickHouse.
- Added the [--insert](https://pgcodekeeper.readthedocs.io/en/latest/cli_version.html#insert) parameter to the CLI version to generate a script for inserting records with dependent data.

## [9.9.0] - 2024-06-25

### Added

- Added aliases for some long CLI options.

### Fixed

- Fixed missing reading of some types of objects when working with a ClickHouse project via CLI.

## [9.8.0] - 2024-06-11

### Added

- Added support for DICTIONARY object in ClickHouse.
- Added support for privileges for USER and ROLE objects in ClickHouse.
- Added analysis of SELECT command in ClickHouse.
- Added dangerous statements mechanism support in ClickHouse;

### Fixed

- Fixed errors in code generation in ClickHouse.

## [9.7.0] - 2024-05-28

### Added

- Added support for USER, ROLE objects in ClickHouse.

### Fixed

- Fixed a script generation bug with the DISTRIBUTED option for partitions in GreenPlum 7.
- Fixed missing quotes in POLICY name in ClickHouse.

## [9.6.0] - 2024-05-14

### Added

- Added support for POLICY object in ClickHouse.

### Changed

- Removed unnecessary condition in queries for reading objects.

### Fixed

- Fixed a bug in re-creating dependencies when changing a custom data type in MS SQL.
- Fixed schema reading logic when using the `.pgcodekeeperignoreschema` file.

## [9.5.1] - 2024-04-24

### Fixed

- Fixed behaviour of domain field in DB settings.
- Fixed an error while read ClickHouse DB.

## [9.5.0] - 2024-04-09

### Added

- Added support for ClickHouse as a test phase.

## [9.4.3] - 2024-03-18

### Fixed

- Fixed bug when loading libraries at the same time.
- Fixed an error when trying to open the New Object wizard.

## [9.4.2] - 2024-03-13

### Fixed

- Fixed code generation for partition tables with access method in GreenPlum 7.
- Fixed bug when loading libraries at the same time.

## [9.4.1] - 2024-03-11

### Fixed

- Fixed error when reading tables in GreenPlum 7.

## [9.4.0] - 2024-03-05

### Added

- Added setting to wrap the creation of IDENTITY and CONSTRAINT in DO block with EXCEPTION section (`Window -> Preferences -> pgCodeKeeper -> Database update -> Print creation of CONSTRAINT and IDENTITY in DO block`, CLI option `-do (--generate-exist-do-block)`).

### Changed

- The separate project creation wizard for MS SQL has been replaced by database type selection.
- Improved error text when parsing expressions.

### Fixed

- Fixed an error when parsing some special characters in MS SQL.
- Fixed an error when parsing `$n%TYPE` construction in PostgreSQL.

## [9.3.0] - 2024-02-06

### Added

- Added dependency search when using ::regoper and ::regoperator.

### Fixed

- Fixed code generation for VIEW objects with SCHEMABINDING option in MS SQL.

## [9.2.0] - 2024-01-23

### Changed

- Updated license year.

### Fixed

- Fixed a bug in duplicating an object in the migration script.
- Fixed code generation when changing the order of columns in INDEX and CONSTRAINT objects.
- Fixed missing quotes in FOREIGN KEY.

### Removed

- Removed generation of comments for DATABASE object.

## [9.1.0] - 2024-01-10

### Added

- Added a preference to move comments to the end of the migration script (`Window -> Preferences -> pgCodeKeeper -> Update DB -> Print comments at the end of the script`, CLI option `--comments-to-end`).

### Fixed

- Fixed parser errors for MS SQL.
- Fixed an error when opening non-pgCodeKeeper project files in SQL editor.
- Fixed a bug with defining a dependency in the body of a function in PG.
- Added missing references to COLLATION objects in PostgreSQL.
- Fixed errors with column dependencies in MS SQL.

## [9.0.0] - 2023-12-13

### Added

- Added database name to console when executing migrations.

### Changed

- `--ms-sql` parameter has been replaced by `--db-type` parameter with name of database type. Currently, 2 values are supported: PG (default value) and MS. The `--ms-sql` option is marked as deprecated and will be removed in future versions. All checkboxes for selecting an MS SQL database are replaced with a combobox for selecting DB type.
- The mechanism for working with CONSTRAINT and INDEX objects has been changed: objects are now stored not as a string, but as separate fields, which avoids unnecessary differences in keywords and spaces. To maintain compatibility, the old code generation template is used.
- Updated all library dependencies of the core program. To use [Windows authentication](https://pgcodekeeper.readthedocs.io/en/latest/windowsauth.html#id2) you need to update [DDL](https://github.com/microsoft/mssql-jdbc/releases/tag/v12.4.2).
- Improved parser rules for MS SQL.

### Fixed

- Fixed a bug in the diff wizard.
- Fixed a bug in the CLI version when using a relative path.
- Fixed a bug with adding a template.

## [8.9.0] - 2023-11-07

### Changed

- Improved parser rules.

## [8.8.0] - 2023-09-27

### Added

- Added support for PostgreSQL 16.

### Changed

- Improved parser rules for MS SQL.

### Fixed

- Fixed an error when reading locale for COLLATION objects.
- Fixed a bug in generating the migration script for COLLATION.

## [8.7.0] - 2023-09-12

### Added

- Added support for GOTO syntax in MS SQL.

### Changed

- Improved parser rules for MS SQL.

## [8.6.0] - 2023-08-29

### Changed

- Improved parser's rules.
- Added SEQUENCE and AGGREGATE in New Object wizard.

### Fixed

- Fixed an error when parsing CLUSTER ON for tables and materialized views.

## [8.5.0] - 2023-08-15

### Changed

- Changed core module logging to use slf4j.
- Disabled standalone pgCodeKeeper package for macOS.
- Sorted list of types in object filter.
- Moved generated classes.
- Improved parser rules for MS SQL.

### Fixed

- Fixed an error with reading USER MAPPING from libraries.
- Fixed an error with dependency search.

## [8.4.0] - 2023-08-01

### Added

- Added support for EVENT TRIGGER object.
- Added option for showing code of all child objects when comparing.

### Fixed

- Fixed code generation with option `Print DROP before CREATE statement` when recreating an object.

## [8.3.0] - 2023-07-19

### Added

- Added settings for connecting types.

### Changed

- Optimized queries for getting objects from DB.

### Fixed

- Fixed expression analysis and dependency search for columns.
- Fixed database menu caching.

## [8.2.0] - 2023-07-04

### Added

- Added alphabetical order of child objects of the same type in a file when saving to a project.

### Changed

- Removed unnecessary commands when generating the migration script for functions.

### Fixed

- Fixed version of Eclipse used in pgCodeKeeper builds to maintain compatibility with JAVA 11.
- Fixed code generation when changing TABLE SUBPARTITION TEMPLATE properties in Greenplum.

## [8.1.0] - 2023-06-13

### Changed

- Optimized work with custom types.

### Fixed

- Fixed a bug when reading a library-project when using a relative path.
- Fixed false differences in function body quoting.
- Fixed tooltip conflicts for object name.

## [8.0.0] - 2023-05-30

### Added

- Added support for Greenplum as a test phase.
- Added dialog box for editing library properties.
- Added relative path support for library.
- Added an optional field "Name" in library properties to customize display name in the list.
- Added transition to library settings page from dialog box with an error when overriding objects.

### Changed

- Improved RETURNS TABLE comparison mechanism for functions.

### Fixed

- Fixed a bug due to which the outline did not update while navigating through search results.

## [7.6.0] - 2023-05-16

### Changed

- Removed Diff Wizard dialog modality.

### Fixed

- Fixed a bug due to which the COLLATION directory was ignored.
- Fixed a bug in generating the migration script when changing the order of columns in a composite type.

## [7.5.0] - 2023-04-11

### Added

- It is now possible to update the plugin version in standalone pgCodeKeeper packages.
- Added parser's support for REBUILD options for tables in MS SQL.
- Added tests for library loader.

### Fixed

- Fixed a bug in the "normalization" mechanism for a project with libraries and overrides.
- Fixed a bug in generating the migration script when data migration with deleting the identity column of the table.
- Fixed a bug in MS SQL builder when saving files.
- Fixed NPE in PostgreSQL aggregate functions.
- Fixed NPE when reading USER MAPPING with PUBLIC user.
- Fixed missing quotes in composite type columns.

## [7.4.0] - 2023-03-28

### Added

- Added signing jar files with a certificate.
- Added support for PostgreSQL version 9.4 - 9.6.
- Added support for MASKED, ROWGUIDCOL, PERSISTED, SPARSE, NOT FOR REPLICATION options for table columns in MS SQL.
- Added tooltip for database name in project editor.
- Added support for MATCH syntax in MS SQL.

### Changed

- Updated license.

### Fixed

- Fixed issue with code generation when deleting a partition index with a table.
- Fixed a bug when reading default value of VARIADIC function parameter.
- Fixed a bug when renaming objects with long names when migrating data.

## [7.3.0] - 2023-03-14

### Added

- Added support for options for the User object in MS SQL: DEFAULT_LANGUAGE, ALLOW_ENCRYPTED_VALUE_MODIFICATIONS.
- Added support for STATISTICS_INCREMENTAL option for the Index object in MS SQL.

### Fixed

- Fixed errors in tests when running on machines with RU locale.
- Fixed issues in code generation when altering OWNED BY property of sequences.
- Fixed vulnerability when reading XML files.

## [7.2.0] - 2023-02-21

### Changed

- Updated mechanism for sending anonymous data from Google Universe to Google Analytics 4.

### Fixed

- Fixed an error when printing query error message. 
- Fixed a bug with data migration code generation for partition tables.
- Fixed a bug when recreating a sequence when pouring data from a table.

## [7.1.0] - 2023-02-07

### Added

- Starting with this version, pgCodeKeeper requires Eclipse 2021-03 (4.19) or higher.
- Added CHANGELOG files.
- It is now possible to add a comment on object via context menu of SQL editor.

### Changed

- Improved deployment by replacing nested jars with maven dependencies.
- Changed `--graph-name` parameter in CLI version: added support for regular expression.

### Fixed

- Fixed an error when changing the type of a FOREIGN TABLE column.
- Fixed errors in parsing expressions.
- Fixed `pg_dbo_timestamp` version check.
- Fixed error when overriding privileges.
- Added missing references to objects in MS SQL.
- Added missing keywords from PostgreSQL 15 to parser.

### Removed

- Removed an option to limit number of rows returned by executed SELECT statements.

## [7.0.1] - 2022-11-14

### Fixed

- Fixed query for sequences.

## [7.0.0] - 2022-11-14

### Added

- Added support for PostgreSQL 15.
- Added a switch to show columns in the pgDependencies view.
- Added search by qualified object name.

### Changed

- Increased minimum JAVA version to 11.
- Сhanged the resource reading mechanism.

### Fixed

- Disabled data migration for foreign tables.
- Fixed a bug related with installing pgCodeKeeper in the latest version of Eclipse.
- Fixed a bug in MS SQL tables query.
- Fixed missing references to objects in MS SQL.

### Removed

- Removed support for PostgreSQL versions below 10.
- Removed feedback form through Eclipse.

## [6.6.0] - 2022-09-27

### Added

- Added support for COLLATION objects.
- It is now possible to generate the creation of CONSTRAINTs using NOT VALID/VALIDATE in migration scripts (CLI option --generate-constraint-not-valid).
- It is now possible to change the trustServerCertificate parameter for MS SQL connections.
- Added CLI option --update-project to update project in --parse mode.
- Added CLI option --clear-lib-cache to clear libraries cache.

### Changed

- It is now possible to roll forward selected objects in the project editor without checked marks.
- Improved quick fix mechanism for FUNCTION, USER MAPPING, CAST objects.
- Added a marker for the current group in the database selection menu.
- Disabled re-launches of the parser by right-clicking in the SQL editor.

## [6.5.3] - 2022-08-05

### Changed

- Added recursive processing for nested directories with PRE/POST scripts.
- Set minimum width for DB selection menu in Eclipse toolbar.

### Fixed

- Fixed an error when PRE/POST files and directories did not exist in UI.
- Fixed a file location dialog when saving global PRE/POST scripts for the first time.

## [6.5.2] - 2022-08-03

### Added

- Added PRE/POST scripts for migrations. Users may create directories named PRE and POST in projects, contents of which will be added to the beginning and end of the main migration script. PRE/POST scripts are also available in global settings and in CLI options.
- Expression analysis dependency resolution now supports function calls with [named parameter notation](https://www.postgresql.org/docs/11/sql-syntax-calling-funcs.html#SQL-SYNTAX-CALLING-FUNCS-NAMED).
- Added support for DISABLE TRIGGER options.
- Added parser support for reserved keywords in object qualified names.

### Changed

- Improved rendering of DB selection menu in Eclipse toolbar.

## [6.5.1] - 2022-07-11

### Fixed

- Fixed NPE in UserMapping when privileges are ignored.
- Restored no-filter state in SQL Editor's DB store picker.

## [6.5.0] - 2022-07-11

### Added

- It is now possible to group DB connections into user-defined groups. Groups are rendered as submenus to easily find required DB connection when choosing one.
- It is now possible to import/export DB connections list.
- It is now possible to generate DROP/CREATE commands with IF (NOT) EXISTS options, and also drop some objects immediately before creating them.
- Added support for USER MAPPING objects.

### Fixed

- Fixed a missing dependency in composite types.
- Fixed object creation order: indices are created before constraints.
- Fixed expression analysis and dependency search in SELECT ... LATERAL commands.

## [6.4.3] - 2022-04-21

### Changed

- Changing SEQUENCE START value now generates ALTER ... START command instead of RESTART.

### Fixed

- Fixed order of operations in migration scripts when deleting a column with its CONSTRAINT. Fixed errors when reading CONSTRAINTS objects.
- Creating a script only with selected objects (CLI --selected-only) no longer hides refreshsqlmodule MS SQL commands and doesn't move them to the end of the script.

## [6.4.2] - 2022-04-11

### Changed

- Updated all library dependencies of the core program. New mssql-jdbc driver (10.2) enables [encryption by default](https://github.com/microsoft/mssql-jdbc/releases/tag/v10.1.0). To preserve old behavior now we set property trustServerCertificate=true for MSSQL connections by default. To enable server certificate validation set trustServerCertificate=false in connection properties or connection string.

### Fixed

- Fixed an error in code generated when changing a function into a procedure and vice versa.
- Fixed an error when opening a temporary SQL editor on Windows.

## [6.4.1] - 2022-03-28

### Fixed

- Fixed an error when parsing certain foreign options and other object options.

## [6.4.0] - 2022-03-25

### Added

- It is now possible to recursively load pgCodeKeeper libraries, which are referenced by other libraries added to the project. Library must be in a project (or project archive) format to have its own dependences, which must be listed in its .dependencies file. This option is disabled by default so that behaviour of existing projects doesn't change. Users can enable this new mechanism in project settings. In a general case, for library dependencies to be loaded, container of that library must have its loadNested flag set in .dependencies file. For instance, in this dependency chain: project → lib1 → lib2 → lib3, lib2 will be loaded if project has the option enabled, and lib3 will be loaded if the option is set in both project and lib1.
- Added a tree view of referenced libraries and their structure in Project Explorer.
- Added an option to save DB passwords in plain text in Eclipse workspace instead of Eclipse secure storage for cases where latter was unstable. Users can also use passwords stored in .pgpass file.
- Added an option to limit number of rows returned by executed SELECT statements.

### Changed

- Improved SQL code formatter, fixed errors.
- Non-relocatable extensions are now re-created when necessary.

### Fixed

- Fixed an error where a newline was lost at the beginning of some expressions.

## [6.3.3] - 2022-01-13

### Fixed

- Fixed data loss in data migration when column type or attributes change.

## [6.3.2] - 2021-12-10

### Fixed

- Fixed installation on Eclipse 2021-12.

## [6.3.1] - 2021-11-18

### Fixed

- Fixed reading SQL-standard function bodies via JDBC.

## [6.3.0] - 2021-11-17

### Added

- Added [PostgreSQL 14](https://www.postgresql.org/docs/14/release-14.html) support:
    - parser support for new SQL and PL/pgSQL syntaxes
    - support for SQL-standard function bodies, not wrapped as string literals
    - support for COMPRESSION option in table columns
    - support for MULTIRANGE and SUCSRIPT options in types
    - support for keywords used as column names in SELECT without AS
    - removed support of postfix unary operators

### Fixed

- Fixed an error when parsing SELECT ... INTO in PL/pgSQL IF-statement.

## [6.2.0] - 2021-10-12

### Added

- Added support for SERVER and FOREIGN DATA WRAPPER objects.
- Added SQL code refactoring feature. Users can now rename objects in SQL code together with references to those objects. This feature is available in context menu of SQL editor or with a hotkey Alt+Shift+R.
- Added object references search feature for SQL code. Users can now search for all recognized references to the currently selected object in SQL editor. This feature is available in context menu of SQL editor or with a hotkey Ctrl+Shift+G.
- Added a quick fix for misplaced object errors. It is available in the error tooltip or in Quick Fix context menu in SQL editor. This quick fix moves the object's file to its expected location in the project.
- Added an option to autoformat object code when comparing them and saving them into projects.

### Changed

- Improved tooltip rendering in SQL editor.

### Fixed

- Fixed erroneous Java 11 requirement in CLI version.
- Fixed code generation when migrating data of tables containing IDENTITY columns.

## [6.1.0] - 2021-08-16

### Added

- It is now possible to selectively load schemas when reading a project or a DB via JDBC. Skipping schemas accelerates DB or project loading. Objects in ignored schemas cannot be used when generation migration scripts. See [docs](https://pgcodekeeper.readthedocs.io/ru/latest/white_black_list_schemas.html) for further info.
- Added developer documentation describing overall project structure and work process in [README](https://github.com/pgcodekeeper/pgcodekeeper#readme).

### Changed

- Improved function links in SQL editor, and also function dependencies.
- Added a DB type filter to the drop-down list in Project Editor.
- Removed extraneous Show In menu in Project Explorer.

### Fixed

- Fixed a false diff on functions with GRANT TO PUBLIC privileges.
- Fixed drop-down DB list rendering in Project Editor when running under KDE.
- Fixed an error in table data migration code generation.
- Fixed a parser error for ALTER TABLE SWITCH TO in MS SQL.

## [6.0.0] - 2021-08-07

### Added

- Added code formatting feature for functions in plpgsql and sql languages. Implemented so far: indentation and newline formatting, tabs to spaces replacement, spaces around operators, trailing whitespace removal. Formatting functionality will be extended in future.

### Changed

- Project Editor now remembers last direction for changes application when reopened.
- Project Editor now has a drop down list of DB connections for convenient connection selection.

### Fixed

- Fixed error when reading a DB schema via JDBC when objects of different kinds have same oid's.

## [5.11.3] - 2021-04-09

### Fixed

- Fixed duplicate object error when using `pg_dbo_timestamp` extension.

## [5.11.2] - 2021-03-25

### Fixed

- Fixed plpgsql block label parser.

## [5.11.1] - 2021-03-22

### Added

- Added full support for new object syntaxes introduced in PostgreSQL 13.
- Project editor now clearly shows currently selected source for schema comparison and destination for application of selected changes

## [5.11.0] - 2021-03-18

### Added

- Starting with this version, pgCodeKeeper requires Eclipse 2020-06 (4.16) or higher.
- Improved Project editor interface, fixed rendering errors on Windows. See [docs](https://pgcodekeeper.readthedocs.io/ru/latest/db_store.html).
- Improved object dependency graph CLI mode. Now the output can be filtered by object types and it is also sorted by object type. See CLI help on `--graph-filter-object`.
- Added support for function calls involving null, anyelement, etc in expression analysis.

### Fixed

- Fixed a crash when analysing WITH RECURSIVE expressions.
- Fixed references lookup for functions with INOUT arguments.
- Fixed index comparison when CONCURRENTLY option for code generation is enabled.
- Fixed a crash when reading IDENITY SEQUENCE over JDBC.
- Fixed errors in identifier parser.

## [5.10.8] - 2020-12-02

### Added

- Added an option for data migration when re-creating tables.
- Added an option to copy selected objects' names in Project editor.

### Fixed

- Fixed `Deselect Child Elements` menu behaviour in Project editor.
- Fixed table column dependencies of indices and constraints.
- Fixed error when running some SQL commands.

## [5.10.7] - 2020-08-27

### Fixed

- Fixed qualified name checks in ignore lists.
- Fixed saving ignore lists containing reserved words.
- Fixed trigger re-creation in MS SQL migrations.
- Fixed ALTER SCHEMA output in script execution log.
- Fixed an error in the project editor UI.

## [5.10.6] - 2020-08-13

### Changed

- Special characters in file names are now replaced with '_'. When file names match for different objects they will be stored in the same file.
- Added a missed option "Ignore column order" into Get changes settings dialog.
- Improved DB connection editing UI.
- Improved Mac OS X build.

### Fixed

- Fixed an error with project recognition when importing.
- Fixed object location checks under Windows.
- Fixed errors in MS SQL parser.
- Fixed expression analysis when changing files in MS SQL projects.

## [5.10.5] - 2020-07-29

### Added

- Added standalone pgCodeKeeper packages that do not require an existing Eclipse installation. Packages are available on [Github](https://github.com/pgcodekeeper/pgcodekeeper/releases). Previous update site versions are also available on Github. Main [update site](https://pgcodekeeper.org/update/) now contains only the latest version.
- Added a setting to create migration scripts only for selected objects without changing any dependencies. In CLI, all objects that passed through the allowed object and ignore list filters are considered "selected", or all changed objects if no filters are defined.
- Added a setting to ignore differences in table column order.

### Changed

- Improved COMMENT ON command generation.

### Fixed

- Fixed dependencies between operators and their functions.

## [5.10.4] - 2020-07-15

### Fixed

- Fixed an error when reading foreign table schemas via JDBC.
- Fixed compatibility with PostgreSQL 9.4 when reading schema via JDBC.
- Fixed order of commands for dependencies between functions.
- Fixed object location path checks to be case-insensitive.
- Fixed errors in expression analysis.
- Fixed a crash when parsing a malformed MS SQL command.
- Fixed export of types when initializing a MS SQL project.

## [5.10.3] - 2020-07-02

### Added

- Selected object occurrences are now highlighted in SQL Editor.
- Added warnings for objects found in unexpected locations (project paths).
- Added parser support for nested multiline comments in PostgreSQL.

### Changed

- Improved object filter dialog in Project Editor.

### Fixed

- Removed duplication of error markers.
- Fixed a crash when an error is found at the end of a line in a migration script.

## [5.10.2] - 2020-06-18

### Fixed

- Fixed an error in project builder.

## [5.10.1] - 2020-06-16

### Added

- Added support for POLICY objects.

### Changed

- Improved COMMENT ON items in SQL Editor's Outline.

### Fixed

- Fixed an error in COMMENT ON for DOMAIN CONSTRAINT.
- Fixed SQL comments before object code being lost when executing MS SQL migrations.
- Fixed erroneous/extraneous object references in SQL Editor.

## [5.10.0] - 2020-06-03

### Added

- Reworked object references lookup. Now object refernces are collected in analysis stage of function bodies, view queries, and all other expressions. Imprecise method of text-search in expressions was retired.
- It is now possible to filter Project Editor by columns. Only tables with changes to their columns will be shown.

### Changed

- Improved support for SQL string escape schemas.

### Fixed

- Fixed an error in SQL parser in SELECT aliases.
- Fixed object references in COMMENT ON.
- Fixed a crash when parsing MS SQL scripts.

## [5.9.14] - 2020-05-20

### Fixed

- Fixed extension CASTs being loaded.
- Fixed DB toolbar combo content when switching editors.

## [5.9.13] - 2020-05-19

### Changed

- Improved DB selection dropdown UI. Increased the list width in Eclipse toolbar.

### Fixed

- Fixed order when adding new columns into a table to preserve the order specified by user.
- Fixed false differences in changed order of VIEW column comments.

## [5.9.12] - 2020-04-29

### Added

- Added support for CAST objects.
- Ignore lists now have a QUALIFIED flag that matches rules against object qualified names.
- Project builder now uses included libraries when performing a full build, and doesn't mark references to library objects as errors.

### Fixed

- Fixed DB connection list UI and other list UIs on Windows.
- Fixed a crash when parsing an empty migration script.

## [5.9.11] - 2020-04-16

### Added

- Added a warning when Java heap space is insufficient for large projects.

### Changed

- Improved output of command log and error messages when executing a script.
- Improved command list in SQL Editor's Outline, and also in Project Explorer.

### Fixed

- Fixed an error in query results UI.
- Fixed an error when parsing WITH (reloptions) in indices, tables, etc.
- Fixed missing links for objects used in function bodies and triggers.

## [5.9.10] - 2020-03-11

### Added

- Added a preference to disable error reports when getting changes.

### Changed

- Removed internal preference values from `.settings/ru.taximaxim.codekeeper.ui.prefs` project file. Now it contains only user-defined settings.
- Improved PL/pgSQL parser rules.

### Fixed

- Fixed an error when reading aggregate functions ordering by VARIADIC "any".

## [5.9.9] - 2020-02-19

### Added

- It is now possible to disable SQL editor parser for large files to improve performance.
- It is now possible to drag and drop the elements around in DB connection list, Ignore lists, Library lists and others.
- It is now possible to set encoding when importing a project.

### Changed

- Diff Wizard now uses the global Ignore list.
- Improved parsing of PL/pgSQL INTO clause.
- Improved performance of MS SQL expression analysis.

### Fixed

- Fixed code generation when changing IN/INOUT function argument modes.
- Fixed builder crash when encountering an error in expression analysis.

## [5.9.8] - 2020-01-28

### Added

- Added support for new object properties introduced in PostgreSQL 12.
- Added `--ignore-errors` CLI switch to ignore parser and code analysis errors.
- Added support for newline-split strings in PostgreSQL.

### Changed

- Dependency tracking for PostgreSQL function bodies was disabled due to unstable behavior.
- Dependencies are now tracked in default value expressions in MS SQL.
- Improved error reporting in expression analysis.
- Improved whitespace-agnostic PostgreSQL VIEW comparison.

## [5.9.7] - 2019-12-24

### Fixed

- Fixed an error when analysing RETURNING DML statement inside a CTE.
- Fixed Windows CLI bat launcher failing when passed special character containing arguments from PowerShell.

## [5.9.6] - 2019-12-16

### Changed

- Enabled dependency processing for PostgreSQL functions when their bodies are changed.
- Reduced the number of objects recreated when their function dependencies have changes in their bodies.

### Fixed

- Fixed CREATE FDW parser.
- Fixed SELECT ... FOR parser.
- Fixed an error when overriding settings before launching an operation.

## [5.9.5] - 2019-12-09

### Changed

- Optimized migration script generation for complex/large object dependency graphs.
- Improved error messages when saving passwords in secure storage.
- Improved cancellability when reading DB via JDBC.

## [5.9.4] - 2019-11-29

### Added

- It is now possible to override settings before launching `Get Changes` or generating a migration script. Overridden setting are only used once and don't affect program and project preferences. Overridable settings are also added to the Diff Wizard.
- Added support for MEMORY_OPTIMIZED MS SQL tables.

### Changed

- Expression analysis has been optimized: debug logging has been turned off, analysis is now run using multiple threads, VIEW analysis is now done in a single pass and doesn't require a dependency graph.
- Expression analysis an the final step when loading any DB schema. These optimizations reduces analysis time 4x relative to the last version (depends on CPU count).
- Improved error reporting when saving passwords in Eclipse's secure storage.

### Fixed

- Fixed code generation when changing ANSI_NULLS and QUOTED_IDENTIFIER properties in MS SQL.
- Fixed execution of MS SQL scripts containing a single batch of commands.

## [5.9.3] - 2019-11-19

### Fixed

- Fixed parsing of RETURN QUERY EXPLAIN.

## [5.9.2] - 2019-11-14

### Added

- Database passwords are now stored in Eclipse's encrypted [Secure storage](https://help.eclipse.org/2019-09/topic/org.eclipse.platform.doc.user/reference/ref-securestorage-start.htm). Passwords in .pgpass file are still supported.
- It is now possible to free parser cache memory after a period of inactivity or on-demand. Default inactivity interval is 30 minutes and may be changed in the program settings. Parser cache significantly speeds up SQL parsing but may consume hundreds of MBs of Java heap space which may be undesirable if parsing rarely.

### Changed

- Added a workaround for potential GUI deadlock on Linux.
- Added a dependency from SELECT queries to PRIMARY KEYs whose columns are used in GROUP BY section.
- Added column dependencies to pgDependencies view graph.

### Fixed

- Fixed an error with function default privileges when changing owners.
- Fixed order of generated commands in cases with cyclic dependencies between functions and tables.

## [5.9.1] - 2019-10-31

### Added

- CLI is now able to run the generated script on a database (options `--run-on` and `--run-on-target`).

### Changed

- Improved parser error messages.
- Added dependencies of Full Text Search objects to functions used by them.
- Improved Query Result view UI: added a context menu for tabs, and it is now possible to close tabs with middle mouse button.

### Fixed

- Fixed errors in PL/plSQL parser, optimized code analysis.
- Fixed issues in code generation when altering OWNED BY property of sequences, dropping sequences, and in some other cases.
- Fixed an issue where order of column dependencies creation was incorrect when creating a table.
- Fixed an issue with dependency detection in expression using COALESCE, NULLIF, etc.
- Fixed code generation when working on partitioned indexes.

## [5.9.0] - 2019-10-16

### Changed

- Enabled analysis for function bodies written in PL/pgSQL language: dependencies used in function bodies are tracked and errors in code are highlighted. Dependency tracking from function bodies to other functions is turned off by default. Projects containing a lot of PL/pgSQL code may require more memory than before due to increased volume of parsed text.

## [5.8.3] - 2019-10-10

### Fixed

- Fixed an error when working with PostgreSQL 12.
- Fixed an error reporting when workign with pgCodeKeeper project libraries and also with projects themselves when reading them in CLI.
- Fixed an error when using LIST identifier.
- Fixed Diff Wizard script encoding.
- Fixed an error when analyzing objects received from JDBC.

## [5.8.2] - 2019-10-02

### Changed

- Data format of copied query results changed for compatibility with both SQL and CSV (SQL strings are copied).

### Fixed

- Fixed an error when opening Diff Wizard's script.

## [5.8.1] - 2019-10-10

### Added

- CLI mode now exits with an error when encountering errors in loaded SQL files.
- Added REFRESH MATERIALIZED VIEW code generation when WITH [NO] DATA state changes.

### Changed

- SQL parser now supports XMLTABLE, TABLESAMPLE, SELECT INTO contructs.
- MS SQL parser now supports UPDATE trigger function. Also, parser rules have been improved.

### Fixed

- Fixed an error when opening non-pgCodeKeeper project files in SQL editor.

## [5.8.0] - 2019-09-18

### Added

- Enabled analysis for function bodies written in SQL language: dependencies used in function bodies are tracked and errors in code are highlighted. Dependency tracking from function bodies to other functions is turned off by default (analogous to MS SQL). Same functionality for plpgSQL is planned in a near future release.
- It is now possible to open an SQL editor to run queries without creating a file on disk.
- In SQL editor it is now possible to switch between PostgreSQL and MS SQL code parsers and templates for files not in pgCodeKeeper projects.

### Changed

- Progress of script execution and getting changes is now shown in Windows task bar.

## [5.7.0] - 2019-09-03

### Added

- Added global and per-project preference to enable simplified VIEW format. Views read via JDBC won't contain excessive parenthesis with this setting enabled.
- Improved PostgreSQL parser coverage, fixed errors.
- Restored the notification about parser errors encountered during `Get Changes` operation.
- Added new CLI mode `--graph` that shows object dependencies.
- Added Java VM property `ru.taximaxim.codekeeper.parser.poolsize`, that allows users to specify number of threads allocated to run SQL parsers in parallel.

### Fixed

- Fixed an error with EXCLUDE CONSTRAINTs.
- Fixed outdated syntax in VIEW statements.
- Fixed an error where users couldn't execute SQL files on MS SQL databases.

### Removed

- Removed deprecated CLI -l (--license) parameter.

## [5.6.1] - 2019-08-14

### Fixed

- Fixed an error with COMMENT ON INDEX code generation.

## [5.6.0] - 2019-08-13

### Added

- It is now possible to override certain global preferences in different projects.
- Added parser support for SELECT WITH ORDINALITY syntax.
- Project editor filter now shows correct change type based on selected target for changes application.
- It is now possible to specify Java VM parameters when using CLI launcher scripts. All parameters given after `-vmargs` will be passed to the JVM itself.

### Fixed

- Fixed incorrect name quoting in GRANT/REVOKE statements.
- Fixed an error with character varying type in MS SQL.

## [5.5.3] - 2019-07-30

### Fixed

- Fixed function call dependency resolution when argument type has typmod.
- Fixed an error when opening an SQL file outside of an Eclipse project.

## [5.5.2] - 2019-07-17

### Added

- Added support for IDENTITY syntax in column definition.
- Added support for ALTER EXTENSION command in SQL parser.

### Changed

- Project's default ignored objects list can now be edited from project properties dialog.
- Improved dependency tracking between inherited tables' columns.
- Referenced libraries list in Project Explorer now shows file names for URLs.

## [5.5.1] - 2019-07-02

### Changed

- Domain field has been added to DB connection properties dialog. It enables domain authentication for MS SQL.
- Improved contextual information when reporting SQL script execution errors.

### Fixed

- Fixed order of operations for partitioned tables' columns to consider dependencies between them.
- Fixed some errors in template autocomplete UI in SQL editor.

## [5.5.0] - 2019-06-19

### Added

- SQL editor code templates have been updated. New SQL object wizard now creates new objects using templates for further editing convenience.
- Code autocompletion in SQL editor has been split into categories: identifiers and keywords, and templates. Categories can be switched by repeatedly pressing the autocomplete hotkey (Ctrl+Space).
- MS SQL JDBC driver has been updated. New version allows for NTLM domain authentication when supplied [additional connection](https://github.com/Microsoft/mssql-jdbc/pull/998) properties.

### Fixed

- Fixed the condition for detecting changes in functions with default parameters. Previous condition used to trigger unnecessary dependency re-creation.
- Fixed code generation when granting PUBLIC privileges to functions, procedures and types.
- Fixed code generation for index comment when altering in CONCURRENTLY mode.

## [5.4.10] - 2019-06-05

### Changed

- Identical objects in project and library are not considered overrides, so that they don't block the workflow when the Disallow overrides option is set.
- It is now possible to edit path or URL in the libraries list.
- When overriding privileges with an "empty list" default privileges for the given object are used instead.

### Fixed

- Fixed vulnerability when extracting zip archives.

## [5.4.9] - 2019-04-30

### Changed

- When altering an index in CONCURRENTLY mode generated code is now optimized to minimize the time where the index is unavailable.
- When altering a MS SQL index generated code now uses DROP_EXISTING without explicitly dropping the existing version.
- Columns are now dropped only in the specified table using ONLY keyword.
- SET NOT NULL operations are no longer generated with ONLY keyword, as they are impossible to execute only on the parent table.
- When creating a NOT NULL column, separate commands for NOT NULL and DEFAULT are no longer generated.
- MS SQL parser now supports multiple actions in ALTER TABLE commands.

## [5.4.8] - 2019-04-17

### Added

- Projects can now be bound to DB connections. Only selected connection can be used for bound project.
- Each DB connection can now specify an external loader (pg_dump or other). Connection parameters are passed to the loader via environment variables as described in pg_dump manual.
- Object change types in Project Editor are now shown based on selected migration direction.

### Fixed

- Fixed incorrect comparison of indentations in text of MS SQL user types.

## [5.4.7] - 2019-04-02

### Fixed

- Fixed dependency processing for MS SQL views, functions, procedures and triggers.
- Fixed an error when comparing MS SQL sequences based on system types.
- Fixed ad error when comparing PostgreSQL functions.
- Fixed an error in MS SQL parser processor for DROP TRIGGER command.
- Fixed privilege override option in project update dialog.
- Fixed an error when sorting project editor by git or DB users.
- Fixed UI freezes when launching large scripts.

## [5.4.6] - 2019-03-19

### Added

- Git and DB user columns in Project Editor are now sortable.
- Added an option to continue reading DB schema when receiving objects in inconsistent state.

### Fixed

- Fixed errors in dependency search for MS SQL expressions and functions.

## [5.4.5] - 2019-03-11

### Added

- It is now possible to execute data queries in SQL editor. Received data is shown in Query `Result view`.

### Fixed

- Fixed index creation code for partitioned tables.
- Fixed naming for a black/white list rule option, that applies it to the object's contents.

## [5.4.4] - 2019-03-05

### Changed

- Disabled `sp_refreshsqlmodule` output for objects except VIEWs.

## [5.4.3] - 2019-02-27

### Added

- Added support for T-SQL scripts beginning with GO command.
- Added support for PostgreSQL scripts lacking terminating semicolon.

## [5.4.2] - 2019-02-27

### Fixed

- Fixed erroneous TABLESPACE parameters for FOREIGN KEYS.

## [5.4.1] - 2019-02-26

### Fixed

- Fixed error where no commands were executed when launching scripts.

## [5.4.0] - 2019-02-26

### Added

- All objects are now expected to be schema qualified, otherwise a warning is emitted. References to unqualified objects are treated as references to pg_catalog objects.
- Added project builder for MS SQL.
- Added support for indices on partitioned tables and materialized views.
- Added support for TABLESPACEs for table constraints.

### Changed

- Improved dangerous statements mechanism. Scripts are now checked immediately prior to their execution.
- Improved dependency processing for MS SQL objects. Changes in functions, procedures, views, triggers and also any changes to table columns trigger dependent object updates.
- Improved and optimized SQL parser rules.

### Fixed

- Fixed an error where FOREIGN KEYs were duplicated for table partitions in PostgreSQL 11.
- Fixed an error when reading server name in FOREIGN TABLE.

## [5.3.9] - 2019-02-12

### Added

- Added support for user-defined aggregate functions.
- Added support for PostgreSQL data type aliases. Aliases are converted into standard types "on the fly", different type aliases used in objects are treated as no-change.

### Changed

- SQL parser rules have been improved and optimized.

### Fixed

- Fixed "too many open files" error when launching parsers in parallel.
- Fixed SQL error reporting when launching parsers in parallel.

## [5.3.8] - 2019-02-01

### Added

- Added parser support for empty SQL statements.

### Fixed

- Fixed migrations generated for function dependent objects when its default parameters change.

## [5.3.7] - 2019-01-30

### Fixed

- Fixed consoles leak in program's UI.
- Fixed MS SQL builder when launching parsers in parallel.

## [5.3.6] - 2019-01-29

### Added

- Added support for type modifiers of user types in PostgreSQL.

### Changed

- Improved project loader performance using parallel parser launches.
- In MS SQL migrations unmodified dependent objects are refreshed using `sp_refreshsqlmodule` instead of being re-created.

### Fixed

- Fixed MS SQL parser for CREATE SCHEMA with object definitions.

## [5.3.5] - 2019-01-15

### Added

- Script execution progress is now reported in pgCodeKeeper console. Execution result and errors are too reported in the console.

### Fixed

- Fixed missing dependencies from functions being called using EXEC in MS SQL.

## [5.3.4] - 2018-12-11

### Added

- Added an option to override owners of library objects in Project library settings. This option is also applied in CLI when including libraries using XML files. Owners in project override files have priority over this option.

### Fixed

- Fixed StackOverflowErrors when processing large DBs.
- Fixed loss of dependency information for library objects.

## [5.3.3] - 2018-12-05

### Added

- Added support for special system function call syntaxes in MS SQL.

### Fixed

- Fixed mismatched source/target library XML options in CLI.
- Fixed missing operation cancellation checks when reading DB over JDBC.

## [5.3.2] - 2018-11-30

### Fixed

- Fixed load order: overrides are loaded last, after libraries.
- Fixed MS SQL functions export.

## [5.3.1] - 2018-11-28

### Fixed

- Fixed an error while reading default values of MS SQL function arguments over JDBC.

## [5.3.0] - 2018-11-27

### Added

- Added new mechanism that allows users to override privileges and owners of objects, stored in projects and libraries. Overrides are saved in the OVERRIDES directory, which the main project structure.
- Update Project dialog now has an option that saves selected differences into the overrides directory.
- Added support for user-defined type objects in MS SQL.
- Added notifications for errors found in libraries.

### Changed

- CLI mode uses overrides directory automatically.

### Fixed

- Fixed an error when updating files for VIEWs with triggers.

## [5.2.1] - 2018-11-20

### Fixed

- Fixed REVOKE PUBLIC privilege being ignored for FUNCTIONs and TYPEs.

## [5.2.0] - 2018-11-13

### Added

- Added support for procedures in PostgreSQL 11. Also fixed reading functions via JDBC in PostgreSQL 11.
- Parser now supports new syntax added in PostgreSQL 11.
- Added dependency processing for all MS SQL objects.
- It is now possible to use zip-archives as libraries in pgCodeKeeper projects.
- Library files can now be included by providing remote resource URLs.
- It is now possible to include libraries in CLI using XML lists (.dependencies files, see --src-lib-xml option).

### Changed

- Default privileges are no longer written in project object files.
- Table re-creation commands are now generated when its column order changes.

### Fixed

- Fixed processing of sequence min and max values in MS SQL.
- Fixed processing of configuration parameters of functions in PostgreSQL to comply with pg_dump fixes.
- Fixed rules for allowed user-defined operator names to comply with PostgreSQL spec.
- Fixed comparison of INCLUDE columns in indices. Column order is is now ignored.

## [5.1.7] - 2018-10-24

### Fixed

- Disabled reading of EXTENSION owned operators.

## [5.1.6] - 2018-10-23

### Added

- Added support for OPERATOR objects in PostgreSQL.
- MS SQL migrations are now generated in order imposed by dependencies between objects and VIEWs.

### Changed

- Deleting MS SQL ROLE members before dropping the ROLE itself.

### Fixed

- Fixed an incorrect reading of TEXTIMAGE_ON parameter in MS SQL tables.
- Fixed an error in CLI launch script on Windows when launching from directories with spaces in path.
- Fixed JDBC loader failing when there is no schema to put an object in.

## [5.1.5] - 2018-10-10

### Fixed

- Fixed several errors in MS SQL support.

## [5.1.4] - 2018-10-08

### Added

- Added an option to use [Windows authentication](https://pgcodekeeper.readthedocs.io/ru/latest/windowsauth.html). when connecting to MS SQL databases.
- Added a separate New Project Wizard for MS SQL.

### Changed

- Significantly improved SQL parsers coverage.
- User formatting is used when processing MS SQL PROCEDURE, FUNCTION, TRIGGER, VIEW objects.
- Columns are now UPDATEd before adding a NOT NULL constraint. UPDATE has been added to the dangerous statements list.
- Improved error logging.

### Fixed

- Fixed an error when reading MS SQL schema over JDBC while using an unprivileged account.
- Fixed an error when reading and parsing RULEs with SELECT commands.
- Fixed an error when parsing a MS SQL USER.
- Fixed an error when writing non-integer FUNCTION COST and ROWS values.

## [5.1.3] - 2018-09-27

### Fixed

- Fixed several errors in MS SQL support.

## [5.1.2] - 2018-09-24

### Fixed

- Fixed an error with quotation of procedure parameters' default values in MS SQL.

## [5.1.1] - 2018-09-24

### Added

- It is now possible to run T-SQL scripts on MS SQL databases. Scripts are now split into separate commands using parsers which are then sent to DB. For T-SQL scripts commands are executed in batches as instructed by GO separators.
- Added support for MS SQL objects ASSEMBLY, ROLE, USER.
- DB drop-down lists are now filtered by type (PG/MS) depending on context.

### Changed

- Improved T-SQL parser, fixed most of ambiguities remaining in the parser grammar. Improved parser error messages.
- Expression analysis is now performed after all library dependencies have been loaded to avoid errors with objects referencing not-yet-loaded objects.

### Fixed

- Fixed false difference and incorrect read errors for MS SQL objects.
- Fixed an error where DEFERRED state of CONSTRAINT TRIGGERs was incorrectly read and written.
- Fixed a DB load crash when analysing expressions with references to non-existent objects. Such references now appear as errors in corresponding files.

## [5.1.0] - 2018-09-06

### Added

- Added support for Microsoft SQL Server as a test phase.

## [5.0.3] - 2018-08-09

### Changed

- Extended -Z parameter in CLI version: time zone value is used when reading the database.
- Improved parser rules.

### Fixed

- Fixed an error when getting time zone from database when creating a new project. 
- Fixed UI blocking when using feedback dialog. 

## [5.0.2] - 2018-08-01

### Fixed

- Fixed user types qualification in JDBC loader.

## [5.0.1] - 2018-08-01

### Fixed

- Fixed JDBC NPE when reading table descendant objects.
- Fixed JDBC NPE when reading IDENTITY sequences.

## [5.0.0] - 2018-08-01

### Changed

- SQL code generation has been changed. All SQL statements are now created for `search_path = pg_catalog`. This improves security and stability of generated code, for more information see PostgreSQL 10.3 changelog. Because of this, differences in name qualification will be found when comparing projects with DBs. Projects need to be updated to the new format by saving these differences. Using constant `search_path` for SQL code generation allows JDBC loader to read objects from all schemas with a single query. This greatly improves schema load speeds and allows us to get rid of server helper functions, they are no longer used. Work with `pg_dbo_timestamp` extension is also greatly sped up.
- Location of schema SQL files in projects has been changed. They are now stored in their schema directories instead of common SCHEMA directory. When opening older projects pgCodeKeeper will suggest moving schema files to their new location.

## [4.6.1] - 2018-07-19

### Fixed

- Fixed parsing of nameless function parameter of type character varying.
- Fixed compatibility with Eclipse 4.8.
- Fixed decrementing SEQUENCEs to comply with PostgreSQL 10 implementation.
- Fixed CONSTRAINT processing when working with `pg_dbo_timestamp` extension.

## [4.6.0] - 2018-06-21

### Added

- Added support from TEXT SEARCH objects: CONFIGURATION, DICTIONARY, PARSER, TEMPLATE. These objects are now also tracked by `pg_dbo_timestamp` extension.
- `pg_dbo_timestamp` extension has been updated to work around the issue of object privilege tracking. This fix allows pgCodeKeeper to use the extension to speed up DB schema reads. An option has been added to general settings to enable this behaviour. It also enables showing DB users who last modified objects that were found to differ.
- Parser now supports IMPORT FOREIGN SCHEMA command.

### Changed

- Improved Ignored objects list editor UI.

### Fixed

- Fixed highlight of multi-line string literals in SQL editor.
- Fixed errors in SEQUENCEs that were read using helper-functions on PostgreSQL 10.

## [4.5.3] - 2018-05-30

### Added

- Bracket highlighting has been enabled in SQL Editor. This can be customized in SQL Editor section of the global pgCodeKeeper settings.
- DB connection parameters UI has been improved. It is now possible to specify additional connection properties.
- Column dependencies in expressions are now recognized in cases where columns are referenced without being qualified by their table names, e.g. in SELECT and index expressions.

### Changed

- Improved notifications' look in Project Editor.

### Fixed

- Fixed an issue with increased memory consumption introduced in version 4.5.0.

## [4.5.2] - 2018-05-15

### Fixed

- Fixed broken association between SQL files and SQL editor.
- Fixed JDBC failover failing when server helper function forces transaction into an error state.

## [4.5.1] - 2018-05-15

### Added

- pgCodeKeeper is now available in [Eclipse Marketplace](https://marketplace.eclipse.org/content/pgcodekeeper)!
- Additional ignored objects lists can now be specified in project properties.
- The lists can be created and modified using editor dialog available in project properties.
- Compare dialog has been replaced by the standard compare editor.
- Object overrides view now lets users to compare object versions using this editor.
- Notification is shown when `Get changes` operation finds no differences.
- Parser now supports TRUNCATE, CREATE USER MAPPING commands and FROM clause in UPDATE command.

### Changed

- Some internal PostgreSQL functions read data outside [current transaction snapshot](http://archives.postgresql.org/pgsql-bugs/2010-02/msg00187.php). Security checks have been added to these function calls.
- When changing libraries their trees in `Project Explorer` now update automatically.
- Diff pane in Project editor now uses global preferences to render its SQL editors. This fixes the "zero-width tabs" error on Windows.
- Improved rendering for checkboxes with very long labels on Windows.
- Improved dependency analysis performance for VIEWs.

## [4.5.0] - 2018-04-25

### Added

- Ignored objects lists now allow to specify object types to which rule is applied. More in the [manual](https://pgcodekeeper.readthedocs.io/en/latest/preferences.html#ignoredobjects).
- pgCodeKeeper project libraries:
    - library structure is now shown in Project Explorer tree;
    - added Object overrides view, it shows overrides in current project editor;
    - library objects are now marked with an icon in the diff table of project editor.

### Changed

- Improved SQL expression analysis (in SELECT and other value expressions). The improvements allow for tracking dependencies from expressions to overloaded functions, as well as to columns selected by an asterisk (SELECT * FROM ...).
- CLI logs are now written to a single file in the user directory. This can be changed in the CLI launch script.

## [4.4.0] - 2018-04-11

### Added

- New feature: libraries in pgCodeKeeper projects. Other project directories, dump files, directories with SQL files, and JDBC connection strings can all be added as libraries. Users may now turn off SQL editor's SQL parser for unrelated files stored in pgCodeKeeper projects. This option is available in project settings.

### Fixed

- Fixed the message shown when SQL scripts executes with an error.
- Fixed a compatibility error with Eclipse Neon.3.

## [4.3.4] - 2018-03-28

### Added

- Improved DB Store: added per-DB ignored objects lists, a read-only DB setting, a connection tester, and .pgpass import functionality. Changed internal storage format for easier expansion and maintenance.
- Improved JDBC SQL-queries cancelability, such as DB schema reads. When cancelling such operations they will now terminate immediately after cancelling their current DB query.

### Changed

- Dollar quotes are now supported in any places in SQL code where strings are valid.
- Updated the list of keywords used for highlighting in SQL editor.
- Object links drop-down in SQL editor now shows project-relative paths.

### Fixed

- Fixed an error where identifiers in RETURNS TABLE clause weren't properly quoted.

## [4.3.3] - 2018-03-14

### Added

- Product documentation has been moved out of Eclipse Help System into a separate [Read the Docs project](https://pgcodekeeper.readthedocs.io/).
- SQL editor now searches and creates links for objects referenced by VIEWs. To initialize these links, rebuild or clean your projects.

### Changed

- `pg_dbo_timestamp` extension has been updated. A crash on PostgreSQL 10 has been fixed and additional data is now saved for events. From this release pgCodeKeeper supports extension of version 0.0.2 or above.
- In-product feedback function was not working and has been restored.
- Improved quoted identifier handling by New Object wizard.
- JDBC DB schema read queries have been secured against naming conflicts between internal PostgreSQL and user objects.

### Fixed

- Fixed an error while searching for file author in an empty git repository.
- Fixed an error when creating a project in a directory with existing settings.

## [4.3.2] - 2018-03-06

### Fixed

- Fixed an error where serial SEQUENCEs turned into IDENTITY's on PostgreSQL 10.

## [4.3.1] - 2018-03-01

### Fixed

- Fixed erroneous suggestions to add builder for non-pgCodeKeeper projects.

## [4.3.0] - 2018-02-27

### Added

- Added `pg_dbo_timestamp` extension support. This extension gathers information about DB objects DDL modifications.
- pgCodeKeeper project editor settings now contain an option to show DB users who modified the objects that were found to differ. In the future we plan to speed up JDBC schema reads by using this extension.
- Project editor can now filter objects by users who made changes in git or database.
- New SQL object wizard will now try to deduce object name and location from context. Inputting object's name and type has been improved, unwanted focus shifts fixed.

### Changed

- Mock data wizard now has a button to remove all optional (not-NOT NULL) columns.
- Project editor's filter history now shows automatically when typing.
- SQL editor now suggests adding b2uilder for file's project if it is absent.

### Fixed

- Fixed an error when reading SEQUENCE objects from PostgreSQL 10.

## [4.2.3] - 2018-02-13

### Added

- Project Editor now has history of previously used filters. Filtering is slightly delayed now to reduce UI hitches when filtering large change-sets. Added object container filter.

### Changed

- Mock data wizard improvements:
    - added support for more types: numeric, time, timestamptz;
    - added support for type aliases (varchar etc);
    - test data insert code can now be generated with explicit type casts for each value;
    - improved and cleared up error messages about incorrect input values;
    - added "any" generator, that allows any expressions or values and uses them "as is;"
    - user may now select and delete many columns at once;
    - the wizard is now accessible via Project Explorer's and SQL Editor's context menus for table files, it is also still accessible via File - New.
- New SQL object wizard improvements:
    - object name and location are now entered as a single string with dot-separators;
    - object name field is filled with default values from current context and is focused by default;
    - useless dummy owner code is no longer generated.

### Fixed

- Fixed project import when .pgcodekeeper file is missing. Also any Eclipse project may be converted into pgCodeKeeper project now (via Configure menu).
- Fixed an error when parsing qualified opclass in CREATE INDEX.
- Fixed an error when parsing implicit row constructor in expressions.

## [4.2.2] - 2018-01-30

### Fixed

- Fixed OS-specific paths in git blame.

## [4.2.1] - 2018-01-30

### Added

- Project editor shows last change author for projects in git repositories. Last change lookup uses `git log ‑‑full‑history ‑‑no‑merges` algorithm which results may differ from the standard one. This functionality may be disabled in pgCodeKeeper project editor settings.
- Added support for column OPTIONs in CREATE FOREIGN TABLE.
- Added support for CREATE RECURSIVE VIEW.
- JDBC-loader now notifies of errors due to outdated helper functions installed in the DB, and also permission denied errors for SEQUENCE objects.

### Fixed

- Fixed an error when reading privileges with special-character-containing user names via JDBC.
- Fixed errors when building project indices and when restoring them after Eclipse restart.
- SQL-editor's Outline will now open with correct filter states after it was closed.

## [4.1.3] - 2017-12-19

### Added

- pgCodeKeeper is now open-source, project moved under Apache 2.0 license.
- Added a "Cancel Execution" action to SQL editor's toolbar, allowing users to terminate a launched script without opening Eclipse's Progress view.
- Added "Collapse All" and "Expand All" options to project editor's diff table's context menu.
- Project editor's object counters have been moved to Eclipse's status bar.

### Changed

- Project editor's actions have been moved back inside the editor. They are still available in pgCodeKeeper main menu and using hotkeys.
- Filtering in project editor has been improved. It is now possible to filter tables' subelements by their types and all objects by their SQL-code.
- Changed pgCodeKeeper perspective's initial layout to allow for better cohesion between editors and their toolbars.

### Fixed

- Fixed a project initialization error. We recommend users to check their projects' properties to see whether they have a pgCodeKeeper builder attached. In case it's not, it is recommended to add it manually via a pgCodeKeeper - Add Builder context menu item.
- Fixed errors when creating object links in SQL editor, specifically links in function bodies and in out-of-project files.
- Fixed an error where changing contents of a single project had reset all project editors.

### Remove

- Licensing feature has been removed along with usage restrictions.
- "Saved selections" feature has been removed. Instead users may copy selected objects as a filter regex string.

## [4.1.2] - 2017-11-22

### Added

- Added table test data (INSERT) generation wizard.
- Restored feedback dialog functionality.

### Changed

- SQL editor and migration editor have been merged into single SQL editor that also executes scripts and performs quick object updates.
- Improved project editor's and SQL editor's toolbars. You can now choose changes sources or script execution targets using a dropdown-combo on Eclipse's main toolbar.
- Migration scrips saved as temporary, out-of-project files are now always created in UTF-8 encoding.

### Fixed

- Fixed an error in object type filter in project editor.

## [4.1.0] - 2017-09-25

### Added

- JDBC loader is now able to read schemas of different PostgreSQL versions, 9.2 through 9.6 are currently supported. Following SQL-clauses from these versions are now supported: CREATE FUNCTION ... TRANSFORM, CREATE FUNCTION ... PARALLEL, ROW LEVEL SECURITY. JDBC loader no longer fails when reading SEQUENCEs from PostgreSQL 10.
- Added support for FOREIGN TABLE, MATERIALIZED VIEW objects and CREATE TABLE UNLOGGED clause.
- Project builder now detects object name conflicts.
- Added an object and change types filters to the diff table in the project editor.
- Added a notification for errors found in sql-files while comparing DBs.

### Changed

- Error markers in sql-files are disabled for non-pgCodeKeeeper projects.
- pgCodeKeeper item is now visible in the main menu when working in the program's editors or its files.
- Extended .-operator (dot) support when it's used with nested composite types etc.
- Object owners' names are now quoted the same as other identifiers.

### Fixed

- Fixed a parser error when reading malformed COMMENT ON statements.
- Fixed and error in checkbox state tracking in diff table.

## [4.0.0] - 2017-09-11

We increment major version in this release due to decision to shift our development focus onto the SQL-IDE side of the application. Another reason is an upcoming open-source release, which we plan in the near future.

### Added

- New workflow for the migration editor — `Quick Update`. If you introduce schema changes directly in pgCodeKeeper now you'll be able to save your changes, generate a migration, apply that migration and update your project using a single hotkey — Ctrl+Alt+A.
- Project editor's main action buttons were moved to Eclipse's toolbar and we also assigned them hotkeys: `Get Changes` — Ctrl+F5, `Apply to project` — Ctrl+Alt+S, `Apply to DB` — Ctrl+Alt+D. Additional dependencies button was moved to pg Dependencies view.
- Migration files are now saved in project (/MIGRATION) or in the temp directory, user may choose to auto-delete migrations when their respective editors close.
- Dangerous statements in migrations are now highlighted at their locations.
- Project Explorer context menu now shows an Eclipse's `Show In` submenu for pgCodeKeeper project elements.
- SQL editor's `Show In` context menu now has a Project Explorer item (allowing user to quickly find editor's file in the project's tree).

### Changed

- Improved editor highlighting and tooltips, Outline view, project builder, added tooltips for errors found in code.
- Improved SQL editors code to allow for more efficient future development.
- Blocked launching of extra Get Changes jobs if a given Project Editor is already running one.

### Fixed

- Fixed an error where newly created project would show as empty.
- Fixed an error where the application tried to access a SEQUENCE without permission to use its SCHEMA.

## [3.11.0] - 2017-07-11

### Changed

- Reworked CLI (command line interface). Changes include: option names, program arguments, the way lists are passed and others. See CLI help for details (launch with `--help`).
- Project builder now looks for references to non-existent objects in project's sql files, those are marked as errors.

### Fixed

- Fixed an error where JDBC performance-helper functions were accessed with no permission to do so.
- Fixed an error in diff table filtering interface.

## [3.10.0] - 2017-05-23

### Added

- Ignored Objects list in program preferences can now be configured as white-list.
- Tabs of the Project Editor have been merged into a single interface.
- CLI build for Windows now includes a bat-script for launching.
- Added support for TABLE OF type clause.
- Added support for ALTER COLUMN SET (options) clause.
- Added support for ALTER COLUMN SET STORAGE clause.

### Changed

- Improved dependency detection for expressions in SQL commands.
- Improved handling of SQL keywords, parsing of built-in types and functions.

## [3.8.6] - 2017-02-07

### Added

- Added support for ENABLE/DISABLE RULE states;
- User can now choose object types (--allowed-objects) to output into migration script.

### Changed

- Server-side JDBC helpers have been updated and need to be reinstalled.

### Fixed

- Fixed a bug with getting data type names via JDBC.

## [3.8.4] - 2016-12-22

### Added

- Diff Wizard has been improved and updated. It can be launched using main menu item pgCodeKeeper - Diff Wizard or via pgCodeKeeper item in the project's context menu. It allows users to compare and generate migration scripts for DBs, loaded from different sources, without creating a project for them.
- CLI mode now allows users to connect to DB using JDBC connection string.

## [3.8.0] - 2016-12-06

### Added

- Another JDBC DB reader mode has been added. This mode improves performance when working with DBs containing large number of schemas and while using limited bandwith connections. To use it, it is necessary to install "helper" stored procedures in the DB being read. To do so, open pgCodeKeeper perspective (Window - Perspective), choose pgCodeKeeper - Install JDBC Performance Helpers in the main menu and apply the script to the DB in question. After this the new enhanced reader will be used automatically with this DB.

### Changed

- Ignored Objects feature has been improved. It is now possible to define both black and while object lists that can be used both in GUI and CLI modes.

## [3.7.8] - 2016-10-25

### Added

- Ctrl+F5 hotkey now executes selected part of the script in Migration editor (or the entire script, if no text is selected).

### Changed

- Getting changes in the project editor now fills both of its tabs (Update Project and Update DB). Choosing a different DB schema source in one tab also changes it in the other one.
- Manual Dependencies Dialog performance has been improved. Object lists in this dialog now contain all DB objects.

## [3.7.5] - 2016-10-04

### Changed

- pgCodeKeeper editor interface has been improved and cleaned up.
- DB schema sources (dump files or items saved in DB Store) are now selected using a single dropdown.
- Manual connection parameters inputs have been removed to clean up interface and free screen real estate.
- Selected elements panel has been merged into search text field area to free screen real estate.
- Other minor corrections and performance improvements.

## [3.7.2] - 2016-09-20

### Added

- Option of opening pgCodeKeeper project editor by double clicking the «pgCodeKeeper project» item in Project Explorer has been added.

### Changed

- Build is no longer started for hidden files.
- Images handling has been improved, resource leak error has been eliminated.
- Receiving indexes via JDBC error has been eliminated.

## [3.7.0] - 2016-09-07

### Added

- Option to create markers of SQL syntax errors, detected by the parser, has been added. Errant files are marked in the project tree, errant places are underlined in pgCodeKeeper SQL editor (enable pgCodeKeeper SQL editor by clicking the file SQL — Open With — pgCodeKeeper SQL editor with a right mouse button). For updating markers in the project make sure that pgCodeKeeper builder is enabled (how to enable: click the project with a right mouse button — select pgCodeKeeper, then — Add builder).

### Changed

- pgCodeKeeper builder operation has been improved: frequent updating and smooth progress bar displaying.

## [3.6.2] - 2016-08-24

### Added

- Full support of PostgreSQL operators syntax has been added. For more information please visit: https://www.postgresql.org/docs/9.3/static/sql-syntax-lexical.html#SQL-SYNTAX-OPERATORS .
- Option of sending messages to the developers directly from the program has been implemented. To send messages use the pgCodeKeeper perspective in the Eclipse, choose the menu option pgCodeKeeper — Feedback.

### Changed

- Interface for working with DB connection data has been improved.

### Fixed

- The DB objects priviliges reading error has been fixed.
- Other fixes.

## [3.6.0] - 2016-08-12

### Changed

- Object dependencies storage method has been modified, which made it possible to add the object dependencies from the RULE statements.
- When generating migration script, the dependent columns indexes are now correctly taken into account.
- The cases of false differences display in stored procedures that return the jsonb type and in the tables using nextval with a value in double quotes as a default value have been updated.

### Fixed

- Parsing of type definitions with INTERNALLENGTH attribute has been fixed.

## [3.5.4] - 2016-06-25

### Added

- Clickthrough to types and domains has been implemented in the SQL editor, these objects have been also added to the Outline list in the Eclipse.

### Changed

- Altered privileges handling has been improved: REVOKE is generated explicitly for deleted GRANT.
- Loading via pg_dump is hidden by default (you can enable it in the settings).

### Fixed

- The objects random shuffling bug occurring in the project when reexporting has been fixed — now the object order in the table file is specified explicitly.

## [3.5.1] - 2016-05-18

### Added

- Support for PostgreSQL RULE objects
- You can copy saved set of elements in the form of the RegEx filter.

### Changed

- SQL parser rework, optimization and performance enhancements. Optimization estimates: parsing speed increased by a factor of 4, required memory reduced by a factor of 2.
- Optimized and refactored SQL parser. SELECT and expression parse rules were rewritten using left-recursion. Eliminated parsing ambiguities in these rules.
- SELECT dependences analyzer has been entirely rewritten.
- Reading of the compared DB sources is now done in parallel.
- Colour highlighting of the editor tabs is optional.
- Help has been updated.
- JDBC errors reports have been improved.

### Fixed

- Transition to the object definition in the SQL editor has been fixed.
- Other minor corrections, mostly related to the parser.

## [3.4.1] - 2016-04-29

### Added

- ORDER BY parsing has been added to the aggregate functions.

[Unreleased]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.14.2...HEAD
[10.14.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.14.1...v10.14.2
[10.14.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.14.0...v10.14.1
[10.14.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.13.0...v10.14.0
[10.13.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.12.0...v10.13.0
[10.12.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.11.0...v10.12.0
[10.11.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.10.0...v10.11.0
[10.10.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.9.0...v10.10.0
[10.9.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.8.0...v10.9.0
[10.8.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.7.1...v10.8.0
[10.7.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.7.0...v10.7.1
[10.7.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.6.0...v10.7.0
[10.6.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.5.0...v10.6.0
[10.5.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.4.0...v10.5.0
[10.4.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.3.1...v10.4.0
[10.3.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.3.0...v10.3.1
[10.3.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.2.0...v10.3.0
[10.2.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.1.0...v10.2.0
[10.1.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v10.0.0...v10.1.0
[10.0.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.14.0...v10.0.0
[9.14.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.13.2...v9.14.0
[9.13.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.13.1...v9.13.2
[9.13.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.13.0...v9.13.1
[9.13.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.12.0...v9.13.0
[9.12.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.11.0...v9.12.0
[9.11.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.10.0...v9.11.0
[9.10.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.9.0...v9.10.0
[9.9.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.8.0...v9.9.0
[9.8.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.7.0...v9.8.0
[9.7.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.6.0...v9.7.0
[9.6.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.5.1...v9.6.0
[9.5.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.5.0...v9.5.1
[9.5.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.4.3...v9.5.0
[9.4.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.4.2...v9.4.3
[9.4.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.4.1...v9.4.2
[9.4.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.4.0...v9.4.1
[9.4.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.3.0...v9.4.0
[9.3.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.2.0...v9.3.0
[9.2.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.1.0...v9.2.0
[9.1.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v9.0.0...v9.1.0
[9.0.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v8.9.0...v9.0.0
[8.9.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v8.8.0...v8.9.0
[8.8.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v8.7.0...v8.8.0
[8.7.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v8.6.0...v8.7.0
[8.6.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v8.5.0...v8.6.0
[8.5.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v8.4.0...v8.5.0
[8.4.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v8.3.0...v8.4.0
[8.3.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v8.2.0...v8.3.0
[8.2.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v8.1.0...v8.2.0
[8.1.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v8.0.0...v8.1.0
[8.0.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v7.6.0...v8.0.0
[7.6.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v7.5.0...v7.6.0
[7.5.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v7.4.0...v7.5.0
[7.4.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v7.3.0...v7.4.0
[7.3.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v7.2.0...v7.3.0
[7.2.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v7.1.0...v7.2.0
[7.1.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v7.0.1...v7.1.0
[7.0.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v7.0.0...v7.0.1
[7.0.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v6.6.0...v7.0.0
[6.6.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v6.5.3...v6.6.0
[6.5.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v6.5.2...v6.5.3
[6.5.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v6.5.1...v6.5.2
[6.5.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v6.5.0...v6.5.1
[6.5.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v6.4.3...v6.5.0
[6.4.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v6.4.2...v6.4.3
[6.4.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v6.4.1...v6.4.2
[6.4.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v6.4.0...v6.4.1
[6.4.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v6.3.3...v6.4.0
[6.3.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v6.3.2...v6.3.3
[6.3.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v6.3.1...v6.3.2
[6.3.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v6.3.0...v6.3.1
[6.3.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v6.2.0...v6.3.0
[6.2.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v6.1.0...v6.2.0
[6.1.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v6.0.0...v6.1.0
[6.0.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.11.3...v6.0.0
[5.11.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.11.2...v5.11.3
[5.11.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.11.1...v5.11.2
[5.11.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.11.0...v5.11.1
[5.11.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.10.8...v5.11.0
[5.10.8]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.10.7...v5.10.8
[5.10.7]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.10.6...v5.10.7
[5.10.6]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.10.5...v5.10.6
[5.10.5]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.10.4...v5.10.5
[5.10.4]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.10.3...v5.10.4
[5.10.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.10.2...v5.10.3
[5.10.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.10.1...v5.10.2
[5.10.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.10.0...v5.10.1
[5.10.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.9.14...v5.10.0
[5.9.14]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.9.13...v5.9.14
[5.9.13]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.9.12...v5.9.13
[5.9.12]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.9.11...v5.9.12
[5.9.11]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.9.10...v5.9.11
[5.9.10]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.9.9...v5.9.10
[5.9.9]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.9.8...v5.9.9
[5.9.8]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.9.7...v5.9.8
[5.9.7]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.9.6...v5.9.7
[5.9.6]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.9.5...v5.9.6
[5.9.5]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.9.4...v5.9.5
[5.9.4]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.9.3...v5.9.4
[5.9.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.9.2...v5.9.3
[5.9.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.9.1...v5.9.2
[5.9.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.9.0...v5.9.1
[5.9.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.8.3...v5.9.0
[5.8.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.8.2...v5.8.3
[5.8.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.8.1...v5.8.2
[5.8.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.8.0...v5.8.1
[5.8.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.7.0...v5.8.0
[5.7.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.6.1...v5.7.0
[5.6.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.6.0...v5.6.1
[5.6.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.5.3...v5.6.0
[5.5.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.5.2...v5.5.3
[5.5.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.5.1...v5.5.2
[5.5.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.5.0...v5.5.1
[5.5.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.4.10...v5.5.0
[5.4.10]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.4.9...v5.4.10
[5.4.9]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.4.8...v5.4.9
[5.4.8]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.4.7...v5.4.8
[5.4.7]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.4.6...v5.4.7
[5.4.6]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.4.5...v5.4.6
[5.4.5]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.4.4...v5.4.5
[5.4.4]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.4.3...v5.4.4
[5.4.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.4.2...v5.4.3
[5.4.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.4.1...v5.4.2
[5.4.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.4.0...v5.4.1
[5.4.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.3.9...v5.4.0
[5.3.9]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.3.8...v5.3.9
[5.3.8]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.3.7...v5.3.8
[5.3.7]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.3.6...v5.3.7
[5.3.6]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.3.5...v5.3.6
[5.3.5]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.3.4...v5.3.5
[5.3.4]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.3.3...v5.3.4
[5.3.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.3.2...v5.3.3
[5.3.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.3.1...v5.3.2
[5.3.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.3.0...v5.3.1
[5.3.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.2.1...v5.3.0
[5.2.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.2.0...v5.2.1
[5.2.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.1.7...v5.2.0
[5.1.7]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.1.6...v5.1.7
[5.1.6]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.1.5...v5.1.6
[5.1.5]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.1.4...v5.1.5
[5.1.4]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.1.3...v5.1.4
[5.1.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.1.2...v5.1.3
[5.1.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.1.1...v5.1.2
[5.1.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.1.0...v5.1.1
[5.1.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.0.3...v5.1.0
[5.0.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.0.2...v5.0.3
[5.0.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.0.1...v5.0.2
[5.0.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v5.0.0...v5.0.1
[5.0.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.6.1...v5.0.0
[4.6.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.6.0...v4.6.1
[4.6.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.5.3...v4.6.0
[4.5.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.5.2...v4.5.3
[4.5.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.5.1...v4.5.2
[4.5.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.5.0...v4.5.1
[4.5.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.4.0...v4.5.0
[4.4.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.3.4...v4.4.0
[4.3.4]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.3.3...v4.3.4
[4.3.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.3.2...v4.3.3
[4.3.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.3.1...v4.3.2
[4.3.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.3.0...v4.3.1
[4.3.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.2.3...v4.3.0
[4.2.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.2.2...v4.2.3
[4.2.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.2.1...v4.2.2
[4.2.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.1.3...v4.2.1
[4.1.3]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.1.2...v4.1.3
[4.1.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.1.0...v4.1.2
[4.1.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v4.0.0...v4.1.0
[4.0.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v3.11.0...v4.0.0
[3.11.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v3.10.0...v3.11.0
[3.10.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v3.8.6...v3.10.0
[3.8.6]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v3.8.4...v3.8.6
[3.8.4]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v3.8.0...v3.8.4
[3.8.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v3.7.8...v3.8.0
[3.7.8]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v3.7.5...v3.7.8
[3.7.5]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v3.7.2...v3.7.5
[3.7.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v3.7.0...v3.7.2
[3.7.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v3.6.2...v3.7.0
[3.6.2]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v3.6.0...v3.6.2
[3.6.0]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v3.5.4...v3.6.0
[3.5.4]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v3.5.1...v3.5.4
[3.5.1]: https://github.com/pgcodekeeper/pgcodekeeper/compare/v3.4.1...v3.5.1
[3.4.1]: https://github.com/pgcodekeeper/pgcodekeeper/releases/tag/v3.4.1
