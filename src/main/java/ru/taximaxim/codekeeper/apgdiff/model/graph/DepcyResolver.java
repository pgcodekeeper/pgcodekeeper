package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.text.MessageFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.jgrapht.DirectedGraph;
import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement.DbObjType;
import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.PgDiffScript;
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

    private static final String DROP_COMMENT = "-- DEPCY: This {0} depends on the {1}: {2}";
    private static final String CREATE_COMMENT = "-- DEPCY: This {0} is a dependency of {1}: {2}";
    private PgDatabase oldDb;
    private PgDatabase newDb;
    private DepcyGraph oldDepcyGraph;
    private DepcyGraph newDepcyGraph;
    private Set<ActionContainer> actions = new LinkedHashSet<>();
    private Set<PgSequence> sequencesOwnedBy = new LinkedHashSet<>();
    /**
     * Хранит запущенные итерации, используется для предотвращения циклического прохода по графу
     */
    private Set<Entry<PgStatement, StatementActions>> sKippedObjects = new HashSet<>();

    public DepcyResolver(PgDatabase oldDatabase, PgDatabase newDatabase)
            throws PgCodekeeperException {
        this.oldDb = oldDatabase;
        this.newDb = newDatabase;
        this.oldDepcyGraph = new DepcyGraph(oldDatabase);
        this.newDepcyGraph = new DepcyGraph(newDatabase);
    }
    
    public DirectedGraph<PgStatement, DefaultEdge> getOldGraph() {
        return oldDepcyGraph.getGraph();
    }
    
    public DirectedGraph<PgStatement, DefaultEdge> getNewGraph() {
        return newDepcyGraph.getGraph();
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
        addDrop(toDrop);
    }
    
    private void addDrop(PgStatement toDrop) {
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
        addCreate(toCreate);
    }
    
    private void addCreate(PgStatement toCreate) {
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
     * При изменении объекта в старой базе, нужно попробовать изменить все
     * объекты из старой базы. <br>
     * Объект существует в обеих базах, но различается. Нужно попробовать
     * привести его к новому виду, при этом все объекты которым он нужен, также
     * нужно привести к новому виду. если это не возможно их нужно удалить.
     * (Затем создать из нового состояния)
     * 
     * @param toAlter
     */
    public void addAlterStatements(PgStatement toAlter) {
        addDrop(toAlter);
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
//        if (adapter instanceof
//                CustomTraversalListenerAdapter) {
//            System.err.println("Итератор завершился");
//        }
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
    
    /**
     * Очищает списки объектов
     */
    public void clearLists() {
        actions.clear();
        sequencesOwnedBy.clear();
    }

    /**
     * Заполняет скрипт объектами с учетом их порядка по зависимостям
     * @param script скрипт для печати
     */
    public void fillScript(PgDiffScript script) {
        String currentSearchPath = MessageFormat.format(
                ApgdiffConsts.SEARCH_PATH_PATTERN, ApgdiffConsts.PUBLIC);
        for (ActionContainer action : actions) {
            PgStatement oldObj = action.getOldObj();
            String depcy = null;
            PgStatement objStarter = action.getStarter();
            if (objStarter != null && objStarter != oldObj
                    && objStarter != action.getNewObj()) {
                String objName = "";
                if (objStarter.getStatementType() == DbObjType.COLUMN) {
                    objName = ((PgColumn) objStarter).getParent().getName()
                            + '.';
                }
                objName += objStarter.getName();
                depcy = MessageFormat.format(
                        action.getAction() == StatementActions.CREATE ?
                                CREATE_COMMENT : DROP_COMMENT,
                        oldObj.getStatementType(),
                        objStarter.getStatementType(), objName);
            }
            switch (action.getAction()) {
            case CREATE:
                currentSearchPath = setSearchPath(currentSearchPath, oldObj,
                        script);
                if (depcy != null) {
                    script.addStatement(depcy);
                }
                script.addCreate(oldObj, null, oldObj.getCreationSQL(), true);
                break;
            case DROP:
                currentSearchPath = setSearchPath(currentSearchPath, oldObj,
                        script);
                if (depcy != null) {
                    script.addStatement(depcy);
                }
                script.addDrop(oldObj, null, oldObj.getDropSQL());
                break;
            case ALTER:
                StringBuilder sb = new StringBuilder();
                oldObj.appendAlterSQL(action.getNewObj(), sb,
                        new AtomicBoolean());
                if (sb.length() > 0) {
                    currentSearchPath = setSearchPath(currentSearchPath,
                            oldObj, script);
                    if (depcy != null) {
                        script.addStatement(depcy);
                    }
                    script.addStatement(sb.toString());
                }
                break;
            default:
                throw new IllegalStateException("Not implemented action");
            }
        }

        for (PgSequence sequence : sequencesOwnedBy) {
            currentSearchPath = setSearchPath(currentSearchPath, sequence,
                    script);
            script.addStatement(sequence.getOwnedBySQL());
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
     * Переключает путь для поиска объектов если текущий объект содержится в другой схеме
     * @param currentSearchPath текущий путь
     * @param st объект для вывода
     * @param script скрипт для печати
     * @return
     */
    private String setSearchPath(String currentSearchPath, PgStatement st,
            PgDiffScript script) {
        if (st instanceof PgStatementWithSearchPath) {
            String searchPath = ((PgStatementWithSearchPath) st)
                    .getSearchPath();
            if (!currentSearchPath.equals(searchPath)) {
                script.addStatement(searchPath);
                return searchPath;
            }
        }
        return currentSearchPath;
    }

    /**
     * Добавляет в список выражений для скрипта Выражение без зависимостей
     * 
     * @param action Какое действие нужно вызвать {@link StatementActions}
     * @param oldObj Объект из старого состояния
     * @param starter объект который вызвал действие
     */
    public void addToListWithoutDepcies(StatementActions action,
            PgStatement oldObj, PgStatement starter) {
//        System.err.println("Добавляем в скрипт " + action + " " + oldObj);
        switch (action) {
        case CREATE:
            if (oldObj.getStatementType() == DbObjType.SEQUENCE) {
                if (((PgSequence) oldObj).getOwnedBy() != null) {
                    sequencesOwnedBy.add((PgSequence) oldObj);
                }
            }
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
        case CONTAINER:
        case DATABASE:
        default:
            break;
        }
        return null;
    }
    
    /**
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
     * Добавить выражение для изменения объекта, метод сам проверяет наличие обоих объектов
     * @param oldObj исходный объект
     * @param newObj новый объект
     */
    public void appendAlter(PgStatement oldObj, PgStatement newObj) {
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
                    addAlterStatements(oldObj);
                } else {
                    addToListWithoutDepcies(
                            sb.length() > 0 ? StatementActions.ALTER : StatementActions.DROP, 
                            oldObj, null);
                }
            }
        }
    }
    
    /**
     * Добавляет в список OWNED BY последовательность (SEQUENCE) для вызова в конце скрипта
     * @param oldObj исходная последовательность
     * @param newObj новая последовательность
     */
    public void appendAlterOwnedBy(PgSequence oldObj, PgSequence newObj) {
        if (newObj != null && oldObj != null) {
            StringBuilder sb = new StringBuilder();
            oldObj.alterOwnedBy(newObj, sb);
            if (sb.length() > 0) {
                sequencesOwnedBy.add(newObj);
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
            PgStatement newObj = null;
            AtomicBoolean isNeedDepcies = new AtomicBoolean();
            if ((newObj = getObjectFromDB(oldObj, newDb)) != null) {
                action = askAlter(oldObj, newObj, isNeedDepcies);
                if (action == StatementActions.NONE) {
                    return true;
                }
                // в случае необходимости изменения (ALter) объекта с
                // зависимостями нужно сначала создать объект с зависимостями,
                // потом изменить его
                if (isNeedDepcies.get()) {
                    if (action == StatementActions.ALTER) {
                        addCreate(newObj);
                        addToList(oldObj);
                        return true;
                    }
                }
            }
            // При дропе таблица тянет за собой почти все зависимости
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
            PgStatement oldObj = null;
            AtomicBoolean isNeedDepcies = new AtomicBoolean();
            if ((oldObj = getObjectFromDB(newObj, oldDb)) != null) {
                action = askAlter(oldObj, newObj, isNeedDepcies);
                if (action == StatementActions.NONE) {
                    return true;
                }
                // в случае изменения объекта с зависимостями
                if (isNeedDepcies.get()) {
                    addDrop(oldObj);
                    if (action == StatementActions.ALTER) {
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
//            System.err.println("Создаем "+ action + " итератор по " + starter.getName());
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
        
        protected StatementActions askAlter(PgStatement oldSt, PgStatement newSt, AtomicBoolean isNeedDepcies) {
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
            // проверить а не
            // требует ли пересоздания(Drop/create) родителькие объекты
            IsDropped iter = new IsDropped();
            customIteration(
                    new DepthFirstIterator<PgStatement, DefaultEdge>(
                            oldDepcyGraph.getGraph(), oldSt), iter);
            if (iter.getDropped() != null
                    && iter.getDropped() != oldSt
                    && action == StatementActions.DROP) {
                alterAction = StatementActions.DROP;
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

/**
 * Класс используется как контейнер для объединения дейсвий с объектом БД
 * (CREATE ALTER DROP) Также хранит объект, инициировавший действие
 */
class ActionContainer {
    private PgStatement oldObj;
    private PgStatement newObj;
    private StatementActions action;
    private PgStatement starter;

    public ActionContainer(PgStatement oldObj, PgStatement newObj,
            StatementActions action, PgStatement starter) {
        this.oldObj = oldObj;
        this.newObj = newObj;
        this.action = action;
        this.starter = starter;
    }

    public PgStatement getOldObj() {
        return oldObj;
    }

    public PgStatement getNewObj() {
        return newObj;
    }

    public StatementActions getAction() {
        return action;
    }

    public PgStatement getStarter() {
        return starter;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((action == null) ? 0 : action.hashCode());
        result = prime * result + ((oldObj == null) ? 0 : oldObj.hashCode());
        result = prime * result + ((newObj == null) ? 0 : newObj.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof ActionContainer) {
            ActionContainer cont = (ActionContainer) obj;
            boolean eq = action == cont.getAction() &&
                    Objects.equals(oldObj, cont.getOldObj()) &&
                    Objects.equals(newObj, cont.getNewObj());
            return eq;
        }
        return false;
    }
    @Override
    public String toString() {
        return action + " " + (oldObj == null? " " : oldObj.getName());
    }
}
