package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.text.MessageFormat;
import java.util.ArrayList;
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
        toDrop = addDrop(toDrop);
        addToListWithoutDepcies(StatementActions.DROP, toDrop, toDrop);
    }
    
    private PgStatement addDrop(PgStatement toDrop) {
        toDrop = getObjectFromDB(toDrop, oldDb);
        if (oldDepcyGraph.getReversedGraph().containsVertex(toDrop)) {
            DepthFirstIterator<PgStatement, DefaultEdge> dfi = new DepthFirstIterator<>(
                    oldDepcyGraph.getReversedGraph(), toDrop);
            customIteration(dfi, new CommonTraversalAdapter(toDrop, StatementActions.DROP));
        }
        return toDrop;
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
        toCreate = addCreate(toCreate);
        addToListWithoutDepcies(StatementActions.CREATE, toCreate, toCreate);
    }
    
    private PgStatement addCreate(PgStatement toCreate) {
        toCreate = getObjectFromDB(toCreate, newDb);
        if (newDepcyGraph.getGraph().containsVertex(toCreate)) {
            DepthFirstIterator<PgStatement, DefaultEdge> dfi = new DepthFirstIterator<>(
                    newDepcyGraph.getGraph(), toCreate);
            customIteration(dfi, new CommonTraversalAdapter(toCreate, StatementActions.CREATE));
        }
        return toCreate;
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
        toAlter = addAlter(toAlter);
        addToListWithoutDepcies(StatementActions.ALTER, toAlter, toAlter);
    }
    
    public PgStatement addAlter(PgStatement toAlter) {
        toAlter = getObjectFromDB(toAlter, oldDb);
        if (oldDepcyGraph.getGraph().containsVertex(toAlter)) {
            DepthFirstIterator<PgStatement, DefaultEdge> dfi = new DepthFirstIterator<>(
                    oldDepcyGraph.getReversedGraph(), toAlter);
            customIteration(dfi, new CommonTraversalAdapter(toAlter, StatementActions.DROP));
        }
        return toAlter;
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
            CustomTraversalListenerAdapter adapter) {
        dfi.addTraversalListener(adapter);
        while (dfi.hasNext()) {
            dfi.next();
        }
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
            if (objStarter != null && objStarter != oldObj) {
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
            // TODO check if was recreated?
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
     * Добавить выражение для изменения объекта
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
     * зависимостей (ALTER, DROP, CREATE)
     */
    private class CommonTraversalAdapter extends CustomTraversalListenerAdapter {
        CommonTraversalAdapter(PgStatement starter, StatementActions action) {
            super(starter, action);
        }

        @Override
        protected boolean notAllowedToAdd(PgStatement statement) {
            // если текущий объект равен начальному не добавляем его добавит
            // вызывающий итератор метод
            if (super.notAllowedToAdd(statement)
                    || statement == starter) {
                return true;
            }
            StringBuilder sb = new StringBuilder();
            AtomicBoolean isNeedDepcies = new AtomicBoolean();
            PgStatement oppositeObj = null;
            action = startAction;
            switch (startAction) {
            case CREATE:
                if (inDropsList(statement)) {
                    // always create if droppped before
                    return false;
                }
                if ((oppositeObj = getObjectFromDB(statement, oldDb)) != null) {
                    // Если альтер требует зависимости - вызов итератора, который проходит как дроп, но не дропает стартер
                    // пишем стайтмент альтер
                    boolean isChanged = oppositeObj.appendAlterSQL(statement, sb, isNeedDepcies);
                    if (isChanged) {
                        if (isNeedDepcies.get()) {
                            addDrop(oppositeObj);
                        } 
                        if (sb.length() > 0) {
                            action = StatementActions.ALTER;
                        }
                        return false;
                    } else {
                        if (sb.length() == 0) {
                            return true;
                        }
                    }
                }
                if (statement.getStatementType() == DbObjType.COLUMN) {
                    PgStatement oldTable = getObjectFromDB(statement.getParent(),
                            oldDb);
                    if (oldTable == null) {
                        // columns are integrated into CREATE TABLE
                        return true;
                    }
                }
                return false;
            case DROP:
                if ((oppositeObj = getObjectFromDB(statement, newDb)) != null) {
                    // Если альтер требует зависимости - вызов итератора, который проходит как креате, но не создает стартер
                    // пишем стайтмент альтер
                    boolean isChanged = statement.appendAlterSQL(oppositeObj, sb, isNeedDepcies);
                    if (isChanged) {
                        if (isNeedDepcies.get()) {
                            addCreate(oppositeObj);
                        }
                        if (sb.length() > 0) {
                            action = StatementActions.ALTER;    
                        }
                        return false;
                    }
                }
                if (statement.getStatementType() == DbObjType.COLUMN) {
                    PgStatement newTable = getObjectFromDB(statement.getParent(),
                            newDb);
                    if (newTable == null) {
                        return true;
                    }
                }
                return false;
            default:
                throw new IllegalStateException("Not implemented action");
            }
        }
    }

    /**
     * Используется для прохода по графу зависимостей, содержит общие методы
     */
    private abstract class CustomTraversalListenerAdapter extends
            TraversalListenerAdapter<PgStatement, DefaultEdge> {
        
        protected PgStatement starter;
        protected StatementActions action;
        protected StatementActions startAction;

        CustomTraversalListenerAdapter(PgStatement starter,
                StatementActions action) {
            this.starter = starter;
            this.action = action;
            this.startAction = action;
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
}
