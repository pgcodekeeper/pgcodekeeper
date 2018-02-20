package ru.taximaxim.codekeeper.ui.differ;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcLoader;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PG_EDIT_PREF;
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

    public List<Object> getErrors() {
        List<? super Object> errors = new ArrayList<>();
        errors.addAll(dbSource.getErrors());
        errors.addAll(dbTarget.getErrors());
        return errors;
    }

    /**
     * Create db sources and generate tree differ
     *
     * @return created tree
     */
    public static TreeDiffer getTree(DbSource dbProj, DbInfo dbInfo, String charset,
            boolean forceUnixNewlines, IPreferenceStore prefs, String timezone) {
        if (!prefs.getBoolean(PREF.PGDUMP_SWITCH) && prefs.getBoolean(PG_EDIT_PREF.SHOW_DB_USER)) {
            try {
                Path timePath = FileUtilsUi.getPathToTimeObject(dbProj.getOrigin(),
                        dbInfo.getName(), PgDiffUtils.shaString(dbInfo.toString()));

                String extSchema = JdbcLoader.getExtensionSchema(dbInfo.getDbHost(),
                        dbInfo.getDbPort(), dbInfo.getDbUser(), dbInfo.getDbPass(),
                        dbInfo.getDbName(), timezone);

                if (extSchema != null) {
                    return new TimestampTreeDiffer(dbProj, dbInfo, extSchema, charset,
                            timezone, forceUnixNewlines, timePath);
                }
            } catch (URISyntaxException e) {
                Log.log(Log.LOG_ERROR, "Error reading project timestamps", e);
            }
        }

        DbSource dbTarget = DbSource.fromDbInfo(dbInfo, prefs, forceUnixNewlines,
                charset, timezone);

        return new ClassicTreeDiffer(dbProj, dbTarget, false);
    }
}