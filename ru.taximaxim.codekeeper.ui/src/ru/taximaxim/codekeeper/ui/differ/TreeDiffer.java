package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.operation.IRunnableWithProgress;

import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcQueries;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * строит дерево сравнения из двух баз
 */
public abstract class TreeDiffer implements IRunnableWithProgress {

    protected static final int JOB_CHECK_MS = 20;

    protected final DbSource dbSource;
    protected final DbSource dbTarget;
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

    public static TreeDiffer getTree(DbSource dbSource, DbSource dbTarget, boolean needTwoWay) {
        TreeDiffer tree = null;
        if (dbTarget instanceof DbSourceJdbc) {
            JdbcConnector connector = ((DbSourceJdbc) dbTarget).getJdbcConnector();
            try (Connection connection = connector.getConnection();
                    Statement statement = connection.createStatement();
                    ResultSet res = statement.executeQuery(JdbcQueries.QUERY_CHECK_TIMESTAMPS)) {
                while (res.next()) {
                    tree = new TimestampTreeDiffer(dbSource, dbTarget, res.getString("nspname"));
                }
            } catch (SQLException | IOException ex) {
                Log.log(Log.LOG_ERROR, Messages.TreeDiffer_schema_load_error, ex);
            }
        }

        return tree != null ? tree : new ClassicTreeDiffer(dbSource, dbTarget, needTwoWay);
    }
}