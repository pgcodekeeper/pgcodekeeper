package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.List;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgSystemFunction extends PgSystemStatement{

    private static final long serialVersionUID = -4626267011739714662L;

    private final List<String> signature = new ArrayList<>();
    private final List<String> returns = new ArrayList<>();
    private boolean returnTable;

    public PgSystemFunction(String schema, String name) {
        super(schema, name, DbObjType.FUNCTION);
    }

    public List<String> getSignature() {
        return signature;
    }

    public void addSignaturePart(String name) {
        signature.add(name);
    }

    public List<String> getReturns() {
        return returns;
    }

    public void addReturnsPart(String name) {
        returns.add(name);
    }

    public boolean isReturnTable() {
        return returnTable;
    }

    public void setReturnTable(boolean returnTable) {
        this.returnTable = returnTable;
    }
}
