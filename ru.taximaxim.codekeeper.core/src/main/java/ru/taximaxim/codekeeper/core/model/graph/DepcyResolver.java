/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.model.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.schema.AbstractColumn;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractFunction;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractTable;
import ru.taximaxim.codekeeper.core.schema.Argument;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IFunction;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SourceStatement;
import ru.taximaxim.codekeeper.core.schema.ms.AbstractMsFunction;
import ru.taximaxim.codekeeper.core.schema.ms.MsTable;
import ru.taximaxim.codekeeper.core.schema.ms.MsType;
import ru.taximaxim.codekeeper.core.schema.ms.MsView;
import ru.taximaxim.codekeeper.core.schema.pg.PgIndex;
import ru.taximaxim.codekeeper.core.schema.pg.PgSequence;
import ru.taximaxim.codekeeper.core.schema.pg.TypedPgTable;
import ru.taximaxim.codekeeper.core.script.SQLScript;

/*
 * implementation notes:
 *
 * General idea behind this class is graph passes that collect required actions.
 * addDropStatements starts a bottom-to-top pass in the old DB graph,
 * addCreateStatements starts a top-to-bottom pass in the new DB graph.
 * When these passes reach an object requiring an ALTER,
 * an "opposite direction" pass for that object is started.
 * This also allows us to treat alters as "drops" here.
 * Passes are eventually exhausted when all the actions have been collected
 * into actions set.
 *
 * At the very end recreateDrops is called, which starts a "create pass"
 * for every object that was dropped but should not have been -
 * i.e. it was a dependency related drop. These passes are performed until
 * they stop generating new actions. This ensures that all dropped dependencies
 * have been recreated, and any dependency drops that may have been generated in the process
 * have also been accounted for.
 *
 * This logic and many kludges around it are consequences of having to work with two graphs,
 * two object states (old and new) and having to generate action sequences for
 * object creates, drops and alters in the same script.
 *
 * TODO the better idea is to prepare a single graph containing not objects,
 * but *actions* and dependencies between these actions.
 * Theoretically, a simple topological sort will be enough to derive an action list from such a graph.
 * Hopefully someday this kludgy mess will be replaced by a more advanced algorithm.
 */
public final class DepcyResolver {

    private final AbstractDatabase oldDb;
    private final AbstractDatabase newDb;
    private final DepcyGraph oldDepcyGraph;
    private final DepcyGraph newDepcyGraph;
    private final Set<ActionContainer> actions = new LinkedHashSet<>();
    private final Set<PgStatement> toRefresh = new LinkedHashSet<>();
    /**
     * Хранит запущенные итерации по удалению объектов, используется для предотвращения циклического прохода по графу
     */
    private final Set<PgStatement> droppedObjects = new HashSet<>();
    /**
     * Хранит запущенные итерации по добавлению объектов, используется для предотвращения циклического прохода по графу
     */
    private final Set<PgStatement> createdObjects = new HashSet<>();

    /**
     * Stores the result of method appendAlterSQL. Key - Qualified name of
     * {@link PgStatement}, value - {@link ObjectState}
     */
    private final Map<String, ObjectState> states = new HashMap<>();

    private final Map<String, Boolean> recreatedObjs = new HashMap<>();

    public DepcyResolver(AbstractDatabase oldDatabase, AbstractDatabase newDatabase) {
        this.oldDb = oldDatabase;
        this.newDb = newDatabase;
        this.oldDepcyGraph = new DepcyGraph(oldDatabase);
        this.newDepcyGraph = new DepcyGraph(newDatabase);
    }

    /**
     * Добавить ручную зависимость к старому графу
     * @param depcies ручная зависимость
     */
    public void addCustomDepciesToOld(List<Entry<PgStatement, PgStatement>> depcies) {
        oldDepcyGraph.addCustomDepcies(depcies);
    }

    /**
     * Добавить ручную зависимость к новому графу
     * @param depcies ручная зависимость
     */
    public void addCustomDepciesToNew(List<Entry<PgStatement, PgStatement>> depcies) {
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

    /**
     * При удалении объекта из старой базы добавляет для удаления все объекты из старой базы. <br>
     * Объекта не существует в новой базе, но существует в старой, мы его удаляем. И удаляем из старой базы все объекты,
     * которым этот объект требуется, т.к. они будут ошибочны, при отсутсвии этого объекта.
     *
     * @param statement
     *            объект для удаления из старой базы
     */
    public void addDropStatements(PgStatement statement) {
        if (oldDepcyGraph.getReversedGraph().containsVertex(statement) && droppedObjects.add(statement)) {
            var dfi = new DepthFirstIterator<>(oldDepcyGraph.getReversedGraph(), statement);
            iterate(dfi, new DropTraversalAdapter(statement));

            if (!statement.canDrop() && statement.getParent().getTwin(newDb) != null) {
                dfi = new DepthFirstIterator<>(oldDepcyGraph.getGraph(), statement);
                iterate(dfi, new CannotDropAdapter(statement));
            }
        }
    }

    /**
     * При создании объекта в новой базе добавляет для создания все объекты из новой базы. <br>
     * Объект существует в новой базе, но не существует в старой. Мы его создаем, а также добавляем для создания все
     * объекты, которые требуются для правильной работы создаваемого объекта.
     *
     * @param statement
     */
    public void addCreateStatements(PgStatement statement) {
        if (newDepcyGraph.getGraph().containsVertex(statement) && createdObjects.add(statement)) {
            var dfi = new DepthFirstIterator<>(newDepcyGraph.getGraph(), statement);
            iterate(dfi, new CreateTraversalAdapter(statement));
        }
    }

    /**
     * Добавить выражение для изменения объекта
     * @param oldObj исходный объект
     * @param newObj новый объект
     */
    public void addAlterStatements(PgStatement oldObjStat, PgStatement newObjStat) {
        ObjectState state = getObjectState(oldObjStat, newObjStat);
        if (state.in(ObjectState.RECREATE, ObjectState.ALTER_WITH_DEP)) {
            addDropStatements(oldObjStat);
            return;
        }

        // добавляем измененные объекты
        // пропускаем колонки таблиц из дроп листа
        if (state == ObjectState.ALTER && !inDropsList(oldObjStat)
                && (oldObjStat.getStatementType() != DbObjType.COLUMN || !inDropsList(oldObjStat.getParent()))) {
            addToListWithoutDepcies(ObjectState.ALTER, oldObjStat, null);
        }

        alterMsTableColumns(oldObjStat, newObjStat);
    }

    private void alterMsTableColumns(PgStatement oldObjStat, PgStatement newObjStat) {
        // if no depcies were triggered for a MsTable alter
        // check for column layout changes and refresh views
        if (oldObjStat instanceof MsTable tOld && newObjStat instanceof MsTable tNew) {
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
                iterate(new DepthFirstIterator<>(oldDepcyGraph.getReversedGraph(), tOld), new RefreshTableDeps());
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
                if (action.getState() == ObjectState.DROP) {
                    toRecreate.add(action.getOldObj());
                }
            }
            for (PgStatement drop : toRecreate) {
                PgStatement newSt = drop.getTwin(newDb);
                if (newSt != null) {
                    // add views to emit refreshes
                    // others are to block drop+create pairs for unchanged statements
                    if (canRefresh(drop, newSt)) {
                        toRefresh.add(newSt);
                    }

                    addCreateStatements(newSt);
                }
            }
        }
    }

    private boolean canRefresh(PgStatement drop, PgStatement newSt) {
        if (newSt instanceof SourceStatement) {
            if (newSt instanceof AbstractMsFunction && isMsTypeDep(newSt)) {
                return false;
            }

            if (newSt instanceof MsView view && view.isSchemaBinding()) {
                return false;
            }

            return newSt.equals(drop) && !inDropsList(newSt.getParent());
        }

        return false;
    }

    // check if obj dependence of ms Type
    private boolean isMsTypeDep(PgStatement newSt) {
        var graph = newDepcyGraph.getGraph();
        for (DefaultEdge edge : graph.edgeSet()) {
            PgStatement source = graph.getEdgeSource(edge);
            if (newSt.equals(source)) {
                PgStatement target = graph.getEdgeTarget(edge);
                if (target instanceof MsType && inDropsList(target)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes actions that for some reason should not be included in the script
     */
    public void removeExtraActions() {
        Set<ActionContainer> toRemove = new HashSet<>();
        for (ActionContainer action : actions) {
            if (action.getState() != ObjectState.ALTER) {
                continue;
            }
            // case where the selected modified object was recreated due to a dependency
            PgStatement newObj = action.getNewObj();
            if (actions.contains(new ActionContainer(newObj, newObj, ObjectState.CREATE, null))) {
                toRemove.add(action);
            }
        }
        actions.removeAll(toRemove);
    }

    /**
     * Проходит по итератору и заполняет список объектами из итератора
     *
     * @param dfi
     *            итератор для прохода
     * @param action
     *            список объектов из итератора
     */
    private void iterate(DepthFirstIterator<PgStatement, DefaultEdge> dfi,
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
        if (statement instanceof PgSequence seq) {
            GenericColumn ownedBy = seq.getOwnedBy();
            if (ownedBy != null) {
                PgStatement column = oldDb.getStatement(ownedBy);
                return column != null && (inDropsList(column) || inDropsList(column.getParent()));
            }
        }

        PgStatement oldObj = statement.getTwin(oldDb);
        return actions.contains(new ActionContainer(oldObj, oldObj, ObjectState.DROP, null));
    }

    /**
     * Добавляет в список выражений для скрипта Выражение без зависимостей
     *
     * @param action Какое действие нужно вызвать {@link StatementActions}
     * @param oldObj Объект из старого состояния
     * @param starter объект который вызвал действие
     */
    private void addToListWithoutDepcies(ObjectState action,
            PgStatement oldObj, PgStatement starter) {
        switch (action) {
        case CREATE, DROP -> actions.add(new ActionContainer(oldObj, oldObj, action, starter));
        case ALTER, ALTER_WITH_DEP -> actions
            .add(new ActionContainer(oldObj, oldObj.getTwin(newDb), ObjectState.ALTER, starter));
        default -> throw new IllegalStateException("Not implemented action");
        }
    }

    private ObjectState getObjectState(PgStatement oldSt, PgStatement newSt) {
        return states.computeIfAbsent(oldSt.getQualifiedName(),
                x -> oldSt.appendAlterSQL(newSt, new SQLScript(oldSt.getDbType())));
    }

    private Boolean getRecreatedObj(AbstractTable oldTable, AbstractTable newTable) {
        return recreatedObjs.computeIfAbsent(oldTable.getQualifiedName(), x -> oldTable.isRecreated(newTable));
    }

    /**
     * Используется для прохода по графу зависимостей для формирования
     * зависимостей (ALTER, DROP)
     */
    private class DropTraversalAdapter extends CustomTraversalListenerAdapter {

        DropTraversalAdapter(PgStatement starter) {
            super(starter, ObjectState.DROP);
        }

        @Override
        protected boolean canAdd(PgStatement oldObj) {
            if (!oldObj.canDrop()) {
                return true;
            }

            // Изначально будем удалять объект
            action = ObjectState.DROP;

            PgStatement newObj = oldObj.getTwin(newDb);
            if (newObj != null) {
                // проверить требует ли пересоздания(Drop/create) родителькие объекты
                IsDropped iter = new IsDropped();
                iterate(new DepthFirstIterator<>(oldDepcyGraph.getGraph(), oldObj), iter);
                if (iter.needDrop != null && iter.needDrop != oldObj) {
                    action = ObjectState.DROP;
                } else {
                    action = getObjectState(oldObj, newObj);

                    if (action == ObjectState.NOTHING) {
                        return false;
                    }
                    // в случае необходимости изменения (ALter) объекта с
                    // зависимостями нужно сначала создать объект с зависимостями,
                    // потом изменить его
                    if (action == ObjectState.ALTER_WITH_DEP) {
                        // не добавлять объект, если уже есть в списке
                        if (!createdObjects.contains(newObj)) {
                            addCreateStatements(newObj);
                            addToList(oldObj);
                        }
                        return false;
                    }
                    if (action == ObjectState.RECREATE) {
                        action = ObjectState.DROP;
                    }
                }
            }

            // Колонки пропускаются при удалении таблицы
            if (oldObj.getStatementType() == DbObjType.COLUMN) {
                AbstractTable oldTable = (AbstractTable) oldObj.getParent();
                PgStatement newTable = oldObj.getParent().getTwin(newDb);

                if (newTable == null || getRecreatedObj(oldTable, (AbstractTable) newTable)) {
                    // случай, если дроп зависимости тянет колонку, которую мы не пишем
                    // потому что дропается таблица - дропаем таблицу
                    addDropStatements(oldTable);
                    return false;
                }

                // пропускаем также при recreate
                ObjectState parentState = getObjectState(oldTable, newTable);
                if (parentState == ObjectState.RECREATE) {
                    return false;
                }

                // пропускать колонки при смене типа таблицы
                if (!oldTable.getClass().equals(newTable.getClass())) {
                    return false;
                }

                // пропускаем колонки типизированных таблиц, если изменился тип
                if (oldTable instanceof TypedPgTable typedTable
                        && !Objects.equals(typedTable.getOfType(), ((TypedPgTable) newTable).getOfType())) {
                    return false;
                }
            }

            // пропускаем сиквенс, если дропается его овнедбай
            // сиквенс дропнется неявно вместе с колонкой
            if (oldObj instanceof PgSequence seq) {
                GenericColumn ownedBy = seq.getOwnedBy();
                if (ownedBy != null && newDb.getStatement(ownedBy) == null) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Используется для прохода по графу зависимостей для формирования
     * зависимостей (CREATE)
     */
    private class CreateTraversalAdapter extends CustomTraversalListenerAdapter {

        CreateTraversalAdapter(PgStatement starter) {
            super(starter, ObjectState.CREATE);
        }

        @Override
        protected boolean canAdd(PgStatement newObj) {
            // Изначально будем создавать объект
            action = ObjectState.CREATE;
            // always create if droppped before
            if (inDropsList(newObj)) {
                createColumnDependencies(newObj);
                return true;
            }

            if (newObj.getStatementType() == DbObjType.COLUMN) {
                PgStatement oldTable = newObj.getParent().getTwin(oldDb);
                AbstractTable newTable = (AbstractTable) newObj.getParent();
                if (oldTable == null || getRecreatedObj((AbstractTable) oldTable, newTable)) {
                    // columns are integrated into CREATE TABLE
                    return false;
                }

                // columns are integrated into CREATE TABLE OF TYPE
                if (newTable instanceof TypedPgTable newTypedTable) {
                    TypedPgTable oldTypedTable = (TypedPgTable) oldTable;
                    if (!Objects.equals(newTypedTable.getOfType(), oldTypedTable.getOfType())) {
                        return false;
                    }
                }

                // пропускать колонки при смене типа таблицы
                if (!oldTable.getClass().equals(newTable.getClass())) {
                    return false;
                }
            }

            PgStatement oldObj = newObj.getTwin(oldDb);
            if (oldObj != null) {
                action = getObjectState(oldObj, newObj);
                if (action == ObjectState.NOTHING) {
                    return false;
                }

                // в случае изменения объекта с зависимостями
                if (action.in(ObjectState.RECREATE, ObjectState.ALTER_WITH_DEP)) {
                    addDropStatements(oldObj);
                    if (action == ObjectState.ALTER_WITH_DEP) {
                        // add alter for old object
                        addToList(oldObj);
                        return false;
                    }
                    action = ObjectState.CREATE;
                }
            }

            // если объект (таблица) создается, запускаем создание зависимостей ее колонок
            // сами колонки создадутся неявно вместе с таблицей
            if (action == ObjectState.CREATE) {
                createColumnDependencies(newObj);
            }

            // создать колонку при создании сиквенса с owned by
            if (newObj instanceof PgSequence seq) {
                GenericColumn ownedBy = seq.getOwnedBy();
                if (ownedBy != null && oldDb.getStatement(ownedBy) == null) {
                    PgStatement col = newDb.getStatement(ownedBy);
                    if (col != null) {
                        addCreateStatements(col);
                    }
                }
            }

            return true;
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
    private abstract class CustomTraversalListenerAdapter extends TraversalListenerAdapter<PgStatement, DefaultEdge> {

        protected final PgStatement starter;
        /**
         * меняется в {@link #canAdd(PgStatement)} для вызова добавления в список с правильным действием
         */
        protected ObjectState action;

        CustomTraversalListenerAdapter(PgStatement starter, ObjectState action) {
            this.starter = starter;
            this.action = action;
        }

        @Override
        public void vertexFinished(VertexTraversalEvent<PgStatement> e) {
            PgStatement statement = e.getVertex();
            if (statement.getStatementType() != DbObjType.DATABASE && canAdd(statement)) {
                addToList(statement);
            }
        }

        protected abstract boolean canAdd(PgStatement statement);

        protected void addToList(PgStatement statement) {
            addToListWithoutDepcies(action, statement, starter);
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
            DbObjType type = oldSt.getStatementType();
            if (newSt == null) {
                if (type == DbObjType.FUNCTION && oldSt.getDbType() == DatabaseType.PG
                        && isDefaultsOnlyChange((IFunction) oldSt)) {
                    // when function's signature changes it has no twin
                    // but the dependent object might be unchanged
                    // due to default arguments changing in the signature
                    needDrop = oldSt;
                }
                return;
            }

            if (type.in(DbObjType.FUNCTION, DbObjType.PROCEDURE)
                    && oldSt.getDbType() != DatabaseType.CH
                    && !((AbstractFunction) oldSt).needDrop((AbstractFunction) newSt)) {
                return;
            }

            ObjectState state = getObjectState(oldSt, newSt);
            if (state.in(ObjectState.RECREATE, ObjectState.ALTER_WITH_DEP)) {
                needDrop = oldSt;
            }
        }

        private boolean isDefaultsOnlyChange(IFunction oldFunc) {
            AbstractSchema newSchema = newDb.getSchema(oldFunc.getSchemaName());
            if (newSchema == null) {
                return false;
            }

            // in the new database, search the function for which
            // the signature before first default argument will be the same
            // if there is such, then the drop is necessary,
            // if there is no such, then the drop is not necessary

            Function<IFunction, List<Argument>> argsBeforeDefaults = f -> {
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

    private class CannotDropAdapter extends CustomTraversalListenerAdapter {

        public CannotDropAdapter(PgStatement starter) {
            super(starter, ObjectState.DROP);
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
        protected boolean canAdd(PgStatement statement) {
            // unused
            return true;
        }
    }
}
