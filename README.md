[![Apache 2.0](https://img.shields.io/github/license/pgcodekeeper/pgcodekeeper.svg)](http://www.apache.org/licenses/LICENSE-2.0)

# pgCodeKeeper

A tool for easier PostgreSQL development.

* Comparing database code is very easy now. Compare live DB instances, pg_dump output, as well as pgCodeKeeper projects.
* Generate migration scripts via a user-friendly interface. You can use both live DB instances and DB dumps as initial data. You can also compare pgCodeKeeper projects — useful when working with versions control systems.
* pgCodeKeeper is an [Eclipse IDE](http://www.eclipse.org) plug-in. The DB code is saved as an Eclipse project, and the project can be tracked under any of the versions control systems supported by Eclipse — Git, SVN, Mercurial, CVS and many others.

<a href="https://pgcodekeeper.org/github-images/main-view.png"><img src="https://pgcodekeeper.org/github-images/main-view.png" width="450"/></a>
<a href="https://pgcodekeeper.org/github-images/sql-editor.png"><img src="https://pgcodekeeper.org/github-images/sql-editor.png" width="450"></a>

## Download

pgCodeKeeper requires Java (JRE) 17+ to run.

If you already have Eclipse IDE installed you can [install](https://pgcodekeeper.readthedocs.io/en/latest/installation.html) pgCodeKeeper plugin using Marketplace or `https://pgcodekeeper.org/update/` update site.

## Documentation

* [User manual](https://pgcodekeeper.readthedocs.io/en/latest/)
* [Issue tracker](https://github.com/pgcodekeeper/pgcodekeeper/issues)

## Build

Build requires Java (JDK) 17+ and Apache Maven 3.9+.

```sh
git clone https://github.com/pgcodekeeper/pgcodekeeper.git
cd pgcodekeeper
mvn clean verify -DskipTests
```

Binaries will be created in `ru.taximaxim.codekeeper.mainapp/product/rcp/target/products`  

## Notes

- If you have any questions, suggestions, ideas, etc - contact us in our [Telegram chat](https://t.me/pgcodekeeper) or create an issue.
- Pull requests are welcome.
- Visit https://pgcodekeeper.org for more information.
- Thanks for using pgCodeKeeper!

## Contributing

### Project Structure

The project consists of several modules that implement Eclipse RCP plugins (and, by extension, OSGi bundles).

#### Main Modules

- `pom.xml` - first, root pom.xml defines Maven build order and environment. Not required for application development.
- `ru.taximaxim.codekeeper.ui` - GUI module, Eclipse integration.

#### Test Modules

- `ru.taximaxim.codekeeper.ui.tests` - tests for pieces of logic that were implemented in UI module instead of the core module.

#### Misc Modules

- `ru.taximaxim.codekeeper.mainapp` - "branding plugin", provides Eclipse with feature information, images, etc. Also contains development Target platform files.
- `ru.taximaxim.codekeeper.mainapp/report` - tests coverage report module.
- `ru.taximaxim.codekeeper.mainapp/feature` - Eclipse feature module.
- `ru.taximaxim.codekeeper.mainapp/updatesite` - Eclipse p2 repository/update site module.
- `ru.taximaxim.codekeeper.mainapp/product/rcp` - Eclipse product description, used to build pgCodeKeeper packages.
- `ru.taximaxim.codekeeper.mainapp/deploy` - GitHub deploy module.

### Module Contents

#### ru.taximaxim.codekeeper.ui

Majority of code in this module implements Eclipse integration, and also wraps core logic into a more UI-suitable forms.

- `plugin.xml` - main Eclipse integration file. All integration code is referenced from here.
- `ru.taximaxim.codekeeper.ui.editors` - main project editor and its supporting classes. Notable classes:
  - `ProjectEditorDiffer` - main project editor. Loads and compares databases, allows user to select changes and saves the into project or generates and diff script for the database.
- `ru.taximaxim.codekeeper.ui.differ` - classes for diff creation. Notable classes:
  - `DbSource` - an abstraction, factory, and implementations for various database loaders.
  - `TreeDiffer`, `Differ` - first creates a diff tree, second creates a diff script based on the tree and user selection.
  - `DiffTableViewer` - GUI element responsible for showing tree diff elements. Part of `ProjectEditorDiffer` separated for reuse in other UIs.
- `ru.taximaxim.codekeeper.ui.pgdbproject` - project classes and various project wizards (New, Import, etc). Notable classes:
  - `PgDbProject` - utility wrapper for Eclipse's `IProject`.
- `ru.taximaxim.codekeeper.ui.pgdbproject.parser` - UI-specific parts of database loaders. Notable classes:
  - `PgDbParser` - stores, serializes and updates project indices (object metadata and references).
  - `UIProjectLoader` - loads a database from project structure in Eclipse Workspace. **(!)** Keep in sync with `ProjectLoader`.
  - `PgUIDumpLoader` - loads objects into a database structure from an Eclipse's `IFile`. **(!)** Keep in sync with `PgDumpLoader`.
- `ru.taximaxim.codekeeper.ui.builders` - Project Builders launch project index updates (metadata, errors etc) when an IDE build is triggered.
- `ru.taximaxim.codekeeper.ui.sqledit` - SQL code editor. Notable classes:
  - `SQLEditorSourceViewerConfiguration` - main editor configuration class, ties in most other editor classes.
- `ru.taximaxim.codekeeper.ui.dbstore` - database connection storage and GUI selection classes. Notable classes:
  - `DbInfo` - database connection parameters.
- `ru.taximaxim.codekeeper.ui.handlers` - handlers for commands (IDE actions) registered with Eclipse in `plugin.xml`.
- `ru.taximaxim.codekeeper.ui.job` - singleton wrapper for Eclipse `Job`s.
- `ru.taximaxim.codekeeper.ui.dialogs` - various dialogs. Notable classes:
  - `ExceptionNotifier` - reports and logs errors using Eclipse's `StatusManager`.
- `ru.taximaxim.codekeeper.ui.externalcalls` - logic for calling external utilities (pg_dump etc).
- `ru.taximaxim.codekeeper.ui.generators` - value generator for dummy data generation wizard (`MockDataWizard`).
- `ru.taximaxim.codekeeper.ui.prefs` - Eclipse Preferences integration - global program settings.
- `ru.taximaxim.codekeeper.ui.properties` - per-project settings.
- `ru.taximaxim.codekeeper.ui.reports` - Google Analytics reports.
- `ru.taximaxim.codekeeper.ui.views` - views showing misc info. Notable classes:
  - `DepcyGraphView` - shows dependency graph for objects currently selected in Project Editor.
  - `ProjectOverrideView` - shows library objects overridden by the project in current Project Editor.
  - `ResultSetView` - shows rows returned by SELECT or other commands executed in a script in SQL Editor.
- `ru.taximaxim.codekeeper.ui.views.navigator` - Eclipse Project Explorer integration, see also `plugin.xml`
- `ru.taximaxim.codekeeper.ui` - main package containing general stuff: e.g. string constants, utils. Notable classes:
  - `UiSync` - exception safety wrapper around SWT's `Display.asyncExec()`. **(!)** Use this instead of calling `getDisplay().asyncExec()`.
  - `UIConsts` - majority of string IDs and other constants commonly used in UI.

#### ru.taximaxim.codekeeper.ui.tests

Majority of tests are here.

- `ru.taximaxim.codekeeper.ui.dbstore` - these test cases are generated url from the assumed state of DbInfo and the obtained result is compared with the expected one.
- `ru.taximaxim.codekeeper.ui.differ.filters` - these test cases check the operation of filters.
- `ru.taximaxim.codekeeper.ui.generators` - these test cases check the data generation.
- `ru.taximaxim.codekeeper.ui.pgdbproject.parser` - these test cases check deserializing.
- `ru.taximaxim.codekeeper.ui.reports` - these test cases check what returns UsageEvent.

Simple tests for core logic wrappers: `DbSource`, `Differ`, `ProjectUpdater`.

### Program Lifecycle

General program lifecycle goes as follows:
1. `ISettings` object is filled with operation parameters.
2. `AbstractDatabase`s are loaded from requested sources, including their libraries and privilege overrides. Ignored schemas are skipped at this step.
   1. During the load dependencies of each object are found and recorded. Expressions are also analyzed to extract their dependencies including overloaded function calls.
   2. All parser and expression analysis operations are run in parallel using `AntlrParser.ANTLR_POOL` thread pool to speed up the process. Parallel operations are serialized by calling `finishLoaders` at the end of each loading process.
3. The diff tree (represented by root `TreeElement`) is created by comparing two `AbstractDatabase`s. In GUI this is then shown to the user to assess the situation and choose objects to work with.
4. The diff tree, now containing "user selection", is used to selectively update project files on disk, or to generate a migration script.
5. In latter case, each "selected" TreeElement is passed to `DepcyResolver` to generate script actions fulfilling the requested change, including actions on dependent objects. To do this, JGraphT object dependency graphs are built using dependency information found at the loading stage.
6. Generated actions are now converted into SQL code with some last-moment post-processing and filtering.
7. Generated SQL script is written to a file/stdout or shown in the GUI for user to review and run on their database.
