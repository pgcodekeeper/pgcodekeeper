package ru.taximaxim.codekeeper.ui.differ;

import java.io.IOException;
import java.nio.file.Path;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.JdbcLoader;
import cz.startnet.utils.pgdiff.loader.timestamps.DBTimestamp;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DiffTree;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.dbstore.DbInfo;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

/**
 * Builds a differ tree from two databases, taking into account the modification time of objects <br> <br>
 *
 * Алгоритм:
 * <ul>
 *      <li>Данное дерево создается при наличии расширения pg_dbo_timestamp {@link JdbcLoader#getExtensionSchema}
 *      и включенной настройки проекта <b>PG_EDIT_PREF.SHOW_DB_USER</b></li>
 *      <li>Чтение таймстампов из сериализованного объекта находящегося по пути FileUtilsUi#getPathToTimeObject </li>
 *      <li>Построение базы данных из проекта.
 *      <li>Запись таймстампов проекта внутрь объекта базы данных проекта
 *      <li>Удаление объектов, у которых не совпали хеши raw statement {@link DBTimestamp#updateObjects}
 *      <li>Чтение таймстампов из базы данных</li>
 *      <li>Запись таймстампов базы внутрь объекта сторонней базы данных
 *      <li>Сравнение полученных объектов по квалифицированным именам и формирование списка совпадающих объектов </li>
 *      <li>Исключение из запросов oid объектов из полученного списка JdbcReaderFactory.excludeObjects</li>
 *      <li>Чтение объектов из базы данных с подменой совпавших объектов из базы проекта JdbcReader.fillOldObjects </li>
 *      <li>Построение дерева различий с записью совпадающих объектов в список</li>
 *      <li>Сохранение в дерево таймстампов удаленной базы</li>
 *      <li>Формирование списка на основе полученного списка и таймстампов в базе данных</li>
 *      <li>Сериализация полученного списка</li>
 *      <li>Чтение авторов изменений DiffTableViewer.readDbUsers</li>
 * </ul>
 *
 */
public class TimestampTreeDiffer extends TreeDiffer {

    private final DbInfo dbInfo;
    private final String extSchema;
    private final String charset;
    private final boolean forceUnixNewlines;
    private final String timezone;
    private final Path path;

    public TimestampTreeDiffer(DbSource dbSource, DbInfo dbInfo, String extSchema,
            String charset, String timezone, boolean forceUnixNewlines, Path path) {
        // dbTarget will be created later
        super(dbSource, null, false);
        this.dbInfo = dbInfo;
        this.extSchema = extSchema;
        this.charset = charset;
        this.forceUnixNewlines = forceUnixNewlines;
        this.timezone = timezone;
        this.path = path;
    }

    @Override
    public void run(IProgressMonitor monitor) throws InterruptedException {
        SubMonitor pm = SubMonitor.convert(monitor,
                Messages.diffPresentationPane_getting_changes_for_diff, 100); // 0
        try {
            DBTimestamp projTimestamps = DBTimestamp.getDBTimestamp(path);

            synchronized (projTimestamps) {
                pm.newChild(30); // 30
                PgDatabase dbSrc = dbSource.get(pm);
                projTimestamps.updateObjects(dbSrc);
                dbSrc.setDbTimestamp(projTimestamps);

                pm.newChild(50); // 80
                dbTarget = DbSource.fromDbTimestamp(dbInfo, forceUnixNewlines, charset, timezone, dbSrc, extSchema);
                PgDatabase dbTgt = dbTarget.get(pm);

                Log.log(Log.LOG_INFO, "Generating diff tree between src: " + dbSource.getOrigin() //$NON-NLS-1$
                + " tgt: " + dbTarget.getOrigin()); //$NON-NLS-1$

                pm.newChild(15).subTask(Messages.treeDiffer_building_diff_tree); // 95

                DiffTree tree = new DiffTree();
                diffTree = tree.createTree(dbSrc, dbTgt, pm);

                if (false) {
                    projTimestamps.rewriteObjects(tree.getEqualsObjects(), dbTgt.getDbTimestamp());
                    ApgdiffUtils.serialize(path, projTimestamps);
                }
            }
        } catch (CoreException | IOException ex) {
            Log.log(Log.LOG_ERROR, Messages.TreeDiffer_schema_load_error, ex);
        }

        PgDiffUtils.checkCancelled(pm);
        monitor.done();
    }
}