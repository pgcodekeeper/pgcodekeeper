package ru.taximaxim.codekeeper.apgdiff.model.exporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgPrivilege;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DiffSide;

public class OverridesModelExporter extends AbstractModelExporter {

    private final boolean isMsSql;

    public OverridesModelExporter(Path outDir, PgDatabase newDb, PgDatabase oldDb,
            Collection<TreeElement> changedObjects, String sqlEncoding, boolean isMsSql) {
        super(outDir, newDb, oldDb, changedObjects, sqlEncoding);
        this.isMsSql = isMsSql;
    }

    @Override
    protected void createOutDir() throws IOException {
        throw new IllegalStateException();
    }

    @Override
    public void exportPartial() throws IOException, PgCodekeeperException {
        if (oldDb == null) {
            throw new PgCodekeeperException("Old database should not be null for partial export.");
        }
        if (Files.notExists(outDir) || !Files.isDirectory(outDir)) {
            throw new DirectoryException(MessageFormat.format(
                    "Output directory does not exist: {0}",
                    outDir.toAbsolutePath()));
        }

        List<PgStatement> toAdd = new ArrayList<>();
        List<PgStatement> toRemove = new ArrayList<>();
        Set<Path> paths = new HashSet<>();

        while (!changeList.isEmpty()) {
            TreeElement el = changeList.pop();
            if (el.getSide() == DiffSide.BOTH) {
                switch (el.getType()) {
                case CONSTRAINT:
                case INDEX:
                case TRIGGER:
                case RULE:
                case POLICY:
                case EXTENSION:
                case CAST:
                case COLUMN:
                    break;
                default:
                    PgStatement stInNew = el.getPgStatement(newDb);
                    PgStatement stInOld = el.getPgStatement(oldDb);
                    toAdd.add(stInNew);
                    toRemove.add(stInOld);
                    paths.add(getRelativeFilePath(stInNew, true));
                }
            }
        }

        List<PgStatement> list = oldDb.getDescendants().filter(st -> {
            Path path = getRelativeFilePath(st, true);
            return paths.contains(path) && Files.exists(outDir.resolve(path));
        }).collect(Collectors.toList());

        list.addAll(toAdd);
        for (PgStatement st : toAdd) {
            deleteStatementIfExists(st);
        }

        list.removeAll(toRemove);
        for (PgStatement st : toRemove) {
            deleteStatementIfExists(st);
        }

        Collections.sort(list, ExportTableOrder.INSTANCE);

        Map<Path, StringBuilder> dumps = new HashMap<>();
        list.forEach(st -> dumpStatement(st, dumps));

        for (Entry<Path, StringBuilder> dump : dumps.entrySet()) {
            dumpSQL(dump.getValue(), dump.getKey());
        }
    }

    @Override
    protected String getDumpSql(PgStatement st) {
        StringBuilder sb = new StringBuilder();
        Set<PgPrivilege> privs = st.getPrivileges();
        PgStatement.appendOwnerSQL(st, st.getOwner(), false, sb);
        PgPrivilege.appendPrivileges(privs, st.isPostgres(), sb);
        if (privs.isEmpty() && st.isPostgres()) {
            PgPrivilege.appendDefaultPrivileges(st, sb);
        }

        if (DbObjType.TABLE == st.getStatementType()) {
            for (AbstractColumn col : ((AbstractTable)st).getColumns()) {
                PgPrivilege.appendPrivileges(col.getPrivileges(), col.isPostgres(), sb);
            }
        }

        return sb.toString();
    }

    @Override
    protected Path getRelativeFilePath(PgStatement st, boolean addExtension) {
        if (isMsSql) {
            return MsModelExporter.getRelativeFilePath(
                    st, Paths.get(ApgdiffConsts.OVERRIDES_DIR), addExtension);
        }

        return ModelExporter.getRelativeFilePath(
                st, Paths.get(ApgdiffConsts.OVERRIDES_DIR), addExtension);
    }

}
