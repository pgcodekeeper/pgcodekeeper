package ru.taximaxim.codekeeper.ui.differ;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcLoader;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * строит дерево сравнения из двух баз
 */
public abstract class TreeDiffer implements IRunnableWithProgress {

    protected static final int JOB_CHECK_MS = 20;

    protected final DbSource dbSource;
    protected DbSource dbTarget;
    protected final boolean needTwoWay;

    protected TreeElement diffTree;
    protected TreeElement diffTreeRevert;

    protected Stream<Object> errors = Stream.empty();

    public DbSource getDbSource() {
        return dbSource;
    }

    public DbSource getDbTarget() {
        return dbTarget;
    }

    public TreeElement getDiffTree() {
        if (diffTree == null) {
            throw new IllegalStateException(Messages.runnable_has_not_finished);
        }
        return diffTree;
    }

    public TreeElement getDiffTreeRevert() {
        if (diffTreeRevert == null) {
            throw new IllegalStateException(Messages.runnable_has_not_finished);
        }
        return diffTreeRevert;
    }

    public TreeDiffer(DbSource dbSource, DbSource dbTarget, boolean needTwoWay) {
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
        this.needTwoWay = needTwoWay;
    }

    public Stream<Object> getErrors() {
        errors = Stream.concat(errors, dbSource.getErrors().stream());
        if (dbTarget != null) {
            errors = Stream.concat(errors, dbTarget.getErrors().stream());
        }
        return errors;
    }

    protected void addError(Object error) {
        errors = Stream.concat(errors, Stream.of(error));
    }

    /**
     * Create db sources and generate tree differ
     *
     * @return created tree
     */
    public static TreeDiffer getTree(DbSource dbProj, DbInfo dbInfo, String charset,
            boolean forceUnixNewlines, IPreferenceStore prefs, String timezone) {
        String error = null;
        if (!prefs.getBoolean(PREF.PGDUMP_SWITCH) && prefs.getBoolean(PREF.USE_EXTENSION)) {
            try {
                Path timePath = FileUtilsUi.getPathToTimeObject(dbProj.getOrigin(),
                        dbInfo.getName(), PgDiffUtils.shaString(dbInfo.toString()));

                String extSchema = null;
                try {
                    extSchema = JdbcLoader.getExtensionSchema(dbInfo.getDbHost(),
                            dbInfo.getDbPort(), dbInfo.getDbUser(), dbInfo.getDbPass(),
                            dbInfo.getDbName(), dbInfo.getProperties(), dbInfo.isReadOnly(),
                            timezone);
                } catch (PgCodekeeperException e) {
                    error = e.getLocalizedMessage();
                }

                if (extSchema != null) {
                    return new TimestampTreeDiffer(dbProj, dbInfo, extSchema, charset,
                            timezone, forceUnixNewlines, timePath);
                }
            } catch (URISyntaxException e) {
                Log.log(Log.LOG_ERROR, "Error reading project timestamps", e); //$NON-NLS-1$
            }
        }

        DbSource dbTarget = DbSource.fromDbInfo(dbInfo, prefs, forceUnixNewlines,
                charset, timezone);


        TreeDiffer tree = new ClassicTreeDiffer(dbProj, dbTarget, false);
        if (error != null) {
            tree.addError(error);
        }
        return tree;
    }
}