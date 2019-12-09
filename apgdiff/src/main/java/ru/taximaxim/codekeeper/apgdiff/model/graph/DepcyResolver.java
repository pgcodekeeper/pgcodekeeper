package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;

import cz.startnet.utils.pgdiff.schema.AbstractColumn;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.AbstractTable;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsTable;
import cz.startnet.utils.pgdiff.schema.MsView;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.SourceStatement;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import cz.startnet.utils.pgdiff.schema.TypedPgTable;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Служит для отслеживания зависимостей, при этом старое состояние хранится в
 * oldDb, a новое состояние в newDb, и требуется список объектов для удаления
 * или создания при приведении состояния из старого в новое.
 */
public class DepcyResolver {

    private final PgDatabase oldDb;
    private final PgDatabase newDb;
    private final DepcyGraph oldDepcyGraph;
    private final DepcyGraph newDepcyGraph;
    private final Set<ActionContainer> actions = new LinkedHashSet<>();
    private final Set<PgStatement> toRefresh = new LinkedHashSet<>();
    /**
     * Хранит запущенные итерации, используется для предотвращения циклического прохода по графу
     */
    private final Set<Entry<PgStatement, StatementActions>> sKippedObjects = new HashSet<>();

    /**
     * Добавить ручную зависимость к старому графу
     * @param depcies ручная зависимость
     */
    public void addCustomDepciesToOld(
            List<Entry<PgStatement, PgStatement>> depcies) {
        oldDepcyGraph.addCustomDepcies(depcies);
    }

    /**
     * Добавить ручную зависимость к новому графу
     * @param depcies ручная зависимость
     */
    public void addCustomDepciesToNew(
            List<Entry<PgStatement, PgStatement>> depcies) {
        newDepcyGraph.addCustomDepcies(depcies);
    }

    public Set<ActionContainer> getActions() {
        return Collections.unmodifiableSet(actions);
    }

    /**
     * @return ordered Set of statements to refresh in reverse order
     */
    public Set<PgStatement> getToRefresh() {
        return Collections.unmodifiableSet(toRefresh);
    }

    public DepcyResolver(PgDatabase oldDatabase, PgDatabase newDatabase) {
        this.oldDb = oldDatabase;
        this.newDb = newDatabase;
        this.oldDepcyGraph = new DepcyGraph(oldDatabase);
        this.newDepcyGraph = new DepcyGraph(newDatabase);
    }

    /**
     * При удалении объекта из старой базы добавляет для удаления все объекты из
     * старой базы. <br>
     * Объекта не существует в новой базе, но существует в старой, мы его
     * удаляем, и удаляем из старой базы все объекты, которым этот объект
     * требуется, т.к. они будут ошибочны, при отсутсвии этого объекта.
     *
     * @param toDrop
     *            объект для удаления из старой базы
     */
    public void addDropStatements(PgStatement toDrop) {
        PgStatement statement = toDrop.getTwin(oldDb);
        Entry<PgStatement, StatementActions> guard = new SimpleEntry<>(statement, StatementActions.DROP);
        if (oldDepcyGraph.getReversedGraph().containsVertex(statement) && sKippedObjects.add(guard)) {
            DepthFirstIterator<PgStatement, DefaultEdge> dfi = new DepthFirstIterator<>(
                    oldDepcyGraph.getReversedGraph(), statement);
            customIteration(dfi, new DropTraversalAdapter(statement));

            if (!statement.canDrop()) {
                customIteration(new DepthFirstIterator<>(oldDepcyGraph.getGraph(), statement),
                        new CannotDropTraversalListener(statement));
            }
        }
    }

    /**
     * При создании объекта в новой базе добавляет для создания все объекты из
     * новой базы. <br>
     * Объект существует в новой базе, но не существует в старой, мы его
     * создаем, а также добавляем для создания все объекты, которые трубуются
     * для правильной работы создаваемого объекта.
     *
     * @param toCreate
     */
    public void addCreateStatements(PgStatement toCreate) {
        PgStatement statement = toCreate.getTwin(newDb);
        Entry<PgStatement, StatementActions> guard = new SimpleEntry<>(statement, StatementActions.CREATE);
        if (newDepcyGraph.getGraph().containsVertex(statement) && sKippedObjects.add(guard)) {
            DepthFirstIterator<PgStatement, DefaultEdge> dfi = new DepthFirstIterator<>(
                    newDepcyGraph.getGraph(), statement);
            customIteration(dfi, new CreateTraversalAdapter(statement));
        }
    }

    /**
     * Добавить выражение для изменения объекта
     * @param oldObj исходный объект
     * @param newObj новый объект
     */
    public void addAlterStatements(PgStatement oldObj, PgStatement newObj) {
        PgStatement oldObjStat = oldObj.getTwin(oldDb);
        PgStatement newObjStat = newObj.getTwin(newDb);
        StringBuilder sb = new StringBuilder();
        AtomicBoolean isNeedDepcies = new AtomicBoolean();
        boolean isChanged = (oldObjStat != null && oldObjStat.appendAlterSQL(newObjStat, sb, isNeedDepcies));

        if (isChanged) {
            if (isNeedDepcies.get()) {
                // is state alterable (sb.length() > 0)
                // is checked in the depcy tracker in this case
                addDropStatements(oldObjStat);
            } else if (!inDropsList(oldObjStat)
                    && (oldObjStat.getStatementType() != DbObjType.COLUMN
                    || !inDropsList(oldObjStat.getParent()))) {
                // объект будет пересоздан ниже в новом состоянии, поэтому
                // ничего делать не нужно
                // пропускаем колонки таблиц из дроп листа
                addToListWithoutDepcies(
                        sb.length() > 0 ? StatementActions.ALTER : StatementActions.DROP,
                                oldObjStat, null);
            }
        }

        // if no depcies were triggered for a MsTable alter
        // check for column layout changes and refresh views
        if (!isNeedDepcies.get() &&
                oldObjStat instanceof MsTable && newObjStat instanceof MsTable) {
            MsTable tOld = (MsTable) oldObjStat;
            MsTable tNew = (MsTable) newObjStat;
            List<AbstractColumn> cOld = tOld.getColumns();
            List<AbstractColumn> cNew = tNew.getColumns();

            // first check for columns added or removed
            boolean colLayoutChanged = cOld.size() != cNew.size();
            if (!colLayoutChanged) {
                // second, columns replaced or reordered
                for (int i = 0; i < cOld.size(); ++i) {
                    if (!cOld.get(i).getName().equals(cNew.get(i).getName())) {
                        colLayoutChanged = true;
                        break;
                    }
                }
            }
            if (colLayoutChanged) {
                customIteration(new DepthFirstIterator<>(oldDepcyGraph.getReversedGraph(), tOld),
                        new RefreshTableDeps());
            }
        }
    }

    /**
     * Пересоздает ранее удаленные объекты в новое состояние
     */
    public void recreateDrops() {
        int oldActionsSize = -1;
        List<PgStatement> toRecreate = new ArrayList<>();
        // since a recreate can trigger a drop via  dependency being altered
        // run recreates until no more statements are being added (may need optimization)
        while (actions.size() > oldActionsSize) {
            toRecreate.clear();
            oldActionsSize = actions.size();
            for (ActionContainer action : actions) {
                if (action.getAction() == StatementActions.DROP) {
                    toRecreate.add(action.getOldObj());
                }
            }
            for (PgStatement drop : toRecreate) {
                PgStatement newSt = drop.getTwin(newDb);
                if (newSt != null) {
                    // add views to emit refreshes
                    // others are to block drop+create pairs for unchanged statements
                    if (newSt instanceof SourceStatement && newSt.equals(drop)) {
                        toRefresh.add(newSt);
                    }

                    addCreateStatements(drop);
                }
            }
        }
    }

    /**
     * Проходит по итератору и заполняет список объектами из итератора
     *
     * @param dfi
     *            итератор для прохода
     * @param action
     *            список объектов из итератора
     */
    private void customIteration(
            DepthFirstIterator<PgStatement, DefaultEdge> dfi,
            TraversalListenerAdapter<PgStatement, DefaultEdge> adapter) {
        dfi.addTraversalListener(adapter);
        while (dfi.hasNext()) {
            dfi.next();
        }
    }

    /**
     * Проверяет есть ли объект в списке ранее удаленных объектов
     * @param statement объект для проверки
     * @return
     */
    private boolean inDropsList(PgStatement statement) {
        // если овнедбай колонка или таблица уже в дроплисте
        // то сиквенс тоже неявно с ними дропнут, возвращаем true
        if (statement instanceof PgSequence) {
            PgSequence seq = (PgSequence) statement;
            GenericColumn ownedBy = seq.getOwnedBy();
            if (ownedBy != null) {
                PgStatement column = ownedBy.getStatement(oldDb);
                return column != null && (inDropsList(column) || inDropsList(column.getParent()));
            }
        }

        PgStatement oldObj = statement.getTwin(oldDb);
        return actions.contains(new ActionContainer(oldObj, oldObj, StatementActions.DROP, null));
    }

    /**
     * Добавляет в список выражений для скрипта Выражение без зависимостей
     *
     * @param action Какое действие нужно вызвать {@link StatementActions}
     * @param oldObj Объект из старого состояния
     * @param starter объект который вызвал действие
     */
    private void addToListWithoutDepcies(StatementActions action,
            PgStatement oldObj, PgStatement starter) {
        switch (action) {
        case CREATE:
        case DROP:
            actions.add(new ActionContainer(oldObj, oldObj, action, starter));
            break;
        case ALTER:
            actions.add(new ActionContainer(oldObj, oldObj.getTwin(newDb), action, starter));
            break;
        default:
            throw new IllegalStateException("Not implemented action");
        }
    }

    /**
     * Используется для прохода по графу зависимостей для формирования
     * зависимостей (ALTER, DROP)
     */
    private class DropTraversalAdapter extends CustomTraversalListenerAdapter {

        DropTraversalAdapter(PgStatement starter) {
            super(starter, StatementActions.DROP);
        }

        @Override
        protected boolean notAllowedToAdd(PgStatement oldObj) {
            // Изначально будем удалять объект
            action = StatementActions.DROP;

            PgStatement newObj = oldObj.getTwin(newDb);
            if (newObj != null) {
                AtomicBoolean isNeedDepcies = new AtomicBoolean();
                action = askAlter(oldObj, newObj, isNeedDepcies);

                // проверить а не
                // требует ли пересоздания(Drop/create) родителькие объекты
                IsDropped iter = new IsDropped();
                customIteration(new DepthFirstIterator<>(oldDepcyGraph.getGraph(),
                        oldObj), iter);
                if (iter.needDrop != null && iter.needDrop != oldObj) {
                    action = StatementActions.DROP;
                }

                if (action == StatementActions.NONE) {
                    return true;
                }
                // в случае необходимости изменения (ALter) объекта с
                // зависимостями нужно сначала создать объект с зависимостями,
                // потом изменить его
                if (isNeedDepcies.get() && action == StatementActions.ALTER) {
                    addCreateStatements(newObj);
                    addToList(oldObj);
                    return true;
                }
            }

            // Колонки пропускаются при удалении таблицы
            if (oldObj.getStatementType() == DbObjType.COLUMN) {
                AbstractTable oldTable = (AbstractTable) oldObj.getParent();
                PgStatement newTable = oldObj.getParent().getTwin(newDb);

                if (newTable == null || oldTable.isRecreated((AbstractTable) newTable)) {
                    // случай, если дроп зависимости тянет колонку, которую мы не пишем
                    // потому что дропается таблица - дропаем таблицу
                    addDropStatements(oldTable);
                    return true;
                }

                // пропускаем также при recreate
                StringBuilder sb = new StringBuilder();
                if (oldTable.appendAlterSQL(newTable, sb, new AtomicBoolean())
                        && sb.length() == 0) {
                    return true;
                }

                // пропускать колонки при смене типа таблицы
                if (!oldTable.getClass().equals(newTable.getClass())) {
                    return true;
                }

                // пропускаем колонки типизированных таблиц, если изменился тип
                if (oldTable instanceof TypedPgTable &&
                        !Objects.equals(((TypedPgTable)oldTable).getOfType(),
                                ((TypedPgTable)newTable).getOfType())) {
                    return true;
                }
            }

            // пропускаем сиквенс, если дропается его овнедбай
            // сиквенс дропнется неявно вместе с колонкой
            if (oldObj instanceof PgSequence) {
                PgSequence seq = (PgSequence) oldObj;
                GenericColumn ownedBy = seq.getOwnedBy();
                if (ownedBy != null && ownedBy.getStatement(newDb) == null) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Используется для прохода по графу зависимостей для формирования
     * зависимостей (CREATE)
     */
    private class CreateTraversalAdapter extends CustomTraversalListenerAdapter {

        CreateTraversalAdapter(PgStatement starter) {
            super(starter, StatementActions.CREATE);
        }

        @Override
        protected boolean notAllowedToAdd(PgStatement newObj) {
            // Изначально будем создавать объект
            action = StatementActions.CREATE;
            if (inDropsList(newObj)) {
                // always create if droppped before
                createColumnDependencies(newObj);
                return false;
            }

            if (newObj.getStatementType() == DbObjType.COLUMN) {
                PgStatement oldTable = newObj.getParent().getTwin(oldDb);
                AbstractTable newTable = (AbstractTable) newObj.getParent();
                if (oldTable == null || ((AbstractTable)oldTable).isRecreated(newTable)) {
                    // columns are integrated into CREATE TABLE
                    return true;
                }

                // columns are integrated into CREATE TABLE OF TYPE
                if (newTable instanceof TypedPgTable) {
                    TypedPgTable newTypedTable = (TypedPgTable) newTable;
                    TypedPgTable oldTypedTable = (TypedPgTable) oldTable;
                    if (!Objects.equals(newTypedTable.getOfType(),
                            oldTypedTable.getOfType())) {
                        return true;
                    }
                }

                // пропускать колонки при смене типа таблицы
                if (!oldTable.getClass().equals(newTable.getClass())) {
                    return true;
                }
            }

            PgStatement oldObj;
            if ((oldObj = newObj.getTwin(oldDb)) != null) {
                AtomicBoolean isNeedDepcies = new AtomicBoolean();
                action = askAlter(oldObj, newObj, isNeedDepcies);
                if (action == StatementActions.NONE) {
                    return true;
                }
                // в случае изменения объекта с зависимостями
                if (isNeedDepcies.get()) {
                    addDropStatements(oldObj);
                    if (action == StatementActions.ALTER) {
                        // add alter for old object
                        addToList(oldObj);
                        return true;
                    }
                }
            }

            // если объект (таблица) создается, запускаем создание зависимостей ее колонок
            // сами колонки создадутся неявно вместе с таблицей
            createColumnDependencies(newObj);

            // создать колонку при создании сиквенса с owned by
            if (newObj instanceof PgSequence) {
                PgSequence seq = (PgSequence) newObj;
                GenericColumn ownedBy = seq.getOwnedBy();
                if (ownedBy != null && ownedBy.getStatement(oldDb) == null) {
                    PgStatement col = ownedBy.getStatement(newDb);
                    if (col != null) {
                        addCreateStatements(col);
                    }
                }
            }

            return false;
        }

        private void createColumnDependencies(PgStatement newObj) {
            if (newObj.getStatementType() == DbObjType.TABLE) {
                // create column dependencies before table
                for (AbstractColumn col : ((AbstractTable) newObj).getColumns()) {
                    addCreateStatements(col);
                }
            }
        }
    }
    /**
     * Используется для прохода по графу зависимостей, содержит общие методы
     */
    private abstract class CustomTraversalListenerAdapter extends
    TraversalListenerAdapter<PgStatement, DefaultEdge> {

        protected PgStatement starter;
        /**
         * меняется в {@link #notAllowedToAdd(PgStatement)} для вызова
         * добавления в список с правильным действием
         */
        protected StatementActions action;

        CustomTraversalListenerAdapter(PgStatement starter,
                StatementActions action) {
            this.starter = starter;
            this.action = action;
        }

        @Override
        public void vertexFinished(VertexTraversalEvent<PgStatement> e) {
            PgStatement statement = e.getVertex();
            if (statement.getStatementType() != DbObjType.DATABASE && !notAllowedToAdd(statement)) {
                addToList(statement);
            }
        }

        protected abstract boolean notAllowedToAdd(PgStatement statement);

        protected void addToList(PgStatement statement) {
            addToListWithoutDepcies(action, statement, starter);
        }

        protected StatementActions askAlter(PgStatement oldSt, PgStatement newSt,
                AtomicBoolean isNeedDepcies) {
            StringBuilder sb = new StringBuilder();
            StatementActions alterAction = action;
            // Проверяем меняется ли объект
            if (oldSt.appendAlterSQL(newSt, sb, isNeedDepcies)) {
                if (sb.length() > 0) {
                    alterAction = StatementActions.ALTER;
                }
            } else {
                alterAction = StatementActions.NONE;
            }
            return alterAction;
        }
    }

    private class IsDropped extends TraversalListenerAdapter<PgStatement, DefaultEdge> {
        private PgStatement needDrop;

        @Override
        public void vertexFinished(VertexTraversalEvent<PgStatement> e) {
            if (needDrop != null) {
                return;
            }
            PgStatement oldSt = e.getVertex();
            PgStatement newSt = oldSt.getTwin(newDb);
            if (newSt == null) {
                if (oldSt.getStatementType() == DbObjType.FUNCTION && oldSt.isPostgres()
                        && isDefaultsOnlyChange((AbstractFunction) oldSt)) {
                    // when function's signature changes it has no twin
                    // but the dependent object might be unchanged
                    // due to default arguments changing in the signature
                    needDrop = oldSt;
                }
                return;
            }
            AtomicBoolean isNeedDepcy = new AtomicBoolean();
            if (oldSt.appendAlterSQL(newSt, new StringBuilder(), isNeedDepcy) && isNeedDepcy.get()) {
                needDrop = oldSt;
            }
        }

        private boolean isDefaultsOnlyChange(AbstractFunction oldFunc) {
            AbstractSchema newSchema = newDb.getSchema(oldFunc.getSchemaName());
            if (newSchema == null) {
                return false;
            }

            // in the new database, search the function for which
            // the signature before first default argument will be the same
            // if there is such, then the drop is necessary,
            // if there is no such, then the drop is not necessary

            Function<AbstractFunction, List<Argument>> argsBeforeDefaults = f -> {
                List<Argument> args = f.getArguments();
                OptionalInt firstDefault = IntStream.range(0, args.size())
                        .filter(i -> args.get(i).getDefaultExpression() != null)
                        .findFirst();
                return firstDefault.isPresent() ? args.subList(0, firstDefault.getAsInt()) : args;
            };

            List<Argument> oldArgs = argsBeforeDefaults.apply(oldFunc);

            return newSchema.getFunctions().stream()
                    .filter(f -> oldFunc.getBareName().equals(f.getBareName()))
                    .map(argsBeforeDefaults)
                    .anyMatch(oldArgs::equals);
        }
    }

    private class RefreshTableDeps extends TraversalListenerAdapter<PgStatement, DefaultEdge> {

        @Override
        public void vertexFinished(VertexTraversalEvent<PgStatement> e) {
            PgStatement st = e.getVertex();
            if (st instanceof MsView && st.getTwin(newDb) != null) {
                toRefresh.add(st);
            }
        }
    }

    private class CannotDropTraversalListener extends CustomTraversalListenerAdapter {

        public CannotDropTraversalListener(PgStatement starter) {
            super(starter, StatementActions.DROP);
        }

        @Override
        public void vertexFinished(VertexTraversalEvent<PgStatement> e) {
            PgStatement st = e.getVertex();
            // dependencies between partition indices
            if (st instanceof PgIndex && starter instanceof PgIndex) {
                addToListWithoutDepcies(action, st, starter);
                addDropStatements(st);
            }
        }

        @Override
        protected boolean notAllowedToAdd(PgStatement statement) {
            // unused
            return false;
        }
    }
}
