package cz.startnet.utils.pgdiff.schema.system;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgSystemStorage implements Serializable {

    private static final long serialVersionUID = -5150584184929914163L;

    public static final String FILE_NAME = "SYSTEM_OBJECTS_";

    private final List<PgSystemStatement> objects = new ArrayList<>();
    private final List<PgSystemOperator> operators = new ArrayList<>();
    private final List<PgSystemCast> casts = new ArrayList<>();

    public List<PgSystemStatement> getObjects() {
        return objects;
    }

    public void addObject(PgSystemStatement object) {
        objects.add(object);
    }

    public List<PgSystemOperator> getOperators() {
        return operators;
    }

    public void addOperator(PgSystemOperator operator) {
        operators.add(operator);
    }

    public List<PgSystemCast> getCasts() {
        return casts;
    }

    public void addCast(PgSystemCast cast) {
        casts.add(cast);
    }

    public static PgSystemStorage getObjectsFromResources(SupportedVersion version) {
        try {
            String path = ApgdiffUtils.getFileFromOsgiRes(PgSystemStorage.class.getResource(
                    FILE_NAME + version + ".ser")).toString();
            Object object = ApgdiffUtils.deserialize(path);

            if (object != null && object instanceof PgSystemStorage) {
                return (PgSystemStorage) object;
            }
        } catch (URISyntaxException | IOException e) {
            Log.log(Log.LOG_ERROR, "Error while reading systems objects from resources");
        }

        return null;
    }

    public static PgSystemStatement getPgSystemStatement(PgSystemStorage storage, DbObjType objType, String objName) {
        List<PgSystemStatement> systemStmtsWithObjType = new ArrayList<>();

        for (PgSystemStatement systemStmt : storage.getObjects()) {
            if (objType.equals(systemStmt.getType())) {
                systemStmtsWithObjType.add(systemStmt);
            }
        }

        for (PgSystemStatement systemStmt : systemStmtsWithObjType) {
            if (objName.equals(systemStmt.getName())) {
                return systemStmt;
            }
        }

        return null;
    }

    /**
     *  Returns the {@link cz.startnet.utils.pgdiff.schema.system.PgSystemCast#type context of the cast}
     *  between two types.
     */
    public static String castFunctionArguments(PgSystemStorage storage, String source, String target) {
        for (PgSystemCast cast : storage.getCasts()) {
            if (source.equals(cast.getSource()) && target.equals(cast.getTarget())) {
                return cast.getType();
            }
        }

        return null;
    }

    /**
     *  Returns operation's result type.
     */
    public static String castOperatorArguments(PgSystemStorage storage, String leftType, String rightType, String operatorName) {
        for (PgSystemOperator oper : storage.getOperators()) {
            if (operatorName.equals(oper.getName())
                    && leftType.equals(oper.getLeft())
                    && rightType.equals(oper.getRight())) {
                return oper.getReturnType();
            }
        }
        return null;
    }
}