[![Apache 2.0](https://img.shields.io/github/license/cronn-de/jira-sync.svg)](http://www.apache.org/licenses/LICENSE-2.0)

# pgCodeKeeper

A tool for easier PostgreSQL and SQL Server development.

* Comparing database code is very easy now. Compare live DB instances, pg_dump output, as well as pgCodeKeeper projects.
* Generate migration scripts via a user-friendly interface. You can use both live DB instances and DB dumps as initial data. You can also compare pgCodeKeeper projects — useful when working with versions control systems.
* pgCodeKeeper is an <a href="http://www.eclipse.org/">Eclipse IDE</a> plug-in. The DB code is saved as an Eclipse project, and the project can be tracked under any of the versions control systems supported by Eclipse — Git, SVN, Mercurial, CVS and many others.

<a href="https://pgcodekeeper.org/github-images/main-view.png"><img src="https://pgcodekeeper.org/github-images/main-view.png" width="450"/></a>
<a href="https://pgcodekeeper.org/github-images/sql-editor.png"><img src="https://pgcodekeeper.org/github-images/sql-editor.png" width="450"></a>

## Download

pgCodeKeeper requires Java (JRE) 1.8+ to run.

You can download prebuilt binaries and CLI-version from <a href="https://github.com/pgcodekeeper/pgcodekeeper/releases">GitHub releases</a>.

If you already have installed version of Eclipse you can <a href="https://pgcodekeeper.readthedocs.io/en/latest/installation.html">install</a> pgCodeKeeper from Marketplace or `https://pgcodekeeper.org/update/` update site.

## Documentation

* <a href="https://pgcodekeeper.readthedocs.io/en/latest/">Wiki</a>
* <a href="https://github.com/pgcodekeeper/pgcodekeeper/issues">Issue tracker</a>

## Build

Build requires Java (JDK) 8+ and Apache Maven.

```sh
git clone https://github.com/pgcodekeeper/pgcodekeeper.git pgCodeKeeper
cd pgCodeKeeper
mvn package
```

Binaries are in `ru.taximaxim.codekeeper.mainapp/product/rcp/target/products`

CLI-version is in `ru.taximaxim.codekeeper.mainapp/product/standalone/target/products`

## Notes

- If you have any questions, suggestions, ideas, etc - <a href="mailto:codekeeper@pgcodekeeper.org">write us</a>.
- Pull requests are welcome.
- Visit https://pgcodekeeper.org for more information.
- Thanks for using pgCodeKeeper!

## Contribution

#### Project structure

- `apgdiff` - The package that is responsible for working with database structure, syntax parsing.
- `ru.taximaxim.codekeeper.cli` - The package that is responsible for working with the CLI version.
- `ru.taximaxim.codekeeper.ui` - The package that is responsible for working with the GUI components.
- `ru.taximaxim.codekeeper.mainapp` - Main package. Contains plug-in information, branding icons.
- `ru.taximaxim.codekeeper.mainapp/feature` - pgCodeKeeper feature.
- `ru.taximaxim.codekeeper.mainapp/product/rcp` - custom Eclipse product builder.
- `ru.taximaxim.codekeeper.mainapp/product/standalone` - pgCodeKeeper CLI version product builder.
- `ru.taximaxim.codekeeper.mainapp/updatesite` - pgCodeKeeper updatesite.
