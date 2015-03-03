package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.jgrapht.event.TraversalListenerAdapter;
import org.jgrapht.event.VertexTraversalEvent;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;

import cz.startnet.utils.pgdiff.PgCodekeeperException;
import cz.startnet.utils.pgdiff.PgDiffScript;
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
 * Служит для отслеживания зависимостей,
 * при этом старое состояние храниться в oldDb, a новое состояние в newDb, и требуется
 * список объектов для удаления или создания при приведении состояния из старого в новое. 
 */
public class DepcyResolver {

	private PgDatabase oldDb;
	private PgDatabase newDb;
	private DepcyGraph oldDepcyGraph;
	private DepcyGraph newDepcyGraph;
	private Set<ActionContainer> actions = new LinkedHashSet<>();
	private List<PgSequence> sequencesOwnedBy = new ArrayList<>();

	public DepcyResolver(PgDatabase oldDatabase, PgDatabase newDatabase) throws PgCodekeeperException {
		this.oldDb = oldDatabase;
		this.newDb = newDatabase;
		this.oldDepcyGraph = new DepcyGraph(oldDatabase);
		this.newDepcyGraph = new DepcyGraph(newDatabase);
	}

	/**
	 * При удалении объекта из старой базы добавляет для удаления все объекты из
	 * старой базы. <br>Объекта не существует в новой базе, но существует в старой, мы его удаляем, и
	 * удаляем из старой базы все объекты, которым этот объект требуется, т.к.
	 * они будут ошибочны, при отсутсвии этого объекта.
	 * 
	 * @param toDrop объект для удаления из старой базы
	 */
	public void addDropStatements(PgStatement toDrop) {
		if (oldDepcyGraph.getReversedGraph().containsVertex(toDrop)) {
			DepthFirstIterator<PgStatement, DefaultEdge> dfi = new DepthFirstIterator<>(
					oldDepcyGraph.getReversedGraph(), toDrop);
			customIteration(dfi, new DropTraversalAdapter(actions));
		}
	}
	
	/**
	 * При создании объекта в новой базе добавляет для создания все объекты из
	 * новой базы. <br>
	 * Объект существует в новой базе, но не существует в старой, мы его
	 * создаем, а также добавляем для создания все объекты, которые трубуются для
	 * правильной работы создаваемого объекта.
	 * 
	 * @param toCreate
	 */
	public void addCreateStatements(PgStatement toCreate) {
		if (newDepcyGraph.getGraph().containsVertex(toCreate)) {
			DepthFirstIterator<PgStatement, DefaultEdge> dfi = new DepthFirstIterator<>(
					newDepcyGraph.getGraph(), toCreate);
			customIteration(dfi, new CreateTraversalAdapter(actions));
		}
	}
	
	/**
	 * Проходит по итератору и заполняет список объектами из итератора
	 * @param dfi итератор для прохода
	 * @param action список объектов из итератора
	 */
	private void customIteration(
			DepthFirstIterator<PgStatement, DefaultEdge> dfi,
			CustomTraversalListenerAdapter adapter) {
		dfi.addTraversalListener(adapter);
		while (dfi.hasNext()) {
			dfi.next();
		}
	}
	
	public void addCustomDepciesToOld(List<Entry<PgStatement, PgStatement>> depcies) {
        oldDepcyGraph.addCustomDepcies(depcies);
    }
	
	public void addCustomDepciesToNew(List<Entry<PgStatement, PgStatement>> depcies) {
		newDepcyGraph.addCustomDepcies(depcies);
	}

	public void fillScript(PgDiffScript script) {
		String currentSearchPath = "";
		for (ActionContainer action : actions) {
			PgStatement st = action.getOldObj();
			currentSearchPath = setSearchPath(currentSearchPath, st, script);
			switch(action.getAction()) {
			case CREATE:
				script.addCreate(st, null, st.getCreationSQL(), true);
				break;
			case DROP:
				script.addDrop(st, null, st.getDropSQL());
				break;
			case ALTER:
				// TODO дописать
				break;
			}
		}
		
		for (PgSequence sequence : sequencesOwnedBy) {
			currentSearchPath = setSearchPath(currentSearchPath, sequence, script);
			script.addStatement(sequence.getOwnedBySQL());
		}
	}
	
	private boolean inDropsList(PgStatement statement) {
		for (ActionContainer action : actions) {
			if (action.getAction() != StatementActions.DROP) {
				continue;
			}
			PgStatement drop = action.getOldObj();
			if (drop.getStatementType() == statement.getStatementType()
					&& drop.getQualifiedName().equals(statement.getQualifiedName())) {
				return true;
			}
		}
		return false;
	}
	
	public void recreateDrops() {
		List<PgStatement> toRecreate = new ArrayList<>();
		for (ActionContainer action : actions) {
			if (action.getAction() != StatementActions.DROP) {
				continue;
			}
			toRecreate.add(action.getOldObj());
		}
		for (PgStatement drop : toRecreate) {
			PgSchema newSchema = null;
			if (drop instanceof PgStatementWithSearchPath) {
				newSchema = newDb.getSchema(((PgStatementWithSearchPath) drop)
						.getContainerSchema().getName());	
			}
			switch (drop.getStatementType()) {
				case EXTENSION:
					if (newDb.getExtension(drop.getName()) != null) {
						addCreateStatements(drop);
					}
					break;
				case SCHEMA:
					if (newDb.getSchema(drop.getName()) != null) {
						addCreateStatements(drop);
					}
					break;
			default:
				break;
			}
			if (newSchema == null) {
				return;
			}
			switch (drop.getStatementType()) {
			case VIEW:
				if (newSchema.getView(drop.getName()) != null) {
					addCreateStatements(drop);
				}
				break;
			case SEQUENCE:
				if (newSchema.getSequence(drop.getName()) != null) {
					addCreateStatements(drop);
				}
				break;
			case FUNCTION:
				if (newSchema.getFunction(drop.getName()) != null) {
					addCreateStatements(drop);
				}
				break;
			case TABLE:
				if (newSchema.getTable(drop.getName()) != null) {
					addCreateStatements(drop);
				}
				break;
			case TRIGGER:
				PgTrigger trig = (PgTrigger)drop; 
				PgTable table = newSchema.getTable(trig.getTableName());
				if (table != null) {
					PgTrigger trigger = table.getTrigger(trig.getName());
					if (trigger != null) {
						addCreateStatements(trigger);
					}
				}
				break;
			case INDEX:
				PgIndex ind = (PgIndex)drop; 
				PgTable tableInd = newSchema.getTable(ind.getTableName());
				if (tableInd != null) {
					PgIndex index = tableInd.getIndex(ind.getName());
					if (index != null) {
						addCreateStatements(index);
					}
				}
				break;
			case CONSTRAINT:
				PgConstraint constr = (PgConstraint)drop; 
				PgTable tableConstr = newSchema.getTable(constr.getTableName());
				if (tableConstr != null) {
					PgConstraint constraint = tableConstr.getConstraint(constr.getName());
					if (constraint != null) {
						addCreateStatements(constraint);
					}
				}
				break;
			default:
				break;
			}
		}
	}
	
	private String setSearchPath(String currentSearchPath, PgStatement st, PgDiffScript script) {
		if (st instanceof PgStatementWithSearchPath) {
			String searchPath = ((PgStatementWithSearchPath)st).getSearchPath();
			if (!currentSearchPath.equals(searchPath)) {
				currentSearchPath = searchPath;
				script.addStatement(((PgStatementWithSearchPath)st).getSearchPath());
			}
		}
		return currentSearchPath;
	} 
	
	private class CreateTraversalAdapter extends CustomTraversalListenerAdapter {

		CreateTraversalAdapter(Set<ActionContainer> action) {
			super(action, StatementActions.CREATE);
		}

		@Override
		protected boolean notAllowedToAdd(PgStatement statement) {
			if (super.notAllowedToAdd(statement)) {
				return true;
			}
			if (inDropsList(statement)) {
				return false;
			}
			PgSchema oldSchema = null;
			
			switch (statement.getStatementType()) {
			case EXTENSION:
				if (statement.equals(oldDb.getExtension(statement.getName()))) {
					return true;
				}
				break;
			case SCHEMA:
				if (oldDb.getSchema(statement.getName()) != null) {
					return true;
				}
				break;
			default:
				break;
			}
			if (statement instanceof PgStatementWithSearchPath) {
				oldSchema = oldDb.getSchema(((PgStatementWithSearchPath)statement).getContainerSchema()
						.getName());
			}
			if (oldSchema == null) {
				return false;
			}
			switch (statement.getStatementType()) {
			case VIEW:
				if (statement.equals(oldSchema.getView(statement.getName()))) {
					return true;
				}
				break;
			case TABLE:
				if (statement.equals(oldSchema.getTable(statement.getName()))) {
					return true;
				} else {
					
				}
				break;
			case TRIGGER:
				PgTrigger trigger = (PgTrigger) statement;
				PgTrigger trig = oldSchema.getTable(trigger.getTableName()).getTrigger(trigger.getName());
				if (trigger.equals(trig)) {
					return true;
				}
				break;
			case INDEX:
				PgIndex index = (PgIndex) statement;
				PgIndex ind = oldSchema.getTable(index.getTableName()).getIndex(index.getName());
				if (index.equals(ind)) {
					return true;
				}
				break;
			case CONSTRAINT:
				PgConstraint constraint = (PgConstraint) statement;
				PgConstraint constr = oldSchema.getTable(constraint.getTableName()).getConstraint(constraint.getName());
				if (constraint.equals(constr)) {
					return true;
				}
				break;
			case SEQUENCE:
				if (statement.equals(oldSchema.getSequence(statement.getName()))) {
					return true;
				}
				break;
			case FUNCTION:
				if (statement.equals(oldSchema.getFunction(statement.getName()))) {
					return true;
				}
				break;
			case COLUMN:
			case CONTAINER:
			case DATABASE:
			default:
				break;
			}
			return false;
		}
	}
	
	private class DropTraversalAdapter extends CustomTraversalListenerAdapter {

		DropTraversalAdapter(Set<ActionContainer> action) {
			super(action, StatementActions.DROP);
		}

		@Override
		protected boolean notAllowedToAdd(PgStatement statement) {
			return super.notAllowedToAdd(statement);
		}
	}
	
	private abstract class CustomTraversalListenerAdapter extends TraversalListenerAdapter<PgStatement, DefaultEdge> {
		private Set<ActionContainer> actions;
		private StatementActions action;

		CustomTraversalListenerAdapter(Set<ActionContainer> actions, StatementActions action) {
			this.actions = actions;
			this.action = action;
		}
		@Override
		public void vertexFinished(VertexTraversalEvent<PgStatement> e) {
			PgStatement statement = e.getVertex();
			if (notAllowedToAdd(statement)) {
				return;
			}
			switch (statement.getStatementType()) {
			case DATABASE:
				break;
			case SEQUENCE:
				if (((PgSequence)statement).getOwnedBy() != null) {
					sequencesOwnedBy.add((PgSequence)statement);	
				}
			default:
				addToList(statement);
				break;
			}
		}
		
		protected boolean notAllowedToAdd(PgStatement statement) {
			if (statement.getStatementType() == null) {
				return true;
			}
			return false;
		}
		
		protected void addToList(PgStatement statement) {
			PgDatabase db =  null;
			switch (action) {
			case CREATE:
				db = oldDb;
				break;
			case ALTER:
			case DROP:
				db = newDb;
				break;
				default:
					throw new IllegalStateException("DataBase is not selected");
			}
			if (db == null) {
				return;
			}
			PgStatement otherSt = null;
			switch (statement.getStatementType()) {
			case EXTENSION:
				otherSt = db.getExtension(statement.getName());
				break;
			case SCHEMA:
				otherSt = db.getSchema(statement.getName());
				break;
			case FUNCTION:
				otherSt = db.getSchema(
						((PgStatementWithSearchPath) statement)
								.getContainerSchema().getName()).getFunction(
						statement.getName());
				break;
			case SEQUENCE:
				otherSt = db.getSchema(
						((PgStatementWithSearchPath) statement)
								.getContainerSchema().getName()).getSequence(
						statement.getName());
				break;
			case VIEW:
				otherSt = db.getSchema(
						((PgStatementWithSearchPath) statement)
								.getContainerSchema().getName()).getView(
						statement.getName());
				break;
			case TABLE:
				otherSt = db.getSchema(
						((PgStatementWithSearchPath) statement)
								.getContainerSchema().getName()).getTable(
						statement.getName());
				break;
			case CONSTRAINT:
				PgTable otherTable = db.getSchema(
						((PgStatementWithSearchPath) statement)
								.getContainerSchema().getName()).getTable(
						((PgConstraint) statement).getTableName());
				if (otherTable != null) {
					otherSt = otherTable.getConstraint(statement.getName());
				}
				break;
			case INDEX:
				otherTable = db.getSchema(
						((PgStatementWithSearchPath) statement)
								.getContainerSchema().getName()).getTable(
						((PgIndex) statement).getTableName());
				if (otherTable != null) {
					otherSt = otherTable.getIndex(statement.getName());
				}
				break;
			case TRIGGER:
				otherTable = db.getSchema(
						((PgStatementWithSearchPath) statement)
								.getContainerSchema().getName()).getTable(
						((PgTrigger) statement).getTableName());
				if (otherTable != null) {
					otherSt = otherTable.getTrigger(statement.getName());
				}
				break;
			}
			switch (action) {
			case CREATE:
				actions.add(new ActionContainer(statement, statement, StatementActions.CREATE));
				break;
			case DROP:
				actions.add(new ActionContainer(statement, statement, StatementActions.DROP));
				break;
			case ALTER:
				actions.add(new ActionContainer(statement, otherSt, StatementActions.ALTER));
				break;
			default:
				break;
			}
		}
	}
	private class ActionContainer {
		private PgStatement oldObj;
		private PgStatement newObj;
		private StatementActions action;

		public ActionContainer(PgStatement oldObj, PgStatement newObj, StatementActions action) {
			this.oldObj = oldObj;
			this.newObj = newObj;
			this.action = action;
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
	}
}
