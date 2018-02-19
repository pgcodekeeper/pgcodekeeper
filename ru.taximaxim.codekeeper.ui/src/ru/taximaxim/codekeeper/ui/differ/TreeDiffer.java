package ru.taximaxim.codekeeper.ui.differ;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcLoader;
import cz.startnet.utils.pgdiff.loader.timestamps.DBTimestamp;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PG_EDIT_PREF;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.editors.ProjectEditorDiffer;
import ru.taximaxim.codekeeper.ui.fileutils.FileUtilsUi;
import ru.taximaxim.codekeeper.ui.localizations.Messages;
import ru.taximaxim.codekeeper.ui.pgdbproject.PgDbProject;

/**
 * строит дерево сравнения из двух баз
 */
public abstract class TreeDiffer implements IRunnableWithProgress {

    protected static final int JOB_CHECK_MS = 20;

    protected final DbSource dbSource;
    protected DbSource dbTarget;
    protected final boolean needTwoWay;
    private final String name;

    protected DBTimestamp dbTime;

    protected TreeElement diffTree;
    protected TreeElement diffTreeRevert;

    public DbSource getDbSource() {
        return dbSource;
    }

    public DbSource getDbTarget() {
        return dbTarget;
    }

    public DBTimestamp getDbTime() {
        return dbTime;
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

    public String getName() {
        return name;
    }

    public TreeDiffer(DbSource dbSource, DbSource dbTarget, boolean needTwoWay, String name) {
        this.dbSource = dbSource;
        this.dbTarget = dbTarget;
        this.needTwoWay = needTwoWay;
        this.name = name;
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
     * @param proj - current project. Source for project DbSource
     * @param remote - DbInfo or File. Source for remote DbSource
     * @param charset - project charset
     * @param forceUnixNewlines - project pref for forceUnixNewlines
     * @param mainPrefs - mainPrefs
     * @param timezone - project timezone
     * @return created tree
     */
    public static TreeDiffer getTree(PgDbProject proj, Object remote,
            String charset, boolean forceUnixNewlines, IPreferenceStore mainPrefs, String timezone) {

        String name;
        DbSource dbTarget = null;
        String schema = null;
        Path path = null;
        if (remote instanceof DbInfo) {
            DbInfo dbInfo = (DbInfo) remote;
            name = dbInfo.getName();
            if (mainPrefs.getBoolean(PG_EDIT_PREF.SHOW_DB_USER)) {
                try {
                    path = FileUtilsUi.getPathToTimeObject(proj.getProjectName(),
                            name, PgDiffUtils.shaString(dbInfo.toString()));
                } catch (URISyntaxException e) {
                    Log.log(Log.LOG_ERROR, "Error reading project timestamps", e);
                }

                schema = JdbcLoader.getExtensionSchema(dbInfo.getDbHost(),
                        dbInfo.getDbPort(), dbInfo.getDbUser(), dbInfo.getDbPass(),
                        dbInfo.getDbName(), timezone);
            }
            if (schema == null) {
                dbTarget = DbSource.fromDbInfo(dbInfo, mainPrefs, forceUnixNewlines,
                        charset, timezone);
            }
            ProjectEditorDiffer.saveLastDb(dbInfo, proj.getProject());
        } else {
            File file = (File) remote;
            name = file.getName();
            dbTarget = DbSource.fromFile(forceUnixNewlines, file, charset);
        }

        DbSource dbProj = DbSource.fromProject(proj, path);

        if (schema != null) {
            return new TimestampTreeDiffer(dbProj, (DbInfo) remote, schema, charset,
                    timezone, forceUnixNewlines, name, path);
        }

        return new ClassicTreeDiffer(dbProj, dbTarget, false, name);
    }
}