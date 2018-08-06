package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.NotDirectoryException;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.List;

import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;

public class MsModelExporter extends AbstractModelExporter {

    public MsModelExporter(File outDir, PgDatabase db, String sqlEncoding) {
        super(outDir, db, sqlEncoding);
    }

    public MsModelExporter(File outDir, PgDatabase newDb, PgDatabase oldDb,
            Collection<TreeElement> changedObjects, String sqlEncoding) {
        super(outDir, newDb, oldDb, changedObjects, sqlEncoding);
    }

    @Override
    public void exportFull() throws IOException {
        String[] dirs = new String[] { "Assemblies",
                "Sequences", "Security", "Stored Procedures", "Functions", "Tables", "Views"};

        if (outDir.exists()) {
            if (!outDir.isDirectory()) {
                throw new NotDirectoryException(outDir.getAbsolutePath());
            }

            for (String subdir : dirs) {
                if (new File(outDir, subdir).exists()) {
                    throw new DirectoryException(MessageFormat.format(
                            "Output directory already contains {0} directory.", subdir));
                }
            }
        } else if (!outDir.mkdirs()) {
            throw new DirectoryException(MessageFormat.format(
                    "Could not create output directory: {0}",
                    outDir.getAbsolutePath()));
        }


        for (String subdir : dirs) {
            File folder = new File(outDir, subdir);
            if (!folder.mkdir()) {
                throw new DirectoryException(MessageFormat.format(
                        "Could not create {0} folder: {1}", subdir,
                        folder.getAbsolutePath()));
            }
        }


        File securityFolder = new File(outDir, "Security");

        //TODO Security folder contains schemas, roles and users

        // exporting schemas
        File schemasSharedDir = new File(securityFolder, "Schemas");
        if (!schemasSharedDir.mkdir()) {
            throw new DirectoryException(MessageFormat.format(
                    "Could not create schemas directory: {0}",
                    schemasSharedDir.getAbsolutePath()));
        }

        // exporting schemas contents
        for (AbstractSchema schema : newDb.getSchemas()) {
            dumpSQL(getDumpSql(schema), new File(schemasSharedDir, getExportedFilenameSql(schema)));

            dumpFunctions(schema.getFunctions());
            dumpObjects(schema.getSequences(), new File(outDir, "Sequences"));
            dumpObjects(schema.getTables(), new File(outDir, "Tables"));
            dumpObjects(schema.getViews(), new File(outDir, "Views"));

            // indexes, triggers, rules, constraints are dumped when tables are processed
        }

        writeProjVersion(new File(outDir.getPath(),
                ApgdiffConsts.FILENAME_WORKING_DIR_MARKER));
    }

    private void dumpFunctions(List<AbstractFunction> funcs) throws IOException {
        for (PgStatementWithSearchPath obj : funcs) {
            String schemaName = getExportedFilename(obj.getContainingSchema());
            String objectName = getExportedFilenameSql(obj);

            String dirName = obj.getStatementType() == DbObjType.PROCEDURE ?
                    "Stored Procedures" : "Functions";

            File parentOutDir = new File(outDir, dirName);
            dumpSQL(getDumpSql(obj), new File(parentOutDir, schemaName + '.' + objectName));
        }
    }

    private void dumpObjects(List<? extends PgStatementWithSearchPath> objects,
            File parentOutDir) throws IOException {
        for (PgStatementWithSearchPath obj : objects) {
            String dump = getDumpSql(obj);
            if (obj.hasChildren()) {
                StringBuilder groupSql = new StringBuilder(dump);
                // only tables and views can be here
                obj.getChildren().map(st -> (PgStatementWithSearchPath)st).sorted(new ExportTableOrder())
                .forEach(st -> groupSql.append(GROUP_DELIMITER).append(getDumpSql(st)));
                dump = groupSql.toString();
            }

            String schemaName = getExportedFilename(obj.getContainingSchema());
            String objectName = getExportedFilenameSql(obj);

            dumpSQL(dump, new File(parentOutDir, schemaName + '.' + objectName));
        }
    }
}
