package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.jgrapht.DirectedGraph;
import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgForeignKey;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.StatementActions;

/**
 * Служит для отслеживания зависимостей, при этом старое состояние хранится в
 * oldDb, a новое состояние в newDb, и требуется список объектов для удаления
 * или создания при приведении состояния из старого в новое.
 */
public class DepcyResolver {

    private PgDatabase oldDb;
    private PgDatabase newDb;
    private DepcyGraph oldDepcyGraph;
    private DepcyGraph newDepcyGraph;
    private Set<ActionContainer> actions = new LinkedHashSet<>();
    /**
     * Хранит запущенные итерации, используется для предотвращения циклического прохода по графу
     */
    private Set<Entry<PgStatement, StatementActions>> sKippedObjects = new HashSet<>();

    public DirectedGraph<PgStatement, DefaultEdge> getOldGraph() {
        return oldDepcyGraph.getGraph();
    }
    
    public DirectedGraph<PgStatement, DefaultEdge> getNewGraph() {
        return newDepcyGraph.getGraph();
    }

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
     * Очищает списки объектов
     */
    public void clearActions() {
        actions.clear();
    }

    public DepcyResolver(PgDatabase oldDatabase, PgDatabase newDatabase)
            throws PgCodekeeperException {
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
        toDrop = getObjectFromDB(toDrop, oldDb);
        if (oldDepcyGraph.getReversedGraph().containsVertex(toDrop)) {
            if (!sKippedObjects.contains(new AbstractMap.SimpleEntry<>(toDrop, StatementActions.DROP))) {
                sKippedObjects.add(new AbstractMap.SimpleEntry<>(toDrop, StatementActions.DROP));
                
                DepthFirstIterator<PgStatement, DefaultEdge> dfi = new DepthFirstIterator<>(
                        oldDepcyGraph.getReversedGraph(), toDrop);
                customIteration(dfi, new DropTraversalAdapter(toDrop, StatementActions.DROP));
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
        toCreate = getObjectFromDB(toCreate, newDb);
        if (newDepcyGraph.getGraph().containsVertex(toCreate)) {
            if (!sKippedObjects.contains(new AbstractMap.SimpleEntry<>(toCreate, StatementActions.CREATE))) {
                sKippedObjects.add(new AbstractMap.SimpleEntry<>(toCreate, StatementActions.CREATE));
                
                DepthFirstIterator<PgStatement, DefaultEdge> dfi = new DepthFirstIterator<>(
                        newDepcyGraph.getGraph(), toCreate);
                customIteration(dfi, new CreateTraversalAdapter(toCreate, StatementActions.CREATE));
            }
        }
    }

    /**
     * Добавить выражение для изменения объекта, метод сам проверяет наличие обоих объектов
     * @param oldObj исходный объект
     * @param newObj новый объект
     */
    public void addAlterStatements(PgStatement oldObj, PgStatement newObj) {
        if (newObj != null && oldObj != null) {
            oldObj = getObjectFromDB(oldObj, oldDb);
            newObj = getObjectFromDB(newObj, newDb);
            StringBuilder sb = new StringBuilder();
            AtomicBoolean isNeedDepcies = new AtomicBoolean();
            boolean isChanged = oldObj.appendAlterSQL(newObj, sb, isNeedDepcies);
            
            if (isChanged) {
                if (isNeedDepcies.get()) {
                    // is state alterable (sb.length() > 0) 
                    // is checked in the depcy tracker in this case
                    addDropStatements(oldObj);
                } else {
                    addToListWithoutDepcies(
                            sb.length() > 0 ? StatementActions.ALTER : StatementActions.DROP, 
                            oldObj, null);
                }
            }
        }
    }

    /**
     * Пересоздает ранее удаленные объекты в новое состояние
     */
    public void recreateDrops() {
        List<PgStatement> toRecreate = new ArrayList<>();
        for (ActionContainer action : actions) {
            if (action.getAction() != StatementActions.DROP) {
                continue;
            }
            // we need this temp list because we cannot add to actions list
            // while iterating over it
            toRecreate.add(action.getOldObj());
        }
        for (PgStatement drop : toRecreate) {
            if (getObjectFromDB(drop, newDb) != null) {
                addCreateStatements(drop);
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
        for (ActionContainer action : actions) {
            if (action.getAction() != StatementActions.DROP) {
                continue;
            }
            PgStatement drop = action.getOldObj();
            if (drop.getStatementType() == statement.getStatementType()
                    && drop.getQualifiedName().equals(
                            statement.getQualifiedName())) {
                return true;
            }
        }
        return false;
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
            actions.add(new ActionContainer(oldObj, getObjectFromDB(oldObj,
                    newDb), action, starter));
            break;
        default:
            throw new IllegalStateException("Not implemented action");
        }
    }

    /**
     * Ищет в переданной базе объетк по имени 
     * @param statement объект для поиска
     * @param db база для поиска
     * @return
     */
    private PgStatement getObjectFromDB(PgStatement statement, PgDatabase db) {
        switch (statement.getStatementType()) {
        case EXTENSION:
            return db.getExtension(statement.getName());
        case SCHEMA:
            return db.getSchema(statement.getName());
        default:
            break;
        }
        PgSchema oldSchema = null;
        if (statement instanceof PgStatementWithSearchPath) {
            oldSchema = db.getSchema(((PgStatementWithSearchPath) statement)
                    .getContainingSchema().getName());
        }
        if (oldSchema == null) {
            return null;
        }
        switch (statement.getStatementType()) {
        case VIEW:
            return oldSchema.getView(statement.getName());
        case TABLE:
            return oldSchema.getTable(statement.getName());
        case TRIGGER:
            PgTrigger trig = (PgTrigger) statement;
            PgTable table = oldSchema.getTable(trig.getTableName());
            if (table != null) {
                return table.getTrigger(trig.getName());
            }
            break;
        case INDEX:
            PgIndex ind = (PgIndex) statement;
            PgTable tableInd = oldSchema.getTable(ind.getTableName());
            if (tableInd != null) {
                return tableInd.getIndex(ind.getName());
            }
            break;
        case CONSTRAINT:
            PgConstraint constr = (PgConstraint) statement;
            PgTable tableConstr = oldSchema.getTable(constr.getTableName());
            if (tableConstr != null) {
                return tableConstr.getConstraint(constr.getName());
            }
            break;
        case COLUMN:
            PgColumn column = (PgColumn) statement;
            PgTable tableCol = oldSchema.getTable(column.getParent().getName());
            if (tableCol != null) {
                return tableCol.getColumn(column.getName());
            }
            break;
        case SEQUENCE:
            return oldSchema.getSequence(statement.getName());
        case FUNCTION:
            return oldSchema.getFunction(statement.getName());
        case TYPE:
            return oldSchema.getType(statement.getName());
        case DOMAIN:
            return oldSchema.getDomain(statement.getName());
        case DATABASE:
        default:
            break;
        }
        return null;
    }
    
    /**
     * TODO Временно (?) заменен методами простой итерации по графу (getDropDepcies)
     * Возвращает упорядоченный набор объектов для наката с указанием действия
     * @param actionType необходимое действие
     * @return
     */
    public Set<PgStatement> getOrderedDepcies(StatementActions actionType) {
        Set<PgStatement> result = new LinkedHashSet<>();
        for (ActionContainer obj : actions) {
            if (obj.getAction() == actionType) {
                result.add(obj.getOldObj());
            }
        }
        return result;
    }

    /**
     * TODO костыльный метод убрать при переделке дерева TreeElement
     * @param toCreate
     * @return
     */
    public Set<PgStatement> getCreateDepcies(PgStatement toCreate) {
        toCreate = getObjectFromDB(toCreate, newDb);
        Set<PgStatement> depcies = new HashSet<>();
        if (newDepcyGraph.getGraph().containsVertex(toCreate)) {
            
            DepthFirstIterator<PgStatement, DefaultEdge> dfi = new DepthFirstIterator<>(
                    newDepcyGraph.getGraph(), toCreate);
            customIteration(dfi, new DepcyIterator(depcies));
        }
        return depcies;
    }
    
    /**
     * TODO костыльный метод убрать при переделке дерева TreeElement
     * @param toDrop
     * @return
     */
    public Set<PgStatement> getDropDepcies(PgStatement toDrop) {
        toDrop = getObjectFromDB(toDrop, oldDb);
        Set<PgStatement> depcies = new HashSet<>();
        if (oldDepcyGraph.getReversedGraph().containsVertex(toDrop)) {
            DepthFirstIterator<PgStatement, DefaultEdge> dfi = new DepthFirstIterator<>(
                    oldDepcyGraph.getReversedGraph(), toDrop);
            customIteration(dfi, new DepcyIterator(depcies));
        }
        return depcies;
    }
    
    private class DepcyIterator extends TraversalListenerAdapter<PgStatement, DefaultEdge> {
        Set<PgStatement> depcies = new HashSet<>();
        
        public DepcyIterator(Set<PgStatement> depcies) {
            this.depcies = depcies;
        }
        
        @Override
        public void vertexFinished(VertexTraversalEvent<PgStatement> e) {
            PgStatement statement = e.getVertex();
            if (statement.getStatementType() != DbObjType.DATABASE) {
                depcies.add(statement);
            }
        }
    }
    
    /**
     * Используется для прохода по графу зависимостей для формирования
     * зависимостей (ALTER, DROP)
     */
    private class DropTraversalAdapter extends CustomTraversalListenerAdapter {

        DropTraversalAdapter(PgStatement starter, StatementActions action) {
            super(starter, action);
        }
        
        @Override
        protected boolean notAllowedToAdd(PgStatement oldObj) {
            if (super.notAllowedToAdd(oldObj)) {
                return true;
            }
            // Изначально будем удалять объект 
            action = StatementActions.DROP;
            
            PgStatement newObj;
            if ((newObj = getObjectFromDB(oldObj, newDb)) != null) {
                AtomicBoolean isNeedDepcies = new AtomicBoolean();
                action = askAlter(oldObj, newObj, isNeedDepcies);
                
                // проверить а не
                // требует ли пересоздания(Drop/create) родителькие объекты
                IsDropped iter = new IsDropped();
                customIteration(new DepthFirstIterator<>(oldDepcyGraph.getGraph(),
                        oldObj), iter);
                if (iter.getDropped() != null && iter.getDropped() != oldObj) {
                    action = StatementActions.DROP;
                }
                
                if (action == StatementActions.NONE) {
                    return true;
                }
                // в случае необходимости изменения (ALter) объекта с
                // зависимостями нужно сначала создать объект с зависимостями,
                // потом изменить его
                if (isNeedDepcies.get()) {
                    if (action == StatementActions.ALTER) {
                        addCreateStatements(newObj);
                        addToList(oldObj);
                        return true;
                    }
                }
            }
            // При дропе таблица тянет за собой внутренние зависимости
            // foreign keys дропаем как обычно, чтобы не было конфликтов с primary keys
            if (oldObj.getParent().getStatementType() == DbObjType.TABLE) {
                if (oldObj instanceof PgForeignKey) {
                    return false;
                }
                PgStatement newTable = getObjectFromDB(oldObj.getParent(),
                        newDb);
                if (newTable == null) {
                    return true;
                }
            }
            // TODO Костыль не совсем рабочий, нужно проверить статус таблицы и
            // колонки, и если хотя бы одна из них удаляется то не дропать
            // сиквенс
            if (oldObj.getStatementType() == DbObjType.SEQUENCE) {
                PgSequence seq = (PgSequence)oldObj;
                if (seq.getOwnedBy() != null) {
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

        CreateTraversalAdapter(PgStatement starter, StatementActions action) {
            super(starter, action);
        }
        
        @Override
        protected boolean notAllowedToAdd(PgStatement newObj) {
            if (super.notAllowedToAdd(newObj)) {
                return true;
            }
            // Изначально будем создавать объект
            action = StatementActions.CREATE;
            if (inDropsList(newObj)) {
                // always create if droppped before
                return false;
            }
            
            PgStatement oldObj;
            if ((oldObj = getObjectFromDB(newObj, oldDb)) != null) {
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
            if (newObj.getStatementType() == DbObjType.COLUMN) {
                PgStatement oldTable = getObjectFromDB(newObj.getParent(),
                        oldDb);
                if (oldTable == null) {
                    // columns are integrated into CREATE TABLE
                    return true;
                }
            }
            return false;
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
            if (notAllowedToAdd(statement)) {
                return;
            }
            if (statement.getStatementType() != DbObjType.DATABASE) {
                addToList(statement);
            }
        }

        protected boolean notAllowedToAdd(PgStatement statement) {
            if (statement.getStatementType() == null) {
                return true;
            }
            return false;
        }

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
            PgStatement st = e.getVertex();
            PgStatement newSt = getObjectFromDB(st, newDb);
            if (newSt == null) {
                return;
            }
            AtomicBoolean isNeedDepcy = new AtomicBoolean(); 
            if (st.appendAlterSQL(newSt, new StringBuilder(), isNeedDepcy)) {
                if (isNeedDepcy.get()) {
                    needDrop = st;
                }
            }
        }

        public PgStatement getDropped() {
            return needDrop;
        }
    }
}
