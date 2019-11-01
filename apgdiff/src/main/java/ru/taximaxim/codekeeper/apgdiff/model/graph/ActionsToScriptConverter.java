package ru.taximaxim.codekeeper.apgdiff.model.graph;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.NotAllowedObjectException;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffScript;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.schema.MsView;
import cz.startnet.utils.pgdiff.schema.PgSequence;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ActionsToScriptConverter {

    private static final String REFRESH_MODULE = "EXEC sys.sp_refreshsqlmodule {0} \nGO";

    private static final String DROP_COMMENT = "-- DEPCY: This {0} depends on the {1}: {2}";
    private static final String CREATE_COMMENT = "-- DEPCY: This {0} is a dependency of {1}: {2}";
    private static final String HIDDEN_OBJECT = "-- HIDDEN: Object {0} of type {1}";

    private final Set<ActionContainer> actions;
    private final Set<PgSequence> sequencesOwnedBy = new LinkedHashSet<>();
    private final Set<PgStatement> toRefresh;
    private final PgDiffArguments arguments;

    public ActionsToScriptConverter(Set<ActionContainer> actions, PgDiffArguments arguments) {
        this(actions, Collections.emptySet(), arguments);
    }

    /**
     * @param toRefresh an ordered set of refreshed statements in reverse order
     */
    public ActionsToScriptConverter(Set<ActionContainer> actions, Set<PgStatement> toRefresh,
            PgDiffArguments arguments) {
        this.actions = actions;
        this.arguments = arguments;
        this.toRefresh = toRefresh;
    }

    /**
     * Заполняет скрипт объектами с учетом их порядка по зависимостям
     * @param script скрипт для печати
     */
    public void fillScript(PgDiffScript script) {
        Collection<DbObjType> allowedTypes = arguments.getAllowedTypes();
        Set<PgStatement> refreshed = new HashSet<>(toRefresh.size());
        for (ActionContainer action : actions) {
            DbObjType type = action.getOldObj().getStatementType();
            if(type == DbObjType.COLUMN){
                type = DbObjType.TABLE;
            }
            if (allowedTypes.isEmpty() || allowedTypes.contains(type)){
                processSequence(action);
                PgStatement oldObj = action.getOldObj();
                String depcy = getComment(action, oldObj);
                switch (action.getAction()) {
                case CREATE:
                    if (toRefresh.contains(oldObj)) {
                        // emit refreshes for views only
                        // refreshes for other objects serve as markers
                        // that allow us to skip unmodified drop+create pairs
                        if (oldObj instanceof MsView) {
                            script.addStatement(MessageFormat.format(REFRESH_MODULE,
                                    PgDiffUtils.quoteString(oldObj.getQualifiedName())));
                        }
                        refreshed.add(oldObj);
                    } else {
                        if (depcy != null) {
                            script.addStatement(depcy);
                        }
                        script.addCreate(oldObj, null, oldObj.getCreationSQL(), true);
                    }
                    break;
                case DROP:
                    if (!toRefresh.contains(oldObj) && oldObj.canDrop()) {
                        if (depcy != null) {
                            script.addStatement(depcy);
                        }
                        script.addDrop(oldObj, null, oldObj.getDropSQL());
                    }
                    break;
                case ALTER:
                    StringBuilder sb = new StringBuilder();
                    oldObj.appendAlterSQL(action.getNewObj(), sb,
                            new AtomicBoolean());
                    if (sb.length() > 0) {
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
            String ownedBy = sequence.getOwnedBySQL();
            if (!ownedBy.isEmpty()) {
                script.addStatement(ownedBy);
            }
        }

        // if any refreshes were not emitted as statement replacements
        // add them explicitly in reverse order (the resolver adds them in "drop order")
        PgStatement[] orphanRefreshes = toRefresh.stream()
                .filter(r -> r instanceof MsView && !refreshed.contains(r))
                .toArray(PgStatement[]::new);
        for (int i = orphanRefreshes.length - 1; i >= 0; --i) {
            script.addStatement(MessageFormat.format(REFRESH_MODULE,
                    PgDiffUtils.quoteString(orphanRefreshes[i].getQualifiedName())));
        }
    }

    private String getComment(ActionContainer action, PgStatement oldObj) {
        PgStatement objStarter = action.getStarter();
        if (objStarter == null || objStarter == oldObj || objStarter == action.getNewObj()) {
            return null;
        }

        // skip column to parent
        if (objStarter.getStatementType() == DbObjType.COLUMN
                && objStarter.getParent().equals(oldObj)) {
            return null;
        }

        return MessageFormat.format(
                action.getAction() == StatementActions.CREATE ?
                        CREATE_COMMENT : DROP_COMMENT,
                        oldObj.getStatementType(),
                        objStarter.getStatementType(),
                        objStarter.getQualifiedName());
    }

    private void processSequence(ActionContainer action) {
        if (action.getOldObj() instanceof PgSequence) {
            PgSequence oldSeq = (PgSequence) action.getOldObj();
            PgSequence newSeq = (PgSequence) action.getNewObj();
            if (newSeq.getOwnedBy() != null
                    && action.getAction() == StatementActions.CREATE
                    || (action.getAction() == StatementActions.ALTER &&
                    !Objects.equals(newSeq.getOwnedBy(), oldSeq.getOwnedBy()))) {
                sequencesOwnedBy.add(newSeq);
            }
        }
    }
}
