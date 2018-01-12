package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.NotAllowedObjectException;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffScript;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.PgStatementWithSearchPath;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ActionsToScriptConverter {

    private static final String DROP_COMMENT = "-- DEPCY: This {0} depends on the {1}: {2}";
    private static final String CREATE_COMMENT = "-- DEPCY: This {0} is a dependency of {1}: {2}";
    private static final String HIDDEN_OBJECT = "-- HIDDEN: Object {0} of type {1}";

    private final Set<ActionContainer> actions;
    private final Set<PgSequence> sequencesOwnedBy = new LinkedHashSet<>();
    private final PgDiffArguments arguments;

    public ActionsToScriptConverter(Set<ActionContainer> actions, PgDiffArguments arguments) {
        this.actions = actions;
        this.arguments = arguments;
    }

    /**
     * Заполняет скрипт объектами с учетом их порядка по зависимостям
     * @param script скрипт для печати
     */
    public void fillScript(PgDiffScript script) {
        String currentSearchPath = "";
        Collection<DbObjType> allowedTypes = arguments.getAllowedTypes();
        for (ActionContainer action : actions) {
            DbObjType type = action.getOldObj().getStatementType();
            if(type == DbObjType.COLUMN){
                type = DbObjType.TABLE;
            }
            if (allowedTypes.isEmpty() || allowedTypes.contains(type)){
                processSequence(action);
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
            } else {
                PgStatement old = action.getOldObj();
                if (arguments.isStopNotAllowed()) {
                    throw new NotAllowedObjectException(old.getQualifiedName()
                            + " (" + type + ") is not an allowed script object. Stopping.");
                }
                script.addStatement(MessageFormat.format(HIDDEN_OBJECT,
                        old.getQualifiedName(), old.getStatementType()));
            }
        }

        for (PgSequence sequence : sequencesOwnedBy) {
            currentSearchPath = setSearchPath(currentSearchPath, sequence,
                    script);
            String ownedBy = sequence.getOwnedBySQL();
            if (!ownedBy.isEmpty()) {
                script.addStatement(ownedBy);
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

    private void processSequence(ActionContainer action) {
        if (action.getOldObj().getStatementType() == DbObjType.SEQUENCE) {
            PgSequence oldSeq = (PgSequence) action.getOldObj();
            PgSequence newSeq = (PgSequence) action.getNewObj();
            if (newSeq.getOwnedBy() != null
                    && !newSeq.getOwnedBy().isEmpty()
                    && action.getAction() == StatementActions.CREATE
                    || (action.getAction() == StatementActions.ALTER &&
                    !Objects.equals(newSeq.getOwnedBy(), oldSeq.getOwnedBy()))) {
                sequencesOwnedBy.add(newSeq);
            }
        }
    }
}
